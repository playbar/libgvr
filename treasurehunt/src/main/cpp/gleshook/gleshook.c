#include <stdint.h>
#include <GLES2/gl2.h>
#include "callstack.h"
#include <android/log.h>
#include <string.h>
#include <EGL/egl.h>
#include <pthread.h>
#include "hookutils.h"
#include "log.h"

//egl

EGLint (*old_eglGetError)(void) = NULL;
EGLint MJ_eglGetError(void)
{
    LOGI("MJ_eglGetError");
    return old_eglGetError();
}
EGLDisplay (*old_eglGetDisplay)(EGLNativeDisplayType display_id) = NULL;
EGLDisplay MJ_eglGetDisplay(EGLNativeDisplayType display_id)
{
    LOGI("MJ_eglGetDisplay");
    return old_eglGetDisplay(display_id);
}

EGLBoolean (*old_eglInitialize)(EGLDisplay dpy, EGLint *major, EGLint *minor) = NULL;
EGLBoolean MJ_eglInitialize(EGLDisplay dpy, EGLint *major, EGLint *minor)
{
    LOGI("MJ_eglInitialize");
    return old_eglInitialize(dpy, major, minor);
}

EGLBoolean (*old_eglTerminate)(EGLDisplay dpy) = NULL;
EGLBoolean MJ_eglTerminate(EGLDisplay dpy)
{
    LOGI("MJ_eglTerminate");
    return old_eglTerminate(dpy);
}

const char * (*old_eglQueryString)(EGLDisplay dpy, EGLint name) = NULL;
const char * MJ_eglQueryString(EGLDisplay dpy, EGLint name)
{
    LOGI("MJ_eglQueryString");
    return old_eglQueryString(dpy, name);
}

EGLBoolean (*old_eglGetConfigs)(EGLDisplay dpy, EGLConfig *configs, EGLint config_size, EGLint *num_config) = NULL;
EGLBoolean MJ_eglGetConfigs(EGLDisplay dpy, EGLConfig *configs, EGLint config_size, EGLint *num_config)
{
    LOGI("MJ_eglGetConfigs");
    return old_eglGetConfigs(dpy, configs, config_size, num_config);
}

EGLBoolean (*old_eglChooseConfig)(EGLDisplay dpy, const EGLint *attrib_list, EGLConfig *configs, EGLint config_size, EGLint *num_config) = NULL;
EGLBoolean MJ_eglChooseConfig(EGLDisplay dpy, const EGLint *attrib_list, EGLConfig *configs, EGLint config_size, EGLint *num_config)
{
    LOGI("MJ_eglChooseConfig");
    return old_eglChooseConfig(dpy, attrib_list, configs, config_size, num_config);
}

EGLBoolean (*old_eglGetConfigAttrib)(EGLDisplay dpy, EGLConfig config, EGLint attribute, EGLint *value) = NULL;
EGLBoolean MJ_eglGetConfigAttrib(EGLDisplay dpy, EGLConfig config, EGLint attribute, EGLint *value)
{
    LOGI("MJ_eglGetConfigAttrib");
    return old_eglGetConfigAttrib(dpy, config, attribute, value);
}

EGLSurface (*old_eglCreateWindowSurface)(EGLDisplay dpy, EGLConfig config, EGLNativeWindowType win, const EGLint *attrib_list) = NULL;
EGLSurface MJ_eglCreateWindowSurface(EGLDisplay dpy, EGLConfig config, EGLNativeWindowType win, const EGLint *attrib_list)
{
    LOGI("MJ_eglCreateWindowSurface");
    EGLSurface surface = old_eglCreateWindowSurface(dpy, config, win, attrib_list);
    LOGI("eglcreate window=%x", surface);
    return surface;
}

EGLSurface (*old_eglCreatePbufferSurface)(EGLDisplay dpy, EGLConfig config,const EGLint *attrib_list) = NULL;
EGLSurface MJ_eglCreatePbufferSurface(EGLDisplay dpy, EGLConfig config, const EGLint *attrib_list)
{
    LOGI("MJ_eglCreatePbufferSurface");
    EGLSurface surface = old_eglCreatePbufferSurface(dpy, config, attrib_list);
    LOGI("eglcreate pbuffer=%x", surface);
    return surface;
}

EGLSurface (*old_eglCreatePixmapSurface)(EGLDisplay dpy, EGLConfig config, EGLNativePixmapType pixmap, const EGLint *attrib_list) = NULL;
EGLSurface MJ_eglCreatePixmapSurface(EGLDisplay dpy, EGLConfig config, EGLNativePixmapType pixmap, const EGLint *attrib_list)
{
    LOGI("MJ_eglCreatePixmapSurface");
    EGLSurface surface = old_eglCreatePixmapSurface(dpy, config, pixmap, attrib_list);
    LOGI("eglcreate pixmap=%x", surface);
    return surface;
}

EGLBoolean (*old_eglDestroySurface)(EGLDisplay dpy, EGLSurface surface) = NULL;
EGLBoolean MJ_eglDestroySurface(EGLDisplay dpy, EGLSurface surface)
{
    LOGI("MJ_eglDestroySurface");
    return old_eglDestroySurface(dpy, surface);
}

EGLBoolean (*old_eglQuerySurface)(EGLDisplay dpy, EGLSurface surface, EGLint attribute, EGLint *value) = NULL;
EGLBoolean MJ_eglQuerySurface(EGLDisplay dpy, EGLSurface surface, EGLint attribute, EGLint *value)
{
    LOGI("MJ_eglQuerySurface");
    return old_eglQuerySurface(dpy, surface, attribute, value);
}

EGLBoolean (*old_eglBindAPI)(EGLenum api) = NULL;
EGLBoolean MJ_eglBindAPI(EGLenum api)
{
    LOGI("MJ_eglBindAPI");
    return old_eglBindAPI(api);
}

EGLenum (*old_eglQueryAPI)(void) = NULL;
EGLenum MJ_eglQueryAPI(void)
{
    LOGI("MJ_eglQueryAPI");
    return old_eglQueryAPI();
}

EGLBoolean (*old_eglWaitClient)(void) = NULL;
EGLBoolean MJ_eglWaitClient(void)
{
    LOGI("MJ_eglWaitClient");
    return old_eglWaitClient();
}

EGLBoolean (*old_eglReleaseThread)(void) = NULL;
EGLBoolean MJ_eglReleaseThread(void)
{
    LOGI("MJ_eglReleaseThread");
    return old_eglReleaseThread();
}

EGLSurface (*old_eglCreatePbufferFromClientBuffer)(EGLDisplay dpy, EGLenum buftype, EGLClientBuffer buffer,
                                                   EGLConfig config, const EGLint *attrib_list) = NULL;
EGLSurface MJ_eglCreatePbufferFromClientBuffer(EGLDisplay dpy, EGLenum buftype, EGLClientBuffer buffer, EGLConfig config, const EGLint *attrib_list)
{
    LOGI("MJ_eglCreatePbufferFromClientBuffer");
    return old_eglCreatePbufferFromClientBuffer(dpy, buftype, buffer, config, attrib_list);
}

EGLBoolean (*old_eglSurfaceAttrib)(EGLDisplay dpy, EGLSurface surface, EGLint attribute, EGLint value) = NULL;
EGLBoolean MJ_eglSurfaceAttrib(EGLDisplay dpy, EGLSurface surface, EGLint attribute, EGLint value)
{
    LOGI("MJ_eglSurfaceAttrib");
    return old_eglSurfaceAttrib(dpy, surface, attribute, value);
}

EGLBoolean (*old_eglBindTexImage)(EGLDisplay dpy, EGLSurface surface, EGLint buffer) = NULL;
EGLBoolean MJ_eglBindTexImage(EGLDisplay dpy, EGLSurface surface, EGLint buffer)
{
    LOGI("MJ_eglBindTexImage");
    return old_eglBindTexImage(dpy, surface, buffer);
}

EGLBoolean (*old_eglReleaseTexImage)(EGLDisplay dpy, EGLSurface surface, EGLint buffer) = NULL;
EGLBoolean MJ_eglReleaseTexImage(EGLDisplay dpy, EGLSurface surface, EGLint buffer)
{
    LOGI("MJ_eglReleaseTexImage");
    return old_eglReleaseTexImage(dpy, surface, buffer);
}

EGLBoolean (*old_eglSwapInterval)(EGLDisplay dpy, EGLint interval) = NULL;
EGLBoolean MJ_eglSwapInterval(EGLDisplay dpy, EGLint interval)
{
    LOGI("MJ_eglSwapInterval");
    return old_eglSwapInterval(dpy, interval);
}

EGLContext (*old_eglCreateContext)(EGLDisplay dpy, EGLConfig config, EGLContext share_context, const EGLint *attrib_list) = NULL;
EGLContext MJ_eglCreateContext(EGLDisplay dpy, EGLConfig config, EGLContext share_context, const EGLint *attrib_list)
{
    LOGI("MJ_eglCreateContext");
    EGLContext context = old_eglCreateContext(dpy, config, share_context, attrib_list);
    LOGI("eglcreate context=%x", context);
    return context;
}

EGLBoolean (*old_eglDestroyContext)(EGLDisplay dpy, EGLContext ctx) = NULL;
EGLBoolean MJ_eglDestroyContext(EGLDisplay dpy, EGLContext ctx)
{
    LOGI("MJ_eglDestroyContext");
    return old_eglDestroyContext(dpy, ctx);
}

EGLBoolean (*old_eglMakeCurrent)(EGLDisplay dpy, EGLSurface draw, EGLSurface read, EGLContext ctx) = NULL;
EGLBoolean MJ_eglMakeCurrent(EGLDisplay dpy, EGLSurface draw, EGLSurface read, EGLContext ctx)
{
    LOGI("MJ_eglMakeCurrent");
    LOGI("eglcreate draw=%x, read=%x, context=%x", draw, read, ctx);
    return old_eglMakeCurrent(dpy, draw, read, ctx);
}

EGLContext (*old_eglGetCurrentContext)(void) = NULL;
EGLContext MJ_eglGetCurrentContext(void)
{
    LOGI("MJ_eglGetCurrentContext");
    return old_eglGetCurrentContext();
}

EGLSurface (*old_eglGetCurrentSurface)(EGLint readdraw) = NULL;
EGLSurface MJ_eglGetCurrentSurface(EGLint readdraw)
{
    LOGI("MJ_eglGetCurrentSurface");
    return old_eglGetCurrentSurface(readdraw);
}

EGLDisplay (*old_eglGetCurrentDisplay)(void) = NULL;
EGLDisplay MJ_eglGetCurrentDisplay(void)
{
    LOGI("MJ_eglGetCurrentDisplay");
    return old_eglGetCurrentDisplay();
}

EGLBoolean (*old_eglQueryContext)(EGLDisplay dpy, EGLContext ctx, EGLint attribute, EGLint *value) = NULL;
EGLBoolean MJ_eglQueryContext(EGLDisplay dpy, EGLContext ctx, EGLint attribute, EGLint *value)
{
    LOGI("MJ_eglQueryContext");
    return old_eglQueryContext(dpy, ctx, attribute, value);
}

EGLBoolean (*old_eglWaitGL)(void) = NULL;
EGLBoolean MJ_eglWaitGL(void)
{
    LOGI("MJ_eglWaitGL");
    return old_eglWaitGL();
}

EGLBoolean (*old_eglWaitNative)(EGLint engine) = NULL;
EGLBoolean MJ_eglWaitNative(EGLint engine)
{
    LOGI("MJ_eglWaitNative");
    return old_eglWaitNative(engine);
}

EGLBoolean (*old_eglSwapBuffers)(EGLDisplay dpy, EGLSurface surface) = NULL;
EGLBoolean MJ_eglSwapBuffers(EGLDisplay dpy, EGLSurface surface)
{
    LOGI("MJ_eglSwapBuffers");
    return old_eglSwapBuffers(dpy, surface);
}

EGLBoolean (*old_eglCopyBuffers)(EGLDisplay dpy, EGLSurface surface, EGLNativePixmapType target) = NULL;
EGLBoolean MJ_eglCopyBuffers(EGLDisplay dpy, EGLSurface surface, EGLNativePixmapType target)
{
    LOGI("MJ_eglCopyBuffers");
    return MJ_eglCopyBuffers(dpy, surface, target);
}

/////////////////////////////
//gles
void (*old_glShaderSource) (GLuint shader, GLsizei count, const GLchar* const* string, const GLint* length) = NULL;
void MJ_glShaderSource (GLuint shader, GLsizei count, const GLchar* const* string, const GLint* length)
{
    LOGI("MJ_glShaderSource");
    for(int i = 0; i < count; ++i){
        int len = strlen(*string);
        FILE *pfile = fopen("/sdcard/shader.txt", "wb");
        fwrite(*string, len, 1, pfile);
        fflush(pfile);
        fclose(pfile);
//        LOGI("shader: %s", *string);
    }
    return old_glShaderSource(shader, count, string, length);
}

void  (*old_glBindBuffer) (GLenum target, GLuint buffer) = NULL;
void MJ_glBindBuffer (GLenum target, GLuint buffer)
{
    LOGI("MJ_glBindBuffer, bufferid=%d", buffer);
    return old_glBindBuffer(target, buffer);
}

void (*old_glBindFramebuffer)(GLenum target, GLuint framebuffer) = NULL;
void MJ_glBindFramebuffer (GLenum target, GLuint framebuffer)
{
    LOGI("MJ_glBindFramebuffer, framebuffer=%d", framebuffer);
    return old_glBindFramebuffer(target, framebuffer);
}



void (*old_glBindRenderbuffer)(GLenum target, GLuint renderbuffer) = NULL;
void MJ_glBindRenderbuffer (GLenum target, GLuint renderbuffer)
{
    LOGI("MJ_glBindRenderbuffer");
    return old_glBindRenderbuffer(target, renderbuffer);
}

void (*old_glBindBufferRange) (GLenum target, GLuint index, GLuint buffer, GLintptr offset, GLsizeiptr size) = NULL;
void MJ_glBindBufferRange (GLenum target, GLuint index, GLuint buffer, GLintptr offset, GLsizeiptr size)
{
    LOGI("MJ_glBindBufferRange");
    return old_glBindBufferRange(target, index, buffer, offset, size);
}

void (*old_glBindBufferBase) (GLenum target, GLuint index, GLuint buffer) = NULL;
void MJ_glBindBufferBase (GLenum target, GLuint index, GLuint buffer)
{
    LOGI("MJ_glBindBufferBase");
    return old_glBindBufferBase(target, index, buffer);
}

void (*old_glBufferData)(GLenum target, GLsizeiptr size, const GLvoid* data, GLenum usage) = NULL;
void MJ_glBufferData (GLenum target, GLsizeiptr size, const GLvoid* data, GLenum usage)
{
    LOGI("MJ_glBufferData");
    FILE *pfile = fopen("/sdcard/bufferdata.txt", "wb");
    fwrite(data, size, 1, pfile);
    fflush(pfile);
    fclose(pfile);
    return old_glBufferData(target, size, data, usage);
}

void (*old_glDisableVertexAttribArray) (GLuint index) = NULL;
void MJ_glDisableVertexAttribArray (GLuint index)
{
    LOGI("MJ_glDisableVertexAttribArray, index=%d", index);
    return old_glDisableVertexAttribArray(index);
}

void (*old_glEnableVertexAttribArray) (GLuint index) = NULL;
void MJ_glEnableVertexAttribArray (GLuint index)
{
    LOGI("MJ_glEnableVertexAttribArray, index=%d", index);
    return old_glEnableVertexAttribArray(index);
}

void (*old_glVertexAttribPointer)(GLuint indx, GLint size, GLenum type, GLboolean normalized, GLsizei stride, const GLvoid* ptr) = NULL;
void MJ_glVertexAttribPointer (GLuint indx, GLint size, GLenum type, GLboolean normalized, GLsizei stride, const GLvoid* ptr)
{
    LOGI("MJ_glVertexAttribPointer, indx=%d, size=%d, type=%d, stride=%d, ptr=%d", indx, size, type, stride, ptr);
    return old_glVertexAttribPointer(indx, size, type, normalized, stride, ptr);
}

void (*old_glDrawArrays)(GLenum mode, GLint first, GLsizei count) = NULL;
void MJ_glDrawArrays (GLenum mode, GLint first, GLsizei count)
{
    LOGI("MJ_glDrawArrays");
    return old_glDrawArrays(mode, first, count);
}

void (*old_glDrawElements)(GLenum mode, GLsizei count, GLenum type, const GLvoid* indices) = NULL;
void MJ_glDrawElements(GLenum mode, GLsizei count, GLenum type, const GLvoid *indices)
{
    LOGI("MJ_glDrawElements");
    return old_glDrawElements(mode, count, type, indices);
}

void (*old_glUseProgram) (GLuint program) = NULL;
void MJ_glUseProgram (GLuint program)
{
    LOGI("MJ_glUseProgram, programid=%d", program);
    return old_glUseProgram(program);
}

void (*old_glRenderbufferStorage)(GLenum target, GLenum internalformat, GLsizei width, GLsizei height) = NULL;
void MJ_glRenderbufferStorage (GLenum target, GLenum internalformat, GLsizei width, GLsizei height)
{
    LOGI("MJ_glRenderbufferStorage");
    return old_glRenderbufferStorage(target, internalformat, width, height);
}

void (*old_glFramebufferRenderbuffer)(GLenum target, GLenum attachment, GLenum renderbuffertarget, GLuint renderbuffer) = NULL;
void MJ_glFramebufferRenderbuffer (GLenum target, GLenum attachment, GLenum renderbuffertarget, GLuint renderbuffer)
{
    LOGI("MJ_glFramebufferRenderbuffer");
    return old_glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer);
}

void (*old_glFramebufferTexture2D) (GLenum target, GLenum attachment, GLenum textarget, GLuint texture, GLint level) = NULL;
void MJ_glFramebufferTexture2D (GLenum target, GLenum attachment, GLenum textarget, GLuint texture, GLint level)
{
    LOGI("MJ_glFramebufferTexture2D");
    return old_glFramebufferTexture2D(target, attachment, textarget, texture, level);
}

void (*old_glCopyTexSubImage2D)(GLenum target, GLint level, GLint xoffset, GLint yoffset, GLint x, GLint y, GLsizei width, GLsizei height) = NULL;
void MJ_glCopyTexSubImage2D (GLenum target, GLint level, GLint xoffset, GLint yoffset, GLint x, GLint y, GLsizei width, GLsizei height)
{
    LOGI("MJ_glCopyTexSubImage2D");
    return old_glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height);
}


void hookGLESFun()
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
    /////////////////
    hook((uint32_t) glShaderSource, (uint32_t)MJ_glShaderSource, (uint32_t **) &old_glShaderSource);
    hook((uint32_t) glBindFramebuffer, (uint32_t)MJ_glBindFramebuffer, (uint32_t **) &old_glBindFramebuffer);
    hook((uint32_t) glBindRenderbuffer, (uint32_t)MJ_glBindRenderbuffer, (uint32_t **) &old_glBindRenderbuffer);
    hook((uint32_t) glBindBuffer, (uint32_t)MJ_glBindBuffer, (uint32_t **) &old_glBindBuffer);
//    hook((uint32_t) glBindBufferRange, (uint32_t)MJ_glBindBufferRange, (uint32_t **) &old_glBindBufferRange);
//    hook((uint32_t) glBindBufferBase, (uint32_t)MJ_glBindBufferBase, (uint32_t **) &old_glBindBufferBase);
    hook((uint32_t) glBufferData, (uint32_t)MJ_glBufferData, (uint32_t **) &old_glBufferData);
    hook((uint32_t) glDisableVertexAttribArray, (uint32_t)MJ_glDisableVertexAttribArray, (uint32_t **) &old_glDisableVertexAttribArray);
    hook((uint32_t) glEnableVertexAttribArray, (uint32_t)MJ_glEnableVertexAttribArray, (uint32_t **) &old_glEnableVertexAttribArray);
    hook((uint32_t) glVertexAttribPointer, (uint32_t)MJ_glVertexAttribPointer, (uint32_t **) &old_glVertexAttribPointer);
    hook((uint32_t) glDrawArrays, (uint32_t)MJ_glDrawArrays, (uint32_t **) &old_glDrawArrays);
    hook((uint32_t) glDrawElements, (uint32_t)MJ_glDrawElements, (uint32_t **) &old_glDrawElements);
    hook((uint32_t) glUseProgram, (uint32_t)MJ_glUseProgram, (uint32_t **) &old_glUseProgram);
    hook((uint32_t) glRenderbufferStorage, (uint32_t)MJ_glRenderbufferStorage, (uint32_t **) &old_glRenderbufferStorage);
    hook((uint32_t) glFramebufferRenderbuffer, (uint32_t)MJ_glFramebufferRenderbuffer, (uint32_t **) &old_glFramebufferRenderbuffer);
    hook((uint32_t) glFramebufferTexture2D, (uint32_t)MJ_glFramebufferTexture2D, (uint32_t **) &old_glFramebufferTexture2D);
    hook((uint32_t) glCopyTexSubImage2D, (uint32_t)MJ_glCopyTexSubImage2D, (uint32_t **) &old_glCopyTexSubImage2D);

    return;
}

void unhookAllFun()
{
    inlineUnHookAll();
//    unHook((uint32_t)glShaderSource);
//    unHook((uint32_t)glBindBuffer);
//    unHook((uint32_t)glBindBufferRange);
//    unHook((uint32_t)glBindBufferBase);
//    unHook((uint32_t)glBufferData);
//    unHook((uint32_t)glEnableVertexAttribArray);
//    unHook((uint32_t)glVertexAttribPointer);
}
