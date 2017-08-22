#include "gvrhook.h"
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <android/log.h>
#include <elf.h>
#include <EGL/egl.h>
#include <GLES/gl.h>
#include <elf.h>
#include <fcntl.h>
#include <sys/mman.h>
#include "gvr.h"
#include "hookgvrfn.h"


extern void gvr_get_recommended_buffer_viewports(const gvr_context *gvr, gvr_buffer_viewport_list *viewport_list);

#define LOG_TAG "INJECT"
#define LOGD(fmt,args...) __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG,fmt,##args)

void (*fp_get_recommended_buffer_viewports)(  const gvr_context *gvr, gvr_buffer_viewport_list *viewport_list) = NULL;

void new_get_recommended_buffer_viewports(const gvr_context *gvr, gvr_buffer_viewport_list *viewport_list)
{
    LOGD("New new_get_recommended_buffer_viewports");
    if(fp_get_recommended_buffer_viewports == NULL)
        LOGD("error\n");
    return fp_get_recommended_buffer_viewports(gvr, viewport_list);
}

void* get_module_base(pid_t pid,const char* module_name)
{
    FILE* fp;
    long addr = 0;
    char *pch;
    char filename[32];
    char line[1024];

    if(pid<0){
        snprintf(filename,sizeof(filename),"/proc/self/maps",pid);
    }else{
        snprintf(filename,sizeof(filename),"/proc/%d/maps",pid);
    }
    fp = fopen(filename,"r");
    if(fp!=NULL){
        while(fgets(line,sizeof(line),fp)){
            if(strstr(line,module_name)){
                pch = strtok(line,"-");
                addr = strtoul(pch,NULL,16);
                if(addr==0x8000)
                    addr = 0;
                break;
            }
        }
        fclose(fp);
    }
    return (void*)addr;
}

#define LIBSF_NAME "libgvr.so"
#define LIBSF_PATH "/data/data/com.Company.GvrProject90/lib/libgvr.so"

void hook_new_get_recommended_buffer_viewports()
{
    fp_get_recommended_buffer_viewports = gvr_get_recommended_buffer_viewports;
    LOGD("Orig get_recommended_buffer_viewports = %p\n",fp_get_recommended_buffer_viewports);
    pid_t pid = getpid();
    LOGD("process pid=%d", pid);
    void* base_addr = get_module_base(getpid(),LIBSF_NAME); //动态库地址
    LOGD("libgvrhook.so address = %p\n",base_addr);

    int fd;
    fd = open(LIBSF_PATH,O_RDONLY);
    if(fd==-1){
        LOGD("open file error\n");
        return;
    }
    Elf32_Ehdr ehdr;  //ELF header
    read(fd,&ehdr,sizeof(Elf32_Ehdr)); //读取ELF文件格式的文件头信息

    unsigned long shdr_addr = ehdr.e_shoff; //section header table文件中的偏移
    int shnum = ehdr.e_shnum; //section header table中有多少个条目
    int shent_size = ehdr.e_shentsize; //section header table每一个条目的大小
    unsigned long stridx = ehdr.e_shstrndx; //包含节名称的字符串是第几个节(从0开始)

    Elf32_Shdr shdr; //节头结构定义
    lseek(fd,shdr_addr+stridx*shent_size,SEEK_SET); //偏移到文件尾
    read(fd,&shdr,shent_size); //读取字符串表的信息

    char* string_table = (char*)malloc(shdr.sh_size);//分配内存
    lseek(fd,shdr.sh_offset,SEEK_SET);//偏移到字符串表

    read(fd,string_table,shdr.sh_size); //读取字符串表的内容


    lseek(fd,shdr_addr,SEEK_SET);//还原指针到section header table处

    int i = 0;
    uint32_t out_addr = 0;
    uint32_t out_size = 0;
    uint32_t got_item = 0;
    int32_t got_found = 0;

    for(i = 0; i < shnum; i++){//每个节头信息,找到got表
        read(fd,&shdr,shent_size);
        if(shdr.sh_type == SHT_PROGBITS){
            int name_idx = shdr.sh_name;//名称索引
            char *str  = &string_table[name_idx];
            LOGD("%s", str);
//            p++;
            if(strcmp(&(string_table[name_idx]),".text")==0 || strcmp(&(string_table[name_idx]),".got")==0)
            {
                out_addr = (uint32_t)((uint32_t)base_addr + shdr.sh_addr);//获得got表
                out_size = shdr.sh_size;
                LOGD("out_addr = %lx,out_size = %lx\n",out_addr,out_size);

                for(int j=0;j<out_size;j+=4)
                {
                    if( j == 0x4d4c ){
                        j = 0x4d4c;
                    }
                    got_item = (out_addr+j);
                    if(got_item + 1 == (uint32_t)fp_get_recommended_buffer_viewports)
                    {
                        LOGD("Found get_recommended_buffer_viewports in got\n");
                        got_found = 1;
                        //hook
                        uint32_t page_size = getpagesize();
                        uint32_t entry_page_start = (out_addr + j)&(~(page_size-1));
                        mprotect((uint32_t*)entry_page_start,page_size,PROT_READ|PROT_WRITE | PROT_EXEC);
                        *((uint32_t*)(got_item + 1)) = (uint32_t)(gvr_get_recommended_buffer_viewports);
                        break;
                    }else if(got_item == (uint32_t)new_get_recommended_buffer_viewports){
                        LOGD("Already hooked\n");
                        break;
                    }
                }
                if(got_found)
                    break;
            }
        }
    }
    free(string_table);
    close(fd);
    return;
}

JNIEXPORT void JNICALL Java_com_google_hook_GVRHook_initHook(JNIEnv* env, jobject obj)
{
    InitHook();
}

JNIEXPORT void JNICALL Java_com_google_hook_GVRHook_hookTest(JNIEnv* env, jobject obj)
{

}

JNIEXPORT void JNICALL Java_com_google_hook_GVRHook_unInitHook(JNIEnv* env, jobject obj)
{
    UninitHook();
}
