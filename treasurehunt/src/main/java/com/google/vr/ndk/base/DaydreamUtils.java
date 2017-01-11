/*     */ package com.google.vr.ndk.base;
/*     */ 
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.pm.ActivityInfo;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.content.pm.ResolveInfo;
/*     */ import android.os.Build.VERSION;
/*     */ import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DaydreamUtils
/*     */ {
/*     */   static final String INTENT_CATEGORY_DAYDREAM = "com.google.intent.category.DAYDREAM";
/*     */   static final String INTENT_CATEGORY_CARDBOARD = "com.google.intent.category.CARDBOARD";
/*     */   public static final int DAYDREAM_NOT_SUPPORTED = 0;
/*     */   public static final int DAYDREAM_OPTIONAL = 1;
/*     */   public static final int DAYDREAM_REQUIRED = 2;
/*     */   private static boolean sDaydreamPhoneOverrideForTesting;
/*     */   
/*     */   public static boolean isDaydreamPhone(Context paramContext)
/*     */   {
/*  32 */     if (sDaydreamPhoneOverrideForTesting) {
/*  33 */       return true;
/*     */     }
/*     */     
/*  36 */     if (Build.VERSION.SDK_INT < 24) {
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     return 
/*     */     
/*  42 */       paramContext.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance");
/*     */   }
/*     */   
/*     */   public static boolean isDaydreamViewer(CardboardDevice.DeviceParams paramDeviceParams)
/*     */   {
/*  47 */     return (paramDeviceParams != null) && (paramDeviceParams.daydreamInternal != null);
/*     */   }
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
/*     */   public static int getComponentDaydreamCompatibility(Context paramContext, ComponentName paramComponentName)
/*     */   {
/*  74 */     return getComponentDaydreamCompatibility(paramContext, paramContext.getPackageManager(), paramComponentName);
/*     */   }
/*     */   
/*     */   static void setIsDaydreamPhoneForTesting(boolean paramBoolean)
/*     */   {
/*  79 */     sDaydreamPhoneOverrideForTesting = paramBoolean;
/*     */   }
/*     */   
/*     */ 
/*     */   static int getComponentDaydreamCompatibility(Context paramContext, PackageManager paramPackageManager, ComponentName paramComponentName)
/*     */   {
/*     */     Intent localIntent1;
/*     */     
/*  87 */     (localIntent1 = new Intent()).setPackage(paramComponentName.getPackageName());
/*  88 */     localIntent1.addCategory("com.google.intent.category.DAYDREAM");
/*  89 */     if (!canResolveIntent(paramPackageManager, paramComponentName, localIntent1)) {
/*  90 */       return 0;
/*     */     }
/*     */     
/*     */ 
/*     */     Intent localIntent2;
/*     */     
/*  96 */     (localIntent2 = new Intent()).setPackage(paramComponentName.getPackageName());
/*  97 */     localIntent2.addCategory("com.google.intent.category.CARDBOARD");
/*     */     
/*  99 */     if (canResolveIntent(paramPackageManager, paramComponentName, localIntent2))
/*     */     {
/* 101 */       return 1;
/*     */     }
/*     */     
/* 104 */     return 2;
/*     */   }
/*     */   
/*     */   private static boolean canResolveIntent(PackageManager paramPackageManager, ComponentName paramComponentName, Intent paramIntent)
/*     */   {
/*     */     List localList;
/*     */     Iterator localIterator;
/* 111 */     if ((localList = paramPackageManager.queryIntentActivities(paramIntent, 128)) != null) {
/* 112 */       for (localIterator = localList.iterator(); localIterator.hasNext();) { ResolveInfo localResolveInfo;
/* 113 */         if (((localResolveInfo = (ResolveInfo)localIterator.next()) != null) && (localResolveInfo.activityInfo != null) && (localResolveInfo.activityInfo.name != null))
/*     */         {
/*     */ 
/* 116 */           if (localResolveInfo.activityInfo.name.equals(paramComponentName.getClassName()))
/* 117 */             return true;
/*     */         }
/*     */       }
/*     */     }
/* 121 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\ndk\base\DaydreamUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */