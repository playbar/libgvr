//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.ndk.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.vr.vrcore.performance.api.IPerformanceService;
import com.google.vr.vrcore.performance.api.TimestampedTemperature;
import com.google.vr.vrcore.performance.api.IPerformanceService.Stub;
import java.util.ArrayList;

public class ThrottlingMonitor implements AutoCloseable {
    private static final String TAG = "ThrottlingMonitor";
    public static final int SUCCESS = 0;
    public static final int ERROR_NOT_SUPPORTED = -1;
    public static final int ERROR_NO_PERMISSION = -2;
    public static final int ERROR_NOT_CONNECTED = -3;
    public static final int ERROR_NOT_ACCURATE = -4;
    public static final int ERROR_UNKNOWN = -5;
    private final Object lock = new Object();
    private final Context context;
    private final Handler mainHandler;
    private IPerformanceService perfService;
    private final ArrayList<ThrottlingMonitor.SetupCallback> setupCallbacks = new ArrayList();
    private final ServiceConnection connection = new ServiceConnection() {
        public void onServiceConnected(ComponentName var1, IBinder var2) {
            ArrayList var3 = new ArrayList();
            synchronized(ThrottlingMonitor.this.lock) {
                ThrottlingMonitor.this.perfService = Stub.asInterface(var2);
                var3.addAll(ThrottlingMonitor.this.setupCallbacks);
                ThrottlingMonitor.this.setupCallbacks.clear();
                ThrottlingMonitor.this.lock.notifyAll();
            }

            ArrayList var6;
            int var7 = (var6 = (ArrayList)var3).size();
            int var8 = 0;
            Object var4 = null;

            while(var8 < var7) {
                Object var10000 = var6.get(var8);
                ++var8;
                ((ThrottlingMonitor.SetupCallback)var10000).onInitialized();
            }

        }

        public void onServiceDisconnected(ComponentName var1) {
            synchronized(ThrottlingMonitor.this.lock) {
                ThrottlingMonitor.this.perfService = null;
                ThrottlingMonitor.this.lock.notifyAll();
            }
        }
    };

    private ThrottlingMonitor(Context var1) {
        this.context = var1;
        this.mainHandler = new Handler(var1.getMainLooper());
    }

    public static ThrottlingMonitor create(Context var0) {
        Intent var1;
        (var1 = new Intent("com.google.vr.vrcore.performance.service.BIND")).setPackage("com.google.vr.vrcore");
        ThrottlingMonitor var2 = new ThrottlingMonitor(var0);
//        return !var0.bindService(var1, var2.connection, 1)?null:var2;
        return var2;
    }

    public void registerSetupCallback(final ThrottlingMonitor.SetupCallback var1) {
        Object var2 = this.lock;
        synchronized(this.lock) {
            if(this.perfService != null) {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        var1.onInitialized();
                    }
                });
            } else {
                this.setupCallbacks.add(var1);
            }
        }
    }

    public int queryRelativeTemperature(TimestampedTemperature var1) {
        Object var3 = this.lock;
        IPerformanceService var2;
        synchronized(this.lock) {
            var2 = this.perfService;
        }

        if(var2 == null) {
            return -3;
        } else {
            try {
                var2.getCurrentThrottlingRelativeTemperature(var1);
            } catch (RemoteException var5) {
                String var4 = String.valueOf(var5);
                Log.e("ThrottlingMonitor", (new StringBuilder(29 + String.valueOf(var4).length())).append("Service failed unexpectedly: ").append(var4).toString());
                return -5;
            } catch (SecurityException var6) {
                return -2;
            } catch (UnsupportedOperationException var7) {
                Log.w("ThrottlingMonitor", "Throttling monitoring not supported on this device.");
                return -1;
            }

            return var1.temperature == 1.4E-45F?-4:0;
        }
    }

    public int addTrigger(ComponentName var1, float var2, ThrottlingMonitor.TemperatureTrigger var3, long var4, Handler var6) {
        return this.addTriggerInternal(var1, 3, var2, var3, var4, var6);
    }

    public int addTrigger(ComponentName var1, ThrottlingMonitor.TemperatureTrigger var2, long var3, Handler var5) {
        return this.addTriggerInternal(var1, 1, 0.0F, var2, var3, var5);
    }

    public int addTrigger(ComponentName var1, float var2, ThrottlingMonitor.TemperatureTrigger var3, Handler var4) {
        return this.addTriggerInternal(var1, 2, var2, var3, 0L, var4);
    }

    public int removeAllTriggers(ComponentName var1) {
        Object var3 = this.lock;
        IPerformanceService var2;
        synchronized(this.lock) {
            var2 = this.perfService;
        }

        if(var2 == null) {
            return -3;
        } else {
            try {
                var2.removeAllTriggers(var1);
                return 0;
            } catch (RemoteException var5) {
                String var4 = String.valueOf(var5);
                Log.e("ThrottlingMonitor", (new StringBuilder(29 + String.valueOf(var4).length())).append("Service failed unexpectedly: ").append(var4).toString());
                return -5;
            } catch (SecurityException var6) {
                return -2;
            } catch (UnsupportedOperationException var7) {
                Log.w("ThrottlingMonitor", "Throttling monitoring not supported on this device.");
                return -1;
            }
        }
    }

    public long getEstimatedThrottlingTimeNanos() {
        Object var2 = this.lock;
        IPerformanceService var1;
        synchronized(this.lock) {
            var1 = this.perfService;
        }

        if(var1 == null) {
            return -3L;
        } else {
            long var10;
            try {
                var10 = var1.getCurrentEstimatedThrottleWarningTime();
            } catch (RemoteException var6) {
                String var5 = String.valueOf(var6);
                Log.e("ThrottlingMonitor", (new StringBuilder(29 + String.valueOf(var5).length())).append("Service failed unexpectedly: ").append(var5).toString());
                return -5L;
            } catch (SecurityException var7) {
                return -2L;
            } catch (UnsupportedOperationException var8) {
                Log.w("ThrottlingMonitor", "Throttling monitoring not supported on this device.");
                return -1L;
            }

            return var10 < 0L?-4L:var10;
        }
    }

    public void close() {
        this.context.unbindService(this.connection);
    }

    private int addTriggerInternal(ComponentName var1, int var2, float var3, ThrottlingMonitor.TemperatureTrigger var4, long var5, Handler var7) {
        if(var4 == null) {
            throw new IllegalArgumentException("Argument 'trigger' cannot be null.");
        } else {
            Object var9 = this.lock;
            IPerformanceService var8;
            synchronized(this.lock) {
                var8 = this.perfService;
            }

            if(var8 == null) {
                return -3;
            } else {
                ThrottlingMonitor.ThrottlingTriggerCallback var16 = new ThrottlingMonitor.ThrottlingTriggerCallback(var4, var7);

                try {
                    var8.addTrigger(var1, var16, var5, var3, var2);
                    return 0;
                } catch (RemoteException var12) {
                    String var11 = String.valueOf(var12);
                    Log.e("ThrottlingMonitor", (new StringBuilder(29 + String.valueOf(var11).length())).append("Service failed unexpectedly: ").append(var11).toString());
                    return -5;
                } catch (SecurityException var13) {
                    return -2;
                } catch (UnsupportedOperationException var14) {
                    Log.w("ThrottlingMonitor", "Throttling monitoring not supported on this device.");
                    return -1;
                }
            }
        }
    }

    public interface TemperatureTrigger {
        void onTemperatureEvent(float var1, long var2);
    }

    public interface SetupCallback {
        void onInitialized();
    }

    static class ThrottlingTriggerCallback extends com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback.Stub {
        private final ThrottlingMonitor.TemperatureTrigger trigger;
        private final Handler handler;

        public ThrottlingTriggerCallback(ThrottlingMonitor.TemperatureTrigger var1, Handler var2) {
            this.trigger = var1;
            this.handler = var2;
        }

        public void onTriggerActivated(final float var1, final long var2) {
            if(this.handler == null) {
                this.trigger.onTemperatureEvent(var1, var2);
            } else {
                this.handler.post(new Runnable() {
                    public void run() {
                        ThrottlingTriggerCallback.this.trigger.onTemperatureEvent(var1, var2);
                    }
                });
            }
        }
    }
}
