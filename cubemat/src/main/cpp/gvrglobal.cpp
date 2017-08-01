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

//static bool Android_GetPackageName(char* outPackageName, size_t length) {
//
//    android_app* app = Android_GetApp();
//    ANativeActivity*activity = app->activity;
//
//    JNIEnv* env = activity->env;
//    //note: we need to attach dalvik VM to current thread, as it is not main thread
//    JavaVM* vm = activity->vm;
//    if ( (*vm)->GetEnv(vm, (void **)&env, JNI_VERSION_1_6) < 0 )
//        (*vm)->AttachCurrentThread(vm, &env, NULL);
//
//    //get package name from Activity Class(context)
//    jclass android_content_Context = (*env)->GetObjectClass(env, activity->clazz);
//    jmethodID midGetPackageName = (*env)->GetMethodID(env, android_content_Context, "getPackageName", "()Ljava/lang/String;");
//    jstring PackageName= (jstring)(*env)->CallObjectMethod(env, activity->clazz, midGetPackageName);
//
//    bool ret = false;
//    if( PackageName != null ) {
//        // get UTF8 string & copy to dest
//        const char* charBuff = (*env)->GetStringUTFChars(env, PackageName, NULL);
//        strncpy(outPackageName, charBuff, length);
//        outPackageName[length-1]='\0';
//
//        (*env)->ReleaseStringUTFChars(PackageName, charBuff);
//        (*env)->DeleteLocalRef(env, PackageName);
//    }
//    (*env)->DeleteLocalRef(env, android_content_Context);
//
//    return ret;
//}


JNIEXPORT jint JNICALL JNI_OnLoad()
{
    CLogMessage msg(__FUNCTION__);
//    getimagebase();
    return gGvrApi.JNI_OnLoad1();
//    return  JNI_VERSION_1_6;
}

