
#include <string.h>
#include <jni.h>
#include <android/log.h>
#include <pthread.h>
#include <stdio.h>

#define ABI "armeabi-v7a"

static const char* kTAG = "mjtest";
#define LOGI(...) ((void)__android_log_print(ANDROID_LOG_INFO, kTAG, __VA_ARGS__))
#define LOGW(...) ((void)__android_log_print(ANDROID_LOG_WARN, kTAG, __VA_ARGS__))
#define LOGE(...) ((void)__android_log_print(ANDROID_LOG_ERROR, kTAG, __VA_ARGS__))

struct A
{
    struct B {
        int c;
    }b;

    struct B sb;

}a;

struct StDemo
{
    int mX;
    int mY;
    int(*funcX)(struct StDemo*, int);
    int(*funcY)(struct StDemo*, int, int);
};

int add1(struct StDemo *demo, int x)
{
    return x*demo->mX;
}

int add2(struct StDemo *demo, int x, int y)
{
    x += demo->mX;
    return x + y;
}

static pthread_key_t thread_log_key;

void write_to_thread_log (const char* message)
{
    FILE* thread_log = (FILE*)pthread_getspecific(thread_log_key);
    fprintf (thread_log, "%s\n", message);
}

void close_thread_log (void* thread_log)
{
    fclose ((FILE*) thread_log);
}

//const char *filename = "/data/data/com.mj.test/lib/libgvrimpl.so";

void* thread_function (void* args)
{
    char thread_log_filename[20];
    FILE* thread_log;
    sprintf (thread_log_filename, "/sdcard/tmp/thread-%d.log", (int) pthread_self ());
    thread_log = fopen (thread_log_filename, "w");
    pthread_setspecific (thread_log_key, thread_log);
    write_to_thread_log ("Thread starting.");
    return NULL;
}

void createThread()
{
    int i;
    pthread_t threads[5];
    pthread_key_create (&thread_log_key, close_thread_log);

    for (i = 0; i < 5; ++i)
        pthread_create (&(threads[i]), NULL, thread_function, NULL);

    for (i = 0; i < 5; ++i)
        pthread_join (threads[i], NULL);
}

struct StDemo demo;

jstring Java_com_mj_test_HelloJni_stringFromJNI( JNIEnv* env, jobject thiz )
{
    struct A a;
    a.b.c = 10;
    LOGE("%d", a.b.c);
    demo.mX = 2;
    demo.mY = 3;
    demo.funcX = add1; //
    demo.funcY = add2;
//    createThread();
    LOGE("func(3,4)=%d\n", demo.funcX(&demo, 4));
    LOGE("func(3,4)=%d\n", demo.funcY(&demo, 3, 4));
    return (*env)->NewStringUTF(env, "Hello from JNI !  Compiled with ABI " ABI ".");
}
