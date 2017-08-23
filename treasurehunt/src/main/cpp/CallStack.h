#ifndef __CALLSTACHPP_H__
#define __CALLSTACHPP_H__

#include <stdio.h>
#include <unwind.h>
#include <unistd.h>
#include <stdlib.h> //strtoul
#include <android/log.h>

#ifdef __cplusplus
extern "C" {
#endif

typedef struct _Unwind_Context __unwind_context;

struct mapinfo{
    struct mapinfo *next;
	uintptr_t start;
	uintptr_t end;
//    char is_readable;  don't need, for excutable -> readable
//    bool is_executable;
//    void* data; // arbitrary data associated with the map by the user, initially NULL
	char name[];
};


 struct stack_crawl_state_t{
	size_t count;
	intptr_t *addrs;
	const struct mapinfo *map_info_list;
} ;

_Unwind_Reason_Code trace_function(__unwind_context *context, void *arg);
#ifdef __cplusplus
}
#endif

class CallStack
{
#define BACKTRACE_SIZE      32

public:
	CallStack()
	{
		init();
	}
	void dump();

private:
	intptr_t backtrace[BACKTRACE_SIZE];
	struct mapinfo *mapinfohead;
	
	mapinfo *parse_maps_line(char *);
	void deinit_mapinfo();
	void print_mapinfo();
	int try_get_word(uintptr_t ptr, uint32_t* out_value);
	int try_get_half_word(uint32_t pc, uint16_t* out_value);
	uintptr_t rewind_pc_arch(uintptr_t pc);
	bool init_mapinfo(int pid);
	mapinfo* find_map_info(uintptr_t addr);
	void init();
	int get_backtrace(intptr_t* addrs, size_t max_entries);
};


#endif
