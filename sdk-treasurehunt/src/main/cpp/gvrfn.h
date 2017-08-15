//
// Created by mac on 16/8/19.
//

#ifndef LIBGVR_H
#define LIBGVR_H

#include <jni.h>
#include <android/log.h>

#include "gvr_controller.h"
#include "gvr_types.h"
#include "gvr_gesture.h"

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

typedef gvr_sizei (*FP_swap_chain_get_buffer_size)( gvr_swap_chain *swap_chain, int32_t index);

typedef int (*FP_set_error)(int a1, int a2);

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
typedef int (*FP_check_surface_size_changed)(int a1);
typedef int (*FP_get_surface_size)(int a1, int a2, int a3);
typedef int (*FP_set_display_output_rotation)(void *a1, int a2);
typedef int (*FP_reconnect_sensors)(void *a1);
typedef int (*FP_set_lens_offset)(int *a1, int a2, int a3);
typedef int (*FP_resume)(int a1);
typedef int (*FP_dump_debug_data)(void *a1);
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

typedef bool (*FP_controller_state_is_touching)( const gvr_controller_state *state);
typedef gvr_vec2f (*FP_controller_state_get_touch_pos)(const gvr_controller_state *state);

typedef bool (*FP_controller_state_get_touch_down)(const gvr_controller_state *state);
typedef bool (*FP_controller_state_get_touch_up)(const gvr_controller_state *state);
typedef bool (*FP_controller_state_get_recentered)(const gvr_controller_state *state);
typedef bool (*FP_controller_state_get_recentering)(const gvr_controller_state *state);
typedef int (*FP_on_pause_reprojection_thread)(int a1);
typedef bool (*FP_controller_state_get_button_state)(  const gvr_controller_state *state,
                                                       int32_t button);
typedef int (*FP_update_surface_reprojection_thread)(int *a1, int a2, int a3, int a4, int64_t a5,
                                                     int a6, int a7, int a8, int a9, int a10, int a11,
                                                     int a12, int a13, int a14, int a15, int a16, int a17,
                                                     int a18, int a19, int a20, int a21);
typedef bool (*FP_controller_state_get_button_down)( const gvr_controller_state *state,
                                                      int32_t button);

typedef bool (*FP_controller_state_get_button_up)(const gvr_controller_state *state,
                                                  int32_t button);
typedef int (*FP_remove_all_surfaces_reprojection_thread)(void *a1);
typedef int64_t (*FP_controller_state_get_last_orientation_timestamp)(const gvr_controller_state *state);
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

#define DEF_VARIABLES(name) FP_##name m_fp##name

extern JavaVM *gs_jvm;
JNIEnv* AttachCurrentThreadJNI();
void DetachCurrentThreadJNI();

class CGVRAPI
{
public:
    CGVRAPI();
    virtual  ~CGVRAPI();

    bool Init();
    void Release();

