//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.ndk.base;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.EGLWindowSurfaceFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.SurfaceHolder.Callback2;
import com.google.vr.cardboard.EglFactory;
import com.google.vr.cardboard.EglReadyListener;
import com.google.vr.ndk.base.TraceCompat;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class GvrSurfaceView extends SurfaceView implements Callback2 {
    private static final String TAG = "GvrSurfaceView";
    private static final boolean LOG_ATTACH_DETACH = false;
    private static final boolean LOG_THREADS = false;
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_SURFACE = false;
    private static final boolean LOG_RENDERER = false;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_EGL = false;
    private static final int GL_CONTEXT_FLAG_NO_ERROR_BIT_KHR = 8;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int SWAPMODE_QUEUED = 0;
    public static final int SWAPMODE_SINGLE = 1;
    public static final int SWAPMODE_MANUAL = 2;
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private final WeakReference<GvrSurfaceView> mThisWeakRef = new WeakReference(this);
    private GvrSurfaceView.GLThread mGLThread;
    private Renderer mRenderer;
    private boolean mDetached;
    private EGLConfigChooser mEGLConfigChooser;
    private EGLContextFactory mEGLContextFactory;
    private EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GvrSurfaceView.GLWrapper mGLWrapper;
    private int mDebugFlags;
    private int mEGLContextClientVersion;
    private boolean mPreserveEGLContextOnPause;
    private boolean mPreserveGlThreadOnDetachedFromWindow;
    private EglReadyListener mAppContextListener;

    public GvrSurfaceView(Context var1) {
        super(var1);
        this.init();
    }

    public GvrSurfaceView(Context var1, AttributeSet var2) {
        super(var1, var2);
        this.init();
    }

    protected void finalize() throws Throwable {
        try {
            if(this.mGLThread != null) {
                this.mGLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }

    }

    private void init() {
        this.getHolder().addCallback(this);
    }

    public void setGLWrapper(GvrSurfaceView.GLWrapper var1) {
        this.mGLWrapper = var1;
    }

    public void setDebugFlags(int var1) {
        this.mDebugFlags = var1;
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public void setPreserveEGLContextOnPause(boolean var1) {
        this.mPreserveEGLContextOnPause = var1;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public void setRenderer(Renderer var1) {
        this.checkRenderThreadState();
        if(this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new GvrSurfaceView.SimpleEGLConfigChooser(true);
        }

        if(this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new GvrSurfaceView.DefaultContextFactory();
        }

        if(this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new GvrSurfaceView.DefaultWindowSurfaceFactory();
        }

        this.mRenderer = var1;
        this.mGLThread = new GvrSurfaceView.GLThread(this.mThisWeakRef);
        this.mGLThread.start();
    }

    public void setEglReadyListener(EglReadyListener var1) {
        this.mAppContextListener = var1;
    }

    public void setEGLContextFactory(EGLContextFactory var1) {
        this.checkRenderThreadState();
        this.mEGLContextFactory = var1;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory var1) {
        this.checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = var1;
    }

    public void setEGLConfigChooser(EGLConfigChooser var1) {
        this.checkRenderThreadState();
        this.mEGLConfigChooser = var1;
    }

    public void setEGLConfigChooser(boolean var1) {
        this.setEGLConfigChooser(new GvrSurfaceView.SimpleEGLConfigChooser(var1));
    }

    public void setEGLConfigChooser(int var1, int var2, int var3, int var4, int var5, int var6) {
        this.setEGLConfigChooser(new GvrSurfaceView.ComponentSizeChooser(var1, var2, var3, var4, var5, var6));
    }

    public void setEGLContextClientVersion(int var1) {
        this.checkRenderThreadState();
        this.mEGLContextClientVersion = var1;
    }

    public void setRenderMode(int var1) {
        this.mGLThread.setRenderMode(var1);
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    public int getSwapMode()
    {
        if(VERSION.SDK_INT > 24 )
            return 1;
        else
            return 0;
    }

    public void setSwapMode(int var1) {
        var1 = getSwapMode();
        if(var1 == 1 && VERSION.SDK_INT < 17) {
            Log.e("GvrSurfaceView", "setSwapMode(SWAPMODE_SINGLE) requires Jellybean MR1 (EGL14 dependency)");
        } else {
            this.mGLThread.setSwapMode(var1);
        }
    }

    public void setPreserveGlThreadOnDetachedFromWindow(boolean var1) {
        this.checkRenderThreadState();
        this.mPreserveGlThreadOnDetachedFromWindow = var1;
    }

    public void surfaceCreated(SurfaceHolder var1) {
        this.mGLThread.surfaceCreated();
    }

    public void surfaceDestroyed(SurfaceHolder var1) {
        this.mGLThread.surfaceDestroyed();
    }

    public void surfaceChanged(SurfaceHolder var1, int var2, int var3, int var4) {
        this.mGLThread.onWindowResize(var3, var4);
    }

    public void surfaceRedrawNeeded(SurfaceHolder var1) {
        this.mGLThread.requestRenderAndWait();
    }

    public void onPause() {
        this.mGLThread.onPause();
    }

    public void onResume() {
        this.mGLThread.onResume();
    }

    public void queueEvent(Runnable var1) {
        this.mGLThread.queueEvent(var1);
    }

    public void requestExitAndWait() {
        this.mGLThread.requestExitAndWait();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.mDetached && this.mRenderer != null && !this.mPreserveGlThreadOnDetachedFromWindow) {
            int var1 = 1;
            int var2 = 0;
            if(this.mGLThread != null) {
                var1 = this.mGLThread.getRenderMode();
                var2 = this.mGLThread.getSwapMode();
            }

            this.mGLThread = new GvrSurfaceView.GLThread(this.mThisWeakRef);
            if(var1 != 1) {
                this.mGLThread.setRenderMode(var1);
            }

            if(var2 != 0) {
                this.mGLThread.setSwapMode(var2);
            }

            this.mGLThread.start();
        }

        this.mDetached = false;
    }

    protected void onDetachedFromWindow() {
        if(this.mGLThread != null && !this.mPreserveGlThreadOnDetachedFromWindow) {
            this.requestExitAndWait();
        }

        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    protected boolean isDetachedFromWindow() {
        return this.mDetached;
    }

    private void checkRenderThreadState() {
        if(this.mGLThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    static class LogWriter extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        LogWriter() {
        }

        public void close() {
            this.flushBuilder();
        }

        public void flush() {
            this.flushBuilder();
        }

        public void write(char[] var1, int var2, int var3) {
            for(int var4 = 0; var4 < var3; ++var4) {
                char var5;
                if((var5 = var1[var2 + var4]) == 10) {
                    this.flushBuilder();
                } else {
                    this.mBuilder.append(var5);
                }
            }

        }

        private void flushBuilder() {
            if(this.mBuilder.length() > 0) {
                Log.v("GvrSurfaceView", this.mBuilder.toString());
                this.mBuilder.delete(0, this.mBuilder.length());
            }

        }
    }

    static class GLThread extends Thread {
        private boolean mShouldExit;
        private boolean mExited;
        private boolean mRequestPaused;
        private boolean mPaused;
        private boolean mHasSurface;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private boolean mFinishedCreatingEglSurface;
        private boolean mShouldReleaseEglContext;
        private int mWidth = 0;
        private int mHeight = 0;
        private int mRenderMode = 1;
        private int mRequestedSwapMode = 0;
        private boolean mRequestRender = true;
        private boolean mWantRenderNotification = false;
        private boolean mRenderComplete;
        private ArrayList<Runnable> mEventQueue = new ArrayList();
        private boolean mSizeChanged = true;
        private GvrSurfaceView.EglHelper mEglHelper;
        private WeakReference<GvrSurfaceView> mGvrSurfaceViewWeakRef;
        private final GvrSurfaceView.GLThread.GLThreadManager mGLThreadManager = new GvrSurfaceView.GLThread.GLThreadManager();

        GLThread(WeakReference<GvrSurfaceView> var1) {
            this.mGvrSurfaceViewWeakRef = var1;
            GvrSurfaceView var2;
            if((var2 = (GvrSurfaceView)var1.get()) != null && var2.mAppContextListener != null) {
                var2.mAppContextListener.setMonitor(this.mGLThreadManager);
            }

        }

        public void run() {
            long var1 = this.getId();
            this.setName((new StringBuilder(29)).append("GLThread ").append(var1).toString());

            try {
                this.guardedRun();
                return;
            } catch (InterruptedException var6) {
                ;
            } finally {
                this.mGLThreadManager.threadExiting(this);
            }

        }

        private void stopEglSurfaceLocked() {
            if(this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }

        }

        private void stopEglContextLocked() {
            if(this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                this.mGLThreadManager.releaseEglContextLocked(this);
            }

        }

        private void guardedRun() throws InterruptedException {
            this.mEglHelper = new GvrSurfaceView.EglHelper(this.mGvrSurfaceViewWeakRef);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            this.mWantRenderNotification = false;
            boolean var40 = false;

            GvrSurfaceView.GLThread.GLThreadManager var87;
            try {
                var40 = true;
                GL10 var1 = null;
                boolean var2 = false;
                boolean var3 = false;
                boolean var4 = false;
                boolean var5 = false;
                boolean var6 = false;
                boolean var7 = false;
                boolean var8 = false;
                boolean var9 = false;
                boolean var10 = false;
                int var11 = 0;
                int var12 = 0;
                int var13 = 0;
                Runnable var14 = null;

                label1188:
                while(true) {
                    while(true) {
                        GvrSurfaceView.GLThread.GLThreadManager var15 = this.mGLThreadManager;
                        synchronized(this.mGLThreadManager) {
                            while(true) {
                                if(this.mShouldExit) {
                                    var40 = false;
                                    break label1188;
                                }

                                if(!this.mEventQueue.isEmpty()) {
                                    var14 = (Runnable)this.mEventQueue.remove(0);
                                    break;
                                }

                                boolean var16 = false;
                                if(this.mPaused != this.mRequestPaused) {
                                    var16 = this.mRequestPaused;
                                    this.mPaused = this.mRequestPaused;
                                    this.mGLThreadManager.notifyAll();
                                }

                                if(this.mShouldReleaseEglContext) {
                                    this.stopEglSurfaceLocked();
                                    this.stopEglContextLocked();
                                    this.mShouldReleaseEglContext = false;
                                    var9 = true;
                                }

                                if(var5) {
                                    this.stopEglSurfaceLocked();
                                    this.stopEglContextLocked();
                                    var5 = false;
                                }

                                if(var16 && this.mHaveEglSurface) {
                                    this.stopEglSurfaceLocked();
                                }

                                GvrSurfaceView var17;
                                if(var16 && this.mHaveEglContext && !((var17 = (GvrSurfaceView)this.mGvrSurfaceViewWeakRef.get()) == null?false:var17.mPreserveEGLContextOnPause)) {
                                    this.stopEglContextLocked();
                                }

                                if(!this.mHasSurface && !this.mWaitingForSurface) {
                                    if(this.mHaveEglSurface) {
                                        this.stopEglSurfaceLocked();
                                    }

                                    this.mWaitingForSurface = true;
                                    this.mSurfaceIsBad = false;
                                    this.mGLThreadManager.notifyAll();
                                }

                                if(this.mHasSurface && this.mWaitingForSurface) {
                                    this.mWaitingForSurface = false;
                                    this.mGLThreadManager.notifyAll();
                                }

                                if(var8) {
                                    this.mWantRenderNotification = false;
                                    var8 = false;
                                    this.mRenderComplete = true;
                                    this.mGLThreadManager.notifyAll();
                                }

                                if(this.readyToDraw()) {
                                    if(!this.mHaveEglContext) {
                                        if(var9) {
                                            var9 = false;
                                        } else {
                                            try {
                                                this.mEglHelper.start();
                                            } catch (RuntimeException var82) {
                                                this.mGLThreadManager.releaseEglContextLocked(this);
                                                throw var82;
                                            }

                                            this.mHaveEglContext = true;
                                            var2 = true;
                                            this.mGLThreadManager.notifyAll();
                                        }
                                    }

                                    if(this.mHaveEglContext && !this.mHaveEglSurface) {
                                        this.mHaveEglSurface = true;
                                        var3 = true;
                                        var4 = true;
                                        var6 = true;
                                    }

                                    if(this.mHaveEglSurface) {
                                        if(this.mSizeChanged) {
                                            var6 = true;
                                            var12 = this.mWidth;
                                            var13 = this.mHeight;
                                            this.mWantRenderNotification = true;
                                            var3 = true;
                                            this.mSizeChanged = false;
                                        }

                                        this.mRequestRender = false;
                                        this.mGLThreadManager.notifyAll();
                                        if(this.mWantRenderNotification) {
                                            var7 = true;
                                        }

                                        var10 = this.mRequestedSwapMode != var11;
                                        var11 = this.mRequestedSwapMode;
                                        break;
                                    }
                                }

                                this.mGLThreadManager.wait();
                            }
                        }

                        if(var14 != null) {
                            var14.run();
                            var14 = null;
                        } else {
                            if(var3) {
                                if(!this.mEglHelper.createSurface()) {
                                    var15 = this.mGLThreadManager;
                                    synchronized(this.mGLThreadManager) {
                                        this.mFinishedCreatingEglSurface = true;
                                        this.mSurfaceIsBad = true;
                                        this.mGLThreadManager.notifyAll();
                                        continue;
                                    }
                                }

                                var15 = this.mGLThreadManager;
                                synchronized(this.mGLThreadManager) {
                                    this.mFinishedCreatingEglSurface = true;
                                    this.mGLThreadManager.notifyAll();
                                }

                                var3 = false;
                                var11 = 0;
                            }

                            if(var4) {
                                var1 = (GL10)this.mEglHelper.createGL();
                                var4 = false;
                            }

                            GvrSurfaceView var85;
                            if(var2) {
                                if((var85 = (GvrSurfaceView)this.mGvrSurfaceViewWeakRef.get()) != null) {
                                    try {
                                        TraceCompat.beginSection("onSurfaceCreated");
                                        var85.mRenderer.onSurfaceCreated(var1, this.mEglHelper.mEglConfig);
                                    } finally {
                                        TraceCompat.endSection();
                                    }
                                }

                                var2 = false;
                            }

                            if(var6) {
                                if((var85 = (GvrSurfaceView)this.mGvrSurfaceViewWeakRef.get()) != null) {
                                    try {
                                        TraceCompat.beginSection("onSurfaceChanged");
                                        var85.mRenderer.onSurfaceChanged(var1, var12, var13);
                                    } finally {
                                        TraceCompat.endSection();
                                    }
                                }

                                var6 = false;
                            }

                            if(var10) {
                                this.mEglHelper.setEglSurfaceAttrib(12422, var11 == 1?12421:12420);
                                this.mEglHelper.setEglSurfaceAttrib(12620, var11 == 1?1:0);
                            }

                            if((var85 = (GvrSurfaceView)this.mGvrSurfaceViewWeakRef.get()) != null) {
                                try {
                                    TraceCompat.beginSection("onDrawFrame");
                                    var85.mRenderer.onDrawFrame(var1);
                                } finally {
                                    TraceCompat.endSection();
                                }
                            }

                            if(var10 || var11 == 0) {
                                int var86;
                                switch(var86 = this.mEglHelper.swap()) {
                                    case 12288:
                                        break;
                                    case 12302:
                                        var5 = true;
                                        break;
                                    default:
                                        GvrSurfaceView.EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", var86);
                                        if(var11 == 0) {
                                            var87 = this.mGLThreadManager;
                                            synchronized(this.mGLThreadManager) {
                                                this.mSurfaceIsBad = true;
                                                this.mGLThreadManager.notifyAll();
                                            }
                                        }
                                }
                            }

                            if(var7) {
                                var8 = true;
                                var7 = false;
                            }
                        }
                    }
                }
            } finally {
                if(var40) {
                    GvrSurfaceView.GLThread.GLThreadManager var27 = this.mGLThreadManager;
                    synchronized(this.mGLThreadManager) {
                        this.stopEglSurfaceLocked();
                        this.stopEglContextLocked();
                    }
                }
            }

            var87 = this.mGLThreadManager;
            synchronized(this.mGLThreadManager) {
                this.stopEglSurfaceLocked();
                this.stopEglContextLocked();
            }
        }

        public boolean ableToDraw() {
            return this.mHaveEglContext && this.mHaveEglSurface && this.readyToDraw();
        }

        private boolean readyToDraw() {
            GvrSurfaceView var1;
            EglReadyListener var10000 = (var1 = (GvrSurfaceView)this.mGvrSurfaceViewWeakRef.get()) == null?null:var1.mAppContextListener;
            EglReadyListener var2 = var10000;
            boolean var3 = var10000 == null || var2.getEGLContext() != null;
            return !this.mPaused && var3 && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        public void setRenderMode(int var1) {
            if(var1 >= 0 && var1 <= 1) {
                GvrSurfaceView.GLThread.GLThreadManager var2 = this.mGLThreadManager;
                synchronized(this.mGLThreadManager) {
                    this.mRenderMode = var1;
                    this.mGLThreadManager.notifyAll();
                }
            } else {
                throw new IllegalArgumentException("renderMode");
            }
        }

        public void setSwapMode(int var1) {
            if(var1 >= 0 && var1 <= 2) {
                GvrSurfaceView.GLThread.GLThreadManager var2 = this.mGLThreadManager;
                synchronized(this.mGLThreadManager) {
                    this.mRequestedSwapMode = var1;
                    this.mGLThreadManager.notifyAll();
                }
            } else {
                throw new IllegalArgumentException("swapMode");
            }
        }

        public int getRenderMode() {
            GvrSurfaceView.GLThread.GLThreadManager var1 = this.mGLThreadManager;
            synchronized(this.mGLThreadManager) {
                return this.mRenderMode;
            }
        }

        public int getSwapMode() {
            GvrSurfaceView.GLThread.GLThreadManager var1 = this.mGLThreadManager;
            synchronized(this.mGLThreadManager) {
                return this.mRequestedSwapMode;
            }
        }

        public void requestRender() {
            GvrSurfaceView.GLThread.GLThreadManager var1 = this.mGLThreadManager;
            synchronized(this.mGLThreadManager) {
                this.mRequestRender = true;
                this.mGLThreadManager.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            GvrSurfaceView.GLThread.GLThreadManager var1 = this.mGLThreadManager;
            synchronized(this.mGLThreadManager) {
                if(Thread.currentThread() != this) {
                    this.mWantRenderNotification = true;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    this.mGLThreadManager.notifyAll();

                    while(!this.mExited && !this.mPaused && !this.mRenderComplete && this.ableToDraw()) {
                        try {
                            this.mGLThreadManager.wait();
                        } catch (InterruptedException var3) {
                            Thread.currentThread().interrupt();
                        }
                    }

                }
            }
        }

        public void surfaceCreated() {
            GvrSurfaceView.GLThread.GLThreadManager var1 = this.mGLThreadManager;
            synchronized(this.mGLThreadManager) {
                this.mHasSurface = true;
                this.mFinishedCreatingEglSurface = false;
                this.mGLThreadManager.notifyAll();

                while(this.mWaitingForSurface && !this.mFinishedCreatingEglSurface && !this.mExited) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException var3) {
                        Thread.currentThread().interrupt();
                    }
                }

            }
        }

        public void surfaceDestroyed() {
            GvrSurfaceView.GLThread.GLThreadManager var1 = this.mGLThreadManager;
            synchronized(this.mGLThreadManager) {
                this.mHasSurface = false;
                this.mGLThreadManager.notifyAll();

                while(!this.mWaitingForSurface && !this.mExited) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException var3) {
                        Thread.currentThread().interrupt();
                    }
                }

            }
        }

        public void onPause() {
            GvrSurfaceView.GLThread.GLThreadManager var1 = this.mGLThreadManager;
            synchronized(this.mGLThreadManager) {
                this.mRequestPaused = true;
                this.mGLThreadManager.notifyAll();

                while(!this.mExited && !this.mPaused) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException var3) {
                        Thread.currentThread().interrupt();
                    }
                }

            }
        }

        public void onResume() {
            GvrSurfaceView.GLThread.GLThreadManager var1 = this.mGLThreadManager;
            synchronized(this.mGLThreadManager) {
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                this.mGLThreadManager.notifyAll();

                while(!this.mExited && this.mPaused && !this.mRenderComplete) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException var3) {
                        Thread.currentThread().interrupt();
                    }
                }

            }
        }

        public void onWindowResize(int var1, int var2) {
            GvrSurfaceView.GLThread.GLThreadManager var3 = this.mGLThreadManager;
            synchronized(this.mGLThreadManager) {
                this.mWidth = var1;
                this.mHeight = var2;
                this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                if(Thread.currentThread() != this) {
                    this.mGLThreadManager.notifyAll();

                    while(!this.mExited && !this.mPaused && !this.mRenderComplete && this.ableToDraw()) {
                        try {
                            this.mGLThreadManager.wait();
                        } catch (InterruptedException var5) {
                            Thread.currentThread().interrupt();
                        }
                    }

                }
            }
        }

        public void requestExitAndWait() {
            GvrSurfaceView.GLThread.GLThreadManager var1 = this.mGLThreadManager;
            synchronized(this.mGLThreadManager) {
                this.mShouldExit = true;
                this.mGLThreadManager.notifyAll();

                while(!this.mExited) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException var4) {
                        Thread.currentThread().interrupt();
                    }
                }

                GvrSurfaceView var2;
                if((var2 = (GvrSurfaceView)this.mGvrSurfaceViewWeakRef.get()) != null && var2.mAppContextListener != null) {
                    var2.mAppContextListener.resetMonitor();
                }

            }
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            this.mGLThreadManager.notifyAll();
        }

        public void queueEvent(Runnable var1) {
            if(var1 == null) {
                throw new IllegalArgumentException("r must not be null");
            } else {
                GvrSurfaceView.GLThread.GLThreadManager var2 = this.mGLThreadManager;
                synchronized(this.mGLThreadManager) {
                    this.mEventQueue.add(var1);
                    this.mGLThreadManager.notifyAll();
                }
            }
        }

        private static class GLThreadManager {
            private static final String TAG = "GLThreadManager";

            private GLThreadManager() {
            }

            public synchronized void threadExiting(GvrSurfaceView.GLThread var1) {
                var1.mExited = true;
                this.notifyAll();
            }

            public void releaseEglContextLocked(GvrSurfaceView.GLThread var1) {
                this.notifyAll();
            }
        }
    }

    private static class EglHelper {
        public static final int EGL_FRONT_BUFFER_AUTO_REFRESH = 12620;
        private WeakReference<GvrSurfaceView> mGvrSurfaceViewWeakRef;
        EGL10 mEgl;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        EGLConfig mEglConfig;
        EGLContext mEglContext;

        public EglHelper(WeakReference<GvrSurfaceView> var1) {
            this.mGvrSurfaceViewWeakRef = var1;
        }

        public void start() {
            this.mEgl = (EGL10)EGLContext.getEGL();
            this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if(this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            } else {
                int[] var1 = new int[2];
                if(!this.mEgl.eglInitialize(this.mEglDisplay, var1)) {
                    throw new RuntimeException("eglInitialize failed");
                } else {
                    GvrSurfaceView var2;
                    if((var2 = (GvrSurfaceView)this.mGvrSurfaceViewWeakRef.get()) == null) {
                        this.mEglConfig = null;
                        this.mEglContext = null;
                    } else {
                        if(var2.mAppContextListener != null) {
                            EGLContext var3;
                            if((var3 = var2.mAppContextListener.getEGLContext()) != null && var3 != EGL10.EGL_NO_CONTEXT) {
                                EglFactory var4 = (EglFactory)var2.mEGLContextFactory;
                                int var5 = var2.mAppContextListener.getEGLContextFlags();
                                var4.setSharedContext(var3);
                                var4.setErrorReportingEnabled((var5 & 8) == 0);
                            } else {
                                this.throwEglException("Unable to obtain application\'s OpenGL context.");
                            }
                        }

                        this.mEglConfig = var2.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                        this.mEglContext = var2.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
                    }

                    if(this.mEglContext == null || this.mEglContext == EGL10.EGL_NO_CONTEXT) {
                        this.mEglContext = null;
                        this.throwEglException("createContext");
                    }

                    this.mEglSurface = null;
                }
            }
        }

        public boolean createSurface() {
            if(this.mEgl == null) {
                throw new RuntimeException("egl not initialized");
            } else if(this.mEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if(this.mEglConfig == null) {
                throw new RuntimeException("mEglConfig not initialized");
            } else {
                this.destroySurfaceImp();
                GvrSurfaceView var1;
                if((var1 = (GvrSurfaceView)this.mGvrSurfaceViewWeakRef.get()) != null) {
                    this.mEglSurface = var1.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, var1.getHolder());
                } else {
                    this.mEglSurface = null;
                }

                if(this.mEglSurface != null && this.mEglSurface != EGL10.EGL_NO_SURFACE) {
                    if(!this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext)) {
                        logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    if(this.mEgl.eglGetError() == 12299) {
                        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }

                    return false;
                }
            }
        }

        GL createGL() {
            GL var1 = this.mEglContext.getGL();
            GvrSurfaceView var2;
            if((var2 = (GvrSurfaceView)this.mGvrSurfaceViewWeakRef.get()) != null) {
                if(var2.mGLWrapper != null) {
                    var1 = var2.mGLWrapper.wrap(var1);
                }

                if((var2.mDebugFlags & 3) != 0) {
                    byte var3 = 0;
                    GvrSurfaceView.LogWriter var4 = null;
                    if((var2.mDebugFlags & 1) != 0) {
                        var3 = 1;
                    }

                    if((var2.mDebugFlags & 2) != 0) {
                        var4 = new GvrSurfaceView.LogWriter();
                    }

                    var1 = GLDebugHelper.wrap(var1, var3, var4);
                }
            }

            return var1;
        }

        public int swap() {
            return !this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)?this.mEgl.eglGetError():12288;
        }

        public void destroySurface() {
            this.destroySurfaceImp();
        }

        public void setEglSurfaceAttrib(int var1, int var2) {
            if(VERSION.SDK_INT < 17) {
                Log.e("EglHelper", "Cannot call eglSurfaceAttrib. API version is too low.");
            } else {
                android.opengl.EGLDisplay var3 = EGL14.eglGetCurrentDisplay();
                android.opengl.EGLSurface var4 = EGL14.eglGetCurrentSurface(12377);
                if(!EGL14.eglSurfaceAttrib(var3, var4, var1, var2)) {
                    Log.e("EglHelper", (new StringBuilder(66)).append("eglSurfaceAttrib() failed. attribute=").append(var1).append(" value=").append(var2).toString());
                }

            }
        }

        private void destroySurfaceImp() {
            if(this.mEglSurface != null && this.mEglSurface != EGL10.EGL_NO_SURFACE) {
                this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                GvrSurfaceView var1;
                if((var1 = (GvrSurfaceView)this.mGvrSurfaceViewWeakRef.get()) != null) {
                    var1.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
                }

                this.mEglSurface = null;
            }

        }

        public void finish() {
            if(this.mEglContext != null) {
                GvrSurfaceView var1;
                if((var1 = (GvrSurfaceView)this.mGvrSurfaceViewWeakRef.get()) != null) {
                    var1.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }

                this.mEglContext = null;
            }

            if(this.mEglDisplay != null) {
                this.mEgl.eglTerminate(this.mEglDisplay);
                this.mEglDisplay = null;
            }

        }

        private void throwEglException(String var1) {
            throwEglException(var1, this.mEgl.eglGetError());
        }

        public static void throwEglException(String var0, int var1) {
            String var2 = formatEglError(var0, var1);
            throw new RuntimeException(var2);
        }

        public static void logEglErrorAsWarning(String var0, String var1, int var2) {
            Log.w(var0, formatEglError(var1, var2));
        }

        public static String formatEglError(String var0, int var1) {
            String var2 = String.valueOf(getErrorString(var1));
            return (new StringBuilder(9 + String.valueOf(var0).length() + String.valueOf(var2).length())).append(var0).append(" failed: ").append(var2).toString();
        }

        private static String getHex(int var0) {
            String var10001 = String.valueOf(Integer.toHexString(var0));
            return var10001.length() != 0?"0x".concat(var10001):new String("0x");
        }

        private static String getErrorString(int var0) {
            switch(var0) {
                case 12288:
                    return "EGL_SUCCESS";
                case 12289:
                    return "EGL_NOT_INITIALIZED";
                case 12290:
                    return "EGL_BAD_ACCESS";
                case 12291:
                    return "EGL_BAD_ALLOC";
                case 12292:
                    return "EGL_BAD_ATTRIBUTE";
                case 12293:
                    return "EGL_BAD_CONFIG";
                case 12294:
                    return "EGL_BAD_CONTEXT";
                case 12295:
                    return "EGL_BAD_CURRENT_SURFACE";
                case 12296:
                    return "EGL_BAD_DISPLAY";
                case 12297:
                    return "EGL_BAD_MATCH";
                case 12298:
                    return "EGL_BAD_NATIVE_PIXMAP";
                case 12299:
                    return "EGL_BAD_NATIVE_WINDOW";
                case 12300:
                    return "EGL_BAD_PARAMETER";
                case 12301:
                    return "EGL_BAD_SURFACE";
                case 12302:
                    return "EGL_CONTEXT_LOST";
                default:
                    return getHex(var0);
            }
        }
    }

    private class SimpleEGLConfigChooser extends GvrSurfaceView.ComponentSizeChooser {
        public SimpleEGLConfigChooser(boolean var2) {
            super(8, 8, 8, 0, var2?16:0, 0);
        }
    }

    private class ComponentSizeChooser extends GvrSurfaceView.BaseConfigChooser {
        private int[] mValue = new int[1];
        protected int mRedSize;
        protected int mGreenSize;
        protected int mBlueSize;
        protected int mAlphaSize;
        protected int mDepthSize;
        protected int mStencilSize;

        public ComponentSizeChooser(int var2, int var3, int var4, int var5, int var6, int var7) {
            super(new int[]{12324, var2, 12323, var3, 12322, var4, 12321, var5, 12325, var6, 12326, var7, 12344});
            this.mRedSize = var2;
            this.mGreenSize = var3;
            this.mBlueSize = var4;
            this.mAlphaSize = var5;
            this.mDepthSize = var6;
            this.mStencilSize = var7;
        }

        public EGLConfig chooseConfig(EGL10 var1, EGLDisplay var2, EGLConfig[] var3) {
            EGLConfig[] var4 = var3;
            int var5 = var3.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                EGLConfig var7 = var4[var6];
                int var8 = this.findConfigAttrib(var1, var2, var7, 12325, 0);
                int var9 = this.findConfigAttrib(var1, var2, var7, 12326, 0);
                if(var8 >= this.mDepthSize && var9 >= this.mStencilSize) {
                    int var10 = this.findConfigAttrib(var1, var2, var7, 12324, 0);
                    int var11 = this.findConfigAttrib(var1, var2, var7, 12323, 0);
                    int var12 = this.findConfigAttrib(var1, var2, var7, 12322, 0);
                    int var13 = this.findConfigAttrib(var1, var2, var7, 12321, 0);
                    if(var10 == this.mRedSize && var11 == this.mGreenSize && var12 == this.mBlueSize && var13 == this.mAlphaSize) {
                        return var7;
                    }
                }
            }

            return null;
        }

        private int findConfigAttrib(EGL10 var1, EGLDisplay var2, EGLConfig var3, int var4, int var5) {
            return var1.eglGetConfigAttrib(var2, var3, var4, this.mValue)?this.mValue[0]:var5;
        }
    }

    private abstract class BaseConfigChooser implements EGLConfigChooser {
        protected int[] mConfigSpec;

        public BaseConfigChooser(int[] var2) {
            this.mConfigSpec = this.filterConfigSpec(var2);
        }

        public EGLConfig chooseConfig(EGL10 var1, EGLDisplay var2) {
            int[] var3 = new int[1];
            int var4;
            if(!var1.eglChooseConfig(var2, this.mConfigSpec, (EGLConfig[])null, 0, var3)) {
                for(var4 = 1; var4 < this.mConfigSpec.length; ++var4) {
                    if(this.mConfigSpec[var4 - 1] == 12352 && this.mConfigSpec[var4] == 64) {
                        Log.w("GvrSurfaceView", "Failed to choose GLES 3 config, will try 2.");
                        this.mConfigSpec[var4] = 4;
                        return this.chooseConfig(var1, var2);
                    }
                }

                throw new IllegalArgumentException("eglChooseConfig failed");
            } else if((var4 = var3[0]) <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            } else {
                EGLConfig[] var5 = new EGLConfig[var4];
                if(!var1.eglChooseConfig(var2, this.mConfigSpec, var5, var4, var3)) {
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                } else {
                    EGLConfig var6;
                    if((var6 = this.chooseConfig(var1, var2, var5)) == null) {
                        throw new IllegalArgumentException("No config chosen");
                    } else {
                        return var6;
                    }
                }
            }
        }

        abstract EGLConfig chooseConfig(EGL10 var1, EGLDisplay var2, EGLConfig[] var3);

        private int[] filterConfigSpec(int[] var1) {
            if(GvrSurfaceView.this.mEGLContextClientVersion != 2 && GvrSurfaceView.this.mEGLContextClientVersion != 3) {
                return var1;
            } else {
                int var2;
                int[] var3 = new int[(var2 = var1.length) + 2];
                System.arraycopy(var1, 0, var3, 0, var2 - 1);
                var3[var2 - 1] = 12352;
                if(GvrSurfaceView.this.mEGLContextClientVersion == 2) {
                    var3[var2] = 4;
                } else {
                    var3[var2] = 64;
                }

                var3[var2 + 1] = 12344;
                return var3;
            }
        }
    }

    private static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        public EGLSurface createWindowSurface(EGL10 var1, EGLDisplay var2, EGLConfig var3, Object var4) {
            EGLSurface var5 = null;

            try {
                var5 = var1.eglCreateWindowSurface(var2, var3, var4, (int[])null);
            } catch (IllegalArgumentException var7) {
                Log.e("GvrSurfaceView", "eglCreateWindowSurface", var7);
            }

            return var5;
        }

        public void destroySurface(EGL10 var1, EGLDisplay var2, EGLSurface var3) {
            var1.eglDestroySurface(var2, var3);
        }
    }

    private class DefaultContextFactory implements EGLContextFactory {
        private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;

        private DefaultContextFactory() {
        }

        public EGLContext createContext(EGL10 var1, EGLDisplay var2, EGLConfig var3) {
            int[] var4 = new int[]{12440, GvrSurfaceView.this.mEGLContextClientVersion, 12344};
            return var1.eglCreateContext(var2, var3, EGL10.EGL_NO_CONTEXT, GvrSurfaceView.this.mEGLContextClientVersion != 0?var4:null);
        }

        public void destroyContext(EGL10 var1, EGLDisplay var2, EGLContext var3) {
            if(!var1.eglDestroyContext(var2, var3)) {
                String var4 = String.valueOf(var2);
                String var5 = String.valueOf(var3);
                Log.e("DefaultContextFactory", (new StringBuilder(18 + String.valueOf(var4).length() + String.valueOf(var5).length())).append("display:").append(var4).append(" context: ").append(var5).toString());
                GvrSurfaceView.EglHelper.throwEglException("eglDestroyContex", var1.eglGetError());
            }

        }
    }

    public interface GLWrapper {
        GL wrap(GL var1);
    }
}
