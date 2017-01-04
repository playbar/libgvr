//
// Created by mac on 16/8/19.
//

#ifndef LIBGVR_H
#define LIBGVR_H

#include <jni.h>
#include <android/log.h>

#define LOGI(...) ((void)__android_log_print(ANDROID_LOG_INFO, "hell-libs::", __VA_ARGS__))

extern JavaVM *gs_jvm;
JNIEnv* AttachCurrentThreadJNI();
void DetachCurrentThreadJNI();

class CGVRAPI
{
public:
    CGVRAPI();
    virtual  ~CGVRAPI();

    bool Init();
    void Release();


private:
    void * m_hDLL;
    bool m_bInit;

};

#endif //TRUNK_VIEWCORE_H
