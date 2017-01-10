#include "gvrtest.h"
#include "gvrfn.h"
#include "LogMessage.h"


JNIEXPORT jstring JNICALL Java_com_mj_test_MainActivity_stringFromJNI( JNIEnv* env, jobject thiz )
{
#define ABI "armeabi-v7a"
    gGvrApi.Init();
    CLogMessage msg(__FUNCTION__);
    return env->NewStringUTF("Hello from JNI !  Compiled with ABI " ABI ".");
}


JNIEXPORT jint JNICALL JNI_OnLoad()
{
    return gGvrApi.JNI_OnLoad1();
//    return  JNI_VERSION_1_6;
}

