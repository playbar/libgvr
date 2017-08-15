

#include <stdint.h>
#include "gleshook.h"
#include <GLES2/gl2.h>
#include "inlineHook.h"
#include <android/log.h>

#define LOG_TAG "mjhook"
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN, LOG_TAG, __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

void (*old_glShaderSource) (GLuint shader, GLsizei count, const GLchar* const* string, const GLint* length) = NULL;
void MJ_glShaderSource (GLuint shader, GLsizei count, const GLchar* const* string, const GLint* length)
{
    LOGI("old_glShaderSource");
    return old_glShaderSource(shader, count, string, length);
}

void  (*old_glBindBuffer) (GLenum target, GLuint buffer) = NULL;
void MJ_glBindBuffer (GLenum target, GLuint buffer)
{
    LOGI("MJ_glBindBuffer");
    return old_glBindBuffer(target, buffer);
}

void (*old_glBindBufferRange) (GLenum target, GLuint index, GLuint buffer, GLintptr offset, GLsizeiptr size) = NULL;
void MJ_glBindBufferRange (GLenum target, GLuint index, GLuint buffer, GLintptr offset, GLsizeiptr size)
{
    LOGI("old_glBindBufferRange");
    return old_glBindBufferRange(target, index, buffer, offset, size);
}

void (*old_glBindBufferBase) (GLenum target, GLuint index, GLuint buffer) = NULL;
void MJ_glBindBufferBase (GLenum target, GLuint index, GLuint buffer)
{
    LOGI("old_glBindBufferBase");
    return old_glBindBufferBase(target, index, buffer);
}

void (*old_glBufferData)(GLenum target, GLsizeiptr size, const GLvoid* data, GLenum usage) = NULL;
void MJ_glBufferData (GLenum target, GLsizeiptr size, const GLvoid* data, GLenum usage)
{
    LOGI("old_glBufferData");
    return old_glBufferData(target, size, data, usage);
}

void (*old_glEnableVertexAttribArray) (GLuint index) = NULL;
void MJ_glEnableVertexAttribArray (GLuint index)
{
    LOGI("old_glEnableVertexAttribArray");
    return old_glEnableVertexAttribArray(index);
}

void (*old_glVertexAttribPointer)(GLuint indx, GLint size, GLenum type, GLboolean normalized, GLsizei stride, const GLvoid* ptr) = NULL;
void MJ_glVertexAttribPointer (GLuint indx, GLint size, GLenum type, GLboolean normalized, GLsizei stride, const GLvoid* ptr)
{
    LOGI("old_glVertexAttribPointer");
    return old_glVertexAttribPointer(indx, size, type, normalized, stride, ptr);
}

void (*old_glDrawArrays)(GLenum mode, GLint first, GLsizei count) = NULL;
void MJ_glDrawArrays (GLenum mode, GLint first, GLsizei count)
{
    LOGI("old_glDrawArrays");
    return old_glDrawArrays(mode, first, count);
}

void (*old_glDrawElements)(GLenum mode, GLsizei count, GLenum type, const GLvoid* indices) = NULL;
void NJ_glDrawElements (GLenum mode, GLsizei count, GLenum type, const GLvoid* indices)
{
    LOGI("old_glDrawElements");
    return old_glDrawElements(mode, count, type, indices);
}

int hook(uint32_t target_addr, uint32_t new_addr, uint32_t **proto_addr)
{
    if (registerInlineHook(target_addr, new_addr, proto_addr) != ELE7EN_OK) {
        return -1;
    }
    if (inlineHook((uint32_t) target_addr) != ELE7EN_OK) {
        return -1;
    }

    return 0;
}

int unHook(uint32_t target_addr)
{
    if (inlineUnHook(target_addr) != ELE7EN_OK) {
        return -1;
    }

    return 0;
}

void hookAllFun()
{
    hook((uint32_t) glShaderSource, (uint32_t)MJ_glShaderSource, (uint32_t **) &old_glShaderSource);
    hook((uint32_t) glBindBuffer, (uint32_t)MJ_glBindBuffer, (uint32_t **) &old_glBindBuffer);
//    hook((uint32_t) glBindBufferRange, (uint32_t)MJ_glBindBufferRange, (uint32_t **) &old_glBindBufferRange);
//    hook((uint32_t) glBindBufferBase, (uint32_t)MJ_glBindBufferBase, (uint32_t **) &old_glBindBufferBase);
    hook((uint32_t) glBufferData, (uint32_t)MJ_glBufferData, (uint32_t **) &old_glBufferData);
    hook((uint32_t) glEnableVertexAttribArray, (uint32_t)MJ_glEnableVertexAttribArray, (uint32_t **) &old_glEnableVertexAttribArray);
    hook((uint32_t) glVertexAttribPointer, (uint32_t)MJ_glVertexAttribPointer, (uint32_t **) &old_glVertexAttribPointer);
    hook((uint32_t) glDrawArrays, (uint32_t)MJ_glDrawArrays, (uint32_t **) &old_glDrawArrays);
    hook((uint32_t) glDrawElements, (uint32_t)NJ_glDrawElements, (uint32_t **) &old_glDrawElements);

}

void unhookAllFun()
{
    inlineUnHookAll();
    unHook((uint32_t)glShaderSource);
//    unHook((uint32_t)glBindBuffer);
//    unHook((uint32_t)glBindBufferRange);
//    unHook((uint32_t)glBindBufferBase);
//    unHook((uint32_t)glBufferData);
//    unHook((uint32_t)glEnableVertexAttribArray);
//    unHook((uint32_t)glVertexAttribPointer);
}

JNIEXPORT void JNICALL Java_com_google_hook_GLESHook_initHook(JNIEnv* env, jobject obj)
{
    LOGI("unhookAllFun begin");
//    unhookAllFun();
    LOGI("initHook begin");
    hookAllFun();
    LOGI("initHook after");
}

JNIEXPORT void JNICALL Java_com_google_hook_GLESHook_hookTest(JNIEnv* env, jobject obj)
{

}

JNIEXPORT void JNICALL Java_com_google_hook_GLESHook_unInitHook(JNIEnv* env, jobject obj)
{
    unhookAllFun();
}
