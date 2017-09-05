#ifndef __MJTYPE_H__
#define __MJTYPE_H__


struct gvr_user_prefs_mj;
struct gvr_sizei;

typedef int32_t (*fn_get_viewer_type)(gvr_user_prefs_mj*p);
typedef void (*fn_resume_tracking)(gvr_user_prefs_mj*p);
typedef void (*fn_initialize_gl)(gvr_user_prefs_mj*p);
typedef void (*fn_buffer_spec_create)(gvr_sizei *size, gvr_user_prefs_mj *p);
typedef int32_t (*fn_sub_271AC)(gvr_user_prefs_mj*p);
typedef void (*fn_sub_26C04)(gvr_user_prefs_mj *p, void *pdata, int index);
#endif

