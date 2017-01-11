/*     */ package com.google.vr.sdk.base;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.os.Bundle;
/*     */ import android.view.KeyEvent;
/*     */ import android.view.View;
/*     */ import android.view.ViewGroup.LayoutParams;
/*     */ import com.google.vr.cardboard.AndroidNCompat;
/*     */ import com.google.vr.cardboard.FullscreenMode;
/*     */ import com.google.vrtoolkit.cardboard.ScreenOnFlagHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GvrActivity
/*     */   extends Activity
/*     */ {
/*     */   private FullscreenMode fullscreenMode;
/*  42 */   private final ScreenOnFlagHelper screenOnFlagHelper = new ScreenOnFlagHelper(this);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private GvrView cardboardView;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean androidVrModeEnabled;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGvrView(GvrView gvrView)
/*     */   {
/*  64 */     setGvrView(gvrView, true);
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
/*     */   public void setGvrView(GvrView gvrView, boolean enableVrModeFallbacks)
/*     */   {
/*  90 */     if (this.cardboardView == gvrView) {
/*  91 */       return;
/*     */     }
/*     */     
/*  94 */     if (this.cardboardView != null) {
/*  95 */       this.cardboardView.setOnCardboardTriggerListener(null);
/*     */     }
/*     */     
/*  98 */     this.cardboardView = gvrView;
/*     */     
/* 100 */     boolean enableAndroidVrMode = gvrView != null;
/* 101 */     this.androidVrModeEnabled = ((AndroidNCompat.setVrModeEnabled(this, enableAndroidVrMode, enableVrModeFallbacks ? 
/* 102 */       1 : 0)) && (enableAndroidVrMode));
/*     */     
/*     */ 
/*     */ 
/* 105 */     if (gvrView == null) {
/* 106 */       return;
/*     */     }
/*     */     
/* 109 */     gvrView.setOnCardboardTriggerListener(new Runnable()
/*     */     {
/*     */       public void run() {
/* 112 */         GvrActivity.this.onCardboardTrigger();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public GvrView getGvrView()
/*     */   {
/* 124 */     return this.cardboardView;
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
/*     */   public void onCardboardTrigger() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void updateGvrViewerParams(GvrViewerParams newParams)
/*     */   {
/* 146 */     if (this.cardboardView != null) {
/* 147 */       this.cardboardView.updateGvrViewerParams(newParams);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onCreate(Bundle savedInstanceState)
/*     */   {
/* 154 */     super.onCreate(savedInstanceState);
/*     */     
/* 156 */     requestWindowFeature(1);
/*     */     
/* 158 */     this.fullscreenMode = new FullscreenMode(getWindow());
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onResume()
/*     */   {
/* 164 */     super.onResume();
/*     */     
/* 166 */     if (this.cardboardView != null) {
/* 167 */       this.cardboardView.onResume();
/*     */     }
/*     */     
/* 170 */     this.fullscreenMode.goFullscreen();
/* 171 */     this.screenOnFlagHelper.start();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onPause()
/*     */   {
/* 177 */     super.onPause();
/* 178 */     if (this.cardboardView != null) {
/* 179 */       this.cardboardView.onPause();
/*     */     }
/*     */     
/* 182 */     this.screenOnFlagHelper.stop();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDestroy()
/*     */   {
/* 188 */     if (this.cardboardView != null) {
/* 189 */       this.cardboardView.setOnCardboardTriggerListener(null);
/* 190 */       this.cardboardView.shutdown();
/* 191 */       this.cardboardView = null;
/*     */     }
/*     */     
/* 194 */     super.onDestroy();
/*     */   }
/*     */   
/*     */ 
/*     */   public void setContentView(View view)
/*     */   {
/* 200 */     if ((view instanceof GvrView)) {
/* 201 */       setGvrView((GvrView)view);
/*     */     }
/*     */     
/* 204 */     super.setContentView(view);
/*     */   }
/*     */   
/*     */ 
/*     */   public void setContentView(View view, ViewGroup.LayoutParams params)
/*     */   {
/* 210 */     if ((view instanceof GvrView)) {
/* 211 */       setGvrView((GvrView)view);
/*     */     }
/*     */     
/* 214 */     super.setContentView(view, params);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean onKeyDown(int keyCode, KeyEvent event)
/*     */   {
/* 221 */     return (shouldSuppressKey(keyCode)) || (super.onKeyDown(keyCode, event));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean onKeyUp(int keyCode, KeyEvent event)
/*     */   {
/* 228 */     return (shouldSuppressKey(keyCode)) || (super.onKeyUp(keyCode, event));
/*     */   }
/*     */   
/*     */ 
/*     */   public void onWindowFocusChanged(boolean hasFocus)
/*     */   {
/* 234 */     super.onWindowFocusChanged(hasFocus);
/* 235 */     this.fullscreenMode.onWindowFocusChanged(hasFocus);
/*     */   }
/*     */   
/*     */   public void setScreenAlwaysOn(boolean enabled)
/*     */   {
/* 240 */     this.screenOnFlagHelper.setScreenAlwaysOn(enabled);
/*     */   }
/*     */   
/*     */   private boolean shouldSuppressKey(int keyCode) {
/* 244 */     if (this.androidVrModeEnabled) {
/* 245 */       return (keyCode == 24) || (keyCode == 25);
/*     */     }
/* 247 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\GvrActivity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */