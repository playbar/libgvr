/*    */ package com.google.vr.cardboard;
/*    */ 
/*    */ import android.os.Build.VERSION;
/*    */ import android.os.Handler;
/*    */ import android.view.View;
/*    */ import android.view.View.OnSystemUiVisibilityChangeListener;
/*    */ import android.view.Window;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FullscreenMode
/*    */ {
/*    */   private static final int NAVIGATION_BAR_TIMEOUT_MS = 2000;
/*    */   private final Window window;
/*    */   
/*    */   public FullscreenMode(Window paramWindow)
/*    */   {
/* 19 */     this.window = paramWindow;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void goFullscreen()
/*    */   {
/* 26 */     setFullscreenModeFlags();
/* 27 */     setImmersiveStickyModeCompat();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private void setImmersiveStickyModeCompat()
/*    */   {
/* 35 */     if (Build.VERSION.SDK_INT < 19) {
/* 36 */       final Handler localHandler = new Handler();
/* 37 */       this.window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
/*    */       {
/*    */         public void onSystemUiVisibilityChange(int paramAnonymousInt)
/*    */         {
/* 41 */           if ((paramAnonymousInt & 0x2) == 0) {
/* 42 */             localHandler.postDelayed(new Runnable()
/*    */             {
/*    */ 
/* 45 */               public void run() { FullscreenMode.this.setFullscreenModeFlags(); } }, 2000L);
/*    */           }
/*    */         }
/*    */       });
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onWindowFocusChanged(boolean paramBoolean)
/*    */   {
/* 59 */     if (paramBoolean) {
/* 60 */       setFullscreenModeFlags();
/*    */     }
/*    */   }
/*    */   
/*    */   private void setFullscreenModeFlags() {
/* 65 */     this.window.getDecorView().setSystemUiVisibility(5894);
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\FullscreenMode.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */