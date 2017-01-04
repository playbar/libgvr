//
// Created by mac on 16/8/19.
//

#include "gvrfn.h"

JavaVM *gs_jvm=0;
static int gneedDetach = 0;

JNIEnv* AttachCurrentThreadJNI()
{
    JNIEnv *env = 0;
    jint result = -1;
    if (gs_jvm->GetEnv((void**) &env, JNI_VERSION_1_6) != JNI_OK)
    {
        int status = gs_jvm->AttachCurrentThread( &env, 0 );
        if( status < 0 )
        {
            return 0;
        }
        gneedDetach = 1;
    }
    return env;
}

void DetachCurrentThreadJNI()
{
    if( gneedDetach )
    {
        gs_jvm->DetachCurrentThread();
        gneedDetach = 0;
    }

}


jint JNI_OnLoad_Test( JavaVM* vm, void *reserved){
    gs_jvm = vm;

    jint result = JNI_VERSION_1_6;
    return  result;

}

