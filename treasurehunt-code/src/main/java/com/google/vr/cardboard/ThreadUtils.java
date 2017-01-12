/*    */ package com.google.vr.cardboard;
/*    */ 
/*    */ import android.os.Handler;
/*    */ import android.os.Looper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ThreadUtils
/*    */ {
/* 11 */   private static final Handler uiHandler = new Handler(Looper.getMainLooper());
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void runOnUiThread(Runnable paramRunnable)
/*    */   {
/* 21 */     if (runningOnUiThread()) {
/* 22 */       paramRunnable.run();return;
/*    */     }
/* 24 */     uiHandler.post(paramRunnable);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void postOnUiThread(Runnable paramRunnable)
/*    */   {
/* 35 */     uiHandler.post(paramRunnable);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static boolean runningOnUiThread()
/*    */   {
/* 42 */     return uiHandler.getLooper() == Looper.myLooper();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void assertOnUiThread() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void throwIfNotOnUiThread()
/*    */   {
/* 59 */     if (!runningOnUiThread()) {
/* 60 */       throw new IllegalStateException("Call was not made on the UI thread.");
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static Handler getUiThreadHandler()
/*    */   {
/* 68 */     return uiHandler;
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\ThreadUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */