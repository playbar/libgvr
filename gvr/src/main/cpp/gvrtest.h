#ifndef __GVRTEST_H__
#define __GVRTEST_H__

#include <string.h>
#include <pthread.h>
#include <jni.h>
#include <android/log.h>
#include <assert.h>


// Android log function wrappers
static const char* kTAG = "gvr";
#define LOGI(...) ((void)__android_log_print(ANDROID_LOG_INFO, kTAG, __VA_ARGS__))
#define LOGW(...) ((void)__android_log_print(ANDROID_LOG_WARN, kTAG, __VA_ARGS__))
#define LOGE(...) ((void)__android_log_print(ANDROID_LOG_ERROR, kTAG, __VA_ARGS__))

// processing callback to handler class
typedef struct tick_context {
    JavaVM  *javaVM;
    jclass   jniHelperClz;
    jobject  jniHelperObj;
    jclass   mainActivityClz;
    jobject  mainActivityObj;
    pthread_mutex_t  lock;
    int      done;
} TickContext;

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved);
JNIEXPORT jstring JNICALL Java_com_example_hellojnicallback_MainActivity_stringFromJNI( JNIEnv* env, jobject thiz );
JNIEXPORT void JNICALL Java_com_example_hellojnicallback_MainActivity_startTicks(JNIEnv *env, jobject instance);
JNIEXPORT void JNICALL Java_com_example_hellojnicallback_MainActivity_StopTicks(JNIEnv *env, jobject instance);

#ifdef __cplusplus
}
#endif

#endif
