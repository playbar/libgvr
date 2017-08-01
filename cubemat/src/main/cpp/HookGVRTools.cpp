#include <dlfcn.h>
#include <cwchar>
#include "HookBase.h"
#include "HookGVRTools.h"
#include "gvrglobal.h"

#ifdef _DEBUG
#define  HOOK_DEBUG
#endif

void * HookGVRTools::m_hGVR = NULL;
FP_gvr_get_head_space_from_start_space_rotation HookGVRTools::m_fp_gvr_get_head_space_from_start_space_rotation = NULL;

extern bool MojingSDK_IsHDMWorking();
extern int MojingSDK_getPredictionHeadView(float* pfViewMatrix, double time);
HookGVRTools::HookGVRTools()
{
}


HookGVRTools::~HookGVRTools()
{
}

bool HookGVRTools::Init()
{
	bool bRet = false;
	if (LoadGVR())
	{
		if (HookBase::HookToFunction(m_hGVR , 
			FN_gvr_get_head_space_from_start_space_rotation , 
			(void*)HookGVRTools::HOOK_gvr_get_head_space_from_start_space_rotation,
			(void**)&m_fp_gvr_get_head_space_from_start_space_rotation
			))
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

bool HookGVRTools::LoadGVR()
{
	if (m_hGVR == nullptr)
	{
		m_hGVR = dlopen("libgvr.so", RTLD_LAZY);
	}

	if (m_hGVR == NULL)
	{
        LOGE( "dlopen libgvr.so err: %s", dlerror());
	}
	return m_hGVR != NULL;
}

gvr_mat4f HookGVRTools::HOOK_gvr_get_head_space_from_start_space_rotation(const gvr_context *gvr, const gvr_clock_time_point time)
{
    LOGE("HOOK_gvr_get_head_space_from_start_space_rotation");
	gvr_mat4f Ret;
	memset(&Ret, 0, sizeof(gvr_mat4f));
	Ret.m[0][0] = Ret.m[1][1] = Ret.m[2][2] = Ret.m[3][3] = 1;
	bool bGetSensorFromMJSDK = false;

	if (!bGetSensorFromMJSDK)
	{
		if (m_fp_gvr_get_head_space_from_start_space_rotation)
		{
            LOGE( "Call gvr_get_head_space_from_start_space_rotation");
			Ret = m_fp_gvr_get_head_space_from_start_space_rotation(gvr, time);
		}
		else
		{
            LOGE( "gvr_get_head_space_from_start_space_rotation = NULL");
		}
	}
	return Ret;
}