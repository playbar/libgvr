#include <android/log.h>
#include <jni.h>
#include <memory>
#include "treasure_hunt_renderer.h"
#include "gvrfn.h"
#include "gvr.h"
#include "gvr_audio.h"

#define JNI_METHOD(return_type, method_name) \
  JNIEXPORT return_type JNICALL              \
      Java_com_mj_vr_TreasureActivityJNI_##method_name

namespace {

inline jlong jptr(TreasureHuntRenderer *native_treasure_hunt)
{
  return reinterpret_cast<intptr_t>(native_treasure_hunt);
}

inline TreasureHuntRenderer *native(jlong ptr)
{
  return reinterpret_cast<TreasureHuntRenderer *>(ptr);
}
}  // anonymous namespace

extern "C"
{

JNI_METHOD(void, nativeTestGvrCreate)(JNIEnv *env, jclass thiz, jobject ctx, jobject classLoader)
{
  gvr_context *gvr_ctx = gvr_create(env, ctx, classLoader);
//  gGvrApi.on_surface_created_reprojection_thread((int)gvr_ctx);
//  gvr_on_surface_created_reprojection_thread(gvr_ctx);
  return;
}

JNI_METHOD(jlong, nativeCreateRenderer)
(JNIEnv *env, jclass clazz, jobject class_loader, jobject android_context, jlong native_gvr_api)
{
  std::unique_ptr<gvr::AudioApi> audio_context(new gvr::AudioApi);
  audio_context->Init(env, android_context, class_loader, GVR_AUDIO_RENDERING_BINAURAL_HIGH_QUALITY);

  return jptr(new TreasureHuntRenderer(reinterpret_cast<gvr_context *>(native_gvr_api), std::move(audio_context)));
}

JNI_METHOD(void, nativeDestroyRenderer)
(JNIEnv *env, jclass clazz, jlong native_treasure_hunt) {
  delete native(native_treasure_hunt);
}

JNI_METHOD(void, nativeInitializeGl)
(JNIEnv *env, jobject obj, jlong native_treasure_hunt) {
  native(native_treasure_hunt)->InitializeGl();
}

JNI_METHOD(void, nativeDrawFrame)
(JNIEnv *env, jobject obj, jlong native_treasure_hunt) {
  native(native_treasure_hunt)->DrawFrame();
}

JNI_METHOD(void, nativeOnTriggerEvent)
(JNIEnv *env, jobject obj, jlong native_treasure_hunt) {
  native(native_treasure_hunt)->OnTriggerEvent();
}

JNI_METHOD(void, nativeOnPause)
(JNIEnv *env, jobject obj, jlong native_treasure_hunt) {
  native(native_treasure_hunt)->OnPause();
}

JNI_METHOD(void, nativeOnResume)
(JNIEnv *env, jobject obj, jlong native_treasure_hunt) {
  native(native_treasure_hunt)->OnResume();
}


//JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved)
//{
//    return  JNI_VERSION_1_6;
//}

}  // extern "C"
