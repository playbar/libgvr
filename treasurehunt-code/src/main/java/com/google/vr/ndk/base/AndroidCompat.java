/*    */ package com.google.vr.ndk.base;
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
/*    */   public static boolean setVrModeEnabled(Activity paramActivity, boolean paramBoolean)
/*    */   {
/* 29 */     return AndroidNCompat.setVrModeEnabled(paramActivity, paramBoolean);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void setSustainedPerformanceMode(Activity paramActivity, boolean paramBoolean)
/*    */   {
/* 39 */     AndroidNCompat.setSustainedPerformanceMode(paramActivity, paramBoolean);
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\ndk\base\AndroidCompat.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */