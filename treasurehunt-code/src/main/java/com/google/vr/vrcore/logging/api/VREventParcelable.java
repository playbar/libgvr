//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.vrcore.logging.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.common.logging.nano.Vr.VREvent;

public class VREventParcelable implements Parcelable {
    private static final String TAG = VREventParcelable.class.getSimpleName();
    private int eventCode;
    private VREvent event;
    public static final Creator<VREventParcelable> CREATOR = new Creator() {
        public final VREventParcelable createFromParcel(Parcel var1) {
            return new VREventParcelable(var1);
        }

        public final VREventParcelable[] newArray(int var1) {
            return new VREventParcelable[var1];
        }
    };

    public VREventParcelable(int var1, VREvent var2) {
        this.eventCode = var1;
        this.event = var2;
    }

    private VREventParcelable(Parcel var1) {
        this.eventCode = var1.readInt();

        try {
            byte[] var2;
            if((var2 = var1.createByteArray()).length > 0) {
                this.event = VREvent.parseFrom(var2);
            }

        } catch (Exception var4) {
            String var10000 = TAG;
            String var3 = String.valueOf(var4);
            Log.i(var10000, (new StringBuilder(35 + String.valueOf(var3).length())).append("Logging with empty VREvent. Error: ").append(var3).toString());
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        var1.writeInt(this.eventCode);
        if(this.event != null) {
            var1.writeByteArray(VREvent.toByteArray(this.event));
        }

    }

    public VREvent getEvent() {
        return this.event;
    }

    public int getEventCode() {
        return this.eventCode;
    }
}
