//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.cardboard;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.google.vr.cardboard.ThreadUtils;

public class FrameMonitor implements FrameCallback {
    private final Choreographer choreographer;
    private final FrameCallback callback;
    private boolean isPaused;

    public FrameMonitor(FrameCallback var1) {
        this(Choreographer.getInstance(), var1);
    }

    public FrameMonitor(Choreographer var1, FrameCallback var2) {
        ThreadUtils.assertOnUiThread();
        this.callback = var2;
        this.choreographer = var1;
        var1.postFrameCallback(this);
    }

    public void onPause() {
        if(!this.isPaused) {
            this.choreographer.removeFrameCallback(this);
            this.isPaused = true;
        }
    }

    public void onResume() {
        if(this.isPaused) {
            this.isPaused = false;
            this.choreographer.postFrameCallback(this);
        }
    }

    public void doFrame(long var1) {
        this.choreographer.postFrameCallback(this);
        this.callback.doFrame(var1);
    }
}
