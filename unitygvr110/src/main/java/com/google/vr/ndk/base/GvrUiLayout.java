//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.ndk.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.FrameLayout;
import com.google.vr.cardboard.ContextUtils;
import com.google.vr.cardboard.UiLayer;
import com.google.vr.cardboard.UiUtils;
import com.google.vr.ndk.base.DaydreamUtilsWrapper;

public class GvrUiLayout extends FrameLayout {
    private static final float DAYDREAM_ALIGNMENT_MARKER_SCALE = 0.35F;
    private final UiLayer uiLayer;
    private final Runnable defaultCloseButtonRunnable;
    private boolean daydreamModeEnabled;

    GvrUiLayout(Context var1) {
        this(var1, new DaydreamUtilsWrapper());
    }

    GvrUiLayout(Context var1, DaydreamUtilsWrapper var2) {
        super(var1);
        this.daydreamModeEnabled = false;
        if(!ContextUtils.canGetActivity(var1)) {
            throw new IllegalArgumentException("An Activity Context is required for VR functionality.");
        } else {
            this.defaultCloseButtonRunnable = createDefaultCloseButtonRunnable(var1, var2);
            this.uiLayer = new UiLayer(var1);
            this.uiLayer.setBackButtonListener(this.defaultCloseButtonRunnable);
            this.addView(this.uiLayer.getView());
        }
    }

    public static void launchOrInstallGvrApp(Activity var0) {
        UiUtils.launchOrInstallCardboard(var0);
    }

    public void setEnabled(boolean var1) {
        this.uiLayer.setEnabled(var1);
    }

    public void setCloseButtonListener(Runnable var1) {
        this.uiLayer.setBackButtonListener(var1 != null?var1:this.defaultCloseButtonRunnable);
    }

    public void setTransitionViewEnabled(boolean var1) {
        this.uiLayer.setTransitionViewEnabled(var1 && !this.daydreamModeEnabled);
    }

    public void setViewerName(String var1) {
        this.uiLayer.setViewerName(var1);
    }

    public UiLayer getUiLayer() {
        return this.uiLayer;
    }

    void invokeCloseButtonListener() {
        Runnable var1;
        if((var1 = this.uiLayer.getBackButtonRunnable()) != null) {
            var1.run();
        }

    }

    void setDaydreamModeEnabled(boolean var1) {
        if(this.daydreamModeEnabled != var1) {
            this.daydreamModeEnabled = var1;
            if(var1) {
                this.uiLayer.setAlignmentMarkerScale(0.35F);
                this.uiLayer.setTransitionViewEnabled(false);
            } else {
                this.uiLayer.setAlignmentMarkerScale(1.0F);
            }
        }
    }

    boolean isDaydreamModeEnabled() {
        return this.daydreamModeEnabled;
    }

    private static Runnable createDefaultCloseButtonRunnable(Context var0, DaydreamUtilsWrapper var1) {
        final Activity var2 = ContextUtils.getActivity(var0);
        return var1.isDaydreamActivity(var2)?new Runnable() {
            public final void run() {
                Intent var1;
                (var1 = new Intent("android.intent.action.MAIN")).addCategory("android.intent.category.HOME");
                var1.setFlags(268435456);
                var2.startActivity(var1);
                var2.finish();
            }
        }:new Runnable() {
            public final void run() {
                var2.onBackPressed();
            }
        };
    }
}
