/*    */ package com.google.vr.ndk.base;
/*    */ 
/*    */ import android.util.Log;
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
/*    */ 
/*    */ public class BufferViewportList
/*    */ {
/* 27 */   private static final String TAG = BufferViewportList.class.getSimpleName();
/*    */   
/*    */ 
/*    */ 
/*    */   long nativeBufferViewportList;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   BufferViewportList(long paramLong)
/*    */   {
/* 38 */     this.nativeBufferViewportList = paramLong;
/*    */   }
/*    */   
/*    */   protected void finalize() throws Throwable
/*    */   {
/*    */     try
/*    */     {
/* 45 */       if (this.nativeBufferViewportList != 0L) {
/* 46 */         Log.w(TAG, "BufferViewportList.shutdown() should be called to ensure resource cleanup");
/* 47 */         shutdown();
/*    */       }
/*    */     } finally {
/* 50 */       super.finalize();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void shutdown()
/*    */   {
/* 61 */     if (this.nativeBufferViewportList != 0L) {
/* 62 */       GvrApi.nativeBufferViewportListDestroy(this.nativeBufferViewportList);
/* 63 */       this.nativeBufferViewportList = 0L;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void get(int paramInt, BufferViewport paramBufferViewport)
/*    */   {
/* 74 */     GvrApi.nativeBufferViewportListGetItem(this.nativeBufferViewportList, paramInt, paramBufferViewport.nativeBufferViewport);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void set(int paramInt, BufferViewport paramBufferViewport)
/*    */   {
/* 86 */     GvrApi.nativeBufferViewportListSetItem(this.nativeBufferViewportList, paramInt, paramBufferViewport.nativeBufferViewport);
/*    */   }
/*    */   
/*    */ 
/*    */   public int size()
/*    */   {
/* 92 */     return GvrApi.nativeBufferViewportListGetSize(this.nativeBufferViewportList);
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\ndk\base\BufferViewportList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */