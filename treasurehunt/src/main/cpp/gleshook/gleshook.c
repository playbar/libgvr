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

/////////////////////////////
//gles
void (*old_glShaderSource) (GLuint shader, GLsizei count, const GLchar* const* string, const GLint* length) = NULL;
void MJ_glShaderSource (GLuint shader, GLsizei count, const GLchar* const* string, const GLint* length)
{
    LOGITAG("mjgl","MJ_glShaderSource");
//    for(int i = 0; i < count; ++i){
//        int len = strlen(*string);
//        FILE *pfile = fopen("/sdcard/shader.txt", "wb");
//        fwrite(*string, len, 1, pfile);
//        fflush(pfile);
//        fclose(pfile);
////        LOGITAG("mjgl","shader: %s", *string);
//    }
    return old_glShaderSource(shader, count, string, length);
}

void  (*old_glBindBuffer) (GLenum target, GLuint buffer) = NULL;
void MJ_glBindBuffer (GLenum target, GLuint buffer)
{
    LOGITAG("mjgl","MJ_glBindBuffer, bufferid=%d", buffer);
    return old_glBindBuffer(target, buffer);
}

void (*old_glGenFramebuffers)(GLsizei n, GLuint *framebuffers) = NULL;
void mj_glGenFramebuffers (GLsizei n, GLuint *framebuffers)
{
    LOGITAG("mjgl", "mj_glGenFramebuffers");
    return old_glGenFramebuffers(n, framebuffers);
}

void (*old_glGenRenderbuffers)(GLsizei n, GLuint *renderbuffers) = NULL;
void mj_glGenRenderbuffers (GLsizei n, GLuint *renderbuffers)
{
    LOGITAG("mjgl", "mj_glGenRenderbuffers");
    return old_glGenRenderbuffers(n, renderbuffers);
}

void (*old_glBindFramebuffer)(GLenum target, GLuint framebuffer) = NULL;
void MJ_glBindFramebuffer (GLenum target, GLuint framebuffer)
{
    LOGITAG("mjgl","MJ_glBindFramebuffer, framebuffer=%d, tid=%d", framebuffer, gettid());
    return old_glBindFramebuffer(target, framebuffer);
}



void (*old_glBindRenderbuffer)(GLenum target, GLuint renderbuffer) = NULL;
void MJ_glBindRenderbuffer (GLenum target, GLuint renderbuffer)
{
    LOGITAG("mjgl","MJ_glBindRenderbuffer");
    return old_glBindRenderbuffer(target, renderbuffer);
}

void (*old_glBindBufferRange) (GLenum target, GLuint index, GLuint buffer, GLintptr offset, GLsizeiptr size) = NULL;
void MJ_glBindBufferRange (GLenum target, GLuint index, GLuint buffer, GLintptr offset, GLsizeiptr size)
{
    LOGITAG("mjgl","MJ_glBindBufferRange");
    return old_glBindBufferRange(target, index, buffer, offset, size);
}

void (*old_glBindBufferBase) (GLenum target, GLuint index, GLuint buffer) = NULL;
void MJ_glBindBufferBase (GLenum target, GLuint index, GLuint buffer)
{
    LOGITAG("mjgl","MJ_glBindBufferBase");
    return old_glBindBufferBase(target, index, buffer);
}

void (*old_glBufferData)(GLenum target, GLsizeiptr size, const GLvoid* data, GLenum usage) = NULL;
void MJ_glBufferData (GLenum target, GLsizeiptr size, const GLvoid* data, GLenum usage)
{
    LOGITAG("mjgl","MJ_glBufferData");
//    FILE *pfile = fopen("/sdcard/bufferdata.txt", "wb");
//    fwrite(data, size, 1, pfile);
//    fflush(pfile);
//    fclose(pfile);
    return old_glBufferData(target, size, data, usage);
}

void (*old_glDisableVertexAttribArray) (GLuint index) = NULL;
void MJ_glDisableVertexAttribArray (GLuint index)
{
    LOGITAG("mjgl","MJ_glDisableVertexAttribArray, index=%d", index);
    return old_glDisableVertexAttribArray(index);
}

void (*old_glEnableVertexAttribArray) (GLuint index) = NULL;
void MJ_glEnableVertexAttribArray (GLuint index)
{
    LOGITAG("mjgl","MJ_glEnableVertexAttribArray, index=%d", index);
    return old_glEnableVertexAttribArray(index);
}

void (*old_glVertexAttribPointer)(GLuint indx, GLint size, GLenum type, GLboolean normalized, GLsizei stride, const GLvoid* ptr) = NULL;
void MJ_glVertexAttribPointer (GLuint indx, GLint size, GLenum type, GLboolean normalized, GLsizei stride, const GLvoid* ptr)
{
    LOGITAG("mjgl","MJ_glVertexAttribPointer, indx=%d, size=%d, type=%d, stride=%d, ptr=%d", indx, size, type, stride, ptr);
    return old_glVertexAttribPointer(indx, size, type, normalized, stride, ptr);
}

void (*old_glDrawArrays)(GLenum mode, GLint first, GLsizei count) = NULL;
void MJ_glDrawArrays (GLenum mode, GLint first, GLsizei count)
{
    LOGITAG("mjgl","MJ_glDrawArrays");
    return old_glDrawArrays(mode, first, count);
}

void (*old_glDrawElements)(GLenum mode, GLsizei count, GLenum type, const GLvoid* indices) = NULL;
void MJ_glDrawElements(GLenum mode, GLsizei count, GLenum type, const GLvoid *indices)
{
    LOGITAG("mjgl","MJ_glDrawElements, tid=%d", gettid());
    return old_glDrawElements(mode, count, type, indices);
}

void (*old_glUseProgram) (GLuint program) = NULL;
void MJ_glUseProgram (GLuint program)
{
    LOGITAG("mjgl","MJ_glUseProgram, programid=%d, tid=%d", program, gettid());
    return old_glUseProgram(program);
}

void (*old_glRenderbufferStorage)(GLenum target, GLenum internalformat, GLsizei width, GLsizei height) = NULL;
void MJ_glRenderbufferStorage (GLenum target, GLenum internalformat, GLsizei width, GLsizei height)
{
    LOGITAG("mjgl","MJ_glRenderbufferStorage");
    return old_glRenderbufferStorage(target, internalformat, width, height);
}

void (*old_glFramebufferRenderbuffer)(GLenum target, GLenum attachment, GLenum renderbuffertarget, GLuint renderbuffer) = NULL;
void MJ_glFramebufferRenderbuffer (GLenum target, GLenum attachment, GLenum renderbuffertarget, GLuint renderbuffer)
{
    LOGITAG("mjgl","MJ_glFramebufferRenderbuffer");
    return old_glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer);
}

void (*old_glFramebufferTexture2D) (GLenum target, GLenum attachment, GLenum textarget, GLuint texture, GLint level) = NULL;
void MJ_glFramebufferTexture2D (GLenum target, GLenum attachment, GLenum textarget, GLuint texture, GLint level)
{
    LOGITAG("mjgl","MJ_glFramebufferTexture2D");
    return old_glFramebufferTexture2D(target, attachment, textarget, texture, level);
}

void (*old_glCopyTexSubImage2D)(GLenum target, GLint level, GLint xoffset, GLint yoffset, GLint x, GLint y, GLsizei width, GLsizei height) = NULL;
void MJ_glCopyTexSubImage2D (GLenum target, GLint level, GLint xoffset, GLint yoffset, GLint x, GLint y, GLsizei width, GLsizei height)
{
    LOGITAG("mjgl","MJ_glCopyTexSubImage2D");
    return old_glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height);
}

void hookESFun()
{
    hook((uint32_t) glShaderSource, (uint32_t)MJ_glShaderSource, (uint32_t **) &old_glShaderSource);
    hook((uint32_t) glBindFramebuffer, (uint32_t)MJ_glBindFramebuffer, (uint32_t **) &old_glBindFramebuffer);
    hook((uint32_t) glBindRenderbuffer, (uint32_t)MJ_glBindRenderbuffer, (uint32_t **) &old_glBindRenderbuffer);
    hook((uint32_t) glBindBuffer, (uint32_t)MJ_glBindBuffer, (uint32_t **) &old_glBindBuffer);
    hook((uint32_t) glGenFramebuffers, (uint32_t)mj_glGenFramebuffers, (uint32_t**)&old_glGenFramebuffers);
    hook((uint32_t) glGenRenderbuffers, (uint32_t)mj_glGenRenderbuffers, (uint32_t**)&old_glGenRenderbuffers);
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
}

void hookGLESFun()
{
    hookEGLFun();
    hookEglextFun();
    hookESFun();
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
