//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vrtoolkit.cardboard.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

public interface CardboardDevice {
    public static final class ScreenAlignmentMarker extends ExtendableMessageNano<CardboardDevice.ScreenAlignmentMarker> implements Cloneable {
        private static volatile CardboardDevice.ScreenAlignmentMarker[] _emptyArray;
        private int bitField0_;
        private float horizontal_;
        private float vertical_;

        public static CardboardDevice.ScreenAlignmentMarker[] emptyArray() {
            if(_emptyArray == null) {
                Object var0 = InternalNano.LAZY_INIT_LOCK;
                synchronized(InternalNano.LAZY_INIT_LOCK) {
                    if(_emptyArray == null) {
                        _emptyArray = new CardboardDevice.ScreenAlignmentMarker[0];
                    }
                }
            }

            return _emptyArray;
        }

        public final float getHorizontal() {
            return this.horizontal_;
        }

        public final CardboardDevice.ScreenAlignmentMarker setHorizontal(float var1) {
            this.horizontal_ = var1;
            this.bitField0_ |= 1;
            return this;
        }

        public final boolean hasHorizontal() {
            return (this.bitField0_ & 1) != 0;
        }

        public final CardboardDevice.ScreenAlignmentMarker clearHorizontal() {
            this.horizontal_ = 0.0F;
            this.bitField0_ &= -2;
            return this;
        }

        public final float getVertical() {
            return this.vertical_;
        }

        public final CardboardDevice.ScreenAlignmentMarker setVertical(float var1) {
            this.vertical_ = var1;
            this.bitField0_ |= 2;
            return this;
        }

        public final boolean hasVertical() {
            return (this.bitField0_ & 2) != 0;
        }

        public final CardboardDevice.ScreenAlignmentMarker clearVertical() {
            this.vertical_ = 0.0F;
            this.bitField0_ &= -3;
            return this;
        }

        public ScreenAlignmentMarker() {
            this.clear();
        }

        public final CardboardDevice.ScreenAlignmentMarker clear() {
            this.bitField0_ = 0;
            this.horizontal_ = 0.0F;
            this.vertical_ = 0.0F;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final CardboardDevice.ScreenAlignmentMarker clone() {
            try {
                CardboardDevice.ScreenAlignmentMarker var1 = (CardboardDevice.ScreenAlignmentMarker)super.clone();
                return var1;
            } catch (CloneNotSupportedException var3) {
                throw new AssertionError(var3);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
            if((this.bitField0_ & 1) != 0) {
                var1.writeFloat(1, this.horizontal_);
            }

            if((this.bitField0_ & 2) != 0) {
                var1.writeFloat(2, this.vertical_);
            }

            super.writeTo(var1);
        }

        protected final int computeSerializedSize() {
            int var1 = super.computeSerializedSize();
            if((this.bitField0_ & 1) != 0) {
                var1 += CodedOutputByteBufferNano.computeFloatSize(1, this.horizontal_);
            }

            if((this.bitField0_ & 2) != 0) {
                var1 += CodedOutputByteBufferNano.computeFloatSize(2, this.vertical_);
            }

            return var1;
        }

        public final CardboardDevice.ScreenAlignmentMarker mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2;
                switch(var2 = var1.readTag()) {
                    case 0:
                        return this;
                    case 13:
                        this.horizontal_ = var1.readFloat();
                        this.bitField0_ |= 1;
                        break;
                    case 21:
                        this.vertical_ = var1.readFloat();
                        this.bitField0_ |= 2;
                        break;
                    default:
                        if(!super.storeUnknownField(var1, var2)) {
                            return this;
                        }
                }
            }
        }

        public static CardboardDevice.ScreenAlignmentMarker parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (CardboardDevice.ScreenAlignmentMarker)MessageNano.mergeFrom(new CardboardDevice.ScreenAlignmentMarker(), var0);
        }

        public static CardboardDevice.ScreenAlignmentMarker parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new CardboardDevice.ScreenAlignmentMarker()).mergeFrom(var0);
        }
    }

    public static final class DaydreamInternalParams extends ExtendableMessageNano<CardboardDevice.DaydreamInternalParams> implements Cloneable {
        private static volatile CardboardDevice.DaydreamInternalParams[] _emptyArray;
        private int bitField0_;
        private int version_;
        public CardboardDevice.ScreenAlignmentMarker[] alignmentMarkers;

        public static CardboardDevice.DaydreamInternalParams[] emptyArray() {
            if(_emptyArray == null) {
                Object var0 = InternalNano.LAZY_INIT_LOCK;
                synchronized(InternalNano.LAZY_INIT_LOCK) {
                    if(_emptyArray == null) {
                        _emptyArray = new CardboardDevice.DaydreamInternalParams[0];
                    }
                }
            }

            return _emptyArray;
        }

        public final int getVersion() {
            return this.version_;
        }

        public final CardboardDevice.DaydreamInternalParams setVersion(int var1) {
            this.version_ = var1;
            this.bitField0_ |= 1;
            return this;
        }

        public final boolean hasVersion() {
            return (this.bitField0_ & 1) != 0;
        }

        public final CardboardDevice.DaydreamInternalParams clearVersion() {
            this.version_ = 0;
            this.bitField0_ &= -2;
            return this;
        }

        public DaydreamInternalParams() {
            this.clear();
        }

        public final CardboardDevice.DaydreamInternalParams clear() {
            this.bitField0_ = 0;
            this.version_ = 0;
            this.alignmentMarkers = CardboardDevice.ScreenAlignmentMarker.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final CardboardDevice.DaydreamInternalParams clone() {
            CardboardDevice.DaydreamInternalParams var1;
            try {
                var1 = (CardboardDevice.DaydreamInternalParams)super.clone();
            } catch (CloneNotSupportedException var3) {
                throw new AssertionError(var3);
            }

            if(this.alignmentMarkers != null && this.alignmentMarkers.length > 0) {
                var1.alignmentMarkers = new CardboardDevice.ScreenAlignmentMarker[this.alignmentMarkers.length];

                for(int var2 = 0; var2 < this.alignmentMarkers.length; ++var2) {
                    if(this.alignmentMarkers[var2] != null) {
                        var1.alignmentMarkers[var2] = this.alignmentMarkers[var2].clone();
                    }
                }
            }

            return var1;
        }

        public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
            if((this.bitField0_ & 1) != 0) {
                var1.writeInt32(1, this.version_);
            }

            if(this.alignmentMarkers != null && this.alignmentMarkers.length > 0) {
                for(int var2 = 0; var2 < this.alignmentMarkers.length; ++var2) {
                    CardboardDevice.ScreenAlignmentMarker var3;
                    if((var3 = this.alignmentMarkers[var2]) != null) {
                        var1.writeMessage(2, var3);
                    }
                }
            }

            super.writeTo(var1);
        }

        protected final int computeSerializedSize() {
            int var1 = super.computeSerializedSize();
            if((this.bitField0_ & 1) != 0) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.version_);
            }

            if(this.alignmentMarkers != null && this.alignmentMarkers.length > 0) {
                for(int var2 = 0; var2 < this.alignmentMarkers.length; ++var2) {
                    CardboardDevice.ScreenAlignmentMarker var3;
                    if((var3 = this.alignmentMarkers[var2]) != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(2, var3);
                    }
                }
            }

            return var1;
        }

        public final CardboardDevice.DaydreamInternalParams mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2;
                int var4;
                CardboardDevice.ScreenAlignmentMarker[] var5;
                switch(var2 = var1.readTag()) {
                    case 0:
                        return this;
                    case 8:
                        this.version_ = var1.readInt32();
                        this.bitField0_ |= 1;
                        continue;
                    case 18:
                        int var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 18);
                        var5 = new CardboardDevice.ScreenAlignmentMarker[(var4 = this.alignmentMarkers == null?0:this.alignmentMarkers.length) + var3];
                        if(var4 != 0) {
                            System.arraycopy(this.alignmentMarkers, 0, var5, 0, var4);
                        }
                        break;
                    default:
                        if(super.storeUnknownField(var1, var2)) {
                            continue;
                        }

                        return this;
                }

                while(var4 < var5.length - 1) {
                    var5[var4] = new CardboardDevice.ScreenAlignmentMarker();
                    var1.readMessage(var5[var4]);
                    var1.readTag();
                    ++var4;
                }

                var5[var4] = new CardboardDevice.ScreenAlignmentMarker();
                var1.readMessage(var5[var4]);
                this.alignmentMarkers = var5;
            }
        }

        public static CardboardDevice.DaydreamInternalParams parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (CardboardDevice.DaydreamInternalParams)MessageNano.mergeFrom(new CardboardDevice.DaydreamInternalParams(), var0);
        }

        public static CardboardDevice.DaydreamInternalParams parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new CardboardDevice.DaydreamInternalParams()).mergeFrom(var0);
        }
    }

    public static final class CardboardInternalParams extends ExtendableMessageNano<CardboardDevice.CardboardInternalParams> implements Cloneable {
        private static volatile CardboardDevice.CardboardInternalParams[] _emptyArray;
        private int bitField0_;
        public int[] eyeOrientations;
        private float screenCenterToLensDistance_;
        private float xPpiOverride_;
        private float yPpiOverride_;
        private String accelerometer_;
        private String gyroscope_;

        public static CardboardDevice.CardboardInternalParams[] emptyArray() {
            if(_emptyArray == null) {
                Object var0 = InternalNano.LAZY_INIT_LOCK;
                synchronized(InternalNano.LAZY_INIT_LOCK) {
                    if(_emptyArray == null) {
                        _emptyArray = new CardboardDevice.CardboardInternalParams[0];
                    }
                }
            }

            return _emptyArray;
        }

        public final float getScreenCenterToLensDistance() {
            return this.screenCenterToLensDistance_;
        }

        public final CardboardDevice.CardboardInternalParams setScreenCenterToLensDistance(float var1) {
            this.screenCenterToLensDistance_ = var1;
            this.bitField0_ |= 1;
            return this;
        }

        public final boolean hasScreenCenterToLensDistance() {
            return (this.bitField0_ & 1) != 0;
        }

        public final CardboardDevice.CardboardInternalParams clearScreenCenterToLensDistance() {
            this.screenCenterToLensDistance_ = 0.0F;
            this.bitField0_ &= -2;
            return this;
        }

        public final float getXPpiOverride() {
            return this.xPpiOverride_;
        }

        public final CardboardDevice.CardboardInternalParams setXPpiOverride(float var1) {
            this.xPpiOverride_ = var1;
            this.bitField0_ |= 2;
            return this;
        }

        public final boolean hasXPpiOverride() {
            return (this.bitField0_ & 2) != 0;
        }

        public final CardboardDevice.CardboardInternalParams clearXPpiOverride() {
            this.xPpiOverride_ = 0.0F;
            this.bitField0_ &= -3;
            return this;
        }

        public final float getYPpiOverride() {
            return this.yPpiOverride_;
        }

        public final CardboardDevice.CardboardInternalParams setYPpiOverride(float var1) {
            this.yPpiOverride_ = var1;
            this.bitField0_ |= 4;
            return this;
        }

        public final boolean hasYPpiOverride() {
            return (this.bitField0_ & 4) != 0;
        }

        public final CardboardDevice.CardboardInternalParams clearYPpiOverride() {
            this.yPpiOverride_ = 0.0F;
            this.bitField0_ &= -5;
            return this;
        }

        public final String getAccelerometer() {
            return this.accelerometer_;
        }

        public final CardboardDevice.CardboardInternalParams setAccelerometer(String var1) {
            if(var1 == null) {
                throw new NullPointerException();
            } else {
                this.accelerometer_ = var1;
                this.bitField0_ |= 8;
                return this;
            }
        }

        public final boolean hasAccelerometer() {
            return (this.bitField0_ & 8) != 0;
        }

        public final CardboardDevice.CardboardInternalParams clearAccelerometer() {
            this.accelerometer_ = "";
            this.bitField0_ &= -9;
            return this;
        }

        public final String getGyroscope() {
            return this.gyroscope_;
        }

        public final CardboardDevice.CardboardInternalParams setGyroscope(String var1) {
            if(var1 == null) {
                throw new NullPointerException();
            } else {
                this.gyroscope_ = var1;
                this.bitField0_ |= 16;
                return this;
            }
        }

        public final boolean hasGyroscope() {
            return (this.bitField0_ & 16) != 0;
        }

        public final CardboardDevice.CardboardInternalParams clearGyroscope() {
            this.gyroscope_ = "";
            this.bitField0_ &= -17;
            return this;
        }

        public CardboardInternalParams() {
            this.clear();
        }

        public final CardboardDevice.CardboardInternalParams clear() {
            this.bitField0_ = 0;
            this.eyeOrientations = WireFormatNano.EMPTY_INT_ARRAY;
            this.screenCenterToLensDistance_ = 0.0F;
            this.xPpiOverride_ = 0.0F;
            this.yPpiOverride_ = 0.0F;
            this.accelerometer_ = "";
            this.gyroscope_ = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final CardboardDevice.CardboardInternalParams clone() {
            CardboardDevice.CardboardInternalParams var1;
            try {
                var1 = (CardboardDevice.CardboardInternalParams)super.clone();
            } catch (CloneNotSupportedException var3) {
                throw new AssertionError(var3);
            }

            if(this.eyeOrientations != null && this.eyeOrientations.length > 0) {
                var1.eyeOrientations = (int[])this.eyeOrientations.clone();
            }

            return var1;
        }

        public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
            if(this.eyeOrientations != null && this.eyeOrientations.length > 0) {
                int var2 = 0;

                int var3;
                for(var3 = 0; var3 < this.eyeOrientations.length; ++var3) {
                    int var4 = this.eyeOrientations[var3];
                    var2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var4);
                }

                var1.writeRawVarint32(10);
                var1.writeRawVarint32(var2);

                for(var3 = 0; var3 < this.eyeOrientations.length; ++var3) {
                    var1.writeRawVarint32(this.eyeOrientations[var3]);
                }
            }

            if((this.bitField0_ & 1) != 0) {
                var1.writeFloat(2, this.screenCenterToLensDistance_);
            }

            if((this.bitField0_ & 2) != 0) {
                var1.writeFloat(3, this.xPpiOverride_);
            }

            if((this.bitField0_ & 4) != 0) {
                var1.writeFloat(4, this.yPpiOverride_);
            }

            if((this.bitField0_ & 8) != 0) {
                var1.writeString(5, this.accelerometer_);
            }

            if((this.bitField0_ & 16) != 0) {
                var1.writeString(6, this.gyroscope_);
            }

            super.writeTo(var1);
        }

        protected final int computeSerializedSize() {
            int var1 = super.computeSerializedSize();
            if(this.eyeOrientations != null && this.eyeOrientations.length > 0) {
                int var2 = 0;

                for(int var3 = 0; var3 < this.eyeOrientations.length; ++var3) {
                    int var4 = this.eyeOrientations[var3];
                    var2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(var4);
                }

                var1 += var2;
                ++var1;
                var1 += CodedOutputByteBufferNano.computeRawVarint32Size(var2);
            }

            if((this.bitField0_ & 1) != 0) {
                var1 += CodedOutputByteBufferNano.computeFloatSize(2, this.screenCenterToLensDistance_);
            }

            if((this.bitField0_ & 2) != 0) {
                var1 += CodedOutputByteBufferNano.computeFloatSize(3, this.xPpiOverride_);
            }

            if((this.bitField0_ & 4) != 0) {
                var1 += CodedOutputByteBufferNano.computeFloatSize(4, this.yPpiOverride_);
            }

            if((this.bitField0_ & 8) != 0) {
                var1 += CodedOutputByteBufferNano.computeStringSize(5, this.accelerometer_);
            }

            if((this.bitField0_ & 16) != 0) {
                var1 += CodedOutputByteBufferNano.computeStringSize(6, this.gyroscope_);
            }

            return var1;
        }

        public final CardboardDevice.CardboardInternalParams mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2;
                int var3;
                int var5;
                int var6;
                int var7;
                switch(var2 = var1.readTag()) {
                    case 0:
                        return this;
                    case 8:
                        int[] var10 = new int[var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 8)];
                        var5 = 0;
                        var6 = 0;

                        while(var6 < var3) {
                            if(var6 != 0) {
                                var1.readTag();
                            }

                            switch(var7 = var1.readInt32()) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                    var10[var5++] = var7;
                                default:
                                    ++var6;
                            }
                        }

                        if(var5 == 0) {
                            break;
                        }

                        if((var6 = this.eyeOrientations == null?0:this.eyeOrientations.length) == 0 && var5 == var3) {
                            this.eyeOrientations = var10;
                            break;
                        }

                        int[] var11 = new int[var6 + var5];
                        if(var6 != 0) {
                            System.arraycopy(this.eyeOrientations, 0, var11, 0, var6);
                        }

                        System.arraycopy(var10, 0, var11, var6, var5);
                        this.eyeOrientations = var11;
                        break;
                    case 10:
                        var3 = var1.readRawVarint32();
                        int var4 = var1.pushLimit(var3);
                        var5 = 0;
                        var6 = var1.getPosition();

                        while(var1.getBytesUntilLimit() > 0) {
                            switch(var1.readInt32()) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                    ++var5;
                            }
                        }

                        if(var5 != 0) {
                            var1.rewindToPosition(var6);
                            int[] var8 = new int[(var7 = this.eyeOrientations == null?0:this.eyeOrientations.length) + var5];
                            if(var7 != 0) {
                                System.arraycopy(this.eyeOrientations, 0, var8, 0, var7);
                            }

                            while(var1.getBytesUntilLimit() > 0) {
                                int var9;
                                switch(var9 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                        var8[var7++] = var9;
                                }
                            }

                            this.eyeOrientations = var8;
                        }

                        var1.popLimit(var4);
                        break;
                    case 21:
                        this.screenCenterToLensDistance_ = var1.readFloat();
                        this.bitField0_ |= 1;
                        break;
                    case 29:
                        this.xPpiOverride_ = var1.readFloat();
                        this.bitField0_ |= 2;
                        break;
                    case 37:
                        this.yPpiOverride_ = var1.readFloat();
                        this.bitField0_ |= 4;
                        break;
                    case 42:
                        this.accelerometer_ = var1.readString();
                        this.bitField0_ |= 8;
                        break;
                    case 50:
                        this.gyroscope_ = var1.readString();
                        this.bitField0_ |= 16;
                        break;
                    default:
                        if(!super.storeUnknownField(var1, var2)) {
                            return this;
                        }
                }
            }
        }

        public static CardboardDevice.CardboardInternalParams parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (CardboardDevice.CardboardInternalParams)MessageNano.mergeFrom(new CardboardDevice.CardboardInternalParams(), var0);
        }

        public static CardboardDevice.CardboardInternalParams parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new CardboardDevice.CardboardInternalParams()).mergeFrom(var0);
        }

        public interface OrientationType {
            int CCW_0_DEGREES = 0;
            int CCW_90_DEGREES = 1;
            int CCW_180_DEGREES = 2;
            int CCW_270_DEGREES = 3;
            int CCW_0_DEGREES_MIRRORED = 4;
            int CCW_90_DEGREES_MIRRORED = 5;
            int CCW_180_DEGREES_MIRRORED = 6;
            int CCW_270_DEGREES_MIRRORED = 7;
        }
    }

    public static final class DeviceParams extends ExtendableMessageNano<CardboardDevice.DeviceParams> implements Cloneable {
        private static volatile CardboardDevice.DeviceParams[] _emptyArray;
        private int bitField0_;
        private String vendor_;
        private String model_;
        private float screenToLensDistance_;
        private float interLensDistance_;
        public float[] leftEyeFieldOfViewAngles;
        private int verticalAlignment_;
        private float trayToLensDistance_;
        public float[] distortionCoefficients;
        private boolean hasMagnet_;
        private int primaryButton_;
        public CardboardDevice.CardboardInternalParams internal;
        public CardboardDevice.DaydreamInternalParams daydreamInternal;

        public static CardboardDevice.DeviceParams[] emptyArray() {
            if(_emptyArray == null) {
                Object var0 = InternalNano.LAZY_INIT_LOCK;
                synchronized(InternalNano.LAZY_INIT_LOCK) {
                    if(_emptyArray == null) {
                        _emptyArray = new CardboardDevice.DeviceParams[0];
                    }
                }
            }

            return _emptyArray;
        }

        public final String getVendor() {
            return this.vendor_;
        }

        public final CardboardDevice.DeviceParams setVendor(String var1) {
            if(var1 == null) {
                throw new NullPointerException();
            } else {
                this.vendor_ = var1;
                this.bitField0_ |= 1;
                return this;
            }
        }

        public final boolean hasVendor() {
            return (this.bitField0_ & 1) != 0;
        }

        public final CardboardDevice.DeviceParams clearVendor() {
            this.vendor_ = "";
            this.bitField0_ &= -2;
            return this;
        }

        public final String getModel() {
            return this.model_;
        }

        public final CardboardDevice.DeviceParams setModel(String var1) {
            if(var1 == null) {
                throw new NullPointerException();
            } else {
                this.model_ = var1;
                this.bitField0_ |= 2;
                return this;
            }
        }

        public final boolean hasModel() {
            return (this.bitField0_ & 2) != 0;
        }

        public final CardboardDevice.DeviceParams clearModel() {
            this.model_ = "";
            this.bitField0_ &= -3;
            return this;
        }

        public final float getScreenToLensDistance() {
            return this.screenToLensDistance_;
        }

        public final CardboardDevice.DeviceParams setScreenToLensDistance(float var1) {
            this.screenToLensDistance_ = var1;
            this.bitField0_ |= 4;
            return this;
        }

        public final boolean hasScreenToLensDistance() {
            return (this.bitField0_ & 4) != 0;
        }

        public final CardboardDevice.DeviceParams clearScreenToLensDistance() {
            this.screenToLensDistance_ = 0.0F;
            this.bitField0_ &= -5;
            return this;
        }

        public final float getInterLensDistance() {
            return this.interLensDistance_;
        }

        public final CardboardDevice.DeviceParams setInterLensDistance(float var1) {
            this.interLensDistance_ = var1;
            this.bitField0_ |= 8;
            return this;
        }

        public final boolean hasInterLensDistance() {
            return (this.bitField0_ & 8) != 0;
        }

        public final CardboardDevice.DeviceParams clearInterLensDistance() {
            this.interLensDistance_ = 0.0F;
            this.bitField0_ &= -9;
            return this;
        }

        public final int getVerticalAlignment() {
            return this.verticalAlignment_;
        }

        public final CardboardDevice.DeviceParams setVerticalAlignment(int var1) {
            this.verticalAlignment_ = var1;
            this.bitField0_ |= 16;
            return this;
        }

        public final boolean hasVerticalAlignment() {
            return (this.bitField0_ & 16) != 0;
        }

        public final CardboardDevice.DeviceParams clearVerticalAlignment() {
            this.verticalAlignment_ = 0;
            this.bitField0_ &= -17;
            return this;
        }

        public final float getTrayToLensDistance() {
            return this.trayToLensDistance_;
        }

        public final CardboardDevice.DeviceParams setTrayToLensDistance(float var1) {
            this.trayToLensDistance_ = var1;
            this.bitField0_ |= 32;
            return this;
        }

        public final boolean hasTrayToLensDistance() {
            return (this.bitField0_ & 32) != 0;
        }

        public final CardboardDevice.DeviceParams clearTrayToLensDistance() {
            this.trayToLensDistance_ = 0.0F;
            this.bitField0_ &= -33;
            return this;
        }

        public final boolean getHasMagnet() {
            return this.hasMagnet_;
        }

        public final CardboardDevice.DeviceParams setHasMagnet(boolean var1) {
            this.hasMagnet_ = var1;
            this.bitField0_ |= 64;
            return this;
        }

        public final boolean hasHasMagnet() {
            return (this.bitField0_ & 64) != 0;
        }

        public final CardboardDevice.DeviceParams clearHasMagnet() {
            this.hasMagnet_ = false;
            this.bitField0_ &= -65;
            return this;
        }

        public final int getPrimaryButton() {
            return this.primaryButton_;
        }

        public final CardboardDevice.DeviceParams setPrimaryButton(int var1) {
            this.primaryButton_ = var1;
            this.bitField0_ |= 128;
            return this;
        }

        public final boolean hasPrimaryButton() {
            return (this.bitField0_ & 128) != 0;
        }

        public final CardboardDevice.DeviceParams clearPrimaryButton() {
            this.primaryButton_ = 1;
            this.bitField0_ &= -129;
            return this;
        }

        public DeviceParams() {
            this.clear();
        }

        public final CardboardDevice.DeviceParams clear() {
            this.bitField0_ = 0;
            this.vendor_ = "";
            this.model_ = "";
            this.screenToLensDistance_ = 0.0F;
            this.interLensDistance_ = 0.0F;
            this.leftEyeFieldOfViewAngles = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.verticalAlignment_ = 0;
            this.trayToLensDistance_ = 0.0F;
            this.distortionCoefficients = WireFormatNano.EMPTY_FLOAT_ARRAY;
            this.hasMagnet_ = false;
            this.primaryButton_ = 1;
            this.internal = null;
            this.daydreamInternal = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final CardboardDevice.DeviceParams clone() {
            CardboardDevice.DeviceParams var1;
            try {
                var1 = (CardboardDevice.DeviceParams)super.clone();
            } catch (CloneNotSupportedException var3) {
                throw new AssertionError(var3);
            }

            if(this.leftEyeFieldOfViewAngles != null && this.leftEyeFieldOfViewAngles.length > 0) {
                var1.leftEyeFieldOfViewAngles = (float[])this.leftEyeFieldOfViewAngles.clone();
            }

            if(this.distortionCoefficients != null && this.distortionCoefficients.length > 0) {
                var1.distortionCoefficients = (float[])this.distortionCoefficients.clone();
            }

            if(this.internal != null) {
                var1.internal = this.internal.clone();
            }

            if(this.daydreamInternal != null) {
                var1.daydreamInternal = this.daydreamInternal.clone();
            }

            return var1;
        }

        public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
            if((this.bitField0_ & 1) != 0) {
                var1.writeString(1, this.vendor_);
            }

            if((this.bitField0_ & 2) != 0) {
                var1.writeString(2, this.model_);
            }

            if((this.bitField0_ & 4) != 0) {
                var1.writeFloat(3, this.screenToLensDistance_);
            }

            if((this.bitField0_ & 8) != 0) {
                var1.writeFloat(4, this.interLensDistance_);
            }

            int var2;
            int var3;
            if(this.leftEyeFieldOfViewAngles != null && this.leftEyeFieldOfViewAngles.length > 0) {
                var2 = 4 * this.leftEyeFieldOfViewAngles.length;
                var1.writeRawVarint32(42);
                var1.writeRawVarint32(var2);

                for(var3 = 0; var3 < this.leftEyeFieldOfViewAngles.length; ++var3) {
                    var1.writeFloatNoTag(this.leftEyeFieldOfViewAngles[var3]);
                }
            }

            if((this.bitField0_ & 32) != 0) {
                var1.writeFloat(6, this.trayToLensDistance_);
            }

            if(this.distortionCoefficients != null && this.distortionCoefficients.length > 0) {
                var2 = 4 * this.distortionCoefficients.length;
                var1.writeRawVarint32(58);
                var1.writeRawVarint32(var2);

                for(var3 = 0; var3 < this.distortionCoefficients.length; ++var3) {
                    var1.writeFloatNoTag(this.distortionCoefficients[var3]);
                }
            }

            if((this.bitField0_ & 64) != 0) {
                var1.writeBool(10, this.hasMagnet_);
            }

            if((this.bitField0_ & 16) != 0) {
                var1.writeInt32(11, this.verticalAlignment_);
            }

            if((this.bitField0_ & 128) != 0) {
                var1.writeInt32(12, this.primaryButton_);
            }

            if(this.internal != null) {
                var1.writeMessage(1729, this.internal);
            }

            if(this.daydreamInternal != null) {
                var1.writeMessage(196883, this.daydreamInternal);
            }

            super.writeTo(var1);
        }

        protected final int computeSerializedSize() {
            int var1 = super.computeSerializedSize();
            if((this.bitField0_ & 1) != 0) {
                var1 += CodedOutputByteBufferNano.computeStringSize(1, this.vendor_);
            }

            if((this.bitField0_ & 2) != 0) {
                var1 += CodedOutputByteBufferNano.computeStringSize(2, this.model_);
            }

            if((this.bitField0_ & 4) != 0) {
                var1 += CodedOutputByteBufferNano.computeFloatSize(3, this.screenToLensDistance_);
            }

            if((this.bitField0_ & 8) != 0) {
                var1 += CodedOutputByteBufferNano.computeFloatSize(4, this.interLensDistance_);
            }

            int var2;
            if(this.leftEyeFieldOfViewAngles != null && this.leftEyeFieldOfViewAngles.length > 0) {
                var2 = 4 * this.leftEyeFieldOfViewAngles.length;
                var1 += var2;
                ++var1;
                var1 += CodedOutputByteBufferNano.computeRawVarint32Size(var2);
            }

            if((this.bitField0_ & 32) != 0) {
                var1 += CodedOutputByteBufferNano.computeFloatSize(6, this.trayToLensDistance_);
            }

            if(this.distortionCoefficients != null && this.distortionCoefficients.length > 0) {
                var2 = 4 * this.distortionCoefficients.length;
                var1 += var2;
                ++var1;
                var1 += CodedOutputByteBufferNano.computeRawVarint32Size(var2);
            }

            if((this.bitField0_ & 64) != 0) {
                var1 += CodedOutputByteBufferNano.computeBoolSize(10, this.hasMagnet_);
            }

            if((this.bitField0_ & 16) != 0) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(11, this.verticalAlignment_);
            }

            if((this.bitField0_ & 128) != 0) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(12, this.primaryButton_);
            }

            if(this.internal != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(1729, this.internal);
            }

            if(this.daydreamInternal != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(196883, this.daydreamInternal);
            }

            return var1;
        }

        public final CardboardDevice.DeviceParams mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2;
                int var3;
                int var4;
                float[] var5;
                int var6;
                float[] var7;
                int var8;
                switch(var2 = var1.readTag()) {
                    case 0:
                        return this;
                    case 10:
                        this.vendor_ = var1.readString();
                        this.bitField0_ |= 1;
                        continue;
                    case 18:
                        this.model_ = var1.readString();
                        this.bitField0_ |= 2;
                        continue;
                    case 29:
                        this.screenToLensDistance_ = var1.readFloat();
                        this.bitField0_ |= 4;
                        continue;
                    case 37:
                        this.interLensDistance_ = var1.readFloat();
                        this.bitField0_ |= 8;
                        continue;
                    case 42:
                        var3 = var1.readRawVarint32();
                        var4 = var1.pushLimit(var3);
                        var8 = var3 / 4;
                        var7 = new float[(var6 = this.leftEyeFieldOfViewAngles == null?0:this.leftEyeFieldOfViewAngles.length) + var8];
                        if(var6 != 0) {
                            System.arraycopy(this.leftEyeFieldOfViewAngles, 0, var7, 0, var6);
                        }
                        break;
                    case 45:
                        var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 45);
                        var5 = new float[(var4 = this.leftEyeFieldOfViewAngles == null?0:this.leftEyeFieldOfViewAngles.length) + var3];
                        if(var4 != 0) {
                            System.arraycopy(this.leftEyeFieldOfViewAngles, 0, var5, 0, var4);
                        }

                        while(var4 < var5.length - 1) {
                            var5[var4] = var1.readFloat();
                            var1.readTag();
                            ++var4;
                        }

                        var5[var4] = var1.readFloat();
                        this.leftEyeFieldOfViewAngles = var5;
                        continue;
                    case 53:
                        this.trayToLensDistance_ = var1.readFloat();
                        this.bitField0_ |= 32;
                        continue;
                    case 58:
                        var3 = var1.readRawVarint32();
                        var4 = var1.pushLimit(var3);
                        var8 = var3 / 4;
                        var7 = new float[(var6 = this.distortionCoefficients == null?0:this.distortionCoefficients.length) + var8];
                        if(var6 != 0) {
                            System.arraycopy(this.distortionCoefficients, 0, var7, 0, var6);
                        }

                        while(var6 < var7.length) {
                            var7[var6] = var1.readFloat();
                            ++var6;
                        }

                        this.distortionCoefficients = var7;
                        var1.popLimit(var4);
                        continue;
                    case 61:
                        var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 61);
                        var5 = new float[(var4 = this.distortionCoefficients == null?0:this.distortionCoefficients.length) + var3];
                        if(var4 != 0) {
                            System.arraycopy(this.distortionCoefficients, 0, var5, 0, var4);
                        }

                        while(var4 < var5.length - 1) {
                            var5[var4] = var1.readFloat();
                            var1.readTag();
                            ++var4;
                        }

                        var5[var4] = var1.readFloat();
                        this.distortionCoefficients = var5;
                        continue;
                    case 80:
                        this.hasMagnet_ = var1.readBool();
                        this.bitField0_ |= 64;
                        continue;
                    case 88:
                        switch(var3 = var1.readInt32()) {
                            case 0:
                            case 1:
                            case 2:
                                this.verticalAlignment_ = var3;
                                this.bitField0_ |= 16;
                            default:
                                continue;
                        }
                    case 96:
                        switch(var3 = var1.readInt32()) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                                this.primaryButton_ = var3;
                                this.bitField0_ |= 128;
                            default:
                                continue;
                        }
                    case 13834:
                        if(this.internal == null) {
                            this.internal = new CardboardDevice.CardboardInternalParams();
                        }

                        var1.readMessage(this.internal);
                        continue;
                    case 1575066:
                        if(this.daydreamInternal == null) {
                            this.daydreamInternal = new CardboardDevice.DaydreamInternalParams();
                        }

                        var1.readMessage(this.daydreamInternal);
                        continue;
                    default:
                        if(super.storeUnknownField(var1, var2)) {
                            continue;
                        }

                        return this;
                }

                while(var6 < var7.length) {
                    var7[var6] = var1.readFloat();
                    ++var6;
                }

                this.leftEyeFieldOfViewAngles = var7;
                var1.popLimit(var4);
            }
        }

        public static CardboardDevice.DeviceParams parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (CardboardDevice.DeviceParams)MessageNano.mergeFrom(new CardboardDevice.DeviceParams(), var0);
        }

        public static CardboardDevice.DeviceParams parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new CardboardDevice.DeviceParams()).mergeFrom(var0);
        }

        public interface ButtonType {
            int NONE = 0;
            int MAGNET = 1;
            int TOUCH = 2;
            int INDIRECT_TOUCH = 3;
        }

        public interface VerticalAlignmentType {
            int BOTTOM = 0;
            int CENTER = 1;
            int TOP = 2;
        }
    }
}
