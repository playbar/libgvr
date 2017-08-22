#include <unistd.h>
#include "gvrglobal.h"
#include "LogMessage.h"
#include "gvrInter.h"


long getimagebase()
{
    pid_t pid =  getpid();
    char fileName[256] = {0};
    sprintf(fileName, "/proc/%d/maps", pid);
    FILE* fd = fopen(fileName, "r");
//    FILE *fw = fopen("/sdcard/maps.txt", "w");
    if (fd != NULL)
    {
        char buff[2048+1];
        while(fgets(buff, 2048, fd) != NULL)
        {
//            int ilen = strlen(buff);
//            fwrite(buff, ilen, 1, fw);
            LOGI("get Module : %s", buff);
        }
    }
//    fclose(fw);
    fclose(fd);
    return 0;

}

JNIEXPORT jstring JNICALL Java_com_mj_vr_MainActivity_stringFromJNI( JNIEnv* env, jobject thiz )
{
#define ABI "armeabi-v7a"
    InitLoadFun();
    CLogMessage msg(__FUNCTION__);
//    getimagebase();
    return env->NewStringUTF("Hello from JNI !  Compiled with ABI " ABI ".");
}


JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved)
{
    return mj_JNI_OnLoad(vm, reserved);
//    return  JNI_VERSION_1_6;
}

