//
// Created by mac on 16/8/19.
//

#include "gvrfn.h"
#include <dlfcn.h>

JavaVM *gs_jvm=0;
static int gneedDetach = 0;

JNIEnv* AttachCurrentThreadJNI()
{
    JNIEnv *env = 0;
    jint result = -1;
    if (gs_jvm->GetEnv((void**) &env, JNI_VERSION_1_6) != JNI_OK)
    {
        int status = gs_jvm->AttachCurrentThread( &env, 0 );
        if( status < 0 )
        {
            return 0;
        }
        gneedDetach = 1;
    }
    return env;
}

void DetachCurrentThreadJNI()
{
    if( gneedDetach )
    {
        gs_jvm->DetachCurrentThread();
        gneedDetach = 0;
    }

}


jint JNI_OnLoad_Test( JavaVM* vm, void *reserved){
    gs_jvm = vm;

    jint result = JNI_VERSION_1_6;
    return  result;

}

CGVRAPI::CGVRAPI()
{

}

CGVRAPI::~CGVRAPI()
{

}

bool CGVRAPI::Init()
{
    bool bRet = false;
//    try
    {
        m_hDLL = dlopen("gvrimpl.so", RTLD_LAZY);
        if (m_hDLL)
        {
//            GET_DLL_FUNCION(m_hDLL, GetVersion);
//            GET_DLL_FUNCION(m_hDLL, Initialize);
//            GET_DLL_FUNCION(m_hDLL, Shutdown);
//            GET_DLL_FUNCION(m_hDLL, GetDeviceInfo);
//            GET_DLL_FUNCION(m_hDLL, SetPerformanceLevels);
//            GET_DLL_FUNCION(m_hDLL, BeginVr);
//            GET_DLL_FUNCION(m_hDLL, EndVr);
//            GET_DLL_FUNCION(m_hDLL, GetPredictedDisplayTime);
//            GET_DLL_FUNCION(m_hDLL, GetPredictedHeadPose);
//            GET_DLL_FUNCION(m_hDLL, RecenterPose);
//            GET_DLL_FUNCION(m_hDLL, GetSupportedTrackingModes);
//            GET_DLL_FUNCION(m_hDLL, SetTrackingMode);
//            GET_DLL_FUNCION(m_hDLL, SubmitFrame);
//            GET_DLL_FUNCION(m_hDLL, UpdateWarpmesh);
//            GET_DLL_FUNCION(m_hDLL, CheckServiceIsAvaliable);
//            GET_DLL_FUNCION(m_hDLL, SetTimewarp);
//            if (m_fpGetVersion != NULL
//                && m_fpInitialize != NULL
//                && m_fpShutdown != NULL
//                && m_fpGetDeviceInfo != NULL
//                && m_fpSetPerformanceLevels != NULL
//                && m_fpBeginVr != NULL
//                && m_fpEndVr != NULL
//                && m_fpGetPredictedDisplayTime != NULL
//                && m_fpGetPredictedHeadPose != NULL
//                && m_fpRecenterPose != NULL
//                && m_fpGetSupportedTrackingModes != NULL
//                && m_fpSetTrackingMode != NULL
//                && m_fpSubmitFrame != NULL
//                && m_fpUpdateWarpmesh != NULL
//                && m_fpCheckServiceIsAvaliable != NULL
//                && m_fpSetTimewarp != NULL
            if( true)
            {
                bRet = m_bInit = true;
//                MOJING_TRACE(g_APIlogger , "svrApi init OK");
            }
            else
            {// 有函数指针拿不到
//                GET_DLL_FUNCION_ERR(GetVersion);
//                GET_DLL_FUNCION_ERR(Initialize);
//                GET_DLL_FUNCION_ERR(Shutdown);
//                GET_DLL_FUNCION_ERR(GetDeviceInfo);
//                GET_DLL_FUNCION_ERR(SetPerformanceLevels);
//                GET_DLL_FUNCION_ERR(BeginVr);
//                GET_DLL_FUNCION_ERR(EndVr);
//                GET_DLL_FUNCION_ERR(GetPredictedDisplayTime);
//                GET_DLL_FUNCION_ERR(GetPredictedHeadPose);
//                GET_DLL_FUNCION_ERR(RecenterPose);
//                GET_DLL_FUNCION_ERR(GetSupportedTrackingModes);
//                GET_DLL_FUNCION_ERR(SetTrackingMode);
//                GET_DLL_FUNCION_ERR(SubmitFrame);
//                GET_DLL_FUNCION_ERR(UpdateWarpmesh);
//                GET_DLL_FUNCION_ERR(CheckServiceIsAvaliable);
//                GET_DLL_FUNCION_ERR(SetTimewarp);
                Release();
            }
        }
        else// m_hDLL == NULL
        {
            const char* err = dlerror();
//            MOJING_ERROR(g_APIlogger, "Can not load libary \"libOverlay.so\"  Error = " << (err ? err : "Unknown"));
        }
    }
//    catch (...)
//    {
////        MOJING_ERROR(g_APIlogger, "Can not load libary \"libOverlay.so\"  , ****CRASH***");
//    }
    return	 bRet;
}

void CGVRAPI::Release() {
    if (m_hDLL)
        dlclose(m_hDLL);
//    m_fpGetVersion = NULL;
//    m_fpInitialize = NULL;
//    m_fpShutdown = NULL;
//    m_fpGetDeviceInfo = NULL;
//    m_fpSetPerformanceLevels = NULL;
//    m_fpBeginVr = NULL;
//    m_fpEndVr = NULL;
//    m_fpGetPredictedDisplayTime = NULL;
//    m_fpGetPredictedHeadPose = NULL;
//    m_fpRecenterPose = NULL;
//    m_fpGetSupportedTrackingModes = NULL;
//    m_fpSetTrackingMode = NULL;
//    m_fpSubmitFrame = NULL;
//    m_fpUpdateWarpmesh = NULL;
}