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
#define INTERVALTIME 10000
    static unsigned int prevTimeMs = GetTimeNano();
    static unsigned int lastTimeMS = GetTimeNano();
    static unsigned int frameCounter = 0;
    static float maxTime = 0;
    static float minTime = 0;

    unsigned int currentTimeMs = GetTimeNano();
    float everyInterTime = (float)(currentTimeMs - lastTimeMS) * 1e-6;
    if( everyInterTime > maxTime ){
        maxTime = everyInterTime;
    }
    if( everyInterTime < minTime )
    {
        minTime = everyInterTime;
    }
    lastTimeMS = currentTimeMs;
    frameCounter++;
    float totalTime = (currentTimeMs - prevTimeMs) * 1e-6;
    if (totalTime > INTERVALTIME)
    {
        float elapsedSec = (float)totalTime / 1000.0f;
        float currentFPS = (float)frameCounter / elapsedSec;
//        LOGI("submit, FPS: %0.2f, maxIntervalTime: %0.2f, minIntervalTime: %0.2f",  currentFPS, maxTime, minTime);
        __android_log_print(ANDROID_LOG_INFO, "MJDD", "---MojingTest--- AvgFPS = %06.2f , Frame = [%06.2f , %06.2f] (ms)",
                            currentFPS, minTime, maxTime);

        minTime = currentFPS;
        maxTime = currentFPS;
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

