//
// Created by houguoli on 2017/1/3.
//

#ifndef UNITYINTERFACE_UNITYINTERFACE_H
#define UNITYINTERFACE_UNITYINTERFACE_H
#include "jni.h"
#include "vr/gvr/capi/include/gvr_controller.h"
#include "vr/gvr/capi/include/gvr_types.h"
#include "vr/gvr/capi/include/gvr_gesture.h"


typedef long (*FP_CardboardViewNativeImpl_nativeSetApplicationState)(JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext);
typedef void (*FP_CardboardViewNativeImpl_nativeSetScreenParams) (JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3);
typedef void (*FP_CardboardViewNativeImpl_nativeSetNeckModelFactor)(JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat);

typedef float (*FP_CardboardViewNativeImpl_nativeGetNeckModelFactor)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_CardboardViewNativeImpl_nativeOnDrawFrame)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_CardboardViewNativeImpl_nativeSetNeckModelEnabled)(JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean);

typedef void (*FP_CardboardViewNativeImpl_nativeDestroy)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_CardboardViewNativeImpl_nativeOnSurfaceCreated)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_CardboardViewNativeImpl_nativeOnSurfaceChanged)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2);

typedef void (*FP_CardboardViewNativeImpl_nativeSetStereoModeEnabled)(JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean);

typedef void (*FP_CardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled)(JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean);

typedef void (*FP_CardboardViewNativeImpl_nativeSetDistortionCorrectionScale)( JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat);

typedef void (*FP_CardboardViewNativeImpl_nativeSetMultisampling)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef void (*FP_CardboardViewNativeImpl_nativeSetDepthStencilFormat)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef void (*FP_CardboardViewNativeImpl_nativeUndistortTexture)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef void (*FP_CardboardViewNativeImpl_nativeLogEvent)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef void (*FP_CardboardViewNativeImpl_nativeSetGvrViewerParams)(JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte);

typedef void (*FP_CardboardViewNativeImpl_nativeSetStereoRenderer)(JNIEnv* env, jobject obj, jlong paramLong, jobject paramStereoRenderer);

typedef void (*FP_CardboardViewNativeImpl_nativeSetRenderer)(JNIEnv* env, jobject obj, jlong paramLong, jobject paramRenderer);

typedef void  (*FP_CardboardViewNativeImpl_nativeGetCurrentEyeParams)(JNIEnv* env, jobject obj, jlong paramLong, jobject paramHeadTransform, jobject paramEye1, jobject paramEye2, jobject paramEye3, jobject paramEye4, jobject paramEye5);

typedef long (*FP_CardboardViewNativeImpl_nativeInit)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_NativeCallbacks_handleStateChanged)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2);

typedef void (*FP_NativeCallbacks_handleControllerRecentered)(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4);

typedef void (*FP_NativeCallbacks_handleTouchEvent)(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt, jfloat paramFloat1, jfloat paramFloat2);

typedef void (*FP_NativeCallbacks_handleOrientationEvent)(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4);

typedef void (*FP_NativeCallbacks_handleButtonEvent)(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt, jboolean paramBoolean);

typedef void (*FP_NativeCallbacks_handleAccelEvent)(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3);

typedef void (*FP_NativeCallbacks_handleBatteryEvent)(JNIEnv* env, jobject obj, jlong var1, jlong var3, jboolean var5, jint var6);

typedef void (*FP_NativeCallbacks_handleGyroEvent)(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3);

typedef void (*FP_NativeCallbacks_handleServiceInitFailed)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef void (*FP_NativeCallbacks_handleServiceFailed)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_NativeCallbacks_handleServiceUnavailable)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_NativeCallbacks_handleServiceConnected)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef void (*FP_NativeCallbacks_handleServiceDisconnected)(JNIEnv* env, jobject obj, jlong paramLong);

typedef int (*FP_MirthNet_setHttpProxy)(int a1);

typedef void (*FP_VrParamsProviderJni_nativeUpdateNativePhoneParamsPointer)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1, jfloat paramFloat2);

typedef void (*FP_GvrApi_nativeRecenterTracking)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeGetEyeFromHeadMatrix)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jfloatArray paramArrayOfFloat);

typedef int (*FP_GvrApi_nativeGetViewerType)(JNIEnv* env, jobject obj, jlong paramLong);

typedef bool (*FP_GvrApi_nativeSetAsyncReprojectionEnabled)(JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBool);

typedef void (*FP_GvrApi_nativeGetHeadSpaceFromStartSpaceRotation)(JNIEnv* env, jobject obj, jlong paramLong1, jfloatArray paramArrayOfFloat, jlong paramLong2);

typedef void (*FP_GvrApi_nativeSetIgnoreManualPauseResumeTracker)(JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean);

typedef void (*FP_GvrApi_nativeResetTracking)(JNIEnv* env, jobject obj, jlong paramLong);

typedef jobject (*FP_GvrApi_nativeRenderReprojectionThread)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeOnPauseReprojectionThread)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeSetDefaultFramebufferActive)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeGetScreenBufferViewports)(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2);

typedef void (*FP_GvrApi_nativeGetMaximumEffectiveRenderTargetSize)(JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint);

typedef void (*FP_GvrApi_nativeGetScreenTargetSize)(JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint);

typedef void (*FP_GvrApi_nativeDistortToScreen)( JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2, jfloatArray paramArrayOfFloat, jlong paramLong3);

typedef int (*FP_GvrApi_nativeBufferViewportListGetSize)( JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeBufferViewportListGetItem)(JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2);

typedef void (*FP_GvrApi_nativeBufferViewportListSetItem)(JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2);

typedef long (*FP_GvrApi_nativeBufferViewportCreate)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeRemoveAllSurfacesReprojectionThread)(JNIEnv* env, jobject obj, jlong paramLong);

typedef bool (*FP_GvrApi_nativeUsingVrDisplayService)(JNIEnv* env, jobject obj, jlong paramLong);

typedef long (*FP_GvrApi_nativeBufferViewportListCreate)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeBufferViewportListDestroy)(JNIEnv* env, jobject obj, jlong paramLong);

typedef float (*FP_GvrApi_nativeGetBorderSizeMeters)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeSetSurfaceSize)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2);

typedef void (*FP_GvrApi_nativeSetLensOffset)( JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat1, jfloat paramFloat2);

typedef void (*FP_GvrApi_nativeUpdateSurfaceReprojectionThread)(JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt1, jint paramInt2, jlong paramLong2, jfloatArray paramArrayOfFloat);

typedef bool (*FP_GvrApi_nativeGetAsyncReprojectionEnabled)(JNIEnv* env, jobject obj, jlong paramLong);

typedef bool (*FP_GvrApi_nativeIsFeatureSupported)(JNIEnv* env, jobject obj, jlong paramLong, jint jvar );

typedef void (*FP_GvrApi_nativeReconnectSensors)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeSetIdleListener)(JNIEnv* env, jobject obj, jlong paramLong, jobject jvar);

typedef void (*FP_GvrApi_nativeSetDisplayMetrics)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1, jfloat paramFloat2);

typedef void (*FP_DisplaySynchronizer_nativeReset)(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jlong paramLong3);

typedef void (*FP_DisplaySynchronizer_nativeUpdate)(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt);

typedef void (*FP_ExternalSurfaceManager_nativeUpdateSurface)(JNIEnv* env, jobject obj, jlong var0, jint var2, jint var3, jlong var4, jfloatArray var6);

typedef long (*FP_DisplaySynchronizer_nativeCreate)(JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext);

typedef void (*FP_DisplaySynchronizer_nativeDestroy)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeDumpDebugData)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeInitializeGl)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeOnSurfaceCreatedReprojectionThread)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeOnSurfaceChangedReprojectionThread)(JNIEnv* env, jobject obj, jlong paramlong);

typedef void (*FP_GvrApi_nativeGetRecommendedBufferViewports)(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2);

typedef int (*FP_GvrApi_nativeGetError)(JNIEnv* env, jobject obj, jlong paramLong);

typedef int (*FP_GvrApi_nativeClearError)( JNIEnv* env, jobject obj, jlong paramLong);

typedef long (*FP_GvrApi_nativeGetUserPrefs)(JNIEnv* env, jobject obj, jlong paramLong);

typedef int (*FP_GvrApi_nativeUserPrefsGetControllerHandedness)(JNIEnv* env, jobject obj, jlong paramLong);

typedef jboolean (*FP_GvrApi_nativeUserPrefsGetPerformanceMonitoringEnabled)(JNIEnv* env, jobject obj, jlong paramLong);

typedef jboolean (*FP_GvrApi_nativeUserPrefsGetPerformanceHudEnabled)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativePause)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeResume)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeReleaseGvrContext)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeBufferViewportDestroy)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeBufferViewportGetSourceUv)(JNIEnv* env, jobject obj, jlong paramLong, jobject paramRectF);

typedef void (*FP_GvrApi_nativeBufferViewportSetSourceUv)(JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4);

typedef void (*FP_GvrApi_nativeBufferViewportGetSourceFov)(JNIEnv* env, jobject obj, jlong paramLong, jobject paramRectF);

typedef void (*FP_GvrApi_nativeBufferViewportSetSourceFov)(JNIEnv* env, jobject obj,  jlong paramLong, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4);

typedef void (*FP_GvrApi_nativeBufferViewportGetTransform)(JNIEnv* env, jobject obj, jlong paramLong, jfloatArray paramArrayOffloat);

typedef void (*FP_GvrApi_nativeBufferViewportSetTransform)(JNIEnv* env, jobject obj, jlong paramLong, jfloatArray paramArrayOfFloat);

typedef int (*FP_GvrApi_nativeBufferViewportGetTargetEye)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeBufferViewportSetTargetEye)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef int (*FP_GvrApi_nativeBufferViewportGetSourceBufferIndex)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeBufferViewportSetSourceBufferIndex)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef int (*FP_GvrApi_nativeBufferViewportGetExternalSurfaceId)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeBufferViewportSetExternalSurfaceId)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef void (*FP_GvrApi_nativeBufferViewportSetExternalSurface)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef int (*FP_GvrApi_nativeBufferViewportGetReprojection)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeBufferViewportSetReprojection)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef void (*FP_GvrApi_nativeBufferViewportSetSourceLayer)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef bool (*FP_GvrApi_nativeBufferViewportEqual)(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2);

typedef long (*FP_GvrApi_nativeBufferSpecCreate)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeBufferSpecDestroy)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeBufferSpecGetSize)( JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint);

typedef void (*FP_GvrApi_nativeBufferSpecSetSize)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jint paramInt2);

typedef int (*FP_GvrApi_nativeBufferSpecGetSamples)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeBufferSpecSetSamples)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef long (*FP_GvrApi_nativeExternalSurfaceCreateWithListeners)(JNIEnv* env, jobject obj, jlong paramLong, jobject var2, jobject var3, jobject var4);

typedef void (*FP_GvrApi_nativeExternalSurfaceDestroy)(JNIEnv* env, jobject obj, jlong paramLong);

typedef jint (*FP_GvrApi_nativeExternalSurfaceGetId)(JNIEnv* env, jobject obj, jlong paramLong);

typedef jobject (*FP_GvrApi_nativeExternalSurfaceGetSurface)(JNIEnv* env, jobject obj, jlong paramLong);

typedef long (*FP_GvrApi_nativeExternalSurfaceCreate)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeBufferSpecSetColorFormat)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef void (*FP_GvrApi_nativeBufferSpecSetDepthStencilFormat)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef void (*FP_GvrApi_nativeBufferSpecSetMultiviewLayers)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef void (*FP_GvrApi_nativeSwapChainDestroy)(JNIEnv* env, jobject obj, jlong paramLong);

typedef int (*FP_GvrApi_nativeSwapChainGetBufferCount)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeSwapChainGetBufferSize)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jobject paramPoint);

typedef void (*FP_GvrApi_nativeSwapChainResizeBuffer)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jint paramInt3);

typedef long (*FP_GvrApi_nativeSwapChainAcquireFrame)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeFrameBindBuffer)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef void (*FP_GvrApi_nativeFrameUnbind)(JNIEnv* env, jobject obj, jlong paramLong);

typedef int (*FP_GvrApi_nativeFrameGetFramebufferObject)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef void (*FP_GvrApi_nativeFrameGetBufferSize)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jobject paramPoint);

typedef void (*FP_GvrApi_nativeFrameSubmit)(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloatArray paramArrayOfFloat);

typedef jboolean (*FP_GvrApi_nativeUsingDynamicLibrary)(JNIEnv* env, jobject obj);

typedef void (*FP_GvrApi_nativeSetApplicationState)(JNIEnv* env, jobject obj, jobject jclassloader, jobject jcontext);

typedef void (*FP_GvrApi_nativeSetDynamicLibraryLoadingEnabled)(JNIEnv* env, jobject obj, jboolean jvar);

typedef void (*FP_GvrApi_nativeResumeTracking)(JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte);

typedef void (*FP_GvrApi_nativeResumeTrackingSetState)( JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte);

typedef bool (*FP_GvrApi_nativeSetDefaultViewerProfile)(JNIEnv* env, jobject obj, jlong paramLong, jstring paramString);

typedef bool (*FP_GvrApi_nativeSetViewerParams)( JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte);

typedef long (*FP_GvrApi_nativeSwapChainCreate)(JNIEnv* env, jobject obj, jlong paramLong, jlongArray paramArrayOfLong);

typedef long (*FP_GvrApi_nativeCreate)(JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1, jfloat paramFloat2, jobject paramPoseTracker);

typedef void (*FP_GvrApi_nativeRequestContextSharing)(JNIEnv* env, jobject obj, jlong paramlong, jobject jvar);

typedef jfloatArray (*FP_GvrApi_nativeComputeDistortedPoint)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jfloatArray paramArrayOfFloat);

typedef jstring (*FP_GvrApi_nativeGetErrorString)(JNIEnv* env, jobject obj, jint paramInt);

typedef jstring (*FP_GvrApi_nativeGetViewerVendor)(JNIEnv* env, jobject obj, jlong paramLong);

typedef jstring (*FP_GvrApi_nativeGetViewerModel)( JNIEnv* env, jobject obj, jlong paramLong);

typedef jbyteArray (*FP_GvrApi_nativePauseTracking)( JNIEnv* env, jobject obj, jlong paramLong);

typedef jbyteArray (*FP_GvrApi_nativePauseTrackingGetState)(JNIEnv* env, jobject obj, jlong paramLong);

typedef jintArray (*FP_GvrApi_nativeGetWindowBounds)(JNIEnv* env, jobject obj, jlong paramLong);

typedef jint (*FP_JNI_OnLoad)(JavaVM* vm, void* reserved);

typedef void (*FP_buffer_viewport_list_destroy)( gvr_buffer_viewport_list **viewport_list);
typedef void (*FP_swap_chain_destroy)(gvr_swap_chain **swap_chain);

typedef void (*FP_destroy)( gvr_context **gvr);

typedef void (*FP_buffer_viewport_destroy)(gvr_buffer_viewport **viewport);

typedef gvr_swap_chain * (*FP_swap_chain_create)( gvr_context *gvr, const gvr_buffer_spec **buffers, int32_t count);

typedef void (*FP_bind_default_framebuffer)(gvr_context *gvr);
typedef gvr_sizei (*FP_get_maximum_effective_render_target_size)(const gvr_context *gvr);

typedef void (*FP_buffer_spec_set_samples)( gvr_buffer_spec *spec, int32_t num_samples);

typedef void (*FP_buffer_spec_set_depth_stencil_format)( gvr_buffer_spec *spec, int32_t depth_stencil_format);

typedef void (*FP_buffer_spec_set_multiview_layer)(gvr_buffer_spec* spec, int32_t num_layers);

typedef void (*FP_buffer_spec_set_size)( gvr_buffer_spec *spec, gvr_sizei size);

typedef gvr_buffer_spec * (*FP_buffer_spec_create)( gvr_context *gvr);

typedef void (*FP_initialize_gl)(gvr_context *gvr);

typedef void (*FP_distort_to_screen)( gvr_context *gvr,
                                      int32_t texture_id,
                                      const gvr_buffer_viewport_list *viewport_list,
                                      gvr_mat4f head_space_from_start_space,
                                      gvr_clock_time_point target_presentation_time);

typedef bool (*FP_is_feature_supported)(const gvr_context* gvr, int32_t feature);

typedef gvr_clock_time_point (*FP_get_time_point_now)();

typedef int (*FP_set_viewer_params)(int *a1, const void *a2, size_t a3);

typedef int (*FP_set_display_metrics)(int *a1, int a2, int a3, int a4, int a5, int a6);

typedef void (*FP_buffer_spec_destroy)(gvr_buffer_spec **spec);

typedef gvr_mat4f (*FP_get_eye_from_head_matrix)( const gvr_context *gvr,
                                                  const int32_t eye);

typedef gvr_sizei (*FP_swap_chain_get_buffer_size)(const gvr_swap_chain *swap_chain, int32_t index);

typedef int (*FP_set_error)(int a1, int a2);
typedef int (*FP_set_idle_listener)(int *a1, int a2, int a3);

typedef void (*FP_compute_distorted_point)(  const gvr_context *gvr,
                                             const int32_t eye,
                                             const gvr_vec2f uv_in,
                                             gvr_vec2f uv_out[3]);

typedef void (*FP_get_recommended_buffer_viewports)(  const gvr_context *gvr,
                                                      gvr_buffer_viewport_list *viewport_list);

typedef bool (*FP_buffer_viewport_equal)( const gvr_buffer_viewport *a,
                                          const gvr_buffer_viewport *b);

typedef void (*FP_buffer_viewport_list_get_item)(  const gvr_buffer_viewport_list *viewport_list,
                                                   size_t index,
                                                   gvr_buffer_viewport *viewport);

typedef gvr_sizei (*FP_buffer_spec_get_size)(const gvr_buffer_spec *spec);

typedef int32_t (*FP_buffer_viewport_get_target_eye)( const gvr_buffer_viewport *viewport);

typedef int32_t (*FP_buffer_spec_get_samples)(const gvr_buffer_spec *spec);

typedef gvr_rectf (*FP_buffer_viewport_get_source_fov)(const gvr_buffer_viewport *viewport);

typedef int32_t (*FP_swap_chain_get_buffer_count)(const gvr_swap_chain *swap_chain);

typedef int32_t (*FP_buffer_viewport_get_reprojection)(const gvr_buffer_viewport *viewport);

typedef void (*FP_buffer_viewport_set_reprojection)(  gvr_buffer_viewport *viewport, int32_t reprojection);

typedef void (*FP_buffer_viewport_set_source_layer)(gvr_buffer_viewport* viewport, int32_t layer_index);

typedef void (*FP_buffer_viewport_set_source_uv)(  gvr_buffer_viewport *viewport,
                                                   gvr_rectf uv);

typedef void (*FP_buffer_viewport_list_set_item)(  gvr_buffer_viewport_list *viewport_list,
                                                   size_t index,
                                                   const gvr_buffer_viewport *viewport);

typedef int32_t (*FP_user_prefs_get_controller_handedness)(const gvr_user_prefs *user_prefs);

typedef void (*FP_get_screen_buffer_viewports)(  const gvr_context *gvr,
                                                 gvr_buffer_viewport_list *viewport_list);

typedef gvr_sizei (*FP_get_screen_target_size)(const gvr_context *gvr);
typedef gvr_rectf (*FP_buffer_viewport_get_source_uv)(const gvr_buffer_viewport *viewport);
typedef gvr_recti (*FP_get_window_bounds)(const gvr_context *gvr);
typedef gvr_mat4f (*FP_get_head_space_from_start_space_rotation)(  const gvr_context *gvr,
                                                                   const gvr_clock_time_point time);

typedef gvr_mat4f (*FP_apply_neck_model)(  const gvr_context *gvr,
                                           gvr_mat4f head_space_from_start_space_rotation,
                                           float factor);
typedef gvr_frame* (*FP_swap_chain_acquire_frame)(gvr_swap_chain *swap_chain);
typedef gvr_context *(*FP_create)(  JNIEnv *env,
                                    jobject app_context,
                                    jobject class_loader);

typedef void (*FP_frame_bind_buffer)(  gvr_frame *frame,
                                       int32_t index);

typedef void (*FP_frame_unbind)(gvr_frame *frame);
typedef gvr_gesture_context* (*FP_gesture_context_create)();
typedef void (*FP_gesture_context_destroy)(gvr_gesture_context** context);
typedef const gvr_gesture* (*FP_gesture_get)(const gvr_gesture_context* context, int index);
typedef int (*FP_gesture_get_count)(const gvr_gesture_context* context);
typedef gvr_gesture_direction (*FP_gesture_get_direction)(const gvr_gesture* gesture);
typedef gvr_vec2f (*FP_gesture_get_displacement)(const gvr_gesture* gesture);
typedef gvr_gesture_type (*FP_gesture_get_type)(const gvr_gesture* gesture);
typedef gvr_vec2f (*FP_gesture_get_velocity)(const gvr_gesture* gesture);
typedef void (*FP_gesture_restart)(gvr_gesture_context* context);
typedef void (*FP_gesture_update)(const gvr_controller_state* controller_state, gvr_gesture_context* context);
typedef void (*FP_frame_submit)(  gvr_frame **frame, const gvr_buffer_viewport_list *list, gvr_mat4f head_space_from_start_space);
typedef void (*FP_swap_chain_resize_buffer)(gvr_swap_chain *swap_chain, int32_t index, gvr_sizei size);

typedef gvr_buffer_viewport_list * (*FP_buffer_viewport_list_create)( const gvr_context *gvr);

typedef const gvr_user_prefs * (*FP_get_user_prefs)(gvr_context *gvr);

typedef gvr_buffer_viewport * (*FP_buffer_viewport_create)(gvr_context *gvr);

typedef int (*FP_set_back_gesture_event_handler)(int a1, int a2, int a3);
typedef gvr_version (*FP_get_version)();

typedef const char * (*FP_get_viewer_vendor)(const gvr_context *gvr);
typedef const char * (*FP_get_version_string)();
typedef const char * (*FP_get_viewer_model)(const gvr_context *gvr);
typedef int32_t (*FP_get_error)(gvr_context *gvr);
typedef int32_t (*FP_get_viewer_type)(const gvr_context *gvr);
typedef int32_t (*FP_clear_error)(gvr_context *gvr);
typedef const char * (*FP_get_error_string)(int32_t error_code);
typedef int32_t (*FP_buffer_viewport_get_source_buffer_index)(const gvr_buffer_viewport *viewport);
typedef bool (*FP_get_async_reprojection_enabled)(const gvr_context *gvr);
typedef void (*FP_buffer_viewport_set_source_buffer_index)( gvr_buffer_viewport *viewport,
                                                            int32_t buffer_index);

typedef size_t (*FP_buffer_viewport_list_get_size)( const gvr_buffer_viewport_list *viewport_list);
typedef int32_t (*FP_buffer_viewport_get_external_surface_id)( const gvr_buffer_viewport *viewport);
typedef void (*FP_buffer_viewport_set_external_surface_id)(  gvr_buffer_viewport *viewport,
                                                             int32_t external_surface_id);

typedef void (*FP_set_surface_size)( gvr_context *gvr,
                                     gvr_sizei surface_size_pixels);

typedef gvr_mat4f (*FP_buffer_viewport_get_transform)(const gvr_buffer_viewport *viewport);

typedef void (*FP_buffer_spec_set_color_format)(  gvr_buffer_spec *spec,
                                                  int32_t color_format);

typedef void (*FP_buffer_viewport_set_transform)(gvr_buffer_viewport *viewport,
                                                 gvr_mat4f transform);
typedef void (*FP_buffer_viewport_set_target_eye)(  gvr_buffer_viewport *viewport,
                                                    int32_t index);

typedef gvr_sizei (*FP_frame_get_buffer_size)(  const gvr_frame *frame,
                                                int32_t index);

typedef int32_t (*FP_frame_get_framebuffer_object)(  const gvr_frame *frame,
                                                     int32_t index);

typedef void (*FP_pause_tracking)( gvr_context *gvr);
typedef void (*FP_buffer_viewport_set_source_fov)( gvr_buffer_viewport *viewport,
                                                   gvr_rectf fov);

typedef void (*FP_resume_tracking)(gvr_context *gvr);
typedef void (*FP_reset_tracking)(gvr_context *gvr);

typedef void (*FP_recenter_tracking)(gvr_context *gvr);

typedef bool (*FP_set_default_viewer_profile)(  gvr_context *gvr,
                                                const char *viewer_profile_uri);

typedef void (*FP_refresh_viewer_profile)(gvr_context *gvr);

typedef int (*FP_display_synchronizer_create)();
typedef int (*FP_display_synchronizer_destroy)(int *a1);
typedef int (*FP_get_border_size_meters)(void *a1);
typedef bool (*FP_get_button_long_press)(const gvr_controller_state* controller_state, const gvr_gesture_context* context, gvr_controller_button button);
typedef int (*FP_check_surface_size_changed)(int a1);
typedef int (*FP_get_surface_size)(int a1, int a2, int a3);
typedef int (*FP_set_display_output_rotation)(void *a1, int a2);
typedef int (*FP_reconnect_sensors)(void *a1);
typedef int (*FP_set_lens_offset)(int *a1, int a2, int a3);
typedef int (*FP_resume)(int a1);
typedef int (*FP_dump_debug_data)(void *a1);
typedef int (*FP_external_surface_create_with_listeners)(int a1, int a2, int a3, int a4);
typedef int (*FP_external_surface_destroy)(void **a1, int a2, int a3);
typedef int (*FP_external_surface_get_surface)(int a1, int a2, int a3);
typedef int (*FP_external_surface_get_surface_id)(int *a1, int a2, int a3);
typedef bool (*FP_using_dynamic_library)(int a1, int a2, int a3);
typedef int32_t (*FP_controller_get_default_options)();
typedef int (*FP_using_vr_display_service)(int a1);
typedef int (*FP_tracker_state_get_buffer_size)(int a1);
typedef gvr_controller_context * (*FP_controller_create_and_init)(int32_t options,gvr_context *context);
typedef int (*FP_tracker_state_get_buffer)(int a1);
typedef int (*FP_pause)(int a1);
typedef gvr_controller_context * (*FP_controller_create_and_init_android)(  JNIEnv *env,
                                                                            jobject android_context,
                                                                            jobject class_loader,
                                                                            int32_t options,
                                                                            gvr_context *context);
typedef void (*FP_controller_destroy)( gvr_controller_context **api);

typedef int  (*FP_set_display_synchronizer)(int *a1, int a2);
typedef void (*FP_controller_pause)(gvr_controller_context *api);
typedef int (*FP_set_ignore_manual_tracker_pause_resume)(void *a1, int a2);
typedef void (*FP_controller_resume)(gvr_controller_context *api);
typedef int (*FP_display_synchronizer_reset)(void *a1);

typedef const char* (*FP_controller_api_status_to_string)( int32_t status);
typedef const char* (*FP_controller_battery_level_to_string)(int32_t level);
typedef const char* (*FP_controller_connection_state_to_string)(int32_t state);
typedef int (*FP_display_synchronizer_update)(int *a1, int a2, int64_t a3, int a4);
typedef const char * (*FP_controller_button_to_string)( int32_t button);
typedef gvr_controller_state * (*FP_controller_state_create)();
typedef void (*FP_controller_state_destroy)(gvr_controller_state **state);
typedef void (*FP_controller_state_update)(  gvr_controller_context *api,
                                             int32_t flags,
                                             gvr_controller_state *out_state);
typedef int32_t (*FP_controller_state_get_api_status)(const gvr_controller_state *state);
typedef int32_t (*FP_controller_state_get_connection_state)(const gvr_controller_state *state);
typedef gvr_quatf (*FP_controller_state_get_orientation)(const gvr_controller_state *state);

typedef gvr_vec3f (*FP_controller_state_get_gyro)(const gvr_controller_state *state);

typedef gvr_vec3f (*FP_controller_state_get_accel)( const gvr_controller_state *state);
typedef bool (*FP_controller_state_get_battery_charging)(const gvr_controller_state* state);
typedef int32_t (*FP_controller_state_get_battery_level)(const gvr_controller_state* state);
typedef bool (*FP_controller_state_is_touching)( const gvr_controller_state *state);
typedef gvr_vec2f (*FP_controller_state_get_touch_pos)(const gvr_controller_state *state);

typedef bool (*FP_controller_state_get_touch_down)(const gvr_controller_state *state);
typedef bool (*FP_controller_state_get_touch_up)(const gvr_controller_state *state);
typedef bool (*FP_controller_state_get_recentered)(const gvr_controller_state *state);
typedef bool (*FP_controller_state_get_recentering)(const gvr_controller_state *state);
typedef int (*FP_on_pause_reprojection_thread)(int a1);
typedef int (*FP_on_surface_changed_reprojection_thread)(int a1, int a2, int a3);
typedef bool (*FP_controller_state_get_button_state)(  const gvr_controller_state *state,
                                                       int32_t button);
typedef int (*FP_update_surface_reprojection_thread)(int *a1, int a2, int a3, int a4, int64_t a5,
                                                     int a6, int a7, int a8, int a9, int a10, int a11,
                                                     int a12, int a13, int a14, int a15, int a16, int a17,
                                                     int a18, int a19, int a20, int a21);
typedef bool (*FP_controller_state_get_button_down)( const gvr_controller_state *state,
                                                     int32_t button);

typedef bool (*FP_controller_state_get_button_up)(const gvr_controller_state *state, int32_t button);
typedef int (*FP_remove_all_surfaces_reprojection_thread)(void *a1);
typedef int64_t (*FP_controller_state_get_last_orientation_timestamp)(const gvr_controller_state *state);
typedef int64_t (*FP_controller_state_get_last_battery_timestamp)(const gvr_controller_state* state);
typedef int64_t (*FP_controller_state_get_last_gyro_timestamp)(const gvr_controller_state *state);
typedef int (*FP_set_async_reprojection_enabled)(int a1, int a2);
typedef int64_t (*FP_controller_state_get_last_accel_timestamp)(const gvr_controller_state *state);
typedef int (*FP_on_surface_created_reprojection_thread)(int a1);
typedef int64_t (*FP_controller_state_get_last_touch_timestamp)(const gvr_controller_state *state);
typedef int (*FP_render_reprojection_thread)(int a1);
typedef int64_t (*FP_controller_state_get_last_button_timestamp)(const gvr_controller_state *state);
typedef int (*FP_tracker_state_destroy)(int *a1);
typedef int (*FP_resume_tracking_set_state)(int a1, int a2, int a3);
typedef int (*FP_pause_tracking_get_state)(void *a1);
typedef int (*FP_tracker_state_create)(int a1, int a2);
typedef int (*FP_create_with_tracker_for_testing)(int a1, int a2);


