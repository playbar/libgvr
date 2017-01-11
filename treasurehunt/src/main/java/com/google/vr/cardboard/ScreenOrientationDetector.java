/*     */ package com.google.vr.cardboard;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.view.OrientationEventListener;
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
/*     */ public class ScreenOrientationDetector
/*     */   extends OrientationEventListener
/*     */ {
/*     */   private static final int DEFAULT_PORTRAIT_TOLERANCE_DEGREES = 30;
/*     */   private static final int DEFAULT_LANDSCAPE_TOLERANCE_DEGREES = 10;
/*     */   private final Listener clientListener;
/*     */   private final int landscapeToleranceDegrees;
/*     */   private final int portraitToleranceDegrees;
/*  29 */   private int currentScreenOrientation = -1;
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
/*     */   public ScreenOrientationDetector(Context paramContext, Listener paramListener)
/*     */   {
/*  51 */     this(paramContext, paramListener, 30, 10);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ScreenOrientationDetector(Context paramContext, Listener paramListener, int paramInt1, int paramInt2)
/*     */   {
/*  60 */     super(paramContext);
/*  61 */     if (paramInt1 + paramInt2 > 90) {
/*  62 */       throw new IllegalArgumentException("Portrait and landscape detection thresholds must sum to to <= 90 degrees");
/*     */     }
/*     */     
/*  65 */     this.clientListener = paramListener;
/*  66 */     this.portraitToleranceDegrees = paramInt1;
/*  67 */     this.landscapeToleranceDegrees = paramInt2;
/*     */   }
/*     */   
/*     */   public void enable()
/*     */   {
/*  72 */     this.currentScreenOrientation = -1;
/*  73 */     super.enable();
/*     */   }
/*     */   
/*     */   public void disable()
/*     */   {
/*  78 */     super.disable();
/*  79 */     this.currentScreenOrientation = -1;
/*     */   }
/*     */   
/*     */   public void onOrientationChanged(int paramInt)
/*     */   {
/*     */     int i;
/*  85 */     if ((i = determineScreenOrientation(paramInt)) != this.currentScreenOrientation) {
/*  86 */       this.currentScreenOrientation = i;
/*  87 */       this.clientListener.onScreenOrientationChanged(i);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getCurrentScreenOrientation()
/*     */   {
/*  98 */     return this.currentScreenOrientation;
/*     */   }
/*     */   
/*     */   private int determineScreenOrientation(int paramInt)
/*     */   {
/* 103 */     if (paramInt == -1) {
/* 104 */       return -1;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 111 */     if (((paramInt = paramInt % 360) <= this.portraitToleranceDegrees) || (paramInt >= 360 - this.portraitToleranceDegrees))
/*     */     {
/* 113 */       return 2;
/*     */     }
/* 115 */     if (Math.abs(paramInt - 90) <= this.landscapeToleranceDegrees) {
/* 116 */       return 1;
/*     */     }
/* 118 */     if (Math.abs(paramInt - 180) <= this.portraitToleranceDegrees) {
/* 119 */       return 3;
/*     */     }
/* 121 */     if (Math.abs(paramInt - 270) <= this.landscapeToleranceDegrees) {
/* 122 */       return 0;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 127 */     return this.currentScreenOrientation;
/*     */   }
/*     */   
/*     */   public static abstract interface Listener
/*     */   {
/*     */     public abstract void onScreenOrientationChanged(int paramInt);
/*     */   }
/*     */   
/*     */   public abstract class Orientation
/*     */   {
/*     */     public static final int UNKNOWN = -1;
/*     */     public static final int LANDSCAPE = 0;
/*     */     public static final int LANDSCAPE_REVERSE = 1;
/*     */     public static final int PORTRAIT = 2;
/*     */     public static final int PORTRAIT_REVERSE = 3;
/*     */     
/*     */     public Orientation() {}
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\ScreenOrientationDetector.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */