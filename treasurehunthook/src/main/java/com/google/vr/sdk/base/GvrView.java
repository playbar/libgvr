package com.google.vr.sdk.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.google.vr.cardboard.ContextUtils;
import com.google.vr.cardboard.UsedByNative;
import com.google.vr.ndk.base.GvrSurfaceView;
import com.google.vr.sdk.base.CardboardViewApi;
import com.google.vr.sdk.base.Eye;
import com.google.vr.sdk.base.GvrViewerParams;
import com.google.vr.sdk.base.HeadMountedDisplay;
import com.google.vr.sdk.base.HeadTransform;
import com.google.vr.sdk.base.ImplementationSelector;
import com.google.vr.sdk.base.ScreenParams;
import com.google.vr.sdk.base.Viewport;
import javax.microedition.khronos.egl.EGLConfig;

public class GvrView extends FrameLayout {
    private CardboardViewApi cardboardViewApi;

    public GvrView(Context context) {
        super(context);
        this.init(context);
    }

    public GvrView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(context);
    }

    public void setRenderer(GvrView.Renderer renderer) {
        if(renderer == null) {
            throw new IllegalArgumentException("Renderer must not be null");
        } else {
            this.cardboardViewApi.setRenderer(renderer);
        }
    }

    public void setRenderer(GvrView.StereoRenderer renderer) {
        if(renderer == null) {
            throw new IllegalArgumentException("StereoRenderer must not be null");
        } else {
            this.cardboardViewApi.setRenderer(renderer);
        }
    }

    public void getCurrentEyeParams(HeadTransform head, Eye leftEye, Eye rightEye, Eye monocular, Eye leftEyeNoDistortionCorrection, Eye rightEyeNoDistortionCorrection) {
        this.cardboardViewApi.getCurrentEyeParams(head, leftEye, rightEye, monocular, leftEyeNoDistortionCorrection, rightEyeNoDistortionCorrection);
    }

    public void setStereoModeEnabled(boolean enabled) {
        this.cardboardViewApi.setStereoModeEnabled(enabled);
    }

    public boolean getStereoModeEnabled() {
        return this.cardboardViewApi.getStereoModeEnabled();
    }

    public boolean setAsyncReprojectionEnabled(boolean enabled) {
        return this.cardboardViewApi.setAsyncReprojectionEnabled(enabled);
    }

    public boolean getAsyncReprojectionEnabled() {
        return this.cardboardViewApi.getAsyncReprojectionEnabled();
    }

    public void setOnCloseButtonListener(Runnable listener) {
        this.cardboardViewApi.setOnCloseButtonListener(listener);
    }

    public void setTransitionViewEnabled(boolean enabled) {
        this.cardboardViewApi.setTransitionViewEnabled(enabled);
    }

    public void setOnTransitionViewDoneListener(Runnable listener) {
        this.cardboardViewApi.setOnTransitionViewDoneListener(listener);
    }

    public HeadMountedDisplay getHeadMountedDisplay() {
        return this.cardboardViewApi.getHeadMountedDisplay();
    }

    public void setNeckModelEnabled(boolean enabled) {
        this.cardboardViewApi.setNeckModelEnabled(enabled);
    }

    public float getNeckModelFactor() {
        return this.cardboardViewApi.getNeckModelFactor();
    }

    public void setNeckModelFactor(float factor) {
        this.cardboardViewApi.setNeckModelFactor(factor);
    }

    /** @deprecated */
    @Deprecated
    public void resetHeadTracker() {
        this.cardboardViewApi.resetHeadTracker();
    }

    public void recenterHeadTracker() {
        this.cardboardViewApi.recenterHeadTracker();
    }

    public void updateGvrViewerParams(GvrViewerParams gvrViewerParams) {
        this.cardboardViewApi.updateGvrViewerParams(gvrViewerParams);
    }

    public GvrViewerParams getGvrViewerParams() {
        return this.cardboardViewApi.getGvrViewerParams();
    }

    public void updateScreenParams(ScreenParams screenParams) {
        this.cardboardViewApi.updateScreenParams(screenParams);
    }

    public ScreenParams getScreenParams() {
        return this.cardboardViewApi.getScreenParams();
    }

    public float getInterpupillaryDistance() {
        return this.cardboardViewApi.getInterpupillaryDistance();
    }

    public void setDistortionCorrectionEnabled(boolean enabled) {
        this.cardboardViewApi.setDistortionCorrectionEnabled(enabled);
    }

    public boolean getDistortionCorrectionEnabled() {
        return this.cardboardViewApi.getDistortionCorrectionEnabled();
    }

    /** @deprecated */
    @Deprecated
    public void undistortTexture(int inputTexture) {
        this.cardboardViewApi.undistortTexture(inputTexture);
    }

    public void setDistortionCorrectionScale(float scale) {
        this.cardboardViewApi.setDistortionCorrectionScale(scale);
    }

    public void setMultisampling(int numSamples) {
        this.cardboardViewApi.setMultisampling(numSamples);
    }

    public void setDepthStencilFormat(int format) {
        this.cardboardViewApi.setDepthStencilFormat(format);
    }

    public void onResume() {
        this.cardboardViewApi.onResume();
    }

    public void onPause() {
        this.cardboardViewApi.onPause();
    }

    public void shutdown() {
        this.cardboardViewApi.shutdown();
    }

    public boolean onTouchEvent(MotionEvent e) {
        return this.cardboardViewApi.onTouchEvent(e)?true:super.onTouchEvent(e);
    }

    public void setOnCardboardBackListener(Runnable listener) {
        this.cardboardViewApi.setOnCardboardBackListener(listener);
    }

    public void setOnCardboardTriggerListener(Runnable listener) {
        this.cardboardViewApi.setOnCardboardTriggerListener(listener);
    }

    public void enableCardboardTriggerEmulation() {
        this.cardboardViewApi.enableCardboardTriggerEmulation();
    }

    public void queueEvent(Runnable r) {
        this.cardboardViewApi.getGvrSurfaceView().queueEvent(r);
    }

    public void setEGLConfigChooser(int redSize, int greenSize, int blueSize, int alphaSize, int depthSize, int stencilSize) {
        this.cardboardViewApi.getGvrSurfaceView().setEGLConfigChooser(redSize, greenSize, blueSize, alphaSize, depthSize, stencilSize);
    }

    public void setEGLContextClientVersion(int version) {
        this.cardboardViewApi.getGvrSurfaceView().setEGLContextClientVersion(version);
    }

    private void init(Context context) {
        if(!this.isInEditMode()) {
            if(!ContextUtils.canGetActivity(context)) {
                throw new IllegalArgumentException("An Activity Context is required for VR functionality.");
            } else {
                this.cardboardViewApi = ImplementationSelector.createCardboardViewApi(context);
                this.addView(this.cardboardViewApi.getRootView(), 0);
                GvrSurfaceView gvrSurfaceView = this.cardboardViewApi.getGvrSurfaceView();
                gvrSurfaceView.setEGLContextClientVersion(2);
                gvrSurfaceView.setPreserveEGLContextOnPause(true);
            }
        }
    }

    public interface StereoRenderer {
        @UsedByNative
        void onNewFrame(HeadTransform var1);

        @UsedByNative
        void onDrawEye(Eye var1);

        @UsedByNative
        void onFinishFrame(Viewport var1);

        void onSurfaceChanged(int var1, int var2);

        void onSurfaceCreated(EGLConfig var1);

        void onRendererShutdown();
    }

    public interface Renderer {
        @UsedByNative
        void onDrawFrame(HeadTransform var1, Eye var2, Eye var3);

        @UsedByNative
        void onFinishFrame(Viewport var1);

        void onSurfaceChanged(int var1, int var2);

        void onSurfaceCreated(EGLConfig var1);

        void onRendererShutdown();
    }
}
