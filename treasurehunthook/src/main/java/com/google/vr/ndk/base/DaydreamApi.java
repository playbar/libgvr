//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.ndk.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.IntentSender.SendIntentException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.cardboard.VrParamsProviderFactory;
import com.google.vr.cardboard.VrSettingsProviderContract;
import com.google.vr.cardboard.VrParamsProviderFactory.ContentProviderClientHandle;
import com.google.vr.cardboard.annotations.UsedByReflection;
import com.google.vr.ndk.base.DaydreamUtils;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;
import com.google.vr.vrcore.common.api.IDaydreamManager;
import com.google.vr.vrcore.common.api.ITransitionCallbacks;
import com.google.vr.vrcore.common.api.IVrCoreSdkService;
import com.google.vr.vrcore.common.api.IVrCoreSdkService.Stub;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams;
import java.util.ArrayList;
import java.util.List;

@TargetApi(24)
@UsedByReflection("IAP")
public class DaydreamApi implements AutoCloseable {
    private static final String TAG = DaydreamApi.class.getSimpleName();
    private static final int MIN_VRCORE_API_VERSION = 8;
    private static final int MIN_API_FOR_HEADSET_INSERTION = 11;
    private static final String DAYDREAM_CATEGORY = "com.google.intent.category.DAYDREAM";
    private IVrCoreSdkService vrCoreSdkService;
    private IDaydreamManager daydreamManager;
    private final Context context;
    private boolean closed;
    private ArrayList<Runnable> queuedRunnables = new ArrayList();
    private int vrCoreApiVersion;
    private final ServiceConnection connection = new ServiceConnection() {
        public void onServiceConnected(ComponentName var1, IBinder var2) {
            DaydreamApi.this.vrCoreSdkService = Stub.asInterface(var2);

            try {
                DaydreamApi.this.daydreamManager = DaydreamApi.this.vrCoreSdkService.getDaydreamManager();
            } catch (RemoteException var8) {
                Log.e(DaydreamApi.TAG, "RemoteException in onServiceConnected");
            }

            if(DaydreamApi.this.daydreamManager == null) {
                Log.w(DaydreamApi.TAG, "Daydream service component unavailable.");
            }

            ArrayList var5;
            int var6 = (var5 = (ArrayList)DaydreamApi.this.queuedRunnables).size();
            int var7 = 0;
            Object var3 = null;

            while(var7 < var6) {
                Object var10000 = var5.get(var7);
                ++var7;
                ((Runnable)var10000).run();
            }

            DaydreamApi.this.queuedRunnables.clear();
        }

        public void onServiceDisconnected(ComponentName var1) {
            DaydreamApi.this.vrCoreSdkService = null;
        }
    };

    @UsedByReflection("IAP")
    public static DaydreamApi create(Context var0) {
        if(Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("DaydreamApi must only be used from the main thread.");
        } else if(!DaydreamUtils.isDaydreamPhone(var0)) {
            Log.i(TAG, "Phone is not Daydream-compatible");
            return null;
        } else {
            DaydreamApi var1;
            if((var1 = new DaydreamApi(var0)).init()) {
                return var1;
            } else {
                Log.w(TAG, "Failed to initialize DaydreamApi object.");
                return null;
            }
        }
    }

    public static boolean isDaydreamReadyPlatform(Context var0) {
        return DaydreamUtils.isDaydreamPhone(var0);
    }

    public int getCurrentViewerType() {
        this.checkNotClosed();
        if(!isDaydreamReadyPlatform(this.context)) {
            return 0;
        } else {
            VrParamsProvider var1 = VrParamsProviderFactory.create(this.context);

            try {
                DeviceParams var2;
                if((var2 = var1.readDeviceParams()) == null) {
                    return 0;
                }

                if(!DaydreamUtils.isDaydreamViewer(var2)) {
                    return 0;
                }
            } finally {
                var1.close();
            }

            return 1;
        }
    }

    public void registerDaydreamIntent(final PendingIntent var1) {
        this.checkNotClosed();
        this.runWhenServiceConnected(new Runnable() {
            public void run() {
                if(DaydreamApi.this.daydreamManager == null) {
                    Log.w(DaydreamApi.TAG, "Can\'t register/unregister daydream intent: no DaydreamManager.");
                } else {
                    try {
                        if(var1 == null) {
                            DaydreamApi.this.daydreamManager.unregisterDaydreamIntent();
                            return;
                        }

                        DaydreamApi.this.daydreamManager.registerDaydreamIntent(var1);
                    } catch (RemoteException var2) {
                        Log.e(DaydreamApi.TAG, "Error when attempting to register/unregister daydream intent: ", var2);
                    }

                }
            }
        });
    }

    public void unregisterDaydreamIntent() {
        this.checkNotClosed();
        this.registerDaydreamIntent((PendingIntent)null);
    }

    public static boolean setDaydreamSetupCompleted(Context var0, boolean var1) {
        ContentProviderClientHandle var2;
        if((var2 = VrParamsProviderFactory.tryToGetContentProviderClientHandle(var0)) == null) {
            Log.e(TAG, "No ContentProvider available for Daydream setup.");
            return false;
        } else {
            Uri var3 = VrSettingsProviderContract.createUri(var2.authority, "daydream_setup");

            try {
                ContentValues var4;
                (var4 = new ContentValues()).put("value", Boolean.valueOf(var1));
                return var2.client.update(var3, var4, (String)null, (String[])null) > 0;
            } catch (RemoteException var6) {
                Log.e(TAG, "Failed to indicate Daydream setup completion to ContentProvider", var6);
                return false;
            } catch (SecurityException var7) {
                Log.e(TAG, "Insufficient permissions to indicate Daydream setup completion to ContentProvider", var7);
                return false;
            }
        }
    }

    public static boolean getDaydreamSetupCompleted(Context var0) {
        ContentProviderClientHandle var1;
        if((var1 = VrParamsProviderFactory.tryToGetContentProviderClientHandle(var0)) == null) {
            Log.e(TAG, "No ContentProvider available for Daydream setup.");
            return false;
        } else {
            Uri var2 = VrSettingsProviderContract.createUri(var1.authority, "daydream_setup");
            Cursor var3 = null;

            try {
                if((var3 = var1.client.query(var2, (String[])null, (String)null, (String[])null, (String)null)) == null || !var3.moveToFirst()) {
                    return false;
                }

                boolean var4 = var3.getInt(0) == 1;
                return var4;
            } catch (RemoteException var9) {
                Log.e(TAG, "Failed to read Daydream setup completion from ContentProvider", var9);
                return false;
            } catch (SecurityException var10) {
                Log.e(TAG, "Insufficient permissions to read Daydream setup completion from ContentProvider", var10);
            } finally {
                if(var3 != null) {
                    var3.close();
                }

            }

            return false;
        }
    }

    @UsedByReflection("IAP")
    public void launchInVr(PendingIntent var1) {
        this.checkNotClosed();
        this.launchInVr(var1, (ComponentName)null);
    }

    private void launchInVr(final PendingIntent var1, final ComponentName var2) {
        this.runWhenServiceConnected(new Runnable() {
            public void run() {
                if(DaydreamApi.this.daydreamManager != null) {
                    try {
                        DaydreamApi.this.daydreamManager.launchInVr(var1, var2);
                    } catch (RemoteException var2x) {
                        Log.e(DaydreamApi.TAG, "RemoteException while launching PendingIntent in VR.", var2x);
                    }
                } else {
                    Log.w(DaydreamApi.TAG, "Can\'t launch PendingIntent via DaydreamManager: not available.");

                    try {
                        var1.send();
                    } catch (Exception var3) {
                        Log.e(DaydreamApi.TAG, "Couldn\'t launch PendingIntent: ", var3);
                    }
                }
            }
        });
    }

    private void launchTransitionCallbackInVr(final ITransitionCallbacks var1) {
        this.runWhenServiceConnected(new Runnable() {
            public void run() {
                boolean var1x = false;
                if(DaydreamApi.this.daydreamManager != null) {
                    try {
                        var1x = DaydreamApi.this.daydreamManager.launchVrTransition(var1);
                    } catch (RemoteException var3) {
                        Log.e(DaydreamApi.TAG, "RemoteException while launching VR transition: ", var3);
                    }
                }

                if(!var1x) {
                    Log.w(DaydreamApi.TAG, "Can\'t launch callbacks via DaydreamManager, sending manually");

                    try {
                        var1.onTransitionComplete();
                        return;
                    } catch (RemoteException var4) {
                        ;
                    }
                }

            }
        });
    }

    @UsedByReflection("IAP")
    public void launchVrHomescreen() {
        this.checkNotClosed();
        this.runWhenServiceConnected(new Runnable() {
            public void run() {
                if(DaydreamApi.this.daydreamManager == null) {
                    Log.e(DaydreamApi.TAG, "Can\'t launch VR homescreen via DaydreamManager. Giving up trying to leave current VR activity...");
                } else {
                    try {
                        if(!DaydreamApi.this.daydreamManager.launchVrHome()) {
                            Log.e(DaydreamApi.TAG, "There is no VR homescreen installed.");
                        }
                    } catch (RemoteException var3) {
                        String var10000 = DaydreamApi.TAG;
                        String var2 = String.valueOf(var3);
                        Log.e(var10000, (new StringBuilder(47 + String.valueOf(var2).length())).append("RemoteException while launching VR homescreen: ").append(var2).toString());
                    }
                }
            }
        });
    }

    @UsedByReflection("IAP")
    public void launchInVr(Intent var1) throws ActivityNotFoundException {
        this.checkNotClosed();
        if(var1 == null) {
            throw new IllegalArgumentException("Null argument \'intent\' passed to launchInVr");
        } else {
            this.checkIntent(var1);
            this.launchInVr(PendingIntent.getActivity(this.context, 0, var1, 1207959552), var1.getComponent());
        }
    }

    @UsedByReflection("IAP")
    public void launchInVr(ComponentName var1) throws ActivityNotFoundException {
        this.checkNotClosed();
        if(var1 == null) {
            throw new IllegalArgumentException("Null argument \'componentName\' passed to launchInVr");
        } else {
            Intent var2 = createVrIntent(var1);
            this.checkIntent(var2);
            this.launchInVr(PendingIntent.getActivity(this.context, 0, var2, 1073741824), var2.getComponent());
        }
    }

    @UsedByReflection("IAP")
    public void launchInVrForResult(final Activity var1, final PendingIntent var2, final int var3) {
        this.checkNotClosed();
        com.google.vr.vrcore.common.api.ITransitionCallbacks.Stub var4 = new com.google.vr.vrcore.common.api.ITransitionCallbacks.Stub() {
            public void onTransitionComplete() {
                var1.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            var1.startIntentSenderForResult(var2.getIntentSender(), var3, (Intent)null, 0, 0, 0);
                        } catch (SendIntentException var3x) {
                            String var10000 = DaydreamApi.TAG;
                            String var2x = String.valueOf(var3x);
                            Log.e(var10000, (new StringBuilder(43 + String.valueOf(var2x).length())).append("Exception while starting next VR activity: ").append(var2x).toString());
                        }
                    }
                });
            }
        };
        this.launchTransitionCallbackInVr(var4);
    }

    @UsedByReflection("IAP")
    public static Intent createVrIntent(ComponentName var0) {
        Intent var1;
        (var1 = new Intent()).setComponent(var0);
        return setupVrIntent(var1);
    }

    @UsedByReflection("IAP")
    public static Intent setupVrIntent(Intent var0) {
        var0.addCategory("com.google.intent.category.DAYDREAM");
        var0.addFlags(335609856);
        return var0;
    }

    @UsedByReflection("IAP")
    public void exitFromVr(Activity var1, int var2, Intent var3) {
        this.checkNotClosed();
        if(var3 == null) {
            var3 = new Intent();
        }

        final PendingIntent var4 = var1.createPendingResult(var2, var3, 1073741824);
        final Runnable var5 = new Runnable() {
            public void run() {
                try {
                    var4.send(0);
                } catch (Exception var3) {
                    String var10000 = DaydreamApi.TAG;
                    String var2 = String.valueOf(var3);
                    Log.e(var10000, (new StringBuilder(31 + String.valueOf(var2).length())).append("Couldn\'t launch PendingIntent: ").append(var2).toString());
                }
            }
        };
        this.runWhenServiceConnected(new Runnable() {
            public void run() {
                if(DaydreamApi.this.daydreamManager == null) {
                    Log.w(DaydreamApi.TAG, "Failed to exit VR: Daydream service unavailable.");
                    var5.run();
                } else {
                    try {
                        if(!DaydreamApi.this.daydreamManager.exitFromVr(var4)) {
                            Log.w(DaydreamApi.TAG, "Failed to exit VR: Invalid request.");
                            var5.run();
                        }

                    } catch (RemoteException var3) {
                        String var10000 = DaydreamApi.TAG;
                        String var2 = String.valueOf(var3);
                        Log.e(var10000, (new StringBuilder(49 + String.valueOf(var2).length())).append("Failed to exit VR: RemoteException while exiting:").append(var2).toString());
                        var5.run();
                    }
                }
            }
        });
    }

    public void setInhibitSystemButtons(final ComponentName var1, final boolean var2) {
        this.checkNotClosed();
        this.runWhenServiceConnected(new Runnable() {
            public void run() {
                try {
                    Bundle var1x;
                    (var1x = new Bundle()).putBoolean("OPTION_INHIBIT_SYSTEM_BUTTONS", var2);
                    if(!DaydreamApi.this.vrCoreSdkService.setClientOptions(var1, var1x)) {
                        Log.w(DaydreamApi.TAG, "Failed to set client options to inhibit system button.");
                    }

                } catch (RemoteException var2x) {
                    Log.e(DaydreamApi.TAG, "RemoteException while setting client options.", var2x);
                }
            }
        });
    }

    public void handleInsertionIntoHeadset(final byte[] var1) {
        this.runWhenServiceConnected(new Runnable() {
            public void run() {
                if(DaydreamApi.this.vrCoreApiVersion < 11) {
                    String var10000 = DaydreamApi.TAG;
                    String var1x = String.valueOf("Can\'t handle insertion of phone into headset: VrCore API too old. Need: 11, found: ");
                    int var2 = DaydreamApi.this.vrCoreApiVersion;
                    Log.e(var10000, (new StringBuilder(11 + String.valueOf(var1x).length())).append(var1x).append(var2).toString());
                } else if(DaydreamApi.this.daydreamManager == null) {
                    Log.e(DaydreamApi.TAG, "Can\'t handle insertion of phone into headset: no DaydreamManager.");
                } else {
                    try {
                        DaydreamApi.this.daydreamManager.handleInsertionIntoHeadset(var1);
                    } catch (SecurityException var3) {
                        Log.e(DaydreamApi.TAG, "SecurityException when notifying phone insertion. Check that the calling app is in the system image (must have the SYSTEM flag in package manager).", var3);
                    } catch (RemoteException var4) {
                        Log.e(DaydreamApi.TAG, "RemoteException while notifying phone insertion.", var4);
                    }
                }
            }
        });
    }

    public void handleRemovalFromHeadset() {
        this.runWhenServiceConnected(new Runnable() {
            public void run() {
                if(DaydreamApi.this.vrCoreApiVersion < 11) {
                    String var10000 = DaydreamApi.TAG;
                    String var1 = String.valueOf("Can\'t handle removal of phone from headset: VrCore API too old. Need: 11, found: ");
                    int var2 = DaydreamApi.this.vrCoreApiVersion;
                    Log.e(var10000, (new StringBuilder(11 + String.valueOf(var1).length())).append(var1).append(var2).toString());
                } else if(DaydreamApi.this.daydreamManager == null) {
                    Log.e(DaydreamApi.TAG, "Can\'t handle removal of phone from headset: no DaydreamManager.");
                } else {
                    try {
                        DaydreamApi.this.daydreamManager.handleRemovalFromHeadset();
                    } catch (SecurityException var3) {
                        Log.e(DaydreamApi.TAG, "SecurityException when notifying phone removal. Check that the calling app is in the system image (must have the SYSTEM flag in package manager).", var3);
                    } catch (RemoteException var4) {
                        Log.e(DaydreamApi.TAG, "RemoteException while notifying phone removal.", var4);
                    }
                }
            }
        });
    }

    @UsedByReflection("IAP")
    public void close() {
        if(!this.closed) {
            this.closed = true;
            this.runWhenServiceConnected(new Runnable() {
                public void run() {
                    DaydreamApi.this.context.unbindService(DaydreamApi.this.connection);
                    DaydreamApi.this.vrCoreSdkService = null;
                }
            });
        }
    }

    private DaydreamApi(Context var1) {
        this.context = var1;
    }

    private boolean init() {
        try {
            this.vrCoreApiVersion = VrCoreUtils.getVrCoreClientApiVersion(this.context);
            if(this.vrCoreApiVersion < 8) {
                int var4 = this.vrCoreApiVersion;
                Log.e(TAG, (new StringBuilder(79)).append("VrCore out of date, current version: ").append(var4).append(", required version: 8").toString());
                return false;
            }

            Intent var1;
            (var1 = new Intent("com.google.vr.vrcore.BIND_SDK_SERVICE")).setPackage("com.google.vr.vrcore");
            if(this.context.bindService(var1, this.connection, 1)) {
                return true;
            }

            Log.e(TAG, "Unable to bind to VrCoreSdkService");
        } catch (VrCoreNotAvailableException var3) {
            String var10000 = TAG;
            String var2 = String.valueOf(var3);
            Log.e(var10000, (new StringBuilder(22 + String.valueOf(var2).length())).append("VrCore not available: ").append(var2).toString());
        }

        return false;
    }

    private void runWhenServiceConnected(Runnable var1) {
        if(this.vrCoreSdkService != null) {
            var1.run();
        } else {
            this.queuedRunnables.add(var1);
        }
    }

    private void checkIntent(Intent var1) throws ActivityNotFoundException {
        List var3;
        if((var3 = this.context.getPackageManager().queryIntentActivities(var1, 0)) == null || var3.isEmpty()) {
            String var4 = String.valueOf(var1);
            throw new ActivityNotFoundException((new StringBuilder(43 + String.valueOf(var4).length())).append("No activity is available to handle intent: ").append(var4).toString());
        }
    }

    private void checkNotClosed() {
        if(this.closed) {
            throw new IllegalStateException("DaydreamApi object is closed and can no longer be used.");
        }
    }
}
