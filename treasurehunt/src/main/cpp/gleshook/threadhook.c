#include <android/log.h>
#include <string.h>
#include <EGL/egl.h>
#include <pthread.h>
#include <stdio.h>
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
//    hook((uint32_t) pthread_attr_init, (uint32_t)mj_pthread_attr_init, (uint32_t **) &old_pthread_attr_init);
    hook((uint32_t) pthread_create, (uint32_t)mj_pthread_create, (uint32_t **) &old_pthread_create);
}
