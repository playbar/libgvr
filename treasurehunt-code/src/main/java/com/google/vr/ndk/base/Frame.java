/*     */ package com.google.vr.ndk.base;
/*     */ 
/*     */ import android.graphics.Point;
/*     */ import android.util.Log;
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
/*     */ public class Frame
/*     */ {
/*  27 */   private static final String TAG = Frame.class.getSimpleName();
/*     */   
/*     */   private long nativeFrame;
/*     */   
/*     */ 
/*     */   Frame()
/*     */   {
/*  34 */     this.nativeFrame = 0L;
/*     */   }
/*     */   
/*     */   protected void finalize() throws Throwable
/*     */   {
/*     */     try
/*     */     {
/*  41 */       if (this.nativeFrame != 0L) {
/*  42 */         Log.w(TAG, "Frame finalized before it was submitted");
/*     */       }
/*     */     } finally {
/*  45 */       super.finalize();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void bindBuffer(int paramInt)
/*     */   {
/*  55 */     checkAccess();
/*  56 */     GvrApi.nativeFrameBindBuffer(this.nativeFrame, paramInt);
/*     */   }
/*     */   
/*     */   public void unbind()
/*     */   {
/*  61 */     checkAccess();
/*  62 */     GvrApi.nativeFrameUnbind(this.nativeFrame);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFramebufferObject(int paramInt)
/*     */   {
/*  74 */     checkAccess();
/*  75 */     return GvrApi.nativeFrameGetFramebufferObject(this.nativeFrame, paramInt);
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
/*     */   public void getBufferSize(int paramInt, Point paramPoint)
/*     */   {
/*  88 */     checkAccess();
/*  89 */     GvrApi.nativeFrameGetBufferSize(this.nativeFrame, paramInt, paramPoint);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void submit(BufferViewportList paramBufferViewportList, float[] paramArrayOfFloat)
/*     */   {
/* 101 */     checkAccess();
/* 102 */     GvrApi.nativeFrameSubmit(this.nativeFrame, paramBufferViewportList.nativeBufferViewportList, paramArrayOfFloat);
/* 103 */     this.nativeFrame = 0L;
/*     */   }
/*     */   
/*     */   void setNativeFrame(long paramLong)
/*     */   {
/* 108 */     this.nativeFrame = paramLong;
/*     */   }
/*     */   
/*     */   long getNativeFrame()
/*     */   {
/* 113 */     return this.nativeFrame;
/*     */   }
/*     */   
/*     */   private void checkAccess() {
/* 117 */     if (this.nativeFrame == 0L) {
/* 118 */       throw new RuntimeException("Frame was reused after submission");
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\ndk\base\Frame.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */