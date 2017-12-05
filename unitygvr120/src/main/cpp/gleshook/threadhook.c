#include <android/log.h>
#include <string.h>
#include <pthread.h>
#include "semaphore.h"
#include <stdio.h>
#include <dlfcn.h>
#include <syscallstack.h>
#include <sys/epoll.h>
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

FILE *(*old_fopen)(const char * name , const char * mode) = NULL;
FILE *mj_fopen(const char * name , const char * mode)
{
    LOGITAG("mjhook", "mj_fopen, filename=%s", name);
    FILE *pfile = old_fopen(name, mode);
    return pfile;
}

//void* (*old_dlsym)(void*  handle, const char*  symbol) = NULL;
//void* mj_dlsym(void*  handle, const char*  symbol)
//{
//    LOGITAG("mjhook", "mj_dlsym, symbol=%s", symbol);
//    return old_dlsym(handle, symbol);
//}

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
//    LOGITAG("mjmem", "mj_malloc, bytecount=%d, re=%x, pid=%d", byte_count, re, getpid());
    memset(re, 0, byte_count);
    return re;
}

void* (*old_calloc)(size_t item_count, size_t item_size) = NULL;
void* mj_calloc(size_t item_count, size_t item_size)
{
    void *re = old_calloc(item_count, item_size);
//    LOGITAG("mjmem", "mj_calloc, re=%x, item_cout=%d, item_size=%d",  re, item_count, item_size);
    return re;
}
void* (*old_realloc)(void* p, size_t byte_count) = NULL;
void* mj_realloc(void* p, size_t byte_count)
{
    void *re = old_realloc(p, byte_count);
//    LOGITAG("mjmem", "mj_realloc, bytecount=%d, re=%x", byte_count, re);
    return re;
}

void (*old_free)(void* p) = NULL;
void mj_free(void* p)
{
    static int count = 0;
    if( count == 0 ) {
        ++count;
        if( p!= NULL) {
            LOGITAG("mjmem", "mj_free, p=%x, pid=%d", p, getpid());
        }
    } else {
        count = 0;
    }

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
//    print_callstack();
    int re = 0;
    re = old_pthread_create(thread, attr, start_routine, arg);
    return re;
}

unsigned int (*old_sleep)(unsigned int) = NULL;
unsigned int mj_sleep(unsigned int timeout)
{
    LOGITAG("mjhook", "mj_sleep, timeout=%d, tid=%d", timeout, gettid());
    unsigned int re = 0;
    re = old_sleep(timeout);
    return re;
}

int (*old_usleep)(useconds_t) = NULL;
int mj_usleep(useconds_t timeout)
{
    LOGITAG("mjhook", "mj_usleep, timeout=%d, tid=%d", timeout, gettid());
    int re = 0;
//    timeout = 1;
    re = old_usleep(timeout);
    return re;
}

int (*old_nanosleep)(const struct timespec*, struct timespec*) = NULL;
int mj_nanosleep(const struct timespec* tspec1, struct timespec* tspec2)
{
    LOGITAG("mjhook", "mj_nanosleep, tid=%d", gettid());
    int re = 0;
    re = old_nanosleep( tspec1, tspec2 );
    return  re;
}

int (*old_pthread_cond_wait)(pthread_cond_t *cond, pthread_mutex_t *mutex) = NULL;
int mj_pthread_cond_wait(pthread_cond_t *cond, pthread_mutex_t *mutex)
{
    LOGITAG("mjhook", "mj_pthread_cond_wait, tid=%d", gettid());
    int re = 0;
    re = old_pthread_cond_wait(cond, mutex);
    return re;
}

int (*old_pthread_cond_timedwait)(pthread_cond_t *cond, pthread_mutex_t *mutex, const struct timespec *abstime) = NULL;
int mj_pthread_cond_timedwait(pthread_cond_t *cond, pthread_mutex_t *mutex, const struct timespec *abstime)
{
    LOGITAG("mjhook", "mj_pthread_cond_timedwait, tid=%d", gettid());
    int re = 0;
    struct timespec tspe;
    tspe.tv_nsec = 0;
    tspe.tv_sec = 0;
    re = old_pthread_cond_timedwait(cond, mutex, &tspe);
//    re = old_pthread_cond_timedwait(cond, mutex, abstime);
    return re;
}

int (*old_epoll_wait)(int epfd, struct epoll_event *events, int maxevents, int timeout) = NULL;
int mj_epoll_wait(int epfd, struct epoll_event *events, int maxevents, int timeout)
{
    LOGITAG("mjhook", "mj_epoll_wait, tid=%d", gettid());
    int re = 0;
    re = old_epoll_wait(epfd, events, maxevents, timeout);
    return  re;
}

int (*old_sem_trywait)(sem_t *sem) = NULL;
int mj_sem_trywait(sem_t *sem)
{
    LOGITAG("mjhook", "mj_sem_trywait, tid=%d", gettid());
    int re = 0;
    re = old_sem_trywait(sem);
    return re;
}

int (*old_sem_wait)(sem_t *sem) = NULL;
int mj_sem_wait(sem_t *sem)
{
    LOGITAG("mjhook", "mj_sem_wait, tid=%d", gettid());
    int re = 0;
    re = old_sem_wait(sem);
    return re;
}

int (*old_sem_timedwait)(sem_t *sem, const struct timespec *abstime) = NULL;
int mj_sem_timedwait(sem_t *sem, const struct timespec *abstime)
{
    LOGITAG("mjhook", "mj_sem_timedwait, tid=%d", gettid());
    int re = 0;
    re = old_sem_timedwait( sem, abstime);
    return  re;
}

int (*old_pthread_mutex_lock)(pthread_mutex_t *mutex) = NULL;
int mj_pthread_mutex_lock(pthread_mutex_t *mutex)
{
    LOGITAG("mjhook", "mj_pthread_mutex_lock, tid=%d", gettid());
    int re = 0;
    re = old_pthread_mutex_lock( mutex );
    return re;
}

int (*old_pthread_mutex_unlock)(pthread_mutex_t *mutex) = NULL;
int mj_pthread_mutex_unlock(pthread_mutex_t *mutex)
{
    LOGITAG("mjhook", "mj_pthread_mutex_unlock, tid=%d", gettid());
    int re = 0;
    re = old_pthread_mutex_unlock(mutex);
    return re;
}

int (*old_pthread_mutex_destroy)(pthread_mutex_t *mutex) = NULL;
int mj_pthread_mutex_destroy(pthread_mutex_t *mutex)
{
    LOGITAG("mjhook", "mj_pthread_mutex_destroy, tid=%d", gettid());
    int re = 0;
    re = old_pthread_mutex_destroy(mutex);
    return re;
}

int (*old_pthread_mutex_init)(pthread_mutex_t *mutex, const pthread_mutexattr_t *mutexattr) = NULL;
int mj_pthread_mutex_init(pthread_mutex_t *mutex, const pthread_mutexattr_t *mutexattr)
{
    LOGITAG("mjhook", "mj_pthread_mutex_init, tid=%d", gettid());
    int re = 0;
    re = old_pthread_mutex_init( mutex, mutexattr);
    return re;
}

int (*old_pthread_mutex_trylock)(pthread_mutex_t *mutex) = NULL;
int mj_pthread_mutex_trylock(pthread_mutex_t *mutex)
{
    LOGITAG("mjhook", "mj_pthread_mutex_trylock, tid=%d", gettid());
    int re = 0;
    re = old_pthread_mutex_trylock(mutex);
    return re;
}

void hookThreadFun()
{
////    hook((uint32_t) __android_log_print, (uint32_t)mj__android_log_print, (uint32_t **) &old__android_log_print);
//    hook((uint32_t) fopen, (uint32_t)mj_fopen, (uint32_t **) &old_fopen);
//    hook((uint32_t) dlopen, (uint32_t)mj_dlopen, (uint32_t **) &old_dlopen);
////    hook((uint32_t) dlsym, (uint32_t)mj_dlsym, (uint32_t **) &old_dlsym);
//    hook((uint32_t) dlclose, (uint32_t)mj_dlclose, (uint32_t **) &old_dlclose);
////    hook((uint32_t) malloc, (uint32_t)mj_malloc, (uint32_t **) &old_malloc);
//    hook((uint32_t) calloc, (uint32_t)mj_calloc, (uint32_t **) &old_calloc);
////    hook((uint32_t) realloc, (uint32_t)mj_realloc, (uint32_t **) &old_realloc);
////    hook((uint32_t) free, (uint32_t)mj_free, (uint32_t **) &old_free);
////    hook((uint32_t) pthread_attr_init, (uint32_t)mj_pthread_attr_init, (uint32_t **) &old_pthread_attr_init);
    hook((uint32_t) pthread_create, (uint32_t)mj_pthread_create, (uint32_t **) &old_pthread_create);
//    hook((uint32_t) pthread_cond_wait, (uint32_t)mj_pthread_cond_wait, (uint32_t **) &old_pthread_cond_wait);
    hook((uint32_t) pthread_cond_timedwait, (uint32_t)mj_pthread_cond_timedwait, (uint32_t **) &old_pthread_cond_timedwait);
    hook((uint32_t) epoll_wait, (uint32_t) mj_epoll_wait, (uint32_t **) &old_epoll_wait);
    hook((uint32_t) sem_trywait, (uint32_t) mj_sem_trywait, (uint32_t **) &old_sem_trywait);
    hook((uint32_t) sem_wait, (uint32_t) mj_sem_wait, (uint32_t **) &old_sem_wait);
    hook((uint32_t) sem_timedwait, (uint32_t) mj_sem_timedwait, (uint32_t **) &old_sem_timedwait);
//    hook((uint32_t) pthread_mutex_lock, (uint32_t) mj_pthread_mutex_lock, (uint32_t **) &old_pthread_mutex_lock);
//    hook((uint32_t) pthread_mutex_unlock, (uint32_t) mj_pthread_mutex_unlock, (uint32_t **) &old_pthread_mutex_unlock);
//    hook((uint32_t) pthread_mutex_destroy, (uint32_t) mj_pthread_mutex_destroy, (uint32_t **) &old_pthread_mutex_destroy);
//    hook((uint32_t) pthread_mutex_init, (uint32_t) mj_pthread_mutex_init, (uint32_t **) &old_pthread_mutex_init);
//    hook((uint32_t) pthread_mutex_trylock, (uint32_t) mj_pthread_mutex_trylock, (uint32_t **) &old_pthread_mutex_trylock);

    hook((uint32_t) sleep, (uint32_t)mj_sleep, (uint32_t **)&old_sleep);
    hook((uint32_t) usleep, (uint32_t)mj_usleep, (uint32_t **)&old_usleep);
    hook((uint32_t) nanosleep, (uint32_t)mj_nanosleep, (uint32_t **)&old_nanosleep);

//    hookImportFunInit();
//    hookImportFun("libgvr.so", "pthread_cond_wait", (void *) mj_pthread_cond_wait, (void **) &old_pthread_cond_wait);
//    hookImportFun("libgvr.so", "pthread_cond_timedwait", (void *) mj_pthread_cond_timedwait, (void **) &old_pthread_cond_timedwait);
//    hookImportFun("libunity.so", "eglSwapBuffers", (void *) mj_eglSwapBuffers, (void **) &old_eglSwapBuffers);
//    hookImportFun("libgvr.so", "eglGetProcAddress", (void *) mj_eglGetProcAddress, (void **) &old_eglGetProcAddress);
}
