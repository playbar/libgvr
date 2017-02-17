package com.google.vr.cardboard;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class MutableEglConfigChooser implements EGLConfigChooser {
    private static final int EGL_MUTABLE_RENDER_BUFFER_BIT = 4096;
    private static final int EGL_OPENGL_ES3_BIT_KHR = 64;
    private boolean forceMutableBuffer = true;

    public MutableEglConfigChooser() {
    }

    public MutableEglConfigChooser(boolean var1) {
        this.forceMutableBuffer = var1;
    }

    public EGLConfig chooseConfig(EGL10 var1, EGLDisplay var2)
    {
        int[] var3 = new int[]{
                EGL10.EGL_RED_SIZE, 8,
                EGL10.EGL_GREEN_SIZE, 8,
                EGL10.EGL_BLUE_SIZE, 8,
                EGL10.EGL_ALPHA_SIZE, 0,
                EGL10.EGL_DEPTH_SIZE, 0,
                EGL10.EGL_STENCIL_SIZE, 0,
                EGL10.EGL_RENDERABLE_TYPE, 64,
//                EGL10.EGL_SURFACE_TYPE, EGL10.EGL_WINDOW_BIT,
                EGL10.EGL_SURFACE_TYPE, 0x1004,
                EGL10.EGL_NONE
        };
        int[] var4 = new int[1];
        if(!var1.eglChooseConfig(var2, var3, (EGLConfig[])null, 0, var4) && this.forceMutableBuffer) {
            throw new IllegalArgumentException("eglChooseConfig failed");
        } else {
            var3[15] = 4;
            if(!var1.eglChooseConfig(var2, var3, (EGLConfig[])null, 0, var4)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            } else {
                int var5;
                if((var5 = var4[0]) <= 0) {
                    throw new IllegalArgumentException("No configs match configSpec");
                } else {
                    EGLConfig[] var6 = new EGLConfig[var5];
                    if(!var1.eglChooseConfig(var2, var3, var6, var5, var4)) {
                        throw new IllegalArgumentException("eglChooseConfig#2 failed");
                    } else {
                        EGLConfig var7;
                        if((var7 = chooseConfig(var1, var2, var6, this.forceMutableBuffer)) == null) {
                            throw new IllegalArgumentException("No config chosen");
                        } else {
                            return var7;
                        }
                    }
                }
            }
        }
    }

    private static EGLConfig chooseConfig(EGL10 var0, EGLDisplay var1, EGLConfig[] var2, boolean var3) {
        EGLConfig[] var4 = var2;
        int var5 = var2.length;

//        for(int var6 = 0; var6 < var5; ++var6) {
//            EGLConfig var7 = var4[var6];
//            int var8 = findConfigAttrib(var0, var1, var7, EGL10.EGL_DEPTH_SIZE, 0);
//            int var9 = findConfigAttrib(var0, var1, var7, EGL10.EGL_STENCIL_SIZE, 0);
//            int var10 = findConfigAttrib(var0, var1, var7, EGL10.EGL_RED_SIZE, 0);
//            int var11 = findConfigAttrib(var0, var1, var7, EGL10.EGL_GREEN_SIZE, 0);
//            int var12 = findConfigAttrib(var0, var1, var7, EGL10.EGL_BLUE_SIZE, 0);
//            int var13 = findConfigAttrib(var0, var1, var7, EGL10.EGL_SURFACE_TYPE, 0);
//            boolean b = (var10 == 8 && var11 == 8 && var12 == 8 && var8 == 0 && var9 == 0 && (!var3 || (var13 & 4096) != 0));
//            if(b) {
//                return var7;
//            }
//        }
        for(int var6 = 0; var6 < var5; ++var6)
        {
            EGLConfig var7 = var4[var6];
            return var7;

        }

        return null;
    }

    private static int findConfigAttrib(EGL10 var0, EGLDisplay var1, EGLConfig var2, int var3, int var4) {
        int[] var5 = new int[1];
        return var0.eglGetConfigAttrib(var1, var2, var3, var5)?var5[0]:var4;
    }
}

