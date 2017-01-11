/*    */ package com.google.vr.cardboard;
/*    */ 
/*    */ import com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams;
/*    */ import com.google.vr.vrcore.nano.SdkConfiguration.SdkConfigurationRequest;
/*    */ import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams;
/*    */ import com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams;
/*    */ import com.google.vrtoolkit.cardboard.proto.nano.Preferences.UserPrefs;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class LegacyVrParamsProvider
/*    */   implements VrParamsProvider
/*    */ {
/* 14 */   private static final String TAG = LegacyVrParamsProvider.class.getSimpleName();
/*    */   
/*    */ 
/*    */ 
/*    */   public final CardboardDevice.DeviceParams readDeviceParams()
/*    */   {
/* 20 */     return ConfigUtils.readDeviceParamsFromExternalStorage();
/*    */   }
/*    */   
/*    */   public final boolean writeDeviceParams(CardboardDevice.DeviceParams paramDeviceParams)
/*    */   {
/* 25 */     if (paramDeviceParams == null)
/*    */     {
/* 27 */       return ConfigUtils.removeDeviceParamsFromExternalStorage();
/*    */     }
/* 29 */     return ConfigUtils.writeDeviceParamsToExternalStorage(paramDeviceParams);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public final Phone.PhoneParams readPhoneParams()
/*    */   {
/*    */     Phone.PhoneParams localPhoneParams;
/*    */     
/* 38 */     if ((localPhoneParams = ConfigUtils.readPhoneParamsFromExternalStorage()) == null)
/*    */     {
/*    */ 
/* 41 */       localPhoneParams = PhoneParams.getPpiOverride();
/*    */     }
/* 43 */     return localPhoneParams;
/*    */   }
/*    */   
/*    */ 
/*    */   public final Preferences.UserPrefs readUserPrefs()
/*    */   {
/* 49 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public final boolean updateUserPrefs(Preferences.UserPrefs paramUserPrefs)
/*    */   {
/* 55 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public final Vr.VREvent.SdkConfigurationParams readSdkConfigurationParams(SdkConfiguration.SdkConfigurationRequest paramSdkConfigurationRequest)
/*    */   {
/* 61 */     return null;
/*    */   }
/*    */   
/*    */   public final void close() {}
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\LegacyVrParamsProvider.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */