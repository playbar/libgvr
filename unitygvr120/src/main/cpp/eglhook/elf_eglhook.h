#ifndef __ELF_EGLHOOK_H__
#define __ELF_EGLHOOK_H__


#ifdef __cplusplus
extern "C" {
#endif

void hookEglGetProcAddress();
void hookGLFun();
void hookUnityFun();
void* get_module_base(pid_t pid,const char* module_name);

#ifdef __cplusplus
}
#endif

#endif

