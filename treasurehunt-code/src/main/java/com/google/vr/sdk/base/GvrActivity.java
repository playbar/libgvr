//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.sdk.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.vr.cardboard.AndroidNCompat;
import com.google.vr.cardboard.FullscreenMode;
import com.google.vr.sdk.base.GvrView;
import com.google.vr.sdk.base.GvrViewerParams;
import com.google.vrtoolkit.cardboard.ScreenOnFlagHelper;

public class GvrActivity extends Activity {
    private FullscreenMode fullscreenMode;
    private final ScreenOnFlagHelper screenOnFlagHelper = new ScreenOnFlagHelper(this);
    private GvrView cardboardView;
    private boolean androidVrModeEnabled;

    public GvrActivity() {
    }

    public void setGvrView(GvrView gvrView) {
        this.setGvrView(gvrView, true);
    }

    public void setGvrView(GvrView gvrView, boolean enableVrModeFallbacks) {
        if(this.cardboardView != gvrView) {
            if(this.cardboardView != null) {
                this.cardboardView.setOnCardboardTriggerListener((Runnable)null);
            }

            this.cardboardView = gvrView;
            boolean enableAndroidVrMode = gvrView != null;
            this.androidVrModeEnabled = AndroidNCompat.setVrModeEnabled(this, enableAndroidVrMode, enableVrModeFallbacks?1:0) && enableAndroidVrMode;
            if(gvrView != null) {
                gvrView.setOnCardboardTriggerListener(new Runnable() {
                    public void run() {
                        GvrActivity.this.onCardboardTrigger();
                    }
                });
            }
        }
    }

    public GvrView getGvrView() {
        return this.cardboardView;
    }

    public void onCardboardTrigger() {
    }

    protected void updateGvrViewerParams(GvrViewerParams newParams) {
        if(this.cardboardView != null) {
            this.cardboardView.updateGvrViewerParams(newParams);
        }

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(1);
        this.fullscreenMode = new FullscreenMode(this.getWindow());
    }

    protected void onResume() {
        super.onResume();
        if(this.cardboardView != null) {
            this.cardboardView.onResume();
        }

        this.fullscreenMode.goFullscreen();
        this.screenOnFlagHelper.start();
    }

    protected void onPause() {
        super.onPause();
        if(this.cardboardView != null) {
            this.cardboardView.onPause();
        }

        this.screenOnFlagHelper.stop();
    }

    protected void onDestroy() {
        if(this.cardboardView != null) {
            this.cardboardView.setOnCardboardTriggerListener((Runnable)null);
            this.cardboardView.shutdown();
            this.cardboardView = null;
        }

        super.onDestroy();
    }

    public void setContentView(View view) {
        if(view instanceof GvrView) {
            this.setGvrView((GvrView)view);
        }

        super.setContentView(view);
    }

    public void setContentView(View view, LayoutParams params) {
        if(view instanceof GvrView) {
            this.setGvrView((GvrView)view);
        }

        super.setContentView(view, params);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return this.shouldSuppressKey(keyCode) || super.onKeyDown(keyCode, event);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return this.shouldSuppressKey(keyCode) || super.onKeyUp(keyCode, event);
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        this.fullscreenMode.onWindowFocusChanged(hasFocus);
    }

    public void setScreenAlwaysOn(boolean enabled) {
        this.screenOnFlagHelper.setScreenAlwaysOn(enabled);
    }

    private boolean shouldSuppressKey(int keyCode) {
        return !this.androidVrModeEnabled?false:keyCode == 24 || keyCode == 25;
    }
}
