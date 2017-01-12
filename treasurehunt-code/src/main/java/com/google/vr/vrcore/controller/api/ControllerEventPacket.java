//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.vr.vrcore.controller.api.ControllerAccelEvent;
import com.google.vr.vrcore.controller.api.ControllerButtonEvent;
import com.google.vr.vrcore.controller.api.ControllerGyroEvent;
import com.google.vr.vrcore.controller.api.ControllerOrientationEvent;
import com.google.vr.vrcore.controller.api.ControllerTouchEvent;
import java.util.ArrayDeque;

/** @deprecated */
@Deprecated
public class ControllerEventPacket implements Parcelable {
    private static final int SERIALIZED_FORMAT_VERSION = 1;
    protected static final int MAX_EVENTS = 16;
    private static ArrayDeque<ControllerEventPacket> pool = new ArrayDeque();
    private static Object poolLock = new Object();
    private int accelEventCount;
    private ControllerAccelEvent[] accelEvents;
    private int buttonEventCount;
    private ControllerButtonEvent[] buttonEvents;
    private int gyroEventCount;
    private ControllerGyroEvent[] gyroEvents;
    private int orientationEventCount;
    private ControllerOrientationEvent[] orientationEvents;
    private int touchEventCount;
    private ControllerTouchEvent[] touchEvents;
    public static final Creator<ControllerEventPacket> CREATOR = new Creator() {
        public final ControllerEventPacket createFromParcel(Parcel var1) {
            ControllerEventPacket var2;
            (var2 = ControllerEventPacket.obtain()).readFromParcel(var1);
            return var2;
        }

        public final ControllerEventPacket[] newArray(int var1) {
            return new ControllerEventPacket[var1];
        }
    };

    public ControllerEventPacket() {
        this.accelEvents = new ControllerAccelEvent[16];
        this.buttonEvents = new ControllerButtonEvent[16];
        this.gyroEvents = new ControllerGyroEvent[16];
        this.orientationEvents = new ControllerOrientationEvent[16];
        this.touchEvents = new ControllerTouchEvent[16];

        for(int var1 = 0; var1 < 16; ++var1) {
            this.accelEvents[var1] = new ControllerAccelEvent();
            this.buttonEvents[var1] = new ControllerButtonEvent();
            this.gyroEvents[var1] = new ControllerGyroEvent();
            this.orientationEvents[var1] = new ControllerOrientationEvent();
            this.touchEvents[var1] = new ControllerTouchEvent();
        }

        this.clear();
    }

    public void copyFrom(ControllerEventPacket var1) {
        this.accelEventCount = var1.accelEventCount;
        this.buttonEventCount = var1.buttonEventCount;
        this.gyroEventCount = var1.gyroEventCount;
        this.orientationEventCount = var1.orientationEventCount;
        this.touchEventCount = var1.touchEventCount;

        for(int var2 = 0; var2 < 16; ++var2) {
            this.accelEvents[var2].copyFrom(var1.accelEvents[var2]);
            this.buttonEvents[var2].copyFrom(var1.buttonEvents[var2]);
            this.gyroEvents[var2].copyFrom(var1.gyroEvents[var2]);
            this.orientationEvents[var2].copyFrom(var1.orientationEvents[var2]);
            this.touchEvents[var2].copyFrom(var1.touchEvents[var2]);
        }

    }

    protected ControllerEventPacket(Parcel var1) {
        this();
        this.readFromParcel(var1);
    }

    public void clear() {
        this.accelEventCount = 0;
        this.buttonEventCount = 0;
        this.gyroEventCount = 0;
        this.orientationEventCount = 0;
        this.touchEventCount = 0;
    }

    public int getAccelEventCount() {
        return this.accelEventCount;
    }

    public int getButtonEventCount() {
        return this.buttonEventCount;
    }

    public int getGyroEventCount() {
        return this.gyroEventCount;
    }

    public int getOrientationEventCount() {
        return this.orientationEventCount;
    }

    public int getTouchEventCount() {
        return this.touchEventCount;
    }

    public ControllerAccelEvent getAccelEvent(int var1) {
        if(var1 >= 0 && var1 < this.accelEventCount) {
            return this.accelEvents[var1];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public ControllerButtonEvent getButtonEvent(int var1) {
        if(var1 >= 0 && var1 < this.buttonEventCount) {
            return this.buttonEvents[var1];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public ControllerGyroEvent getGyroEvent(int var1) {
        if(var1 >= 0 && var1 < this.gyroEventCount) {
            return this.gyroEvents[var1];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public ControllerOrientationEvent getOrientationEvent(int var1) {
        if(var1 >= 0 && var1 < this.orientationEventCount) {
            return this.orientationEvents[var1];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public ControllerTouchEvent getTouchEvent(int var1) {
        if(var1 >= 0 && var1 < this.touchEventCount) {
            return this.touchEvents[var1];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public ControllerAccelEvent addAccelEvent() {
        if(this.accelEventCount >= 16) {
            throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
        } else {
            return this.accelEvents[this.accelEventCount++];
        }
    }

    public ControllerButtonEvent addButtonEvent() {
        if(this.buttonEventCount >= 16) {
            throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
        } else {
            return this.buttonEvents[this.buttonEventCount++];
        }
    }

    public ControllerGyroEvent addGyroEvent() {
        if(this.gyroEventCount >= 16) {
            throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
        } else {
            return this.gyroEvents[this.gyroEventCount++];
        }
    }

    public ControllerOrientationEvent addOrientationEvent() {
        if(this.orientationEventCount >= 16) {
            throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
        } else {
            return this.orientationEvents[this.orientationEventCount++];
        }
    }

    public ControllerTouchEvent addTouchEvent() {
        if(this.touchEventCount >= 16) {
            throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
        } else {
            return this.touchEvents[this.touchEventCount++];
        }
    }

    public static ControllerEventPacket obtain() {
        Object var0 = poolLock;
        synchronized(poolLock) {
            return pool.isEmpty()?new ControllerEventPacket():(ControllerEventPacket)pool.remove();
        }
    }

    public void recycle() {
        this.clear();
        Object var1 = poolLock;
        synchronized(poolLock) {
            if(!pool.contains(this)) {
                pool.add(this);
            }

        }
    }

    public int describeContents() {
        return 0;
    }

    protected int calculateParcelByteLength() {
        byte var1 = 4;
        int var3 = var1 + 20;

        int var2;
        for(var2 = 0; var2 < this.accelEventCount; ++var2) {
            var3 += this.accelEvents[var2].getByteSize();
        }

        for(var2 = 0; var2 < this.buttonEventCount; ++var2) {
            var3 += this.buttonEvents[var2].getByteSize();
        }

        for(var2 = 0; var2 < this.gyroEventCount; ++var2) {
            var3 += this.gyroEvents[var2].getByteSize();
        }

        for(var2 = 0; var2 < this.orientationEventCount; ++var2) {
            var3 += this.orientationEvents[var2].getByteSize();
        }

        for(var2 = 0; var2 < this.touchEventCount; ++var2) {
            var3 += this.touchEvents[var2].getByteSize();
        }

        return var3;
    }

    public void writeToParcel(Parcel var1, int var2) {
        var1.writeInt(1);
        var1.writeInt(this.accelEventCount);

        int var3;
        for(var3 = 0; var3 < this.accelEventCount; ++var3) {
            this.accelEvents[var3].writeToParcel(var1, var2);
        }

        var1.writeInt(this.buttonEventCount);

        for(var3 = 0; var3 < this.buttonEventCount; ++var3) {
            this.buttonEvents[var3].writeToParcel(var1, var2);
        }

        var1.writeInt(this.gyroEventCount);

        for(var3 = 0; var3 < this.gyroEventCount; ++var3) {
            this.gyroEvents[var3].writeToParcel(var1, var2);
        }

        var1.writeInt(this.orientationEventCount);

        for(var3 = 0; var3 < this.orientationEventCount; ++var3) {
            this.orientationEvents[var3].writeToParcel(var1, var2);
        }

        var1.writeInt(this.touchEventCount);

        for(var3 = 0; var3 < this.touchEventCount; ++var3) {
            this.touchEvents[var3].writeToParcel(var1, var2);
        }

    }

    public void readFromParcel(Parcel var1) {
        var1.readInt();
        this.accelEventCount = var1.readInt();
        this.checkIsValidEventCount(this.accelEventCount);

        int var2;
        for(var2 = 0; var2 < this.accelEventCount; ++var2) {
            this.accelEvents[var2].readFromParcel(var1);
        }

        this.buttonEventCount = var1.readInt();
        this.checkIsValidEventCount(this.buttonEventCount);

        for(var2 = 0; var2 < this.buttonEventCount; ++var2) {
            this.buttonEvents[var2].readFromParcel(var1);
        }

        this.gyroEventCount = var1.readInt();
        this.checkIsValidEventCount(this.gyroEventCount);

        for(var2 = 0; var2 < this.gyroEventCount; ++var2) {
            this.gyroEvents[var2].readFromParcel(var1);
        }

        this.orientationEventCount = var1.readInt();
        this.checkIsValidEventCount(this.orientationEventCount);

        for(var2 = 0; var2 < this.orientationEventCount; ++var2) {
            this.orientationEvents[var2].readFromParcel(var1);
        }

        this.touchEventCount = var1.readInt();
        this.checkIsValidEventCount(this.touchEventCount);

        for(var2 = 0; var2 < this.touchEventCount; ++var2) {
            this.touchEvents[var2].readFromParcel(var1);
        }

    }

    protected void checkIsValidEventCount(int var1) {
        if(var1 < 0 || var1 >= 16) {
            throw new IllegalArgumentException((new StringBuilder(32)).append("Invalid event count: ").append(var1).toString());
        }
    }
}
