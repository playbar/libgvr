#include "gvrglobal.h"
#include "gvrfn.h"
#include "LogMessage.h"


JNIEXPORT jstring JNICALL Java_com_Company_GvrProject13_MainActivity_stringFromJNI( JNIEnv* env, jobject thiz )
{
#define ABI "armeabi-v7a"
    gGvrApi.Init();
    CLogMessage msg(__FUNCTION__);
    return env->NewStringUTF("Hello from JNI !  Compiled with ABI " ABI ".");
}


JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved)
{
    return gGvrApi.JNI_OnLoad(vm, reserved);
//    return  JNI_VERSION_1_6;
}

