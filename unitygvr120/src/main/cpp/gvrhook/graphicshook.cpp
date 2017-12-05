

#include <unistd.h>
#include <dlfcn.h>
#include "gvrhookfn.h"
#include "gvrlog.h"

static void * g_hGraphics = NULL;

#define fn__ZN7android13GraphicBufferC2EjjijjP13native_handleb "_ZN7android13GraphicBufferC2EjjijjP13native_handleb"
int (*old__ZN7android13GraphicBufferC2EjjijjP13native_handleb)(void *pthiz, uint32_t inWidth, uint32_t inHeight,
                                                               int inFormat, uint32_t inUsage, uint32_t inStride,
                                                               void* inHandle, bool keepOwnership) = NULL;
int mj__ZN7android13GraphicBufferC2EjjijjP13native_handleb(void *pthiz, uint32_t inWidth, uint32_t inHeight,
                                                           int inFormat, uint32_t inUsage, uint32_t inStride,
                                                           void* inHandle, bool keepOwnership)
{
    LOGITAG("mjgvr","mj__ZN7android13GraphicBufferC2EjjijjP13native_handleb, tid=%d", gettid());
    int re = old__ZN7android13GraphicBufferC2EjjijjP13native_handleb(pthiz, inWidth, inHeight, inFormat, inUsage, inStride, inHandle, keepOwnership);
    return re;
}

#define fn__ZNK7android13GraphicBuffer15getNativeBufferEv "_ZNK7android13GraphicBuffer15getNativeBufferEv"
void* (*old__ZNK7android13GraphicBuffer15getNativeBufferEv)(void *thiz) = NULL;
void* mj__ZNK7android13GraphicBuffer15getNativeBufferEv(void *thiz)
{
    LOGITAG("mjgvr","mj__ZNK7android13GraphicBuffer15getNativeBufferEv, tid=%d", gettid());
    void *pdata = old__ZNK7android13GraphicBuffer15getNativeBufferEv(thiz);
    return pdata;
}

bool InitGraphicHook()
{
    bool bRet = false;
    if (LoadGraphics())
    {
        bRet = HookToFunction(g_hGraphics ,fn__ZN7android13GraphicBufferC2EjjijjP13native_handleb,
                              (void*)mj__ZN7android13GraphicBufferC2EjjijjP13native_handleb, (void**)&old__ZN7android13GraphicBufferC2EjjijjP13native_handleb)
                &&HookToFunction(g_hGraphics, fn__ZNK7android13GraphicBuffer15getNativeBufferEv,
                                 (void*)mj__ZNK7android13GraphicBuffer15getNativeBufferEv, (void**)old__ZNK7android13GraphicBuffer15getNativeBufferEv);
        if (bRet)
        {
            bRet = true;
        }
        else
        {
            LOGE( "hook error, tid=%d", gettid());
        }
    }
    else
    {
        LOGE("LoadGVR error, tid=%d", gettid());
    }

    return bRet;
}


bool UninitGraphicsHook()
{
    if( g_hGraphics != NULL )
        dlclose(g_hGraphics);
    g_hGraphics = NULL;
}

bool LoadGraphics()
{
    if (g_hGraphics == nullptr)
    {
//        g_hGraphics = dlopen("libui.so", RTLD_LAZY);
        g_hGraphics = dlopen(NULL, RTLD_LAZY);
    }

    if (g_hGraphics == NULL)
    {
        LOGE( "dlopen libgvr.so err: %s", dlerror());
    }
    return g_hGraphics != NULL;
}