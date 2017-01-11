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
/*     */ 
/*     */ public class SwapChain
/*     */ {
/*  28 */   private static final String TAG = SwapChain.class.getSimpleName();
/*     */   
/*     */ 
/*     */ 
/*     */   private long nativeSwapChain;
/*     */   
/*     */ 
/*     */   private final Frame[] frames;
/*     */   
/*     */ 
/*     */   private int currentFrame;
/*     */   
/*     */ 
/*     */ 
/*     */   SwapChain(long paramLong)
/*     */   {
/*  44 */     this.nativeSwapChain = paramLong;
/*  45 */     this.frames = new Frame[2];
/*  46 */     this.frames[0] = new Frame();
/*  47 */     this.frames[1] = new Frame();
/*  48 */     this.currentFrame = 0;
/*     */   }
/*     */   
/*     */   protected void finalize() throws Throwable
/*     */   {
/*     */     try
/*     */     {
/*  55 */       if (this.nativeSwapChain != 0L) {
/*  56 */         Log.w(TAG, "SwapChain.shutdown() should be called to ensure resource cleanup");
/*  57 */         shutdown();
/*     */       }
/*     */     } finally {
/*  60 */       super.finalize();
/*     */     }
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
/*     */   public Frame acquireFrame()
/*     */   {
/*  80 */     if ((this.frames[0].getNativeFrame() != 0L) || (this.frames[1].getNativeFrame() != 0L)) {
/*  81 */       throw new RuntimeException("Previous frame not submitted");
/*     */     }
/*  83 */     this.currentFrame = ((this.currentFrame + 1) % 2);
/*     */     long l;
/*  85 */     if ((l = GvrApi.nativeSwapChainAcquireFrame(this.nativeSwapChain)) == 0L) {
/*  86 */       return null;
/*     */     }
/*  88 */     this.frames[this.currentFrame].setNativeFrame(l);
/*  89 */     return this.frames[this.currentFrame];
/*     */   }
/*     */   
/*     */   public int getBufferCount()
/*     */   {
/*  94 */     return GvrApi.nativeSwapChainGetBufferCount(this.nativeSwapChain);
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
/*     */   public void getBufferSize(int paramInt, Point paramPoint)
/*     */   {
/* 108 */     GvrApi.nativeSwapChainGetBufferSize(this.nativeSwapChain, paramInt, paramPoint);
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
/*     */   public void resizeBuffer(int paramInt, Point paramPoint)
/*     */   {
/* 121 */     GvrApi.nativeSwapChainResizeBuffer(this.nativeSwapChain, paramInt, paramPoint.x, paramPoint.y);
/*     */   }
/*     */   
/*     */   public void shutdown()
/*     */   {
/* 126 */     if (this.nativeSwapChain != 0L) {
/* 127 */       GvrApi.nativeSwapChainDestroy(this.nativeSwapChain);
/* 128 */       this.nativeSwapChain = 0L;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\ndk\base\SwapChain.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */