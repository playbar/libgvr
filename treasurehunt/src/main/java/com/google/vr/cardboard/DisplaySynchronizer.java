/*     */ package com.google.vr.cardboard;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Build.VERSION;
/*     */ import android.util.Log;
/*     */ import android.view.Choreographer.FrameCallback;
/*     */ import android.view.Display;
/*     */ import java.util.concurrent.TimeUnit;
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
/*     */ public class DisplaySynchronizer
/*     */   implements Choreographer.FrameCallback
/*     */ {
/*     */   private static final String TAG = "DisplaySynchronizer";
/*     */   private static final boolean DEBUG = false;
/*     */   private static final float MIN_VALID_DISPLAY_REFRESH_RATE = 30.0F;
/*  29 */   public static final long DISPLAY_ROTATION_REFRESH_INTERVAL_NANOS = TimeUnit.SECONDS.toNanos(1L);
/*     */   
/*     */ 
/*     */   private static final int INVALID_DISPLAY_ROTATION = -1;
/*     */   
/*     */ 
/*     */   private long nativeDisplaySynchronizer;
/*     */   
/*     */ 
/*     */   private final FrameMonitor frameMonitor;
/*     */   
/*     */ 
/*     */   private volatile Display display;
/*     */   
/*     */ 
/*  44 */   private int displayRotationDegrees = -1;
/*  45 */   private long lastDisplayRotationUpdateTimeNanos = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DisplaySynchronizer(Context paramContext, Display paramDisplay)
/*     */   {
/*  57 */     this.nativeDisplaySynchronizer = nativeCreate(getClass().getClassLoader(), paramContext.getApplicationContext());
/*  58 */     if (this.nativeDisplaySynchronizer == 0L) {
/*  59 */       throw new IllegalStateException("Native DisplaySynchronizer creation failed.");
/*     */     }
/*  61 */     setDisplay(paramDisplay);
/*  62 */     this.frameMonitor = new FrameMonitor(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDisplay(Display paramDisplay)
/*     */   {
/*  71 */     checkNativeDisplaySynchronizer();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  76 */     this.display = paramDisplay;
/*  77 */     invalidateDisplayRotation();
/*     */     
/*     */ 
/*     */     float f;
/*     */     
/*     */ 
/*  83 */     long l1 = (f = paramDisplay.getRefreshRate()) >= 30.0F ? ((float)TimeUnit.SECONDS.toNanos(1L) / f) : 0L;
/*     */     
/*  85 */     long l2 = 0L;
/*  86 */     if (Build.VERSION.SDK_INT >= 21) {
/*  87 */       l2 = paramDisplay.getAppVsyncOffsetNanos();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  92 */     nativeReset(this.nativeDisplaySynchronizer, l1, l2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Display getDisplay()
/*     */   {
/* 101 */     return this.display;
/*     */   }
/*     */   
/*     */   protected void finalize() throws Throwable
/*     */   {
/*     */     try
/*     */     {
/* 108 */       if (this.nativeDisplaySynchronizer != 0L) {
/* 109 */         Log.w("DisplaySynchronizer", "DisplaySynchronizer.shutdown() should be called to ensure resource cleanup");
/* 110 */         nativeDestroy(this.nativeDisplaySynchronizer);
/*     */       }
/*     */     } finally {
/* 113 */       super.finalize();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onPause()
/*     */   {
/* 121 */     this.frameMonitor.onPause();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onResume()
/*     */   {
/* 128 */     invalidateDisplayRotation();
/* 129 */     this.frameMonitor.onResume();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onConfigurationChanged()
/*     */   {
/* 136 */     invalidateDisplayRotation();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void shutdown()
/*     */   {
/* 146 */     if (this.nativeDisplaySynchronizer != 0L)
/*     */     {
/*     */ 
/* 149 */       onPause();
/* 150 */       nativeDestroy(this.nativeDisplaySynchronizer);
/* 151 */       this.nativeDisplaySynchronizer = 0L;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getNativeDisplaySynchronizer()
/*     */   {
/* 164 */     checkNativeDisplaySynchronizer();
/* 165 */     return this.nativeDisplaySynchronizer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void doFrame(long paramLong)
/*     */   {
/* 176 */     checkNativeDisplaySynchronizer();
/*     */     
/*     */ 
/*     */ 
/* 180 */     if ((this.displayRotationDegrees == -1) || (paramLong - this.lastDisplayRotationUpdateTimeNanos > DISPLAY_ROTATION_REFRESH_INTERVAL_NANOS))
/*     */     {
/*     */ 
/* 183 */       switch (this.display.getRotation()) {
/*     */       case 0: 
/* 185 */         this.displayRotationDegrees = 0;
/* 186 */         break;
/*     */       case 1: 
/* 188 */         this.displayRotationDegrees = 90;
/* 189 */         break;
/*     */       case 2: 
/* 191 */         this.displayRotationDegrees = 180;
/* 192 */         break;
/*     */       case 3: 
/* 194 */         this.displayRotationDegrees = 270;
/* 195 */         break;
/*     */       default: 
/* 197 */         Log.e("DisplaySynchronizer", "Unknown display rotation, defaulting to 0");
/* 198 */         this.displayRotationDegrees = 0;
/*     */       }
/* 200 */       this.lastDisplayRotationUpdateTimeNanos = paramLong;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 205 */     nativeUpdate(this.nativeDisplaySynchronizer, paramLong, this.displayRotationDegrees);
/*     */   }
/*     */   
/*     */   private void checkNativeDisplaySynchronizer() {
/* 209 */     if (this.nativeDisplaySynchronizer == 0L) {
/* 210 */       throw new IllegalStateException("DisplaySynchronizer has already been shut down.");
/*     */     }
/*     */   }
/*     */   
/*     */   private void invalidateDisplayRotation() {
/* 215 */     this.displayRotationDegrees = -1;
/*     */   }
/*     */   
/*     */   protected native long nativeCreate(ClassLoader paramClassLoader, Context paramContext);
/*     */   
/*     */   protected native void nativeDestroy(long paramLong);
/*     */   
/*     */   protected native void nativeReset(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   protected native void nativeUpdate(long paramLong1, long paramLong2, int paramInt);
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\DisplaySynchronizer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */