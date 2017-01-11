/*    */ package com.google.vr.sdk.base;
/*    */ 
/*    */ import android.app.Activity;
/*    */ import com.google.vr.cardboard.AndroidNCompat;
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
/*    */ public final class AndroidCompat
/*    */ {
/*    */   public static boolean setVrModeEnabled(Activity activity, boolean enabled)
/*    */   {
/* 29 */     return AndroidNCompat.setVrModeEnabled(activity, enabled, 1);
/*    */   }
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
/*    */   public static boolean trySetVrModeEnabled(Activity activity, boolean enabled)
/*    */   {
/* 49 */     return AndroidNCompat.setVrModeEnabled(activity, enabled, 0);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void setSustainedPerformanceMode(Activity activity, boolean enabled)
/*    */   {
/* 60 */     AndroidNCompat.setSustainedPerformanceMode(activity, enabled);
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\AndroidCompat.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */