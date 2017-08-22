#pragma once

#include "gvr_types.h"
#include "android/log.h"

//typedef struct gvr_context_ gvr_context;
//typedef struct gvr_clock_time_point
//{
//	int64_t monotonic_system_time_nanos;
//} gvr_clock_time_point;
//// end gvrtyprs.h

//typedef struct gvr_mat4f
//{
//	float m[4][4];
//} gvr_mat4f;

static const char* hooktag = "gvrhook";
#define LOGI(...) ((void)__android_log_print(ANDROID_LOG_INFO, hooktag, __VA_ARGS__))
#define LOGW(...) ((void)__android_log_print(ANDROID_LOG_WARN, hooktag, __VA_ARGS__))
#define LOGE(...) ((void)__android_log_print(ANDROID_LOG_ERROR, hooktag, __VA_ARGS__))


#ifdef __cplusplus
extern "C" {
#endif

bool InitHook();
bool UninitHook();
bool LoadGVR();
gvr_mat4f HOOK_gvr_get_head_space_from_start_space_rotation(const gvr_context *gvr, const gvr_clock_time_point time);

#ifdef __cplusplus
}
#endif
