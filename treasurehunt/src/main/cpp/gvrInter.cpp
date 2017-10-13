#include <dlfcn.h>
#include <unistd.h>
#include "gvrInter.h"
#include "gvrglobal.h"
#include "LogMessage.h"

#define GET_DLL_FUNCION(DLL , FUNC)  g_fp##FUNC = (FP_##FUNC)dlsym(DLL , FN_##FUNC)
#define GET_DLL_FUNCION_ERR(FUNC) {if (g_fp##FUNC == NULL ) { LOGE( "Can not get "#FUNC" function pointer");}}
#define DEF_VARIABLES(name) FP_##name g_fp##name


void *g_hDLL = NULL;
bool g_bInit = false;

FP_create_with_tracker_for_testing      g_fpcreate_with_tracker_for_testing;
FP_tracker_state_create                 g_fptracker_state_create;
FP_pause_tracking_get_state             g_fppause_tracking_get_state;
FP_resume_tracking_set_state            g_fpresume_tracking_set_state;
FP_tracker_state_destroy                g_fptracker_state_destroy;
FP_controller_state_get_last_button_timestamp g_fpcontroller_state_get_last_button_timestamp;
FP_render_reprojection_thread g_fprender_reprojection_thread;
FP_controller_state_get_last_touch_timestamp g_fpcontroller_state_get_last_touch_timestamp;
FP_on_surface_created_reprojection_thread g_fpon_surface_created_reprojection_thread;
FP_controller_state_get_last_accel_timestamp g_fpcontroller_state_get_last_accel_timestamp;
FP_set_async_reprojection_enabled g_fpset_async_reprojection_enabled;
FP_controller_state_get_last_gyro_timestamp g_fpcontroller_state_get_last_gyro_timestamp;
FP_controller_state_get_last_orientation_timestamp g_fpcontroller_state_get_last_orientation_timestamp;
FP_controller_state_get_last_battery_timestamp g_fpcontroller_state_get_last_battery_timestamp;
FP_remove_all_surfaces_reprojection_thread g_fpremove_all_surfaces_reprojection_thread;
FP_controller_state_get_button_up g_fpcontroller_state_get_button_up;
FP_controller_state_get_button_down g_fpcontroller_state_get_button_down;
FP_update_surface_reprojection_thread g_fpupdate_surface_reprojection_thread;
FP_controller_state_get_button_state g_fpcontroller_state_get_button_state;
FP_on_pause_reprojection_thread g_fpon_pause_reprojection_thread;
FP_on_surface_changed_reprojection_thread g_fpon_surface_changed_reprojection_thread;
FP_controller_state_get_recentering g_fpcontroller_state_get_recentering;
FP_controller_state_get_recentered g_fpcontroller_state_get_recentered;
FP_controller_state_get_touch_up g_fpcontroller_state_get_touch_up;
FP_controller_state_get_touch_down g_fpcontroller_state_get_touch_down;
FP_controller_state_get_touch_pos g_fpcontroller_state_get_touch_pos;
FP_controller_state_is_touching g_fpcontroller_state_is_touching;
FP_controller_state_get_accel g_fpcontroller_state_get_accel;
FP_controller_state_get_battery_charging g_fpcontroller_state_get_battery_charging;
FP_controller_state_get_battery_level g_fpcontroller_state_get_battery_level;
FP_controller_state_get_gyro g_fpcontroller_state_get_gyro;
FP_controller_state_get_orientation g_fpcontroller_state_get_orientation;
FP_controller_state_get_connection_state g_fpcontroller_state_get_connection_state;
FP_controller_state_get_api_status g_fpcontroller_state_get_api_status;
FP_controller_state_update g_fpcontroller_state_update;
FP_controller_state_destroy g_fpcontroller_state_destroy;
FP_controller_state_create g_fpcontroller_state_create;
FP_controller_button_to_string g_fpcontroller_button_to_string;
FP_display_synchronizer_update g_fpdisplay_synchronizer_update;
FP_controller_connection_state_to_string g_fpcontroller_connection_state_to_string;
FP_controller_api_status_to_string g_fpcontroller_api_status_to_string;
FP_controller_battery_level_to_string g_fpcontroller_battery_level_to_string;
FP_display_synchronizer_reset g_fpdisplay_synchronizer_reset;
FP_controller_resume g_fpcontroller_resume;
FP_set_ignore_manual_tracker_pause_resume g_fpset_ignore_manual_tracker_pause_resume;
FP_controller_pause g_fpcontroller_pause;
FP_set_display_synchronizer g_fpset_display_synchronizer;
FP_controller_destroy g_fpcontroller_destroy;
FP_controller_create_and_init_android g_fpcontroller_create_and_init_android;
FP_pause g_fppause;
FP_tracker_state_get_buffer g_fptracker_state_get_buffer;
FP_controller_create_and_init g_fpcontroller_create_and_init;
FP_tracker_state_get_buffer_size g_fptracker_state_get_buffer_size;
FP_using_vr_display_service g_fpusing_vr_display_service;
FP_controller_get_default_options g_fpcontroller_get_default_options;
FP_dump_debug_data g_fpdump_debug_data;
FP_external_surface_create_with_listeners g_fpexternal_surface_create_with_listeners;
FP_external_surface_destroy g_fpexternal_surface_destroy;
FP_external_surface_get_surface g_fpexternal_surface_get_surface;
FP_external_surface_get_surface_id g_fpexternal_surface_get_surface_id;
FP_using_dynamic_library g_fpusing_dynamic_library;
FP_resume g_fpresume;
FP_set_lens_offset g_fpset_lens_offset;
FP_reconnect_sensors g_fpreconnect_sensors;
FP_set_display_output_rotation g_fpset_display_output_rotation;
FP_get_surface_size g_fpget_surface_size;
FP_check_surface_size_changed g_fpcheck_surface_size_changed;
FP_get_border_size_meters g_fpget_border_size_meters;
FP_get_button_long_press g_fpget_button_long_press;
FP_display_synchronizer_destroy g_fpdisplay_synchronizer_destroy;
FP_display_synchronizer_create g_fpdisplay_synchronizer_create;
FP_refresh_viewer_profile g_fprefresh_viewer_profile;
FP_set_default_viewer_profile g_fpset_default_viewer_profile;
FP_recenter_tracking g_fprecenter_tracking;
FP_reset_tracking g_fpreset_tracking;
FP_resume_tracking g_fpresume_tracking;
FP_buffer_viewport_set_source_fov g_fpbuffer_viewport_set_source_fov;
FP_pause_tracking g_fppause_tracking;
FP_frame_get_framebuffer_object g_fpframe_get_framebuffer_object;
FP_frame_get_buffer_size g_fpframe_get_buffer_size;
FP_buffer_viewport_set_target_eye g_fpbuffer_viewport_set_target_eye;
FP_buffer_viewport_set_transform g_fpbuffer_viewport_set_transform;
FP_buffer_spec_set_color_format g_fpbuffer_spec_set_color_format;
FP_buffer_viewport_get_transform g_fpbuffer_viewport_get_transform;
FP_set_surface_size g_fpset_surface_size;
FP_buffer_viewport_set_external_surface_id g_fpbuffer_viewport_set_external_surface_id;
FP_buffer_viewport_get_external_surface_id g_fpbuffer_viewport_get_external_surface_id;
FP_buffer_viewport_list_get_size g_fpbuffer_viewport_list_get_size;
FP_buffer_viewport_set_source_buffer_index g_fpbuffer_viewport_set_source_buffer_index;
FP_get_async_reprojection_enabled g_fpget_async_reprojection_enabled;
FP_buffer_viewport_get_source_buffer_index g_fpbuffer_viewport_get_source_buffer_index;
FP_get_error_string g_fpget_error_string;
FP_clear_error g_fpclear_error;
FP_get_viewer_type g_fpget_viewer_type;
FP_get_error g_fpget_error;
FP_get_viewer_model g_fpget_viewer_model;
FP_get_version_string g_fpget_version_string;
FP_get_viewer_vendor g_fpget_viewer_vendor;
FP_get_version g_fpget_version;
FP_set_back_gesture_event_handler g_fpset_back_gesture_event_handler;
FP_buffer_viewport_create g_fpbuffer_viewport_create;
FP_get_user_prefs g_fpget_user_prefs;
FP_buffer_viewport_list_create g_fpbuffer_viewport_list_create;
FP_swap_chain_resize_buffer g_fpswap_chain_resize_buffer;
FP_frame_submit g_fpframe_submit;
FP_frame_unbind g_fpframe_unbind;
FP_gesture_context_create g_fpgesture_context_create;
FP_gesture_context_destroy g_fpgesture_context_destroy;
FP_gesture_get g_fpgesture_get;
FP_gesture_get_count g_fpgesture_get_count;
FP_gesture_get_direction g_fpgesture_get_direction;
FP_gesture_get_displacement g_fpgesture_get_displacement;
FP_gesture_get_type g_fpgesture_get_type;
FP_gesture_get_velocity g_fpgesture_get_velocity;
FP_gesture_restart g_fpgesture_restart;
FP_gesture_update g_fpgesture_update;
FP_frame_bind_buffer g_fpframe_bind_buffer;
FP_create g_fpcreate;
FP_swap_chain_acquire_frame g_fpswap_chain_acquire_frame;
FP_apply_neck_model g_fpapply_neck_model;
FP_get_head_space_from_start_space_rotation g_fpget_head_space_from_start_space_rotation;
FP_get_window_bounds g_fpget_window_bounds;
FP_buffer_viewport_get_source_uv g_fpbuffer_viewport_get_source_uv;
FP_get_screen_target_size g_fpget_screen_target_size;
FP_get_screen_buffer_viewports g_fpget_screen_buffer_viewports;
FP_user_prefs_get_controller_handedness g_fpuser_prefs_get_controller_handedness;
FP_buffer_viewport_list_set_item g_fpbuffer_viewport_list_set_item;
FP_buffer_viewport_set_source_uv g_fpbuffer_viewport_set_source_uv;
FP_buffer_viewport_set_reprojection g_fpbuffer_viewport_set_reprojection;
FP_buffer_viewport_set_source_layer g_fpbuffer_viewport_set_source_layer;
FP_buffer_viewport_get_reprojection g_fpbuffer_viewport_get_reprojection;
FP_swap_chain_get_buffer_count g_fpswap_chain_get_buffer_count;
FP_buffer_viewport_get_source_fov g_fpbuffer_viewport_get_source_fov;
FP_buffer_spec_get_samples g_fpbuffer_spec_get_samples;
FP_buffer_viewport_get_target_eye g_fpbuffer_viewport_get_target_eye;
FP_buffer_spec_get_size g_fpbuffer_spec_get_size;
FP_buffer_viewport_list_get_item g_fpbuffer_viewport_list_get_item;
FP_buffer_viewport_equal g_fpbuffer_viewport_equal;
FP_get_recommended_buffer_viewports g_fpget_recommended_buffer_viewports;
FP_compute_distorted_point g_fpcompute_distorted_point;
FP_set_error g_fpset_error;
FP_set_idle_listener g_fpset_idle_listener;
FP_swap_chain_get_buffer_size g_fpswap_chain_get_buffer_size;
FP_get_eye_from_head_matrix g_fpget_eye_from_head_matrix;
FP_buffer_spec_destroy g_fpbuffer_spec_destroy;
FP_set_display_metrics g_fpset_display_metrics;
FP_set_viewer_params g_fpset_viewer_params;
FP_get_time_point_now g_fpget_time_point_now;
FP_distort_to_screen g_fpdistort_to_screen;
FP_is_feature_supported g_fpis_feature_supported;
FP_initialize_gl g_fpinitialize_gl;
FP_buffer_spec_create g_fpbuffer_spec_create;
FP_buffer_spec_set_size g_fpbuffer_spec_set_size;
FP_buffer_spec_set_depth_stencil_format g_fpbuffer_spec_set_depth_stencil_format;
FP_buffer_spec_set_multiview_layer g_fpbuffer_spec_set_multiview_layer;
FP_buffer_spec_set_samples g_fpbuffer_spec_set_samples;
FP_get_maximum_effective_render_target_size g_fpget_maximum_effective_render_target_size;
FP_bind_default_framebuffer g_fpbind_default_framebuffer;
FP_swap_chain_create g_fpswap_chain_create;
FP_buffer_viewport_destroy g_fpbuffer_viewport_destroy;
FP_destroy g_fpdestroy;
FP_swap_chain_destroy g_fpswap_chain_destroy;
FP_JNI_OnLoad g_fpJNI_OnLoad;
FP_buffer_viewport_list_destroy g_fpbuffer_viewport_list_destroy;
FP_GvrApi_nativeGetWindowBounds g_fpGvrApi_nativeGetWindowBounds;
FP_GvrApi_nativePauseTracking g_fpGvrApi_nativePauseTracking;
FP_GvrApi_nativePauseTrackingGetState g_fpGvrApi_nativePauseTrackingGetState;
FP_GvrApi_nativeGetViewerModel g_fpGvrApi_nativeGetViewerModel;
FP_GvrApi_nativeGetViewerVendor g_fpGvrApi_nativeGetViewerVendor;
FP_GvrApi_nativeGetErrorString g_fpGvrApi_nativeGetErrorString;
FP_GvrApi_nativeComputeDistortedPoint g_fpGvrApi_nativeComputeDistortedPoint;
FP_GvrApi_nativeCreate g_fpGvrApi_nativeCreate;
FP_GvrApi_nativeRequestContextSharing g_fpGvrApi_nativeRequestContextSharing;
FP_GvrApi_nativeSwapChainCreate g_fpGvrApi_nativeSwapChainCreate;
FP_GvrApi_nativeSetViewerParams g_fpGvrApi_nativeSetViewerParams;
FP_GvrApi_nativeSetDefaultViewerProfile g_fpGvrApi_nativeSetDefaultViewerProfile;
FP_GvrApi_nativeResumeTracking g_fpGvrApi_nativeResumeTracking;
FP_GvrApi_nativeResumeTrackingSetState g_fpGvrApi_nativeResumeTrackingSetState;
FP_GvrApi_nativeFrameSubmit g_fpGvrApi_nativeFrameSubmit;
FP_GvrApi_nativeUsingDynamicLibrary g_fpGvrApi_nativeUsingDynamicLibrary;
FP_GvrApi_nativeSetApplicationState g_fpGvrApi_nativeSetApplicationState;
FP_GvrApi_nativeSetDynamicLibraryLoadingEnabled g_fpGvrApi_nativeSetDynamicLibraryLoadingEnabled;
FP_GvrApi_nativeFrameGetBufferSize g_fpGvrApi_nativeFrameGetBufferSize;
FP_GvrApi_nativeFrameGetFramebufferObject g_fpGvrApi_nativeFrameGetFramebufferObject;
FP_GvrApi_nativeFrameUnbind g_fpGvrApi_nativeFrameUnbind;
FP_GvrApi_nativeFrameBindBuffer g_fpGvrApi_nativeFrameBindBuffer;
FP_GvrApi_nativeSwapChainAcquireFrame g_fpGvrApi_nativeSwapChainAcquireFrame;
FP_GvrApi_nativeSwapChainResizeBuffer g_fpGvrApi_nativeSwapChainResizeBuffer;
FP_GvrApi_nativeSwapChainGetBufferSize g_fpGvrApi_nativeSwapChainGetBufferSize;
FP_GvrApi_nativeSwapChainGetBufferCount g_fpGvrApi_nativeSwapChainGetBufferCount;
FP_GvrApi_nativeSwapChainDestroy g_fpGvrApi_nativeSwapChainDestroy;
FP_GvrApi_nativeBufferSpecSetDepthStencilFormat g_fpGvrApi_nativeBufferSpecSetDepthStencilFormat;
FP_GvrApi_nativeBufferSpecSetMultiviewLayers g_fpGvrApi_nativeBufferSpecSetMultiviewLayers;
FP_GvrApi_nativeBufferSpecSetColorFormat g_fpGvrApi_nativeBufferSpecSetColorFormat;
FP_GvrApi_nativeBufferSpecSetSamples g_fpGvrApi_nativeBufferSpecSetSamples;
FP_GvrApi_nativeExternalSurfaceCreate g_fpGvrApi_nativeExternalSurfaceCreate;
FP_GvrApi_nativeExternalSurfaceCreateWithListeners g_fpGvrApi_nativeExternalSurfaceCreateWithListeners;
FP_GvrApi_nativeExternalSurfaceDestroy g_fpGvrApi_nativeExternalSurfaceDestroy;
FP_GvrApi_nativeExternalSurfaceGetId g_fpGvrApi_nativeExternalSurfaceGetId;
FP_GvrApi_nativeExternalSurfaceGetSurface g_fpGvrApi_nativeExternalSurfaceGetSurface;
FP_GvrApi_nativeBufferSpecGetSamples g_fpGvrApi_nativeBufferSpecGetSamples;
FP_GvrApi_nativeBufferSpecSetSize g_fpGvrApi_nativeBufferSpecSetSize;
FP_GvrApi_nativeBufferSpecGetSize g_fpGvrApi_nativeBufferSpecGetSize;
FP_GvrApi_nativeBufferSpecDestroy g_fpGvrApi_nativeBufferSpecDestroy;
FP_GvrApi_nativeBufferSpecCreate g_fpGvrApi_nativeBufferSpecCreate;
FP_GvrApi_nativeBufferViewportEqual g_fpGvrApi_nativeBufferViewportEqual;
FP_GvrApi_nativeBufferViewportSetReprojection g_fpGvrApi_nativeBufferViewportSetReprojection;
FP_GvrApi_nativeBufferViewportSetSourceLayer g_fpGvrApi_nativeBufferViewportSetSourceLayer;
FP_GvrApi_nativeBufferViewportGetReprojection g_fpGvrApi_nativeBufferViewportGetReprojection;
FP_GvrApi_nativeBufferViewportSetExternalSurfaceId g_fpGvrApi_nativeBufferViewportSetExternalSurfaceId;
FP_GvrApi_nativeBufferViewportSetExternalSurface g_fpGvrApi_nativeBufferViewportSetExternalSurface;
FP_GvrApi_nativeBufferViewportGetExternalSurfaceId g_fpGvrApi_nativeBufferViewportGetExternalSurfaceId;
FP_GvrApi_nativeBufferViewportSetSourceBufferIndex g_fpGvrApi_nativeBufferViewportSetSourceBufferIndex;
FP_GvrApi_nativeBufferViewportGetSourceBufferIndex g_fpGvrApi_nativeBufferViewportGetSourceBufferIndex;
FP_GvrApi_nativeBufferViewportSetTargetEye g_fpGvrApi_nativeBufferViewportSetTargetEye;
FP_GvrApi_nativeBufferViewportGetTargetEye g_fpGvrApi_nativeBufferViewportGetTargetEye;
FP_GvrApi_nativeBufferViewportSetTransform g_fpGvrApi_nativeBufferViewportSetTransform;
FP_GvrApi_nativeBufferViewportGetTransform g_fpGvrApi_nativeBufferViewportGetTransform;
FP_GvrApi_nativeBufferViewportSetSourceFov g_fpGvrApi_nativeBufferViewportSetSourceFov;
FP_GvrApi_nativeBufferViewportGetSourceFov g_fpGvrApi_nativeBufferViewportGetSourceFov;
FP_GvrApi_nativeBufferViewportSetSourceUv g_fpGvrApi_nativeBufferViewportSetSourceUv;
FP_GvrApi_nativeBufferViewportGetSourceUv g_fpGvrApi_nativeBufferViewportGetSourceUv;
FP_GvrApi_nativeBufferViewportDestroy g_fpGvrApi_nativeBufferViewportDestroy;
FP_GvrApi_nativeReleaseGvrContext g_fpGvrApi_nativeReleaseGvrContext;
FP_GvrApi_nativeResume g_fpGvrApi_nativeResume;
FP_GvrApi_nativePause g_fpGvrApi_nativePause;
FP_GvrApi_nativeUserPrefsGetControllerHandedness g_fpGvrApi_nativeUserPrefsGetControllerHandedness;
FP_GvrApi_nativeUserPrefsGetPerformanceMonitoringEnabled g_fpGvrApi_nativeUserPrefsGetPerformanceMonitoringEnabled;
FP_GvrApi_nativeUserPrefsGetPerformanceHudEnabled g_fpGvrApi_nativeUserPrefsGetPerformanceHudEnabled;
FP_GvrApi_nativeGetUserPrefs g_fpGvrApi_nativeGetUserPrefs;
FP_GvrApi_nativeClearError g_fpGvrApi_nativeClearError;
FP_GvrApi_nativeGetError g_fpGvrApi_nativeGetError;
FP_GvrApi_nativeGetRecommendedBufferViewports g_fpGvrApi_nativeGetRecommendedBufferViewports;
FP_GvrApi_nativeOnSurfaceCreatedReprojectionThread g_fpGvrApi_nativeOnSurfaceCreatedReprojectionThread;
FP_GvrApi_nativeOnSurfaceChangedReprojectionThread g_fpGvrApi_nativeOnSurfaceChangedReprojectionThread;
FP_GvrApi_nativeInitializeGl g_fpGvrApi_nativeInitializeGl;
FP_GvrApi_nativeDumpDebugData g_fpGvrApi_nativeDumpDebugData;
FP_DisplaySynchronizer_nativeDestroy g_fpDisplaySynchronizer_nativeDestroy;
FP_DisplaySynchronizer_nativeCreate g_fpDisplaySynchronizer_nativeCreate;
FP_DisplaySynchronizer_nativeUpdate g_fpDisplaySynchronizer_nativeUpdate;
FP_ExternalSurfaceManager_nativeUpdateSurface g_fpExternalSurfaceManager_nativeUpdateSurface;
FP_DisplaySynchronizer_nativeReset g_fpDisplaySynchronizer_nativeReset;
FP_GvrApi_nativeSetDisplayMetrics g_fpGvrApi_nativeSetDisplayMetrics;
FP_GvrApi_nativeReconnectSensors g_fpGvrApi_nativeReconnectSensors;
FP_GvrApi_nativeSetIdleListener g_fpGvrApi_nativeSetIdleListener;
FP_GvrApi_nativeGetAsyncReprojectionEnabled g_fpGvrApi_nativeGetAsyncReprojectionEnabled;
FP_GvrApi_nativeIsFeatureSupported g_fpGvrApi_nativeIsFeatureSupported;
FP_GvrApi_nativeSetLensOffset g_fpGvrApi_nativeSetLensOffset;
FP_GvrApi_nativeSetSurfaceSize g_fpGvrApi_nativeSetSurfaceSize;
FP_GvrApi_nativeGetBorderSizeMeters g_fpGvrApi_nativeGetBorderSizeMeters;
FP_GvrApi_nativeBufferViewportListDestroy g_fpGvrApi_nativeBufferViewportListDestroy;
FP_GvrApi_nativeBufferViewportListCreate g_fpGvrApi_nativeBufferViewportListCreate;
FP_GvrApi_nativeUsingVrDisplayService g_fpGvrApi_nativeUsingVrDisplayService;
FP_GvrApi_nativeBufferViewportCreate g_fpGvrApi_nativeBufferViewportCreate;
FP_GvrApi_nativeBufferViewportListSetItem g_fpGvrApi_nativeBufferViewportListSetItem;
FP_GvrApi_nativeBufferViewportListGetItem g_fpGvrApi_nativeBufferViewportListGetItem;
FP_GvrApi_nativeBufferViewportListGetSize g_fpGvrApi_nativeBufferViewportListGetSize;
FP_GvrApi_nativeDistortToScreen g_fpGvrApi_nativeDistortToScreen;
FP_GvrApi_nativeGetScreenTargetSize g_fpGvrApi_nativeGetScreenTargetSize;
FP_GvrApi_nativeGetMaximumEffectiveRenderTargetSize g_fpGvrApi_nativeGetMaximumEffectiveRenderTargetSize;
FP_GvrApi_nativeGetScreenBufferViewports g_fpGvrApi_nativeGetScreenBufferViewports;
FP_GvrApi_nativeSetDefaultFramebufferActive g_fpGvrApi_nativeSetDefaultFramebufferActive;
FP_GvrApi_nativeOnPauseReprojectionThread g_fpGvrApi_nativeOnPauseReprojectionThread;
FP_GvrApi_nativeRenderReprojectionThread g_fpGvrApi_nativeRenderReprojectionThread;
FP_GvrApi_nativeResetTracking g_fpGvrApi_nativeResetTracking;
FP_GvrApi_nativeSetIgnoreManualPauseResumeTracker g_fpGvrApi_nativeSetIgnoreManualPauseResumeTracker;
FP_GvrApi_nativeGetHeadSpaceFromStartSpaceRotation g_fpGvrApi_nativeGetHeadSpaceFromStartSpaceRotation;
FP_GvrApi_nativeSetAsyncReprojectionEnabled g_fpGvrApi_nativeSetAsyncReprojectionEnabled;
FP_GvrApi_nativeGetViewerType g_fpGvrApi_nativeGetViewerType;
FP_GvrApi_nativeGetEyeFromHeadMatrix g_fpGvrApi_nativeGetEyeFromHeadMatrix;
FP_GvrApi_nativeRecenterTracking g_fpGvrApi_nativeRecenterTracking;
FP_VrParamsProviderJni_nativeUpdateNativePhoneParamsPointer g_fpVrParamsProviderJni_nativeUpdateNativePhoneParamsPointer;
FP_MirthNet_setHttpProxy g_fpMirthNet_setHttpProxy;
FP_NativeCallbacks_handleServiceDisconnected g_fpNativeCallbacks_handleServiceDisconnected;
FP_NativeCallbacks_handleServiceConnected g_fpNativeCallbacks_handleServiceConnected;
FP_NativeCallbacks_handleServiceUnavailable g_fpNativeCallbacks_handleServiceUnavailable;
FP_NativeCallbacks_handleServiceFailed g_fpNativeCallbacks_handleServiceFailed;
FP_NativeCallbacks_handleServiceInitFailed g_fpNativeCallbacks_handleServiceInitFailed;
FP_NativeCallbacks_handleGyroEvent g_fpNativeCallbacks_handleGyroEvent;
FP_NativeCallbacks_handleAccelEvent g_fpNativeCallbacks_handleAccelEvent;
FP_NativeCallbacks_handleBatteryEvent g_fpNativeCallbacks_handleBatteryEvent;
FP_NativeCallbacks_handleButtonEvent g_fpNativeCallbacks_handleButtonEvent;
FP_NativeCallbacks_handleOrientationEvent g_fpNativeCallbacks_handleOrientationEvent;
FP_NativeCallbacks_handleTouchEvent g_fpNativeCallbacks_handleTouchEvent;
FP_NativeCallbacks_handleControllerRecentered g_fpNativeCallbacks_handleControllerRecentered;
FP_NativeCallbacks_handleStateChanged g_fpNativeCallbacks_handleStateChanged;
FP_CardboardViewNativeImpl_nativeInit g_fpCardboardViewNativeImpl_nativeInit;
FP_CardboardViewNativeImpl_nativeGetCurrentEyeParams g_fpCardboardViewNativeImpl_nativeGetCurrentEyeParams;
FP_CardboardViewNativeImpl_nativeSetRenderer g_fpCardboardViewNativeImpl_nativeSetRenderer;
FP_CardboardViewNativeImpl_nativeSetStereoRenderer g_fpCardboardViewNativeImpl_nativeSetStereoRenderer;
FP_CardboardViewNativeImpl_nativeSetGvrViewerParams g_fpCardboardViewNativeImpl_nativeSetGvrViewerParams;
FP_CardboardViewNativeImpl_nativeLogEvent g_fpCardboardViewNativeImpl_nativeLogEvent;
FP_CardboardViewNativeImpl_nativeSetApplicationState g_fpCardboardViewNativeImpl_nativeSetApplicationState;
FP_CardboardViewNativeImpl_nativeSetScreenParams g_fpCardboardViewNativeImpl_nativeSetScreenParams;
FP_CardboardViewNativeImpl_nativeSetNeckModelFactor g_fpCardboardViewNativeImpl_nativeSetNeckModelFactor;
FP_CardboardViewNativeImpl_nativeGetNeckModelFactor  g_fpCardboardViewNativeImpl_nativeGetNeckModelFactor;
FP_CardboardViewNativeImpl_nativeOnDrawFrame  g_fpCardboardViewNativeImpl_nativeOnDrawFrame;
FP_CardboardViewNativeImpl_nativeSetNeckModelEnabled  g_fpCardboardViewNativeImpl_nativeSetNeckModelEnabled;
FP_CardboardViewNativeImpl_nativeDestroy g_fpCardboardViewNativeImpl_nativeDestroy;
FP_CardboardViewNativeImpl_nativeOnSurfaceCreated g_fpCardboardViewNativeImpl_nativeOnSurfaceCreated;
FP_CardboardViewNativeImpl_nativeOnSurfaceChanged g_fpCardboardViewNativeImpl_nativeOnSurfaceChanged;
FP_CardboardViewNativeImpl_nativeSetStereoModeEnabled g_fpCardboardViewNativeImpl_nativeSetStereoModeEnabled;
FP_CardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled g_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled;
FP_CardboardViewNativeImpl_nativeSetDistortionCorrectionScale g_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionScale;
FP_CardboardViewNativeImpl_nativeSetMultisampling g_fpCardboardViewNativeImpl_nativeSetMultisampling;
FP_CardboardViewNativeImpl_nativeSetDepthStencilFormat g_fpCardboardViewNativeImpl_nativeSetDepthStencilFormat;


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
    if( g_bInit )
        return g_bInit;

//        const char *filename = "/data/data/com.mj.test/lib/libgvrimpl.so";
//        const char *filename = "/data/data/com.Company.Daydream.Controller/lib/libgvrimpl.so";
    const char *filename = "libgvrimpl.so";
//        const char *filename = "/sdcard/libgvrimpl.so";
    is_file_exist(filename);
    g_hDLL = dlopen(filename, RTLD_LAZY);
    if( g_hDLL == nullptr)
    {
        LOGE( "dlopen err:%s.\n",dlerror());
    }
    if (g_hDLL)
    {
        GET_DLL_FUNCION(g_hDLL,create_with_tracker_for_testing);
        GET_DLL_FUNCION(g_hDLL,tracker_state_create);
        GET_DLL_FUNCION(g_hDLL,pause_tracking_get_state);
        GET_DLL_FUNCION(g_hDLL,resume_tracking_set_state);
        GET_DLL_FUNCION(g_hDLL,tracker_state_destroy);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_last_button_timestamp);
        GET_DLL_FUNCION(g_hDLL,render_reprojection_thread);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_last_touch_timestamp);
        GET_DLL_FUNCION(g_hDLL,on_surface_created_reprojection_thread);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_last_accel_timestamp);
        GET_DLL_FUNCION(g_hDLL,set_async_reprojection_enabled);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_last_gyro_timestamp);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_last_orientation_timestamp);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_last_battery_timestamp);
        GET_DLL_FUNCION(g_hDLL,remove_all_surfaces_reprojection_thread);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_button_up);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_button_down);
        GET_DLL_FUNCION(g_hDLL,update_surface_reprojection_thread);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_button_state);
        GET_DLL_FUNCION(g_hDLL,on_pause_reprojection_thread);
        GET_DLL_FUNCION(g_hDLL,on_surface_changed_reprojection_thread);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_recentering);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_recentered);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_touch_up);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_touch_down);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_touch_pos);
        GET_DLL_FUNCION(g_hDLL,controller_state_is_touching);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_accel);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_battery_charging);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_battery_level);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_gyro);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_orientation);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_connection_state);
        GET_DLL_FUNCION(g_hDLL,controller_state_get_api_status);
        GET_DLL_FUNCION(g_hDLL,controller_state_update);
        GET_DLL_FUNCION(g_hDLL,controller_state_destroy);
        GET_DLL_FUNCION(g_hDLL,controller_state_create);
        GET_DLL_FUNCION(g_hDLL,controller_button_to_string);
        GET_DLL_FUNCION(g_hDLL,display_synchronizer_update);
        GET_DLL_FUNCION(g_hDLL,controller_connection_state_to_string);
        GET_DLL_FUNCION(g_hDLL,controller_api_status_to_string);
        GET_DLL_FUNCION(g_hDLL,controller_battery_level_to_string);
        GET_DLL_FUNCION(g_hDLL,display_synchronizer_reset);
        GET_DLL_FUNCION(g_hDLL,controller_resume);
        GET_DLL_FUNCION(g_hDLL,set_ignore_manual_tracker_pause_resume);
        GET_DLL_FUNCION(g_hDLL,controller_pause);
        GET_DLL_FUNCION(g_hDLL,set_display_synchronizer);
        GET_DLL_FUNCION(g_hDLL,controller_destroy);
        GET_DLL_FUNCION(g_hDLL,controller_create_and_init_android);
        GET_DLL_FUNCION(g_hDLL,pause);
        GET_DLL_FUNCION(g_hDLL,tracker_state_get_buffer);
        GET_DLL_FUNCION(g_hDLL,controller_create_and_init);
        GET_DLL_FUNCION(g_hDLL,tracker_state_get_buffer_size);
        GET_DLL_FUNCION(g_hDLL,using_vr_display_service);
        GET_DLL_FUNCION(g_hDLL,controller_get_default_options);
        GET_DLL_FUNCION(g_hDLL,dump_debug_data);
        GET_DLL_FUNCION(g_hDLL,external_surface_create_with_listeners);
        GET_DLL_FUNCION(g_hDLL,external_surface_destroy);
        GET_DLL_FUNCION(g_hDLL,external_surface_get_surface);
        GET_DLL_FUNCION(g_hDLL,external_surface_get_surface_id);
        GET_DLL_FUNCION(g_hDLL,using_dynamic_library);
        GET_DLL_FUNCION(g_hDLL,resume);
        GET_DLL_FUNCION(g_hDLL,set_lens_offset);
        GET_DLL_FUNCION(g_hDLL,reconnect_sensors);
        GET_DLL_FUNCION(g_hDLL,set_display_output_rotation);
        GET_DLL_FUNCION(g_hDLL,get_surface_size);
        GET_DLL_FUNCION(g_hDLL,check_surface_size_changed);
        GET_DLL_FUNCION(g_hDLL,get_border_size_meters);
        GET_DLL_FUNCION(g_hDLL,get_button_long_press);
        GET_DLL_FUNCION(g_hDLL,display_synchronizer_destroy);
        GET_DLL_FUNCION(g_hDLL,display_synchronizer_create);
        GET_DLL_FUNCION(g_hDLL,refresh_viewer_profile);
        GET_DLL_FUNCION(g_hDLL,set_default_viewer_profile);
        GET_DLL_FUNCION(g_hDLL,recenter_tracking);
        GET_DLL_FUNCION(g_hDLL,reset_tracking);
        GET_DLL_FUNCION(g_hDLL,resume_tracking);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_set_source_fov);
        GET_DLL_FUNCION(g_hDLL,pause_tracking);
        GET_DLL_FUNCION(g_hDLL,frame_get_framebuffer_object);
        GET_DLL_FUNCION(g_hDLL,frame_get_buffer_size);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_set_target_eye);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_set_transform);
        GET_DLL_FUNCION(g_hDLL,buffer_spec_set_color_format);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_get_transform);
        GET_DLL_FUNCION(g_hDLL,set_surface_size);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_set_external_surface_id);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_get_external_surface_id);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_list_get_size);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_set_source_buffer_index);
        GET_DLL_FUNCION(g_hDLL,get_async_reprojection_enabled);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_get_source_buffer_index);
        GET_DLL_FUNCION(g_hDLL,get_error_string);
        GET_DLL_FUNCION(g_hDLL,clear_error);
        GET_DLL_FUNCION(g_hDLL,get_viewer_type);
        GET_DLL_FUNCION(g_hDLL,get_error);
        GET_DLL_FUNCION(g_hDLL,get_viewer_model);
        GET_DLL_FUNCION(g_hDLL,get_version_string);
        GET_DLL_FUNCION(g_hDLL,get_viewer_vendor);
        GET_DLL_FUNCION(g_hDLL,get_version);
        GET_DLL_FUNCION(g_hDLL,set_back_gesture_event_handler);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_create);
        GET_DLL_FUNCION(g_hDLL,get_user_prefs);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_list_create);
        GET_DLL_FUNCION(g_hDLL,swap_chain_resize_buffer);
        GET_DLL_FUNCION(g_hDLL,frame_submit);
        GET_DLL_FUNCION(g_hDLL,frame_unbind);
        GET_DLL_FUNCION(g_hDLL,gesture_context_create);
        GET_DLL_FUNCION(g_hDLL,gesture_context_destroy);
        GET_DLL_FUNCION(g_hDLL,gesture_get);
        GET_DLL_FUNCION(g_hDLL, gesture_get_count);
        GET_DLL_FUNCION(g_hDLL,gesture_get_direction);
        GET_DLL_FUNCION(g_hDLL,gesture_get_displacement);
        GET_DLL_FUNCION(g_hDLL,gesture_get_type);
        GET_DLL_FUNCION(g_hDLL,gesture_get_velocity);
        GET_DLL_FUNCION(g_hDLL,gesture_restart);
        GET_DLL_FUNCION(g_hDLL,gesture_update);
        GET_DLL_FUNCION(g_hDLL,frame_bind_buffer);
        GET_DLL_FUNCION(g_hDLL,create);
        GET_DLL_FUNCION(g_hDLL,swap_chain_acquire_frame);
        GET_DLL_FUNCION(g_hDLL,apply_neck_model);
        GET_DLL_FUNCION(g_hDLL,get_head_space_from_start_space_rotation);
        GET_DLL_FUNCION(g_hDLL,get_window_bounds);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_get_source_uv);
        GET_DLL_FUNCION(g_hDLL,get_screen_target_size);
        GET_DLL_FUNCION(g_hDLL,get_screen_buffer_viewports);
        GET_DLL_FUNCION(g_hDLL,user_prefs_get_controller_handedness);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_list_set_item);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_set_source_uv);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_set_reprojection);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_get_reprojection);
        GET_DLL_FUNCION(g_hDLL, buffer_viewport_set_source_layer);
        GET_DLL_FUNCION(g_hDLL,swap_chain_get_buffer_count);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_get_source_fov);
        GET_DLL_FUNCION(g_hDLL,buffer_spec_get_samples);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_get_target_eye);
        GET_DLL_FUNCION(g_hDLL,buffer_spec_get_size);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_list_get_item);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_equal);
        GET_DLL_FUNCION(g_hDLL,get_recommended_buffer_viewports);
        GET_DLL_FUNCION(g_hDLL,compute_distorted_point);
        GET_DLL_FUNCION(g_hDLL,set_error);
        GET_DLL_FUNCION(g_hDLL,set_idle_listener);
        GET_DLL_FUNCION(g_hDLL,swap_chain_get_buffer_size);
        GET_DLL_FUNCION(g_hDLL,get_eye_from_head_matrix);
        GET_DLL_FUNCION(g_hDLL,buffer_spec_destroy);
        GET_DLL_FUNCION(g_hDLL,set_display_metrics);
        GET_DLL_FUNCION(g_hDLL,set_viewer_params);
        GET_DLL_FUNCION(g_hDLL,get_time_point_now);
        GET_DLL_FUNCION(g_hDLL,distort_to_screen);
        GET_DLL_FUNCION(g_hDLL, is_feature_supported);
        GET_DLL_FUNCION(g_hDLL,initialize_gl);
        GET_DLL_FUNCION(g_hDLL,buffer_spec_create);
        GET_DLL_FUNCION(g_hDLL,buffer_spec_set_size);
        GET_DLL_FUNCION(g_hDLL,buffer_spec_set_depth_stencil_format);
        GET_DLL_FUNCION(g_hDLL, buffer_spec_set_multiview_layer);
        GET_DLL_FUNCION(g_hDLL,buffer_spec_set_samples);
        GET_DLL_FUNCION(g_hDLL,get_maximum_effective_render_target_size);
        GET_DLL_FUNCION(g_hDLL,bind_default_framebuffer);
        GET_DLL_FUNCION(g_hDLL,swap_chain_create);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_destroy);
        GET_DLL_FUNCION(g_hDLL,destroy);
        GET_DLL_FUNCION(g_hDLL,swap_chain_destroy);
        GET_DLL_FUNCION(g_hDLL, JNI_OnLoad);
        GET_DLL_FUNCION(g_hDLL,buffer_viewport_list_destroy);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeGetWindowBounds);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativePauseTracking);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativePauseTrackingGetState);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeGetViewerModel);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeGetViewerVendor);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeGetErrorString);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeComputeDistortedPoint);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeCreate);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeRequestContextSharing);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeSwapChainCreate);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeSetViewerParams);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeSetDefaultViewerProfile);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeResumeTracking);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeResumeTrackingSetState);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeFrameSubmit);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeUsingDynamicLibrary);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeSetApplicationState);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeSetDynamicLibraryLoadingEnabled);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeFrameGetBufferSize);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeFrameGetFramebufferObject);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeFrameUnbind);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeFrameBindBuffer);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeSwapChainAcquireFrame);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeSwapChainResizeBuffer);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeSwapChainGetBufferSize);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeSwapChainGetBufferCount);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeSwapChainDestroy);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferSpecSetDepthStencilFormat);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferSpecSetMultiviewLayers);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferSpecSetColorFormat);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferSpecSetSamples);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeExternalSurfaceCreateWithListeners);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeExternalSurfaceDestroy);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeExternalSurfaceGetId);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeExternalSurfaceGetSurface);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferSpecGetSamples);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferSpecSetSize);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferSpecGetSize);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferSpecDestroy);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferSpecCreate);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportEqual);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportSetReprojection);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportSetSourceLayer);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportGetReprojection);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportSetExternalSurfaceId);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportSetExternalSurface);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportGetExternalSurfaceId);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportSetSourceBufferIndex);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportGetSourceBufferIndex);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportSetTargetEye);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportGetTargetEye);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportSetTransform);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportGetTransform);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportSetSourceFov);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportGetSourceFov);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportSetSourceUv);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportGetSourceUv);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportDestroy);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeReleaseGvrContext);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeResume);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativePause);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeUserPrefsGetControllerHandedness);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeGetUserPrefs);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeClearError);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeGetError);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeGetRecommendedBufferViewports);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeOnSurfaceCreatedReprojectionThread);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeOnSurfaceChangedReprojectionThread);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeInitializeGl);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeDumpDebugData);
        GET_DLL_FUNCION(g_hDLL,DisplaySynchronizer_nativeDestroy);
        GET_DLL_FUNCION(g_hDLL,DisplaySynchronizer_nativeCreate);
        GET_DLL_FUNCION(g_hDLL,DisplaySynchronizer_nativeUpdate);
        GET_DLL_FUNCION(g_hDLL,ExternalSurfaceManager_nativeUpdateSurface);
        GET_DLL_FUNCION(g_hDLL,DisplaySynchronizer_nativeReset);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeSetDisplayMetrics);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeReconnectSensors);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeSetIdleListener);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeGetAsyncReprojectionEnabled);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeIsFeatureSupported);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeSetLensOffset);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeSetSurfaceSize);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeGetBorderSizeMeters);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportListDestroy);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportListCreate);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeUsingVrDisplayService);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportCreate);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportListSetItem);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportListGetItem);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeBufferViewportListGetSize);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeDistortToScreen);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeGetScreenTargetSize);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeGetMaximumEffectiveRenderTargetSize);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeGetScreenBufferViewports);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeSetDefaultFramebufferActive);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeOnPauseReprojectionThread);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeRenderReprojectionThread);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeResetTracking);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeSetIgnoreManualPauseResumeTracker);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeGetHeadSpaceFromStartSpaceRotation);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeSetAsyncReprojectionEnabled);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeGetViewerType);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeGetEyeFromHeadMatrix);
        GET_DLL_FUNCION(g_hDLL,GvrApi_nativeRecenterTracking);
        GET_DLL_FUNCION(g_hDLL,VrParamsProviderJni_nativeUpdateNativePhoneParamsPointer);
        GET_DLL_FUNCION(g_hDLL,MirthNet_setHttpProxy);
        GET_DLL_FUNCION(g_hDLL,NativeCallbacks_handleServiceDisconnected);
        GET_DLL_FUNCION(g_hDLL,NativeCallbacks_handleServiceConnected);
        GET_DLL_FUNCION(g_hDLL,NativeCallbacks_handleServiceUnavailable);
        GET_DLL_FUNCION(g_hDLL,NativeCallbacks_handleServiceFailed);
        GET_DLL_FUNCION(g_hDLL,NativeCallbacks_handleServiceInitFailed);
        GET_DLL_FUNCION(g_hDLL,NativeCallbacks_handleGyroEvent);
        GET_DLL_FUNCION(g_hDLL,NativeCallbacks_handleAccelEvent);
        GET_DLL_FUNCION(g_hDLL,NativeCallbacks_handleBatteryEvent);
        GET_DLL_FUNCION(g_hDLL,NativeCallbacks_handleButtonEvent);
        GET_DLL_FUNCION(g_hDLL,NativeCallbacks_handleOrientationEvent);
        GET_DLL_FUNCION(g_hDLL,NativeCallbacks_handleTouchEvent);
        GET_DLL_FUNCION(g_hDLL,NativeCallbacks_handleControllerRecentered);
        GET_DLL_FUNCION(g_hDLL,NativeCallbacks_handleStateChanged);
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeInit);
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeGetCurrentEyeParams);
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeSetRenderer);
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeSetStereoRenderer);
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeSetGvrViewerParams);
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeLogEvent);
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeSetApplicationState);
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeSetScreenParams);
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeSetNeckModelFactor);
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeGetNeckModelFactor );
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeOnDrawFrame );
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeSetNeckModelEnabled );
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeDestroy);
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeOnSurfaceCreated);
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeOnSurfaceChanged);
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeSetStereoModeEnabled);
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled);
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeSetDistortionCorrectionScale);
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeSetMultisampling);
        GET_DLL_FUNCION(g_hDLL,CardboardViewNativeImpl_nativeSetDepthStencilFormat);

        if (g_fpcreate_with_tracker_for_testing!= NULL
            && g_fptracker_state_create!= NULL
            && g_fppause_tracking_get_state!= NULL
            && g_fpresume_tracking_set_state!= NULL
            && g_fptracker_state_destroy!= NULL
            && g_fpcontroller_state_get_last_button_timestamp!= NULL
            && g_fprender_reprojection_thread!= NULL
            && g_fpcontroller_state_get_last_touch_timestamp!= NULL
            && g_fpon_surface_created_reprojection_thread!= NULL
            && g_fpcontroller_state_get_last_accel_timestamp!= NULL
            && g_fpset_async_reprojection_enabled!= NULL
            && g_fpcontroller_state_get_last_gyro_timestamp!= NULL
            && g_fpcontroller_state_get_last_orientation_timestamp!= NULL
            && g_fpcontroller_state_get_last_battery_timestamp!= NULL
            && g_fpremove_all_surfaces_reprojection_thread!= NULL
            && g_fpcontroller_state_get_button_up!= NULL
            && g_fpcontroller_state_get_button_down!= NULL
            && g_fpupdate_surface_reprojection_thread!= NULL
            && g_fpcontroller_state_get_button_state!= NULL
            && g_fpon_pause_reprojection_thread!= NULL
            && g_fpon_surface_changed_reprojection_thread!= NULL
            && g_fpcontroller_state_get_recentering!= NULL
            && g_fpcontroller_state_get_recentered!= NULL
            && g_fpcontroller_state_get_touch_up!= NULL
            && g_fpcontroller_state_get_touch_down!= NULL
            && g_fpcontroller_state_get_touch_pos!= NULL
            && g_fpcontroller_state_is_touching!= NULL
            && g_fpcontroller_state_get_accel!= NULL
            && g_fpcontroller_state_get_battery_charging!= NULL
            && g_fpcontroller_state_get_battery_level!= NULL
            && g_fpcontroller_state_get_gyro!= NULL
            && g_fpcontroller_state_get_orientation!= NULL
            && g_fpcontroller_state_get_connection_state!= NULL
            && g_fpcontroller_state_get_api_status!= NULL
            && g_fpcontroller_state_update!= NULL
            && g_fpcontroller_state_destroy!= NULL
            && g_fpcontroller_state_create!= NULL
            && g_fpcontroller_button_to_string!= NULL
            && g_fpdisplay_synchronizer_update!= NULL
            && g_fpcontroller_connection_state_to_string!= NULL
            && g_fpcontroller_api_status_to_string!= NULL
            && g_fpcontroller_battery_level_to_string!= NULL
            && g_fpdisplay_synchronizer_reset!= NULL
            && g_fpcontroller_resume!= NULL
            && g_fpset_ignore_manual_tracker_pause_resume!= NULL
            && g_fpcontroller_pause!= NULL
            && g_fpset_display_synchronizer!= NULL
            && g_fpcontroller_destroy!= NULL
            && g_fpcontroller_create_and_init_android!= NULL
            && g_fppause!= NULL
            && g_fptracker_state_get_buffer!= NULL
            && g_fpcontroller_create_and_init!= NULL
            && g_fptracker_state_get_buffer_size!= NULL
            && g_fpusing_vr_display_service!= NULL
            && g_fpcontroller_get_default_options!= NULL
            && g_fpdump_debug_data!= NULL
            && g_fpexternal_surface_create_with_listeners!= NULL
            && g_fpexternal_surface_destroy!= NULL
            && g_fpexternal_surface_get_surface!= NULL
            && g_fpexternal_surface_get_surface_id!= NULL
            && g_fpusing_dynamic_library!= NULL
            && g_fpresume!= NULL
            && g_fpset_lens_offset!= NULL
            && g_fpreconnect_sensors!= NULL
            && g_fpset_display_output_rotation!= NULL
            && g_fpget_surface_size!= NULL
            && g_fpcheck_surface_size_changed!= NULL
            && g_fpget_border_size_meters!= NULL
            && g_fpget_button_long_press!= NULL
            && g_fpdisplay_synchronizer_destroy!= NULL
            && g_fpdisplay_synchronizer_create!= NULL
            && g_fprefresh_viewer_profile!= NULL
            && g_fpset_default_viewer_profile!= NULL
            && g_fprecenter_tracking!= NULL
            && g_fpreset_tracking!= NULL
            && g_fpresume_tracking!= NULL
            && g_fpbuffer_viewport_set_source_fov!= NULL
            && g_fppause_tracking!= NULL
            && g_fpframe_get_framebuffer_object!= NULL
            && g_fpframe_get_buffer_size!= NULL
            && g_fpbuffer_viewport_set_target_eye!= NULL
            && g_fpbuffer_viewport_set_transform!= NULL
            && g_fpbuffer_spec_set_color_format!= NULL
            && g_fpbuffer_viewport_get_transform!= NULL
            && g_fpset_surface_size!= NULL
            && g_fpbuffer_viewport_set_external_surface_id!= NULL
            && g_fpbuffer_viewport_get_external_surface_id!= NULL
            && g_fpbuffer_viewport_list_get_size!= NULL
            && g_fpbuffer_viewport_set_source_buffer_index!= NULL
            && g_fpget_async_reprojection_enabled!= NULL
            && g_fpbuffer_viewport_get_source_buffer_index!= NULL
            && g_fpget_error_string!= NULL
            && g_fpclear_error!= NULL
            && g_fpget_viewer_type!= NULL
            && g_fpget_error!= NULL
            && g_fpget_viewer_model!= NULL
            && g_fpget_version_string!= NULL
            && g_fpget_viewer_vendor!= NULL
            && g_fpget_version!= NULL
            && g_fpset_back_gesture_event_handler!= NULL
            && g_fpbuffer_viewport_create!= NULL
            && g_fpget_user_prefs!= NULL
            && g_fpbuffer_viewport_list_create!= NULL
            && g_fpswap_chain_resize_buffer!= NULL
            && g_fpframe_submit!= NULL
            && g_fpframe_unbind!= NULL
            && g_fpgesture_context_create!= NULL
            && g_fpgesture_context_destroy!= NULL
            && g_fpgesture_get!= NULL
            && g_fpgesture_get_count!= NULL
            && g_fpgesture_get_direction!= NULL
            && g_fpgesture_get_displacement!= NULL
            && g_fpgesture_get_type!= NULL
            && g_fpgesture_get_velocity!= NULL
            && g_fpgesture_restart!= NULL
            && g_fpgesture_update!= NULL
            && g_fpframe_bind_buffer!= NULL
            && g_fpcreate!= NULL
            && g_fpswap_chain_acquire_frame!= NULL
            && g_fpapply_neck_model!= NULL
            && g_fpget_head_space_from_start_space_rotation!= NULL
            && g_fpget_window_bounds!= NULL
            && g_fpbuffer_viewport_get_source_uv!= NULL
            && g_fpget_screen_target_size!= NULL
            && g_fpget_screen_buffer_viewports!= NULL
            && g_fpuser_prefs_get_controller_handedness!= NULL
            && g_fpbuffer_viewport_list_set_item!= NULL
            && g_fpbuffer_viewport_set_source_uv!= NULL
            && g_fpbuffer_viewport_set_reprojection!= NULL
            && g_fpbuffer_viewport_get_reprojection!= NULL
            && g_fpbuffer_viewport_set_source_layer!= NULL
            && g_fpswap_chain_get_buffer_count!= NULL
            && g_fpbuffer_viewport_get_source_fov!= NULL
            && g_fpbuffer_spec_get_samples!= NULL
            && g_fpbuffer_viewport_get_target_eye!= NULL
            && g_fpbuffer_spec_get_size!= NULL
            && g_fpbuffer_viewport_list_get_item!= NULL
            && g_fpbuffer_viewport_equal!= NULL
            && g_fpget_recommended_buffer_viewports!= NULL
            && g_fpcompute_distorted_point!= NULL
            && g_fpset_error!= NULL
            && g_fpset_idle_listener!= NULL
            && g_fpswap_chain_get_buffer_size!= NULL
            && g_fpget_eye_from_head_matrix!= NULL
            && g_fpbuffer_spec_destroy!= NULL
            && g_fpset_display_metrics!= NULL
            && g_fpset_viewer_params!= NULL
            && g_fpget_time_point_now!= NULL
            && g_fpdistort_to_screen!= NULL
            && g_fpis_feature_supported!= NULL
            && g_fpinitialize_gl!= NULL
            && g_fpbuffer_spec_create!= NULL
            && g_fpbuffer_spec_set_size!= NULL
            && g_fpbuffer_spec_set_depth_stencil_format!= NULL
            && g_fpbuffer_spec_set_multiview_layer!= NULL
            && g_fpbuffer_spec_set_samples!= NULL
            && g_fpget_maximum_effective_render_target_size!= NULL
            && g_fpbind_default_framebuffer!= NULL
            && g_fpswap_chain_create!= NULL
            && g_fpbuffer_viewport_destroy!= NULL
            && g_fpdestroy!= NULL
            && g_fpswap_chain_destroy!= NULL
            && g_fpJNI_OnLoad != NULL
            && g_fpbuffer_viewport_list_destroy!= NULL
            && g_fpGvrApi_nativeGetWindowBounds!= NULL
            && g_fpGvrApi_nativePauseTracking!= NULL
            && g_fpGvrApi_nativePauseTrackingGetState!= NULL
            && g_fpGvrApi_nativeGetViewerModel!= NULL
            && g_fpGvrApi_nativeGetViewerVendor!= NULL
            && g_fpGvrApi_nativeGetErrorString!= NULL
            && g_fpGvrApi_nativeComputeDistortedPoint!= NULL
            && g_fpGvrApi_nativeCreate!= NULL
            && g_fpGvrApi_nativeRequestContextSharing!= NULL
            && g_fpGvrApi_nativeSwapChainCreate!= NULL
            && g_fpGvrApi_nativeSetViewerParams!= NULL
            && g_fpGvrApi_nativeSetDefaultViewerProfile!= NULL
            && g_fpGvrApi_nativeResumeTracking!= NULL
            && g_fpGvrApi_nativeResumeTrackingSetState!= NULL
            && g_fpGvrApi_nativeFrameSubmit!= NULL
            && g_fpGvrApi_nativeUsingDynamicLibrary!= NULL
            && g_fpGvrApi_nativeSetApplicationState!=NULL
            && g_fpGvrApi_nativeSetDynamicLibraryLoadingEnabled!=NULL
            && g_fpGvrApi_nativeFrameGetBufferSize!= NULL
            && g_fpGvrApi_nativeFrameGetFramebufferObject!= NULL
            && g_fpGvrApi_nativeFrameUnbind!= NULL
            && g_fpGvrApi_nativeFrameBindBuffer!= NULL
            && g_fpGvrApi_nativeSwapChainAcquireFrame!= NULL
            && g_fpGvrApi_nativeSwapChainResizeBuffer!= NULL
            && g_fpGvrApi_nativeSwapChainGetBufferSize!= NULL
            && g_fpGvrApi_nativeSwapChainGetBufferCount!= NULL
            && g_fpGvrApi_nativeSwapChainDestroy!= NULL
            && g_fpGvrApi_nativeBufferSpecSetDepthStencilFormat!= NULL
            && g_fpGvrApi_nativeBufferSpecSetMultiviewLayers!=NULL
            && g_fpGvrApi_nativeBufferSpecSetColorFormat!= NULL
            && g_fpGvrApi_nativeBufferSpecSetSamples!= NULL
            && g_fpGvrApi_nativeExternalSurfaceCreateWithListeners!= NULL
            && g_fpGvrApi_nativeExternalSurfaceDestroy!=NULL
            && g_fpGvrApi_nativeExternalSurfaceGetId!=NULL
            && g_fpGvrApi_nativeExternalSurfaceGetSurface!=NULL
            && g_fpGvrApi_nativeBufferSpecGetSamples!= NULL
            && g_fpGvrApi_nativeBufferSpecSetSize!= NULL
            && g_fpGvrApi_nativeBufferSpecGetSize!= NULL
            && g_fpGvrApi_nativeBufferSpecDestroy!= NULL
            && g_fpGvrApi_nativeBufferSpecCreate!= NULL
            && g_fpGvrApi_nativeBufferViewportEqual!= NULL
            && g_fpGvrApi_nativeBufferViewportSetReprojection!= NULL
            && g_fpGvrApi_nativeBufferViewportSetSourceLayer!=NULL
            && g_fpGvrApi_nativeBufferViewportGetReprojection!= NULL
            && g_fpGvrApi_nativeBufferViewportSetExternalSurfaceId!= NULL
            && g_fpGvrApi_nativeBufferViewportSetExternalSurface!= NULL
            && g_fpGvrApi_nativeBufferViewportGetExternalSurfaceId!= NULL
            && g_fpGvrApi_nativeBufferViewportSetSourceBufferIndex!= NULL
            && g_fpGvrApi_nativeBufferViewportGetSourceBufferIndex!= NULL
            && g_fpGvrApi_nativeBufferViewportSetTargetEye!= NULL
            && g_fpGvrApi_nativeBufferViewportGetTargetEye!= NULL
            && g_fpGvrApi_nativeBufferViewportSetTransform!= NULL
            && g_fpGvrApi_nativeBufferViewportGetTransform!= NULL
            && g_fpGvrApi_nativeBufferViewportSetSourceFov!= NULL
            && g_fpGvrApi_nativeBufferViewportGetSourceFov!= NULL
            && g_fpGvrApi_nativeBufferViewportSetSourceUv!= NULL
            && g_fpGvrApi_nativeBufferViewportGetSourceUv!= NULL
            && g_fpGvrApi_nativeBufferViewportDestroy!= NULL
            && g_fpGvrApi_nativeReleaseGvrContext!= NULL
            && g_fpGvrApi_nativeResume!= NULL
            && g_fpGvrApi_nativePause!= NULL
            && g_fpGvrApi_nativeUserPrefsGetControllerHandedness!= NULL
            && g_fpGvrApi_nativeGetUserPrefs!= NULL
            && g_fpGvrApi_nativeClearError!= NULL
            && g_fpGvrApi_nativeGetError!= NULL
            && g_fpGvrApi_nativeGetRecommendedBufferViewports!= NULL
            && g_fpGvrApi_nativeOnSurfaceCreatedReprojectionThread!= NULL
            && g_fpGvrApi_nativeOnSurfaceChangedReprojectionThread!= NULL
            && g_fpGvrApi_nativeInitializeGl!= NULL
            && g_fpGvrApi_nativeDumpDebugData!= NULL
            && g_fpDisplaySynchronizer_nativeDestroy!= NULL
            && g_fpDisplaySynchronizer_nativeCreate!= NULL
            && g_fpDisplaySynchronizer_nativeUpdate!= NULL
            && g_fpExternalSurfaceManager_nativeUpdateSurface!= NULL
            && g_fpDisplaySynchronizer_nativeReset!= NULL
            && g_fpGvrApi_nativeSetDisplayMetrics!= NULL
            && g_fpGvrApi_nativeReconnectSensors!= NULL
            && g_fpGvrApi_nativeSetIdleListener!= NULL
            && g_fpGvrApi_nativeGetAsyncReprojectionEnabled!= NULL
            && g_fpGvrApi_nativeIsFeatureSupported != NULL
            && g_fpGvrApi_nativeSetLensOffset!= NULL
            && g_fpGvrApi_nativeSetSurfaceSize!= NULL
            && g_fpGvrApi_nativeGetBorderSizeMeters!= NULL
            && g_fpGvrApi_nativeBufferViewportListDestroy!= NULL
            && g_fpGvrApi_nativeBufferViewportListCreate!= NULL
            && g_fpGvrApi_nativeUsingVrDisplayService!= NULL
            && g_fpGvrApi_nativeBufferViewportCreate!= NULL
            && g_fpGvrApi_nativeBufferViewportListSetItem!= NULL
            && g_fpGvrApi_nativeBufferViewportListGetItem!= NULL
            && g_fpGvrApi_nativeBufferViewportListGetSize!= NULL
            && g_fpGvrApi_nativeDistortToScreen!= NULL
            && g_fpGvrApi_nativeGetScreenTargetSize!= NULL
            && g_fpGvrApi_nativeGetMaximumEffectiveRenderTargetSize!= NULL
            && g_fpGvrApi_nativeGetScreenBufferViewports!= NULL
            && g_fpGvrApi_nativeSetDefaultFramebufferActive!= NULL
            && g_fpGvrApi_nativeOnPauseReprojectionThread!= NULL
            && g_fpGvrApi_nativeRenderReprojectionThread!= NULL
            && g_fpGvrApi_nativeResetTracking!= NULL
            && g_fpGvrApi_nativeSetIgnoreManualPauseResumeTracker!= NULL
            && g_fpGvrApi_nativeGetHeadSpaceFromStartSpaceRotation!= NULL
            && g_fpGvrApi_nativeSetAsyncReprojectionEnabled!= NULL
            && g_fpGvrApi_nativeGetViewerType!= NULL
            && g_fpGvrApi_nativeGetEyeFromHeadMatrix!= NULL
            && g_fpGvrApi_nativeRecenterTracking!= NULL
            && g_fpVrParamsProviderJni_nativeUpdateNativePhoneParamsPointer!= NULL
            && g_fpMirthNet_setHttpProxy!= NULL
            && g_fpNativeCallbacks_handleServiceDisconnected!= NULL
            && g_fpNativeCallbacks_handleServiceConnected!= NULL
            && g_fpNativeCallbacks_handleServiceUnavailable!= NULL
            && g_fpNativeCallbacks_handleServiceFailed!= NULL
            && g_fpNativeCallbacks_handleServiceInitFailed!= NULL
            && g_fpNativeCallbacks_handleGyroEvent!= NULL
            && g_fpNativeCallbacks_handleAccelEvent!= NULL
            && g_fpNativeCallbacks_handleBatteryEvent!= NULL
            && g_fpNativeCallbacks_handleButtonEvent!= NULL
            && g_fpNativeCallbacks_handleOrientationEvent!= NULL
            && g_fpNativeCallbacks_handleTouchEvent!= NULL
            && g_fpNativeCallbacks_handleControllerRecentered!= NULL
            && g_fpNativeCallbacks_handleStateChanged!= NULL
            && g_fpCardboardViewNativeImpl_nativeInit!= NULL
            && g_fpCardboardViewNativeImpl_nativeGetCurrentEyeParams!= NULL
            && g_fpCardboardViewNativeImpl_nativeSetRenderer!= NULL
            && g_fpCardboardViewNativeImpl_nativeSetStereoRenderer!= NULL
            && g_fpCardboardViewNativeImpl_nativeSetGvrViewerParams!= NULL
            && g_fpCardboardViewNativeImpl_nativeLogEvent!= NULL
            && g_fpCardboardViewNativeImpl_nativeSetApplicationState!= NULL
            && g_fpCardboardViewNativeImpl_nativeSetScreenParams!= NULL
            && g_fpCardboardViewNativeImpl_nativeSetNeckModelFactor!= NULL
            && g_fpCardboardViewNativeImpl_nativeGetNeckModelFactor != NULL
            && g_fpCardboardViewNativeImpl_nativeOnDrawFrame != NULL
            && g_fpCardboardViewNativeImpl_nativeSetNeckModelEnabled != NULL
            && g_fpCardboardViewNativeImpl_nativeDestroy!= NULL
            && g_fpCardboardViewNativeImpl_nativeOnSurfaceCreated!= NULL
            && g_fpCardboardViewNativeImpl_nativeOnSurfaceChanged!= NULL
            && g_fpCardboardViewNativeImpl_nativeSetStereoModeEnabled!= NULL
            && g_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled!= NULL
            && g_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionScale!= NULL
            && g_fpCardboardViewNativeImpl_nativeSetMultisampling!= NULL
            && g_fpCardboardViewNativeImpl_nativeSetDepthStencilFormat!= NULL
                )
        {
            g_bInit = true;
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

    return	 g_bInit;
}


void ReleaseFun()
{
    if (g_hDLL)
        dlclose(g_hDLL);

    g_fpcreate_with_tracker_for_testing = NULL;
    g_fptracker_state_create = NULL;
    g_fppause_tracking_get_state = NULL;
    g_fpresume_tracking_set_state = NULL;
    g_fptracker_state_destroy = NULL;
    g_fpcontroller_state_get_last_button_timestamp = NULL;
    g_fprender_reprojection_thread = NULL;
    g_fpcontroller_state_get_last_touch_timestamp = NULL;
    g_fpon_surface_created_reprojection_thread = NULL;
    g_fpcontroller_state_get_last_accel_timestamp = NULL;
    g_fpset_async_reprojection_enabled = NULL;
    g_fpcontroller_state_get_last_gyro_timestamp = NULL;
    g_fpcontroller_state_get_last_orientation_timestamp = NULL;
    g_fpcontroller_state_get_last_battery_timestamp = NULL;
    g_fpremove_all_surfaces_reprojection_thread = NULL;
    g_fpcontroller_state_get_button_up = NULL;
    g_fpcontroller_state_get_button_down = NULL;
    g_fpupdate_surface_reprojection_thread = NULL;
    g_fpcontroller_state_get_button_state = NULL;
    g_fpon_pause_reprojection_thread = NULL;
    g_fpon_surface_changed_reprojection_thread = NULL;
    g_fpcontroller_state_get_recentering = NULL;
    g_fpcontroller_state_get_recentered = NULL;
    g_fpcontroller_state_get_touch_up = NULL;
    g_fpcontroller_state_get_touch_down = NULL;
    g_fpcontroller_state_get_touch_pos = NULL;
    g_fpcontroller_state_is_touching = NULL;
    g_fpcontroller_state_get_accel = NULL;
    g_fpcontroller_state_get_battery_charging = NULL;
    g_fpcontroller_state_get_battery_level = NULL;
    g_fpcontroller_state_get_gyro = NULL;
    g_fpcontroller_state_get_orientation = NULL;
    g_fpcontroller_state_get_connection_state = NULL;
    g_fpcontroller_state_get_api_status = NULL;
    g_fpcontroller_state_update = NULL;
    g_fpcontroller_state_destroy = NULL;
    g_fpcontroller_state_create = NULL;
    g_fpcontroller_button_to_string = NULL;
    g_fpdisplay_synchronizer_update = NULL;
    g_fpcontroller_connection_state_to_string = NULL;
    g_fpcontroller_api_status_to_string = NULL;
    g_fpcontroller_battery_level_to_string = NULL;
    g_fpdisplay_synchronizer_reset = NULL;
    g_fpcontroller_resume = NULL;
    g_fpset_ignore_manual_tracker_pause_resume = NULL;
    g_fpcontroller_pause = NULL;
    g_fpset_display_synchronizer = NULL;
    g_fpcontroller_destroy = NULL;
    g_fpcontroller_create_and_init_android = NULL;
    g_fppause = NULL;
    g_fptracker_state_get_buffer = NULL;
    g_fpcontroller_create_and_init = NULL;
    g_fptracker_state_get_buffer_size = NULL;
    g_fpusing_vr_display_service = NULL;
    g_fpcontroller_get_default_options = NULL;
    g_fpdump_debug_data = NULL;
    g_fpexternal_surface_create_with_listeners = NULL;
    g_fpexternal_surface_destroy = NULL;
    g_fpexternal_surface_get_surface = NULL;
    g_fpexternal_surface_get_surface_id = NULL;
    g_fpusing_dynamic_library = NULL;
    g_fpresume = NULL;
    g_fpset_lens_offset = NULL;
    g_fpreconnect_sensors = NULL;
    g_fpset_display_output_rotation = NULL;
    g_fpget_surface_size = NULL;
    g_fpcheck_surface_size_changed = NULL;
    g_fpget_border_size_meters = NULL;
    g_fpget_button_long_press = NULL;
    g_fpdisplay_synchronizer_destroy = NULL;
    g_fpdisplay_synchronizer_create = NULL;
    g_fprefresh_viewer_profile = NULL;
    g_fpset_default_viewer_profile = NULL;
    g_fprecenter_tracking = NULL;
    g_fpreset_tracking = NULL;
    g_fpresume_tracking = NULL;
    g_fpbuffer_viewport_set_source_fov = NULL;
    g_fppause_tracking = NULL;
    g_fpframe_get_framebuffer_object = NULL;
    g_fpframe_get_buffer_size = NULL;
    g_fpbuffer_viewport_set_target_eye = NULL;
    g_fpbuffer_viewport_set_transform = NULL;
    g_fpbuffer_spec_set_color_format = NULL;
    g_fpbuffer_viewport_get_transform = NULL;
    g_fpset_surface_size = NULL;
    g_fpbuffer_viewport_set_external_surface_id = NULL;
    g_fpbuffer_viewport_get_external_surface_id = NULL;
    g_fpbuffer_viewport_list_get_size = NULL;
    g_fpbuffer_viewport_set_source_buffer_index = NULL;
    g_fpget_async_reprojection_enabled = NULL;
    g_fpbuffer_viewport_get_source_buffer_index = NULL;
    g_fpget_error_string = NULL;
    g_fpclear_error = NULL;
    g_fpget_viewer_type = NULL;
    g_fpget_error = NULL;
    g_fpget_viewer_model = NULL;
    g_fpget_version_string = NULL;
    g_fpget_viewer_vendor = NULL;
    g_fpget_version = NULL;
    g_fpset_back_gesture_event_handler = NULL;
    g_fpbuffer_viewport_create = NULL;
    g_fpget_user_prefs = NULL;
    g_fpbuffer_viewport_list_create = NULL;
    g_fpswap_chain_resize_buffer = NULL;
    g_fpframe_submit = NULL;
    g_fpframe_unbind = NULL;
    g_fpgesture_context_create = NULL;
    g_fpgesture_context_destroy = NULL;
    g_fpgesture_get = NULL;
    g_fpgesture_get_count = NULL;
    g_fpgesture_get_direction = NULL;
    g_fpgesture_get_displacement = NULL;
    g_fpgesture_get_type = NULL;
    g_fpgesture_get_velocity = NULL;
    g_fpgesture_restart = NULL;
    g_fpgesture_update = NULL;
    g_fpframe_bind_buffer = NULL;
    g_fpcreate = NULL;
    g_fpswap_chain_acquire_frame = NULL;
    g_fpapply_neck_model = NULL;
    g_fpget_head_space_from_start_space_rotation = NULL;
    g_fpget_window_bounds = NULL;
    g_fpbuffer_viewport_get_source_uv = NULL;
    g_fpget_screen_target_size = NULL;
    g_fpget_screen_buffer_viewports = NULL;
    g_fpuser_prefs_get_controller_handedness = NULL;
    g_fpbuffer_viewport_list_set_item = NULL;
    g_fpbuffer_viewport_set_source_uv = NULL;
    g_fpbuffer_viewport_set_reprojection = NULL;
    g_fpbuffer_viewport_get_reprojection = NULL;
    g_fpbuffer_viewport_set_source_layer = NULL;
    g_fpswap_chain_get_buffer_count = NULL;
    g_fpbuffer_viewport_get_source_fov = NULL;
    g_fpbuffer_spec_get_samples = NULL;
    g_fpbuffer_viewport_get_target_eye = NULL;
    g_fpbuffer_spec_get_size = NULL;
    g_fpbuffer_viewport_list_get_item = NULL;
    g_fpbuffer_viewport_equal = NULL;
    g_fpget_recommended_buffer_viewports = NULL;
    g_fpcompute_distorted_point = NULL;
    g_fpset_error = NULL;
    g_fpset_idle_listener = NULL;
    g_fpswap_chain_get_buffer_size = NULL;
    g_fpget_eye_from_head_matrix = NULL;
    g_fpbuffer_spec_destroy = NULL;
    g_fpset_display_metrics = NULL;
    g_fpset_viewer_params = NULL;
    g_fpget_time_point_now = NULL;
    g_fpdistort_to_screen = NULL;
    g_fpis_feature_supported = NULL;
    g_fpinitialize_gl = NULL;
    g_fpbuffer_spec_create = NULL;
    g_fpbuffer_spec_set_size = NULL;
    g_fpbuffer_spec_set_depth_stencil_format = NULL;
    g_fpbuffer_spec_set_multiview_layer = NULL;
    g_fpbuffer_spec_set_samples = NULL;
    g_fpget_maximum_effective_render_target_size = NULL;
    g_fpbind_default_framebuffer = NULL;
    g_fpswap_chain_create = NULL;
    g_fpbuffer_viewport_destroy = NULL;
    g_fpdestroy = NULL;
    g_fpswap_chain_destroy = NULL;
    g_fpJNI_OnLoad = NULL;
    g_fpbuffer_viewport_list_destroy = NULL;
    g_fpGvrApi_nativeGetWindowBounds = NULL;
    g_fpGvrApi_nativePauseTracking = NULL;
    g_fpGvrApi_nativePauseTrackingGetState = NULL;
    g_fpGvrApi_nativeGetViewerModel = NULL;
    g_fpGvrApi_nativeGetViewerVendor = NULL;
    g_fpGvrApi_nativeGetErrorString = NULL;
    g_fpGvrApi_nativeComputeDistortedPoint = NULL;
    g_fpGvrApi_nativeCreate = NULL;
    g_fpGvrApi_nativeRequestContextSharing = NULL;
    g_fpGvrApi_nativeSwapChainCreate = NULL;
    g_fpGvrApi_nativeSetViewerParams = NULL;
    g_fpGvrApi_nativeSetDefaultViewerProfile = NULL;
    g_fpGvrApi_nativeResumeTracking = NULL;
    g_fpGvrApi_nativeResumeTrackingSetState = NULL;
    g_fpGvrApi_nativeFrameSubmit = NULL;
    g_fpGvrApi_nativeUsingDynamicLibrary = NULL;
    g_fpGvrApi_nativeSetApplicationState = NULL;
    g_fpGvrApi_nativeSetDynamicLibraryLoadingEnabled = NULL;
    g_fpGvrApi_nativeFrameGetBufferSize = NULL;
    g_fpGvrApi_nativeFrameGetFramebufferObject = NULL;
    g_fpGvrApi_nativeFrameUnbind = NULL;
    g_fpGvrApi_nativeFrameBindBuffer = NULL;
    g_fpGvrApi_nativeSwapChainAcquireFrame = NULL;
    g_fpGvrApi_nativeSwapChainResizeBuffer = NULL;
    g_fpGvrApi_nativeSwapChainGetBufferSize = NULL;
    g_fpGvrApi_nativeSwapChainGetBufferCount = NULL;
    g_fpGvrApi_nativeSwapChainDestroy = NULL;
    g_fpGvrApi_nativeBufferSpecSetDepthStencilFormat = NULL;
    g_fpGvrApi_nativeBufferSpecSetMultiviewLayers = NULL;
    g_fpGvrApi_nativeBufferSpecSetColorFormat = NULL;
    g_fpGvrApi_nativeBufferSpecSetSamples = NULL;
    g_fpGvrApi_nativeExternalSurfaceCreateWithListeners = NULL;
    g_fpGvrApi_nativeExternalSurfaceDestroy = NULL;
    g_fpGvrApi_nativeExternalSurfaceGetId = NULL;
    g_fpGvrApi_nativeExternalSurfaceGetSurface = NULL;
    g_fpGvrApi_nativeBufferSpecGetSamples = NULL;
    g_fpGvrApi_nativeBufferSpecSetSize = NULL;
    g_fpGvrApi_nativeBufferSpecGetSize = NULL;
    g_fpGvrApi_nativeBufferSpecDestroy = NULL;
    g_fpGvrApi_nativeBufferSpecCreate = NULL;
    g_fpGvrApi_nativeBufferViewportEqual = NULL;
    g_fpGvrApi_nativeBufferViewportSetReprojection = NULL;
    g_fpGvrApi_nativeBufferViewportSetSourceLayer = NULL;
    g_fpGvrApi_nativeBufferViewportGetReprojection = NULL;
    g_fpGvrApi_nativeBufferViewportSetExternalSurfaceId = NULL;
    g_fpGvrApi_nativeBufferViewportSetExternalSurface = NULL;
    g_fpGvrApi_nativeBufferViewportGetExternalSurfaceId = NULL;
    g_fpGvrApi_nativeBufferViewportSetSourceBufferIndex = NULL;
    g_fpGvrApi_nativeBufferViewportGetSourceBufferIndex = NULL;
    g_fpGvrApi_nativeBufferViewportSetTargetEye = NULL;
    g_fpGvrApi_nativeBufferViewportGetTargetEye = NULL;
    g_fpGvrApi_nativeBufferViewportSetTransform = NULL;
    g_fpGvrApi_nativeBufferViewportGetTransform = NULL;
    g_fpGvrApi_nativeBufferViewportSetSourceFov = NULL;
    g_fpGvrApi_nativeBufferViewportGetSourceFov = NULL;
    g_fpGvrApi_nativeBufferViewportSetSourceUv = NULL;
    g_fpGvrApi_nativeBufferViewportGetSourceUv = NULL;
    g_fpGvrApi_nativeBufferViewportDestroy = NULL;
    g_fpGvrApi_nativeReleaseGvrContext = NULL;
    g_fpGvrApi_nativeResume = NULL;
    g_fpGvrApi_nativePause = NULL;
    g_fpGvrApi_nativeUserPrefsGetControllerHandedness = NULL;
    g_fpGvrApi_nativeGetUserPrefs = NULL;
    g_fpGvrApi_nativeClearError = NULL;
    g_fpGvrApi_nativeGetError = NULL;
    g_fpGvrApi_nativeGetRecommendedBufferViewports = NULL;
    g_fpGvrApi_nativeOnSurfaceCreatedReprojectionThread = NULL;
    g_fpGvrApi_nativeOnSurfaceChangedReprojectionThread = NULL;
    g_fpGvrApi_nativeInitializeGl = NULL;
    g_fpGvrApi_nativeDumpDebugData = NULL;
    g_fpDisplaySynchronizer_nativeDestroy = NULL;
    g_fpDisplaySynchronizer_nativeCreate = NULL;
    g_fpDisplaySynchronizer_nativeUpdate = NULL;
    g_fpExternalSurfaceManager_nativeUpdateSurface = NULL;
    g_fpDisplaySynchronizer_nativeReset = NULL;
    g_fpGvrApi_nativeSetDisplayMetrics = NULL;
    g_fpGvrApi_nativeReconnectSensors = NULL;
    g_fpGvrApi_nativeSetIdleListener = NULL;
    g_fpGvrApi_nativeGetAsyncReprojectionEnabled = NULL;
    g_fpGvrApi_nativeIsFeatureSupported = NULL;
    g_fpGvrApi_nativeSetLensOffset = NULL;
    g_fpGvrApi_nativeSetSurfaceSize = NULL;
    g_fpGvrApi_nativeGetBorderSizeMeters = NULL;
    g_fpGvrApi_nativeBufferViewportListDestroy = NULL;
    g_fpGvrApi_nativeBufferViewportListCreate = NULL;
    g_fpGvrApi_nativeUsingVrDisplayService = NULL;
    g_fpGvrApi_nativeBufferViewportCreate = NULL;
    g_fpGvrApi_nativeBufferViewportListSetItem = NULL;
    g_fpGvrApi_nativeBufferViewportListGetItem = NULL;
    g_fpGvrApi_nativeBufferViewportListGetSize = NULL;
    g_fpGvrApi_nativeDistortToScreen = NULL;
    g_fpGvrApi_nativeGetScreenTargetSize = NULL;
    g_fpGvrApi_nativeGetMaximumEffectiveRenderTargetSize = NULL;
    g_fpGvrApi_nativeGetScreenBufferViewports = NULL;
    g_fpGvrApi_nativeSetDefaultFramebufferActive = NULL;
    g_fpGvrApi_nativeOnPauseReprojectionThread = NULL;
    g_fpGvrApi_nativeRenderReprojectionThread = NULL;
    g_fpGvrApi_nativeResetTracking = NULL;
    g_fpGvrApi_nativeSetIgnoreManualPauseResumeTracker = NULL;
    g_fpGvrApi_nativeGetHeadSpaceFromStartSpaceRotation = NULL;
    g_fpGvrApi_nativeSetAsyncReprojectionEnabled = NULL;
    g_fpGvrApi_nativeGetViewerType = NULL;
    g_fpGvrApi_nativeGetEyeFromHeadMatrix = NULL;
    g_fpGvrApi_nativeRecenterTracking = NULL;
    g_fpVrParamsProviderJni_nativeUpdateNativePhoneParamsPointer = NULL;
    g_fpMirthNet_setHttpProxy = NULL;
    g_fpNativeCallbacks_handleServiceDisconnected = NULL;
    g_fpNativeCallbacks_handleServiceConnected = NULL;
    g_fpNativeCallbacks_handleServiceUnavailable = NULL;
    g_fpNativeCallbacks_handleServiceFailed = NULL;
    g_fpNativeCallbacks_handleServiceInitFailed = NULL;
    g_fpNativeCallbacks_handleGyroEvent = NULL;
    g_fpNativeCallbacks_handleAccelEvent = NULL;
    g_fpNativeCallbacks_handleBatteryEvent = NULL;
    g_fpNativeCallbacks_handleButtonEvent = NULL;
    g_fpNativeCallbacks_handleOrientationEvent = NULL;
    g_fpNativeCallbacks_handleTouchEvent = NULL;
    g_fpNativeCallbacks_handleControllerRecentered = NULL;
    g_fpNativeCallbacks_handleStateChanged = NULL;
    g_fpCardboardViewNativeImpl_nativeInit = NULL;
    g_fpCardboardViewNativeImpl_nativeGetCurrentEyeParams = NULL;
    g_fpCardboardViewNativeImpl_nativeSetRenderer = NULL;
    g_fpCardboardViewNativeImpl_nativeSetStereoRenderer = NULL;
    g_fpCardboardViewNativeImpl_nativeSetGvrViewerParams = NULL;
    g_fpCardboardViewNativeImpl_nativeLogEvent = NULL;
    g_fpCardboardViewNativeImpl_nativeSetApplicationState = NULL;
    g_fpCardboardViewNativeImpl_nativeSetScreenParams = NULL;
    g_fpCardboardViewNativeImpl_nativeSetNeckModelFactor = NULL;
    g_fpCardboardViewNativeImpl_nativeGetNeckModelFactor  = NULL;
    g_fpCardboardViewNativeImpl_nativeOnDrawFrame  = NULL;
    g_fpCardboardViewNativeImpl_nativeSetNeckModelEnabled  = NULL;
    g_fpCardboardViewNativeImpl_nativeDestroy = NULL;
    g_fpCardboardViewNativeImpl_nativeOnSurfaceCreated = NULL;
    g_fpCardboardViewNativeImpl_nativeOnSurfaceChanged = NULL;
    g_fpCardboardViewNativeImpl_nativeSetStereoModeEnabled = NULL;
    g_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled = NULL;
    g_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionScale = NULL;
    g_fpCardboardViewNativeImpl_nativeSetMultisampling = NULL;
    g_fpCardboardViewNativeImpl_nativeSetDepthStencilFormat = NULL;
    return;
}

//ClassLoader paramClassLoader, Context paramContext)
JNIEXPORT long JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetApplicationState(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( g_fpCardboardViewNativeImpl_nativeSetApplicationState)
        re = g_fpCardboardViewNativeImpl_nativeSetApplicationState(env, obj, paramClassLoader, paramContext);
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetScreenParams(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1,
        jfloat paramFloat2, jfloat paramFloat3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpCardboardViewNativeImpl_nativeSetScreenParams){
        g_fpCardboardViewNativeImpl_nativeSetScreenParams(env, obj, paramLong, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3);
    }
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetNeckModelFactor(
        JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpCardboardViewNativeImpl_nativeSetNeckModelFactor){
        g_fpCardboardViewNativeImpl_nativeSetNeckModelFactor(env, obj, paramLong, paramFloat);
    }
    return;
}
JNIEXPORT float JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeGetNeckModelFactor(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    float re=0;
    if( g_fpCardboardViewNativeImpl_nativeGetNeckModelFactor)
        re = g_fpCardboardViewNativeImpl_nativeGetNeckModelFactor(env, obj, paramLong);
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeOnDrawFrame(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpCardboardViewNativeImpl_nativeOnDrawFrame)
        g_fpCardboardViewNativeImpl_nativeOnDrawFrame(env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetNeckModelEnabled(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpCardboardViewNativeImpl_nativeSetNeckModelEnabled)
        g_fpCardboardViewNativeImpl_nativeSetNeckModelEnabled(env, obj, paramLong, paramBoolean);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpCardboardViewNativeImpl_nativeDestroy)
        g_fpCardboardViewNativeImpl_nativeDestroy(env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeOnSurfaceCreated(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpCardboardViewNativeImpl_nativeOnSurfaceCreated)
        g_fpCardboardViewNativeImpl_nativeOnSurfaceCreated(env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeOnSurfaceChanged(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpCardboardViewNativeImpl_nativeOnSurfaceChanged)
        g_fpCardboardViewNativeImpl_nativeOnSurfaceChanged(env, obj, paramLong, paramInt1, paramInt2);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetStereoModeEnabled(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpCardboardViewNativeImpl_nativeSetStereoModeEnabled)
        g_fpCardboardViewNativeImpl_nativeSetStereoModeEnabled(env, obj, paramLong, paramBoolean);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled)
        g_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionEnabled(env, obj, paramLong, paramBoolean);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetDistortionCorrectionScale(
        JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionScale)
        g_fpCardboardViewNativeImpl_nativeSetDistortionCorrectionScale(env, obj, paramLong, paramFloat);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetMultisampling(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpCardboardViewNativeImpl_nativeSetMultisampling)
        g_fpCardboardViewNativeImpl_nativeSetMultisampling(env, obj, paramLong, paramInt);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetDepthStencilFormat(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpCardboardViewNativeImpl_nativeSetDepthStencilFormat)
        g_fpCardboardViewNativeImpl_nativeSetDepthStencilFormat(env,obj, paramLong, paramInt);
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
    if( g_fpCardboardViewNativeImpl_nativeLogEvent)
        g_fpCardboardViewNativeImpl_nativeLogEvent( env, obj, paramLong, paramInt);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetGvrViewerParams(
        JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpCardboardViewNativeImpl_nativeSetGvrViewerParams)
        g_fpCardboardViewNativeImpl_nativeSetGvrViewerParams(env, obj, paramLong, paramArrayOfByte);
    return;
}
//GvrView.StereoRenderer paramStereoRenderer
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetStereoRenderer(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramStereoRenderer)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpCardboardViewNativeImpl_nativeSetStereoRenderer)
        g_fpCardboardViewNativeImpl_nativeSetStereoRenderer(env, obj, paramLong, paramStereoRenderer );
    return;
}
//GvrView.Renderer
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeSetRenderer(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramRenderer)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpCardboardViewNativeImpl_nativeSetRenderer)
        g_fpCardboardViewNativeImpl_nativeSetRenderer(env, obj, paramLong, paramRenderer);
    return;
}

//HeadTransform paramHeadTransform, Eye paramEye1, Eye paramEye2, Eye paramEye3, Eye paramEye4, Eye paramEye
JNIEXPORT void JNICALL Java_com_google_vr_sdk_base_CardboardViewNativeImpl_nativeGetCurrentEyeParams(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramHeadTransform, jobject paramEye1, jobject paramEye2,
        jobject paramEye3, jobject paramEye4, jobject paramEye5)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpCardboardViewNativeImpl_nativeGetCurrentEyeParams) {
        g_fpCardboardViewNativeImpl_nativeGetCurrentEyeParams(env, obj, paramLong,
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
    if( g_fpCardboardViewNativeImpl_nativeInit)
        re = g_fpCardboardViewNativeImpl_nativeInit(env, obj, paramLong);
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleStateChanged(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2 )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpNativeCallbacks_handleStateChanged)
        g_fpNativeCallbacks_handleStateChanged(env, obj, paramLong, paramInt1, paramInt2 );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleControllerRecentered(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2,
        jfloat paramFloat3, jfloat paramFloat4)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpNativeCallbacks_handleControllerRecentered)
        g_fpNativeCallbacks_handleControllerRecentered(env, obj, paramLong1, paramLong2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleTouchEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt, jfloat paramFloat1, jfloat paramFloat2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpNativeCallbacks_handleTouchEvent)
        g_fpNativeCallbacks_handleTouchEvent( env, obj, paramLong1, paramLong2, paramInt, paramFloat1, paramFloat2);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleOrientationEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpNativeCallbacks_handleOrientationEvent)
        g_fpNativeCallbacks_handleOrientationEvent(env, obj, paramLong1, paramLong2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleButtonEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt, jboolean paramBoolean)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpNativeCallbacks_handleButtonEvent)
        g_fpNativeCallbacks_handleButtonEvent( env, obj, paramLong1, paramLong2, paramInt, paramBoolean);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleAccelEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpNativeCallbacks_handleAccelEvent)
        g_fpNativeCallbacks_handleAccelEvent( env, obj, paramLong1, paramLong2, paramFloat1, paramFloat2, paramFloat3);
    return;
}

JNIEXPORT void JNICALL  Java_com_google_vr_internal_controller_NativeCallbacks_handleBatteryEvent(
        JNIEnv* env, jobject obj, jlong var1, jlong var3, jboolean var5, jint var6)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpNativeCallbacks_handleBatteryEvent)
        g_fpNativeCallbacks_handleBatteryEvent(env, obj, var1, var3, var5, var6);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleGyroEvent(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpNativeCallbacks_handleGyroEvent)
        g_fpNativeCallbacks_handleGyroEvent( env, obj, paramLong1, paramLong2, paramFloat1, paramFloat2, paramFloat3);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceInitFailed(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpNativeCallbacks_handleServiceInitFailed)
        g_fpNativeCallbacks_handleServiceInitFailed( env, obj, paramLong, paramInt);
    return;
}
JNIEXPORT void JNICALL  Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceFailed(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpNativeCallbacks_handleServiceFailed)
        g_fpNativeCallbacks_handleServiceFailed( env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceUnavailable(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpNativeCallbacks_handleServiceUnavailable)
        g_fpNativeCallbacks_handleServiceUnavailable( env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceConnected(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpNativeCallbacks_handleServiceConnected)
        g_fpNativeCallbacks_handleServiceConnected(env, obj, paramLong, paramInt);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_internal_controller_NativeCallbacks_handleServiceDisconnected(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpNativeCallbacks_handleServiceDisconnected)
        g_fpNativeCallbacks_handleServiceDisconnected( env, obj, paramLong);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_cardboard_VrParamsProviderJni_nativeUpdateNativePhoneParamsPointer(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1, jfloat paramFloat2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpVrParamsProviderJni_nativeUpdateNativePhoneParamsPointer)
        g_fpVrParamsProviderJni_nativeUpdateNativePhoneParamsPointer( env, obj, paramLong, paramInt1, paramInt2, paramFloat1, paramFloat2);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeRecenterTracking(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeRecenterTracking)
        g_fpGvrApi_nativeRecenterTracking( env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetEyeFromHeadMatrix(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jfloatArray paramArrayOfFloat)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeGetEyeFromHeadMatrix)
        g_fpGvrApi_nativeGetEyeFromHeadMatrix( env, obj, paramLong, paramInt, paramArrayOfFloat);
    return;
}

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetViewerType(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(g_fpGvrApi_nativeGetViewerType)
        re =g_fpGvrApi_nativeGetViewerType( env, obj, paramLong);
    LOGI("mjgvr F:%s, bool:%d", __FUNCTION__, re );
    return re;
}
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBool)
{
    CLogMessage msg(__FUNCTION__);
    bool re = false;
    InitLoadFun();
    if( g_fpGvrApi_nativeSetAsyncReprojectionEnabled)
        re = g_fpGvrApi_nativeSetAsyncReprojectionEnabled(env, obj, paramLong, paramBool);
//    re = false;
    LOGI("mjgvr F:%s, bool:%d", __FUNCTION__, re );
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetHeadSpaceFromStartSpaceRotation(
        JNIEnv* env, jobject obj, jlong paramLong1, jfloatArray paramArrayOfFloat, jlong paramLong2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeGetHeadSpaceFromStartSpaceRotation)
        g_fpGvrApi_nativeGetHeadSpaceFromStartSpaceRotation( env, obj, paramLong1, paramArrayOfFloat, paramLong2);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetIgnoreManualPauseResumeTracker(
        JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBoolean)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeSetIgnoreManualPauseResumeTracker)
        g_fpGvrApi_nativeSetIgnoreManualPauseResumeTracker(env, obj, paramLong, paramBoolean);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeResetTracking(JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeResetTracking)
        g_fpGvrApi_nativeResetTracking( env, obj, paramLong);
    return;
}

JNIEXPORT jobject JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeRenderReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jobject re = NULL;
    if(g_fpGvrApi_nativeRenderReprojectionThread)
        re = g_fpGvrApi_nativeRenderReprojectionThread(env, obj, paramLong);
    return  re;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeOnPauseReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeOnPauseReprojectionThread)
        g_fpGvrApi_nativeOnPauseReprojectionThread(env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDefaultFramebufferActive(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeSetDefaultFramebufferActive)
        g_fpGvrApi_nativeSetDefaultFramebufferActive( env, obj, paramLong);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetScreenBufferViewports(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2 )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeGetScreenBufferViewports)
        g_fpGvrApi_nativeGetScreenBufferViewports(env, obj, paramLong1, paramLong2);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetMaximumEffectiveRenderTargetSize(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeGetMaximumEffectiveRenderTargetSize)
        g_fpGvrApi_nativeGetMaximumEffectiveRenderTargetSize( env, obj, paramLong, paramPoint);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetScreenTargetSize(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeGetScreenTargetSize)
        g_fpGvrApi_nativeGetScreenTargetSize( env, obj, paramLong, paramPoint);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeDistortToScreen(
        JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2, jfloatArray paramArrayOfFloat, jlong paramLong3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeDistortToScreen)
        g_fpGvrApi_nativeDistortToScreen( env, obj, paramLong1, paramInt, paramLong2, paramArrayOfFloat, paramLong3);
    return;
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListGetSize(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( g_fpGvrApi_nativeBufferViewportListGetSize)
        re = g_fpGvrApi_nativeBufferViewportListGetSize(env, obj, paramLong );
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListGetItem(
        JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeBufferViewportListGetItem)
        g_fpGvrApi_nativeBufferViewportListGetItem( env, obj, paramLong1, paramInt, paramLong2);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListSetItem(
        JNIEnv* env, jobject obj, jlong paramLong1, jint paramInt, jlong paramLong2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeBufferViewportListSetItem)
        g_fpGvrApi_nativeBufferViewportListSetItem( env, obj, paramLong1, paramInt, paramLong2);
    return;
}

JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportCreate(JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( g_fpGvrApi_nativeBufferViewportCreate)
        re = g_fpGvrApi_nativeBufferViewportCreate( env, obj, paramLong);
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
    if( g_fpGvrApi_nativeUsingVrDisplayService)
        g_fpGvrApi_nativeUsingVrDisplayService(env, obj, paramLong);
    LOGI("mjgvr F:%s, bool:%d", __FUNCTION__, re );
    return re;
}

JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListCreate(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( g_fpGvrApi_nativeBufferViewportListCreate)
        re = g_fpGvrApi_nativeBufferViewportListCreate(env, obj, paramLong);
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportListDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeBufferViewportListDestroy)
        g_fpGvrApi_nativeBufferViewportListDestroy( env, obj, paramLong);
    return;
}

JNIEXPORT float JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetBorderSizeMeters(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    float  re = 0;
    if( g_fpGvrApi_nativeGetBorderSizeMeters)
        re = g_fpGvrApi_nativeGetBorderSizeMeters( env, obj, paramLong);
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetSurfaceSize(JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeSetSurfaceSize)
        g_fpGvrApi_nativeSetSurfaceSize( env, obj, paramLong, paramInt1, paramInt2);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetLensOffset(
        JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat1, jfloat paramFloat2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeSetLensOffset)
        g_fpGvrApi_nativeSetLensOffset( env, obj, paramLong, paramFloat1, paramFloat2);
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
    if( g_fpGvrApi_nativeGetAsyncReprojectionEnabled)
        re = g_fpGvrApi_nativeGetAsyncReprojectionEnabled( env, obj, paramLong);
    return re;
}

JNIEXPORT jboolean JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeIsFeatureSupported(
        JNIEnv* env, jobject obj, jlong paramLong, jint jvar )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if(g_fpGvrApi_nativeIsFeatureSupported)
        re = g_fpGvrApi_nativeIsFeatureSupported(env, obj, paramLong, jvar);
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeReconnectSensors(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeReconnectSensors)
        g_fpGvrApi_nativeReconnectSensors( env, obj, paramLong);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetIdleListener(
        JNIEnv* env, jobject obj, jlong paramLong, jobject jvar)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeSetIdleListener)
        g_fpGvrApi_nativeSetIdleListener(env, obj, paramLong, jvar);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDisplayMetrics(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jfloat paramFloat1, jfloat paramFloat2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeSetDisplayMetrics)
        g_fpGvrApi_nativeSetDisplayMetrics( env, obj, paramLong, paramInt1, paramInt2, paramFloat1, paramFloat2);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeReset(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jlong paramLong3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpDisplaySynchronizer_nativeReset)
        g_fpDisplaySynchronizer_nativeReset( env, obj, paramLong1, paramLong2, paramLong3);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeUpdate(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpDisplaySynchronizer_nativeUpdate)
        g_fpDisplaySynchronizer_nativeUpdate(env, obj, paramLong1, paramLong2, paramInt);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_cardboard_ExternalSurfaceManager_nativeUpdateSurface(
        JNIEnv* env, jobject obj, jlong var0, jint var2, jint var3, jlong var4, jfloatArray var6)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpExternalSurfaceManager_nativeUpdateSurface)
        g_fpExternalSurfaceManager_nativeUpdateSurface(env, obj, var0, var2, var3, var4, var6);
    return;
}

//ClassLoader paramClassLoader, Context paramContext
JNIEXPORT long JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( g_fpDisplaySynchronizer_nativeCreate)
        re = g_fpDisplaySynchronizer_nativeCreate( env, obj, paramClassLoader, paramContext);
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_cardboard_DisplaySynchronizer_nativeDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpDisplaySynchronizer_nativeDestroy)
        g_fpDisplaySynchronizer_nativeDestroy( env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeDumpDebugData(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeDumpDebugData)
        g_fpGvrApi_nativeDumpDebugData( env, obj, paramLong );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeInitializeGl(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeInitializeGl)
        g_fpGvrApi_nativeInitializeGl(env, obj, paramLong);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeOnSurfaceCreatedReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeOnSurfaceCreatedReprojectionThread)
        g_fpGvrApi_nativeOnSurfaceCreatedReprojectionThread(env, obj, paramLong);
//    if(g_fpon_surface_created_reprojection_thread)
//        g_fpon_surface_created_reprojection_thread(paramLong);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeOnSurfaceChangedReprojectionThread(
        JNIEnv* env, jobject obj, jlong paramlong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeOnSurfaceChangedReprojectionThread)
        g_fpGvrApi_nativeOnSurfaceChangedReprojectionThread(env, obj, paramlong);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetRecommendedBufferViewports(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeGetRecommendedBufferViewports)
        g_fpGvrApi_nativeGetRecommendedBufferViewports( env, obj, paramLong1, paramLong2);
    return;
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetError(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( g_fpGvrApi_nativeGetError)
        re = g_fpGvrApi_nativeGetError( env, obj, paramLong);
    return re;
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeClearError(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( g_fpGvrApi_nativeClearError)
        re = g_fpGvrApi_nativeClearError(env, obj, paramLong );
    return re;
}
JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetUserPrefs(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( g_fpGvrApi_nativeGetUserPrefs)
        re = g_fpGvrApi_nativeGetUserPrefs(env, obj, paramLong );
    return re;
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUserPrefsGetControllerHandedness(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( g_fpGvrApi_nativeUserPrefsGetControllerHandedness)
        re = g_fpGvrApi_nativeUserPrefsGetControllerHandedness( env, obj, paramLong);
    return re;
}

JNIEXPORT jboolean JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUserPrefsGetPerformanceMonitoringEnabled(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jboolean re = false;
    assert(false);
    if(g_fpGvrApi_nativeUserPrefsGetPerformanceMonitoringEnabled)
        re = g_fpGvrApi_nativeUserPrefsGetPerformanceMonitoringEnabled(env, obj, paramLong);
    return re;
}

JNIEXPORT jboolean JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUserPrefsGetPerformanceHudEnabled(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jboolean re = false;
    assert(false);
    if(g_fpGvrApi_nativeUserPrefsGetPerformanceHudEnabled)
        re = g_fpGvrApi_nativeUserPrefsGetPerformanceHudEnabled(env, obj, paramLong);
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
    if( g_fpGvrApi_nativePause)
        g_fpGvrApi_nativePause(env, obj, paramLong );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeResume(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeResume)
        g_fpGvrApi_nativeResume(env, obj, paramLong );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeReleaseGvrContext(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeReleaseGvrContext)
        g_fpGvrApi_nativeReleaseGvrContext( env, obj, paramLong );
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeBufferViewportDestroy)
        g_fpGvrApi_nativeBufferViewportDestroy( env, obj, paramLong);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetSourceUv(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramRectF)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeBufferViewportGetSourceUv)
        g_fpGvrApi_nativeBufferViewportGetSourceUv(env, obj, paramLong, paramRectF );
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceUv(
        JNIEnv* env, jobject obj, jlong paramLong, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeBufferViewportSetSourceUv)
        g_fpGvrApi_nativeBufferViewportSetSourceUv( env, obj, paramLong, paramFloat1, paramFloat2, paramFloat3, paramFloat4 );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetSourceFov(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramRectF)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeBufferViewportGetSourceFov)
        g_fpGvrApi_nativeBufferViewportGetSourceFov( env, obj, paramLong, paramRectF );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceFov(
        JNIEnv* env, jobject obj,  jlong paramLong, jfloat paramFloat1, jfloat paramFloat2, jfloat paramFloat3, jfloat paramFloat4 )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeBufferViewportSetSourceFov)
        g_fpGvrApi_nativeBufferViewportSetSourceFov( env, obj, paramLong, paramFloat1, paramFloat2, paramFloat3, paramFloat4 );
    return;
}

// static native void nativeBufferViewportGetTransform(long paramLong, float[] paramArrayOfFloat);
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetTransform(
        JNIEnv* env, jobject obj, jlong paramLong, jfloatArray paramArrayOffloat)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeBufferViewportGetTransform)
        g_fpGvrApi_nativeBufferViewportGetTransform( env, obj, paramLong, paramArrayOffloat);
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetTransform(
        JNIEnv* env, jobject obj, jlong paramLong, jfloatArray paramArrayOfFloat)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeBufferViewportSetTransform)
        g_fpGvrApi_nativeBufferViewportSetTransform(env, obj, paramLong, paramArrayOfFloat );
    return;
}

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetTargetEye(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( g_fpGvrApi_nativeBufferViewportGetTargetEye)
        re = g_fpGvrApi_nativeBufferViewportGetTargetEye( env, obj, paramLong );
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetTargetEye(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeBufferViewportSetTargetEye)
        g_fpGvrApi_nativeBufferViewportSetTargetEye( env, obj, paramLong, paramInt );
    return;
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetSourceBufferIndex(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(g_fpGvrApi_nativeBufferViewportGetSourceBufferIndex)
        re = g_fpGvrApi_nativeBufferViewportGetSourceBufferIndex( env, obj, paramLong );
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceBufferIndex(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeBufferViewportSetSourceBufferIndex)
        g_fpGvrApi_nativeBufferViewportSetSourceBufferIndex( env, obj, paramLong, paramInt );
    return;
}

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetExternalSurfaceId(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( g_fpGvrApi_nativeBufferViewportGetExternalSurfaceId)
        re = g_fpGvrApi_nativeBufferViewportGetExternalSurfaceId( env, obj, paramLong );
    return re;
}

JNIEXPORT void JNICALL  Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetExternalSurfaceId(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeBufferViewportSetExternalSurfaceId)
        g_fpGvrApi_nativeBufferViewportSetExternalSurfaceId( env, obj, paramLong, paramInt );
    return;
}

JNIEXPORT void JNICALL  Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetExternalSurface(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeBufferViewportSetExternalSurface)
        g_fpGvrApi_nativeBufferViewportSetExternalSurface(env, obj, paramLong, paramInt );
}

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportGetReprojection(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( g_fpGvrApi_nativeBufferViewportGetReprojection)
        re = g_fpGvrApi_nativeBufferViewportGetReprojection( env, obj, paramLong );
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetReprojection(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeBufferViewportSetReprojection)
        g_fpGvrApi_nativeBufferViewportSetReprojection( env, obj, paramLong, paramInt );
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportSetSourceLayer(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeBufferViewportSetSourceLayer)
        g_fpGvrApi_nativeBufferViewportSetSourceLayer(env, obj, paramLong, paramInt);
    return;
}

JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferViewportEqual(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if( g_fpGvrApi_nativeBufferViewportEqual)
        re = g_fpGvrApi_nativeBufferViewportEqual( env, obj, paramLong1, paramLong2 );
    return re;
}

JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecCreate(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( g_fpGvrApi_nativeBufferSpecCreate)
        re = g_fpGvrApi_nativeBufferSpecCreate( env, obj, paramLong);
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeBufferSpecDestroy)
        g_fpGvrApi_nativeBufferSpecDestroy( env, obj, paramLong );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecGetSize(
        JNIEnv* env, jobject obj, jlong paramLong, jobject paramPoint)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeBufferSpecGetSize)
        g_fpGvrApi_nativeBufferSpecGetSize( env, obj, paramLong, paramPoint );
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetSize(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jint paramInt2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeBufferSpecSetSize)
        g_fpGvrApi_nativeBufferSpecSetSize( env, obj, paramLong, paramInt, paramInt2 );
    return;
}

JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecGetSamples(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( g_fpGvrApi_nativeBufferSpecGetSamples)
        re = g_fpGvrApi_nativeBufferSpecGetSamples(env, obj, paramLong);
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetSamples(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeBufferSpecSetSamples)
        g_fpGvrApi_nativeBufferSpecSetSamples( env, obj, paramLong, paramInt );
    return;
}

JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceCreate(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    assert(false);
    if(g_fpGvrApi_nativeExternalSurfaceCreate)
        re = g_fpGvrApi_nativeExternalSurfaceCreate(env, obj, paramLong);
    return re;
}

JNIEXPORT jlong JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceCreateWithListeners(
        JNIEnv* env, jobject obj, jlong paramLong, jobject var2, jobject var3, jobject var4)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( g_fpGvrApi_nativeExternalSurfaceCreateWithListeners)
        re = g_fpGvrApi_nativeExternalSurfaceCreateWithListeners(env, obj, paramLong, var2, var3, var4);
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeExternalSurfaceDestroy)
        g_fpGvrApi_nativeExternalSurfaceDestroy(env, obj, paramLong);
    return;
}

JNIEXPORT jint JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceGetId(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jint re = 0;
    if( g_fpGvrApi_nativeExternalSurfaceGetId)
        re = g_fpGvrApi_nativeExternalSurfaceGetId(env, obj, paramLong);
    return re;
}

JNIEXPORT jobject JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeExternalSurfaceGetSurface(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jobject re = NULL;
    if(g_fpGvrApi_nativeExternalSurfaceGetSurface)
        re = g_fpGvrApi_nativeExternalSurfaceGetSurface(env, obj, paramLong);
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetColorFormat(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeBufferSpecSetColorFormat)
        g_fpGvrApi_nativeBufferSpecSetColorFormat( env, obj, paramLong, paramInt );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetDepthStencilFormat(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeBufferSpecSetDepthStencilFormat)
        g_fpGvrApi_nativeBufferSpecSetDepthStencilFormat(env, obj, paramLong, paramInt );
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeBufferSpecSetMultiviewLayers(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeBufferSpecSetMultiviewLayers)
        g_fpGvrApi_nativeBufferSpecSetMultiviewLayers(env, obj, paramLong, paramInt);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainDestroy(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeSwapChainDestroy)
        g_fpGvrApi_nativeSwapChainDestroy(env, obj, paramLong );
    return;
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainGetBufferCount(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( g_fpGvrApi_nativeSwapChainGetBufferCount)
        re = g_fpGvrApi_nativeSwapChainGetBufferCount( env, obj, paramLong );
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainGetBufferSize(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jobject paramPoint)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeSwapChainGetBufferSize)
        g_fpGvrApi_nativeSwapChainGetBufferSize( env, obj, paramLong, paramInt, paramPoint );
    return;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainResizeBuffer(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt1, jint paramInt2, jint paramInt3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeSwapChainResizeBuffer)
        g_fpGvrApi_nativeSwapChainResizeBuffer( env, obj, paramLong, paramInt1, paramInt2, paramInt3 );
    return;
}
JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainAcquireFrame(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( g_fpGvrApi_nativeSwapChainAcquireFrame)
        re = g_fpGvrApi_nativeSwapChainAcquireFrame( env, obj, paramLong );
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameBindBuffer(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeFrameBindBuffer)
        g_fpGvrApi_nativeFrameBindBuffer( env, obj, paramLong, paramInt );
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameUnbind(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeFrameUnbind)
        g_fpGvrApi_nativeFrameUnbind( env, obj, paramLong );
    return;
}
JNIEXPORT int JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameGetFramebufferObject(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( g_fpGvrApi_nativeFrameGetFramebufferObject)
        re = g_fpGvrApi_nativeFrameGetFramebufferObject( env, obj, paramLong, paramInt );
    return re;
}
JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameGetBufferSize(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jobject paramPoint)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeFrameGetBufferSize)
        g_fpGvrApi_nativeFrameGetBufferSize( env, obj, paramLong, paramInt, paramPoint);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeFrameSubmit(
        JNIEnv* env, jobject obj, jlong paramLong1, jlong paramLong2, jfloatArray paramArrayOfFloat)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeFrameSubmit)
        g_fpGvrApi_nativeFrameSubmit( env, obj, paramLong1, paramLong2, paramArrayOfFloat);
    return;
}

JNIEXPORT jboolean JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeUsingDynamicLibrary(JNIEnv* env, jobject obj)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jboolean re = false;
    if(g_fpGvrApi_nativeUsingDynamicLibrary)
        re = g_fpGvrApi_nativeUsingDynamicLibrary(env, obj);
    return re;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetApplicationState(
        JNIEnv* env, jobject obj, jobject jclassloader, jobject jcontext)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeSetApplicationState)
        g_fpGvrApi_nativeSetApplicationState(env, obj, jclassloader, jcontext);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDynamicLibraryLoadingEnabled(
        JNIEnv* env, jobject obj, jboolean jvar)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeSetDynamicLibraryLoadingEnabled)
        g_fpGvrApi_nativeSetDynamicLibraryLoadingEnabled(env, obj, jvar);
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeResumeTracking(
        JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpGvrApi_nativeResumeTracking)
        g_fpGvrApi_nativeResumeTracking( env, obj, paramLong, paramArrayOfByte );
    return;
}

JNIEXPORT void JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeResumeTrackingSetState(
        JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpGvrApi_nativeResumeTrackingSetState)
        g_fpGvrApi_nativeResumeTrackingSetState(env, obj, paramLong, paramArrayOfByte);
    return;
}

JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetDefaultViewerProfile(
        JNIEnv* env, jobject obj, jlong paramLong, jstring paramString)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if( g_fpGvrApi_nativeSetDefaultViewerProfile)
        re = g_fpGvrApi_nativeSetDefaultViewerProfile( env, obj, paramLong, paramString );
    return re;
}
JNIEXPORT bool JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSetViewerParams(
        JNIEnv* env, jobject obj, jlong paramLong, jbyteArray paramArrayOfByte)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if( g_fpGvrApi_nativeSetViewerParams)
        re = g_fpGvrApi_nativeSetViewerParams( env, obj, paramLong, paramArrayOfByte );
    return re;
}
JNIEXPORT long JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeSwapChainCreate(
        JNIEnv* env, jobject obj, jlong paramLong, jlongArray paramArrayOfLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    long re = 0;
    if( g_fpGvrApi_nativeSwapChainCreate)
        re = g_fpGvrApi_nativeSwapChainCreate( env, obj, paramLong, paramArrayOfLong );
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
    if( g_fpGvrApi_nativeCreate)
        re = g_fpGvrApi_nativeCreate( env, obj, paramClassLoader, paramContext, paramLong, paramInt1, paramInt2, paramFloat1, paramFloat2, paramPoseTracker);
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
    if(g_fpGvrApi_nativeRequestContextSharing)
        g_fpGvrApi_nativeRequestContextSharing(env, obj, paramlong, jvar);
    return;
}

JNIEXPORT jfloatArray JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeComputeDistortedPoint(
        JNIEnv* env, jobject obj, jlong paramLong, jint paramInt, jfloatArray paramArrayOfFloat)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jfloatArray re = 0;
    if( g_fpGvrApi_nativeComputeDistortedPoint)
        re = g_fpGvrApi_nativeComputeDistortedPoint( env, obj, paramLong, paramInt, paramArrayOfFloat );
    return re;
}

JNIEXPORT jstring JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetErrorString(
        JNIEnv* env, jobject obj, jint paramInt )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jstring re = 0;
    if( g_fpGvrApi_nativeGetErrorString)
        re = g_fpGvrApi_nativeGetErrorString( env,obj, paramInt );
    return re;
}

JNIEXPORT jstring JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetViewerVendor(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jstring  re = 0;
    if( g_fpGvrApi_nativeGetViewerVendor)
        re = g_fpGvrApi_nativeGetViewerVendor(env, obj, paramLong);
    return re;
}

JNIEXPORT jstring JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetViewerModel(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jstring  re = 0;
    if( g_fpGvrApi_nativeGetViewerModel)
        re = g_fpGvrApi_nativeGetViewerModel(env, obj, paramLong);
    return re;
}

JNIEXPORT jbyteArray JNICALL Java_com_google_vr_ndk_base_GvrApi_nativePauseTracking(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jbyteArray re = 0;
    if( g_fpGvrApi_nativePauseTracking)
        re = g_fpGvrApi_nativePauseTracking( env, obj, paramLong);
    return re;
}

JNIEXPORT jbyteArray JNICALL Java_com_google_vr_ndk_base_GvrApi_nativePauseTrackingGetState(
        JNIEnv* env, jobject obj, jlong paramLong )
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jbyteArray re = 0;
    if(g_fpGvrApi_nativePauseTrackingGetState)
        re = g_fpGvrApi_nativePauseTrackingGetState(env, obj, paramLong);
    return re;
}

JNIEXPORT jintArray JNICALL Java_com_google_vr_ndk_base_GvrApi_nativeGetWindowBounds(
        JNIEnv* env, jobject obj, jlong paramLong)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    jintArray re = 0;
    if( g_fpGvrApi_nativeGetWindowBounds)
        re = g_fpGvrApi_nativeGetWindowBounds(env, obj, paramLong );
    return re;
}

jint mj_JNI_OnLoad(JavaVM* vm, void* reserved)
{
    InitLoadFun();
    if(g_fpJNI_OnLoad)
        return g_fpJNI_OnLoad(vm, reserved);
    return JNI_VERSION_1_6;
}

void gvr_buffer_viewport_list_destroy(gvr_buffer_viewport_list **viewport_list)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpbuffer_viewport_list_destroy)
        g_fpbuffer_viewport_list_destroy( viewport_list);
    return;
}

void gvr_swap_chain_destroy(gvr_swap_chain **swap_chain)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpswap_chain_destroy)
        g_fpswap_chain_destroy( swap_chain);
    return;
}

void gvr_destroy(gvr_context **gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpdestroy)
        g_fpdestroy( gvr);
    return;
}

void gvr_buffer_viewport_destroy(gvr_buffer_viewport **viewport)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_viewport_destroy)
        g_fpbuffer_viewport_destroy(viewport);
    return;
}

gvr_swap_chain * gvr_swap_chain_create(gvr_context *gvr, const gvr_buffer_spec **buffers, int32_t count)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_swap_chain *re = NULL;
    if( g_fpswap_chain_create)
        re = g_fpswap_chain_create( gvr, buffers, count );
    return re;
}

void gvr_bind_default_framebuffer(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
//    getimagebase();
    InitLoadFun();
    if( g_fpbind_default_framebuffer)
        g_fpbind_default_framebuffer(gvr);
    return;
}

gvr_sizei gvr_get_maximum_effective_render_target_size(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_sizei re;
    if( g_fpget_maximum_effective_render_target_size)
        re = g_fpget_maximum_effective_render_target_size( gvr);
    return re;
}

void gvr_buffer_spec_set_samples(gvr_buffer_spec *spec, int32_t num_samples)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_spec_set_samples)
        g_fpbuffer_spec_set_samples(spec, num_samples );
    return;
}

void gvr_buffer_spec_set_depth_stencil_format(gvr_buffer_spec *spec, int32_t depth_stencil_format)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpbuffer_spec_set_depth_stencil_format)
        g_fpbuffer_spec_set_depth_stencil_format(spec, depth_stencil_format);
    return;
}

void gvr_buffer_spec_set_multiview_layers(gvr_buffer_spec* spec, int32_t num_layers)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_spec_set_multiview_layer)
        g_fpbuffer_spec_set_multiview_layer(spec, num_layers);
    return;
}

void gvr_buffer_spec_set_size(gvr_buffer_spec *spec, gvr_sizei size)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_spec_set_size)
        g_fpbuffer_spec_set_size( spec, size);
    return;
}

gvr_buffer_spec * gvr_buffer_spec_create(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_buffer_spec *re = NULL;
    if(g_fpbuffer_spec_create)
        re = g_fpbuffer_spec_create( gvr );
    return re;
}

void gvr_initialize_gl(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpinitialize_gl)
        g_fpinitialize_gl( gvr);
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
    if(g_fpdistort_to_screen)
        g_fpdistort_to_screen( gvr, texture_id, viewport_list, head_space_from_start_space, target_presentation_time);
    return;
}

bool gvr_is_feature_supported(const gvr_context* gvr, int32_t feature)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if(g_fpis_feature_supported)
        re = g_fpis_feature_supported(gvr, feature);
    return re;
}

gvr_clock_time_point gvr_get_time_point_now()
{
//    gvr_clock_time_point re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_clock_time_point re;
    if(g_fpget_time_point_now)
        re = g_fpget_time_point_now( );
    return re;
}


void gvr_buffer_spec_destroy(gvr_buffer_spec **spec)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_spec_destroy)
        g_fpbuffer_spec_destroy( spec);
    return;
}

gvr_mat4f gvr_get_eye_from_head_matrix(const gvr_context *gvr, const int32_t eye)
{
//    gvr_mat4f re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_mat4f re;
    if(g_fpget_eye_from_head_matrix)
        re = g_fpget_eye_from_head_matrix( gvr, eye);
    return re;
}

gvr_sizei gvr_swap_chain_get_buffer_size(gvr_swap_chain *swap_chain, int32_t index)
{
//    gvr_sizei re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_sizei re;
    if( g_fpswap_chain_get_buffer_size)
        re = g_fpswap_chain_get_buffer_size( swap_chain, index);
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
    if( g_fpcompute_distorted_point)
        g_fpcompute_distorted_point( gvr, eye, uv_in, uv_out);
    return;
}

void gvr_get_recommended_buffer_viewports(const gvr_context *gvr, gvr_buffer_viewport_list *viewport_list)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpget_recommended_buffer_viewports)
        g_fpget_recommended_buffer_viewports( gvr, viewport_list);
    return;
}

bool gvr_buffer_viewport_equal(const gvr_buffer_viewport *a, const gvr_buffer_viewport *b)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if(g_fpbuffer_viewport_equal)
        re = g_fpbuffer_viewport_equal( a, b);
    return re;
}

void gvr_buffer_viewport_list_get_item(const gvr_buffer_viewport_list *viewport_list, size_t index, gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_viewport_list_get_item)
        g_fpbuffer_viewport_list_get_item( viewport_list, index, viewport );
    return;
}

gvr_sizei gvr_buffer_spec_get_size(const gvr_buffer_spec *spec)
{
//    gvr_sizei re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_sizei re;
    if(g_fpbuffer_spec_get_size)
        re = g_fpbuffer_spec_get_size( spec);
    return re;
}

int32_t gvr_buffer_viewport_get_target_eye(const gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int32_t re = 0;
    if(g_fpbuffer_viewport_get_target_eye)
        re = g_fpbuffer_viewport_get_target_eye( viewport);
    return re;
}

int32_t gvr_buffer_spec_get_samples(const gvr_buffer_spec *spec)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int32_t re = 0;
    if(g_fpbuffer_spec_get_samples)
        re = g_fpbuffer_spec_get_samples( spec );
    return re;
}

gvr_rectf gvr_buffer_viewport_get_source_fov(const gvr_buffer_viewport *viewport)
{
//    gvr_rectf re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_rectf re;
    if(g_fpbuffer_viewport_get_source_fov)
        re = g_fpbuffer_viewport_get_source_fov(viewport);
    return re;
}

int32_t gvr_swap_chain_get_buffer_count(const gvr_swap_chain *swap_chain)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int32_t re = 0;
    if( g_fpswap_chain_get_buffer_count)
        re = g_fpswap_chain_get_buffer_count( swap_chain);
    return re;
}

int32_t gvr_buffer_viewport_get_reprojection(const gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int32_t re = 0;
    if(g_fpbuffer_viewport_get_reprojection)
        re = g_fpbuffer_viewport_get_reprojection( viewport);
    return re;
}

void gvr_buffer_viewport_set_reprojection(gvr_buffer_viewport *viewport, int32_t reprojection)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_viewport_set_reprojection)
        g_fpbuffer_viewport_set_reprojection( viewport, reprojection );
    return;
}

void gvr_buffer_viewport_set_source_layer(gvr_buffer_viewport* viewport, int32_t layer_index)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_viewport_set_source_layer)
        g_fpbuffer_viewport_set_source_layer(viewport, layer_index);
    return;
}

void gvr_buffer_viewport_set_source_uv(gvr_buffer_viewport *viewport, gvr_rectf uv)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_viewport_set_source_uv)
        g_fpbuffer_viewport_set_source_uv( viewport, uv);
    return;
}

void gvr_buffer_viewport_list_set_item(
        gvr_buffer_viewport_list *viewport_list,
        size_t index,
        const gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_viewport_list_set_item)
        g_fpbuffer_viewport_list_set_item( viewport_list, index, viewport );
    return;
}

int32_t gvr_user_prefs_get_controller_handedness(const gvr_user_prefs *user_prefs)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int32_t re = 0;
    if( g_fpuser_prefs_get_controller_handedness)
        re = g_fpuser_prefs_get_controller_handedness( user_prefs);
    return re;
}

void gvr_get_screen_buffer_viewports(const gvr_context *gvr, gvr_buffer_viewport_list *viewport_list)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpget_screen_buffer_viewports)
        g_fpget_screen_buffer_viewports( gvr, viewport_list);
    return;
}

gvr_sizei gvr_get_screen_target_size(const gvr_context *gvr)
{
//    gvr_sizei re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_sizei re;
    if(g_fpget_screen_target_size)
        re = g_fpget_screen_target_size( gvr);
    return re;
}

gvr_rectf gvr_buffer_viewport_get_source_uv(const gvr_buffer_viewport *viewport)
{
//    gvr_rectf re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_rectf re;
    if(g_fpbuffer_viewport_get_source_uv)
        re = g_fpbuffer_viewport_get_source_uv( viewport);
    return re;
}

gvr_recti gvr_get_window_bounds(const gvr_context *gvr)
{
//    gvr_recti re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_recti re;
    if(g_fpget_window_bounds)
        re = g_fpget_window_bounds( gvr);
    return re;
}

gvr_mat4f gvr_get_head_space_from_start_space_rotation(const gvr_context *gvr, const gvr_clock_time_point time)
{
//    gvr_mat4f re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_mat4f re;
    if(g_fpget_head_space_from_start_space_rotation)
        re = g_fpget_head_space_from_start_space_rotation( gvr, time);
    return re;
}

gvr_mat4f gvr_apply_neck_model(const gvr_context *gvr, gvr_mat4f head_space_from_start_space_rotation, float factor)
{
//    gvr_mat4f re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_mat4f re;
    if(g_fpapply_neck_model)
        re = g_fpapply_neck_model( gvr, head_space_from_start_space_rotation, factor);
    return re;
}

gvr_frame * gvr_swap_chain_acquire_frame(gvr_swap_chain *swap_chain)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_frame *pframe = NULL;
    if(g_fpswap_chain_acquire_frame)
        pframe = g_fpswap_chain_acquire_frame( swap_chain);
    LOGE("gvr_swap_chain_acquire_frame gvr_frame:%p", pframe);
    return pframe;
}

gvr_context * gvr_create(JNIEnv *env, jobject app_context, jobject class_loader)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_context *re = NULL;
    if(g_fpcreate)
        re = g_fpcreate(env, app_context, class_loader );
    return re;
}

void gvr_frame_bind_buffer(gvr_frame *frame, int32_t index)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpframe_bind_buffer)
        g_fpframe_bind_buffer(frame, index);
    return;
}

void gvr_frame_unbind(gvr_frame *frame)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpframe_unbind)
        g_fpframe_unbind(frame);
    return;
}

gvr_gesture_context* gvr_gesture_context_create()
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpgesture_context_create)
        return g_fpgesture_context_create();
    else
        return NULL;
}

void gvr_gesture_context_destroy(gvr_gesture_context** context)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpgesture_context_destroy)
        g_fpgesture_context_destroy(context);
    return;
}

const gvr_gesture* gvr_gesture_get(const gvr_gesture_context* context, int index)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpgesture_get)
        return g_fpgesture_get(context, index);
    else
        return NULL;
}

int gvr_gesture_get_count(const gvr_gesture_context* context)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpgesture_get_count)
        return g_fpgesture_get_count(context);
    return 0;
}

gvr_gesture_direction gvr_gesture_get_direction(const gvr_gesture* gesture)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpgesture_get_direction)
        return g_fpgesture_get_direction(gesture);
    return GVR_GESTURE_DIRECTION_UP;
}

gvr_vec2f gvr_gesture_get_displacement(const gvr_gesture* gesture)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_vec2f re;
    if(g_fpgesture_get_displacement)
        re = g_fpgesture_get_displacement(gesture);
    return re;
}

gvr_gesture_type gvr_gesture_get_type(const gvr_gesture* gesture)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_gesture_type re = GVR_GESTURE_SWIPE;
    if(g_fpgesture_get_type)
        re = g_fpgesture_get_type(gesture);
    return  re;
}

gvr_vec2f gvr_gesture_get_velocity(const gvr_gesture* gesture)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_vec2f re;
    if(g_fpgesture_get_velocity)
        re = g_fpgesture_get_velocity(gesture);
    return re;
}

void gvr_gesture_restart(gvr_gesture_context* context)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpgesture_restart)
        g_fpgesture_restart(context);
    return;
}

void gvr_gesture_update(const gvr_controller_state* controller_state, gvr_gesture_context* context)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpgesture_update)
        g_fpgesture_update(controller_state, context);
    return;
}

void gvr_frame_submit(gvr_frame **frame, const gvr_buffer_viewport_list *list, gvr_mat4f head_space_from_start_space)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpframe_submit)
        g_fpframe_submit(frame, list, head_space_from_start_space );
    return;
}

void gvr_swap_chain_resize_buffer(gvr_swap_chain *swap_chain, int32_t index, gvr_sizei size)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpswap_chain_resize_buffer)
        g_fpswap_chain_resize_buffer( swap_chain, index, size);
    return;
}

gvr_buffer_viewport_list * gvr_buffer_viewport_list_create(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_buffer_viewport_list *re = NULL;
    if( g_fpbuffer_viewport_list_create)
        re = g_fpbuffer_viewport_list_create( gvr);
    return re;
}

const gvr_user_prefs * gvr_get_user_prefs(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpget_user_prefs)
        return g_fpget_user_prefs( gvr);
    else
        return NULL;
}

gvr_buffer_viewport * gvr_buffer_viewport_create(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_viewport_create)
        return g_fpbuffer_viewport_create( gvr);
    else
        return NULL;
}

gvr_version gvr_get_version()
{
//    gvr_version re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_version re;
    if(g_fpget_version)
        re = g_fpget_version();
    return re;
}

const char * gvr_get_viewer_vendor(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpget_viewer_vendor)
        return g_fpget_viewer_vendor( gvr);
    else
        return NULL;
}

const char * gvr_get_version_string()
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpget_version_string)
        return g_fpget_version_string();
    else
        return NULL;
}

const char * gvr_get_viewer_model(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpget_viewer_model)
        return g_fpget_viewer_model( gvr);
    else
        return NULL;
}

int32_t gvr_get_error(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpget_error)
        return g_fpget_error(gvr);
    else
        return 0;
}

int32_t gvr_get_viewer_type(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpget_viewer_type)
        return g_fpget_viewer_type( gvr);
    else
        return 0;
}

int32_t gvr_clear_error(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpclear_error)
        return g_fpclear_error( gvr);
    else
        return 0;
}

const char * gvr_get_error_string(int32_t error_code)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpget_error_string)
        return g_fpget_error_string( error_code );
    else
        return NULL;
}

int32_t gvr_buffer_viewport_get_source_buffer_index(const gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpbuffer_viewport_get_source_buffer_index)
        return g_fpbuffer_viewport_get_source_buffer_index( viewport);
    else
        return 0;
}

bool gvr_get_async_reprojection_enabled(const gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpget_async_reprojection_enabled)
        return g_fpget_async_reprojection_enabled( gvr);
    return false;
}

void gvr_buffer_viewport_set_source_buffer_index(gvr_buffer_viewport *viewport, int32_t buffer_index)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_viewport_set_source_buffer_index)
        g_fpbuffer_viewport_set_source_buffer_index(viewport, buffer_index);
    return;
}

size_t gvr_buffer_viewport_list_get_size(const gvr_buffer_viewport_list *viewport_list)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_viewport_list_get_size)
        return g_fpbuffer_viewport_list_get_size(viewport_list);
    return 0;
}

int32_t gvr_buffer_viewport_get_external_surface_id(const gvr_buffer_viewport *viewport)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_viewport_get_external_surface_id)
        return g_fpbuffer_viewport_get_external_surface_id( viewport);
    return 0;
}

void gvr_buffer_viewport_set_external_surface_id(gvr_buffer_viewport *viewport, int32_t external_surface_id)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_viewport_set_external_surface_id)
        g_fpbuffer_viewport_set_external_surface_id( viewport, external_surface_id );
    return;
}

void gvr_set_surface_size(gvr_context *gvr, gvr_sizei surface_size_pixels)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpset_surface_size)
        g_fpset_surface_size( gvr, surface_size_pixels);
    return;
}

gvr_mat4f gvr_buffer_viewport_get_transform(const gvr_buffer_viewport *viewport)
{
//    gvr_mat4f re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_mat4f re;
    if(g_fpbuffer_viewport_get_transform)
        re = g_fpbuffer_viewport_get_transform( viewport);
    return re;
}

void gvr_buffer_spec_set_color_format(gvr_buffer_spec *spec, int32_t color_format)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_spec_set_color_format)
        g_fpbuffer_spec_set_color_format( spec, color_format);
    return;
}

void gvr_buffer_viewport_set_transform(gvr_buffer_viewport *viewport, gvr_mat4f transform)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_viewport_set_transform)
        g_fpbuffer_viewport_set_transform( viewport, transform);
    return;
}

void gvr_buffer_viewport_set_target_eye(gvr_buffer_viewport *viewport, int32_t index)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_viewport_set_target_eye)
        g_fpbuffer_viewport_set_target_eye(viewport, index);
    return;
}

gvr_sizei gvr_frame_get_buffer_size(const gvr_frame *frame, int32_t index)
{
//    gvr_sizei re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_sizei re;
    if(g_fpframe_get_buffer_size)
        re = g_fpframe_get_buffer_size(frame, index);
    return re;
}

int32_t gvr_frame_get_framebuffer_object(const gvr_frame *frame, int32_t index)
{
    //sub_26CD8  ->sub_68EE4->sub_6486C
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpframe_get_framebuffer_object)
        return g_fpframe_get_framebuffer_object(frame, index);
    return 0;
}

void gvr_pause_tracking(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fppause_tracking)
        g_fppause_tracking( gvr);
    return;
}

void gvr_buffer_viewport_set_source_fov(gvr_buffer_viewport *viewport, gvr_rectf fov)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpbuffer_viewport_set_source_fov)
        g_fpbuffer_viewport_set_source_fov( viewport, fov);
    return;
}

void gvr_resume_tracking(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpresume_tracking)
        g_fpresume_tracking(gvr);
    return;
}

void gvr_reset_tracking(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpreset_tracking)
        g_fpreset_tracking(gvr);
    return;
}

void gvr_recenter_tracking(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fprecenter_tracking)
        g_fprecenter_tracking( gvr);
    return;
}

bool gvr_set_default_viewer_profile(gvr_context *gvr, const char *viewer_profile_uri)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpset_default_viewer_profile)
        return g_fpset_default_viewer_profile( gvr, viewer_profile_uri );
    return false;
}

void gvr_refresh_viewer_profile(gvr_context *gvr)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fprefresh_viewer_profile)
        g_fprefresh_viewer_profile( gvr);
    return;
}


gvr_controller_context * gvr_controller_create_and_init(int32_t options,gvr_context *context)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_create_and_init)
        return g_fpcontroller_create_and_init( options, context);
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
    if( g_fpcontroller_create_and_init_android)
        return g_fpcontroller_create_and_init_android( env, android_context, class_loader, options, context );
    return NULL;
}

void gvr_controller_destroy(gvr_controller_context **api)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_destroy)
        g_fpcontroller_destroy(api);
    return;
}

void gvr_controller_pause(gvr_controller_context *api)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_pause)
        g_fpcontroller_pause( api);
    return;
}

void gvr_controller_resume( gvr_controller_context *api)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpcontroller_resume)
        g_fpcontroller_resume(api);
    return;
}

const char * gvr_controller_api_status_to_string(  int32_t status)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_api_status_to_string)
        return g_fpcontroller_api_status_to_string(status);
    return NULL;
}

const char* gvr_controller_battery_level_to_string(int32_t level)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_battery_level_to_string)
        return g_fpcontroller_battery_level_to_string(level);
    return NULL;
}

const char * gvr_controller_connection_state_to_string(int32_t state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_connection_state_to_string)
        return g_fpcontroller_connection_state_to_string(state);
    return nullptr;
}

const char * gvr_controller_button_to_string(int32_t button)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_button_to_string)
        return g_fpcontroller_button_to_string( button);
    return nullptr;
}

gvr_controller_state * gvr_controller_state_create()
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_state_create)
        return g_fpcontroller_state_create();
    return nullptr;
}

void gvr_controller_state_destroy(gvr_controller_state **state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_state_destroy)
        g_fpcontroller_state_destroy( state);
    return;
}

void gvr_controller_state_update(gvr_controller_context *api, int32_t flags, gvr_controller_state *out_state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_state_update)
        g_fpcontroller_state_update(api, flags, out_state);
    return;
}

int32_t gvr_controller_state_get_api_status(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_state_get_api_status)
        return g_fpcontroller_state_get_api_status( state);
    return 0;
}

int32_t gvr_controller_state_get_connection_state(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpcontroller_state_get_connection_state)
        return g_fpcontroller_state_get_connection_state( state);
    return 0;
}

gvr_quatf gvr_controller_state_get_orientation(const gvr_controller_state *state)
{
//    gvr_quatf re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_quatf re;
    if( g_fpcontroller_state_get_orientation)
        re = g_fpcontroller_state_get_orientation(state);
    return re;
}

gvr_vec3f gvr_controller_state_get_gyro(const gvr_controller_state *state)
{
//    gvr_vec3f re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_vec3f re;
    if(g_fpcontroller_state_get_gyro)
        re = g_fpcontroller_state_get_gyro( state);
    return re;
}

gvr_vec3f gvr_controller_state_get_accel(const gvr_controller_state *state)
{
//    gvr_vec3f re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_vec3f re;
    if(g_fpcontroller_state_get_accel)
        re = g_fpcontroller_state_get_accel(state);
    return re;
}

bool gvr_controller_state_get_battery_charging(const gvr_controller_state* state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if(g_fpcontroller_state_get_battery_charging)
        re = g_fpcontroller_state_get_battery_charging(state);
    return re;
}

int32_t gvr_controller_state_get_battery_level(const gvr_controller_state* state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int32_t re = 0;
    if(g_fpcontroller_state_get_battery_level)
        re = g_fpcontroller_state_get_battery_level(state);
    return re;
}

bool gvr_controller_state_is_touching(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_state_is_touching)
        return g_fpcontroller_state_is_touching(state);
    return false;
}

gvr_vec2f gvr_controller_state_get_touch_pos(const gvr_controller_state *state)
{
//    gvr_vec2f re;
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    gvr_vec2f re;
    if( g_fpcontroller_state_get_touch_pos)
        re = g_fpcontroller_state_get_touch_pos(state);
    return re;
}

bool gvr_controller_state_get_touch_down(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_state_get_touch_down)
        return g_fpcontroller_state_get_touch_down(state);
    return false;
}

bool gvr_controller_state_get_touch_up(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_state_get_touch_up)
        return g_fpcontroller_state_get_touch_up(state);
    return false;
}

bool gvr_controller_state_get_recentered(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpcontroller_state_get_recentered)
        return g_fpcontroller_state_get_recentered(state);
    return false;
}

bool gvr_controller_state_get_recentering(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_state_get_recentering)
        return g_fpcontroller_state_get_recentering( state);
    return false;
}

bool gvr_controller_state_get_button_state(const gvr_controller_state *state, int32_t button)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpcontroller_state_get_button_state)
        return g_fpcontroller_state_get_button_state( state, button);
    return false;
}

bool gvr_controller_state_get_button_down(const gvr_controller_state *state, int32_t button)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpcontroller_state_get_button_down)
        return g_fpcontroller_state_get_button_down(state, button);
    return false;
}

bool gvr_controller_state_get_button_up(const gvr_controller_state *state, int32_t button)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_state_get_button_up)
        return g_fpcontroller_state_get_button_up( state, button);
    return false;
}

int64_t gvr_controller_state_get_last_orientation_timestamp(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_state_get_last_orientation_timestamp)
        return g_fpcontroller_state_get_last_orientation_timestamp(state);
    return 0;
}

int64_t gvr_controller_state_get_last_battery_timestamp(const gvr_controller_state* state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int64_t re = 0;
    if(g_fpcontroller_state_get_last_battery_timestamp)
        re = g_fpcontroller_state_get_last_battery_timestamp(state);
    return re;
}

int64_t gvr_controller_state_get_last_gyro_timestamp(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_state_get_last_gyro_timestamp)
        return g_fpcontroller_state_get_last_gyro_timestamp(state);
    return 0;
}

int64_t gvr_controller_state_get_last_accel_timestamp(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_state_get_last_accel_timestamp)
        return g_fpcontroller_state_get_last_accel_timestamp(state);
    return 0;
}

int64_t gvr_controller_state_get_last_touch_timestamp(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_state_get_last_touch_timestamp)
        return g_fpcontroller_state_get_last_touch_timestamp( state);
    return 0;
}

int64_t gvr_controller_state_get_last_button_timestamp(const gvr_controller_state *state)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_state_get_last_button_timestamp)
        return g_fpcontroller_state_get_last_button_timestamp(state);
    return 0;
}

int32_t gvr_controller_get_default_options()
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcontroller_get_default_options)
        return g_fpcontroller_get_default_options();
    return 0;
}

/////////////////////////
/////////////////////
int gvr_set_viewer_params(int *a1, const void *a2, size_t a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( g_fpset_viewer_params)
        re = g_fpset_viewer_params( a1, a2, a3);
    return re;
}
int gvr_set_display_metrics( int *a1, int a2, int a3, int a4, int a5, int a6)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(g_fpset_display_metrics)
        re = g_fpset_display_metrics( a1, a2, a3, a4, a5, a6);
    return re;
}
int gvr_set_back_gesture_event_handler(int a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpset_back_gesture_event_handler)
        return g_fpset_back_gesture_event_handler( a1, a2, a3);
    else
        return 0;
}
int gvr_display_synchronizer_create()
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpdisplay_synchronizer_create)
        return g_fpdisplay_synchronizer_create();
    return 0;
}

int gvr_display_synchronizer_destroy(int *a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpdisplay_synchronizer_destroy)
        return g_fpdisplay_synchronizer_destroy(a1);
    return 0;
}

int gvr_get_border_size_meters(void *a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpget_border_size_meters)
        return g_fpget_border_size_meters( a1);
    return 0;
}

bool gvr_get_button_long_press(const gvr_controller_state* controller_state, const gvr_gesture_context* context, gvr_controller_button button)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if(g_fpget_button_long_press)
        re = g_fpget_button_long_press(controller_state, context, button);
    return re;
}

int gvr_check_surface_size_changed(int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcheck_surface_size_changed)
        return g_fpcheck_surface_size_changed( a1);
    return 0;
}

int gvr_get_surface_size(int a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpget_surface_size)
        return g_fpget_surface_size( a1, a2, a3);
    return 0;
}

int gvr_set_display_output_rotation(void *a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpset_display_output_rotation)
        return g_fpset_display_output_rotation( a1, a2);
    return 0;
}

int gvr_reconnect_sensors( void *a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpreconnect_sensors)
        return g_fpreconnect_sensors(a1);
    return 0;
}

int gvr_set_lens_offset(int *a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpset_lens_offset)
        return g_fpset_lens_offset( a1, a2, a3);
    return 0;
}

int gvr_resume(int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpresume)
        return g_fpresume(a1);
    return 0;
}

int gvr_dump_debug_data(void *a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpdump_debug_data)
        return g_fpdump_debug_data( a1);
    return 0;
}


int gvr_external_surface_create_with_listeners(int a1, int a2, int a3, int a4)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(g_fpexternal_surface_create_with_listeners)
        re = g_fpexternal_surface_create_with_listeners(a1, a2, a3, a4);
    return re;
}

int gvr_external_surface_destroy(void **a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(g_fpexternal_surface_destroy)
        re = g_fpexternal_surface_destroy(a1, a2, a3);
    return re;
}

int gvr_external_surface_get_surface(int a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(g_fpexternal_surface_get_surface)
        re = g_fpexternal_surface_get_surface(a1, a2, a3);
    return re;
}

int gvr_external_surface_get_surface_id(int *a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(g_fpexternal_surface_get_surface_id)
        re = g_fpexternal_surface_get_surface_id(a1, a2, a3);
    return re;
}

bool gvr_using_dynamic_library(int a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    bool re = false;
    if(g_fpusing_dynamic_library)
        re = g_fpusing_dynamic_library(a1, a2, a3);
    return re;
}

int gvr_using_vr_display_service( int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpusing_vr_display_service)
        return g_fpusing_vr_display_service(a1);
    return 0;
}

int gvr_tracker_state_get_buffer_size(int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fptracker_state_get_buffer_size)
        return g_fptracker_state_get_buffer_size(a1);
    return 0;
}

int gvr_tracker_state_get_buffer(int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fptracker_state_get_buffer)
        return g_fptracker_state_get_buffer(a1);
    return 0;
}

int gvr_pause(int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fppause)
        return g_fppause(a1);
    return 0;
}

int gvr_set_ignore_manual_tracker_pause_resume(void *a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpset_ignore_manual_tracker_pause_resume)
        return g_fpset_ignore_manual_tracker_pause_resume(a1, a2);
    return 0;
}

int gvr_display_synchronizer_update(int *a1, int a2, int64_t a3, int a4)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpdisplay_synchronizer_update)
        return g_fpdisplay_synchronizer_update(a1, a2, a3, a4);
    return 0;
}

int gvr_remove_all_surfaces_reprojection_thread(void *a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpremove_all_surfaces_reprojection_thread)
        return g_fpremove_all_surfaces_reprojection_thread( a1);
    return 0;
}

int gvr_set_async_reprojection_enabled(int a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpset_async_reprojection_enabled)
        return g_fpset_async_reprojection_enabled(a1, a2);
    return 0;
}

int gvr_on_surface_created_reprojection_thread( int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpon_surface_created_reprojection_thread)
        return g_fpon_surface_created_reprojection_thread(a1);
    return 0;
}

int gvr_render_reprojection_thread(int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fprender_reprojection_thread)
        return g_fprender_reprojection_thread( a1);
    return 0;
}

int gvr_tracker_state_destroy( int *a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fptracker_state_destroy)
        return g_fptracker_state_destroy( a1);
    return 0;
}

int gvr_resume_tracking_set_state(int a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpresume_tracking_set_state)
        return g_fpresume_tracking_set_state( a1, a2, a3);
    return 0;
}

int gvr_pause_tracking_get_state( void *a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fppause_tracking_get_state)
        return g_fppause_tracking_get_state(a1);
    return 0;
}

int gvr_tracker_state_create(int a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fptracker_state_create)
        return g_fptracker_state_create( a1,a2);
    return 0;
}

int gvr_create_with_tracker_for_testing( int a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpcreate_with_tracker_for_testing)
        return g_fpcreate_with_tracker_for_testing(a1, a2);
    return 0;
}

int gvr_set_error(int a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(g_fpset_error)
        re = g_fpset_error( a1, a2);
    return re;
}

int gvr_set_idle_listener(int *a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if(g_fpset_idle_listener)
        re = g_fpset_idle_listener(a1, a2, a3);
    return re;
}

int gvr_set_display_synchronizer( int *a1, int a2)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpset_display_synchronizer)
        return g_fpset_display_synchronizer(a1, a2);
    return 0;
}

int gvr_display_synchronizer_reset(void *a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpdisplay_synchronizer_reset)
        return g_fpdisplay_synchronizer_reset(a1);
    return 0;
}

int gvr_on_pause_reprojection_thread(int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpon_pause_reprojection_thread)
        return g_fpon_pause_reprojection_thread( a1);
    return 0;
}

int gvr_on_surface_changed_reprojection_thread(int a1, int a2, int a3)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if(g_fpon_surface_changed_reprojection_thread)
        return g_fpon_surface_changed_reprojection_thread(a1, a2, a3);
    return 0;
}

int gvr_update_surface_reprojection_thread(int *a1, int a2, int a3, int a4, int64_t a5,
                                           int a6, int a7, int a8, int a9, int a10, int a11,
                                           int a12, int a13, int a14, int a15, int a16, int a17,
                                           int a18, int a19, int a20, int a21)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    if( g_fpupdate_surface_reprojection_thread)
        return g_fpupdate_surface_reprojection_thread(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21);
    return 0;
}

int Java_com_google_geo_render_mirth_api_MirthNet_setHttpProxy(int a1)
{
    CLogMessage msg(__FUNCTION__);
    InitLoadFun();
    int re = 0;
    if( g_fpMirthNet_setHttpProxy)
        re = g_fpMirthNet_setHttpProxy( a1);
    return re;
}

