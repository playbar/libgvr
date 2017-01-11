/*     */ package com.google.vr.cardboard;
/*     */ 
/*     */ import android.graphics.Point;
/*     */ import android.opengl.GLSurfaceView.Renderer;
/*     */ import android.os.Process;
/*     */ import android.view.SurfaceHolder;
/*     */ import com.google.vr.ndk.base.GvrApi;
/*     */ import com.google.vr.ndk.base.GvrLayout.ExternalSurfaceManager;
/*     */ import com.google.vr.ndk.base.GvrSurfaceView;
/*     */ import javax.microedition.khronos.egl.EGLConfig;
/*     */ import javax.microedition.khronos.opengles.GL10;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScanlineRacingRenderer
/*     */   implements GLSurfaceView.Renderer
/*     */ {
/*     */   private static final String TAG = "ScanlineRacingRenderer";
/*     */   private final GvrApi gvrApi;
/*     */   private final ExternalSurfaceManager surfaceManager;
/*     */   private GvrSurfaceView gvrSurfaceView;
/*     */   
/*     */   public ScanlineRacingRenderer(GvrApi paramGvrApi)
/*     */   {
/*  27 */     if (paramGvrApi == null) {
/*  28 */       throw new IllegalArgumentException("GvrApi must be supplied for proper scanline rendering");
/*     */     }
/*  30 */     this.gvrApi = paramGvrApi;
/*  31 */     this.surfaceManager = new ExternalSurfaceManager(paramGvrApi);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public GvrLayout.ExternalSurfaceManager getExternalSurfaceManager()
/*     */   {
/*  41 */     return this.surfaceManager;
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
/*     */   public void setSurfaceView(GvrSurfaceView paramGvrSurfaceView)
/*     */   {
/*  55 */     if (paramGvrSurfaceView == null) {
/*  56 */       throw new IllegalArgumentException("GvrSurfaceView must be supplied for proper scanline rendering");
/*     */     }
/*     */     
/*  59 */     this.gvrSurfaceView = paramGvrSurfaceView;
/*     */   }
/*     */   
/*     */   public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
/*     */   {
/*  64 */     Thread.currentThread().setPriority(10);
/*  65 */     AndroidNCompat.setVrThread(Process.myTid());
/*     */     
/*  67 */     this.gvrApi.onSurfaceCreatedReprojectionThread();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
/*     */   {
/*  77 */     this.surfaceManager.consumerAttachToCurrentGLContext();
/*     */   }
/*     */   
/*     */   public void onDrawFrame(GL10 paramGL10)
/*     */   {
/*  82 */     this.surfaceManager.consumerUpdateManagedSurfaces();
/*     */     Point localPoint;
/*  84 */     if ((localPoint = this.gvrApi.renderReprojectionThread()) != null) {
/*  85 */       setSurfaceSize(localPoint.x, localPoint.y);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSurfaceSize(final int paramInt1, final int paramInt2)
/*     */   {
/*  94 */     ThreadUtils.runOnUiThread(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/*  98 */         if ((paramInt1 > 0) && (paramInt2 > 0)) {
/*  99 */           ScanlineRacingRenderer.this.gvrSurfaceView.getHolder().setFixedSize(paramInt1, paramInt2);return;
/*     */         }
/* 101 */         ScanlineRacingRenderer.this.gvrSurfaceView.getHolder().setSizeFromLayout();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */   public void onPause()
/*     */   {
/* 109 */     this.gvrApi.onPauseReprojectionThread();
/*     */     
/*     */ 
/* 112 */     this.surfaceManager.consumerDetachFromCurrentGLContext();
/*     */   }
/*     */   
/*     */ 
/*     */   public void shutdown()
/*     */   {
/* 118 */     this.surfaceManager.shutdown();
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\ScanlineRacingRenderer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */