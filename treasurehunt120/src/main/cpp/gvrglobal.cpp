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

bool phrase_dev_num(char *devno, int *pmajor, int *pminor)
{
    *pmajor = 0;
    *pminor = 0;
    if (devno != NULL) {
        char *second = strstr(devno, ":");
        if (second != NULL) {
            *pmajor = strtoul(devno + 0, NULL, 16);
            *pminor = strtoul(second + 1, NULL, 16);
            return true;
        }
    }
    return false;
}

bool phrase_proc_base_addr(char *addr, void **pbase_addr, void **pend_addr) {
    char *split = strchr(addr, '-');
    if (split != NULL) {
        if (pbase_addr != NULL) {
            *pbase_addr = (void *) strtoul(addr, NULL, 16);
        }
        if (pend_addr != NULL) {
            *pend_addr = (void *) strtoul(split + 1, NULL, 16);
        }
        return true;
    }
    return false;
}

void* getimagebase(const char *target) {
    FILE *fd = fopen("/proc/self/maps", "r");
    if (fd != NULL) {
        char buff[2048 + 1];
        while (fgets(buff, 2048, fd) != NULL) {
            const char *sep = "\t \r\n";
            char *line = NULL;
            char *addr = strtok_r(buff, sep, &line);
            if (!addr) {
                continue;
            }

            char *flags = strtok_r(NULL, sep, &line);
            if (!flags || flags[0] != 'r' || flags[3] == 's') {
                //
                /*
                    1. mem section cound NOT be read, without 'r' flag.
                    2. read from base addr of /dev/mail module would crash.
                       i dont know how to handle it, just skip it.

                       1f5573000-1f58f7000 rw-s 1f5573000 00:0c 6287 /dev/mali0

                 */
                continue;
            }
            strtok_r(NULL, sep, &line);  // offsets
            char *dev = strtok_r(NULL, sep, &line);  // dev number.
            int major = 0, minor = 0;
            if (!phrase_dev_num(dev, &major, &minor) || major == 0) {
                /*
                    if dev major number equal to 0, mean the module must NOT be
                    a shared or executable object loaded from disk.
                    e.g:
                    lookup symbol from [vdso] would crash.
                    7f7b48a000-7f7b48c000 r-xp 00000000 00:00 0  [vdso]
                 */
                continue;
            }

            strtok_r(NULL, sep, &line);  // node

            char *filename = strtok_r(NULL, sep, &line); //module name
            if (!filename) {
                continue;
            }

            if (*filename == '\0') {
                continue;
            }
//            LOGD("filename: %s ,target:%s",filename,target);
//            std::string module_name(filename);

            if (strstr(filename, target) != NULL) {
                void *base_addr = NULL;
                void *end_addr = NULL;
                phrase_proc_base_addr(addr, &base_addr, &end_addr);
                void * image_base = base_addr;
                LOGI("get Module : %s,%p", filename, image_base);
                fclose(fd);
                return image_base;
            }
        }

    }
    fclose(fd);
    return (void *)-1;

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

