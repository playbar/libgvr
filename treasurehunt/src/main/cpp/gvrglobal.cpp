#include <unistd.h>
#include "gvrglobal.h"
#include "gvrfn.h"
#include "LogMessage.h"


long getimagebase()
{
    pid_t pid =  getpid();
    char fileName[256] = {0};
    sprintf(fileName, "/proc/%d/maps", pid);
    FILE* fd = fopen(fileName, "r");
    if (fd != NULL)
    {
        char buff[2048+1];
        while(fgets(buff, 2048, fd) != NULL)
        {
            LOGI("get Module : %s", buff);
//            const char *sep = "\t \r\n";
//            char *line = NULL;
//            char* addr = strtok_r(buff, sep, &line);
//            if (!addr) {
//                continue;
//            }
//
//            char *flags = strtok_r(NULL, sep, &line);
//            if (!flags || flags[0] != 'r' || flags[3] == 's') {
//                //
//                /*
//                    1. mem section cound NOT be read, without 'r' flag.
//                    2. read from base addr of /dev/mail module would crash.
//                       i dont know how to handle it, just skip it.
//
//                       1f5573000-1f58f7000 rw-s 1f5573000 00:0c 6287 /dev/mali0
//
//                 */
//                continue;
//            }
//            strtok_r(NULL, sep, &line);  // offsets
//            char *dev = strtok_r(NULL, sep, &line);  // dev number.
//            int major = 0, minor = 0;
//            if (!phrase_dev_num(dev, &major, &minor) || major == 0) {
//                /*
//                    if dev major number equal to 0, mean the module must NOT be
//                    a shared or executable object loaded from disk.
//                    e.g:
//                    lookup symbol from [vdso] would crash.
//                    7f7b48a000-7f7b48c000 r-xp 00000000 00:00 0  [vdso]
//                 */
//                continue;
//            }
//
//            strtok_r(NULL, sep, &line);  // node
//
//            char* filename = strtok_r(NULL, sep, &line); //module name
//            if (!filename) {
//                continue;
//            }
//            std::string module_name = filename;
//            if(module_name.find(target)!=module_name.npos){
//                void* base_addr = NULL;
//                void* end_addr = NULL;
//                phrase_proc_base_addr(addr, &base_addr, &end_addr) ;
//                long image_base=(long)base_addr;
//                LOGI("get Module : %s,%lx", filename,image_base);
//                fclose(fd);
//                return image_base;
//            }
        }

    }
    fclose(fd);
    return 0;

}

JNIEXPORT jstring JNICALL Java_com_mj_vr_MainActivity_stringFromJNI( JNIEnv* env, jobject thiz )
{
#define ABI "armeabi-v7a"
    gGvrApi.Init();
    CLogMessage msg(__FUNCTION__);
    getimagebase();
    return env->NewStringUTF("Hello from JNI !  Compiled with ABI " ABI ".");
}


JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved)
{
    return gGvrApi.JNI_OnLoad(vm, reserved);
//    return  JNI_VERSION_1_6;
}

