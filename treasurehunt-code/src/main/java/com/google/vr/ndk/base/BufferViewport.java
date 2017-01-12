/*     */ package com.google.vr.ndk.base;
/*     */ 
/*     */ import android.graphics.RectF;
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
/*     */ public class BufferViewport
/*     */ {
/*  34 */   private static final String TAG = BufferViewport.class.getSimpleName();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long nativeBufferViewport;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int EXTERNAL_SURFACE_ID_NONE = -1;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int BUFFER_INDEX_EXTERNAL_SURFACE = -1;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   BufferViewport(long paramLong)
/*     */   {
/*  67 */     this.nativeBufferViewport = paramLong;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject)
/*     */   {
/*  72 */     if (!(paramObject instanceof BufferViewport)) {
/*  73 */       return false;
/*     */     }
/*  75 */     BufferViewport localBufferViewport = (BufferViewport)paramObject;
/*  76 */     return GvrApi.nativeBufferViewportEqual(this.nativeBufferViewport, localBufferViewport.nativeBufferViewport);
/*     */   }
/*     */   
/*     */   protected void finalize()
/*     */     throws Throwable
/*     */   {
/*     */     try
/*     */     {
/*  84 */       if (this.nativeBufferViewport != 0L) {
/*  85 */         Log.w(TAG, "BufferViewport.shutdown() should be called to ensure resource cleanup");
/*  86 */         shutdown();
/*     */       }
/*     */     } finally {
/*  89 */       super.finalize();
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
/* 100 */     if (this.nativeBufferViewport != 0L) {
/* 101 */       GvrApi.nativeBufferViewportDestroy(this.nativeBufferViewport);
/* 102 */       this.nativeBufferViewport = 0L;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void getSourceUv(RectF paramRectF)
/*     */   {
/* 112 */     GvrApi.nativeBufferViewportGetSourceUv(this.nativeBufferViewport, paramRectF);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSourceUv(RectF paramRectF)
/*     */   {
/* 121 */     GvrApi.nativeBufferViewportSetSourceUv(this.nativeBufferViewport, paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void getSourceFov(RectF paramRectF)
/*     */   {
/* 131 */     GvrApi.nativeBufferViewportGetSourceFov(this.nativeBufferViewport, paramRectF);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSourceFov(RectF paramRectF)
/*     */   {
/* 140 */     GvrApi.nativeBufferViewportSetSourceFov(this.nativeBufferViewport, paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void getTransform(float[] paramArrayOfFloat)
/*     */   {
/* 152 */     GvrApi.nativeBufferViewportGetTransform(this.nativeBufferViewport, paramArrayOfFloat);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTransform(float[] paramArrayOfFloat)
/*     */   {
/* 163 */     GvrApi.nativeBufferViewportSetTransform(this.nativeBufferViewport, paramArrayOfFloat);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTargetEye()
/*     */   {
/* 170 */     return GvrApi.nativeBufferViewportGetTargetEye(this.nativeBufferViewport);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTargetEye(int paramInt)
/*     */   {
/* 177 */     GvrApi.nativeBufferViewportSetTargetEye(this.nativeBufferViewport, paramInt);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSourceBufferIndex()
/*     */   {
/* 184 */     return GvrApi.nativeBufferViewportGetSourceBufferIndex(this.nativeBufferViewport);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSourceBufferIndex(int paramInt)
/*     */   {
/* 193 */     GvrApi.nativeBufferViewportSetSourceBufferIndex(this.nativeBufferViewport, paramInt);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getExternalSurfaceId()
/*     */   {
/* 204 */     return GvrApi.nativeBufferViewportGetExternalSurfaceId(this.nativeBufferViewport);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setExternalSurfaceId(int paramInt)
/*     */   {
/* 215 */     GvrApi.nativeBufferViewportSetExternalSurfaceId(this.nativeBufferViewport, paramInt);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getReprojection()
/*     */   {
/* 224 */     return GvrApi.nativeBufferViewportGetReprojection(this.nativeBufferViewport);
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
/*     */   public void setReprojection(int paramInt)
/*     */   {
/* 237 */     GvrApi.nativeBufferViewportSetReprojection(this.nativeBufferViewport, paramInt);
/*     */   }
/*     */   
/*     */   public static abstract class Reprojection
/*     */   {
/*     */     public static final int NONE = 0;
/*     */     public static final int FULL = 1;
/*     */   }
/*     */   
/*     */   public static abstract class EyeType
/*     */   {
/*     */     public static final int LEFT = 0;
/*     */     public static final int RIGHT = 1;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\ndk\base\BufferViewport.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */