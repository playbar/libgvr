//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.cardboard;

import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.EGLWindowSurfaceFactory;
import android.os.Build.VERSION;
import android.util.Log;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class EglFactory implements EGLContextFactory, EGLWindowSurfaceFactory {
    private static final String TAG = "GvrEglFactory";
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final int EGL_CONTEXT_PRIORITY_LEVEL = 12544;
    private static final int EGL_CONTEXT_PRIORITY_HIGH = 12545;
    private static final int EGL_PROTECTED_CONTENT_EXT = 12992;
    private static final int MIN_REQUIRED_CONTEXT_CLIENT_VERSION = 2;
    private boolean usePriority = false;
    private boolean useProtected = false;
    private int eglContextClientVersion = 2;

    public EglFactory() {
    }

    public void setUsePriorityContext(boolean var1) {
        this.usePriority = var1;
    }

    public void setUseProtectedBuffers(boolean var1) {
        if(var1 && VERSION.SDK_INT < 17) {
            throw new RuntimeException("Protected buffer support requires EGL 1.4, available only on Jelly Bean MR1 and later.");
        } else {
            this.useProtected = var1;
        }
    }

    public EGLContext createContext(EGL10 var1, EGLDisplay var2, EGLConfig var3) {
        IntBuffer var4;
        (var4 = IntBuffer.allocate(8)).put(12440);
        var4.put(this.eglContextClientVersion);
        if(this.usePriority) {
            var4.put(12544);
            var4.put(12545);
        }

        if(this.useProtected && this.supportsProtectedContent(var1, var2)) {
            var4.put(12992);
            var4.put(1);
        }

        while(var4.hasRemaining()) {
            var4.put(12344);
        }

        EGLContext var5;
        if((var5 = var1.eglCreateContext(var2, var3, EGL10.EGL_NO_CONTEXT, var4.array())) == null && this.eglContextClientVersion > 2) {
            int var6 = this.eglContextClientVersion;
            Log.w("GvrEglFactory", (new StringBuilder(75)).append("Failed to create EGL context with version ").append(var6).append(", will try 2").toString());
            var4.array()[1] = 2;
            var5 = var1.eglCreateContext(var2, var3, EGL10.EGL_NO_CONTEXT, var4.array());
        }

        return var5;
    }

    public void destroyContext(EGL10 var1, EGLDisplay var2, EGLContext var3) {
        var1.eglDestroyContext(var2, var3);
    }

    public EGLSurface createWindowSurface(EGL10 var1, EGLDisplay var2, EGLConfig var3, Object var4) {
        EGLSurface var5 = null;
        int[] var6 = null;
        if(this.useProtected && this.supportsProtectedContent(var1, var2)) {
            var6 = new int[]{12992, 1, 12344};
        }

        try {
            var5 = var1.eglCreateWindowSurface(var2, var3, var4, var6);
        } catch (IllegalArgumentException var8) {
            Log.e("GvrEglFactory", "eglCreateWindowSurface", var8);
        }

        return var5;
    }

    public void destroySurface(EGL10 var1, EGLDisplay var2, EGLSurface var3) {
        var1.eglDestroySurface(var2, var3);
    }

    public void setEGLContextClientVersion(int var1) {
        this.eglContextClientVersion = var1;
    }

    private boolean supportsProtectedContent(EGL10 var1, EGLDisplay var2) {
        return var1.eglQueryString(var2, 12373).contains("EGL_EXT_protected_content");
    }
}
