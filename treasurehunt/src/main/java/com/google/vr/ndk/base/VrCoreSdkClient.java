/*     */ package com.google.vr.ndk.base;
/*     */ 
/*     */ import android.app.ActivityManager;
/*     */ import android.app.AlertDialog;
/*     */ import android.app.PendingIntent;
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.ServiceConnection;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Message;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Log;
/*     */ import com.google.vr.cardboard.ContextUtils;
/*     */ import com.google.vr.cardboard.R.string;
/*     */ import com.google.vr.cardboard.UiUtils;
/*     */ import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
/*     */ import com.google.vr.vrcore.base.api.VrCoreUtils;
/*     */ import com.google.vr.vrcore.common.api.HeadTrackingState;
/*     */ import com.google.vr.vrcore.common.api.IDaydreamListener.Stub;
/*     */ import com.google.vr.vrcore.common.api.IDaydreamManager;
/*     */ import com.google.vr.vrcore.common.api.IVrCoreSdkService;
/*     */ import com.google.vr.vrcore.common.api.IVrCoreSdkService.Stub;
/*     */ import java.lang.ref.WeakReference;
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
/*     */ class VrCoreSdkClient
/*     */ {
/*     */   private static final String TAG = "VrCoreSdkClient";
/*     */   private static final boolean DEBUG = false;
/*     */   static final int MIN_VRCORE_API_VERSION = 5;
/*     */   static final int TARGET_VRCORE_API_VERSION = 10;
/*     */   private static final int FADE_FLUSH_DELAY_FOR_TRACKING_STABILIZATION_MILLIS = 200;
/*     */   private final Context context;
/*     */   private final GvrApi gvrApi;
/*     */   private final ComponentName componentName;
/*     */   private final DaydreamUtilsWrapper daydreamUtils;
/*     */   private final Runnable closeVrRunnable;
/*     */   private final FadeOverlayView fadeOverlayView;
/*     */   private final DaydreamListenerImpl daydreamListener;
/*     */   private final boolean shouldBind;
/*     */   private boolean isBound;
/*     */   private boolean isResumed;
/*  83 */   private boolean isEnabled = true;
/*     */   
/*     */ 
/*     */ 
/*     */   private IVrCoreSdkService vrCoreSdkService;
/*     */   
/*     */ 
/*     */ 
/*     */   private IDaydreamManager daydreamManager;
/*     */   
/*     */ 
/*     */ 
/*     */   private AlertDialog helpCenterDialog;
/*     */   
/*     */ 
/*     */ 
/*     */   public VrCoreSdkClient(Context paramContext, GvrApi paramGvrApi, ComponentName paramComponentName, DaydreamUtilsWrapper paramDaydreamUtilsWrapper, Runnable paramRunnable, FadeOverlayView paramFadeOverlayView)
/*     */   {
/* 101 */     this.context = paramContext;
/* 102 */     this.gvrApi = paramGvrApi;
/* 103 */     this.componentName = paramComponentName;
/* 104 */     this.daydreamUtils = paramDaydreamUtilsWrapper;
/* 105 */     this.closeVrRunnable = paramRunnable;
/* 106 */     this.fadeOverlayView = paramFadeOverlayView;
/* 107 */     this.daydreamListener = new DaydreamListenerImpl(paramGvrApi, paramFadeOverlayView);
/* 108 */     this.shouldBind = hasCompatibleSdkService(paramContext);
/*     */     
/*     */ 
/* 111 */     paramGvrApi.setIgnoreManualTrackerPauseResume(true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   IDaydreamManager getDaydreamManager()
/*     */   {
/* 119 */     return this.daydreamManager;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   HeadTrackingState getHeadTrackingState()
/*     */   {
/* 127 */     return new HeadTrackingState();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean onResume()
/*     */   {
/* 138 */     this.isResumed = true;
/*     */     
/* 140 */     if (!this.isEnabled) {
/* 141 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 146 */     return doBind();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onPause()
/*     */   {
/* 155 */     this.isResumed = false;
/*     */     
/*     */ 
/* 158 */     this.daydreamListener.resetSafeguards();
/*     */     
/* 160 */     if (this.isEnabled)
/*     */     {
/*     */ 
/* 163 */       doUnbind();
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
/*     */   public void setEnabled(boolean paramBoolean)
/*     */   {
/* 176 */     if (this.isEnabled == paramBoolean) {
/* 177 */       return;
/*     */     }
/*     */     
/* 180 */     this.isEnabled = paramBoolean;
/*     */     
/*     */ 
/* 183 */     this.gvrApi.setIgnoreManualTrackerPauseResume(paramBoolean);
/*     */     
/* 185 */     if (this.isResumed) {
/* 186 */       if (this.isEnabled) {
/* 187 */         doBind();return;
/*     */       }
/* 189 */       doUnbind();
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
/*     */   public boolean launchInVr(PendingIntent paramPendingIntent)
/*     */   {
/* 202 */     if (this.daydreamManager != null) {
/*     */       try {
/* 204 */         this.daydreamManager.deprecatedLaunchInVr(paramPendingIntent);
/*     */       } catch (RemoteException localRemoteException) {
/* 206 */         String str = String.valueOf(localRemoteException);Log.w("VrCoreSdkClient", 28 + String.valueOf(str).length() + "Failed to launch app in VR: " + str);
/*     */       }
/* 208 */       return true;
/*     */     }
/* 210 */     return false;
/*     */   }
/*     */   
/*     */   private boolean doBind()
/*     */   {
/* 215 */     if (this.isBound) {
/* 216 */       return true;
/*     */     }
/*     */     
/* 219 */     if (this.shouldBind) {
/*     */       Intent localIntent;
/* 221 */       (localIntent = new Intent("com.google.vr.vrcore.BIND_SDK_SERVICE")).setPackage("com.google.vr.vrcore");
/* 222 */       this.isBound = this.context.bindService(localIntent, this.serviceConnection, 1);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 232 */     if (!this.isBound) {
/* 233 */       handleBindFailed();
/*     */     }
/*     */     
/* 236 */     return this.isBound;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void doUnbind()
/*     */   {
/* 243 */     if (this.isResumed) {
/* 244 */       resumeTracking(null);
/*     */     }
/*     */     else
/*     */     {
/* 248 */       this.gvrApi.pauseTrackingGetState();
/*     */     }
/*     */     
/* 251 */     if (!this.isBound)
/*     */     {
/*     */ 
/*     */ 
/* 255 */       return;
/*     */     }
/*     */     
/* 258 */     if (this.daydreamManager != null) {
/*     */       try {
/* 260 */         this.daydreamManager.unregisterListener(this.componentName);
/*     */       } catch (RemoteException localRemoteException) {
/* 262 */         String str = String.valueOf(localRemoteException);Log.w("VrCoreSdkClient", 40 + String.valueOf(str).length() + "Failed to unregister Daydream listener: " + str);
/*     */       }
/* 264 */       this.daydreamManager = null;
/*     */     }
/*     */     
/* 267 */     this.vrCoreSdkService = null;
/* 268 */     this.context.unbindService(this.serviceConnection);
/* 269 */     this.isBound = false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void handleBindFailed()
/*     */   {
/* 277 */     doUnbind();
/*     */     
/* 279 */     warnIfIncompatibleClient();
/*     */   }
/*     */   
/*     */ 
/*     */   private void handleNoDaydreamManager()
/*     */   {
/* 285 */     doUnbind();
/*     */     
/* 287 */     warnIfIncompatibleClient();
/*     */   }
/*     */   
/*     */   private void handlePrepareVrFailed() {
/* 291 */     doUnbind();
/*     */     
/*     */ 
/*     */ 
/* 295 */     this.closeVrRunnable.run();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void warnIfIncompatibleClient()
/*     */   {
/* 303 */     if ((!this.daydreamUtils.isDaydreamPhone(this.context)) && 
/* 304 */       (this.daydreamUtils.isDaydreamRequiredActivity(ContextUtils.getActivity(this.context))) && 
/* 305 */       (!ActivityManager.isRunningInTestHarness())) {
/* 306 */       if (this.helpCenterDialog != null) {
/* 307 */         this.helpCenterDialog.show();return;
/*     */       }
/*     */       
/*     */ 
/* 311 */       this.helpCenterDialog = UiUtils.showDaydreamHelpCenterDialog(this.context, R.string.dialog_title_incompatible_phone, R.string.dialog_message_incompatible_phone, this.closeVrRunnable);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void resumeTracking(HeadTrackingState paramHeadTrackingState)
/*     */   {
/* 321 */     resumeTracking(this.gvrApi, paramHeadTrackingState);
/* 322 */     if (this.fadeOverlayView != null)
/*     */     {
/*     */ 
/* 325 */       this.fadeOverlayView.flushAutoFade(200L);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void resumeTracking(GvrApi paramGvrApi, HeadTrackingState paramHeadTrackingState)
/*     */   {
/* 331 */     paramGvrApi.resumeTrackingSetState((paramHeadTrackingState != null) && 
/* 332 */       (!paramHeadTrackingState.isEmpty()) ? paramHeadTrackingState.getData() : null);
/*     */   }
/*     */   
/*     */   private static boolean hasCompatibleSdkService(Context paramContext)
/*     */   {
/*     */     try
/*     */     {
/*     */       int i;
/* 340 */       if ((i = VrCoreUtils.getVrCoreClientApiVersion(paramContext)) >= 5) {
/* 341 */         return true;
/*     */       }
/*     */       
/* 344 */       Log.w("VrCoreSdkClient", 
/*     */       
/* 346 */         String.format("VrCore service obsolete, GVR SDK requires API %d but found API %d.", new Object[] {
/*     */         
/* 348 */         Integer.valueOf(5), Integer.valueOf(i) }));
/*     */     }
/*     */     catch (VrCoreNotAvailableException localVrCoreNotAvailableException) {}
/*     */     
/*     */ 
/*     */ 
/* 354 */     return false;
/*     */   }
/*     */   
/* 357 */   private final ServiceConnection serviceConnection = new ServiceConnection()
/*     */   {
/*     */ 
/*     */ 
/*     */     public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
/*     */     {
/*     */ 
/* 364 */       IVrCoreSdkService localIVrCoreSdkService = IVrCoreSdkService.Stub.asInterface(paramAnonymousIBinder);
/*     */       Object localObject2;
/* 366 */       try { if (!localIVrCoreSdkService.initialize(10)) {
/* 367 */           Log.e("VrCoreSdkClient", "Failed to initialize VrCore SDK Service.");
/* 368 */           VrCoreSdkClient.this.handleBindFailed();
/* 369 */           return;
/*     */         }
/*     */       } catch (RemoteException localRemoteException1) {
/* 372 */         localObject2 = String.valueOf(localRemoteException1);Log.w("VrCoreSdkClient", 41 + String.valueOf(localObject2).length() + "Failed to initialize VrCore SDK Service: " + (String)localObject2);
/* 373 */         VrCoreSdkClient.this.handleBindFailed();
/* 374 */         return;
/*     */       }
/* 376 */       VrCoreSdkClient.this.vrCoreSdkService = localIVrCoreSdkService;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       try
/*     */       {
/* 384 */         VrCoreSdkClient.this.daydreamManager = VrCoreSdkClient.this.vrCoreSdkService.getDaydreamManager();
/*     */         
/* 386 */         if (VrCoreSdkClient.this.daydreamManager == null) {
/* 387 */           Log.w("VrCoreSdkClient", "Failed to obtain DaydreamManager from VrCore SDK Service.");
/* 388 */           VrCoreSdkClient.this.handleNoDaydreamManager();
/* 389 */           return;
/*     */         }
/* 391 */         VrCoreSdkClient.this.daydreamManager.registerListener(VrCoreSdkClient.this.componentName, VrCoreSdkClient.this.daydreamListener);
/*     */       } catch (RemoteException localRemoteException2) {
/* 393 */         localObject2 = String.valueOf(localRemoteException2);Log.w("VrCoreSdkClient", 57 + String.valueOf(localObject2).length() + "Failed to obtain DaydreamManager from VrCore SDK Service:" + (String)localObject2);
/* 394 */         VrCoreSdkClient.this.handleNoDaydreamManager();
/* 395 */         return;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 400 */       Object localObject1 = null;
/*     */       
/*     */       try
/*     */       {
/* 404 */         localObject2 = VrCoreSdkClient.this.getHeadTrackingState();
/*     */         
/*     */         int i;
/*     */         
/* 408 */         if ((i = VrCoreSdkClient.this.daydreamManager.prepareVr(VrCoreSdkClient.this.componentName, (HeadTrackingState)localObject2)) == 2)
/*     */         {
/* 410 */           Log.e("VrCoreSdkClient", "Daydream VR preparation failed, closing VR session.");
/* 411 */           VrCoreSdkClient.this.handlePrepareVrFailed();
/* 412 */           return;
/*     */         }
/*     */         
/*     */ 
/* 416 */         if (i == 0) {
/* 417 */           localObject1 = localObject2;
/*     */         }
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
/* 434 */         VrCoreSdkClient.this.resumeTracking((HeadTrackingState)localObject1);
/*     */       }
/*     */       catch (RemoteException localRemoteException3)
/*     */       {
/* 431 */         String str = String.valueOf(localRemoteException3);Log.w("VrCoreSdkClient", 61 + String.valueOf(str).length() + "Error while registering listener with the VrCore SDK Service:" + str);
/*     */       }
/*     */       finally {
/* 434 */         VrCoreSdkClient.this.resumeTracking(null);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
/*     */     {
/* 443 */       VrCoreSdkClient.this.vrCoreSdkService = null;
/* 444 */       VrCoreSdkClient.this.daydreamManager = null;
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */ 
/*     */   private static final class DaydreamListenerImpl
/*     */     extends IDaydreamListener.Stub
/*     */   {
/*     */     private static final long TRACKING_SAFEGUARD_DELAY_MILLIS = 3000L;
/*     */     
/*     */ 
/*     */     private static final long FADE_SAFEGUARD_DELAY_MILLIS = 3500L;
/*     */     
/*     */ 
/*     */     private static final int MSG_TRACKING_RESUME_SAFEGUARD = 1;
/*     */     
/*     */ 
/*     */     private static final int MSG_FADE_IN_SAFEGUARD = 2;
/*     */     
/*     */ 
/*     */     private final WeakReference<GvrApi> gvrApiWeak;
/*     */     
/*     */     private final WeakReference<FadeOverlayView> fadeOverlayViewWeak;
/*     */     
/* 469 */     private final Handler safeguardHandler = new Handler()
/*     */     {
/*     */       public void handleMessage(Message paramAnonymousMessage)
/*     */       {
/* 473 */         switch (paramAnonymousMessage.what) {
/*     */         case 2: 
/* 475 */           Log.w("VrCoreSdkClient", "Forcing fade in: VrCore unresponsive");
/* 476 */           VrCoreSdkClient.DaydreamListenerImpl.this.applyFadeImpl(1, 350L);
/* 477 */           return;
/*     */         
/*     */         case 1: 
/* 480 */           Log.w("VrCoreSdkClient", "Forcing tracking resume: VrCore unresponsive");
/* 481 */           VrCoreSdkClient.DaydreamListenerImpl.this.resumeHeadTrackingImpl(null);
/* 482 */           return;
/*     */         }
/*     */         
/* 485 */         super.handleMessage(paramAnonymousMessage);
/*     */       }
/*     */     };
/*     */     
/*     */ 
/*     */     DaydreamListenerImpl(GvrApi paramGvrApi, FadeOverlayView paramFadeOverlayView)
/*     */     {
/* 492 */       this.gvrApiWeak = new WeakReference(paramGvrApi);
/* 493 */       this.fadeOverlayViewWeak = new WeakReference(paramFadeOverlayView);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     final void resetSafeguards()
/*     */     {
/* 501 */       this.safeguardHandler.removeCallbacksAndMessages(null);
/*     */     }
/*     */     
/*     */     public final int getTargetApiVersion() throws RemoteException
/*     */     {
/* 506 */       return 10;
/*     */     }
/*     */     
/*     */ 
/*     */     public final HeadTrackingState requestStopTracking()
/*     */       throws RemoteException
/*     */     {
/*     */       GvrApi localGvrApi;
/*     */       
/* 515 */       if ((localGvrApi = (GvrApi)this.gvrApiWeak.get()) == null) {
/* 516 */         Log.w("VrCoreSdkClient", "Invalid requestStopTracking() call: GvrApi no longer valid");
/* 517 */         return null;
/*     */       }
/* 519 */       byte[] arrayOfByte = localGvrApi.pauseTrackingGetState();
/* 520 */       rescheduleSafeguard(1, 3000L);
/* 521 */       if (arrayOfByte != null) {
/* 522 */         return new HeadTrackingState(arrayOfByte);
/*     */       }
/* 524 */       return null;
/*     */     }
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
/*     */     public final void applyFade(int paramInt, long paramLong)
/*     */     {
/* 538 */       applyFadeImpl(paramInt, paramLong);
/*     */     }
/*     */     
/*     */ 
/*     */     public final void recenterHeadTracking()
/*     */       throws RemoteException
/*     */     {
/*     */       GvrApi localGvrApi;
/*     */       
/* 547 */       if ((localGvrApi = (GvrApi)this.gvrApiWeak.get()) == null) {
/* 548 */         Log.w("VrCoreSdkClient", "Invalid recenterHeadTracking() call: GvrApi no longer valid");
/* 549 */         return;
/*     */       }
/* 551 */       localGvrApi.recenterTracking();
/*     */     }
/*     */     
/*     */ 
/*     */     public final void dumpDebugData()
/*     */       throws RemoteException
/*     */     {
/*     */       GvrApi localGvrApi;
/*     */       
/* 560 */       if ((localGvrApi = (GvrApi)this.gvrApiWeak.get()) == null) {
/* 561 */         Log.w("VrCoreSdkClient", "Invalid dumpDebugData() call: GvrApi no longer valid");
/* 562 */         return;
/*     */       }
/* 564 */       localGvrApi.dumpDebugData();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public final void resumeHeadTracking(HeadTrackingState paramHeadTrackingState)
/*     */     {
/* 572 */       resumeHeadTrackingImpl(paramHeadTrackingState);
/*     */     }
/*     */     
/*     */     private final void resumeHeadTrackingImpl(HeadTrackingState paramHeadTrackingState) {
/*     */       GvrApi localGvrApi;
/* 577 */       if ((localGvrApi = (GvrApi)this.gvrApiWeak.get()) == null) {
/* 578 */         Log.w("VrCoreSdkClient", "Invalid resumeHeadTracking() call: GvrApi no longer valid");
/* 579 */         return;
/*     */       }
/* 581 */       cancelSafeguard(1);
/* 582 */       VrCoreSdkClient.resumeTracking(localGvrApi, paramHeadTrackingState);
/*     */     }
/*     */     
/*     */     private final void applyFadeImpl(final int paramInt, final long paramLong) {
/*     */       final FadeOverlayView localFadeOverlayView;
/* 587 */       if ((localFadeOverlayView = (FadeOverlayView)this.fadeOverlayViewWeak.get()) == null)
/*     */       {
/*     */ 
/*     */ 
/* 591 */         return;
/*     */       }
/* 593 */       cancelSafeguard(2);
/* 594 */       localFadeOverlayView.post(new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 598 */           localFadeOverlayView.startFade(paramInt, paramLong);
/*     */         }
/*     */       });
/* 601 */       if (paramInt == 2) {
/* 602 */         rescheduleSafeguard(2, paramLong + 3500L);
/*     */       }
/*     */     }
/*     */     
/*     */     private final void cancelSafeguard(int paramInt) {
/* 607 */       this.safeguardHandler.removeMessages(paramInt);
/*     */     }
/*     */     
/*     */     private final void rescheduleSafeguard(int paramInt, long paramLong) {
/* 611 */       cancelSafeguard(paramInt);
/* 612 */       this.safeguardHandler.sendEmptyMessageDelayed(paramInt, paramLong);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\ndk\base\VrCoreSdkClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */