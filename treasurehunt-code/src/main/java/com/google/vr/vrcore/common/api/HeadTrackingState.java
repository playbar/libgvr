//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.vrcore.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class HeadTrackingState implements Parcelable {
    private byte[] data;
    public static final Creator<HeadTrackingState> CREATOR = new Creator() {
        public final HeadTrackingState createFromParcel(Parcel var1) {
            return new HeadTrackingState(var1);
        }

        public final HeadTrackingState[] newArray(int var1) {
            return new HeadTrackingState[var1];
        }
    };

    public HeadTrackingState() {
        this.data = new byte[0];
    }

    public HeadTrackingState(byte[] var1) {
        this.data = new byte[0];
        this.data = var1;
    }

    private HeadTrackingState(Parcel var1) {
        this.data = new byte[0];
        this.readFromParcel(var1);
    }

    public byte[] getData() {
        return this.data;
    }

    public boolean isEmpty() {
        return this.data.length == 0;
    }

    public void setData(byte[] var1) {
        this.data = var1;
    }

    public void clear() {
        this.data = new byte[0];
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        var1.writeInt(this.data.length);
        var1.writeByteArray(this.data);
    }

    public void readFromParcel(Parcel var1) {
        int var2 = var1.readInt();
        this.data = new byte[var2];
        var1.readByteArray(this.data);
    }

    public String toString() {
        int var1 = this.data.length;
        return (new StringBuilder(36)).append("HeadTrackingState[").append(var1).append(" bytes]").toString();
    }

    public boolean equals(Object var1) {
        return var1 == this?true:(var1 instanceof HeadTrackingState?Arrays.equals(((HeadTrackingState)var1).data, this.data):false);
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }

    public void copyFrom(HeadTrackingState var1) {
        Parcel var2 = Parcel.obtain();
        var1.writeToParcel(var2, 0);
        var2.setDataPosition(0);
        this.readFromParcel(var2);
        var2.recycle();
    }
}
