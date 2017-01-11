//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.common.logging.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

public interface Vr {
    public static final class VREvent extends ExtendableMessageNano<Vr.VREvent> implements Cloneable {
        private static volatile Vr.VREvent[] _emptyArray;
        public Vr.VREvent.HeadMount headMount;
        public Vr.VREvent.Application application;
        public Long durationMs;
        public Vr.VREvent.Application[] installedVrApplications;
        public Vr.VREvent.Cyclops cyclops;
        public Vr.VREvent.QrCodeScan qrCodeScan;
        public String cohort;
        public Integer lifetimeCountBucket;
        public Vr.VREvent.PerformanceStats performanceStats;
        public Vr.VREvent.SensorStats sensorStats;
        public Vr.VREvent.AudioStats audioStats;
        public Vr.VREvent.EmbedVrWidget embedVrWidget;
        public Vr.VREvent.VrCore vrCore;
        public Vr.VREvent.EarthVr earthVr;
        public Vr.VREvent.Launcher launcher;
        public Vr.VREvent.Keyboard keyboard;
        public Vr.VREvent.Renderer renderer;
        public Vr.VREvent.Lullaby lullaby;
        public Vr.VREvent.StreetView streetView;
        public Vr.VREvent.Photos photos;
        public Vr.VREvent.VrHome vrHome;
        public Vr.VREvent.SdkConfigurationParams sdkConfiguration;

        public static Vr.VREvent[] emptyArray() {
            if(_emptyArray == null) {
                Object var0 = InternalNano.LAZY_INIT_LOCK;
                synchronized(InternalNano.LAZY_INIT_LOCK) {
                    if(_emptyArray == null) {
                        _emptyArray = new Vr.VREvent[0];
                    }
                }
            }

            return _emptyArray;
        }

        public VREvent() {
            this.clear();
        }

        public final Vr.VREvent clear() {
            this.headMount = null;
            this.application = null;
            this.durationMs = null;
            this.installedVrApplications = Vr.VREvent.Application.emptyArray();
            this.cyclops = null;
            this.qrCodeScan = null;
            this.cohort = null;
            this.performanceStats = null;
            this.sensorStats = null;
            this.audioStats = null;
            this.embedVrWidget = null;
            this.vrCore = null;
            this.earthVr = null;
            this.launcher = null;
            this.keyboard = null;
            this.renderer = null;
            this.lullaby = null;
            this.streetView = null;
            this.photos = null;
            this.vrHome = null;
            this.sdkConfiguration = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public final Vr.VREvent clone() {
            Vr.VREvent var1;
            try {
                var1 = (Vr.VREvent)super.clone();
            } catch (CloneNotSupportedException var3) {
                throw new AssertionError(var3);
            }

            if(this.headMount != null) {
                var1.headMount = this.headMount.clone();
            }

            if(this.application != null) {
                var1.application = this.application.clone();
            }

            if(this.installedVrApplications != null && this.installedVrApplications.length > 0) {
                var1.installedVrApplications = new Vr.VREvent.Application[this.installedVrApplications.length];

                for(int var2 = 0; var2 < this.installedVrApplications.length; ++var2) {
                    if(this.installedVrApplications[var2] != null) {
                        var1.installedVrApplications[var2] = this.installedVrApplications[var2].clone();
                    }
                }
            }

            if(this.cyclops != null) {
                var1.cyclops = this.cyclops.clone();
            }

            if(this.qrCodeScan != null) {
                var1.qrCodeScan = this.qrCodeScan.clone();
            }

            if(this.performanceStats != null) {
                var1.performanceStats = this.performanceStats.clone();
            }

            if(this.sensorStats != null) {
                var1.sensorStats = this.sensorStats.clone();
            }

            if(this.audioStats != null) {
                var1.audioStats = this.audioStats.clone();
            }

            if(this.embedVrWidget != null) {
                var1.embedVrWidget = this.embedVrWidget.clone();
            }

            if(this.vrCore != null) {
                var1.vrCore = this.vrCore.clone();
            }

            if(this.earthVr != null) {
                var1.earthVr = this.earthVr.clone();
            }

            if(this.launcher != null) {
                var1.launcher = this.launcher.clone();
            }

            if(this.keyboard != null) {
                var1.keyboard = this.keyboard.clone();
            }

            if(this.renderer != null) {
                var1.renderer = this.renderer.clone();
            }

            if(this.lullaby != null) {
                var1.lullaby = this.lullaby.clone();
            }

            if(this.streetView != null) {
                var1.streetView = this.streetView.clone();
            }

            if(this.photos != null) {
                var1.photos = this.photos.clone();
            }

            if(this.vrHome != null) {
                var1.vrHome = this.vrHome.clone();
            }

            if(this.sdkConfiguration != null) {
                var1.sdkConfiguration = this.sdkConfiguration.clone();
            }

            return var1;
        }

        public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
            if(this.headMount != null) {
                var1.writeMessage(1, this.headMount);
            }

            if(this.application != null) {
                var1.writeMessage(2, this.application);
            }

            if(this.durationMs != null) {
                var1.writeInt64(3, this.durationMs.longValue());
            }

            if(this.installedVrApplications != null && this.installedVrApplications.length > 0) {
                for(int var2 = 0; var2 < this.installedVrApplications.length; ++var2) {
                    Vr.VREvent.Application var3;
                    if((var3 = this.installedVrApplications[var2]) != null) {
                        var1.writeMessage(4, var3);
                    }
                }
            }

            if(this.cyclops != null) {
                var1.writeMessage(5, this.cyclops);
            }

            if(this.qrCodeScan != null) {
                var1.writeMessage(6, this.qrCodeScan);
            }

            if(this.cohort != null) {
                var1.writeString(7, this.cohort);
            }

            if(this.lifetimeCountBucket != null) {
                var1.writeInt32(8, this.lifetimeCountBucket.intValue());
            }

            if(this.performanceStats != null) {
                var1.writeMessage(9, this.performanceStats);
            }

            if(this.sensorStats != null) {
                var1.writeMessage(10, this.sensorStats);
            }

            if(this.audioStats != null) {
                var1.writeMessage(11, this.audioStats);
            }

            if(this.embedVrWidget != null) {
                var1.writeMessage(12, this.embedVrWidget);
            }

            if(this.vrCore != null) {
                var1.writeMessage(13, this.vrCore);
            }

            if(this.earthVr != null) {
                var1.writeMessage(14, this.earthVr);
            }

            if(this.launcher != null) {
                var1.writeMessage(15, this.launcher);
            }

            if(this.keyboard != null) {
                var1.writeMessage(16, this.keyboard);
            }

            if(this.renderer != null) {
                var1.writeMessage(17, this.renderer);
            }

            if(this.lullaby != null) {
                var1.writeMessage(18, this.lullaby);
            }

            if(this.streetView != null) {
                var1.writeMessage(19, this.streetView);
            }

            if(this.photos != null) {
                var1.writeMessage(20, this.photos);
            }

            if(this.vrHome != null) {
                var1.writeMessage(21, this.vrHome);
            }

            if(this.sdkConfiguration != null) {
                var1.writeMessage(22, this.sdkConfiguration);
            }

            super.writeTo(var1);
        }

        protected final int computeSerializedSize() {
            int var1 = super.computeSerializedSize();
            if(this.headMount != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(1, this.headMount);
            }

            if(this.application != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.application);
            }

            if(this.durationMs != null) {
                var1 += CodedOutputByteBufferNano.computeInt64Size(3, this.durationMs.longValue());
            }

            if(this.installedVrApplications != null && this.installedVrApplications.length > 0) {
                for(int var2 = 0; var2 < this.installedVrApplications.length; ++var2) {
                    Vr.VREvent.Application var3;
                    if((var3 = this.installedVrApplications[var2]) != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(4, var3);
                    }
                }
            }

            if(this.cyclops != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(5, this.cyclops);
            }

            if(this.qrCodeScan != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(6, this.qrCodeScan);
            }

            if(this.cohort != null) {
                var1 += CodedOutputByteBufferNano.computeStringSize(7, this.cohort);
            }

            if(this.lifetimeCountBucket != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(8, this.lifetimeCountBucket.intValue());
            }

            if(this.performanceStats != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(9, this.performanceStats);
            }

            if(this.sensorStats != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(10, this.sensorStats);
            }

            if(this.audioStats != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(11, this.audioStats);
            }

            if(this.embedVrWidget != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(12, this.embedVrWidget);
            }

            if(this.vrCore != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(13, this.vrCore);
            }

            if(this.earthVr != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(14, this.earthVr);
            }

            if(this.launcher != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(15, this.launcher);
            }

            if(this.keyboard != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(16, this.keyboard);
            }

            if(this.renderer != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(17, this.renderer);
            }

            if(this.lullaby != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(18, this.lullaby);
            }

            if(this.streetView != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(19, this.streetView);
            }

            if(this.photos != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(20, this.photos);
            }

            if(this.vrHome != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(21, this.vrHome);
            }

            if(this.sdkConfiguration != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(22, this.sdkConfiguration);
            }

            return var1;
        }

        public final Vr.VREvent mergeFrom(CodedInputByteBufferNano var1) throws IOException {
            while(true) {
                int var2;
                int var3;
                int var4;
                Vr.VREvent.Application[] var5;
                switch(var2 = var1.readTag()) {
                    case 0:
                        return this;
                    case 10:
                        if(this.headMount == null) {
                            this.headMount = new Vr.VREvent.HeadMount();
                        }

                        var1.readMessage(this.headMount);
                        continue;
                    case 18:
                        if(this.application == null) {
                            this.application = new Vr.VREvent.Application();
                        }

                        var1.readMessage(this.application);
                        continue;
                    case 24:
                        this.durationMs = Long.valueOf(var1.readInt64());
                        continue;
                    case 34:
                        var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 34);
                        var5 = new Vr.VREvent.Application[(var4 = this.installedVrApplications == null?0:this.installedVrApplications.length) + var3];
                        if(var4 != 0) {
                            System.arraycopy(this.installedVrApplications, 0, var5, 0, var4);
                        }
                        break;
                    case 42:
                        if(this.cyclops == null) {
                            this.cyclops = new Vr.VREvent.Cyclops();
                        }

                        var1.readMessage(this.cyclops);
                        continue;
                    case 50:
                        if(this.qrCodeScan == null) {
                            this.qrCodeScan = new Vr.VREvent.QrCodeScan();
                        }

                        var1.readMessage(this.qrCodeScan);
                        continue;
                    case 58:
                        this.cohort = var1.readString();
                        continue;
                    case 64:
                        switch(var3 = var1.readInt32()) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 11:
                            case 21:
                                this.lifetimeCountBucket = Integer.valueOf(var3);
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            default:
                                continue;
                        }
                    case 74:
                        if(this.performanceStats == null) {
                            this.performanceStats = new Vr.VREvent.PerformanceStats();
                        }

                        var1.readMessage(this.performanceStats);
                        continue;
                    case 82:
                        if(this.sensorStats == null) {
                            this.sensorStats = new Vr.VREvent.SensorStats();
                        }

                        var1.readMessage(this.sensorStats);
                        continue;
                    case 90:
                        if(this.audioStats == null) {
                            this.audioStats = new Vr.VREvent.AudioStats();
                        }

                        var1.readMessage(this.audioStats);
                        continue;
                    case 98:
                        if(this.embedVrWidget == null) {
                            this.embedVrWidget = new Vr.VREvent.EmbedVrWidget();
                        }

                        var1.readMessage(this.embedVrWidget);
                        continue;
                    case 106:
                        if(this.vrCore == null) {
                            this.vrCore = new Vr.VREvent.VrCore();
                        }

                        var1.readMessage(this.vrCore);
                        continue;
                    case 114:
                        if(this.earthVr == null) {
                            this.earthVr = new Vr.VREvent.EarthVr();
                        }

                        var1.readMessage(this.earthVr);
                        continue;
                    case 122:
                        if(this.launcher == null) {
                            this.launcher = new Vr.VREvent.Launcher();
                        }

                        var1.readMessage(this.launcher);
                        continue;
                    case 130:
                        if(this.keyboard == null) {
                            this.keyboard = new Vr.VREvent.Keyboard();
                        }

                        var1.readMessage(this.keyboard);
                        continue;
                    case 138:
                        if(this.renderer == null) {
                            this.renderer = new Vr.VREvent.Renderer();
                        }

                        var1.readMessage(this.renderer);
                        continue;
                    case 146:
                        if(this.lullaby == null) {
                            this.lullaby = new Vr.VREvent.Lullaby();
                        }

                        var1.readMessage(this.lullaby);
                        continue;
                    case 154:
                        if(this.streetView == null) {
                            this.streetView = new Vr.VREvent.StreetView();
                        }

                        var1.readMessage(this.streetView);
                        continue;
                    case 162:
                        if(this.photos == null) {
                            this.photos = new Vr.VREvent.Photos();
                        }

                        var1.readMessage(this.photos);
                        continue;
                    case 170:
                        if(this.vrHome == null) {
                            this.vrHome = new Vr.VREvent.VrHome();
                        }

                        var1.readMessage(this.vrHome);
                        continue;
                    case 178:
                        if(this.sdkConfiguration == null) {
                            this.sdkConfiguration = new Vr.VREvent.SdkConfigurationParams();
                        }

                        var1.readMessage(this.sdkConfiguration);
                        continue;
                    default:
                        if(super.storeUnknownField(var1, var2)) {
                            continue;
                        }

                        return this;
                }

                while(var4 < var5.length - 1) {
                    var5[var4] = new Vr.VREvent.Application();
                    var1.readMessage(var5[var4]);
                    var1.readTag();
                    ++var4;
                }

                var5[var4] = new Vr.VREvent.Application();
                var1.readMessage(var5[var4]);
                this.installedVrApplications = var5;
            }
        }

        public static Vr.VREvent parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
            return (Vr.VREvent)MessageNano.mergeFrom(new Vr.VREvent(), var0);
        }

        public static Vr.VREvent parseFrom(CodedInputByteBufferNano var0) throws IOException {
            return (new Vr.VREvent()).mergeFrom(var0);
        }

        public static final class StreetView extends ExtendableMessageNano<Vr.VREvent.StreetView> implements Cloneable {
            private static volatile Vr.VREvent.StreetView[] _emptyArray;
            public Vr.VREvent.StreetView.PanoSession panoSession;

            public static Vr.VREvent.StreetView[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.StreetView[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public StreetView() {
                this.clear();
            }

            public final Vr.VREvent.StreetView clear() {
                this.panoSession = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.StreetView clone() {
                Vr.VREvent.StreetView var1;
                try {
                    var1 = (Vr.VREvent.StreetView)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.panoSession != null) {
                    var1.panoSession = this.panoSession.clone();
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.panoSession != null) {
                    var1.writeMessage(1, this.panoSession);
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.panoSession != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(1, this.panoSession);
                }

                return var1;
            }

            public final Vr.VREvent.StreetView mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 10:
                            if(this.panoSession == null) {
                                this.panoSession = new Vr.VREvent.StreetView.PanoSession();
                            }

                            var1.readMessage(this.panoSession);
                            break;
                        default:
                            if(!super.storeUnknownField(var1, var2)) {
                                return this;
                            }
                    }
                }
            }

            public static Vr.VREvent.StreetView parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.StreetView)MessageNano.mergeFrom(new Vr.VREvent.StreetView(), var0);
            }

            public static Vr.VREvent.StreetView parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.StreetView()).mergeFrom(var0);
            }

            public static final class PanoSession extends ExtendableMessageNano<Vr.VREvent.StreetView.PanoSession> implements Cloneable {
                private static volatile Vr.VREvent.StreetView.PanoSession[] _emptyArray;
                public Integer source;
                public Integer panosAvailable;
                public Integer panosViewed;
                public Integer nodesNavigated;
                public Integer nextClicks;
                public Integer prevClicks;
                public Integer playPauseClicks;
                public Integer infoClicks;

                public static Vr.VREvent.StreetView.PanoSession[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.StreetView.PanoSession[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public PanoSession() {
                    this.clear();
                }

                public final Vr.VREvent.StreetView.PanoSession clear() {
                    this.panosAvailable = null;
                    this.panosViewed = null;
                    this.nodesNavigated = null;
                    this.nextClicks = null;
                    this.prevClicks = null;
                    this.playPauseClicks = null;
                    this.infoClicks = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.StreetView.PanoSession clone() {
                    try {
                        Vr.VREvent.StreetView.PanoSession var1 = (Vr.VREvent.StreetView.PanoSession)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.source != null) {
                        var1.writeInt32(1, this.source.intValue());
                    }

                    if(this.panosAvailable != null) {
                        var1.writeInt32(2, this.panosAvailable.intValue());
                    }

                    if(this.panosViewed != null) {
                        var1.writeInt32(3, this.panosViewed.intValue());
                    }

                    if(this.nodesNavigated != null) {
                        var1.writeInt32(4, this.nodesNavigated.intValue());
                    }

                    if(this.nextClicks != null) {
                        var1.writeInt32(5, this.nextClicks.intValue());
                    }

                    if(this.prevClicks != null) {
                        var1.writeInt32(6, this.prevClicks.intValue());
                    }

                    if(this.playPauseClicks != null) {
                        var1.writeInt32(7, this.playPauseClicks.intValue());
                    }

                    if(this.infoClicks != null) {
                        var1.writeInt32(8, this.infoClicks.intValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.source != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.source.intValue());
                    }

                    if(this.panosAvailable != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.panosAvailable.intValue());
                    }

                    if(this.panosViewed != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(3, this.panosViewed.intValue());
                    }

                    if(this.nodesNavigated != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(4, this.nodesNavigated.intValue());
                    }

                    if(this.nextClicks != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(5, this.nextClicks.intValue());
                    }

                    if(this.prevClicks != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(6, this.prevClicks.intValue());
                    }

                    if(this.playPauseClicks != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(7, this.playPauseClicks.intValue());
                    }

                    if(this.infoClicks != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(8, this.infoClicks.intValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.StreetView.PanoSession mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                int var3;
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                        this.source = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 16:
                                this.panosAvailable = Integer.valueOf(var1.readInt32());
                                break;
                            case 24:
                                this.panosViewed = Integer.valueOf(var1.readInt32());
                                break;
                            case 32:
                                this.nodesNavigated = Integer.valueOf(var1.readInt32());
                                break;
                            case 40:
                                this.nextClicks = Integer.valueOf(var1.readInt32());
                                break;
                            case 48:
                                this.prevClicks = Integer.valueOf(var1.readInt32());
                                break;
                            case 56:
                                this.playPauseClicks = Integer.valueOf(var1.readInt32());
                                break;
                            case 64:
                                this.infoClicks = Integer.valueOf(var1.readInt32());
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.StreetView.PanoSession parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.StreetView.PanoSession)MessageNano.mergeFrom(new Vr.VREvent.StreetView.PanoSession(), var0);
                }

                public static Vr.VREvent.StreetView.PanoSession parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.StreetView.PanoSession()).mergeFrom(var0);
                }

                public interface Source {
                    int SOURCE_UNKNOWN = 0;
                    int SOURCE_COLLECTION = 1;
                    int SOURCE_PANO = 2;
                    int SOURCE_SEARCH = 3;
                    int SOURCE_SEARCH_RESULTS = 4;
                }
            }
        }

        public static final class Lullaby extends ExtendableMessageNano<Vr.VREvent.Lullaby> implements Cloneable {
            private static volatile Vr.VREvent.Lullaby[] _emptyArray;
            public Integer uiElement;
            public Integer index;
            public String contentId;
            public Vr.VREvent.Lullaby.LoadTime loadTime;

            public static Vr.VREvent.Lullaby[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.Lullaby[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public Lullaby() {
                this.clear();
            }

            public final Vr.VREvent.Lullaby clear() {
                this.index = null;
                this.contentId = null;
                this.loadTime = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.Lullaby clone() {
                Vr.VREvent.Lullaby var1;
                try {
                    var1 = (Vr.VREvent.Lullaby)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.loadTime != null) {
                    var1.loadTime = this.loadTime.clone();
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.uiElement != null) {
                    var1.writeInt32(1, this.uiElement.intValue());
                }

                if(this.index != null) {
                    var1.writeInt32(2, this.index.intValue());
                }

                if(this.contentId != null) {
                    var1.writeString(3, this.contentId);
                }

                if(this.loadTime != null) {
                    var1.writeMessage(4, this.loadTime);
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.uiElement != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.uiElement.intValue());
                }

                if(this.index != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.index.intValue());
                }

                if(this.contentId != null) {
                    var1 += CodedOutputByteBufferNano.computeStringSize(3, this.contentId);
                }

                if(this.loadTime != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(4, this.loadTime);
                }

                return var1;
            }

            public final Vr.VREvent.Lullaby mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 8:
                            int var3;
                            switch(var3 = var1.readInt32()) {
                                case 0:
                                case 1:
                                case 1000:
                                case 1001:
                                case 1002:
                                case 1003:
                                case 1004:
                                case 1005:
                                case 1006:
                                case 1007:
                                case 2000:
                                case 2001:
                                case 2002:
                                case 2003:
                                case 2004:
                                case 2005:
                                case 2006:
                                case 2007:
                                case 2008:
                                case 2009:
                                case 2010:
                                case 2011:
                                case 2012:
                                case 2013:
                                case 2014:
                                case 2015:
                                case 2016:
                                case 2017:
                                case 2018:
                                case 2019:
                                case 2020:
                                case 2021:
                                    this.uiElement = Integer.valueOf(var3);
                                default:
                                    continue;
                            }
                        case 16:
                            this.index = Integer.valueOf(var1.readInt32());
                            break;
                        case 26:
                            this.contentId = var1.readString();
                            break;
                        case 34:
                            if(this.loadTime == null) {
                                this.loadTime = new Vr.VREvent.Lullaby.LoadTime();
                            }

                            var1.readMessage(this.loadTime);
                            break;
                        default:
                            if(!super.storeUnknownField(var1, var2)) {
                                return this;
                            }
                    }
                }
            }

            public static Vr.VREvent.Lullaby parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.Lullaby)MessageNano.mergeFrom(new Vr.VREvent.Lullaby(), var0);
            }

            public static Vr.VREvent.Lullaby parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.Lullaby()).mergeFrom(var0);
            }

            public static final class LoadTime extends ExtendableMessageNano<Vr.VREvent.Lullaby.LoadTime> implements Cloneable {
                private static volatile Vr.VREvent.Lullaby.LoadTime[] _emptyArray;
                public Integer assetType;
                public Long loadTimeMs;

                public static Vr.VREvent.Lullaby.LoadTime[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.Lullaby.LoadTime[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public LoadTime() {
                    this.clear();
                }

                public final Vr.VREvent.Lullaby.LoadTime clear() {
                    this.loadTimeMs = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.Lullaby.LoadTime clone() {
                    try {
                        Vr.VREvent.Lullaby.LoadTime var1 = (Vr.VREvent.Lullaby.LoadTime)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.assetType != null) {
                        var1.writeInt32(1, this.assetType.intValue());
                    }

                    if(this.loadTimeMs != null) {
                        var1.writeInt64(2, this.loadTimeMs.longValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.assetType != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.assetType.intValue());
                    }

                    if(this.loadTimeMs != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(2, this.loadTimeMs.longValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.Lullaby.LoadTime mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                int var3;
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                        this.assetType = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 16:
                                this.loadTimeMs = Long.valueOf(var1.readInt64());
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.Lullaby.LoadTime parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.Lullaby.LoadTime)MessageNano.mergeFrom(new Vr.VREvent.Lullaby.LoadTime(), var0);
                }

                public static Vr.VREvent.Lullaby.LoadTime parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.Lullaby.LoadTime()).mergeFrom(var0);
                }

                public interface AssetType {
                    int UNKNOWN = 0;
                    int PAGE = 1;
                    int TEXT = 2;
                    int SOUND_WAV = 3;
                    int SOUND_OGG = 4;
                    int TEXTURE_PNG = 5;
                    int TEXTURE_JPEG = 6;
                    int TEXTURE_WEBP = 7;
                    int TEXTURE_FIFE_PNG = 8;
                    int TEXTURE_FIFE_JPEG = 9;
                    int TEXTURE_FIFE_WEBP = 10;
                }
            }

            public interface UiElement {
                int UNKNOWN = 0;
                int BACK_BUTTON = 1;
                int LAUNCHER_MAIN = 1000;
                int LAUNCHER_DISCOVERY_WINDOW = 1001;
                int LAUNCHER_RECENT_APP_CARD = 1002;
                int LAUNCHER_SETTINGS_BUTTON = 1003;
                int LAUNCHER_LIBRARY_BUTTON = 1004;
                int LAUNCHER_PLAY_STORE_BUTTON = 1005;
                int LAUNCHER_LIBRARY = 1006;
                int LAUNCHER_LIBRARY_APP_CARD = 1007;
                int PLAY_STORE_MAIN = 2000;
                int PLAY_STORE_MAIN_FEATURED_CAROUSEL_CARD = 2001;
                int PLAY_STORE_MAIN_FEATURED_ACTIVE_CARD = 2002;
                int PLAY_STORE_MAIN_COLLECTION = 2003;
                int PLAY_STORE_MAIN_COLLECTION_TITLE_CARD = 2004;
                int PLAY_STORE_MAIN_COLLECTION_APP_CARD = 2005;
                int PLAY_STORE_MAIN_FEATURED_COLLECTION = 2006;
                int PLAY_STORE_COLLECTION_PAGE = 2007;
                int PLAY_STORE_COLLECTION_APP_CARD = 2008;
                int PLAY_STORE_DETAILS = 2009;
                int PLAY_STORE_DETAILS_PANO = 2010;
                int PLAY_STORE_DETAILS_MORE_DETAILS_BUTTON = 2011;
                int PLAY_STORE_DETAILS_OPEN_BUTTON = 2012;
                int PLAY_STORE_DETAILS_INSTALL_BUTTON = 2013;
                int PLAY_STORE_DETAILS_BUY_BUTTON = 2014;
                int PLAY_STORE_DETAILS_UPDATE_BUTTON = 2015;
                int PLAY_STORE_DETAILS_NO_DAYDREAM = 2016;
                int PLAY_STORE_MORE_DETAILS = 2017;
                int PLAY_STORE_TOS_DIALOG = 2018;
                int PLAY_STORE_TOS_DIALOG_EXIT_VR_BUTTON = 2019;
                int PLAY_STORE_NETWORK_ERROR = 2020;
                int PLAY_STORE_NETWORK_ERROR_RETRY_BUTTON = 2021;
            }
        }

        public static final class Keyboard extends ExtendableMessageNano<Vr.VREvent.Keyboard> implements Cloneable {
            private static volatile Vr.VREvent.Keyboard[] _emptyArray;
            public Vr.VREvent.Keyboard.KeyboardEvent[] keyboardEvents;

            public static Vr.VREvent.Keyboard[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.Keyboard[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public Keyboard() {
                this.clear();
            }

            public final Vr.VREvent.Keyboard clear() {
                this.keyboardEvents = Vr.VREvent.Keyboard.KeyboardEvent.emptyArray();
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.Keyboard clone() {
                Vr.VREvent.Keyboard var1;
                try {
                    var1 = (Vr.VREvent.Keyboard)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.keyboardEvents != null && this.keyboardEvents.length > 0) {
                    var1.keyboardEvents = new Vr.VREvent.Keyboard.KeyboardEvent[this.keyboardEvents.length];

                    for(int var2 = 0; var2 < this.keyboardEvents.length; ++var2) {
                        if(this.keyboardEvents[var2] != null) {
                            var1.keyboardEvents[var2] = this.keyboardEvents[var2].clone();
                        }
                    }
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.keyboardEvents != null && this.keyboardEvents.length > 0) {
                    for(int var2 = 0; var2 < this.keyboardEvents.length; ++var2) {
                        Vr.VREvent.Keyboard.KeyboardEvent var3;
                        if((var3 = this.keyboardEvents[var2]) != null) {
                            var1.writeMessage(2, var3);
                        }
                    }
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.keyboardEvents != null && this.keyboardEvents.length > 0) {
                    for(int var2 = 0; var2 < this.keyboardEvents.length; ++var2) {
                        Vr.VREvent.Keyboard.KeyboardEvent var3;
                        if((var3 = this.keyboardEvents[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(2, var3);
                        }
                    }
                }

                return var1;
            }

            public final Vr.VREvent.Keyboard mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    int var4;
                    Vr.VREvent.Keyboard.KeyboardEvent[] var5;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 18:
                            int var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 18);
                            var5 = new Vr.VREvent.Keyboard.KeyboardEvent[(var4 = this.keyboardEvents == null?0:this.keyboardEvents.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.keyboardEvents, 0, var5, 0, var4);
                            }
                            break;
                        default:
                            if(super.storeUnknownField(var1, var2)) {
                                continue;
                            }

                            return this;
                    }

                    while(var4 < var5.length - 1) {
                        var5[var4] = new Vr.VREvent.Keyboard.KeyboardEvent();
                        var1.readMessage(var5[var4]);
                        var1.readTag();
                        ++var4;
                    }

                    var5[var4] = new Vr.VREvent.Keyboard.KeyboardEvent();
                    var1.readMessage(var5[var4]);
                    this.keyboardEvents = var5;
                }
            }

            public static Vr.VREvent.Keyboard parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.Keyboard)MessageNano.mergeFrom(new Vr.VREvent.Keyboard(), var0);
            }

            public static Vr.VREvent.Keyboard parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.Keyboard()).mergeFrom(var0);
            }

            public static final class KeyboardEvent extends ExtendableMessageNano<Vr.VREvent.Keyboard.KeyboardEvent> implements Cloneable {
                private static volatile Vr.VREvent.Keyboard.KeyboardEvent[] _emptyArray;
                public Long clientTimestamp;
                public Integer eventType;
                public Vr.VREvent.Keyboard.KeyboardTextEntry textEntry;
                public Vr.VREvent.Application keyboardService;
                public String[] systemLanguages;
                public String[] enabledLanguages;
                public String language;
                public Integer inputType;
                public String layout;

                public static Vr.VREvent.Keyboard.KeyboardEvent[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.Keyboard.KeyboardEvent[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public KeyboardEvent() {
                    this.clear();
                }

                public final Vr.VREvent.Keyboard.KeyboardEvent clear() {
                    this.clientTimestamp = null;
                    this.textEntry = null;
                    this.keyboardService = null;
                    this.systemLanguages = WireFormatNano.EMPTY_STRING_ARRAY;
                    this.enabledLanguages = WireFormatNano.EMPTY_STRING_ARRAY;
                    this.language = null;
                    this.layout = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.Keyboard.KeyboardEvent clone() {
                    Vr.VREvent.Keyboard.KeyboardEvent var1;
                    try {
                        var1 = (Vr.VREvent.Keyboard.KeyboardEvent)super.clone();
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }

                    if(this.textEntry != null) {
                        var1.textEntry = this.textEntry.clone();
                    }

                    if(this.keyboardService != null) {
                        var1.keyboardService = this.keyboardService.clone();
                    }

                    if(this.systemLanguages != null && this.systemLanguages.length > 0) {
                        var1.systemLanguages = (String[])this.systemLanguages.clone();
                    }

                    if(this.enabledLanguages != null && this.enabledLanguages.length > 0) {
                        var1.enabledLanguages = (String[])this.enabledLanguages.clone();
                    }

                    return var1;
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.clientTimestamp != null) {
                        var1.writeInt64(1, this.clientTimestamp.longValue());
                    }

                    if(this.eventType != null) {
                        var1.writeInt32(2, this.eventType.intValue());
                    }

                    if(this.textEntry != null) {
                        var1.writeMessage(3, this.textEntry);
                    }

                    if(this.keyboardService != null) {
                        var1.writeMessage(4, this.keyboardService);
                    }

                    int var2;
                    String var3;
                    if(this.systemLanguages != null && this.systemLanguages.length > 0) {
                        for(var2 = 0; var2 < this.systemLanguages.length; ++var2) {
                            if((var3 = this.systemLanguages[var2]) != null) {
                                var1.writeString(5, var3);
                            }
                        }
                    }

                    if(this.enabledLanguages != null && this.enabledLanguages.length > 0) {
                        for(var2 = 0; var2 < this.enabledLanguages.length; ++var2) {
                            if((var3 = this.enabledLanguages[var2]) != null) {
                                var1.writeString(6, var3);
                            }
                        }
                    }

                    if(this.language != null) {
                        var1.writeString(7, this.language);
                    }

                    if(this.inputType != null) {
                        var1.writeInt32(8, this.inputType.intValue());
                    }

                    if(this.layout != null) {
                        var1.writeString(9, this.layout);
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.clientTimestamp != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(1, this.clientTimestamp.longValue());
                    }

                    if(this.eventType != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.eventType.intValue());
                    }

                    if(this.textEntry != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(3, this.textEntry);
                    }

                    if(this.keyboardService != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(4, this.keyboardService);
                    }

                    int var2;
                    int var3;
                    int var4;
                    String var5;
                    if(this.systemLanguages != null && this.systemLanguages.length > 0) {
                        var2 = 0;
                        var3 = 0;

                        for(var4 = 0; var4 < this.systemLanguages.length; ++var4) {
                            if((var5 = this.systemLanguages[var4]) != null) {
                                ++var2;
                                var3 += CodedOutputByteBufferNano.computeStringSizeNoTag(var5);
                            }
                        }

                        var1 = var1 + var3 + 1 * var2;
                    }

                    if(this.enabledLanguages != null && this.enabledLanguages.length > 0) {
                        var2 = 0;
                        var3 = 0;

                        for(var4 = 0; var4 < this.enabledLanguages.length; ++var4) {
                            if((var5 = this.enabledLanguages[var4]) != null) {
                                ++var2;
                                var3 += CodedOutputByteBufferNano.computeStringSizeNoTag(var5);
                            }
                        }

                        var1 = var1 + var3 + 1 * var2;
                    }

                    if(this.language != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(7, this.language);
                    }

                    if(this.inputType != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(8, this.inputType.intValue());
                    }

                    if(this.layout != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(9, this.layout);
                    }

                    return var1;
                }

                public final Vr.VREvent.Keyboard.KeyboardEvent mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        int var3;
                        int var4;
                        String[] var5;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                this.clientTimestamp = Long.valueOf(var1.readInt64());
                                continue;
                            case 16:
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 1000:
                                    case 1001:
                                    case 2000:
                                        this.eventType = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 26:
                                if(this.textEntry == null) {
                                    this.textEntry = new Vr.VREvent.Keyboard.KeyboardTextEntry();
                                }

                                var1.readMessage(this.textEntry);
                                continue;
                            case 34:
                                if(this.keyboardService == null) {
                                    this.keyboardService = new Vr.VREvent.Application();
                                }

                                var1.readMessage(this.keyboardService);
                                continue;
                            case 42:
                                var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 42);
                                var5 = new String[(var4 = this.systemLanguages == null?0:this.systemLanguages.length) + var3];
                                if(var4 != 0) {
                                    System.arraycopy(this.systemLanguages, 0, var5, 0, var4);
                                }
                                break;
                            case 50:
                                var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 50);
                                var5 = new String[(var4 = this.enabledLanguages == null?0:this.enabledLanguages.length) + var3];
                                if(var4 != 0) {
                                    System.arraycopy(this.enabledLanguages, 0, var5, 0, var4);
                                }

                                while(var4 < var5.length - 1) {
                                    var5[var4] = var1.readString();
                                    var1.readTag();
                                    ++var4;
                                }

                                var5[var4] = var1.readString();
                                this.enabledLanguages = var5;
                                continue;
                            case 58:
                                this.language = var1.readString();
                                continue;
                            case 64:
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                        this.inputType = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 74:
                                this.layout = var1.readString();
                                continue;
                            default:
                                if(super.storeUnknownField(var1, var2)) {
                                    continue;
                                }

                                return this;
                        }

                        while(var4 < var5.length - 1) {
                            var5[var4] = var1.readString();
                            var1.readTag();
                            ++var4;
                        }

                        var5[var4] = var1.readString();
                        this.systemLanguages = var5;
                    }
                }

                public static Vr.VREvent.Keyboard.KeyboardEvent parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.Keyboard.KeyboardEvent)MessageNano.mergeFrom(new Vr.VREvent.Keyboard.KeyboardEvent(), var0);
                }

                public static Vr.VREvent.Keyboard.KeyboardEvent parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.Keyboard.KeyboardEvent()).mergeFrom(var0);
                }
            }

            public static final class KeyboardTextEntry extends ExtendableMessageNano<Vr.VREvent.Keyboard.KeyboardTextEntry> implements Cloneable {
                private static volatile Vr.VREvent.Keyboard.KeyboardTextEntry[] _emptyArray;
                public Integer type;
                public Integer length;
                public String layout;
                public String language;

                public static Vr.VREvent.Keyboard.KeyboardTextEntry[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.Keyboard.KeyboardTextEntry[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public KeyboardTextEntry() {
                    this.clear();
                }

                public final Vr.VREvent.Keyboard.KeyboardTextEntry clear() {
                    this.length = null;
                    this.layout = null;
                    this.language = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.Keyboard.KeyboardTextEntry clone() {
                    try {
                        Vr.VREvent.Keyboard.KeyboardTextEntry var1 = (Vr.VREvent.Keyboard.KeyboardTextEntry)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.type != null) {
                        var1.writeInt32(1, this.type.intValue());
                    }

                    if(this.length != null) {
                        var1.writeInt32(2, this.length.intValue());
                    }

                    if(this.layout != null) {
                        var1.writeString(3, this.layout);
                    }

                    if(this.language != null) {
                        var1.writeString(4, this.language);
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.type != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.type.intValue());
                    }

                    if(this.length != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.length.intValue());
                    }

                    if(this.layout != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(3, this.layout);
                    }

                    if(this.language != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(4, this.language);
                    }

                    return var1;
                }

                public final Vr.VREvent.Keyboard.KeyboardTextEntry mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                int var3;
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 4:
                                    case 5:
                                        this.type = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 16:
                                this.length = Integer.valueOf(var1.readInt32());
                                break;
                            case 26:
                                this.layout = var1.readString();
                                break;
                            case 34:
                                this.language = var1.readString();
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.Keyboard.KeyboardTextEntry parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.Keyboard.KeyboardTextEntry)MessageNano.mergeFrom(new Vr.VREvent.Keyboard.KeyboardTextEntry(), var0);
                }

                public static Vr.VREvent.Keyboard.KeyboardTextEntry parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.Keyboard.KeyboardTextEntry()).mergeFrom(var0);
                }
            }

            public interface KeyboardTextType {
                int TEXT_UNKNOWN = 0;
                int TEXT_SPACE = 4;
                int TEXT_SUGGESTION = 5;
            }

            public interface KeyboardInputType {
                int KEYBOARD_INPUT_TYPE_UNKNOWN = 0;
                int KEYBOARD_INPUT_TYPE_DEFAULT = 1;
            }

            public interface KeyboardEventType {
                int KEYBOARD_EVENT_UNKNOWN = 0;
                int KEYBOARD_USER_EVENT_SHOW = 1;
                int KEYBOARD_USER_EVENT_HIDE = 2;
                int KEYBOARD_USER_EVENT_COMMIT = 3;
                int KEYBOARD_USER_EVENT_DELETE = 4;
                int KEYBOARD_USER_EVENT_RETURN = 5;
                int KEYBOARD_USER_EVENT_DISMISS = 6;
                int KEYBOARD_USER_EVENT_CHANGE_LANGUAGE = 7;
                int KEYBOARD_USER_EVENT_CHANGE_LAYOUT = 8;
                int KEYBOARD_ERROR_NOT_INSTALLED = 1000;
                int KEYBOARD_ERROR_NO_LOCALES = 1001;
                int KEYBOARD_EVENT_CONNECTED = 2000;
            }
        }

        public static final class Launcher extends ExtendableMessageNano<Vr.VREvent.Launcher> implements Cloneable {
            private static volatile Vr.VREvent.Launcher[] _emptyArray;
            public Integer navItem;

            public static Vr.VREvent.Launcher[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.Launcher[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public Launcher() {
                this.clear();
            }

            public final Vr.VREvent.Launcher clear() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.Launcher clone() {
                try {
                    Vr.VREvent.Launcher var1 = (Vr.VREvent.Launcher)super.clone();
                    return var1;
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.navItem != null) {
                    var1.writeInt32(1, this.navItem.intValue());
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.navItem != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.navItem.intValue());
                }

                return var1;
            }

            public final Vr.VREvent.Launcher mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 8:
                            int var3;
                            switch(var3 = var1.readInt32()) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 6:
                                case 7:
                                case 8:
                                    this.navItem = Integer.valueOf(var3);
                                case 4:
                                case 5:
                                default:
                                    continue;
                            }
                        default:
                            if(!super.storeUnknownField(var1, var2)) {
                                return this;
                            }
                    }
                }
            }

            public static Vr.VREvent.Launcher parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.Launcher)MessageNano.mergeFrom(new Vr.VREvent.Launcher(), var0);
            }

            public static Vr.VREvent.Launcher parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.Launcher()).mergeFrom(var0);
            }

            public interface NavItem {
                int UNKNOWN = 0;
                int SETTINGS = 1;
                int FEEDBACK = 2;
                int HELP = 3;
                int DISCOVERY = 6;
                int LIBRARY = 7;
                int WISHLIST = 8;
            }
        }

        public static final class EarthVr extends ExtendableMessageNano<Vr.VREvent.EarthVr> implements Cloneable {
            private static volatile Vr.VREvent.EarthVr[] _emptyArray;
            public Vr.VREvent.DoublePrecisionTransform startFromKeyholeTransform;
            public Vr.VREvent.Transform startFromHeadTransform;
            public Vr.VREvent.EarthVr.ControllerState[] controllerStates;
            public Vr.VREvent.EarthVr.AppState appState;
            public Vr.VREvent.EarthVr.View view;
            public Vr.VREvent.EarthVr.Menu menu;
            public Vr.VREvent.EarthVr.Preferences preferences;
            public Vr.VREvent.EarthVr.Tour tour;
            public Vr.VREvent.EarthVr.Tutorial tutorial;
            public Vr.VREvent.EarthVr.Actor[] actors;
            public Vr.VREvent.EarthVr.Environment environment;
            public Vr.VREvent.EarthVr.SplashScreen splashScreen;

            public static Vr.VREvent.EarthVr[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.EarthVr[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public EarthVr() {
                this.clear();
            }

            public final Vr.VREvent.EarthVr clear() {
                this.startFromKeyholeTransform = null;
                this.startFromHeadTransform = null;
                this.controllerStates = Vr.VREvent.EarthVr.ControllerState.emptyArray();
                this.appState = null;
                this.view = null;
                this.menu = null;
                this.preferences = null;
                this.tour = null;
                this.tutorial = null;
                this.actors = Vr.VREvent.EarthVr.Actor.emptyArray();
                this.environment = null;
                this.splashScreen = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.EarthVr clone() {
                Vr.VREvent.EarthVr var1;
                try {
                    var1 = (Vr.VREvent.EarthVr)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.startFromKeyholeTransform != null) {
                    var1.startFromKeyholeTransform = this.startFromKeyholeTransform.clone();
                }

                if(this.startFromHeadTransform != null) {
                    var1.startFromHeadTransform = this.startFromHeadTransform.clone();
                }

                int var2;
                if(this.controllerStates != null && this.controllerStates.length > 0) {
                    var1.controllerStates = new Vr.VREvent.EarthVr.ControllerState[this.controllerStates.length];

                    for(var2 = 0; var2 < this.controllerStates.length; ++var2) {
                        if(this.controllerStates[var2] != null) {
                            var1.controllerStates[var2] = this.controllerStates[var2].clone();
                        }
                    }
                }

                if(this.appState != null) {
                    var1.appState = this.appState.clone();
                }

                if(this.view != null) {
                    var1.view = this.view.clone();
                }

                if(this.menu != null) {
                    var1.menu = this.menu.clone();
                }

                if(this.preferences != null) {
                    var1.preferences = this.preferences.clone();
                }

                if(this.tour != null) {
                    var1.tour = this.tour.clone();
                }

                if(this.tutorial != null) {
                    var1.tutorial = this.tutorial.clone();
                }

                if(this.actors != null && this.actors.length > 0) {
                    var1.actors = new Vr.VREvent.EarthVr.Actor[this.actors.length];

                    for(var2 = 0; var2 < this.actors.length; ++var2) {
                        if(this.actors[var2] != null) {
                            var1.actors[var2] = this.actors[var2].clone();
                        }
                    }
                }

                if(this.environment != null) {
                    var1.environment = this.environment.clone();
                }

                if(this.splashScreen != null) {
                    var1.splashScreen = this.splashScreen.clone();
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.startFromKeyholeTransform != null) {
                    var1.writeMessage(1, this.startFromKeyholeTransform);
                }

                if(this.startFromHeadTransform != null) {
                    var1.writeMessage(2, this.startFromHeadTransform);
                }

                int var2;
                if(this.controllerStates != null && this.controllerStates.length > 0) {
                    for(var2 = 0; var2 < this.controllerStates.length; ++var2) {
                        Vr.VREvent.EarthVr.ControllerState var3;
                        if((var3 = this.controllerStates[var2]) != null) {
                            var1.writeMessage(3, var3);
                        }
                    }
                }

                if(this.appState != null) {
                    var1.writeMessage(4, this.appState);
                }

                if(this.view != null) {
                    var1.writeMessage(5, this.view);
                }

                if(this.menu != null) {
                    var1.writeMessage(6, this.menu);
                }

                if(this.preferences != null) {
                    var1.writeMessage(7, this.preferences);
                }

                if(this.tour != null) {
                    var1.writeMessage(8, this.tour);
                }

                if(this.tutorial != null) {
                    var1.writeMessage(9, this.tutorial);
                }

                if(this.actors != null && this.actors.length > 0) {
                    for(var2 = 0; var2 < this.actors.length; ++var2) {
                        Vr.VREvent.EarthVr.Actor var4;
                        if((var4 = this.actors[var2]) != null) {
                            var1.writeMessage(10, var4);
                        }
                    }
                }

                if(this.environment != null) {
                    var1.writeMessage(11, this.environment);
                }

                if(this.splashScreen != null) {
                    var1.writeMessage(12, this.splashScreen);
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.startFromKeyholeTransform != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(1, this.startFromKeyholeTransform);
                }

                if(this.startFromHeadTransform != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.startFromHeadTransform);
                }

                int var2;
                if(this.controllerStates != null && this.controllerStates.length > 0) {
                    for(var2 = 0; var2 < this.controllerStates.length; ++var2) {
                        Vr.VREvent.EarthVr.ControllerState var3;
                        if((var3 = this.controllerStates[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(3, var3);
                        }
                    }
                }

                if(this.appState != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(4, this.appState);
                }

                if(this.view != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(5, this.view);
                }

                if(this.menu != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(6, this.menu);
                }

                if(this.preferences != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(7, this.preferences);
                }

                if(this.tour != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(8, this.tour);
                }

                if(this.tutorial != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(9, this.tutorial);
                }

                if(this.actors != null && this.actors.length > 0) {
                    for(var2 = 0; var2 < this.actors.length; ++var2) {
                        Vr.VREvent.EarthVr.Actor var4;
                        if((var4 = this.actors[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(10, var4);
                        }
                    }
                }

                if(this.environment != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(11, this.environment);
                }

                if(this.splashScreen != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(12, this.splashScreen);
                }

                return var1;
            }

            public final Vr.VREvent.EarthVr mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    int var3;
                    int var4;
                    Vr.VREvent.EarthVr.ControllerState[] var6;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 10:
                            if(this.startFromKeyholeTransform == null) {
                                this.startFromKeyholeTransform = new Vr.VREvent.DoublePrecisionTransform();
                            }

                            var1.readMessage(this.startFromKeyholeTransform);
                            continue;
                        case 18:
                            if(this.startFromHeadTransform == null) {
                                this.startFromHeadTransform = new Vr.VREvent.Transform();
                            }

                            var1.readMessage(this.startFromHeadTransform);
                            continue;
                        case 26:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 26);
                            var6 = new Vr.VREvent.EarthVr.ControllerState[(var4 = this.controllerStates == null?0:this.controllerStates.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.controllerStates, 0, var6, 0, var4);
                            }
                            break;
                        case 34:
                            if(this.appState == null) {
                                this.appState = new Vr.VREvent.EarthVr.AppState();
                            }

                            var1.readMessage(this.appState);
                            continue;
                        case 42:
                            if(this.view == null) {
                                this.view = new Vr.VREvent.EarthVr.View();
                            }

                            var1.readMessage(this.view);
                            continue;
                        case 50:
                            if(this.menu == null) {
                                this.menu = new Vr.VREvent.EarthVr.Menu();
                            }

                            var1.readMessage(this.menu);
                            continue;
                        case 58:
                            if(this.preferences == null) {
                                this.preferences = new Vr.VREvent.EarthVr.Preferences();
                            }

                            var1.readMessage(this.preferences);
                            continue;
                        case 66:
                            if(this.tour == null) {
                                this.tour = new Vr.VREvent.EarthVr.Tour();
                            }

                            var1.readMessage(this.tour);
                            continue;
                        case 74:
                            if(this.tutorial == null) {
                                this.tutorial = new Vr.VREvent.EarthVr.Tutorial();
                            }

                            var1.readMessage(this.tutorial);
                            continue;
                        case 82:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 82);
                            Vr.VREvent.EarthVr.Actor[] var5 = new Vr.VREvent.EarthVr.Actor[(var4 = this.actors == null?0:this.actors.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.actors, 0, var5, 0, var4);
                            }

                            while(var4 < var5.length - 1) {
                                var5[var4] = new Vr.VREvent.EarthVr.Actor();
                                var1.readMessage(var5[var4]);
                                var1.readTag();
                                ++var4;
                            }

                            var5[var4] = new Vr.VREvent.EarthVr.Actor();
                            var1.readMessage(var5[var4]);
                            this.actors = var5;
                            continue;
                        case 90:
                            if(this.environment == null) {
                                this.environment = new Vr.VREvent.EarthVr.Environment();
                            }

                            var1.readMessage(this.environment);
                            continue;
                        case 98:
                            if(this.splashScreen == null) {
                                this.splashScreen = new Vr.VREvent.EarthVr.SplashScreen();
                            }

                            var1.readMessage(this.splashScreen);
                            continue;
                        default:
                            if(super.storeUnknownField(var1, var2)) {
                                continue;
                            }

                            return this;
                    }

                    while(var4 < var6.length - 1) {
                        var6[var4] = new Vr.VREvent.EarthVr.ControllerState();
                        var1.readMessage(var6[var4]);
                        var1.readTag();
                        ++var4;
                    }

                    var6[var4] = new Vr.VREvent.EarthVr.ControllerState();
                    var1.readMessage(var6[var4]);
                    this.controllerStates = var6;
                }
            }

            public static Vr.VREvent.EarthVr parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.EarthVr)MessageNano.mergeFrom(new Vr.VREvent.EarthVr(), var0);
            }

            public static Vr.VREvent.EarthVr parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.EarthVr()).mergeFrom(var0);
            }

            public static final class ControllerState extends ExtendableMessageNano<Vr.VREvent.EarthVr.ControllerState> implements Cloneable {
                private static volatile Vr.VREvent.EarthVr.ControllerState[] _emptyArray;
                public Integer role;
                public Vr.VREvent.Transform startFromControllerTransform;

                public static Vr.VREvent.EarthVr.ControllerState[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.EarthVr.ControllerState[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public ControllerState() {
                    this.clear();
                }

                public final Vr.VREvent.EarthVr.ControllerState clear() {
                    this.startFromControllerTransform = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.EarthVr.ControllerState clone() {
                    Vr.VREvent.EarthVr.ControllerState var1;
                    try {
                        var1 = (Vr.VREvent.EarthVr.ControllerState)super.clone();
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }

                    if(this.startFromControllerTransform != null) {
                        var1.startFromControllerTransform = this.startFromControllerTransform.clone();
                    }

                    return var1;
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.role != null) {
                        var1.writeInt32(1, this.role.intValue());
                    }

                    if(this.startFromControllerTransform != null) {
                        var1.writeMessage(2, this.startFromControllerTransform);
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.role != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.role.intValue());
                    }

                    if(this.startFromControllerTransform != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.startFromControllerTransform);
                    }

                    return var1;
                }

                public final Vr.VREvent.EarthVr.ControllerState mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                int var3;
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                        this.role = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 18:
                                if(this.startFromControllerTransform == null) {
                                    this.startFromControllerTransform = new Vr.VREvent.Transform();
                                }

                                var1.readMessage(this.startFromControllerTransform);
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.EarthVr.ControllerState parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.EarthVr.ControllerState)MessageNano.mergeFrom(new Vr.VREvent.EarthVr.ControllerState(), var0);
                }

                public static Vr.VREvent.EarthVr.ControllerState parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.EarthVr.ControllerState()).mergeFrom(var0);
                }

                public interface Role {
                    int UNKNOWN = 0;
                    int PRIMARY = 1;
                    int SECONDARY = 2;
                }
            }

            public static final class SplashScreen extends ExtendableMessageNano<Vr.VREvent.EarthVr.SplashScreen> implements Cloneable {
                private static volatile Vr.VREvent.EarthVr.SplashScreen[] _emptyArray;
                public Integer exitType;
                public Long numberOfViewPreloadsAttempted;
                public Long numberOfViewPreloadsSucceeded;
                public Long viewPreloadDurationMs;

                public static Vr.VREvent.EarthVr.SplashScreen[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.EarthVr.SplashScreen[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public SplashScreen() {
                    this.clear();
                }

                public final Vr.VREvent.EarthVr.SplashScreen clear() {
                    this.numberOfViewPreloadsAttempted = null;
                    this.numberOfViewPreloadsSucceeded = null;
                    this.viewPreloadDurationMs = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.EarthVr.SplashScreen clone() {
                    try {
                        Vr.VREvent.EarthVr.SplashScreen var1 = (Vr.VREvent.EarthVr.SplashScreen)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.exitType != null) {
                        var1.writeInt32(1, this.exitType.intValue());
                    }

                    if(this.numberOfViewPreloadsAttempted != null) {
                        var1.writeInt64(2, this.numberOfViewPreloadsAttempted.longValue());
                    }

                    if(this.numberOfViewPreloadsSucceeded != null) {
                        var1.writeInt64(3, this.numberOfViewPreloadsSucceeded.longValue());
                    }

                    if(this.viewPreloadDurationMs != null) {
                        var1.writeInt64(4, this.viewPreloadDurationMs.longValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.exitType != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.exitType.intValue());
                    }

                    if(this.numberOfViewPreloadsAttempted != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(2, this.numberOfViewPreloadsAttempted.longValue());
                    }

                    if(this.numberOfViewPreloadsSucceeded != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(3, this.numberOfViewPreloadsSucceeded.longValue());
                    }

                    if(this.viewPreloadDurationMs != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(4, this.viewPreloadDurationMs.longValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.EarthVr.SplashScreen mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                int var3;
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                        this.exitType = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 16:
                                this.numberOfViewPreloadsAttempted = Long.valueOf(var1.readInt64());
                                break;
                            case 24:
                                this.numberOfViewPreloadsSucceeded = Long.valueOf(var1.readInt64());
                                break;
                            case 32:
                                this.viewPreloadDurationMs = Long.valueOf(var1.readInt64());
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.EarthVr.SplashScreen parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.EarthVr.SplashScreen)MessageNano.mergeFrom(new Vr.VREvent.EarthVr.SplashScreen(), var0);
                }

                public static Vr.VREvent.EarthVr.SplashScreen parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.EarthVr.SplashScreen()).mergeFrom(var0);
                }

                public interface ExitType {
                    int EXIT_TYPE_UNKNOWN = 0;
                    int EXIT_TYPE_START_ACTION = 1;
                }
            }

            public static final class Environment extends ExtendableMessageNano<Vr.VREvent.EarthVr.Environment> implements Cloneable {
                private static volatile Vr.VREvent.EarthVr.Environment[] _emptyArray;
                public Vr.VREvent.Transform startFromEnvironmentTransform;

                public static Vr.VREvent.EarthVr.Environment[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.EarthVr.Environment[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public Environment() {
                    this.clear();
                }

                public final Vr.VREvent.EarthVr.Environment clear() {
                    this.startFromEnvironmentTransform = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.EarthVr.Environment clone() {
                    Vr.VREvent.EarthVr.Environment var1;
                    try {
                        var1 = (Vr.VREvent.EarthVr.Environment)super.clone();
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }

                    if(this.startFromEnvironmentTransform != null) {
                        var1.startFromEnvironmentTransform = this.startFromEnvironmentTransform.clone();
                    }

                    return var1;
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.startFromEnvironmentTransform != null) {
                        var1.writeMessage(1, this.startFromEnvironmentTransform);
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.startFromEnvironmentTransform != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(1, this.startFromEnvironmentTransform);
                    }

                    return var1;
                }

                public final Vr.VREvent.EarthVr.Environment mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 10:
                                if(this.startFromEnvironmentTransform == null) {
                                    this.startFromEnvironmentTransform = new Vr.VREvent.Transform();
                                }

                                var1.readMessage(this.startFromEnvironmentTransform);
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.EarthVr.Environment parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.EarthVr.Environment)MessageNano.mergeFrom(new Vr.VREvent.EarthVr.Environment(), var0);
                }

                public static Vr.VREvent.EarthVr.Environment parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.EarthVr.Environment()).mergeFrom(var0);
                }
            }

            public static final class Actor extends ExtendableMessageNano<Vr.VREvent.EarthVr.Actor> implements Cloneable {
                private static volatile Vr.VREvent.EarthVr.Actor[] _emptyArray;
                public Vr.VREvent.Transform startFromHeadTransform;
                public Vr.VREvent.EarthVr.Actor.ControllerState[] controllerStates;

                public static Vr.VREvent.EarthVr.Actor[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.EarthVr.Actor[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public Actor() {
                    this.clear();
                }

                public final Vr.VREvent.EarthVr.Actor clear() {
                    this.startFromHeadTransform = null;
                    this.controllerStates = Vr.VREvent.EarthVr.Actor.ControllerState.emptyArray();
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.EarthVr.Actor clone() {
                    Vr.VREvent.EarthVr.Actor var1;
                    try {
                        var1 = (Vr.VREvent.EarthVr.Actor)super.clone();
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }

                    if(this.startFromHeadTransform != null) {
                        var1.startFromHeadTransform = this.startFromHeadTransform.clone();
                    }

                    if(this.controllerStates != null && this.controllerStates.length > 0) {
                        var1.controllerStates = new Vr.VREvent.EarthVr.Actor.ControllerState[this.controllerStates.length];

                        for(int var2 = 0; var2 < this.controllerStates.length; ++var2) {
                            if(this.controllerStates[var2] != null) {
                                var1.controllerStates[var2] = this.controllerStates[var2].clone();
                            }
                        }
                    }

                    return var1;
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.startFromHeadTransform != null) {
                        var1.writeMessage(2, this.startFromHeadTransform);
                    }

                    if(this.controllerStates != null && this.controllerStates.length > 0) {
                        for(int var2 = 0; var2 < this.controllerStates.length; ++var2) {
                            Vr.VREvent.EarthVr.Actor.ControllerState var3;
                            if((var3 = this.controllerStates[var2]) != null) {
                                var1.writeMessage(3, var3);
                            }
                        }
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.startFromHeadTransform != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.startFromHeadTransform);
                    }

                    if(this.controllerStates != null && this.controllerStates.length > 0) {
                        for(int var2 = 0; var2 < this.controllerStates.length; ++var2) {
                            Vr.VREvent.EarthVr.Actor.ControllerState var3;
                            if((var3 = this.controllerStates[var2]) != null) {
                                var1 += CodedOutputByteBufferNano.computeMessageSize(3, var3);
                            }
                        }
                    }

                    return var1;
                }

                public final Vr.VREvent.EarthVr.Actor mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        int var4;
                        Vr.VREvent.EarthVr.Actor.ControllerState[] var5;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 18:
                                if(this.startFromHeadTransform == null) {
                                    this.startFromHeadTransform = new Vr.VREvent.Transform();
                                }

                                var1.readMessage(this.startFromHeadTransform);
                                continue;
                            case 26:
                                int var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 26);
                                var5 = new Vr.VREvent.EarthVr.Actor.ControllerState[(var4 = this.controllerStates == null?0:this.controllerStates.length) + var3];
                                if(var4 != 0) {
                                    System.arraycopy(this.controllerStates, 0, var5, 0, var4);
                                }
                                break;
                            default:
                                if(super.storeUnknownField(var1, var2)) {
                                    continue;
                                }

                                return this;
                        }

                        while(var4 < var5.length - 1) {
                            var5[var4] = new Vr.VREvent.EarthVr.Actor.ControllerState();
                            var1.readMessage(var5[var4]);
                            var1.readTag();
                            ++var4;
                        }

                        var5[var4] = new Vr.VREvent.EarthVr.Actor.ControllerState();
                        var1.readMessage(var5[var4]);
                        this.controllerStates = var5;
                    }
                }

                public static Vr.VREvent.EarthVr.Actor parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.EarthVr.Actor)MessageNano.mergeFrom(new Vr.VREvent.EarthVr.Actor(), var0);
                }

                public static Vr.VREvent.EarthVr.Actor parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.EarthVr.Actor()).mergeFrom(var0);
                }

                public static final class ControllerState extends ExtendableMessageNano<Vr.VREvent.EarthVr.Actor.ControllerState> implements Cloneable {
                    private static volatile Vr.VREvent.EarthVr.Actor.ControllerState[] _emptyArray;
                    public Integer role;
                    public Vr.VREvent.Transform startFromControllerTransform;

                    public static Vr.VREvent.EarthVr.Actor.ControllerState[] emptyArray() {
                        if(_emptyArray == null) {
                            Object var0 = InternalNano.LAZY_INIT_LOCK;
                            synchronized(InternalNano.LAZY_INIT_LOCK) {
                                if(_emptyArray == null) {
                                    _emptyArray = new Vr.VREvent.EarthVr.Actor.ControllerState[0];
                                }
                            }
                        }

                        return _emptyArray;
                    }

                    public ControllerState() {
                        this.clear();
                    }

                    public final Vr.VREvent.EarthVr.Actor.ControllerState clear() {
                        this.startFromControllerTransform = null;
                        this.unknownFieldData = null;
                        this.cachedSize = -1;
                        return this;
                    }

                    public final Vr.VREvent.EarthVr.Actor.ControllerState clone() {
                        Vr.VREvent.EarthVr.Actor.ControllerState var1;
                        try {
                            var1 = (Vr.VREvent.EarthVr.Actor.ControllerState)super.clone();
                        } catch (CloneNotSupportedException var3) {
                            throw new AssertionError(var3);
                        }

                        if(this.startFromControllerTransform != null) {
                            var1.startFromControllerTransform = this.startFromControllerTransform.clone();
                        }

                        return var1;
                    }

                    public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                        if(this.role != null) {
                            var1.writeInt32(1, this.role.intValue());
                        }

                        if(this.startFromControllerTransform != null) {
                            var1.writeMessage(2, this.startFromControllerTransform);
                        }

                        super.writeTo(var1);
                    }

                    protected final int computeSerializedSize() {
                        int var1 = super.computeSerializedSize();
                        if(this.role != null) {
                            var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.role.intValue());
                        }

                        if(this.startFromControllerTransform != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.startFromControllerTransform);
                        }

                        return var1;
                    }

                    public final Vr.VREvent.EarthVr.Actor.ControllerState mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                        while(true) {
                            int var2;
                            switch(var2 = var1.readTag()) {
                                case 0:
                                    return this;
                                case 8:
                                    int var3;
                                    switch(var3 = var1.readInt32()) {
                                        case 0:
                                        case 1:
                                        case 2:
                                            this.role = Integer.valueOf(var3);
                                        default:
                                            continue;
                                    }
                                case 18:
                                    if(this.startFromControllerTransform == null) {
                                        this.startFromControllerTransform = new Vr.VREvent.Transform();
                                    }

                                    var1.readMessage(this.startFromControllerTransform);
                                    break;
                                default:
                                    if(!super.storeUnknownField(var1, var2)) {
                                        return this;
                                    }
                            }
                        }
                    }

                    public static Vr.VREvent.EarthVr.Actor.ControllerState parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                        return (Vr.VREvent.EarthVr.Actor.ControllerState)MessageNano.mergeFrom(new Vr.VREvent.EarthVr.Actor.ControllerState(), var0);
                    }

                    public static Vr.VREvent.EarthVr.Actor.ControllerState parseFrom(CodedInputByteBufferNano var0) throws IOException {
                        return (new Vr.VREvent.EarthVr.Actor.ControllerState()).mergeFrom(var0);
                    }

                    public interface Role {
                        int UNKNOWN = 0;
                        int PRIMARY = 1;
                        int SECONDARY = 2;
                    }
                }
            }

            public static final class Tutorial extends ExtendableMessageNano<Vr.VREvent.EarthVr.Tutorial> implements Cloneable {
                private static volatile Vr.VREvent.EarthVr.Tutorial[] _emptyArray;
                public Integer stage;
                public String stageName;

                public static Vr.VREvent.EarthVr.Tutorial[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.EarthVr.Tutorial[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public Tutorial() {
                    this.clear();
                }

                public final Vr.VREvent.EarthVr.Tutorial clear() {
                    this.stage = null;
                    this.stageName = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.EarthVr.Tutorial clone() {
                    try {
                        Vr.VREvent.EarthVr.Tutorial var1 = (Vr.VREvent.EarthVr.Tutorial)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.stage != null) {
                        var1.writeInt32(1, this.stage.intValue());
                    }

                    if(this.stageName != null) {
                        var1.writeString(2, this.stageName);
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.stage != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.stage.intValue());
                    }

                    if(this.stageName != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(2, this.stageName);
                    }

                    return var1;
                }

                public final Vr.VREvent.EarthVr.Tutorial mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                this.stage = Integer.valueOf(var1.readInt32());
                                break;
                            case 18:
                                this.stageName = var1.readString();
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.EarthVr.Tutorial parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.EarthVr.Tutorial)MessageNano.mergeFrom(new Vr.VREvent.EarthVr.Tutorial(), var0);
                }

                public static Vr.VREvent.EarthVr.Tutorial parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.EarthVr.Tutorial()).mergeFrom(var0);
                }
            }

            public static final class Tour extends ExtendableMessageNano<Vr.VREvent.EarthVr.Tour> implements Cloneable {
                private static volatile Vr.VREvent.EarthVr.Tour[] _emptyArray;
                public String name;
                public Long playbackMs;

                public static Vr.VREvent.EarthVr.Tour[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.EarthVr.Tour[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public Tour() {
                    this.clear();
                }

                public final Vr.VREvent.EarthVr.Tour clear() {
                    this.name = null;
                    this.playbackMs = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.EarthVr.Tour clone() {
                    try {
                        Vr.VREvent.EarthVr.Tour var1 = (Vr.VREvent.EarthVr.Tour)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.name != null) {
                        var1.writeString(1, this.name);
                    }

                    if(this.playbackMs != null) {
                        var1.writeInt64(2, this.playbackMs.longValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.name != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(1, this.name);
                    }

                    if(this.playbackMs != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(2, this.playbackMs.longValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.EarthVr.Tour mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 10:
                                this.name = var1.readString();
                                break;
                            case 16:
                                this.playbackMs = Long.valueOf(var1.readInt64());
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.EarthVr.Tour parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.EarthVr.Tour)MessageNano.mergeFrom(new Vr.VREvent.EarthVr.Tour(), var0);
                }

                public static Vr.VREvent.EarthVr.Tour parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.EarthVr.Tour()).mergeFrom(var0);
                }
            }

            public static final class Preferences extends ExtendableMessageNano<Vr.VREvent.EarthVr.Preferences> implements Cloneable {
                private static volatile Vr.VREvent.EarthVr.Preferences[] _emptyArray;
                public Integer labelsState;
                public Integer comfortModeState;
                public Integer startConfiguration;
                public Integer guestMode;
                public Integer humanScaleMode;

                public static Vr.VREvent.EarthVr.Preferences[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.EarthVr.Preferences[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public Preferences() {
                    this.clear();
                }

                public final Vr.VREvent.EarthVr.Preferences clear() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.EarthVr.Preferences clone() {
                    try {
                        Vr.VREvent.EarthVr.Preferences var1 = (Vr.VREvent.EarthVr.Preferences)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.labelsState != null) {
                        var1.writeInt32(1, this.labelsState.intValue());
                    }

                    if(this.comfortModeState != null) {
                        var1.writeInt32(2, this.comfortModeState.intValue());
                    }

                    if(this.startConfiguration != null) {
                        var1.writeInt32(3, this.startConfiguration.intValue());
                    }

                    if(this.guestMode != null) {
                        var1.writeInt32(4, this.guestMode.intValue());
                    }

                    if(this.humanScaleMode != null) {
                        var1.writeInt32(5, this.humanScaleMode.intValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.labelsState != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.labelsState.intValue());
                    }

                    if(this.comfortModeState != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.comfortModeState.intValue());
                    }

                    if(this.startConfiguration != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(3, this.startConfiguration.intValue());
                    }

                    if(this.guestMode != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(4, this.guestMode.intValue());
                    }

                    if(this.humanScaleMode != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(5, this.humanScaleMode.intValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.EarthVr.Preferences mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        int var3;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                        this.labelsState = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 16:
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                        this.comfortModeState = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 24:
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                        this.startConfiguration = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 32:
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                        this.guestMode = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 40:
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                        this.humanScaleMode = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.EarthVr.Preferences parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.EarthVr.Preferences)MessageNano.mergeFrom(new Vr.VREvent.EarthVr.Preferences(), var0);
                }

                public static Vr.VREvent.EarthVr.Preferences parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.EarthVr.Preferences()).mergeFrom(var0);
                }

                public interface MusicMode {
                    int MUSIC_UNKNOWN = 0;
                    int MUSIC_OFF = 1;
                    int MUSIC_ON = 2;
                }

                public interface HumanScaleMode {
                    int HUMAN_SCALE_UNKNOWN = 0;
                    int DISALLOW_HUMAN_SCALE = 1;
                    int ALLOW_HUMAN_SCALE = 2;
                }

                public interface GuestMode {
                    int GUEST_MODE_UNKNOWN = 0;
                    int GUEST_MODE_OFF = 1;
                    int GUEST_MODE_ON = 2;
                }

                public interface StartConfiguration {
                    int CONFIGURATION_UNKNOWN = 0;
                    int APP_HAS_NEVER_BEEN_RUN = 1;
                    int APP_HAS_BEEN_RUN_BEFORE = 2;
                }

                public interface ComfortModeState {
                    int COMFORT_MODE_UNKNOWN = 0;
                    int COMFORT_MODE_DISABLED = 1;
                    int COMFORT_MODE_ENABLED = 2;
                }

                public interface LabelsState {
                    int LABELS_UNKNOWN = 0;
                    int LABELS_DISABLED = 1;
                    int LABELS_ENABLED = 2;
                }
            }

            public static final class Menu extends ExtendableMessageNano<Vr.VREvent.EarthVr.Menu> implements Cloneable {
                private static volatile Vr.VREvent.EarthVr.Menu[] _emptyArray;
                public String categoryName;
                public Integer pageIndex;
                public String contentKey;

                public static Vr.VREvent.EarthVr.Menu[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.EarthVr.Menu[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public Menu() {
                    this.clear();
                }

                public final Vr.VREvent.EarthVr.Menu clear() {
                    this.categoryName = null;
                    this.pageIndex = null;
                    this.contentKey = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.EarthVr.Menu clone() {
                    try {
                        Vr.VREvent.EarthVr.Menu var1 = (Vr.VREvent.EarthVr.Menu)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.categoryName != null) {
                        var1.writeString(1, this.categoryName);
                    }

                    if(this.pageIndex != null) {
                        var1.writeInt32(2, this.pageIndex.intValue());
                    }

                    if(this.contentKey != null) {
                        var1.writeString(3, this.contentKey);
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.categoryName != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(1, this.categoryName);
                    }

                    if(this.pageIndex != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.pageIndex.intValue());
                    }

                    if(this.contentKey != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(3, this.contentKey);
                    }

                    return var1;
                }

                public final Vr.VREvent.EarthVr.Menu mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 10:
                                this.categoryName = var1.readString();
                                break;
                            case 16:
                                this.pageIndex = Integer.valueOf(var1.readInt32());
                                break;
                            case 26:
                                this.contentKey = var1.readString();
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.EarthVr.Menu parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.EarthVr.Menu)MessageNano.mergeFrom(new Vr.VREvent.EarthVr.Menu(), var0);
                }

                public static Vr.VREvent.EarthVr.Menu parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.EarthVr.Menu()).mergeFrom(var0);
                }
            }

            public static final class View extends ExtendableMessageNano<Vr.VREvent.EarthVr.View> implements Cloneable {
                private static volatile Vr.VREvent.EarthVr.View[] _emptyArray;
                public Integer mode;
                public Vr.VREvent.DoublePrecisionTransform startFromKeyholeTransform;
                public Long simulationSecondsSinceEpoch;

                public static Vr.VREvent.EarthVr.View[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.EarthVr.View[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public View() {
                    this.clear();
                }

                public final Vr.VREvent.EarthVr.View clear() {
                    this.startFromKeyholeTransform = null;
                    this.simulationSecondsSinceEpoch = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.EarthVr.View clone() {
                    Vr.VREvent.EarthVr.View var1;
                    try {
                        var1 = (Vr.VREvent.EarthVr.View)super.clone();
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }

                    if(this.startFromKeyholeTransform != null) {
                        var1.startFromKeyholeTransform = this.startFromKeyholeTransform.clone();
                    }

                    return var1;
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.mode != null) {
                        var1.writeInt32(1, this.mode.intValue());
                    }

                    if(this.startFromKeyholeTransform != null) {
                        var1.writeMessage(2, this.startFromKeyholeTransform);
                    }

                    if(this.simulationSecondsSinceEpoch != null) {
                        var1.writeInt64(3, this.simulationSecondsSinceEpoch.longValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.mode != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.mode.intValue());
                    }

                    if(this.startFromKeyholeTransform != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.startFromKeyholeTransform);
                    }

                    if(this.simulationSecondsSinceEpoch != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(3, this.simulationSecondsSinceEpoch.longValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.EarthVr.View mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                int var3;
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                        this.mode = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 18:
                                if(this.startFromKeyholeTransform == null) {
                                    this.startFromKeyholeTransform = new Vr.VREvent.DoublePrecisionTransform();
                                }

                                var1.readMessage(this.startFromKeyholeTransform);
                                break;
                            case 24:
                                this.simulationSecondsSinceEpoch = Long.valueOf(var1.readInt64());
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.EarthVr.View parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.EarthVr.View)MessageNano.mergeFrom(new Vr.VREvent.EarthVr.View(), var0);
                }

                public static Vr.VREvent.EarthVr.View parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.EarthVr.View()).mergeFrom(var0);
                }

                public interface Mode {
                    int UNKNOWN = 0;
                    int PLANET = 1;
                    int TERRAIN = 2;
                    int TRANSITION = 3;
                }
            }

            public static final class AppState extends ExtendableMessageNano<Vr.VREvent.EarthVr.AppState> implements Cloneable {
                private static volatile Vr.VREvent.EarthVr.AppState[] _emptyArray;
                public Long appModeId;

                public static Vr.VREvent.EarthVr.AppState[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.EarthVr.AppState[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public AppState() {
                    this.clear();
                }

                public final Vr.VREvent.EarthVr.AppState clear() {
                    this.appModeId = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.EarthVr.AppState clone() {
                    try {
                        Vr.VREvent.EarthVr.AppState var1 = (Vr.VREvent.EarthVr.AppState)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.appModeId != null) {
                        var1.writeInt64(1, this.appModeId.longValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.appModeId != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(1, this.appModeId.longValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.EarthVr.AppState mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                this.appModeId = Long.valueOf(var1.readInt64());
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.EarthVr.AppState parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.EarthVr.AppState)MessageNano.mergeFrom(new Vr.VREvent.EarthVr.AppState(), var0);
                }

                public static Vr.VREvent.EarthVr.AppState parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.EarthVr.AppState()).mergeFrom(var0);
                }
            }
        }

        public static final class VrCore extends ExtendableMessageNano<Vr.VREvent.VrCore> implements Cloneable {
            private static volatile Vr.VREvent.VrCore[] _emptyArray;
            public Integer errorCode;
            public Integer permission;
            public Vr.VREvent.Application foregroundApplication;
            public Integer clientApiVersion;
            public Vr.VREvent.Application previousForegroundApplication;
            public Vr.VREvent.VrCore.Controller controller;

            public static Vr.VREvent.VrCore[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.VrCore[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public VrCore() {
                this.clear();
            }

            public final Vr.VREvent.VrCore clear() {
                this.foregroundApplication = null;
                this.clientApiVersion = null;
                this.previousForegroundApplication = null;
                this.controller = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.VrCore clone() {
                Vr.VREvent.VrCore var1;
                try {
                    var1 = (Vr.VREvent.VrCore)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.foregroundApplication != null) {
                    var1.foregroundApplication = this.foregroundApplication.clone();
                }

                if(this.previousForegroundApplication != null) {
                    var1.previousForegroundApplication = this.previousForegroundApplication.clone();
                }

                if(this.controller != null) {
                    var1.controller = this.controller.clone();
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.errorCode != null) {
                    var1.writeInt32(1, this.errorCode.intValue());
                }

                if(this.permission != null) {
                    var1.writeInt32(2, this.permission.intValue());
                }

                if(this.foregroundApplication != null) {
                    var1.writeMessage(3, this.foregroundApplication);
                }

                if(this.clientApiVersion != null) {
                    var1.writeInt32(4, this.clientApiVersion.intValue());
                }

                if(this.previousForegroundApplication != null) {
                    var1.writeMessage(5, this.previousForegroundApplication);
                }

                if(this.controller != null) {
                    var1.writeMessage(6, this.controller);
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.errorCode != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.errorCode.intValue());
                }

                if(this.permission != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.permission.intValue());
                }

                if(this.foregroundApplication != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(3, this.foregroundApplication);
                }

                if(this.clientApiVersion != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(4, this.clientApiVersion.intValue());
                }

                if(this.previousForegroundApplication != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(5, this.previousForegroundApplication);
                }

                if(this.controller != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(6, this.controller);
                }

                return var1;
            }

            public final Vr.VREvent.VrCore mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    int var3;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 8:
                            switch(var3 = var1.readInt32()) {
                                case 0:
                                case 1:
                                case 101:
                                case 102:
                                case 103:
                                case 104:
                                case 105:
                                case 106:
                                case 107:
                                case 108:
                                case 109:
                                case 110:
                                case 111:
                                case 112:
                                case 113:
                                case 114:
                                case 115:
                                case 116:
                                case 117:
                                case 118:
                                case 119:
                                case 120:
                                case 121:
                                case 122:
                                case 123:
                                case 124:
                                case 125:
                                case 126:
                                case 127:
                                case 151:
                                case 152:
                                case 153:
                                case 176:
                                case 177:
                                case 178:
                                case 179:
                                case 180:
                                case 181:
                                case 182:
                                case 183:
                                case 184:
                                case 185:
                                case 186:
                                case 187:
                                case 188:
                                case 189:
                                case 190:
                                case 191:
                                case 201:
                                case 202:
                                case 203:
                                case 301:
                                case 401:
                                case 402:
                                    this.errorCode = Integer.valueOf(var3);
                                default:
                                    continue;
                            }
                        case 16:
                            switch(var3 = var1.readInt32()) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                    this.permission = Integer.valueOf(var3);
                                default:
                                    continue;
                            }
                        case 26:
                            if(this.foregroundApplication == null) {
                                this.foregroundApplication = new Vr.VREvent.Application();
                            }

                            var1.readMessage(this.foregroundApplication);
                            break;
                        case 32:
                            this.clientApiVersion = Integer.valueOf(var1.readInt32());
                            break;
                        case 42:
                            if(this.previousForegroundApplication == null) {
                                this.previousForegroundApplication = new Vr.VREvent.Application();
                            }

                            var1.readMessage(this.previousForegroundApplication);
                            break;
                        case 50:
                            if(this.controller == null) {
                                this.controller = new Vr.VREvent.VrCore.Controller();
                            }

                            var1.readMessage(this.controller);
                            break;
                        default:
                            if(!super.storeUnknownField(var1, var2)) {
                                return this;
                            }
                    }
                }
            }

            public static Vr.VREvent.VrCore parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.VrCore)MessageNano.mergeFrom(new Vr.VREvent.VrCore(), var0);
            }

            public static Vr.VREvent.VrCore parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.VrCore()).mergeFrom(var0);
            }

            public static final class Controller extends ExtendableMessageNano<Vr.VREvent.VrCore.Controller> implements Cloneable {
                private static volatile Vr.VREvent.VrCore.Controller[] _emptyArray;
                public String manufacturer;
                public String model;
                public String firmware;
                public String availableFirmware;
                public String softwareRevision;
                public Integer batteryLevel;
                public String hardwareRevision;
                public Integer xRailCount;
                public Integer yRailCount;
                public Integer zRailCount;
                public Integer sampleCount;
                public Integer sensorType;
                public Integer axis;

                public static Vr.VREvent.VrCore.Controller[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.VrCore.Controller[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public Controller() {
                    this.clear();
                }

                public final Vr.VREvent.VrCore.Controller clear() {
                    this.manufacturer = null;
                    this.model = null;
                    this.firmware = null;
                    this.availableFirmware = null;
                    this.softwareRevision = null;
                    this.batteryLevel = null;
                    this.hardwareRevision = null;
                    this.xRailCount = null;
                    this.yRailCount = null;
                    this.zRailCount = null;
                    this.sampleCount = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.VrCore.Controller clone() {
                    try {
                        Vr.VREvent.VrCore.Controller var1 = (Vr.VREvent.VrCore.Controller)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.manufacturer != null) {
                        var1.writeString(1, this.manufacturer);
                    }

                    if(this.model != null) {
                        var1.writeString(2, this.model);
                    }

                    if(this.firmware != null) {
                        var1.writeString(3, this.firmware);
                    }

                    if(this.availableFirmware != null) {
                        var1.writeString(4, this.availableFirmware);
                    }

                    if(this.softwareRevision != null) {
                        var1.writeString(5, this.softwareRevision);
                    }

                    if(this.batteryLevel != null) {
                        var1.writeInt32(6, this.batteryLevel.intValue());
                    }

                    if(this.hardwareRevision != null) {
                        var1.writeString(7, this.hardwareRevision);
                    }

                    if(this.xRailCount != null) {
                        var1.writeInt32(8, this.xRailCount.intValue());
                    }

                    if(this.yRailCount != null) {
                        var1.writeInt32(9, this.yRailCount.intValue());
                    }

                    if(this.zRailCount != null) {
                        var1.writeInt32(10, this.zRailCount.intValue());
                    }

                    if(this.sampleCount != null) {
                        var1.writeInt32(11, this.sampleCount.intValue());
                    }

                    if(this.sensorType != null) {
                        var1.writeInt32(12, this.sensorType.intValue());
                    }

                    if(this.axis != null) {
                        var1.writeInt32(13, this.axis.intValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.manufacturer != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(1, this.manufacturer);
                    }

                    if(this.model != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(2, this.model);
                    }

                    if(this.firmware != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(3, this.firmware);
                    }

                    if(this.availableFirmware != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(4, this.availableFirmware);
                    }

                    if(this.softwareRevision != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(5, this.softwareRevision);
                    }

                    if(this.batteryLevel != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(6, this.batteryLevel.intValue());
                    }

                    if(this.hardwareRevision != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(7, this.hardwareRevision);
                    }

                    if(this.xRailCount != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(8, this.xRailCount.intValue());
                    }

                    if(this.yRailCount != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(9, this.yRailCount.intValue());
                    }

                    if(this.zRailCount != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(10, this.zRailCount.intValue());
                    }

                    if(this.sampleCount != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(11, this.sampleCount.intValue());
                    }

                    if(this.sensorType != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(12, this.sensorType.intValue());
                    }

                    if(this.axis != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(13, this.axis.intValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.VrCore.Controller mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        int var3;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 10:
                                this.manufacturer = var1.readString();
                                break;
                            case 18:
                                this.model = var1.readString();
                                break;
                            case 26:
                                this.firmware = var1.readString();
                                break;
                            case 34:
                                this.availableFirmware = var1.readString();
                                break;
                            case 42:
                                this.softwareRevision = var1.readString();
                                break;
                            case 48:
                                this.batteryLevel = Integer.valueOf(var1.readInt32());
                                break;
                            case 58:
                                this.hardwareRevision = var1.readString();
                                break;
                            case 64:
                                this.xRailCount = Integer.valueOf(var1.readInt32());
                                break;
                            case 72:
                                this.yRailCount = Integer.valueOf(var1.readInt32());
                                break;
                            case 80:
                                this.zRailCount = Integer.valueOf(var1.readInt32());
                                break;
                            case 88:
                                this.sampleCount = Integer.valueOf(var1.readInt32());
                                break;
                            case 96:
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                        this.sensorType = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 104:
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                        this.axis = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.VrCore.Controller parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.VrCore.Controller)MessageNano.mergeFrom(new Vr.VREvent.VrCore.Controller(), var0);
                }

                public static Vr.VREvent.VrCore.Controller parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.VrCore.Controller()).mergeFrom(var0);
                }

                public interface SensorType {
                    int SENSOR_UNKNOWN = 0;
                    int SENSOR_ACCEL = 2;
                    int SENSOR_GYRO = 1;
                }

                public interface ControllerAxis {
                    int AXIS_UNKNOWN = 0;
                    int AXIS_X = 1;
                    int AXIS_Y = 2;
                    int AXIS_Z = 3;
                }
            }

            public interface Permission {
                int UNKNOWN_PERMISSION = 0;
                int ACCESS_COARSE_LOCATION = 1;
                int CAMERA = 2;
                int READ_EXTERNAL_STORAGE = 3;
                int WRITE_EXTERNAL_STORAGE = 4;
                int SYSTEM_ALERT_WINDOW = 5;
                int BIND_NOTIFICATION_LISTENER_SERVICE = 6;
                int BIND_CONDITION_PROVIDER_SERVICE = 7;
                int ACCESS_NOTIFICATION_POLICY = 8;
            }

            public interface ErrorCode {
                int UNKNOWN_ERROR = 0;
                int BAD_STATE = 1;
                int CONTROLLER_BATTERY_TOO_LOW = 101;
                int CONTROLLER_BLUETOOTH_ERROR = 102;
                int CONTROLLER_BLUETOOTH_OFF = 103;
                int CONTROLLER_BOND_FAILED = 104;
                int CONTROLLER_CONNECTION_FAILURE = 105;
                int CONTROLLER_HANDSHAKE_FAILURE = 106;
                int CONTROLLER_INSUFFICIENT_PERMS = 107;
                int CONTROLLER_LOST_CONNECTION = 108;
                int CONTROLLER_MISMATCH = 109;
                int CONTROLLER_NOT_FOUND = 110;
                int CONTROLLER_PROTOCOL_FAILURE = 111;
                int CONTROLLER_TIMEOUT = 112;
                int CONTROLLER_FIRMWARE_ERROR = 113;
                int CONTROLLER_INVALID_MANUFACTURER = 114;
                int CONTROLLER_OTA_SERVICE_ERROR = 115;
                int CONTROLLER_BLUETOOTH_SCAN_FAILURE = 116;
                int CONTROLLER_CREATE_BOND_FAILURE = 117;
                int CONTROLLER_NOT_BONDED = 118;
                int CONTROLLER_UNSUPPORTED = 119;
                int CONTROLLER_INFO_READ_ERROR = 120;
                int CONTROLLER_GATT_DISCOVERY_FAILED = 121;
                int CONTROLLER_GATT_SERVICE_NOT_FOUND = 122;
                int CONTROLLER_GATT_CHARACTERISTIC_NOT_FOUND = 123;
                int CONTROLLER_GATT_NOTIFY_FAILED = 124;
                int CONTROLLER_BATTERY_READ_FAILED = 125;
                int CONTROLLER_STUCK = 126;
                int CONTROLLER_UNSTUCK = 127;
                int DAYDREAM_TRACKING_ACQUISITION_FAILED = 151;
                int DAYDREAM_TRACKING_TRANSITIONAL_FAILED = 152;
                int DAYDREAM_TRACKING_HANDOFF_FAILED = 153;
                int DON_BAD_POSE = 176;
                int DON_BLUETOOTH_OFF = 177;
                int DON_CANCELLED = 178;
                int DON_DAYDREAM_APP_INSTALLING = 179;
                int DON_DAYDREAM_APP_NOT_PRESENT = 180;
                int DON_DAYDREAM_APP_OUT_OF_DATE = 181;
                int DON_DAYDREAM_SETUP_NOT_COMPLETE = 182;
                int DON_DEVICE_INCOMPATIBLE = 183;
                int DON_HEADSET_INCOMPATIBLE = 184;
                int DON_LOCATION_OFF = 185;
                int DON_MISSING_PERMISSION = 186;
                int DON_NFC_OFF = 187;
                int DON_VRCORE_OUT_OF_DATE = 188;
                int DON_VR_KEYBOARD_NOT_PRESENT = 189;
                int DON_APP_INCOMPATIBLE = 190;
                int DON_SYSTEM_UPDATE_REQUESTED = 191;
                int EMPTY_PLAYLOAD = 201;
                int INVALID_PLAYLOAD = 202;
                int LAUNCH_FAILURE = 203;
                int NO_ZEN_RULE = 301;
                int INVALID_READ = 401;
                int DISALLOWED_WRITE = 402;
            }
        }

        public static final class SdkConfigurationParams extends ExtendableMessageNano<Vr.VREvent.SdkConfigurationParams> implements Cloneable {
            private static volatile Vr.VREvent.SdkConfigurationParams[] _emptyArray;
            public Boolean daydreamImageAlignmentEnabled;
            public Boolean useSystemClockForSensorTimestamps;
            public Boolean useMagnetometerInSensorFusion;
            public Boolean allowDynamicLibraryLoading;
            public Boolean cpuLateLatchingEnabled;
            public Integer daydreamImageAlignment;
            public Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig asyncReprojectionConfig;
            public Boolean useOnlineMagnetometerCalibration;

            public static Vr.VREvent.SdkConfigurationParams[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.SdkConfigurationParams[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public SdkConfigurationParams() {
                this.clear();
            }

            public final Vr.VREvent.SdkConfigurationParams clear() {
                this.daydreamImageAlignmentEnabled = null;
                this.useSystemClockForSensorTimestamps = null;
                this.useMagnetometerInSensorFusion = null;
                this.allowDynamicLibraryLoading = null;
                this.cpuLateLatchingEnabled = null;
                this.asyncReprojectionConfig = null;
                this.useOnlineMagnetometerCalibration = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.SdkConfigurationParams clone() {
                Vr.VREvent.SdkConfigurationParams var1;
                try {
                    var1 = (Vr.VREvent.SdkConfigurationParams)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.asyncReprojectionConfig != null) {
                    var1.asyncReprojectionConfig = this.asyncReprojectionConfig.clone();
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.daydreamImageAlignmentEnabled != null) {
                    var1.writeBool(1, this.daydreamImageAlignmentEnabled.booleanValue());
                }

                if(this.useSystemClockForSensorTimestamps != null) {
                    var1.writeBool(2, this.useSystemClockForSensorTimestamps.booleanValue());
                }

                if(this.useMagnetometerInSensorFusion != null) {
                    var1.writeBool(3, this.useMagnetometerInSensorFusion.booleanValue());
                }

                if(this.allowDynamicLibraryLoading != null) {
                    var1.writeBool(4, this.allowDynamicLibraryLoading.booleanValue());
                }

                if(this.cpuLateLatchingEnabled != null) {
                    var1.writeBool(5, this.cpuLateLatchingEnabled.booleanValue());
                }

                if(this.daydreamImageAlignment != null) {
                    var1.writeInt32(6, this.daydreamImageAlignment.intValue());
                }

                if(this.asyncReprojectionConfig != null) {
                    var1.writeMessage(7, this.asyncReprojectionConfig);
                }

                if(this.useOnlineMagnetometerCalibration != null) {
                    var1.writeBool(8, this.useOnlineMagnetometerCalibration.booleanValue());
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.daydreamImageAlignmentEnabled != null) {
                    var1 += CodedOutputByteBufferNano.computeBoolSize(1, this.daydreamImageAlignmentEnabled.booleanValue());
                }

                if(this.useSystemClockForSensorTimestamps != null) {
                    var1 += CodedOutputByteBufferNano.computeBoolSize(2, this.useSystemClockForSensorTimestamps.booleanValue());
                }

                if(this.useMagnetometerInSensorFusion != null) {
                    var1 += CodedOutputByteBufferNano.computeBoolSize(3, this.useMagnetometerInSensorFusion.booleanValue());
                }

                if(this.allowDynamicLibraryLoading != null) {
                    var1 += CodedOutputByteBufferNano.computeBoolSize(4, this.allowDynamicLibraryLoading.booleanValue());
                }

                if(this.cpuLateLatchingEnabled != null) {
                    var1 += CodedOutputByteBufferNano.computeBoolSize(5, this.cpuLateLatchingEnabled.booleanValue());
                }

                if(this.daydreamImageAlignment != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(6, this.daydreamImageAlignment.intValue());
                }

                if(this.asyncReprojectionConfig != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(7, this.asyncReprojectionConfig);
                }

                if(this.useOnlineMagnetometerCalibration != null) {
                    var1 += CodedOutputByteBufferNano.computeBoolSize(8, this.useOnlineMagnetometerCalibration.booleanValue());
                }

                return var1;
            }

            public final Vr.VREvent.SdkConfigurationParams mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 8:
                            this.daydreamImageAlignmentEnabled = Boolean.valueOf(var1.readBool());
                            break;
                        case 16:
                            this.useSystemClockForSensorTimestamps = Boolean.valueOf(var1.readBool());
                            break;
                        case 24:
                            this.useMagnetometerInSensorFusion = Boolean.valueOf(var1.readBool());
                            break;
                        case 32:
                            this.allowDynamicLibraryLoading = Boolean.valueOf(var1.readBool());
                            break;
                        case 40:
                            this.cpuLateLatchingEnabled = Boolean.valueOf(var1.readBool());
                            break;
                        case 48:
                            int var3;
                            switch(var3 = var1.readInt32()) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                    this.daydreamImageAlignment = Integer.valueOf(var3);
                                default:
                                    continue;
                            }
                        case 58:
                            if(this.asyncReprojectionConfig == null) {
                                this.asyncReprojectionConfig = new Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig();
                            }

                            var1.readMessage(this.asyncReprojectionConfig);
                            break;
                        case 64:
                            this.useOnlineMagnetometerCalibration = Boolean.valueOf(var1.readBool());
                            break;
                        default:
                            if(!super.storeUnknownField(var1, var2)) {
                                return this;
                            }
                    }
                }
            }

            public static Vr.VREvent.SdkConfigurationParams parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.SdkConfigurationParams)MessageNano.mergeFrom(new Vr.VREvent.SdkConfigurationParams(), var0);
            }

            public static Vr.VREvent.SdkConfigurationParams parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.SdkConfigurationParams()).mergeFrom(var0);
            }

            public static final class AsyncReprojectionConfig extends ExtendableMessageNano<Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig> implements Cloneable {
                private static volatile Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig[] _emptyArray;
                public Long flags;
                public Long displayLatencyMicros;

                public static Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public AsyncReprojectionConfig() {
                    this.clear();
                }

                public final Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig clear() {
                    this.flags = null;
                    this.displayLatencyMicros = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig clone() {
                    try {
                        Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig var1 = (Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.flags != null) {
                        var1.writeInt64(1, this.flags.longValue());
                    }

                    if(this.displayLatencyMicros != null) {
                        var1.writeInt64(2, this.displayLatencyMicros.longValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.flags != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(1, this.flags.longValue());
                    }

                    if(this.displayLatencyMicros != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(2, this.displayLatencyMicros.longValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                this.flags = Long.valueOf(var1.readInt64());
                                break;
                            case 16:
                                this.displayLatencyMicros = Long.valueOf(var1.readInt64());
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig)MessageNano.mergeFrom(new Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig(), var0);
                }

                public static Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig()).mergeFrom(var0);
                }

                public interface Flags {
                    int UNSPECIFIED = 0;
                    int CONFIGURE_BINNING = 1;
                    int LATE_LATCHING = 2;
                    int AGGRESSIVE_SCHEDULING = 4;
                    int EXCLUSIVE_CORE = 8;
                }
            }

            public interface DaydreamImageAlignment {
                int UNKNOWN_ALIGNMENT = 0;
                int DISABLED = 1;
                int ENABLED_NO_FILTERING = 2;
                int ENABLED_WITH_MEDIAN_FILTER = 3;
            }
        }

        public static final class EmbedVrWidget extends ExtendableMessageNano<Vr.VREvent.EmbedVrWidget> implements Cloneable {
            private static volatile Vr.VREvent.EmbedVrWidget[] _emptyArray;
            public Integer viewMode;
            public Vr.VREvent.EmbedVrWidget.Pano pano;
            public Vr.VREvent.EmbedVrWidget.Video video;
            public String errorMsg;

            public static Vr.VREvent.EmbedVrWidget[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.EmbedVrWidget[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public EmbedVrWidget() {
                this.clear();
            }

            public final Vr.VREvent.EmbedVrWidget clear() {
                this.pano = null;
                this.video = null;
                this.errorMsg = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.EmbedVrWidget clone() {
                Vr.VREvent.EmbedVrWidget var1;
                try {
                    var1 = (Vr.VREvent.EmbedVrWidget)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.pano != null) {
                    var1.pano = this.pano.clone();
                }

                if(this.video != null) {
                    var1.video = this.video.clone();
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.viewMode != null) {
                    var1.writeInt32(1, this.viewMode.intValue());
                }

                if(this.pano != null) {
                    var1.writeMessage(2, this.pano);
                }

                if(this.video != null) {
                    var1.writeMessage(3, this.video);
                }

                if(this.errorMsg != null) {
                    var1.writeString(4, this.errorMsg);
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.viewMode != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.viewMode.intValue());
                }

                if(this.pano != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.pano);
                }

                if(this.video != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(3, this.video);
                }

                if(this.errorMsg != null) {
                    var1 += CodedOutputByteBufferNano.computeStringSize(4, this.errorMsg);
                }

                return var1;
            }

            public final Vr.VREvent.EmbedVrWidget mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 8:
                            int var3;
                            switch(var3 = var1.readInt32()) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                    this.viewMode = Integer.valueOf(var3);
                                default:
                                    continue;
                            }
                        case 18:
                            if(this.pano == null) {
                                this.pano = new Vr.VREvent.EmbedVrWidget.Pano();
                            }

                            var1.readMessage(this.pano);
                            break;
                        case 26:
                            if(this.video == null) {
                                this.video = new Vr.VREvent.EmbedVrWidget.Video();
                            }

                            var1.readMessage(this.video);
                            break;
                        case 34:
                            this.errorMsg = var1.readString();
                            break;
                        default:
                            if(!super.storeUnknownField(var1, var2)) {
                                return this;
                            }
                    }
                }
            }

            public static Vr.VREvent.EmbedVrWidget parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.EmbedVrWidget)MessageNano.mergeFrom(new Vr.VREvent.EmbedVrWidget(), var0);
            }

            public static Vr.VREvent.EmbedVrWidget parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.EmbedVrWidget()).mergeFrom(var0);
            }

            public static final class Video extends ExtendableMessageNano<Vr.VREvent.EmbedVrWidget.Video> implements Cloneable {
                private static volatile Vr.VREvent.EmbedVrWidget.Video[] _emptyArray;
                public Integer widthPixels;
                public Integer heightPixels;
                public Integer stereoFormat;
                public Integer videoDurationMs;

                public static Vr.VREvent.EmbedVrWidget.Video[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.EmbedVrWidget.Video[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public Video() {
                    this.clear();
                }

                public final Vr.VREvent.EmbedVrWidget.Video clear() {
                    this.widthPixels = null;
                    this.heightPixels = null;
                    this.videoDurationMs = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.EmbedVrWidget.Video clone() {
                    try {
                        Vr.VREvent.EmbedVrWidget.Video var1 = (Vr.VREvent.EmbedVrWidget.Video)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.widthPixels != null) {
                        var1.writeInt32(1, this.widthPixels.intValue());
                    }

                    if(this.heightPixels != null) {
                        var1.writeInt32(2, this.heightPixels.intValue());
                    }

                    if(this.stereoFormat != null) {
                        var1.writeInt32(3, this.stereoFormat.intValue());
                    }

                    if(this.videoDurationMs != null) {
                        var1.writeInt32(4, this.videoDurationMs.intValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.widthPixels != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.widthPixels.intValue());
                    }

                    if(this.heightPixels != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.heightPixels.intValue());
                    }

                    if(this.stereoFormat != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(3, this.stereoFormat.intValue());
                    }

                    if(this.videoDurationMs != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(4, this.videoDurationMs.intValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.EmbedVrWidget.Video mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                this.widthPixels = Integer.valueOf(var1.readInt32());
                                break;
                            case 16:
                                this.heightPixels = Integer.valueOf(var1.readInt32());
                                break;
                            case 24:
                                int var3;
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                        this.stereoFormat = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 32:
                                this.videoDurationMs = Integer.valueOf(var1.readInt32());
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.EmbedVrWidget.Video parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.EmbedVrWidget.Video)MessageNano.mergeFrom(new Vr.VREvent.EmbedVrWidget.Video(), var0);
                }

                public static Vr.VREvent.EmbedVrWidget.Video parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.EmbedVrWidget.Video()).mergeFrom(var0);
                }
            }

            public static final class Pano extends ExtendableMessageNano<Vr.VREvent.EmbedVrWidget.Pano> implements Cloneable {
                private static volatile Vr.VREvent.EmbedVrWidget.Pano[] _emptyArray;
                public Integer widthPixels;
                public Integer heightPixels;
                public Integer stereoFormat;

                public static Vr.VREvent.EmbedVrWidget.Pano[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.EmbedVrWidget.Pano[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public Pano() {
                    this.clear();
                }

                public final Vr.VREvent.EmbedVrWidget.Pano clear() {
                    this.widthPixels = null;
                    this.heightPixels = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.EmbedVrWidget.Pano clone() {
                    try {
                        Vr.VREvent.EmbedVrWidget.Pano var1 = (Vr.VREvent.EmbedVrWidget.Pano)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.widthPixels != null) {
                        var1.writeInt32(1, this.widthPixels.intValue());
                    }

                    if(this.heightPixels != null) {
                        var1.writeInt32(2, this.heightPixels.intValue());
                    }

                    if(this.stereoFormat != null) {
                        var1.writeInt32(3, this.stereoFormat.intValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.widthPixels != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.widthPixels.intValue());
                    }

                    if(this.heightPixels != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.heightPixels.intValue());
                    }

                    if(this.stereoFormat != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(3, this.stereoFormat.intValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.EmbedVrWidget.Pano mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                this.widthPixels = Integer.valueOf(var1.readInt32());
                                break;
                            case 16:
                                this.heightPixels = Integer.valueOf(var1.readInt32());
                                break;
                            case 24:
                                int var3;
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                        this.stereoFormat = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.EmbedVrWidget.Pano parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.EmbedVrWidget.Pano)MessageNano.mergeFrom(new Vr.VREvent.EmbedVrWidget.Pano(), var0);
                }

                public static Vr.VREvent.EmbedVrWidget.Pano parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.EmbedVrWidget.Pano()).mergeFrom(var0);
                }
            }

            public interface ViewMode {
                int UNKNOWN_MODE = 0;
                int EMBEDDED = 1;
                int FULLSCREEN_MONO = 2;
                int FULLSCREEN_VR = 3;
            }

            public interface StereoFormat {
                int UNKNOWN_FORMAT = 0;
                int MONO = 1;
                int STEREO_OVER_UNDER = 2;
            }
        }

        public static final class AudioStats extends ExtendableMessageNano<Vr.VREvent.AudioStats> implements Cloneable {
            private static volatile Vr.VREvent.AudioStats[] _emptyArray;
            public Integer renderingMode;
            public Integer sampleRate;
            public Integer framesPerBuffer;
            public Vr.VREvent.HistogramBucket[] renderingTimePerBufferMilliseconds;
            public Vr.VREvent.HistogramBucket[] numberOfSimultaneousSoundObjects;
            public Vr.VREvent.HistogramBucket[] numberOfSimultaneousSoundFields;
            public Vr.VREvent.HistogramBucket[] cpuMeasurementsPercent;

            public static Vr.VREvent.AudioStats[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.AudioStats[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public AudioStats() {
                this.clear();
            }

            public final Vr.VREvent.AudioStats clear() {
                this.sampleRate = null;
                this.framesPerBuffer = null;
                this.renderingTimePerBufferMilliseconds = Vr.VREvent.HistogramBucket.emptyArray();
                this.numberOfSimultaneousSoundObjects = Vr.VREvent.HistogramBucket.emptyArray();
                this.numberOfSimultaneousSoundFields = Vr.VREvent.HistogramBucket.emptyArray();
                this.cpuMeasurementsPercent = Vr.VREvent.HistogramBucket.emptyArray();
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.AudioStats clone() {
                Vr.VREvent.AudioStats var1;
                try {
                    var1 = (Vr.VREvent.AudioStats)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                int var2;
                if(this.renderingTimePerBufferMilliseconds != null && this.renderingTimePerBufferMilliseconds.length > 0) {
                    var1.renderingTimePerBufferMilliseconds = new Vr.VREvent.HistogramBucket[this.renderingTimePerBufferMilliseconds.length];

                    for(var2 = 0; var2 < this.renderingTimePerBufferMilliseconds.length; ++var2) {
                        if(this.renderingTimePerBufferMilliseconds[var2] != null) {
                            var1.renderingTimePerBufferMilliseconds[var2] = this.renderingTimePerBufferMilliseconds[var2].clone();
                        }
                    }
                }

                if(this.numberOfSimultaneousSoundObjects != null && this.numberOfSimultaneousSoundObjects.length > 0) {
                    var1.numberOfSimultaneousSoundObjects = new Vr.VREvent.HistogramBucket[this.numberOfSimultaneousSoundObjects.length];

                    for(var2 = 0; var2 < this.numberOfSimultaneousSoundObjects.length; ++var2) {
                        if(this.numberOfSimultaneousSoundObjects[var2] != null) {
                            var1.numberOfSimultaneousSoundObjects[var2] = this.numberOfSimultaneousSoundObjects[var2].clone();
                        }
                    }
                }

                if(this.numberOfSimultaneousSoundFields != null && this.numberOfSimultaneousSoundFields.length > 0) {
                    var1.numberOfSimultaneousSoundFields = new Vr.VREvent.HistogramBucket[this.numberOfSimultaneousSoundFields.length];

                    for(var2 = 0; var2 < this.numberOfSimultaneousSoundFields.length; ++var2) {
                        if(this.numberOfSimultaneousSoundFields[var2] != null) {
                            var1.numberOfSimultaneousSoundFields[var2] = this.numberOfSimultaneousSoundFields[var2].clone();
                        }
                    }
                }

                if(this.cpuMeasurementsPercent != null && this.cpuMeasurementsPercent.length > 0) {
                    var1.cpuMeasurementsPercent = new Vr.VREvent.HistogramBucket[this.cpuMeasurementsPercent.length];

                    for(var2 = 0; var2 < this.cpuMeasurementsPercent.length; ++var2) {
                        if(this.cpuMeasurementsPercent[var2] != null) {
                            var1.cpuMeasurementsPercent[var2] = this.cpuMeasurementsPercent[var2].clone();
                        }
                    }
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.renderingMode != null) {
                    var1.writeInt32(1, this.renderingMode.intValue());
                }

                if(this.sampleRate != null) {
                    var1.writeInt32(2, this.sampleRate.intValue());
                }

                if(this.framesPerBuffer != null) {
                    var1.writeInt32(3, this.framesPerBuffer.intValue());
                }

                int var2;
                Vr.VREvent.HistogramBucket var3;
                if(this.renderingTimePerBufferMilliseconds != null && this.renderingTimePerBufferMilliseconds.length > 0) {
                    for(var2 = 0; var2 < this.renderingTimePerBufferMilliseconds.length; ++var2) {
                        if((var3 = this.renderingTimePerBufferMilliseconds[var2]) != null) {
                            var1.writeMessage(4, var3);
                        }
                    }
                }

                if(this.numberOfSimultaneousSoundObjects != null && this.numberOfSimultaneousSoundObjects.length > 0) {
                    for(var2 = 0; var2 < this.numberOfSimultaneousSoundObjects.length; ++var2) {
                        if((var3 = this.numberOfSimultaneousSoundObjects[var2]) != null) {
                            var1.writeMessage(5, var3);
                        }
                    }
                }

                if(this.numberOfSimultaneousSoundFields != null && this.numberOfSimultaneousSoundFields.length > 0) {
                    for(var2 = 0; var2 < this.numberOfSimultaneousSoundFields.length; ++var2) {
                        if((var3 = this.numberOfSimultaneousSoundFields[var2]) != null) {
                            var1.writeMessage(6, var3);
                        }
                    }
                }

                if(this.cpuMeasurementsPercent != null && this.cpuMeasurementsPercent.length > 0) {
                    for(var2 = 0; var2 < this.cpuMeasurementsPercent.length; ++var2) {
                        if((var3 = this.cpuMeasurementsPercent[var2]) != null) {
                            var1.writeMessage(7, var3);
                        }
                    }
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.renderingMode != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.renderingMode.intValue());
                }

                if(this.sampleRate != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.sampleRate.intValue());
                }

                if(this.framesPerBuffer != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(3, this.framesPerBuffer.intValue());
                }

                int var2;
                Vr.VREvent.HistogramBucket var3;
                if(this.renderingTimePerBufferMilliseconds != null && this.renderingTimePerBufferMilliseconds.length > 0) {
                    for(var2 = 0; var2 < this.renderingTimePerBufferMilliseconds.length; ++var2) {
                        if((var3 = this.renderingTimePerBufferMilliseconds[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(4, var3);
                        }
                    }
                }

                if(this.numberOfSimultaneousSoundObjects != null && this.numberOfSimultaneousSoundObjects.length > 0) {
                    for(var2 = 0; var2 < this.numberOfSimultaneousSoundObjects.length; ++var2) {
                        if((var3 = this.numberOfSimultaneousSoundObjects[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(5, var3);
                        }
                    }
                }

                if(this.numberOfSimultaneousSoundFields != null && this.numberOfSimultaneousSoundFields.length > 0) {
                    for(var2 = 0; var2 < this.numberOfSimultaneousSoundFields.length; ++var2) {
                        if((var3 = this.numberOfSimultaneousSoundFields[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(6, var3);
                        }
                    }
                }

                if(this.cpuMeasurementsPercent != null && this.cpuMeasurementsPercent.length > 0) {
                    for(var2 = 0; var2 < this.cpuMeasurementsPercent.length; ++var2) {
                        if((var3 = this.cpuMeasurementsPercent[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(7, var3);
                        }
                    }
                }

                return var1;
            }

            public final Vr.VREvent.AudioStats mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    int var3;
                    int var4;
                    Vr.VREvent.HistogramBucket[] var5;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 8:
                            switch(var3 = var1.readInt32()) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                    this.renderingMode = Integer.valueOf(var3);
                                default:
                                    continue;
                            }
                        case 16:
                            this.sampleRate = Integer.valueOf(var1.readInt32());
                            continue;
                        case 24:
                            this.framesPerBuffer = Integer.valueOf(var1.readInt32());
                            continue;
                        case 34:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 34);
                            var5 = new Vr.VREvent.HistogramBucket[(var4 = this.renderingTimePerBufferMilliseconds == null?0:this.renderingTimePerBufferMilliseconds.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.renderingTimePerBufferMilliseconds, 0, var5, 0, var4);
                            }
                            break;
                        case 42:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 42);
                            var5 = new Vr.VREvent.HistogramBucket[(var4 = this.numberOfSimultaneousSoundObjects == null?0:this.numberOfSimultaneousSoundObjects.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.numberOfSimultaneousSoundObjects, 0, var5, 0, var4);
                            }

                            while(var4 < var5.length - 1) {
                                var5[var4] = new Vr.VREvent.HistogramBucket();
                                var1.readMessage(var5[var4]);
                                var1.readTag();
                                ++var4;
                            }

                            var5[var4] = new Vr.VREvent.HistogramBucket();
                            var1.readMessage(var5[var4]);
                            this.numberOfSimultaneousSoundObjects = var5;
                            continue;
                        case 50:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 50);
                            var5 = new Vr.VREvent.HistogramBucket[(var4 = this.numberOfSimultaneousSoundFields == null?0:this.numberOfSimultaneousSoundFields.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.numberOfSimultaneousSoundFields, 0, var5, 0, var4);
                            }

                            while(var4 < var5.length - 1) {
                                var5[var4] = new Vr.VREvent.HistogramBucket();
                                var1.readMessage(var5[var4]);
                                var1.readTag();
                                ++var4;
                            }

                            var5[var4] = new Vr.VREvent.HistogramBucket();
                            var1.readMessage(var5[var4]);
                            this.numberOfSimultaneousSoundFields = var5;
                            continue;
                        case 58:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 58);
                            var5 = new Vr.VREvent.HistogramBucket[(var4 = this.cpuMeasurementsPercent == null?0:this.cpuMeasurementsPercent.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.cpuMeasurementsPercent, 0, var5, 0, var4);
                            }

                            while(var4 < var5.length - 1) {
                                var5[var4] = new Vr.VREvent.HistogramBucket();
                                var1.readMessage(var5[var4]);
                                var1.readTag();
                                ++var4;
                            }

                            var5[var4] = new Vr.VREvent.HistogramBucket();
                            var1.readMessage(var5[var4]);
                            this.cpuMeasurementsPercent = var5;
                            continue;
                        default:
                            if(super.storeUnknownField(var1, var2)) {
                                continue;
                            }

                            return this;
                    }

                    while(var4 < var5.length - 1) {
                        var5[var4] = new Vr.VREvent.HistogramBucket();
                        var1.readMessage(var5[var4]);
                        var1.readTag();
                        ++var4;
                    }

                    var5[var4] = new Vr.VREvent.HistogramBucket();
                    var1.readMessage(var5[var4]);
                    this.renderingTimePerBufferMilliseconds = var5;
                }
            }

            public static Vr.VREvent.AudioStats parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.AudioStats)MessageNano.mergeFrom(new Vr.VREvent.AudioStats(), var0);
            }

            public static Vr.VREvent.AudioStats parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.AudioStats()).mergeFrom(var0);
            }

            public interface RenderingMode {
                int UNKNOWN = 0;
                int STEREO_PANNING = 1;
                int BINAURAL_LOW_QUALITY = 2;
                int BINAURAL_HIGH_QUALITY = 3;
            }
        }

        public static final class SensorStats extends ExtendableMessageNano<Vr.VREvent.SensorStats> implements Cloneable {
            private static volatile Vr.VREvent.SensorStats[] _emptyArray;
            public Vr.VREvent.SensorStats.GyroscopeStats gyroscopeStats;

            public static Vr.VREvent.SensorStats[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.SensorStats[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public SensorStats() {
                this.clear();
            }

            public final Vr.VREvent.SensorStats clear() {
                this.gyroscopeStats = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.SensorStats clone() {
                Vr.VREvent.SensorStats var1;
                try {
                    var1 = (Vr.VREvent.SensorStats)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.gyroscopeStats != null) {
                    var1.gyroscopeStats = this.gyroscopeStats.clone();
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.gyroscopeStats != null) {
                    var1.writeMessage(1, this.gyroscopeStats);
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.gyroscopeStats != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(1, this.gyroscopeStats);
                }

                return var1;
            }

            public final Vr.VREvent.SensorStats mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 10:
                            if(this.gyroscopeStats == null) {
                                this.gyroscopeStats = new Vr.VREvent.SensorStats.GyroscopeStats();
                            }

                            var1.readMessage(this.gyroscopeStats);
                            break;
                        default:
                            if(!super.storeUnknownField(var1, var2)) {
                                return this;
                            }
                    }
                }
            }

            public static Vr.VREvent.SensorStats parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.SensorStats)MessageNano.mergeFrom(new Vr.VREvent.SensorStats(), var0);
            }

            public static Vr.VREvent.SensorStats parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.SensorStats()).mergeFrom(var0);
            }

            public static final class GyroscopeStats extends ExtendableMessageNano<Vr.VREvent.SensorStats.GyroscopeStats> implements Cloneable {
                private static volatile Vr.VREvent.SensorStats.GyroscopeStats[] _emptyArray;
                public Vr.VREvent.SensorStats.Vector3 bias;
                public Vr.VREvent.SensorStats.Vector3 lowerBound;
                public Vr.VREvent.SensorStats.Vector3 upperBound;
                public Vr.VREvent.SensorStats.Vector3 standardDeviation;

                public static Vr.VREvent.SensorStats.GyroscopeStats[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.SensorStats.GyroscopeStats[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public GyroscopeStats() {
                    this.clear();
                }

                public final Vr.VREvent.SensorStats.GyroscopeStats clear() {
                    this.bias = null;
                    this.lowerBound = null;
                    this.upperBound = null;
                    this.standardDeviation = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.SensorStats.GyroscopeStats clone() {
                    Vr.VREvent.SensorStats.GyroscopeStats var1;
                    try {
                        var1 = (Vr.VREvent.SensorStats.GyroscopeStats)super.clone();
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }

                    if(this.bias != null) {
                        var1.bias = this.bias.clone();
                    }

                    if(this.lowerBound != null) {
                        var1.lowerBound = this.lowerBound.clone();
                    }

                    if(this.upperBound != null) {
                        var1.upperBound = this.upperBound.clone();
                    }

                    if(this.standardDeviation != null) {
                        var1.standardDeviation = this.standardDeviation.clone();
                    }

                    return var1;
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.bias != null) {
                        var1.writeMessage(1, this.bias);
                    }

                    if(this.lowerBound != null) {
                        var1.writeMessage(2, this.lowerBound);
                    }

                    if(this.upperBound != null) {
                        var1.writeMessage(3, this.upperBound);
                    }

                    if(this.standardDeviation != null) {
                        var1.writeMessage(4, this.standardDeviation);
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.bias != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(1, this.bias);
                    }

                    if(this.lowerBound != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.lowerBound);
                    }

                    if(this.upperBound != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(3, this.upperBound);
                    }

                    if(this.standardDeviation != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(4, this.standardDeviation);
                    }

                    return var1;
                }

                public final Vr.VREvent.SensorStats.GyroscopeStats mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 10:
                                if(this.bias == null) {
                                    this.bias = new Vr.VREvent.SensorStats.Vector3();
                                }

                                var1.readMessage(this.bias);
                                break;
                            case 18:
                                if(this.lowerBound == null) {
                                    this.lowerBound = new Vr.VREvent.SensorStats.Vector3();
                                }

                                var1.readMessage(this.lowerBound);
                                break;
                            case 26:
                                if(this.upperBound == null) {
                                    this.upperBound = new Vr.VREvent.SensorStats.Vector3();
                                }

                                var1.readMessage(this.upperBound);
                                break;
                            case 34:
                                if(this.standardDeviation == null) {
                                    this.standardDeviation = new Vr.VREvent.SensorStats.Vector3();
                                }

                                var1.readMessage(this.standardDeviation);
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.SensorStats.GyroscopeStats parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.SensorStats.GyroscopeStats)MessageNano.mergeFrom(new Vr.VREvent.SensorStats.GyroscopeStats(), var0);
                }

                public static Vr.VREvent.SensorStats.GyroscopeStats parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.SensorStats.GyroscopeStats()).mergeFrom(var0);
                }
            }

            public static final class Vector3 extends ExtendableMessageNano<Vr.VREvent.SensorStats.Vector3> implements Cloneable {
                private static volatile Vr.VREvent.SensorStats.Vector3[] _emptyArray;
                public Float x;
                public Float y;
                public Float z;

                public static Vr.VREvent.SensorStats.Vector3[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.SensorStats.Vector3[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public Vector3() {
                    this.clear();
                }

                public final Vr.VREvent.SensorStats.Vector3 clear() {
                    this.x = null;
                    this.y = null;
                    this.z = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.SensorStats.Vector3 clone() {
                    try {
                        Vr.VREvent.SensorStats.Vector3 var1 = (Vr.VREvent.SensorStats.Vector3)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.x != null) {
                        var1.writeFloat(1, this.x.floatValue());
                    }

                    if(this.y != null) {
                        var1.writeFloat(2, this.y.floatValue());
                    }

                    if(this.z != null) {
                        var1.writeFloat(3, this.z.floatValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.x != null) {
                        var1 += CodedOutputByteBufferNano.computeFloatSize(1, this.x.floatValue());
                    }

                    if(this.y != null) {
                        var1 += CodedOutputByteBufferNano.computeFloatSize(2, this.y.floatValue());
                    }

                    if(this.z != null) {
                        var1 += CodedOutputByteBufferNano.computeFloatSize(3, this.z.floatValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.SensorStats.Vector3 mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 13:
                                this.x = Float.valueOf(var1.readFloat());
                                break;
                            case 21:
                                this.y = Float.valueOf(var1.readFloat());
                                break;
                            case 29:
                                this.z = Float.valueOf(var1.readFloat());
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.SensorStats.Vector3 parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.SensorStats.Vector3)MessageNano.mergeFrom(new Vr.VREvent.SensorStats.Vector3(), var0);
                }

                public static Vr.VREvent.SensorStats.Vector3 parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.SensorStats.Vector3()).mergeFrom(var0);
                }
            }
        }

        public static final class PerformanceStats extends ExtendableMessageNano<Vr.VREvent.PerformanceStats> implements Cloneable {
            private static volatile Vr.VREvent.PerformanceStats[] _emptyArray;
            public Integer averageFps;
            public Vr.VREvent.HistogramBucket[] frameTime;
            public Integer memoryConsumptionKilobytes;
            public Float throttleSkinTemperatureCelsius;
            public Float vrMaxSkinTemperatureCelsius;
            public Float shutdownSkinTemperatureCelsius;
            public Vr.VREvent.TimeSeriesData timeSeriesData;
            public Vr.VREvent.HistogramBucket[] appRenderTime;
            public Vr.VREvent.HistogramBucket[] presentTime;
            public Vr.VREvent.HistogramBucket[] totalRenderTime;
            public Vr.VREvent.HistogramBucket[] postFrameTime;
            public Vr.VREvent.HistogramBucket[] consecutiveDroppedFrames;
            public Vr.VREvent.HistogramBucket[] scanlineRacingVsyncOvershootUs;
            public Integer thermalExitFlowShown;
            public float[] cpuThrottlingTemperature;
            public float[] gpuThrottlingTemperature;
            public float[] batteryThrottlingTemperature;
            public float[] cpuShutdownTemperature;
            public float[] gpuShutdownTemperature;
            public float[] batteryShutdownTemperature;

            public static Vr.VREvent.PerformanceStats[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.PerformanceStats[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public PerformanceStats() {
                this.clear();
            }

            public final Vr.VREvent.PerformanceStats clear() {
                this.averageFps = null;
                this.frameTime = Vr.VREvent.HistogramBucket.emptyArray();
                this.memoryConsumptionKilobytes = null;
                this.throttleSkinTemperatureCelsius = null;
                this.vrMaxSkinTemperatureCelsius = null;
                this.shutdownSkinTemperatureCelsius = null;
                this.timeSeriesData = null;
                this.appRenderTime = Vr.VREvent.HistogramBucket.emptyArray();
                this.presentTime = Vr.VREvent.HistogramBucket.emptyArray();
                this.totalRenderTime = Vr.VREvent.HistogramBucket.emptyArray();
                this.postFrameTime = Vr.VREvent.HistogramBucket.emptyArray();
                this.consecutiveDroppedFrames = Vr.VREvent.HistogramBucket.emptyArray();
                this.scanlineRacingVsyncOvershootUs = Vr.VREvent.HistogramBucket.emptyArray();
                this.thermalExitFlowShown = null;
                this.cpuThrottlingTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.gpuThrottlingTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.batteryThrottlingTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.cpuShutdownTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.gpuShutdownTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.batteryShutdownTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.PerformanceStats clone() {
                Vr.VREvent.PerformanceStats var1;
                try {
                    var1 = (Vr.VREvent.PerformanceStats)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                int var2;
                if(this.frameTime != null && this.frameTime.length > 0) {
                    var1.frameTime = new Vr.VREvent.HistogramBucket[this.frameTime.length];

                    for(var2 = 0; var2 < this.frameTime.length; ++var2) {
                        if(this.frameTime[var2] != null) {
                            var1.frameTime[var2] = this.frameTime[var2].clone();
                        }
                    }
                }

                if(this.timeSeriesData != null) {
                    var1.timeSeriesData = this.timeSeriesData.clone();
                }

                if(this.appRenderTime != null && this.appRenderTime.length > 0) {
                    var1.appRenderTime = new Vr.VREvent.HistogramBucket[this.appRenderTime.length];

                    for(var2 = 0; var2 < this.appRenderTime.length; ++var2) {
                        if(this.appRenderTime[var2] != null) {
                            var1.appRenderTime[var2] = this.appRenderTime[var2].clone();
                        }
                    }
                }

                if(this.presentTime != null && this.presentTime.length > 0) {
                    var1.presentTime = new Vr.VREvent.HistogramBucket[this.presentTime.length];

                    for(var2 = 0; var2 < this.presentTime.length; ++var2) {
                        if(this.presentTime[var2] != null) {
                            var1.presentTime[var2] = this.presentTime[var2].clone();
                        }
                    }
                }

                if(this.totalRenderTime != null && this.totalRenderTime.length > 0) {
                    var1.totalRenderTime = new Vr.VREvent.HistogramBucket[this.totalRenderTime.length];

                    for(var2 = 0; var2 < this.totalRenderTime.length; ++var2) {
                        if(this.totalRenderTime[var2] != null) {
                            var1.totalRenderTime[var2] = this.totalRenderTime[var2].clone();
                        }
                    }
                }

                if(this.postFrameTime != null && this.postFrameTime.length > 0) {
                    var1.postFrameTime = new Vr.VREvent.HistogramBucket[this.postFrameTime.length];

                    for(var2 = 0; var2 < this.postFrameTime.length; ++var2) {
                        if(this.postFrameTime[var2] != null) {
                            var1.postFrameTime[var2] = this.postFrameTime[var2].clone();
                        }
                    }
                }

                if(this.consecutiveDroppedFrames != null && this.consecutiveDroppedFrames.length > 0) {
                    var1.consecutiveDroppedFrames = new Vr.VREvent.HistogramBucket[this.consecutiveDroppedFrames.length];

                    for(var2 = 0; var2 < this.consecutiveDroppedFrames.length; ++var2) {
                        if(this.consecutiveDroppedFrames[var2] != null) {
                            var1.consecutiveDroppedFrames[var2] = this.consecutiveDroppedFrames[var2].clone();
                        }
                    }
                }

                if(this.scanlineRacingVsyncOvershootUs != null && this.scanlineRacingVsyncOvershootUs.length > 0) {
                    var1.scanlineRacingVsyncOvershootUs = new Vr.VREvent.HistogramBucket[this.scanlineRacingVsyncOvershootUs.length];

                    for(var2 = 0; var2 < this.scanlineRacingVsyncOvershootUs.length; ++var2) {
                        if(this.scanlineRacingVsyncOvershootUs[var2] != null) {
                            var1.scanlineRacingVsyncOvershootUs[var2] = this.scanlineRacingVsyncOvershootUs[var2].clone();
                        }
                    }
                }

                if(this.cpuThrottlingTemperature != null && this.cpuThrottlingTemperature.length > 0) {
                    var1.cpuThrottlingTemperature = (float[])this.cpuThrottlingTemperature.clone();
                }

                if(this.gpuThrottlingTemperature != null && this.gpuThrottlingTemperature.length > 0) {
                    var1.gpuThrottlingTemperature = (float[])this.gpuThrottlingTemperature.clone();
                }

                if(this.batteryThrottlingTemperature != null && this.batteryThrottlingTemperature.length > 0) {
                    var1.batteryThrottlingTemperature = (float[])this.batteryThrottlingTemperature.clone();
                }

                if(this.cpuShutdownTemperature != null && this.cpuShutdownTemperature.length > 0) {
                    var1.cpuShutdownTemperature = (float[])this.cpuShutdownTemperature.clone();
                }

                if(this.gpuShutdownTemperature != null && this.gpuShutdownTemperature.length > 0) {
                    var1.gpuShutdownTemperature = (float[])this.gpuShutdownTemperature.clone();
                }

                if(this.batteryShutdownTemperature != null && this.batteryShutdownTemperature.length > 0) {
                    var1.batteryShutdownTemperature = (float[])this.batteryShutdownTemperature.clone();
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.averageFps != null) {
                    var1.writeInt32(1, this.averageFps.intValue());
                }

                int var2;
                Vr.VREvent.HistogramBucket var3;
                if(this.frameTime != null && this.frameTime.length > 0) {
                    for(var2 = 0; var2 < this.frameTime.length; ++var2) {
                        if((var3 = this.frameTime[var2]) != null) {
                            var1.writeMessage(2, var3);
                        }
                    }
                }

                if(this.memoryConsumptionKilobytes != null) {
                    var1.writeInt32(3, this.memoryConsumptionKilobytes.intValue());
                }

                if(this.throttleSkinTemperatureCelsius != null) {
                    var1.writeFloat(4, this.throttleSkinTemperatureCelsius.floatValue());
                }

                if(this.vrMaxSkinTemperatureCelsius != null) {
                    var1.writeFloat(5, this.vrMaxSkinTemperatureCelsius.floatValue());
                }

                if(this.shutdownSkinTemperatureCelsius != null) {
                    var1.writeFloat(6, this.shutdownSkinTemperatureCelsius.floatValue());
                }

                if(this.timeSeriesData != null) {
                    var1.writeMessage(7, this.timeSeriesData);
                }

                if(this.appRenderTime != null && this.appRenderTime.length > 0) {
                    for(var2 = 0; var2 < this.appRenderTime.length; ++var2) {
                        if((var3 = this.appRenderTime[var2]) != null) {
                            var1.writeMessage(8, var3);
                        }
                    }
                }

                if(this.presentTime != null && this.presentTime.length > 0) {
                    for(var2 = 0; var2 < this.presentTime.length; ++var2) {
                        if((var3 = this.presentTime[var2]) != null) {
                            var1.writeMessage(9, var3);
                        }
                    }
                }

                if(this.totalRenderTime != null && this.totalRenderTime.length > 0) {
                    for(var2 = 0; var2 < this.totalRenderTime.length; ++var2) {
                        if((var3 = this.totalRenderTime[var2]) != null) {
                            var1.writeMessage(10, var3);
                        }
                    }
                }

                if(this.postFrameTime != null && this.postFrameTime.length > 0) {
                    for(var2 = 0; var2 < this.postFrameTime.length; ++var2) {
                        if((var3 = this.postFrameTime[var2]) != null) {
                            var1.writeMessage(11, var3);
                        }
                    }
                }

                if(this.consecutiveDroppedFrames != null && this.consecutiveDroppedFrames.length > 0) {
                    for(var2 = 0; var2 < this.consecutiveDroppedFrames.length; ++var2) {
                        if((var3 = this.consecutiveDroppedFrames[var2]) != null) {
                            var1.writeMessage(12, var3);
                        }
                    }
                }

                if(this.scanlineRacingVsyncOvershootUs != null && this.scanlineRacingVsyncOvershootUs.length > 0) {
                    for(var2 = 0; var2 < this.scanlineRacingVsyncOvershootUs.length; ++var2) {
                        if((var3 = this.scanlineRacingVsyncOvershootUs[var2]) != null) {
                            var1.writeMessage(13, var3);
                        }
                    }
                }

                if(this.thermalExitFlowShown != null) {
                    var1.writeInt32(14, this.thermalExitFlowShown.intValue());
                }

                if(this.cpuThrottlingTemperature != null && this.cpuThrottlingTemperature.length > 0) {
                    for(var2 = 0; var2 < this.cpuThrottlingTemperature.length; ++var2) {
                        var1.writeFloat(15, this.cpuThrottlingTemperature[var2]);
                    }
                }

                if(this.gpuThrottlingTemperature != null && this.gpuThrottlingTemperature.length > 0) {
                    for(var2 = 0; var2 < this.gpuThrottlingTemperature.length; ++var2) {
                        var1.writeFloat(16, this.gpuThrottlingTemperature[var2]);
                    }
                }

                if(this.batteryThrottlingTemperature != null && this.batteryThrottlingTemperature.length > 0) {
                    for(var2 = 0; var2 < this.batteryThrottlingTemperature.length; ++var2) {
                        var1.writeFloat(17, this.batteryThrottlingTemperature[var2]);
                    }
                }

                if(this.cpuShutdownTemperature != null && this.cpuShutdownTemperature.length > 0) {
                    for(var2 = 0; var2 < this.cpuShutdownTemperature.length; ++var2) {
                        var1.writeFloat(18, this.cpuShutdownTemperature[var2]);
                    }
                }

                if(this.gpuShutdownTemperature != null && this.gpuShutdownTemperature.length > 0) {
                    for(var2 = 0; var2 < this.gpuShutdownTemperature.length; ++var2) {
                        var1.writeFloat(19, this.gpuShutdownTemperature[var2]);
                    }
                }

                if(this.batteryShutdownTemperature != null && this.batteryShutdownTemperature.length > 0) {
                    for(var2 = 0; var2 < this.batteryShutdownTemperature.length; ++var2) {
                        var1.writeFloat(20, this.batteryShutdownTemperature[var2]);
                    }
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.averageFps != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.averageFps.intValue());
                }

                int var2;
                Vr.VREvent.HistogramBucket var3;
                if(this.frameTime != null && this.frameTime.length > 0) {
                    for(var2 = 0; var2 < this.frameTime.length; ++var2) {
                        if((var3 = this.frameTime[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(2, var3);
                        }
                    }
                }

                if(this.memoryConsumptionKilobytes != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(3, this.memoryConsumptionKilobytes.intValue());
                }

                if(this.throttleSkinTemperatureCelsius != null) {
                    var1 += CodedOutputByteBufferNano.computeFloatSize(4, this.throttleSkinTemperatureCelsius.floatValue());
                }

                if(this.vrMaxSkinTemperatureCelsius != null) {
                    var1 += CodedOutputByteBufferNano.computeFloatSize(5, this.vrMaxSkinTemperatureCelsius.floatValue());
                }

                if(this.shutdownSkinTemperatureCelsius != null) {
                    var1 += CodedOutputByteBufferNano.computeFloatSize(6, this.shutdownSkinTemperatureCelsius.floatValue());
                }

                if(this.timeSeriesData != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(7, this.timeSeriesData);
                }

                if(this.appRenderTime != null && this.appRenderTime.length > 0) {
                    for(var2 = 0; var2 < this.appRenderTime.length; ++var2) {
                        if((var3 = this.appRenderTime[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(8, var3);
                        }
                    }
                }

                if(this.presentTime != null && this.presentTime.length > 0) {
                    for(var2 = 0; var2 < this.presentTime.length; ++var2) {
                        if((var3 = this.presentTime[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(9, var3);
                        }
                    }
                }

                if(this.totalRenderTime != null && this.totalRenderTime.length > 0) {
                    for(var2 = 0; var2 < this.totalRenderTime.length; ++var2) {
                        if((var3 = this.totalRenderTime[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(10, var3);
                        }
                    }
                }

                if(this.postFrameTime != null && this.postFrameTime.length > 0) {
                    for(var2 = 0; var2 < this.postFrameTime.length; ++var2) {
                        if((var3 = this.postFrameTime[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(11, var3);
                        }
                    }
                }

                if(this.consecutiveDroppedFrames != null && this.consecutiveDroppedFrames.length > 0) {
                    for(var2 = 0; var2 < this.consecutiveDroppedFrames.length; ++var2) {
                        if((var3 = this.consecutiveDroppedFrames[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(12, var3);
                        }
                    }
                }

                if(this.scanlineRacingVsyncOvershootUs != null && this.scanlineRacingVsyncOvershootUs.length > 0) {
                    for(var2 = 0; var2 < this.scanlineRacingVsyncOvershootUs.length; ++var2) {
                        if((var3 = this.scanlineRacingVsyncOvershootUs[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(13, var3);
                        }
                    }
                }

                if(this.thermalExitFlowShown != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(14, this.thermalExitFlowShown.intValue());
                }

                if(this.cpuThrottlingTemperature != null && this.cpuThrottlingTemperature.length > 0) {
                    var2 = 4 * this.cpuThrottlingTemperature.length;
                    var1 = var1 + var2 + 1 * this.cpuThrottlingTemperature.length;
                }

                if(this.gpuThrottlingTemperature != null && this.gpuThrottlingTemperature.length > 0) {
                    var2 = 4 * this.gpuThrottlingTemperature.length;
                    var1 = var1 + var2 + 2 * this.gpuThrottlingTemperature.length;
                }

                if(this.batteryThrottlingTemperature != null && this.batteryThrottlingTemperature.length > 0) {
                    var2 = 4 * this.batteryThrottlingTemperature.length;
                    var1 = var1 + var2 + 2 * this.batteryThrottlingTemperature.length;
                }

                if(this.cpuShutdownTemperature != null && this.cpuShutdownTemperature.length > 0) {
                    var2 = 4 * this.cpuShutdownTemperature.length;
                    var1 = var1 + var2 + 2 * this.cpuShutdownTemperature.length;
                }

                if(this.gpuShutdownTemperature != null && this.gpuShutdownTemperature.length > 0) {
                    var2 = 4 * this.gpuShutdownTemperature.length;
                    var1 = var1 + var2 + 2 * this.gpuShutdownTemperature.length;
                }

                if(this.batteryShutdownTemperature != null && this.batteryShutdownTemperature.length > 0) {
                    var2 = 4 * this.batteryShutdownTemperature.length;
                    var1 = var1 + var2 + 2 * this.batteryShutdownTemperature.length;
                }

                return var1;
            }

            public final Vr.VREvent.PerformanceStats mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    int var3;
                    int var4;
                    float[] var5;
                    int var6;
                    float[] var7;
                    int var8;
                    Vr.VREvent.HistogramBucket[] var9;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 8:
                            this.averageFps = Integer.valueOf(var1.readInt32());
                            continue;
                        case 18:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 18);
                            var9 = new Vr.VREvent.HistogramBucket[(var4 = this.frameTime == null?0:this.frameTime.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.frameTime, 0, var9, 0, var4);
                            }
                            break;
                        case 24:
                            this.memoryConsumptionKilobytes = Integer.valueOf(var1.readInt32());
                            continue;
                        case 37:
                            this.throttleSkinTemperatureCelsius = Float.valueOf(var1.readFloat());
                            continue;
                        case 45:
                            this.vrMaxSkinTemperatureCelsius = Float.valueOf(var1.readFloat());
                            continue;
                        case 53:
                            this.shutdownSkinTemperatureCelsius = Float.valueOf(var1.readFloat());
                            continue;
                        case 58:
                            if(this.timeSeriesData == null) {
                                this.timeSeriesData = new Vr.VREvent.TimeSeriesData();
                            }

                            var1.readMessage(this.timeSeriesData);
                            continue;
                        case 66:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 66);
                            var9 = new Vr.VREvent.HistogramBucket[(var4 = this.appRenderTime == null?0:this.appRenderTime.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.appRenderTime, 0, var9, 0, var4);
                            }

                            while(var4 < var9.length - 1) {
                                var9[var4] = new Vr.VREvent.HistogramBucket();
                                var1.readMessage(var9[var4]);
                                var1.readTag();
                                ++var4;
                            }

                            var9[var4] = new Vr.VREvent.HistogramBucket();
                            var1.readMessage(var9[var4]);
                            this.appRenderTime = var9;
                            continue;
                        case 74:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 74);
                            var9 = new Vr.VREvent.HistogramBucket[(var4 = this.presentTime == null?0:this.presentTime.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.presentTime, 0, var9, 0, var4);
                            }

                            while(var4 < var9.length - 1) {
                                var9[var4] = new Vr.VREvent.HistogramBucket();
                                var1.readMessage(var9[var4]);
                                var1.readTag();
                                ++var4;
                            }

                            var9[var4] = new Vr.VREvent.HistogramBucket();
                            var1.readMessage(var9[var4]);
                            this.presentTime = var9;
                            continue;
                        case 82:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 82);
                            var9 = new Vr.VREvent.HistogramBucket[(var4 = this.totalRenderTime == null?0:this.totalRenderTime.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.totalRenderTime, 0, var9, 0, var4);
                            }

                            while(var4 < var9.length - 1) {
                                var9[var4] = new Vr.VREvent.HistogramBucket();
                                var1.readMessage(var9[var4]);
                                var1.readTag();
                                ++var4;
                            }

                            var9[var4] = new Vr.VREvent.HistogramBucket();
                            var1.readMessage(var9[var4]);
                            this.totalRenderTime = var9;
                            continue;
                        case 90:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 90);
                            var9 = new Vr.VREvent.HistogramBucket[(var4 = this.postFrameTime == null?0:this.postFrameTime.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.postFrameTime, 0, var9, 0, var4);
                            }

                            while(var4 < var9.length - 1) {
                                var9[var4] = new Vr.VREvent.HistogramBucket();
                                var1.readMessage(var9[var4]);
                                var1.readTag();
                                ++var4;
                            }

                            var9[var4] = new Vr.VREvent.HistogramBucket();
                            var1.readMessage(var9[var4]);
                            this.postFrameTime = var9;
                            continue;
                        case 98:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 98);
                            var9 = new Vr.VREvent.HistogramBucket[(var4 = this.consecutiveDroppedFrames == null?0:this.consecutiveDroppedFrames.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.consecutiveDroppedFrames, 0, var9, 0, var4);
                            }

                            while(var4 < var9.length - 1) {
                                var9[var4] = new Vr.VREvent.HistogramBucket();
                                var1.readMessage(var9[var4]);
                                var1.readTag();
                                ++var4;
                            }

                            var9[var4] = new Vr.VREvent.HistogramBucket();
                            var1.readMessage(var9[var4]);
                            this.consecutiveDroppedFrames = var9;
                            continue;
                        case 106:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 106);
                            var9 = new Vr.VREvent.HistogramBucket[(var4 = this.scanlineRacingVsyncOvershootUs == null?0:this.scanlineRacingVsyncOvershootUs.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.scanlineRacingVsyncOvershootUs, 0, var9, 0, var4);
                            }

                            while(var4 < var9.length - 1) {
                                var9[var4] = new Vr.VREvent.HistogramBucket();
                                var1.readMessage(var9[var4]);
                                var1.readTag();
                                ++var4;
                            }

                            var9[var4] = new Vr.VREvent.HistogramBucket();
                            var1.readMessage(var9[var4]);
                            this.scanlineRacingVsyncOvershootUs = var9;
                            continue;
                        case 112:
                            this.thermalExitFlowShown = Integer.valueOf(var1.readInt32());
                            continue;
                        case 122:
                            var3 = var1.readRawVarint32();
                            var4 = var1.pushLimit(var3);
                            var8 = var3 / 4;
                            var7 = new float[(var6 = this.cpuThrottlingTemperature == null?0:this.cpuThrottlingTemperature.length) + var8];
                            if(var6 != 0) {
                                System.arraycopy(this.cpuThrottlingTemperature, 0, var7, 0, var6);
                            }

                            while(var6 < var7.length) {
                                var7[var6] = var1.readFloat();
                                ++var6;
                            }

                            this.cpuThrottlingTemperature = var7;
                            var1.popLimit(var4);
                            continue;
                        case 125:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 125);
                            var5 = new float[(var4 = this.cpuThrottlingTemperature == null?0:this.cpuThrottlingTemperature.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.cpuThrottlingTemperature, 0, var5, 0, var4);
                            }

                            while(var4 < var5.length - 1) {
                                var5[var4] = var1.readFloat();
                                var1.readTag();
                                ++var4;
                            }

                            var5[var4] = var1.readFloat();
                            this.cpuThrottlingTemperature = var5;
                            continue;
                        case 130:
                            var3 = var1.readRawVarint32();
                            var4 = var1.pushLimit(var3);
                            var8 = var3 / 4;
                            var7 = new float[(var6 = this.gpuThrottlingTemperature == null?0:this.gpuThrottlingTemperature.length) + var8];
                            if(var6 != 0) {
                                System.arraycopy(this.gpuThrottlingTemperature, 0, var7, 0, var6);
                            }

                            while(var6 < var7.length) {
                                var7[var6] = var1.readFloat();
                                ++var6;
                            }

                            this.gpuThrottlingTemperature = var7;
                            var1.popLimit(var4);
                            continue;
                        case 133:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 133);
                            var5 = new float[(var4 = this.gpuThrottlingTemperature == null?0:this.gpuThrottlingTemperature.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.gpuThrottlingTemperature, 0, var5, 0, var4);
                            }

                            while(var4 < var5.length - 1) {
                                var5[var4] = var1.readFloat();
                                var1.readTag();
                                ++var4;
                            }

                            var5[var4] = var1.readFloat();
                            this.gpuThrottlingTemperature = var5;
                            continue;
                        case 138:
                            var3 = var1.readRawVarint32();
                            var4 = var1.pushLimit(var3);
                            var8 = var3 / 4;
                            var7 = new float[(var6 = this.batteryThrottlingTemperature == null?0:this.batteryThrottlingTemperature.length) + var8];
                            if(var6 != 0) {
                                System.arraycopy(this.batteryThrottlingTemperature, 0, var7, 0, var6);
                            }

                            while(var6 < var7.length) {
                                var7[var6] = var1.readFloat();
                                ++var6;
                            }

                            this.batteryThrottlingTemperature = var7;
                            var1.popLimit(var4);
                            continue;
                        case 141:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 141);
                            var5 = new float[(var4 = this.batteryThrottlingTemperature == null?0:this.batteryThrottlingTemperature.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.batteryThrottlingTemperature, 0, var5, 0, var4);
                            }

                            while(var4 < var5.length - 1) {
                                var5[var4] = var1.readFloat();
                                var1.readTag();
                                ++var4;
                            }

                            var5[var4] = var1.readFloat();
                            this.batteryThrottlingTemperature = var5;
                            continue;
                        case 146:
                            var3 = var1.readRawVarint32();
                            var4 = var1.pushLimit(var3);
                            var8 = var3 / 4;
                            var7 = new float[(var6 = this.cpuShutdownTemperature == null?0:this.cpuShutdownTemperature.length) + var8];
                            if(var6 != 0) {
                                System.arraycopy(this.cpuShutdownTemperature, 0, var7, 0, var6);
                            }

                            while(var6 < var7.length) {
                                var7[var6] = var1.readFloat();
                                ++var6;
                            }

                            this.cpuShutdownTemperature = var7;
                            var1.popLimit(var4);
                            continue;
                        case 149:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 149);
                            var5 = new float[(var4 = this.cpuShutdownTemperature == null?0:this.cpuShutdownTemperature.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.cpuShutdownTemperature, 0, var5, 0, var4);
                            }

                            while(var4 < var5.length - 1) {
                                var5[var4] = var1.readFloat();
                                var1.readTag();
                                ++var4;
                            }

                            var5[var4] = var1.readFloat();
                            this.cpuShutdownTemperature = var5;
                            continue;
                        case 154:
                            var3 = var1.readRawVarint32();
                            var4 = var1.pushLimit(var3);
                            var8 = var3 / 4;
                            var7 = new float[(var6 = this.gpuShutdownTemperature == null?0:this.gpuShutdownTemperature.length) + var8];
                            if(var6 != 0) {
                                System.arraycopy(this.gpuShutdownTemperature, 0, var7, 0, var6);
                            }

                            while(var6 < var7.length) {
                                var7[var6] = var1.readFloat();
                                ++var6;
                            }

                            this.gpuShutdownTemperature = var7;
                            var1.popLimit(var4);
                            continue;
                        case 157:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 157);
                            var5 = new float[(var4 = this.gpuShutdownTemperature == null?0:this.gpuShutdownTemperature.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.gpuShutdownTemperature, 0, var5, 0, var4);
                            }

                            while(var4 < var5.length - 1) {
                                var5[var4] = var1.readFloat();
                                var1.readTag();
                                ++var4;
                            }

                            var5[var4] = var1.readFloat();
                            this.gpuShutdownTemperature = var5;
                            continue;
                        case 162:
                            var3 = var1.readRawVarint32();
                            var4 = var1.pushLimit(var3);
                            var8 = var3 / 4;
                            var7 = new float[(var6 = this.batteryShutdownTemperature == null?0:this.batteryShutdownTemperature.length) + var8];
                            if(var6 != 0) {
                                System.arraycopy(this.batteryShutdownTemperature, 0, var7, 0, var6);
                            }

                            while(var6 < var7.length) {
                                var7[var6] = var1.readFloat();
                                ++var6;
                            }

                            this.batteryShutdownTemperature = var7;
                            var1.popLimit(var4);
                            continue;
                        case 165:
                            var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 165);
                            var5 = new float[(var4 = this.batteryShutdownTemperature == null?0:this.batteryShutdownTemperature.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.batteryShutdownTemperature, 0, var5, 0, var4);
                            }

                            while(var4 < var5.length - 1) {
                                var5[var4] = var1.readFloat();
                                var1.readTag();
                                ++var4;
                            }

                            var5[var4] = var1.readFloat();
                            this.batteryShutdownTemperature = var5;
                            continue;
                        default:
                            if(super.storeUnknownField(var1, var2)) {
                                continue;
                            }

                            return this;
                    }

                    while(var4 < var9.length - 1) {
                        var9[var4] = new Vr.VREvent.HistogramBucket();
                        var1.readMessage(var9[var4]);
                        var1.readTag();
                        ++var4;
                    }

                    var9[var4] = new Vr.VREvent.HistogramBucket();
                    var1.readMessage(var9[var4]);
                    this.frameTime = var9;
                }
            }

            public static Vr.VREvent.PerformanceStats parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.PerformanceStats)MessageNano.mergeFrom(new Vr.VREvent.PerformanceStats(), var0);
            }

            public static Vr.VREvent.PerformanceStats parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.PerformanceStats()).mergeFrom(var0);
            }
        }

        public static final class TimeSeriesData extends ExtendableMessageNano<Vr.VREvent.TimeSeriesData> implements Cloneable {
            private static volatile Vr.VREvent.TimeSeriesData[] _emptyArray;
            public Integer timeIntervalSeconds;
            public Vr.VREvent.TimeSeriesData.TimeIntervalData[] timeIntervalData;

            public static Vr.VREvent.TimeSeriesData[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.TimeSeriesData[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public TimeSeriesData() {
                this.clear();
            }

            public final Vr.VREvent.TimeSeriesData clear() {
                this.timeIntervalSeconds = null;
                this.timeIntervalData = Vr.VREvent.TimeSeriesData.TimeIntervalData.emptyArray();
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.TimeSeriesData clone() {
                Vr.VREvent.TimeSeriesData var1;
                try {
                    var1 = (Vr.VREvent.TimeSeriesData)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.timeIntervalData != null && this.timeIntervalData.length > 0) {
                    var1.timeIntervalData = new Vr.VREvent.TimeSeriesData.TimeIntervalData[this.timeIntervalData.length];

                    for(int var2 = 0; var2 < this.timeIntervalData.length; ++var2) {
                        if(this.timeIntervalData[var2] != null) {
                            var1.timeIntervalData[var2] = this.timeIntervalData[var2].clone();
                        }
                    }
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.timeIntervalSeconds != null) {
                    var1.writeInt32(1, this.timeIntervalSeconds.intValue());
                }

                if(this.timeIntervalData != null && this.timeIntervalData.length > 0) {
                    for(int var2 = 0; var2 < this.timeIntervalData.length; ++var2) {
                        Vr.VREvent.TimeSeriesData.TimeIntervalData var3;
                        if((var3 = this.timeIntervalData[var2]) != null) {
                            var1.writeMessage(2, var3);
                        }
                    }
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.timeIntervalSeconds != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.timeIntervalSeconds.intValue());
                }

                if(this.timeIntervalData != null && this.timeIntervalData.length > 0) {
                    for(int var2 = 0; var2 < this.timeIntervalData.length; ++var2) {
                        Vr.VREvent.TimeSeriesData.TimeIntervalData var3;
                        if((var3 = this.timeIntervalData[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(2, var3);
                        }
                    }
                }

                return var1;
            }

            public final Vr.VREvent.TimeSeriesData mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    int var4;
                    Vr.VREvent.TimeSeriesData.TimeIntervalData[] var5;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 8:
                            this.timeIntervalSeconds = Integer.valueOf(var1.readInt32());
                            continue;
                        case 18:
                            int var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 18);
                            var5 = new Vr.VREvent.TimeSeriesData.TimeIntervalData[(var4 = this.timeIntervalData == null?0:this.timeIntervalData.length) + var3];
                            if(var4 != 0) {
                                System.arraycopy(this.timeIntervalData, 0, var5, 0, var4);
                            }
                            break;
                        default:
                            if(super.storeUnknownField(var1, var2)) {
                                continue;
                            }

                            return this;
                    }

                    while(var4 < var5.length - 1) {
                        var5[var4] = new Vr.VREvent.TimeSeriesData.TimeIntervalData();
                        var1.readMessage(var5[var4]);
                        var1.readTag();
                        ++var4;
                    }

                    var5[var4] = new Vr.VREvent.TimeSeriesData.TimeIntervalData();
                    var1.readMessage(var5[var4]);
                    this.timeIntervalData = var5;
                }
            }

            public static Vr.VREvent.TimeSeriesData parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.TimeSeriesData)MessageNano.mergeFrom(new Vr.VREvent.TimeSeriesData(), var0);
            }

            public static Vr.VREvent.TimeSeriesData parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.TimeSeriesData()).mergeFrom(var0);
            }

            public static final class TimeIntervalData extends ExtendableMessageNano<Vr.VREvent.TimeSeriesData.TimeIntervalData> implements Cloneable {
                private static volatile Vr.VREvent.TimeSeriesData.TimeIntervalData[] _emptyArray;
                public Integer intervalStartTimeSeconds;
                public Float skinTemperature;
                public Integer edsThreadFrameDropCount;
                public Integer batteryLevel;
                public Integer batteryLevelDelta;
                public Integer thermalWarningsShown;
                public float[] cpuTemperature;
                public float[] gpuTemperature;
                public float[] batteryTemperature;

                public static Vr.VREvent.TimeSeriesData.TimeIntervalData[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.TimeSeriesData.TimeIntervalData[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public TimeIntervalData() {
                    this.clear();
                }

                public final Vr.VREvent.TimeSeriesData.TimeIntervalData clear() {
                    this.intervalStartTimeSeconds = null;
                    this.skinTemperature = null;
                    this.edsThreadFrameDropCount = null;
                    this.batteryLevel = null;
                    this.batteryLevelDelta = null;
                    this.thermalWarningsShown = null;
                    this.cpuTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                    this.gpuTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                    this.batteryTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.TimeSeriesData.TimeIntervalData clone() {
                    Vr.VREvent.TimeSeriesData.TimeIntervalData var1;
                    try {
                        var1 = (Vr.VREvent.TimeSeriesData.TimeIntervalData)super.clone();
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }

                    if(this.cpuTemperature != null && this.cpuTemperature.length > 0) {
                        var1.cpuTemperature = (float[])this.cpuTemperature.clone();
                    }

                    if(this.gpuTemperature != null && this.gpuTemperature.length > 0) {
                        var1.gpuTemperature = (float[])this.gpuTemperature.clone();
                    }

                    if(this.batteryTemperature != null && this.batteryTemperature.length > 0) {
                        var1.batteryTemperature = (float[])this.batteryTemperature.clone();
                    }

                    return var1;
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.intervalStartTimeSeconds != null) {
                        var1.writeInt32(1, this.intervalStartTimeSeconds.intValue());
                    }

                    if(this.skinTemperature != null) {
                        var1.writeFloat(2, this.skinTemperature.floatValue());
                    }

                    if(this.edsThreadFrameDropCount != null) {
                        var1.writeInt32(3, this.edsThreadFrameDropCount.intValue());
                    }

                    if(this.batteryLevel != null) {
                        var1.writeInt32(4, this.batteryLevel.intValue());
                    }

                    if(this.batteryLevelDelta != null) {
                        var1.writeInt32(5, this.batteryLevelDelta.intValue());
                    }

                    if(this.thermalWarningsShown != null) {
                        var1.writeInt32(6, this.thermalWarningsShown.intValue());
                    }

                    int var2;
                    if(this.cpuTemperature != null && this.cpuTemperature.length > 0) {
                        for(var2 = 0; var2 < this.cpuTemperature.length; ++var2) {
                            var1.writeFloat(7, this.cpuTemperature[var2]);
                        }
                    }

                    if(this.gpuTemperature != null && this.gpuTemperature.length > 0) {
                        for(var2 = 0; var2 < this.gpuTemperature.length; ++var2) {
                            var1.writeFloat(8, this.gpuTemperature[var2]);
                        }
                    }

                    if(this.batteryTemperature != null && this.batteryTemperature.length > 0) {
                        for(var2 = 0; var2 < this.batteryTemperature.length; ++var2) {
                            var1.writeFloat(9, this.batteryTemperature[var2]);
                        }
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.intervalStartTimeSeconds != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.intervalStartTimeSeconds.intValue());
                    }

                    if(this.skinTemperature != null) {
                        var1 += CodedOutputByteBufferNano.computeFloatSize(2, this.skinTemperature.floatValue());
                    }

                    if(this.edsThreadFrameDropCount != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(3, this.edsThreadFrameDropCount.intValue());
                    }

                    if(this.batteryLevel != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(4, this.batteryLevel.intValue());
                    }

                    if(this.batteryLevelDelta != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(5, this.batteryLevelDelta.intValue());
                    }

                    if(this.thermalWarningsShown != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(6, this.thermalWarningsShown.intValue());
                    }

                    int var2;
                    if(this.cpuTemperature != null && this.cpuTemperature.length > 0) {
                        var2 = 4 * this.cpuTemperature.length;
                        var1 = var1 + var2 + 1 * this.cpuTemperature.length;
                    }

                    if(this.gpuTemperature != null && this.gpuTemperature.length > 0) {
                        var2 = 4 * this.gpuTemperature.length;
                        var1 = var1 + var2 + 1 * this.gpuTemperature.length;
                    }

                    if(this.batteryTemperature != null && this.batteryTemperature.length > 0) {
                        var2 = 4 * this.batteryTemperature.length;
                        var1 = var1 + var2 + 1 * this.batteryTemperature.length;
                    }

                    return var1;
                }

                public final Vr.VREvent.TimeSeriesData.TimeIntervalData mergeFrom(CodedInputByteBufferNano var1) throws IOException {
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
                            case 8:
                                this.intervalStartTimeSeconds = Integer.valueOf(var1.readInt32());
                                continue;
                            case 21:
                                this.skinTemperature = Float.valueOf(var1.readFloat());
                                continue;
                            case 24:
                                this.edsThreadFrameDropCount = Integer.valueOf(var1.readInt32());
                                continue;
                            case 32:
                                this.batteryLevel = Integer.valueOf(var1.readInt32());
                                continue;
                            case 40:
                                this.batteryLevelDelta = Integer.valueOf(var1.readInt32());
                                continue;
                            case 48:
                                this.thermalWarningsShown = Integer.valueOf(var1.readInt32());
                                continue;
                            case 58:
                                var3 = var1.readRawVarint32();
                                var4 = var1.pushLimit(var3);
                                var8 = var3 / 4;
                                var7 = new float[(var6 = this.cpuTemperature == null?0:this.cpuTemperature.length) + var8];
                                if(var6 != 0) {
                                    System.arraycopy(this.cpuTemperature, 0, var7, 0, var6);
                                }
                                break;
                            case 61:
                                var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 61);
                                var5 = new float[(var4 = this.cpuTemperature == null?0:this.cpuTemperature.length) + var3];
                                if(var4 != 0) {
                                    System.arraycopy(this.cpuTemperature, 0, var5, 0, var4);
                                }

                                while(var4 < var5.length - 1) {
                                    var5[var4] = var1.readFloat();
                                    var1.readTag();
                                    ++var4;
                                }

                                var5[var4] = var1.readFloat();
                                this.cpuTemperature = var5;
                                continue;
                            case 66:
                                var3 = var1.readRawVarint32();
                                var4 = var1.pushLimit(var3);
                                var8 = var3 / 4;
                                var7 = new float[(var6 = this.gpuTemperature == null?0:this.gpuTemperature.length) + var8];
                                if(var6 != 0) {
                                    System.arraycopy(this.gpuTemperature, 0, var7, 0, var6);
                                }

                                while(var6 < var7.length) {
                                    var7[var6] = var1.readFloat();
                                    ++var6;
                                }

                                this.gpuTemperature = var7;
                                var1.popLimit(var4);
                                continue;
                            case 69:
                                var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 69);
                                var5 = new float[(var4 = this.gpuTemperature == null?0:this.gpuTemperature.length) + var3];
                                if(var4 != 0) {
                                    System.arraycopy(this.gpuTemperature, 0, var5, 0, var4);
                                }

                                while(var4 < var5.length - 1) {
                                    var5[var4] = var1.readFloat();
                                    var1.readTag();
                                    ++var4;
                                }

                                var5[var4] = var1.readFloat();
                                this.gpuTemperature = var5;
                                continue;
                            case 74:
                                var3 = var1.readRawVarint32();
                                var4 = var1.pushLimit(var3);
                                var8 = var3 / 4;
                                var7 = new float[(var6 = this.batteryTemperature == null?0:this.batteryTemperature.length) + var8];
                                if(var6 != 0) {
                                    System.arraycopy(this.batteryTemperature, 0, var7, 0, var6);
                                }

                                while(var6 < var7.length) {
                                    var7[var6] = var1.readFloat();
                                    ++var6;
                                }

                                this.batteryTemperature = var7;
                                var1.popLimit(var4);
                                continue;
                            case 77:
                                var3 = WireFormatNano.getRepeatedFieldArrayLength(var1, 77);
                                var5 = new float[(var4 = this.batteryTemperature == null?0:this.batteryTemperature.length) + var3];
                                if(var4 != 0) {
                                    System.arraycopy(this.batteryTemperature, 0, var5, 0, var4);
                                }

                                while(var4 < var5.length - 1) {
                                    var5[var4] = var1.readFloat();
                                    var1.readTag();
                                    ++var4;
                                }

                                var5[var4] = var1.readFloat();
                                this.batteryTemperature = var5;
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

                        this.cpuTemperature = var7;
                        var1.popLimit(var4);
                    }
                }

                public static Vr.VREvent.TimeSeriesData.TimeIntervalData parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.TimeSeriesData.TimeIntervalData)MessageNano.mergeFrom(new Vr.VREvent.TimeSeriesData.TimeIntervalData(), var0);
                }

                public static Vr.VREvent.TimeSeriesData.TimeIntervalData parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.TimeSeriesData.TimeIntervalData()).mergeFrom(var0);
                }
            }
        }

        public static final class HistogramBucket extends ExtendableMessageNano<Vr.VREvent.HistogramBucket> implements Cloneable {
            private static volatile Vr.VREvent.HistogramBucket[] _emptyArray;
            public Integer minimumValue;
            public Integer count;

            public static Vr.VREvent.HistogramBucket[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.HistogramBucket[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public HistogramBucket() {
                this.clear();
            }

            public final Vr.VREvent.HistogramBucket clear() {
                this.minimumValue = null;
                this.count = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.HistogramBucket clone() {
                try {
                    Vr.VREvent.HistogramBucket var1 = (Vr.VREvent.HistogramBucket)super.clone();
                    return var1;
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.minimumValue != null) {
                    var1.writeInt32(1, this.minimumValue.intValue());
                }

                if(this.count != null) {
                    var1.writeInt32(2, this.count.intValue());
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.minimumValue != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.minimumValue.intValue());
                }

                if(this.count != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.count.intValue());
                }

                return var1;
            }

            public final Vr.VREvent.HistogramBucket mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 8:
                            this.minimumValue = Integer.valueOf(var1.readInt32());
                            break;
                        case 16:
                            this.count = Integer.valueOf(var1.readInt32());
                            break;
                        default:
                            if(!super.storeUnknownField(var1, var2)) {
                                return this;
                            }
                    }
                }
            }

            public static Vr.VREvent.HistogramBucket parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.HistogramBucket)MessageNano.mergeFrom(new Vr.VREvent.HistogramBucket(), var0);
            }

            public static Vr.VREvent.HistogramBucket parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.HistogramBucket()).mergeFrom(var0);
            }
        }

        public static final class QrCodeScan extends ExtendableMessageNano<Vr.VREvent.QrCodeScan> implements Cloneable {
            private static volatile Vr.VREvent.QrCodeScan[] _emptyArray;
            public Integer status;
            public String headMountConfigUrl;

            public static Vr.VREvent.QrCodeScan[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.QrCodeScan[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public QrCodeScan() {
                this.clear();
            }

            public final Vr.VREvent.QrCodeScan clear() {
                this.headMountConfigUrl = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.QrCodeScan clone() {
                try {
                    Vr.VREvent.QrCodeScan var1 = (Vr.VREvent.QrCodeScan)super.clone();
                    return var1;
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.status != null) {
                    var1.writeInt32(1, this.status.intValue());
                }

                if(this.headMountConfigUrl != null) {
                    var1.writeString(2, this.headMountConfigUrl);
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.status != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.status.intValue());
                }

                if(this.headMountConfigUrl != null) {
                    var1 += CodedOutputByteBufferNano.computeStringSize(2, this.headMountConfigUrl);
                }

                return var1;
            }

            public final Vr.VREvent.QrCodeScan mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 8:
                            int var3;
                            switch(var3 = var1.readInt32()) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                    this.status = Integer.valueOf(var3);
                                default:
                                    continue;
                            }
                        case 18:
                            this.headMountConfigUrl = var1.readString();
                            break;
                        default:
                            if(!super.storeUnknownField(var1, var2)) {
                                return this;
                            }
                    }
                }
            }

            public static Vr.VREvent.QrCodeScan parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.QrCodeScan)MessageNano.mergeFrom(new Vr.VREvent.QrCodeScan(), var0);
            }

            public static Vr.VREvent.QrCodeScan parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.QrCodeScan()).mergeFrom(var0);
            }

            public interface Status {
                int UNKNOWN = 0;
                int OK = 1;
                int UNEXPECTED_FORMAT = 2;
                int CONNECTION_ERROR = 3;
            }
        }

        public static final class VrHome extends ExtendableMessageNano<Vr.VREvent.VrHome> implements Cloneable {
            private static volatile Vr.VREvent.VrHome[] _emptyArray;
            public Vr.VREvent.VrHome.Setup setup;

            public static Vr.VREvent.VrHome[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.VrHome[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public VrHome() {
                this.clear();
            }

            public final Vr.VREvent.VrHome clear() {
                this.setup = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.VrHome clone() {
                Vr.VREvent.VrHome var1;
                try {
                    var1 = (Vr.VREvent.VrHome)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.setup != null) {
                    var1.setup = this.setup.clone();
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.setup != null) {
                    var1.writeMessage(1, this.setup);
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.setup != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(1, this.setup);
                }

                return var1;
            }

            public final Vr.VREvent.VrHome mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 10:
                            if(this.setup == null) {
                                this.setup = new Vr.VREvent.VrHome.Setup();
                            }

                            var1.readMessage(this.setup);
                            break;
                        default:
                            if(!super.storeUnknownField(var1, var2)) {
                                return this;
                            }
                    }
                }
            }

            public static Vr.VREvent.VrHome parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.VrHome)MessageNano.mergeFrom(new Vr.VREvent.VrHome(), var0);
            }

            public static Vr.VREvent.VrHome parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.VrHome()).mergeFrom(var0);
            }

            public static final class Setup extends ExtendableMessageNano<Vr.VREvent.VrHome.Setup> implements Cloneable {
                private static volatile Vr.VREvent.VrHome.Setup[] _emptyArray;
                public Vr.VREvent.VrHome.Setup.View view;
                public Vr.VREvent.VrHome.Setup.StepStateChange stepStateChange;

                public static Vr.VREvent.VrHome.Setup[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.VrHome.Setup[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public Setup() {
                    this.clear();
                }

                public final Vr.VREvent.VrHome.Setup clear() {
                    this.view = null;
                    this.stepStateChange = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.VrHome.Setup clone() {
                    Vr.VREvent.VrHome.Setup var1;
                    try {
                        var1 = (Vr.VREvent.VrHome.Setup)super.clone();
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }

                    if(this.view != null) {
                        var1.view = this.view.clone();
                    }

                    if(this.stepStateChange != null) {
                        var1.stepStateChange = this.stepStateChange.clone();
                    }

                    return var1;
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.view != null) {
                        var1.writeMessage(1, this.view);
                    }

                    if(this.stepStateChange != null) {
                        var1.writeMessage(2, this.stepStateChange);
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.view != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(1, this.view);
                    }

                    if(this.stepStateChange != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.stepStateChange);
                    }

                    return var1;
                }

                public final Vr.VREvent.VrHome.Setup mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 10:
                                if(this.view == null) {
                                    this.view = new Vr.VREvent.VrHome.Setup.View();
                                }

                                var1.readMessage(this.view);
                                break;
                            case 18:
                                if(this.stepStateChange == null) {
                                    this.stepStateChange = new Vr.VREvent.VrHome.Setup.StepStateChange();
                                }

                                var1.readMessage(this.stepStateChange);
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.VrHome.Setup parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.VrHome.Setup)MessageNano.mergeFrom(new Vr.VREvent.VrHome.Setup(), var0);
                }

                public static Vr.VREvent.VrHome.Setup parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.VrHome.Setup()).mergeFrom(var0);
                }

                public static final class StepStateChange extends ExtendableMessageNano<Vr.VREvent.VrHome.Setup.StepStateChange> implements Cloneable {
                    private static volatile Vr.VREvent.VrHome.Setup.StepStateChange[] _emptyArray;
                    public Integer step;
                    public Integer previousStepState;
                    public Integer newStepState;

                    public static Vr.VREvent.VrHome.Setup.StepStateChange[] emptyArray() {
                        if(_emptyArray == null) {
                            Object var0 = InternalNano.LAZY_INIT_LOCK;
                            synchronized(InternalNano.LAZY_INIT_LOCK) {
                                if(_emptyArray == null) {
                                    _emptyArray = new Vr.VREvent.VrHome.Setup.StepStateChange[0];
                                }
                            }
                        }

                        return _emptyArray;
                    }

                    public StepStateChange() {
                        this.clear();
                    }

                    public final Vr.VREvent.VrHome.Setup.StepStateChange clear() {
                        this.unknownFieldData = null;
                        this.cachedSize = -1;
                        return this;
                    }

                    public final Vr.VREvent.VrHome.Setup.StepStateChange clone() {
                        try {
                            Vr.VREvent.VrHome.Setup.StepStateChange var1 = (Vr.VREvent.VrHome.Setup.StepStateChange)super.clone();
                            return var1;
                        } catch (CloneNotSupportedException var3) {
                            throw new AssertionError(var3);
                        }
                    }

                    public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                        if(this.step != null) {
                            var1.writeInt32(1, this.step.intValue());
                        }

                        if(this.previousStepState != null) {
                            var1.writeInt32(2, this.previousStepState.intValue());
                        }

                        if(this.newStepState != null) {
                            var1.writeInt32(3, this.newStepState.intValue());
                        }

                        super.writeTo(var1);
                    }

                    protected final int computeSerializedSize() {
                        int var1 = super.computeSerializedSize();
                        if(this.step != null) {
                            var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.step.intValue());
                        }

                        if(this.previousStepState != null) {
                            var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.previousStepState.intValue());
                        }

                        if(this.newStepState != null) {
                            var1 += CodedOutputByteBufferNano.computeInt32Size(3, this.newStepState.intValue());
                        }

                        return var1;
                    }

                    public final Vr.VREvent.VrHome.Setup.StepStateChange mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                        while(true) {
                            int var2;
                            int var3;
                            switch(var2 = var1.readTag()) {
                                case 0:
                                    return this;
                                case 8:
                                    switch(var3 = var1.readInt32()) {
                                        case 0:
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 6:
                                        case 7:
                                        case 8:
                                            this.step = Integer.valueOf(var3);
                                        default:
                                            continue;
                                    }
                                case 16:
                                    switch(var3 = var1.readInt32()) {
                                        case 0:
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                            this.previousStepState = Integer.valueOf(var3);
                                        default:
                                            continue;
                                    }
                                case 24:
                                    switch(var3 = var1.readInt32()) {
                                        case 0:
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                            this.newStepState = Integer.valueOf(var3);
                                        default:
                                            continue;
                                    }
                                default:
                                    if(!super.storeUnknownField(var1, var2)) {
                                        return this;
                                    }
                            }
                        }
                    }

                    public static Vr.VREvent.VrHome.Setup.StepStateChange parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                        return (Vr.VREvent.VrHome.Setup.StepStateChange)MessageNano.mergeFrom(new Vr.VREvent.VrHome.Setup.StepStateChange(), var0);
                    }

                    public static Vr.VREvent.VrHome.Setup.StepStateChange parseFrom(CodedInputByteBufferNano var0) throws IOException {
                        return (new Vr.VREvent.VrHome.Setup.StepStateChange()).mergeFrom(var0);
                    }

                    public interface StepState {
                        int UNKNOWN = 0;
                        int ERROR = 1;
                        int LOADING = 2;
                        int COMPLETE = 3;
                        int SHOW = 4;
                    }
                }

                public static final class View extends ExtendableMessageNano<Vr.VREvent.VrHome.Setup.View> implements Cloneable {
                    private static volatile Vr.VREvent.VrHome.Setup.View[] _emptyArray;
                    public Integer step;
                    public Integer page;

                    public static Vr.VREvent.VrHome.Setup.View[] emptyArray() {
                        if(_emptyArray == null) {
                            Object var0 = InternalNano.LAZY_INIT_LOCK;
                            synchronized(InternalNano.LAZY_INIT_LOCK) {
                                if(_emptyArray == null) {
                                    _emptyArray = new Vr.VREvent.VrHome.Setup.View[0];
                                }
                            }
                        }

                        return _emptyArray;
                    }

                    public View() {
                        this.clear();
                    }

                    public final Vr.VREvent.VrHome.Setup.View clear() {
                        this.page = null;
                        this.unknownFieldData = null;
                        this.cachedSize = -1;
                        return this;
                    }

                    public final Vr.VREvent.VrHome.Setup.View clone() {
                        try {
                            Vr.VREvent.VrHome.Setup.View var1 = (Vr.VREvent.VrHome.Setup.View)super.clone();
                            return var1;
                        } catch (CloneNotSupportedException var3) {
                            throw new AssertionError(var3);
                        }
                    }

                    public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                        if(this.step != null) {
                            var1.writeInt32(1, this.step.intValue());
                        }

                        if(this.page != null) {
                            var1.writeInt32(2, this.page.intValue());
                        }

                        super.writeTo(var1);
                    }

                    protected final int computeSerializedSize() {
                        int var1 = super.computeSerializedSize();
                        if(this.step != null) {
                            var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.step.intValue());
                        }

                        if(this.page != null) {
                            var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.page.intValue());
                        }

                        return var1;
                    }

                    public final Vr.VREvent.VrHome.Setup.View mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                        while(true) {
                            int var2;
                            switch(var2 = var1.readTag()) {
                                case 0:
                                    return this;
                                case 8:
                                    int var3;
                                    switch(var3 = var1.readInt32()) {
                                        case 0:
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 6:
                                        case 7:
                                        case 8:
                                            this.step = Integer.valueOf(var3);
                                        default:
                                            continue;
                                    }
                                case 16:
                                    this.page = Integer.valueOf(var1.readInt32());
                                    break;
                                default:
                                    if(!super.storeUnknownField(var1, var2)) {
                                        return this;
                                    }
                            }
                        }
                    }

                    public static Vr.VREvent.VrHome.Setup.View parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                        return (Vr.VREvent.VrHome.Setup.View)MessageNano.mergeFrom(new Vr.VREvent.VrHome.Setup.View(), var0);
                    }

                    public static Vr.VREvent.VrHome.Setup.View parseFrom(CodedInputByteBufferNano var0) throws IOException {
                        return (new Vr.VREvent.VrHome.Setup.View()).mergeFrom(var0);
                    }
                }

                public interface Step {
                    int UNKNOWN = 0;
                    int ACCOUNT_SELECTION = 1;
                    int GETTING_STARTED = 2;
                    int HEALTH_AND_SAFETY = 3;
                    int CHECKING_ACCOUNT_INFO = 4;
                    int PIN = 5;
                    int FOP = 6;
                    int DOWNLOADING_VR_COMPONENTS = 7;
                    int OVERALL = 8;
                }
            }
        }

        public static final class Photos extends ExtendableMessageNano<Vr.VREvent.Photos> implements Cloneable {
            private static volatile Vr.VREvent.Photos[] _emptyArray;
            public Integer numPhotos;
            public Vr.VREvent.Photos.OpenMedia openMedia;
            public Vr.VREvent.Photos.WarmWelcome warmWelcome;

            public static Vr.VREvent.Photos[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.Photos[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public Photos() {
                this.clear();
            }

            public final Vr.VREvent.Photos clear() {
                this.numPhotos = null;
                this.openMedia = null;
                this.warmWelcome = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.Photos clone() {
                Vr.VREvent.Photos var1;
                try {
                    var1 = (Vr.VREvent.Photos)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.openMedia != null) {
                    var1.openMedia = this.openMedia.clone();
                }

                if(this.warmWelcome != null) {
                    var1.warmWelcome = this.warmWelcome.clone();
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.numPhotos != null) {
                    var1.writeInt32(1, this.numPhotos.intValue());
                }

                if(this.openMedia != null) {
                    var1.writeMessage(2, this.openMedia);
                }

                if(this.warmWelcome != null) {
                    var1.writeMessage(3, this.warmWelcome);
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.numPhotos != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.numPhotos.intValue());
                }

                if(this.openMedia != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.openMedia);
                }

                if(this.warmWelcome != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(3, this.warmWelcome);
                }

                return var1;
            }

            public final Vr.VREvent.Photos mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 8:
                            this.numPhotos = Integer.valueOf(var1.readInt32());
                            break;
                        case 18:
                            if(this.openMedia == null) {
                                this.openMedia = new Vr.VREvent.Photos.OpenMedia();
                            }

                            var1.readMessage(this.openMedia);
                            break;
                        case 26:
                            if(this.warmWelcome == null) {
                                this.warmWelcome = new Vr.VREvent.Photos.WarmWelcome();
                            }

                            var1.readMessage(this.warmWelcome);
                            break;
                        default:
                            if(!super.storeUnknownField(var1, var2)) {
                                return this;
                            }
                    }
                }
            }

            public static Vr.VREvent.Photos parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.Photos)MessageNano.mergeFrom(new Vr.VREvent.Photos(), var0);
            }

            public static Vr.VREvent.Photos parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.Photos()).mergeFrom(var0);
            }

            public static final class WarmWelcome extends ExtendableMessageNano<Vr.VREvent.Photos.WarmWelcome> implements Cloneable {
                private static volatile Vr.VREvent.Photos.WarmWelcome[] _emptyArray;
                public Float exitProgress;

                public static Vr.VREvent.Photos.WarmWelcome[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.Photos.WarmWelcome[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public WarmWelcome() {
                    this.clear();
                }

                public final Vr.VREvent.Photos.WarmWelcome clear() {
                    this.exitProgress = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.Photos.WarmWelcome clone() {
                    try {
                        Vr.VREvent.Photos.WarmWelcome var1 = (Vr.VREvent.Photos.WarmWelcome)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.exitProgress != null) {
                        var1.writeFloat(1, this.exitProgress.floatValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.exitProgress != null) {
                        var1 += CodedOutputByteBufferNano.computeFloatSize(1, this.exitProgress.floatValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.Photos.WarmWelcome mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 13:
                                this.exitProgress = Float.valueOf(var1.readFloat());
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.Photos.WarmWelcome parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.Photos.WarmWelcome)MessageNano.mergeFrom(new Vr.VREvent.Photos.WarmWelcome(), var0);
                }

                public static Vr.VREvent.Photos.WarmWelcome parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.Photos.WarmWelcome()).mergeFrom(var0);
                }
            }

            public static final class OpenMedia extends ExtendableMessageNano<Vr.VREvent.Photos.OpenMedia> implements Cloneable {
                private static volatile Vr.VREvent.Photos.OpenMedia[] _emptyArray;
                public Integer type;
                public Integer source;
                public Boolean isSample;

                public static Vr.VREvent.Photos.OpenMedia[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.Photos.OpenMedia[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public OpenMedia() {
                    this.clear();
                }

                public final Vr.VREvent.Photos.OpenMedia clear() {
                    this.isSample = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.Photos.OpenMedia clone() {
                    try {
                        Vr.VREvent.Photos.OpenMedia var1 = (Vr.VREvent.Photos.OpenMedia)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.type != null) {
                        var1.writeInt32(1, this.type.intValue());
                    }

                    if(this.source != null) {
                        var1.writeInt32(2, this.source.intValue());
                    }

                    if(this.isSample != null) {
                        var1.writeBool(3, this.isSample.booleanValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.type != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.type.intValue());
                    }

                    if(this.source != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.source.intValue());
                    }

                    if(this.isSample != null) {
                        var1 += CodedOutputByteBufferNano.computeBoolSize(3, this.isSample.booleanValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.Photos.OpenMedia mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        int var3;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                        this.type = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 16:
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                        this.source = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 24:
                                this.isSample = Boolean.valueOf(var1.readBool());
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.Photos.OpenMedia parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.Photos.OpenMedia)MessageNano.mergeFrom(new Vr.VREvent.Photos.OpenMedia(), var0);
                }

                public static Vr.VREvent.Photos.OpenMedia parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.Photos.OpenMedia()).mergeFrom(var0);
                }

                public interface MediaSource {
                    int UNSPECIFIED = 0;
                    int GALLERY = 1;
                    int CAROUSEL = 2;
                    int INTENT = 3;
                }

                public interface MediaType {
                    int UNKNOWN = 0;
                    int PHOTO = 1;
                    int FLAT_PANORAMA = 2;
                    int PANORAMA = 3;
                    int VR = 4;
                }
            }
        }

        public static final class Cyclops extends ExtendableMessageNano<Vr.VREvent.Cyclops> implements Cloneable {
            private static volatile Vr.VREvent.Cyclops[] _emptyArray;
            public Vr.VREvent.Cyclops.Capture capture;
            public Vr.VREvent.Cyclops.View view;
            public Vr.VREvent.Cyclops.Share share;
            public Vr.VREvent.Cyclops.ShareStart shareStart;

            public static Vr.VREvent.Cyclops[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.Cyclops[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public Cyclops() {
                this.clear();
            }

            public final Vr.VREvent.Cyclops clear() {
                this.capture = null;
                this.view = null;
                this.share = null;
                this.shareStart = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.Cyclops clone() {
                Vr.VREvent.Cyclops var1;
                try {
                    var1 = (Vr.VREvent.Cyclops)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.capture != null) {
                    var1.capture = this.capture.clone();
                }

                if(this.view != null) {
                    var1.view = this.view.clone();
                }

                if(this.share != null) {
                    var1.share = this.share.clone();
                }

                if(this.shareStart != null) {
                    var1.shareStart = this.shareStart.clone();
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.capture != null) {
                    var1.writeMessage(1, this.capture);
                }

                if(this.view != null) {
                    var1.writeMessage(2, this.view);
                }

                if(this.share != null) {
                    var1.writeMessage(3, this.share);
                }

                if(this.shareStart != null) {
                    var1.writeMessage(4, this.shareStart);
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.capture != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(1, this.capture);
                }

                if(this.view != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.view);
                }

                if(this.share != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(3, this.share);
                }

                if(this.shareStart != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(4, this.shareStart);
                }

                return var1;
            }

            public final Vr.VREvent.Cyclops mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 10:
                            if(this.capture == null) {
                                this.capture = new Vr.VREvent.Cyclops.Capture();
                            }

                            var1.readMessage(this.capture);
                            break;
                        case 18:
                            if(this.view == null) {
                                this.view = new Vr.VREvent.Cyclops.View();
                            }

                            var1.readMessage(this.view);
                            break;
                        case 26:
                            if(this.share == null) {
                                this.share = new Vr.VREvent.Cyclops.Share();
                            }

                            var1.readMessage(this.share);
                            break;
                        case 34:
                            if(this.shareStart == null) {
                                this.shareStart = new Vr.VREvent.Cyclops.ShareStart();
                            }

                            var1.readMessage(this.shareStart);
                            break;
                        default:
                            if(!super.storeUnknownField(var1, var2)) {
                                return this;
                            }
                    }
                }
            }

            public static Vr.VREvent.Cyclops parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.Cyclops)MessageNano.mergeFrom(new Vr.VREvent.Cyclops(), var0);
            }

            public static Vr.VREvent.Cyclops parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.Cyclops()).mergeFrom(var0);
            }

            public static final class ShareStart extends ExtendableMessageNano<Vr.VREvent.Cyclops.ShareStart> implements Cloneable {
                private static volatile Vr.VREvent.Cyclops.ShareStart[] _emptyArray;
                public Integer originScreen;
                public Integer numPhotos;

                public static Vr.VREvent.Cyclops.ShareStart[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.Cyclops.ShareStart[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public ShareStart() {
                    this.clear();
                }

                public final Vr.VREvent.Cyclops.ShareStart clear() {
                    this.numPhotos = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.Cyclops.ShareStart clone() {
                    try {
                        Vr.VREvent.Cyclops.ShareStart var1 = (Vr.VREvent.Cyclops.ShareStart)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.originScreen != null) {
                        var1.writeInt32(1, this.originScreen.intValue());
                    }

                    if(this.numPhotos != null) {
                        var1.writeInt32(2, this.numPhotos.intValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.originScreen != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.originScreen.intValue());
                    }

                    if(this.numPhotos != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.numPhotos.intValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.Cyclops.ShareStart mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                int var3;
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                        this.originScreen = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 16:
                                this.numPhotos = Integer.valueOf(var1.readInt32());
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.Cyclops.ShareStart parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.Cyclops.ShareStart)MessageNano.mergeFrom(new Vr.VREvent.Cyclops.ShareStart(), var0);
                }

                public static Vr.VREvent.Cyclops.ShareStart parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.Cyclops.ShareStart()).mergeFrom(var0);
                }

                public interface OriginScreen {
                    int UNKNOWN = 0;
                    int GALLERY = 1;
                    int ONE_UP_VIEW = 2;
                }
            }

            public static final class Share extends ExtendableMessageNano<Vr.VREvent.Cyclops.Share> implements Cloneable {
                private static volatile Vr.VREvent.Cyclops.Share[] _emptyArray;
                public Integer type;
                public Boolean withSound;
                public Integer numPhotos;

                public static Vr.VREvent.Cyclops.Share[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.Cyclops.Share[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public Share() {
                    this.clear();
                }

                public final Vr.VREvent.Cyclops.Share clear() {
                    this.withSound = null;
                    this.numPhotos = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.Cyclops.Share clone() {
                    try {
                        Vr.VREvent.Cyclops.Share var1 = (Vr.VREvent.Cyclops.Share)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.type != null) {
                        var1.writeInt32(1, this.type.intValue());
                    }

                    if(this.withSound != null) {
                        var1.writeBool(2, this.withSound.booleanValue());
                    }

                    if(this.numPhotos != null) {
                        var1.writeInt32(3, this.numPhotos.intValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.type != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.type.intValue());
                    }

                    if(this.withSound != null) {
                        var1 += CodedOutputByteBufferNano.computeBoolSize(2, this.withSound.booleanValue());
                    }

                    if(this.numPhotos != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(3, this.numPhotos.intValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.Cyclops.Share mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                int var3;
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                        this.type = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 16:
                                this.withSound = Boolean.valueOf(var1.readBool());
                                break;
                            case 24:
                                this.numPhotos = Integer.valueOf(var1.readInt32());
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.Cyclops.Share parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.Cyclops.Share)MessageNano.mergeFrom(new Vr.VREvent.Cyclops.Share(), var0);
                }

                public static Vr.VREvent.Cyclops.Share parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.Cyclops.Share()).mergeFrom(var0);
                }

                public interface Type {
                    int UNKNOWN = 0;
                    int CANCELLED = 1;
                    int COPY_LINK = 2;
                    int SOCIAL_OTHER = 3;
                    int SOCIAL_FACEBOOK = 4;
                    int SOCIAL_TWITTER = 5;
                    int SOCIAL_GPLUS = 6;
                    int EMAIL = 7;
                }
            }

            public static final class View extends ExtendableMessageNano<Vr.VREvent.Cyclops.View> implements Cloneable {
                private static volatile Vr.VREvent.Cyclops.View[] _emptyArray;
                public Integer orientation;
                public Boolean interaction;
                public Boolean withSound;
                public Integer numPanos;

                public static Vr.VREvent.Cyclops.View[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.Cyclops.View[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public View() {
                    this.clear();
                }

                public final Vr.VREvent.Cyclops.View clear() {
                    this.interaction = null;
                    this.withSound = null;
                    this.numPanos = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.Cyclops.View clone() {
                    try {
                        Vr.VREvent.Cyclops.View var1 = (Vr.VREvent.Cyclops.View)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.orientation != null) {
                        var1.writeInt32(1, this.orientation.intValue());
                    }

                    if(this.interaction != null) {
                        var1.writeBool(2, this.interaction.booleanValue());
                    }

                    if(this.withSound != null) {
                        var1.writeBool(3, this.withSound.booleanValue());
                    }

                    if(this.numPanos != null) {
                        var1.writeInt32(4, this.numPanos.intValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.orientation != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.orientation.intValue());
                    }

                    if(this.interaction != null) {
                        var1 += CodedOutputByteBufferNano.computeBoolSize(2, this.interaction.booleanValue());
                    }

                    if(this.withSound != null) {
                        var1 += CodedOutputByteBufferNano.computeBoolSize(3, this.withSound.booleanValue());
                    }

                    if(this.numPanos != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(4, this.numPanos.intValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.Cyclops.View mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                int var3;
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                        this.orientation = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 16:
                                this.interaction = Boolean.valueOf(var1.readBool());
                                break;
                            case 24:
                                this.withSound = Boolean.valueOf(var1.readBool());
                                break;
                            case 32:
                                this.numPanos = Integer.valueOf(var1.readInt32());
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.Cyclops.View parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.Cyclops.View)MessageNano.mergeFrom(new Vr.VREvent.Cyclops.View(), var0);
                }

                public static Vr.VREvent.Cyclops.View parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.Cyclops.View()).mergeFrom(var0);
                }

                public interface Orientation {
                    int UNKNOWN = 0;
                    int LANDSCAPE = 1;
                    int PORTRAIT = 2;
                }
            }

            public static final class Capture extends ExtendableMessageNano<Vr.VREvent.Cyclops.Capture> implements Cloneable {
                private static volatile Vr.VREvent.Cyclops.Capture[] _emptyArray;
                public Integer outcome;
                public Float angleDegrees;
                public Boolean withSound;
                public Boolean captureWarnings;
                public Long compositionTimeMs;
                public Long captureTimeMs;
                public Long processingTimeMs;

                public static Vr.VREvent.Cyclops.Capture[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Vr.VREvent.Cyclops.Capture[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public Capture() {
                    this.clear();
                }

                public final Vr.VREvent.Cyclops.Capture clear() {
                    this.angleDegrees = null;
                    this.withSound = null;
                    this.captureWarnings = null;
                    this.compositionTimeMs = null;
                    this.captureTimeMs = null;
                    this.processingTimeMs = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                    return this;
                }

                public final Vr.VREvent.Cyclops.Capture clone() {
                    try {
                        Vr.VREvent.Cyclops.Capture var1 = (Vr.VREvent.Cyclops.Capture)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.outcome != null) {
                        var1.writeInt32(1, this.outcome.intValue());
                    }

                    if(this.angleDegrees != null) {
                        var1.writeFloat(2, this.angleDegrees.floatValue());
                    }

                    if(this.withSound != null) {
                        var1.writeBool(3, this.withSound.booleanValue());
                    }

                    if(this.captureWarnings != null) {
                        var1.writeBool(4, this.captureWarnings.booleanValue());
                    }

                    if(this.compositionTimeMs != null) {
                        var1.writeInt64(5, this.compositionTimeMs.longValue());
                    }

                    if(this.captureTimeMs != null) {
                        var1.writeInt64(6, this.captureTimeMs.longValue());
                    }

                    if(this.processingTimeMs != null) {
                        var1.writeInt64(7, this.processingTimeMs.longValue());
                    }

                    super.writeTo(var1);
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.outcome != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.outcome.intValue());
                    }

                    if(this.angleDegrees != null) {
                        var1 += CodedOutputByteBufferNano.computeFloatSize(2, this.angleDegrees.floatValue());
                    }

                    if(this.withSound != null) {
                        var1 += CodedOutputByteBufferNano.computeBoolSize(3, this.withSound.booleanValue());
                    }

                    if(this.captureWarnings != null) {
                        var1 += CodedOutputByteBufferNano.computeBoolSize(4, this.captureWarnings.booleanValue());
                    }

                    if(this.compositionTimeMs != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(5, this.compositionTimeMs.longValue());
                    }

                    if(this.captureTimeMs != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(6, this.captureTimeMs.longValue());
                    }

                    if(this.processingTimeMs != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(7, this.processingTimeMs.longValue());
                    }

                    return var1;
                }

                public final Vr.VREvent.Cyclops.Capture mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                    while(true) {
                        int var2;
                        switch(var2 = var1.readTag()) {
                            case 0:
                                return this;
                            case 8:
                                int var3;
                                switch(var3 = var1.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                        this.outcome = Integer.valueOf(var3);
                                    default:
                                        continue;
                                }
                            case 21:
                                this.angleDegrees = Float.valueOf(var1.readFloat());
                                break;
                            case 24:
                                this.withSound = Boolean.valueOf(var1.readBool());
                                break;
                            case 32:
                                this.captureWarnings = Boolean.valueOf(var1.readBool());
                                break;
                            case 40:
                                this.compositionTimeMs = Long.valueOf(var1.readInt64());
                                break;
                            case 48:
                                this.captureTimeMs = Long.valueOf(var1.readInt64());
                                break;
                            case 56:
                                this.processingTimeMs = Long.valueOf(var1.readInt64());
                                break;
                            default:
                                if(!super.storeUnknownField(var1, var2)) {
                                    return this;
                                }
                        }
                    }
                }

                public static Vr.VREvent.Cyclops.Capture parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                    return (Vr.VREvent.Cyclops.Capture)MessageNano.mergeFrom(new Vr.VREvent.Cyclops.Capture(), var0);
                }

                public static Vr.VREvent.Cyclops.Capture parseFrom(CodedInputByteBufferNano var0) throws IOException {
                    return (new Vr.VREvent.Cyclops.Capture()).mergeFrom(var0);
                }

                public interface Outcome {
                    int UNKNOWN = 0;
                    int SUCCESS = 1;
                    int FAILURE_CAPTURE = 2;
                    int FAILURE_PROCESSING = 3;
                    int USER_CANCELLED = 4;
                }
            }
        }

        public static final class DoublePrecisionTransform extends ExtendableMessageNano<Vr.VREvent.DoublePrecisionTransform> implements Cloneable {
            private static volatile Vr.VREvent.DoublePrecisionTransform[] _emptyArray;
            public Double translationX;
            public Double translationY;
            public Double translationZ;
            public Double rotationQx;
            public Double rotationQy;
            public Double rotationQz;
            public Double scale;

            public static Vr.VREvent.DoublePrecisionTransform[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.DoublePrecisionTransform[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public DoublePrecisionTransform() {
                this.clear();
            }

            public final Vr.VREvent.DoublePrecisionTransform clear() {
                this.translationX = null;
                this.translationY = null;
                this.translationZ = null;
                this.rotationQx = null;
                this.rotationQy = null;
                this.rotationQz = null;
                this.scale = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.DoublePrecisionTransform clone() {
                try {
                    Vr.VREvent.DoublePrecisionTransform var1 = (Vr.VREvent.DoublePrecisionTransform)super.clone();
                    return var1;
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.translationX != null) {
                    var1.writeDouble(1, this.translationX.doubleValue());
                }

                if(this.translationY != null) {
                    var1.writeDouble(2, this.translationY.doubleValue());
                }

                if(this.translationZ != null) {
                    var1.writeDouble(3, this.translationZ.doubleValue());
                }

                if(this.rotationQx != null) {
                    var1.writeDouble(4, this.rotationQx.doubleValue());
                }

                if(this.rotationQy != null) {
                    var1.writeDouble(5, this.rotationQy.doubleValue());
                }

                if(this.rotationQz != null) {
                    var1.writeDouble(6, this.rotationQz.doubleValue());
                }

                if(this.scale != null) {
                    var1.writeDouble(7, this.scale.doubleValue());
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.translationX != null) {
                    var1 += CodedOutputByteBufferNano.computeDoubleSize(1, this.translationX.doubleValue());
                }

                if(this.translationY != null) {
                    var1 += CodedOutputByteBufferNano.computeDoubleSize(2, this.translationY.doubleValue());
                }

                if(this.translationZ != null) {
                    var1 += CodedOutputByteBufferNano.computeDoubleSize(3, this.translationZ.doubleValue());
                }

                if(this.rotationQx != null) {
                    var1 += CodedOutputByteBufferNano.computeDoubleSize(4, this.rotationQx.doubleValue());
                }

                if(this.rotationQy != null) {
                    var1 += CodedOutputByteBufferNano.computeDoubleSize(5, this.rotationQy.doubleValue());
                }

                if(this.rotationQz != null) {
                    var1 += CodedOutputByteBufferNano.computeDoubleSize(6, this.rotationQz.doubleValue());
                }

                if(this.scale != null) {
                    var1 += CodedOutputByteBufferNano.computeDoubleSize(7, this.scale.doubleValue());
                }

                return var1;
            }

            public final Vr.VREvent.DoublePrecisionTransform mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 9:
                            this.translationX = Double.valueOf(var1.readDouble());
                            break;
                        case 17:
                            this.translationY = Double.valueOf(var1.readDouble());
                            break;
                        case 25:
                            this.translationZ = Double.valueOf(var1.readDouble());
                            break;
                        case 33:
                            this.rotationQx = Double.valueOf(var1.readDouble());
                            break;
                        case 41:
                            this.rotationQy = Double.valueOf(var1.readDouble());
                            break;
                        case 49:
                            this.rotationQz = Double.valueOf(var1.readDouble());
                            break;
                        case 57:
                            this.scale = Double.valueOf(var1.readDouble());
                            break;
                        default:
                            if(!super.storeUnknownField(var1, var2)) {
                                return this;
                            }
                    }
                }
            }

            public static Vr.VREvent.DoublePrecisionTransform parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.DoublePrecisionTransform)MessageNano.mergeFrom(new Vr.VREvent.DoublePrecisionTransform(), var0);
            }

            public static Vr.VREvent.DoublePrecisionTransform parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.DoublePrecisionTransform()).mergeFrom(var0);
            }
        }

        public static final class Transform extends ExtendableMessageNano<Vr.VREvent.Transform> implements Cloneable {
            private static volatile Vr.VREvent.Transform[] _emptyArray;
            public Float translationX;
            public Float translationY;
            public Float translationZ;
            public Float rotationQx;
            public Float rotationQy;
            public Float rotationQz;
            public Float scale;

            public static Vr.VREvent.Transform[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.Transform[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public Transform() {
                this.clear();
            }

            public final Vr.VREvent.Transform clear() {
                this.translationX = null;
                this.translationY = null;
                this.translationZ = null;
                this.rotationQx = null;
                this.rotationQy = null;
                this.rotationQz = null;
                this.scale = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.Transform clone() {
                try {
                    Vr.VREvent.Transform var1 = (Vr.VREvent.Transform)super.clone();
                    return var1;
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.translationX != null) {
                    var1.writeFloat(1, this.translationX.floatValue());
                }

                if(this.translationY != null) {
                    var1.writeFloat(2, this.translationY.floatValue());
                }

                if(this.translationZ != null) {
                    var1.writeFloat(3, this.translationZ.floatValue());
                }

                if(this.rotationQx != null) {
                    var1.writeFloat(4, this.rotationQx.floatValue());
                }

                if(this.rotationQy != null) {
                    var1.writeFloat(5, this.rotationQy.floatValue());
                }

                if(this.rotationQz != null) {
                    var1.writeFloat(6, this.rotationQz.floatValue());
                }

                if(this.scale != null) {
                    var1.writeFloat(7, this.scale.floatValue());
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.translationX != null) {
                    var1 += CodedOutputByteBufferNano.computeFloatSize(1, this.translationX.floatValue());
                }

                if(this.translationY != null) {
                    var1 += CodedOutputByteBufferNano.computeFloatSize(2, this.translationY.floatValue());
                }

                if(this.translationZ != null) {
                    var1 += CodedOutputByteBufferNano.computeFloatSize(3, this.translationZ.floatValue());
                }

                if(this.rotationQx != null) {
                    var1 += CodedOutputByteBufferNano.computeFloatSize(4, this.rotationQx.floatValue());
                }

                if(this.rotationQy != null) {
                    var1 += CodedOutputByteBufferNano.computeFloatSize(5, this.rotationQy.floatValue());
                }

                if(this.rotationQz != null) {
                    var1 += CodedOutputByteBufferNano.computeFloatSize(6, this.rotationQz.floatValue());
                }

                if(this.scale != null) {
                    var1 += CodedOutputByteBufferNano.computeFloatSize(7, this.scale.floatValue());
                }

                return var1;
            }

            public final Vr.VREvent.Transform mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 13:
                            this.translationX = Float.valueOf(var1.readFloat());
                            break;
                        case 21:
                            this.translationY = Float.valueOf(var1.readFloat());
                            break;
                        case 29:
                            this.translationZ = Float.valueOf(var1.readFloat());
                            break;
                        case 37:
                            this.rotationQx = Float.valueOf(var1.readFloat());
                            break;
                        case 45:
                            this.rotationQy = Float.valueOf(var1.readFloat());
                            break;
                        case 53:
                            this.rotationQz = Float.valueOf(var1.readFloat());
                            break;
                        case 61:
                            this.scale = Float.valueOf(var1.readFloat());
                            break;
                        default:
                            if(!super.storeUnknownField(var1, var2)) {
                                return this;
                            }
                    }
                }
            }

            public static Vr.VREvent.Transform parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.Transform)MessageNano.mergeFrom(new Vr.VREvent.Transform(), var0);
            }

            public static Vr.VREvent.Transform parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.Transform()).mergeFrom(var0);
            }
        }

        public static final class Renderer extends ExtendableMessageNano<Vr.VREvent.Renderer> implements Cloneable {
            private static volatile Vr.VREvent.Renderer[] _emptyArray;
            public String glVendor;
            public String glRenderer;
            public String glVersion;

            public static Vr.VREvent.Renderer[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.Renderer[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public Renderer() {
                this.clear();
            }

            public final Vr.VREvent.Renderer clear() {
                this.glVendor = null;
                this.glRenderer = null;
                this.glVersion = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.Renderer clone() {
                try {
                    Vr.VREvent.Renderer var1 = (Vr.VREvent.Renderer)super.clone();
                    return var1;
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.glVendor != null) {
                    var1.writeString(1, this.glVendor);
                }

                if(this.glRenderer != null) {
                    var1.writeString(2, this.glRenderer);
                }

                if(this.glVersion != null) {
                    var1.writeString(3, this.glVersion);
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.glVendor != null) {
                    var1 += CodedOutputByteBufferNano.computeStringSize(1, this.glVendor);
                }

                if(this.glRenderer != null) {
                    var1 += CodedOutputByteBufferNano.computeStringSize(2, this.glRenderer);
                }

                if(this.glVersion != null) {
                    var1 += CodedOutputByteBufferNano.computeStringSize(3, this.glVersion);
                }

                return var1;
            }

            public final Vr.VREvent.Renderer mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 10:
                            this.glVendor = var1.readString();
                            break;
                        case 18:
                            this.glRenderer = var1.readString();
                            break;
                        case 26:
                            this.glVersion = var1.readString();
                            break;
                        default:
                            if(!super.storeUnknownField(var1, var2)) {
                                return this;
                            }
                    }
                }
            }

            public static Vr.VREvent.Renderer parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.Renderer)MessageNano.mergeFrom(new Vr.VREvent.Renderer(), var0);
            }

            public static Vr.VREvent.Renderer parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.Renderer()).mergeFrom(var0);
            }
        }

        public static final class Application extends ExtendableMessageNano<Vr.VREvent.Application> implements Cloneable {
            private static volatile Vr.VREvent.Application[] _emptyArray;
            public String packageName;
            public String name;
            public String version;

            public static Vr.VREvent.Application[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.Application[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public Application() {
                this.clear();
            }

            public final Vr.VREvent.Application clear() {
                this.packageName = null;
                this.name = null;
                this.version = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.Application clone() {
                try {
                    Vr.VREvent.Application var1 = (Vr.VREvent.Application)super.clone();
                    return var1;
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.packageName != null) {
                    var1.writeString(1, this.packageName);
                }

                if(this.name != null) {
                    var1.writeString(2, this.name);
                }

                if(this.version != null) {
                    var1.writeString(3, this.version);
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.packageName != null) {
                    var1 += CodedOutputByteBufferNano.computeStringSize(1, this.packageName);
                }

                if(this.name != null) {
                    var1 += CodedOutputByteBufferNano.computeStringSize(2, this.name);
                }

                if(this.version != null) {
                    var1 += CodedOutputByteBufferNano.computeStringSize(3, this.version);
                }

                return var1;
            }

            public final Vr.VREvent.Application mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 10:
                            this.packageName = var1.readString();
                            break;
                        case 18:
                            this.name = var1.readString();
                            break;
                        case 26:
                            this.version = var1.readString();
                            break;
                        default:
                            if(!super.storeUnknownField(var1, var2)) {
                                return this;
                            }
                    }
                }
            }

            public static Vr.VREvent.Application parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.Application)MessageNano.mergeFrom(new Vr.VREvent.Application(), var0);
            }

            public static Vr.VREvent.Application parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.Application()).mergeFrom(var0);
            }
        }

        public static final class HeadMount extends ExtendableMessageNano<Vr.VREvent.HeadMount> implements Cloneable {
            private static volatile Vr.VREvent.HeadMount[] _emptyArray;
            public String vendor;
            public String model;

            public static Vr.VREvent.HeadMount[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vr.VREvent.HeadMount[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public HeadMount() {
                this.clear();
            }

            public final Vr.VREvent.HeadMount clear() {
                this.vendor = null;
                this.model = null;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public final Vr.VREvent.HeadMount clone() {
                try {
                    Vr.VREvent.HeadMount var1 = (Vr.VREvent.HeadMount)super.clone();
                    return var1;
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.vendor != null) {
                    var1.writeString(1, this.vendor);
                }

                if(this.model != null) {
                    var1.writeString(2, this.model);
                }

                super.writeTo(var1);
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.vendor != null) {
                    var1 += CodedOutputByteBufferNano.computeStringSize(1, this.vendor);
                }

                if(this.model != null) {
                    var1 += CodedOutputByteBufferNano.computeStringSize(2, this.model);
                }

                return var1;
            }

            public final Vr.VREvent.HeadMount mergeFrom(CodedInputByteBufferNano var1) throws IOException {
                while(true) {
                    int var2;
                    switch(var2 = var1.readTag()) {
                        case 0:
                            return this;
                        case 10:
                            this.vendor = var1.readString();
                            break;
                        case 18:
                            this.model = var1.readString();
                            break;
                        default:
                            if(!super.storeUnknownField(var1, var2)) {
                                return this;
                            }
                    }
                }
            }

            public static Vr.VREvent.HeadMount parseFrom(byte[] var0) throws InvalidProtocolBufferNanoException {
                return (Vr.VREvent.HeadMount)MessageNano.mergeFrom(new Vr.VREvent.HeadMount(), var0);
            }

            public static Vr.VREvent.HeadMount parseFrom(CodedInputByteBufferNano var0) throws IOException {
                return (new Vr.VREvent.HeadMount()).mergeFrom(var0);
            }
        }

        public interface EventType {
            int UNKNOWN_EVENT_TYPE = 0;
            int START_LAUNCHER = 1;
            int GET_INSTALLED_APPLICATIONS = 2;
            int START_APPLICATION = 3;
            int STOP_APPLICATION = 4;
            int GO_TO_STORE = 5;
            int SWITCH_HEAD_MOUNT = 6;
            int SETUP_WELCOME_NEXT = 11;
            int SETUP_WELCOME_GET_VIEWER = 12;
            int SETUP_WELCOME_SWITCH_VIEWER = 13;
            int SETUP_WELCOME_USE_VIEWER = 14;
            int SETUP_QR_CODE_SCAN_SKIP = 7;
            int SETUP_QR_CODE_SCAN = 8;
            int SETUP_QR_CODE_HELP = 15;
            int SETUP_PAIRED_NEXT = 16;
            int SETUP_HEAD_MOUNT_INSERTED = 17;
            int SETUP_HEAD_MOUNT_SWITCH = 18;
            int SETUP_VR_INTRO_START = 19;
            int SETUP_VR_INTRO_STOP = 20;
            int SETTINGS_QR_CODE_SCAN = 9;
            int SETTINGS_QR_CODE_SCAN_SKIP = 10;
            int SETTINGS_QR_CODE_HELP = 21;
            int MY_APPS_TAB = 22;
            int FEATURED_APPS_TAB = 23;
            int NAV_ITEM_SELECTED = 24;
            int CYCLOPS_APPLICATION = 1000;
            int CYCLOPS_SHARE = 1001;
            int CYCLOPS_RECEIVE = 1002;
            int CYCLOPS_DELETE = 1003;
            int CYCLOPS_VIEW = 1004;
            int CYCLOPS_VIEW_HMD = 1005;
            int CYCLOPS_CAPTURE = 1006;
            int CYCLOPS_GALLERY_CONTEXT_MENU = 1007;
            int CYCLOPS_GALLERY_TO_GALLERY_HMD = 1008;
            int CYCLOPS_GALLERY_TO_CAPTURE = 1009;
            int CYCLOPS_SETTINGS = 1010;
            int CYCLOPS_ACCOUNT_SWITCH = 1011;
            int CYCLOPS_FEEDBACK = 1012;
            int CYCLOPS_SHARE_START = 1013;
            int START_SDK_APPLICATION = 2000;
            int TRANSITION_HEAD_MOUNT_INSERTED = 2001;
            int TRANSITION_HEAD_MOUNT_SWITCH = 2002;
            int SDK_PERFORMANCE_REPORT = 2003;
            int SDK_SENSOR_REPORT = 2004;
            int START_VR_APPLICATION = 2005;
            int STOP_VR_APPLICATION = 2006;
            int SDK_SCANLINE_RACING_ENABLED = 2007;
            int SDK_SCANLINE_RACING_VSYNC_OVERSHOOT_FATAL = 2008;
            int SDK_SENSOR_STALL = 2009;
            int START_VR_LAUNCHER_COLD = 3000;
            int LAUNCHER_START_APPLICATION = 3001;
            int LAUNCHER_STOP_APPLICATION = 3002;
            int AUDIO_INITIALIZATION = 4000;
            int AUDIO_SHUTDOWN = 4001;
            int AUDIO_PERFORMANCE_REPORT = 4002;
            int LULLABY_MUTE = 5000;
            int LULLABY_UNMUTE = 5001;
            int LULLABY_IMPRESSION = 5002;
            int LULLABY_ACTION = 5003;
            int LULLABY_LOAD = 5004;
            int EMBEDVR_START_SESSION = 6000;
            int EMBEDVR_STOP_SESSION = 6001;
            int EMBEDVR_LOAD_SUCCESS = 6002;
            int EMBEDVR_LOAD_ERROR = 6003;
            int EMBEDVR_VIEW_CLICK = 6004;
            int EMBEDVR_VIDEO_PLAY = 6005;
            int EMBEDVR_VIDEO_PAUSE = 6006;
            int EMBEDVR_VIDEO_SEEK_TO = 6007;
            int EMBEDVR_PERFORMANCE_REPORT = 6008;
            int VRCORE_COMMON_ENABLE_VRMODE = 7000;
            int VRCORE_COMMON_DISABLE_VRMODE = 7001;
            int VRCORE_COMMON_CONTINUE_VRMODE = 7002;
            int VRCORE_COMMON_PERMISSION_GRANTED = 7203;
            int VRCORE_COMMON_PERMISSION_DENIED = 7204;
            int VRCORE_COMMON_ERROR = 7049;
            int VRCORE_CONTROLLER_CONNECTED = 7050;
            int VRCORE_CONTROLLER_ERROR = 7051;
            int VRCORE_CONTROLLER_OTA_ERROR = 7052;
            int VRCORE_CONTROLLER_OTA_STARTED = 7053;
            int VRCORE_CONTROLLER_OTA_SUCCESS = 7054;
            int VRCORE_CONTROLLER_OTA_SUCCESS_TRIVIAL = 7055;
            int VRCORE_CONTROLLER_OTA_DATA_TRANSFER_SUCCESS = 7056;
            int VRCORE_CONTROLLER_PAIRING_ERROR = 7057;
            int VRCORE_CONTROLLER_PAIRING_STARTED = 7058;
            int VRCORE_CONTROLLER_PAIRING_SUCCESS = 7059;
            int VRCORE_CONTROLLER_RECALIBRATED = 7060;
            int VRCORE_CONTROLLER_RECALIBRATION_ERROR = 7061;
            int VRCORE_CONTROLLER_SLEPT_END = 7062;
            int VRCORE_CONTROLLER_SLEPT_IDLE = 7063;
            int VRCORE_CONTROLLER_VOLUME_ADJUSTED = 7064;
            int VRCORE_CONTROLLER_EMULATOR_CONNECTED = 7065;
            int VRCORE_CONTROLLER_EMULATOR_ERROR = 7066;
            int VRCORE_CONTROLLER_RAIL_REPORT = 7067;
            int VRCORE_CONTROLLER_STUCK_NOTIFICATION_SHOWN = 7068;
            int VRCORE_CONTROLLER_STUCK_EXITED_VR = 7069;
            int VRCORE_CONTROLLER_STUCK_NOTIFICATION_TAPPED = 7070;
            int VRCORE_NFC_TRIGGER_INTENT = 7100;
            int VRCORE_NFC_ERROR = 7149;
            int VRCORE_NOTIFICATION_POSTED = 7150;
            int VRCORE_NOTIFICATION_REMOVED = 7151;
            int VRCORE_NOTIFICATION_ERROR = 7199;
            int VRCORE_SETTINGS_LAUNCHED = 7200;
            int VRCORE_SETTINGS_ENABLE_NOTIFICATION = 7201;
            int VRCORE_SETTINGS_DISABLE_NOTIFICATION = 7202;
            int VRCORE_SETTINGS_ERROR = 7249;
            int VRCORE_DAYDREAM_DON_STARTED = 7250;
            int VRCORE_DAYDREAM_DON_SUCCESS = 7251;
            int VRCORE_DAYDREAM_DON_ERROR = 7252;
            int VRCORE_DAYDREAM_SESSION_STARTED = 7253;
            int VRCORE_DAYDREAM_SESSION_ENDED = 7254;
            int VRCORE_DAYDREAM_HOME_LAUNCHED = 7255;
            int VRCORE_DAYDREAM_METAWORLD_STARTED = 7256;
            int VRCORE_DAYDREAM_METAWORLD_DISMISSED = 7257;
            int VRCORE_DAYDREAM_SYSTEM_UPDATE_ACCEPTED = 7258;
            int VRCORE_DAYDREAM_SYSTEM_UPDATE_DECLINED = 7259;
            int VRCORE_PERFORMANCE_REPORT = 7999;
            int EARTHVR_APP_STARTED = 8000;
            int EARTHVR_APP_STOPPED = 8001;
            int EARTHVR_APP_IDLE = 8002;
            int EARTHVR_APP_MODE_ENTERED = 8003;
            int EARTHVR_APP_MODE_EXITED = 8004;
            int EARTHVR_APP_PREFERENCES_CHANGED = 8005;
            int EARTHVR_APP_ENVIRONMENT_CHANGED = 8006;
            int EARTHVR_APP_INITIALIZED = 8007;
            int EARTHVR_NAVIGATION_ARCBALL_STARTED = 8100;
            int EARTHVR_NAVIGATION_ARCBALL_UPDATED = 8101;
            int EARTHVR_NAVIGATION_ARCBALL_STOPPED = 8102;
            int EARTHVR_NAVIGATION_FLYING_STARTED = 8103;
            int EARTHVR_NAVIGATION_FLYING_UPDATED = 8104;
            int EARTHVR_NAVIGATION_FLYING_STOPPED = 8105;
            int EARTHVR_NAVIGATION_SKY_TIME_TRAVELING_STARTED = 8106;
            int EARTHVR_NAVIGATION_SKY_TIME_TRAVELING_UPDATED = 8107;
            int EARTHVR_NAVIGATION_SKY_TIME_TRAVELING_STOPPED = 8108;
            int EARTHVR_NAVIGATION_ROTATING_STARTED = 8109;
            int EARTHVR_NAVIGATION_ROTATING_UPDATED = 8110;
            int EARTHVR_NAVIGATION_ROTATING_STOPPED = 8111;
            int EARTHVR_NAVIGATION_TRANSITION_STARTED = 8150;
            int EARTHVR_NAVIGATION_TRANSITION_STOPPED = 8151;
            int EARTHVR_RENDERING_TUNNEL_VISION_APPEARED = 8200;
            int EARTHVR_RENDERING_TUNNEL_VISION_DISAPPEARED = 8201;
            int EARTHVR_MENU_OPENED = 8300;
            int EARTHVR_MENU_CLOSED = 8301;
            int EARTHVR_MENU_PREFERENCES_OPENED = 8302;
            int EARTHVR_MENU_PREFERENCES_CLOSED = 8303;
            int EARTHVR_MENU_CATEGORY_SELECTED = 8304;
            int EARTHVR_MENU_PAGE_CHANGED = 8305;
            int EARTHVR_MENU_CARD_CLICKED = 8306;
            int EARTHVR_MENU_PLACE_DELETION_REQUESTED = 8307;
            int EARTHVR_DESKTOP_WINDOW_MENU_ITEM_SELECTED = 8308;
            int EARTHVR_TOUR_PAUSED = 8400;
            int EARTHVR_TOUR_RESUMED = 8401;
            int EARTHVR_TOUR_COMPLETED = 8402;
            int EARTHVR_TUTORIAL_STAGE_CHANGED = 8403;
            int EARTHVR_TOUR_STARTED = 8404;
            int EARTHVR_SPLASH_SCREEN_EXITED = 8405;
            int EARTHVR_PLACE_SAVED = 8500;
            int EARTHVR_REVEAL_QUERY_STARTED = 8501;
            int EARTHVR_REVEAL_QUERY_RESULT_READY = 8502;
            int EARTHVR_MINIGLOBE_BECAME_LARGE = 8503;
            int EARTHVR_MINIGLOBE_BECAME_SMALL = 8504;
            int EARTHVR_MINIGLOBE_ROTATED = 8505;
            int EARTHVR_MINIGLOBE_TELEPORT_TRIGGERED = 8506;
            int KEYBOARD_EVENT = 9000;
            int STREET_VIEW_COLLECTION = 10000;
            int STREET_VIEW_PANO_IN_COLLECTION = 10001;
            int STREET_VIEW_PANO_IN_SEARCH_RESULTS = 10002;
            int STREET_VIEW_NO_KEYBOARD = 10003;
            int STREET_VIEW_SEARCH_START = 10004;
            int STREET_VIEW_SEARCH_RESULTS = 10005;
            int STREET_VIEW_SEARCH_NO_RESULTS = 10006;
            int STREET_VIEW_SEARCH_DISMISS = 10007;
            int STREET_VIEW_SEARCH_EDIT = 10008;
            int STREET_VIEW_PANO_NAV_SESSION = 10009;
            int STREET_VIEW_APP_BUTTON = 10010;
            int STREET_VIEW_SEARCH_NO_PANOS = 10011;
            int PHOTOS_APPLICATION = 11000;
            int PHOTOS_GALLERY_NEXT = 11010;
            int PHOTOS_GALLERY_PREV = 11011;
            int PHOTOS_ACCOUNT_CHANGE = 11020;
            int PHOTOS_ACCOUNT_INVALID = 11021;
            int PHOTOS_OPEN_MEDIA = 11030;
            int PHOTOS_CAROUSEL_NEXT = 11031;
            int PHOTOS_CAROUSEL_PREV = 11032;
            int PHOTOS_CC_CARD_SHOWN = 11040;
            int PHOTOS_CC_CARD_DISMISS = 11041;
            int PHOTOS_CC_CARD_SUCCESS = 11042;
            int PHOTOS_BACKUP_CARD_SHOWN = 11050;
            int PHOTOS_BACKUP_CARD_DISMISS = 11051;
            int PHOTOS_BACKUP_CARD_SUCCESS = 11052;
            int PHOTOS_SIGN_CARD_SHOWN = 11060;
            int PHOTOS_WARM_WELCOME_SHOWN = 11061;
            int VRHOME_SETUP_STEP_START = 12000;
            int VRHOME_SETUP_STEP_END = 12001;
            int VRHOME_SETUP_STEP_STATE_CHANGE = 12002;
        }

        public interface Bucket {
            int UNKNOWN_BUCKET = 0;
            int ONE = 1;
            int TWO = 2;
            int THREE = 3;
            int FOUR = 4;
            int FIVE = 5;
            int SIX_TO_TEN = 6;
            int ELEVEN_TO_TWENTY = 11;
            int TWENTYONE_PLUS = 21;
        }
    }
}
