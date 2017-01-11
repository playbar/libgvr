/*     */ package com.google.vr.internal.controller;
/*     */ 
/*     */ import com.google.vr.cardboard.annotations.UsedByNative;
/*     */ import com.google.vr.vrcore.controller.api.ControllerAccelEvent;
/*     */ import com.google.vr.vrcore.controller.api.ControllerButtonEvent;
/*     */ import com.google.vr.vrcore.controller.api.ControllerEventPacket;
/*     */ import com.google.vr.vrcore.controller.api.ControllerGyroEvent;
/*     */ import com.google.vr.vrcore.controller.api.ControllerOrientationEvent;
/*     */ import com.google.vr.vrcore.controller.api.ControllerTouchEvent;
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
/*     */ @UsedByNative
/*     */ public final class NativeCallbacks
/*     */   implements ServiceBridge.Callbacks
/*     */ {
/*     */   private final long userData;
/*     */   private boolean closed;
/*     */   
/*     */   @UsedByNative
/*     */   public NativeCallbacks(long paramLong)
/*     */   {
/*  42 */     this.userData = paramLong;
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
/*     */   @UsedByNative
/*     */   public final synchronized void close()
/*     */   {
/*  56 */     this.closed = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public final synchronized void onControllerStateChanged(int paramInt1, int paramInt2)
/*     */   {
/*  63 */     if (!this.closed) {
/*  64 */       handleStateChanged(this.userData, paramInt1, paramInt2);
/*     */     }
/*     */   }
/*     */   
/*     */   public final synchronized void onControllerEventPacket(ControllerEventPacket paramControllerEventPacket)
/*     */   {
/*  70 */     if (this.closed) {
/*     */       return;
/*     */     }
/*     */     
/*     */     Object localObject;
/*     */     
/*  76 */     for (int i = 0; (!this.closed) && (i < paramControllerEventPacket.getAccelEventCount()); i++) {
/*  77 */       localObject = paramControllerEventPacket.getAccelEvent(i);
/*  78 */       handleAccelEvent(this.userData, ((ControllerAccelEvent)localObject).timestampNanos, ((ControllerAccelEvent)localObject).x, ((ControllerAccelEvent)localObject).y, ((ControllerAccelEvent)localObject).z);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  84 */     for (i = 0; (!this.closed) && (i < paramControllerEventPacket.getButtonEventCount()); i++) {
/*  85 */       localObject = paramControllerEventPacket.getButtonEvent(i);
/*  86 */       handleButtonEvent(this.userData, ((ControllerButtonEvent)localObject).timestampNanos, ((ControllerButtonEvent)localObject).button, ((ControllerButtonEvent)localObject).down);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  92 */     for (i = 0; (!this.closed) && (i < paramControllerEventPacket.getGyroEventCount()); i++) {
/*  93 */       localObject = paramControllerEventPacket.getGyroEvent(i);
/*  94 */       handleGyroEvent(this.userData, ((ControllerGyroEvent)localObject).timestampNanos, ((ControllerGyroEvent)localObject).x, ((ControllerGyroEvent)localObject).y, ((ControllerGyroEvent)localObject).z);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  99 */     for (i = 0; (!this.closed) && (i < paramControllerEventPacket.getOrientationEventCount()); i++) {
/* 100 */       localObject = paramControllerEventPacket.getOrientationEvent(i);
/* 101 */       handleOrientationEvent(this.userData, ((ControllerOrientationEvent)localObject).timestampNanos, ((ControllerOrientationEvent)localObject).qx, ((ControllerOrientationEvent)localObject).qy, ((ControllerOrientationEvent)localObject).qz, ((ControllerOrientationEvent)localObject).qw);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 107 */     for (i = 0; (!this.closed) && (i < paramControllerEventPacket.getTouchEventCount()); i++) {
/* 108 */       localObject = paramControllerEventPacket.getTouchEvent(i);
/* 109 */       handleTouchEvent(this.userData, ((ControllerTouchEvent)localObject).timestampNanos, ((ControllerTouchEvent)localObject).action, ((ControllerTouchEvent)localObject).x, ((ControllerTouchEvent)localObject).y);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public final synchronized void onControllerRecentered(ControllerOrientationEvent paramControllerOrientationEvent)
/*     */   {
/* 116 */     if (!this.closed) {
/* 117 */       handleControllerRecentered(this.userData, paramControllerOrientationEvent.timestampNanos, paramControllerOrientationEvent.qx, paramControllerOrientationEvent.qy, paramControllerOrientationEvent.qz, paramControllerOrientationEvent.qw);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public final synchronized void onServiceConnected(int paramInt)
/*     */   {
/* 124 */     if (!this.closed) {
/* 125 */       handleServiceConnected(this.userData, paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   public final synchronized void onServiceDisconnected()
/*     */   {
/* 131 */     if (!this.closed) {
/* 132 */       handleServiceDisconnected(this.userData);
/*     */     }
/*     */   }
/*     */   
/*     */   public final synchronized void onServiceFailed()
/*     */   {
/* 138 */     if (!this.closed) {
/* 139 */       handleServiceFailed(this.userData);
/*     */     }
/*     */   }
/*     */   
/*     */   public final synchronized void onServiceUnavailable()
/*     */   {
/* 145 */     if (!this.closed) {
/* 146 */       handleServiceUnavailable(this.userData);
/*     */     }
/*     */   }
/*     */   
/*     */   public final synchronized void onServiceInitFailed(int paramInt)
/*     */   {
/* 152 */     if (!this.closed) {
/* 153 */       handleServiceInitFailed(this.userData, paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   private final native void handleStateChanged(long paramLong, int paramInt1, int paramInt2);
/*     */   
/*     */   private final native void handleControllerRecentered(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
/*     */   
/*     */   private final native void handleTouchEvent(long paramLong1, long paramLong2, int paramInt, float paramFloat1, float paramFloat2);
/*     */   
/*     */   private final native void handleOrientationEvent(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
/*     */   
/*     */   private final native void handleButtonEvent(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean);
/*     */   
/*     */   private final native void handleAccelEvent(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3);
/*     */   
/*     */   private final native void handleGyroEvent(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3);
/*     */   
/*     */   private final native void handleServiceInitFailed(long paramLong, int paramInt);
/*     */   
/*     */   private final native void handleServiceFailed(long paramLong);
/*     */   
/*     */   private final native void handleServiceUnavailable(long paramLong);
/*     */   
/*     */   private final native void handleServiceConnected(long paramLong, int paramInt);
/*     */   
/*     */   private final native void handleServiceDisconnected(long paramLong);
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\internal\controller\NativeCallbacks.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */