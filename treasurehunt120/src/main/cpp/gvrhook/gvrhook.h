
#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL Java_com_unity3d_unitygvr_GoogleVR_HookInit(JNIEnv * env , jobject obj ) ;

JNIEXPORT void JNICALL Java_com_google_hook_GVRHook_initHook(JNIEnv* env, jobject obj);
JNIEXPORT void JNICALL Java_com_google_hook_GVRHook_initGraphicHook(JNIEnv* env, jobject obj);
JNIEXPORT void JNICALL Java_com_google_hook_GVRHook_hookTest(JNIEnv* env, jobject obj);
JNIEXPORT void JNICALL Java_com_google_hook_GVRHook_unInitHook(JNIEnv* env, jobject obj);
JNIEXPORT void JNICALL Java_com_google_hook_GVRHook_ReprojFunc(JNIEnv* env, jobject obj);


#ifdef __cplusplus
}
#endif

