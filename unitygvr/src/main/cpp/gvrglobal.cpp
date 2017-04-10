#include <unistd.h>
#include "gvrglobal.h"
#include "gvrfn.h"
#include "LogMessage.h"

long getimagebase()
{
    static bool bfirst = true;
//    if( !bfirst ){
//        return 0;
//    }
    long tid = pthread_self();
    bfirst = false;
//    CLogMessage msg(__FUNCTION__);
    LOGI("getimagebase begin");
    pid_t pid =  getpid();
    char fileName[256] = {0};
    sprintf(fileName, "/proc/%d/maps", pid);
    FILE* fd = fopen(fileName, "r");
//    FILE *fw = fopen("/data/local/tmp/maps.txt", "w");
    if (fd != NULL)
    {
//        if( fw == NULL)
//        {
//            LOGI("err maps.txt");
//        }
        char buff[2048+1];
        while(fgets(buff, 2048, fd) != NULL)
        {
//            int ilen = strlen(buff);
//            fwrite(buff, ilen, 1, fw);
            LOGI("get Module, tid=%u, %s", tid,buff);
        }
    }
//    fclose(fw);
    fclose(fd);
    LOGI("getimagebase end");
    return 0;
    return 0;

}

JNIEXPORT jstring JNICALL Java_com_Company_GvrProject13_MainActivity_stringFromJNI( JNIEnv* env, jobject thiz )
{
#define ABI "armeabi-v7a"
    gGvrApi.Init();
    CLogMessage msg(__FUNCTION__);
    return env->NewStringUTF("Hello from JNI !  Compiled with ABI " ABI ".");
}


JNIEXPORT jint JNICALL JNI_OnLoad()
{
    CLogMessage msg(__FUNCTION__);
//    getimagebase();
    return gGvrApi.JNI_OnLoad1();
//    return  JNI_VERSION_1_6;
}

