//
// Created by mac on 16/8/19.
//

#ifndef LIBGVR_H
#define LIBGVR_H

#include <jni.h>
#include <android/log.h>

#include "gvr_controller.h"
#include "gvr_types.h"

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

typedef void (*FP_GvrApi_nativeReconnectSensors)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeSetDisplayMetrics)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1, jfloat paramFloat2);

typedef void (*FP_DisplaySynchronizer_nativeReset)(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jlong paramLong3);

typedef void (*FP_DisplaySynchronizer_nativeUpdate)(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt);

typedef long (*FP_DisplaySynchronizer_nativeCreate)(JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext);

typedef void (*FP_DisplaySynchronizer_nativeDestroy)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeDumpDebugData)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeInitializeGl)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeOnSurfaceCreatedReprojectionThread)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeGetRecommendedBufferViewports)(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2);

typedef int (*FP_GvrApi_nativeGetError)(JNIEnv* env, jobject obj, jlong paramLong);

typedef int (*FP_GvrApi_nativeClearError)( JNIEnv* env, jobject obj, jlong paramLong);

typedef long (*FP_GvrApi_nativeGetUserPrefs)(JNIEnv* env, jobject obj, jlong paramLong);

typedef int (*FP_GvrApi_nativeUserPrefsGetControllerHandedness)(JNIEnv* env, jobject obj, jlong paramLong);

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

typedef int (*FP_GvrApi_nativeBufferViewportGetReprojection)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeBufferViewportSetReprojection)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef bool (*FP_GvrApi_nativeBufferViewportEqual)(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2);

typedef long (*FP_GvrApi_nativeBufferSpecCreate)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeBufferSpecDestroy)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeBufferSpecGetSize)( JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint);

typedef void (*FP_GvrApi_nativeBufferSpecSetSize)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jint paramInt2);

typedef int (*FP_GvrApi_nativeBufferSpecGetSamples)(JNIEnv* env, jobject obj, jlong paramLong);

typedef void (*FP_GvrApi_nativeBufferSpecSetSamples)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef void (*FP_GvrApi_nativeBufferSpecSetColorFormat)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

typedef void (*FP_GvrApi_nativeBufferSpecSetDepthStencilFormat)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt);

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

typedef void (*FP_GvrApi_nativeResumeTracking)(JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte);

typedef bool (*FP_GvrApi_nativeSetDefaultViewerProfile)(JNIEnv* env, jobject obj, jlong paramLong, jstring paramString);

typedef bool (*FP_GvrApi_nativeSetViewerParams)( JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte);

typedef long (*FP_GvrApi_nativeSwapChainCreate)(JNIEnv* env, jobject obj, jlong paramLong, jlongArray paramArrayOfLong);

typedef long (*FP_GvrApi_nativeCreate)(JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1, jfloat paramFloat2, jobject paramPoseTracker);

typedef jfloatArray (*FP_GvrApi_nativeComputeDistortedPoint)(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jfloatArray paramArrayOfFloat);

typedef jstring (*FP_GvrApi_nativeGetErrorString)(JNIEnv* env, jobject obj, jint paramInt);

typedef jstring (*FP_GvrApi_nativeGetViewerVendor)(JNIEnv* env, jobject obj, jlong paramLong);

typedef jstring (*FP_GvrApi_nativeGetViewerModel)( JNIEnv* env, jobject obj, jlong paramLong);

typedef jbyteArray (*FP_GvrApi_nativePauseTracking)( JNIEnv* env, jobject obj, jlong paramLong);

typedef jintArray (*FP_GvrApi_nativeGetWindowBounds)(JNIEnv* env, jobject obj, jlong paramLong);



typedef void (*FP_buffer_viewport_list_destroy)( gvr_buffer_viewport_list **viewport_list);
typedef void (*FP_swap_chain_destroy)(gvr_swap_chain **swap_chain);

typedef void (*FP_destroy)( gvr_context **gvr);

typedef void (*FP_buffer_viewport_destroy)(gvr_buffer_viewport **viewport);

typedef gvr_swap_chain * (*FP_swap_chain_create)( gvr_context *gvr, const gvr_buffer_spec **buffers, int32_t count);

typedef void (*FP_bind_default_framebuffer)(gvr_context *gvr);
typedef gvr_sizei (*FP_get_maximum_effective_render_target_size)(const gvr_context *gvr);

typedef void (*FP_buffer_spec_set_samples)( gvr_buffer_spec *spec, int32_t num_samples);

typedef void (*FP_buffer_spec_set_depth_stencil_format)( gvr_buffer_spec *spec, int32_t depth_stencil_format);

typedef void (*FP_buffer_spec_set_size)( gvr_buffer_spec *spec, gvr_sizei size);

typedef gvr_buffer_spec * (*FP_buffer_spec_create)( gvr_context *gvr);

typedef void (*FP_initialize_gl)(gvr_context *gvr);

typedef void (*FP_distort_to_screen)( gvr_context *gvr,
                                       int32_t texture_id,
                                       const gvr_buffer_viewport_list *viewport_list,
                                       gvr_mat4f head_space_from_start_space,
                                       gvr_clock_time_point target_presentation_time);

typedef void (*FP_get_time_point_now)();

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

typedef void (*FP_buffer_viewport_set_reprojection)(  gvr_buffer_viewport *viewport,
                                                      int32_t reprojection);

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
typedef gvr_context *(FP_create)(  JNIEnv *env,
                                   jobject app_context,
                                   jobject class_loader);

typedef void (*FP_frame_bind_buffer)(  gvr_frame *frame,
                                       int32_t index);

typedef void (*FP_frame_unbind)(gvr_frame *frame);
typedef void (*FP_frame_submit)(  gvr_frame **frame,
                                  const gvr_buffer_viewport_list *list,
                                  gvr_mat4f head_space_from_start_space);

typedef void (*FP_swap_chain_resize_buffer)(  gvr_swap_chain *swap_chain,
                                              int32_t index,
                                              gvr_sizei size);

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
typedef int (*FP_gvr_get_border_size_meters)(void *a1);
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



#define LOGI(...) ((void)__android_log_print(ANDROID_LOG_INFO, "hell-libs::", __VA_ARGS__))

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
    void GvrApi_nativeReconnectSensors(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeSetDisplayMetrics(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2,
                                        jfloat paramFloat1, jfloat paramFloat2);
    void DisplaySynchronizer_nativeReset(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jlong paramLong3);
    void DisplaySynchronizer_nativeUpdate(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt);
    long DisplaySynchronizer_nativeCreate(JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext);
    void DisplaySynchronizer_nativeDestroy(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeDumpDebugData(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeInitializeGl(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeOnSurfaceCreatedReprojectionThread(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeGetRecommendedBufferViewports(JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2);
    int GvrApi_nativeGetError(JNIEnv* env, jobject obj, jlong paramLong);
    int GvrApi_nativeClearError( JNIEnv* env, jobject obj, jlong paramLong);
    long GvrApi_nativeGetUserPrefs(JNIEnv* env, jobject obj, jlong paramLong);
    int GvrApi_nativeUserPrefsGetControllerHandedness(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativePause(JNIEnv* env, jobject obj, jlong paramLong);
    void GvrApi_nativeResume(JNIEnv* env, jobject obj, jlong paramLong);

private:
    void * m_hDLL;
    bool m_bInit;

    DEF_VARIABLES(GvrApi_nativeResume);
    DEF_VARIABLES(GvrApi_nativePause);
    DEF_VARIABLES(GvrApi_nativeUserPrefsGetControllerHandedness);
    DEF_VARIABLES(GvrApi_nativeGetUserPrefs);
    DEF_VARIABLES(GvrApi_nativeClearError);
    DEF_VARIABLES(GvrApi_nativeGetError);
    DEF_VARIABLES(GvrApi_nativeGetRecommendedBufferViewports);
    DEF_VARIABLES(GvrApi_nativeOnSurfaceCreatedReprojectionThread);
    DEF_VARIABLES(GvrApi_nativeInitializeGl);
    DEF_VARIABLES(GvrApi_nativeDumpDebugData);
    DEF_VARIABLES(DisplaySynchronizer_nativeDestroy);
    DEF_VARIABLES(DisplaySynchronizer_nativeCreate);
    DEF_VARIABLES(DisplaySynchronizer_nativeUpdate);
    DEF_VARIABLES(DisplaySynchronizer_nativeReset);
    DEF_VARIABLES(GvrApi_nativeSetDisplayMetrics);
    DEF_VARIABLES(GvrApi_nativeReconnectSensors);
    DEF_VARIABLES(GvrApi_nativeGetAsyncReprojectionEnabled);
    DEF_VARIABLES(GvrApi_nativeUpdateSurfaceReprojectionThread);
    DEF_VARIABLES(GvrApi_nativeSetLensOffset);
    DEF_VARIABLES(GvrApi_nativeSetSurfaceSize);
    DEF_VARIABLES(GvrApi_nativeGetBorderSizeMeters);
    DEF_VARIABLES(GvrApi_nativeBufferViewportListDestroy);
    DEF_VARIABLES(GvrApi_nativeBufferViewportListCreate);
    DEF_VARIABLES(GvrApi_nativeUsingVrDisplayService);
    DEF_VARIABLES(GvrApi_nativeRemoveAllSurfacesReprojectionThread);
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
    DEF_VARIABLES(CardboardViewNativeImpl_nativeUndistortTexture);

};

#endif //TRUNK_VIEWCORE_H
