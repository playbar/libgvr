//
// Created by houguoli on 2017/1/3.
//

#include <dlfcn.h>
#include <unistd.h>
#include "gvrInter.h"
#include "gvrglobal.h"
#include "LogMessage.h"


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

#define GET_DLL_FUNCION(DLL , FUNC)  m_fp##FUNC = (FP_##FUNC)dlsym(DLL , FN_##FUNC)
#define GET_DLL_FUNCION_ERR(FUNC) {if (m_fp##FUNC == NULL ) { LOGE( "Can not get "#FUNC" function pointer");}}
#define DEF_VARIABLES(name) FP_##name m_fp##name


void * m_hDLL = NULL;
bool m_bInit = false;

FP_create_with_tracker_for_testing      m_fpcreate_with_tracker_for_testing;
FP_tracker_state_create                 m_fptracker_state_create;
FP_pause_tracking_get_state             m_fppause_tracking_get_state;
FP_resume_tracking_set_state            m_fpresume_tracking_set_state;
FP_tracker_state_destroy                m_fptracker_state_destroy;
FP_controller_state_get_last_button_timestamp m_fpcontroller_state_get_last_button_timestamp;
FP_render_reprojection_thread m_fprender_reprojection_thread;
FP_controller_state_get_last_touch_timestamp m_fpcontroller_state_get_last_touch_timestamp;
FP_on_surface_created_reprojection_thread m_fpon_surface_created_reprojection_thread;
FP_controller_state_get_last_accel_timestamp m_fpcontroller_state_get_last_accel_timestamp;
FP_set_async_reprojection_enabled m_fpset_async_reprojection_enabled;
FP_controller_state_get_last_gyro_timestamp m_fpcontroller_state_get_last_gyro_timestamp;
FP_controller_state_get_last_orientation_timestamp m_fpcontroller_state_get_last_orientation_timestamp;
FP_controller_state_get_last_battery_timestamp m_fpcontroller_state_get_last_battery_timestamp;
FP_remove_all_surfaces_reprojection_thread m_fpremove_all_surfaces_reprojection_thread;
FP_controller_state_get_button_up m_fpcontroller_state_get_button_up;
FP_controller_state_get_button_down m_fpcontroller_state_get_button_down;
FP_update_surface_reprojection_thread m_fpupdate_surface_reprojection_thread;
FP_controller_state_get_button_state m_fpcontroller_state_get_button_state;
FP_on_pause_reprojection_thread m_fpon_pause_reprojection_thread;
FP_on_surface_changed_reprojection_thread m_fpon_surface_changed_reprojection_thread;
FP_controller_state_get_recentering m_fpcontroller_state_get_recentering;
FP_controller_state_get_recentered m_fpcontroller_state_get_recentered;
FP_controller_state_get_touch_up m_fpcontroller_state_get_touch_up;
FP_controller_state_get_touch_down m_fpcontroller_state_get_touch_down;
FP_controller_state_get_touch_pos m_fpcontroller_state_get_touch_pos;
FP_controller_state_is_touching m_fpcontroller_state_is_touching;
FP_controller_state_get_accel m_fpcontroller_state_get_accel;
FP_controller_state_get_battery_charging m_fpcontroller_state_get_battery_charging;
FP_controller_state_get_battery_level m_fpcontroller_state_get_battery_level;
FP_controller_state_get_gyro m_fpcontroller_state_get_gyro;
FP_controller_state_get_orientation m_fpcontroller_state_get_orientation;
FP_controller_state_get_connection_state m_fpcontroller_state_get_connection_state;
FP_controller_state_get_api_status m_fpcontroller_state_get_api_status;
FP_controller_state_update m_fpcontroller_state_update;
FP_controller_state_destroy m_fpcontroller_state_destroy;
FP_controller_state_create m_fpcontroller_state_create;
FP_controller_button_to_string m_fpcontroller_button_to_string;
FP_display_synchronizer_update m_fpdisplay_synchronizer_update;
FP_controller_connection_state_to_string m_fpcontroller_connection_state_to_string;
FP_controller_api_status_to_string m_fpcontroller_api_status_to_string;
FP_controller_battery_level_to_string m_fpcontroller_battery_level_to_string;
FP_display_synchronizer_reset m_fpdisplay_synchronizer_reset;
FP_controller_resume m_fpcontroller_resume;
FP_set_ignore_manual_tracker_pause_resume m_fpset_ignore_manual_tracker_pause_resume;
FP_controller_pause m_fpcontroller_pause;
FP_set_display_synchronizer m_fpset_display_synchronizer;
FP_controller_destroy m_fpcontroller_destroy;
FP_controller_create_and_init_android m_fpcontroller_create_and_init_android;
FP_pause m_fppause;
FP_tracker_state_get_buffer m_fptracker_state_get_buffer;
FP_controller_create_and_init m_fpcontroller_create_and_init;
FP_tracker_state_get_buffer_size m_fptracker_state_get_buffer_size;
FP_using_vr_display_service m_fpusing_vr_display_service;
FP_controller_get_default_options m_fpcontroller_get_default_options;
FP_dump_debug_data m_fpdump_debug_data;
FP_external_surface_create_with_listeners m_fpexternal_surface_create_with_listeners;
FP_external_surface_destroy m_fpexternal_surface_destroy;
FP_external_surface_get_surface m_fpexternal_surface_get_surface;
FP_external_surface_get_surface_id m_fpexternal_surface_get_surface_id;
FP_using_dynamic_library m_fpusing_dynamic_library;
FP_resume m_fpresume;
FP_set_lens_offset m_fpset_lens_offset;
FP_reconnect_sensors m_fpreconnect_sensors;
FP_set_display_output_rotation m_fpset_display_output_rotation;
FP_get_surface_size m_fpget_surface_size;
FP_check_surface_size_changed m_fpcheck_surface_size_changed;
FP_get_border_size_meters m_fpget_border_size_meters;
FP_get_button_long_press m_fpget_button_long_press;
FP_display_synchronizer_destroy m_fpdisplay_synchronizer_destroy;
FP_display_synchronizer_create m_fpdisplay_synchronizer_create;
FP_refresh_viewer_profile m_fprefresh_viewer_profile;
FP_set_default_viewer_profile m_fpset_default_viewer_profile;
FP_recenter_tracking m_fprecenter_tracking;
FP_reset_tracking m_fpreset_tracking;
FP_resume_tracking m_fpresume_tracking;
FP_buffer_viewport_set_source_fov m_fpbuffer_viewport_set_source_fov;
FP_pause_tracking m_fppause_tracking;
FP_frame_get_framebuffer_object m_fpframe_get_framebuffer_object;
FP_frame_get_buffer_size m_fpframe_get_buffer_size;
FP_buffer_viewport_set_target_eye m_fpbuffer_viewport_set_target_eye;
FP_buffer_viewport_set_transform m_fpbuffer_viewport_set_transform;
FP_buffer_spec_set_color_format m_fpbuffer_spec_set_color_format;
FP_buffer_viewport_get_transform m_fpbuffer_viewport_get_transform;
FP_set_surface_size m_fpset_surface_size;
FP_buffer_viewport_set_external_surface_id m_fpbuffer_viewport_set_external_surface_id;
FP_buffer_viewport_get_external_surface_id m_fpbuffer_viewport_get_external_surface_id;
FP_buffer_viewport_list_get_size m_fpbuffer_viewport_list_get_size;
FP_buffer_viewport_set_source_buffer_index m_fpbuffer_viewport_set_source_buffer_index;
FP_get_async_reprojection_enabled m_fpget_async_reprojection_enabled;
FP_buffer_viewport_get_source_buffer_index m_fpbuffer_viewport_get_source_buffer_index;
FP_get_error_string m_fpget_error_string;
FP_clear_error m_fpclear_error;
FP_get_viewer_type m_fpget_viewer_type;
FP_get_error m_fpget_error;
FP_get_viewer_model m_fpget_viewer_model;
FP_get_version_string m_fpget_version_string;
FP_get_viewer_vendor m_fpget_viewer_vendor;
FP_get_version m_fpget_version;
FP_set_back_gesture_event_handler m_fpset_back_gesture_event_handler;
FP_buffer_viewport_create m_fpbuffer_viewport_create;
FP_get_user_prefs m_fpget_user_prefs;
FP_buffer_viewport_list_create m_fpbuffer_viewport_list_create;
FP_swap_chain_resize_buffer m_fpswap_chain_resize_buffer;
FP_frame_submit m_fpframe_submit;
FP_frame_unbind m_fpframe_unbind;
FP_gesture_context_create m_fpgesture_context_create;
FP_gesture_context_destroy m_fpgesture_context_destroy;
FP_gesture_get m_fpgesture_get;
FP_gesture_get_count m_fpgesture_get_count;
FP_gesture_get_direction m_fpgesture_get_direction;
FP_gesture_get_displacement m_fpgesture_get_displacement;
FP_gesture_get_type m_fpgesture_get_type;
FP_gesture_get_velocity m_fpgesture_get_velocity;
FP_gesture_restart m_fpgesture_restart;
FP_gesture_update m_fpgesture_update;
FP_frame_bind_buffer m_fpframe_bind_buffer;
FP_create m_fpcreate;
FP_swap_chain_acquire_frame m_fpswap_chain_acquire_frame;
FP_apply_neck_model m_fpapply_neck_model;
FP_get_head_space_from_start_space_rotation m_fpget_head_space_from_start_space_rotation;
FP_get_window_bounds m_fpget_window_bounds;
FP_buffer_viewport_get_source_uv m_fpbuffer_viewport_get_source_uv;
FP_get_screen_target_size m_fpget_screen_target_size;
FP_get_screen_buffer_viewports m_fpget_screen_buffer_viewports;
FP_user_prefs_get_controller_handedness m_fpuser_prefs_get_controller_handedness;
FP_buffer_viewport_list_set_item m_fpbuffer_viewport_list_set_item;
FP_buffer_viewport_set_source_uv m_fpbuffer_viewport_set_source_uv;
FP_buffer_viewport_set_reprojection m_fpbuffer_viewport_set_reprojection;
FP_buffer_viewport_set_source_layer m_fpbuffer_viewport_set_source_layer;
FP_buffer_viewport_get_reprojection m_fpbuffer_viewport_get_reprojection;
FP_swap_chain_get_buffer_count m_fpswap_chain_get_buffer_count;
FP_buffer_viewport_get_source_fov m_fpbuffer_viewport_get_source_fov;
FP_buffer_spec_get_samples m_fpbuffer_spec_get_samples;
FP_buffer_viewport_get_target_eye m_fpbuffer_viewport_get_target_eye;
FP_buffer_spec_get_size m_fpbuffer_spec_get_size;
FP_buffer_viewport_list_get_item m_fpbuffer_viewport_list_get_item;
FP_buffer_viewport_equal m_fpbuffer_viewport_equal;
FP_get_recommended_buffer_viewports m_fpget_recommended_buffer_viewports;
FP_compute_distorted_point m_fpcompute_distorted_point;
FP_set_error m_fpset_error;
FP_set_idle_listener m_fpset_idle_listener;
FP_swap_chain_get_buffer_size m_fpswap_chain_get_buffer_size;
FP_get_eye_from_head_matrix m_fpget_eye_from_head_matrix;
FP_buffer_spec_destroy m_fpbuffer_spec_destroy;
FP_set_display_metrics m_fpset_display_metrics;
FP_set_viewer_params m_fpset_viewer_params;
FP_get_time_point_now m_fpget_time_point_now;
FP_distort_to_screen m_fpdistort_to_screen;
FP_is_feature_supported m_fpis_feature_supported;
FP_initialize_gl m_fpinitialize_gl;
FP_buffer_spec_create m_fpbuffer_spec_create;
FP_buffer_spec_set_size m_fpbuffer_spec_set_size;
FP_buffer_spec_set_depth_stencil_format m_fpbuffer_spec_set_depth_stencil_format;
FP_buffer_spec_set_multiview_layer m_fpbuffer_spec_set_multiview_layer;
FP_buffer_spec_set_samples m_fpbuffer_spec_set_samples;
FP_get_maximum_effective_render_target_size m_fpget_maximum_effective_render_target_size;
FP_bind_default_framebuffer m_fpbind_default_framebuffer;
FP_swap_chain_create m_fpswap_chain_create;
FP_buffer_viewport_destroy m_fpbuffer_viewport_destroy;
FP_destroy m_fpdestroy;
FP_swap_chain_destroy m_fpswap_chain_destroy;
FP_JNI_OnLoad m_fpJNI_OnLoad;
FP_buffer_viewport_list_destroy m_fpbuffer_viewport_list_destroy;
FP_GvrApi_nativeGetWindowBounds m_fpGvrApi_nativeGetWindowBounds;
FP_GvrApi_nativePauseTracking m_fpGvrApi_nativePauseTracking;
FP_GvrApi_nativePauseTrackingGetState m_fpGvrApi_nativePauseTrackingGetState;
FP_GvrApi_nativeGetViewerModel m_fpGvrApi_nativeGetViewerModel;
FP_GvrApi_nativeGetViewerVendor m_fpGvrApi_nativeGetViewerVendor;
FP_GvrApi_nativeGetErrorString m_fpGvrApi_nativeGetErrorString;
FP_GvrApi_nativeComputeDistortedPoint m_fpGvrApi_nativeComputeDistortedPoint;
FP_GvrApi_nativeCreate m_fpGvrApi_nativeCreate;
FP_GvrApi_nativeRequestContextSharing m_fpGvrApi_nativeRequestContextSharing;
FP_GvrApi_nativeSwapChainCreate m_fpGvrApi_nativeSwapChainCreate;
FP_GvrApi_nativeSetViewerParams m_fpGvrApi_nativeSetViewerParams;
FP_GvrApi_nativeSetDefaultViewerProfile m_fpGvrApi_nativeSetDefaultViewerProfile;
FP_GvrApi_nativeResumeTracking m_fpGvrApi_nativeResumeTracking;
FP_GvrApi_nativeResumeTrackingSetState m_fpGvrApi_nativeResumeTrackingSetState;
FP_GvrApi_nativeFrameSubmit m_fpGvrApi_nativeFrameSubmit;
FP_GvrApi_nativeUsingDynamicLibrary m_fpGvrApi_nativeUsingDynamicLibrary;
FP_GvrApi_nativeSetApplicationState m_fpGvrApi_nativeSetApplicationState;
FP_GvrApi_nativeSetDynamicLibraryLoadingEnabled m_fpGvrApi_nativeSetDynamicLibraryLoadingEnabled;
FP_GvrApi_nativeFrameGetBufferSize m_fpGvrApi_nativeFrameGetBufferSize;
FP_GvrApi_nativeFrameGetFramebufferObject m_fpGvrApi_nativeFrameGetFramebufferObject;
FP_GvrApi_nativeFrameUnbind m_fpGvrApi_nativeFrameUnbind;
FP_GvrApi_nativeFrameBindBuffer m_fpGvrApi_nativeFrameBindBuffer;
FP_GvrApi_nativeSwapChainAcquireFrame m_fpGvrApi_nativeSwapChainAcquireFrame;
FP_GvrApi_nativeSwapChainResizeBuffer m_fpGvrApi_nativeSwapChainResizeBuffer;
FP_GvrApi_nativeSwapChainGetBufferSize m_fpGvrApi_nativeSwapChainGetBufferSize;
FP_GvrApi_nativeSwapChainGetBufferCount m_fpGvrApi_nativeSwapChainGetBufferCount;
FP_GvrApi_nativeSwapChainDestroy m_fpGvrApi_nativeSwapChainDestroy;
FP_GvrApi_nativeBufferSpecSetDepthStencilFormat m_fpGvrApi_nativeBufferSpecSetDepthStencilFormat;
FP_GvrApi_nativeBufferSpecSetMultiviewLayers m_fpGvrApi_nativeBufferSpecSetMultiviewLayers;
FP_GvrApi_nativeBufferSpecSetColorFormat m_fpGvrApi_nativeBufferSpecSetColorFormat;
FP_GvrApi_nativeBufferSpecSetSamples m_fpGvrApi_nativeBufferSpecSetSamples;
FP_GvrApi_nativeExternalSurfaceCreate m_fpGvrApi_nativeExternalSurfaceCreate;
FP_GvrApi_nativeExternalSurfaceCreateWithListeners m_fpGvrApi_nativeExternalSurfaceCreateWithListeners;
FP_GvrApi_nativeExternalSurfaceDestroy m_fpGvrApi_nativeExternalSurfaceDestroy;
FP_GvrApi_nativeExternalSurfaceGetId m_fpGvrApi_nativeExternalSurfaceGetId;
FP_GvrApi_nativeExternalSurfaceGetSurface m_fpGvrApi_nativeExternalSurfaceGetSurface;
FP_GvrApi_nativeBufferSpecGetSamples m_fpGvrApi_nativeBufferSpecGetSamples;
FP_GvrApi_nativeBufferSpecSetSize m_fpGvrApi_nativeBufferSpecSetSize;
FP_GvrApi_nativeBufferSpecGetSize m_fpGvrApi_nativeBufferSpecGetSize;
FP_GvrApi_nativeBufferSpecDestroy m_fpGvrApi_nativeBufferSpecDestroy;
FP_GvrApi_nativeBufferSpecCreate m_fpGvrApi_nativeBufferSpecCreate;
FP_GvrApi_nativeBufferViewportEqual m_fpGvrApi_nativeBufferViewportEqual;
FP_GvrApi_nativeBufferViewportSetReprojection m_fpGvrApi_nativeBufferViewportSetReprojection;
FP_GvrApi_nativeBufferViewportSetSourceLayer m_fpGvrApi_nativeBufferViewportSetSourceLayer;
FP_GvrApi_nativeBufferViewportGetReprojection m_fpGvrApi_nativeBufferViewportGetReprojection;
FP_GvrApi_nativeBufferViewportSetExternalSurfaceId m_fpGvrApi_nativeBufferViewportSetExternalSurfaceId;
FP_GvrApi_nativeBufferViewportSetExternalSurface m_fpGvrApi_nativeBufferViewportSetExternalSurface;
FP_GvrApi_nativeBufferViewportGetExternalSurfaceId m_fpGvrApi_nativeBufferViewportGetExternalSurfaceId;
FP_GvrApi_nativeBufferViewportSetSourceBufferIndex m_fpGvrApi_nativeBufferViewportSetSourceBufferIndex;
FP_GvrApi_nativeBufferViewportGetSourceBufferIndex m_fpGvrApi_nativeBufferViewportGetSourceBufferIndex;
FP_GvrApi_nativeBufferViewportSetTargetEye m_fpGvrApi_nativeBufferViewportSetTargetEye;
FP_GvrApi_nativeBufferViewportGetTargetEye m_fpGvrApi_nativeBufferViewportGetTargetEye;
FP_GvrApi_nativeBufferViewportSetTransform m_fpGvrApi_nativeBufferViewportSetTransform;
FP_GvrApi_nativeBufferViewportGetTransform m_fpGvrApi_nativeBufferViewportGetTransform;
FP_GvrApi_nativeBufferViewportSetSourceFov m_fpGvrApi_nativeBufferViewportSetSourceFov;
FP_GvrApi_nativeBufferViewportGetSourceFov m_fpGvrApi_nativeBufferViewportGetSourceFov;
FP_GvrApi_nativeBufferViewportSetSourceUv m_fpGvrApi_nativeBufferViewportSetSourceUv;
FP_GvrApi_nativeBufferViewportGetSourceUv m_fpGvrApi_nativeBufferViewportGetSourceUv;
FP_GvrApi_nativeBufferViewportDestroy m_fpGvrApi_nativeBufferViewportDestroy;
FP_GvrApi_nativeReleaseGvrContext m_fpGvrApi_nativeReleaseGvrContext;
FP_GvrApi_nativeResume m_fpGvrApi_nativeResume;
FP_GvrApi_nativePause m_fpGvrApi_nativePause;
FP_GvrApi_nativeUserPrefsGetControllerHandedness m_fpGvrApi_nativeUserPrefsGetControllerHandedness;
FP_GvrApi_nativeUserPrefsGetPerformanceMonitoringEnabled m_fpGvrApi_nativeUserPrefsGetPerformanceMonitoringEnabled;
FP_GvrApi_nativeUserPrefsGetPerformanceHudEnabled m_fpGvrApi_nativeUserPrefsGetPerformanceHudEnabled;
FP_GvrApi_nativeGetUserPrefs m_fpGvrApi_nativeGetUserPrefs;
FP_GvrApi_nativeClearError m_fpGvrApi_nativeClearError;
FP_GvrApi_nativeGetError m_fpGvrApi_nativeGetError;
FP_GvrApi_nativeGetRecommendedBufferViewports m_fpGvrApi_nativeGetRecommendedBufferViewports;
FP_GvrApi_nativeOnSurfaceCreatedReprojectionThread m_fpGvrApi_nativeOnSurfaceCreatedReprojectionThread;
FP_GvrApi_nativeOnSurfaceChangedReprojectionThread m_fpGvrApi_nativeOnSurfaceChangedReprojectionThread;
FP_GvrApi_nativeInitializeGl m_fpGvrApi_nativeInitializeGl;
FP_GvrApi_nativeDumpDebugData m_fpGvrApi_nativeDumpDebugData;
FP_DisplaySynchronizer_nativeDestroy m_fpDisplaySynchronizer_nativeDestroy;
FP_DisplaySynchronizer_nativeCreate m_fpDisplaySynchronizer_nativeCreate;
FP_DisplaySynchronizer_nativeUpdate m_fpDisplaySynchronizer_nativeUpdate;
FP_ExternalSurfaceManager_nativeUpdateSurface m_fpExternalSurfaceManager_nativeUpdateSurface;
FP_DisplaySynchronizer_nativeReset m_fpDisplaySynchronizer_nativeReset;
FP_GvrApi_nativeSetDisplayMetrics m_fpGvrApi_nativeSetDisplayMetrics;
FP_GvrApi_nativeReconnectSensors m_fpGvrApi_nativeReconnectSensors;
FP_GvrApi_nativeSetIdleListener m_fpGvrApi_nativeSetIdleListener;
FP_GvrApi_nativeGetAsyncReprojectionEnabled m_fpGvrApi_nativeGetAsyncReprojectionEnabled;
FP_GvrApi_nativeIsFeatureSupported m_fpGvrApi_nativeIsFeatureSupported;
FP_GvrApi_nativeSetLensOffset m_fpGvrApi_nativeSetLensOffset;
FP_GvrApi_nativeSetSurfaceSize m_fpGvrApi_nativeSetSurfaceSize;
FP_GvrApi_nativeGetBorderSizeMeters m_fpGvrApi_nativeGetBorderSizeMeters;
FP_GvrApi_nativeBufferViewportListDestroy m_fpGvrApi_nativeBufferViewportListDestroy;
FP_GvrApi_nativeBufferViewportListCreate m_fpGvrApi_nativeBufferViewportListCreate;
FP_GvrApi_nativeUsingVrDisplayService m_fpGvrApi_nativeUsingVrDisplayService;
FP_GvrApi_nativeBufferViewportCreate m_fpGvrApi_nativeBufferViewportCreate;
FP_GvrApi_nativeBufferViewportListSetItem m_fpGvrApi_nativeBufferViewportListSetItem;
FP_GvrApi_nativeBufferViewportListGetItem m_fpGvrApi_nativeBufferViewportListGetItem;
FP_GvrApi_nativeBufferViewportListGetSize m_fpGvrApi_nativeBufferViewportListGetSize;
FP_GvrApi_nativeDistortToScreen m_fpGvrApi_nativeDistortToScreen;
FP_GvrApi_nativeGetScreenTargetSize m_fpGvrApi_nativeGetScreenTargetSize;
FP_GvrApi_nativeGetMaximumEffectiveRenderTargetSize m_fpGvrApi_nativeGetMaximumEffectiveRenderTargetSize;
FP_GvrApi_nativeGetScreenBufferViewports m_fpGvrApi_nativeGetScreenBufferViewports;
FP_GvrApi_nativeSetDefaultFramebufferActive m_fpGvrApi_nativeSetDefaultFramebufferActive;
FP_GvrApi_nativeOnPauseReprojectionThread m_fpGvrApi_nativeOnPauseReprojectionThread;
FP_GvrApi_nativeRenderReprojectionThread m_fpGvrApi_nativeRenderReprojectionThread;
FP_GvrApi_nativeResetTracking m_fpGvrApi_nativeResetTracking;
FP_GvrApi_nativeSetIgnoreManualPauseResumeTracker m_fpGvrApi_nativeSetIgnoreManualPauseResumeTracker;
FP_GvrApi_nativeGetHeadSpaceFromStartSpaceRotation m_fpGvrApi_nativeGetHeadSpaceFromStartSpaceRotation;
FP_GvrApi_nativeSetAsyncReprojectionEnabled m_fpGvrApi_nativeSetAsyncReprojectionEnabled;
FP_GvrApi_nativeGetViewerType m_fpGvrApi_nativeGetViewerType;
FP_GvrApi_nativeGetEyeFromHeadMatrix m_fpGvrApi_nativeGetEyeFromHeadMatrix;
FP_GvrApi_nativeRecenterTracking m_fpGvrApi_nativeRecenterTracking;
FP_VrParamsProviderJni_nativeUpdateNativePhoneParamsPointer m_fpVrParamsProviderJni_nativeUpdateNativePhoneParamsPointer;
FP_MirthNet_setHttpProxy m_fpMirthNet_setHttpProxy;
FP_NativeCallbacks_handleServiceDisconnected m_fpNativeCallbacks_handleServiceDisconnected;
FP_NativeCallbacks_handleServiceConnected m_fpNativeCallbacks_handleServiceConnected;
FP_NativeCallbacks_handleServiceUnavailable m_fpNativeCallbacks_handleServiceUnavailable;
FP_NativeCallbacks_handleServiceFailed m_fpNativeCallbacks_handleServiceFailed;
FP_NativeCallbacks_handleServiceInitFailed m_fpNativeCallbacks_handleServiceInitFailed;
FP_NativeCallbacks_handleGyroEvent m_fpNativeCallbacks_handleGyroEvent;
FP_NativeCallbacks_handleAccelEvent m_fpNativeCallbacks_handleAccelEvent;
FP_NativeCallbacks_handleBatteryEvent m_fpNativeCallbacks_handleBatteryEvent;
FP_NativeCallbacks_handleButtonEvent m_fpNativeCallbacks_handleButtonEvent;
FP_NativeCallbacks_handleOrientationEvent m_fpNativeCallbacks_handleOrientationEvent;
FP_NativeCallbacks_handleTouchEvent m_fpNativeCallbacks_handleTouchEvent;
FP_NativeCallbacks_handleControllerRecentered m_fpNativeCallbacks_handleControllerRecentered;
FP_NativeCallbacks_handleStateChanged m_fpNativeCallbacks_handleStateChanged;
FP_CardboardViewNativeImpl_nativeInit m_fpCardboardViewNativeImpl_nativeInit;
FP_CardboardViewNativeImpl_nativeGetCurrentEyeParams m_fpCardboardViewNativeImpl_nativeGetCurrentEyeParams;
FP_CardboardViewNativeImpl_nativeSetRenderer m_fpCardboardViewNativeImpl_nativeSetRenderer;
FP_CardboardViewNativeImpl_nativeSetStereoRenderer m_fpCardboardViewNativeImpl_nativeSetStereoRenderer;
FP_CardboardViewNativeImpl_nativeSetGvrViewerParams m_fpCardboardViewNativeImpl_nativeSetGvrViewerParams;
FP_CardboardViewNativeImpl_nativeLogEvent m_fpCardboardViewNativeImpl_nativeLogEvent;
FP_CardboardViewNativeImpl_nativeSetApplicationState m_fpCardboardViewNativeImpl_nativeSetApplicationState;
FP_CardboardViewNativeImpl_nativeSetScreenParams m_fpCardboardViewNativeImpl_nativeSetScreenParams;
FP_CardboardViewNativeImpl_nativeSetNeckModelFactor m_fpCardboardViewNativeImpl_nativeSetNeckModelFactor;
FP_CardboardViewNativeImpl_nativeGetNeckModelFactor  m_fpCardboardViewNativeImpl_nativeGetNeckModelFactor;
FP_CardboardViewNativeImpl_nativeOnDrawFrame  m_fpCardboardViewNativeImpl_nativeOnDrawFrame;
FP_CardboardViewNativeImpl_nativeSetNeckModelEnabled  m_fpCardboardViewNativeImpl_nativeSetNeckModelEnabled;
FP_CardboardViewNativeImpl_nativeDestroy m_fpCardboardViewNativeImpl_nativeDestroy;
FP_CardboardViewNativeImpl_nativeOnSurfaceCreated m_fpCardboardViewNativeImpl_nativeOnSurfaceCreated;
FP_CardboardViewNativeImpl_nativeOnSurfaceChanged m_fpCardboardViewNativeImpl_nativeOnSurfaceChanged;
FP_CardboardViewNativeImpl_nativeSetStereoModeEnabled m_fpCardboardViewNativeImpl_nativeSetStereoModeEnabled;
FP_CardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled m_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled;
FP_CardboardViewNativeImpl_nativeSetDistortionCorrectionScale m_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionScale;
FP_CardboardViewNativeImpl_nativeSetMultisampling m_fpCardboardViewNativeImpl_nativeSetMultisampling;
FP_CardboardViewNativeImpl_nativeSetDepthStencilFormat m_fpCardboardViewNativeImpl_nativeSetDepthStencilFormat;




JavaVM *gs_jvm=0;
static int gneedDetach = 0;
JNIEnv* AttachCurrentThreadJNI()
{
    JNIEnv *env = 0;
    jint result = -1;
    if (gs_jvm->GetEnv((void**) &env, JNI_VERSION_1_6) != JNI_OK)
    {
        int status = gs_jvm->AttachCurrentThread( &env, 0 );
        if( status < 0 )
        {
            return 0;
        }
        gneedDetach = 1;
    }
    return env;
}

void DetachCurrentThreadJNI()
{
    if( gneedDetach )
    {
        gs_jvm->DetachCurrentThread();
        gneedDetach = 0;
    }

}


int is_file_exist(const char *file_path)
{
    if(file_path == nullptr )
    {
        return  -1;
    }
    if( access(file_path, F_OK) == 0 )
        return 0;
    return -1;
}

bool InitLoadFun()
{
    if( m_bInit )
        return m_bInit;

//        const char *filename = "/data/data/com.mj.test/lib/libgvrimpl.so";
//        const char *filename = "/data/data/com.Company.Daydream.Controller/lib/libgvrimpl.so";
    const char *filename = "libgvrimpl.so";
//        const char *filename = "/sdcard/libgvrimpl.so";
    is_file_exist(filename);
    m_hDLL = dlopen(filename, RTLD_LAZY);
    if( m_hDLL == nullptr)
    {
        LOGE( "dlopen err:%s.\n",dlerror());
    }
    if (m_hDLL)
    {
        GET_DLL_FUNCION(m_hDLL,create_with_tracker_for_testing);
        GET_DLL_FUNCION(m_hDLL,tracker_state_create);
        GET_DLL_FUNCION(m_hDLL,pause_tracking_get_state);
        GET_DLL_FUNCION(m_hDLL,resume_tracking_set_state);
        GET_DLL_FUNCION(m_hDLL,tracker_state_destroy);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_last_button_timestamp);
        GET_DLL_FUNCION(m_hDLL,render_reprojection_thread);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_last_touch_timestamp);
        GET_DLL_FUNCION(m_hDLL,on_surface_created_reprojection_thread);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_last_accel_timestamp);
        GET_DLL_FUNCION(m_hDLL,set_async_reprojection_enabled);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_last_gyro_timestamp);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_last_orientation_timestamp);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_last_battery_timestamp);
        GET_DLL_FUNCION(m_hDLL,remove_all_surfaces_reprojection_thread);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_button_up);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_button_down);
        GET_DLL_FUNCION(m_hDLL,update_surface_reprojection_thread);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_button_state);
        GET_DLL_FUNCION(m_hDLL,on_pause_reprojection_thread);
        GET_DLL_FUNCION(m_hDLL,on_surface_changed_reprojection_thread);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_recentering);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_recentered);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_touch_up);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_touch_down);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_touch_pos);
        GET_DLL_FUNCION(m_hDLL,controller_state_is_touching);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_accel);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_battery_charging);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_battery_level);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_gyro);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_orientation);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_connection_state);
        GET_DLL_FUNCION(m_hDLL,controller_state_get_api_status);
        GET_DLL_FUNCION(m_hDLL,controller_state_update);
        GET_DLL_FUNCION(m_hDLL,controller_state_destroy);
        GET_DLL_FUNCION(m_hDLL,controller_state_create);
        GET_DLL_FUNCION(m_hDLL,controller_button_to_string);
        GET_DLL_FUNCION(m_hDLL,display_synchronizer_update);
        GET_DLL_FUNCION(m_hDLL,controller_connection_state_to_string);
        GET_DLL_FUNCION(m_hDLL,controller_api_status_to_string);
        GET_DLL_FUNCION(m_hDLL,controller_battery_level_to_string);
        GET_DLL_FUNCION(m_hDLL,display_synchronizer_reset);
        GET_DLL_FUNCION(m_hDLL,controller_resume);
        GET_DLL_FUNCION(m_hDLL,set_ignore_manual_tracker_pause_resume);
        GET_DLL_FUNCION(m_hDLL,controller_pause);
        GET_DLL_FUNCION(m_hDLL,set_display_synchronizer);
        GET_DLL_FUNCION(m_hDLL,controller_destroy);
        GET_DLL_FUNCION(m_hDLL,controller_create_and_init_android);
        GET_DLL_FUNCION(m_hDLL,pause);
        GET_DLL_FUNCION(m_hDLL,tracker_state_get_buffer);
        GET_DLL_FUNCION(m_hDLL,controller_create_and_init);
        GET_DLL_FUNCION(m_hDLL,tracker_state_get_buffer_size);
        GET_DLL_FUNCION(m_hDLL,using_vr_display_service);
        GET_DLL_FUNCION(m_hDLL,controller_get_default_options);
        GET_DLL_FUNCION(m_hDLL,dump_debug_data);
        GET_DLL_FUNCION(m_hDLL,external_surface_create_with_listeners);
        GET_DLL_FUNCION(m_hDLL,external_surface_destroy);
        GET_DLL_FUNCION(m_hDLL,external_surface_get_surface);
        GET_DLL_FUNCION(m_hDLL,external_surface_get_surface_id);
        GET_DLL_FUNCION(m_hDLL,using_dynamic_library);
        GET_DLL_FUNCION(m_hDLL,resume);
        GET_DLL_FUNCION(m_hDLL,set_lens_offset);
        GET_DLL_FUNCION(m_hDLL,reconnect_sensors);
        GET_DLL_FUNCION(m_hDLL,set_display_output_rotation);
        GET_DLL_FUNCION(m_hDLL,get_surface_size);
        GET_DLL_FUNCION(m_hDLL,check_surface_size_changed);
        GET_DLL_FUNCION(m_hDLL,get_border_size_meters);
        GET_DLL_FUNCION(m_hDLL,get_button_long_press);
        GET_DLL_FUNCION(m_hDLL,display_synchronizer_destroy);
        GET_DLL_FUNCION(m_hDLL,display_synchronizer_create);
        GET_DLL_FUNCION(m_hDLL,refresh_viewer_profile);
        GET_DLL_FUNCION(m_hDLL,set_default_viewer_profile);
        GET_DLL_FUNCION(m_hDLL,recenter_tracking);
        GET_DLL_FUNCION(m_hDLL,reset_tracking);
        GET_DLL_FUNCION(m_hDLL,resume_tracking);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_set_source_fov);
        GET_DLL_FUNCION(m_hDLL,pause_tracking);
        GET_DLL_FUNCION(m_hDLL,frame_get_framebuffer_object);
        GET_DLL_FUNCION(m_hDLL,frame_get_buffer_size);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_set_target_eye);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_set_transform);
        GET_DLL_FUNCION(m_hDLL,buffer_spec_set_color_format);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_get_transform);
        GET_DLL_FUNCION(m_hDLL,set_surface_size);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_set_external_surface_id);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_get_external_surface_id);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_list_get_size);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_set_source_buffer_index);
        GET_DLL_FUNCION(m_hDLL,get_async_reprojection_enabled);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_get_source_buffer_index);
        GET_DLL_FUNCION(m_hDLL,get_error_string);
        GET_DLL_FUNCION(m_hDLL,clear_error);
        GET_DLL_FUNCION(m_hDLL,get_viewer_type);
        GET_DLL_FUNCION(m_hDLL,get_error);
        GET_DLL_FUNCION(m_hDLL,get_viewer_model);
        GET_DLL_FUNCION(m_hDLL,get_version_string);
        GET_DLL_FUNCION(m_hDLL,get_viewer_vendor);
        GET_DLL_FUNCION(m_hDLL,get_version);
        GET_DLL_FUNCION(m_hDLL,set_back_gesture_event_handler);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_create);
        GET_DLL_FUNCION(m_hDLL,get_user_prefs);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_list_create);
        GET_DLL_FUNCION(m_hDLL,swap_chain_resize_buffer);
        GET_DLL_FUNCION(m_hDLL,frame_submit);
        GET_DLL_FUNCION(m_hDLL,frame_unbind);
        GET_DLL_FUNCION(m_hDLL,gesture_context_create);
        GET_DLL_FUNCION(m_hDLL,gesture_context_destroy);
        GET_DLL_FUNCION(m_hDLL,gesture_get);
        GET_DLL_FUNCION(m_hDLL, gesture_get_count);
        GET_DLL_FUNCION(m_hDLL,gesture_get_direction);
        GET_DLL_FUNCION(m_hDLL,gesture_get_displacement);
        GET_DLL_FUNCION(m_hDLL,gesture_get_type);
        GET_DLL_FUNCION(m_hDLL,gesture_get_velocity);
        GET_DLL_FUNCION(m_hDLL,gesture_restart);
        GET_DLL_FUNCION(m_hDLL,gesture_update);
        GET_DLL_FUNCION(m_hDLL,frame_bind_buffer);
        GET_DLL_FUNCION(m_hDLL,create);
        GET_DLL_FUNCION(m_hDLL,swap_chain_acquire_frame);
        GET_DLL_FUNCION(m_hDLL,apply_neck_model);
        GET_DLL_FUNCION(m_hDLL,get_head_space_from_start_space_rotation);
        GET_DLL_FUNCION(m_hDLL,get_window_bounds);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_get_source_uv);
        GET_DLL_FUNCION(m_hDLL,get_screen_target_size);
        GET_DLL_FUNCION(m_hDLL,get_screen_buffer_viewports);
        GET_DLL_FUNCION(m_hDLL,user_prefs_get_controller_handedness);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_list_set_item);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_set_source_uv);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_set_reprojection);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_get_reprojection);
        GET_DLL_FUNCION(m_hDLL, buffer_viewport_set_source_layer);
        GET_DLL_FUNCION(m_hDLL,swap_chain_get_buffer_count);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_get_source_fov);
        GET_DLL_FUNCION(m_hDLL,buffer_spec_get_samples);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_get_target_eye);
        GET_DLL_FUNCION(m_hDLL,buffer_spec_get_size);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_list_get_item);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_equal);
        GET_DLL_FUNCION(m_hDLL,get_recommended_buffer_viewports);
        GET_DLL_FUNCION(m_hDLL,compute_distorted_point);
        GET_DLL_FUNCION(m_hDLL,set_error);
        GET_DLL_FUNCION(m_hDLL,set_idle_listener);
        GET_DLL_FUNCION(m_hDLL,swap_chain_get_buffer_size);
        GET_DLL_FUNCION(m_hDLL,get_eye_from_head_matrix);
        GET_DLL_FUNCION(m_hDLL,buffer_spec_destroy);
        GET_DLL_FUNCION(m_hDLL,set_display_metrics);
        GET_DLL_FUNCION(m_hDLL,set_viewer_params);
        GET_DLL_FUNCION(m_hDLL,get_time_point_now);
        GET_DLL_FUNCION(m_hDLL,distort_to_screen);
        GET_DLL_FUNCION(m_hDLL, is_feature_supported);
        GET_DLL_FUNCION(m_hDLL,initialize_gl);
        GET_DLL_FUNCION(m_hDLL,buffer_spec_create);
        GET_DLL_FUNCION(m_hDLL,buffer_spec_set_size);
        GET_DLL_FUNCION(m_hDLL,buffer_spec_set_depth_stencil_format);
        GET_DLL_FUNCION(m_hDLL, buffer_spec_set_multiview_layer);
        GET_DLL_FUNCION(m_hDLL,buffer_spec_set_samples);
        GET_DLL_FUNCION(m_hDLL,get_maximum_effective_render_target_size);
        GET_DLL_FUNCION(m_hDLL,bind_default_framebuffer);
        GET_DLL_FUNCION(m_hDLL,swap_chain_create);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_destroy);
        GET_DLL_FUNCION(m_hDLL,destroy);
        GET_DLL_FUNCION(m_hDLL,swap_chain_destroy);
        GET_DLL_FUNCION(m_hDLL, JNI_OnLoad);
        GET_DLL_FUNCION(m_hDLL,buffer_viewport_list_destroy);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeGetWindowBounds);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativePauseTracking);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativePauseTrackingGetState);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeGetViewerModel);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeGetViewerVendor);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeGetErrorString);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeComputeDistortedPoint);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeCreate);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeRequestContextSharing);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeSwapChainCreate);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeSetViewerParams);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeSetDefaultViewerProfile);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeResumeTracking);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeResumeTrackingSetState);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeFrameSubmit);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeUsingDynamicLibrary);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeSetApplicationState);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeSetDynamicLibraryLoadingEnabled);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeFrameGetBufferSize);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeFrameGetFramebufferObject);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeFrameUnbind);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeFrameBindBuffer);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeSwapChainAcquireFrame);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeSwapChainResizeBuffer);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeSwapChainGetBufferSize);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeSwapChainGetBufferCount);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeSwapChainDestroy);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferSpecSetDepthStencilFormat);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferSpecSetMultiviewLayers);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferSpecSetColorFormat);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferSpecSetSamples);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeExternalSurfaceCreateWithListeners);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeExternalSurfaceDestroy);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeExternalSurfaceGetId);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeExternalSurfaceGetSurface);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferSpecGetSamples);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferSpecSetSize);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferSpecGetSize);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferSpecDestroy);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferSpecCreate);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportEqual);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportSetReprojection);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportSetSourceLayer);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportGetReprojection);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportSetExternalSurfaceId);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportSetExternalSurface);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportGetExternalSurfaceId);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportSetSourceBufferIndex);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportGetSourceBufferIndex);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportSetTargetEye);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportGetTargetEye);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportSetTransform);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportGetTransform);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportSetSourceFov);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportGetSourceFov);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportSetSourceUv);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportGetSourceUv);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportDestroy);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeReleaseGvrContext);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeResume);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativePause);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeUserPrefsGetControllerHandedness);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeGetUserPrefs);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeClearError);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeGetError);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeGetRecommendedBufferViewports);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeOnSurfaceCreatedReprojectionThread);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeOnSurfaceChangedReprojectionThread);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeInitializeGl);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeDumpDebugData);
        GET_DLL_FUNCION(m_hDLL,DisplaySynchronizer_nativeDestroy);
        GET_DLL_FUNCION(m_hDLL,DisplaySynchronizer_nativeCreate);
        GET_DLL_FUNCION(m_hDLL,DisplaySynchronizer_nativeUpdate);
        GET_DLL_FUNCION(m_hDLL,ExternalSurfaceManager_nativeUpdateSurface);
        GET_DLL_FUNCION(m_hDLL,DisplaySynchronizer_nativeReset);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeSetDisplayMetrics);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeReconnectSensors);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeSetIdleListener);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeGetAsyncReprojectionEnabled);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeIsFeatureSupported);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeSetLensOffset);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeSetSurfaceSize);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeGetBorderSizeMeters);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportListDestroy);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportListCreate);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeUsingVrDisplayService);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportCreate);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportListSetItem);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportListGetItem);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeBufferViewportListGetSize);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeDistortToScreen);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeGetScreenTargetSize);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeGetMaximumEffectiveRenderTargetSize);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeGetScreenBufferViewports);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeSetDefaultFramebufferActive);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeOnPauseReprojectionThread);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeRenderReprojectionThread);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeResetTracking);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeSetIgnoreManualPauseResumeTracker);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeGetHeadSpaceFromStartSpaceRotation);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeSetAsyncReprojectionEnabled);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeGetViewerType);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeGetEyeFromHeadMatrix);
        GET_DLL_FUNCION(m_hDLL,GvrApi_nativeRecenterTracking);
        GET_DLL_FUNCION(m_hDLL,VrParamsProviderJni_nativeUpdateNativePhoneParamsPointer);
        GET_DLL_FUNCION(m_hDLL,MirthNet_setHttpProxy);
        GET_DLL_FUNCION(m_hDLL,NativeCallbacks_handleServiceDisconnected);
        GET_DLL_FUNCION(m_hDLL,NativeCallbacks_handleServiceConnected);
        GET_DLL_FUNCION(m_hDLL,NativeCallbacks_handleServiceUnavailable);
        GET_DLL_FUNCION(m_hDLL,NativeCallbacks_handleServiceFailed);
        GET_DLL_FUNCION(m_hDLL,NativeCallbacks_handleServiceInitFailed);
        GET_DLL_FUNCION(m_hDLL,NativeCallbacks_handleGyroEvent);
        GET_DLL_FUNCION(m_hDLL,NativeCallbacks_handleAccelEvent);
        GET_DLL_FUNCION(m_hDLL,NativeCallbacks_handleBatteryEvent);
        GET_DLL_FUNCION(m_hDLL,NativeCallbacks_handleButtonEvent);
        GET_DLL_FUNCION(m_hDLL,NativeCallbacks_handleOrientationEvent);
        GET_DLL_FUNCION(m_hDLL,NativeCallbacks_handleTouchEvent);
        GET_DLL_FUNCION(m_hDLL,NativeCallbacks_handleControllerRecentered);
        GET_DLL_FUNCION(m_hDLL,NativeCallbacks_handleStateChanged);
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeInit);
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeGetCurrentEyeParams);
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeSetRenderer);
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeSetStereoRenderer);
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeSetGvrViewerParams);
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeLogEvent);
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeSetApplicationState);
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeSetScreenParams);
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeSetNeckModelFactor);
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeGetNeckModelFactor );
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeOnDrawFrame );
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeSetNeckModelEnabled );
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeDestroy);
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeOnSurfaceCreated);
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeOnSurfaceChanged);
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeSetStereoModeEnabled);
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled);
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeSetDistortionCorrectionScale);
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeSetMultisampling);
        GET_DLL_FUNCION(m_hDLL,CardboardViewNativeImpl_nativeSetDepthStencilFormat);

        if (m_fpcreate_with_tracker_for_testing!= NULL
            && m_fptracker_state_create!= NULL
            && m_fppause_tracking_get_state!= NULL
            && m_fpresume_tracking_set_state!= NULL
            && m_fptracker_state_destroy!= NULL
            && m_fpcontroller_state_get_last_button_timestamp!= NULL
            && m_fprender_reprojection_thread!= NULL
            && m_fpcontroller_state_get_last_touch_timestamp!= NULL
            && m_fpon_surface_created_reprojection_thread!= NULL
            && m_fpcontroller_state_get_last_accel_timestamp!= NULL
            && m_fpset_async_reprojection_enabled!= NULL
            && m_fpcontroller_state_get_last_gyro_timestamp!= NULL
            && m_fpcontroller_state_get_last_orientation_timestamp!= NULL
            && m_fpcontroller_state_get_last_battery_timestamp!= NULL
            && m_fpremove_all_surfaces_reprojection_thread!= NULL
            && m_fpcontroller_state_get_button_up!= NULL
            && m_fpcontroller_state_get_button_down!= NULL
            && m_fpupdate_surface_reprojection_thread!= NULL
            && m_fpcontroller_state_get_button_state!= NULL
            && m_fpon_pause_reprojection_thread!= NULL
            && m_fpon_surface_changed_reprojection_thread!= NULL
            && m_fpcontroller_state_get_recentering!= NULL
            && m_fpcontroller_state_get_recentered!= NULL
            && m_fpcontroller_state_get_touch_up!= NULL
            && m_fpcontroller_state_get_touch_down!= NULL
            && m_fpcontroller_state_get_touch_pos!= NULL
            && m_fpcontroller_state_is_touching!= NULL
            && m_fpcontroller_state_get_accel!= NULL
            && m_fpcontroller_state_get_battery_charging!= NULL
            && m_fpcontroller_state_get_battery_level!= NULL
            && m_fpcontroller_state_get_gyro!= NULL
            && m_fpcontroller_state_get_orientation!= NULL
            && m_fpcontroller_state_get_connection_state!= NULL
            && m_fpcontroller_state_get_api_status!= NULL
            && m_fpcontroller_state_update!= NULL
            && m_fpcontroller_state_destroy!= NULL
            && m_fpcontroller_state_create!= NULL
            && m_fpcontroller_button_to_string!= NULL
            && m_fpdisplay_synchronizer_update!= NULL
            && m_fpcontroller_connection_state_to_string!= NULL
            && m_fpcontroller_api_status_to_string!= NULL
            && m_fpcontroller_battery_level_to_string!= NULL
            && m_fpdisplay_synchronizer_reset!= NULL
            && m_fpcontroller_resume!= NULL
            && m_fpset_ignore_manual_tracker_pause_resume!= NULL
            && m_fpcontroller_pause!= NULL
            && m_fpset_display_synchronizer!= NULL
            && m_fpcontroller_destroy!= NULL
            && m_fpcontroller_create_and_init_android!= NULL
            && m_fppause!= NULL
            && m_fptracker_state_get_buffer!= NULL
            && m_fpcontroller_create_and_init!= NULL
            && m_fptracker_state_get_buffer_size!= NULL
            && m_fpusing_vr_display_service!= NULL
            && m_fpcontroller_get_default_options!= NULL
            && m_fpdump_debug_data!= NULL
            && m_fpexternal_surface_create_with_listeners!= NULL
            && m_fpexternal_surface_destroy!= NULL
            && m_fpexternal_surface_get_surface!= NULL
            && m_fpexternal_surface_get_surface_id!= NULL
            && m_fpusing_dynamic_library!= NULL
            && m_fpresume!= NULL
            && m_fpset_lens_offset!= NULL
            && m_fpreconnect_sensors!= NULL
            && m_fpset_display_output_rotation!= NULL
            && m_fpget_surface_size!= NULL
            && m_fpcheck_surface_size_changed!= NULL
            && m_fpget_border_size_meters!= NULL
            && m_fpget_button_long_press!= NULL
            && m_fpdisplay_synchronizer_destroy!= NULL
            && m_fpdisplay_synchronizer_create!= NULL
            && m_fprefresh_viewer_profile!= NULL
            && m_fpset_default_viewer_profile!= NULL
            && m_fprecenter_tracking!= NULL
            && m_fpreset_tracking!= NULL
            && m_fpresume_tracking!= NULL
            && m_fpbuffer_viewport_set_source_fov!= NULL
            && m_fppause_tracking!= NULL
            && m_fpframe_get_framebuffer_object!= NULL
            && m_fpframe_get_buffer_size!= NULL
            && m_fpbuffer_viewport_set_target_eye!= NULL
            && m_fpbuffer_viewport_set_transform!= NULL
            && m_fpbuffer_spec_set_color_format!= NULL
            && m_fpbuffer_viewport_get_transform!= NULL
            && m_fpset_surface_size!= NULL
            && m_fpbuffer_viewport_set_external_surface_id!= NULL
            && m_fpbuffer_viewport_get_external_surface_id!= NULL
            && m_fpbuffer_viewport_list_get_size!= NULL
            && m_fpbuffer_viewport_set_source_buffer_index!= NULL
            && m_fpget_async_reprojection_enabled!= NULL
            && m_fpbuffer_viewport_get_source_buffer_index!= NULL
            && m_fpget_error_string!= NULL
            && m_fpclear_error!= NULL
            && m_fpget_viewer_type!= NULL
            && m_fpget_error!= NULL
            && m_fpget_viewer_model!= NULL
            && m_fpget_version_string!= NULL
            && m_fpget_viewer_vendor!= NULL
            && m_fpget_version!= NULL
            && m_fpset_back_gesture_event_handler!= NULL
            && m_fpbuffer_viewport_create!= NULL
            && m_fpget_user_prefs!= NULL
            && m_fpbuffer_viewport_list_create!= NULL
            && m_fpswap_chain_resize_buffer!= NULL
            && m_fpframe_submit!= NULL
            && m_fpframe_unbind!= NULL
            && m_fpgesture_context_create!= NULL
            && m_fpgesture_context_destroy!= NULL
            && m_fpgesture_get!= NULL
            && m_fpgesture_get_count!= NULL
            && m_fpgesture_get_direction!= NULL
            && m_fpgesture_get_displacement!= NULL
            && m_fpgesture_get_type!= NULL
            && m_fpgesture_get_velocity!= NULL
            && m_fpgesture_restart!= NULL
            && m_fpgesture_update!= NULL
            && m_fpframe_bind_buffer!= NULL
            && m_fpcreate!= NULL
            && m_fpswap_chain_acquire_frame!= NULL
            && m_fpapply_neck_model!= NULL
            && m_fpget_head_space_from_start_space_rotation!= NULL
            && m_fpget_window_bounds!= NULL
            && m_fpbuffer_viewport_get_source_uv!= NULL
            && m_fpget_screen_target_size!= NULL
            && m_fpget_screen_buffer_viewports!= NULL
            && m_fpuser_prefs_get_controller_handedness!= NULL
            && m_fpbuffer_viewport_list_set_item!= NULL
            && m_fpbuffer_viewport_set_source_uv!= NULL
            && m_fpbuffer_viewport_set_reprojection!= NULL
            && m_fpbuffer_viewport_get_reprojection!= NULL
            && m_fpbuffer_viewport_set_source_layer!= NULL
            && m_fpswap_chain_get_buffer_count!= NULL
            && m_fpbuffer_viewport_get_source_fov!= NULL
            && m_fpbuffer_spec_get_samples!= NULL
            && m_fpbuffer_viewport_get_target_eye!= NULL
            && m_fpbuffer_spec_get_size!= NULL
            && m_fpbuffer_viewport_list_get_item!= NULL
            && m_fpbuffer_viewport_equal!= NULL
            && m_fpget_recommended_buffer_viewports!= NULL
            && m_fpcompute_distorted_point!= NULL
            && m_fpset_error!= NULL
            && m_fpset_idle_listener!= NULL
            && m_fpswap_chain_get_buffer_size!= NULL
            && m_fpget_eye_from_head_matrix!= NULL
            && m_fpbuffer_spec_destroy!= NULL
            && m_fpset_display_metrics!= NULL
            && m_fpset_viewer_params!= NULL
            && m_fpget_time_point_now!= NULL
            && m_fpdistort_to_screen!= NULL
            && m_fpis_feature_supported!= NULL
            && m_fpinitialize_gl!= NULL
            && m_fpbuffer_spec_create!= NULL
            && m_fpbuffer_spec_set_size!= NULL
            && m_fpbuffer_spec_set_depth_stencil_format!= NULL
            && m_fpbuffer_spec_set_multiview_layer!= NULL
            && m_fpbuffer_spec_set_samples!= NULL
            && m_fpget_maximum_effective_render_target_size!= NULL
            && m_fpbind_default_framebuffer!= NULL
            && m_fpswap_chain_create!= NULL
            && m_fpbuffer_viewport_destroy!= NULL
            && m_fpdestroy!= NULL
            && m_fpswap_chain_destroy!= NULL
            && m_fpJNI_OnLoad != NULL
            && m_fpbuffer_viewport_list_destroy!= NULL
            && m_fpGvrApi_nativeGetWindowBounds!= NULL
            && m_fpGvrApi_nativePauseTracking!= NULL
            && m_fpGvrApi_nativePauseTrackingGetState!= NULL
            && m_fpGvrApi_nativeGetViewerModel!= NULL
            && m_fpGvrApi_nativeGetViewerVendor!= NULL
            && m_fpGvrApi_nativeGetErrorString!= NULL
            && m_fpGvrApi_nativeComputeDistortedPoint!= NULL
            && m_fpGvrApi_nativeCreate!= NULL
            && m_fpGvrApi_nativeRequestContextSharing!= NULL
            && m_fpGvrApi_nativeSwapChainCreate!= NULL
            && m_fpGvrApi_nativeSetViewerParams!= NULL
            && m_fpGvrApi_nativeSetDefaultViewerProfile!= NULL
            && m_fpGvrApi_nativeResumeTracking!= NULL
            && m_fpGvrApi_nativeResumeTrackingSetState!= NULL
            && m_fpGvrApi_nativeFrameSubmit!= NULL
            && m_fpGvrApi_nativeUsingDynamicLibrary!= NULL
            && m_fpGvrApi_nativeSetApplicationState!=NULL
            && m_fpGvrApi_nativeSetDynamicLibraryLoadingEnabled!=NULL
            && m_fpGvrApi_nativeFrameGetBufferSize!= NULL
            && m_fpGvrApi_nativeFrameGetFramebufferObject!= NULL
            && m_fpGvrApi_nativeFrameUnbind!= NULL
            && m_fpGvrApi_nativeFrameBindBuffer!= NULL
            && m_fpGvrApi_nativeSwapChainAcquireFrame!= NULL
            && m_fpGvrApi_nativeSwapChainResizeBuffer!= NULL
            && m_fpGvrApi_nativeSwapChainGetBufferSize!= NULL
            && m_fpGvrApi_nativeSwapChainGetBufferCount!= NULL
            && m_fpGvrApi_nativeSwapChainDestroy!= NULL
            && m_fpGvrApi_nativeBufferSpecSetDepthStencilFormat!= NULL
            && m_fpGvrApi_nativeBufferSpecSetMultiviewLayers!=NULL
            && m_fpGvrApi_nativeBufferSpecSetColorFormat!= NULL
            && m_fpGvrApi_nativeBufferSpecSetSamples!= NULL
            && m_fpGvrApi_nativeExternalSurfaceCreateWithListeners!= NULL
            && m_fpGvrApi_nativeExternalSurfaceDestroy!=NULL
            && m_fpGvrApi_nativeExternalSurfaceGetId!=NULL
            && m_fpGvrApi_nativeExternalSurfaceGetSurface!=NULL
            && m_fpGvrApi_nativeBufferSpecGetSamples!= NULL
            && m_fpGvrApi_nativeBufferSpecSetSize!= NULL
            && m_fpGvrApi_nativeBufferSpecGetSize!= NULL
            && m_fpGvrApi_nativeBufferSpecDestroy!= NULL
            && m_fpGvrApi_nativeBufferSpecCreate!= NULL
            && m_fpGvrApi_nativeBufferViewportEqual!= NULL
            && m_fpGvrApi_nativeBufferViewportSetReprojection!= NULL
            && m_fpGvrApi_nativeBufferViewportSetSourceLayer!=NULL
            && m_fpGvrApi_nativeBufferViewportGetReprojection!= NULL
            && m_fpGvrApi_nativeBufferViewportSetExternalSurfaceId!= NULL
            && m_fpGvrApi_nativeBufferViewportSetExternalSurface!= NULL
            && m_fpGvrApi_nativeBufferViewportGetExternalSurfaceId!= NULL
            && m_fpGvrApi_nativeBufferViewportSetSourceBufferIndex!= NULL
            && m_fpGvrApi_nativeBufferViewportGetSourceBufferIndex!= NULL
            && m_fpGvrApi_nativeBufferViewportSetTargetEye!= NULL
            && m_fpGvrApi_nativeBufferViewportGetTargetEye!= NULL
            && m_fpGvrApi_nativeBufferViewportSetTransform!= NULL
            && m_fpGvrApi_nativeBufferViewportGetTransform!= NULL
            && m_fpGvrApi_nativeBufferViewportSetSourceFov!= NULL
            && m_fpGvrApi_nativeBufferViewportGetSourceFov!= NULL
            && m_fpGvrApi_nativeBufferViewportSetSourceUv!= NULL
            && m_fpGvrApi_nativeBufferViewportGetSourceUv!= NULL
            && m_fpGvrApi_nativeBufferViewportDestroy!= NULL
            && m_fpGvrApi_nativeReleaseGvrContext!= NULL
            && m_fpGvrApi_nativeResume!= NULL
            && m_fpGvrApi_nativePause!= NULL
            && m_fpGvrApi_nativeUserPrefsGetControllerHandedness!= NULL
            && m_fpGvrApi_nativeGetUserPrefs!= NULL
            && m_fpGvrApi_nativeClearError!= NULL
            && m_fpGvrApi_nativeGetError!= NULL
            && m_fpGvrApi_nativeGetRecommendedBufferViewports!= NULL
            && m_fpGvrApi_nativeOnSurfaceCreatedReprojectionThread!= NULL
            && m_fpGvrApi_nativeOnSurfaceChangedReprojectionThread!= NULL
            && m_fpGvrApi_nativeInitializeGl!= NULL
            && m_fpGvrApi_nativeDumpDebugData!= NULL
            && m_fpDisplaySynchronizer_nativeDestroy!= NULL
            && m_fpDisplaySynchronizer_nativeCreate!= NULL
            && m_fpDisplaySynchronizer_nativeUpdate!= NULL
            && m_fpExternalSurfaceManager_nativeUpdateSurface!= NULL
            && m_fpDisplaySynchronizer_nativeReset!= NULL
            && m_fpGvrApi_nativeSetDisplayMetrics!= NULL
            && m_fpGvrApi_nativeReconnectSensors!= NULL
            && m_fpGvrApi_nativeSetIdleListener!= NULL
            && m_fpGvrApi_nativeGetAsyncReprojectionEnabled!= NULL
            && m_fpGvrApi_nativeIsFeatureSupported != NULL
            && m_fpGvrApi_nativeSetLensOffset!= NULL
            && m_fpGvrApi_nativeSetSurfaceSize!= NULL
            && m_fpGvrApi_nativeGetBorderSizeMeters!= NULL
            && m_fpGvrApi_nativeBufferViewportListDestroy!= NULL
            && m_fpGvrApi_nativeBufferViewportListCreate!= NULL
            && m_fpGvrApi_nativeUsingVrDisplayService!= NULL
            && m_fpGvrApi_nativeBufferViewportCreate!= NULL
            && m_fpGvrApi_nativeBufferViewportListSetItem!= NULL
            && m_fpGvrApi_nativeBufferViewportListGetItem!= NULL
            && m_fpGvrApi_nativeBufferViewportListGetSize!= NULL
            && m_fpGvrApi_nativeDistortToScreen!= NULL
            && m_fpGvrApi_nativeGetScreenTargetSize!= NULL
            && m_fpGvrApi_nativeGetMaximumEffectiveRenderTargetSize!= NULL
            && m_fpGvrApi_nativeGetScreenBufferViewports!= NULL
            && m_fpGvrApi_nativeSetDefaultFramebufferActive!= NULL
            && m_fpGvrApi_nativeOnPauseReprojectionThread!= NULL
            && m_fpGvrApi_nativeRenderReprojectionThread!= NULL
            && m_fpGvrApi_nativeResetTracking!= NULL
            && m_fpGvrApi_nativeSetIgnoreManualPauseResumeTracker!= NULL
            && m_fpGvrApi_nativeGetHeadSpaceFromStartSpaceRotation!= NULL
            && m_fpGvrApi_nativeSetAsyncReprojectionEnabled!= NULL
            && m_fpGvrApi_nativeGetViewerType!= NULL
            && m_fpGvrApi_nativeGetEyeFromHeadMatrix!= NULL
            && m_fpGvrApi_nativeRecenterTracking!= NULL
            && m_fpVrParamsProviderJni_nativeUpdateNativePhoneParamsPointer!= NULL
            && m_fpMirthNet_setHttpProxy!= NULL
            && m_fpNativeCallbacks_handleServiceDisconnected!= NULL
            && m_fpNativeCallbacks_handleServiceConnected!= NULL
            && m_fpNativeCallbacks_handleServiceUnavailable!= NULL
            && m_fpNativeCallbacks_handleServiceFailed!= NULL
            && m_fpNativeCallbacks_handleServiceInitFailed!= NULL
            && m_fpNativeCallbacks_handleGyroEvent!= NULL
            && m_fpNativeCallbacks_handleAccelEvent!= NULL
            && m_fpNativeCallbacks_handleBatteryEvent!= NULL
            && m_fpNativeCallbacks_handleButtonEvent!= NULL
            && m_fpNativeCallbacks_handleOrientationEvent!= NULL
            && m_fpNativeCallbacks_handleTouchEvent!= NULL
            && m_fpNativeCallbacks_handleControllerRecentered!= NULL
            && m_fpNativeCallbacks_handleStateChanged!= NULL
            && m_fpCardboardViewNativeImpl_nativeInit!= NULL
            && m_fpCardboardViewNativeImpl_nativeGetCurrentEyeParams!= NULL
            && m_fpCardboardViewNativeImpl_nativeSetRenderer!= NULL
            && m_fpCardboardViewNativeImpl_nativeSetStereoRenderer!= NULL
            && m_fpCardboardViewNativeImpl_nativeSetGvrViewerParams!= NULL
            && m_fpCardboardViewNativeImpl_nativeLogEvent!= NULL
            && m_fpCardboardViewNativeImpl_nativeSetApplicationState!= NULL
            && m_fpCardboardViewNativeImpl_nativeSetScreenParams!= NULL
            && m_fpCardboardViewNativeImpl_nativeSetNeckModelFactor!= NULL
            && m_fpCardboardViewNativeImpl_nativeGetNeckModelFactor != NULL
            && m_fpCardboardViewNativeImpl_nativeOnDrawFrame != NULL
            && m_fpCardboardViewNativeImpl_nativeSetNeckModelEnabled != NULL
            && m_fpCardboardViewNativeImpl_nativeDestroy!= NULL
            && m_fpCardboardViewNativeImpl_nativeOnSurfaceCreated!= NULL
            && m_fpCardboardViewNativeImpl_nativeOnSurfaceChanged!= NULL
            && m_fpCardboardViewNativeImpl_nativeSetStereoModeEnabled!= NULL
            && m_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled!= NULL
            && m_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionScale!= NULL
            && m_fpCardboardViewNativeImpl_nativeSetMultisampling!= NULL
            && m_fpCardboardViewNativeImpl_nativeSetDepthStencilFormat!= NULL
                )
        {
            m_bInit = true;
            LOGI("dlopen success");
//                MOJING_TRACE(g_APIlogger , "svrApi init OK");
        }
        else
        {// 有函数指针拿不到

            GET_DLL_FUNCION_ERR(create_with_tracker_for_testing);
            GET_DLL_FUNCION_ERR(tracker_state_create);
            GET_DLL_FUNCION_ERR(pause_tracking_get_state);
            GET_DLL_FUNCION_ERR(resume_tracking_set_state);
            GET_DLL_FUNCION_ERR(tracker_state_destroy);
            GET_DLL_FUNCION_ERR(controller_state_get_last_button_timestamp);
            GET_DLL_FUNCION_ERR(render_reprojection_thread);
            GET_DLL_FUNCION_ERR(controller_state_get_last_touch_timestamp);
            GET_DLL_FUNCION_ERR(on_surface_created_reprojection_thread);
            GET_DLL_FUNCION_ERR(controller_state_get_last_accel_timestamp);
            GET_DLL_FUNCION_ERR(set_async_reprojection_enabled);
            GET_DLL_FUNCION_ERR(controller_state_get_last_gyro_timestamp);
            GET_DLL_FUNCION_ERR(controller_state_get_last_orientation_timestamp);
            GET_DLL_FUNCION_ERR(controller_state_get_last_battery_timestamp);
            GET_DLL_FUNCION_ERR(remove_all_surfaces_reprojection_thread);
            GET_DLL_FUNCION_ERR(controller_state_get_button_up);
            GET_DLL_FUNCION_ERR(controller_state_get_button_down);
            GET_DLL_FUNCION_ERR(update_surface_reprojection_thread);
            GET_DLL_FUNCION_ERR(controller_state_get_button_state);
            GET_DLL_FUNCION_ERR(on_pause_reprojection_thread);
            GET_DLL_FUNCION_ERR(on_surface_changed_reprojection_thread);
            GET_DLL_FUNCION_ERR(controller_state_get_recentering);
            GET_DLL_FUNCION_ERR(controller_state_get_recentered);
            GET_DLL_FUNCION_ERR(controller_state_get_touch_up);
            GET_DLL_FUNCION_ERR(controller_state_get_touch_down);
            GET_DLL_FUNCION_ERR(controller_state_get_touch_pos);
            GET_DLL_FUNCION_ERR(controller_state_is_touching);
            GET_DLL_FUNCION_ERR(controller_state_get_accel);
            GET_DLL_FUNCION_ERR(controller_state_get_battery_charging);
            GET_DLL_FUNCION_ERR(controller_state_get_battery_level);
            GET_DLL_FUNCION_ERR(controller_state_get_gyro);
            GET_DLL_FUNCION_ERR(controller_state_get_orientation);
            GET_DLL_FUNCION_ERR(controller_state_get_connection_state);
            GET_DLL_FUNCION_ERR(controller_state_get_api_status);
            GET_DLL_FUNCION_ERR(controller_state_update);
            GET_DLL_FUNCION_ERR(controller_state_destroy);
            GET_DLL_FUNCION_ERR(controller_state_create);
            GET_DLL_FUNCION_ERR(controller_button_to_string);
            GET_DLL_FUNCION_ERR(display_synchronizer_update);
            GET_DLL_FUNCION_ERR(controller_connection_state_to_string);
            GET_DLL_FUNCION_ERR(controller_api_status_to_string);
            GET_DLL_FUNCION_ERR(controller_battery_level_to_string);
            GET_DLL_FUNCION_ERR(display_synchronizer_reset);
            GET_DLL_FUNCION_ERR(controller_resume);
            GET_DLL_FUNCION_ERR(set_ignore_manual_tracker_pause_resume);
            GET_DLL_FUNCION_ERR(controller_pause);
            GET_DLL_FUNCION_ERR(set_display_synchronizer);
            GET_DLL_FUNCION_ERR(controller_destroy);
            GET_DLL_FUNCION_ERR(controller_create_and_init_android);
            GET_DLL_FUNCION_ERR(pause);
            GET_DLL_FUNCION_ERR(tracker_state_get_buffer);
            GET_DLL_FUNCION_ERR(controller_create_and_init);
            GET_DLL_FUNCION_ERR(tracker_state_get_buffer_size);
            GET_DLL_FUNCION_ERR(using_vr_display_service);
            GET_DLL_FUNCION_ERR(controller_get_default_options);
            GET_DLL_FUNCION_ERR(dump_debug_data);
            GET_DLL_FUNCION_ERR(external_surface_create_with_listeners);
            GET_DLL_FUNCION_ERR(external_surface_destroy);
            GET_DLL_FUNCION_ERR(external_surface_get_surface);
            GET_DLL_FUNCION_ERR(external_surface_get_surface_id);
            GET_DLL_FUNCION_ERR(using_dynamic_library);
            GET_DLL_FUNCION_ERR(resume);
            GET_DLL_FUNCION_ERR(set_lens_offset);
            GET_DLL_FUNCION_ERR(reconnect_sensors);
            GET_DLL_FUNCION_ERR(set_display_output_rotation);
            GET_DLL_FUNCION_ERR(get_surface_size);
            GET_DLL_FUNCION_ERR(check_surface_size_changed);
            GET_DLL_FUNCION_ERR(get_border_size_meters);
            GET_DLL_FUNCION_ERR(get_button_long_press);
            GET_DLL_FUNCION_ERR(display_synchronizer_destroy);
            GET_DLL_FUNCION_ERR(display_synchronizer_create);
            GET_DLL_FUNCION_ERR(refresh_viewer_profile);
            GET_DLL_FUNCION_ERR(set_default_viewer_profile);
            GET_DLL_FUNCION_ERR(recenter_tracking);
            GET_DLL_FUNCION_ERR(reset_tracking);
            GET_DLL_FUNCION_ERR(resume_tracking);
            GET_DLL_FUNCION_ERR(buffer_viewport_set_source_fov);
            GET_DLL_FUNCION_ERR(pause_tracking);
            GET_DLL_FUNCION_ERR(frame_get_framebuffer_object);
            GET_DLL_FUNCION_ERR(frame_get_buffer_size);
            GET_DLL_FUNCION_ERR(buffer_viewport_set_target_eye);
            GET_DLL_FUNCION_ERR(buffer_viewport_set_transform);
            GET_DLL_FUNCION_ERR(buffer_spec_set_color_format);
            GET_DLL_FUNCION_ERR(buffer_viewport_get_transform);
            GET_DLL_FUNCION_ERR(set_surface_size);
            GET_DLL_FUNCION_ERR(buffer_viewport_set_external_surface_id);
            GET_DLL_FUNCION_ERR(buffer_viewport_get_external_surface_id);
            GET_DLL_FUNCION_ERR(buffer_viewport_list_get_size);
            GET_DLL_FUNCION_ERR(buffer_viewport_set_source_buffer_index);
            GET_DLL_FUNCION_ERR(get_async_reprojection_enabled);
            GET_DLL_FUNCION_ERR(buffer_viewport_get_source_buffer_index);
            GET_DLL_FUNCION_ERR(get_error_string);
            GET_DLL_FUNCION_ERR(clear_error);
            GET_DLL_FUNCION_ERR(get_viewer_type);
            GET_DLL_FUNCION_ERR(get_error);
            GET_DLL_FUNCION_ERR(get_viewer_model);
            GET_DLL_FUNCION_ERR(get_version_string);
            GET_DLL_FUNCION_ERR(get_viewer_vendor);
            GET_DLL_FUNCION_ERR(get_version);
            GET_DLL_FUNCION_ERR(set_back_gesture_event_handler);
            GET_DLL_FUNCION_ERR(buffer_viewport_create);
            GET_DLL_FUNCION_ERR(get_user_prefs);
            GET_DLL_FUNCION_ERR(buffer_viewport_list_create);
            GET_DLL_FUNCION_ERR(swap_chain_resize_buffer);
            GET_DLL_FUNCION_ERR(frame_submit);
            GET_DLL_FUNCION_ERR(frame_unbind);
            GET_DLL_FUNCION_ERR(gesture_context_create);
            GET_DLL_FUNCION_ERR(gesture_context_destroy);
            GET_DLL_FUNCION_ERR(gesture_get);
            GET_DLL_FUNCION_ERR(gesture_get_count);
            GET_DLL_FUNCION_ERR(gesture_get_direction);
            GET_DLL_FUNCION_ERR(gesture_get_displacement);
            GET_DLL_FUNCION_ERR(gesture_get_type);
            GET_DLL_FUNCION_ERR(gesture_get_velocity);
            GET_DLL_FUNCION_ERR(gesture_restart);
            GET_DLL_FUNCION_ERR(gesture_update);
            GET_DLL_FUNCION_ERR(frame_bind_buffer);
            GET_DLL_FUNCION_ERR(create);
            GET_DLL_FUNCION_ERR(swap_chain_acquire_frame);
            GET_DLL_FUNCION_ERR(apply_neck_model);
            GET_DLL_FUNCION_ERR(get_head_space_from_start_space_rotation);
            GET_DLL_FUNCION_ERR(get_window_bounds);
            GET_DLL_FUNCION_ERR(buffer_viewport_get_source_uv);
            GET_DLL_FUNCION_ERR(get_screen_target_size);
            GET_DLL_FUNCION_ERR(get_screen_buffer_viewports);
            GET_DLL_FUNCION_ERR(user_prefs_get_controller_handedness);
            GET_DLL_FUNCION_ERR(buffer_viewport_list_set_item);
            GET_DLL_FUNCION_ERR(buffer_viewport_set_source_uv);
            GET_DLL_FUNCION_ERR(buffer_viewport_set_reprojection);
            GET_DLL_FUNCION_ERR(buffer_viewport_get_reprojection);
            GET_DLL_FUNCION_ERR(buffer_viewport_set_source_layer);
            GET_DLL_FUNCION_ERR(swap_chain_get_buffer_count);
            GET_DLL_FUNCION_ERR(buffer_viewport_get_source_fov);
            GET_DLL_FUNCION_ERR(buffer_spec_get_samples);
            GET_DLL_FUNCION_ERR(buffer_viewport_get_target_eye);
            GET_DLL_FUNCION_ERR(buffer_spec_get_size);
            GET_DLL_FUNCION_ERR(buffer_viewport_list_get_item);
            GET_DLL_FUNCION_ERR(buffer_viewport_equal);
            GET_DLL_FUNCION_ERR(get_recommended_buffer_viewports);
            GET_DLL_FUNCION_ERR(compute_distorted_point);
            GET_DLL_FUNCION_ERR(set_error);
            GET_DLL_FUNCION_ERR(set_idle_listener);
            GET_DLL_FUNCION_ERR(swap_chain_get_buffer_size);
            GET_DLL_FUNCION_ERR(get_eye_from_head_matrix);
            GET_DLL_FUNCION_ERR(buffer_spec_destroy);
            GET_DLL_FUNCION_ERR(set_display_metrics);
            GET_DLL_FUNCION_ERR(set_viewer_params);
            GET_DLL_FUNCION_ERR(get_time_point_now);
            GET_DLL_FUNCION_ERR(distort_to_screen);
            GET_DLL_FUNCION_ERR(is_feature_supported);
            GET_DLL_FUNCION_ERR(initialize_gl);
            GET_DLL_FUNCION_ERR(buffer_spec_create);
            GET_DLL_FUNCION_ERR(buffer_spec_set_size);
            GET_DLL_FUNCION_ERR(buffer_spec_set_depth_stencil_format);
            GET_DLL_FUNCION_ERR(buffer_spec_set_multiview_layer);
            GET_DLL_FUNCION_ERR(buffer_spec_set_samples);
            GET_DLL_FUNCION_ERR(get_maximum_effective_render_target_size);
            GET_DLL_FUNCION_ERR(bind_default_framebuffer);
            GET_DLL_FUNCION_ERR(swap_chain_create);
            GET_DLL_FUNCION_ERR(buffer_viewport_destroy);
            GET_DLL_FUNCION_ERR(destroy);
            GET_DLL_FUNCION_ERR(swap_chain_destroy);
            GET_DLL_FUNCION_ERR(JNI_OnLoad);
            GET_DLL_FUNCION_ERR(buffer_viewport_list_destroy);
            GET_DLL_FUNCION_ERR(GvrApi_nativeGetWindowBounds);
            GET_DLL_FUNCION_ERR(GvrApi_nativePauseTracking);
            GET_DLL_FUNCION_ERR(GvrApi_nativePauseTrackingGetState);
            GET_DLL_FUNCION_ERR(GvrApi_nativeGetViewerModel);
            GET_DLL_FUNCION_ERR(GvrApi_nativeGetViewerVendor);
            GET_DLL_FUNCION_ERR(GvrApi_nativeGetErrorString);
            GET_DLL_FUNCION_ERR(GvrApi_nativeComputeDistortedPoint);
            GET_DLL_FUNCION_ERR(GvrApi_nativeCreate);
            GET_DLL_FUNCION_ERR(GvrApi_nativeRequestContextSharing);
            GET_DLL_FUNCION_ERR(GvrApi_nativeSwapChainCreate);
            GET_DLL_FUNCION_ERR(GvrApi_nativeSetViewerParams);
            GET_DLL_FUNCION_ERR(GvrApi_nativeSetDefaultViewerProfile);
            GET_DLL_FUNCION_ERR(GvrApi_nativeResumeTracking);
            GET_DLL_FUNCION_ERR(GvrApi_nativeResumeTrackingSetState);
            GET_DLL_FUNCION_ERR(GvrApi_nativeFrameSubmit);
            GET_DLL_FUNCION_ERR(GvrApi_nativeUsingDynamicLibrary);
            GET_DLL_FUNCION_ERR(GvrApi_nativeSetApplicationState);
            GET_DLL_FUNCION_ERR(GvrApi_nativeSetDynamicLibraryLoadingEnabled);
            GET_DLL_FUNCION_ERR(GvrApi_nativeFrameGetBufferSize);
            GET_DLL_FUNCION_ERR(GvrApi_nativeFrameGetFramebufferObject);
            GET_DLL_FUNCION_ERR(GvrApi_nativeFrameUnbind);
            GET_DLL_FUNCION_ERR(GvrApi_nativeFrameBindBuffer);
            GET_DLL_FUNCION_ERR(GvrApi_nativeSwapChainAcquireFrame);
            GET_DLL_FUNCION_ERR(GvrApi_nativeSwapChainResizeBuffer);
            GET_DLL_FUNCION_ERR(GvrApi_nativeSwapChainGetBufferSize);
            GET_DLL_FUNCION_ERR(GvrApi_nativeSwapChainGetBufferCount);
            GET_DLL_FUNCION_ERR(GvrApi_nativeSwapChainDestroy);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferSpecSetDepthStencilFormat);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferSpecSetMultiviewLayers);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferSpecSetColorFormat);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferSpecSetSamples);
            GET_DLL_FUNCION_ERR(GvrApi_nativeExternalSurfaceCreateWithListeners);
            GET_DLL_FUNCION_ERR(GvrApi_nativeExternalSurfaceDestroy);
            GET_DLL_FUNCION_ERR(GvrApi_nativeExternalSurfaceGetId);
            GET_DLL_FUNCION_ERR(GvrApi_nativeExternalSurfaceGetSurface);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferSpecGetSamples);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferSpecSetSize);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferSpecGetSize);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferSpecDestroy);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferSpecCreate);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportEqual);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportSetReprojection);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportSetSourceLayer);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportGetReprojection);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportSetExternalSurfaceId);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportSetExternalSurface);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportGetExternalSurfaceId);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportSetSourceBufferIndex);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportGetSourceBufferIndex);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportSetTargetEye);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportGetTargetEye);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportSetTransform);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportGetTransform);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportSetSourceFov);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportGetSourceFov);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportSetSourceUv);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportGetSourceUv);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportDestroy);
            GET_DLL_FUNCION_ERR(GvrApi_nativeReleaseGvrContext);
            GET_DLL_FUNCION_ERR(GvrApi_nativeResume);
            GET_DLL_FUNCION_ERR(GvrApi_nativePause);
            GET_DLL_FUNCION_ERR(GvrApi_nativeUserPrefsGetControllerHandedness);
            GET_DLL_FUNCION_ERR(GvrApi_nativeGetUserPrefs);
            GET_DLL_FUNCION_ERR(GvrApi_nativeClearError);
            GET_DLL_FUNCION_ERR(GvrApi_nativeGetError);
            GET_DLL_FUNCION_ERR(GvrApi_nativeGetRecommendedBufferViewports);
            GET_DLL_FUNCION_ERR(GvrApi_nativeOnSurfaceCreatedReprojectionThread);
            GET_DLL_FUNCION_ERR(GvrApi_nativeOnSurfaceChangedReprojectionThread);
            GET_DLL_FUNCION_ERR(GvrApi_nativeInitializeGl);
            GET_DLL_FUNCION_ERR(GvrApi_nativeDumpDebugData);
            GET_DLL_FUNCION_ERR(DisplaySynchronizer_nativeDestroy);
            GET_DLL_FUNCION_ERR(DisplaySynchronizer_nativeCreate);
            GET_DLL_FUNCION_ERR(DisplaySynchronizer_nativeUpdate);
            GET_DLL_FUNCION_ERR(ExternalSurfaceManager_nativeUpdateSurface);
            GET_DLL_FUNCION_ERR(DisplaySynchronizer_nativeReset);
            GET_DLL_FUNCION_ERR(GvrApi_nativeSetDisplayMetrics);
            GET_DLL_FUNCION_ERR(GvrApi_nativeReconnectSensors);
            GET_DLL_FUNCION_ERR(GvrApi_nativeSetIdleListener);
            GET_DLL_FUNCION_ERR(GvrApi_nativeGetAsyncReprojectionEnabled);
            GET_DLL_FUNCION_ERR(GvrApi_nativeIsFeatureSupported);
            GET_DLL_FUNCION_ERR(GvrApi_nativeSetLensOffset);
            GET_DLL_FUNCION_ERR(GvrApi_nativeSetSurfaceSize);
            GET_DLL_FUNCION_ERR(GvrApi_nativeGetBorderSizeMeters);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportListDestroy);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportListCreate);
            GET_DLL_FUNCION_ERR(GvrApi_nativeUsingVrDisplayService);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportCreate);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportListSetItem);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportListGetItem);
            GET_DLL_FUNCION_ERR(GvrApi_nativeBufferViewportListGetSize);
            GET_DLL_FUNCION_ERR(GvrApi_nativeDistortToScreen);
            GET_DLL_FUNCION_ERR(GvrApi_nativeGetScreenTargetSize);
            GET_DLL_FUNCION_ERR(GvrApi_nativeGetMaximumEffectiveRenderTargetSize);
            GET_DLL_FUNCION_ERR(GvrApi_nativeGetScreenBufferViewports);
            GET_DLL_FUNCION_ERR(GvrApi_nativeSetDefaultFramebufferActive);
            GET_DLL_FUNCION_ERR(GvrApi_nativeOnPauseReprojectionThread);
            GET_DLL_FUNCION_ERR(GvrApi_nativeRenderReprojectionThread);
            GET_DLL_FUNCION_ERR(GvrApi_nativeResetTracking);
            GET_DLL_FUNCION_ERR(GvrApi_nativeSetIgnoreManualPauseResumeTracker);
            GET_DLL_FUNCION_ERR(GvrApi_nativeGetHeadSpaceFromStartSpaceRotation);
            GET_DLL_FUNCION_ERR(GvrApi_nativeSetAsyncReprojectionEnabled);
            GET_DLL_FUNCION_ERR(GvrApi_nativeGetViewerType);
            GET_DLL_FUNCION_ERR(GvrApi_nativeGetEyeFromHeadMatrix);
            GET_DLL_FUNCION_ERR(GvrApi_nativeRecenterTracking);
            GET_DLL_FUNCION_ERR(VrParamsProviderJni_nativeUpdateNativePhoneParamsPointer);
            GET_DLL_FUNCION_ERR(MirthNet_setHttpProxy);
            GET_DLL_FUNCION_ERR(NativeCallbacks_handleServiceDisconnected);
            GET_DLL_FUNCION_ERR(NativeCallbacks_handleServiceConnected);
            GET_DLL_FUNCION_ERR(NativeCallbacks_handleServiceUnavailable);
            GET_DLL_FUNCION_ERR(NativeCallbacks_handleServiceFailed);
            GET_DLL_FUNCION_ERR(NativeCallbacks_handleServiceInitFailed);
            GET_DLL_FUNCION_ERR(NativeCallbacks_handleGyroEvent);
            GET_DLL_FUNCION_ERR(NativeCallbacks_handleAccelEvent);
            GET_DLL_FUNCION_ERR(NativeCallbacks_handleBatteryEvent);
            GET_DLL_FUNCION_ERR(NativeCallbacks_handleButtonEvent);
            GET_DLL_FUNCION_ERR(NativeCallbacks_handleOrientationEvent);
            GET_DLL_FUNCION_ERR(NativeCallbacks_handleTouchEvent);
            GET_DLL_FUNCION_ERR(NativeCallbacks_handleControllerRecentered);
            GET_DLL_FUNCION_ERR(NativeCallbacks_handleStateChanged);
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeInit);
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeGetCurrentEyeParams);
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeSetRenderer);
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeSetStereoRenderer);
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeSetGvrViewerParams);
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeLogEvent);
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeSetApplicationState);
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeSetScreenParams);
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeSetNeckModelFactor);
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeGetNeckModelFactor );
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeOnDrawFrame );
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeSetNeckModelEnabled );
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeDestroy);
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeOnSurfaceCreated);
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeOnSurfaceChanged);
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeSetStereoModeEnabled);
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled);
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeSetDistortionCorrectionScale);
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeSetMultisampling);
            GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeSetDepthStencilFormat);
            ReleaseFun();
        }
    }
    else
    {
        const char* err = dlerror();
        LOGE( "Can not load libary \"gvrimpl.so\"  Error = %s" , err ? err : "Unknown");
    }

    return	 m_bInit;
}


