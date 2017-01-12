/*     */ package com.google.vr.sdk.base;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.AttributeSet;
/*     */ import android.view.MotionEvent;
/*     */ import android.widget.FrameLayout;
/*     */ import com.google.vr.cardboard.ContextUtils;
/*     */ import com.google.vr.cardboard.UsedByNative;
/*     */ import com.google.vr.ndk.base.GvrSurfaceView;
/*     */ import javax.microedition.khronos.egl.EGLConfig;
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
/*     */ public class GvrView
/*     */   extends FrameLayout
/*     */ {
/*     */   private CardboardViewApi cardboardViewApi;
/*     */   
/*     */   public GvrView(Context context)
/*     */   {
/* 242 */     super(context);
/* 243 */     init(context);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public GvrView(Context context, AttributeSet attrs)
/*     */   {
/* 255 */     super(context, attrs);
/* 256 */     init(context);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRenderer(Renderer renderer)
/*     */   {
/* 268 */     if (renderer == null) {
/* 269 */       throw new IllegalArgumentException("Renderer must not be null");
/*     */     }
/* 271 */     this.cardboardViewApi.setRenderer(renderer);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRenderer(StereoRenderer renderer)
/*     */   {
/* 283 */     if (renderer == null) {
/* 284 */       throw new IllegalArgumentException("StereoRenderer must not be null");
/*     */     }
/* 286 */     this.cardboardViewApi.setRenderer(renderer);
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
/*     */   public void getCurrentEyeParams(HeadTransform head, Eye leftEye, Eye rightEye, Eye monocular, Eye leftEyeNoDistortionCorrection, Eye rightEyeNoDistortionCorrection)
/*     */   {
/* 317 */     this.cardboardViewApi.getCurrentEyeParams(head, leftEye, rightEye, monocular, leftEyeNoDistortionCorrection, rightEyeNoDistortionCorrection);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setStereoModeEnabled(boolean enabled)
/*     */   {
/* 340 */     this.cardboardViewApi.setStereoModeEnabled(enabled);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean getStereoModeEnabled()
/*     */   {
/* 350 */     return this.cardboardViewApi.getStereoModeEnabled();
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
/*     */   public boolean setAsyncReprojectionEnabled(boolean enabled)
/*     */   {
/* 367 */     return this.cardboardViewApi.setAsyncReprojectionEnabled(enabled);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean getAsyncReprojectionEnabled()
/*     */   {
/* 377 */     return this.cardboardViewApi.getAsyncReprojectionEnabled();
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
/*     */   public void setOnCloseButtonListener(Runnable listener)
/*     */   {
/* 394 */     this.cardboardViewApi.setOnCloseButtonListener(listener);
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
/*     */   public void setTransitionViewEnabled(boolean enabled)
/*     */   {
/* 407 */     this.cardboardViewApi.setTransitionViewEnabled(enabled);
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
/*     */   public void setOnTransitionViewDoneListener(Runnable listener)
/*     */   {
/* 424 */     this.cardboardViewApi.setOnTransitionViewDoneListener(listener);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public HeadMountedDisplay getHeadMountedDisplay()
/*     */   {
/* 436 */     return this.cardboardViewApi.getHeadMountedDisplay();
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
/*     */   public void setNeckModelEnabled(boolean enabled)
/*     */   {
/* 450 */     this.cardboardViewApi.setNeckModelEnabled(enabled);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getNeckModelFactor()
/*     */   {
/* 462 */     return this.cardboardViewApi.getNeckModelFactor();
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
/*     */   public void setNeckModelFactor(float factor)
/*     */   {
/* 476 */     this.cardboardViewApi.setNeckModelFactor(factor);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public void resetHeadTracker()
/*     */   {
/* 501 */     this.cardboardViewApi.resetHeadTracker();
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
/*     */   public void recenterHeadTracker()
/*     */   {
/* 518 */     this.cardboardViewApi.recenterHeadTracker();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void updateGvrViewerParams(GvrViewerParams gvrViewerParams)
/*     */   {
/* 530 */     this.cardboardViewApi.updateGvrViewerParams(gvrViewerParams);
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
/*     */   public GvrViewerParams getGvrViewerParams()
/*     */   {
/* 548 */     return this.cardboardViewApi.getGvrViewerParams();
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
/*     */   public void updateScreenParams(ScreenParams screenParams)
/*     */   {
/* 561 */     this.cardboardViewApi.updateScreenParams(screenParams);
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
/*     */   public ScreenParams getScreenParams()
/*     */   {
/* 576 */     return this.cardboardViewApi.getScreenParams();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getInterpupillaryDistance()
/*     */   {
/* 586 */     return this.cardboardViewApi.getInterpupillaryDistance();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDistortionCorrectionEnabled(boolean enabled)
/*     */   {
/* 597 */     this.cardboardViewApi.setDistortionCorrectionEnabled(enabled);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean getDistortionCorrectionEnabled()
/*     */   {
/* 606 */     return this.cardboardViewApi.getDistortionCorrectionEnabled();
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
/*     */   @Deprecated
/*     */   public void undistortTexture(int inputTexture)
/*     */   {
/* 626 */     this.cardboardViewApi.undistortTexture(inputTexture);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDistortionCorrectionScale(float scale)
/*     */   {
/* 648 */     this.cardboardViewApi.setDistortionCorrectionScale(scale);
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
/*     */   public void setMultisampling(int numSamples)
/*     */   {
/* 666 */     this.cardboardViewApi.setMultisampling(numSamples);
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
/*     */   public void setDepthStencilFormat(int format)
/*     */   {
/* 681 */     this.cardboardViewApi.setDepthStencilFormat(format);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onResume()
/*     */   {
/* 688 */     this.cardboardViewApi.onResume();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onPause()
/*     */   {
/* 695 */     this.cardboardViewApi.onPause();
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
/*     */   public void shutdown()
/*     */   {
/* 709 */     this.cardboardViewApi.shutdown();
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onTouchEvent(MotionEvent e)
/*     */   {
/* 715 */     if (this.cardboardViewApi.onTouchEvent(e)) {
/* 716 */       return true;
/*     */     }
/* 718 */     return super.onTouchEvent(e);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOnCardboardBackListener(Runnable listener)
/*     */   {
/* 728 */     this.cardboardViewApi.setOnCardboardBackListener(listener);
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
/*     */   public void setOnCardboardTriggerListener(Runnable listener)
/*     */   {
/* 742 */     this.cardboardViewApi.setOnCardboardTriggerListener(listener);
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
/*     */   public void enableCardboardTriggerEmulation()
/*     */   {
/* 772 */     this.cardboardViewApi.enableCardboardTriggerEmulation();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void queueEvent(Runnable r)
/*     */   {
/* 782 */     this.cardboardViewApi.getGvrSurfaceView().queueEvent(r);
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
/*     */   public void setEGLConfigChooser(int redSize, int greenSize, int blueSize, int alphaSize, int depthSize, int stencilSize)
/*     */   {
/* 800 */     this.cardboardViewApi.getGvrSurfaceView().setEGLConfigChooser(redSize, greenSize, blueSize, alphaSize, depthSize, stencilSize);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEGLContextClientVersion(int version)
/*     */   {
/* 812 */     this.cardboardViewApi.getGvrSurfaceView().setEGLContextClientVersion(version);
/*     */   }
/*     */   
/*     */   private void init(Context context) {
/* 816 */     if (isInEditMode())
/*     */     {
/*     */ 
/* 819 */       return;
/*     */     }
/*     */     
/* 822 */     if (!ContextUtils.canGetActivity(context)) {
/* 823 */       throw new IllegalArgumentException("An Activity Context is required for VR functionality.");
/*     */     }
/*     */     
/* 826 */     this.cardboardViewApi = ImplementationSelector.createCardboardViewApi(context);
/* 827 */     addView(this.cardboardViewApi.getRootView(), 0);
/*     */     
/*     */ 
/*     */ 
/* 831 */     GvrSurfaceView gvrSurfaceView = this.cardboardViewApi.getGvrSurfaceView();
/* 832 */     gvrSurfaceView.setEGLContextClientVersion(2);
/* 833 */     gvrSurfaceView.setPreserveEGLContextOnPause(true);
/*     */   }
/*     */   
/*     */   public static abstract interface StereoRenderer
/*     */   {
/*     */     @UsedByNative
/*     */     public abstract void onNewFrame(HeadTransform paramHeadTransform);
/*     */     
/*     */     @UsedByNative
/*     */     public abstract void onDrawEye(Eye paramEye);
/*     */     
/*     */     @UsedByNative
/*     */     public abstract void onFinishFrame(Viewport paramViewport);
/*     */     
/*     */     public abstract void onSurfaceChanged(int paramInt1, int paramInt2);
/*     */     
/*     */     public abstract void onSurfaceCreated(EGLConfig paramEGLConfig);
/*     */     
/*     */     public abstract void onRendererShutdown();
/*     */   }
/*     */   
/*     */   public static abstract interface Renderer
/*     */   {
/*     */     @UsedByNative
/*     */     public abstract void onDrawFrame(HeadTransform paramHeadTransform, Eye paramEye1, Eye paramEye2);
/*     */     
/*     */     @UsedByNative
/*     */     public abstract void onFinishFrame(Viewport paramViewport);
/*     */     
/*     */     public abstract void onSurfaceChanged(int paramInt1, int paramInt2);
/*     */     
/*     */     public abstract void onSurfaceCreated(EGLConfig paramEGLConfig);
/*     */     
/*     */     public abstract void onRendererShutdown();
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\GvrView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */