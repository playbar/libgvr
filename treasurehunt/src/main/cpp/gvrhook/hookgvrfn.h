#pragma once

#include "gvr_types.h"

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
