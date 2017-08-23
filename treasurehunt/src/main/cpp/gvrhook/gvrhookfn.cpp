#include <dlfcn.h>
#include <cwchar>
#include <memory.h>
#include <jni.h>
#include "gvrhookfn.h"
#include "detour.h"

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

#define fn_Java_com_google_vr_ndk_base_GvrApi_nativeCreate 	"Java_com_google_vr_ndk_base_GvrApi_nativeCreate"
long (*old_Java_com_google_vr_ndk_base_GvrApi_nativeCreate)(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext, jlong paramLong, jint paramInt1,
        jint paramInt2, jfloat paramFloat1, jfloat paramFloat2, jobject paramPoseTracker) = NULL;
long mj_Java_com_google_vr_ndk_base_GvrApi_nativeCreate(
        JNIEnv* env, jobject obj, jobject paramClassLoader, jobject paramContext, jlong paramLong, jint paramInt1,
        jint paramInt2, jfloat paramFloat1, jfloat paramFloat2, jobject paramPoseTracker)
{
    LOGI("mj_Java_com_google_vr_ndk_base_GvrApi_nativeCreate");
    long re = 0;
    re = old_Java_com_google_vr_ndk_base_GvrApi_nativeCreate(env, obj, paramClassLoader, paramContext, paramLong,
                                                           paramInt1, paramInt2, paramFloat1, paramFloat2, paramPoseTracker);
    return re;
}

#define fn_gvr_create "gvr_create"
gvr_context * (*old_gvr_create)(JNIEnv *env, jobject app_context, jobject class_loader) = NULL;
gvr_context * mj_gvr_create(JNIEnv *env, jobject app_context, jobject class_loader)
{
	LOGI("mj_gvr_create");
    gvr_context *re = NULL;
	re = old_gvr_create(env, app_context, class_loader);
    return re;
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
		   &&HookToFunction(g_hGVR, fn_gvr_create, (void*)mj_gvr_create, (void**)&old_gvr_create)
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
