#ifndef __GLESHOOK_H__
#define __GLESHOOK_H__

#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT void JNICALL Java_com_google_hook_GLESHook_initHook(JNIEnv* env, jobject obj);
JNIEXPORT void JNICALL Java_com_google_hook_GLESHook_hookTest(JNIEnv* env, jobject obj);
JNIEXPORT void JNICALL Java_com_google_hook_GLESHook_unInitHook(JNIEnv* env, jobject obj);
#ifdef __cplusplus
}
#endif

#endif
