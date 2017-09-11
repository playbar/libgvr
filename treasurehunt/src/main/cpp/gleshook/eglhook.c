#include <stdint.h>
#include <GLES3/gl32.h>
#include "callstack.h"
#include <android/log.h>
#include <string.h>
#include <EGL/egl.h>
#include <pthread.h>
#include "hookutils.h"
#include "log.h"

EGLint (*old_eglGetError)(void) = NULL;
EGLint MJ_eglGetError(void)
{
    LOGITAG("mjgl","MJ_eglGetError, tid=%d", gettid());
    EGLint re = old_eglGetError();
    return re;
}
EGLDisplay (*old_eglGetDisplay)(EGLNativeDisplayType display_id) = NULL;
EGLDisplay MJ_eglGetDisplay(EGLNativeDisplayType display_id)
{
    LOGITAG("mjgl","MJ_eglGetDisplay");
    return old_eglGetDisplay(display_id);
}

EGLBoolean (*old_eglInitialize)(EGLDisplay dpy, EGLint *major, EGLint *minor) = NULL;
EGLBoolean MJ_eglInitialize(EGLDisplay dpy, EGLint *major, EGLint *minor)
{
    LOGITAG("mjgl","MJ_eglInitialize");
    return old_eglInitialize(dpy, major, minor);
}

EGLBoolean (*old_eglTerminate)(EGLDisplay dpy) = NULL;
EGLBoolean MJ_eglTerminate(EGLDisplay dpy)
{
    LOGITAG("mjgl","MJ_eglTerminate");
    return old_eglTerminate(dpy);
}

const char * (*old_eglQueryString)(EGLDisplay dpy, EGLint name) = NULL;
const char * MJ_eglQueryString(EGLDisplay dpy, EGLint name)
{
    LOGITAG("mjgl","MJ_eglQueryString");
    return old_eglQueryString(dpy, name);
}

EGLBoolean (*old_eglGetConfigs)(EGLDisplay dpy, EGLConfig *configs, EGLint config_size, EGLint *num_config) = NULL;
EGLBoolean MJ_eglGetConfigs(EGLDisplay dpy, EGLConfig *configs, EGLint config_size, EGLint *num_config)
{
    LOGITAG("mjgl","MJ_eglGetConfigs");
    return old_eglGetConfigs(dpy, configs, config_size, num_config);
}

EGLBoolean (*old_eglChooseConfig)(EGLDisplay dpy, const EGLint *attrib_list, EGLConfig *configs, EGLint config_size, EGLint *num_config) = NULL;
EGLBoolean MJ_eglChooseConfig(EGLDisplay dpy, const EGLint *attrib_list, EGLConfig *configs, EGLint config_size, EGLint *num_config)
{
    LOGITAG("mjgl","MJ_eglChooseConfig");
    return old_eglChooseConfig(dpy, attrib_list, configs, config_size, num_config);
}

EGLBoolean (*old_eglGetConfigAttrib)(EGLDisplay dpy, EGLConfig config, EGLint attribute, EGLint *value) = NULL;
EGLBoolean MJ_eglGetConfigAttrib(EGLDisplay dpy, EGLConfig config, EGLint attribute, EGLint *value)
{
    EGLBoolean re = old_eglGetConfigAttrib(dpy, config, attribute, value);
    LOGITAG("mjgl","MJ_eglGetConfigAttrib, attribute=%d, value=%d, pid=%d", attribute, *value, getpid());
    return re;
}

EGLSurface (*old_eglCreateWindowSurface)(EGLDisplay dpy, EGLConfig config, EGLNativeWindowType win, const EGLint *attrib_list) = NULL;
EGLSurface MJ_eglCreateWindowSurface(EGLDisplay dpy, EGLConfig config, EGLNativeWindowType win, const EGLint *attrib_list)
{
    EGLSurface surface = old_eglCreateWindowSurface(dpy, config, win, attrib_list);
    LOGITAG("mjgl","MJ_eglCreateWindowSurface window=%x", surface);
    return surface;
}

EGLSurface (*old_eglCreatePbufferSurface)(EGLDisplay dpy, EGLConfig config,const EGLint *attrib_list) = NULL;
EGLSurface MJ_eglCreatePbufferSurface(EGLDisplay dpy, EGLConfig config, const EGLint *attrib_list)
{
    EGLSurface surface = old_eglCreatePbufferSurface(dpy, config, attrib_list);
    LOGITAG("mjgl","MJ_eglCreatePbufferSurface pbuffer=%x, tid=%d", surface, gettid());
    return surface;
}

EGLSurface (*old_eglCreatePixmapSurface)(EGLDisplay dpy, EGLConfig config, EGLNativePixmapType pixmap, const EGLint *attrib_list) = NULL;
EGLSurface MJ_eglCreatePixmapSurface(EGLDisplay dpy, EGLConfig config, EGLNativePixmapType pixmap, const EGLint *attrib_list)
{
    LOGITAG("mjgl","MJ_eglCreatePixmapSurface");
    EGLSurface surface = old_eglCreatePixmapSurface(dpy, config, pixmap, attrib_list);
    LOGITAG("mjgl","eglcreate pixmap=%x", surface);
    return surface;
}

EGLBoolean (*old_eglDestroySurface)(EGLDisplay dpy, EGLSurface surface) = NULL;
EGLBoolean MJ_eglDestroySurface(EGLDisplay dpy, EGLSurface surface)
{
    LOGITAG("mjgl","MJ_eglDestroySurface");
    return old_eglDestroySurface(dpy, surface);
}

EGLBoolean (*old_eglQuerySurface)(EGLDisplay dpy, EGLSurface surface, EGLint attribute, EGLint *value) = NULL;
EGLBoolean MJ_eglQuerySurface(EGLDisplay dpy, EGLSurface surface, EGLint attribute, EGLint *value)
{
    LOGITAG("mjgl","MJ_eglQuerySurface");
    return old_eglQuerySurface(dpy, surface, attribute, value);
}

EGLBoolean (*old_eglBindAPI)(EGLenum api) = NULL;
EGLBoolean MJ_eglBindAPI(EGLenum api)
{
    LOGITAG("mjgl","MJ_eglBindAPI");
    return old_eglBindAPI(api);
}

EGLenum (*old_eglQueryAPI)(void) = NULL;
EGLenum MJ_eglQueryAPI(void)
{
    LOGITAG("mjgl","MJ_eglQueryAPI");
    return old_eglQueryAPI();
}

EGLBoolean (*old_eglWaitClient)(void) = NULL;
EGLBoolean MJ_eglWaitClient(void)
{
    LOGITAG("mjgl","MJ_eglWaitClient");
    return old_eglWaitClient();
}

EGLBoolean (*old_eglReleaseThread)(void) = NULL;
EGLBoolean MJ_eglReleaseThread(void)
{
    LOGITAG("mjgl","MJ_eglReleaseThread");
    return old_eglReleaseThread();
}

EGLSurface (*old_eglCreatePbufferFromClientBuffer)(EGLDisplay dpy, EGLenum buftype, EGLClientBuffer buffer,
                                                   EGLConfig config, const EGLint *attrib_list) = NULL;
EGLSurface MJ_eglCreatePbufferFromClientBuffer(EGLDisplay dpy, EGLenum buftype, EGLClientBuffer buffer, EGLConfig config, const EGLint *attrib_list)
{
    LOGITAG("mjgl","MJ_eglCreatePbufferFromClientBuffer");
    return old_eglCreatePbufferFromClientBuffer(dpy, buftype, buffer, config, attrib_list);
}

EGLBoolean (*old_eglSurfaceAttrib)(EGLDisplay dpy, EGLSurface surface, EGLint attribute, EGLint value) = NULL;
EGLBoolean MJ_eglSurfaceAttrib(EGLDisplay dpy, EGLSurface surface, EGLint attribute, EGLint value)
{
    LOGITAG("mjgl","MJ_eglSurfaceAttrib");
    return old_eglSurfaceAttrib(dpy, surface, attribute, value);
}

EGLBoolean (*old_eglBindTexImage)(EGLDisplay dpy, EGLSurface surface, EGLint buffer) = NULL;
EGLBoolean MJ_eglBindTexImage(EGLDisplay dpy, EGLSurface surface, EGLint buffer)
{
    LOGITAG("mjgl","MJ_eglBindTexImage");
    return old_eglBindTexImage(dpy, surface, buffer);
}

EGLBoolean (*old_eglReleaseTexImage)(EGLDisplay dpy, EGLSurface surface, EGLint buffer) = NULL;
EGLBoolean MJ_eglReleaseTexImage(EGLDisplay dpy, EGLSurface surface, EGLint buffer)
{
    LOGITAG("mjgl","MJ_eglReleaseTexImage");
    return old_eglReleaseTexImage(dpy, surface, buffer);
}

EGLBoolean (*old_eglSwapInterval)(EGLDisplay dpy, EGLint interval) = NULL;
EGLBoolean MJ_eglSwapInterval(EGLDisplay dpy, EGLint interval)
{
    LOGITAG("mjgl","MJ_eglSwapInterval");
    return old_eglSwapInterval(dpy, interval);
}

EGLContext (*old_eglCreateContext)(EGLDisplay dpy, EGLConfig config, EGLContext share_context, const EGLint *attrib_list) = NULL;
EGLContext MJ_eglCreateContext(EGLDisplay dpy, EGLConfig config, EGLContext share_context, const EGLint *attrib_list)
{
    EGLContext context = old_eglCreateContext(dpy, config, share_context, attrib_list);
    LOGITAG("mjgl","MJ_eglCreateContext context=%x, share_context=%x, pid=%d", context, share_context, getpid());
    return context;
}

EGLBoolean (*old_eglDestroyContext)(EGLDisplay dpy, EGLContext ctx) = NULL;
EGLBoolean MJ_eglDestroyContext(EGLDisplay dpy, EGLContext ctx)
{
    LOGITAG("mjgl","MJ_eglDestroyContext");
    return old_eglDestroyContext(dpy, ctx);
}

EGLBoolean (*old_eglMakeCurrent)(EGLDisplay dpy, EGLSurface draw, EGLSurface read, EGLContext ctx) = NULL;
EGLBoolean MJ_eglMakeCurrent(EGLDisplay dpy, EGLSurface draw, EGLSurface read, EGLContext ctx)
{
    LOGITAG("mjgl","MJ_eglMakeCurrent draw=%0X, read=%0X, context=%X, tid=%d", draw, read, ctx, gettid());
    return old_eglMakeCurrent(dpy, draw, read, ctx);
}

EGLContext (*old_eglGetCurrentContext)(void) = NULL;
EGLContext MJ_eglGetCurrentContext(void)
{
    EGLContext context = old_eglGetCurrentContext();
    LOGITAG("mjgl","MJ_eglGetCurrentContext, context=%x, tid=%d", context, gettid());
    return context;
}

EGLSurface (*old_eglGetCurrentSurface)(EGLint readdraw) = NULL;
EGLSurface MJ_eglGetCurrentSurface(EGLint readdraw)
{
    LOGITAG("mjgl","MJ_eglGetCurrentSurface");
    return old_eglGetCurrentSurface(readdraw);
}

EGLDisplay (*old_eglGetCurrentDisplay)(void) = NULL;
EGLDisplay MJ_eglGetCurrentDisplay(void)
{
    LOGITAG("mjgl","MJ_eglGetCurrentDisplay");
    return old_eglGetCurrentDisplay();
}

EGLBoolean (*old_eglQueryContext)(EGLDisplay dpy, EGLContext ctx, EGLint attribute, EGLint *value) = NULL;
EGLBoolean MJ_eglQueryContext(EGLDisplay dpy, EGLContext ctx, EGLint attribute, EGLint *value)
{
    LOGITAG("mjgl","MJ_eglQueryContext");
    return old_eglQueryContext(dpy, ctx, attribute, value);
}

EGLBoolean (*old_eglWaitGL)(void) = NULL;
EGLBoolean MJ_eglWaitGL(void)
{
    LOGITAG("mjgl","MJ_eglWaitGL");
    return old_eglWaitGL();
}

EGLBoolean (*old_eglWaitNative)(EGLint engine) = NULL;
EGLBoolean MJ_eglWaitNative(EGLint engine)
{
    LOGITAG("mjgl","MJ_eglWaitNative");
    return old_eglWaitNative(engine);
}

EGLBoolean (*old_eglSwapBuffers)(EGLDisplay dpy, EGLSurface surface) = NULL;
EGLBoolean MJ_eglSwapBuffers(EGLDisplay dpy, EGLSurface surface)
{
    LOGITAG("mjgl","MJ_eglSwapBuffers");
    return old_eglSwapBuffers(dpy, surface);
}

EGLBoolean (*old_eglCopyBuffers)(EGLDisplay dpy, EGLSurface surface, EGLNativePixmapType target) = NULL;
EGLBoolean MJ_eglCopyBuffers(EGLDisplay dpy, EGLSurface surface, EGLNativePixmapType target)
{
    LOGITAG("mjgl","MJ_eglCopyBuffers");
    return MJ_eglCopyBuffers(dpy, surface, target);
}

//typedef void (*__eglMustCastToProperFunctionPointerType)(void);
__eglMustCastToProperFunctionPointerType (*old_eglGetProcAddress)(const char *procname) = NULL;
__eglMustCastToProperFunctionPointerType mj_eglGetProcAddress(const char *procname)
{
    LOGITAG("mjgl","mj_eglGetProcAddress, procename=%s", procname);
    return old_eglGetProcAddress(procname);
}



void hookEGLFun()
{
    hook((uint32_t) eglGetError, (uint32_t)MJ_eglGetError, (uint32_t **) &old_eglGetError);
    hook((uint32_t) eglGetDisplay, (uint32_t)MJ_eglGetDisplay, (uint32_t **) &old_eglGetDisplay);
    hook((uint32_t) eglInitialize, (uint32_t)MJ_eglInitialize, (uint32_t **) &old_eglInitialize);
    hook((uint32_t) eglTerminate, (uint32_t)MJ_eglTerminate, (uint32_t **) &old_eglTerminate);
    hook((uint32_t) eglQueryString, (uint32_t)MJ_eglQueryString, (uint32_t **) &old_eglQueryString);
    hook((uint32_t) eglGetConfigs, (uint32_t)MJ_eglGetConfigs, (uint32_t **) &old_eglGetConfigs);
    hook((uint32_t) eglChooseConfig, (uint32_t)MJ_eglChooseConfig, (uint32_t **) &old_eglChooseConfig);
    hook((uint32_t) eglGetConfigAttrib, (uint32_t)MJ_eglGetConfigAttrib, (uint32_t **) &old_eglGetConfigAttrib);
    hook((uint32_t) eglCreateWindowSurface, (uint32_t)MJ_eglCreateWindowSurface, (uint32_t **) &old_eglCreateWindowSurface);
    hook((uint32_t) eglCreatePbufferSurface, (uint32_t)MJ_eglCreatePbufferSurface, (uint32_t **) &old_eglCreatePbufferSurface);
    hook((uint32_t) eglCreatePixmapSurface, (uint32_t)MJ_eglCreatePixmapSurface, (uint32_t **) &old_eglCreatePixmapSurface);
    hook((uint32_t) eglDestroySurface, (uint32_t)MJ_eglDestroySurface, (uint32_t **) &old_eglDestroySurface);
    hook((uint32_t) eglQuerySurface, (uint32_t)MJ_eglQuerySurface, (uint32_t **) &old_eglQuerySurface);
    hook((uint32_t) eglBindAPI, (uint32_t)MJ_eglBindAPI, (uint32_t **) &old_eglBindAPI);
    hook((uint32_t) eglQueryAPI, (uint32_t)MJ_eglQueryAPI, (uint32_t **) &old_eglQueryAPI);
    hook((uint32_t) eglWaitClient, (uint32_t)MJ_eglWaitClient, (uint32_t **) &old_eglWaitClient);
    hook((uint32_t) eglReleaseThread, (uint32_t)MJ_eglReleaseThread, (uint32_t **) &old_eglReleaseThread);
    hook((uint32_t) eglCreatePbufferFromClientBuffer, (uint32_t)MJ_eglCreatePbufferFromClientBuffer, (uint32_t **) &old_eglCreatePbufferFromClientBuffer);
    hook((uint32_t) eglSurfaceAttrib, (uint32_t)MJ_eglSurfaceAttrib, (uint32_t **) &old_eglSurfaceAttrib);
    hook((uint32_t) eglBindTexImage, (uint32_t)MJ_eglBindTexImage, (uint32_t **) &old_eglBindTexImage);
    hook((uint32_t) eglReleaseTexImage, (uint32_t)MJ_eglReleaseTexImage, (uint32_t **) &old_eglReleaseTexImage);
    hook((uint32_t) eglSwapInterval, (uint32_t)MJ_eglSwapInterval, (uint32_t **) &old_eglSwapInterval);
    hook((uint32_t) eglCreateContext, (uint32_t)MJ_eglCreateContext, (uint32_t **) &old_eglCreateContext);
    hook((uint32_t) eglDestroyContext, (uint32_t)MJ_eglDestroyContext, (uint32_t **) &old_eglDestroyContext);
    hook((uint32_t) eglMakeCurrent, (uint32_t)MJ_eglMakeCurrent, (uint32_t **) &old_eglMakeCurrent);
    hook((uint32_t) eglGetCurrentContext, (uint32_t)MJ_eglGetCurrentContext, (uint32_t **) &old_eglGetCurrentContext);
    hook((uint32_t) eglGetCurrentSurface, (uint32_t)MJ_eglGetCurrentSurface, (uint32_t **) &old_eglGetCurrentSurface);
    hook((uint32_t) eglGetCurrentDisplay, (uint32_t)MJ_eglGetCurrentDisplay, (uint32_t **) &old_eglGetCurrentDisplay);
    hook((uint32_t) eglQueryContext, (uint32_t)MJ_eglQueryContext, (uint32_t **) &old_eglQueryContext);
    hook((uint32_t) eglWaitGL, (uint32_t)MJ_eglWaitGL, (uint32_t **) &old_eglWaitGL);
    hook((uint32_t) eglWaitNative, (uint32_t)MJ_eglWaitNative, (uint32_t **) &old_eglWaitNative);
    hook((uint32_t) eglSwapBuffers, (uint32_t)MJ_eglSwapBuffers, (uint32_t **) &old_eglSwapBuffers);
    hook((uint32_t) eglCopyBuffers, (uint32_t)MJ_eglCopyBuffers, (uint32_t **) &old_eglCopyBuffers);
    hook((uint32_t) eglGetProcAddress, (uint32_t)mj_eglGetProcAddress, (uint32_t **) &old_eglGetProcAddress);

    return;
}


