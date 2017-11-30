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
#include "vr/gvr/capi/include/gvr.h"
#include "gvrhookfn.h"



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


JNIEXPORT void JNICALL Java_com_google_hook_GVRHook_initHook(JNIEnv* env, jobject obj)
{
    LOGI("GVRHook_initHook begin");
    InitHook();
    LOGI("GVRHook_initHook end");
}

JNIEXPORT void JNICALL Java_com_google_hook_GVRHook_initGraphicHook(JNIEnv* env, jobject obj)
{
    InitGraphicHook();
}

JNIEXPORT void JNICALL Java_com_google_hook_GVRHook_hookTest(JNIEnv* env, jobject obj)
{

}

JNIEXPORT void JNICALL Java_com_google_hook_GVRHook_unInitHook(JNIEnv* env, jobject obj)
{
    UninitHook();
}
