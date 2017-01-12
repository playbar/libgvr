//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.internal.controller;

import com.google.vr.cardboard.annotations.UsedByNative;
import com.google.vr.internal.controller.ServiceBridge.Callbacks;
import com.google.vr.vrcore.controller.api.ControllerAccelEvent;
import com.google.vr.vrcore.controller.api.ControllerButtonEvent;
import com.google.vr.vrcore.controller.api.ControllerEventPacket;
import com.google.vr.vrcore.controller.api.ControllerGyroEvent;
import com.google.vr.vrcore.controller.api.ControllerOrientationEvent;
import com.google.vr.vrcore.controller.api.ControllerTouchEvent;

@UsedByNative
public final class NativeCallbacks implements Callbacks {
    private final long userData;
    private boolean closed;

    @UsedByNative
    public NativeCallbacks(long var1) {
        this.userData = var1;
    }

    @UsedByNative
    public final synchronized void close() {
        this.closed = true;
    }

    public final synchronized void onControllerStateChanged(int var1, int var2) {
        if(!this.closed) {
            this.handleStateChanged(this.userData, var1, var2);
        }

    }

    public final synchronized void onControllerEventPacket(ControllerEventPacket var1) {
        if(!this.closed) {
            int var2;
            for(var2 = 0; !this.closed && var2 < var1.getAccelEventCount(); ++var2) {
                ControllerAccelEvent var3 = var1.getAccelEvent(var2);
                this.handleAccelEvent(this.userData, var3.timestampNanos, var3.x, var3.y, var3.z);
            }

            for(var2 = 0; !this.closed && var2 < var1.getButtonEventCount(); ++var2) {
                ControllerButtonEvent var4 = var1.getButtonEvent(var2);
                this.handleButtonEvent(this.userData, var4.timestampNanos, var4.button, var4.down);
            }

            for(var2 = 0; !this.closed && var2 < var1.getGyroEventCount(); ++var2) {
                ControllerGyroEvent var5 = var1.getGyroEvent(var2);
                this.handleGyroEvent(this.userData, var5.timestampNanos, var5.x, var5.y, var5.z);
            }

            for(var2 = 0; !this.closed && var2 < var1.getOrientationEventCount(); ++var2) {
                ControllerOrientationEvent var6 = var1.getOrientationEvent(var2);
                this.handleOrientationEvent(this.userData, var6.timestampNanos, var6.qx, var6.qy, var6.qz, var6.qw);
            }

            for(var2 = 0; !this.closed && var2 < var1.getTouchEventCount(); ++var2) {
                ControllerTouchEvent var7 = var1.getTouchEvent(var2);
                this.handleTouchEvent(this.userData, var7.timestampNanos, var7.action, var7.x, var7.y);
            }

        }
    }

    public final synchronized void onControllerRecentered(ControllerOrientationEvent var1) {
        if(!this.closed) {
            this.handleControllerRecentered(this.userData, var1.timestampNanos, var1.qx, var1.qy, var1.qz, var1.qw);
        }

    }

    public final synchronized void onServiceConnected(int var1) {
        if(!this.closed) {
            this.handleServiceConnected(this.userData, var1);
        }

    }

    public final synchronized void onServiceDisconnected() {
        if(!this.closed) {
            this.handleServiceDisconnected(this.userData);
        }

    }

    public final synchronized void onServiceFailed() {
        if(!this.closed) {
            this.handleServiceFailed(this.userData);
        }

    }

    public final synchronized void onServiceUnavailable() {
        if(!this.closed) {
            this.handleServiceUnavailable(this.userData);
        }

    }

    public final synchronized void onServiceInitFailed(int var1) {
        if(!this.closed) {
            this.handleServiceInitFailed(this.userData, var1);
        }

    }

    private final native void handleStateChanged(long var1, int var3, int var4);

    private final native void handleControllerRecentered(long var1, long var3, float var5, float var6, float var7, float var8);

    private final native void handleTouchEvent(long var1, long var3, int var5, float var6, float var7);

    private final native void handleOrientationEvent(long var1, long var3, float var5, float var6, float var7, float var8);

    private final native void handleButtonEvent(long var1, long var3, int var5, boolean var6);

    private final native void handleAccelEvent(long var1, long var3, float var5, float var6, float var7);

    private final native void handleGyroEvent(long var1, long var3, float var5, float var6, float var7);

    private final native void handleServiceInitFailed(long var1, int var3);

    private final native void handleServiceFailed(long var1);

    private final native void handleServiceUnavailable(long var1);

    private final native void handleServiceConnected(long var1, int var3);

    private final native void handleServiceDisconnected(long var1);
}
