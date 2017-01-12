//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.cardboard;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.vr.cardboard.DisplayUtils;
import com.google.vr.cardboard.UsedByNative;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.cardboard.VrParamsProviderFactory;
import com.google.vr.ndk.base.SdkConfigurationReader;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams;
import com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams;
import com.google.vrtoolkit.cardboard.proto.nano.Preferences.UserPrefs;

@UsedByNative
public class VrParamsProviderJni {
    private static final String TAG = "VrParamsProviderJni";
    private static volatile DisplayMetrics displayMetricsOverride = null;

    public VrParamsProviderJni() {
    }

    public static void setDisplayOverride(Display var0) {
        displayMetricsOverride = var0 != null?DisplayUtils.getDisplayMetricsLandscape(var0):null;
    }

    @UsedByNative
    private static byte[] readDeviceParams(Context var0) {
        VrParamsProvider var1;
        DeviceParams var2 = (var1 = VrParamsProviderFactory.create(var0)).readDeviceParams();
        var1.close();
        return var2 == null?null:MessageNano.toByteArray(var2);
    }

    @UsedByNative
    private static byte[] readSdkConfigurationParams(Context var0) {
        return MessageNano.toByteArray(SdkConfigurationReader.getParams(var0));
    }

    @UsedByNative
    private static boolean writeDeviceParams(Context var0, byte[] var1) {
        VrParamsProvider var2 = VrParamsProviderFactory.create(var0);

        try {
            DeviceParams var3 = var1 != null?(DeviceParams)MessageNano.mergeFrom(new DeviceParams(), var1):null;
            boolean var10 = var2.writeDeviceParams(var3);
            return var10;
        } catch (InvalidProtocolBufferNanoException var8) {
            String var4 = String.valueOf(var8);
            Log.w("VrParamsProviderJni", (new StringBuilder(31 + String.valueOf(var4).length())).append("Error parsing protocol buffer: ").append(var4).toString());
        } finally {
            var2.close();
        }

        return false;
    }

    @UsedByNative
    private static void readPhoneParams(Context var0, long var1) {
        if(var0 == null) {
            Log.w("VrParamsProviderJni", "Missing context for phone params lookup. Results may be invalid.");
            updateNativePhoneParamsPointer(var1, Resources.getSystem().getDisplayMetrics());
        } else {
            DisplayMetrics var3 = getDisplayMetrics(var0);
            VrParamsProvider var4;
            PhoneParams var5 = (var4 = VrParamsProviderFactory.create(var0)).readPhoneParams();
            var4.close();
            if(var5 != null) {
                if(var5.hasXPpi()) {
                    var3.xdpi = var5.getXPpi();
                }

                if(var5.hasYPpi()) {
                    var3.ydpi = var5.getYPpi();
                }
            }

            updateNativePhoneParamsPointer(var1, var3);
        }
    }

    @UsedByNative
    private static byte[] readUserPrefs(Context var0) {
        VrParamsProvider var1;
        UserPrefs var2 = (var1 = VrParamsProviderFactory.create(var0)).readUserPrefs();
        var1.close();
        return var2 == null?null:MessageNano.toByteArray(var2);
    }

    private static DisplayMetrics getDisplayMetrics(Context var0) {
        DisplayMetrics var1 = displayMetricsOverride;
        return displayMetricsOverride != null?var1:DisplayUtils.getDisplayMetricsLandscape(((WindowManager)var0.getSystemService("window")).getDefaultDisplay());
    }

    private static void updateNativePhoneParamsPointer(long var0, DisplayMetrics var2) {
        nativeUpdateNativePhoneParamsPointer(var0, var2.widthPixels, var2.heightPixels, var2.xdpi, var2.ydpi);
    }

    private static native void nativeUpdateNativePhoneParamsPointer(long var0, int var2, int var3, float var4, float var5);
}
