#include <dlfcn.h>
#include <cwchar>
#include <memory.h>
#include <jni.h>
#include <CallStack.h>
#include <syscallstack.h>
#include <mjtype.h>
#include <pthread.h>
#include <gleshook/log.h>
#include <glresource.h>
#include "gvrhookfn.h"
#include "detour.h"
#include "mjgvr.h"


void * g_hGVR = NULL;

#define fn_JNI_OnLoad "JNI_OnLoad"
jint (*old_JNI_OnLoad)(JavaVM* vm, void* reserved) = NULL;
jint GVR_JNI_OnLoad(JavaVM* vm, void* reserved)
{
    LOGITAG("mjgvr","mj_JNI_OnLoad, tid=%d", gettid());
    return old_JNI_OnLoad(vm, reserved);
}


#define fn_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled "Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled"
bool (*old_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled)(JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBool) = NULL;
bool mj_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled(JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBool)
{
	LOGITAG("mjgvr","mj_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled, tid=%d", gettid());
    bool re = old_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled(env, obj, paramLong, paramBool);
	return re;
}

#define fn_gvr_set_async_reprojection_enabled "gvr_set_async_reprojection_enabled"
int (*old_gvr_set_async_reprojection_enabled)(gvr_context * a1, int a2) = NULL;
int mj_gvr_set_async_reprojection_enabled(gvr_context *a1, int a2)
{
    // sub_28DC8  sub_95960
    LOGITAG("mjgvr","mj_gvr_set_async_reprojection_enabled, a1=%x, tid=%d", a1, gettid());
//    return  true;
    int re = old_gvr_set_async_reprojection_enabled(a1, a2);
//    fn_set_async_reprojection_enabled pfun = a1->user_prefs->p001->pfun04;
//    int re = pfun(a1->user_prefs);
    return re;
}

#define fn_Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate "Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate"
long (*old_Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate)(JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext) = NULL;
long mj_Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate(JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext)
{
	LOGITAG("mjgvr","mj_Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate, tid=%d", gettid());
	return old_Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate(env, obj, paramClassLoader, paramContext);
}

#define fn_Java_com_google_vr_ndk_base_GvrApi_nativeGetAsyncReprojectionEnabled "Java_com_google_vr_ndk_base_GvrApi_nativeGetAsyncReprojectionEnabled"
bool (*old_Java_com_google_vr_ndk_base_GvrApi_nativeGetAsyncReprojectionEnabled)(JNIEnv* env, jobject obj, jlong paramLong ) = NULL;
bool mj_Java_com_google_vr_ndk_base_GvrApi_nativeGetAsyncReprojectionEnabled(JNIEnv* env, jobject obj, jlong paramLong)
{
    LOGITAG("mjgvr","Java_com_google_vr_ndk_base_GvrApi_nativeGetAsyncReprojectionEnabled, tid=%d", gettid());
    bool re =  old_Java_com_google_vr_ndk_base_GvrApi_nativeGetAsyncReprojectionEnabled(env, obj, paramLong);
//    bool re = false;
    return re;
}

#define fn_Java_com_google_vr_ndk_base_GvrApi_nativeCreate 	"Java_com_google_vr_ndk_base_GvrApi_nativeCreate"
long (*old_Java_com_google_vr_ndk_base_GvrApi_nativeCreate)(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext, jlong paramLong, jint paramInt1,
        jint paramInt2, jfloat paramFloat1, jfloat paramFloat2, jobject paramPoseTracker) = NULL;
long mj_Java_com_google_vr_ndk_base_GvrApi_nativeCreate(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext, jlong paramLong, jint paramWidth,
        jint paramHeight, jfloat paramFloat1, jfloat paramFloat2, jobject paramPoseTracker)
{
    LOGITAG("mjgvr","mj_Java_com_google_vr_ndk_base_GvrApi_nativeCreate, tid=%d", gettid());
    long re = 0;
    re = old_Java_com_google_vr_ndk_base_GvrApi_nativeCreate(env, obj, paramClassLoader, paramContext, paramLong,
                                                           paramWidth, paramHeight, paramFloat1, paramFloat2, paramPoseTracker);
    return re;
}

#define fn_Java_com_google_vr_ndk_base_GvrApi_nativeUsingVrDisplayService "Java_com_google_vr_ndk_base_GvrApi_nativeUsingVrDisplayService"
bool (*old_Java_com_google_vr_ndk_base_GvrApi_nativeUsingVrDisplayService)(JNIEnv* env, jobject obj, jlong paramLong) = NULL;
bool mj_Java_com_google_vr_ndk_base_GvrApi_nativeUsingVrDisplayService(JNIEnv* env, jobject obj, jlong paramLong)
{
    LOGITAG("mjgvr","mj_Java_com_google_vr_ndk_base_GvrApi_nativeUsingVrDisplayService, tid=%d", gettid());
//    bool re = true;
    bool re = old_Java_com_google_vr_ndk_base_GvrApi_nativeUsingVrDisplayService(env, obj, paramLong);
    return re;
}

#define fn_gvr_using_dynamic_library "gvr_using_dynamic_library"
bool (*old_gvr_using_dynamic_library)() = NULL;
bool mj_gvr_using_dynamic_library()
{
	LOGITAG("mjgvr","mj_gvr_using_dynamic_library, tid=%d", gettid());
    bool re = old_gvr_using_dynamic_library();
	return re;
}

int (*old_sub_24738)() = NULL;
int mj_sub_24738()
{
    LOGITAG("mjgvr","mj_sub_24738, tid=%d", gettid());
    int re = old_sub_24738();
    return re;
}

st68CA4 * gst68CA4;
st68CA4 *(*old_sub_68CA4)(void *a1, int a2) = NULL;
st68CA4 *mj_sub_68CA4(void *a1, int a2)
{
    LOGITAG("mjgvr","mj_sub_68CA4, tid=%d", gettid());
    st68CA4 *pdata = old_sub_68CA4(a1, a2);
    gst68CA4 = pdata;
    return pdata;
}

#define fn_gvr_create_with_tracker_for_testing "gvr_create_with_tracker_for_testing"
int (*old_gvr_create_with_tracker_for_testing)( int a1, int a2) = NULL;
int mj_gvr_create_with_tracker_for_testing( int a1, int a2)
{
    LOGITAG("mjgvr","mj_gvr_create_with_tracker_for_testing, tid=%d", gettid());
    return old_gvr_create_with_tracker_for_testing(a1, a2);
}

#define fn_gvr_create "gvr_create"
gvr_context * (*old_gvr_create)(JNIEnv *env, jobject app_context, jobject class_loader) = NULL;
gvr_context * mj_gvr_create(JNIEnv *env, jobject app_context, jobject class_loader)
{
//    CallStack stack;
//    stack.dump();
	sys_call_stack();
	LOGITAG("mjgvr","mj_gvr_create, tid=%d", gettid());
    gvr_context *re = NULL;
//    sub_C1324("GVR");
	re = old_gvr_create(env, app_context, class_loader);
    return re;
}

#define fn_gvr_get_error "gvr_get_error"
int32_t (*old_gvr_get_error)(gvr_context* gvr) = NULL;
int32_t mj_gvr_get_error(gvr_context* gvr)
{
    LOGITAG("mjgvr","mj_gvr_get_error, tid=%d", gettid());
    return old_gvr_get_error(gvr);
}

#define fn_gvr_clear_error "gvr_clear_error"
int32_t (*old_gvr_clear_error)(gvr_context* gvr) = NULL;
int32_t mj_gvr_clear_error(gvr_context* gvr)
{
	LOGITAG("mjgvr","mj_gvr_clear_error, tid=%d", gettid());
	return old_gvr_clear_error(gvr);
}

#define fn_gvr_pause_tracking "gvr_pause_tracking"
void (*old_gvr_pause_tracking)(gvr_context* gvr) = NULL;
void mj_gvr_pause_tracking(gvr_context* gvr)
{
    LOGITAG("mjgvr","mj_gvr_pause_tracking, tid=%d", gettid());
    return old_gvr_pause_tracking(gvr);
}

#define fn_gvr_resume_tracking "gvr_resume_tracking"
void (*old_gvr_resume_tracking)(gvr_context* gvr) = NULL;
void mj_gvr_resume_tracking(gvr_context* gvr)
{
    LOGITAG("mjgvr","mj_gvr_resume_tracking, tid=%d", gettid());
    fn_resume_tracking resume_tracking = (gvr->user_prefs->p001->pfun36);
    return resume_tracking(gvr->user_prefs);
}

#define fn_gvr_reset_tracking "gvr_reset_tracking"
void (*old_gvr_reset_tracking)(gvr_context* gvr) = NULL;
void mj_gvr_reset_tracking(gvr_context* gvr)
{
	LOGITAG("mjgvr","mj_gvr_reset_tracking, tid=%d", gettid());
	return old_gvr_reset_tracking(gvr);
}

#define fn_gvr_recenter_tracking "gvr_recenter_tracking"
void (*old_gvr_recenter_tracking)(gvr_context* gvr) = NULL;
void mj_gvr_recenter_tracking(gvr_context* gvr)
{
	LOGITAG("mjgvr","mj_gvr_recenter_tracking, tid=%d", gettid());
	return old_gvr_recenter_tracking(gvr);
}

#define fn_gvr_set_default_viewer_profile "gvr_set_default_viewer_profile"
bool (*old_gvr_set_default_viewer_profile)(gvr_context* gvr, const char* viewer_profile_uri) = NULL;
bool mj_gvr_set_default_viewer_profile(gvr_context* gvr, const char* viewer_profile_uri)
{
    LOGITAG("mjgvr","mj_gvr_set_default_viewer_profile, tid=%d", gettid());
    return old_gvr_set_default_viewer_profile(gvr, viewer_profile_uri);
}

#define fn_gvr_refresh_viewer_profile "gvr_refresh_viewer_profile"
void (*old_gvr_refresh_viewer_profile)(gvr_context* gvr) = NULL;
void mj_gvr_refresh_viewer_profile(gvr_context* gvr)
{
    LOGITAG("mjgvr","mj_gvr_refresh_viewer_profile, tid=%d", gettid());
    return old_gvr_refresh_viewer_profile(gvr);
}

#define fn_gvr_get_viewer_vendor "gvr_get_viewer_vendor"
const char* (*old_gvr_get_viewer_vendor)(const gvr_context* gvr) = NULL;
const char* mj_gvr_get_viewer_vendor(const gvr_context* gvr)
{
    LOGITAG("mjgvr","gvr_get_viewer_vendor, tid=%d", gettid());
    return old_gvr_get_viewer_vendor(gvr);
}

#define fn_gvr_get_viewer_model "gvr_get_viewer_model"
const char* (*old_gvr_get_viewer_model)(const gvr_context* gvr) = NULL;
const char* mj_gvr_get_viewer_model(const gvr_context* gvr)
{
    LOGITAG("mjgvr","mj_gvr_get_viewer_model, tid=%d", gettid());
    return old_gvr_get_viewer_model(gvr);
}


#define fn_gvr_get_viewer_type "gvr_get_viewer_type"
int32_t (*old_gvr_get_viewer_type)(const gvr_context* gvr) = NULL;
int32_t mj_gvr_get_viewer_type(const gvr_context* gvr)
{
    LOGITAG("mjgvr","mj_gvr_get_viewer_type, tid=%d", gettid());
//	fn_get_viewer_type get_viewer_type = NULL;
//    void *pdata = (void*)((int)gvr->user_prefs->p001 + 0xAC);
//    get_viewer_type = (gvr->user_prefs->p001->pfun43);
//    int32_t re = get_viewer_type(gvr->user_prefs);
    int32_t re = old_gvr_get_viewer_type(gvr);
    return re;
}

#define fn_gvr_get_eye_from_head_matrix "gvr_get_eye_from_head_matrix"
gvr_mat4f (*old_gvr_get_eye_from_head_matrix)(const gvr_context* gvr, const int32_t eye)= NULL;
gvr_mat4f mj_gvr_get_eye_from_head_matrix(const gvr_context* gvr, const int32_t eye)
{
    LOGITAG("mjgvr","mj_gvr_get_eye_from_head_matrix, tid=%d", gettid());
    gvr_mat4f mat =  old_gvr_get_eye_from_head_matrix(gvr, eye);
    return mat;
}

#define fn_gvr_get_window_bounds "gvr_get_window_bounds"
gvr_recti (*old_gvr_get_window_bounds)(const gvr_context* gvr) = NULL;
gvr_recti mj_gvr_get_window_bounds(const gvr_context* gvr)
{
    LOGITAG("mjgvr","gvr_get_window_bounds, tid=%d", gettid());
    return old_gvr_get_window_bounds(gvr);
}

#define fn_gvr_compute_distorted_point "gvr_compute_distorted_point"
void (*old_gvr_compute_distorted_point)(const gvr_context* gvr, const int32_t eye, const gvr_vec2f uv_in, gvr_vec2f uv_out[3]) = NULL;
void mj_gvr_compute_distorted_point(const gvr_context* gvr, const int32_t eye, const gvr_vec2f uv_in, gvr_vec2f uv_out[3])
{
    LOGITAG("mjgvr","mj_gvr_compute_distorted_point, tid=%d", gettid());
    return old_gvr_compute_distorted_point(gvr, eye, uv_in, uv_out);
}

#define fn_gvr_get_user_prefs "gvr_get_user_prefs"
const gvr_user_prefs* (*old_gvr_get_user_prefs)(gvr_context* gvr) = NULL;
const gvr_user_prefs* mj_gvr_get_user_prefs(gvr_context* gvr)
{
    LOGITAG("mjgvr","mj_gvr_get_user_prefs, tid=%d", gettid());
    const gvr_user_prefs* re = old_gvr_get_user_prefs(gvr);
    return re;
}

#define fn_gvr_destroy "gvr_destroy"
void (*old_gvr_destroy)(gvr_context** gvr) = NULL;
void mj_gvr_destroy(gvr_context** gvr)
{
    LOGITAG("mjgvr","mj_gvr_destroy, tid=%d", gettid());
    return old_gvr_destroy(gvr);
}

#define fn_gvr_initialize_gl "gvr_initialize_gl"
void (*old_gvr_initialize_gl)(gvr_context* gvr) = NULL;
void mj_gvr_initialize_gl(gvr_context* gvr)
{
    LOGITAG("mjgvr","mj_gvr_initialize_gl, tid=%d", gettid());
    fn_initialize_gl initgl = gvr->user_prefs->p001->pfun06;
    return initgl(gvr->user_prefs);
//	return old_gvr_initialize_gl(gvr);
}

#define fn_gvr_get_async_reprojection_enabled "gvr_get_async_reprojection_enabled"
bool (*old_gvr_get_async_reprojection_enabled)(const gvr_context* gvr) = NULL;
bool mj_gvr_get_async_reprojection_enabled(const gvr_context* gvr)
{
    LOGITAG("mjgvr","mj_gvr_get_async_reprojection_enabled, tid=%d", gettid());
    return old_gvr_get_async_reprojection_enabled(gvr);
}

#define fn_gvr_get_recommended_buffer_viewports "gvr_get_recommended_buffer_viewports"
void (*old_gvr_get_recommended_buffer_viewports)(const gvr_context* gvr, gvr_buffer_viewport_list* viewport_list) = NULL;
void mj_gvr_get_recommended_buffer_viewports(const gvr_context* gvr, gvr_buffer_viewport_list* viewport_list)
{
    LOGITAG("mjgvr","mj_gvr_get_recommended_buffer_viewports, tid=%d", gettid());
    old_gvr_get_recommended_buffer_viewports(gvr, viewport_list);
    return;
}

#define fn_gvr_get_screen_buffer_viewports "gvr_get_screen_buffer_viewports"
void (*old_gvr_get_screen_buffer_viewports)(const gvr_context* gvr, gvr_buffer_viewport_list* viewport_list) = NULL;
void mj_gvr_get_screen_buffer_viewports(const gvr_context* gvr, gvr_buffer_viewport_list* viewport_list)
{
	LOGITAG("mjgvr","mj_gvr_get_screen_buffer_viewports, tid=%d", gettid());
    old_gvr_get_screen_buffer_viewports(gvr, viewport_list);
	return;
}

#define fn_gvr_get_maximum_effective_render_target_size "gvr_get_maximum_effective_render_target_size"
gvr_sizei (*old_gvr_get_maximum_effective_render_target_size)(const gvr_context* gvr) = NULL;
gvr_sizei mj_gvr_get_maximum_effective_render_target_size(const gvr_context* gvr)
{
    gvr_sizei size = old_gvr_get_maximum_effective_render_target_size(gvr);
    LOGITAG("mjgvr","mj_gvr_get_maximum_effective_render_target_size, w=%d, h=%d, tid=%d", size.width, size.height, gettid());
    return size;
}

#define fn_gvr_get_screen_target_size "gvr_get_screen_target_size"
gvr_sizei (*old_gvr_get_screen_target_size)(const gvr_context* gvr) = NULL;
gvr_sizei mj_gvr_get_screen_target_size(const gvr_context* gvr)
{
    LOGITAG("mjgvr","mj_gvr_get_screen_target_size, tid=%d", gettid());
	return old_gvr_get_screen_target_size(gvr);
}

#define fn_gvr_distort_to_screen "gvr_distort_to_screen"
void (*old_gvr_distort_to_screen)(gvr_context* gvr, int32_t texture_id, const gvr_buffer_viewport_list* viewport_list,
                           gvr_mat4f head_space_from_start_space, gvr_clock_time_point target_presentation_time) = NULL;
void mj_gvr_distort_to_screen(gvr_context* gvr, int32_t texture_id, const gvr_buffer_viewport_list* viewport_list,
                           gvr_mat4f head_space_from_start_space, gvr_clock_time_point target_presentation_time)
{
    LOGITAG("mjgvr","mj_gvr_distort_to_screen, tid=%d", gettid());
    old_gvr_distort_to_screen(gvr, texture_id, viewport_list, head_space_from_start_space, target_presentation_time);
    return;
}

#define fn_gvr_is_feature_supported "gvr_is_feature_supported"
bool (*old_gvr_is_feature_supported)(const gvr_context* gvr, int32_t feature) = NULL;
bool mj_gvr_is_feature_supported(const gvr_context* gvr, int32_t feature)
{
    LOGITAG("mjgvr","mj_gvr_is_feature_supported, tid=%d", gettid());
    return old_gvr_is_feature_supported(gvr, feature);
}

#define fn_gvr_buffer_viewport_create "gvr_buffer_viewport_create"
gvr_buffer_viewport* (*old_gvr_buffer_viewport_create)(gvr_context* gvr) = NULL;
gvr_buffer_viewport* mj_gvr_buffer_viewport_create(gvr_context* gvr)
{
    LOGITAG("mjgvr","mj_gvr_buffer_viewport_create, tid=%d", gettid());
    gvr_buffer_viewport *viewport = old_gvr_buffer_viewport_create(gvr);
//    int ilen = sizeof(gvr_buffer_viewport);
//    gvr_buffer_viewport *viewport = (gvr_buffer_viewport*)malloc(ilen);
//    memset(viewport, 0, ilen);
//    viewport->eye = GVR_LEFT_EYE;
//    viewport->buffer_index = 0;
//    memset(viewport->data1, 0xff, 8);
//    viewport->layer_index = 0;
//    memset(viewport->data11, 0xff, 4);
//    viewport->reprojection = GVR_REPROJECTION_FULL;
    return viewport;
}

#define fn_gvr_buffer_viewport_list_create "gvr_buffer_viewport_list_create"
gvr_buffer_viewport_list* (*old_gvr_buffer_viewport_list_create)(const gvr_context* gvr) = NULL;
gvr_buffer_viewport_list* mj_gvr_buffer_viewport_list_create(const gvr_context* gvr)
{
    LOGITAG("mjgvr","mj_gvr_buffer_viewport_list_create, tid=%d", gettid());
    gvr_buffer_viewport_list *viewportlist = old_gvr_buffer_viewport_list_create(gvr);
    return viewportlist;
}

#define fn_gvr_buffer_viewport_list_get_item "gvr_buffer_viewport_list_get_item"
void (*old_gvr_buffer_viewport_list_get_item)(const gvr_buffer_viewport_list* viewport_list, size_t index, gvr_buffer_viewport* viewport) = NULL;
void mj_gvr_buffer_viewport_list_get_item(const gvr_buffer_viewport_list* viewport_list, size_t index, gvr_buffer_viewport* viewport)
{
    LOGITAG("mjgvr","mj_gvr_buffer_viewport_list_get_item, tid=%d", gettid());
    old_gvr_buffer_viewport_list_get_item(viewport_list, index, viewport);
    return;
}

#define fn_gvr_buffer_viewport_list_set_item "gvr_buffer_viewport_list_set_item"
void (*old_gvr_buffer_viewport_list_set_item)(gvr_buffer_viewport_list* viewport_list, size_t index, const gvr_buffer_viewport* viewport) = NULL;
void mj_gvr_buffer_viewport_list_set_item(gvr_buffer_viewport_list* viewport_list, size_t index, const gvr_buffer_viewport* viewport)
{
    LOGITAG("mjgvr","mj_gvr_buffer_viewport_list_set_item, tid=%d", gettid());
    old_gvr_buffer_viewport_list_set_item(viewport_list, index, viewport);
    return;
}

#define fn_gvr_buffer_spec_create "gvr_buffer_spec_create"
gvr_buffer_spec* (*old_gvr_buffer_spec_create)(gvr_context* gvr) = NULL;
gvr_buffer_spec* mj_gvr_buffer_spec_create(gvr_context* gvr)
{
    LOGITAG("mjgvr","mj_gvr_buffer_spec_create, tid=%d", gettid());
//    int ilen = sizeof(gvr_buffer_spec);
//    gvr_buffer_spec *buff = (gvr_buffer_spec*)malloc(ilen);
//    memset(buff, 0, ilen);
//    buff->size.width = 0;
//    buff->size.height = 0;
//    buff->depth_stencil_format = GVR_DEPTH_STENCIL_FORMAT_DEPTH_32_F_STENCIL_8;
//    buff->color_format = GVR_COLOR_FORMAT_RGBA_8888;
//    buff->num_samples = 1;
//    buff->num_layers = 1;
//    fn_buffer_spec_create pfun =  gvr->user_prefs->p001->pfun10;
//    pfun(&buff->size, gvr->user_prefs);

    gvr_buffer_spec *buff = old_gvr_buffer_spec_create(gvr);
    return buff;
}

#define fn_gvr_swap_chain_create "gvr_swap_chain_create"
gvr_swap_chain* (*old_gvr_swap_chain_create)(gvr_context* gvr, const gvr_buffer_spec** buffers, int32_t count) = NULL;
gvr_swap_chain* mj_gvr_swap_chain_create(gvr_context* gvr, const gvr_buffer_spec** buffers, int32_t count)
{
    LOGITAG("mjgvr","mj_gvr_swap_chain_create, tid=%d", gettid());
    gvr_swap_chain *swap_chain = old_gvr_swap_chain_create(gvr, buffers, count);
    return swap_chain;
}

#define fn_gvr_swap_chain_destroy "gvr_swap_chain_destroy"
void (*old_gvr_swap_chain_destroy)(gvr_swap_chain** swap_chain) = NULL;
void mj_gvr_swap_chain_destroy(gvr_swap_chain** swap_chain)
{
    LOGITAG("mjgvr","mj_gvr_swap_chain_destroy, tid=%d", gettid());
    return old_gvr_swap_chain_destroy(swap_chain);
}

#define fn_gvr_swap_chain_get_buffer_count "gvr_swap_chain_get_buffer_count"
int32_t (*old_gvr_swap_chain_get_buffer_count)(const gvr_swap_chain* swap_chain) = NULL;
int32_t mj_gvr_swap_chain_get_buffer_count(const gvr_swap_chain* swap_chain)
{
    LOGITAG("mjgvr","mj_gvr_swap_chain_get_buffer_count, tid=%d", gettid());
    int count = old_gvr_swap_chain_get_buffer_count(swap_chain);
    return count;
}

#define fn_gvr_swap_chain_get_buffer_size "gvr_swap_chain_get_buffer_size"
gvr_sizei (*old_gvr_swap_chain_get_buffer_size)(gvr_swap_chain* swap_chain, int32_t index) = NULL;
gvr_sizei mj_gvr_swap_chain_get_buffer_size(gvr_swap_chain* swap_chain, int32_t index)
{
    LOGITAG("mjgvr","mj_gvr_swap_chain_get_buffer_size, tid=%d", gettid());
    gvr_sizei size = old_gvr_swap_chain_get_buffer_size(swap_chain, index);
    return size;
}

#define fn_gvr_swap_chain_resize_buffer "gvr_swap_chain_resize_buffer"
void (*old_gvr_swap_chain_resize_buffer)(gvr_swap_chain* swap_chain, int32_t index, gvr_sizei size) = NULL;
void mj_gvr_swap_chain_resize_buffer(gvr_swap_chain* swap_chain, int32_t index, gvr_sizei size)
{
    LOGITAG("mjgvr","mj_gvr_swap_chain_resize_buffer, tid=%d", gettid());
    return old_gvr_swap_chain_resize_buffer(swap_chain, index, size);
}

#define fn_gvr_bind_default_framebuffer "gvr_bind_default_framebuffer"
void (*old_gvr_bind_default_framebuffer)(gvr_context* gvr) = NULL;
void mj_gvr_bind_default_framebuffer(gvr_context* gvr)
{
    LOGITAG("mjgvr","mj_gvr_bind_default_framebuffer, tid=%d", gettid());
    return old_gvr_bind_default_framebuffer(gvr);
}

#define fn_gvr_apply_neck_model "gvr_apply_neck_model"
gvr_mat4f (*old_gvr_apply_neck_model)(const gvr_context* gvr, gvr_mat4f head_space_from_start_space_rotation, float factor) = NULL;
gvr_mat4f mj_gvr_apply_neck_model(const gvr_context* gvr, gvr_mat4f head_space_from_start_space_rotation, float factor)
{
	LOGITAG("mjgvr","mj_gvr_apply_neck_model, tid=%d", gettid());
	return old_gvr_apply_neck_model(gvr, head_space_from_start_space_rotation, factor);
}

#define fn_gvr_set_display_metrics "gvr_set_display_metrics"
int (*old_gvr_set_display_metrics)( int *a1, int a2, int a3, int a4, int a5, int a6) = NULL;
int mj_gvr_set_display_metrics( int *a1, int widht, int height, int a4, int a5, int a6)
{
    LOGITAG("mjgvr","mj_gvr_set_display_metrics, tid=%d", gettid());
    return old_gvr_set_display_metrics(a1, widht, height, a4, a5, a6);
}

#define fn_gvr_set_display_synchronizer "gvr_set_display_synchronizer"
int (*old_gvr_set_display_synchronizer)( gvr_context *a1, int a2) = NULL;
int mj_gvr_set_display_synchronizer( gvr_context *a1, int a2)
{
    LOGITAG("mjgvr","mj_gvr_set_display_synchronizer, tid=%d", gettid());
    return old_gvr_set_display_synchronizer(a1, a2);
}

#define fn_gvr_swap_chain_acquire_frame "gvr_swap_chain_acquire_frame"
gvr_frame* (*old_gvr_swap_chain_acquire_frame)(gvr_swap_chain* swap_chain) = NULL;
gvr_frame* mj_gvr_swap_chain_acquire_frame(gvr_swap_chain* swap_chain)
{

    LOGITAG("mjgvr","mj_gvr_swap_chain_acquire_frame, threadid=%ld,tid=%d", pthread_self(), gettid());
    gvr_frame *frame = old_gvr_swap_chain_acquire_frame(swap_chain);
    if( (int)frame != (int)swap_chain)
        LOGITAG("mjgvr","error, tid=%d", gettid());
//    fn_sub_271AC pfun = swap_chain->context->user_prefs->p001->pfun13;
////    pfun(swap_chain->context->user_prefs);
////    gvr_frame *frame = (gvr_frame*)swap_chain;
////    swap_chain->data04[0] = 1;
    return frame;
}

#define fn_gvr_frame_bind_buffer "gvr_frame_bind_buffer"
void (*old_gvr_frame_bind_buffer)(gvr_frame* frame, int32_t index) = NULL;
void mj_gvr_frame_bind_buffer(gvr_frame* frame, int32_t index)
{
    LOGITAG("mjgvr","mj_gvr_frame_bind_buffer, index=%d, tid=%d", index, gettid());
    old_gvr_frame_bind_buffer(frame, index);
//    fn_sub_26C04 pFun =  frame->context->user_prefs->p001->pfun22;
//    pFun(frame->context->user_prefs, frame->data00, index);
    return;
}

#define fn_gvr_frame_unbind "gvr_frame_unbind"
void (*old_gvr_frame_unbind)(gvr_frame* frame) = NULL;
void mj_gvr_frame_unbind(gvr_frame* frame)
{
    LOGITAG("mjgvr","mj_gvr_frame_unbind, tid=%d", gettid());
    old_gvr_frame_unbind(frame);
    return;
}

#define fn_gvr_frame_get_buffer_size "gvr_frame_get_buffer_size"
gvr_sizei (*old_gvr_frame_get_buffer_size)(const gvr_frame* frame, int32_t index) = NULL;
gvr_sizei mj_gvr_frame_get_buffer_size(const gvr_frame* frame, int32_t index)
{
    LOGITAG("mjgvr","mj_gvr_frame_get_buffer_size, tid=%d", gettid());
    gvr_sizei size = old_gvr_frame_get_buffer_size(frame, index);
    return size;
}

#define fn_gvr_frame_get_framebuffer_object "gvr_frame_get_framebuffer_object"
int32_t (*old_gvr_frame_get_framebuffer_object)(const gvr_frame* frame, int32_t index) = NULL;
int32_t mj_gvr_frame_get_framebuffer_object(const gvr_frame* frame, int32_t index)
{
    LOGITAG("mjgvr","mj_gvr_frame_get_framebuffer_object, tid=%d", gettid());
    int32_t re = old_gvr_frame_get_framebuffer_object(frame, index);
    return re;
}

#define fn_gvr_frame_submit "gvr_frame_submit"
void (*old_gvr_frame_submit)(gvr_frame** frame, const gvr_buffer_viewport_list* list, gvr_mat4f head_space_from_start_space) = NULL;
void mj_gvr_frame_submit(gvr_frame** frame, const gvr_buffer_viewport_list* list, gvr_mat4f head_space_from_start_space)
{
    LOGITAG("mjgvr","mj_gvr_frame_submit, tid=%d", gettid());
    old_gvr_frame_submit(frame, list, head_space_from_start_space);
    return;
}

#define fn_gvr_render_reprojection_thread "gvr_render_reprojection_thread"
int (*old_gvr_render_reprojection_thread)(const gvr_context *gvr) = NULL;
int mj_gvr_render_reprojection_thread(const gvr_context *gvr)
{   // ->sub_28A86[00028b3f]
    // ->sub_364B4[0003696b]
    // ->sub_35CB0[00035e3d]
    // ->sub_34868[00034a31]
    // ->sub_3A724[0003a74f]
    // ->sub_399D0[0003a3a1]
    //->>sub_36A38[00036a47]
    //->>sub_6CB66[0006cb81]
    // ->sub_691E8[0006932b]
    // ->sub_68FF0[00069179]
    // ->sub_68FF0
    // ->sub_67690(sub_677F4)[00069121]
    // ->sub_67584[00067765]
    // ->sub_67544[0006756b]
    // ->sub_66AA8[00066abf]
    // ->sub_656B8[00065727]
    // ->sub_5EB60[0005eb69]->>mjglBindTexture
//    sys_call_stack();
    gRendThread = gettid();
    LOGITAG("mjgvr","mj_gvr_render_reprojection_thread, tid=%d", gettid());
//    fn_sub_28A86 pfun = gvr->user_prefs->p001->pfun17;
//    int re = pfun(gvr->user_prefs);
    int re = old_gvr_render_reprojection_thread(gvr);
    return re;
}

#define fn_gvr_on_surface_created_reprojection_thread "gvr_on_surface_created_reprojection_thread"
int (*old_gvr_on_surface_created_reprojection_thread)(const gvr_context *gvr) = NULL;
int mj_gvr_on_surface_created_reprojection_thread(const gvr_context *gvr)
{
    LOGITAG("mjgvr","mj_gvr_on_surface_created_reprojection_thread, tid=%d", gettid());
    int re = old_gvr_on_surface_created_reprojection_thread(gvr);
    return re;
}

#define fn_gvr_get_head_space_from_start_space_rotation "gvr_get_head_space_from_start_space_rotation"
gvr_mat4f (*old_gvr_get_head_space_from_start_space_rotation)(const gvr_context *gvr, const gvr_clock_time_point time) = NULL;
gvr_mat4f mj_gvr_get_head_space_from_start_space_rotation(const gvr_context *gvr, const gvr_clock_time_point time)
{
	LOGITAG("mjgvr","mj_gvr_get_head_space_from_start_space_rotation, tid=%d", gettid());
	gvr_mat4f Ret;
	memset(&Ret, 0, sizeof(gvr_mat4f));
	Ret.m[0][0] = Ret.m[1][1] = Ret.m[2][2] = Ret.m[3][3] = 1;

	if (old_gvr_get_head_space_from_start_space_rotation)
	{
		LOGE( "Call gvr_get_head_space_from_start_space_rotation, tid=%d", gettid());
		Ret = old_gvr_get_head_space_from_start_space_rotation(gvr, time);
	}
	else
	{
		LOGE( "gvr_get_head_space_from_start_space_rotation = NULL, tid=%d", gettid());
	}
	return Ret;
}


bool HookToFunctionBase(int base, void * fpReplactToFunction, void ** fpOutRealFunction)
{
    bool bRet = false;
    void *pModule = get_module_base(getpid(), "libgvr.so");
    void *pFunc = (void*)((int)pModule + base + 1);
    if (registerInlineHook((uint32_t)pFunc, (uint32_t)fpReplactToFunction, (uint32_t **)fpOutRealFunction) == DETOUR_OK)
    {
        if (inlineHook((uint32_t)pFunc) == DETOUR_OK)
        {
            bRet = true;
        }
    }
    else
    {
        LOGE("Try registerInlineHook error!!, tid=%d", gettid());
    }

    return bRet;
}


bool HookToFunction(void * hDLL, const char * szFunctionName, void * fpReplactToFunction, void ** fpOutRealFunction)
{
	bool bRet = false;
	if (hDLL != NULL && szFunctionName != NULL && fpOutRealFunction != NULL)
	{
		void *pFunc = dlsym(hDLL, szFunctionName);
		if (pFunc != NULL)
		{
			if (registerInlineHook((uint32_t)pFunc, (uint32_t)fpReplactToFunction, (uint32_t **)fpOutRealFunction) == DETOUR_OK)
			{
				if (inlineHook((uint32_t)pFunc) == DETOUR_OK)
				{
					bRet = true;
				}
				else
				{
					LOGE( "Try inlineHook error!! Fucntion name = %s", szFunctionName);
				}
			}
			else
			{
				LOGE("Try registerInlineHook error!! Fucntion name = %s", szFunctionName);
			}
		}
		else
		{
			LOGE("Can not find and Fucntion name = %s", szFunctionName);
		}
	}
	else
	{
		LOGE( "Invalid parmeat!!, tid=%d", gettid());
	}
	return bRet;
}


bool InitHook()
{
    void *pModule = get_module_base(getpid(), "libgvr.so");
    LOGITAG("mjgvr","gvrbase: %x", pModule);
	bool bRet = false;
	if (LoadGVR())
	{
		bRet = HookToFunction(g_hGVR , fn_gvr_get_head_space_from_start_space_rotation , (void*)mj_gvr_get_head_space_from_start_space_rotation, (void**)&old_gvr_get_head_space_from_start_space_rotation)
			   &&HookToFunction(g_hGVR, fn_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled, (void*)mj_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled, (void**)&old_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled)
               &&HookToFunction(g_hGVR, fn_gvr_set_async_reprojection_enabled, (void*)mj_gvr_set_async_reprojection_enabled, (void**)&old_gvr_set_async_reprojection_enabled)
               &&HookToFunction(g_hGVR, fn_JNI_OnLoad, (void*)GVR_JNI_OnLoad, (void**)&old_JNI_OnLoad)
//           &&HookToFunctionBase(g_hGVR, 0x9B37E, (void*)mj_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled, (void**)&old_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled)
			   &&HookToFunction(g_hGVR, fn_gvr_create_with_tracker_for_testing, (void*)mj_gvr_create_with_tracker_for_testing, (void**)&old_gvr_create_with_tracker_for_testing)
			   &&HookToFunction(g_hGVR, fn_gvr_using_dynamic_library, (void*)mj_gvr_using_dynamic_library, (void**)&old_gvr_using_dynamic_library)
//		   &&HookToFunctionBase(g_hGVR, 0x6722, (void*)mj_sub_24738, (void**)&old_sub_24738)
//               &&HookToFunctionBase( 0x68CA4,(void*)mj_sub_68CA4, (void**)&old_sub_68CA4)
			   &&HookToFunction(g_hGVR, fn_gvr_create, (void*)mj_gvr_create, (void**)&old_gvr_create)
			   &&HookToFunction(g_hGVR, fn_gvr_get_error, (void*)mj_gvr_get_error, (void**)&old_gvr_get_error)
			   &&HookToFunction(g_hGVR, fn_gvr_clear_error,(void*)mj_gvr_clear_error, (void**)&old_gvr_clear_error)
			   &&HookToFunction(g_hGVR, fn_gvr_get_user_prefs, (void*)mj_gvr_get_user_prefs, (void**)&old_gvr_get_user_prefs)
			   &&HookToFunction(g_hGVR, fn_gvr_destroy, (void*)mj_gvr_destroy, (void**)&old_gvr_destroy)
			   &&HookToFunction(g_hGVR, fn_gvr_initialize_gl,(void*)mj_gvr_initialize_gl, (void**)&old_gvr_initialize_gl)
               &&HookToFunction(g_hGVR, fn_gvr_get_async_reprojection_enabled,(void*)mj_gvr_get_async_reprojection_enabled, (void**)&old_gvr_get_async_reprojection_enabled)
			   &&HookToFunction(g_hGVR, fn_gvr_get_recommended_buffer_viewports, (void*)mj_gvr_get_recommended_buffer_viewports, (void**)&old_gvr_get_recommended_buffer_viewports)
			   &&HookToFunction(g_hGVR, fn_gvr_get_screen_buffer_viewports, (void*)mj_gvr_get_screen_buffer_viewports, (void**)&old_gvr_get_screen_buffer_viewports)
			   &&HookToFunction(g_hGVR, fn_gvr_get_maximum_effective_render_target_size, (void*)mj_gvr_get_maximum_effective_render_target_size, (void**)&old_gvr_get_maximum_effective_render_target_size)
			   &&HookToFunction(g_hGVR, fn_gvr_get_screen_target_size, (void*)mj_gvr_get_screen_target_size, (void**)&old_gvr_get_screen_target_size)
			   &&HookToFunction(g_hGVR, fn_gvr_distort_to_screen, (void*)mj_gvr_distort_to_screen, (void**)&old_gvr_distort_to_screen)
               &&HookToFunction(g_hGVR, fn_gvr_is_feature_supported, (void*)mj_gvr_is_feature_supported, (void**)&old_gvr_is_feature_supported)
			   &&HookToFunction(g_hGVR, fn_gvr_buffer_viewport_create, (void*)mj_gvr_buffer_viewport_create, (void**)&old_gvr_buffer_viewport_create)
               &&HookToFunction(g_hGVR, fn_gvr_buffer_viewport_list_create, (void*)mj_gvr_buffer_viewport_list_create, (void**)&old_gvr_buffer_viewport_list_create)
			   &&HookToFunction(g_hGVR, fn_gvr_buffer_viewport_list_get_item, (void*)mj_gvr_buffer_viewport_list_get_item, (void**)&old_gvr_buffer_viewport_list_get_item)
			   &&HookToFunction(g_hGVR, fn_gvr_buffer_viewport_list_set_item,(void*)mj_gvr_buffer_viewport_list_set_item, (void**)&old_gvr_buffer_viewport_list_set_item)
               &&HookToFunction(g_hGVR, fn_gvr_buffer_spec_create, (void*)mj_gvr_buffer_spec_create, (void**)&old_gvr_buffer_spec_create)
			   &&HookToFunction(g_hGVR, fn_gvr_swap_chain_create, (void*)mj_gvr_swap_chain_create, (void**)&old_gvr_swap_chain_create)
               &&HookToFunction(g_hGVR, fn_gvr_swap_chain_destroy, (void*)mj_gvr_swap_chain_destroy, (void**)&old_gvr_swap_chain_destroy)
               &&HookToFunction(g_hGVR, fn_gvr_swap_chain_get_buffer_count, (void*)mj_gvr_swap_chain_get_buffer_count, (void**)&old_gvr_swap_chain_get_buffer_count)
               &&HookToFunction(g_hGVR, fn_gvr_swap_chain_get_buffer_size, (void*)mj_gvr_swap_chain_get_buffer_size, (void**)&old_gvr_swap_chain_get_buffer_size)
               &&HookToFunction(g_hGVR, fn_gvr_swap_chain_resize_buffer, (void*)mj_gvr_swap_chain_resize_buffer, (void**)&old_gvr_swap_chain_resize_buffer)
			   &&HookToFunction(g_hGVR, fn_gvr_bind_default_framebuffer, (void*)mj_gvr_bind_default_framebuffer, (void**)&old_gvr_bind_default_framebuffer)
			   &&HookToFunction(g_hGVR, fn_gvr_apply_neck_model, (void*)mj_gvr_apply_neck_model, (void**)&old_gvr_apply_neck_model)
			   &&HookToFunction(g_hGVR, fn_gvr_pause_tracking, (void*)mj_gvr_pause_tracking, (void**)&old_gvr_pause_tracking)
			   &&HookToFunction(g_hGVR, fn_gvr_resume_tracking, (void*)mj_gvr_resume_tracking, (void**)&old_gvr_resume_tracking)
			   &&HookToFunction(g_hGVR, fn_gvr_reset_tracking, (void*)mj_gvr_reset_tracking, (void**)&old_gvr_reset_tracking)
			   &&HookToFunction(g_hGVR, fn_gvr_recenter_tracking, (void*)mj_gvr_recenter_tracking, (void**)&old_gvr_recenter_tracking)
			   &&HookToFunction(g_hGVR, fn_gvr_set_default_viewer_profile, (void*)mj_gvr_set_default_viewer_profile, (void**)&old_gvr_set_default_viewer_profile)
               &&HookToFunction(g_hGVR, fn_gvr_refresh_viewer_profile, (void*)mj_gvr_refresh_viewer_profile, (void**)&old_gvr_refresh_viewer_profile)
			   &&HookToFunction(g_hGVR, fn_gvr_get_viewer_vendor, (void*)mj_gvr_get_viewer_vendor, (void**)&old_gvr_get_viewer_vendor)
			   &&HookToFunction(g_hGVR, fn_gvr_get_viewer_model, (void*)mj_gvr_get_viewer_model, (void**)&old_gvr_get_viewer_model)
			   &&HookToFunction(g_hGVR, fn_gvr_get_viewer_type, (void*)mj_gvr_get_viewer_type, (void**)&old_gvr_get_viewer_type)
               &&HookToFunction(g_hGVR, fn_gvr_get_eye_from_head_matrix, (void*)mj_gvr_get_eye_from_head_matrix, (void**)&old_gvr_get_eye_from_head_matrix)
               &&HookToFunction(g_hGVR, fn_gvr_get_window_bounds, (void*)mj_gvr_get_window_bounds, (void**)&old_gvr_get_window_bounds)
			   &&HookToFunction(g_hGVR, fn_gvr_compute_distorted_point, (void*)mj_gvr_compute_distorted_point, (void**)&old_gvr_compute_distorted_point)
			   &&HookToFunction(g_hGVR, fn_gvr_set_display_synchronizer, (void*)mj_gvr_set_display_synchronizer, (void**)&old_gvr_set_display_synchronizer)
               &&HookToFunction(g_hGVR, fn_gvr_swap_chain_acquire_frame, (void*)mj_gvr_swap_chain_acquire_frame, (void**)&old_gvr_swap_chain_acquire_frame)
               &&HookToFunction(g_hGVR, fn_gvr_frame_bind_buffer, (void*)mj_gvr_frame_bind_buffer, (void**)&old_gvr_frame_bind_buffer)
               &&HookToFunction(g_hGVR, fn_gvr_frame_unbind, (void*)mj_gvr_frame_unbind, (void**)&old_gvr_frame_unbind)
               &&HookToFunction(g_hGVR, fn_gvr_frame_get_buffer_size, (void*)mj_gvr_frame_get_buffer_size, (void**)&old_gvr_frame_get_buffer_size)
               &&HookToFunction(g_hGVR, fn_gvr_frame_get_framebuffer_object, (void*)mj_gvr_frame_get_framebuffer_object, (void**)&old_gvr_frame_get_framebuffer_object)
               &&HookToFunction(g_hGVR, fn_gvr_frame_submit, (void*)mj_gvr_frame_submit, (void**)&old_gvr_frame_submit)
               &&HookToFunction(g_hGVR, fn_gvr_render_reprojection_thread, (void*)mj_gvr_render_reprojection_thread, (void**)&old_gvr_render_reprojection_thread)
               &&HookToFunction(g_hGVR, fn_gvr_on_surface_created_reprojection_thread, (void*)mj_gvr_on_surface_created_reprojection_thread, (void**)&old_gvr_on_surface_created_reprojection_thread)
			   &&HookToFunction(g_hGVR, fn_gvr_set_display_metrics, (void*)mj_gvr_set_display_metrics, (void**)&old_gvr_set_display_metrics)
			   &&HookToFunction(g_hGVR, fn_Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate, (void*)mj_Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate, (void**)&old_Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate)
               &&HookToFunction(g_hGVR, fn_Java_com_google_vr_ndk_base_GvrApi_nativeGetAsyncReprojectionEnabled, (void*)mj_Java_com_google_vr_ndk_base_GvrApi_nativeGetAsyncReprojectionEnabled, (void**)&old_Java_com_google_vr_ndk_base_GvrApi_nativeGetAsyncReprojectionEnabled)
               &&HookToFunction(g_hGVR, fn_Java_com_google_vr_ndk_base_GvrApi_nativeUsingVrDisplayService, (void*)mj_Java_com_google_vr_ndk_base_GvrApi_nativeUsingVrDisplayService, (void**)&old_Java_com_google_vr_ndk_base_GvrApi_nativeUsingVrDisplayService)
			   &&HookToFunction(g_hGVR, fn_Java_com_google_vr_ndk_base_GvrApi_nativeCreate, (void*)mj_Java_com_google_vr_ndk_base_GvrApi_nativeCreate, (void**)&old_Java_com_google_vr_ndk_base_GvrApi_nativeCreate);

		if (bRet)
		{
			bRet = true;
		}
		else
		{
			LOGE( "hook error, tid=%d", gettid());
		}
	}
	else
	{
		LOGE("LoadGVR error, tid=%d", gettid());
	}

	return bRet;
}

bool UninitHook()
{
    inlineUnHookAll();
    if( g_hGVR != NULL )
        dlclose(g_hGVR);
    g_hGVR = NULL;
}

bool LoadGVR()
{
	if (g_hGVR == nullptr)
	{
		g_hGVR = dlopen("libgvr.so", RTLD_LAZY);
	}

	if (g_hGVR == NULL)
	{
        LOGE( "dlopen libgvr.so err: %s", dlerror());
	}
	return g_hGVR != NULL;
}