#define FN_CardboardViewNativeImpl_nativeSetApplicationState    "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetApplicationState"
#define FN_CardboardViewNativeImpl_nativeSetScreenParams        "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetScreenParams"
#define FN_CardboardViewNativeImpl_nativeSetNeckModelFactor     "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetNeckModelFactor"
#define FN_CardboardViewNativeImpl_nativeGetNeckModelFactor     "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeGetNeckModelFactor"
#define FN_CardboardViewNativeImpl_nativeOnDrawFrame             "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeOnDrawFrame"
#define FN_CardboardViewNativeImpl_nativeSetNeckModelEnabled    "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetNeckModelEnabled"
#define FN_CardboardViewNativeImpl_nativeDestroy                  "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeDestroy"
#define FN_CardboardViewNativeImpl_nativeOnSurfaceCreated        "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeOnSurfaceCreated"
#define FN_CardboardViewNativeImpl_nativeOnSurfaceChanged        "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeOnSurfaceChanged"
#define FN_CardboardViewNativeImpl_nativeSetStereoModeEnabled    "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetStereoModeEnabled"
#define FN_CardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled  "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled"
#define FN_CardboardViewNativeImpl_nativeSetDistortionCorrectionScale    "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetDistortionCorrectionScale"
#define FN_CardboardViewNativeImpl_nativeSetMultisampling                  "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetMultisampling"
#define FN_CardboardViewNativeImpl_nativeSetDepthStencilFormat            "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetDepthStencilFormat"
#define FN_CardboardViewNativeImpl_nativeLogEvent                           "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeLogEvent"
#define FN_CardboardViewNativeImpl_nativeSetGvrViewerParams                "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetGvrViewerParams"
#define FN_CardboardViewNativeImpl_nativeSetStereoRenderer                 "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetStereoRenderer"
#define FN_CardboardViewNativeImpl_nativeSetRenderer                        "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetRenderer"
#define FN_CardboardViewNativeImpl_nativeGetCurrentEyeParams               "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeGetCurrentEyeParams"
#define FN_CardboardViewNativeImpl_nativeInit                                "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeInit"
#define FN_NativeCallbacks_handleStateChanged                                "Java_com_google_vr_internal_controller_NativeCallbacks_handleStateChanged"
#define FN_NativeCallbacks_handleControllerRecentered                       "Java_com_google_vr_internal_controller_NativeCallbacks_handleControllerRecentered"
#define FN_NativeCallbacks_handleTouchEvent                                  "Java_com_google_vr_internal_controller_NativeCallbacks_handleTouchEvent"
#define FN_NativeCallbacks_handleOrientationEvent                           "Java_com_google_vr_internal_controller_NativeCallbacks_handleOrientationEvent"
#define FN_NativeCallbacks_handleButtonEvent         "Java_com_google_vr_internal_controller_NativeCallbacks_handleButtonEvent"
#define FN_NativeCallbacks_handleAccelEvent  "Java_com_google_vr_internal_controller_NativeCallbacks_handleAccelEvent"
#define FN_NativeCallbacks_handleBatteryEvent "Java_com_google_vr_internal_controller_NativeCallbacks_handleBatteryEvent"
#define FN_NativeCallbacks_handleGyroEvent         "Java_com_google_vr_internal_controller_NativeCallbacks_handleGyroEvent"
#define FN_NativeCallbacks_handleServiceInitFailed  "Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceInitFailed"
#define FN_NativeCallbacks_handleServiceFailed          "Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceFailed"
#define FN_NativeCallbacks_handleServiceUnavailable  "Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceUnavailable"
#define FN_NativeCallbacks_handleServiceConnected          "Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceConnected"
#define FN_NativeCallbacks_handleServiceDisconnected  "Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceDisconnected"
#define FN_MirthNet_setHttpProxy         "Java_com_google_geo_render_mirth_api_MirthNet_setHttpProxy"
#define FN_VrParamsProviderJni_nativeUpdateNativePhoneParamsPointer  "Java_com_google_vr_cardboard_VrParamsProviderJni_nativeUpdateNativePhoneParamsPointer"
#define FN_GvrApi_nativeRecenterTracking          "Java_com_google_vr_ndk_base_GvrApi_nativeRecenterTracking"
#define FN_GvrApi_nativeGetEyeFromHeadMatrix  "Java_com_google_vr_ndk_base_GvrApi_nativeGetEyeFromHeadMatrix"
#define FN_GvrApi_nativeGetViewerType          "Java_com_google_vr_ndk_base_GvrApi_nativeGetViewerType"
#define FN_GvrApi_nativeSetAsyncReprojectionEnabled  "Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled"
#define FN_GvrApi_nativeGetHeadSpaceFromStartSpaceRotation         "Java_com_google_vr_ndk_base_GvrApi_nativeGetHeadSpaceFromStartSpaceRotation"
#define FN_GvrApi_nativeSetIgnoreManualPauseResumeTracker  "Java_com_google_vr_ndk_base_GvrApi_nativeSetIgnoreManualPauseResumeTracker"
#define FN_GvrApi_nativeResetTracking          "Java_com_google_vr_ndk_base_GvrApi_nativeResetTracking"
#define FN_GvrApi_nativeRenderReprojectionThread  "Java_com_google_vr_ndk_base_GvrApi_nativeRenderReprojectionThread"
#define FN_GvrApi_nativeOnPauseReprojectionThread          "Java_com_google_vr_ndk_base_GvrApi_nativeOnPauseReprojectionThread"
#define FN_GvrApi_nativeSetDefaultFramebufferActive  "Java_com_google_vr_ndk_base_GvrApi_nativeSetDefaultFramebufferActive"
#define FN_GvrApi_nativeGetScreenBufferViewports          "Java_com_google_vr_ndk_base_GvrApi_nativeGetScreenBufferViewports"
#define FN_GvrApi_nativeGetMaximumEffectiveRenderTargetSize  "Java_com_google_vr_ndk_base_GvrApi_nativeGetMaximumEffectiveRenderTargetSize"
#define FN_GvrApi_nativeGetScreenTargetSize          "Java_com_google_vr_ndk_base_GvrApi_nativeGetScreenTargetSize"
#define FN_GvrApi_nativeDistortToScreen  "Java_com_google_vr_ndk_base_GvrApi_nativeDistortToScreen"
#define FN_GvrApi_nativeBufferViewportListGetSize          "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListGetSize"
#define FN_GvrApi_nativeBufferViewportListGetItem  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListGetItem"
#define FN_GvrApi_nativeBufferViewportListSetItem          "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListSetItem"
#define FN_GvrApi_nativeBufferViewportCreate  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportCreate"
#define FN_GvrApi_nativeUsingVrDisplayService  "Java_com_google_vr_ndk_base_GvrApi_nativeUsingVrDisplayService"
#define FN_GvrApi_nativeBufferViewportListCreate         "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListCreate"
#define FN_GvrApi_nativeBufferViewportListDestroy  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListDestroy"
#define FN_GvrApi_nativeGetBorderSizeMeters          "Java_com_google_vr_ndk_base_GvrApi_nativeGetBorderSizeMeters"
#define FN_GvrApi_nativeSetSurfaceSize  "Java_com_google_vr_ndk_base_GvrApi_nativeSetSurfaceSize"
#define FN_GvrApi_nativeSetLensOffset          "Java_com_google_vr_ndk_base_GvrApi_nativeSetLensOffset"
#define FN_GvrApi_nativeGetAsyncReprojectionEnabled    "Java_com_google_vr_ndk_base_GvrApi_nativeGetAsyncReprojectionEnabled"
#define FN_GvrApi_nativeIsFeatureSupported              "Java_com_google_vr_ndk_base_GvrApi_nativeIsFeatureSupported"
#define FN_GvrApi_nativeReconnectSensors  "Java_com_google_vr_ndk_base_GvrApi_nativeReconnectSensors"
#define FN_GvrApi_nativeSetIdleListener   "Java_com_google_vr_ndk_base_GvrApi_nativeSetIdleListener"
#define FN_GvrApi_nativeSetDisplayMetrics         "Java_com_google_vr_ndk_base_GvrApi_nativeSetDisplayMetrics"
#define FN_DisplaySynchronizer_nativeReset  "Java_com_google_vr_cardboard_DisplaySynchronizer_nativeReset"
#define FN_DisplaySynchronizer_nativeUpdate         "Java_com_google_vr_cardboard_DisplaySynchronizer_nativeUpdate"
#define FN_ExternalSurfaceManager_nativeUpdateSurface "Java_com_google_vr_cardboard_ExternalSurfaceManager_nativeUpdateSurface"
#define FN_DisplaySynchronizer_nativeCreate  "Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate"
#define FN_DisplaySynchronizer_nativeDestroy          "Java_com_google_vr_cardboard_DisplaySynchronizer_nativeDestroy"
#define FN_GvrApi_nativeDumpDebugData  "Java_com_google_vr_ndk_base_GvrApi_nativeDumpDebugData"
#define FN_GvrApi_nativeInitializeGl         "Java_com_google_vr_ndk_base_GvrApi_nativeInitializeGl"
#define FN_GvrApi_nativeOnSurfaceCreatedReprojectionThread "Java_com_google_vr_ndk_base_GvrApi_nativeOnSurfaceCreatedReprojectionThread"
#define FN_GvrApi_nativeOnSurfaceChangedReprojectionThread "Java_com_google_vr_ndk_base_GvrApi_nativeOnSurfaceChangedReprojectionThread"
#define FN_GvrApi_nativeGetRecommendedBufferViewports         "Java_com_google_vr_ndk_base_GvrApi_nativeGetRecommendedBufferViewports"
#define FN_GvrApi_nativeGetError  "Java_com_google_vr_ndk_base_GvrApi_nativeGetError"
#define FN_GvrApi_nativeClearError         "Java_com_google_vr_ndk_base_GvrApi_nativeClearError"
#define FN_GvrApi_nativeGetUserPrefs  "Java_com_google_vr_ndk_base_GvrApi_nativeGetUserPrefs"
#define FN_GvrApi_nativeUserPrefsGetControllerHandedness          "Java_com_google_vr_ndk_base_GvrApi_nativeUserPrefsGetControllerHandedness"
#define FN_GvrApi_nativeUserPrefsGetPerformanceMonitoringEnabled "";
#define FN_GvrApi_nativeUserPrefsGetPerformanceHudEnabled ""
#define FN_GvrApi_nativePause  "Java_com_google_vr_ndk_base_GvrApi_nativePause"
#define FN_GvrApi_nativeResume         "Java_com_google_vr_ndk_base_GvrApi_nativeResume"
#define FN_GvrApi_nativeReleaseGvrContext  "Java_com_google_vr_ndk_base_GvrApi_nativeReleaseGvrContext"
#define FN_GvrApi_nativeBufferViewportDestroy         "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportDestroy"
#define FN_GvrApi_nativeBufferViewportGetSourceUv  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetSourceUv"
#define FN_GvrApi_nativeBufferViewportSetSourceUv         "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceUv"
#define FN_GvrApi_nativeBufferViewportGetSourceFov  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetSourceFov"
#define FN_GvrApi_nativeBufferViewportSetSourceFov         "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceFov"
#define FN_GvrApi_nativeBufferViewportGetTransform  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetTransform"
#define FN_GvrApi_nativeBufferViewportSetTransform         "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetTransform"
#define FN_GvrApi_nativeBufferViewportGetTargetEye  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetTargetEye"
#define FN_GvrApi_nativeBufferViewportSetTargetEye          "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetTargetEye"
#define FN_GvrApi_nativeBufferViewportGetSourceBufferIndex  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetSourceBufferIndex"
#define FN_GvrApi_nativeBufferViewportSetSourceBufferIndex         "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceBufferIndex"
#define FN_GvrApi_nativeBufferViewportGetExternalSurfaceId  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetExternalSurfaceId"
#define FN_GvrApi_nativeBufferViewportSetExternalSurfaceId   "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetExternalSurfaceId"
#define FN_GvrApi_nativeBufferViewportSetExternalSurface     "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetExternalSurface"
#define FN_GvrApi_nativeBufferViewportGetReprojection  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetReprojection"
#define FN_GvrApi_nativeBufferViewportSetReprojection  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetReprojection"
#define FN_GvrApi_nativeBufferViewportSetSourceLayer   "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceLayer"
#define FN_GvrApi_nativeBufferViewportEqual  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportEqual"
#define FN_GvrApi_nativeBufferSpecCreate         "Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecCreate"
#define FN_GvrApi_nativeBufferSpecDestroy  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecDestroy"
#define FN_GvrApi_nativeBufferSpecGetSize          "Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecGetSize"
#define FN_GvrApi_nativeBufferSpecSetSize  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetSize"
#define FN_GvrApi_nativeBufferSpecGetSamples         "Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecGetSamples"
#define FN_GvrApi_nativeBufferSpecSetSamples  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetSamples"
#define FN_GvrApi_nativeExternalSurfaceCreateWithListeners "Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceCreateWithListeners"
#define FN_GvrApi_nativeExternalSurfaceDestroy            "Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceDestroy"
#define FN_GvrApi_nativeExternalSurfaceGetId              "Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceGetId"
#define FN_GvrApi_nativeExternalSurfaceGetSurface         "Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceGetSurface"
#define FN_GvrApi_nativeBufferSpecSetColorFormat         "Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetColorFormat"
#define FN_GvrApi_nativeBufferSpecSetDepthStencilFormat  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetDepthStencilFormat"
#define FN_GvrApi_nativeBufferSpecSetMultiviewLayers     "Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetMultiviewLayers"
#define FN_GvrApi_nativeSwapChainDestroy          "Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainDestroy"
#define FN_GvrApi_nativeSwapChainGetBufferCount  "Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainGetBufferCount"
#define FN_GvrApi_nativeSwapChainGetBufferSize   "Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainGetBufferSize"
#define FN_GvrApi_nativeSwapChainResizeBuffer  "Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainResizeBuffer"
#define FN_GvrApi_nativeSwapChainAcquireFrame         "Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainAcquireFrame"
#define FN_GvrApi_nativeFrameBindBuffer  "Java_com_google_vr_ndk_base_GvrApi_nativeFrameBindBuffer"
#define FN_GvrApi_nativeFrameUnbind          "Java_com_google_vr_ndk_base_GvrApi_nativeFrameUnbind"
#define FN_GvrApi_nativeFrameGetFramebufferObject  "Java_com_google_vr_ndk_base_GvrApi_nativeFrameGetFramebufferObject"
#define FN_GvrApi_nativeFrameGetBufferSize         "Java_com_google_vr_ndk_base_GvrApi_nativeFrameGetBufferSize"
#define FN_GvrApi_nativeFrameSubmit  "Java_com_google_vr_ndk_base_GvrApi_nativeFrameSubmit"
#define FN_GvrApi_nativeUsingDynamicLibrary "Java_com_google_vr_ndk_base_GvrApi_nativeUsingDynamicLibrary"
#define FN_GvrApi_nativeSetApplicationState "Java_com_google_vr_ndk_base_GvrApi_nativeSetApplicationState"
#define FN_GvrApi_nativeSetDynamicLibraryLoadingEnabled "Java_com_google_vr_ndk_base_GvrApi_nativeSetDynamicLibraryLoadingEnabled"
#define FN_GvrApi_nativeResumeTracking         "Java_com_google_vr_ndk_base_GvrApi_nativeResumeTracking"
#define FN_GvrApi_nativeResumeTrackingSetState "Java_com_google_vr_ndk_base_GvrApi_nativeResumeTrackingSetState"
#define FN_GvrApi_nativeSetDefaultViewerProfile  "Java_com_google_vr_ndk_base_GvrApi_nativeSetDefaultViewerProfile"
#define FN_GvrApi_nativeSetViewerParams         "Java_com_google_vr_ndk_base_GvrApi_nativeSetViewerParams"
#define FN_GvrApi_nativeSwapChainCreate  "Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainCreate"
#define FN_GvrApi_nativeCreate          "Java_com_google_vr_ndk_base_GvrApi_nativeCreate"
#define FN_GvrApi_nativeRequestContextSharing  "Java_com_google_vr_ndk_base_GvrApi_nativeRequestContextSharing"
#define FN_GvrApi_nativeComputeDistortedPoint  "Java_com_google_vr_ndk_base_GvrApi_nativeComputeDistortedPoint"
#define FN_GvrApi_nativeGetErrorString         "Java_com_google_vr_ndk_base_GvrApi_nativeGetErrorString"
#define FN_GvrApi_nativeGetViewerVendor  "Java_com_google_vr_ndk_base_GvrApi_nativeGetViewerVendor"
#define FN_GvrApi_nativeGetViewerModel          "Java_com_google_vr_ndk_base_GvrApi_nativeGetViewerModel"
#define FN_GvrApi_nativePauseTracking  "Java_com_google_vr_ndk_base_GvrApi_nativePauseTracking"
#define FN_GvrApi_nativePauseTrackingGetState "Java_com_google_vr_ndk_base_GvrApi_nativePauseTrackingGetState"
#define FN_GvrApi_nativeGetWindowBounds         "Java_com_google_vr_ndk_base_GvrApi_nativeGetWindowBounds"
#define FN_JNI_OnLoad "JNI_OnLoad"

#define FN_buffer_viewport_list_destroy         "gvr_buffer_viewport_list_destroy"
#define FN_swap_chain_destroy                    "gvr_swap_chain_destroy"
#define FN_destroy                                "gvr_destroy"
#define FN_buffer_viewport_destroy         "gvr_buffer_viewport_destroy"
#define FN_swap_chain_create  "gvr_swap_chain_create"
#define FN_bind_default_framebuffer         "gvr_bind_default_framebuffer"
#define FN_get_maximum_effective_render_target_size  "gvr_get_maximum_effective_render_target_size"
#define FN_buffer_spec_set_samples          "gvr_buffer_spec_set_samples"
#define FN_buffer_spec_set_depth_stencil_format  "gvr_buffer_spec_set_depth_stencil_format"
#define FN_buffer_spec_set_multiview_layer        "gvr_buffer_spec_set_multiview_layers"
#define FN_buffer_spec_set_size          "gvr_buffer_spec_set_size"
#define FN_buffer_spec_create  "gvr_buffer_spec_create"
#define FN_initialize_gl          "gvr_initialize_gl"
#define FN_distort_to_screen  "gvr_distort_to_screen"
#define FN_is_feature_supported "gvr_is_feature_supported"
#define FN_get_time_point_now          "gvr_get_time_point_now"
#define FN_set_viewer_params  "gvr_set_viewer_params"
#define FN_set_display_metrics          "gvr_set_display_metrics"
#define FN_buffer_spec_destroy  "gvr_buffer_spec_destroy"
#define FN_get_eye_from_head_matrix          "gvr_get_eye_from_head_matrix"
#define FN_swap_chain_get_buffer_size  "gvr_swap_chain_get_buffer_size"
#define FN_set_error             "gvr_set_error"
#define FN_set_idle_listener    "gvr_set_idle_listener"
#define FN_compute_distorted_point  "gvr_compute_distorted_point"
#define FN_get_recommended_buffer_viewports         "gvr_get_recommended_buffer_viewports"
#define FN_buffer_viewport_equal  "gvr_buffer_viewport_equal"
#define FN_buffer_viewport_list_get_item         "gvr_buffer_viewport_list_get_item"
#define FN_buffer_spec_get_size  "gvr_buffer_spec_get_size"
#define FN_buffer_viewport_get_target_eye          "gvr_buffer_viewport_get_target_eye"
#define FN_buffer_spec_get_samples  "gvr_buffer_spec_get_samples"
#define FN_buffer_viewport_get_source_fov          "gvr_buffer_viewport_get_source_fov"
#define FN_swap_chain_get_buffer_count  "gvr_swap_chain_get_buffer_count"
#define FN_buffer_viewport_get_reprojection          "gvr_buffer_viewport_get_reprojection"
#define FN_buffer_viewport_set_source_layer         "gvr_buffer_viewport_set_source_layer"
#define FN_buffer_viewport_set_reprojection  "gvr_buffer_viewport_set_reprojection"
#define FN_buffer_viewport_set_source_uv         "gvr_buffer_viewport_set_source_uv"
#define FN_buffer_viewport_list_set_item  "gvr_buffer_viewport_list_set_item"
#define FN_user_prefs_get_controller_handedness         "gvr_user_prefs_get_controller_handedness"
#define FN_get_screen_buffer_viewports  "gvr_get_screen_buffer_viewports"
#define FN_get_screen_target_size          "gvr_get_screen_target_size"
#define FN_buffer_viewport_get_source_uv  "gvr_buffer_viewport_get_source_uv"
#define FN_get_window_bounds          "gvr_get_window_bounds"
#define FN_get_head_space_from_start_space_rotation  "gvr_get_head_space_from_start_space_rotation"
#define FN_apply_neck_model         "gvr_apply_neck_model"
#define FN_swap_chain_acquire_frame  "gvr_swap_chain_acquire_frame"
#define FN_create          "gvr_create"
#define FN_frame_bind_buffer  "gvr_frame_bind_buffer"
#define FN_frame_unbind        "gvr_frame_unbind"
#define FN_gesture_context_create   "gvr_gesture_context_create"
#define FN_gesture_context_destroy  "gvr_gesture_context_destroy"
#define FN_gesture_get                "gvr_gesture_get"
#define FN_gesture_get_count          "gvr_gesture_get_count"
#define FN_gesture_get_direction      "gvr_gesture_get_direction"
#define FN_gesture_get_displacement   "gvr_gesture_get_displacement"
#define FN_gesture_get_type             "gvr_gesture_get_type"
#define FN_gesture_get_velocity         "gvr_gesture_get_velocity"
#define FN_gesture_restart               "gvr_gesture_restart"
#define FN_gesture_update                "gvr_gesture_update"
#define FN_frame_submit  "gvr_frame_submit"
#define FN_swap_chain_resize_buffer          "gvr_swap_chain_resize_buffer"
#define FN_buffer_viewport_list_create  "gvr_buffer_viewport_list_create"
#define FN_get_user_prefs         "gvr_get_user_prefs"
#define FN_buffer_viewport_create  "gvr_buffer_viewport_create"
#define FN_set_back_gesture_event_handler         "gvr_set_back_gesture_event_handler"
#define FN_get_version  "gvr_get_version"
#define FN_get_viewer_vendor          "gvr_get_viewer_vendor"
#define FN_get_version_string  "gvr_get_version_string"
#define FN_get_viewer_model         "gvr_get_viewer_model"
#define FN_get_error  "gvr_get_error"
#define FN_get_viewer_type          "gvr_get_viewer_type"
#define FN_clear_error  "gvr_clear_error"
#define FN_get_error_string          "gvr_get_error_string"
#define FN_buffer_viewport_get_source_buffer_index  "gvr_buffer_viewport_get_source_buffer_index"
#define FN_get_async_reprojection_enabled          "gvr_get_async_reprojection_enabled"
#define FN_buffer_viewport_set_source_buffer_index  "gvr_buffer_viewport_set_source_buffer_index"
#define FN_buffer_viewport_list_get_size          "gvr_buffer_viewport_list_get_size"
#define FN_buffer_viewport_get_external_surface_id  "gvr_buffer_viewport_get_external_surface_id"
#define FN_buffer_viewport_set_external_surface_id          "gvr_buffer_viewport_set_external_surface_id"
#define FN_set_surface_size  "gvr_set_surface_size"
#define FN_buffer_viewport_get_transform          "gvr_buffer_viewport_get_transform"
#define FN_buffer_spec_set_color_format  "gvr_buffer_spec_set_color_format"
#define FN_buffer_viewport_set_transform          "gvr_buffer_viewport_set_transform"
#define FN_buffer_viewport_set_target_eye  "gvr_buffer_viewport_set_target_eye"
#define FN_frame_get_buffer_size          "gvr_frame_get_buffer_size"
#define FN_frame_get_framebuffer_object  "gvr_frame_get_framebuffer_object"
#define FN_pause_tracking          "gvr_pause_tracking"
#define FN_buffer_viewport_set_source_fov  "gvr_buffer_viewport_set_source_fov"
#define FN_resume_tracking         "gvr_resume_tracking"
#define FN_reset_tracking  "gvr_reset_tracking"
#define FN_recenter_tracking          "gvr_recenter_tracking"
#define FN_set_default_viewer_profile  "gvr_set_default_viewer_profile"
#define FN_refresh_viewer_profile         "gvr_refresh_viewer_profile"
#define FN_display_synchronizer_create  "gvr_display_synchronizer_create"
#define FN_display_synchronizer_destroy         "gvr_display_synchronizer_destroy"
#define FN_get_border_size_meters  "gvr_get_border_size_meters"
#define FN_get_button_long_press    "gvr_get_button_long_press"
#define FN_check_surface_size_changed          "gvr_check_surface_size_changed"
#define FN_get_surface_size  "gvr_get_surface_size"
#define FN_set_display_output_rotation          "gvr_set_display_output_rotation"
#define FN_reconnect_sensors  "gvr_reconnect_sensors"
#define FN_set_lens_offset         "gvr_set_lens_offset"
#define FN_resume  "gvr_resume"
#define FN_dump_debug_data         "gvr_dump_debug_data"
#define FN_external_surface_create_with_listeners "gvr_external_surface_create_with_listeners"
#define FN_external_surface_destroy                 "gvr_external_surface_destroy"
#define FN_external_surface_get_surface             "gvr_external_surface_get_surface"
#define FN_external_surface_get_surface_id          "gvr_external_surface_get_surface_id"
#define FN_using_dynamic_library                     "gvr_using_dynamic_library"
#define FN_controller_get_default_options  "gvr_controller_get_default_options"
#define FN_using_vr_display_service          "gvr_using_vr_display_service"
#define FN_tracker_state_get_buffer_size  "gvr_tracker_state_get_buffer_size"
#define FN_controller_create_and_init         "gvr_controller_create_and_init"
#define FN_tracker_state_get_buffer  "gvr_tracker_state_get_buffer"
#define FN_pause         "gvr_pause"
#define FN_controller_create_and_init_android  "gvr_controller_create_and_init_android"
#define FN_controller_destroy         "gvr_controller_destroy"
#define FN_set_display_synchronizer  "gvr_set_display_synchronizer"
#define FN_controller_pause          "gvr_controller_pause"
#define FN_set_ignore_manual_tracker_pause_resume  "gvr_set_ignore_manual_tracker_pause_resume"
#define FN_controller_resume         "gvr_controller_resume"
#define FN_display_synchronizer_reset  "gvr_display_synchronizer_reset"
#define FN_controller_api_status_to_string   "gvr_controller_api_status_to_string"
#define FN_controller_battery_level_to_string   "gvr_controller_battery_level_to_string"
#define FN_controller_connection_state_to_string  "gvr_controller_connection_state_to_string"
#define FN_display_synchronizer_update         "gvr_display_synchronizer_update"
#define FN_controller_button_to_string  "gvr_controller_button_to_string"
#define FN_controller_state_create         "gvr_controller_state_create"
#define FN_controller_state_destroy  "gvr_controller_state_destroy"
#define FN_controller_state_update        "gvr_controller_state_update"
#define FN_controller_state_get_api_status  "gvr_controller_state_get_api_status"
#define FN_controller_state_get_connection_state          "gvr_controller_state_get_connection_state"
#define FN_controller_state_get_orientation  "gvr_controller_state_get_orientation"
#define FN_controller_state_get_gyro        "gvr_controller_state_get_gyro"
#define FN_controller_state_get_accel  "gvr_controller_state_get_accel"
#define FN_controller_state_get_battery_charging "gvr_controller_state_get_battery_charging"
#define FN_controller_state_get_battery_level "gvr_controller_state_get_battery_level"
#define FN_controller_state_is_touching          "gvr_controller_state_is_touching"
#define FN_controller_state_get_touch_pos  "gvr_controller_state_get_touch_pos"
#define FN_controller_state_get_touch_down         "gvr_controller_state_get_touch_down"
#define FN_controller_state_get_touch_up  "gvr_controller_state_get_touch_up"
#define FN_controller_state_get_recentered         "gvr_controller_state_get_recentered"
#define FN_controller_state_get_recentering  "gvr_controller_state_get_recentering"
#define FN_on_pause_reprojection_thread        "gvr_on_pause_reprojection_thread"
#define FN_on_surface_changed_reprojection_thread "gvr_on_surface_changed_reprojection_thread"
#define FN_controller_state_get_button_state  "gvr_controller_state_get_button_state"
#define FN_update_surface_reprojection_thread       "gvr_update_surface_reprojection_thread"
#define FN_controller_state_get_button_down  "gvr_controller_state_get_button_down"
#define FN_controller_state_get_button_up        "gvr_controller_state_get_button_up"
#define FN_remove_all_surfaces_reprojection_thread  "gvr_remove_all_surfaces_reprojection_thread"
#define FN_controller_state_get_last_orientation_timestamp       "gvr_controller_state_get_last_orientation_timestamp"
#define FN_controller_state_get_last_battery_timestamp            "gvr_controller_state_get_last_battery_timestamp"
#define FN_controller_state_get_last_gyro_timestamp  "gvr_controller_state_get_last_gyro_timestamp"
#define FN_set_async_reprojection_enabled       "gvr_set_async_reprojection_enabled"
#define FN_controller_state_get_last_accel_timestamp  "gvr_controller_state_get_last_accel_timestamp"
#define FN_on_surface_created_reprojection_thread        "gvr_on_surface_created_reprojection_thread"
#define FN_controller_state_get_last_touch_timestamp  "gvr_controller_state_get_last_touch_timestamp"
#define FN_render_reprojection_thread       "gvr_render_reprojection_thread"
#define FN_controller_state_get_last_button_timestamp  "gvr_controller_state_get_last_button_timestamp"
#define FN_tracker_state_destroy         "gvr_tracker_state_destroy"
#define FN_resume_tracking_set_state  "gvr_resume_tracking_set_state"
#define FN_pause_tracking_get_state        "gvr_pause_tracking_get_state"
#define FN_tracker_state_create  "gvr_tracker_state_create"
#define FN_create_with_tracker_for_testing        "gvr_create_with_tracker_for_testing"


#ifdef __cplusplus
extern "C" {
#endif

bool InitLoadFun();
void ReleaseFun();
JNIEnv* AttachCurrentThreadJNI();
void DetachCurrentThreadJNI();

//ClassLoader paramClassLoader, Context paramContext)
JNIEXPORT long JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetApplicationState(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext);
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetScreenParams(
          JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3);
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetNeckModelFactor(
        JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat);
JNIEXPORT float JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeGetNeckModelFactor(
                JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeOnDrawFrame(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetNeckModelEnabled(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean );
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeDestroy(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeOnSurfaceCreated(
        JNIEnv* env, jobject obj, jlong paramLong );
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeOnSurfaceChanged(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2);
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetStereoModeEnabled(
       JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean);
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean);
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetDistortionCorrectionScale(
         JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat);
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetMultisampling(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetDepthStencilFormat(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt );
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeUndistortTexture(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeLogEvent(
         JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetGvrViewerParams(
        JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte);
//GvrView.StereoRenderer paramStereoRenderer
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetStereoRenderer(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramStereoRenderer);
//GvrView.Renderer
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetRenderer(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramRenderer);

//HeadTransform paramHeadTransform, Eye paramEye1, Eye paramEye2, Eye paramEye3, Eye paramEye4, Eye paramEye
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeGetCurrentEyeParams(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramHeadTransform, jobject paramEye1, jobject paramEye2, jobject paramEye3, jobject paramEye4, jobject paramEye5);
JNIEXPORT long JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeInit(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleStateChanged(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2 );
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleControllerRecentered(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4);
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleTouchEvent(
         JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt, jfloat paramFloat1, jfloat paramFloat2);
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleOrientationEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4);
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleButtonEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt, jboolean paramBoolean);
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleAccelEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3);

JNIEXPORT void JNICALL  Java_com_google_vr_internal_controller_NativeCallbacks_handleBatteryEvent(
        JNIEnv* env, jobject obj, jlong var1, jlong var3, jboolean var5, jint var6);

JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleGyroEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3);
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceInitFailed(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
JNIEXPORT void JNICALL  Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceFailed(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceUnavailable(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceConnected(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt );
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceDisconnected(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT void JNICALL Java_com_google_vr_cardboard_VrParamsProviderJni_nativeUpdateNativePhoneParamsPointer(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1, jfloat paramFloat2);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeRecenterTracking(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetEyeFromHeadMatrix(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jfloatArray paramArrayOfFloat);

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetViewerType(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBool);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetHeadSpaceFromStartSpaceRotation(
        JNIEnv* env, jobject obj, jlong paramLong1, jfloatArray paramArrayOfFloat, jlong paramLong2);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetIgnoreManualPauseResumeTracker(
       JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeResetTracking(
        JNIEnv* env, jobject obj, jlong paramLong);
//todo
JNIEXPORT jobject JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeRenderReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeOnPauseReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDefaultFramebufferActive(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetScreenBufferViewports(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2 );
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetMaximumEffectiveRenderTargetSize(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetScreenTargetSize(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint );
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeDistortToScreen(
        JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2, jfloatArray paramArrayOfFloat, jlong paramLong3);
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListGetSize(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListGetItem(
        JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListSetItem(
        JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2);
               
JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportCreate(
         JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeRemoveAllSurfacesReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramLong );
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUsingVrDisplayService(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListCreate(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListDestroy(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT float JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetBorderSizeMeters(
        JNIEnv* env, jobject obj, jlong paramLong );
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetSurfaceSize(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetLensOffset(
        JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat1, jfloat paramFloat2);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUpdateSurfaceReprojectionThread(
       JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt1, jint paramInt2, jlong paramLong2, jfloatArray paramArrayOfFloat);
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetAsyncReprojectionEnabled(
        JNIEnv* env, jobject obj, jlong paramLong );

JNIEXPORT jboolean JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeIsFeatureSupported(
        JNIEnv* env, jobject obj, jlong paramLong, jint jvar );

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeReconnectSensors(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetIdleListener(
        JNIEnv* env, jobject obj, jlong paramLong, jobject jvar);


JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDisplayMetrics(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1, jfloat paramFloat2);
JNIEXPORT void JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeReset(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jlong paramLong3);
JNIEXPORT void JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeUpdate(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt);

JNIEXPORT void JNICALL Java_com_google_vr_cardboard_ExternalSurfaceManager_nativeUpdateSurface(
        JNIEnv* env, jobject obj, jlong var0, jint var2, jint var3, jlong var4, jfloatArray var6);

//ClassLoader paramClassLoader, Context paramContext
JNIEXPORT long JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext);
JNIEXPORT void JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeDestroy(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeDumpDebugData(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeInitializeGl(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeOnSurfaceCreatedReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeOnSurfaceChangedReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramlong);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetRecommendedBufferViewports(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2);
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetError(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeClearError(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetUserPrefs(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUserPrefsGetControllerHandedness(
        JNIEnv* env, jobject obj, jlong paramLong );

JNIEXPORT jboolean JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUserPrefsGetPerformanceMonitoringEnabled(
        JNIEnv* env, jobject obj, jlong paramLong );

JNIEXPORT jboolean JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUserPrefsGetPerformanceHudEnabled(
        JNIEnv* env, jobject obj, jlong paramLong );

JNIEXPORT jlong JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetAnalytics(
        JNIEnv* env, jobject obj, jlong paramLong );


JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativePause(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeResume(
        JNIEnv* env, jobject obj, jlong paramLong );
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeReleaseGvrContext(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportDestroy(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetSourceUv(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramRectF);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceUv(
        JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetSourceFov(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramRectF);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceFov(
        JNIEnv* env, jobject obj,  jlong paramLong, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4 );

// static native void nativeBufferViewportGetTransform(long paramLong, float[] paramArrayOfFloat);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetTransform(
        JNIEnv* env, jobject obj, jlong paramLong, jfloatArray paramArrayOffloat);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetTransform(
        JNIEnv* env, jobject obj, jlong paramLong, jfloatArray paramArrayOfFloat);

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetTargetEye(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetTargetEye(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt );
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetSourceBufferIndex(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceBufferIndex(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt );

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetExternalSurfaceId(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT void JNICALL  Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetExternalSurfaceId(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

JNIEXPORT void JNICALL  Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetExternalSurface(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetReprojection(
         JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetReprojection(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceLayer(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportEqual(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2);

JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecCreate(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecDestroy(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecGetSize(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetSize(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jint paramInt2);

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecGetSamples(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetSamples(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceCreate(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT jlong JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceCreateWithListeners(
        JNIEnv* env, jobject obj, jlong paramLong, jobject var2, jobject var3, jobject var4);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceDestroy(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT jint JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceGetId(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT jobject JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceGetSurface(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetColorFormat(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt );
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetDepthStencilFormat(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetMultiviewLayers(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainDestroy(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainGetBufferCount(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainGetBufferSize(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jobject paramPoint);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainResizeBuffer(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jint paramInt3);
JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainAcquireFrame(
        JNIEnv* env, jobject obj, jlong paramLong );
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameBindBuffer(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameUnbind(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameGetFramebufferObject(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
//todo
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameGetBufferSize(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jobject paramPoint);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameSubmit(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloatArray paramArrayOfFloat);

JNIEXPORT jboolean JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUsingDynamicLibrary(JNIEnv* env, jobject obj);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetApplicationState(
        JNIEnv* env, jobject obj, jobject jclassloader, jobject jcontext);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDynamicLibraryLoadingEnabled(
        JNIEnv* env, jobject obj, jboolean jvar);

//todo
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeResumeTracking(
        JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeResumeTrackingSetState(
        JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte);

//todo
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDefaultViewerProfile(
        JNIEnv* env, jobject obj, jlong paramLong, jstring paramString);
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetViewerParams(
        JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte);
JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainCreate(
        JNIEnv* env, jobject obj, jlong paramLong, jlongArray paramArrayOfLong);


JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeCreate(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext, jlong paramLong, jint paramInt1,
        jint paramInt2, jfloat paramFloat1, jfloat paramFloat2, jobject paramPoseTracker);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeRequestContextSharing(
        JNIEnv* env, jobject obj, jlong paramlong, jobject jvar);

JNIEXPORT jfloatArray JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeComputeDistortedPoint(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jfloatArray paramArrayOfFloat);

JNIEXPORT jstring JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetErrorString(
        JNIEnv* env, jobject obj, jint paramInt );

JNIEXPORT jstring JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetViewerVendor(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT jstring JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetViewerModel(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT jbyteArray JNICALL Java_com_google_vr_ndk_base_GvrApi_nativePauseTracking(
       JNIEnv* env, jobject obj, jlong paramLong );

JNIEXPORT jbyteArray JNICALL Java_com_google_vr_ndk_base_GvrApi_nativePauseTrackingGetState(
        JNIEnv* env, jobject obj, jlong paramLong );


JNIEXPORT jintArray JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetWindowBounds(
                JNIEnv* env, jobject obj, jlong paramLong);

jint mj_JNI_OnLoad(JavaVM* vm, void* reserved);

void gvr_buffer_viewport_list_destroy(gvr_buffer_viewport_list **viewport_list);
       
void gvr_swap_chain_destroy(gvr_swap_chain **swap_chain);

void gvr_destroy(gvr_context **gvr);

void gvr_buffer_viewport_destroy(gvr_buffer_viewport **viewport);

gvr_swap_chain * gvr_swap_chain_create(gvr_context *gvr, const gvr_buffer_spec **buffers, int32_t count);

void gvr_bind_default_framebuffer(gvr_context *gvr);

gvr_sizei gvr_get_maximum_effective_render_target_size(const gvr_context *gvr);

void gvr_buffer_spec_set_samples(gvr_buffer_spec *spec, int32_t num_samples);

void gvr_buffer_spec_set_depth_stencil_format(gvr_buffer_spec *spec, int32_t depth_stencil_format);

void gvr_buffer_spec_set_multiview_layers(gvr_buffer_spec* spec, int32_t num_layers);

void gvr_buffer_spec_set_size(gvr_buffer_spec *spec, gvr_sizei size);

gvr_buffer_spec * gvr_buffer_spec_create(gvr_context *gvr);

void gvr_initialize_gl(gvr_context *gvr);

void gvr_distort_to_screen(
  gvr_context *gvr,
  int32_t texture_id,
  const gvr_buffer_viewport_list *viewport_list,
  gvr_mat4f head_space_from_start_space,
  gvr_clock_time_point target_presentation_time);

bool gvr_is_feature_supported(const gvr_context* gvr, int32_t feature);

gvr_clock_time_point gvr_get_time_point_now();


void gvr_buffer_spec_destroy(gvr_buffer_spec **spec);

gvr_mat4f gvr_get_eye_from_head_matrix(const gvr_context *gvr, const int32_t eye);

gvr_sizei gvr_swap_chain_get_buffer_size(const gvr_swap_chain* swap_chain, int32_t index);

void gvr_compute_distorted_point(const gvr_context *gvr, const int32_t eye, const gvr_vec2f uv_in, gvr_vec2f uv_out[3]);

void gvr_get_recommended_buffer_viewports(const gvr_context *gvr, gvr_buffer_viewport_list *viewport_list);

bool gvr_buffer_viewport_equal(const gvr_buffer_viewport *a, const gvr_buffer_viewport *b);

void gvr_buffer_viewport_list_get_item(const gvr_buffer_viewport_list *viewport_list, size_t index, gvr_buffer_viewport *viewport);

gvr_sizei gvr_buffer_spec_get_size(const gvr_buffer_spec *spec);

int32_t gvr_buffer_viewport_get_target_eye(const gvr_buffer_viewport *viewport);

int32_t gvr_buffer_spec_get_samples(const gvr_buffer_spec *spec);

gvr_rectf gvr_buffer_viewport_get_source_fov(const gvr_buffer_viewport *viewport);

int32_t gvr_swap_chain_get_buffer_count(const gvr_swap_chain *swap_chain);
        
int32_t gvr_buffer_viewport_get_reprojection(const gvr_buffer_viewport *viewport);

void gvr_buffer_viewport_set_reprojection(gvr_buffer_viewport *viewport, int32_t reprojection);

void gvr_buffer_viewport_set_source_layer(gvr_buffer_viewport* viewport, int32_t layer_index);

void gvr_buffer_viewport_set_source_uv(gvr_buffer_viewport *viewport, gvr_rectf uv);

void gvr_buffer_viewport_list_set_item(gvr_buffer_viewport_list *viewport_list, size_t index, const gvr_buffer_viewport *viewport);

int32_t gvr_user_prefs_get_controller_handedness(const gvr_user_prefs *user_prefs);

void gvr_get_screen_buffer_viewports(const gvr_context *gvr, gvr_buffer_viewport_list *viewport_list);

gvr_sizei gvr_get_screen_target_size(const gvr_context *gvr);

gvr_rectf gvr_buffer_viewport_get_source_uv(const gvr_buffer_viewport *viewport);

gvr_recti gvr_get_window_bounds(const gvr_context *gvr);

gvr_mat4f gvr_get_head_space_from_start_space_rotation(const gvr_context *gvr, const gvr_clock_time_point time);
       
gvr_mat4f gvr_apply_neck_model(const gvr_context *gvr, gvr_mat4f head_space_from_start_space_rotation, float factor);

gvr_frame * gvr_swap_chain_acquire_frame(gvr_swap_chain *swap_chain);
      
gvr_context * gvr_create(JNIEnv *env, jobject app_context, jobject class_loader);

void gvr_frame_bind_buffer(gvr_frame *frame, int32_t index);

void gvr_frame_unbind(gvr_frame *frame);

gvr_gesture_context* gvr_gesture_context_create();

void gvr_gesture_context_destroy(gvr_gesture_context** context);

const gvr_gesture* gvr_gesture_get(const gvr_gesture_context* context, int index);

int gvr_gesture_get_count(const gvr_gesture_context* context);

gvr_gesture_direction gvr_gesture_get_direction(const gvr_gesture* gesture);

gvr_vec2f gvr_gesture_get_displacement(const gvr_gesture* gesture);

gvr_gesture_type gvr_gesture_get_type(const gvr_gesture* gesture);

gvr_vec2f gvr_gesture_get_velocity(const gvr_gesture* gesture);

void gvr_gesture_restart(gvr_gesture_context* context);

void gvr_gesture_update(const gvr_controller_state* controller_state,
                        gvr_gesture_context* context);

void gvr_frame_submit(gvr_frame **frame, const gvr_buffer_viewport_list *list, gvr_mat4f head_space_from_start_space);

void gvr_swap_chain_resize_buffer(gvr_swap_chain *swap_chain, int32_t index, gvr_sizei size);

gvr_buffer_viewport_list * gvr_buffer_viewport_list_create(const gvr_context *gvr);
       
const gvr_user_prefs * gvr_get_user_prefs(gvr_context *gvr);

gvr_buffer_viewport * gvr_buffer_viewport_create(gvr_context *gvr);

gvr_version gvr_get_version();

const char * gvr_get_viewer_vendor(const gvr_context *gvr);

const char * gvr_get_version_string();

const char * gvr_get_viewer_model(const gvr_context *gvr);

int32_t gvr_get_error(gvr_context *gvr);

int32_t gvr_get_viewer_type(const gvr_context *gvr);

int32_t gvr_clear_error(gvr_context *gvr);
       
const char * gvr_get_error_string(int32_t error_code);

int32_t gvr_buffer_viewport_get_source_buffer_index(const gvr_buffer_viewport *viewport);
        
bool gvr_get_async_reprojection_enabled(const gvr_context *gvr);

void gvr_buffer_viewport_set_source_buffer_index(gvr_buffer_viewport *viewport, int32_t buffer_index);

size_t gvr_buffer_viewport_list_get_size(const gvr_buffer_viewport_list *viewport_list);

int32_t gvr_buffer_viewport_get_external_surface_id(const gvr_buffer_viewport *viewport);

void gvr_buffer_viewport_set_external_surface_id(gvr_buffer_viewport *viewport, int32_t external_surface_id);

void gvr_set_surface_size(gvr_context *gvr, gvr_sizei surface_size_pixels);

gvr_mat4f gvr_buffer_viewport_get_transform(const gvr_buffer_viewport *viewport);

void gvr_buffer_spec_set_color_format(gvr_buffer_spec *spec, int32_t color_format);

void gvr_buffer_viewport_set_transform(gvr_buffer_viewport *viewport, gvr_mat4f transform);

void gvr_buffer_viewport_set_target_eye(gvr_buffer_viewport *viewport, int32_t index);

gvr_sizei gvr_frame_get_buffer_size(const gvr_frame *frame, int32_t index);

int32_t gvr_frame_get_framebuffer_object(const gvr_frame *frame, int32_t index);

void gvr_pause_tracking(gvr_context *gvr);

void gvr_buffer_viewport_set_source_fov(gvr_buffer_viewport *viewport, gvr_rectf fov);
       
void gvr_resume_tracking(gvr_context *gvr);

void gvr_reset_tracking(gvr_context *gvr);

void gvr_recenter_tracking(gvr_context *gvr);

bool gvr_set_default_viewer_profile(gvr_context *gvr, const char *viewer_profile_uri);

void gvr_refresh_viewer_profile(gvr_context *gvr);


gvr_controller_context * gvr_controller_create_and_init(int32_t options,gvr_context *context);

gvr_controller_context * gvr_controller_create_and_init_android(
  JNIEnv *env,
  jobject android_context,
  jobject class_loader,
  int32_t options,
  gvr_context *context);

void gvr_controller_destroy(gvr_controller_context **api);

void gvr_controller_pause(gvr_controller_context *api);

void gvr_controller_resume( gvr_controller_context *api);

const char * gvr_controller_api_status_to_string(  int32_t status);

const char* gvr_controller_battery_level_to_string(int32_t level);

const char * gvr_controller_connection_state_to_string(int32_t state);

const char * gvr_controller_button_to_string(int32_t button);

gvr_controller_state * gvr_controller_state_create();

void gvr_controller_state_destroy(gvr_controller_state **state);

void gvr_controller_state_update(gvr_controller_context *api, int32_t flags, gvr_controller_state *out_state);

int32_t gvr_controller_state_get_api_status(const gvr_controller_state *state);

int32_t gvr_controller_state_get_connection_state(const gvr_controller_state *state);

gvr_quatf gvr_controller_state_get_orientation(const gvr_controller_state *state);
        
gvr_vec3f gvr_controller_state_get_gyro(const gvr_controller_state *state);

gvr_vec3f gvr_controller_state_get_accel(const gvr_controller_state *state);

bool gvr_controller_state_get_battery_charging(const gvr_controller_state* state);

int32_t gvr_controller_state_get_battery_level(const gvr_controller_state* state);

bool gvr_controller_state_is_touching(const gvr_controller_state *state);

gvr_vec2f gvr_controller_state_get_touch_pos(const gvr_controller_state *state);

bool gvr_controller_state_get_touch_down(const gvr_controller_state *state);

bool gvr_controller_state_get_touch_up(const gvr_controller_state *state);
       
bool gvr_controller_state_get_recentered(const gvr_controller_state *state);

bool gvr_controller_state_get_recentering(const gvr_controller_state *state);

bool gvr_controller_state_get_button_state(const gvr_controller_state *state, int32_t button);

bool gvr_controller_state_get_button_down(const gvr_controller_state *state, int32_t button);

bool gvr_controller_state_get_button_up(const gvr_controller_state *state, int32_t button);

int64_t gvr_controller_state_get_last_orientation_timestamp(const gvr_controller_state *state);

int64_t gvr_controller_state_get_last_battery_timestamp(const gvr_controller_state* state);

int64_t gvr_controller_state_get_last_gyro_timestamp(const gvr_controller_state *state);

int64_t gvr_controller_state_get_last_accel_timestamp(const gvr_controller_state *state);
        
int64_t gvr_controller_state_get_last_touch_timestamp(const gvr_controller_state *state);

int64_t gvr_controller_state_get_last_button_timestamp(const gvr_controller_state *state);

int32_t gvr_controller_get_default_options();
       
/////////////////////////
/////////////////////
int gvr_set_viewer_params(int *a1, const void *a2, size_t a3);
int gvr_set_display_metrics( int *a1, int a2, int a3, int a4, int a5, int a6);
int gvr_set_back_gesture_event_handler(int a1, int a2, int a3);
int gvr_display_synchronizer_create();
int gvr_display_synchronizer_destroy(int *a1);
int gvr_get_border_size_meters(void *a1);
bool gvr_get_button_long_press(const gvr_controller_state* controller_state,
                               const gvr_gesture_context* context,
                               gvr_controller_button button);
int gvr_check_surface_size_changed(int a1);
int gvr_get_surface_size(int a1, int a2, int a3);
int gvr_set_display_output_rotation(void *a1, int a2);
int gvr_reconnect_sensors( void *a1);
int gvr_set_lens_offset(int *a1, int a2, int a3);
int gvr_resume(int a1);
int gvr_dump_debug_data(void *a1);
int gvr_external_surface_create_with_listeners(int a1, int a2, int a3, int a4);
int gvr_external_surface_destroy(void **a1, int a2, int a3);
int gvr_external_surface_get_surface(int a1, int a2, int a3);
int gvr_external_surface_get_surface_id(int *a1, int a2, int a3);
bool gvr_using_dynamic_library(int a1, int a2, int a3);
int gvr_using_vr_display_service( int a1);
int gvr_tracker_state_get_buffer_size(int a1);
int gvr_tracker_state_get_buffer(int a1);
int gvr_pause(int a1);
int gvr_set_ignore_manual_tracker_pause_resume(void *a1, int a2);
int gvr_display_synchronizer_update(int *a1, int a2, int64_t a3, int a4);
int gvr_remove_all_surfaces_reprojection_thread(void *a1);
int gvr_set_async_reprojection_enabled(int a1, int a2);
int gvr_on_surface_created_reprojection_thread( int a1);
int gvr_render_reprojection_thread(int a1);
int gvr_tracker_state_destroy( int *a1);
int gvr_resume_tracking_set_state(int a1, int a2, int a3);
int gvr_pause_tracking_get_state( void *a1);
int gvr_tracker_state_create(int a1, int a2);
int gvr_create_with_tracker_for_testing( int a1, int a2);
int gvr_set_error(int a1, int a2);
int gvr_set_idle_listener(int *a1, int a2, int a3);
int gvr_set_display_synchronizer( int *a1, int a2);
int gvr_display_synchronizer_reset(void *a1);
int gvr_on_pause_reprojection_thread(int a1);
int gvr_on_surface_changed_reprojection_thread(int a1, int a2, int a3);
int gvr_update_surface_reprojection_thread(int *a1, int a2, int a3, int a4, int64_t a5,
                                           int a6, int a7, int a8, int a9, int a10, int a11,
                                           int a12, int a13, int a14, int a15, int a16, int a17,
                                           int a18, int a19, int a20, int a21);

int Java_com_google_geo_render_mirth_api_MirthNet_setHttpProxy(int a1);

#ifdef __cplusplus
}
#endif

#endif //UNITYINTERFACE_UNITYINTERFACE_H
