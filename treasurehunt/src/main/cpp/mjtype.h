#ifndef __MJTYPE_H__
#define __MJTYPE_H__


struct gvr_user_prefs_mj;

typedef int32_t (*fn_get_viewer_type)(gvr_user_prefs_mj*p);
typedef void (*fn_resume_tracking)(gvr_user_prefs_mj*p);
typedef void (*fn_initialize_gl)(gvr_user_prefs_mj*p);
#endif

