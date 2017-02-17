//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.cardboard;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Display;
import android.view.Choreographer.FrameCallback;
import com.google.vr.cardboard.FrameMonitor;
import java.util.concurrent.TimeUnit;

public class DisplaySynchronizer implements FrameCallback {
    private static final String TAG = "DisplaySynchronizer";
    private static final boolean DEBUG = false;
    private static final float MIN_VALID_DISPLAY_REFRESH_RATE = 30.0F;
    public static final long DISPLAY_ROTATION_REFRESH_INTERVAL_NANOS;
    private static final int INVALID_DISPLAY_ROTATION = -1;
    private long nativeDisplaySynchronizer;
    private final FrameMonitor frameMonitor;
    private volatile Display display;
    private int displayRotationDegrees = -1;
    private long lastDisplayRotationUpdateTimeNanos = 0L;

    public DisplaySynchronizer(Context var1, Display var2) {
        this.nativeDisplaySynchronizer = this.nativeCreate(this.getClass().getClassLoader(), var1.getApplicationContext());
        if(this.nativeDisplaySynchronizer == 0L) {
            throw new IllegalStateException("Native DisplaySynchronizer creation failed.");
        } else {
            this.setDisplay(var2);
            this.frameMonitor = new FrameMonitor(this);
        }
    }

    public void setDisplay(Display var1) {
        this.checkNativeDisplaySynchronizer();
        this.display = var1;
        this.invalidateDisplayRotation();
        float var2;
        long var3 = (var2 = var1.getRefreshRate()) >= 30.0F?(long)((float)TimeUnit.SECONDS.toNanos(1L) / var2):0L;
        long var5 = 0L;
        if(VERSION.SDK_INT >= 21) {
            var5 = var1.getAppVsyncOffsetNanos();
        }

        this.nativeReset(this.nativeDisplaySynchronizer, var3, var5);
    }

    public Display getDisplay() {
        return this.display;
    }

    protected void finalize() throws Throwable {
        try {
            if(this.nativeDisplaySynchronizer != 0L) {
                Log.w("DisplaySynchronizer", "DisplaySynchronizer.shutdown() should be called to ensure resource cleanup");
                this.nativeDestroy(this.nativeDisplaySynchronizer);
            }
        } finally {
            super.finalize();
        }

    }

    public void onPause() {
        this.frameMonitor.onPause();
    }

    public void onResume() {
        this.invalidateDisplayRotation();
        this.frameMonitor.onResume();
    }

    public void onConfigurationChanged() {
        this.invalidateDisplayRotation();
    }

    public void shutdown() {
        if(this.nativeDisplaySynchronizer != 0L) {
            this.onPause();
            this.nativeDestroy(this.nativeDisplaySynchronizer);
            this.nativeDisplaySynchronizer = 0L;
        }

    }

    public long getNativeDisplaySynchronizer() {
        this.checkNativeDisplaySynchronizer();
        return this.nativeDisplaySynchronizer;
    }

    public void doFrame(long var1) {
        this.checkNativeDisplaySynchronizer();
        if(this.displayRotationDegrees == -1 || var1 - this.lastDisplayRotationUpdateTimeNanos > DISPLAY_ROTATION_REFRESH_INTERVAL_NANOS) {
            switch(this.display.getRotation()) {
                case 0:
                    this.displayRotationDegrees = 0;
                    break;
                case 1:
                    this.displayRotationDegrees = 90;
                    break;
                case 2:
                    this.displayRotationDegrees = 180;
                    break;
                case 3:
                    this.displayRotationDegrees = 270;
                    break;
                default:
                    Log.e("DisplaySynchronizer", "Unknown display rotation, defaulting to 0");
                    this.displayRotationDegrees = 0;
            }

            this.lastDisplayRotationUpdateTimeNanos = var1;
        }

        this.nativeUpdate(this.nativeDisplaySynchronizer, var1, this.displayRotationDegrees);
    }

    private void checkNativeDisplaySynchronizer() {
        if(this.nativeDisplaySynchronizer == 0L) {
            throw new IllegalStateException("DisplaySynchronizer has already been shut down.");
        }
    }

    private void invalidateDisplayRotation() {
        this.displayRotationDegrees = -1;
    }

    protected native long nativeCreate(ClassLoader var1, Context var2);

    protected native void nativeDestroy(long var1);

    protected native void nativeReset(long var1, long var3, long var5);

    protected native void nativeUpdate(long var1, long var3, int var5);

    static {
        DISPLAY_ROTATION_REFRESH_INTERVAL_NANOS = TimeUnit.SECONDS.toNanos(1L);
    }
}