void ReleaseFun()
{
    if (m_hDLL)
        dlclose(m_hDLL);

    m_fpcreate_with_tracker_for_testing = NULL;
    m_fptracker_state_create = NULL;
    m_fppause_tracking_get_state = NULL;
    m_fpresume_tracking_set_state = NULL;
    m_fptracker_state_destroy = NULL;
    m_fpcontroller_state_get_last_button_timestamp = NULL;
    m_fprender_reprojection_thread = NULL;
    m_fpcontroller_state_get_last_touch_timestamp = NULL;
    m_fpon_surface_created_reprojection_thread = NULL;
    m_fpcontroller_state_get_last_accel_timestamp = NULL;
    m_fpset_async_reprojection_enabled = NULL;
    m_fpcontroller_state_get_last_gyro_timestamp = NULL;
    m_fpcontroller_state_get_last_orientation_timestamp = NULL;
    m_fpcontroller_state_get_last_battery_timestamp = NULL;
    m_fpremove_all_surfaces_reprojection_thread = NULL;
    m_fpcontroller_state_get_button_up = NULL;
    m_fpcontroller_state_get_button_down = NULL;
    m_fpupdate_surface_reprojection_thread = NULL;
    m_fpcontroller_state_get_button_state = NULL;
    m_fpon_pause_reprojection_thread = NULL;
    m_fpon_surface_changed_reprojection_thread = NULL;
    m_fpcontroller_state_get_recentering = NULL;
    m_fpcontroller_state_get_recentered = NULL;
    m_fpcontroller_state_get_touch_up = NULL;
    m_fpcontroller_state_get_touch_down = NULL;
    m_fpcontroller_state_get_touch_pos = NULL;
    m_fpcontroller_state_is_touching = NULL;
    m_fpcontroller_state_get_accel = NULL;
    m_fpcontroller_state_get_battery_charging = NULL;
    m_fpcontroller_state_get_battery_level = NULL;
    m_fpcontroller_state_get_gyro = NULL;
    m_fpcontroller_state_get_orientation = NULL;
    m_fpcontroller_state_get_connection_state = NULL;
    m_fpcontroller_state_get_api_status = NULL;
    m_fpcontroller_state_update = NULL;
    m_fpcontroller_state_destroy = NULL;
    m_fpcontroller_state_create = NULL;
    m_fpcontroller_button_to_string = NULL;
    m_fpdisplay_synchronizer_update = NULL;
    m_fpcontroller_connection_state_to_string = NULL;
    m_fpcontroller_api_status_to_string = NULL;
    m_fpcontroller_battery_level_to_string = NULL;
    m_fpdisplay_synchronizer_reset = NULL;
    m_fpcontroller_resume = NULL;
    m_fpset_ignore_manual_tracker_pause_resume = NULL;
    m_fpcontroller_pause = NULL;
    m_fpset_display_synchronizer = NULL;
    m_fpcontroller_destroy = NULL;
    m_fpcontroller_create_and_init_android = NULL;
    m_fppause = NULL;
    m_fptracker_state_get_buffer = NULL;
    m_fpcontroller_create_and_init = NULL;
    m_fptracker_state_get_buffer_size = NULL;
    m_fpusing_vr_display_service = NULL;
    m_fpcontroller_get_default_options = NULL;
    m_fpdump_debug_data = NULL;
    m_fpexternal_surface_create_with_listeners = NULL;
    m_fpexternal_surface_destroy = NULL;
    m_fpexternal_surface_get_surface = NULL;
    m_fpexternal_surface_get_surface_id = NULL;
    m_fpusing_dynamic_library = NULL;
    m_fpresume = NULL;
    m_fpset_lens_offset = NULL;
    m_fpreconnect_sensors = NULL;
    m_fpset_display_output_rotation = NULL;
    m_fpget_surface_size = NULL;
    m_fpcheck_surface_size_changed = NULL;
    m_fpget_border_size_meters = NULL;
    m_fpget_button_long_press = NULL;
    m_fpdisplay_synchronizer_destroy = NULL;
    m_fpdisplay_synchronizer_create = NULL;
    m_fprefresh_viewer_profile = NULL;
    m_fpset_default_viewer_profile = NULL;
    m_fprecenter_tracking = NULL;
    m_fpreset_tracking = NULL;
    m_fpresume_tracking = NULL;
    m_fpbuffer_viewport_set_source_fov = NULL;
    m_fppause_tracking = NULL;
    m_fpframe_get_framebuffer_object = NULL;
    m_fpframe_get_buffer_size = NULL;
    m_fpbuffer_viewport_set_target_eye = NULL;
    m_fpbuffer_viewport_set_transform = NULL;
    m_fpbuffer_spec_set_color_format = NULL;
    m_fpbuffer_viewport_get_transform = NULL;
    m_fpset_surface_size = NULL;
    m_fpbuffer_viewport_set_external_surface_id = NULL;
    m_fpbuffer_viewport_get_external_surface_id = NULL;
    m_fpbuffer_viewport_list_get_size = NULL;
    m_fpbuffer_viewport_set_source_buffer_index = NULL;
    m_fpget_async_reprojection_enabled = NULL;
    m_fpbuffer_viewport_get_source_buffer_index = NULL;
    m_fpget_error_string = NULL;
    m_fpclear_error = NULL;
    m_fpget_viewer_type = NULL;
    m_fpget_error = NULL;
    m_fpget_viewer_model = NULL;
    m_fpget_version_string = NULL;
    m_fpget_viewer_vendor = NULL;
    m_fpget_version = NULL;
    m_fpset_back_gesture_event_handler = NULL;
    m_fpbuffer_viewport_create = NULL;
    m_fpget_user_prefs = NULL;
    m_fpbuffer_viewport_list_create = NULL;
    m_fpswap_chain_resize_buffer = NULL;
    m_fpframe_submit = NULL;
    m_fpframe_unbind = NULL;
    m_fpgesture_context_create = NULL;
    m_fpgesture_context_destroy = NULL;
    m_fpgesture_get = NULL;
    m_fpgesture_get_count = NULL;
    m_fpgesture_get_direction = NULL;
    m_fpgesture_get_displacement = NULL;
    m_fpgesture_get_type = NULL;
    m_fpgesture_get_velocity = NULL;
    m_fpgesture_restart = NULL;
    m_fpgesture_update = NULL;
    m_fpframe_bind_buffer = NULL;
    m_fpcreate = NULL;
    m_fpswap_chain_acquire_frame = NULL;
    m_fpapply_neck_model = NULL;
    m_fpget_head_space_from_start_space_rotation = NULL;
    m_fpget_window_bounds = NULL;
    m_fpbuffer_viewport_get_source_uv = NULL;
    m_fpget_screen_target_size = NULL;
    m_fpget_screen_buffer_viewports = NULL;
    m_fpuser_prefs_get_controller_handedness = NULL;
    m_fpbuffer_viewport_list_set_item = NULL;
    m_fpbuffer_viewport_set_source_uv = NULL;
    m_fpbuffer_viewport_set_reprojection = NULL;
    m_fpbuffer_viewport_get_reprojection = NULL;
    m_fpbuffer_viewport_set_source_layer = NULL;
    m_fpswap_chain_get_buffer_count = NULL;
    m_fpbuffer_viewport_get_source_fov = NULL;
    m_fpbuffer_spec_get_samples = NULL;
    m_fpbuffer_viewport_get_target_eye = NULL;
    m_fpbuffer_spec_get_size = NULL;
    m_fpbuffer_viewport_list_get_item = NULL;
    m_fpbuffer_viewport_equal = NULL;
    m_fpget_recommended_buffer_viewports = NULL;
    m_fpcompute_distorted_point = NULL;
    m_fpset_error = NULL;
    m_fpset_idle_listener = NULL;
    m_fpswap_chain_get_buffer_size = NULL;
    m_fpget_eye_from_head_matrix = NULL;
    m_fpbuffer_spec_destroy = NULL;
    m_fpset_display_metrics = NULL;
    m_fpset_viewer_params = NULL;
    m_fpget_time_point_now = NULL;
    m_fpdistort_to_screen = NULL;
    m_fpis_feature_supported = NULL;
    m_fpinitialize_gl = NULL;
    m_fpbuffer_spec_create = NULL;
    m_fpbuffer_spec_set_size = NULL;
    m_fpbuffer_spec_set_depth_stencil_format = NULL;
    m_fpbuffer_spec_set_multiview_layer = NULL;
    m_fpbuffer_spec_set_samples = NULL;
    m_fpget_maximum_effective_render_target_size = NULL;
    m_fpbind_default_framebuffer = NULL;
    m_fpswap_chain_create = NULL;
    m_fpbuffer_viewport_destroy = NULL;
    m_fpdestroy = NULL;
    m_fpswap_chain_destroy = NULL;
    m_fpJNI_OnLoad = NULL;
    m_fpbuffer_viewport_list_destroy = NULL;
    m_fpGvrApi_nativeGetWindowBounds = NULL;
    m_fpGvrApi_nativePauseTracking = NULL;
    m_fpGvrApi_nativePauseTrackingGetState = NULL;
    m_fpGvrApi_nativeGetViewerModel = NULL;
    m_fpGvrApi_nativeGetViewerVendor = NULL;
    m_fpGvrApi_nativeGetErrorString = NULL;
    m_fpGvrApi_nativeComputeDistortedPoint = NULL;
    m_fpGvrApi_nativeCreate = NULL;
    m_fpGvrApi_nativeRequestContextSharing = NULL;
    m_fpGvrApi_nativeSwapChainCreate = NULL;
    m_fpGvrApi_nativeSetViewerParams = NULL;
    m_fpGvrApi_nativeSetDefaultViewerProfile = NULL;
    m_fpGvrApi_nativeResumeTracking = NULL;
    m_fpGvrApi_nativeResumeTrackingSetState = NULL;
    m_fpGvrApi_nativeFrameSubmit = NULL;
    m_fpGvrApi_nativeUsingDynamicLibrary = NULL;
    m_fpGvrApi_nativeSetApplicationState = NULL;
    m_fpGvrApi_nativeSetDynamicLibraryLoadingEnabled = NULL;
    m_fpGvrApi_nativeFrameGetBufferSize = NULL;
    m_fpGvrApi_nativeFrameGetFramebufferObject = NULL;
    m_fpGvrApi_nativeFrameUnbind = NULL;
    m_fpGvrApi_nativeFrameBindBuffer = NULL;
    m_fpGvrApi_nativeSwapChainAcquireFrame = NULL;
    m_fpGvrApi_nativeSwapChainResizeBuffer = NULL;
    m_fpGvrApi_nativeSwapChainGetBufferSize = NULL;
    m_fpGvrApi_nativeSwapChainGetBufferCount = NULL;
    m_fpGvrApi_nativeSwapChainDestroy = NULL;
    m_fpGvrApi_nativeBufferSpecSetDepthStencilFormat = NULL;
    m_fpGvrApi_nativeBufferSpecSetMultiviewLayers = NULL;
    m_fpGvrApi_nativeBufferSpecSetColorFormat = NULL;
    m_fpGvrApi_nativeBufferSpecSetSamples = NULL;
    m_fpGvrApi_nativeExternalSurfaceCreateWithListeners = NULL;
    m_fpGvrApi_nativeExternalSurfaceDestroy = NULL;
    m_fpGvrApi_nativeExternalSurfaceGetId = NULL;
    m_fpGvrApi_nativeExternalSurfaceGetSurface = NULL;
    m_fpGvrApi_nativeBufferSpecGetSamples = NULL;
    m_fpGvrApi_nativeBufferSpecSetSize = NULL;
    m_fpGvrApi_nativeBufferSpecGetSize = NULL;
    m_fpGvrApi_nativeBufferSpecDestroy = NULL;
    m_fpGvrApi_nativeBufferSpecCreate = NULL;
    m_fpGvrApi_nativeBufferViewportEqual = NULL;
    m_fpGvrApi_nativeBufferViewportSetReprojection = NULL;
    m_fpGvrApi_nativeBufferViewportSetSourceLayer = NULL;
    m_fpGvrApi_nativeBufferViewportGetReprojection = NULL;
    m_fpGvrApi_nativeBufferViewportSetExternalSurfaceId = NULL;
    m_fpGvrApi_nativeBufferViewportSetExternalSurface = NULL;
    m_fpGvrApi_nativeBufferViewportGetExternalSurfaceId = NULL;
    m_fpGvrApi_nativeBufferViewportSetSourceBufferIndex = NULL;
    m_fpGvrApi_nativeBufferViewportGetSourceBufferIndex = NULL;
    m_fpGvrApi_nativeBufferViewportSetTargetEye = NULL;
    m_fpGvrApi_nativeBufferViewportGetTargetEye = NULL;
    m_fpGvrApi_nativeBufferViewportSetTransform = NULL;
    m_fpGvrApi_nativeBufferViewportGetTransform = NULL;
    m_fpGvrApi_nativeBufferViewportSetSourceFov = NULL;
    m_fpGvrApi_nativeBufferViewportGetSourceFov = NULL;
    m_fpGvrApi_nativeBufferViewportSetSourceUv = NULL;
    m_fpGvrApi_nativeBufferViewportGetSourceUv = NULL;
    m_fpGvrApi_nativeBufferViewportDestroy = NULL;
    m_fpGvrApi_nativeReleaseGvrContext = NULL;
    m_fpGvrApi_nativeResume = NULL;
    m_fpGvrApi_nativePause = NULL;
    m_fpGvrApi_nativeUserPrefsGetControllerHandedness = NULL;
    m_fpGvrApi_nativeGetUserPrefs = NULL;
    m_fpGvrApi_nativeClearError = NULL;
    m_fpGvrApi_nativeGetError = NULL;
    m_fpGvrApi_nativeGetRecommendedBufferViewports = NULL;
    m_fpGvrApi_nativeOnSurfaceCreatedReprojectionThread = NULL;
    m_fpGvrApi_nativeOnSurfaceChangedReprojectionThread = NULL;
    m_fpGvrApi_nativeInitializeGl = NULL;
    m_fpGvrApi_nativeDumpDebugData = NULL;
    m_fpDisplaySynchronizer_nativeDestroy = NULL;
    m_fpDisplaySynchronizer_nativeCreate = NULL;
    m_fpDisplaySynchronizer_nativeUpdate = NULL;
    m_fpExternalSurfaceManager_nativeUpdateSurface = NULL;
    m_fpDisplaySynchronizer_nativeReset = NULL;
    m_fpGvrApi_nativeSetDisplayMetrics = NULL;
    m_fpGvrApi_nativeReconnectSensors = NULL;
    m_fpGvrApi_nativeSetIdleListener = NULL;
    m_fpGvrApi_nativeGetAsyncReprojectionEnabled = NULL;
    m_fpGvrApi_nativeIsFeatureSupported = NULL;
    m_fpGvrApi_nativeSetLensOffset = NULL;
    m_fpGvrApi_nativeSetSurfaceSize = NULL;
    m_fpGvrApi_nativeGetBorderSizeMeters = NULL;
    m_fpGvrApi_nativeBufferViewportListDestroy = NULL;
    m_fpGvrApi_nativeBufferViewportListCreate = NULL;
    m_fpGvrApi_nativeUsingVrDisplayService = NULL;
    m_fpGvrApi_nativeBufferViewportCreate = NULL;
    m_fpGvrApi_nativeBufferViewportListSetItem = NULL;
    m_fpGvrApi_nativeBufferViewportListGetItem = NULL;
    m_fpGvrApi_nativeBufferViewportListGetSize = NULL;
    m_fpGvrApi_nativeDistortToScreen = NULL;
    m_fpGvrApi_nativeGetScreenTargetSize = NULL;
    m_fpGvrApi_nativeGetMaximumEffectiveRenderTargetSize = NULL;
    m_fpGvrApi_nativeGetScreenBufferViewports = NULL;
    m_fpGvrApi_nativeSetDefaultFramebufferActive = NULL;
    m_fpGvrApi_nativeOnPauseReprojectionThread = NULL;
    m_fpGvrApi_nativeRenderReprojectionThread = NULL;
    m_fpGvrApi_nativeResetTracking = NULL;
    m_fpGvrApi_nativeSetIgnoreManualPauseResumeTracker = NULL;
    m_fpGvrApi_nativeGetHeadSpaceFromStartSpaceRotation = NULL;
    m_fpGvrApi_nativeSetAsyncReprojectionEnabled = NULL;
    m_fpGvrApi_nativeGetViewerType = NULL;
    m_fpGvrApi_nativeGetEyeFromHeadMatrix = NULL;
    m_fpGvrApi_nativeRecenterTracking = NULL;
    m_fpVrParamsProviderJni_nativeUpdateNativePhoneParamsPointer = NULL;
    m_fpMirthNet_setHttpProxy = NULL;
    m_fpNativeCallbacks_handleServiceDisconnected = NULL;
    m_fpNativeCallbacks_handleServiceConnected = NULL;
    m_fpNativeCallbacks_handleServiceUnavailable = NULL;
    m_fpNativeCallbacks_handleServiceFailed = NULL;
    m_fpNativeCallbacks_handleServiceInitFailed = NULL;
    m_fpNativeCallbacks_handleGyroEvent = NULL;
    m_fpNativeCallbacks_handleAccelEvent = NULL;
    m_fpNativeCallbacks_handleBatteryEvent = NULL;
    m_fpNativeCallbacks_handleButtonEvent = NULL;
    m_fpNativeCallbacks_handleOrientationEvent = NULL;
    m_fpNativeCallbacks_handleTouchEvent = NULL;
    m_fpNativeCallbacks_handleControllerRecentered = NULL;
    m_fpNativeCallbacks_handleStateChanged = NULL;
    m_fpCardboardViewNativeImpl_nativeInit = NULL;
    m_fpCardboardViewNativeImpl_nativeGetCurrentEyeParams = NULL;
    m_fpCardboardViewNativeImpl_nativeSetRenderer = NULL;
    m_fpCardboardViewNativeImpl_nativeSetStereoRenderer = NULL;
    m_fpCardboardViewNativeImpl_nativeSetGvrViewerParams = NULL;
    m_fpCardboardViewNativeImpl_nativeLogEvent = NULL;
    m_fpCardboardViewNativeImpl_nativeSetApplicationState = NULL;
    m_fpCardboardViewNativeImpl_nativeSetScreenParams = NULL;
    m_fpCardboardViewNativeImpl_nativeSetNeckModelFactor = NULL;
    m_fpCardboardViewNativeImpl_nativeGetNeckModelFactor  = NULL;
    m_fpCardboardViewNativeImpl_nativeOnDrawFrame  = NULL;
    m_fpCardboardViewNativeImpl_nativeSetNeckModelEnabled  = NULL;
    m_fpCardboardViewNativeImpl_nativeDestroy = NULL;
    m_fpCardboardViewNativeImpl_nativeOnSurfaceCreated = NULL;
    m_fpCardboardViewNativeImpl_nativeOnSurfaceChanged = NULL;
    m_fpCardboardViewNativeImpl_nativeSetStereoModeEnabled = NULL;
    m_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled = NULL;
    m_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionScale = NULL;
    m_fpCardboardViewNativeImpl_nativeSetMultisampling = NULL;
    m_fpCardboardViewNativeImpl_nativeSetDepthStencilFormat = NULL;
    return;
}

//ClassLoader paramClassLoader, Context paramContext)
JNIEXPORT long JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetApplicationState(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( m_fpCardboardViewNativeImpl_nativeSetApplicationState)
        re = m_fpCardboardViewNativeImpl_nativeSetApplicationState(env, obj, paramClassLoader, paramContext);
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetScreenParams(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1,
        jfloat paramFloat2, jfloat paramFloat3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpCardboardViewNativeImpl_nativeSetScreenParams){
        m_fpCardboardViewNativeImpl_nativeSetScreenParams(env, obj, paramLong, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3);
    }
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetNeckModelFactor(
        JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpCardboardViewNativeImpl_nativeSetNeckModelFactor){
        m_fpCardboardViewNativeImpl_nativeSetNeckModelFactor(env, obj, paramLong, paramFloat);
    }
    return;
}
JNIEXPORT float JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeGetNeckModelFactor(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    float re=0;
    if( m_fpCardboardViewNativeImpl_nativeGetNeckModelFactor)
        re = m_fpCardboardViewNativeImpl_nativeGetNeckModelFactor(env, obj, paramLong);
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeOnDrawFrame(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpCardboardViewNativeImpl_nativeOnDrawFrame)
        m_fpCardboardViewNativeImpl_nativeOnDrawFrame(env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetNeckModelEnabled(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpCardboardViewNativeImpl_nativeSetNeckModelEnabled)
        m_fpCardboardViewNativeImpl_nativeSetNeckModelEnabled(env, obj, paramLong, paramBoolean);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpCardboardViewNativeImpl_nativeDestroy)
        m_fpCardboardViewNativeImpl_nativeDestroy(env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeOnSurfaceCreated(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpCardboardViewNativeImpl_nativeOnSurfaceCreated)
        m_fpCardboardViewNativeImpl_nativeOnSurfaceCreated(env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeOnSurfaceChanged(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpCardboardViewNativeImpl_nativeOnSurfaceChanged)
        m_fpCardboardViewNativeImpl_nativeOnSurfaceChanged(env, obj, paramLong, paramInt1, paramInt2);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetStereoModeEnabled(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpCardboardViewNativeImpl_nativeSetStereoModeEnabled)
        m_fpCardboardViewNativeImpl_nativeSetStereoModeEnabled(env, obj, paramLong, paramBoolean);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled)
        m_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled(env, obj, paramLong, paramBoolean);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetDistortionCorrectionScale(
        JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionScale)
        m_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionScale(env, obj, paramLong, paramFloat);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetMultisampling(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpCardboardViewNativeImpl_nativeSetMultisampling)
        m_fpCardboardViewNativeImpl_nativeSetMultisampling(env, obj, paramLong, paramInt);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetDepthStencilFormat(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpCardboardViewNativeImpl_nativeSetDepthStencilFormat)
        m_fpCardboardViewNativeImpl_nativeSetDepthStencilFormat(env,obj, paramLong, paramInt);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeUndistortTexture(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    assert(false);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeLogEvent(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpCardboardViewNativeImpl_nativeLogEvent)
        m_fpCardboardViewNativeImpl_nativeLogEvent( env, obj, paramLong, paramInt);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetGvrViewerParams(
        JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpCardboardViewNativeImpl_nativeSetGvrViewerParams)
        m_fpCardboardViewNativeImpl_nativeSetGvrViewerParams(env, obj, paramLong, paramArrayOfByte);
    return;
}
//GvrView.StereoRenderer paramStereoRenderer
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetStereoRenderer(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramStereoRenderer)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpCardboardViewNativeImpl_nativeSetStereoRenderer)
        m_fpCardboardViewNativeImpl_nativeSetStereoRenderer(env, obj, paramLong, paramStereoRenderer );
    return;
}
//GvrView.Renderer
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetRenderer(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramRenderer)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpCardboardViewNativeImpl_nativeSetRenderer)
        m_fpCardboardViewNativeImpl_nativeSetRenderer(env, obj, paramLong, paramRenderer);
    return;
}

//HeadTransform paramHeadTransform, Eye paramEye1, Eye paramEye2, Eye paramEye3, Eye paramEye4, Eye paramEye
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeGetCurrentEyeParams(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramHeadTransform, jobject paramEye1, jobject paramEye2,
        jobject paramEye3, jobject paramEye4, jobject paramEye5)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpCardboardViewNativeImpl_nativeGetCurrentEyeParams) {
        m_fpCardboardViewNativeImpl_nativeGetCurrentEyeParams(env, obj, paramLong,
                                                              paramHeadTransform, paramEye1,
                                                              paramEye2, paramEye3,
                                                              paramEye4, paramEye5);
    }
    return;
}
JNIEXPORT long JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeInit(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( m_fpCardboardViewNativeImpl_nativeInit)
        re = m_fpCardboardViewNativeImpl_nativeInit(env, obj, paramLong);
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleStateChanged(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2 )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpNativeCallbacks_handleStateChanged)
        m_fpNativeCallbacks_handleStateChanged(env, obj, paramLong, paramInt1, paramInt2 );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleControllerRecentered(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2,
        jfloat paramFloat3, jfloat paramFloat4)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpNativeCallbacks_handleControllerRecentered)
        m_fpNativeCallbacks_handleControllerRecentered(env, obj, paramLong1, paramLong2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleTouchEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt, jfloat paramFloat1, jfloat paramFloat2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpNativeCallbacks_handleTouchEvent)
        m_fpNativeCallbacks_handleTouchEvent( env, obj, paramLong1, paramLong2, paramInt, paramFloat1, paramFloat2);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleOrientationEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpNativeCallbacks_handleOrientationEvent)
        m_fpNativeCallbacks_handleOrientationEvent(env, obj, paramLong1, paramLong2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleButtonEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt, jboolean paramBoolean)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpNativeCallbacks_handleButtonEvent)
        m_fpNativeCallbacks_handleButtonEvent( env, obj, paramLong1, paramLong2, paramInt, paramBoolean);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleAccelEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpNativeCallbacks_handleAccelEvent)
        m_fpNativeCallbacks_handleAccelEvent( env, obj, paramLong1, paramLong2, paramFloat1, paramFloat2, paramFloat3);
    return;
}

JNIEXPORT void JNICALL  Java_com_google_vr_internal_controller_NativeCallbacks_handleBatteryEvent(
        JNIEnv* env, jobject obj, jlong var1, jlong var3, jboolean var5, jint var6)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpNativeCallbacks_handleBatteryEvent)
        m_fpNativeCallbacks_handleBatteryEvent(env, obj, var1, var3, var5, var6);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleGyroEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpNativeCallbacks_handleGyroEvent)
        m_fpNativeCallbacks_handleGyroEvent( env, obj, paramLong1, paramLong2, paramFloat1, paramFloat2, paramFloat3);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceInitFailed(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpNativeCallbacks_handleServiceInitFailed)
        m_fpNativeCallbacks_handleServiceInitFailed( env, obj, paramLong, paramInt);
    return;
}
JNIEXPORT void JNICALL  Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceFailed(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpNativeCallbacks_handleServiceFailed)
        m_fpNativeCallbacks_handleServiceFailed( env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceUnavailable(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpNativeCallbacks_handleServiceUnavailable)
        m_fpNativeCallbacks_handleServiceUnavailable( env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceConnected(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpNativeCallbacks_handleServiceConnected)
        m_fpNativeCallbacks_handleServiceConnected(env, obj, paramLong, paramInt);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceDisconnected(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpNativeCallbacks_handleServiceDisconnected)
        m_fpNativeCallbacks_handleServiceDisconnected( env, obj, paramLong);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_cardboard_VrParamsProviderJni_nativeUpdateNativePhoneParamsPointer(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1, jfloat paramFloat2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpVrParamsProviderJni_nativeUpdateNativePhoneParamsPointer)
        m_fpVrParamsProviderJni_nativeUpdateNativePhoneParamsPointer( env, obj, paramLong, paramInt1, paramInt2, paramFloat1, paramFloat2);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeRecenterTracking(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeRecenterTracking)
        m_fpGvrApi_nativeRecenterTracking( env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetEyeFromHeadMatrix(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jfloatArray paramArrayOfFloat)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeGetEyeFromHeadMatrix)
        m_fpGvrApi_nativeGetEyeFromHeadMatrix( env, obj, paramLong, paramInt, paramArrayOfFloat);
    return;
}

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetViewerType(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(m_fpGvrApi_nativeGetViewerType)
        re =m_fpGvrApi_nativeGetViewerType( env, obj, paramLong);
    LOGI("mjgvr F:%s, bool:%d", __FUNCTION__, re );
    return re;
}
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBool)
{
    CLogMessage msg(__FUNCTION__);
    bool re = false;
    InitLoadFun();
    if( m_fpGvrApi_nativeSetAsyncReprojectionEnabled)
        re = m_fpGvrApi_nativeSetAsyncReprojectionEnabled(env, obj, paramLong, paramBool);
//    re = false;
    LOGI("mjgvr F:%s, bool:%d", __FUNCTION__, re );
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetHeadSpaceFromStartSpaceRotation(
        JNIEnv* env, jobject obj, jlong paramLong1, jfloatArray paramArrayOfFloat, jlong paramLong2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeGetHeadSpaceFromStartSpaceRotation)
        m_fpGvrApi_nativeGetHeadSpaceFromStartSpaceRotation( env, obj, paramLong1, paramArrayOfFloat, paramLong2);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetIgnoreManualPauseResumeTracker(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeSetIgnoreManualPauseResumeTracker)
        m_fpGvrApi_nativeSetIgnoreManualPauseResumeTracker(env, obj, paramLong, paramBoolean);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeResetTracking(JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeResetTracking)
        m_fpGvrApi_nativeResetTracking( env, obj, paramLong);
    return;
}

JNIEXPORT jobject JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeRenderReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jobject re = NULL;
    if(m_fpGvrApi_nativeRenderReprojectionThread)
        re = m_fpGvrApi_nativeRenderReprojectionThread(env, obj, paramLong);
    return  re;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeOnPauseReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeOnPauseReprojectionThread)
        m_fpGvrApi_nativeOnPauseReprojectionThread(env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDefaultFramebufferActive(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeSetDefaultFramebufferActive)
        m_fpGvrApi_nativeSetDefaultFramebufferActive( env, obj, paramLong);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetScreenBufferViewports(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2 )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeGetScreenBufferViewports)
        m_fpGvrApi_nativeGetScreenBufferViewports(env, obj, paramLong1, paramLong2);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetMaximumEffectiveRenderTargetSize(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeGetMaximumEffectiveRenderTargetSize)
        m_fpGvrApi_nativeGetMaximumEffectiveRenderTargetSize( env, obj, paramLong, paramPoint);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetScreenTargetSize(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeGetScreenTargetSize)
        m_fpGvrApi_nativeGetScreenTargetSize( env, obj, paramLong, paramPoint);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeDistortToScreen(
        JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2, jfloatArray paramArrayOfFloat, jlong paramLong3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeDistortToScreen)
        m_fpGvrApi_nativeDistortToScreen( env, obj, paramLong1, paramInt, paramLong2, paramArrayOfFloat, paramLong3);
    return;
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListGetSize(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( m_fpGvrApi_nativeBufferViewportListGetSize)
        re = m_fpGvrApi_nativeBufferViewportListGetSize(env, obj, paramLong );
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListGetItem(
        JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeBufferViewportListGetItem)
        m_fpGvrApi_nativeBufferViewportListGetItem( env, obj, paramLong1, paramInt, paramLong2);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListSetItem(
        JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeBufferViewportListSetItem)
        m_fpGvrApi_nativeBufferViewportListSetItem( env, obj, paramLong1, paramInt, paramLong2);
    return;
}

JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportCreate(JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( m_fpGvrApi_nativeBufferViewportCreate)
        re = m_fpGvrApi_nativeBufferViewportCreate( env, obj, paramLong);
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeRemoveAllSurfacesReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    assert(false);
    return;
}
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUsingVrDisplayService(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = 0;
    if( m_fpGvrApi_nativeUsingVrDisplayService)
        m_fpGvrApi_nativeUsingVrDisplayService(env, obj, paramLong);
    LOGI("mjgvr F:%s, bool:%d", __FUNCTION__, re );
    return re;
}

JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListCreate(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( m_fpGvrApi_nativeBufferViewportListCreate)
        re = m_fpGvrApi_nativeBufferViewportListCreate(env, obj, paramLong);
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeBufferViewportListDestroy)
        m_fpGvrApi_nativeBufferViewportListDestroy( env, obj, paramLong);
    return;
}

JNIEXPORT float JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetBorderSizeMeters(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    float  re = 0;
    if( m_fpGvrApi_nativeGetBorderSizeMeters)
        re = m_fpGvrApi_nativeGetBorderSizeMeters( env, obj, paramLong);
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetSurfaceSize(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeSetSurfaceSize)
        m_fpGvrApi_nativeSetSurfaceSize( env, obj, paramLong, paramInt1, paramInt2);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetLensOffset(
        JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat1, jfloat paramFloat2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeSetLensOffset)
        m_fpGvrApi_nativeSetLensOffset( env, obj, paramLong, paramFloat1, paramFloat2);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUpdateSurfaceReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt1, jint paramInt2, jlong paramLong2, jfloatArray paramArrayOfFloat)
{
    CLogMessage msg(__FUNCTION__);
    assert(false);
    return;
}
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetAsyncReprojectionEnabled(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if( m_fpGvrApi_nativeGetAsyncReprojectionEnabled)
        re = m_fpGvrApi_nativeGetAsyncReprojectionEnabled( env, obj, paramLong);
    return re;
}

JNIEXPORT jboolean JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeIsFeatureSupported(
        JNIEnv* env, jobject obj, jlong paramLong, jint jvar )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if(m_fpGvrApi_nativeIsFeatureSupported)
        re = m_fpGvrApi_nativeIsFeatureSupported(env, obj, paramLong, jvar);
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeReconnectSensors(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeReconnectSensors)
        m_fpGvrApi_nativeReconnectSensors( env, obj, paramLong);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetIdleListener(
        JNIEnv* env, jobject obj, jlong paramLong, jobject jvar)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeSetIdleListener)
        m_fpGvrApi_nativeSetIdleListener(env, obj, paramLong, jvar);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDisplayMetrics(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1, jfloat paramFloat2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeSetDisplayMetrics)
        m_fpGvrApi_nativeSetDisplayMetrics( env, obj, paramLong, paramInt1, paramInt2, paramFloat1, paramFloat2);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeReset(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jlong paramLong3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpDisplaySynchronizer_nativeReset)
        m_fpDisplaySynchronizer_nativeReset( env, obj, paramLong1, paramLong2, paramLong3);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeUpdate(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpDisplaySynchronizer_nativeUpdate)
        m_fpDisplaySynchronizer_nativeUpdate(env, obj, paramLong1, paramLong2, paramInt);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_cardboard_ExternalSurfaceManager_nativeUpdateSurface(
        JNIEnv* env, jobject obj, jlong var0, jint var2, jint var3, jlong var4, jfloatArray var6)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpExternalSurfaceManager_nativeUpdateSurface)
        m_fpExternalSurfaceManager_nativeUpdateSurface(env, obj, var0, var2, var3, var4, var6);
    return;
}

//ClassLoader paramClassLoader, Context paramContext
JNIEXPORT long JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( m_fpDisplaySynchronizer_nativeCreate)
        re = m_fpDisplaySynchronizer_nativeCreate( env, obj, paramClassLoader, paramContext);
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpDisplaySynchronizer_nativeDestroy)
        m_fpDisplaySynchronizer_nativeDestroy( env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeDumpDebugData(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeDumpDebugData)
        m_fpGvrApi_nativeDumpDebugData( env, obj, paramLong );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeInitializeGl(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeInitializeGl)
        m_fpGvrApi_nativeInitializeGl(env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeOnSurfaceCreatedReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeOnSurfaceCreatedReprojectionThread)
        m_fpGvrApi_nativeOnSurfaceCreatedReprojectionThread(env, obj, paramLong);
//    if(m_fpon_surface_created_reprojection_thread)
//        m_fpon_surface_created_reprojection_thread(paramLong);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeOnSurfaceChangedReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramlong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeOnSurfaceChangedReprojectionThread)
        m_fpGvrApi_nativeOnSurfaceChangedReprojectionThread(env, obj, paramlong);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetRecommendedBufferViewports(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeGetRecommendedBufferViewports)
        m_fpGvrApi_nativeGetRecommendedBufferViewports( env, obj, paramLong1, paramLong2);
    return;
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetError(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( m_fpGvrApi_nativeGetError)
        re = m_fpGvrApi_nativeGetError( env, obj, paramLong);
    return re;
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeClearError(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( m_fpGvrApi_nativeClearError)
        re = m_fpGvrApi_nativeClearError(env, obj, paramLong );
    return re;
}
JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetUserPrefs(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( m_fpGvrApi_nativeGetUserPrefs)
        re = m_fpGvrApi_nativeGetUserPrefs(env, obj, paramLong );
    return re;
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUserPrefsGetControllerHandedness(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( m_fpGvrApi_nativeUserPrefsGetControllerHandedness)
        re = m_fpGvrApi_nativeUserPrefsGetControllerHandedness( env, obj, paramLong);
    return re;
}

JNIEXPORT jboolean JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUserPrefsGetPerformanceMonitoringEnabled(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jboolean re = false;
    assert(false);
    if(m_fpGvrApi_nativeUserPrefsGetPerformanceMonitoringEnabled)
        re = m_fpGvrApi_nativeUserPrefsGetPerformanceMonitoringEnabled(env, obj, paramLong);
    return re;
}

JNIEXPORT jboolean JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUserPrefsGetPerformanceHudEnabled(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jboolean re = false;
    assert(false);
    if(m_fpGvrApi_nativeUserPrefsGetPerformanceHudEnabled)
        re = m_fpGvrApi_nativeUserPrefsGetPerformanceHudEnabled(env, obj, paramLong);
    return re;
}

JNIEXPORT jlong JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetAnalytics(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    assert(false);
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativePause(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativePause)
        m_fpGvrApi_nativePause(env, obj, paramLong );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeResume(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeResume)
        m_fpGvrApi_nativeResume(env, obj, paramLong );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeReleaseGvrContext(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeReleaseGvrContext)
        m_fpGvrApi_nativeReleaseGvrContext( env, obj, paramLong );
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeBufferViewportDestroy)
        m_fpGvrApi_nativeBufferViewportDestroy( env, obj, paramLong);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetSourceUv(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramRectF)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeBufferViewportGetSourceUv)
        m_fpGvrApi_nativeBufferViewportGetSourceUv(env, obj, paramLong, paramRectF );
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceUv(
        JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeBufferViewportSetSourceUv)
        m_fpGvrApi_nativeBufferViewportSetSourceUv( env, obj, paramLong, paramFloat1, paramFloat2, paramFloat3, paramFloat4 );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetSourceFov(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramRectF)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeBufferViewportGetSourceFov)
        m_fpGvrApi_nativeBufferViewportGetSourceFov( env, obj, paramLong, paramRectF );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceFov(
        JNIEnv* env, jobject obj,  jlong paramLong, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4 )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeBufferViewportSetSourceFov)
        m_fpGvrApi_nativeBufferViewportSetSourceFov( env, obj, paramLong, paramFloat1, paramFloat2, paramFloat3, paramFloat4 );
    return;
}

// static native void nativeBufferViewportGetTransform(long paramLong, float[] paramArrayOfFloat);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetTransform(
        JNIEnv* env, jobject obj, jlong paramLong, jfloatArray paramArrayOffloat)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeBufferViewportGetTransform)
        m_fpGvrApi_nativeBufferViewportGetTransform( env, obj, paramLong, paramArrayOffloat);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetTransform(
        JNIEnv* env, jobject obj, jlong paramLong, jfloatArray paramArrayOfFloat)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeBufferViewportSetTransform)
        m_fpGvrApi_nativeBufferViewportSetTransform(env, obj, paramLong, paramArrayOfFloat );
    return;
}

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetTargetEye(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( m_fpGvrApi_nativeBufferViewportGetTargetEye)
        re = m_fpGvrApi_nativeBufferViewportGetTargetEye( env, obj, paramLong );
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetTargetEye(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeBufferViewportSetTargetEye)
        m_fpGvrApi_nativeBufferViewportSetTargetEye( env, obj, paramLong, paramInt );
    return;
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetSourceBufferIndex(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(m_fpGvrApi_nativeBufferViewportGetSourceBufferIndex)
        re = m_fpGvrApi_nativeBufferViewportGetSourceBufferIndex( env, obj, paramLong );
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceBufferIndex(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeBufferViewportSetSourceBufferIndex)
        m_fpGvrApi_nativeBufferViewportSetSourceBufferIndex( env, obj, paramLong, paramInt );
    return;
}

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetExternalSurfaceId(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( m_fpGvrApi_nativeBufferViewportGetExternalSurfaceId)
        re = m_fpGvrApi_nativeBufferViewportGetExternalSurfaceId( env, obj, paramLong );
    return re;
}

JNIEXPORT void JNICALL  Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetExternalSurfaceId(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeBufferViewportSetExternalSurfaceId)
        m_fpGvrApi_nativeBufferViewportSetExternalSurfaceId( env, obj, paramLong, paramInt );
    return;
}

JNIEXPORT void JNICALL  Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetExternalSurface(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeBufferViewportSetExternalSurface)
        m_fpGvrApi_nativeBufferViewportSetExternalSurface(env, obj, paramLong, paramInt );
}

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetReprojection(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( m_fpGvrApi_nativeBufferViewportGetReprojection)
        re = m_fpGvrApi_nativeBufferViewportGetReprojection( env, obj, paramLong );
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetReprojection(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeBufferViewportSetReprojection)
        m_fpGvrApi_nativeBufferViewportSetReprojection( env, obj, paramLong, paramInt );
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceLayer(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeBufferViewportSetSourceLayer)
        m_fpGvrApi_nativeBufferViewportSetSourceLayer(env, obj, paramLong, paramInt);
    return;
}

JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportEqual(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if( m_fpGvrApi_nativeBufferViewportEqual)
        re = m_fpGvrApi_nativeBufferViewportEqual( env, obj, paramLong1, paramLong2 );
    return re;
}

JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecCreate(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( m_fpGvrApi_nativeBufferSpecCreate)
        re = m_fpGvrApi_nativeBufferSpecCreate( env, obj, paramLong);
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeBufferSpecDestroy)
        m_fpGvrApi_nativeBufferSpecDestroy( env, obj, paramLong );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecGetSize(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeBufferSpecGetSize)
        m_fpGvrApi_nativeBufferSpecGetSize( env, obj, paramLong, paramPoint );
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetSize(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jint paramInt2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeBufferSpecSetSize)
        m_fpGvrApi_nativeBufferSpecSetSize( env, obj, paramLong, paramInt, paramInt2 );
    return;
}

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecGetSamples(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( m_fpGvrApi_nativeBufferSpecGetSamples)
        re = m_fpGvrApi_nativeBufferSpecGetSamples(env, obj, paramLong);
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetSamples(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeBufferSpecSetSamples)
        m_fpGvrApi_nativeBufferSpecSetSamples( env, obj, paramLong, paramInt );
    return;
}

JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceCreate(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    assert(false);
    if(m_fpGvrApi_nativeExternalSurfaceCreate)
        re = m_fpGvrApi_nativeExternalSurfaceCreate(env, obj, paramLong);
    return re;
}

JNIEXPORT jlong JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceCreateWithListeners(
        JNIEnv* env, jobject obj, jlong paramLong, jobject var2, jobject var3, jobject var4)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( m_fpGvrApi_nativeExternalSurfaceCreateWithListeners)
        re = m_fpGvrApi_nativeExternalSurfaceCreateWithListeners(env, obj, paramLong, var2, var3, var4);
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeExternalSurfaceDestroy)
        m_fpGvrApi_nativeExternalSurfaceDestroy(env, obj, paramLong);
    return;
}

JNIEXPORT jint JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceGetId(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jint re = 0;
    if( m_fpGvrApi_nativeExternalSurfaceGetId)
        re = m_fpGvrApi_nativeExternalSurfaceGetId(env, obj, paramLong);
    return re;
}

JNIEXPORT jobject JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceGetSurface(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jobject re = NULL;
    if(m_fpGvrApi_nativeExternalSurfaceGetSurface)
        re = m_fpGvrApi_nativeExternalSurfaceGetSurface(env, obj, paramLong);
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetColorFormat(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeBufferSpecSetColorFormat)
        m_fpGvrApi_nativeBufferSpecSetColorFormat( env, obj, paramLong, paramInt );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetDepthStencilFormat(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeBufferSpecSetDepthStencilFormat)
        m_fpGvrApi_nativeBufferSpecSetDepthStencilFormat(env, obj, paramLong, paramInt );
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetMultiviewLayers(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeBufferSpecSetMultiviewLayers)
        m_fpGvrApi_nativeBufferSpecSetMultiviewLayers(env, obj, paramLong, paramInt);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeSwapChainDestroy)
        m_fpGvrApi_nativeSwapChainDestroy(env, obj, paramLong );
    return;
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainGetBufferCount(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( m_fpGvrApi_nativeSwapChainGetBufferCount)
        re = m_fpGvrApi_nativeSwapChainGetBufferCount( env, obj, paramLong );
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainGetBufferSize(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jobject paramPoint)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeSwapChainGetBufferSize)
        m_fpGvrApi_nativeSwapChainGetBufferSize( env, obj, paramLong, paramInt, paramPoint );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainResizeBuffer(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jint paramInt3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeSwapChainResizeBuffer)
        m_fpGvrApi_nativeSwapChainResizeBuffer( env, obj, paramLong, paramInt1, paramInt2, paramInt3 );
    return;
}
JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainAcquireFrame(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( m_fpGvrApi_nativeSwapChainAcquireFrame)
        re = m_fpGvrApi_nativeSwapChainAcquireFrame( env, obj, paramLong );
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameBindBuffer(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeFrameBindBuffer)
        m_fpGvrApi_nativeFrameBindBuffer( env, obj, paramLong, paramInt );
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameUnbind(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeFrameUnbind)
        m_fpGvrApi_nativeFrameUnbind( env, obj, paramLong );
    return;
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameGetFramebufferObject(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( m_fpGvrApi_nativeFrameGetFramebufferObject)
        re = m_fpGvrApi_nativeFrameGetFramebufferObject( env, obj, paramLong, paramInt );
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameGetBufferSize(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jobject paramPoint)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeFrameGetBufferSize)
        m_fpGvrApi_nativeFrameGetBufferSize( env, obj, paramLong, paramInt, paramPoint);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameSubmit(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloatArray paramArrayOfFloat)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeFrameSubmit)
        m_fpGvrApi_nativeFrameSubmit( env, obj, paramLong1, paramLong2, paramArrayOfFloat);
    return;
}

JNIEXPORT jboolean JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUsingDynamicLibrary(JNIEnv* env, jobject obj)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jboolean re = false;
    if(m_fpGvrApi_nativeUsingDynamicLibrary)
        re = m_fpGvrApi_nativeUsingDynamicLibrary(env, obj);
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetApplicationState(
        JNIEnv* env, jobject obj, jobject jclassloader, jobject jcontext)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeSetApplicationState)
        m_fpGvrApi_nativeSetApplicationState(env, obj, jclassloader, jcontext);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDynamicLibraryLoadingEnabled(
        JNIEnv* env, jobject obj, jboolean jvar)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeSetDynamicLibraryLoadingEnabled)
        m_fpGvrApi_nativeSetDynamicLibraryLoadingEnabled(env, obj, jvar);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeResumeTracking(
        JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpGvrApi_nativeResumeTracking)
        m_fpGvrApi_nativeResumeTracking( env, obj, paramLong, paramArrayOfByte );
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeResumeTrackingSetState(
        JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeResumeTrackingSetState)
        m_fpGvrApi_nativeResumeTrackingSetState(env, obj, paramLong, paramArrayOfByte);
    return;
}

JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDefaultViewerProfile(
        JNIEnv* env, jobject obj, jlong paramLong, jstring paramString)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if( m_fpGvrApi_nativeSetDefaultViewerProfile)
        re = m_fpGvrApi_nativeSetDefaultViewerProfile( env, obj, paramLong, paramString );
    return re;
}
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetViewerParams(
        JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if( m_fpGvrApi_nativeSetViewerParams)
        re = m_fpGvrApi_nativeSetViewerParams( env, obj, paramLong, paramArrayOfByte );
    return re;
}
JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainCreate(
        JNIEnv* env, jobject obj, jlong paramLong, jlongArray paramArrayOfLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( m_fpGvrApi_nativeSwapChainCreate)
        re = m_fpGvrApi_nativeSwapChainCreate( env, obj, paramLong, paramArrayOfLong );
    return re;
}


JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeCreate(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext, jlong paramLong, jint paramInt1,
        jint paramInt2, jfloat paramFloat1, jfloat paramFloat2, jobject paramPoseTracker)
{
//    LOGE("Java_com_google_vr_ndk_base_GvrApi_nativeCreate");
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    void * pdata = 0;
    if( m_fpGvrApi_nativeCreate)
        re = m_fpGvrApi_nativeCreate( env, obj, paramClassLoader, paramContext, paramLong, paramInt1, paramInt2, paramFloat1, paramFloat2, paramPoseTracker);
//    pdata = (void*)re;
//    FILE *pfile = fopen("/sdcard/mem.txt", "wb");
//    fwrite(pdata, 600, 1, pfile);
//    fflush(pfile);
//    fclose(pfile);
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeRequestContextSharing(
        JNIEnv* env, jobject obj, jlong paramlong, jobject jvar)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpGvrApi_nativeRequestContextSharing)
        m_fpGvrApi_nativeRequestContextSharing(env, obj, paramlong, jvar);
    return;
}

JNIEXPORT jfloatArray JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeComputeDistortedPoint(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jfloatArray paramArrayOfFloat)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jfloatArray re = 0;
    if( m_fpGvrApi_nativeComputeDistortedPoint)
        re = m_fpGvrApi_nativeComputeDistortedPoint( env, obj, paramLong, paramInt, paramArrayOfFloat );
    return re;
}

JNIEXPORT jstring JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetErrorString(
        JNIEnv* env, jobject obj, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jstring re = 0;
    if( m_fpGvrApi_nativeGetErrorString)
        re = m_fpGvrApi_nativeGetErrorString( env,obj, paramInt );
    return re;
}

JNIEXPORT jstring JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetViewerVendor(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jstring  re = 0;
    if( m_fpGvrApi_nativeGetViewerVendor)
        re = m_fpGvrApi_nativeGetViewerVendor(env, obj, paramLong);
    return re;
}

JNIEXPORT jstring JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetViewerModel(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jstring  re = 0;
    if( m_fpGvrApi_nativeGetViewerModel)
        re = m_fpGvrApi_nativeGetViewerModel(env, obj, paramLong);
    return re;
}

JNIEXPORT jbyteArray JNICALL Java_com_google_vr_ndk_base_GvrApi_nativePauseTracking(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jbyteArray re = 0;
    if( m_fpGvrApi_nativePauseTracking)
        re = m_fpGvrApi_nativePauseTracking( env, obj, paramLong);
    return re;
}

JNIEXPORT jbyteArray JNICALL Java_com_google_vr_ndk_base_GvrApi_nativePauseTrackingGetState(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jbyteArray re = 0;
    if(m_fpGvrApi_nativePauseTrackingGetState)
        re = m_fpGvrApi_nativePauseTrackingGetState(env, obj, paramLong);
    return re;
}

JNIEXPORT jintArray JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetWindowBounds(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jintArray re = 0;
    if( m_fpGvrApi_nativeGetWindowBounds)
        re = m_fpGvrApi_nativeGetWindowBounds(env, obj, paramLong );
    return re;
}

jint mj_JNI_OnLoad(JavaVM* vm, void* reserved)
{
    InitLoadFun();
    if(m_fpJNI_OnLoad)
        return m_fpJNI_OnLoad(vm, reserved);
    return JNI_VERSION_1_6;
}

void gvr_buffer_viewport_list_destroy(gvr_buffer_viewport_list **viewport_list)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpbuffer_viewport_list_destroy)
        m_fpbuffer_viewport_list_destroy( viewport_list);
    return;
}

void gvr_swap_chain_destroy(gvr_swap_chain **swap_chain)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpswap_chain_destroy)
        m_fpswap_chain_destroy( swap_chain);
    return;
}

void gvr_destroy(gvr_context **gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpdestroy)
        m_fpdestroy( gvr);
    return;
}

void gvr_buffer_viewport_destroy(gvr_buffer_viewport **viewport)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_viewport_destroy)
        m_fpbuffer_viewport_destroy(viewport);
    return;
}

gvr_swap_chain * gvr_swap_chain_create(gvr_context *gvr, const gvr_buffer_spec **buffers, int32_t count)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_swap_chain *re = NULL;
    if( m_fpswap_chain_create)
        re = m_fpswap_chain_create( gvr, buffers, count );
    return re;
}

void gvr_bind_default_framebuffer(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
//    getimagebase();
    InitLoadFun();
    if( m_fpbind_default_framebuffer)
        m_fpbind_default_framebuffer(gvr);
    return;
}

gvr_sizei gvr_get_maximum_effective_render_target_size(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_sizei re;
    if( m_fpget_maximum_effective_render_target_size)
        re = m_fpget_maximum_effective_render_target_size( gvr);
    return re;
}

void gvr_buffer_spec_set_samples(gvr_buffer_spec *spec, int32_t num_samples)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_spec_set_samples)
        m_fpbuffer_spec_set_samples(spec, num_samples );
    return;
}

void gvr_buffer_spec_set_depth_stencil_format(gvr_buffer_spec *spec, int32_t depth_stencil_format)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpbuffer_spec_set_depth_stencil_format)
        m_fpbuffer_spec_set_depth_stencil_format(spec, depth_stencil_format);
    return;
}

void gvr_buffer_spec_set_multiview_layers(gvr_buffer_spec* spec, int32_t num_layers)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_spec_set_multiview_layer)
        m_fpbuffer_spec_set_multiview_layer(spec, num_layers);
    return;
}

void gvr_buffer_spec_set_size(gvr_buffer_spec *spec, gvr_sizei size)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_spec_set_size)
        m_fpbuffer_spec_set_size( spec, size);
    return;
}

gvr_buffer_spec * gvr_buffer_spec_create(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_buffer_spec *re = NULL;
    if(m_fpbuffer_spec_create)
        re = m_fpbuffer_spec_create( gvr );
    return re;
}

void gvr_initialize_gl(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpinitialize_gl)
        m_fpinitialize_gl( gvr);
    return;
}

void gvr_distort_to_screen(
        gvr_context *gvr,
        int32_t texture_id,
        const gvr_buffer_viewport_list *viewport_list,
        gvr_mat4f head_space_from_start_space,
        gvr_clock_time_point target_presentation_time)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpdistort_to_screen)
        m_fpdistort_to_screen( gvr, texture_id, viewport_list, head_space_from_start_space, target_presentation_time);
    return;
}

bool gvr_is_feature_supported(const gvr_context* gvr, int32_t feature)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if(m_fpis_feature_supported)
        re = m_fpis_feature_supported(gvr, feature);
    return re;
}

gvr_clock_time_point gvr_get_time_point_now()
{
//    gvr_clock_time_point re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_clock_time_point re;
    if(m_fpget_time_point_now)
        re = m_fpget_time_point_now( );
    return re;
}


void gvr_buffer_spec_destroy(gvr_buffer_spec **spec)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_spec_destroy)
        m_fpbuffer_spec_destroy( spec);
    return;
}

gvr_mat4f gvr_get_eye_from_head_matrix(const gvr_context *gvr, const int32_t eye)
{
//    gvr_mat4f re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_mat4f re;
    if(m_fpget_eye_from_head_matrix)
        re = m_fpget_eye_from_head_matrix( gvr, eye);
    return re;
}

gvr_sizei gvr_swap_chain_get_buffer_size(gvr_swap_chain *swap_chain, int32_t index)
{
//    gvr_sizei re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_sizei re;
    if( m_fpswap_chain_get_buffer_size)
        re = m_fpswap_chain_get_buffer_size( swap_chain, index);
    return re;
}

void gvr_compute_distorted_point(
        const gvr_context *gvr,
        const int32_t eye,
        const gvr_vec2f uv_in,
        gvr_vec2f uv_out[3])
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpcompute_distorted_point)
        m_fpcompute_distorted_point( gvr, eye, uv_in, uv_out);
    return;
}

void gvr_get_recommended_buffer_viewports(const gvr_context *gvr, gvr_buffer_viewport_list *viewport_list)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpget_recommended_buffer_viewports)
        m_fpget_recommended_buffer_viewports( gvr, viewport_list);
    return;
}

bool gvr_buffer_viewport_equal(const gvr_buffer_viewport *a, const gvr_buffer_viewport *b)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if(m_fpbuffer_viewport_equal)
        re = m_fpbuffer_viewport_equal( a, b);
    return re;
}

void gvr_buffer_viewport_list_get_item(const gvr_buffer_viewport_list *viewport_list, size_t index, gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_viewport_list_get_item)
        m_fpbuffer_viewport_list_get_item( viewport_list, index, viewport );
    return;
}

gvr_sizei gvr_buffer_spec_get_size(const gvr_buffer_spec *spec)
{
//    gvr_sizei re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_sizei re;
    if(m_fpbuffer_spec_get_size)
        re = m_fpbuffer_spec_get_size( spec);
    return re;
}

int32_t gvr_buffer_viewport_get_target_eye(const gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int32_t re = 0;
    if(m_fpbuffer_viewport_get_target_eye)
        re = m_fpbuffer_viewport_get_target_eye( viewport);
    return re;
}

int32_t gvr_buffer_spec_get_samples(const gvr_buffer_spec *spec)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int32_t re = 0;
    if(m_fpbuffer_spec_get_samples)
        re = m_fpbuffer_spec_get_samples( spec );
    return re;
}

gvr_rectf gvr_buffer_viewport_get_source_fov(const gvr_buffer_viewport *viewport)
{
//    gvr_rectf re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_rectf re;
    if(m_fpbuffer_viewport_get_source_fov)
        re = m_fpbuffer_viewport_get_source_fov(viewport);
    return re;
}

int32_t gvr_swap_chain_get_buffer_count(const gvr_swap_chain *swap_chain)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int32_t re = 0;
    if( m_fpswap_chain_get_buffer_count)
        re = m_fpswap_chain_get_buffer_count( swap_chain);
    return re;
}

int32_t gvr_buffer_viewport_get_reprojection(const gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int32_t re = 0;
    if(m_fpbuffer_viewport_get_reprojection)
        re = m_fpbuffer_viewport_get_reprojection( viewport);
    return re;
}

void gvr_buffer_viewport_set_reprojection(gvr_buffer_viewport *viewport, int32_t reprojection)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_viewport_set_reprojection)
        m_fpbuffer_viewport_set_reprojection( viewport, reprojection );
    return;
}

void gvr_buffer_viewport_set_source_layer(gvr_buffer_viewport* viewport, int32_t layer_index)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_viewport_set_source_layer)
        m_fpbuffer_viewport_set_source_layer(viewport, layer_index);
    return;
}

void gvr_buffer_viewport_set_source_uv(gvr_buffer_viewport *viewport, gvr_rectf uv)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_viewport_set_source_uv)
        m_fpbuffer_viewport_set_source_uv( viewport, uv);
    return;
}

void gvr_buffer_viewport_list_set_item(
        gvr_buffer_viewport_list *viewport_list,
        size_t index,
        const gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_viewport_list_set_item)
        m_fpbuffer_viewport_list_set_item( viewport_list, index, viewport );
    return;
}

int32_t gvr_user_prefs_get_controller_handedness(const gvr_user_prefs *user_prefs)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int32_t re = 0;
    if( m_fpuser_prefs_get_controller_handedness)
        re = m_fpuser_prefs_get_controller_handedness( user_prefs);
    return re;
}

void gvr_get_screen_buffer_viewports(const gvr_context *gvr, gvr_buffer_viewport_list *viewport_list)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpget_screen_buffer_viewports)
        m_fpget_screen_buffer_viewports( gvr, viewport_list);
    return;
}

gvr_sizei gvr_get_screen_target_size(const gvr_context *gvr)
{
//    gvr_sizei re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_sizei re;
    if(m_fpget_screen_target_size)
        re = m_fpget_screen_target_size( gvr);
    return re;
}

gvr_rectf gvr_buffer_viewport_get_source_uv(const gvr_buffer_viewport *viewport)
{
//    gvr_rectf re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_rectf re;
    if(m_fpbuffer_viewport_get_source_uv)
        re = m_fpbuffer_viewport_get_source_uv( viewport);
    return re;
}

gvr_recti gvr_get_window_bounds(const gvr_context *gvr)
{
//    gvr_recti re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_recti re;
    if(m_fpget_window_bounds)
        re = m_fpget_window_bounds( gvr);
    return re;
}

gvr_mat4f gvr_get_head_space_from_start_space_rotation(const gvr_context *gvr, const gvr_clock_time_point time)
{
//    gvr_mat4f re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_mat4f re;
    if(m_fpget_head_space_from_start_space_rotation)
        re = m_fpget_head_space_from_start_space_rotation( gvr, time);
    return re;
}

gvr_mat4f gvr_apply_neck_model(const gvr_context *gvr, gvr_mat4f head_space_from_start_space_rotation, float factor)
{
//    gvr_mat4f re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_mat4f re;
    if(m_fpapply_neck_model)
        re = m_fpapply_neck_model( gvr, head_space_from_start_space_rotation, factor);
    return re;
}

gvr_frame * gvr_swap_chain_acquire_frame(gvr_swap_chain *swap_chain)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_frame *pframe = NULL;
    if(m_fpswap_chain_acquire_frame)
        pframe = m_fpswap_chain_acquire_frame( swap_chain);
    LOGE("gvr_swap_chain_acquire_frame gvr_frame:%p", pframe);
    return pframe;
}

gvr_context * gvr_create(JNIEnv *env, jobject app_context, jobject class_loader)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_context *re = NULL;
    if(m_fpcreate)
        re = m_fpcreate(env, app_context, class_loader );
    return re;
}

void gvr_frame_bind_buffer(gvr_frame *frame, int32_t index)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpframe_bind_buffer)
        m_fpframe_bind_buffer(frame, index);
    return;
}

void gvr_frame_unbind(gvr_frame *frame)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpframe_unbind)
        m_fpframe_unbind(frame);
    return;
}

gvr_gesture_context* gvr_gesture_context_create()
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpgesture_context_create)
        return m_fpgesture_context_create();
    else
        return NULL;
}

void gvr_gesture_context_destroy(gvr_gesture_context** context)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpgesture_context_destroy)
        m_fpgesture_context_destroy(context);
    return;
}

const gvr_gesture* gvr_gesture_get(const gvr_gesture_context* context, int index)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpgesture_get)
        return m_fpgesture_get(context, index);
    else
        return NULL;
}

int gvr_gesture_get_count(const gvr_gesture_context* context)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpgesture_get_count)
        return m_fpgesture_get_count(context);
    return 0;
}

gvr_gesture_direction gvr_gesture_get_direction(const gvr_gesture* gesture)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpgesture_get_direction)
        return m_fpgesture_get_direction(gesture);
    return GVR_GESTURE_DIRECTION_UP;
}

gvr_vec2f gvr_gesture_get_displacement(const gvr_gesture* gesture)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_vec2f re;
    if(m_fpgesture_get_displacement)
        re = m_fpgesture_get_displacement(gesture);
    return re;
}

gvr_gesture_type gvr_gesture_get_type(const gvr_gesture* gesture)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_gesture_type re = GVR_GESTURE_SWIPE;
    if(m_fpgesture_get_type)
        re = m_fpgesture_get_type(gesture);
    return  re;
}

gvr_vec2f gvr_gesture_get_velocity(const gvr_gesture* gesture)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_vec2f re;
    if(m_fpgesture_get_velocity)
        re = m_fpgesture_get_velocity(gesture);
    return re;
}

void gvr_gesture_restart(gvr_gesture_context* context)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpgesture_restart)
        m_fpgesture_restart(context);
    return;
}

void gvr_gesture_update(const gvr_controller_state* controller_state, gvr_gesture_context* context)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpgesture_update)
        m_fpgesture_update(controller_state, context);
    return;
}

void gvr_frame_submit(gvr_frame **frame, const gvr_buffer_viewport_list *list, gvr_mat4f head_space_from_start_space)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpframe_submit)
        m_fpframe_submit(frame, list, head_space_from_start_space );
    return;
}

void gvr_swap_chain_resize_buffer(gvr_swap_chain *swap_chain, int32_t index, gvr_sizei size)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpswap_chain_resize_buffer)
        m_fpswap_chain_resize_buffer( swap_chain, index, size);
    return;
}

gvr_buffer_viewport_list * gvr_buffer_viewport_list_create(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_buffer_viewport_list *re = NULL;
    if( m_fpbuffer_viewport_list_create)
        re = m_fpbuffer_viewport_list_create( gvr);
    return re;
}

const gvr_user_prefs * gvr_get_user_prefs(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpget_user_prefs)
        return m_fpget_user_prefs( gvr);
    else
        return NULL;
}

gvr_buffer_viewport * gvr_buffer_viewport_create(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_viewport_create)
        return m_fpbuffer_viewport_create( gvr);
    else
        return NULL;
}

gvr_version gvr_get_version()
{
//    gvr_version re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_version re;
    if(m_fpget_version)
        re = m_fpget_version();
    return re;
}

const char * gvr_get_viewer_vendor(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpget_viewer_vendor)
        return m_fpget_viewer_vendor( gvr);
    else
        return NULL;
}

const char * gvr_get_version_string()
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpget_version_string)
        return m_fpget_version_string();
    else
        return NULL;
}

const char * gvr_get_viewer_model(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpget_viewer_model)
        return m_fpget_viewer_model( gvr);
    else
        return NULL;
}

int32_t gvr_get_error(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpget_error)
        return m_fpget_error(gvr);
    else
        return 0;
}

int32_t gvr_get_viewer_type(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpget_viewer_type)
        return m_fpget_viewer_type( gvr);
    else
        return 0;
}

int32_t gvr_clear_error(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpclear_error)
        return m_fpclear_error( gvr);
    else
        return 0;
}

const char * gvr_get_error_string(int32_t error_code)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpget_error_string)
        return m_fpget_error_string( error_code );
    else
        return NULL;
}

int32_t gvr_buffer_viewport_get_source_buffer_index(const gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpbuffer_viewport_get_source_buffer_index)
        return m_fpbuffer_viewport_get_source_buffer_index( viewport);
    else
        return 0;
}

bool gvr_get_async_reprojection_enabled(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpget_async_reprojection_enabled)
        return m_fpget_async_reprojection_enabled( gvr);
    return false;
}

void gvr_buffer_viewport_set_source_buffer_index(gvr_buffer_viewport *viewport, int32_t buffer_index)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_viewport_set_source_buffer_index)
        m_fpbuffer_viewport_set_source_buffer_index(viewport, buffer_index);
    return;
}

size_t gvr_buffer_viewport_list_get_size(const gvr_buffer_viewport_list *viewport_list)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_viewport_list_get_size)
        return m_fpbuffer_viewport_list_get_size(viewport_list);
    return 0;
}

int32_t gvr_buffer_viewport_get_external_surface_id(const gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_viewport_get_external_surface_id)
        return m_fpbuffer_viewport_get_external_surface_id( viewport);
    return 0;
}

void gvr_buffer_viewport_set_external_surface_id(gvr_buffer_viewport *viewport, int32_t external_surface_id)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_viewport_set_external_surface_id)
        m_fpbuffer_viewport_set_external_surface_id( viewport, external_surface_id );
    return;
}

void gvr_set_surface_size(gvr_context *gvr, gvr_sizei surface_size_pixels)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpset_surface_size)
        m_fpset_surface_size( gvr, surface_size_pixels);
    return;
}

gvr_mat4f gvr_buffer_viewport_get_transform(const gvr_buffer_viewport *viewport)
{
//    gvr_mat4f re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_mat4f re;
    if(m_fpbuffer_viewport_get_transform)
        re = m_fpbuffer_viewport_get_transform( viewport);
    return re;
}

void gvr_buffer_spec_set_color_format(gvr_buffer_spec *spec, int32_t color_format)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_spec_set_color_format)
        m_fpbuffer_spec_set_color_format( spec, color_format);
    return;
}

void gvr_buffer_viewport_set_transform(gvr_buffer_viewport *viewport, gvr_mat4f transform)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_viewport_set_transform)
        m_fpbuffer_viewport_set_transform( viewport, transform);
    return;
}

void gvr_buffer_viewport_set_target_eye(gvr_buffer_viewport *viewport, int32_t index)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_viewport_set_target_eye)
        m_fpbuffer_viewport_set_target_eye(viewport, index);
    return;
}

gvr_sizei gvr_frame_get_buffer_size(const gvr_frame *frame, int32_t index)
{
//    gvr_sizei re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_sizei re;
    if(m_fpframe_get_buffer_size)
        re = m_fpframe_get_buffer_size(frame, index);
    return re;
}

int32_t gvr_frame_get_framebuffer_object(const gvr_frame *frame, int32_t index)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpframe_get_framebuffer_object)
        return m_fpframe_get_framebuffer_object(frame, index);
    return 0;
}

void gvr_pause_tracking(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fppause_tracking)
        m_fppause_tracking( gvr);
    return;
}

void gvr_buffer_viewport_set_source_fov(gvr_buffer_viewport *viewport, gvr_rectf fov)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpbuffer_viewport_set_source_fov)
        m_fpbuffer_viewport_set_source_fov( viewport, fov);
    return;
}

void gvr_resume_tracking(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpresume_tracking)
        m_fpresume_tracking(gvr);
    return;
}

void gvr_reset_tracking(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpreset_tracking)
        m_fpreset_tracking(gvr);
    return;
}

void gvr_recenter_tracking(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fprecenter_tracking)
        m_fprecenter_tracking( gvr);
    return;
}

bool gvr_set_default_viewer_profile(gvr_context *gvr, const char *viewer_profile_uri)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpset_default_viewer_profile)
        return m_fpset_default_viewer_profile( gvr, viewer_profile_uri );
    return false;
}

void gvr_refresh_viewer_profile(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fprefresh_viewer_profile)
        m_fprefresh_viewer_profile( gvr);
    return;
}


gvr_controller_context * gvr_controller_create_and_init(int32_t options,gvr_context *context)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_create_and_init)
        return m_fpcontroller_create_and_init( options, context);
    return NULL;
}

gvr_controller_context * gvr_controller_create_and_init_android(
        JNIEnv *env,
        jobject android_context,
        jobject class_loader,
        int32_t options,
        gvr_context *context)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpcontroller_create_and_init_android)
        return m_fpcontroller_create_and_init_android( env, android_context, class_loader, options, context );
    return NULL;
}

void gvr_controller_destroy(gvr_controller_context **api)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_destroy)
        m_fpcontroller_destroy(api);
    return;
}

void gvr_controller_pause(gvr_controller_context *api)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_pause)
        m_fpcontroller_pause( api);
    return;
}

void gvr_controller_resume( gvr_controller_context *api)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpcontroller_resume)
        m_fpcontroller_resume(api);
    return;
}

const char * gvr_controller_api_status_to_string(  int32_t status)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_api_status_to_string)
        return m_fpcontroller_api_status_to_string(status);
    return NULL;
}

const char* gvr_controller_battery_level_to_string(int32_t level)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_battery_level_to_string)
        return m_fpcontroller_battery_level_to_string(level);
    return NULL;
}

const char * gvr_controller_connection_state_to_string(int32_t state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_connection_state_to_string)
        return m_fpcontroller_connection_state_to_string(state);
    return nullptr;
}

const char * gvr_controller_button_to_string(int32_t button)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_button_to_string)
        return m_fpcontroller_button_to_string( button);
    return nullptr;
}

gvr_controller_state * gvr_controller_state_create()
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_state_create)
        return m_fpcontroller_state_create();
    return nullptr;
}

void gvr_controller_state_destroy(gvr_controller_state **state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_state_destroy)
        m_fpcontroller_state_destroy( state);
    return;
}

void gvr_controller_state_update(gvr_controller_context *api, int32_t flags, gvr_controller_state *out_state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_state_update)
        m_fpcontroller_state_update(api, flags, out_state);
    return;
}

int32_t gvr_controller_state_get_api_status(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_state_get_api_status)
        return m_fpcontroller_state_get_api_status( state);
    return 0;
}

int32_t gvr_controller_state_get_connection_state(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpcontroller_state_get_connection_state)
        return m_fpcontroller_state_get_connection_state( state);
    return 0;
}

gvr_quatf gvr_controller_state_get_orientation(const gvr_controller_state *state)
{
//    gvr_quatf re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_quatf re;
    if( m_fpcontroller_state_get_orientation)
        re = m_fpcontroller_state_get_orientation(state);
    return re;
}

gvr_vec3f gvr_controller_state_get_gyro(const gvr_controller_state *state)
{
//    gvr_vec3f re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_vec3f re;
    if(m_fpcontroller_state_get_gyro)
        re = m_fpcontroller_state_get_gyro( state);
    return re;
}

gvr_vec3f gvr_controller_state_get_accel(const gvr_controller_state *state)
{
//    gvr_vec3f re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_vec3f re;
    if(m_fpcontroller_state_get_accel)
        re = m_fpcontroller_state_get_accel(state);
    return re;
}

bool gvr_controller_state_get_battery_charging(const gvr_controller_state* state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if(m_fpcontroller_state_get_battery_charging)
        re = m_fpcontroller_state_get_battery_charging(state);
    return re;
}

int32_t gvr_controller_state_get_battery_level(const gvr_controller_state* state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int32_t re = 0;
    if(m_fpcontroller_state_get_battery_level)
        re = m_fpcontroller_state_get_battery_level(state);
    return re;
}

bool gvr_controller_state_is_touching(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_state_is_touching)
        return m_fpcontroller_state_is_touching(state);
    return false;
}

gvr_vec2f gvr_controller_state_get_touch_pos(const gvr_controller_state *state)
{
//    gvr_vec2f re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_vec2f re;
    if( m_fpcontroller_state_get_touch_pos)
        re = m_fpcontroller_state_get_touch_pos(state);
    return re;
}

bool gvr_controller_state_get_touch_down(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_state_get_touch_down)
        return m_fpcontroller_state_get_touch_down(state);
    return false;
}

bool gvr_controller_state_get_touch_up(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_state_get_touch_up)
        return m_fpcontroller_state_get_touch_up(state);
    return false;
}

bool gvr_controller_state_get_recentered(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpcontroller_state_get_recentered)
        return m_fpcontroller_state_get_recentered(state);
    return false;
}

bool gvr_controller_state_get_recentering(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_state_get_recentering)
        return m_fpcontroller_state_get_recentering( state);
    return false;
}

bool gvr_controller_state_get_button_state(const gvr_controller_state *state, int32_t button)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpcontroller_state_get_button_state)
        return m_fpcontroller_state_get_button_state( state, button);
    return false;
}

bool gvr_controller_state_get_button_down(const gvr_controller_state *state, int32_t button)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpcontroller_state_get_button_down)
        return m_fpcontroller_state_get_button_down(state, button);
    return false;
}

bool gvr_controller_state_get_button_up(const gvr_controller_state *state, int32_t button)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_state_get_button_up)
        return m_fpcontroller_state_get_button_up( state, button);
    return false;
}

int64_t gvr_controller_state_get_last_orientation_timestamp(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_state_get_last_orientation_timestamp)
        return m_fpcontroller_state_get_last_orientation_timestamp(state);
    return 0;
}

int64_t gvr_controller_state_get_last_battery_timestamp(const gvr_controller_state* state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int64_t re = 0;
    if(m_fpcontroller_state_get_last_battery_timestamp)
        re = m_fpcontroller_state_get_last_battery_timestamp(state);
    return re;
}

int64_t gvr_controller_state_get_last_gyro_timestamp(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_state_get_last_gyro_timestamp)
        return m_fpcontroller_state_get_last_gyro_timestamp(state);
    return 0;
}

int64_t gvr_controller_state_get_last_accel_timestamp(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_state_get_last_accel_timestamp)
        return m_fpcontroller_state_get_last_accel_timestamp(state);
    return 0;
}

int64_t gvr_controller_state_get_last_touch_timestamp(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_state_get_last_touch_timestamp)
        return m_fpcontroller_state_get_last_touch_timestamp( state);
    return 0;
}

int64_t gvr_controller_state_get_last_button_timestamp(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_state_get_last_button_timestamp)
        return m_fpcontroller_state_get_last_button_timestamp(state);
    return 0;
}

int32_t gvr_controller_get_default_options()
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcontroller_get_default_options)
        return m_fpcontroller_get_default_options();
    return 0;
}

/////////////////////////
/////////////////////
int gvr_set_viewer_params(int *a1, const void *a2, size_t a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( m_fpset_viewer_params)
        re = m_fpset_viewer_params( a1, a2, a3);
    return re;
}
int gvr_set_display_metrics( int *a1, int a2, int a3, int a4, int a5, int a6)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(m_fpset_display_metrics)
        re = m_fpset_display_metrics( a1, a2, a3, a4, a5, a6);
    return re;
}
int gvr_set_back_gesture_event_handler(int a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpset_back_gesture_event_handler)
        return m_fpset_back_gesture_event_handler( a1, a2, a3);
    else
        return 0;
}
int gvr_display_synchronizer_create()
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpdisplay_synchronizer_create)
        return m_fpdisplay_synchronizer_create();
    return 0;
}

int gvr_display_synchronizer_destroy(int *a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpdisplay_synchronizer_destroy)
        return m_fpdisplay_synchronizer_destroy(a1);
    return 0;
}

int gvr_get_border_size_meters(void *a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpget_border_size_meters)
        return m_fpget_border_size_meters( a1);
    return 0;
}

bool gvr_get_button_long_press(const gvr_controller_state* controller_state, const gvr_gesture_context* context, gvr_controller_button button)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if(m_fpget_button_long_press)
        re = m_fpget_button_long_press(controller_state, context, button);
    return re;
}

int gvr_check_surface_size_changed(int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcheck_surface_size_changed)
        return m_fpcheck_surface_size_changed( a1);
    return 0;
}

int gvr_get_surface_size(int a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpget_surface_size)
        return m_fpget_surface_size( a1, a2, a3);
    return 0;
}

int gvr_set_display_output_rotation(void *a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpset_display_output_rotation)
        return m_fpset_display_output_rotation( a1, a2);
    return 0;
}

int gvr_reconnect_sensors( void *a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpreconnect_sensors)
        return m_fpreconnect_sensors(a1);
    return 0;
}

int gvr_set_lens_offset(int *a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpset_lens_offset)
        return m_fpset_lens_offset( a1, a2, a3);
    return 0;
}

int gvr_resume(int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpresume)
        return m_fpresume(a1);
    return 0;
}

int gvr_dump_debug_data(void *a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpdump_debug_data)
        return m_fpdump_debug_data( a1);
    return 0;
}


int gvr_external_surface_create_with_listeners(int a1, int a2, int a3, int a4)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(m_fpexternal_surface_create_with_listeners)
        re = m_fpexternal_surface_create_with_listeners(a1, a2, a3, a4);
    return re;
}

int gvr_external_surface_destroy(void **a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(m_fpexternal_surface_destroy)
        re = m_fpexternal_surface_destroy(a1, a2, a3);
    return re;
}

int gvr_external_surface_get_surface(int a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(m_fpexternal_surface_get_surface)
        re = m_fpexternal_surface_get_surface(a1, a2, a3);
    return re;
}

int gvr_external_surface_get_surface_id(int *a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(m_fpexternal_surface_get_surface_id)
        re = m_fpexternal_surface_get_surface_id(a1, a2, a3);
    return re;
}

bool gvr_using_dynamic_library(int a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if(m_fpusing_dynamic_library)
        re = m_fpusing_dynamic_library(a1, a2, a3);
    return re;
}

int gvr_using_vr_display_service( int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpusing_vr_display_service)
        return m_fpusing_vr_display_service(a1);
    return 0;
}

int gvr_tracker_state_get_buffer_size(int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fptracker_state_get_buffer_size)
        return m_fptracker_state_get_buffer_size(a1);
    return 0;
}

int gvr_tracker_state_get_buffer(int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fptracker_state_get_buffer)
        return m_fptracker_state_get_buffer(a1);
    return 0;
}

int gvr_pause(int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fppause)
        return m_fppause(a1);
    return 0;
}

int gvr_set_ignore_manual_tracker_pause_resume(void *a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpset_ignore_manual_tracker_pause_resume)
        return m_fpset_ignore_manual_tracker_pause_resume(a1, a2);
    return 0;
}

int gvr_display_synchronizer_update(int *a1, int a2, int64_t a3, int a4)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpdisplay_synchronizer_update)
        return m_fpdisplay_synchronizer_update(a1, a2, a3, a4);
    return 0;
}

int gvr_remove_all_surfaces_reprojection_thread(void *a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpremove_all_surfaces_reprojection_thread)
        return m_fpremove_all_surfaces_reprojection_thread( a1);
    return 0;
}

int gvr_set_async_reprojection_enabled(int a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpset_async_reprojection_enabled)
        return m_fpset_async_reprojection_enabled(a1, a2);
    return 0;
}

int gvr_on_surface_created_reprojection_thread( int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpon_surface_created_reprojection_thread)
        return m_fpon_surface_created_reprojection_thread(a1);
    return 0;
}

int gvr_render_reprojection_thread(int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fprender_reprojection_thread)
        return m_fprender_reprojection_thread( a1);
    return 0;
}

int gvr_tracker_state_destroy( int *a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fptracker_state_destroy)
        return m_fptracker_state_destroy( a1);
    return 0;
}

int gvr_resume_tracking_set_state(int a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpresume_tracking_set_state)
        return m_fpresume_tracking_set_state( a1, a2, a3);
    return 0;
}

int gvr_pause_tracking_get_state( void *a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fppause_tracking_get_state)
        return m_fppause_tracking_get_state(a1);
    return 0;
}

int gvr_tracker_state_create(int a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fptracker_state_create)
        return m_fptracker_state_create( a1,a2);
    return 0;
}

int gvr_create_with_tracker_for_testing( int a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpcreate_with_tracker_for_testing)
        return m_fpcreate_with_tracker_for_testing(a1, a2);
    return 0;
}

int gvr_set_error(int a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(m_fpset_error)
        re = m_fpset_error( a1, a2);
    return re;
}

int gvr_set_idle_listener(int *a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(m_fpset_idle_listener)
        re = m_fpset_idle_listener(a1, a2, a3);
    return re;
}

int gvr_set_display_synchronizer( int *a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpset_display_synchronizer)
        return m_fpset_display_synchronizer(a1, a2);
    return 0;
}

int gvr_display_synchronizer_reset(void *a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpdisplay_synchronizer_reset)
        return m_fpdisplay_synchronizer_reset(a1);
    return 0;
}

int gvr_on_pause_reprojection_thread(int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpon_pause_reprojection_thread)
        return m_fpon_pause_reprojection_thread( a1);
    return 0;
}

int gvr_on_surface_changed_reprojection_thread(int a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(m_fpon_surface_changed_reprojection_thread)
        return m_fpon_surface_changed_reprojection_thread(a1, a2, a3);
    return 0;
}

int gvr_update_surface_reprojection_thread(int *a1, int a2, int a3, int a4, int64_t a5,
                                           int a6, int a7, int a8, int a9, int a10, int a11,
                                           int a12, int a13, int a14, int a15, int a16, int a17,
                                           int a18, int a19, int a20, int a21)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( m_fpupdate_surface_reprojection_thread)
        return m_fpupdate_surface_reprojection_thread(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21);
    return 0;
}

int Java_com_google_geo_render_mirth_api_MirthNet_setHttpProxy(int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( m_fpMirthNet_setHttpProxy)
        re = m_fpMirthNet_setHttpProxy( a1);
    return re;
}

