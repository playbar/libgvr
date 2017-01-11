/*    */ package com.google.vr.vrcore.base.api;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.content.pm.PackageManager;
/*    */ import android.content.pm.PackageManager.NameNotFoundException;
/*    */ import android.content.pm.Signature;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BuildUtils
/*    */ {
/*    */   private static volatile Boolean isDebug;
/*    */   
/*    */   public static boolean isDebugBuild(Context paramContext)
/*    */   {
/* 16 */     if (isDebug != null) return isDebug.booleanValue(); return computeIsDebugBuild(paramContext);
/*    */   }
/*    */   
/*    */   public static synchronized void setIsDebugBuild(boolean paramBoolean)
/*    */   {
/* 21 */     isDebug = Boolean.valueOf(paramBoolean);
/*    */   }
/*    */   
/*    */   private static synchronized boolean computeIsDebugBuild(Context paramContext) {
/* 25 */     if (isDebug == null) {
/*    */       try
/*    */       {
/*    */         PackageManager localPackageManager;
/* 29 */         isDebug = Boolean.valueOf(SignatureUtils.verifySignature((localPackageManager = paramContext.getPackageManager())
/* 30 */           .getPackageInfo(paramContext
/* 31 */           .getPackageName(), 64), new Signature[] { SignatureUtils.BLAZE_DEBUG_SIGNATURE, SignatureUtils.ANDROID_DEBUG_SIGNATURE, SignatureUtils.VRCORE_DEBUG_SIGNATURE }));
/*    */ 
/*    */       }
/*    */       catch (PackageManager.NameNotFoundException localNameNotFoundException)
/*    */       {
/* 36 */         throw new IllegalStateException("Unable to find self package info", localNameNotFoundException);
/*    */       }
/*    */     }
/* 39 */     return isDebug.booleanValue();
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\base\api\BuildUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */