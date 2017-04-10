//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.cardboard;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.vr.cardboard.ThreadUtils;
import com.google.vr.cardboard.TransitionView;
import com.google.vr.cardboard.UiUtils;
import com.google.vr.cardboard.R.dimen;
import com.google.vr.cardboard.R.id;
import com.google.vr.cardboard.R.layout;
import com.google.vr.cardboard.TransitionView.TransitionListener;

public class UiLayer {
    private final Context context;
    private ImageButton settingsButton;
    private ImageButton backButton;
    private RelativeLayout alignmentMarker;
    private TransitionView transitionView;
    private RelativeLayout rootLayout;
    private volatile boolean isSettingsButtonEnabled = true;
    private volatile boolean isAlignmentMarkerEnabled = true;
    private volatile Runnable backButtonRunnable = null;
    private volatile Runnable settingsButtonRunnable;
    private volatile boolean transitionViewEnabled = false;
    private volatile String viewerName;

    public UiLayer(Context var1) {
        this.context = var1;
        this.initializeViewsWithLayoutId(layout.ui_layer);
    }

    public void setPortraitSupportEnabled(boolean var1) {
        this.initializeViewsWithLayoutId(var1?layout.ui_layer_with_portrait_support:layout.ui_layer);
    }


    private void initializeViewsWithLayoutId(int var1) {
        this.rootLayout = (RelativeLayout)LayoutInflater.from(this.context).inflate(var1, (ViewGroup)null, false);
        this.settingsButtonRunnable = new Runnable() {
            public void run() {
                UiUtils.launchOrInstallCardboard(UiLayer.this.context);
            }
        };
        this.settingsButton = (ImageButton)this.rootLayout.findViewById(id.ui_settings_button);
        this.settingsButton.setVisibility(computeVisibility(this.isSettingsButtonEnabled));
        this.settingsButton.setContentDescription("Settings");
        this.settingsButton.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
                Runnable var2;
                if((var2 = UiLayer.this.settingsButtonRunnable) != null) {
                    var2.run();
                }

            }
        });
        this.backButton = (ImageButton)this.rootLayout.findViewById(id.ui_back_button);
        this.backButton.setVisibility(computeVisibility(this.getBackButtonEnabled()));
        this.backButton.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
                Runnable var2;
                if((var2 = UiLayer.this.backButtonRunnable) != null) {
                    var2.run();
                }

            }
        });
        this.alignmentMarker = (RelativeLayout)this.rootLayout.findViewById(id.ui_alignment_marker);
        this.alignmentMarker.setVisibility(computeVisibility(this.getAlignmentMarkerEnabled()));
    }

    private TransitionView getTransitionView() {
        if(this.transitionView == null) {
            this.transitionView = new TransitionView(this.context);
            LayoutParams var1 = new LayoutParams(-1, -1);
            this.transitionView.setLayoutParams(var1);
            this.transitionView.setVisibility(computeVisibility(this.transitionViewEnabled));
            if(this.viewerName != null) {
                this.transitionView.setViewerName(this.viewerName);
            }

            this.transitionView.setBackButtonListener(this.backButtonRunnable);
            this.rootLayout.addView(this.transitionView);
        }

        return this.transitionView;
    }

    private static int computeVisibility(boolean var0) {
        return var0?View.VISIBLE:View.GONE;
    }

    public View getView() {
        return this.rootLayout;
    }

    public void setEnabled(final boolean var1) {
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                UiLayer.this.rootLayout.setVisibility(UiLayer.computeVisibility(var1));
            }
        });
    }

    public void setSettingsButtonEnabled(final boolean var1) {
        this.isSettingsButtonEnabled = var1;
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                UiLayer.this.settingsButton.setVisibility(UiLayer.computeVisibility(var1));
            }
        });
    }

    public void setSettingsButtonRunnable(Runnable var1) {
        this.settingsButtonRunnable = var1;
    }

    public void setBackButtonListener(final Runnable var1) {
        this.backButtonRunnable = var1;
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                boolean var1x = var1 != null;
                UiLayer.this.backButton.setVisibility(UiLayer.computeVisibility(var1x));
                if(UiLayer.this.transitionView != null) {
                    UiLayer.this.transitionView.setBackButtonListener(var1);
                }

            }
        });
    }

    public void setAlignmentMarkerEnabled(final boolean var1) {
        this.isAlignmentMarkerEnabled = var1;
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                UiLayer.this.alignmentMarker.setVisibility(UiLayer.computeVisibility(var1));
            }
        });
    }

    @TargetApi(23)
    public void setAlignmentMarkerScale(final float var1) {
        if(VERSION.SDK_INT >= 23) {
            ThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    LayoutParams var1x = (LayoutParams)UiLayer.this.alignmentMarker.getLayoutParams();
                    int var3 = (int)((float)((int)UiLayer.this.context.getResources().getDimension(dimen.alignment_marker_height)) * var1);
                    if(var1x.getRule(15) == -1) {
                        var1x.width = var3;
                    } else {
                        var1x.height = var3;
                    }

                    UiLayer.this.alignmentMarker.setLayoutParams(var1x);
                }
            });
        }
    }

    public void setTransitionViewEnabled(final boolean var1) {
        this.transitionViewEnabled = var1;
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                if(var1 || UiLayer.this.transitionView != null) {
                    UiLayer.this.getTransitionView().setVisibility(UiLayer.computeVisibility(var1));
                }
            }
        });
    }

    public boolean getTransitionViewEnabled() {
        return this.transitionViewEnabled;
    }

    public void setTransitionViewListener(final TransitionListener var1) {
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                if(var1 != null || UiLayer.this.transitionView != null) {
                    UiLayer.this.getTransitionView().setTransitionListener(var1);
                }
            }
        });
    }

    public void setViewerName(final String var1) {
        this.viewerName = var1;
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                if(UiLayer.this.transitionView != null) {
                    UiLayer.this.transitionView.setViewerName(var1);
                }

            }
        });
    }

    public String getViewerName() {
        return this.viewerName;
    }

    public void setCustomTransitionLayout(final int var1, final int var2) {
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                UiLayer.this.getTransitionView().setCustomTransitionLayout(var1, var2);
            }
        });
    }

    public boolean getSettingsButtonEnabled() {
        return this.isSettingsButtonEnabled;
    }

    public boolean getBackButtonEnabled() {
        return this.backButtonRunnable != null;
    }

    public Runnable getBackButtonRunnable() {
        return this.backButtonRunnable;
    }

    public boolean getAlignmentMarkerEnabled() {
        return this.isAlignmentMarkerEnabled;
    }
}
