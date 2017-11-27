//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.internal.controller;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.google.vr.cardboard.annotations.UsedByNative;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;
import com.google.vr.vrcore.controller.api.ControllerEventPacket;
import com.google.vr.vrcore.controller.api.ControllerEventPacket2;
import com.google.vr.vrcore.controller.api.ControllerInitResults;
import com.google.vr.vrcore.controller.api.ControllerListenerOptions;
import com.google.vr.vrcore.controller.api.ControllerOrientationEvent;
import com.google.vr.vrcore.controller.api.IControllerService;
import com.google.vr.vrcore.controller.api.IControllerService.Stub;
import java.lang.ref.WeakReference;

@UsedByNative
public class ControllerServiceBridge implements ServiceConnection {
    static final String TAG = ControllerServiceBridge.class.getSimpleName();
    private static final boolean DEBUG = false;
    public static final int TARGET_SERVICE_API_VERSION = 21;
    static final int MIN_API_VERSION_FOR_SERVICE_CALLBACKS = 21;
    static final String LISTENER_KEY = "com.google.vr.internal.controller.LISTENER_KEY";
    public static final int FLAG_SUPPORTS_RECENTER = 1;
    private final Context context;
    private final Handler mainThreadHandler;
    private final int vrcoreApiVersion;
    private IControllerService service;
    private ControllerServiceBridge.LocalControllerListener defaultListener;
    private final ControllerServiceBridge.ControllerServiceListener defaultServiceListener;
    private final SparseArray<ControllerServiceBridge.LocalControllerListener> controllerListenerMap = new SparseArray();
    private boolean isBound;

    @UsedByNative
    public ControllerServiceBridge(Context var1, ControllerServiceBridge.Callbacks var2, int var3) {
        this.context = var1.getApplicationContext();
        this.initializeDefaultListener(var2, new ControllerListenerOptions(var3));
        this.mainThreadHandler = new Handler(Looper.getMainLooper());
        this.defaultServiceListener = new ControllerServiceBridge.ControllerServiceListener(this);
        this.vrcoreApiVersion = getVrCoreApiVersion(var1);
    }

    public ControllerServiceBridge(Context var1, ControllerServiceBridge.Callbacks var2) {
        this.context = var1.getApplicationContext();
        this.initializeDefaultListener(var2, new ControllerListenerOptions());
        this.mainThreadHandler = new Handler(Looper.getMainLooper());
        this.defaultServiceListener = new ControllerServiceBridge.ControllerServiceListener(this);
        this.vrcoreApiVersion = getVrCoreApiVersion(var1);
    }

    @UsedByNative
    public void requestBind() {
//        this.mainThreadHandler.post(new ControllerServiceBridge$$Lambda$0(this));
    }

    @UsedByNative
    public void requestUnbind() {
//        this.mainThreadHandler.post(new ControllerServiceBridge$$Lambda$1(this));
    }

    public void doBind() {
        this.ensureOnMainThread();
        if(this.isBound) {
            Log.w(TAG, "Service is already bound.");
        } else {
            Intent var1;
            (var1 = new Intent("com.google.vr.vrcore.controller.BIND")).setPackage("com.google.vr.vrcore");
            if(!this.context.bindService(var1, this, 1)) {
                Log.w(TAG, "Bind failed. Service is not available.");
                this.defaultListener.callbacks.onServiceUnavailable();
            } else {
                this.isBound = true;
            }
        }
    }

    public void doUnbind() {
        this.ensureOnMainThread();
        if(!this.isBound) {
            Log.w(TAG, "Service is already unbound.");
        } else {
            this.unregisterListener();
            if(this.vrcoreApiVersion >= 21) {
                try {
                    if(this.service != null && !this.service.unregisterServiceListener(this.defaultServiceListener)) {
                        Log.w(TAG, "Failed to unregister remote service listener.");
                    }
                } catch (RemoteException var3) {
                    String var10000 = TAG;
                    String var2 = String.valueOf(var3);
                    Log.w(var10000, (new StringBuilder(55 + String.valueOf(var2).length())).append("Exception while unregistering remote service listener: ").append(var2).toString());
                }
            }

            this.context.unbindService(this);
            this.service = null;
            this.isBound = false;
        }
    }

    public ControllerServiceBridge.Callbacks getControllerCallbacks(int var1) {
        this.ensureOnMainThread();
        ControllerServiceBridge.LocalControllerListener var2;
        return (var2 = (ControllerServiceBridge.LocalControllerListener)this.controllerListenerMap.get(var1)) == null?null:var2.callbacks;
    }

    public void clearControllers() {
        this.ensureOnMainThread();
        this.controllerListenerMap.clear();
    }

    @UsedByNative
    public boolean createAndConnectController(int var1, ControllerServiceBridge.Callbacks var2, int var3) throws RemoteException {
        return this.createAndConnectControllerInternal(var1, var2, new ControllerListenerOptions(var3));
    }

    public boolean createAndConnectController(int var1, ControllerServiceBridge.Callbacks var2) throws RemoteException {
        return this.createAndConnectControllerInternal(var1, var2, new ControllerListenerOptions());
    }

    public void unregisterListener() {
        this.ensureOnMainThread();
        if(this.service != null) {
            try {
                this.service.unregisterListener("com.google.vr.internal.controller.LISTENER_KEY");
            } catch (RemoteException var2) {
                ThrowableExtension.printStackTrace(var2);
                Log.w(TAG, "RemoteException while unregistering listener.");
            }
        }
    }

    public void onServiceConnected(ComponentName var1, IBinder var2) {
        this.ensureOnMainThread();
        this.service = Stub.asInterface(var2);

        int var3;
        try {
            var3 = this.service.initialize(21);
        } catch (RemoteException var7) {
            ThrowableExtension.printStackTrace(var7);
            Log.e(TAG, "Failed to call initialize() on controller service (RemoteException).");
            this.defaultListener.callbacks.onServiceFailed();
            this.doUnbind();
            return;
        }

        String var10000;
        if(var3 != 0) {

            this.defaultListener.callbacks.onServiceInitFailed(var3);
            this.doUnbind();
        } else {
            if(this.vrcoreApiVersion >= 21) {
                try {
                    if(!this.service.registerServiceListener(this.defaultServiceListener)) {
                        Log.e(TAG, "Failed to register remote service listener.");
                        this.defaultListener.callbacks.onServiceInitFailed(var3);
                        this.doUnbind();
                        return;
                    }
                } catch (RemoteException var6) {
                    var10000 = TAG;
                    String var5 = String.valueOf(var6);
                    Log.w(var10000, (new StringBuilder(53 + String.valueOf(var5).length())).append("Exception while registering remote service listener: ").append(var5).toString());
                }
            }

            this.setupAndBindDefaultControllerListener();
        }
    }

    private void setupAndBindDefaultControllerListener() {
        this.defaultListener.callbacks.onServiceConnected(1);

        try {
            if(!this.service.registerListener(0, "com.google.vr.internal.controller.LISTENER_KEY", new ControllerServiceBridge.ControllerListener(this.defaultListener))) {
                Log.w(TAG, "Failed to register service listener.");
                this.defaultListener.callbacks.onServiceFailed();
                this.doUnbind();
                return;
            }
        } catch (RemoteException var2) {
            ThrowableExtension.printStackTrace(var2);
            Log.w(TAG, "RemoteException while registering service listener.");
            this.defaultListener.callbacks.onServiceFailed();
            this.doUnbind();
            return;
        }

        this.controllerListenerMap.put(0, this.defaultListener);
        Log.i(TAG, "Successfully registered service listener.");
    }

    public void onServiceDisconnected(ComponentName var1) {
        this.ensureOnMainThread();
        this.service = null;
        this.defaultListener.callbacks.onServiceDisconnected();
    }

    private void ensureOnMainThread() {
        if(Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("This should be running on the main thread.");
        }
    }

    private void handleServiceEvent(int var1) {
        if(var1 == 1) {
//            this.mainThreadHandler.post(new ControllerServiceBridge$$Lambda$2(this));
        }

    }

    private void handleAvailableControllersChanged() {
        this.ensureOnMainThread();
        if(this.getNumOfControllers() > 0) {
            if(this.isBound) {
                this.setupAndBindDefaultControllerListener();
                return;
            }
        } else {
            int var1 = this.controllerListenerMap.size();

            for(int var2 = 0; var2 < var1; ++var2) {
                ControllerServiceBridge.LocalControllerListener var3;
                if((var3 = (ControllerServiceBridge.LocalControllerListener)this.controllerListenerMap.valueAt(var2)) != null) {
                    var3.callbacks.onControllerStateChanged(var2, 0);
                }
            }

            this.clearControllers();
            this.defaultListener.callbacks.onServiceDisconnected();
        }

    }

    public int getNumOfControllers() {
        if(this.service == null) {
            return 0;
        } else {
            try {
                return this.service.getNumberOfControllers();
            } catch (RemoteException var3) {
                String var10000 = TAG;
                String var2 = String.valueOf(var3);
                Log.w(var10000, (new StringBuilder(54 + String.valueOf(var2).length())).append("Remote exception while getting number of controllers: ").append(var2).toString());
                return 0;
            }
        }
    }

    private static int getVrCoreApiVersion(Context var0) {
        try {
            return VrCoreUtils.getVrCoreClientApiVersion(var0);
        } catch (VrCoreNotAvailableException var1) {
            return 0;
        }
    }

    private static void logIfControllerPacketLags(ControllerEventPacket2 var0) {
        if(var0.getTimestampMillis() != 0L) {
            long var1;
            if((var1 = SystemClock.elapsedRealtime() - var0.getTimestampMillis()) > 300L) {
                Log.w(TAG, (new StringBuilder(122)).append("Experiencing large controller packet delivery time between service and  client: timestamp diff in ms: ").append(var1).toString());
            }

        }
    }

    private void initializeDefaultListener(ControllerServiceBridge.Callbacks var1, ControllerListenerOptions var2) {
        this.defaultListener = new ControllerServiceBridge.LocalControllerListener(var1, var2, 0);
        this.controllerListenerMap.put(0, this.defaultListener);
    }

    private boolean createAndConnectControllerInternal(int var1, ControllerServiceBridge.Callbacks var2, ControllerListenerOptions var3) throws RemoteException {
        this.ensureOnMainThread();
        if(this.service == null) {
            return false;
        } else {
            ControllerServiceBridge.LocalControllerListener var4 = new ControllerServiceBridge.LocalControllerListener(var2, var3, var1);
            if(this.service.registerListener(var1, "com.google.vr.internal.controller.LISTENER_KEY", new ControllerServiceBridge.ControllerListener(var4))) {
                if(var1 == 0) {
                    this.defaultListener = var4;
                }

                this.controllerListenerMap.put(var1, var4);
                return true;
            } else {
                Log.e(TAG, (new StringBuilder(41)).append("Failed to connect controller ").append(var1).append(".").toString());
                this.controllerListenerMap.remove(var1);
                return false;
            }
        }
    }

    static class ControllerListener extends com.google.vr.vrcore.controller.api.IControllerListener.Stub {
        private final WeakReference<ControllerServiceBridge.LocalControllerListener> listener;

        public ControllerListener(ControllerServiceBridge.LocalControllerListener var1) {
            this.listener = new WeakReference(var1);
        }

        public int getApiVersion() throws RemoteException {
            return 21;
        }

        public ControllerListenerOptions getOptions() throws RemoteException {
            ControllerServiceBridge.LocalControllerListener var1;
            return (var1 = (ControllerServiceBridge.LocalControllerListener)this.listener.get()) == null?null:var1.options;
        }

        public void onControllerStateChanged(int var1, int var2) throws RemoteException {
            ControllerServiceBridge.LocalControllerListener var3;
            if((var3 = (ControllerServiceBridge.LocalControllerListener)this.listener.get()) != null) {
                var3.callbacks.onControllerStateChanged(var1, var2);
            }
        }

        public void onControllerEventPacket(ControllerEventPacket var1) throws RemoteException {
            ControllerServiceBridge.LocalControllerListener var2;
            if((var2 = (ControllerServiceBridge.LocalControllerListener)this.listener.get()) != null) {
                var1.setEventsControllerIndex(var2.controllerIndex);
                var2.callbacks.onControllerEventPacket(var1);
                var1.recycle();
            }
        }

        public void onControllerEventPacket2(ControllerEventPacket2 var1) throws RemoteException {
            ControllerServiceBridge.LocalControllerListener var2;
            if((var2 = (ControllerServiceBridge.LocalControllerListener)this.listener.get()) != null) {
                ControllerServiceBridge.logIfControllerPacketLags(var1);
                var1.setEventsControllerIndex(var2.controllerIndex);
                var2.callbacks.onControllerEventPacket2(var1);
                var1.recycle();
            }
        }

        public void onControllerRecentered(ControllerOrientationEvent var1) {
            ControllerServiceBridge.LocalControllerListener var2;
            if((var2 = (ControllerServiceBridge.LocalControllerListener)this.listener.get()) != null) {
                var1.controllerId = var2.controllerIndex;
                var2.callbacks.onControllerRecentered(var1);
            }
        }
    }

    static class ControllerServiceListener extends com.google.vr.vrcore.controller.api.IControllerServiceListener.Stub {
        private final WeakReference<ControllerServiceBridge> serviceBridge;

        public ControllerServiceListener(ControllerServiceBridge var1) {
            this.serviceBridge = new WeakReference(var1);
        }

        public int getApiVersion() throws RemoteException {
            return 21;
        }

        public void onControllerServiceEvent(int var1) throws RemoteException {
            ControllerServiceBridge var2;
            if((var2 = (ControllerServiceBridge)this.serviceBridge.get()) != null) {
                var2.handleServiceEvent(var1);
            }
        }
    }

    static class LocalControllerListener {
        public final ControllerServiceBridge.Callbacks callbacks;
        public final ControllerListenerOptions options;
        public final int controllerIndex;

        public LocalControllerListener(ControllerServiceBridge.Callbacks var1, ControllerListenerOptions var2, int var3) {
            this.callbacks = var1;
            this.options = var2;
            this.controllerIndex = var3;
        }
    }

    @UsedByNative
    public interface Callbacks {
        void onServiceConnected(int var1);

        void onServiceDisconnected();

        void onServiceUnavailable();

        void onServiceFailed();

        void onServiceInitFailed(int var1);

        void onControllerStateChanged(int var1, int var2);

        void onControllerEventPacket(ControllerEventPacket var1);

        void onControllerRecentered(ControllerOrientationEvent var1);

        void onControllerEventPacket2(ControllerEventPacket2 var1);
    }
}
