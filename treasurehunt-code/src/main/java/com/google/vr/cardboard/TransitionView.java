//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.cardboard;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.vr.cardboard.UiUtils;
import com.google.vr.ndk.base.Frame;
import com.mj.vr.R.id;
import com.mj.vr.R.layout;
import com.mj.vr.R.string;

public class TransitionView extends FrameLayout implements OnTouchListener {
    public static final int TRANSITION_BACKGROUND_COLOR = -12232092;
    public static final int ALREADY_LANDSCAPE_LEFT_TRANSITION_DELAY_MS = 2000;
    public static final int TRANSITION_ANIMATION_DURATION_MS = 500;
    private static final int VIEW_CORRECTION_ROTATION_DEGREES = 90;
    private static final int PORTRAIT_TOLERANCE_DEGREES = 45;
    private static final int LANDSCAPE_TOLERANCE_DEGREES = 5;
    private int orientation = -1;
    private OrientationEventListener orientationEventListener;
    private boolean rotationChecked;
    private boolean useCustomTransitionLayout;
    private String viewerName;
    private AnimationDrawable animationDrawable;
    private TransitionView.TransitionListener transitionListener;
    private ImageButton backButton;
    private Runnable backButtonRunnable;

    public TransitionView(Context var1) {
        super(var1);
        this.setOnTouchListener(this);
        this.setBackground(new ColorDrawable(-12232092));
        this.inflateContentView(layout.transition_view);
        super.setVisibility(8);
    }

    private void inflateContentView(int var1) {
        this.removeAllViews();
        LayoutInflater.from(this.getContext()).inflate(var1, this, true);
        this.findViewById(id.transition_switch_action).setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
                UiUtils.launchOrInstallCardboard(TransitionView.this.getContext());
                if(TransitionView.this.transitionListener != null) {
                    TransitionView.this.transitionListener.onSwitchViewer();
                }

            }
        });
        ((ImageView)this.findViewById(id.transition_icon)).setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
                TransitionView.this.fadeOutAndRemove(false);
            }
        });
        this.updateBackButtonVisibility();
        if(!this.useCustomTransitionLayout && this.getResources().getConfiguration().orientation == 2) {
            this.findViewById(id.transition_bottom_frame).setVisibility(8);
        }

    }

    public void setCustomTransitionLayout(int var1, int var2) {
        this.useCustomTransitionLayout = true;
        this.inflateContentView(var1);
        this.setBackground(new ColorDrawable(var2));
        this.setViewerName(this.viewerName);
        Drawable var4;
        if((var4 = ((ImageView)this.findViewById(id.transition_icon)).getDrawable()) != null && var4 instanceof AnimationDrawable) {
            this.animationDrawable = (AnimationDrawable)var4;
            this.animationDrawable.start();
        }

    }

    public void setViewerName(String var1) {
        this.viewerName = var1;
        TextView var2 = (TextView)this.findViewById(id.transition_text);
        if(var1 != null) {
            var2.setText(this.getContext().getString(string.place_your_viewer_into_viewer_format, new Object[]{var1}));
        } else {
            var2.setText(this.getContext().getString(string.place_your_phone_into_cardboard));
        }
    }

    public void setBackButtonListener(Runnable var1) {
        this.backButtonRunnable = var1;
        this.updateBackButtonVisibility();
    }

    public void setVisibility(int var1) {
        int var2 = this.getVisibility();
        super.setVisibility(var1);
        if(var2 != var1) {
            if(var1 == 0) {
                this.startOrientationMonitor();
                return;
            }

            this.stopOrientationMonitor();
        }

    }

    public void setTransitionListener(TransitionView.TransitionListener var1) {
        this.transitionListener = var1;
    }

    private void startOrientationMonitor() {
        if(this.orientationEventListener == null) {
            this.orientationEventListener = new OrientationEventListener(this.getContext()) {
                public void onOrientationChanged(int var1) {
                    TransitionView.this.orientation = var1;
                    if(!TransitionView.this.rotationChecked) {
                        TransitionView.this.rotateViewIfNeeded();
                    } else if(TransitionView.isLandscapeLeft(var1)) {
                        TransitionView.this.fadeOutAndRemove(false);
                    } else {
                        TransitionView.isLandscapeRight(var1);
                    }
                }
            };
            this.orientationEventListener.enable();
        }
    }

    private void stopOrientationMonitor() {
        if(this.orientationEventListener != null) {
            this.orientation = -1;
            this.orientationEventListener.disable();
            this.orientationEventListener = null;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.orientationEventListener != null) {
            this.orientationEventListener.enable();
        }

        this.rotateViewIfNeeded();
    }

    protected void onDetachedFromWindow() {
        if(this.orientationEventListener != null) {
            this.orientation = -1;
            this.orientationEventListener.disable();
        }

        super.onDetachedFromWindow();
    }

    private void rotateViewIfNeeded() {
        if(this.getWidth() > 0 && this.getHeight() > 0 && this.orientation != -1 && this.orientationEventListener != null && !this.rotationChecked) {
            boolean var1 = this.getWidth() < this.getHeight();
            boolean var2 = isPortrait(this.orientation);
            if(var1 != var2) {
                View var3;
                int var4 = (var3 = this.findViewById(id.transition_frame)).getWidth();
                int var5 = var3.getHeight();
                if(VERSION.SDK_INT >= 17 && this.getLayoutDirection() == 1) {
                    var3.setPivotX((float)var5 - var3.getPivotX());
                    var3.setPivotY((float)var4 - var3.getPivotY());
                }

                if(var1) {
                    var3.setRotation(90.0F);
                } else {
                    var3.setRotation(-90.0F);
                }

                var3.setTranslationX((float)((var4 - var5) / 2));
                var3.setTranslationY((float)((var5 - var4) / 2));
                LayoutParams var6;
                (var6 = (FrameLayout.LayoutParams)var3.getLayoutParams()).height = var4;
                var6.width = var5;
                var3.requestLayout();
            }

            if(!var2) {
                this.findViewById(id.transition_bottom_frame).setVisibility(8);
                if(this.useCustomTransitionLayout) {
                    TextView var8;
                    if((var8 = (TextView)this.findViewById(id.transition_text)) != null) {
                        var8.setMaxWidth(2 * var8.getMaxWidth());
                    }

                    View var9;
                    if((var9 = this.findViewById(id.transition_icon)) != null) {
                        android.widget.RelativeLayout.LayoutParams var10;
                        int var11 = (var10 = (android.widget.RelativeLayout.LayoutParams)var9.getLayoutParams()).topMargin;
                        int var7 = -1 * var11;
                        var10.setMargins(var7, 0, 0, 0);
                        var9.requestLayout();
                    }
                }
            } else {
                this.findViewById(id.transition_bottom_frame).setVisibility(0);
            }

            this.rotationChecked = true;
            if(isLandscapeLeft(this.orientation)) {
                this.fadeOutAndRemove(true);
            }

        }
    }

    private void fadeOutAndRemove(boolean var1) {
        this.stopOrientationMonitor();
        Animation var2;
        if((var2 = this.getAnimation()) != null) {
            if(var1 || var2.getStartOffset() == 0L) {
                return;
            }

            var2.setAnimationListener((AnimationListener)null);
            this.clearAnimation();
        }

        AlphaAnimation var3;
        (var3 = new AlphaAnimation(1.0F, 0.0F)).setInterpolator(new AccelerateInterpolator());
        var3.setRepeatCount(0);
        var3.setDuration(500L);
        if(var1) {
            var3.setStartOffset(2000L);
        }

        var3.setAnimationListener(new AnimationListener() {
            public void onAnimationStart(Animation var1) {
            }

            public void onAnimationEnd(Animation var1) {
                TransitionView.this.setVisibility(8);
                ((ViewGroup)TransitionView.this.getParent()).removeView(TransitionView.this);
                if(TransitionView.this.animationDrawable != null) {
                    TransitionView.this.animationDrawable.stop();
                    TransitionView.this.animationDrawable = null;
                }

                if(TransitionView.this.transitionListener != null) {
                    TransitionView.this.transitionListener.onTransitionDone();
                }

            }

            public void onAnimationRepeat(Animation var1) {
            }
        });
        this.startAnimation(var3);
    }

    public boolean onTouch(View var1, MotionEvent var2) {
        return true;
    }

    private void updateBackButtonVisibility() {
        ViewGroup var1 = (ViewGroup)this.findViewById(id.transition_frame);
        this.backButton = (ImageButton)var1.findViewById(id.back_button);
        if(this.backButtonRunnable == null) {
            this.backButton.setVisibility(8);
            this.backButton.setTag((Object)null);
            this.backButton.setOnClickListener((OnClickListener)null);
        } else {
            this.backButton.setTag(this.backButtonRunnable);
            this.backButton.setVisibility(0);
            this.backButton.setOnClickListener(new OnClickListener() {
                public void onClick(View var1) {
                    TransitionView.this.backButtonRunnable.run();
                }
            });
        }
    }

    private static boolean isPortrait(int var0) {
        return Math.abs(var0 - 180) > 135;
    }

    private static boolean isLandscapeLeft(int var0) {
        return Math.abs(var0 - 270) < 5;
    }

    private static boolean isLandscapeRight(int var0) {
        return Math.abs(var0 - 90) < 5;
    }

    public interface TransitionListener {
        void onTransitionDone();

        void onSwitchViewer();
    }
}
