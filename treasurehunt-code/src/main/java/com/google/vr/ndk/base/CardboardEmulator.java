/*     */ package com.google.vr.ndk.base;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.google.vr.cardboard.ThreadUtils;
/*     */ import com.google.vr.internal.controller.ServiceBridge;
/*     */ import com.google.vr.internal.controller.ServiceBridge.Callbacks;
/*     */ import com.google.vr.vrcore.controller.api.ControllerButtonEvent;
/*     */ import com.google.vr.vrcore.controller.api.ControllerEventPacket;
/*     */ import com.google.vr.vrcore.controller.api.ControllerOrientationEvent;
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
/*     */ class CardboardEmulator
/*     */ {
/*  25 */   private static final String TAG = CardboardEmulator.class.getSimpleName();
/*     */   
/*     */ 
/*     */ 
/*     */   private static final boolean DEBUG = false;
/*     */   
/*     */ 
/*     */ 
/*     */   private final ServiceBridge controllerServiceBridge;
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean resumed;
/*     */   
/*     */ 
/*     */ 
/*     */   public CardboardEmulator(Context paramContext, Runnable paramRunnable)
/*     */   {
/*  43 */     this.controllerServiceBridge = createServiceBridge(paramContext, new ControllerCallbacks(paramRunnable));
/*     */     
/*     */ 
/*  46 */     this.controllerServiceBridge.setOrientationEnabled(false);
/*  47 */     this.controllerServiceBridge.setGyroEnabled(false);
/*  48 */     this.controllerServiceBridge.setAccelEnabled(false);
/*  49 */     this.controllerServiceBridge.setTouchEnabled(false);
/*  50 */     this.controllerServiceBridge.setGesturesEnabled(false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onResume()
/*     */   {
/*  58 */     if (!this.resumed) {
/*  59 */       this.resumed = true;
/*  60 */       this.controllerServiceBridge.requestBind();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onPause()
/*     */   {
/*  69 */     if (this.resumed) {
/*  70 */       this.resumed = false;
/*  71 */       this.controllerServiceBridge.requestUnbind();
/*     */     }
/*     */   }
/*     */   
/*     */   protected ServiceBridge createServiceBridge(Context paramContext, ServiceBridge.Callbacks paramCallbacks)
/*     */   {
/*  77 */     return new ServiceBridge(paramContext, paramCallbacks);
/*     */   }
/*     */   
/*     */ 
/*     */   private static class ControllerCallbacks
/*     */     implements ServiceBridge.Callbacks
/*     */   {
/*     */     private final Runnable cardboardTriggerCallback;
/*     */     
/*     */     ControllerCallbacks(Runnable paramRunnable)
/*     */     {
/*  88 */       this.cardboardTriggerCallback = paramRunnable;
/*     */     }
/*     */     
/*     */ 
/*     */     public void onServiceConnected(int paramInt) {}
/*     */     
/*     */ 
/*     */     public void onServiceDisconnected() {}
/*     */     
/*     */ 
/*     */     public void onServiceUnavailable() {}
/*     */     
/*     */ 
/*     */     public void onServiceFailed() {}
/*     */     
/*     */ 
/*     */     public void onServiceInitFailed(int paramInt) {}
/*     */     
/*     */ 
/*     */     public void onControllerStateChanged(int paramInt1, int paramInt2) {}
/*     */     
/*     */     public void onControllerEventPacket(ControllerEventPacket paramControllerEventPacket)
/*     */     {
/* 111 */       for (int i = 0; i < paramControllerEventPacket.getButtonEventCount(); i++) {
/*     */         ControllerButtonEvent localControllerButtonEvent;
/* 113 */         if ((localControllerButtonEvent = paramControllerEventPacket.getButtonEvent(i)).down)
/*     */         {
/*     */ 
/* 116 */           switch (localControllerButtonEvent.button)
/*     */           {
/*     */ 
/*     */ 
/*     */           case 1: 
/*     */           case 3: 
/* 122 */             ThreadUtils.runOnUiThread(this.cardboardTriggerCallback);
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public void onControllerRecentered(ControllerOrientationEvent paramControllerOrientationEvent) {}
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\ndk\base\CardboardEmulator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */