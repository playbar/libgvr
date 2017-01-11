/*     */ package com.google.vr.cardboard;
/*     */ 
/*     */ import android.opengl.GLSurfaceView.EGLContextFactory;
/*     */ import android.opengl.GLSurfaceView.EGLWindowSurfaceFactory;
/*     */ import android.os.Build.VERSION;
/*     */ import android.util.Log;
/*     */ import java.nio.IntBuffer;
/*     */ import javax.microedition.khronos.egl.EGL10;
/*     */ import javax.microedition.khronos.egl.EGLConfig;
/*     */ import javax.microedition.khronos.egl.EGLContext;
/*     */ import javax.microedition.khronos.egl.EGLDisplay;
/*     */ import javax.microedition.khronos.egl.EGLSurface;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EglFactory
/*     */   implements GLSurfaceView.EGLContextFactory, GLSurfaceView.EGLWindowSurfaceFactory
/*     */ {
/*     */   private static final String TAG = "GvrEglFactory";
/*     */   private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
/*     */   private static final int EGL_CONTEXT_PRIORITY_LEVEL = 12544;
/*     */   private static final int EGL_CONTEXT_PRIORITY_HIGH = 12545;
/*     */   private static final int EGL_PROTECTED_CONTENT_EXT = 12992;
/*     */   private static final int MIN_REQUIRED_CONTEXT_CLIENT_VERSION = 2;
/*  28 */   private boolean usePriority = false;
/*  29 */   private boolean useProtected = false;
/*  30 */   private int eglContextClientVersion = 2;
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
/*     */   public void setUsePriorityContext(boolean paramBoolean)
/*     */   {
/*  43 */     this.usePriority = paramBoolean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUseProtectedBuffers(boolean paramBoolean)
/*     */   {
/*  55 */     if ((paramBoolean) && (Build.VERSION.SDK_INT < 17)) {
/*  56 */       throw new RuntimeException("Protected buffer support requires EGL 1.4, available only on Jelly Bean MR1 and later.");
/*     */     }
/*     */     
/*  59 */     this.useProtected = paramBoolean;
/*     */   }
/*     */   
/*     */   public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
/*     */   {
/*     */     IntBuffer localIntBuffer;
/*  65 */     (localIntBuffer = IntBuffer.allocate(8)).put(12440);
/*  66 */     localIntBuffer.put(this.eglContextClientVersion);
/*  67 */     if (this.usePriority) {
/*  68 */       localIntBuffer.put(12544);
/*  69 */       localIntBuffer.put(12545);
/*     */     }
/*  71 */     if ((this.useProtected) && (supportsProtectedContent(paramEGL10, paramEGLDisplay))) {
/*  72 */       localIntBuffer.put(12992);
/*  73 */       localIntBuffer.put(1);
/*     */     }
/*  75 */     while (localIntBuffer.hasRemaining()) {
/*  76 */       localIntBuffer.put(12344);
/*     */     }
/*     */     
/*     */ 
/*     */     EGLContext localEGLContext;
/*     */     
/*  82 */     if (((localEGLContext = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, localIntBuffer.array())) == null) && (this.eglContextClientVersion > 2)) {
/*  83 */       int i = this.eglContextClientVersion;Log.w("GvrEglFactory", 75 + "Failed to create EGL context with version " + i + ", will try 2");
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  90 */       localIntBuffer.array()[1] = 2;
/*  91 */       localEGLContext = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, localIntBuffer.array());
/*     */     }
/*     */     
/*  94 */     return localEGLContext;
/*     */   }
/*     */   
/*     */   public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
/*     */   {
/*  99 */     paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
/*     */   }
/*     */   
/*     */ 
/*     */   public EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
/*     */   {
/* 105 */     EGLSurface localEGLSurface = null;
/* 106 */     int[] arrayOfInt = null;
/* 107 */     if ((this.useProtected) && (supportsProtectedContent(paramEGL10, paramEGLDisplay))) {
/* 108 */       arrayOfInt = new int[] { 12992, 1, 12344 };
/*     */     }
/*     */     try {
/* 111 */       localEGLSurface = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, arrayOfInt);
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (IllegalArgumentException localIllegalArgumentException)
/*     */     {
/*     */ 
/*     */ 
/* 119 */       Log.e("GvrEglFactory", "eglCreateWindowSurface", localIllegalArgumentException);
/*     */     }
/* 121 */     return localEGLSurface;
/*     */   }
/*     */   
/*     */   public void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
/*     */   {
/* 126 */     paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEGLContextClientVersion(int paramInt)
/*     */   {
/* 133 */     this.eglContextClientVersion = paramInt;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean supportsProtectedContent(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
/*     */   {
/*     */     String str;
/*     */     
/* 141 */     return (str = paramEGL10.eglQueryString(paramEGLDisplay, 12373)).contains("EGL_EXT_protected_content");
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\EglFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */