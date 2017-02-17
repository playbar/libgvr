//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.cardboard;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.performance.api.IPerformanceService;
import com.google.vr.vrcore.performance.api.IPerformanceService.Stub;

public class PerfMonitor implements AutoCloseable {
    private static final int STATUS_DISCONNECTED = 0;
    private static final int STATUS_CONNECTING = 1;
    private static final int STATUS_CONNECTED = 2;
    private final Object lock = new Object();
    private final Context context;
    private IPerformanceService perfService;
    private int status = 1;
    private final ServiceConnection connection = new ServiceConnection() {
        public void onServiceConnected(ComponentName var1, IBinder var2) {
            synchronized(PerfMonitor.this.lock) {
                PerfMonitor.this.perfService = Stub.asInterface(var2);
                PerfMonitor.this.status = 2;
                PerfMonitor.this.lock.notifyAll();
            }
        }

        public void onServiceDisconnected(ComponentName var1) {
            synchronized(PerfMonitor.this.lock) {
                PerfMonitor.this.perfService = null;
                PerfMonitor.this.status = 0;
                PerfMonitor.this.lock.notifyAll();
            }
        }
    };

    protected PerfMonitor(Context var1) {
        this.context = var1;
    }

    public static PerfMonitor build(Context var0) {
        Intent var1;
        (var1 = new Intent("com.google.vr.vrcore.performance.BIND")).setPackage("com.google.vr.vrcore");
        PerfMonitor var2 = new PerfMonitor(var0);
        return !var0.bindService(var1, var2.connection, 1)?null:var2;
    }

    public void waitUntilReady(long var1) throws IllegalStateException, InterruptedException {
        if(Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("waitUntilReady cannot be called from the UI thread");
        } else {
            Object var3 = this.lock;
            synchronized(this.lock) {
                long var4;
                for(long var6 = (var4 = System.currentTimeMillis()) + var1; this.status == 1 && var4 < var6; var4 = System.currentTimeMillis()) {
                    this.lock.wait(var6 - var4);
                }

            }
        }
    }

    public boolean isReady() {
        Object var1 = this.lock;
        synchronized(this.lock) {
            return this.status == 2;
        }
    }

    public float queryRelativeTemperature() throws VrCoreNotAvailableException {
        Object var2 = this.lock;
        IPerformanceService var1;
        synchronized(this.lock) {
            var1 = this.perfService;
        }

        if(var1 == null) {
            throw new VrCoreNotAvailableException(5);
        } else {
            try {
                return var1.getCurrentThrottlingRelativeTemperature();
            } catch (RemoteException var4) {
                throw new VrCoreNotAvailableException(8);
            } catch (SecurityException var5) {
                throw new VrCoreNotAvailableException(6);
            } catch (UnsupportedOperationException var6) {
                throw new VrCoreNotAvailableException(7);
            }
        }
    }

    public void reportFrameDrops(long var1, long var3, int var5) throws VrCoreNotAvailableException {
        Object var7 = this.lock;
        IPerformanceService var6;
        synchronized(this.lock) {
            var6 = this.perfService;
        }

        if(var6 == null) {
            throw new VrCoreNotAvailableException(5);
        } else {
            try {
                var6.reportFrameDrops(var1, var3, var5);
            } catch (RemoteException var9) {
                throw new VrCoreNotAvailableException(8);
            }
        }
    }

    public void close() {
        this.context.unbindService(this.connection);
    }
}
