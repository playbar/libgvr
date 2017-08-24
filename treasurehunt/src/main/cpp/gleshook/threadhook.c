#include <android/log.h>
#include <string.h>
#include <pthread.h>
#include <stdio.h>
#include <dlfcn.h>
#include "log.h"
#include "callstack.h"
#include "hookutils.h"

int (*old__android_log_print)(int prio, const char *tag, const char *fmt, ...) = NULL;
int mj__android_log_print(int prio, const char *tag,  const char *fmt, ...)
{
    va_list ap;
    char buf[1024];
    va_start(ap, fmt);
    vsnprintf(buf, 1024, fmt, ap);
    va_end(ap);

    return __android_log_write(prio, tag, buf);
//    return old__android_log_print(prio, tag, fmt);
}

void* (*old_dlopen)(const char*  filename, int flag) = NULL;
void* mj_dlopen(const char*  filename, int flag)
{
    LOGITAG("mjhook", "mj_dlopen, filename=%s", filename);
    return old_dlopen(filename, flag);
}

int (*old_dlclose)(void* handle) = NULL;
int mj_dlclose(void*  handle)
{
    LOGITAG("mjhook", "mj_dlclose");
    return old_dlclose(handle);
}

void* (*old_malloc)(size_t byte_count) = NULL;
void* mj_malloc(size_t byte_count)
{
    void *re = old_malloc(byte_count);
    LOGITAG("mjmem", "mj_malloc, re=%x", re);
    memset(re, 0, byte_count);
    return re;
}

void (*old_free)(void* p) = NULL;
void mj_free(void* p)
{
    LOGITAG("mjmem", "mj_free, p=%x", p);
    return old_free(p);
}

// thread

int (*old_pthread_attr_init)(pthread_attr_t * attr) = NULL;
int mj_pthread_attr_init(pthread_attr_t * attr)
{
    LOGITAG("mjhook", "mj_pthread_attr_init");
    return old_pthread_attr_init(attr);
}

int (*old_pthread_create)(pthread_t *thread, pthread_attr_t const * attr, void *(*start_routine)(void *), void * arg) = NULL;
int mj_pthread_create(pthread_t *thread, pthread_attr_t const * attr, void *(*start_routine)(void *), void * arg)
{
    LOGITAG("mjhook", "mj_pthread_create");
    print_callstack();
    int re = 0;
    re = old_pthread_create(thread, attr, start_routine, arg);
    return re;
}


void hookThreadFun()
{
    hook((uint32_t) __android_log_print, (uint32_t)mj__android_log_print, (uint32_t **) &old__android_log_print);
//    hook((uint32_t) dlopen, (uint32_t)mj_dlopen, (uint32_t **) &old_dlopen);
    hook((uint32_t) dlclose, (uint32_t)mj_dlclose, (uint32_t **) &old_dlclose);
    hook((uint32_t) malloc, (uint32_t)mj_malloc, (uint32_t **) &old_malloc);
//    hook((uint32_t) pthread_attr_init, (uint32_t)mj_pthread_attr_init, (uint32_t **) &old_pthread_attr_init);
    hook((uint32_t) pthread_create, (uint32_t)mj_pthread_create, (uint32_t **) &old_pthread_create);
}
