/*    */ package com.google.vr.cardboard;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.content.pm.ApplicationInfo;
/*    */ import android.content.pm.PackageManager;
/*    */ import android.content.pm.PackageManager.NameNotFoundException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PackageUtils
/*    */ {
/*    */   private static final String GOOGLE_PACKAGE_PREFIX = "com.google.";
/*    */   
/*    */   public static boolean isGooglePackage(String paramString)
/*    */   {
/* 21 */     return (paramString != null) && (paramString.startsWith("com.google."));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static boolean isSystemPackage(Context paramContext, String paramString)
/*    */   {
/*    */     try
/*    */     {
/*    */       ApplicationInfo localApplicationInfo;
/*    */       
/*    */ 
/*    */       int i;
/*    */       
/*    */ 
/* 36 */       if ((((i = (localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramString, 0)) != null ? localApplicationInfo.flags : 0) & 0x1) != 0) || ((i & 0x80) != 0))
/*    */       {
/* 38 */         return true;
/*    */       }
/*    */     } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
/* 41 */       return false;
/*    */     }
/* 43 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\PackageUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */