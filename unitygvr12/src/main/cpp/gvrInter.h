//
// Created by houguoli on 2017/1/3.
//

#ifndef UNITYINTERFACE_UNITYINTERFACE_H
#define UNITYINTERFACE_UNITYINTERFACE_H
#include "jni.h"
//#include "vr/gvr/capi/include/gvr_types.h"
//#include "vr/gvr/capi/include/gvr_controller.h"
#include "gvr_controller.h"
#include "gvr_types.h"

#ifdef __cplusplus
extern "C" {
#endif

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
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeReconnectSensors(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDisplayMetrics(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1, jfloat paramFloat2);
JNIEXPORT void JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeReset(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jlong paramLong3);
JNIEXPORT void JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeUpdate(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt);

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
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativePause(
        JNIEnv* env, jobject obj, jlong paramLong);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeResume(
        JNIEnv* env, jobject obj, jlong paramLong );
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeReleaseGvrContext(
        JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetCardboardApi(
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
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetReprojection(
         JNIEnv* env, jobject obj, jlong paramLong);

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetReprojection(
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
//todo
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeResumeTracking(
        JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte);
//todo
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDefaultViewerProfile(
        JNIEnv* env, jobject obj, jlong paramLong, jstring paramString);
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetViewerParams(
        JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte);
JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainCreate(
        JNIEnv* env, jobject obj, jlong paramLong, jlongArray paramArrayOfLong);

//(int a1, int a2, int a3, int a4, float a5, float a6, int a7, int a8, int a9, int a10, int a11

JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeCreate(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext, jfloat a5, jfloat a6, jint paramInt1,
        jint paramInt2, jfloat paramFloat1, jfloat paramFloat2, jobject paramPoseTracker);
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

JNIEXPORT jintArray JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetWindowBounds(
                JNIEnv* env, jobject obj, jlong paramLong);


void gvr_buffer_viewport_list_destroy(gvr_buffer_viewport_list **viewport_list);
       
void gvr_swap_chain_destroy(gvr_swap_chain **swap_chain);

void gvr_destroy(gvr_context **gvr);

void gvr_buffer_viewport_destroy(gvr_buffer_viewport **viewport);

gvr_swap_chain * gvr_swap_chain_create(gvr_context *gvr, const gvr_buffer_spec **buffers, int32_t count);

void gvr_bind_default_framebuffer(gvr_context *gvr);

gvr_sizei gvr_get_maximum_effective_render_target_size(const gvr_context *gvr);

void gvr_buffer_spec_set_samples(gvr_buffer_spec *spec, int32_t num_samples);

void gvr_buffer_spec_set_depth_stencil_format(gvr_buffer_spec *spec, int32_t depth_stencil_format);

void gvr_buffer_spec_set_size(gvr_buffer_spec *spec, gvr_sizei size);

gvr_buffer_spec * gvr_buffer_spec_create(gvr_context *gvr);

void gvr_initialize_gl(gvr_context *gvr);

void gvr_distort_to_screen(
  gvr_context *gvr,
  int32_t texture_id,
  const gvr_buffer_viewport_list *viewport_list,
  gvr_mat4f head_space_from_start_space,
  gvr_clock_time_point target_presentation_time);

gvr_clock_time_point gvr_get_time_point_now();


void gvr_buffer_spec_destroy(gvr_buffer_spec **spec);

gvr_mat4f gvr_get_eye_from_head_matrix(const gvr_context *gvr, const int32_t eye);

gvr_sizei gvr_swap_chain_get_buffer_size(gvr_swap_chain *swap_chain, int32_t index);

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

void gvr_buffer_spec_set_color_format(gvr_buffer_spec *spec, int32_t color_format);

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
int gvr_check_surface_size_changed(int a1);
int gvr_get_surface_size(int a1, int a2, int a3);
int gvr_reconnect_sensors( void *a1);
int gvr_set_lens_offset(int *a1, int a2, int a3);
int gvr_resume(int a1);
int gvr_dump_debug_data(void *a1);
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
int gvr_set_error(int a1, int a2);
int gvr_set_display_synchronizer( int *a1, int a2);
int gvr_display_synchronizer_reset(void *a1);
int gvr_on_pause_reprojection_thread(int a1);
int gvr_update_surface_reprojection_thread(int *a1, int a2, int a3, int a4, int64_t a5,
                                           int a6, int a7, int a8, int a9, int a10, int a11,
                                           int a12, int a13, int a14, int a15, int a16, int a17,
                                           int a18, int a19, int a20, int a21);

int Java_com_google_geo_render_mirth_api_MirthNet_setHttpProxy(int a1);

#ifdef __cplusplus
}
#endif

#endif //UNITYINTERFACE_UNITYINTERFACE_H
