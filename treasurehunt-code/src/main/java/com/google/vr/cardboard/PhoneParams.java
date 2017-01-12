//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.cardboard;

import android.os.Build;
import android.util.Log;
import com.google.protobuf.nano.MessageNano;
import com.google.vr.cardboard.ConfigUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PhoneParams {
    private static final boolean DEBUG = false;
    private static final String TAG = PhoneParams.class.getSimpleName();
    private static final List<PhoneParams.PpiOverride> PPI_OVERRIDES = Arrays.asList(new PhoneParams.PpiOverride[]{new PhoneParams.PpiOverride("Micromax", (String)null, "4560MMX", (String)null, 217, 217), new PhoneParams.PpiOverride("HTC", "endeavoru", "HTC One X", (String)null, 312, 312), new PhoneParams.PpiOverride("samsung", (String)null, "SM-G920P", (String)null, 575, 575), new PhoneParams.PpiOverride("samsung", (String)null, "SM-G930", (String)null, 581, 580), new PhoneParams.PpiOverride("samsung", (String)null, "SM-G9300", (String)null, 581, 580), new PhoneParams.PpiOverride("samsung", (String)null, "SM-G930A", (String)null, 581, 580), new PhoneParams.PpiOverride("samsung", (String)null, "SM-G930F", (String)null, 581, 580), new PhoneParams.PpiOverride("samsung", (String)null, "SM-G930P", (String)null, 581, 580), new PhoneParams.PpiOverride("samsung", (String)null, "SM-G930R4", (String)null, 581, 580), new PhoneParams.PpiOverride("samsung", (String)null, "SM-G930T", (String)null, 581, 580), new PhoneParams.PpiOverride("samsung", (String)null, "SM-G930V", (String)null, 581, 580), new PhoneParams.PpiOverride("samsung", (String)null, "SM-G930W8", (String)null, 581, 580), new PhoneParams.PpiOverride("samsung", (String)null, "SM-N915FY", (String)null, 541, 541), new PhoneParams.PpiOverride("samsung", (String)null, "SM-N915A", (String)null, 541, 541), new PhoneParams.PpiOverride("samsung", (String)null, "SM-N915T", (String)null, 541, 541), new PhoneParams.PpiOverride("samsung", (String)null, "SM-N915K", (String)null, 541, 541), new PhoneParams.PpiOverride("samsung", (String)null, "SM-N915T", (String)null, 541, 541), new PhoneParams.PpiOverride("samsung", (String)null, "SM-N915G", (String)null, 541, 541), new PhoneParams.PpiOverride("samsung", (String)null, "SM-N915D", (String)null, 541, 541), new PhoneParams.PpiOverride("BLU", "BLU", "Studio 5.0 HD LTE", "qcom", 294, 294), new PhoneParams.PpiOverride("OnePlus", "A0001", "A0001", "bacon", 401, 401), new PhoneParams.PpiOverride("THL", "THL", "thl 5000", "mt6592", 441, 441)});

    private PhoneParams() {
    }

    static boolean getPpiOverride(List<PhoneParams.PpiOverride> var0, String var1, String var2, String var3, String var4, com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams var5) {
        Iterator var6 = var0.iterator();

        PhoneParams.PpiOverride var7;
        do {
            if(!var6.hasNext()) {
                return false;
            }
        } while(!(var7 = (PhoneParams.PpiOverride)var6.next()).isMatching(var1, var2, var3, var4));

        Log.d(TAG, String.format("Found override: {MANUFACTURER=%s, DEVICE=%s, MODEL=%s, HARDWARE=%s} : x_ppi=%d, y_ppi=%d", new Object[]{var7.manufacturer, var7.device, var7.model, var7.hardware, Integer.valueOf(var7.xPpi), Integer.valueOf(var7.yPpi)}));
        var5.setXPpi((float)var7.xPpi);
        var5.setYPpi((float)var7.yPpi);
        return true;
    }

    static void registerOverridesInternal(List<PhoneParams.PpiOverride> var0, String var1, String var2, String var3, String var4) {
        com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams var5;
        com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams var6 = (var5 = ConfigUtils.readPhoneParamsFromExternalStorage()) == null?new com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams():var5.clone();
        if(getPpiOverride(var0, var1, var2, var3, var4, var6) && !MessageNano.messageNanoEquals(var5, var6)) {
            Log.i(TAG, "Applying phone param override.");
            ConfigUtils.writePhoneParamsToExternalStorage(var6);
        }

    }

    public static void registerOverrides() {
        registerOverridesInternal(PPI_OVERRIDES, Build.MANUFACTURER, Build.DEVICE, Build.MODEL, Build.HARDWARE);
    }

    public static com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams getPpiOverride() {
        com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams var0 = new com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams();
        return getPpiOverride(PPI_OVERRIDES, Build.MANUFACTURER, Build.DEVICE, Build.MODEL, Build.HARDWARE, var0)?var0:null;
    }

    static class PpiOverride {
        String manufacturer;
        String device;
        String model;
        String hardware;
        int xPpi;
        int yPpi;

        PpiOverride(String var1, String var2, String var3, String var4, int var5, int var6) {
            this.manufacturer = var1;
            this.device = var2;
            this.model = var3;
            this.hardware = var4;
            this.xPpi = var5;
            this.yPpi = var6;
        }

        boolean isMatching(String var1, String var2, String var3, String var4) {
            return (this.manufacturer == null || this.manufacturer.equals(var1)) && (this.device == null || this.device.equals(var2)) && (this.model == null || this.model.equals(var3)) && (this.hardware == null || this.hardware.equals(var4));
        }
    }
}
