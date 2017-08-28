//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.cardboard;

import android.content.Context;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.vr.cardboard.UsedByNative;
import com.google.vr.ndk.base.Version;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;
import com.google.vr.vrcore.library.api.IVrNativeLibraryLoader;
import com.google.vr.vrcore.library.api.ObjectWrapper;
import com.google.vr.vrcore.library.api.VrCoreLoader;

@UsedByNative
public class VrCoreLibraryLoader {
    private static final String TAG = VrCoreLibraryLoader.class.getSimpleName();
    private static final int MAX_ANDROID_SDK_VERSION_FOR_DLSYM = 22;
    private static final int MIN_TARGET_API_VERSION_FOR_DLSYM = 14;

    public VrCoreLibraryLoader() {
    }

    public static void checkVrCoreGvrLibraryAvailable(Context var0) throws VrCoreNotAvailableException {
        checkVrCoreGvrLibraryAvailable(var0, Version.CURRENT);
    }

    @UsedByNative
    public static long loadNativeGvrLibrary(Context var0, int var1, int var2, int var3) {
        try {
            Version var4 = new Version(var1, var2, var3);
            if(!Version.CURRENT.equals(var4)) {
                Log.w(TAG, String.format("Native SDK version does not match Java; expected %s but received %s", new Object[]{Version.CURRENT, var4.toString()}));
            }

            checkVrCoreGvrLibraryAvailable(var0, var4);
            Context var9 = VrCoreLoader.getRemoteContext(var0);
            IVrNativeLibraryLoader var7;
            if((var7 = VrCoreLoader.getRemoteCreator(var0).newNativeLibraryLoader(ObjectWrapper.wrap(var9), ObjectWrapper.wrap(var0))) == null) {
                Log.e(TAG, "Failed to load native GVR library from VrCore: no library loader available.");
                return 0L;
            } else {
                return var7.loadNativeGvrLibrary(var4.majorVersion, var4.minorVersion, var4.patchVersion);
            }
        } catch (IllegalArgumentException | IllegalStateException | SecurityException | UnsatisfiedLinkError | RemoteException | VrCoreNotAvailableException var8) {
            String var10000 = TAG;
            String var5 = String.valueOf(var8);
            Log.e(var10000, (new StringBuilder(49 + String.valueOf(var5).length())).append("Failed to load native GVR library from VrCore:\n  ").append(var5).toString());
            return 0L;
        }
    }

    @UsedByNative
    public static long loadNativeDlsymMethod(Context var0) {
        if(VERSION.SDK_INT > 22) {
            return 0L;
        } else {
            try {
                if(VrCoreUtils.getVrCoreClientApiVersion(var0) < 14) {
                    return 0L;
                } else {
                    Context var1 = VrCoreLoader.getRemoteContext(var0);
                    IVrNativeLibraryLoader var3;
                    if((var3 = VrCoreLoader.getRemoteCreator(var0).newNativeLibraryLoader(ObjectWrapper.wrap(var1), ObjectWrapper.wrap(var0))) == null) {
                        Log.e(TAG, "Failed to load native dlsym handle from VrCore: no library loader available.");
                        return 0L;
                    } else {
                        return var3.loadNativeDlsymMethod();
                    }
                }
            } catch (IllegalArgumentException | IllegalStateException | SecurityException | UnsatisfiedLinkError | RemoteException | VrCoreNotAvailableException var4) {
                String var10000 = TAG;
                String var2 = String.valueOf(var4);
                Log.e(var10000, (new StringBuilder(50 + String.valueOf(var2).length())).append("Failed to load native dlsym handle from VrCore:\n  ").append(var2).toString());
                return 0L;
            }
        }
    }

    private static void checkVrCoreGvrLibraryAvailable(Context var0, Version var1) throws VrCoreNotAvailableException {
        String var2;
        Version var3;
        if((var3 = Version.parse(var2 = VrCoreUtils.getVrCoreSdkLibraryVersion(var0))) == null) {
            Log.i(TAG, "VrCore version does not support library loading.");
            throw new VrCoreNotAvailableException(4);
        } else if(!var3.isAtLeast(var1)) {
            Log.w(TAG, String.format("VrCore GVR library version obsolete; VrCore supports %s but target version is %s", new Object[]{var2, var1.toString()}));
            throw new VrCoreNotAvailableException(4);
        }
    }
}
