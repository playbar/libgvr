/*    */ package com.google.vr.sdk.base;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.os.Process;
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
/*    */ public class PermissionUtils
/*    */ {
/*    */   public static boolean hasPermission(Context context, String permission)
/*    */   {
/* 21 */     if ((context == null) || (permission == null)) {
/* 22 */       return false;
/*    */     }
/* 24 */     return context.checkPermission(permission, Process.myPid(), Process.myUid()) == 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean hasStoragePermission(Context context)
/*    */   {
/* 32 */     return (hasPermission(context, "android.permission.READ_EXTERNAL_STORAGE")) && 
/* 33 */       (hasPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE"));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static boolean hasCameraPermission(Context context)
/*    */   {
/* 40 */     return hasPermission(context, "android.permission.CAMERA");
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\PermissionUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */