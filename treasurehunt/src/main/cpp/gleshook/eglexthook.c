#include <stdint.h>
#include <GLES3/gl32.h>
#include "callstack.h"
#include <android/log.h>
#include <string.h>
#include <EGL/egl.h>
#include <EGL/eglext.h>
#include <pthread.h>
#include "hookutils.h"
#include "log.h"

//eglext


EGLBoolean (*old_eglLockSurfaceKHR) (EGLDisplay display, EGLSurface surface, const EGLint *attrib_list) = NULL;
EGLBoolean mj_eglLockSurfaceKHR (EGLDisplay display, EGLSurface surface, const EGLint *attrib_list)
{
    LOGITAG("mjgl", "mj_eglLockSurfaceKHR");
    return old_eglLockSurfaceKHR(display, surface, attrib_list);
}

EGLBoolean (*old_eglUnlockSurfaceKHR)(EGLDisplay display, EGLSurface surface) = NULL;
EGLBoolean mj_eglUnlockSurfaceKHR(EGLDisplay display, EGLSurface surface)
{
    LOGITAG("mjgl", "mj_eglUnlockSurfaceKHR");
    return old_eglUnlockSurfaceKHR(display, surface);
}

EGLImageKHR (*old_eglCreateImageKHR)(EGLDisplay dpy, EGLContext ctx, EGLenum target, EGLClientBuffer buffer, const EGLint *attrib_list) = NULL;
EGLImageKHR mj_eglCreateImageKHR(EGLDisplay dpy, EGLContext ctx, EGLenum target, EGLClientBuffer buffer, const EGLint *attrib_list)
{
//    EGLDisplay display = eglGetCurrentDisplay();
    LOGITAG("mjgl", "mj_eglCreateImageKHR, buffer=%0X, tid=%d", buffer, gettid());
    EGLImageKHR img = old_eglCreateImageKHR(dpy, ctx, target, buffer, attrib_list);
    return img;
}

EGLBoolean (*old_eglDestroyImageKHR)(EGLDisplay dpy, EGLImageKHR image) = NULL;
EGLBoolean mj_eglDestroyImageKHR(EGLDisplay dpy, EGLImageKHR image)
{
    LOGITAG("mjgl", "mj_eglDestroyImageKHR");
    return old_eglDestroyImageKHR(dpy, image);
}

EGLSyncKHR (*old_eglCreateSyncKHR)(EGLDisplay dpy, EGLenum type, const EGLint *attrib_list) = NULL;
EGLSyncKHR mj_eglCreateSyncKHR(EGLDisplay dpy, EGLenum type, const EGLint *attrib_list)
{
    LOGITAG("mjgl", "eglCreateSyncKHR");
    return old_eglCreateSyncKHR(dpy, type, attrib_list);
}

EGLBoolean (*old_eglDestroySyncKHR)(EGLDisplay dpy, EGLSyncKHR sync) = NULL;
EGLBoolean mj_eglDestroySyncKHR(EGLDisplay dpy, EGLSyncKHR sync)
{
    LOGITAG("mjgl", "eglDestroySyncKHR, tid=%d", gettid());
    return old_eglDestroySyncKHR(dpy, sync);
}

EGLint (*old_eglClientWaitSyncKHR)(EGLDisplay dpy, EGLSyncKHR sync, EGLint flags, EGLTimeKHR timeout) = NULL;
EGLint mj_eglClientWaitSyncKHR(EGLDisplay dpy, EGLSyncKHR sync, EGLint flags, EGLTimeKHR timeout)
{
    LOGITAG("mjgl", "eglClientWaitSyncKHR, tid=%d", gettid());
    return old_eglClientWaitSyncKHR(dpy, sync, flags, timeout);
}


EGLBoolean (*old_eglSignalSyncKHR)(EGLDisplay dpy, EGLSyncKHR sync, EGLenum mode) = NULL;
EGLBoolean mj_eglSignalSyncKHR(EGLDisplay dpy, EGLSyncKHR sync, EGLenum mode)
{
    LOGITAG("mjgl", "eglSignalSyncKHR");
    return old_eglSignalSyncKHR(dpy, sync, mode);
}

EGLBoolean (*old_eglGetSyncAttribKHR)(EGLDisplay dpy, EGLSyncKHR sync, EGLint attribute, EGLint *value) = NULL;
EGLBoolean mj_eglGetSyncAttribKHR(EGLDisplay dpy, EGLSyncKHR sync, EGLint attribute, EGLint *value)
{
    LOGITAG("mjgl", "eglGetSyncAttribKHR");
    return old_eglGetSyncAttribKHR(dpy, sync, attribute, value);
}

EGLBoolean (*old_eglSetDamageRegionKHR)(EGLDisplay dpy, EGLSurface surface, EGLint *rects, EGLint n_rects) = NULL;
EGLBoolean mj_eglSetDamageRegionKHR(EGLDisplay dpy, EGLSurface surface, EGLint *rects, EGLint n_rects)
{
    LOGITAG("mjgl", "eglSetDamageRegionKHR");
    return old_eglSetDamageRegionKHR(dpy, surface, rects, n_rects);
}


EGLSyncNV (*old_eglCreateFenceSyncNV)(EGLDisplay dpy, EGLenum condition, const EGLint *attrib_list) = NULL;
EGLSyncNV mj_eglCreateFenceSyncNV(EGLDisplay dpy, EGLenum condition, const EGLint *attrib_list)
{
    LOGITAG("mjgl", "eglCreateFenceSyncNV");
    return old_eglCreateFenceSyncNV(dpy, condition, attrib_list);
}

EGLBoolean (*old_eglDestroySyncNV)(EGLSyncNV sync) = NULL;
EGLBoolean mj_eglDestroySyncNV(EGLSyncNV sync)
{
    LOGITAG("mjgl", "eglDestroySyncNV");
    return old_eglDestroySyncNV(sync);
}

EGLBoolean (*old_eglFenceNV)(EGLSyncNV sync) = NULL;
EGLBoolean mj_eglFenceNV(EGLSyncNV sync)
{
    LOGITAG("mjgl", "eglFenceNV");
    return old_eglFenceNV(sync);
}

EGLint (*old_eglClientWaitSyncNV)(EGLSyncNV sync, EGLint flags, EGLTimeNV timeout) = NULL;
EGLint mj_eglClientWaitSyncNV(EGLSyncNV sync, EGLint flags, EGLTimeNV timeout)
{
    LOGITAG("mjgl", "eglClientWaitSyncNV");
    return old_eglClientWaitSyncNV(sync, flags, timeout);
}

EGLBoolean (*old_eglSignalSyncNV)(EGLSyncNV sync, EGLenum mode) = NULL;
EGLBoolean mj_eglSignalSyncNV(EGLSyncNV sync, EGLenum mode)
{
    LOGITAG("mjgl", "eglSignalSyncNV");
    return old_eglSignalSyncNV(sync, mode);
}

EGLBoolean (*old_eglGetSyncAttribNV)(EGLSyncNV sync, EGLint attribute, EGLint *value) = NULL;
EGLBoolean mj_eglGetSyncAttribNV(EGLSyncNV sync, EGLint attribute, EGLint *value)
{
    LOGITAG("mjgl", "eglGetSyncAttribNV");
    return old_eglGetSyncAttribNV(sync, attribute, value);
}

EGLSurface (*old_eglCreatePixmapSurfaceHI)(EGLDisplay dpy, EGLConfig config, struct EGLClientPixmapHI* pixmap) = NULL;
EGLSurface mj_eglCreatePixmapSurfaceHI(EGLDisplay dpy, EGLConfig config, struct EGLClientPixmapHI* pixmap)
{
    LOGITAG("mjgl", "eglCreatePixmapSurfaceHI");
    return old_eglCreatePixmapSurfaceHI(dpy, config, pixmap);
}

EGLuint64NV (*old_eglGetSystemTimeFrequencyNV)(void) = NULL;
EGLuint64NV mj_eglGetSystemTimeFrequencyNV(void)
{
    LOGITAG("mjgl", "eglGetSystemTimeFrequencyNV");
    return old_eglGetSystemTimeFrequencyNV();
}