    long CardboardViewNativeImpl_nativeSetApplicationState(JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext);
    void CardboardViewNativeImpl_nativeSetScreenParams(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1,
                                                       jint paramInt2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3);
    void CardboardViewNativeImpl_nativeSetNeckModelFactor(JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat);
    float CardboardViewNativeImpl_nativeGetNeckModelFactor(JNIEnv* env, jobject obj, jlong paramLong);
    void CardboardViewNativeImpl_nativeOnDrawFrame(JNIEnv* env, jobject obj, jlong paramLong);
    void CardboardViewNativeImpl_nativeSetNeckModelEnabled(JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean);
    void CardboardViewNativeImpl_nativeDestroy(JNIEnv* env, jobject obj, jlong paramLong);
    void CardboardViewNativeImpl_nativeOnSurfaceCreated( JNIEnv* env, jobject obj, jlong paramLong);
    void CardboardViewNativeImpl_nativeOnSurfaceChanged(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2);
    void CardboardViewNativeImpl_nativeSetStereoModeEnabled(JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean);
    void CardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled(JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean);
    void CardboardViewNativeImpl_nativeSetDistortionCorrectionScale(JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat);
    void CardboardViewNativeImpl_nativeSetMultisampling(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    void CardboardViewNativeImpl_nativeSetDepthStencilFormat(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    void CardboardViewNativeImpl_nativeUndistortTexture(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    void CardboardViewNativeImpl_nativeLogEvent(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    void CardboardViewNativeImpl_nativeSetGvrViewerParams(JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte);
    void CardboardViewNativeImpl_nativeSetStereoRenderer(JNIEnv* env, jobject obj, jlong paramLong, jobject paramStereoRenderer);
    void CardboardViewNativeImpl_nativeSetRenderer(JNIEnv* env, jobject obj, jlong paramLong, jobject paramRenderer);
    void CardboardViewNativeImpl_nativeGetCurrentEyeParams(JNIEnv* env, jobject obj, jlong paramLong, jobject paramHeadTransform, jobject paramEye1,
                                                           jobject paramEye2, jobject paramEye3, jobject paramEye4, jobject paramEye5);
    long CardboardViewNativeImpl_nativeInit(JNIEnv* env, jobject obj, jlong paramLong);
    void NativeCallbacks_handleStateChanged(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2);
    void NativeCallbacks_handleControllerRecentered(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1,
                                                    jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4);
    void NativeCallbacks_handleTouchEvent(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt,
                                          jfloat paramFloat1, jfloat paramFloat2);
    void NativeCallbacks_handleOrientationEvent(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2,
                                                jfloat paramFloat3, jfloat paramFloat4);
    void NativeCallbacks_handleButtonEvent(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt, jboolean paramBoolean);
    void NativeCallbacks_handleAccelEvent(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3);
    void NativeCallbacks_handleBatteryEvent(JNIEnv* env, jobject obj, jlong var1, jlong var3, jboolean var5, jint var6);
    void NativeCallbacks_handleGyroEvent(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3);
    void NativeCallbacks_handleServiceInitFailed(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    void NativeCallbacks_handleServiceFailed(JNIEnv* env, jobject obj, jlong paramLong);
    void NativeCallbacks_handleServiceUnavailable(JNIEnv* env, jobject obj, jlong paramLong);
    void NativeCallbacks_handleServiceConnected(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    void NativeCallbacks_handleServiceDisconnected(JNIEnv* env, jobject obj, jlong paramLong);
    int MirthNet_setHttpProxy(int a1);
    void VrParamsProviderJni_nativeUpdateNativePhoneParamsPointer(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1, jfloat paramFloat2);
    void GvrApi_nativeRecenterTracking(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeGetEyeFromHeadMatrix(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jfloatArray paramArrayOfFloat);
    int GvrApi_nativeGetViewerType(JNIEnv* env, jobject obj, jlong paramLong);
    bool GvrApi_nativeSetAsyncReprojectionEnabled(JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBool);
    void GvrApi_nativeGetHeadSpaceFromStartSpaceRotation(JNIEnv* env, jobject obj, jlong paramLong1, jfloatArray paramArrayOfFloat, jlong paramLong2);
    void GvrApi_nativeSetIgnoreManualPauseResumeTracker(JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean);
    void GvrApi_nativeResetTracking(JNIEnv* env, jobject obj, jlong paramLong);
    jobject GvrApi_nativeRenderReprojectionThread(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeOnPauseReprojectionThread(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeSetDefaultFramebufferActive(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeGetScreenBufferViewports(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2);
    void GvrApi_nativeGetMaximumEffectiveRenderTargetSize(JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint);
    void GvrApi_nativeGetScreenTargetSize(JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint);
    void GvrApi_nativeDistortToScreen(JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2,
                                      jfloatArray paramArrayOfFloat, jlong paramLong3);
    int GvrApi_nativeBufferViewportListGetSize(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeBufferViewportListGetItem(JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2);
    void GvrApi_nativeBufferViewportListSetItem(JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2);
    long GvrApi_nativeBufferViewportCreate(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeRemoveAllSurfacesReprojectionThread(JNIEnv* env, jobject obj, jlong paramLong);
    bool GvrApi_nativeUsingVrDisplayService(JNIEnv* env, jobject obj, jlong paramLong);
    long GvrApi_nativeBufferViewportListCreate(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeBufferViewportListDestroy(JNIEnv* env, jobject obj, jlong paramLong);
    float GvrApi_nativeGetBorderSizeMeters(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeSetSurfaceSize(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2);
    void GvrApi_nativeSetLensOffset(JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat1, jfloat paramFloat2);
    void GvrApi_nativeUpdateSurfaceReprojectionThread(JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt1, jint paramInt2, jlong paramLong2, jfloatArray paramArrayOfFloat);
    bool GvrApi_nativeGetAsyncReprojectionEnabled(JNIEnv* env, jobject obj, jlong paramLong);
    bool GvrApi_nativeIsFeatureSupported(JNIEnv* env, jobject obj, jlong paramLong, jint jvar);
    void GvrApi_nativeReconnectSensors(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeSetIdleListener(JNIEnv* env, jobject obj, jlong paramLong, jobject jvar);
    void GvrApi_nativeSetDisplayMetrics(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2,
                                        jfloat paramFloat1, jfloat paramFloat2);
    void DisplaySynchronizer_nativeReset(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jlong paramLong3);
    void DisplaySynchronizer_nativeUpdate(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt);
    void ExternalSurfaceManager_nativeUpdateSurface(JNIEnv* env, jobject obj, jlong var0, jint var2, jint var3, jlong var4, jfloatArray var6);
    long DisplaySynchronizer_nativeCreate(JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext);
    void DisplaySynchronizer_nativeDestroy(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeDumpDebugData(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeInitializeGl(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeOnSurfaceCreatedReprojectionThread(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeOnSurfaceChangedReprojectionThread(JNIEnv* env, jobject obj, jlong paramlong);
    void GvrApi_nativeGetRecommendedBufferViewports(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2);
    int GvrApi_nativeGetError(JNIEnv* env, jobject obj, jlong paramLong);
    int GvrApi_nativeClearError( JNIEnv* env, jobject obj, jlong paramLong);
    long GvrApi_nativeGetUserPrefs(JNIEnv* env, jobject obj, jlong paramLong);
    int GvrApi_nativeUserPrefsGetControllerHandedness(JNIEnv* env, jobject obj, jlong paramLong);
    jboolean GvrApi_nativeUserPrefsGetPerformanceMonitoringEnabled(JNIEnv* env, jobject obj, jlong paramLong);
    jboolean GvrApi_nativeUserPrefsGetPerformanceHudEnabled(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativePause(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeResume(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeReleaseGvrContext(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeBufferViewportDestroy(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeBufferViewportGetSourceUv(JNIEnv* env, jobject obj, jlong paramLong, jobject paramRectF);
    void GvrApi_nativeBufferViewportSetSourceUv(JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat1, jfloat paramFloat2,
                                                jfloat paramFloat3, jfloat paramFloat4);
    void GvrApi_nativeBufferViewportGetSourceFov(JNIEnv* env, jobject obj, jlong paramLong, jobject paramRectF);
    void GvrApi_nativeBufferViewportSetSourceFov(JNIEnv* env, jobject obj,  jlong paramLong, jfloat paramFloat1, jfloat paramFloat2,
                                                 jfloat paramFloat3, jfloat paramFloat4);
    void GvrApi_nativeBufferViewportGetTransform(JNIEnv* env, jobject obj, jlong paramLong, jfloatArray paramArrayOffloat);
    void GvrApi_nativeBufferViewportSetTransform(JNIEnv* env, jobject obj, jlong paramLong, jfloatArray paramArrayOfFloat);
    int GvrApi_nativeBufferViewportGetTargetEye(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeBufferViewportSetTargetEye(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    int GvrApi_nativeBufferViewportGetSourceBufferIndex(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeBufferViewportSetSourceBufferIndex(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    int GvrApi_nativeBufferViewportGetExternalSurfaceId(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeBufferViewportSetExternalSurfaceId(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    void GvrApi_nativeBufferViewportSetExternalSurface(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    int GvrApi_nativeBufferViewportGetReprojection(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeBufferViewportSetReprojection(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    void GvrApi_nativeBufferViewportSetSourceLayer(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    bool GvrApi_nativeBufferViewportEqual(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2);
    long GvrApi_nativeBufferSpecCreate(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeBufferSpecDestroy(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeBufferSpecGetSize(JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint);
    void GvrApi_nativeBufferSpecSetSize(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jint paramInt2);
    int GvrApi_nativeBufferSpecGetSamples(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeBufferSpecSetSamples(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    long GvrApi_nativeExternalSurfaceCreate(JNIEnv* env, jobject obj, jlong paramLong);
    long GvrApi_nativeExternalSurfaceCreateWithListeners(JNIEnv* env, jobject obj, jlong paramLong, jobject var2, jobject var3, jobject var4);
    void GvrApi_nativeExternalSurfaceDestroy( JNIEnv* env, jobject obj, jlong paramLong);
    jint GvrApi_nativeExternalSurfaceGetId(JNIEnv* env, jobject obj, jlong paramLong);
    jobject GvrApi_nativeExternalSurfaceGetSurface(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeBufferSpecSetColorFormat(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    void GvrApi_nativeBufferSpecSetDepthStencilFormat(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    void GvrApi_nativeBufferSpecSetMultiviewLayers( JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    void GvrApi_nativeSwapChainDestroy(JNIEnv* env, jobject obj, jlong paramLong);
    int GvrApi_nativeSwapChainGetBufferCount(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeSwapChainGetBufferSize(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jobject paramPoint);
    void GvrApi_nativeSwapChainResizeBuffer(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jint paramInt3);
    long GvrApi_nativeSwapChainAcquireFrame(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeFrameBindBuffer(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    void GvrApi_nativeFrameUnbind(JNIEnv* env, jobject obj, jlong paramLong);
    int GvrApi_nativeFrameGetFramebufferObject(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);
    void GvrApi_nativeFrameGetBufferSize(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jobject paramPoint);
    void GvrApi_nativeFrameSubmit(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloatArray paramArrayOfFloat);
    jboolean GvrApi_nativeUsingDynamicLibrary(JNIEnv* env, jobject obj);
    void GvrApi_nativeSetApplicationState(JNIEnv* env, jobject obj, jobject jclassloader, jobject jcontext);
    void GvrApi_nativeSetDynamicLibraryLoadingEnabled(JNIEnv* env, jobject obj, jboolean jvar);
    void GvrApi_nativeResumeTracking(JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte);
    void GvrApi_nativeResumeTrackingSetState(JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte);
    bool GvrApi_nativeSetDefaultViewerProfile(JNIEnv* env, jobject obj, jlong paramLong, jstring paramString);
    bool GvrApi_nativeSetViewerParams(JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte);
    long GvrApi_nativeSwapChainCreate(JNIEnv* env, jobject obj, jlong paramLong, jlongArray paramArrayOfLong);
    long GvrApi_nativeCreate(JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext, jlong paramLong, jint paramInt1,
                             jint paramInt2, jfloat paramFloat1, jfloat paramFloat2, jobject paramPoseTracker);
    void GvrApi_nativeRequestContextSharing(JNIEnv* env, jobject obj, jlong paramlong, jobject jvar);
    jfloatArray GvrApi_nativeComputeDistortedPoint(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jfloatArray paramArrayOfFloat);
    jstring GvrApi_nativeGetErrorString(JNIEnv* env, jobject obj, jint paramInt);
    jstring GvrApi_nativeGetViewerVendor(JNIEnv* env, jobject obj, jlong paramLong);
    jstring GvrApi_nativeGetViewerModel( JNIEnv* env, jobject obj, jlong paramLong);
    jbyteArray GvrApi_nativePauseTracking( JNIEnv* env, jobject obj, jlong paramLong);
    jbyteArray GvrApi_nativePauseTrackingGetState(JNIEnv* env, jobject obj, jlong paramLong);
    jintArray GvrApi_nativeGetWindowBounds(JNIEnv* env, jobject obj, jlong paramLong);
    jint JNI_OnLoad(JavaVM* vm, void* reserved);
    void buffer_viewport_list_destroy(gvr_buffer_viewport_list **viewport_list);
    void swap_chain_destroy(gvr_swap_chain **swap_chain);
    void destroy(gvr_context **gvr);
    void buffer_viewport_destroy(gvr_buffer_viewport **viewport);
    gvr_swap_chain* swap_chain_create( gvr_context *gvr, const gvr_buffer_spec **buffers, int32_t count);
    void bind_default_framebuffer(gvr_context *gvr);
    gvr_sizei get_maximum_effective_render_target_size(const gvr_context *gvr);
    void buffer_spec_set_samples(gvr_buffer_spec *spec, int32_t num_samples);
    void buffer_spec_set_depth_stencil_format(gvr_buffer_spec *spec, int32_t depth_stencil_format);
    void buffer_spec_set_multiview_layer(gvr_buffer_spec* spec, int32_t num_layers);
    void buffer_spec_set_size( gvr_buffer_spec *spec, gvr_sizei size);
    gvr_buffer_spec* buffer_spec_create( gvr_context *gvr);
    void initialize_gl(gvr_context *gvr);
    void distort_to_screen(gvr_context *gvr,
                           int32_t texture_id,
                           const gvr_buffer_viewport_list *viewport_list,
                           gvr_mat4f head_space_from_start_space,
                           gvr_clock_time_point target_presentation_time);
    bool is_feature_supported(const gvr_context* gvr, int32_t feature);
    gvr_clock_time_point get_time_point_now();
    int set_viewer_params(int *a1, const void *a2, size_t a3);
    int set_display_metrics(int *a1, int a2, int a3, int a4, int a5, int a6);
    void buffer_spec_destroy(gvr_buffer_spec **spec);
    gvr_mat4f get_eye_from_head_matrix( const gvr_context *gvr,
                                        const int32_t eye);
    gvr_sizei swap_chain_get_buffer_size( gvr_swap_chain *swap_chain, int32_t index);
    int set_error(int a1, int a2);
    void compute_distorted_point(  const gvr_context *gvr,
                                   const int32_t eye,
                                   const gvr_vec2f uv_in,
                                   gvr_vec2f uv_out[3]);

    void get_recommended_buffer_viewports(  const gvr_context *gvr,
                                            gvr_buffer_viewport_list *viewport_list);
    bool buffer_viewport_equal( const gvr_buffer_viewport *a,
                                const gvr_buffer_viewport *b);
    void buffer_viewport_list_get_item(  const gvr_buffer_viewport_list *viewport_list,
                                         size_t index,
                                         gvr_buffer_viewport *viewport);
    gvr_sizei buffer_spec_get_size(const gvr_buffer_spec *spec);
    int32_t buffer_viewport_get_target_eye( const gvr_buffer_viewport *viewport);
    int32_t buffer_spec_get_samples(const gvr_buffer_spec *spec);
    gvr_rectf buffer_viewport_get_source_fov(const gvr_buffer_viewport *viewport);
    int32_t swap_chain_get_buffer_count(const gvr_swap_chain *swap_chain);
    int32_t buffer_viewport_get_reprojection(const gvr_buffer_viewport *viewport);
    void buffer_viewport_set_reprojection(  gvr_buffer_viewport *viewport, int32_t reprojection);
    void buffer_viewport_set_source_layer(gvr_buffer_viewport* viewport, int32_t layer_index);
    void buffer_viewport_set_source_uv(  gvr_buffer_viewport *viewport, gvr_rectf uv);
    void buffer_viewport_list_set_item(  gvr_buffer_viewport_list *viewport_list, size_t index, const gvr_buffer_viewport *viewport);
    int32_t user_prefs_get_controller_handedness(const gvr_user_prefs *user_prefs);
    void get_screen_buffer_viewports(  const gvr_context *gvr, gvr_buffer_viewport_list *viewport_list);
    gvr_sizei get_screen_target_size(const gvr_context *gvr);
    gvr_rectf buffer_viewport_get_source_uv(const gvr_buffer_viewport *viewport);
    gvr_recti get_window_bounds(const gvr_context *gvr);

    gvr_mat4f get_head_space_from_start_space_rotation( const gvr_context *gvr, const gvr_clock_time_point time);

    gvr_mat4f apply_neck_model(  const gvr_context *gvr,
                                               gvr_mat4f head_space_from_start_space_rotation,
                                               float factor);
    gvr_frame* swap_chain_acquire_frame(gvr_swap_chain *swap_chain);
    gvr_context* create(  JNIEnv *env, jobject app_context, jobject class_loader);

    void frame_bind_buffer(  gvr_frame *frame, int32_t index);

    void frame_unbind(gvr_frame *frame);
    gvr_gesture_context* gesture_context_create();
    void gesture_context_destroy(gvr_gesture_context** context);
    const gvr_gesture* gesture_get(const gvr_gesture_context* context, int index);
    int gesture_get_count(const gvr_gesture_context* context);
    gvr_gesture_direction gesture_get_direction(const gvr_gesture* gesture);
    gvr_vec2f gesture_get_displacement(const gvr_gesture* gesture);
    gvr_gesture_type gesture_get_type(const gvr_gesture* gesture);
    gvr_vec2f gesture_get_velocity(const gvr_gesture* gesture);
    void gesture_restart(gvr_gesture_context* context);
    void frame_submit(  gvr_frame **frame, const gvr_buffer_viewport_list *list, gvr_mat4f head_space_from_start_space);

    void swap_chain_resize_buffer(  gvr_swap_chain *swap_chain, int32_t index, gvr_sizei size);

    gvr_buffer_viewport_list * buffer_viewport_list_create( const gvr_context *gvr);

    const gvr_user_prefs * get_user_prefs(gvr_context *gvr);

    gvr_buffer_viewport * buffer_viewport_create(gvr_context *gvr);

    int set_back_gesture_event_handler(int a1, int a2, int a3);
    gvr_version get_version();

    const char * get_viewer_vendor(const gvr_context *gvr);
    const char * get_version_string();
    const char * get_viewer_model(const gvr_context *gvr);
    int32_t get_error(gvr_context *gvr);
    int32_t get_viewer_type(const gvr_context *gvr);
    int32_t clear_error(gvr_context *gvr);
    const char * get_error_string(int32_t error_code);
    int32_t buffer_viewport_get_source_buffer_index(const gvr_buffer_viewport *viewport);
    bool get_async_reprojection_enabled(const gvr_context *gvr);
    void buffer_viewport_set_source_buffer_index( gvr_buffer_viewport *viewport,
                                                                int32_t buffer_index);

    size_t buffer_viewport_list_get_size( const gvr_buffer_viewport_list *viewport_list);
    int32_t buffer_viewport_get_external_surface_id( const gvr_buffer_viewport *viewport);
    void buffer_viewport_set_external_surface_id(  gvr_buffer_viewport *viewport,
                                                                 int32_t external_surface_id);

    void set_surface_size( gvr_context *gvr, gvr_sizei surface_size_pixels);

    gvr_mat4f buffer_viewport_get_transform(const gvr_buffer_viewport *viewport);

    void buffer_spec_set_color_format(  gvr_buffer_spec *spec, int32_t color_format);

    void buffer_viewport_set_transform(gvr_buffer_viewport *viewport,
                                                     gvr_mat4f transform);
    void buffer_viewport_set_target_eye(  gvr_buffer_viewport *viewport, int32_t index);

    gvr_sizei frame_get_buffer_size(  const gvr_frame *frame, int32_t index);

    int32_t frame_get_framebuffer_object(  const gvr_frame *frame, int32_t index);

    void pause_tracking( gvr_context *gvr);
    void buffer_viewport_set_source_fov( gvr_buffer_viewport *viewport, gvr_rectf fov);

    void resume_tracking(gvr_context *gvr);
    void reset_tracking(gvr_context *gvr);

    void recenter_tracking(gvr_context *gvr);

    bool set_default_viewer_profile(  gvr_context *gvr, const char *viewer_profile_uri);

    void refresh_viewer_profile(gvr_context *gvr);

    int display_synchronizer_create();
    int display_synchronizer_destroy(int *a1);
    int get_border_size_meters(void *a1);
    int check_surface_size_changed(int a1);
    int get_surface_size(int a1, int a2, int a3);
    int set_display_output_rotation(void *a1, int a2);
    int reconnect_sensors(void *a1);
    int set_lens_offset(int *a1, int a2, int a3);
    int resume(int a1);
    int dump_debug_data(void *a1);
    int32_t controller_get_default_options();
    int using_vr_display_service(int a1);
    int tracker_state_get_buffer_size(int a1);
    gvr_controller_context *controller_create_and_init(int32_t options,gvr_context *context);
    int tracker_state_get_buffer(int a1);
    int pause(int a1);
    gvr_controller_context * controller_create_and_init_android(  JNIEnv *env,
                                                                                jobject android_context,
                                                                                jobject class_loader,
                                                                                int32_t options,
                                                                                gvr_context *context);
    void controller_destroy( gvr_controller_context **api);

    int  set_display_synchronizer(int *a1, int a2);
    void controller_pause(gvr_controller_context *api);
    int set_ignore_manual_tracker_pause_resume(void *a1, int a2);
    void controller_resume(gvr_controller_context *api);
    int display_synchronizer_reset(void *a1);

    const char* controller_api_status_to_string( int32_t status);

    const char* controller_connection_state_to_string(int32_t state);
    int display_synchronizer_update(int *a1, int a2, int64_t a3, int a4);
    const char * controller_button_to_string( int32_t button);
    gvr_controller_state * controller_state_create();
    void controller_state_destroy(gvr_controller_state **state);
    void controller_state_update(  gvr_controller_context *api,
                                                 int32_t flags,
                                                 gvr_controller_state *out_state);
    int32_t controller_state_get_api_status(const gvr_controller_state *state);
    int32_t controller_state_get_connection_state(const gvr_controller_state *state);
    gvr_quatf controller_state_get_orientation(const gvr_controller_state *state);

    gvr_vec3f controller_state_get_gyro(const gvr_controller_state *state);

    gvr_vec3f controller_state_get_accel( const gvr_controller_state *state);

    bool controller_state_is_touching( const gvr_controller_state *state);
    gvr_vec2f controller_state_get_touch_pos(const gvr_controller_state *state);

    bool controller_state_get_touch_down(const gvr_controller_state *state);
    bool controller_state_get_touch_up(const gvr_controller_state *state);
    bool controller_state_get_recentered(const gvr_controller_state *state);
    bool controller_state_get_recentering(const gvr_controller_state *state);
    int on_pause_reprojection_thread(int a1);
    bool controller_state_get_button_state(  const gvr_controller_state *state,
                                                           int32_t button);
    int update_surface_reprojection_thread(int *a1, int a2, int a3, int a4, int64_t a5,
                                                         int a6, int a7, int a8, int a9, int a10, int a11,
                                                         int a12, int a13, int a14, int a15, int a16, int a17,
                                                         int a18, int a19, int a20, int a21);
    bool controller_state_get_button_down( const gvr_controller_state *state,
                                                         int32_t button);

    bool controller_state_get_button_up(const gvr_controller_state *state,
                                                      int32_t button);
    int remove_all_surfaces_reprojection_thread(void *a1);
    int64_t controller_state_get_last_orientation_timestamp(const gvr_controller_state *state);
    int64_t controller_state_get_last_gyro_timestamp(const gvr_controller_state *state);
    int set_async_reprojection_enabled(int a1, int a2);
    int64_t controller_state_get_last_accel_timestamp(const gvr_controller_state *state);
    int on_surface_created_reprojection_thread(int a1);
    int64_t controller_state_get_last_touch_timestamp(const gvr_controller_state *state);
    int render_reprojection_thread(int a1);
    int64_t controller_state_get_last_button_timestamp(const gvr_controller_state *state);
    int tracker_state_destroy(int *a1);
    int resume_tracking_set_state(int a1, int a2, int a3);
    int pause_tracking_get_state(void *a1);
    int tracker_state_create(int a1, int a2);
    int create_with_tracker_for_testing(int a1, int a2);

private:
    void * m_hDLL;
    bool m_bInit;

    DEF_VARIABLES(create_with_tracker_for_testing);
    DEF_VARIABLES(tracker_state_create);
    DEF_VARIABLES(pause_tracking_get_state);
    DEF_VARIABLES(resume_tracking_set_state);
    DEF_VARIABLES(tracker_state_destroy);
    DEF_VARIABLES(controller_state_get_last_button_timestamp);
    DEF_VARIABLES(render_reprojection_thread);
    DEF_VARIABLES(controller_state_get_last_touch_timestamp);
    DEF_VARIABLES(on_surface_created_reprojection_thread);
    DEF_VARIABLES(controller_state_get_last_accel_timestamp);
    DEF_VARIABLES(set_async_reprojection_enabled);
    DEF_VARIABLES(controller_state_get_last_gyro_timestamp);
    DEF_VARIABLES(controller_state_get_last_orientation_timestamp);
    DEF_VARIABLES(remove_all_surfaces_reprojection_thread);
    DEF_VARIABLES(controller_state_get_button_up);
    DEF_VARIABLES(controller_state_get_button_down);
    DEF_VARIABLES(update_surface_reprojection_thread);
    DEF_VARIABLES(controller_state_get_button_state);
    DEF_VARIABLES(on_pause_reprojection_thread);
    DEF_VARIABLES(controller_state_get_recentering);
    DEF_VARIABLES(controller_state_get_recentered);
    DEF_VARIABLES(controller_state_get_touch_up);
    DEF_VARIABLES(controller_state_get_touch_down);
    DEF_VARIABLES(controller_state_get_touch_pos);
    DEF_VARIABLES(controller_state_is_touching);
    DEF_VARIABLES(controller_state_get_accel);
    DEF_VARIABLES(controller_state_get_gyro);
    DEF_VARIABLES(controller_state_get_orientation);
    DEF_VARIABLES(controller_state_get_connection_state);
    DEF_VARIABLES(controller_state_get_api_status);
    DEF_VARIABLES(controller_state_update);
    DEF_VARIABLES(controller_state_destroy);
    DEF_VARIABLES(controller_state_create);
    DEF_VARIABLES(controller_button_to_string);
    DEF_VARIABLES(display_synchronizer_update);
    DEF_VARIABLES(controller_connection_state_to_string);
    DEF_VARIABLES(controller_api_status_to_string);
    DEF_VARIABLES(display_synchronizer_reset);
    DEF_VARIABLES(controller_resume);
    DEF_VARIABLES(set_ignore_manual_tracker_pause_resume);
    DEF_VARIABLES(controller_pause);
    DEF_VARIABLES(set_display_synchronizer);
    DEF_VARIABLES(controller_destroy);
    DEF_VARIABLES(controller_create_and_init_android);
    DEF_VARIABLES(pause);
    DEF_VARIABLES(tracker_state_get_buffer);
    DEF_VARIABLES(controller_create_and_init);
    DEF_VARIABLES(tracker_state_get_buffer_size);
    DEF_VARIABLES(using_vr_display_service);
    DEF_VARIABLES(controller_get_default_options);
    DEF_VARIABLES(dump_debug_data);
    DEF_VARIABLES(resume);
    DEF_VARIABLES(set_lens_offset);
    DEF_VARIABLES(reconnect_sensors);
    DEF_VARIABLES(set_display_output_rotation);
    DEF_VARIABLES(get_surface_size);
    DEF_VARIABLES(check_surface_size_changed);
    DEF_VARIABLES(get_border_size_meters);
    DEF_VARIABLES(display_synchronizer_destroy);
    DEF_VARIABLES(display_synchronizer_create);
    DEF_VARIABLES(refresh_viewer_profile);
    DEF_VARIABLES(set_default_viewer_profile);
    DEF_VARIABLES(recenter_tracking);
    DEF_VARIABLES(reset_tracking);
    DEF_VARIABLES(resume_tracking);
    DEF_VARIABLES(buffer_viewport_set_source_fov);
    DEF_VARIABLES(pause_tracking);
    DEF_VARIABLES(frame_get_framebuffer_object);
    DEF_VARIABLES(frame_get_buffer_size);
    DEF_VARIABLES(buffer_viewport_set_target_eye);
    DEF_VARIABLES(buffer_viewport_set_transform);
    DEF_VARIABLES(buffer_spec_set_color_format);
    DEF_VARIABLES(buffer_viewport_get_transform);
    DEF_VARIABLES(set_surface_size);
    DEF_VARIABLES(buffer_viewport_set_external_surface_id);
    DEF_VARIABLES(buffer_viewport_get_external_surface_id);
    DEF_VARIABLES(buffer_viewport_list_get_size);
    DEF_VARIABLES(buffer_viewport_set_source_buffer_index);
    DEF_VARIABLES(get_async_reprojection_enabled);
    DEF_VARIABLES(buffer_viewport_get_source_buffer_index);
    DEF_VARIABLES(get_error_string);
    DEF_VARIABLES(clear_error);
    DEF_VARIABLES(get_viewer_type);
    DEF_VARIABLES(get_error);
    DEF_VARIABLES(get_viewer_model);
    DEF_VARIABLES(get_version_string);
    DEF_VARIABLES(get_viewer_vendor);
    DEF_VARIABLES(get_version);
    DEF_VARIABLES(set_back_gesture_event_handler);
    DEF_VARIABLES(buffer_viewport_create);
    DEF_VARIABLES(get_user_prefs);
    DEF_VARIABLES(buffer_viewport_list_create);
    DEF_VARIABLES(swap_chain_resize_buffer);
    DEF_VARIABLES(frame_submit);
    DEF_VARIABLES(frame_unbind);
    DEF_VARIABLES(gesture_context_create);
    DEF_VARIABLES(gesture_context_destroy);
    DEF_VARIABLES(gesture_get);
    DEF_VARIABLES(gesture_get_count);
    DEF_VARIABLES(gesture_get_direction);
    DEF_VARIABLES(gesture_get_displacement);
    DEF_VARIABLES(gesture_get_type);
    DEF_VARIABLES(gesture_get_velocity);
    DEF_VARIABLES(gesture_restart);
    DEF_VARIABLES(frame_bind_buffer);
    DEF_VARIABLES(create);
    DEF_VARIABLES(swap_chain_acquire_frame);
    DEF_VARIABLES(apply_neck_model);
    DEF_VARIABLES(get_head_space_from_start_space_rotation);
    DEF_VARIABLES(get_window_bounds);
    DEF_VARIABLES(buffer_viewport_get_source_uv);
    DEF_VARIABLES(get_screen_target_size);
    DEF_VARIABLES(get_screen_buffer_viewports);
    DEF_VARIABLES(user_prefs_get_controller_handedness);
    DEF_VARIABLES(buffer_viewport_list_set_item);
    DEF_VARIABLES(buffer_viewport_set_source_uv);
    DEF_VARIABLES(buffer_viewport_set_reprojection);
    DEF_VARIABLES(buffer_viewport_set_source_layer);
    DEF_VARIABLES(buffer_viewport_get_reprojection);
    DEF_VARIABLES(swap_chain_get_buffer_count);
    DEF_VARIABLES(buffer_viewport_get_source_fov);
    DEF_VARIABLES(buffer_spec_get_samples);
    DEF_VARIABLES(buffer_viewport_get_target_eye);
    DEF_VARIABLES(buffer_spec_get_size);
    DEF_VARIABLES(buffer_viewport_list_get_item);
    DEF_VARIABLES(buffer_viewport_equal);
    DEF_VARIABLES(get_recommended_buffer_viewports);
    DEF_VARIABLES(compute_distorted_point);
    DEF_VARIABLES(set_error);
    DEF_VARIABLES(swap_chain_get_buffer_size);
    DEF_VARIABLES(get_eye_from_head_matrix);
    DEF_VARIABLES(buffer_spec_destroy);
    DEF_VARIABLES(set_display_metrics);
    DEF_VARIABLES(set_viewer_params);
    DEF_VARIABLES(get_time_point_now);
    DEF_VARIABLES(distort_to_screen);
    DEF_VARIABLES(is_feature_supported);
    DEF_VARIABLES(initialize_gl);
    DEF_VARIABLES(buffer_spec_create);
    DEF_VARIABLES(buffer_spec_set_size);
    DEF_VARIABLES(buffer_spec_set_depth_stencil_format);
    DEF_VARIABLES(buffer_spec_set_multiview_layer);
    DEF_VARIABLES(buffer_spec_set_samples);
    DEF_VARIABLES(get_maximum_effective_render_target_size);
    DEF_VARIABLES(bind_default_framebuffer);
    DEF_VARIABLES(swap_chain_create);
    DEF_VARIABLES(buffer_viewport_destroy);
    DEF_VARIABLES(destroy);
    DEF_VARIABLES(swap_chain_destroy);
    DEF_VARIABLES(JNI_OnLoad);
    DEF_VARIABLES(buffer_viewport_list_destroy);
    DEF_VARIABLES(GvrApi_nativeGetWindowBounds);
    DEF_VARIABLES(GvrApi_nativePauseTracking);
    DEF_VARIABLES(GvrApi_nativePauseTrackingGetState);
    DEF_VARIABLES(GvrApi_nativeGetViewerModel);
    DEF_VARIABLES(GvrApi_nativeGetViewerVendor);
    DEF_VARIABLES(GvrApi_nativeGetErrorString);
    DEF_VARIABLES(GvrApi_nativeComputeDistortedPoint);
    DEF_VARIABLES(GvrApi_nativeCreate);
    DEF_VARIABLES(GvrApi_nativeRequestContextSharing);
    DEF_VARIABLES(GvrApi_nativeSwapChainCreate);
    DEF_VARIABLES(GvrApi_nativeSetViewerParams);
    DEF_VARIABLES(GvrApi_nativeSetDefaultViewerProfile);
    DEF_VARIABLES(GvrApi_nativeResumeTracking);
    DEF_VARIABLES(GvrApi_nativeResumeTrackingSetState);
    DEF_VARIABLES(GvrApi_nativeFrameSubmit);
    DEF_VARIABLES(GvrApi_nativeUsingDynamicLibrary);
    DEF_VARIABLES(GvrApi_nativeSetApplicationState);
    DEF_VARIABLES(GvrApi_nativeSetDynamicLibraryLoadingEnabled);
    DEF_VARIABLES(GvrApi_nativeFrameGetBufferSize);
    DEF_VARIABLES(GvrApi_nativeFrameGetFramebufferObject);
    DEF_VARIABLES(GvrApi_nativeFrameUnbind);
    DEF_VARIABLES(GvrApi_nativeFrameBindBuffer);
    DEF_VARIABLES(GvrApi_nativeSwapChainAcquireFrame);
    DEF_VARIABLES(GvrApi_nativeSwapChainResizeBuffer);
    DEF_VARIABLES(GvrApi_nativeSwapChainGetBufferSize);
    DEF_VARIABLES(GvrApi_nativeSwapChainGetBufferCount);
    DEF_VARIABLES(GvrApi_nativeSwapChainDestroy);
    DEF_VARIABLES(GvrApi_nativeBufferSpecSetDepthStencilFormat);
    DEF_VARIABLES(GvrApi_nativeBufferSpecSetMultiviewLayers);
    DEF_VARIABLES(GvrApi_nativeBufferSpecSetColorFormat);
    DEF_VARIABLES(GvrApi_nativeBufferSpecSetSamples);
    DEF_VARIABLES(GvrApi_nativeExternalSurfaceCreate);
    DEF_VARIABLES(GvrApi_nativeExternalSurfaceCreateWithListeners);
    DEF_VARIABLES(GvrApi_nativeExternalSurfaceDestroy);
    DEF_VARIABLES(GvrApi_nativeExternalSurfaceGetId);
    DEF_VARIABLES(GvrApi_nativeExternalSurfaceGetSurface);
    DEF_VARIABLES(GvrApi_nativeBufferSpecGetSamples);
    DEF_VARIABLES(GvrApi_nativeBufferSpecSetSize);
    DEF_VARIABLES(GvrApi_nativeBufferSpecGetSize);
    DEF_VARIABLES(GvrApi_nativeBufferSpecDestroy);
    DEF_VARIABLES(GvrApi_nativeBufferSpecCreate);
    DEF_VARIABLES(GvrApi_nativeBufferViewportEqual);
    DEF_VARIABLES(GvrApi_nativeBufferViewportSetReprojection);
    DEF_VARIABLES(GvrApi_nativeBufferViewportSetSourceLayer);
    DEF_VARIABLES(GvrApi_nativeBufferViewportGetReprojection);
    DEF_VARIABLES(GvrApi_nativeBufferViewportSetExternalSurfaceId);
    DEF_VARIABLES(GvrApi_nativeBufferViewportSetExternalSurface);
    DEF_VARIABLES(GvrApi_nativeBufferViewportGetExternalSurfaceId);
    DEF_VARIABLES(GvrApi_nativeBufferViewportSetSourceBufferIndex);
    DEF_VARIABLES(GvrApi_nativeBufferViewportGetSourceBufferIndex);
    DEF_VARIABLES(GvrApi_nativeBufferViewportSetTargetEye);
    DEF_VARIABLES(GvrApi_nativeBufferViewportGetTargetEye);
    DEF_VARIABLES(GvrApi_nativeBufferViewportSetTransform);
    DEF_VARIABLES(GvrApi_nativeBufferViewportGetTransform);
    DEF_VARIABLES(GvrApi_nativeBufferViewportSetSourceFov);
    DEF_VARIABLES(GvrApi_nativeBufferViewportGetSourceFov);
    DEF_VARIABLES(GvrApi_nativeBufferViewportSetSourceUv);
    DEF_VARIABLES(GvrApi_nativeBufferViewportGetSourceUv);
    DEF_VARIABLES(GvrApi_nativeBufferViewportDestroy);
    DEF_VARIABLES(GvrApi_nativeReleaseGvrContext);
    DEF_VARIABLES(GvrApi_nativeResume);
    DEF_VARIABLES(GvrApi_nativePause);
    DEF_VARIABLES(GvrApi_nativeUserPrefsGetControllerHandedness);
    DEF_VARIABLES(GvrApi_nativeUserPrefsGetPerformanceMonitoringEnabled);
    DEF_VARIABLES(GvrApi_nativeUserPrefsGetPerformanceHudEnabled);
    DEF_VARIABLES(GvrApi_nativeGetUserPrefs);
    DEF_VARIABLES(GvrApi_nativeClearError);
    DEF_VARIABLES(GvrApi_nativeGetError);
    DEF_VARIABLES(GvrApi_nativeGetRecommendedBufferViewports);
    DEF_VARIABLES(GvrApi_nativeOnSurfaceCreatedReprojectionThread);
    DEF_VARIABLES(GvrApi_nativeOnSurfaceChangedReprojectionThread);
    DEF_VARIABLES(GvrApi_nativeInitializeGl);
    DEF_VARIABLES(GvrApi_nativeDumpDebugData);
    DEF_VARIABLES(DisplaySynchronizer_nativeDestroy);
    DEF_VARIABLES(DisplaySynchronizer_nativeCreate);
    DEF_VARIABLES(DisplaySynchronizer_nativeUpdate);
    DEF_VARIABLES(ExternalSurfaceManager_nativeUpdateSurface);
    DEF_VARIABLES(DisplaySynchronizer_nativeReset);
    DEF_VARIABLES(GvrApi_nativeSetDisplayMetrics);
    DEF_VARIABLES(GvrApi_nativeReconnectSensors);
    DEF_VARIABLES(GvrApi_nativeSetIdleListener);
    DEF_VARIABLES(GvrApi_nativeGetAsyncReprojectionEnabled);
    DEF_VARIABLES(GvrApi_nativeIsFeatureSupported);
    DEF_VARIABLES(GvrApi_nativeSetLensOffset);
    DEF_VARIABLES(GvrApi_nativeSetSurfaceSize);
    DEF_VARIABLES(GvrApi_nativeGetBorderSizeMeters);
    DEF_VARIABLES(GvrApi_nativeBufferViewportListDestroy);
    DEF_VARIABLES(GvrApi_nativeBufferViewportListCreate);
    DEF_VARIABLES(GvrApi_nativeUsingVrDisplayService);
    DEF_VARIABLES(GvrApi_nativeBufferViewportCreate);
    DEF_VARIABLES(GvrApi_nativeBufferViewportListSetItem);
    DEF_VARIABLES(GvrApi_nativeBufferViewportListGetItem);
    DEF_VARIABLES(GvrApi_nativeBufferViewportListGetSize);
    DEF_VARIABLES(GvrApi_nativeDistortToScreen);
    DEF_VARIABLES(GvrApi_nativeGetScreenTargetSize);
    DEF_VARIABLES(GvrApi_nativeGetMaximumEffectiveRenderTargetSize);
    DEF_VARIABLES(GvrApi_nativeGetScreenBufferViewports);
    DEF_VARIABLES(GvrApi_nativeSetDefaultFramebufferActive);
    DEF_VARIABLES(GvrApi_nativeOnPauseReprojectionThread);
    DEF_VARIABLES(GvrApi_nativeRenderReprojectionThread);
    DEF_VARIABLES(GvrApi_nativeResetTracking);
    DEF_VARIABLES(GvrApi_nativeSetIgnoreManualPauseResumeTracker);
    DEF_VARIABLES(GvrApi_nativeGetHeadSpaceFromStartSpaceRotation);
    DEF_VARIABLES(GvrApi_nativeSetAsyncReprojectionEnabled);
    DEF_VARIABLES(GvrApi_nativeGetViewerType);
    DEF_VARIABLES(GvrApi_nativeGetEyeFromHeadMatrix);
    DEF_VARIABLES(GvrApi_nativeRecenterTracking);
    DEF_VARIABLES(VrParamsProviderJni_nativeUpdateNativePhoneParamsPointer);
    DEF_VARIABLES(MirthNet_setHttpProxy);
    DEF_VARIABLES(NativeCallbacks_handleServiceDisconnected);
    DEF_VARIABLES(NativeCallbacks_handleServiceConnected);
    DEF_VARIABLES(NativeCallbacks_handleServiceUnavailable);
    DEF_VARIABLES(NativeCallbacks_handleServiceFailed);
    DEF_VARIABLES(NativeCallbacks_handleServiceInitFailed);
    DEF_VARIABLES(NativeCallbacks_handleGyroEvent);
    DEF_VARIABLES(NativeCallbacks_handleAccelEvent);
    DEF_VARIABLES(NativeCallbacks_handleBatteryEvent);
    DEF_VARIABLES(NativeCallbacks_handleButtonEvent);
    DEF_VARIABLES(NativeCallbacks_handleOrientationEvent);
    DEF_VARIABLES(NativeCallbacks_handleTouchEvent);
    DEF_VARIABLES(NativeCallbacks_handleControllerRecentered);
    DEF_VARIABLES(NativeCallbacks_handleStateChanged);
    DEF_VARIABLES(CardboardViewNativeImpl_nativeInit);
    DEF_VARIABLES(CardboardViewNativeImpl_nativeGetCurrentEyeParams);
    DEF_VARIABLES(CardboardViewNativeImpl_nativeSetRenderer);
    DEF_VARIABLES(CardboardViewNativeImpl_nativeSetStereoRenderer);
    DEF_VARIABLES(CardboardViewNativeImpl_nativeSetGvrViewerParams);
    DEF_VARIABLES(CardboardViewNativeImpl_nativeLogEvent);
    DEF_VARIABLES(CardboardViewNativeImpl_nativeSetApplicationState);
    DEF_VARIABLES(CardboardViewNativeImpl_nativeSetScreenParams);
    DEF_VARIABLES(CardboardViewNativeImpl_nativeSetNeckModelFactor);
    DEF_VARIABLES(CardboardViewNativeImpl_nativeGetNeckModelFactor );
    DEF_VARIABLES(CardboardViewNativeImpl_nativeOnDrawFrame );
    DEF_VARIABLES(CardboardViewNativeImpl_nativeSetNeckModelEnabled );
    DEF_VARIABLES(CardboardViewNativeImpl_nativeDestroy);
    DEF_VARIABLES(CardboardViewNativeImpl_nativeOnSurfaceCreated);
    DEF_VARIABLES(CardboardViewNativeImpl_nativeOnSurfaceChanged);
    DEF_VARIABLES(CardboardViewNativeImpl_nativeSetStereoModeEnabled);
    DEF_VARIABLES(CardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled);
    DEF_VARIABLES(CardboardViewNativeImpl_nativeSetDistortionCorrectionScale);
    DEF_VARIABLES(CardboardViewNativeImpl_nativeSetMultisampling);
    DEF_VARIABLES(CardboardViewNativeImpl_nativeSetDepthStencilFormat);

};

extern CGVRAPI gGvrApi;

#endif //TRUNK_VIEWCORE_H
