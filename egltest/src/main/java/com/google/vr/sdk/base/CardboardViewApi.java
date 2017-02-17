//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.sdk.base;

import android.view.MotionEvent;
import android.view.View;
import com.google.vr.ndk.base.GvrSurfaceView;
import com.google.vr.sdk.base.Eye;
import com.google.vr.sdk.base.GvrViewerParams;
import com.google.vr.sdk.base.HeadMountedDisplay;
import com.google.vr.sdk.base.HeadTransform;
import com.google.vr.sdk.base.ScreenParams;
import com.google.vr.sdk.base.GvrView.Renderer;
import com.google.vr.sdk.base.GvrView.StereoRenderer;

public interface CardboardViewApi {
    void setRenderer(Renderer var1);

    void setRenderer(StereoRenderer var1);

    void getCurrentEyeParams(HeadTransform var1, Eye var2, Eye var3, Eye var4, Eye var5, Eye var6);

    void setStereoModeEnabled(boolean var1);

    boolean getStereoModeEnabled();

    boolean setAsyncReprojectionEnabled(boolean var1);

    boolean getAsyncReprojectionEnabled();

    void setOnCloseButtonListener(Runnable var1);

    HeadMountedDisplay getHeadMountedDisplay();

    void setNeckModelEnabled(boolean var1);

    float getNeckModelFactor();

    void setNeckModelFactor(float var1);

    void resetHeadTracker();

    void recenterHeadTracker();

    void updateGvrViewerParams(GvrViewerParams var1);

    GvrViewerParams getGvrViewerParams();

    void updateScreenParams(ScreenParams var1);

    ScreenParams getScreenParams();

    float getInterpupillaryDistance();

    void setDistortionCorrectionEnabled(boolean var1);

    boolean getDistortionCorrectionEnabled();

    void undistortTexture(int var1);

    void setDistortionCorrectionScale(float var1);

    void setMultisampling(int var1);

    void setDepthStencilFormat(int var1);

    void onResume();

    void onPause();

    void shutdown();

    boolean onTouchEvent(MotionEvent var1);

    void setOnCardboardBackListener(Runnable var1);

    void setOnCardboardTriggerListener(Runnable var1);

    void enableCardboardTriggerEmulation();

    void setTransitionViewEnabled(boolean var1);

    void setOnTransitionViewDoneListener(Runnable var1);

    View getRootView();

    GvrSurfaceView getGvrSurfaceView();
}
