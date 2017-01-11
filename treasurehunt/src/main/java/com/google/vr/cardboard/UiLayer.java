/*     */ package com.google.vr.cardboard;
/*     */ 
/*     */ import android.annotation.TargetApi;
/*     */ import android.content.Context;
/*     */ import android.content.res.Resources;
/*     */ import android.os.Build.VERSION;
/*     */ import android.view.LayoutInflater;
/*     */ import android.view.View;
/*     */ import android.view.View.OnClickListener;
/*     */ import android.widget.ImageButton;
/*     */ import android.widget.RelativeLayout;
/*     */ import android.widget.RelativeLayout.LayoutParams;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UiLayer
/*     */ {
/*     */   private final Context context;
/*     */   private ImageButton settingsButton;
/*     */   private ImageButton backButton;
/*     */   private RelativeLayout alignmentMarker;
/*     */   private TransitionView transitionView;
/*     */   private RelativeLayout rootLayout;
/*  54 */   private volatile boolean isSettingsButtonEnabled = true;
/*  55 */   private volatile boolean isAlignmentMarkerEnabled = true;
/*     */   
/*     */ 
/*     */ 
/*  59 */   private volatile Runnable backButtonRunnable = null;
/*     */   
/*     */ 
/*     */   private volatile Runnable settingsButtonRunnable;
/*     */   
/*  64 */   private volatile boolean transitionViewEnabled = false;
/*     */   
/*     */ 
/*     */ 
/*     */   private volatile String viewerName;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public UiLayer(Context paramContext)
/*     */   {
/*  75 */     this.context = paramContext;
/*  76 */     initializeViewsWithLayoutId(R.layout.ui_layer);
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
/*     */   public void setPortraitSupportEnabled(boolean paramBoolean)
/*     */   {
/*  89 */     initializeViewsWithLayoutId(paramBoolean ? 
/*  90 */       R.layout.ui_layer_with_portrait_support : R.layout.ui_layer);
/*     */   }
/*     */   
/*     */   private void initializeViewsWithLayoutId(int paramInt) {
/*  94 */     this.rootLayout = ((RelativeLayout)LayoutInflater.from(this.context).inflate(paramInt, null, false));
/*     */     
/*  96 */     this.settingsButtonRunnable = new Runnable()
/*     */     {
/*     */       public void run() {
/*  99 */         UiUtils.launchOrInstallCardboard(UiLayer.this.context);
/*     */       }
/* 101 */     };
/* 102 */     this.settingsButton = ((ImageButton)this.rootLayout.findViewById(R.id.ui_settings_button));
/* 103 */     this.settingsButton.setVisibility(computeVisibility(this.isSettingsButtonEnabled));
/*     */     
/*     */ 
/*     */ 
/* 107 */     this.settingsButton.setContentDescription("Settings");
/* 108 */     this.settingsButton.setOnClickListener(new View.OnClickListener()
/*     */     {
/*     */       public void onClick(View paramAnonymousView)
/*     */       {
/*     */         Runnable localRunnable;
/* 113 */         if ((localRunnable = UiLayer.this.settingsButtonRunnable) != null) {
/* 114 */           localRunnable.run();
/*     */         }
/*     */         
/*     */       }
/*     */       
/*     */ 
/* 120 */     });
/* 121 */     this.backButton = ((ImageButton)this.rootLayout.findViewById(R.id.ui_back_button));
/* 122 */     this.backButton.setVisibility(computeVisibility(getBackButtonEnabled()));
/* 123 */     this.backButton.setOnClickListener(new View.OnClickListener()
/*     */     {
/*     */       public void onClick(View paramAnonymousView)
/*     */       {
/*     */         Runnable localRunnable;
/* 128 */         if ((localRunnable = UiLayer.this.backButtonRunnable) != null) {
/* 129 */           localRunnable.run();
/*     */         }
/*     */         
/*     */       }
/* 133 */     });
/* 134 */     this.alignmentMarker = ((RelativeLayout)this.rootLayout.findViewById(R.id.ui_alignment_marker));
/* 135 */     this.alignmentMarker.setVisibility(computeVisibility(getAlignmentMarkerEnabled()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private TransitionView getTransitionView()
/*     */   {
/* 144 */     if (this.transitionView == null) {
/* 145 */       this.transitionView = new TransitionView(this.context);
/* 146 */       RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
/*     */       
/*     */ 
/* 149 */       this.transitionView.setLayoutParams(localLayoutParams);
/* 150 */       this.transitionView.setVisibility(computeVisibility(this.transitionViewEnabled));
/* 151 */       if (this.viewerName != null) {
/* 152 */         this.transitionView.setViewerName(this.viewerName);
/*     */       }
/* 154 */       this.transitionView.setBackButtonListener(this.backButtonRunnable);
/* 155 */       this.rootLayout.addView(this.transitionView);
/*     */     }
/* 157 */     return this.transitionView;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int computeVisibility(boolean paramBoolean)
/*     */   {
/* 167 */     if (paramBoolean) return 0; return 8;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public View getView()
/*     */   {
/* 175 */     return this.rootLayout;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEnabled(final boolean paramBoolean)
/*     */   {
/* 183 */     ThreadUtils.runOnUiThread(new Runnable()
/*     */     {
/*     */       public void run() {
/* 186 */         UiLayer.this.rootLayout.setVisibility(UiLayer.computeVisibility(paramBoolean));
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSettingsButtonEnabled(final boolean paramBoolean)
/*     */   {
/* 196 */     this.isSettingsButtonEnabled = paramBoolean;
/*     */     
/*     */ 
/*     */ 
/* 200 */     ThreadUtils.runOnUiThread(new Runnable()
/*     */     {
/*     */       public void run() {
/* 203 */         UiLayer.this.settingsButton.setVisibility(UiLayer.computeVisibility(paramBoolean));
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSettingsButtonRunnable(Runnable paramRunnable)
/*     */   {
/* 217 */     this.settingsButtonRunnable = paramRunnable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBackButtonListener(final Runnable paramRunnable)
/*     */   {
/* 229 */     this.backButtonRunnable = paramRunnable;
/* 230 */     ThreadUtils.runOnUiThread(new Runnable()
/*     */     {
/*     */       public void run() {
/* 233 */         boolean bool = paramRunnable != null;
/* 234 */         UiLayer.this.backButton.setVisibility(UiLayer.computeVisibility(bool));
/* 235 */         if (UiLayer.this.transitionView != null) {
/* 236 */           UiLayer.this.transitionView.setBackButtonListener(paramRunnable);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAlignmentMarkerEnabled(final boolean paramBoolean)
/*     */   {
/* 246 */     this.isAlignmentMarkerEnabled = paramBoolean;
/* 247 */     ThreadUtils.runOnUiThread(new Runnable()
/*     */     {
/*     */       public void run() {
/* 250 */         UiLayer.this.alignmentMarker.setVisibility(UiLayer.computeVisibility(paramBoolean));
/*     */       }
/*     */     });
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
/*     */   @TargetApi(23)
/*     */   public void setAlignmentMarkerScale(final float paramFloat)
/*     */   {
/* 266 */     if (Build.VERSION.SDK_INT < 23) {
/* 267 */       return;
/*     */     }
/* 269 */     ThreadUtils.runOnUiThread(new Runnable()
/*     */     {
/*     */ 
/*     */       public void run()
/*     */       {
/* 274 */         RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)UiLayer.this.alignmentMarker.getLayoutParams();
/*     */         int i;
/* 276 */         int j = (int)((i = (int)UiLayer.this.context.getResources().getDimension(R.dimen.alignment_marker_height)) * paramFloat);
/*     */         
/*     */ 
/* 279 */         if (localLayoutParams.getRule(15) == -1) {
/* 280 */           localLayoutParams.width = j;
/*     */         } else {
/* 282 */           localLayoutParams.height = j;
/*     */         }
/* 284 */         UiLayer.this.alignmentMarker.setLayoutParams(localLayoutParams);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTransitionViewEnabled(final boolean paramBoolean)
/*     */   {
/* 294 */     this.transitionViewEnabled = paramBoolean;
/* 295 */     ThreadUtils.runOnUiThread(new Runnable()
/*     */     {
/*     */       public void run() {
/* 298 */         if ((!paramBoolean) && (UiLayer.this.transitionView == null)) {
/* 299 */           return;
/*     */         }
/* 301 */         UiLayer.this.getTransitionView().setVisibility(UiLayer.computeVisibility(paramBoolean));
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getTransitionViewEnabled()
/*     */   {
/* 310 */     return this.transitionViewEnabled;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTransitionViewListener(final TransitionView.TransitionListener paramTransitionListener)
/*     */   {
/* 318 */     ThreadUtils.runOnUiThread(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 322 */         if ((paramTransitionListener == null) && (UiLayer.this.transitionView == null)) {
/* 323 */           return;
/*     */         }
/* 325 */         UiLayer.this.getTransitionView().setTransitionListener(paramTransitionListener);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setViewerName(final String paramString)
/*     */   {
/* 335 */     this.viewerName = paramString;
/* 336 */     ThreadUtils.runOnUiThread(new Runnable()
/*     */     {
/*     */ 
/*     */       public void run()
/*     */       {
/* 341 */         if (UiLayer.this.transitionView != null) {
/* 342 */           UiLayer.this.transitionView.setViewerName(paramString);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getViewerName()
/*     */   {
/* 352 */     return this.viewerName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCustomTransitionLayout(final int paramInt1, final int paramInt2)
/*     */   {
/* 360 */     ThreadUtils.runOnUiThread(new Runnable()
/*     */     {
/*     */       public void run() {
/* 363 */         UiLayer.this.getTransitionView().setCustomTransitionLayout(paramInt1, paramInt2);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getSettingsButtonEnabled()
/*     */   {
/* 372 */     return this.isSettingsButtonEnabled;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getBackButtonEnabled()
/*     */   {
/* 379 */     return this.backButtonRunnable != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Runnable getBackButtonRunnable()
/*     */   {
/* 386 */     return this.backButtonRunnable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getAlignmentMarkerEnabled()
/*     */   {
/* 393 */     return this.isAlignmentMarkerEnabled;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\UiLayer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */