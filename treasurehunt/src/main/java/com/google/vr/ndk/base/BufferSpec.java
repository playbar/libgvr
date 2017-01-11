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
/*     */ public class BufferSpec
/*     */ {
/*  49 */   private static final String TAG = BufferSpec.class.getSimpleName();
/*     */   
/*     */ 
/*     */ 
/*     */   long nativeBufferSpec;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   BufferSpec(long paramLong)
/*     */   {
/*  60 */     this.nativeBufferSpec = paramLong;
/*     */   }
/*     */   
/*     */   protected void finalize() throws Throwable
/*     */   {
/*     */     try
/*     */     {
/*  67 */       if (this.nativeBufferSpec != 0L) {
/*  68 */         Log.w(TAG, "BufferSpec.shutdown() should be called to ensure resource cleanup");
/*  69 */         shutdown();
/*     */       }
/*     */     } finally {
/*  72 */       super.finalize();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void shutdown()
/*     */   {
/*  83 */     if (this.nativeBufferSpec != 0L) {
/*  84 */       GvrApi.nativeBufferSpecDestroy(this.nativeBufferSpec);
/*  85 */       this.nativeBufferSpec = 0L;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void getSize(Point paramPoint)
/*     */   {
/*  96 */     GvrApi.nativeBufferSpecGetSize(this.nativeBufferSpec, paramPoint);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSize(Point paramPoint)
/*     */   {
/* 105 */     GvrApi.nativeBufferSpecSetSize(this.nativeBufferSpec, paramPoint.x, paramPoint.y);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getSamples()
/*     */   {
/* 115 */     return GvrApi.nativeBufferSpecGetSamples(this.nativeBufferSpec);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSamples(int paramInt)
/*     */   {
/* 124 */     GvrApi.nativeBufferSpecSetSamples(this.nativeBufferSpec, paramInt);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setColorFormat(int paramInt)
/*     */   {
/* 133 */     if (!isValidColorFormat(paramInt)) {
/* 134 */       throw new IllegalArgumentException("Invalid color format.");
/*     */     }
/* 136 */     GvrApi.nativeBufferSpecSetColorFormat(this.nativeBufferSpec, paramInt);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDepthStencilFormat(int paramInt)
/*     */   {
/* 145 */     if (!isValidDepthStencilFormat(paramInt)) {
/* 146 */       throw new IllegalArgumentException("Invalid depth-stencil format.");
/*     */     }
/* 148 */     GvrApi.nativeBufferSpecSetDepthStencilFormat(this.nativeBufferSpec, paramInt);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isValidColorFormat(int paramInt)
/*     */   {
/* 158 */     return (paramInt >= 0) && (paramInt < 2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isValidDepthStencilFormat(int paramInt)
/*     */   {
/* 168 */     return (paramInt == 255) || ((paramInt >= 0) && (paramInt < 6));
/*     */   }
/*     */   
/*     */   public static abstract class DepthStencilFormat
/*     */   {
/*     */     public static final int NONE = 255;
/*     */     public static final int DEPTH_16 = 0;
/*     */     public static final int DEPTH_24 = 1;
/*     */     public static final int DEPTH_24_STENCIL_8 = 2;
/*     */     public static final int DEPTH_32_F = 3;
/*     */     public static final int DEPTH_32_F_STENCIL_8 = 4;
/*     */     public static final int STENCIL_8 = 5;
/*     */     public static final int NUM_FORMATS = 6;
/*     */   }
/*     */   
/*     */   public static abstract class ColorFormat
/*     */   {
/*     */     public static final int RGBA_8888 = 0;
/*     */     public static final int RGB_565 = 1;
/*     */     public static final int NUM_FORMATS = 2;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\ndk\base\BufferSpec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */