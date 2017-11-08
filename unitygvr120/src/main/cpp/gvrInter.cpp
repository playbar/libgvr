//
// Created by houguoli on 2017/1/3.
//

#include <GLES3/gl3.h>
#include "gvrInter.h"
#include "gvrfn.h"
#include "gvrglobal.h"
#include "LogMessage.h"
#include "map"

std::map<gvr_buffer_viewport*, int> ViewportMap;

//ClassLoader paramClassLoader, Context paramContext)
JNIEXPORT long JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetApplicationState(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext)
{
    CLogMessage msg(__FUNCTION__);
    long re = gGvrApi.CardboardViewNativeImpl_nativeSetApplicationState( env,obj, paramClassLoader, paramContext);
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetScreenParams(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1,
        jfloat paramFloat2, jfloat paramFloat3)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeSetScreenParams(env, obj, paramLong, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3);
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetNeckModelFactor(
        JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeSetNeckModelFactor(env, obj, paramLong, paramFloat);
}
JNIEXPORT float JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeGetNeckModelFactor(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.CardboardViewNativeImpl_nativeGetNeckModelFactor(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeOnDrawFrame(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeOnDrawFrame(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetNeckModelEnabled(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean )
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeSetNeckModelEnabled(env,obj, paramLong, paramBoolean);
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeDestroy(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeOnSurfaceCreated(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeOnSurfaceCreated(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeOnSurfaceChanged(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeOnSurfaceChanged(env, obj, paramLong, paramInt1, paramInt2);
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetStereoModeEnabled(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeSetStereoModeEnabled(env, obj, paramLong, paramBoolean);
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled(env, obj, paramLong, paramBoolean);
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetDistortionCorrectionScale(
        JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeSetDistortionCorrectionScale(env, obj,paramLong, paramFloat);
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetMultisampling(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeSetMultisampling(env, obj, paramLong, paramInt);
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetDepthStencilFormat(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeSetDepthStencilFormat(env, obj, paramLong, paramInt);
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeUndistortTexture(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeUndistortTexture(env, obj, paramLong, paramInt);
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeLogEvent(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeLogEvent(env, obj, paramLong, paramInt);
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetGvrViewerParams(
        JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeSetGvrViewerParams(env, obj, paramLong, paramArrayOfByte);
}
//GvrView.StereoRenderer paramStereoRenderer
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetStereoRenderer(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramStereoRenderer)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeSetStereoRenderer(env, obj, paramLong, paramStereoRenderer);
}
//GvrView.Renderer
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetRenderer(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramRenderer)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeSetRenderer(env, obj, paramLong, paramRenderer);
}

//HeadTransform paramHeadTransform, Eye paramEye1, Eye paramEye2, Eye paramEye3, Eye paramEye4, Eye paramEye
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeGetCurrentEyeParams(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramHeadTransform, jobject paramEye1, jobject paramEye2,
        jobject paramEye3, jobject paramEye4, jobject paramEye5)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.CardboardViewNativeImpl_nativeGetCurrentEyeParams(env, obj, paramLong, paramHeadTransform, paramEye1, paramEye2, paramEye3, paramEye4, paramEye5);
}
JNIEXPORT long JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeInit(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.CardboardViewNativeImpl_nativeInit(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleStateChanged(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2 )
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.NativeCallbacks_handleStateChanged(env, obj, paramLong, paramInt1, paramInt2);
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleControllerRecentered(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2,
        jfloat paramFloat3, jfloat paramFloat4)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.NativeCallbacks_handleControllerRecentered(env, obj, paramLong1, paramLong2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleTouchEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt, jfloat paramFloat1, jfloat paramFloat2)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.NativeCallbacks_handleTouchEvent(env, obj, paramLong1, paramLong2, paramInt, paramFloat1, paramFloat2);
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleOrientationEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.NativeCallbacks_handleOrientationEvent(env, obj, paramLong1, paramLong2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
}

JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handlePositionEvent(
        JNIEnv* env, jobject obj, jlong arv1, jlong var3, jlong var5, jlong var6, jfloat var7)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.NativeCallbacks_handlePositionEvent(env, obj, arv1, var3, var5, var6, var7);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleButtonEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt, jboolean paramBoolean)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.NativeCallbacks_handleButtonEvent(env, obj, paramLong1, paramLong2, paramInt, paramBoolean);
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleAccelEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.NativeCallbacks_handleAccelEvent( env, obj, paramLong1, paramLong2, paramFloat1, paramFloat2, paramFloat3);
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleGyroEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.NativeCallbacks_handleGyroEvent(env, obj, paramLong1, paramLong2, paramFloat1, paramFloat2, paramFloat3);
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceInitFailed(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.NativeCallbacks_handleServiceInitFailed(env, obj, paramLong, paramInt);
}
JNIEXPORT void JNICALL  Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceFailed(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.NativeCallbacks_handleServiceFailed(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceUnavailable(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.NativeCallbacks_handleServiceUnavailable(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceConnected(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.NativeCallbacks_handleServiceConnected(env, obj, paramLong, paramInt);
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceDisconnected(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.NativeCallbacks_handleServiceDisconnected(env, obj, paramLong);
}

JNIEXPORT void JNICALL Java_com_google_vr_cardboard_VrParamsProviderJni_nativeUpdateNativePhoneParamsPointer(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1, jfloat paramFloat2)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.VrParamsProviderJni_nativeUpdateNativePhoneParamsPointer(env, obj, paramLong, paramInt1, paramInt2, paramFloat1, paramFloat2);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeRecenterTracking(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeRecenterTracking(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetEyeFromHeadMatrix(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jfloatArray paramArrayOfFloat)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeGetEyeFromHeadMatrix(env, obj, paramLong, paramInt, paramArrayOfFloat);
}

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetViewerType(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    LOGI("mjgvr env:%0x, obj:%0X, paramLong:%lld", env, obj, paramLong);
    int re = 0;
    re = gGvrApi.GvrApi_nativeGetViewerType(env, obj, paramLong);
    LOGI("mjgvr F:%s, bool:%d", __FUNCTION__, re );
    return re;
}
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBool)
{
    CLogMessage msg(__FUNCTION__);
    LOGI("mjgvr env:%0x, obj:%0X, paramLong:%lld, paramBool:%d", env, obj, paramLong, paramBool);
    bool re = true;
    re = gGvrApi.GvrApi_nativeSetAsyncReprojectionEnabled(env, obj, paramLong, paramBool);
//    re = true;
    LOGI("mjgvr F:%s, bool:%d", __FUNCTION__, re );
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetHeadSpaceFromStartSpaceRotation(
        JNIEnv* env, jobject obj, jlong paramLong1, jfloatArray paramArrayOfFloat, jlong paramLong2)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeGetHeadSpaceFromStartSpaceRotation(env, obj, paramLong1, paramArrayOfFloat, paramLong2);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetIgnoreManualPauseResumeTracker(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean)
{
    CLogMessage msg(__FUNCTION__);
    LOGI("mjgvr env:%0x, obj:%0X, paramLong:%lld, paramBoolean:%d", env, obj, paramLong, paramBoolean);
    gGvrApi.GvrApi_nativeSetIgnoreManualPauseResumeTracker(env, obj, paramLong, paramBoolean);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeResetTracking(JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeResetTracking(env, obj, paramLong);
}

JNIEXPORT jobject JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeRenderReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    glBindFramebuffer(GL_FRAMEBUFFER, 0 );
    jobject re = gGvrApi.GvrApi_nativeRenderReprojectionThread(env, obj, paramLong);
    return NULL;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeRequestContextSharing(
        JNIEnv* env, jobject obj, jlong var1, jobject var3)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeRequestContextSharing(env, obj, var1, var3);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeOnPauseReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeOnPauseReprojectionThread(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDefaultFramebufferActive(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeSetDefaultFramebufferActive(env, obj, paramLong);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetScreenBufferViewports(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2 )
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeGetScreenBufferViewports(env, obj, paramLong1, paramLong2);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetMaximumEffectiveRenderTargetSize(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeGetMaximumEffectiveRenderTargetSize(env, obj, paramLong, paramPoint);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetScreenTargetSize(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint )
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeGetScreenTargetSize(env, obj, paramLong, paramPoint);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeDistortToScreen(
        JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2, jfloatArray paramArrayOfFloat, jlong paramLong3)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeDistortToScreen(env, obj, paramLong1, paramInt, paramLong2, paramArrayOfFloat, paramLong3);
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListGetSize(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeBufferViewportListGetSize(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListGetItem(
        JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferViewportListGetItem(env, obj, paramLong1, paramInt, paramLong2);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListSetItem(
        JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferViewportListSetItem(env, obj, paramLong1, paramInt, paramLong2);
}

JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportCreate(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeBufferViewportCreate(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeRemoveAllSurfacesReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeRemoveAllSurfacesReprojectionThread(env, obj, paramLong);
}
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUsingVrDisplayService(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    bool re = true;
    re = gGvrApi.GvrApi_nativeUsingVrDisplayService(env, obj, paramLong);
    LOGI("mjgvr F:%s, bool:%d", __FUNCTION__, re );
    return re;
}

JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListCreate(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeBufferViewportListCreate(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferViewportListDestroy(env, obj, paramLong);
}

JNIEXPORT float JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetBorderSizeMeters(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeGetBorderSizeMeters(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetSurfaceSize(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeSetSurfaceSize(env, obj, paramLong, paramInt1, paramInt2);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetLensOffset(
        JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat1, jfloat paramFloat2)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeSetLensOffset(env, obj, paramLong, paramFloat1, paramFloat2);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUpdateSurfaceReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt1, jint paramInt2, jlong paramLong2, jfloatArray paramArrayOfFloat)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeUpdateSurfaceReprojectionThread(env, obj, paramLong1, paramInt1, paramInt2, paramLong2, paramArrayOfFloat);
}
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetAsyncReprojectionEnabled(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeGetAsyncReprojectionEnabled(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeReconnectSensors(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeReconnectSensors(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDisplayMetrics(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1, jfloat paramFloat2)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeSetDisplayMetrics(env, obj, paramLong, paramInt1, paramInt2, paramFloat1, paramFloat2);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDynamicLibraryLoadingEnabled(
        JNIEnv* env, jobject obj, jboolean var1)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeSetDynamicLibraryLoadingEnabled(env, obj, var1);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeReset(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jlong paramLong3)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.DisplaySynchronizer_nativeReset(env, obj, paramLong1, paramLong2, paramLong3);
}
JNIEXPORT void JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeUpdate(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    glBindFramebuffer(GL_FRAMEBUFFER, 0);
    gGvrApi.DisplaySynchronizer_nativeUpdate(env, obj, paramLong1, paramLong2, paramInt);
}

//ClassLoader paramClassLoader, Context paramContext
JNIEXPORT long JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.DisplaySynchronizer_nativeCreate(env, obj, paramClassLoader, paramContext);
}
JNIEXPORT void JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.DisplaySynchronizer_nativeDestroy(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeDumpDebugData(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeDumpDebugData(env, obj, paramLong);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeInitializeGl(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeInitializeGl(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeOnSurfaceCreatedReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeOnSurfaceCreatedReprojectionThread(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetRecommendedBufferViewports(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeGetRecommendedBufferViewports(env, obj, paramLong1, paramLong2);
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetError(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeGetError(env, obj, paramLong);
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeClearError(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeClearError(env, obj, paramLong);
}
JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetUserPrefs(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeGetUserPrefs(env, obj, paramLong);
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUserPrefsGetControllerHandedness(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeUserPrefsGetControllerHandedness(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativePause(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativePause(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeResume(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeResume(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeReleaseGvrContext(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeReleaseGvrContext(env, obj, paramLong);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferViewportDestroy(env, obj, paramLong);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetSourceUv(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramRectF)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferViewportGetSourceUv(env, obj, paramLong, paramRectF);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceUv(
        JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferViewportSetSourceUv(env, obj, paramLong, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetSourceFov(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramRectF)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferViewportGetSourceFov(env, obj, paramLong, paramRectF);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceFov(
        JNIEnv* env, jobject obj,  jlong paramLong, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4 )
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferViewportSetSourceFov(env, obj, paramLong, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
}

// static native void nativeBufferViewportGetTransform(long paramLong, float[] paramArrayOfFloat);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetTransform(
        JNIEnv* env, jobject obj, jlong paramLong, jfloatArray paramArrayOffloat)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferViewportGetTransform(env, obj, paramLong, paramArrayOffloat);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetTransform(
        JNIEnv* env, jobject obj, jlong paramLong, jfloatArray paramArrayOfFloat)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferViewportSetTransform(env, obj, paramLong, paramArrayOfFloat);
}

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetTargetEye(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeBufferViewportGetTargetEye(env, obj, paramLong);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetTargetEye(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferViewportSetTargetEye(env, obj, paramLong, paramInt);
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetSourceBufferIndex(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeBufferViewportGetSourceBufferIndex(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceBufferIndex(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferViewportSetSourceBufferIndex(env, obj, paramLong, paramInt);
}

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetExternalSurfaceId(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeBufferViewportGetExternalSurfaceId(env, obj, paramLong);
}

JNIEXPORT void JNICALL  Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetExternalSurfaceId(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferViewportSetExternalSurfaceId(env, obj, paramLong, paramInt);
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetReprojection(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeBufferViewportGetReprojection(env, obj, paramLong);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetReprojection(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferViewportSetReprojection(env, obj, paramLong, paramInt);
}
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportEqual(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeBufferViewportEqual(env, obj, paramLong1, paramLong2);
}

JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecCreate(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeBufferSpecCreate(env, obj, paramLong);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferSpecDestroy(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecGetSize(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferSpecGetSize(env, obj, paramLong, paramPoint);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetSize(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jint paramInt2)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferSpecSetSize(env, obj, paramLong, paramInt, paramInt2);
}

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecGetSamples(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeBufferSpecGetSamples(env, obj, paramLong);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetSamples(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferSpecSetSamples(env, obj, paramLong, paramInt);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetColorFormat(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferSpecSetColorFormat(env, obj, paramLong, paramInt);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetDepthStencilFormat(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeBufferSpecSetDepthStencilFormat(env, obj, paramLong, paramInt);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeSwapChainDestroy(env, obj, paramLong);
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainGetBufferCount(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeSwapChainGetBufferCount(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainGetBufferSize(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jobject paramPoint)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeSwapChainGetBufferSize(env, obj, paramLong, paramInt, paramPoint);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainResizeBuffer(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jint paramInt3)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeSwapChainResizeBuffer(env, obj, paramLong, paramInt1, paramInt2, paramInt3);
}
JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainAcquireFrame(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeSwapChainAcquireFrame(env, obj, paramLong);
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameBindBuffer(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeFrameBindBuffer(env, obj, paramLong, paramInt);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameUnbind(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeFrameUnbind(env, obj, paramLong);
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameGetFramebufferObject(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeFrameGetFramebufferObject(env, obj, paramLong, paramInt);
}
//todo
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameGetBufferSize(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jobject paramPoint)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeFrameGetBufferSize(env, obj, paramLong, paramInt, paramPoint);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameSubmit(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloatArray paramArrayOfFloat)
{
    CLogMessage msg(__FUNCTION__);
    glBindFramebuffer(GL_FRAMEBUFFER, 0);
    gGvrApi.GvrApi_nativeFrameSubmit(env, obj, paramLong1, paramLong2, paramArrayOfFloat);
}
//todo
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeResumeTracking(
        JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.GvrApi_nativeResumeTracking(env, obj, paramLong, paramArrayOfByte);
}
//todo
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDefaultViewerProfile(
        JNIEnv* env, jobject obj, jlong paramLong, jstring paramString)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeSetDefaultViewerProfile(env, obj, paramLong, paramString);
}
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetViewerParams(
        JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeSetViewerParams(env, obj, paramLong, paramArrayOfByte);
}
JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainCreate(
        JNIEnv* env, jobject obj, jlong paramLong, jlongArray paramArrayOfLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeSwapChainCreate(env, obj, paramLong, paramArrayOfLong);
}


JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeCreate(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext, jlong paramLong, jint paramInt1,
        jint paramInt2, jfloat paramFloat1, jfloat paramFloat2, jobject paramPoseTracker)
{
//    LOGE("Java_com_google_vr_ndk_base_GvrApi_nativeCreate");
    CLogMessage msg(__FUNCTION__);
    int i1 = paramInt1;
    int i2 = paramInt2;
    float f1 = paramFloat1;
    float f2 = paramFloat2;
    LOGI("mjgvr env:%0x, obj:%0X, paramClassLoader:%0X, paramContext:%0X, paramLong:%lld paramInt1:%d, paramInt2:%d, paramFloat1:%f, paramFloat2:%f, paramPoseTracker:%0X",
         env, obj, paramClassLoader,paramContext, paramLong, i1, i2, f1, f2, paramPoseTracker  );
    return gGvrApi.GvrApi_nativeCreate(env, obj, paramClassLoader, paramContext, paramLong, paramInt1, paramInt2, paramFloat1, paramFloat2, paramPoseTracker);
}
JNIEXPORT jfloatArray JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeComputeDistortedPoint(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jfloatArray paramArrayOfFloat)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeComputeDistortedPoint(env, obj, paramLong, paramInt, paramArrayOfFloat);
}

JNIEXPORT jstring JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetErrorString(
        JNIEnv* env, jobject obj, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeGetErrorString(env, obj, paramInt);
    //return env->NewStringUTF("Hello from JNI!");
}

JNIEXPORT jstring JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetViewerVendor(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeGetViewerVendor(env, obj, paramLong);
     // /return env->NewStringUTF("Hello from JNI!");
}

JNIEXPORT jstring JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetViewerModel(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeGetViewerModel(env, obj, paramLong);
     //return env->NewStringUTF("Hello from JNI!");
}

JNIEXPORT jbyteArray JNICALL Java_com_google_vr_ndk_base_GvrApi_nativePauseTracking(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativePauseTracking(env, obj, paramLong);
}

JNIEXPORT jintArray JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetWindowBounds(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.GvrApi_nativeGetWindowBounds(env, obj, paramLong);
}


void gvr_buffer_viewport_list_destroy(gvr_buffer_viewport_list **viewport_list)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.buffer_viewport_list_destroy(viewport_list);
}

void gvr_swap_chain_destroy(gvr_swap_chain **swap_chain)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.swap_chain_destroy(swap_chain);
}

void gvr_destroy(gvr_context **gvr)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.destroy(gvr);
}

void gvr_buffer_viewport_destroy(gvr_buffer_viewport **viewport)
{
    CLogMessage msg(__FUNCTION__);
    std::map<gvr_buffer_viewport*, int>::iterator iter = ViewportMap.find(*viewport);
    if( iter != ViewportMap.end()) {
        ViewportMap.erase(iter);
    }
    gGvrApi.buffer_viewport_destroy(viewport);
}

gvr_swap_chain * gvr_swap_chain_create(gvr_context *gvr, const gvr_buffer_spec **buffers, int32_t count)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.swap_chain_create(gvr, buffers, count);
}

void gvr_bind_default_framebuffer(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
//    getimagebase();
    gGvrApi.bind_default_framebuffer(gvr);
}

gvr_sizei gvr_get_maximum_effective_render_target_size(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.get_maximum_effective_render_target_size(gvr);
}

void gvr_buffer_spec_set_samples(gvr_buffer_spec *spec, int32_t num_samples)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.buffer_spec_set_samples(spec, num_samples);
}

void gvr_buffer_spec_set_depth_stencil_format(gvr_buffer_spec *spec, int32_t depth_stencil_format)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.buffer_spec_set_depth_stencil_format(spec, depth_stencil_format);
}

void gvr_buffer_spec_set_size(gvr_buffer_spec *spec, gvr_sizei size)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.buffer_spec_set_size(spec, size);
}

gvr_buffer_spec * gvr_buffer_spec_create(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.buffer_spec_create(gvr);
}

void gvr_initialize_gl(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.initialize_gl(gvr);
}

void gvr_distort_to_screen(
        gvr_context *gvr,
        int32_t texture_id,
        const gvr_buffer_viewport_list *viewport_list,
        gvr_mat4f head_space_from_start_space,
        gvr_clock_time_point target_presentation_time)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.distort_to_screen(gvr, texture_id, viewport_list, head_space_from_start_space, target_presentation_time);
}

gvr_clock_time_point gvr_get_time_point_now()
{
//    gvr_clock_time_point re;
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.get_time_point_now();
}


void gvr_buffer_spec_destroy(gvr_buffer_spec **spec)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.buffer_spec_destroy(spec);
}

gvr_mat4f gvr_get_eye_from_head_matrix(const gvr_context *gvr, const int32_t eye)
{
//    gvr_mat4f re;
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.get_eye_from_head_matrix(gvr, eye);
}

gvr_sizei gvr_swap_chain_get_buffer_size(gvr_swap_chain *swap_chain, int32_t index)
{
//    gvr_sizei re;
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.swap_chain_get_buffer_size(swap_chain, index);
}

void gvr_compute_distorted_point(
        const gvr_context *gvr,
        const int32_t eye,
        const gvr_vec2f uv_in,
        gvr_vec2f uv_out[3])
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.compute_distorted_point(gvr, eye, uv_in, uv_out);
}

void gvr_get_recommended_buffer_viewports(const gvr_context *gvr, gvr_buffer_viewport_list *viewport_list)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.get_recommended_buffer_viewports(gvr, viewport_list);
}

bool gvr_buffer_viewport_equal(const gvr_buffer_viewport *a, const gvr_buffer_viewport *b)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.buffer_viewport_equal(a, b);
}

void gvr_buffer_viewport_list_get_item(const gvr_buffer_viewport_list *viewport_list, size_t index, gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.buffer_viewport_list_get_item(viewport_list, index, viewport);
}

gvr_sizei gvr_buffer_spec_get_size(const gvr_buffer_spec *spec)
{
//    gvr_sizei re;
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.buffer_spec_get_size(spec);
}

int32_t gvr_buffer_viewport_get_target_eye(const gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.buffer_viewport_get_target_eye(viewport);
}

gvr_mat4f gvr_buffer_viewport_get_transform(
        const gvr_buffer_viewport* viewport)
{
    CLogMessage msg(__FUNCTION__);
    gvr_mat4f mat = gGvrApi.buffer_viewport_get_transform(viewport);
    return mat;

}

void gvr_buffer_viewport_set_transform(gvr_buffer_viewport* viewport,
                                       gvr_mat4f transform)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.buffer_viewport_set_transform(viewport, transform);
    return;

}

int32_t gvr_buffer_spec_get_samples(const gvr_buffer_spec *spec)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.buffer_spec_get_samples(spec);
}

gvr_rectf gvr_buffer_viewport_get_source_fov(const gvr_buffer_viewport *viewport)
{
//    gvr_rectf re;
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.buffer_viewport_get_source_fov(viewport);
}

int32_t gvr_swap_chain_get_buffer_count(const gvr_swap_chain *swap_chain)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.swap_chain_get_buffer_count(swap_chain);
}

int32_t gvr_buffer_viewport_get_reprojection(const gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.buffer_viewport_get_reprojection(viewport);
}

void gvr_buffer_viewport_set_reprojection(gvr_buffer_viewport *viewport, int32_t reprojection)
{
    CLogMessage msg(__FUNCTION__);
    LOGE("gvr_buffer_viewport_set_reprojection:%d", reprojection);
    gGvrApi.buffer_viewport_set_reprojection(viewport, reprojection);
}

void gvr_buffer_viewport_set_source_uv(gvr_buffer_viewport *viewport, gvr_rectf uv)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.buffer_viewport_set_source_uv(viewport, uv);
}

void gvr_buffer_viewport_list_set_item(
        gvr_buffer_viewport_list *viewport_list,
        size_t index,
        const gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);

//    static bool bchange = true;
//    static unsigned int prevTimeMs = 0;
//    unsigned int currentTimeMs = GetTimeNano() * 1e-6;
//    if(currentTimeMs - prevTimeMs > 5000 ) {
//        bchange = !bchange;
//        prevTimeMs = currentTimeMs;
//    }
//    gvr_buffer_viewport_set_reprojection(const_cast<gvr_buffer_viewport *>(viewport), 0);
//    if( bchange) {
//        gvr_buffer_viewport_set_reprojection(const_cast<gvr_buffer_viewport *>(viewport), 0);
//    } else{
//        gvr_buffer_viewport_set_reprojection(const_cast<gvr_buffer_viewport *>(viewport), 1);
//    }
//    ViewportMap.insert(std::pair<gvr_buffer_viewport*, int>(const_cast<gvr_buffer_viewport *>(viewport), index));
//    int re = gvr_buffer_viewport_get_reprojection(viewport);
//    LOGE("re=%d", re);
    gGvrApi.buffer_viewport_list_set_item(viewport_list, index, viewport);
}

int32_t gvr_user_prefs_get_controller_handedness(const gvr_user_prefs *user_prefs)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.user_prefs_get_controller_handedness(user_prefs);
}

void gvr_get_screen_buffer_viewports(const gvr_context *gvr, gvr_buffer_viewport_list *viewport_list)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.get_screen_buffer_viewports(gvr, viewport_list);
}

gvr_sizei gvr_get_screen_target_size(const gvr_context *gvr)
{
//    gvr_sizei re;
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.get_screen_target_size(gvr);
}

gvr_rectf gvr_buffer_viewport_get_source_uv(const gvr_buffer_viewport *viewport)
{
//    gvr_rectf re;
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.buffer_viewport_get_source_uv(viewport);
}

gvr_recti gvr_get_window_bounds(const gvr_context *gvr)
{
//    gvr_recti re;
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.get_window_bounds(gvr);
}

gvr_mat4f gvr_get_head_space_from_start_space_rotation(const gvr_context *gvr, const gvr_clock_time_point time)
{
//    gvr_mat4f re;
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.get_head_space_from_start_space_rotation(gvr, time);
}

gvr_mat4f gvr_apply_neck_model(const gvr_context *gvr, gvr_mat4f head_space_from_start_space_rotation, float factor)
{
//    gvr_mat4f re;
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.apply_neck_model(gvr, head_space_from_start_space_rotation, factor);
}

gvr_frame * gvr_swap_chain_acquire_frame(gvr_swap_chain *swap_chain)
{
    CLogMessage msg(__FUNCTION__);
    gvr_frame *pfrme = gGvrApi.swap_chain_acquire_frame(swap_chain);
    LOGE("gvr_swap_chain_acquire_frame gvr_frame:%p", pfrme);
    return pfrme;
}

gvr_context * gvr_create(JNIEnv *env, jobject app_context, jobject class_loader)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.create(env, app_context, class_loader);
}

void gvr_frame_bind_buffer(gvr_frame *frame, int32_t index)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.frame_bind_buffer(frame, index);
}

void gvr_frame_unbind(gvr_frame *frame)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.frame_unbind(frame);
}

void gvr_frame_submit(gvr_frame **frame, const gvr_buffer_viewport_list *list, gvr_mat4f head_space_from_start_space)
{
    CLogMessage msg(__FUNCTION__);
//    LOGE("gvr_frame_submit %p", frame);
    ShowFPS();

    LOGE("matrix:%0.6f, %0.6f, %0.6f, %0.6f, %0.6f, %0.6f, %0.6f, %0.6f, %0.6f, %0.6f, %0.6f, %0.6f, %0.6f, %0.6f, %0.6f, %0.6f",
         head_space_from_start_space.m[0][0],head_space_from_start_space.m[0][1],head_space_from_start_space.m[0][2],head_space_from_start_space.m[0][3],
         head_space_from_start_space.m[1][0],head_space_from_start_space.m[1][1],head_space_from_start_space.m[1][2],head_space_from_start_space.m[1][3],
         head_space_from_start_space.m[2][0],head_space_from_start_space.m[2][1],head_space_from_start_space.m[2][2],head_space_from_start_space.m[2][3],
         head_space_from_start_space.m[3][0],head_space_from_start_space.m[3][1],head_space_from_start_space.m[3][2],head_space_from_start_space.m[3][3]);


//    static bool bchange = true;
//    static unsigned int prevTimeMs = 0;
//    unsigned int currentTimeMs = GetTimeNano() * 1e-6;
//    if(currentTimeMs - prevTimeMs > 5000 ) {
//        bchange = !bchange;
//        prevTimeMs = currentTimeMs;
//    }
//
//    gvr_buffer_viewport *viewport = NULL;
//    std::map<gvr_buffer_viewport *, int>::iterator iter = ViewportMap.begin();
//    for (; iter != ViewportMap.end(); ++iter) {
//        gvr_buffer_viewport *viewport = iter->first;
//        if( bchange) {
//            gvr_buffer_viewport_set_reprojection(viewport, 0);
//        }else{
//            gvr_buffer_viewport_set_reprojection(viewport, 1);
//        }
//    }


//    gvr_buffer_viewport_list_get_item(list, 0,  viewport);
//    gvr_buffer_viewport_set_reprojection(viewport, 0);
//    int size = gvr_buffer_viewport_list_get_size(list);
    gGvrApi.frame_submit(frame, list, head_space_from_start_space);
}

void gvr_swap_chain_resize_buffer(gvr_swap_chain *swap_chain, int32_t index, gvr_sizei size)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.swap_chain_resize_buffer(swap_chain, index, size);
}

gvr_buffer_viewport_list * gvr_buffer_viewport_list_create(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    gvr_buffer_viewport_list * list = gGvrApi.buffer_viewport_list_create(gvr);
    return list;

}

const gvr_user_prefs * gvr_get_user_prefs(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.get_user_prefs(gvr);
}

gvr_buffer_viewport * gvr_buffer_viewport_create(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    gvr_buffer_viewport *viewport = gGvrApi.buffer_viewport_create(gvr);
    return viewport;
}

gvr_version gvr_get_version()
{
//    gvr_version re;
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.get_version();
}

const char * gvr_get_viewer_vendor(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.get_viewer_vendor(gvr);
}

const char * gvr_get_version_string()
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.get_version_string();
}

const char * gvr_get_viewer_model(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.get_viewer_model(gvr);
}

int32_t gvr_get_error(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.get_error(gvr);
}

int32_t gvr_get_viewer_type(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.get_viewer_type(gvr);
}

int32_t gvr_clear_error(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.clear_error(gvr);
}

const char * gvr_get_error_string(int32_t error_code)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.get_error_string(error_code);
}

int32_t gvr_buffer_viewport_get_source_buffer_index(const gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.buffer_viewport_get_source_buffer_index(viewport);
}

bool gvr_get_async_reprojection_enabled(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.get_async_reprojection_enabled(gvr);
}

void gvr_buffer_viewport_set_source_buffer_index(gvr_buffer_viewport *viewport, int32_t buffer_index)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.buffer_viewport_set_source_buffer_index(viewport, buffer_index);
}

size_t gvr_buffer_viewport_list_get_size(const gvr_buffer_viewport_list *viewport_list)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.buffer_viewport_list_get_size(viewport_list);
}

int32_t gvr_buffer_viewport_get_external_surface_id(const gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.buffer_viewport_get_external_surface_id(viewport);
}

void gvr_buffer_viewport_set_external_surface_id(gvr_buffer_viewport *viewport, int32_t external_surface_id)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.buffer_viewport_set_external_surface_id(viewport, external_surface_id);
}

void gvr_set_surface_size(gvr_context *gvr, gvr_sizei surface_size_pixels)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.set_surface_size(gvr, surface_size_pixels);
}

void gvr_buffer_spec_set_color_format(gvr_buffer_spec *spec, int32_t color_format)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.buffer_spec_set_color_format(spec, color_format);
}

void gvr_buffer_viewport_set_target_eye(gvr_buffer_viewport *viewport, int32_t index)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.buffer_viewport_set_target_eye(viewport, index);
}

gvr_sizei gvr_frame_get_buffer_size(const gvr_frame *frame, int32_t index)
{
//    gvr_sizei re;
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.frame_get_buffer_size(frame, index);
}

int32_t gvr_frame_get_framebuffer_object(const gvr_frame *frame, int32_t index)
{
    CLogMessage msg(__FUNCTION__);
    LOGE("gvr_frame_get_framebuffer_object %p, index:%d", frame, index);
    return gGvrApi.frame_get_framebuffer_object(frame, index);
}

void gvr_pause_tracking(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.pause_tracking(gvr);
}

void gvr_buffer_viewport_set_source_fov(gvr_buffer_viewport *viewport, gvr_rectf fov)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.buffer_viewport_set_source_fov(viewport, fov);
}

void gvr_resume_tracking(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.resume_tracking(gvr);
}

void gvr_reset_tracking(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.reset_tracking(gvr);
}

void gvr_recenter_tracking(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.recenter_tracking(gvr);
}

bool gvr_set_default_viewer_profile(gvr_context *gvr, const char *viewer_profile_uri)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.set_default_viewer_profile(gvr, viewer_profile_uri);
}

void gvr_refresh_viewer_profile(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.refresh_viewer_profile(gvr);
}


gvr_controller_context * gvr_controller_create_and_init(int32_t options,gvr_context *context)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_create_and_init(options, context);
}

gvr_controller_context * gvr_controller_create_and_init_android(
        JNIEnv *env,
        jobject android_context,
        jobject class_loader,
        int32_t options,
        gvr_context *context)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_create_and_init_android(env, android_context, class_loader, options, context);
}

void gvr_controller_destroy(gvr_controller_context **api)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.controller_destroy(api);
}

void gvr_controller_pause(gvr_controller_context *api)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.controller_pause(api);
}

void gvr_controller_resume( gvr_controller_context *api)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.controller_resume(api);
}

const char * gvr_controller_api_status_to_string(  int32_t status)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_api_status_to_string(status);
}

const char * gvr_controller_connection_state_to_string(int32_t state)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_connection_state_to_string(state);
}

const char * gvr_controller_button_to_string(int32_t button)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_button_to_string(button);
}

gvr_controller_state * gvr_controller_state_create()
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_create();
}

void gvr_controller_state_destroy(gvr_controller_state **state)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.controller_state_destroy(state);
}

void gvr_controller_state_update(gvr_controller_context *api, int32_t flags, gvr_controller_state *out_state)
{
    CLogMessage msg(__FUNCTION__);
    gGvrApi.controller_state_update(api, flags, out_state);
}

int32_t gvr_controller_state_get_api_status(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_api_status(state);
}

int32_t gvr_controller_state_get_connection_state(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_connection_state(state);
}

gvr_quatf gvr_controller_state_get_orientation(const gvr_controller_state *state)
{
//    gvr_quatf re;
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_orientation(state);
}

gvr_vec3f gvr_controller_state_get_position(const gvr_controller_state* state)
{
    CLogMessage msg(__FUNCTION__);
    gvr_vec3f vec3 = gGvrApi.controller_state_get_position(state);
    return vec3;
}

gvr_vec3f gvr_controller_state_get_gyro(const gvr_controller_state *state)
{
//    gvr_vec3f re;
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_gyro(state);
}

gvr_vec3f gvr_controller_state_get_accel(const gvr_controller_state *state)
{
//    gvr_vec3f re;
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_accel(state);
}

bool gvr_controller_state_is_touching(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_is_touching(state);
}

gvr_vec2f gvr_controller_state_get_touch_pos(const gvr_controller_state *state)
{
//    gvr_vec2f re;
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_touch_pos(state);
}

bool gvr_controller_state_get_touch_down(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_touch_down(state);
}

bool gvr_controller_state_get_touch_up(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_touch_up(state);
}

bool gvr_controller_state_get_recentered(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_recentered(state);
}

bool gvr_controller_state_get_recentering(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_recentering(state);
}

bool gvr_controller_state_get_button_state(const gvr_controller_state *state, int32_t button)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_button_state(state, button);
}

bool gvr_controller_state_get_button_down(const gvr_controller_state *state, int32_t button)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_button_down(state, button);
}

bool gvr_controller_state_get_button_up(const gvr_controller_state *state, int32_t button)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_button_up(state, button);
}

int64_t gvr_controller_state_get_last_orientation_timestamp(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_last_orientation_timestamp(state);
}

int64_t gvr_controller_state_get_last_position_timestamp(
        const gvr_controller_state* state)
{
    int64_t re = 0;
    CLogMessage msg(__FUNCTION__);
    re = gGvrApi.controller_state_get_last_position_timestamp(state);
    return re;
}

int64_t gvr_controller_state_get_last_gyro_timestamp(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_last_gyro_timestamp(state);
}

int64_t gvr_controller_state_get_last_accel_timestamp(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_last_accel_timestamp(state);
}

int64_t gvr_controller_state_get_last_touch_timestamp(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_last_touch_timestamp(state);
}

int64_t gvr_controller_state_get_last_button_timestamp(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_state_get_last_button_timestamp(state);
}

int32_t gvr_controller_get_default_options()
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.controller_get_default_options();
}

/////////////////////////
/////////////////////
int gvr_set_viewer_params(int *a1, const void *a2, size_t a3)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.set_viewer_params(a1, a2, a3);
}
int gvr_set_display_metrics( int *a1, int a2, int a3, int a4, int a5, int a6)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.set_display_metrics(a1, a2, a3, a4, a5, a6);
}
int gvr_set_back_gesture_event_handler(int a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.set_back_gesture_event_handler(a1, a2, a3);
}
int gvr_display_synchronizer_create()
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.display_synchronizer_create();
}

int gvr_display_synchronizer_destroy(int *a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.display_synchronizer_destroy(a1);
}

int gvr_get_border_size_meters(void *a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.get_border_size_meters(a1);
}

int gvr_check_surface_size_changed(int a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.check_surface_size_changed(a1);
}

int gvr_get_surface_size(int a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.get_surface_size(a1, a2, a3);
}

int gvr_set_display_output_rotation(void *a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.set_display_output_rotation(a1, a2);
}

int gvr_reconnect_sensors( void *a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.reconnect_sensors(a1);
}

int gvr_set_lens_offset(int *a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.set_lens_offset(a1, a2, a3);
}

int gvr_resume(int a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.resume(a1);
}

int gvr_dump_debug_data(void *a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.dump_debug_data(a1);
}

int gvr_using_vr_display_service( int a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.using_vr_display_service(a1);
}

int gvr_tracker_state_get_buffer_size(int a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.tracker_state_get_buffer_size(a1);
}

int gvr_tracker_state_get_buffer(int a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.tracker_state_get_buffer(a1);
}

int gvr_pause(int a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.pause(a1);
}

int gvr_set_ignore_manual_tracker_pause_resume(void *a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.set_ignore_manual_tracker_pause_resume(a1, a2);
}

int gvr_display_synchronizer_update(int *a1, int a2, int64_t a3, int a4)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.display_synchronizer_update(a1, a2, a3, a4);
}

int gvr_remove_all_surfaces_reprojection_thread(void *a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.remove_all_surfaces_reprojection_thread(a1);
}

int gvr_set_async_reprojection_enabled(int a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.set_async_reprojection_enabled(a1, a2);
}

int gvr_on_surface_created_reprojection_thread( int a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.on_surface_created_reprojection_thread(a1);
}

int gvr_render_reprojection_thread(int a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.render_reprojection_thread(a1);
}

int gvr_request_context_sharing(int *a1, int a2, int a3)
{
    int re = 0;
    CLogMessage msg(__FUNCTION__);
    re = gGvrApi.request_context_sharing(a1, a2, a3);
    return re;
}

int gvr_tracker_state_destroy( int *a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.tracker_state_destroy(a1);
}

int gvr_resume_tracking_set_state(int a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.resume_tracking_set_state(a1, a2, a3);
}

int gvr_pause_tracking_get_state( void *a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.pause_tracking_get_state(a1);
}

int gvr_tracker_state_create(int a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.tracker_state_create(a1, a2);
}

int gvr_create_with_tracker_for_testing( int a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.create_with_tracker_for_testing(a1, a2);
}

int gvr_set_error(int a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.set_error(a1, a2);
}

int gvr_set_display_synchronizer( int *a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.set_display_synchronizer(a1, a2);
}

int gvr_display_synchronizer_reset(void *a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.display_synchronizer_reset(a1);
}

int gvr_on_pause_reprojection_thread(int a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.on_pause_reprojection_thread(a1);
}

int gvr_update_surface_reprojection_thread(int *a1, int a2, int a3, int a4, int64_t a5,
                                           int a6, int a7, int a8, int a9, int a10, int a11,
                                           int a12, int a13, int a14, int a15, int a16, int a17,
                                           int a18, int a19, int a20, int a21)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.update_surface_reprojection_thread(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21);
}

int Java_com_google_geo_render_mirth_api_MirthNet_setHttpProxy(int a1)
{
    CLogMessage msg(__FUNCTION__);
    return gGvrApi.MirthNet_setHttpProxy(a1);
}

