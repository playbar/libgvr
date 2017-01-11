package com.google.vr.sdk.base;

import android.view.MotionEvent;
import android.view.View;
import com.google.vr.ndk.base.GvrSurfaceView;

public abstract interface CardboardViewApi
{
  public abstract void setRenderer(GvrView.Renderer paramRenderer);
  
  public abstract void setRenderer(GvrView.StereoRenderer paramStereoRenderer);
  
  public abstract void getCurrentEyeParams(HeadTransform paramHeadTransform, Eye paramEye1, Eye paramEye2, Eye paramEye3, Eye paramEye4, Eye paramEye5);
  
  public abstract void setStereoModeEnabled(boolean paramBoolean);
  
  public abstract boolean getStereoModeEnabled();
  
  public abstract boolean setAsyncReprojectionEnabled(boolean paramBoolean);
  
  public abstract boolean getAsyncReprojectionEnabled();
  
  public abstract void setOnCloseButtonListener(Runnable paramRunnable);
  
  public abstract HeadMountedDisplay getHeadMountedDisplay();
  
  public abstract void setNeckModelEnabled(boolean paramBoolean);
  
  public abstract float getNeckModelFactor();
  
  public abstract void setNeckModelFactor(float paramFloat);
  
  public abstract void resetHeadTracker();
  
  public abstract void recenterHeadTracker();
  
  public abstract void updateGvrViewerParams(GvrViewerParams paramGvrViewerParams);
  
  public abstract GvrViewerParams getGvrViewerParams();
  
  public abstract void updateScreenParams(ScreenParams paramScreenParams);
  
  public abstract ScreenParams getScreenParams();
  
  public abstract float getInterpupillaryDistance();
  
  public abstract void setDistortionCorrectionEnabled(boolean paramBoolean);
  
  public abstract boolean getDistortionCorrectionEnabled();
  
  public abstract void undistortTexture(int paramInt);
  
  public abstract void setDistortionCorrectionScale(float paramFloat);
  
  public abstract void setMultisampling(int paramInt);
  
  public abstract void setDepthStencilFormat(int paramInt);
  
  public abstract void onResume();
  
  public abstract void onPause();
  
  public abstract void shutdown();
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void setOnCardboardBackListener(Runnable paramRunnable);
  
  public abstract void setOnCardboardTriggerListener(Runnable paramRunnable);
  
  public abstract void enableCardboardTriggerEmulation();
  
  public abstract void setTransitionViewEnabled(boolean paramBoolean);
  
  public abstract void setOnTransitionViewDoneListener(Runnable paramRunnable);
  
  public abstract View getRootView();
  
  public abstract GvrSurfaceView getGvrSurfaceView();
}


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\CardboardViewApi.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */