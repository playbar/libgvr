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

void* get_module_base(pid_t pid,const char* module_name);
bool InitHook();
bool UninitHook();
bool LoadGVR();

#ifdef __cplusplus
}
#endif
