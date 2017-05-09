//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.cardboard;

import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import com.google.vr.cardboard.EglFactory;
import com.google.vr.ndk.base.GvrSurfaceView;
import java.util.ArrayList;
import com.google.vr.cardboard.VrParamsProviderJni;

public class CardboardGLSurfaceView extends GvrSurfaceView {
    private static final String TAG = CardboardGLSurfaceView.class.getSimpleName();
    private final CardboardGLSurfaceView.DetachListener listener;
    private boolean isRendererSet;
    private boolean isDetached;
    private ArrayList<Runnable> eventQueueWhileDetached;
    private final EglFactory eglFactory;

    public CardboardGLSurfaceView(Context var1, CardboardGLSurfaceView.DetachListener var2) {
        super(var1);
        this.listener = var2;
        this.eglFactory = new EglFactory();
        this.setEGLContextFactory(this.eglFactory);
        this.setEGLWindowSurfaceFactory(this.eglFactory);
    }

    public CardboardGLSurfaceView(Context var1, AttributeSet var2, CardboardGLSurfaceView.DetachListener var3) {
        super(var1, var2);
        this.listener = var3;
        this.eglFactory = new EglFactory();
        this.setEGLContextFactory(this.eglFactory);
        this.setEGLWindowSurfaceFactory(this.eglFactory);
    }

    public void onPause() {
        if(this.isRendererSet) {
            super.onPause();
        }

    }

    public void onResume() {
        if(this.isRendererSet) {
            super.onResume();
        }

    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isDetached = false;
        if(this.eventQueueWhileDetached != null) {
            ArrayList var3;
            int var4 = (var3 = (ArrayList)this.eventQueueWhileDetached).size();
            int var5 = 0;
            Object var1 = null;

            while(var5 < var4) {
                Object var10000 = var3.get(var5);
                ++var5;
                Runnable var2 = (Runnable)var10000;
                super.queueEvent(var2);
            }

            this.eventQueueWhileDetached.clear();
        }

    }

    protected void onDetachedFromWindow() {
        if(this.isRendererSet && this.listener != null) {
            this.listener.onSurfaceViewDetachedFromWindow();
        }

        super.onDetachedFromWindow();
        this.isDetached = true;
    }

    public void setRenderer(Renderer var1) {
        super.setRenderer(var1);
        this.isRendererSet = true;
    }

    public void setEGLContextClientVersion(int var1) {
        super.setEGLContextClientVersion(var1);
        this.eglFactory.setEGLContextClientVersion(var1);
    }

    public void queueEvent(Runnable var1) {
        if(!this.isRendererSet) {
            var1.run();
        } else if(this.isDetached) {
            if(this.eventQueueWhileDetached == null) {
                this.eventQueueWhileDetached = new ArrayList();
            }

            this.eventQueueWhileDetached.add(var1);
        } else {
            super.queueEvent(var1);
        }
    }

    public boolean isDetached() {
        return this.isDetached;
    }

    public interface DetachListener {
        void onSurfaceViewDetachedFromWindow();
    }
}
