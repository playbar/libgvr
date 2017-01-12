/*    */ package com.google.vr.cardboard;
/*    */ 
/*    */ import android.opengl.GLSurfaceView;
/*    */ import javax.microedition.khronos.egl.EGL10;
/*    */ import javax.microedition.khronos.egl.EGLConfig;
/*    */ import javax.microedition.khronos.egl.EGLDisplay;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MutableEglConfigChooser
/*    */   implements GLSurfaceView.EGLConfigChooser
/*    */ {
/*    */   private static final int EGL_MUTABLE_RENDER_BUFFER_BIT = 4096;
/*    */   private static final int EGL_OPENGL_ES3_BIT_KHR = 64;
/* 18 */   private boolean forceMutableBuffer = true;
/*    */   
/*    */ 
/*    */ 
/*    */   public MutableEglConfigChooser() {}
/*    */   
/*    */ 
/*    */   public MutableEglConfigChooser(boolean paramBoolean)
/*    */   {
/* 27 */     this.forceMutableBuffer = paramBoolean;
/*    */   }
/*    */   
/*    */   public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
/*    */   {
/* 32 */     int[] arrayOfInt1 = { 12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, 0, 12326, 0, 12352, 64, 12339, 4100, 12344 };
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 45 */     int[] arrayOfInt2 = new int[1];
/* 46 */     if ((!paramEGL10.eglChooseConfig(paramEGLDisplay, arrayOfInt1, null, 0, arrayOfInt2)) && (this.forceMutableBuffer)) {
/* 47 */       throw new IllegalArgumentException("eglChooseConfig failed");
/*    */     }
/* 49 */     arrayOfInt1[15] = 4;
/* 50 */     if (!paramEGL10.eglChooseConfig(paramEGLDisplay, arrayOfInt1, null, 0, arrayOfInt2)) {
/* 51 */       throw new IllegalArgumentException("eglChooseConfig failed");
/*    */     }
/*    */     
/*    */     int i;
/*    */     
/* 56 */     if ((i = arrayOfInt2[0]) <= 0) {
/* 57 */       throw new IllegalArgumentException("No configs match configSpec");
/*    */     }
/*    */     
/* 60 */     EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
/* 61 */     if (!paramEGL10.eglChooseConfig(paramEGLDisplay, arrayOfInt1, arrayOfEGLConfig, i, arrayOfInt2)) {
/* 62 */       throw new IllegalArgumentException("eglChooseConfig#2 failed");
/*    */     }
/*    */     EGLConfig localEGLConfig;
/* 65 */     if ((localEGLConfig = chooseConfig(paramEGL10, paramEGLDisplay, arrayOfEGLConfig, this.forceMutableBuffer)) == null) {
/* 66 */       throw new IllegalArgumentException("No config chosen");
/*    */     }
/* 68 */     return localEGLConfig;
/*    */   }
/*    */   
/*    */   private static EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig, boolean paramBoolean) {
/*    */     EGLConfig[] arrayOfEGLConfig;
/* 73 */     int i = (arrayOfEGLConfig = paramArrayOfEGLConfig).length; for (int j = 0; j < i; j++) { EGLConfig localEGLConfig = arrayOfEGLConfig[j];
/* 74 */       int k = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
/* 75 */       int m = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
/*    */       
/*    */ 
/* 78 */       int n = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
/* 79 */       int i1 = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
/* 80 */       int i2 = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
/*    */       
/* 82 */       int i3 = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12339, 0);
/*    */       
/* 84 */       if ((n == 8) && (i1 == 8) && (i2 == 8) && (k == 0) && (m == 0) && ((!paramBoolean) || ((i3 & 0x1000) != 0)))
/*    */       {
/* 86 */         return localEGLConfig;
/*    */       }
/*    */     }
/* 89 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   private static int findConfigAttrib(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
/*    */   {
/* 95 */     int[] arrayOfInt = new int[1];
/* 96 */     if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, arrayOfInt)) {
/* 97 */       return arrayOfInt[0];
/*    */     }
/* 99 */     return paramInt2;
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\MutableEglConfigChooser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */