//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.ndk.base;

import android.content.Context;
import android.util.Log;
import com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams;
import com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.cardboard.VrParamsProviderFactory;
import com.google.vr.vrcore.nano.SdkConfiguration.SdkConfigurationRequest;

public class SdkConfigurationReader {
    private static final String TAG = SdkConfigurationReader.class.getSimpleName();
    static final SdkConfigurationParams REQUESTED_PARAMS;
    static SdkConfigurationParams sParams;
    public static final SdkConfigurationParams DEFAULT_PARAMS;

    public SdkConfigurationReader() {
    }

    public static SdkConfigurationParams getParams(Context var0) {
        Class var1 = SdkConfigurationReader.class;
        synchronized(SdkConfigurationReader.class) {
            if(sParams != null) {
                return sParams;
            }
        }

        VrParamsProvider var7;
        SdkConfigurationParams var2 = readParamsFromProvider(var7 = VrParamsProviderFactory.create(var0));
        Class var3 = SdkConfigurationReader.class;
        synchronized(SdkConfigurationReader.class) {
            sParams = var2;
        }

        var7.close();
        return sParams;
    }

    private static SdkConfigurationParams readParamsFromProvider(VrParamsProvider var0) {
        SdkConfigurationRequest var1;
        (var1 = new SdkConfigurationRequest()).requestedParams = REQUESTED_PARAMS;
        var1.sdkVersion = "1.10.0";
        SdkConfigurationParams var2;
        if((var2 = var0.readSdkConfigurationParams(var1)) == null) {
            Log.w(TAG, "VrParamsProvider returned null params, using defaults.");
            var2 = DEFAULT_PARAMS;
        } else {
            String var10000 = TAG;
            String var3 = String.valueOf(var2);
            Log.d(var10000, (new StringBuilder(38 + String.valueOf(var3).length())).append("Fetched params from VrParamsProvider: ").append(var3).toString());
        }

        return var2;
    }

    static {
        (REQUESTED_PARAMS = new SdkConfigurationParams()).useSystemClockForSensorTimestamps = Boolean.valueOf(true);
        REQUESTED_PARAMS.useMagnetometerInSensorFusion = Boolean.valueOf(true);
        REQUESTED_PARAMS.allowDynamicLibraryLoading = Boolean.valueOf(true);
        REQUESTED_PARAMS.cpuLateLatchingEnabled = Boolean.valueOf(true);
        REQUESTED_PARAMS.daydreamImageAlignment = Integer.valueOf(1);
        REQUESTED_PARAMS.asyncReprojectionConfig = new AsyncReprojectionConfig();
        REQUESTED_PARAMS.useOnlineMagnetometerCalibration = Boolean.valueOf(true);
        (DEFAULT_PARAMS = new SdkConfigurationParams()).useSystemClockForSensorTimestamps = Boolean.valueOf(false);
        DEFAULT_PARAMS.useMagnetometerInSensorFusion = Boolean.valueOf(false);
        DEFAULT_PARAMS.allowDynamicLibraryLoading = Boolean.valueOf(false);
        DEFAULT_PARAMS.cpuLateLatchingEnabled = Boolean.valueOf(false);
        DEFAULT_PARAMS.daydreamImageAlignment = Integer.valueOf(3);
        DEFAULT_PARAMS.asyncReprojectionConfig = null;
        DEFAULT_PARAMS.useOnlineMagnetometerCalibration = Boolean.valueOf(false);
    }
}