EGLuint64NV (*old_eglGetSystemTimeNV)(void) = NULL;
EGLuint64NV mj_eglGetSystemTimeNV(void)
{
    LOGITAG("mjgl", "eglGetSystemTimeNV");
    return old_eglGetSystemTimeNV();
}

EGLStreamKHR (*old_eglCreateStreamKHR)(EGLDisplay dpy, const EGLint *attrib_list) = NULL;
EGLStreamKHR mj_eglCreateStreamKHR(EGLDisplay dpy, const EGLint *attrib_list)
{
    LOGITAG("mjgl", "eglCreateStreamKHR");
    return old_eglCreateStreamKHR(dpy, attrib_list);
}

EGLBoolean (*old_eglDestroyStreamKHR)(EGLDisplay dpy, EGLStreamKHR stream) = NULL;
EGLBoolean mj_eglDestroyStreamKHR(EGLDisplay dpy, EGLStreamKHR stream)
{
    LOGITAG("mjgl", "eglDestroyStreamKHR");
    return old_eglDestroyStreamKHR(dpy, stream);
}

EGLBoolean (*old_eglStreamAttribKHR)(EGLDisplay dpy, EGLStreamKHR stream, EGLenum attribute, EGLint value) = NULL;
EGLBoolean mj_eglStreamAttribKHR(EGLDisplay dpy, EGLStreamKHR stream, EGLenum attribute, EGLint value)
{
    LOGITAG("mjgl", "eglStreamAttribKHR");
    return old_eglStreamAttribKHR(dpy, stream, attribute, value);
}

EGLBoolean (*old_eglQueryStreamKHR)(EGLDisplay dpy, EGLStreamKHR stream, EGLenum attribute, EGLint *value) = NULL;
EGLBoolean mj_eglQueryStreamKHR(EGLDisplay dpy, EGLStreamKHR stream, EGLenum attribute, EGLint *value)
{
    LOGITAG("mjgl", "eglQueryStreamKHR");
    return old_eglQueryStreamKHR(dpy, stream, attribute, value);
}

EGLBoolean (*old_eglQueryStreamu64KHR)(EGLDisplay dpy, EGLStreamKHR stream, EGLenum attribute, EGLuint64KHR *value) = NULL;
EGLBoolean mj_eglQueryStreamu64KHR(EGLDisplay dpy, EGLStreamKHR stream, EGLenum attribute, EGLuint64KHR *value)
{
    LOGITAG("mjgl", "eglQueryStreamu64KHR");
    return old_eglQueryStreamu64KHR(dpy, stream, attribute, value);
}

EGLBoolean (*old_eglStreamConsumerGLTextureExternalKHR)(EGLDisplay dpy, EGLStreamKHR stream) = NULL;
EGLBoolean mj_eglStreamConsumerGLTextureExternalKHR(EGLDisplay dpy, EGLStreamKHR stream)
{
    LOGITAG("mjgl", "mj_eglStreamConsumerGLTextureExternalKHR");
    return old_eglStreamConsumerGLTextureExternalKHR(dpy, stream);
}

EGLBoolean (*old_eglStreamConsumerAcquireKHR)(EGLDisplay dpy, EGLStreamKHR stream) = NULL;
EGLBoolean mj_eglStreamConsumerAcquireKHR(EGLDisplay dpy, EGLStreamKHR stream)
{
    LOGITAG("mjgl", "mj_eglStreamConsumerAcquireKHR");
    return old_eglStreamConsumerAcquireKHR(dpy, stream);
}

EGLBoolean (*old_eglStreamConsumerReleaseKHR)(EGLDisplay dpy, EGLStreamKHR stream) = NULL;
EGLBoolean mj_eglStreamConsumerReleaseKHR(EGLDisplay dpy, EGLStreamKHR stream)
{
    LOGITAG("mjgl", "mj_eglStreamConsumerReleaseKHR");
    return old_eglStreamConsumerReleaseKHR(dpy, stream);
}

