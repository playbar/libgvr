#include "CallStack.h"

#define LOG_TAG "CallStack"

// 6f000000-6f01e000 rwxp 00000000 00:0c 16389419   /system/lib/libcomposer.so
// 012345678901234567890123456789012345678901234567890123456789
// 0         1         2         3         4         5

/* depends how the system includes define this */

_Unwind_Reason_Code trace_function(__unwind_context *context, void *arg)
{
	stack_crawl_state_t* state = (stack_crawl_state_t*)arg;
	if (state->count) {
		intptr_t ip = (intptr_t)_Unwind_GetIP(context);
		if (ip) {
			state->addrs[0] = ip;
			state->addrs++;
			state->count--;
			return _URC_NO_REASON;
		}
	}
	/*
     * If we run out of space to record the address or 0 has been seen, stop
     * unwinding the stack.
     */
	return _URC_END_OF_STACK;
}

void CallStack::dump()
{
	size_t numEntries = get_backtrace(backtrace, BACKTRACE_SIZE);
	
	for(size_t i=0; i< numEntries; i++){
		intptr_t p = rewind_pc_arch(backtrace[i]);
		mapinfo* mi = find_map_info(p);
		
		__android_log_print(ANDROID_LOG_INFO, LOG_TAG,"%s: 0x%x", mi->name, p - mi->start);
	}
}

void CallStack::init()
{
	static bool bInited = false;
	if(!bInited){
		init_mapinfo(getpid());
		bInited = true;
	}
}

int CallStack::get_backtrace(intptr_t* addrs, size_t max_entries)
{
    stack_crawl_state_t state;
    state.count = max_entries;
    state.addrs = (intptr_t*)addrs;
    _Unwind_Backtrace(trace_function, (void*)&state);
    return max_entries - state.count;
}

bool CallStack::init_mapinfo(int pid)
{
	mapinfo *prev, *t;
	char data[1024];
	FILE *fp;

	mapinfohead = NULL;
	sprintf(data, "/proc/%d/maps", pid);
	//    strcpy(data, "/proc/28037/maps");
	fp = fopen(data, "r");
	if(fp) {
		while(fgets(data, sizeof(data), fp)) {
			t = parse_maps_line(data);
			if(t){
				mapinfohead = t;
				break;
			}
		}
		if(!mapinfohead)
			return false;
		prev = mapinfohead;
		while(fgets(data, sizeof(data), fp)) {
			mapinfo *mi = parse_maps_line(data);
			if(mi) {
				prev->next = mi;
				prev = mi;
			}
		}
		fclose(fp);
	}
	__android_log_print(ANDROID_LOG_INFO, LOG_TAG,"init_mapinfo head=%x\n", (int)mapinfohead);
	return true;
}

mapinfo* CallStack::parse_maps_line(char *line)
{
    mapinfo *mi;
    int len = strlen(line);

    if(len < 1){
       //__android_log_print(ANDROID_LOG_INFO, LOG_TAG,"error len\n");
	return 0;
    }
    line[--len] = 0;

    if(len < 40){
       //__android_log_print(ANDROID_LOG_INFO, LOG_TAG,"error max len %d\n", len);
	return 0;
    }
    if(line[20] != 'x'){
       //__android_log_print(ANDROID_LOG_INFO, LOG_TAG,"error executing \n");
	return 0;
    }

    //mi = dlmalloc(sizeof(mapinfo) + (len - 47));
    mi = static_cast<mapinfo*>(malloc(sizeof(mapinfo) + (len - 47)));

    if(mi == 0){
       __android_log_print(ANDROID_LOG_INFO, LOG_TAG,"error memory\n");
	return 0;
    }

    mi->start = strtoul(line, 0, 16);
    mi->end = strtoul(line + 9, 0, 16);
   // mi->is_readable = (line[19] == 'r')? 1: 0;
    /* To be filled in parse_elf_info if the mapped section starts with
     * elf_header
     */
    mi->next = 0;
    strcpy(mi->name, line + 49);

    return mi;
}


void CallStack::deinit_mapinfo()
{
	mapinfo* mi = mapinfohead;

	mapinfo *del;
	while(mi) {
		del = mi;
		mi = mi->next;
		//dlfree(del);
		free(del);

	}
}

void CallStack::print_mapinfo()
{
	mapinfo* mi = mapinfohead;
	while(mi) {
	// __android_log_print(ANDROID_LOG_INFO, LOG_TAG,"name %s, addr 0x%x-0x%x, R%d\n", mi->name, mi->start, mi->end, mi->is_readable);
		__android_log_print(ANDROID_LOG_INFO, LOG_TAG,"name %s, addr 0x%x-0x%x\n", mi->name, mi->start, mi->end);
		mi = mi->next;
	}
}
mapinfo* CallStack::find_map_info(uintptr_t addr) {
	mapinfo* mi = mapinfohead;

	while (mi && mi->end <= addr) {
		mi = mi->next;
	}

	return mi;
}

int CallStack::try_get_word(uintptr_t ptr, uint32_t* out_value) {
    //ALOGV("try_get_word: reading word at 0x%08x", ptr);
    if (ptr & 3) {
        //ALOGV("try_get_word: invalid pointer 0x%08x", ptr);
        *out_value = 0xffffffffL;
        return 0;
    }
    //if (!is_readable_map(map_info_list, ptr)) {
        //ALOGV("try_get_word: pointer 0x%08x not in a readable map", ptr);
     //   *out_value = 0xffffffffL;
     //   return 0;
    //}
    if (!find_map_info(ptr)) {
        //ALOGV("try_get_word: pointer 0x%08x not in a readable map", ptr);
        *out_value = 0xffffffffL;
        return 0;
    }
    *out_value = *(uint32_t*)ptr;
    return 1;
}

int CallStack::try_get_half_word(uint32_t pc, uint16_t* out_value) {
    uint32_t word;
    if (try_get_word(pc & ~2, &word)) {
        *out_value = pc & 2 ? word >> 16 : word & 0xffff;
        return 1;
    }
    return 0;
}

uintptr_t CallStack::rewind_pc_arch(uintptr_t pc) {
    if (pc & 1) {
        /* Thumb mode - need to check whether the bl(x) has long offset or not.
         * Examples:
         *
         * arm blx in the middle of thumb:
         * 187ae:       2300            movs    r3, #0
         * 187b0:       f7fe ee1c       blx     173ec
         * 187b4:       2c00            cmp     r4, #0
         *
         * arm bl in the middle of thumb:
         * 187d8:       1c20            adds    r0, r4, #0
         * 187da:       f136 fd15       bl      14f208
         * 187de:       2800            cmp     r0, #0
         *
         * pure thumb:
         * 18894:       189b            adds    r3, r3, r2
         * 18896:       4798            blx     r3
         * 18898:       b001            add     sp, #4
         */
        uint16_t prev1, prev2;
        if (try_get_half_word(pc - 5, &prev1)
            && ((prev1 & 0xf000) == 0xf000)
            && try_get_half_word(pc - 3, &prev2)
            && ((prev2 & 0xe000) == 0xe000)) {
            pc -= 4; // long offset
        } else {
            pc -= 2;
        }
    } else {
        /* ARM mode, all instructions are 32bit.  Yay! */
        pc -= 4;
    }
    return pc;
}


