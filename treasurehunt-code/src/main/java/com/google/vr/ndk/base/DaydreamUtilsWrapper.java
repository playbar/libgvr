/*    */ package com.google.vr.ndk.base;
/*    */ 
/*    */ import android.app.Activity;
/*    */ import android.content.Context;
/*    */ import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams;
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
/*    */ public class DaydreamUtilsWrapper
/*    */ {
/*    */   public boolean isDaydreamActivity(Activity paramActivity)
/*    */   {
/* 26 */     return getActivityDaydreamCompatibility(paramActivity) != 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isDaydreamRequiredActivity(Activity paramActivity)
/*    */   {
/* 38 */     return getActivityDaydreamCompatibility(paramActivity) == 2;
/*    */   }
/*    */   
/*    */   public int getActivityDaydreamCompatibility(Activity paramActivity)
/*    */   {
/* 43 */     return DaydreamUtils.getComponentDaydreamCompatibility(paramActivity, paramActivity.getComponentName());
/*    */   }
/*    */   
/*    */   public boolean isDaydreamPhone(Context paramContext)
/*    */   {
/* 48 */     return DaydreamUtils.isDaydreamPhone(paramContext);
/*    */   }
/*    */   
/*    */   public boolean isDaydreamViewer(DeviceParams paramDeviceParams)
/*    */   {
/* 53 */     return DaydreamUtils.isDaydreamViewer(paramDeviceParams);
/*    */   }
/*    */ }

