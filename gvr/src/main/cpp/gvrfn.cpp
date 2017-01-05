//
// Created by mac on 16/8/19.
//

#include "gvrfn.h"
#include <dlfcn.h>
#include "gvrtest.h"

JavaVM *gs_jvm=0;
static int gneedDetach = 0;


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
#define FN_CardboardViewNativeImpl_nativeUndistortTexture                  "Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeUndistortTexture"
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
#define FN_GvrApi_nativeRemoveAllSurfacesReprojectionThread         "Java_com_google_vr_ndk_base_GvrApi_nativeRemoveAllSurfacesReprojectionThread"
#define FN_GvrApi_nativeUsingVrDisplayService  "Java_com_google_vr_ndk_base_GvrApi_nativeUsingVrDisplayService"
#define FN_GvrApi_nativeBufferViewportListCreate         "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListCreate"
#define FN_GvrApi_nativeBufferViewportListDestroy  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListDestroy"
#define FN_GvrApi_nativeGetBorderSizeMeters          "Java_com_google_vr_ndk_base_GvrApi_nativeGetBorderSizeMeters"
#define FN_GvrApi_nativeSetSurfaceSize  "Java_com_google_vr_ndk_base_GvrApi_nativeSetSurfaceSize"
#define FN_GvrApi_nativeSetLensOffset          "Java_com_google_vr_ndk_base_GvrApi_nativeSetLensOffset"
#define FN_GvrApi_nativeUpdateSurfaceReprojectionThread  "Java_com_google_vr_ndk_base_GvrApi_nativeUpdateSurfaceReprojectionThread"
#define FN_GvrApi_nativeGetAsyncReprojectionEnabled          "Java_com_google_vr_ndk_base_GvrApi_nativeGetAsyncReprojectionEnabled"
#define FN_GvrApi_nativeReconnectSensors  "Java_com_google_vr_ndk_base_GvrApi_nativeReconnectSensors"
#define FN_GvrApi_nativeSetDisplayMetrics         "Java_com_google_vr_ndk_base_GvrApi_nativeSetDisplayMetrics"
#define FN_DisplaySynchronizer_nativeReset  "Java_com_google_vr_cardboard_DisplaySynchronizer_nativeReset"
#define FN_DisplaySynchronizer_nativeUpdate         "Java_com_google_vr_cardboard_DisplaySynchronizer_nativeUpdate"
#define FN_DisplaySynchronizer_nativeCreate  "Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate"
#define FN_DisplaySynchronizer_nativeDestroy          "Java_com_google_vr_cardboard_DisplaySynchronizer_nativeDestroy"
#define FN_GvrApi_nativeDumpDebugData  "Java_com_google_vr_ndk_base_GvrApi_nativeDumpDebugData"
#define FN_GvrApi_nativeInitializeGl         "Java_com_google_vr_ndk_base_GvrApi_nativeInitializeGl"
#define FN_GvrApi_nativeOnSurfaceCreatedReprojectionThread  "Java_com_google_vr_ndk_base_GvrApi_nativeOnSurfaceCreatedReprojectionThread"
#define FN_GvrApi_nativeGetRecommendedBufferViewports         "Java_com_google_vr_ndk_base_GvrApi_nativeGetRecommendedBufferViewports"
#define FN_GvrApi_nativeGetError  "Java_com_google_vr_ndk_base_GvrApi_nativeGetError"
#define FN_GvrApi_nativeClearError         "Java_com_google_vr_ndk_base_GvrApi_nativeClearError"
#define FN_GvrApi_nativeGetUserPrefs  "Java_com_google_vr_ndk_base_GvrApi_nativeGetUserPrefs"
#define FN_GvrApi_nativeUserPrefsGetControllerHandedness          "Java_com_google_vr_ndk_base_GvrApi_nativeUserPrefsGetControllerHandedness"
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
#define FN_GvrApi_nativeBufferViewportSetExternalSurfaceId         "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetExternalSurfaceId"
#define FN_GvrApi_nativeBufferViewportGetReprojection  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetReprojection"
#define FN_GvrApi_nativeBufferViewportSetReprojection         "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetReprojection"
#define FN_GvrApi_nativeBufferViewportEqual  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportEqual"
#define FN_GvrApi_nativeBufferSpecCreate         "Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecCreate"
#define FN_GvrApi_nativeBufferSpecDestroy  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecDestroy"
#define FN_GvrApi_nativeBufferSpecGetSize          "Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecGetSize"
#define FN_GvrApi_nativeBufferSpecSetSize  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetSize"
#define FN_GvrApi_nativeBufferSpecGetSamples         "Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecGetSamples"
#define FN_GvrApi_nativeBufferSpecSetSamples  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetSamples"
#define FN_GvrApi_nativeBufferSpecSetColorFormat         "Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetColorFormat"
#define FN_GvrApi_nativeBufferSpecSetDepthStencilFormat  "Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetDepthStencilFormat"
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
#define FN_GvrApi_nativeResumeTracking         "Java_com_google_vr_ndk_base_GvrApi_nativeResumeTracking"
#define FN_GvrApi_nativeSetDefaultViewerProfile  "Java_com_google_vr_ndk_base_GvrApi_nativeSetDefaultViewerProfile"
#define FN_GvrApi_nativeSetViewerParams         "Java_com_google_vr_ndk_base_GvrApi_nativeSetViewerParams"
#define FN_GvrApi_nativeSwapChainCreate  "Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainCreate"
#define FN_GvrApi_nativeCreate          "Java_com_google_vr_ndk_base_GvrApi_nativeCreate"
#define FN_GvrApi_nativeComputeDistortedPoint  "Java_com_google_vr_ndk_base_GvrApi_nativeComputeDistortedPoint"
#define FN_GvrApi_nativeGetErrorString         "Java_com_google_vr_ndk_base_GvrApi_nativeGetErrorString"
#define FN_GvrApi_nativeGetViewerVendor  "Java_com_google_vr_ndk_base_GvrApi_nativeGetViewerVendor"
#define FN_GvrApi_nativeGetViewerModel          "Java_com_google_vr_ndk_base_GvrApi_nativeGetViewerModel"
#define FN_GvrApi_nativePauseTracking  "Java_com_google_vr_ndk_base_GvrApi_nativePauseTracking"
#define FN_GvrApi_nativeGetWindowBounds         "Java_com_google_vr_ndk_base_GvrApi_nativeGetWindowBounds"


#define FN_buffer_viewport_list_destroy         "gvr_buffer_viewport_list_destroy"
#define FN_swap_chain_destroy                    "gvr_swap_chain_destroy"
#define FN_destroy                                "gvr_destroy"
#define FN_buffer_viewport_destroy         "gvr_buffer_viewport_destroy"
#define FN_swap_chain_create  "gvr_swap_chain_create"
#define FN_bind_default_framebuffer         "gvr_bind_default_framebuffer"
#define FN_get_maximum_effective_render_target_size  "gvr_get_maximum_effective_render_target_size"
#define FN_buffer_spec_set_samples          "gvr_buffer_spec_set_samples"
#define FN_buffer_spec_set_depth_stencil_format  "gvr_buffer_spec_set_depth_stencil_format"
#define FN_buffer_spec_set_size          "gvr_buffer_spec_set_size"
#define FN_buffer_spec_create  "gvr_buffer_spec_create"
#define FN_initialize_gl          "gvr_initialize_gl"
#define FN_distort_to_screen  "gvr_distort_to_screen"
#define FN_get_time_point_now          "gvr_get_time_point_now"
#define FN_set_viewer_params  "gvr_set_viewer_params"
#define FN_set_display_metrics          "gvr_set_display_metrics"
#define FN_buffer_spec_destroy  "gvr_buffer_spec_destroy"
#define FN_get_eye_from_head_matrix          "gvr_get_eye_from_head_matrix"
#define FN_swap_chain_get_buffer_size  "gvr_swap_chain_get_buffer_size"
#define FN_set_error          "gvr_set_error"
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
#define FN_gvr_get_border_size_meters  "gvr_get_border_size_meters"
#define FN_check_surface_size_changed          "gvr_check_surface_size_changed"
#define FN_get_surface_size  "gvr_get_surface_size"
#define FN_set_display_output_rotation          "gvr_set_display_output_rotation"
#define FN_reconnect_sensors  "gvr_reconnect_sensors"
#define FN_set_lens_offset         "gvr_set_lens_offset"
#define FN_resume  "gvr_resume"
#define FN_dump_debug_data         "gvr_dump_debug_data"
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
#define FN_controller_state_is_touching          "gvr_controller_state_is_touching"
#define FN_controller_state_get_touch_pos  "gvr_controller_state_get_touch_pos"
#define FN_controller_state_get_touch_down         "gvr_controller_state_get_touch_down"
#define FN_controller_state_get_touch_up  "gvr_controller_state_get_touch_up"
#define FN_controller_state_get_recentered         "gvr_controller_state_get_recentered"
#define FN_controller_state_get_recentering  "gvr_controller_state_get_recentering"
#define FN_on_pause_reprojection_thread        "gvr_on_pause_reprojection_thread"
#define FN_controller_state_get_button_state  "gvr_controller_state_get_button_state"
#define FN_update_surface_reprojection_thread       "gvr_update_surface_reprojection_thread"
#define FN_controller_state_get_button_down  "gvr_controller_state_get_button_down"
#define FN_controller_state_get_button_up        "gvr_controller_state_get_button_up"
#define FN_remove_all_surfaces_reprojection_thread  "gvr_remove_all_surfaces_reprojection_thread"
#define FN_controller_state_get_last_orientation_timestamp       "gvr_controller_state_get_last_orientation_timestamp"
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
#define GET_DLL_FUNCION_ERR(FUNC) {if (m_fp##FUNC == NULL ) { LOGW( "Can not get "#FUNC" function pointer");}}

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


jint JNI_OnLoad_Test( JavaVM* vm, void *reserved){
    gs_jvm = vm;

    jint result = JNI_VERSION_1_6;
    return  result;

}

CGVRAPI::CGVRAPI()
{
    m_bInit = false;
}

CGVRAPI::~CGVRAPI()
{
    m_bInit = false;
}

bool CGVRAPI::Init()
{
    if( m_bInit )
        return m_bInit;
//    try
    {
        m_hDLL = dlopen("/sdcard/gvrimpl.so", RTLD_LAZY);
        if (m_hDLL)
        {
            GET_DLL_FUNCION(m_hDLL, CardboardViewNativeImpl_nativeSetApplicationState);
//            GET_DLL_FUNCION(m_hDLL, Initialize);
//            GET_DLL_FUNCION(m_hDLL, Shutdown);
//            GET_DLL_FUNCION(m_hDLL, GetDeviceInfo);
//            GET_DLL_FUNCION(m_hDLL, SetPerformanceLevels);
//            GET_DLL_FUNCION(m_hDLL, BeginVr);
//            GET_DLL_FUNCION(m_hDLL, EndVr);
//            GET_DLL_FUNCION(m_hDLL, GetPredictedDisplayTime);
//            GET_DLL_FUNCION(m_hDLL, GetPredictedHeadPose);
//            GET_DLL_FUNCION(m_hDLL, RecenterPose);
//            GET_DLL_FUNCION(m_hDLL, GetSupportedTrackingModes);
//            GET_DLL_FUNCION(m_hDLL, SetTrackingMode);
//            GET_DLL_FUNCION(m_hDLL, SubmitFrame);
//            GET_DLL_FUNCION(m_hDLL, UpdateWarpmesh);
//            GET_DLL_FUNCION(m_hDLL, CheckServiceIsAvaliable);
//            GET_DLL_FUNCION(m_hDLL, SetTimewarp);
            if (m_fpCardboardViewNativeImpl_nativeSetApplicationState != NULL
//                && m_fpInitialize != NULL
//                && m_fpShutdown != NULL
//                && m_fpGetDeviceInfo != NULL
//                && m_fpSetPerformanceLevels != NULL
//                && m_fpBeginVr != NULL
//                && m_fpEndVr != NULL
//                && m_fpGetPredictedDisplayTime != NULL
//                && m_fpGetPredictedHeadPose != NULL
//                && m_fpRecenterPose != NULL
//                && m_fpGetSupportedTrackingModes != NULL
//                && m_fpSetTrackingMode != NULL
//                && m_fpSubmitFrame != NULL
//                && m_fpUpdateWarpmesh != NULL
//                && m_fpCheckServiceIsAvaliable != NULL
//                && m_fpSetTimewarp != NULL
            )
            {
                 m_bInit = true;
//                MOJING_TRACE(g_APIlogger , "svrApi init OK");
            }
            else
            {// 有函数指针拿不到
                GET_DLL_FUNCION_ERR(CardboardViewNativeImpl_nativeSetApplicationState);
//                GET_DLL_FUNCION_ERR(Initialize);
//                GET_DLL_FUNCION_ERR(Shutdown);
//                GET_DLL_FUNCION_ERR(GetDeviceInfo);
//                GET_DLL_FUNCION_ERR(SetPerformanceLevels);
//                GET_DLL_FUNCION_ERR(BeginVr);
//                GET_DLL_FUNCION_ERR(EndVr);
//                GET_DLL_FUNCION_ERR(GetPredictedDisplayTime);
//                GET_DLL_FUNCION_ERR(GetPredictedHeadPose);
//                GET_DLL_FUNCION_ERR(RecenterPose);
//                GET_DLL_FUNCION_ERR(GetSupportedTrackingModes);
//                GET_DLL_FUNCION_ERR(SetTrackingMode);
//                GET_DLL_FUNCION_ERR(SubmitFrame);
//                GET_DLL_FUNCION_ERR(UpdateWarpmesh);
//                GET_DLL_FUNCION_ERR(CheckServiceIsAvaliable);
//                GET_DLL_FUNCION_ERR(SetTimewarp);
                Release();
            }
        }
        else// m_hDLL == NULL
        {
            const char* err = dlerror();
            LOGE( "Can not load libary \"gvrimpl.so\"  Error = %s" , err ? err : "Unknown");
        }
    }
//    catch (...)
//    {
//        LOGE( "Can not load libary \"gvrimpl.so\"  , ****CRASH***");
//    }
    return	 m_bInit;
}

void CGVRAPI::Release() {
    if (m_hDLL)
        dlclose(m_hDLL);
    m_fpCardboardViewNativeImpl_nativeSetApplicationState = NULL;
//    m_fpGetVersion = NULL;
//    m_fpInitialize = NULL;
//    m_fpShutdown = NULL;
//    m_fpGetDeviceInfo = NULL;
//    m_fpSetPerformanceLevels = NULL;
//    m_fpBeginVr = NULL;
//    m_fpEndVr = NULL;
//    m_fpGetPredictedDisplayTime = NULL;
//    m_fpGetPredictedHeadPose = NULL;
//    m_fpRecenterPose = NULL;
//    m_fpGetSupportedTrackingModes = NULL;
//    m_fpSetTrackingMode = NULL;
//    m_fpSubmitFrame = NULL;
//    m_fpUpdateWarpmesh = NULL;
}

long CGVRAPI::CardboardViewNativeImpl_nativeSetApplicationState(JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext)
{
    Init();
    long re = 0;
    if( m_fpCardboardViewNativeImpl_nativeSetApplicationState)
        re = m_fpCardboardViewNativeImpl_nativeSetApplicationState(env, obj, paramClassLoader, paramContext);
    return re;
}