//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.ndk.base;

import android.app.Activity;
import android.content.Context;
import com.google.vr.ndk.base.DaydreamUtils;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams;

public class DaydreamUtilsWrapper {
    public DaydreamUtilsWrapper() {
    }

    public boolean isDaydreamActivity(Activity var1) {
        return this.getActivityDaydreamCompatibility(var1) != 0;
    }

    public boolean isDaydreamRequiredActivity(Activity var1) {
        return this.getActivityDaydreamCompatibility(var1) == 2;
    }

    public int getActivityDaydreamCompatibility(Activity var1) {
        return DaydreamUtils.getComponentDaydreamCompatibility(var1, var1.getComponentName());
    }

    public boolean isDaydreamPhone(Context var1) {
        return DaydreamUtils.isDaydreamPhone(var1);
    }

    public boolean isDaydreamViewer(DeviceParams var1) {
        return DaydreamUtils.isDaydreamViewer(var1);
    }
}
