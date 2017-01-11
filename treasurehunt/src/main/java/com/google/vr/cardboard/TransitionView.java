/*     */ package com.google.vr.cardboard;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.res.Configuration;
/*     */ import android.content.res.Resources;
/*     */ import android.graphics.drawable.AnimationDrawable;
/*     */ import android.graphics.drawable.ColorDrawable;
/*     */ import android.graphics.drawable.Drawable;
/*     */ import android.os.Build.VERSION;
/*     */ import android.view.LayoutInflater;
/*     */ import android.view.MotionEvent;
/*     */ import android.view.OrientationEventListener;
/*     */ import android.view.View;
/*     */ import android.view.View.OnClickListener;
/*     */ import android.view.View.OnTouchListener;
/*     */ import android.view.ViewGroup;
/*     */ import android.view.ViewGroup.LayoutParams;
/*     */ import android.view.animation.AccelerateInterpolator;
/*     */ import android.view.animation.AlphaAnimation;
/*     */ import android.view.animation.Animation;
/*     */ import android.view.animation.Animation.AnimationListener;
/*     */ import android.widget.FrameLayout;
/*     */ import android.widget.ImageButton;
/*     */ import android.widget.ImageView;
/*     */ import android.widget.RelativeLayout.LayoutParams;
/*     */ import android.widget.TextView;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TransitionView
/*     */   extends FrameLayout
/*     */   implements View.OnTouchListener
/*     */ {
/*     */   public static final int TRANSITION_BACKGROUND_COLOR = -12232092;
/*     */   public static final int ALREADY_LANDSCAPE_LEFT_TRANSITION_DELAY_MS = 2000;
/*     */   public static final int TRANSITION_ANIMATION_DURATION_MS = 500;
/*     */   private static final int VIEW_CORRECTION_ROTATION_DEGREES = 90;
/*     */   private static final int PORTRAIT_TOLERANCE_DEGREES = 45;
/*     */   private static final int LANDSCAPE_TOLERANCE_DEGREES = 5;
/*  72 */   private int orientation = -1;
/*     */   
/*     */ 
/*     */   private OrientationEventListener orientationEventListener;
/*     */   
/*     */ 
/*     */   private boolean rotationChecked;
/*     */   
/*     */ 
/*     */   private boolean useCustomTransitionLayout;
/*     */   
/*     */ 
/*     */   private String viewerName;
/*     */   
/*     */ 
/*     */   private AnimationDrawable animationDrawable;
/*     */   
/*     */   private TransitionListener transitionListener;
/*     */   
/*     */   private ImageButton backButton;
/*     */   
/*     */   private Runnable backButtonRunnable;
/*     */   
/*     */ 
/*     */   public TransitionView(Context paramContext)
/*     */   {
/*  98 */     super(paramContext);
/*  99 */     setOnTouchListener(this);
/* 100 */     setBackground(new ColorDrawable(-12232092));
/* 101 */     inflateContentView(R.layout.transition_view);
/*     */     
/*     */ 
/*     */ 
/* 105 */     super.setVisibility(8);
/*     */   }
/*     */   
/*     */   private void inflateContentView(int paramInt) {
/* 109 */     removeAllViews();
/*     */     
/* 111 */     LayoutInflater.from(getContext()).inflate(paramInt, this, true);
/*     */     View localView;
/* 113 */     (localView = findViewById(R.id.transition_switch_action)).setOnClickListener(new View.OnClickListener()
/*     */     {
/*     */       public void onClick(View paramAnonymousView)
/*     */       {
/* 117 */         UiUtils.launchOrInstallCardboard(TransitionView.this.getContext());
/* 118 */         if (TransitionView.this.transitionListener != null) {
/* 119 */           TransitionView.this.transitionListener.onSwitchViewer();
/*     */         }
/*     */       }
/*     */     });
/*     */     
/*     */     ImageView localImageView;
/*     */     
/* 126 */     (localImageView = (ImageView)findViewById(R.id.transition_icon)).setOnClickListener(new View.OnClickListener()
/*     */     {
/*     */       public void onClick(View paramAnonymousView) {
/* 129 */         TransitionView.this.fadeOutAndRemove(false);
/*     */       }
/*     */       
/* 132 */     });
/* 133 */     updateBackButtonVisibility();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 140 */     if ((!this.useCustomTransitionLayout) && 
/* 141 */       (getResources().getConfiguration().orientation == 2)) {
/* 142 */       findViewById(R.id.transition_bottom_frame).setVisibility(8);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCustomTransitionLayout(int paramInt1, int paramInt2)
/*     */   {
/* 152 */     this.useCustomTransitionLayout = true;
/* 153 */     inflateContentView(paramInt1);
/* 154 */     setBackground(new ColorDrawable(paramInt2));
/*     */     
/* 156 */     setViewerName(this.viewerName);
/*     */     
/*     */     ImageView localImageView;
/*     */     Drawable localDrawable;
/* 160 */     if (((localDrawable = (localImageView = (ImageView)findViewById(R.id.transition_icon)).getDrawable()) != null) && ((localDrawable instanceof AnimationDrawable))) {
/* 161 */       this.animationDrawable = ((AnimationDrawable)localDrawable);
/* 162 */       this.animationDrawable.start();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setViewerName(String paramString)
/*     */   {
/* 170 */     this.viewerName = paramString;
/* 171 */     TextView localTextView = (TextView)findViewById(R.id.transition_text);
/* 172 */     if (paramString != null) {
/* 173 */       localTextView.setText(getContext().getString(R.string.place_your_viewer_into_viewer_format, new Object[] { paramString }));return;
/*     */     }
/*     */     
/* 176 */     localTextView.setText(getContext().getString(R.string.place_your_phone_into_cardboard));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBackButtonListener(Runnable paramRunnable)
/*     */   {
/* 187 */     this.backButtonRunnable = paramRunnable;
/* 188 */     updateBackButtonVisibility();
/*     */   }
/*     */   
/*     */   public void setVisibility(int paramInt)
/*     */   {
/* 193 */     int i = getVisibility();
/* 194 */     super.setVisibility(paramInt);
/*     */     
/* 196 */     if (i != paramInt) {
/* 197 */       if (paramInt == 0) {
/* 198 */         startOrientationMonitor();return;
/*     */       }
/* 200 */       stopOrientationMonitor();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTransitionListener(TransitionListener paramTransitionListener)
/*     */   {
/* 209 */     this.transitionListener = paramTransitionListener;
/*     */   }
/*     */   
/*     */   private void startOrientationMonitor() {
/* 213 */     if (this.orientationEventListener != null) {
/* 214 */       return;
/*     */     }
/*     */     
/* 217 */     this.orientationEventListener = new OrientationEventListener(getContext())
/*     */     {
/*     */       public void onOrientationChanged(int paramAnonymousInt) {
/* 220 */         TransitionView.this.orientation = paramAnonymousInt;
/*     */         
/* 222 */         if (!TransitionView.this.rotationChecked) {
/* 223 */           TransitionView.this.rotateViewIfNeeded();return;
/*     */         }
/*     */         
/*     */ 
/* 227 */         if (TransitionView.isLandscapeLeft(paramAnonymousInt)) {
/* 228 */           TransitionView.this.fadeOutAndRemove(false);return; }
/* 229 */         TransitionView.isLandscapeRight(paramAnonymousInt);
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 235 */     };
/* 236 */     this.orientationEventListener.enable();
/*     */   }
/*     */   
/*     */   private void stopOrientationMonitor() {
/* 240 */     if (this.orientationEventListener == null) {
/* 241 */       return;
/*     */     }
/*     */     
/* 244 */     this.orientation = -1;
/* 245 */     this.orientationEventListener.disable();
/* 246 */     this.orientationEventListener = null;
/*     */   }
/*     */   
/*     */   protected void onAttachedToWindow()
/*     */   {
/* 251 */     super.onAttachedToWindow();
/* 252 */     if (this.orientationEventListener != null) {
/* 253 */       this.orientationEventListener.enable();
/*     */     }
/*     */     
/* 256 */     rotateViewIfNeeded();
/*     */   }
/*     */   
/*     */   protected void onDetachedFromWindow()
/*     */   {
/* 261 */     if (this.orientationEventListener != null) {
/* 262 */       this.orientation = -1;
/* 263 */       this.orientationEventListener.disable();
/*     */     }
/* 265 */     super.onDetachedFromWindow();
/*     */   }
/*     */   
/*     */ 
/*     */   private void rotateViewIfNeeded()
/*     */   {
/* 271 */     if ((getWidth() <= 0) || (getHeight() <= 0) || (this.orientation == -1) || (this.orientationEventListener == null) || (this.rotationChecked))
/*     */     {
/*     */ 
/* 274 */       return;
/*     */     }
/*     */     
/* 277 */     boolean bool1 = getWidth() < getHeight();
/* 278 */     boolean bool2 = isPortrait(this.orientation);
/*     */     
/*     */     Object localObject;
/*     */     
/* 282 */     if (bool1 != bool2)
/*     */     {
/* 284 */       int i = (localObject = findViewById(R.id.transition_frame)).getWidth();
/* 285 */       int j = ((View)localObject).getHeight();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 290 */       if ((Build.VERSION.SDK_INT >= 17) && 
/* 291 */         (getLayoutDirection() == 1)) {
/* 292 */         ((View)localObject).setPivotX(j - ((View)localObject).getPivotX());
/* 293 */         ((View)localObject).setPivotY(i - ((View)localObject).getPivotY());
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 299 */       if (bool1)
/*     */       {
/*     */ 
/* 302 */         ((View)localObject).setRotation(90.0F);
/*     */       }
/*     */       else
/*     */       {
/* 306 */         ((View)localObject).setRotation(-90.0F);
/*     */       }
/*     */       
/* 309 */       ((View)localObject).setTranslationX((i - j) / 2);
/* 310 */       ((View)localObject).setTranslationY((j - i) / 2);
/*     */       ViewGroup.LayoutParams localLayoutParams1;
/* 312 */       (localLayoutParams1 = ((View)localObject).getLayoutParams()).height = i;
/* 313 */       localLayoutParams1.width = j;
/*     */       
/* 315 */       ((View)localObject).requestLayout();
/*     */     }
/*     */     
/* 318 */     if (!bool2)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 323 */       findViewById(R.id.transition_bottom_frame).setVisibility(8);
/*     */       
/* 325 */       if (this.useCustomTransitionLayout)
/*     */       {
/*     */ 
/*     */ 
/* 329 */         if ((localObject = (TextView)findViewById(R.id.transition_text)) != null) {
/* 330 */           ((TextView)localObject).setMaxWidth(2 * ((TextView)localObject).getMaxWidth());
/*     */         }
/*     */         
/*     */         View localView;
/*     */         
/* 335 */         if ((localView = findViewById(R.id.transition_icon)) != null)
/*     */         {
/*     */           RelativeLayout.LayoutParams localLayoutParams;
/* 338 */           int k = (localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams()).topMargin;
/* 339 */           int m = -1 * k;
/* 340 */           localLayoutParams.setMargins(m, 0, 0, 0);
/* 341 */           localView.requestLayout();
/*     */         }
/*     */       }
/*     */     } else {
/* 345 */       findViewById(R.id.transition_bottom_frame).setVisibility(0);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 350 */     this.rotationChecked = true;
/*     */     
/*     */ 
/*     */ 
/* 354 */     if (isLandscapeLeft(this.orientation)) {
/* 355 */       fadeOutAndRemove(true);
/*     */     }
/*     */   }
/*     */   
/*     */   private void fadeOutAndRemove(boolean paramBoolean)
/*     */   {
/* 361 */     stopOrientationMonitor();
/*     */     
/*     */     Animation localAnimation;
/* 364 */     if ((localAnimation = getAnimation()) != null)
/*     */     {
/*     */ 
/* 367 */       if ((paramBoolean) || (localAnimation.getStartOffset() == 0L)) {
/* 368 */         return;
/*     */       }
/*     */       
/*     */ 
/* 372 */       localAnimation.setAnimationListener(null);
/* 373 */       clearAnimation();
/*     */     }
/*     */     
/*     */     AlphaAnimation localAlphaAnimation;
/* 377 */     (localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F)).setInterpolator(new AccelerateInterpolator());
/* 378 */     localAlphaAnimation.setRepeatCount(0);
/* 379 */     localAlphaAnimation.setDuration(500L);
/* 380 */     if (paramBoolean) {
/* 381 */       localAlphaAnimation.setStartOffset(2000L);
/*     */     }
/*     */     
/* 384 */     localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
/*     */     {
/*     */       public void onAnimationStart(Animation paramAnonymousAnimation) {}
/*     */       
/*     */       public void onAnimationEnd(Animation paramAnonymousAnimation)
/*     */       {
/* 390 */         TransitionView.this.setVisibility(8);
/* 391 */         ((ViewGroup)TransitionView.this.getParent()).removeView(TransitionView.this);
/*     */         
/*     */ 
/* 394 */         if (TransitionView.this.animationDrawable != null) {
/* 395 */           TransitionView.this.animationDrawable.stop();
/* 396 */           TransitionView.this.animationDrawable = null;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 401 */         if (TransitionView.this.transitionListener != null) {
/* 402 */           TransitionView.this.transitionListener.onTransitionDone();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
/* 409 */     });
/* 410 */     startAnimation(localAlphaAnimation);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
/*     */   {
/* 417 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateBackButtonVisibility()
/*     */   {
/* 425 */     ViewGroup localViewGroup = (ViewGroup)findViewById(R.id.transition_frame);
/* 426 */     this.backButton = ((ImageButton)localViewGroup.findViewById(R.id.back_button));
/*     */     
/* 428 */     if (this.backButtonRunnable == null) {
/* 429 */       this.backButton.setVisibility(8);
/* 430 */       this.backButton.setTag(null);
/* 431 */       this.backButton.setOnClickListener(null);return;
/*     */     }
/* 433 */     this.backButton.setTag(this.backButtonRunnable);
/* 434 */     this.backButton.setVisibility(0);
/* 435 */     this.backButton.setOnClickListener(new View.OnClickListener()
/*     */     {
/*     */       public void onClick(View paramAnonymousView)
/*     */       {
/* 439 */         TransitionView.this.backButtonRunnable.run();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean isPortrait(int paramInt)
/*     */   {
/* 450 */     return Math.abs(paramInt - 180) > 135;
/*     */   }
/*     */   
/*     */   private static boolean isLandscapeLeft(int paramInt) {
/* 454 */     return Math.abs(paramInt - 270) < 5;
/*     */   }
/*     */   
/*     */   private static boolean isLandscapeRight(int paramInt) {
/* 458 */     return Math.abs(paramInt - 90) < 5;
/*     */   }
/*     */   
/*     */   public static abstract interface TransitionListener
/*     */   {
/*     */     public abstract void onTransitionDone();
/*     */     
/*     */     public abstract void onSwitchViewer();
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\TransitionView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */