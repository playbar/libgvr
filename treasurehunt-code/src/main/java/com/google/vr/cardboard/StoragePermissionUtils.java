/*    */ package com.google.vr.cardboard;
/*    */ 
/*    */ import android.app.Activity;
/*    */ import android.content.Context;
/*    */ import android.os.Build.VERSION;
/*    */ import android.util.Log;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StoragePermissionUtils
/*    */ {
/* 16 */   private static final String TAG = StoragePermissionUtils.class.getSimpleName();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private static final String STORAGE_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static final int STORAGE_PERMISSION_DUMMY_REQUEST_CODE = 239;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void requestStoragePermission(Context paramContext)
/*    */   {
/* 34 */     if (VERSION.SDK_INT < 23) {
/* 35 */       return;
/*    */     }
/*    */     
/* 38 */     if (paramContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
/*    */       return;
/*    */     }
/*    */     
/*    */     Activity localActivity;
/* 43 */     if ((localActivity = ContextUtils.getActivity(paramContext)) == null) {
/* 44 */       Log.w(TAG, "An Activity Context is required, aborting storage permission request.");
/* 45 */       return;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 50 */     localActivity.requestPermissions(new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 239);
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\StoragePermissionUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */