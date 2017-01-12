/*    */ package com.google.vr.cardboard;
/*    */ 
/*    */ import android.net.Uri;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VrSettingsProviderContract
/*    */ {
/*    */   public static final String VRCORE_AUTHORITY = "com.google.vr.vrcore.settings";
/*    */   public static final String PROVIDER_INTENT_ACTION = "android.content.action.VR_SETTINGS_PROVIDER";
/*    */   public static final String DEVICE_PARAMS_SETTING = "device_params";
/*    */   public static final String PHONE_PARAMS_SETTING = "phone_params";
/*    */   public static final String DAYDREAM_SETUP_COMPLETED = "daydream_setup";
/*    */   public static final String SDK_CONFIGURATION_PARAMS_SETTING = "sdk_configuration_params";
/*    */   public static final String USER_PREFS_SETTING = "user_prefs";
/*    */   public static final String SETTING_VALUE_KEY = "value";
/*    */   
/*    */   public static Uri createUri(String paramString1, String paramString2)
/*    */   {
/* 51 */     String str = String.valueOf("content://");return Uri.parse(1 + String.valueOf(str).length() + String.valueOf(paramString1).length() + String.valueOf(paramString2).length() + str + paramString1 + "/" + paramString2);
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\VrSettingsProviderContract.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */