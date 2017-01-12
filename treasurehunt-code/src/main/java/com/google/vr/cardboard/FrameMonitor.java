/*    */ package com.google.vr.cardboard;
/*    */ 
/*    */ import android.view.Choreographer;
/*    */ import android.view.Choreographer.FrameCallback;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FrameMonitor
/*    */   implements Choreographer.FrameCallback
/*    */ {
/*    */   private final Choreographer choreographer;
/*    */   private final Choreographer.FrameCallback callback;
/*    */   private boolean isPaused;
/*    */   
/*    */   public FrameMonitor(Choreographer.FrameCallback paramFrameCallback)
/*    */   {
/* 21 */     this(Choreographer.getInstance(), paramFrameCallback);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public FrameMonitor(Choreographer paramChoreographer, Choreographer.FrameCallback paramFrameCallback)
/*    */   {
/* 28 */     ThreadUtils.assertOnUiThread();
/*    */     
/* 30 */     this.callback = paramFrameCallback;
/* 31 */     this.choreographer = paramChoreographer;
/* 32 */     paramChoreographer.postFrameCallback(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onPause()
/*    */   {
/* 39 */     if (this.isPaused) {
/* 40 */       return;
/*    */     }
/* 42 */     this.choreographer.removeFrameCallback(this);
/* 43 */     this.isPaused = true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onResume()
/*    */   {
/* 50 */     if (!this.isPaused) {
/* 51 */       return;
/*    */     }
/* 53 */     this.isPaused = false;
/* 54 */     this.choreographer.postFrameCallback(this);
/*    */   }
/*    */   
/*    */ 
/*    */   public void doFrame(long paramLong)
/*    */   {
/* 60 */     this.choreographer.postFrameCallback(this);
/* 61 */     this.callback.doFrame(paramLong);
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\FrameMonitor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */