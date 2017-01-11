/*     */ package com.google.vr.ndk.base;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Handler;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.util.Log;
/*     */ import android.view.View;
/*     */ import android.view.animation.AnimationUtils;
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
/*     */ class FadeOverlayView
/*     */   extends View
/*     */ {
/*     */   private static final String TAG = "FadeOverlayView";
/*     */   private static final boolean DEBUG = true;
/*     */   private static final int MSG_AUTO_FADE = 77337733;
/*     */   private static final int BACKGROUND_COLOR = -16777216;
/*     */   static final long AUTO_FADE_DURATION_MILLIS = 350L;
/*     */   static final long AUTO_FADE_START_DELAY_MILLIS = 1000L;
/*  51 */   private int fadeType = 0;
/*     */   
/*     */ 
/*     */   private long fadeStartTimeMillis;
/*     */   
/*     */ 
/*     */   private long fadeDurationMillis;
/*     */   
/*     */ 
/*     */   private boolean visible;
/*     */   
/*     */ 
/*  63 */   private final Runnable fadeUpdateRunnable = new Runnable()
/*     */   {
/*     */     public void run()
/*     */     {
/*  67 */       FadeOverlayView.this.updateFade();
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*  72 */   private final Handler autoFadeHandler = new Handler(
/*  73 */     Looper.getMainLooper())
/*     */   {
/*     */     public void handleMessage(Message paramAnonymousMessage) {
/*  76 */       if (paramAnonymousMessage.what == 77337733) {
/*  77 */         FadeOverlayView.this.startFade(1, 350L);
/*  78 */         return;
/*     */       }
/*  80 */       super.handleMessage(paramAnonymousMessage);
/*     */     }
/*     */   };
/*     */   
/*     */   public FadeOverlayView(Context paramContext)
/*     */   {
/*  86 */     super(paramContext);
/*  87 */     setBackgroundColor(-16777216);
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
/*     */   public void startFade(int paramInt, long paramLong)
/*     */   {
/* 102 */     Log.d("FadeOverlayView", 23 + ".startFade: " + paramInt);
/*     */     
/* 104 */     if (!isEnabled()) {
/* 105 */       Log.w("FadeOverlayView", "Ignoring fade request while disabled.");
/* 106 */       return;
/*     */     }
/* 108 */     if (!this.visible) {
/* 109 */       Log.w("FadeOverlayView", "Ignoring fade request while invisible.");
/* 110 */       return;
/*     */     }
/* 112 */     removeFadeCallbacks();
/* 113 */     this.fadeType = paramInt;
/* 114 */     this.fadeDurationMillis = paramLong;
/* 115 */     this.fadeStartTimeMillis = AnimationUtils.currentAnimationTimeMillis();
/* 116 */     updateFade();
/*     */   }
/*     */   
/*     */   public void onInvisible()
/*     */   {
/* 121 */     if (!this.visible) {
/* 122 */       return;
/*     */     }
/*     */     
/* 125 */     this.visible = false;
/*     */     
/* 127 */     if (isEnabled())
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 132 */       removeFadeCallbacks();
/*     */       
/* 134 */       this.fadeType = 2;
/* 135 */       endFade();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onVisible()
/*     */   {
/* 143 */     if ((this.visible) && (getAlpha() == 0.0F)) {
/* 144 */       return;
/*     */     }
/*     */     
/* 147 */     this.visible = true;
/*     */     
/* 149 */     if (isEnabled()) {
/* 150 */       this.autoFadeHandler.removeMessages(77337733);
/* 151 */       this.autoFadeHandler.sendEmptyMessageDelayed(77337733, 1000L);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void flushAutoFade(long paramLong)
/*     */   {
/* 163 */     Log.d("FadeOverlayView", ".flushAutoFade");
/*     */     
/* 165 */     if (this.autoFadeHandler.hasMessages(77337733)) {
/* 166 */       this.autoFadeHandler.removeMessages(77337733);
/*     */       
/*     */ 
/* 169 */       this.autoFadeHandler.sendEmptyMessageDelayed(77337733, paramLong);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean paramBoolean)
/*     */   {
/* 175 */     if (isEnabled() == paramBoolean) {
/* 176 */       return;
/*     */     }
/* 178 */     super.setEnabled(paramBoolean);
/* 179 */     if (!paramBoolean)
/*     */     {
/* 181 */       removeFadeCallbacks();
/* 182 */       this.fadeType = 1;
/* 183 */       endFade();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   int getFadeType()
/*     */   {
/* 192 */     return this.fadeType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isVisible()
/*     */   {
/* 200 */     return this.visible;
/*     */   }
/*     */   
/*     */   private void removeFadeCallbacks()
/*     */   {
/* 205 */     this.autoFadeHandler.removeMessages(77337733);
/* 206 */     removeCallbacks(this.fadeUpdateRunnable);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void endFade()
/*     */   {
/* 216 */     if (this.fadeType == 0)
/*     */     {
/* 218 */       return;
/*     */     }
/* 220 */     setVisibility(this.fadeType == 2 ? 0 : 8);
/* 221 */     setAlpha(this.fadeType == 2 ? 1.0F : 0.0F);
/* 222 */     removeCallbacks(this.fadeUpdateRunnable);
/* 223 */     this.fadeType = 0;
/*     */     
/* 225 */     Log.d("FadeOverlayView", ".endFade");
/*     */   }
/*     */   
/*     */   private void updateFade()
/*     */   {
/*     */     long l;
/* 231 */     float f1 = (float)(l = AnimationUtils.currentAnimationTimeMillis() - this.fadeStartTimeMillis) / (float)this.fadeDurationMillis;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 238 */     float f2 = this.fadeType == 2 ? f1 : 1.0F - f1;
/* 239 */     setAlpha(Math.min(Math.max(f2, 0.0F), 1.0F));
/*     */     
/* 241 */     if ((l < this.fadeDurationMillis) && (getVisibility() != 0))
/*     */     {
/* 243 */       setVisibility(0);
/*     */     }
/*     */     
/* 246 */     if (l < this.fadeDurationMillis)
/*     */     {
/* 248 */       postOnAnimation(this.fadeUpdateRunnable);return;
/*     */     }
/* 250 */     endFade();
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\ndk\base\FadeOverlayView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */