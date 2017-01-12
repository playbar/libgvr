/*     */ package com.google.vr.sdk.base;
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
/*     */ public class HeadMountedDisplay
/*     */ {
/*     */   private ScreenParams screen;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private GvrViewerParams cardboardDevice;
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
/*     */   public HeadMountedDisplay(ScreenParams screenParams, GvrViewerParams gvrViewerParams)
/*     */   {
/*  38 */     this.screen = screenParams;
/*  39 */     this.cardboardDevice = gvrViewerParams;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public HeadMountedDisplay(HeadMountedDisplay hmd)
/*     */   {
/*  48 */     this.screen = new ScreenParams(hmd.screen);
/*  49 */     this.cardboardDevice = new GvrViewerParams(hmd.cardboardDevice);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScreenParams(ScreenParams screen)
/*     */   {
/*  58 */     this.screen = new ScreenParams(screen);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ScreenParams getScreenParams()
/*     */   {
/*  67 */     return this.screen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setGvrViewerParams(GvrViewerParams gvrViewerParams)
/*     */   {
/*  76 */     this.cardboardDevice = new GvrViewerParams(gvrViewerParams);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public GvrViewerParams getGvrViewerParams()
/*     */   {
/*  85 */     return this.cardboardDevice;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/*  96 */     if (other == null) {
/*  97 */       return false;
/*     */     }
/*  99 */     if (other == this) {
/* 100 */       return true;
/*     */     }
/* 102 */     if (!(other instanceof HeadMountedDisplay)) {
/* 103 */       return false;
/*     */     }
/* 105 */     HeadMountedDisplay o = (HeadMountedDisplay)other;
/*     */     
/* 107 */     return (this.screen.equals(o.screen)) && 
/* 108 */       (this.cardboardDevice.equals(o.cardboardDevice));
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\HeadMountedDisplay.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */