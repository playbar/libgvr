/*     */ package com.google.vr.cardboard;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.res.Resources;
/*     */ import android.util.DisplayMetrics;
/*     */ import android.util.Log;
/*     */ import android.view.Display;
/*     */ import android.view.WindowManager;
/*     */ import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
/*     */ import com.google.protobuf.nano.MessageNano;
/*     */ import com.google.vr.ndk.base.SdkConfigurationReader;
/*     */ import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams;
/*     */ import com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams;
/*     */ import com.google.vrtoolkit.cardboard.proto.nano.Preferences.UserPrefs;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @UsedByNative
/*     */ public class VrParamsProviderJni
/*     */ {
/*     */   private static final String TAG = "VrParamsProviderJni";
/*  42 */   private static volatile DisplayMetrics displayMetricsOverride = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setDisplayOverride(Display paramDisplay)
/*     */   {
/*  55 */     displayMetricsOverride = paramDisplay != null ? DisplayUtils.getDisplayMetricsLandscape(paramDisplay) : null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @UsedByNative
/*     */   private static byte[] readDeviceParams(Context paramContext)
/*     */   {
/*     */     VrParamsProvider localVrParamsProvider;
/*     */     
/*     */ 
/*  67 */     CardboardDevice.DeviceParams localDeviceParams = (localVrParamsProvider = VrParamsProviderFactory.create(paramContext)).readDeviceParams();
/*  68 */     localVrParamsProvider.close();
/*  69 */     if (localDeviceParams == null) {
/*  70 */       return null;
/*     */     }
/*  72 */     return MessageNano.toByteArray(localDeviceParams);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @UsedByNative
/*     */   private static byte[] readSdkConfigurationParams(Context paramContext)
/*     */   {
/*  82 */     return MessageNano.toByteArray(SdkConfigurationReader.getParams(paramContext));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @UsedByNative
/*     */   private static boolean writeDeviceParams(Context paramContext, byte[] paramArrayOfByte)
/*     */   {
/*  94 */     VrParamsProvider localVrParamsProvider = VrParamsProviderFactory.create(paramContext);
/*     */     
/*     */ 
/*     */     try
/*     */     {
/*  99 */       CardboardDevice.DeviceParams localDeviceParams = paramArrayOfByte != null ? (CardboardDevice.DeviceParams)MessageNano.mergeFrom(new CardboardDevice.DeviceParams(), paramArrayOfByte) : null;
/* 100 */       return localVrParamsProvider.writeDeviceParams(localDeviceParams);
/*     */     } catch (InvalidProtocolBufferNanoException localInvalidProtocolBufferNanoException) {
/* 102 */       String str = String.valueOf(localInvalidProtocolBufferNanoException);Log.w("VrParamsProviderJni", 31 + String.valueOf(str).length() + "Error parsing protocol buffer: " + str);
/* 103 */       return false;
/*     */     } finally {
/* 105 */       localVrParamsProvider.close();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @UsedByNative
/*     */   private static void readPhoneParams(Context paramContext, long paramLong)
/*     */   {
/* 118 */     if (paramContext == null)
/*     */     {
/*     */ 
/*     */ 
/* 122 */       Log.w("VrParamsProviderJni", "Missing context for phone params lookup. Results may be invalid.");
/* 123 */       updateNativePhoneParamsPointer(paramLong, Resources.getSystem().getDisplayMetrics());
/* 124 */       return;
/*     */     }
/*     */     
/*     */ 
/* 128 */     DisplayMetrics localDisplayMetrics = getDisplayMetrics(paramContext);
/*     */     VrParamsProvider localVrParamsProvider;
/* 130 */     Phone.PhoneParams localPhoneParams = (localVrParamsProvider = VrParamsProviderFactory.create(paramContext)).readPhoneParams();
/* 131 */     localVrParamsProvider.close();
/* 132 */     if (localPhoneParams != null) {
/* 133 */       if (localPhoneParams.hasXPpi()) {
/* 134 */         localDisplayMetrics.xdpi = localPhoneParams.getXPpi();
/*     */       }
/* 136 */       if (localPhoneParams.hasYPpi()) {
/* 137 */         localDisplayMetrics.ydpi = localPhoneParams.getYPpi();
/*     */       }
/*     */     }
/* 140 */     updateNativePhoneParamsPointer(paramLong, localDisplayMetrics);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @UsedByNative
/*     */   private static byte[] readUserPrefs(Context paramContext)
/*     */   {
/*     */     VrParamsProvider localVrParamsProvider;
/*     */     
/*     */ 
/*     */ 
/* 153 */     Preferences.UserPrefs localUserPrefs = (localVrParamsProvider = VrParamsProviderFactory.create(paramContext)).readUserPrefs();
/* 154 */     localVrParamsProvider.close();
/* 155 */     if (localUserPrefs == null) {
/* 156 */       return null;
/*     */     }
/* 158 */     return MessageNano.toByteArray(localUserPrefs);
/*     */   }
/*     */   
/*     */ 
/*     */   private static DisplayMetrics getDisplayMetrics(Context paramContext)
/*     */   {
/*     */     DisplayMetrics localDisplayMetrics;
/* 165 */     if ((localDisplayMetrics = displayMetricsOverride) != null) {
/* 166 */       return localDisplayMetrics;
/*     */     }
/*     */     WindowManager localWindowManager;
/*     */     Display localDisplay;
/* 170 */     return DisplayUtils.getDisplayMetricsLandscape(localDisplay = (localWindowManager = (WindowManager)paramContext.getSystemService("window")).getDefaultDisplay());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void updateNativePhoneParamsPointer(long paramLong, DisplayMetrics paramDisplayMetrics)
/*     */   {
/* 181 */     nativeUpdateNativePhoneParamsPointer(paramLong, paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels, paramDisplayMetrics.xdpi, paramDisplayMetrics.ydpi);
/*     */   }
/*     */   
/*     */   private static native void nativeUpdateNativePhoneParamsPointer(long paramLong, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2);
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\VrParamsProviderJni.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */