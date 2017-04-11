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

uint64_t GetTimeNano()
{
    struct timespec t;
    clock_gettime(CLOCK_MONOTONIC, &t);
    uint64_t result = t.tv_sec * 1000000000LL + t.tv_nsec;
    return result;
}

void ShowFPS()
{
#define INTERVALTIME 1000
    static unsigned int frameCounter = 0;
    static unsigned int prevTimeMs = 0;
    static unsigned int lastTimeMS = 0;
    static float maxFPS = 0;
    static float minFPS = 0;

    unsigned int currentTimeMs = GetTimeNano() * 1e-6;
    float everyFPS =  1000.0f / (float)(currentTimeMs - lastTimeMS);
    if( everyFPS > maxFPS ){
        maxFPS = everyFPS;
    }
    if( everyFPS < minFPS )
    {
        minFPS = everyFPS;
    }
    lastTimeMS = currentTimeMs;
    frameCounter++;
    if (currentTimeMs - prevTimeMs > INTERVALTIME)
    {
        float elapsedSec = (float)(currentTimeMs - prevTimeMs) / 1000.0f;
        float currentFPS = (float)frameCounter / elapsedSec;
        LOGI("submit, FPS: %0.2f, maxFPS: %0.2f, minFPS: %0.2f",  currentFPS, maxFPS, minFPS);

        minFPS = currentFPS;
        maxFPS = currentFPS;
        frameCounter = 0;
        prevTimeMs = currentTimeMs;
    }
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