EGLSurface (*old_eglCreateStreamProducerSurfaceKHR)(EGLDisplay dpy, EGLConfig config, EGLStreamKHR stream, const EGLint *attrib_list) = NULL;
EGLSurface mj_eglCreateStreamProducerSurfaceKHR(EGLDisplay dpy, EGLConfig config, EGLStreamKHR stream, const EGLint *attrib_list)
{
    LOGITAG("mjgl", "mj_eglCreateStreamProducerSurfaceKHR");
    return old_eglCreateStreamProducerSurfaceKHR(dpy, config, stream, attrib_list);
}

EGLBoolean (*old_eglQueryStreamTimeKHR)(EGLDisplay dpy, EGLStreamKHR stream, EGLenum attribute, EGLTimeKHR *value) = NULL;
EGLBoolean mj_eglQueryStreamTimeKHR(EGLDisplay dpy, EGLStreamKHR stream, EGLenum attribute, EGLTimeKHR *value)
{
    LOGITAG("mjgl", "mj_eglQueryStreamTimeKHR");
    return old_eglQueryStreamTimeKHR(dpy, stream, attribute, value);
}


EGLBoolean (*old_eglSwapBuffersWithDamageKHR)(EGLDisplay dpy, EGLSurface surface, EGLint *rects, EGLint n_rects) = NULL;
EGLBoolean mj_eglSwapBuffersWithDamageKHR (EGLDisplay dpy, EGLSurface surface, EGLint *rects, EGLint n_rects)
{
    LOGITAG("mjgl", "mj_eglSwapBuffersWithDamageKHR, surface=%X, tid=%d", surface, gettid());
    return old_eglSwapBuffersWithDamageKHR(dpy, surface, rects, n_rects);
}

EGLNativeFileDescriptorKHR (*old_eglGetStreamFileDescriptorKHR)(EGLDisplay dpy, EGLStreamKHR stream) = NULL;
EGLNativeFileDescriptorKHR mj_eglGetStreamFileDescriptorKHR(EGLDisplay dpy, EGLStreamKHR stream)
{
    LOGITAG("mjgl", "mj_eglGetStreamFileDescriptorKHR");
    return old_eglGetStreamFileDescriptorKHR(dpy, stream);
}

EGLStreamKHR (*old_eglCreateStreamFromFileDescriptorKHR)(EGLDisplay dpy, EGLNativeFileDescriptorKHR file_descriptor) = NULL;
EGLStreamKHR mj_eglCreateStreamFromFileDescriptorKHR(EGLDisplay dpy, EGLNativeFileDescriptorKHR file_descriptor)
{
    LOGITAG("mjgl", "mj_eglCreateStreamFromFileDescriptorKHR");
    return old_eglCreateStreamFromFileDescriptorKHR(dpy, file_descriptor);
}

EGLint (*old_eglWaitSyncKHR)(EGLDisplay dpy, EGLSyncKHR sync, EGLint flags) = NULL;
EGLint mj_eglWaitSyncKHR(EGLDisplay dpy, EGLSyncKHR sync, EGLint flags)
{
    LOGITAG("mjgl", "mj_eglWaitSyncKHR");
    return old_eglWaitSyncKHR(dpy, sync, flags);
}

EGLBoolean (*old_eglQueryNativeDisplayNV)( EGLDisplay dpy, EGLNativeDisplayType* display_id) = NULL;
EGLBoolean (*old_eglQueryNativeWindowNV)( EGLDisplay dpy, EGLSurface surf, EGLNativeWindowType* window) = NULL;
EGLBoolean (*old_eglQueryNativePixmapNV)( EGLDisplay dpy, EGLSurface surf, EGLNativePixmapType* pixmap) = NULL;

void (*old_eglSetBlobCacheFuncsANDROID)(EGLDisplay dpy, EGLSetBlobFuncANDROID set, EGLGetBlobFuncANDROID get) = NULL;
void mj_eglSetBlobCacheFuncsANDROID(EGLDisplay dpy, EGLSetBlobFuncANDROID set, EGLGetBlobFuncANDROID get)
{
    LOGITAG("mjgl", "mj_eglSetBlobCacheFuncsANDROID");
    return old_eglSetBlobCacheFuncsANDROID(dpy, set, get);
}

EGLBoolean (*old_eglPresentationTimeANDROID)(EGLDisplay dpy, EGLSurface sur, EGLnsecsANDROID time) = NULL;
EGLBoolean mj_eglPresentationTimeANDROID(EGLDisplay dpy, EGLSurface sur, EGLnsecsANDROID time)
{
    LOGITAG("mjgl", "mj_eglPresentationTimeANDROID");
    return old_eglPresentationTimeANDROID(dpy, sur, time);
}

EGLClientBuffer (*old_eglCreateNativeClientBufferANDROID)(const EGLint *attrib_list) = NULL;
EGLClientBuffer mj_eglCreateNativeClientBufferANDROID(const EGLint *attrib_list)
{
    int i = 0;
    while(attrib_list[i] != EGL_NONE){
        LOGITAG("mjgl", "attr:%0X, value:%d", attrib_list[i], attrib_list[i+1]);
        i = i+2;
    }
    EGLClientBuffer buffer = old_eglCreateNativeClientBufferANDROID(attrib_list);
    LOGITAG("mjgl", "eglCreateNativeClientBufferANDROID, buffer=%0X, tid=%d", buffer, gettid());
    return buffer;
}

//////////////////////////

void hookEglextFun()
{
    hook((uint32_t) eglLockSurfaceKHR, (uint32_t)mj_eglLockSurfaceKHR, (uint32_t **) &old_eglLockSurfaceKHR);
    hook((uint32_t) eglUnlockSurfaceKHR, (uint32_t)mj_eglUnlockSurfaceKHR, (uint32_t **)&old_eglUnlockSurfaceKHR);
    hook((uint32_t) eglCreateImageKHR, (uint32_t)mj_eglCreateImageKHR, (uint32_t **) &old_eglCreateImageKHR);
    hook((uint32_t) eglDestroyImageKHR, (uint32_t)mj_eglDestroyImageKHR, (uint32_t **) &old_eglDestroyImageKHR);
    hook((uint32_t) eglCreateSyncKHR, (uint32_t)mj_eglCreateSyncKHR, (uint32_t **) &old_eglCreateSyncKHR);
    hook((uint32_t) eglDestroySyncKHR, (uint32_t)mj_eglDestroySyncKHR, (uint32_t **) &old_eglDestroySyncKHR);
    hook((uint32_t) eglClientWaitSyncKHR, (uint32_t)mj_eglClientWaitSyncKHR, (uint32_t **) &old_eglClientWaitSyncKHR);
    hook((uint32_t) eglSignalSyncKHR, (uint32_t)mj_eglSignalSyncKHR, (uint32_t **) &old_eglSignalSyncKHR);
    hook((uint32_t) eglGetSyncAttribKHR, (uint32_t)mj_eglGetSyncAttribKHR, (uint32_t **) &old_eglGetSyncAttribKHR);
    hook((uint32_t) eglSetDamageRegionKHR, (uint32_t)mj_eglSetDamageRegionKHR, (uint32_t **) &old_eglSetDamageRegionKHR);
//    hook((uint32_t) eglCreateFenceSyncNV, (uint32_t)mj_eglCreateFenceSyncNV, (uint32_t **) &old_eglCreateFenceSyncNV);
//    hook((uint32_t) eglDestroySyncNV, (uint32_t)mj_eglDestroySyncNV, (uint32_t **) &old_eglDestroySyncNV);
//    hook((uint32_t) eglFenceNV, (uint32_t)mj_eglFenceNV, (uint32_t **) &old_eglFenceNV);
//    hook((uint32_t) eglClientWaitSyncNV, (uint32_t)mj_eglClientWaitSyncNV, (uint32_t **) &old_eglClientWaitSyncNV);
//    hook((uint32_t) eglSignalSyncNV, (uint32_t)mj_eglSignalSyncNV, (uint32_t **) &old_eglSignalSyncNV);
//    hook((uint32_t) eglGetSyncAttribNV, (uint32_t)mj_eglGetSyncAttribNV, (uint32_t **) &old_eglGetSyncAttribNV);
//    hook((uint32_t) eglCreatePixmapSurfaceHI, (uint32_t)mj_eglCreatePixmapSurfaceHI, (uint32_t **) &old_eglCreatePixmapSurfaceHI);
    hook((uint32_t) eglGetSystemTimeFrequencyNV, (uint32_t)mj_eglGetSystemTimeFrequencyNV, (uint32_t **) &old_eglGetSystemTimeFrequencyNV);
    hook((uint32_t) eglGetSystemTimeNV, (uint32_t)mj_eglGetSystemTimeNV, (uint32_t **) &old_eglGetSystemTimeNV);
    hook((uint32_t) eglCreateStreamKHR, (uint32_t)mj_eglCreateStreamKHR, (uint32_t **) &old_eglCreateStreamKHR);
    hook((uint32_t) eglDestroyStreamKHR, (uint32_t)mj_eglDestroyStreamKHR, (uint32_t **) &old_eglDestroyStreamKHR);
    hook((uint32_t) eglStreamAttribKHR, (uint32_t)mj_eglStreamAttribKHR, (uint32_t **) &old_eglStreamAttribKHR);
    hook((uint32_t) eglQueryStreamKHR, (uint32_t)mj_eglQueryStreamKHR, (uint32_t **) &old_eglQueryStreamKHR);
    hook((uint32_t) eglQueryStreamu64KHR, (uint32_t)mj_eglQueryStreamu64KHR, (uint32_t **) &old_eglQueryStreamu64KHR);
    hook((uint32_t) eglStreamConsumerGLTextureExternalKHR, (uint32_t)mj_eglStreamConsumerGLTextureExternalKHR, (uint32_t **) &old_eglStreamConsumerGLTextureExternalKHR);
    hook((uint32_t) eglStreamConsumerAcquireKHR, (uint32_t)mj_eglStreamConsumerAcquireKHR, (uint32_t **) &old_eglStreamConsumerAcquireKHR);
    hook((uint32_t) eglStreamConsumerReleaseKHR, (uint32_t)mj_eglStreamConsumerReleaseKHR, (uint32_t **) &old_eglStreamConsumerReleaseKHR);
    hook((uint32_t) eglCreateStreamProducerSurfaceKHR, (uint32_t)mj_eglCreateStreamProducerSurfaceKHR, (uint32_t **) &old_eglCreateStreamProducerSurfaceKHR);
    hook((uint32_t) eglQueryStreamTimeKHR, (uint32_t)mj_eglQueryStreamTimeKHR, (uint32_t **) &old_eglQueryStreamTimeKHR);
    hook((uint32_t) eglSwapBuffersWithDamageKHR, (uint32_t)mj_eglSwapBuffersWithDamageKHR, (uint32_t **) &old_eglSwapBuffersWithDamageKHR);
    hook((uint32_t) eglGetStreamFileDescriptorKHR, (uint32_t)mj_eglGetStreamFileDescriptorKHR, (uint32_t **) &old_eglGetStreamFileDescriptorKHR);
    hook((uint32_t) eglCreateStreamFromFileDescriptorKHR, (uint32_t)mj_eglCreateStreamFromFileDescriptorKHR, (uint32_t **) &old_eglCreateStreamFromFileDescriptorKHR);
    hook((uint32_t) eglWaitSyncKHR, (uint32_t)mj_eglWaitSyncKHR, (uint32_t **) &old_eglWaitSyncKHR);
    hook((uint32_t) eglPresentationTimeANDROID, (uint32_t)mj_eglPresentationTimeANDROID, (uint32_t **) &old_eglPresentationTimeANDROID);

    hook((uint32_t) eglCreateNativeClientBufferANDROID, (uint32_t)mj_eglCreateNativeClientBufferANDROID, (uint32_t **) &old_eglCreateNativeClientBufferANDROID);


    return;
}


