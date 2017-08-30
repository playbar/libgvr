#include <dlfcn.h>
#include <cwchar>
#include <memory.h>
#include <jni.h>
#include <CallStack.h>
#include <syscallstack.h>
#include "gvrhookfn.h"
#include "detour.h"
#include "mjgvr.h"

#ifdef _DEBUG
#define  HOOK_DEBUG
#endif

void * g_hGVR = NULL;


#define fn_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled "Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled"
bool (*old_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled)(JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBool) = NULL;
bool mj_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled(JNIEnv* env, jobject obj, jlong paramLong, jboolean paramBool)
{
	LOGI("mj_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled");
	return old_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled(env, obj, paramLong, paramBool);
}

#define fn_Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate "Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate"
long (*old_Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate)(JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext) = NULL;
long mj_Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate(JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext)
{
	LOGI("mj_Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate");
	return old_Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate(env, obj, paramClassLoader, paramContext);
}


#define fn_Java_com_google_vr_ndk_base_GvrApi_nativeCreate 	"Java_com_google_vr_ndk_base_GvrApi_nativeCreate"
long (*old_Java_com_google_vr_ndk_base_GvrApi_nativeCreate)(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext, jlong paramLong, jint paramInt1,
        jint paramInt2, jfloat paramFloat1, jfloat paramFloat2, jobject paramPoseTracker) = NULL;
long mj_Java_com_google_vr_ndk_base_GvrApi_nativeCreate(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext, jlong paramLong, jint paramWidth,
        jint paramHeight, jfloat paramFloat1, jfloat paramFloat2, jobject paramPoseTracker)
{
    LOGI("mj_Java_com_google_vr_ndk_base_GvrApi_nativeCreate");
    long re = 0;
    re = old_Java_com_google_vr_ndk_base_GvrApi_nativeCreate(env, obj, paramClassLoader, paramContext, paramLong,
                                                           paramWidth, paramHeight, paramFloat1, paramFloat2, paramPoseTracker);
    return re;
}

#define fn_gvr_using_dynamic_library "gvr_using_dynamic_library"
bool (*old_gvr_using_dynamic_library)() = NULL;
bool mj_gvr_using_dynamic_library()
{
	LOGI("mj_gvr_using_dynamic_library");
    bool re = old_gvr_using_dynamic_library();
	return re;
}

int (*old_sub_24738)() = NULL;
int mj_sub_24738()
{
    LOGI("mj_sub_24738");
    int re = old_sub_24738();
    return re;
}

#define fn_gvr_create_with_tracker_for_testing "gvr_create_with_tracker_for_testing"
int (*old_gvr_create_with_tracker_for_testing)( int a1, int a2) = NULL;
int mj_gvr_create_with_tracker_for_testing( int a1, int a2)
{
    LOGI("mj_gvr_create_with_tracker_for_testing");
    return old_gvr_create_with_tracker_for_testing(a1, a2);
}

#define fn_gvr_create "gvr_create"
gvr_context * (*old_gvr_create)(JNIEnv *env, jobject app_context, jobject class_loader) = NULL;
gvr_context * mj_gvr_create(JNIEnv *env, jobject app_context, jobject class_loader)
{
//    CallStack stack;
//    stack.dump();
	sys_call_stack();
	LOGI("mj_gvr_create");
    gvr_context *re = NULL;
    sub_C1324("GVR");
	re = old_gvr_create(env, app_context, class_loader);
    return re;
}

#define fn_gvr_get_error "gvr_get_error"
int32_t (*old_gvr_get_error)(gvr_context* gvr) = NULL;
int32_t mj_gvr_get_error(gvr_context* gvr)
{
    LOGI("mj_gvr_get_error");
    return old_gvr_get_error(gvr);
}

#define fn_gvr_clear_error "gvr_clear_error"
int32_t (*old_gvr_clear_error)(gvr_context* gvr) = NULL;
int32_t mj_gvr_clear_error(gvr_context* gvr)
{
	LOGI("mj_gvr_clear_error");
	return old_gvr_clear_error(gvr);
}

#define fn_gvr_resume_tracking "gvr_resume_tracking"
void (*old_gvr_resume_tracking)(gvr_context* gvr) = NULL;
void mj_gvr_resume_tracking(gvr_context* gvr)
{
    LOGI("mj_gvr_resume_tracking");
    return old_gvr_resume_tracking(gvr);
}

#define fn_gvr_get_user_prefs "gvr_get_user_prefs"
const gvr_user_prefs* (*old_gvr_get_user_prefs)(gvr_context* gvr) = NULL;
const gvr_user_prefs* mj_gvr_get_user_prefs(gvr_context* gvr)
{
    LOGI("mj_gvr_get_user_prefs");
    const gvr_user_prefs* re = old_gvr_get_user_prefs(gvr);
    return re;
}

#define fn_gvr_destroy "gvr_destroy"
void (*old_gvr_destroy)(gvr_context** gvr) = NULL;
void mj_gvr_destroy(gvr_context** gvr)
{
    LOGI("mj_gvr_destroy");
    return old_gvr_destroy(gvr);
}

#define fn_gvr_initialize_gl "gvr_initialize_gl"
void (*old_gvr_initialize_gl)(gvr_context* gvr) = NULL;
void mj_gvr_initialize_gl(gvr_context* gvr)
{
    LOGI("mj_gvr_initialize_gl");
	return old_gvr_initialize_gl(gvr);
}

#define fn_gvr_set_display_metrics "gvr_set_display_metrics"
int (*old_gvr_set_display_metrics)( int *a1, int a2, int a3, int a4, int a5, int a6) = NULL;
int mj_gvr_set_display_metrics( int *a1, int widht, int height, int a4, int a5, int a6)
{
    LOGI("mj_gvr_set_display_metrics");
    return old_gvr_set_display_metrics(a1, widht, height, a4, a5, a6);
}

#define fn_gvr_set_display_synchronizer "gvr_set_display_synchronizer"
int (*old_gvr_set_display_synchronizer)( int *a1, int a2) = NULL;
int mj_gvr_set_display_synchronizer( int *a1, int a2)
{
    LOGI("mj_gvr_set_display_synchronizer");
    return old_gvr_set_display_synchronizer(a1, a2);
}

#define fn_gvr_get_head_space_from_start_space_rotation "gvr_get_head_space_from_start_space_rotation"
gvr_mat4f (*old_gvr_get_head_space_from_start_space_rotation)(const gvr_context *gvr, const gvr_clock_time_point time) = NULL;
gvr_mat4f mj_gvr_get_head_space_from_start_space_rotation(const gvr_context *gvr, const gvr_clock_time_point time)
{
	LOGI("mj_gvr_get_head_space_from_start_space_rotation");
	gvr_mat4f Ret;
	memset(&Ret, 0, sizeof(gvr_mat4f));
	Ret.m[0][0] = Ret.m[1][1] = Ret.m[2][2] = Ret.m[3][3] = 1;

	if (old_gvr_get_head_space_from_start_space_rotation)
	{
		LOGE( "Call gvr_get_head_space_from_start_space_rotation");
		Ret = old_gvr_get_head_space_from_start_space_rotation(gvr, time);
	}
	else
	{
		LOGE( "gvr_get_head_space_from_start_space_rotation = NULL");
	}
	return Ret;
}


bool HookToFunctionBase(void * hDLL, int base, void * fpReplactToFunction, void ** fpOutRealFunction)
{
    bool bRet = false;
    void *pModule = get_module_base(getpid(), "libgvr.so");
    void *pFunc = (void*)((int)pModule + 0x24738 + 1);
    if (registerInlineHook((uint32_t)pFunc, (uint32_t)fpReplactToFunction, (uint32_t **)fpOutRealFunction) == DETOUR_OK)
    {
        if (inlineHook((uint32_t)pFunc) == DETOUR_OK)
        {
            bRet = true;
        }
    }
    else
    {
        LOGE("Try registerInlineHook error!!");
    }

//    const char * szFunName = "gvr_get_head_space_from_start_space_rotation";
//    if (hDLL != NULL && fpOutRealFunction != NULL)
//    {
//        void *pFunc = dlsym(hDLL, szFunName);
//        pFunc = (void*)((int)pFunc + base);
//        if (pFunc != NULL)
//        {
//            if (registerInlineHook((uint32_t)pFunc, (uint32_t)fpReplactToFunction, (uint32_t **)fpOutRealFunction) == DETOUR_OK)
//            {
//                if (inlineHook((uint32_t)pFunc) == DETOUR_OK)
//                {
//                    bRet = true;
//                }
//                else
//                {
//                    LOGE( "Try inlineHook error!! Fucntion name = %s", szFunName);
//                }
//            }
//            else
//            {
//                LOGE("Try registerInlineHook error!! Fucntion name = %s", szFunName);
//            }
//        }
//        else
//        {
//            LOGE("Can not find and Fucntion name = %s", szFunName);
//        }
//    }
//    else
//    {
//        LOGE( "Invalid parmeat!!");
//    }
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
		LOGE( "Invalid parmeat!!");
	}
	return bRet;
}


bool InitHook()
{
	bool bRet = false;
	if (LoadGVR())
	{
		bRet = HookToFunction(g_hGVR , fn_gvr_get_head_space_from_start_space_rotation , (void*)mj_gvr_get_head_space_from_start_space_rotation, (void**)&old_gvr_get_head_space_from_start_space_rotation)
			   &&HookToFunction(g_hGVR, fn_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled, (void*)mj_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled, (void**)&old_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled)
//           &&HookToFunctionBase(g_hGVR, 0x9B37E, (void*)mj_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled, (void**)&old_Java_com_google_vr_ndk_base_GvrApi_nativeSetAsyncReprojectionEnabled)
			   &&HookToFunction(g_hGVR, fn_gvr_create_with_tracker_for_testing, (void*)mj_gvr_create_with_tracker_for_testing, (void**)&old_gvr_create_with_tracker_for_testing)
			   &&HookToFunction(g_hGVR, fn_gvr_using_dynamic_library, (void*)mj_gvr_using_dynamic_library, (void**)&old_gvr_using_dynamic_library)
//		   &&HookToFunctionBase(g_hGVR, 0x6722, (void*)mj_sub_24738, (void**)&old_sub_24738)
			   &&HookToFunction(g_hGVR, fn_gvr_create, (void*)mj_gvr_create, (void**)&old_gvr_create)
			   &&HookToFunction(g_hGVR, fn_gvr_get_error, (void*)mj_gvr_get_error, (void**)&old_gvr_get_error)
			   &&HookToFunction(g_hGVR, fn_gvr_clear_error,(void*)mj_gvr_clear_error, (void**)&old_gvr_clear_error)
			   &&HookToFunction(g_hGVR, fn_gvr_get_user_prefs, (void*)mj_gvr_get_user_prefs, (void**)&old_gvr_get_user_prefs)
			   &&HookToFunction(g_hGVR, fn_gvr_destroy, (void*)mj_gvr_destroy, (void**)&old_gvr_destroy)
			   &&HookToFunction(g_hGVR, fn_gvr_initialize_gl,(void*)mj_gvr_initialize_gl, (void**)&old_gvr_initialize_gl)
			   &&HookToFunction(g_hGVR, fn_gvr_resume_tracking, (void*)mj_gvr_resume_tracking, (void**)&old_gvr_resume_tracking)
			   &&HookToFunction(g_hGVR, fn_gvr_set_display_synchronizer, (void*)mj_gvr_set_display_synchronizer, (void**)&old_gvr_set_display_synchronizer)
			   &&HookToFunction(g_hGVR, fn_gvr_set_display_metrics, (void*)mj_gvr_set_display_metrics, (void**)&old_gvr_set_display_metrics)
			   &&HookToFunction(g_hGVR, fn_Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate, (void*)mj_Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate, (void**)&old_Java_com_google_vr_cardboard_DisplaySynchronizer_nativeCreate)
			   &&HookToFunction(g_hGVR, fn_Java_com_google_vr_ndk_base_GvrApi_nativeCreate, (void*)mj_Java_com_google_vr_ndk_base_GvrApi_nativeCreate, (void**)&old_Java_com_google_vr_ndk_base_GvrApi_nativeCreate);

		if (bRet)
		{
			bRet = true;

		}
		else
		{
			LOGE( "hook error");
		}
	}
	else
	{
		LOGE("LoadGVR error");
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
