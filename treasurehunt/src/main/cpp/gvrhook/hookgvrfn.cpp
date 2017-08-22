#include <dlfcn.h>
#include <cwchar>
#include <memory.h>
#include "hookgvrfn.h"
#include "detour.h"

#ifdef _DEBUG
#define  HOOK_DEBUG
#endif

void * g_hGVR = NULL;

#define fn_gvr_get_head_space_from_start_space_rotation "gvr_get_head_space_from_start_space_rotation"
gvr_mat4f (*mj_gvr_get_head_space_from_start_space_rotation)(const gvr_context *gvr, const gvr_clock_time_point time) = NULL;
gvr_mat4f hook_gvr_get_head_space_from_start_space_rotation(const gvr_context *gvr, const gvr_clock_time_point time)
{
	LOGE("hook_gvr_get_head_space_from_start_space_rotation");
	gvr_mat4f Ret;
	memset(&Ret, 0, sizeof(gvr_mat4f));
	Ret.m[0][0] = Ret.m[1][1] = Ret.m[2][2] = Ret.m[3][3] = 1;
	bool bGetSensorFromMJSDK = false;

	if (!bGetSensorFromMJSDK)
	{
		if (mj_gvr_get_head_space_from_start_space_rotation)
		{
			LOGE( "Call gvr_get_head_space_from_start_space_rotation");
			Ret = mj_gvr_get_head_space_from_start_space_rotation(gvr, time);
		}
		else
		{
			LOGE( "gvr_get_head_space_from_start_space_rotation = NULL");
		}
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
		if (HookToFunction(g_hGVR , fn_gvr_get_head_space_from_start_space_rotation , (void*)hook_gvr_get_head_space_from_start_space_rotation, (void**)&mj_gvr_get_head_space_from_start_space_rotation))
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
