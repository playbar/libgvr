/*      */ package com.google.vr.ndk.base;
/*      */ 
/*      */ import android.app.Activity;
/*      */ import android.app.PendingIntent;
/*      */ import android.app.Presentation;
/*      */ import android.content.ComponentName;
/*      */ import android.content.Context;
/*      */ import android.content.res.Configuration;
/*      */ import android.hardware.display.DisplayManager;
/*      */ import android.hardware.display.DisplayManager.DisplayListener;
/*      */ import android.os.Build.VERSION;
/*      */ import android.os.Handler;
/*      */ import android.os.Looper;
/*      */ import android.util.AttributeSet;
/*      */ import android.util.Log;
/*      */ import android.view.Display;
/*      */ import android.view.MotionEvent;
/*      */ import android.view.Surface;
/*      */ import android.view.View;
/*      */ import android.view.ViewGroup;
/*      */ import android.view.WindowManager.InvalidDisplayException;
/*      */ import android.widget.FrameLayout;
/*      */ import android.widget.RelativeLayout.LayoutParams;
/*      */ import com.google.vr.cardboard.ContextUtils;
/*      */ import com.google.vr.cardboard.DisplaySynchronizer;
/*      */ import com.google.vr.cardboard.DisplayUtils;
/*      */ import com.google.vr.cardboard.EglFactory;
/*      */ import com.google.vr.cardboard.MutableEglConfigChooser;
/*      */ import com.google.vr.cardboard.ScanlineRacingRenderer;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class GvrLayout
/*      */   extends FrameLayout
/*      */ {
/*      */   private static final String TAG = "GvrLayout";
/*      */   private static final boolean DEBUG = false;
/*      */   private static final int EXTERNAL_PRESENTATION_MIN_API = 16;
/*      */   private static final int SHOW_RENDERING_VIEWS_DELAY_FOR_FADE = 50;
/*   76 */   private static PresentationFactory sOptionalPresentationFactory = null;
/*      */   
/*      */ 
/*      */   private DaydreamUtilsWrapper daydreamUtils;
/*      */   
/*      */ 
/*      */   private FrameLayout presentationLayout;
/*      */   
/*      */   private GvrUiLayout uiLayout;
/*      */   
/*      */   private DisplaySynchronizer displaySynchronizer;
/*      */   
/*      */   private View presentationView;
/*      */   
/*      */   private boolean isAsyncReprojectionVideoEnabled;
/*      */   
/*      */   private boolean isAsyncReprojectionUsingProtectedBuffers;
/*      */   
/*      */   private GvrSurfaceView scanlineRacingView;
/*      */   
/*      */   private ScanlineRacingRenderer scanlineRacingRenderer;
/*      */   
/*      */   private EglFactory eglFactory;
/*      */   
/*      */   private FadeOverlayView fadeOverlayView;
/*      */   
/*      */   private PresentationHelper presentationHelper;
/*      */   
/*      */   private VrCoreSdkClient vrCoreSdkClient;
/*      */   
/*      */   private DaydreamAlignment daydreamAlignment;
/*      */   
/*      */   private CardboardEmulator cardboardEmulator;
/*      */   
/*      */   private GvrApi gvrApi;
/*      */   
/*  112 */   private boolean isResumed = false;
/*  113 */   private int videoSurfaceId = -1;
/*      */   
/*      */ 
/*  116 */   private boolean stereoModeEnabled = true;
/*      */   
/*  118 */   private final Runnable showRenderingViewsRunnable = new Runnable()
/*      */   {
/*      */     public void run()
/*      */     {
/*  122 */       GvrLayout.this.updateRenderingViewsVisibility(0);
/*      */     }
/*      */   };
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public GvrLayout(Context paramContext)
/*      */   {
/*  229 */     super(paramContext);
/*  230 */     init(null, null, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public GvrLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
/*      */   {
/*  244 */     super(paramContext, paramAttributeSet, paramInt1, paramInt2);
/*  245 */     init(null, null, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   GvrLayout(Context paramContext, GvrApi paramGvrApi, DisplaySynchronizer paramDisplaySynchronizer, FadeOverlayView paramFadeOverlayView, DaydreamUtilsWrapper paramDaydreamUtilsWrapper)
/*      */   {
/*  255 */     super(paramContext);
/*  256 */     init(paramGvrApi, paramDisplaySynchronizer, paramFadeOverlayView, paramDaydreamUtilsWrapper);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void init(GvrApi paramGvrApi, DisplaySynchronizer paramDisplaySynchronizer, FadeOverlayView paramFadeOverlayView, DaydreamUtilsWrapper paramDaydreamUtilsWrapper)
/*      */   {
/*      */     Activity localActivity;
/*      */     
/*  265 */     if ((localActivity = ContextUtils.getActivity(getContext())) == null) {
/*  266 */       throw new IllegalArgumentException("An Activity Context is required for VR functionality.");
/*      */     }
/*      */     
/*  269 */     TraceCompat.beginSection("GvrLayout.init");
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     try
/*      */     {
/*  276 */       paramDisplaySynchronizer = paramDisplaySynchronizer != null ? paramDisplaySynchronizer : GvrApi.createDefaultDisplaySynchronizer(getContext());
/*  277 */       paramGvrApi = paramGvrApi != null ? paramGvrApi : new GvrApi(getContext(), paramDisplaySynchronizer);
/*  278 */       paramDaydreamUtilsWrapper = paramDaydreamUtilsWrapper != null ? paramDaydreamUtilsWrapper : new DaydreamUtilsWrapper();
/*      */       
/*      */ 
/*  281 */       this.daydreamUtils = paramDaydreamUtilsWrapper;
/*  282 */       this.presentationLayout = new FrameLayout(getContext());
/*  283 */       this.uiLayout = new GvrUiLayout(getContext());
/*  284 */       this.gvrApi = paramGvrApi;
/*  285 */       this.displaySynchronizer = paramDisplaySynchronizer;
/*  286 */       this.presentationHelper = tryCreatePresentationHelper();
/*      */       
/*      */ 
/*      */ 
/*  290 */       addView(this.presentationLayout, 0);
/*  291 */       addView(this.uiLayout, 1);
/*  292 */       updateUiLayout();
/*      */       
/*      */       boolean bool;
/*      */       
/*  296 */       if ((bool = paramDaydreamUtilsWrapper.isDaydreamPhone(getContext()))) {
/*  297 */         this.daydreamAlignment = createDaydreamAlignment();
/*  298 */         this.uiLayout.setOnTouchListener(new DaydreamAlignment.DefaultTouchListener(this.daydreamAlignment, paramGvrApi));
/*      */       }
/*      */       
/*      */ 
/*      */       int i;
/*      */       
/*  304 */       int j = (i = paramDaydreamUtilsWrapper.getActivityDaydreamCompatibility(localActivity)) != 0 ? 1 : 0;
/*  305 */       int k = i == 2 ? 1 : 0;
/*      */       
/*      */       int m;
/*      */       
/*  309 */       if ((m = (bool) || (k != 0) ? 1 : 0) != 0) {
/*  310 */         if (j != 0)
/*      */         {
/*  312 */           this.fadeOverlayView = (paramFadeOverlayView != null ? paramFadeOverlayView : new FadeOverlayView(getContext()));
/*  313 */           addView(this.fadeOverlayView, 2);
/*      */         }
/*      */         
/*  316 */         this.vrCoreSdkClient = createVrCoreSdkClient(getContext(), paramGvrApi, paramDaydreamUtilsWrapper, this.fadeOverlayView);
/*      */       }
/*      */     } finally {
/*  319 */       TraceCompat.endSection();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public GvrUiLayout getUiLayout()
/*      */   {
/*  330 */     return this.uiLayout;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void onWindowVisibilityChanged(int paramInt)
/*      */   {
/*  338 */     super.onWindowVisibilityChanged(paramInt);
/*  339 */     updateFadeVisibility();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void onPause()
/*      */   {
/*  346 */     TraceCompat.beginSection("GvrLayout.onPause");
/*      */     try {
/*  348 */       this.gvrApi.pause();
/*  349 */       if (this.scanlineRacingView != null) {
/*  350 */         this.scanlineRacingView.queueEvent(new Runnable()
/*      */         {
/*      */           public void run()
/*      */           {
/*  354 */             GvrLayout.this.scanlineRacingRenderer.onPause();
/*      */           }
/*  356 */         });
/*  357 */         this.scanlineRacingView.onPause();
/*      */       }
/*  359 */       if (this.presentationHelper != null) {
/*  360 */         this.presentationHelper.onPause();
/*      */       }
/*  362 */       this.displaySynchronizer.onPause();
/*      */       
/*  364 */       if (this.vrCoreSdkClient != null) {
/*  365 */         this.vrCoreSdkClient.onPause();
/*      */       }
/*  367 */       if (this.cardboardEmulator != null) {
/*  368 */         this.cardboardEmulator.onPause();
/*      */       }
/*      */       
/*  371 */       this.isResumed = false;
/*  372 */       updateFadeVisibility();
/*      */     } finally {
/*  374 */       TraceCompat.endSection();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void onResume()
/*      */   {
/*  382 */     TraceCompat.beginSection("GvrLayout.onResume");
/*      */     try {
/*  384 */       this.gvrApi.resume();
/*  385 */       if (this.daydreamAlignment != null) {
/*  386 */         this.daydreamAlignment.refreshViewerProfile();
/*      */       }
/*  388 */       this.displaySynchronizer.onResume();
/*  389 */       if (this.presentationHelper != null) {
/*  390 */         this.presentationHelper.onResume();
/*      */       }
/*  392 */       if (this.scanlineRacingView != null) {
/*  393 */         this.scanlineRacingView.onResume();
/*      */       }
/*  395 */       if (this.vrCoreSdkClient != null) {
/*  396 */         this.vrCoreSdkClient.onResume();
/*      */       }
/*  398 */       if ((this.cardboardEmulator != null) && 
/*  399 */         (this.gvrApi.getViewerType() == 1)) {
/*  400 */         this.cardboardEmulator.onResume();
/*      */       }
/*      */       
/*      */ 
/*  404 */       this.isResumed = true;
/*  405 */       updateFadeVisibility();
/*  406 */       updateUiLayout();
/*      */     } finally {
/*  408 */       TraceCompat.endSection();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void shutdown()
/*      */   {
/*  422 */     TraceCompat.beginSection("GvrLayout.shutdown");
/*      */     try {
/*  424 */       this.displaySynchronizer.shutdown();
/*  425 */       if (this.daydreamAlignment != null) {
/*  426 */         this.daydreamAlignment.shutdown();
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  434 */       removeView(this.presentationLayout);
/*  435 */       removeView(this.uiLayout);
/*  436 */       if (this.scanlineRacingRenderer != null) {
/*  437 */         this.scanlineRacingRenderer.shutdown();
/*  438 */         this.scanlineRacingRenderer = null;
/*      */       }
/*  440 */       this.scanlineRacingView = null;
/*  441 */       this.presentationView = null;
/*  442 */       if (this.presentationHelper != null) {
/*  443 */         this.presentationHelper.shutdown();
/*  444 */         this.presentationHelper = null;
/*      */       }
/*  446 */       if (this.vrCoreSdkClient != null) {
/*  447 */         this.vrCoreSdkClient.onPause();
/*  448 */         this.vrCoreSdkClient = null;
/*      */       }
/*  450 */       if (this.cardboardEmulator != null) {
/*  451 */         this.cardboardEmulator.onPause();
/*  452 */         this.cardboardEmulator = null;
/*      */       }
/*  454 */       if (this.gvrApi != null) {
/*  455 */         this.gvrApi.shutdown();
/*  456 */         this.gvrApi = null;
/*      */       }
/*      */     } finally {
/*  459 */       TraceCompat.endSection();
/*      */     }
/*      */   }
/*      */   
/*      */   protected void onDetachedFromWindow()
/*      */   {
/*  465 */     super.onDetachedFromWindow();
/*  466 */     if (this.presentationHelper != null) {
/*  467 */       this.presentationHelper.onDetachedFromWindow();
/*      */     }
/*      */   }
/*      */   
/*      */   protected void onConfigurationChanged(Configuration paramConfiguration)
/*      */   {
/*  473 */     super.onConfigurationChanged(paramConfiguration);
/*  474 */     this.displaySynchronizer.onConfigurationChanged();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setPresentationView(View paramView)
/*      */   {
/*  492 */     if (this.presentationView != null) {
/*  493 */       this.presentationLayout.removeView(this.presentationView);
/*      */     }
/*  495 */     this.presentationLayout.addView(paramView, 0);
/*  496 */     this.presentationView = paramView;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setFixedPresentationSurfaceSize(int paramInt1, int paramInt2)
/*      */   {
/*  532 */     this.gvrApi.setSurfaceSize(paramInt1, paramInt2);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean enableAsyncReprojectionVideoSurface(ExternalSurfaceListener paramExternalSurfaceListener, Handler paramHandler, boolean paramBoolean)
/*      */   {
/*  552 */     if (!this.daydreamUtils.isDaydreamPhone(getContext()))
/*      */     {
/*  554 */       Log.e("GvrLayout", "Only Daydream devices support async reprojection. Cannot enable video Surface.");
/*  555 */       return false;
/*      */     }
/*      */     
/*  558 */     if (this.scanlineRacingView != null) {
/*  559 */       Log.e("GvrLayout", "Async reprojection is already enabled. Cannot call enableAsyncReprojectionVideoSurface after calling setAsyncReprojectionEnabled.");
/*      */       
/*      */ 
/*      */ 
/*  563 */       return false;
/*      */     }
/*      */     
/*  566 */     if (this.gvrApi.usingVrDisplayService()) {
/*  567 */       Log.e("GvrLayout", "Async reprojection video is not supported on this device.");
/*  568 */       return false;
/*      */     }
/*      */     
/*  571 */     this.isAsyncReprojectionVideoEnabled = true;
/*  572 */     this.isAsyncReprojectionUsingProtectedBuffers = paramBoolean;
/*      */     
/*      */ 
/*  575 */     this.scanlineRacingRenderer = new ScanlineRacingRenderer(this.gvrApi);
/*  576 */     ExternalSurfaceManager localExternalSurfaceManager = this.scanlineRacingRenderer.getExternalSurfaceManager();
/*  577 */     this.videoSurfaceId = localExternalSurfaceManager.createExternalSurface(paramExternalSurfaceListener, paramHandler);
/*  578 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean setAsyncReprojectionEnabled(boolean paramBoolean)
/*      */   {
/*  593 */     if (Looper.getMainLooper() != Looper.myLooper()) {
/*  594 */       throw new IllegalStateException("setAsyncReprojectionEnabled may only be called from the UI thread");
/*      */     }
/*      */     
/*      */ 
/*  598 */     if ((this.scanlineRacingView != null) && (!paramBoolean)) {
/*  599 */       throw new UnsupportedOperationException("Async reprojection cannot be disabled once enabled");
/*      */     }
/*      */     
/*  602 */     if ((paramBoolean) && (!this.daydreamUtils.isDaydreamPhone(getContext()))) {
/*  603 */       return false;
/*      */     }
/*      */     
/*  606 */     boolean bool = this.gvrApi.setAsyncReprojectionEnabled(paramBoolean);
/*      */     
/*  608 */     if (paramBoolean) {
/*  609 */       if (bool) {
/*  610 */         if (!this.gvrApi.usingVrDisplayService()) {
/*  611 */           addScanlineRacingView();
/*      */         }
/*      */       } else {
/*  614 */         Log.e("GvrLayout", "Failed to initialize async reprojection, unsupported device.");
/*  615 */         this.isAsyncReprojectionVideoEnabled = false;
/*  616 */         this.scanlineRacingRenderer = null;
/*      */       }
/*      */     }
/*  619 */     return bool;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean enableCardboardTriggerEmulation(Runnable paramRunnable)
/*      */   {
/*  654 */     if (paramRunnable == null) {
/*  655 */       throw new IllegalArgumentException("The Cardboard trigger listener must not be null.");
/*      */     }
/*      */     
/*  658 */     if (this.cardboardEmulator != null)
/*      */     {
/*      */ 
/*      */ 
/*  662 */       return true;
/*      */     }
/*      */     
/*  665 */     if (!this.daydreamUtils.isDaydreamPhone(getContext()))
/*      */     {
/*      */ 
/*      */ 
/*  669 */       return false;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  675 */     this.cardboardEmulator = new CardboardEmulator(getContext(), paramRunnable);
/*  676 */     return true;
/*      */   }
/*      */   
/*      */   private void addScanlineRacingView() {
/*  680 */     if (this.scanlineRacingView != null) {
/*  681 */       return;
/*      */     }
/*      */     
/*  684 */     this.eglFactory = new EglFactory();
/*  685 */     this.eglFactory.setUsePriorityContext(true);
/*  686 */     this.eglFactory.setUseProtectedBuffers(this.isAsyncReprojectionUsingProtectedBuffers);
/*  687 */     this.eglFactory.setEGLContextClientVersion(2);
/*      */     
/*  689 */     this.scanlineRacingView = new GvrSurfaceView(getContext());
/*  690 */     this.scanlineRacingView.setEGLContextClientVersion(2);
/*  691 */     this.scanlineRacingView.setEGLConfigChooser(new MutableEglConfigChooser());
/*  692 */     this.scanlineRacingView.setZOrderMediaOverlay(true);
/*  693 */     this.scanlineRacingView.setEGLContextFactory(this.eglFactory);
/*  694 */     this.scanlineRacingView.setEGLWindowSurfaceFactory(this.eglFactory);
/*      */     
/*  696 */     if (!this.stereoModeEnabled)
/*      */     {
/*      */ 
/*  699 */       Log.w("GvrLayout", "Disabling stereo mode with async reprojection enabled may not work properly.");
/*  700 */       this.scanlineRacingView.setVisibility(8);
/*      */     }
/*      */     
/*  703 */     if (this.scanlineRacingRenderer == null) {
/*  704 */       this.scanlineRacingRenderer = new ScanlineRacingRenderer(this.gvrApi);
/*      */     }
/*      */     
/*  707 */     this.scanlineRacingRenderer.setSurfaceView(this.scanlineRacingView);
/*  708 */     this.scanlineRacingView.setRenderer(this.scanlineRacingRenderer);
/*  709 */     this.scanlineRacingView.setSwapMode(1);
/*      */     
/*      */ 
/*      */ 
/*  713 */     this.presentationLayout.addView(this.scanlineRacingView, 0);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getAsyncReprojectionVideoSurfaceId()
/*      */   {
/*  728 */     if (!this.isAsyncReprojectionVideoEnabled) {
/*  729 */       Log.w("GvrLayout", "Async reprojection video is not enabled. Did you call enableAsyncReprojectionVideoSurface()?");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  734 */     return this.videoSurfaceId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Surface getAsyncReprojectionVideoSurface()
/*      */   {
/*  745 */     if (!this.isAsyncReprojectionVideoEnabled) {
/*  746 */       Log.w("GvrLayout", "Async reprojection video is not enabled. Did you call enableAsyncReprojectionVideoSurface()?");
/*      */       
/*      */ 
/*      */ 
/*  750 */       return null; }
/*  751 */     if (this.scanlineRacingView == null) {
/*  752 */       Log.w("GvrLayout", "No async reprojection view has been set. Cannot get async reprojection managed Surfaces. Have you called setAsyncReprojectionEnabled()?");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  757 */     return this.scanlineRacingRenderer.getExternalSurfaceManager().getSurface(this.videoSurfaceId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public GvrApi getGvrApi()
/*      */   {
/*  778 */     return this.gvrApi;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void addPresentationListener(PresentationListener paramPresentationListener)
/*      */   {
/*  788 */     if (this.presentationHelper != null) {
/*  789 */       this.presentationHelper.addListener(paramPresentationListener);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected VrCoreSdkClient createVrCoreSdkClient(Context paramContext, GvrApi paramGvrApi, DaydreamUtilsWrapper paramDaydreamUtilsWrapper, FadeOverlayView paramFadeOverlayView)
/*      */   {
/*  809 */     ComponentName localComponentName = ContextUtils.getActivity(paramContext).getComponentName();
/*  810 */     Runnable local3 = new Runnable()
/*      */     {
/*      */       public void run()
/*      */       {
/*  814 */         GvrLayout.this.uiLayout.invokeCloseButtonListener();
/*      */       }
/*  816 */     };
/*  817 */     return new VrCoreSdkClient(paramContext, paramGvrApi, localComponentName, paramDaydreamUtilsWrapper, local3, paramFadeOverlayView);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void launchInVr(PendingIntent paramPendingIntent)
/*      */   {
/*  829 */     if ((this.vrCoreSdkClient == null) || (!this.vrCoreSdkClient.launchInVr(paramPendingIntent))) {
/*      */       try {
/*  831 */         paramPendingIntent.send(); return;
/*      */       }
/*      */       catch (Exception localException)
/*      */       {
/*  835 */         Log.e("GvrLayout", "Error launching PendingIntent.", localException);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setStereoModeEnabled(boolean paramBoolean)
/*      */   {
/*  854 */     if (this.stereoModeEnabled == paramBoolean) {
/*  855 */       return;
/*      */     }
/*      */     
/*  858 */     this.stereoModeEnabled = paramBoolean;
/*      */     
/*      */ 
/*  861 */     this.uiLayout.setEnabled(paramBoolean);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  867 */     if (this.vrCoreSdkClient != null) {
/*  868 */       this.vrCoreSdkClient.setEnabled(paramBoolean);
/*      */     }
/*  870 */     if (this.fadeOverlayView != null) {
/*  871 */       this.fadeOverlayView.setEnabled(paramBoolean);
/*      */     }
/*  873 */     if (this.daydreamAlignment != null) {
/*  874 */       this.daydreamAlignment.setEnabled(paramBoolean);
/*      */     }
/*      */     
/*      */ 
/*  878 */     updateRenderingViewsVisibility(0);
/*      */   }
/*      */   
/*      */   public boolean onTouchEvent(MotionEvent paramMotionEvent)
/*      */   {
/*  883 */     if ((this.presentationView != null) && (isPresenting()))
/*      */     {
/*      */ 
/*      */ 
/*  887 */       if (this.presentationView.dispatchTouchEvent(paramMotionEvent)) {
/*  888 */         return true;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  894 */     return super.onTouchEvent(paramMotionEvent);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isPresenting()
/*      */   {
/*  903 */     if ((this.presentationView != null) && (this.presentationHelper != null))
/*      */     {
/*  905 */       if (this.presentationHelper.isPresenting()) return true;
/*      */     }
/*  903 */     return 
/*      */     
/*  905 */       false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void setPresentationFactory(PresentationFactory paramPresentationFactory)
/*      */   {
/*  917 */     sOptionalPresentationFactory = paramPresentationFactory;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   VrCoreSdkClient getVrCoreSdkClient()
/*      */   {
/*  926 */     return this.vrCoreSdkClient;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   FadeOverlayView getFadeOverlayView()
/*      */   {
/*  935 */     return this.fadeOverlayView;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   DaydreamAlignment createDaydreamAlignment()
/*      */   {
/*  944 */     return new DaydreamAlignment(getContext(), this.gvrApi);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private PresentationHelper tryCreatePresentationHelper()
/*      */   {
/*  954 */     if (Build.VERSION.SDK_INT <= 16) {
/*  955 */       return null;
/*      */     }
/*      */     
/*      */     String str;
/*  959 */     if ((str = DisplayUtils.getExternalDisplayName(getContext())) == null) {
/*  960 */       Log.e("GvrLayout", "HDMI display name could not be found, disabling external presentation support");
/*  961 */       return null;
/*      */     }
/*      */     
/*  964 */     return new PresentationHelper(
/*  965 */       getContext(), this, this.presentationLayout, this.displaySynchronizer, str);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void updateRenderingViewsVisibility(int paramInt)
/*      */   {
/*  976 */     if (this.presentationView != null)
/*      */     {
/*  978 */       this.presentationView.setVisibility(this.stereoModeEnabled ? paramInt : 0);
/*      */     }
/*  980 */     if (this.scanlineRacingView != null)
/*      */     {
/*  982 */       this.scanlineRacingView.setVisibility(this.stereoModeEnabled ? paramInt : 8);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void updateFadeVisibility()
/*      */   {
/*  999 */     int i = getWindowVisibility() == 0 ? 1 : 0;
/* 1000 */     if (this.fadeOverlayView != null) {
/* 1001 */       if ((i != 0) && (this.isResumed)) {
/* 1002 */         this.fadeOverlayView.onVisible();
/*      */         
/*      */ 
/*      */ 
/* 1006 */         removeCallbacks(this.showRenderingViewsRunnable);
/* 1007 */         postDelayed(this.showRenderingViewsRunnable, 50L);return; }
/* 1008 */       if ((i == 0) && (!this.isResumed)) {
/* 1009 */         this.fadeOverlayView.onInvisible();
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1016 */         updateRenderingViewsVisibility(4);
/*      */         
/* 1018 */         removeCallbacks(this.showRenderingViewsRunnable);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void updateUiLayout()
/*      */   {
/* 1025 */     boolean bool = this.gvrApi.getViewerType() == 1;
/* 1026 */     this.uiLayout.setDaydreamModeEnabled(bool);
/*      */   }
/*      */   
/*      */ 
/*      */   private static class PresentationHelper
/*      */     implements DisplayManager.DisplayListener
/*      */   {
/* 1033 */     private final RelativeLayout.LayoutParams layout = new RelativeLayout.LayoutParams(-1, -1);
/*      */     
/*      */     private final Context context;
/*      */     
/*      */     private final DisplayManager displayManager;
/*      */     
/*      */     private final DisplaySynchronizer displaySynchronizer;
/*      */     
/*      */     private final FrameLayout originalParent;
/*      */     
/*      */     private final View view;
/*      */     
/*      */     private final List<GvrLayout.PresentationListener> listeners;
/*      */     
/*      */     private String externalDisplayName;
/*      */     
/*      */     private Presentation presentation;
/*      */     
/*      */     PresentationHelper(Context paramContext, FrameLayout paramFrameLayout, View paramView, DisplaySynchronizer paramDisplaySynchronizer, String paramString)
/*      */     {
/* 1053 */       this.context = paramContext;
/* 1054 */       this.originalParent = paramFrameLayout;
/* 1055 */       this.view = paramView;
/* 1056 */       this.displaySynchronizer = paramDisplaySynchronizer;
/* 1057 */       this.externalDisplayName = paramString;
/* 1058 */       this.displayManager = ((DisplayManager)paramContext.getSystemService("display"));
/* 1059 */       this.listeners = new ArrayList();
/*      */     }
/*      */     
/*      */     public boolean isPresenting() {
/* 1063 */       return (this.presentation != null) && (this.presentation.isShowing());
/*      */     }
/*      */     
/*      */     public void onPause() {
/* 1067 */       this.displayManager.unregisterDisplayListener(this);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     public void onResume()
/*      */     {
/* 1075 */       this.externalDisplayName = DisplayUtils.getExternalDisplayName(this.context);
/* 1076 */       if (this.externalDisplayName == null) {
/* 1077 */         setDisplay(null);
/* 1078 */         return;
/*      */       }
/*      */       
/* 1081 */       this.displayManager.registerDisplayListener(this, null);
/*      */       
/*      */ 
/*      */ 
/* 1085 */       Object localObject = null;
/* 1086 */       Display[] arrayOfDisplay; int i = (arrayOfDisplay = this.displayManager.getDisplays()).length; for (int j = 0; j < i; j++) { Display localDisplay = arrayOfDisplay[j];
/* 1087 */         if (isValidExternalDisplay(localDisplay)) {
/* 1088 */           localObject = localDisplay;
/* 1089 */           break;
/*      */         }
/*      */       }
/* 1092 */       setDisplay((Display)localObject);
/*      */     }
/*      */     
/*      */     public void shutdown() {
/* 1096 */       this.displayManager.unregisterDisplayListener(this);
/*      */       
/*      */       Iterator localIterator;
/*      */       
/* 1100 */       if (this.presentation != null) {
/* 1101 */         this.presentation.cancel();
/* 1102 */         this.presentation = null;
/*      */         
/* 1104 */         for (localIterator = this.listeners.iterator(); localIterator.hasNext();) { GvrLayout.PresentationListener localPresentationListener;
/* 1105 */           (localPresentationListener = (GvrLayout.PresentationListener)localIterator.next()).onPresentationStopped();
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */     public void onDetachedFromWindow() {
/* 1111 */       this.displayManager.unregisterDisplayListener(this);
/*      */       
/* 1113 */       setDisplay(null);
/*      */     }
/*      */     
/*      */     public void addListener(GvrLayout.PresentationListener paramPresentationListener) {
/* 1117 */       if (this.listeners.contains(paramPresentationListener)) {
/* 1118 */         return;
/*      */       }
/* 1120 */       this.listeners.add(paramPresentationListener);
/* 1121 */       if (this.presentation != null) {
/* 1122 */         paramPresentationListener.onPresentationStarted(this.presentation.getDisplay());
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     public void onDisplayAdded(int paramInt)
/*      */     {
/* 1131 */       Display localDisplay = this.displayManager.getDisplay(paramInt);
/* 1132 */       if (isValidExternalDisplay(localDisplay)) {
/* 1133 */         setDisplay(localDisplay);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     public void onDisplayRemoved(int paramInt)
/*      */     {
/* 1142 */       if ((this.presentation != null) && (this.presentation.getDisplay().getDisplayId() == paramInt)) {
/* 1143 */         setDisplay(null);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public void onDisplayChanged(int paramInt) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     private void setDisplay(Display paramDisplay)
/*      */     {
/* 1167 */       Display localDisplay = this.presentation != null ? this.presentation.getDisplay() : null;
/* 1168 */       if ((!hasCurrentPresentationExpired()) && 
/* 1169 */         (DisplayUtils.isSameDisplay(paramDisplay, localDisplay)))
/*      */       {
/*      */ 
/*      */ 
/* 1173 */         return;
/*      */       }
/*      */       
/* 1176 */       Presentation localPresentation = this.presentation;
/* 1177 */       if (this.presentation != null) {
/* 1178 */         this.presentation.dismiss();
/* 1179 */         this.presentation = null;
/*      */       }
/*      */       
/* 1182 */       detachViewFromParent(this.view);
/*      */       Object localObject;
/* 1184 */       if (paramDisplay != null)
/*      */       {
/*      */ 
/*      */ 
/* 1188 */         this.presentation = (GvrLayout.sOptionalPresentationFactory != null ? GvrLayout.sOptionalPresentationFactory.create(this.context, paramDisplay) : new Presentation(this.context, paramDisplay));
/* 1189 */         this.presentation.addContentView(this.view, this.layout);
/*      */         try {
/* 1191 */           this.presentation.show();
/*      */         } catch (WindowManager.InvalidDisplayException localInvalidDisplayException) {
/* 1193 */           localObject = String.valueOf(localInvalidDisplayException);Log.e("GvrLayout", 57 + String.valueOf(localObject).length() + "Attaching Cardboard View to the external display failed: " + (String)localObject);
/* 1194 */           this.presentation.cancel();
/* 1195 */           this.presentation = null;
/* 1196 */           detachViewFromParent(this.view);
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1201 */         this.originalParent.addView(this.view, 0);
/*      */       }
/*      */       
/* 1204 */       this.displaySynchronizer.setDisplay(this.presentation != null ? 
/*      */       
/* 1206 */         this.presentation.getDisplay() : 
/* 1207 */         DisplayUtils.getDefaultDisplay(this.context));
/*      */       
/*      */       Iterator localIterator;
/* 1210 */       if (localPresentation != null) {
/* 1211 */         for (localIterator = this.listeners.iterator(); localIterator.hasNext();) {
/* 1212 */           (localObject = (GvrLayout.PresentationListener)localIterator.next()).onPresentationStopped();
/*      */         }
/*      */       }
/* 1215 */       if (this.presentation != null) {
/* 1216 */         for (localIterator = this.listeners.iterator(); localIterator.hasNext();) {
/* 1217 */           (localObject = (GvrLayout.PresentationListener)localIterator.next()).onPresentationStarted(this.presentation.getDisplay());
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */     private static void detachViewFromParent(View paramView) {
/*      */       ViewGroup localViewGroup;
/* 1224 */       if ((localViewGroup = (ViewGroup)paramView.getParent()) != null) {
/* 1225 */         localViewGroup.removeView(paramView);
/*      */       }
/*      */     }
/*      */     
/*      */     private boolean isValidExternalDisplay(Display paramDisplay) {
/* 1230 */       return (paramDisplay.isValid()) && (paramDisplay.getName().equals(this.externalDisplayName));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     private boolean hasCurrentPresentationExpired()
/*      */     {
/* 1242 */       if (this.presentation == null) {
/* 1243 */         return false;
/*      */       }
/* 1245 */       return (!this.presentation.isShowing()) || (!this.presentation.getDisplay().isValid());
/*      */     }
/*      */   }
/*      */   
/*      */   static abstract interface PresentationFactory
/*      */   {
/*      */     public abstract Presentation create(Context paramContext, Display paramDisplay);
/*      */   }
/*      */   
/*      */   public static abstract interface PresentationListener
/*      */   {
/*      */     public abstract void onPresentationStarted(Display paramDisplay);
/*      */     
/*      */     public abstract void onPresentationStopped();
/*      */   }
/*      */   
/*      */   public static abstract interface ExternalSurfaceManager
/*      */   {
/*      */     public abstract int createExternalSurface();
/*      */     
/*      */     public abstract int createExternalSurface(GvrLayout.ExternalSurfaceListener paramExternalSurfaceListener, Handler paramHandler);
/*      */     
/*      */     public abstract void releaseExternalSurface(int paramInt);
/*      */     
/*      */     public abstract Surface getSurface(int paramInt);
/*      */     
/*      */     public abstract int getSurfaceCount();
/*      */   }
/*      */   
/*      */   public static abstract interface ExternalSurfaceListener
/*      */   {
/*      */     public abstract void onSurfaceAvailable(Surface paramSurface);
/*      */     
/*      */     public abstract void onFrameAvailable();
/*      */   }
/*      */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\ndk\base\GvrLayout.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */