#include <stdint.h>
#include <GLES3/gl32.h>
#include "callstack.h"
#include <android/log.h>
#include <string.h>
#include <EGL/egl.h>
#include <pthread.h>
#include <syscallstack.h>
#include "hookutils.h"
#include "log.h"

EGLint (*old_eglGetError)(void) = NULL;
EGLint MJ_eglGetError(void)
{
//    LOGITAG("mjgl","MJ_eglGetError, tid=%d", gettid());
    EGLint re = old_eglGetError();
    return re;
}
EGLDisplay (*old_eglGetDisplay)(EGLNativeDisplayType display_id) = NULL;
EGLDisplay MJ_eglGetDisplay(EGLNativeDisplayType display_id)
{
    LOGITAG("mjgl","MJ_eglGetDisplay, tid=%d", gettid());
    return old_eglGetDisplay(display_id);
}

EGLBoolean (*old_eglInitialize)(EGLDisplay dpy, EGLint *major, EGLint *minor) = NULL;
EGLBoolean MJ_eglInitialize(EGLDisplay dpy, EGLint *major, EGLint *minor)
{
    LOGITAG("mjgl","MJ_eglInitialize, tid=%d", gettid());
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
    const char *str = old_eglQueryString(dpy, name);
    LOGITAG("mjgl","MJ_eglQueryString, name=%s, tid=%d", str, gettid());
    return str;
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
    LOGITAG("mjgl","MJ_eglChooseConfig, tid=%d", gettid());
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
    LOGITAG("mjgl","MJ_eglCreateWindowSurface surface=%X, tid=%d", surface, gettid());
    return surface;
}

EGLSurface (*old_eglCreatePbufferSurface)(EGLDisplay dpy, EGLConfig config,const EGLint *attrib_list) = NULL;
EGLSurface MJ_eglCreatePbufferSurface(EGLDisplay dpy, EGLConfig config, const EGLint *attrib_list)
{
    EGLSurface surface = old_eglCreatePbufferSurface(dpy, config, attrib_list);
    LOGITAG("mjgl","MJ_eglCreatePbufferSurface pbuffer=%X, tid=%d", surface, gettid());
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
    LOGITAG("mjgl","MJ_eglQuerySurface, surface=%X, tid=%d", surface, gettid());
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
    LOGITAG("mjgl","MJ_eglSurfaceAttrib, surface=%X, tid=%d", surface, gettid());
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
//    LOGITAG("mjgl","MJ_eglGetCurrentContext, context=%x, tid=%d", context, gettid());
    return context;
}

EGLSurface (*old_eglGetCurrentSurface)(EGLint readdraw) = NULL;
EGLSurface MJ_eglGetCurrentSurface(EGLint readdraw)
{
    EGLSurface  surface = old_eglGetCurrentSurface(readdraw);
    LOGITAG("mjgl","MJ_eglGetCurrentSurface, surface=%X, tid=%d", surface, gettid());
    return surface;
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
    LOGITAG("mjgl","MJ_eglSwapBuffers, surface=%X, tid=%d", surface, gettid());
    return old_eglSwapBuffers(dpy, surface);
}

EGLBoolean (*old_eglCopyBuffers)(EGLDisplay dpy, EGLSurface surface, EGLNativePixmapType target) = NULL;
EGLBoolean MJ_eglCopyBuffers(EGLDisplay dpy, EGLSurface surface, EGLNativePixmapType target)
{
    LOGITAG("mjgl","MJ_eglCopyBuffers");
    return MJ_eglCopyBuffers(dpy, surface, target);
}

void (*pfun_gImageTargetTexture2DOES) (GLenum target, void *image);
void mjImageTargetTexture2DOES(GLenum target, void *image)
{
    LOGITAG("mjgl","mjImageTargetTexture2DOES, image=%X, tid=%d", image, gettid());
    return pfun_gImageTargetTexture2DOES(target, image);
}

void (*pfun_glBindRenderbuffer)(GLenum target, GLuint renderbuffer);
void mjBindRenderbuffer (GLenum target, GLuint renderbuffer)
{
    return pfun_glBindRenderbuffer(target, renderbuffer);
}

void (*pfun_glEGLImageTargetRenderbufferStorageOES)(GLenum target, void *image) = NULL;
void mjEGLImageTargetRenderbufferStorageOES(GLenum target, void *image)
{
    return pfun_glEGLImageTargetRenderbufferStorageOES(target, image);
}

void (*pfun_glBindTexture)(GLenum target, GLuint texture) = NULL;
void mjglBindTexture (GLenum target, GLuint texture)
{
//    print_callstack();
    LOGITAG("mjgl", "mjglBindTexture, texid=%d, tid=%d", texture, gettid());
    return pfun_glBindTexture(target, texture);
}

void (*pfun_glBindFramebuffer)(GLenum target, GLuint framebuffer) = NULL;
void mjglBindFramebuffer (GLenum target, GLuint framebuffer)
{
    LOGITAG("mjgl", "mjglBindFramebuffer, framebuffer=%d, tid=%d", framebuffer, gettid());
    return pfun_glBindFramebuffer(target, framebuffer);
}

void (*pfun_glGenTextures)(GLsizei n, GLuint *textures) = NULL;
void mjglGenTextures (GLsizei n, GLuint *textures)
{
    sys_call_stack();
    pfun_glGenTextures(n, textures);
    LOGITAG("mjgl", "mjglGenTextures, texid=%d, tid=%d", textures[0], gettid());
    return;
}

void (*pfun_glDeleteTextures)(GLsizei n, const GLuint *textures) = NULL;
void mjglDeleteTextures (GLsizei n, const GLuint *textures)
{
    pfun_glDeleteTextures(n, textures);
    LOGITAG("mjgl", "mjglDeleteTextures, texid=%d, tid=%d", textures[0], gettid());
    return;
}

void (*pfun_glFramebufferTexture2D)(GLenum target, GLenum attachment, GLenum textarget, GLuint texture, GLint level) = NULL;
void mjglFramebufferTexture2D (GLenum target, GLenum attachment, GLenum textarget, GLuint texture, GLint level)
{
    LOGITAG("mjgl", "mjglFramebufferTexture2D, texid=%d, tid=%d", texture, gettid());
    pfun_glFramebufferTexture2D(target, attachment, textarget, texture, level);
    return;
}

void (*pfun_glGenFramebuffers)(GLsizei n, GLuint *framebuffers) = NULL;
void mjglGenFramebuffers (GLsizei n, GLuint *framebuffers)
{
    pfun_glGenFramebuffers(n, framebuffers);
    LOGITAG("mjgl", "mjglGenFramebuffers, texid=%d, tid=%d", framebuffers[0], gettid());
    return;
}

void (*pfun_glGenRenderbuffers)(GLsizei n, GLuint *renderbuffers) = NULL;
void mjglGenRenderbuffers (GLsizei n, GLuint *renderbuffers)
{
    pfun_glGenRenderbuffers(n, renderbuffers);
    LOGITAG("mjgl", "mjglGenRenderbuffers, texid=%d, tid=%d", renderbuffers[0], gettid());
    return;
}

void (*pfun_glDrawArrays)(GLenum mode, GLint first, GLsizei count) = NULL;
void mjglDrawArrays (GLenum mode, GLint first, GLsizei count)
{
    LOGITAG("mjgl", "mjglDrawArrays, tid=%d", gettid());
    pfun_glDrawArrays(mode, first, count);
    return;
}

void (*pfun_glDrawElements)(GLenum mode, GLsizei count, GLenum type, const void *indices) = NULL;
void mjglDrawElements (GLenum mode, GLsizei count, GLenum type, const void *indices)
{
    LOGITAG("mjgl", "mjglDrawElements, tid=%d", gettid());
    return pfun_glDrawElements(mode, count, type, indices);
}

void (*pfun_glDrawBuffers)(GLsizei n, const GLenum *bufs) = NULL;
void mjglDrawBuffers (GLsizei n, const GLenum *bufs)
{
    LOGITAG("mjgl", "mjglDrawBuffers, tid=%d", gettid());
    return pfun_glDrawBuffers(n, bufs);
}

void (*pfun_glDrawArraysInstanced)(GLenum mode, GLint first, GLsizei count, GLsizei instancecount) = NULL;
void mjglDrawArraysInstanced(GLenum mode, GLint first, GLsizei count, GLsizei instancecount)
{
    LOGITAG("mjgl", "mjglDrawArraysInstanced, tid=%d", gettid());
    return pfun_glDrawArraysInstanced(mode, first, count, instancecount);
}


void (*pfun_glDrawElementsInstanced)(GLenum mode, GLsizei count, GLenum type, const void *indices, GLsizei instancecount) = NULL;
void mjglDrawElementsInstanced (GLenum mode, GLsizei count, GLenum type, const void *indices, GLsizei instancecount)
{
    LOGITAG("mjgl", "mjglDrawElementsInstanced, tid=%d", gettid());
    return pfun_glDrawElementsInstanced(mode, count, type, indices, instancecount);
}

void (*pfun_glTexImage2D)(GLenum target, GLint level, GLint internalformat, GLsizei width, GLsizei height,
                          GLint border, GLenum format, GLenum type, const void *pixels) = NULL;
void mjglTexImage2D (GLenum target, GLint level, GLint internalformat, GLsizei width, GLsizei height, GLint border,
                   GLenum format, GLenum type, const void *pixels)
{
    LOGITAG("mjgl", "pfun_glTexImage2D, tid=%d", gettid());
    return pfun_glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
}

//typedef void (*__eglMustCastToProperFunctionPointerType)(void);
__eglMustCastToProperFunctionPointerType (*old_eglGetProcAddress)(const char *procname) = NULL;
__eglMustCastToProperFunctionPointerType mj_eglGetProcAddress(const char *procname)
{
//    sys_call_stack();
    __eglMustCastToProperFunctionPointerType pfun = old_eglGetProcAddress(procname);
    LOGITAG("mjgl","mj_eglGetProcAddress, procename=%s, tid=%d", procname, gettid());
    if( strcmp(procname, "glEGLImageTargetTexture2DOES") == 0)
    {
        pfun_gImageTargetTexture2DOES = pfun;
        pfun = mjImageTargetTexture2DOES;
    }
    if(strcmp(procname, "glBindRenderbuffer") == 0)
    {
        pfun_glBindRenderbuffer = pfun;
        pfun = mjBindRenderbuffer;
    }
    if( strcmp(procname, "glEGLImageTargetRenderbufferStorageOES") == 0 )
    {
        pfun_glEGLImageTargetRenderbufferStorageOES = pfun;
        pfun = mjEGLImageTargetRenderbufferStorageOES;
    }
    if( strcmp(procname, "glBindTexture") == 0 )
    {
        pfun_glBindTexture = pfun;
        pfun = mjglBindTexture;
    }
    if(strcmp(procname, "glBindFramebuffer") == 0 )
    {
        pfun_glBindFramebuffer = pfun;
        pfun = mjglBindFramebuffer;
    }
    if(strcmp(procname, "glGenTextures") == 0 )
    {
        pfun_glGenTextures = pfun;
        pfun = mjglGenTextures;
    }
    if(strcmp(procname, "glDeleteTextures") == 0)
    {
        pfun_glDeleteTextures = pfun;
        pfun = mjglDeleteTextures;
    }
    if(strcmp(procname, "glFramebufferTexture2D") == 0 )
    {
        pfun_glFramebufferTexture2D = pfun;
        pfun = mjglFramebufferTexture2D;
    }
    if(strcmp(procname, "glGenFramebuffers") == 0 )
    {
        pfun_glGenFramebuffers = pfun;
        pfun = mjglGenFramebuffers;
    }
    if(strcmp(procname, "glGenRenderbuffers") == 0)
    {
        pfun_glGenRenderbuffers = pfun;
        pfun = mjglGenRenderbuffers;
    }
    if(strcmp(procname, "glDrawArrays") == 0)
    {
        pfun_glDrawArrays = pfun;
        pfun = mjglDrawArrays;
    }
    if(strcmp(procname, "glDrawElements") == 0)
    {
        pfun_glDrawElements = pfun;
        pfun = mjglDrawElements;
    }
    if(strcmp(procname, "glDrawBuffers") == 0)
    {
        pfun_glDrawBuffers = pfun;
        pfun = mjglDrawBuffers;
    }
    if(strcmp(procname, "glDrawArraysInstanced") == 0)
    {
        pfun_glDrawArraysInstanced = pfun;
        pfun = mjglDrawArraysInstanced;
    }
    if(strcmp(procname, "glDrawElementsInstanced") == 0)
    {
        pfun_glDrawElementsInstanced = pfun;
        pfun = mjglDrawElementsInstanced;
    }
    if(strcmp(procname, "glTexImage2D") == 0)
    {
        pfun_glTexImage2D = pfun;
        pfun = mjglTexImage2D;
    }
    return pfun;
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


