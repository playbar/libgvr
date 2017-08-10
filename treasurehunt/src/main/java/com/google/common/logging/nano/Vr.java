package com.google.common.logging.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import logs.proto.wireless.performance.mobile.nano.MemoryMetric.AndroidMemoryStats;

import java.io.IOException;

/**
 * Created by houguoli on 2017/8/10.
 */

public class Vr {

    public final static class VREvent extends ExtendableMessageNano<VREvent> implements Cloneable
    {
        public static class Application extends ExtendableMessageNano<Application> implements Cloneable {
            private volatile static Application[] _emptyArray = null;
            private String packageName = null;
            private String name = null;
            private String version = null;

            public static Application[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Application[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public Application() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final Application clone() {
                try {
                    Application var1 = (Application)super.clone();
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

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
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
        }
        /////////////////////////////////////

        public final class AudioStats extends ExtendableMessageNano<AudioStats> implements Cloneable {
            private Integer renderingMode = null;
            private Integer sampleRate = null;
            private Integer framesPerBuffer = null;
            private HistogramBucket[] renderingTimePerBufferMilliseconds = HistogramBucket.emptyArray();
            private HistogramBucket[] numberOfSimultaneousSoundObjects = HistogramBucket.emptyArray();
            private HistogramBucket[] numberOfSimultaneousSoundFields = HistogramBucket.emptyArray();
            private HistogramBucket[] cpuMeasurementsPercent = HistogramBucket.emptyArray();

            public AudioStats() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final AudioStats clone() {
                AudioStats var1;
                try {
                    var1 = (AudioStats)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                int var2;
                if(this.renderingTimePerBufferMilliseconds != null && this.renderingTimePerBufferMilliseconds.length > 0) {
                    var1.renderingTimePerBufferMilliseconds = new HistogramBucket[this.renderingTimePerBufferMilliseconds.length];

                    for(var2 = 0; var2 < this.renderingTimePerBufferMilliseconds.length; ++var2) {
                        if(this.renderingTimePerBufferMilliseconds[var2] != null) {
                            var1.renderingTimePerBufferMilliseconds[var2] = this.renderingTimePerBufferMilliseconds[var2].clone();
                        }
                    }
                }

                if(this.numberOfSimultaneousSoundObjects != null && this.numberOfSimultaneousSoundObjects.length > 0) {
                    var1.numberOfSimultaneousSoundObjects = new HistogramBucket[this.numberOfSimultaneousSoundObjects.length];

                    for(var2 = 0; var2 < this.numberOfSimultaneousSoundObjects.length; ++var2) {
                        if(this.numberOfSimultaneousSoundObjects[var2] != null) {
                            var1.numberOfSimultaneousSoundObjects[var2] = this.numberOfSimultaneousSoundObjects[var2].clone();
                        }
                    }
                }

                if(this.numberOfSimultaneousSoundFields != null && this.numberOfSimultaneousSoundFields.length > 0) {
                    var1.numberOfSimultaneousSoundFields = new HistogramBucket[this.numberOfSimultaneousSoundFields.length];

                    for(var2 = 0; var2 < this.numberOfSimultaneousSoundFields.length; ++var2) {
                        if(this.numberOfSimultaneousSoundFields[var2] != null) {
                            var1.numberOfSimultaneousSoundFields[var2] = this.numberOfSimultaneousSoundFields[var2].clone();
                        }
                    }
                }

                if(this.cpuMeasurementsPercent != null && this.cpuMeasurementsPercent.length > 0) {
                    var1.cpuMeasurementsPercent = new HistogramBucket[this.cpuMeasurementsPercent.length];

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
                HistogramBucket var3;
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

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
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
                HistogramBucket var3;
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
        }

////////////////////////////////

        public final static class HistogramBucket extends ExtendableMessageNano<HistogramBucket> implements Cloneable {
            private static volatile HistogramBucket[] _emptyArray;
            private Integer minimumValue = null;
            private Integer count = null;

            public static HistogramBucket[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new HistogramBucket[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public HistogramBucket() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final HistogramBucket clone() {
                try {
                    HistogramBucket var1 = (HistogramBucket)super.clone();
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

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
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
        }
///////////////////////////

        public final class HeadMount extends ExtendableMessageNano<HeadMount> implements Cloneable {
            private String vendor = null;
            private String model = null;

            public HeadMount() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final HeadMount clone() {
                try {
                    HeadMount var1 = (HeadMount)super.clone();
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

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
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
        }
////////////////////

        public final class Cyclops extends ExtendableMessageNano<Cyclops> implements Cloneable
        {

            public final class Capture extends ExtendableMessageNano<Capture> implements Cloneable {
                private Integer outcome = null;
                private Float angleDegrees = null;
                private Boolean withSound = null;
                private Boolean captureWarnings = null;
                private Long compositionTimeMs = null;
                private Long captureTimeMs = null;
                private Long processingTimeMs = null;

                public Capture() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final Capture clone() {
                    try {
                        Capture var1 = (Capture)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }
            /////////////////////////

            public final class View extends ExtendableMessageNano<View> implements Cloneable {
                private Integer orientation = null;
                private Boolean interaction = null;
                private Boolean withSound = null;
                private Integer numPanos = null;

                public View() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final View clone() {
                    try {
                        View var1 = (View)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }
            /////////////////////////////////
            public final class Share extends ExtendableMessageNano<Share> implements Cloneable {
                private Integer type = null;
                private Boolean withSound = null;
                private Integer numPhotos = null;

                public Share() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final Share clone() {
                    try {
                        Share var1 = (Share)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }
            //////////////////////////////////

            public final class ShareStart extends ExtendableMessageNano<ShareStart> implements Cloneable {
                private Integer originScreen = null;
                private Integer numPhotos = null;

                public ShareStart() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final ShareStart clone() {
                    try {
                        ShareStart var1 = (ShareStart)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }

            private Capture capture = null;
            private View view = null;
            private Share share = null;
            private ShareStart shareStart = null;

            public Cyclops() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final Cyclops clone() {
                Cyclops var1;
                try {
                    var1 = (Cyclops)super.clone();
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

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
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
        }
//////////////////////////////////

        public final class QrCodeScan extends ExtendableMessageNano<QrCodeScan> implements Cloneable {
            private Integer status = null;
            private String headMountConfigUrl = null;

            public QrCodeScan() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final QrCodeScan clone() {
                try {
                    QrCodeScan var1 = (QrCodeScan)super.clone();
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

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
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
        }
        //////////////////////////

        public final class PerformanceStats extends ExtendableMessageNano<PerformanceStats> implements Cloneable {
            private Integer averageFps = null;
            private HistogramBucket[] frameTime = HistogramBucket.emptyArray();
            private Integer memoryConsumptionKilobytes = null;
            private Float throttleSkinTemperatureCelsius = null;
            private Float vrMaxSkinTemperatureCelsius = null;
            private Float shutdownSkinTemperatureCelsius = null;
            private TimeSeriesData timeSeriesData = null;
            private HistogramBucket[] appRenderTime = HistogramBucket.emptyArray();
            private HistogramBucket[] presentTime = HistogramBucket.emptyArray();
            private HistogramBucket[] totalRenderTime = HistogramBucket.emptyArray();
            private HistogramBucket[] postFrameTime = HistogramBucket.emptyArray();
            private HistogramBucket[] consecutiveDroppedFrames = HistogramBucket.emptyArray();
            private HistogramBucket[] scanlineRacingVsyncOvershootUs = HistogramBucket.emptyArray();
            private Integer thermalEventFlags = null;
            private float[] cpuThrottlingTemperature;
            private float[] gpuThrottlingTemperature;
            private float[] batteryThrottlingTemperature;
            private float[] cpuShutdownTemperature;
            private float[] gpuShutdownTemperature;
            private float[] batteryShutdownTemperature;

            public PerformanceStats() {
                this.cpuThrottlingTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.gpuThrottlingTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.batteryThrottlingTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.cpuShutdownTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.gpuShutdownTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.batteryShutdownTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final PerformanceStats clone() {
                PerformanceStats var1;
                try {
                    var1 = (PerformanceStats)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                int var2;
                if(this.frameTime != null && this.frameTime.length > 0) {
                    var1.frameTime = new HistogramBucket[this.frameTime.length];

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
                    var1.appRenderTime = new HistogramBucket[this.appRenderTime.length];

                    for(var2 = 0; var2 < this.appRenderTime.length; ++var2) {
                        if(this.appRenderTime[var2] != null) {
                            var1.appRenderTime[var2] = this.appRenderTime[var2].clone();
                        }
                    }
                }

                if(this.presentTime != null && this.presentTime.length > 0) {
                    var1.presentTime = new HistogramBucket[this.presentTime.length];

                    for(var2 = 0; var2 < this.presentTime.length; ++var2) {
                        if(this.presentTime[var2] != null) {
                            var1.presentTime[var2] = this.presentTime[var2].clone();
                        }
                    }
                }

                if(this.totalRenderTime != null && this.totalRenderTime.length > 0) {
                    var1.totalRenderTime = new HistogramBucket[this.totalRenderTime.length];

                    for(var2 = 0; var2 < this.totalRenderTime.length; ++var2) {
                        if(this.totalRenderTime[var2] != null) {
                            var1.totalRenderTime[var2] = this.totalRenderTime[var2].clone();
                        }
                    }
                }

                if(this.postFrameTime != null && this.postFrameTime.length > 0) {
                    var1.postFrameTime = new HistogramBucket[this.postFrameTime.length];

                    for(var2 = 0; var2 < this.postFrameTime.length; ++var2) {
                        if(this.postFrameTime[var2] != null) {
                            var1.postFrameTime[var2] = this.postFrameTime[var2].clone();
                        }
                    }
                }

                if(this.consecutiveDroppedFrames != null && this.consecutiveDroppedFrames.length > 0) {
                    var1.consecutiveDroppedFrames = new HistogramBucket[this.consecutiveDroppedFrames.length];

                    for(var2 = 0; var2 < this.consecutiveDroppedFrames.length; ++var2) {
                        if(this.consecutiveDroppedFrames[var2] != null) {
                            var1.consecutiveDroppedFrames[var2] = this.consecutiveDroppedFrames[var2].clone();
                        }
                    }
                }

                if(this.scanlineRacingVsyncOvershootUs != null && this.scanlineRacingVsyncOvershootUs.length > 0) {
                    var1.scanlineRacingVsyncOvershootUs = new HistogramBucket[this.scanlineRacingVsyncOvershootUs.length];

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
                HistogramBucket var3;
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

                if(this.thermalEventFlags != null) {
                    var1.writeInt32(14, this.thermalEventFlags.intValue());
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

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.averageFps != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.averageFps.intValue());
                }

                int var2;
                HistogramBucket var3;
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

                if(this.thermalEventFlags != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(14, this.thermalEventFlags.intValue());
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
        }
        /////////////////////

        public final class SensorStats extends ExtendableMessageNano<SensorStats> implements Cloneable {

            public final class GyroscopeStats extends ExtendableMessageNano<GyroscopeStats> implements Cloneable {
                private Vector3 bias = null;
                private Vector3 lowerBound = null;
                private Vector3 upperBound = null;
                private Vector3 standardDeviation = null;

                public GyroscopeStats() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final GyroscopeStats clone() {
                    GyroscopeStats var1;
                    try {
                        var1 = (GyroscopeStats)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }


            public final class Vector3 extends ExtendableMessageNano<Vector3> implements Cloneable {
                private Float x = null;
                private Float y = null;
                private Float z = null;

                public Vector3() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final Vector3 clone() {
                    try {
                        Vector3 var1 = (Vector3)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }



            private GyroscopeStats gyroscopeStats = null;

            public SensorStats() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final SensorStats clone() {
                SensorStats var1;
                try {
                    var1 = (SensorStats)super.clone();
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

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.gyroscopeStats != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(1, this.gyroscopeStats);
                }

                return var1;
            }
        }

        ////////////////////////

        public final class EmbedVrWidget extends ExtendableMessageNano<EmbedVrWidget> implements Cloneable
        {

            public final class Pano extends ExtendableMessageNano<Pano> implements Cloneable {
                private Integer widthPixels = null;
                private Integer heightPixels = null;
                private Integer stereoFormat = null;

                public Pano() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final Pano clone() {
                    try {
                        Pano var1 = (Pano)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }


            public final class Video extends ExtendableMessageNano<Video> implements Cloneable {
                private Integer widthPixels = null;
                private Integer heightPixels = null;
                private Integer stereoFormat = null;
                private Integer videoDurationMs = null;

                public Video() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final Video clone() {
                    try {
                        Video var1 = (Video)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }


            private Integer viewMode = null;
            private Pano pano = null;
            private Video video = null;
            private String errorMsg = null;

            public EmbedVrWidget() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final EmbedVrWidget clone() {
                EmbedVrWidget var1;
                try {
                    var1 = (EmbedVrWidget)super.clone();
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

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
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
        }
        ///////////////////////////

        public final class VrCore extends ExtendableMessageNano<VrCore> implements Cloneable
        {

            public final class Controller extends ExtendableMessageNano<Controller> implements Cloneable {
                private String manufacturer = null;
                private String model = null;
                private String firmware = null;
                private String availableFirmware = null;
                private String softwareRevision = null;
                private Integer batteryLevel = null;
                private String hardwareRevision = null;
                private Integer xRailCount = null;
                private Integer yRailCount = null;
                private Integer zRailCount = null;
                private Integer sampleCount = null;
                private Integer sensorType = null;
                private Integer axis = null;
                private Integer otaRetries = null;
                private Integer totalControllerLagCount = null;

                public Controller() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final Controller clone() {
                    try {
                        Controller var1 = (Controller)super.clone();
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

                    if(this.otaRetries != null) {
                        var1.writeInt32(14, this.otaRetries.intValue());
                    }

                    if(this.totalControllerLagCount != null) {
                        var1.writeInt32(15, this.totalControllerLagCount.intValue());
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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

                    if(this.otaRetries != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(14, this.otaRetries.intValue());
                    }

                    if(this.totalControllerLagCount != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(15, this.totalControllerLagCount.intValue());
                    }

                    return var1;
                }
            }
//////////////////////////////

            public final class DashboardEvent extends ExtendableMessageNano<DashboardEvent> implements Cloneable
            {

                public final class DashboardDismissDetails extends ExtendableMessageNano<DashboardDismissDetails> implements Cloneable {
                    private Integer dismissReason = null;
                    private Boolean worldAppDied = null;

                    public DashboardDismissDetails() {
                        this.unknownFieldData = null;
                        this.cachedSize = -1;
                    }

                    public final DashboardDismissDetails clone() {
                        try {
                            DashboardDismissDetails var1 = (DashboardDismissDetails)super.clone();
                            return var1;
                        } catch (CloneNotSupportedException var3) {
                            throw new AssertionError(var3);
                        }
                    }

                    public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                        if(this.dismissReason != null) {
                            var1.writeInt32(1, this.dismissReason.intValue());
                        }

                        if(this.worldAppDied != null) {
                            var1.writeBool(2, this.worldAppDied.booleanValue());
                        }

                        super.writeTo(var1);
                    }

                    @Override
                    public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                        return null;
                    }

                    protected final int computeSerializedSize() {
                        int var1 = super.computeSerializedSize();
                        if(this.dismissReason != null) {
                            var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.dismissReason.intValue());
                        }

                        if(this.worldAppDied != null) {
                            var1 += CodedOutputByteBufferNano.computeBoolSize(2, this.worldAppDied.booleanValue());
                        }

                        return var1;
                    }
                }

                private Integer eventType = null;
                private Long clientTimestamp = null;
                private String sessionId = null;
                private Application worldApp = null;
                private AndroidMemoryStats worldAppMemoryStats = null;
                private DashboardDismissDetails dismissDetails = null;

                public DashboardEvent() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final DashboardEvent clone() {
                    DashboardEvent var1;
                    try {
                        var1 = (DashboardEvent)super.clone();
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }

                    if(this.worldApp != null) {
                        var1.worldApp = this.worldApp.clone();
                    }

                    if(this.worldAppMemoryStats != null) {
                        var1.worldAppMemoryStats = this.worldAppMemoryStats.clone();
                    }

                    if(this.dismissDetails != null) {
                        var1.dismissDetails = this.dismissDetails.clone();
                    }

                    return var1;
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.eventType != null) {
                        var1.writeInt32(1, this.eventType.intValue());
                    }

                    if(this.clientTimestamp != null) {
                        var1.writeInt64(2, this.clientTimestamp.longValue());
                    }

                    if(this.sessionId != null) {
                        var1.writeString(3, this.sessionId);
                    }

                    if(this.worldApp != null) {
                        var1.writeMessage(4, this.worldApp);
                    }

                    if(this.worldAppMemoryStats != null) {
                        var1.writeMessage(5, this.worldAppMemoryStats);
                    }

                    if(this.dismissDetails != null) {
                        var1.writeMessage(6, this.dismissDetails);
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.eventType != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.eventType.intValue());
                    }

                    if(this.clientTimestamp != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(2, this.clientTimestamp.longValue());
                    }

                    if(this.sessionId != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(3, this.sessionId);
                    }

                    if(this.worldApp != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(4, this.worldApp);
                    }

                    if(this.worldAppMemoryStats != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(5, this.worldAppMemoryStats);
                    }

                    if(this.dismissDetails != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(6, this.dismissDetails);
                    }

                    return var1;
                }
            }


            private Integer errorCode = null;
            private Integer permission = null;
            private Application foregroundApplication = null;
            private Integer clientApiVersion = null;
            private Application previousForegroundApplication = null;
            private Controller controller = null;
            private DashboardEvent dashboardEvent = null;

            public VrCore() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final VrCore clone() {
                VrCore var1;
                try {
                    var1 = (VrCore)super.clone();
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

                if(this.dashboardEvent != null) {
                    var1.dashboardEvent = this.dashboardEvent.clone();
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

                if(this.dashboardEvent != null) {
                    var1.writeMessage(7, this.dashboardEvent);
                }

                super.writeTo(var1);
            }

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
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

                if(this.dashboardEvent != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(7, this.dashboardEvent);
                }

                return var1;
            }
        }
        ////////////////////

        public final class DoublePrecisionTransform extends ExtendableMessageNano<DoublePrecisionTransform> implements Cloneable {
            private Double translationX = null;
            private Double translationY = null;
            private Double translationZ = null;
            private Double rotationQx = null;
            private Double rotationQy = null;
            private Double rotationQz = null;
            private Double scale = null;

            public DoublePrecisionTransform() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final DoublePrecisionTransform clone() {
                try {
                    DoublePrecisionTransform var1 = (DoublePrecisionTransform)super.clone();
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

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
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
        }
        ////////////////////////////////////

        public final static class TimeSeriesData extends ExtendableMessageNano<TimeSeriesData> implements Cloneable
        {

            public final static class TimeIntervalData extends ExtendableMessageNano<TimeIntervalData> implements Cloneable {
                private static volatile TimeIntervalData[] _emptyArray;
                private Integer intervalStartTimeSeconds = null;
                private Float skinTemperature = null;
                private Integer edsThreadFrameDropCount = null;
                private Integer batteryLevel = null;
                private Integer batteryLevelDelta = null;
                private Integer thermalWarningsShown = null;
                private float[] cpuTemperature;
                private float[] gpuTemperature;
                private float[] batteryTemperature;

                public static TimeIntervalData[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new TimeIntervalData[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public TimeIntervalData() {
                    this.cpuTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                    this.gpuTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                    this.batteryTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final TimeIntervalData clone() {
                    TimeIntervalData var1;
                    try {
                        var1 = (TimeIntervalData)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }

            private Integer timeIntervalSeconds = null;
            private TimeIntervalData[] timeIntervalData = TimeIntervalData.emptyArray();

            public TimeSeriesData() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final TimeSeriesData clone() {
                TimeSeriesData var1;
                try {
                    var1 = (TimeSeriesData)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.timeIntervalData != null && this.timeIntervalData.length > 0) {
                    var1.timeIntervalData = new TimeIntervalData[this.timeIntervalData.length];

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
                        TimeIntervalData var3;
                        if((var3 = this.timeIntervalData[var2]) != null) {
                            var1.writeMessage(2, var3);
                        }
                    }
                }

                super.writeTo(var1);
            }

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.timeIntervalSeconds != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.timeIntervalSeconds.intValue());
                }

                if(this.timeIntervalData != null && this.timeIntervalData.length > 0) {
                    for(int var2 = 0; var2 < this.timeIntervalData.length; ++var2) {
                        TimeIntervalData var3;
                        if((var3 = this.timeIntervalData[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(2, var3);
                        }
                    }
                }

                return var1;
            }
        }
//////////////////////

        public final class Transform extends ExtendableMessageNano<Transform> implements Cloneable {
            private Float translationX = null;
            private Float translationY = null;
            private Float translationZ = null;
            private Float rotationQx = null;
            private Float rotationQy = null;
            private Float rotationQz = null;
            private Float scale = null;

            public Transform() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final Transform clone() {
                try {
                    Transform var1 = (Transform)super.clone();
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

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
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
        }


        /////////////////////////////////////

        public final static class EarthVr extends ExtendableMessageNano<EarthVr> implements Cloneable
        {

            public final static class ControllerState extends ExtendableMessageNano<ControllerState> implements Cloneable {
                private static volatile ControllerState[] _emptyArray;
                private Integer role = null;
                private Transform startFromControllerTransform = null;

                public static ControllerState[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new ControllerState[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public ControllerState() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final ControllerState clone() {
                    ControllerState var1;
                    try {
                        var1 = (ControllerState)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }
            ///////////////////////////

            public final class AppState extends ExtendableMessageNano<AppState> implements Cloneable {
                private Long appModeId = null;

                public AppState() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final AppState clone() {
                    try {
                        AppState var1 = (AppState)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.appModeId != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(1, this.appModeId.longValue());
                    }

                    return var1;
                }
            }
            ///////////////////////

            public final class View extends ExtendableMessageNano<View> implements Cloneable {
                private Integer mode = null;
                private DoublePrecisionTransform startFromKeyholeTransform = null;
                private Long simulationSecondsSinceEpoch = null;

                public View() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final View clone() {
                    View var1;
                    try {
                        var1 = (View)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }
            //////////////////////////////

            public final class Menu extends ExtendableMessageNano<Menu> implements Cloneable {
                private String categoryName = null;
                private Integer pageIndex = null;
                private String contentKey = null;
                private String contentName = null;

                public Menu() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final Menu clone() {
                    try {
                        Menu var1 = (Menu)super.clone();
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

                    if(this.contentName != null) {
                        var1.writeString(4, this.contentName);
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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

                    if(this.contentName != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(4, this.contentName);
                    }

                    return var1;
                }
            }

            /////////////////////////////

            public final class Preferences extends ExtendableMessageNano<Preferences> implements Cloneable {
                private Integer labelsState = null;
                private Integer comfortModeState = null;
                private Integer startConfiguration = null;
                private Integer guestMode = null;
                private Integer humanScaleMode = null;

                public Preferences() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final Preferences clone() {
                    try {
                        Preferences var1 = (Preferences)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }


            public final class Tour extends ExtendableMessageNano<Tour> implements Cloneable {
                private String name = null;
                private Long playbackMs = null;

                public Tour() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final Tour clone() {
                    try {
                        Tour var1 = (Tour)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }
            /////////////////

            public final class Tutorial extends ExtendableMessageNano<Tutorial> implements Cloneable {
                private Integer stage = null;
                private String stageName = null;

                public Tutorial() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final Tutorial clone() {
                    try {
                        Tutorial var1 = (Tutorial)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }
            ///////////////////

            public final static class Actor extends ExtendableMessageNano<Actor> implements Cloneable
            {

                public final static class ControllerState extends ExtendableMessageNano<ControllerState> implements Cloneable {
                    private static volatile ControllerState[] _emptyArray;
                    private Integer role = null;
                    private Transform startFromControllerTransform = null;
                    private Integer type = null;

                    public static ControllerState[] emptyArray() {
                        if(_emptyArray == null) {
                            Object var0 = InternalNano.LAZY_INIT_LOCK;
                            synchronized(InternalNano.LAZY_INIT_LOCK) {
                                if(_emptyArray == null) {
                                    _emptyArray = new ControllerState[0];
                                }
                            }
                        }

                        return _emptyArray;
                    }

                    public ControllerState() {
                        this.unknownFieldData = null;
                        this.cachedSize = -1;
                    }

                    public final ControllerState clone() {
                        ControllerState var1;
                        try {
                            var1 = (ControllerState)super.clone();
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

                        if(this.type != null) {
                            var1.writeInt32(3, this.type.intValue());
                        }

                        super.writeTo(var1);
                    }

                    @Override
                    public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                        return null;
                    }

                    protected final int computeSerializedSize() {
                        int var1 = super.computeSerializedSize();
                        if(this.role != null) {
                            var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.role.intValue());
                        }

                        if(this.startFromControllerTransform != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.startFromControllerTransform);
                        }

                        if(this.type != null) {
                            var1 += CodedOutputByteBufferNano.computeInt32Size(3, this.type.intValue());
                        }

                        return var1;
                    }
                }

                private static volatile Actor[] _emptyArray;
                private Transform startFromHeadTransform = null;
                private ControllerState[] controllerStates = ControllerState.emptyArray();
                private Integer vrSdk = null;
                private Integer vrSystemType = null;

                public static Actor[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Actor[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public Actor() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final Actor clone() {
                    Actor var1;
                    try {
                        var1 = (Actor)super.clone();
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }

                    if(this.startFromHeadTransform != null) {
                        var1.startFromHeadTransform = this.startFromHeadTransform.clone();
                    }

                    if(this.controllerStates != null && this.controllerStates.length > 0) {
                        var1.controllerStates = new ControllerState[this.controllerStates.length];

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
                            ControllerState var3;
                            if((var3 = this.controllerStates[var2]) != null) {
                                var1.writeMessage(3, var3);
                            }
                        }
                    }

                    if(this.vrSdk != null) {
                        var1.writeInt32(4, this.vrSdk.intValue());
                    }

                    if(this.vrSystemType != null) {
                        var1.writeInt32(5, this.vrSystemType.intValue());
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.startFromHeadTransform != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.startFromHeadTransform);
                    }

                    if(this.controllerStates != null && this.controllerStates.length > 0) {
                        for(int var2 = 0; var2 < this.controllerStates.length; ++var2) {
                            ControllerState var3;
                            if((var3 = this.controllerStates[var2]) != null) {
                                var1 += CodedOutputByteBufferNano.computeMessageSize(3, var3);
                            }
                        }
                    }

                    if(this.vrSdk != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(4, this.vrSdk.intValue());
                    }

                    if(this.vrSystemType != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(5, this.vrSystemType.intValue());
                    }

                    return var1;
                }
            }


            public final class Environment extends ExtendableMessageNano<Environment> implements Cloneable {
                private Transform startFromEnvironmentTransform = null;

                public Environment() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final Environment clone() {
                    Environment var1;
                    try {
                        var1 = (Environment)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.startFromEnvironmentTransform != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(1, this.startFromEnvironmentTransform);
                    }

                    return var1;
                }
            }


            public final class SplashScreen extends ExtendableMessageNano<SplashScreen> implements Cloneable {
                private Integer exitType = null;
                private Long numberOfViewPreloadsAttempted = null;
                private Long numberOfViewPreloadsSucceeded = null;
                private Long viewPreloadDurationMs = null;

                public SplashScreen() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final SplashScreen clone() {
                    try {
                        SplashScreen var1 = (SplashScreen)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }


            public final class Search extends ExtendableMessageNano<Search> implements Cloneable {
                private String typedQuery = null;
                private String searchQuery = null;
                private Integer selectedEntityIndex = null;
                private View selectedEntityView = null;

                public Search() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final Search clone() {
                    Search var1;
                    try {
                        var1 = (Search)super.clone();
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }

                    if(this.selectedEntityView != null) {
                        var1.selectedEntityView = this.selectedEntityView.clone();
                    }

                    return var1;
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.typedQuery != null) {
                        var1.writeString(1, this.typedQuery);
                    }

                    if(this.searchQuery != null) {
                        var1.writeString(2, this.searchQuery);
                    }

                    if(this.selectedEntityIndex != null) {
                        var1.writeInt32(3, this.selectedEntityIndex.intValue());
                    }

                    if(this.selectedEntityView != null) {
                        var1.writeMessage(4, this.selectedEntityView);
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.typedQuery != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(1, this.typedQuery);
                    }

                    if(this.searchQuery != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(2, this.searchQuery);
                    }

                    if(this.selectedEntityIndex != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(3, this.selectedEntityIndex.intValue());
                    }

                    if(this.selectedEntityView != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(4, this.selectedEntityView);
                    }

                    return var1;
                }
            }



            private DoublePrecisionTransform startFromKeyholeTransform = null;
            private Transform startFromHeadTransform = null;
            private ControllerState[] controllerStates = ControllerState.emptyArray();
            private AppState appState = null;
            private View view = null;
            private Menu menu = null;
            private Preferences preferences = null;
            private Preferences preferencesDelta = null;
            private Tour tour = null;
            private Tutorial tutorial = null;
            private Actor[] actors = Actor.emptyArray();
            private Environment environment = null;
            private SplashScreen splashScreen = null;
            private Search search = null;

            public EarthVr() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final EarthVr clone() {
                EarthVr var1;
                try {
                    var1 = (EarthVr)super.clone();
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
                    var1.controllerStates = new ControllerState[this.controllerStates.length];

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

                if(this.preferencesDelta != null) {
                    var1.preferencesDelta = this.preferencesDelta.clone();
                }

                if(this.tour != null) {
                    var1.tour = this.tour.clone();
                }

                if(this.tutorial != null) {
                    var1.tutorial = this.tutorial.clone();
                }

                if(this.actors != null && this.actors.length > 0) {
                    var1.actors = new Actor[this.actors.length];

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

                if(this.search != null) {
                    var1.search = this.search.clone();
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
                        ControllerState var3;
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
                        Actor var4;
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

                if(this.search != null) {
                    var1.writeMessage(13, this.search);
                }

                if(this.preferencesDelta != null) {
                    var1.writeMessage(14, this.preferencesDelta);
                }

                super.writeTo(var1);
            }

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
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
                        ControllerState var3;
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
                        Actor var4;
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

                if(this.search != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(13, this.search);
                }

                if(this.preferencesDelta != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(14, this.preferencesDelta);
                }

                return var1;
            }
        }
        ///////////////////

        public final class Launcher extends ExtendableMessageNano<Launcher> implements Cloneable {
            private Integer navItem = null;

            public Launcher() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final Launcher clone() {
                try {
                    Launcher var1 = (Launcher)super.clone();
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

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.navItem != null) {
                    var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.navItem.intValue());
                }

                return var1;
            }
        }
//////////////////////////////

        public final static class Keyboard extends ExtendableMessageNano<Keyboard> implements Cloneable
        {


            public final static class KeyboardEvent extends ExtendableMessageNano<KeyboardEvent> implements Cloneable {
                private static volatile KeyboardEvent[] _emptyArray;
                private Long clientTimestamp = null;
                private Integer eventType = null;
                private KeyboardTextEntry textEntry = null;
                private Application keyboardService = null;
                private String[] systemLanguages;
                private String[] enabledLanguages;
                private String language;
                private Integer inputType;
                private String layout;
                private Integer suggestionCount;

                public static KeyboardEvent[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new KeyboardEvent[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public KeyboardEvent() {
                    this.systemLanguages = WireFormatNano.EMPTY_STRING_ARRAY;
                    this.enabledLanguages = WireFormatNano.EMPTY_STRING_ARRAY;
                    this.language = null;
                    this.inputType = null;
                    this.layout = null;
                    this.suggestionCount = null;
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final KeyboardEvent clone() {
                    KeyboardEvent var1;
                    try {
                        var1 = (KeyboardEvent)super.clone();
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

                    if(this.suggestionCount != null) {
                        var1.writeInt32(10, this.suggestionCount.intValue());
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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

                    if(this.suggestionCount != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(10, this.suggestionCount.intValue());
                    }

                    return var1;
                }
            }

            public final class KeyboardTextEntry extends ExtendableMessageNano<KeyboardTextEntry> implements Cloneable {
                private Integer type = null;
                private Integer length = null;
                private String layout = null;
                private String language = null;

                public KeyboardTextEntry() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final KeyboardTextEntry clone() {
                    try {
                        KeyboardTextEntry var1 = (KeyboardTextEntry)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }


            private KeyboardEvent[] keyboardEvents = KeyboardEvent.emptyArray();

            public Keyboard() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final Keyboard clone() {
                Keyboard var1;
                try {
                    var1 = (Keyboard)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.keyboardEvents != null && this.keyboardEvents.length > 0) {
                    var1.keyboardEvents = new KeyboardEvent[this.keyboardEvents.length];

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
                        KeyboardEvent var3;
                        if((var3 = this.keyboardEvents[var2]) != null) {
                            var1.writeMessage(2, var3);
                        }
                    }
                }

                super.writeTo(var1);
            }

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.keyboardEvents != null && this.keyboardEvents.length > 0) {
                    for(int var2 = 0; var2 < this.keyboardEvents.length; ++var2) {
                        KeyboardEvent var3;
                        if((var3 = this.keyboardEvents[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(2, var3);
                        }
                    }
                }

                return var1;
            }
        }
        //////////////////////

        public final class Renderer extends ExtendableMessageNano<Renderer> implements Cloneable {
            private String glVendor = null;
            private String glRenderer = null;
            private String glVersion = null;

            public Renderer() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final Renderer clone() {
                try {
                    Renderer var1 = (Renderer)super.clone();
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

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
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
        }
        /////////////////

        public final class Lullaby extends ExtendableMessageNano<Lullaby> implements Cloneable
        {

            public final class LoadTime extends ExtendableMessageNano<LoadTime> implements Cloneable {
                private Integer assetType = null;
                private Long loadTimeMs = null;

                public LoadTime() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final LoadTime clone() {
                    try {
                        LoadTime var1 = (LoadTime)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }

            private Integer uiElement = null;
            private Integer index = null;
            private String contentId = null;
            private LoadTime loadTime = null;

            public Lullaby() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final Lullaby clone() {
                Lullaby var1;
                try {
                    var1 = (Lullaby)super.clone();
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

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
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
        }
        //////////////////////

        public final class StreetView extends ExtendableMessageNano<StreetView> implements Cloneable
        {

            public final class PanoSession extends ExtendableMessageNano<PanoSession> implements Cloneable {
                private Integer source = null;
                private Integer panosAvailable = null;
                private Integer panosViewed = null;
                private Integer nodesNavigated = null;
                private Integer nextClicks = null;
                private Integer prevClicks = null;
                private Integer playPauseClicks = null;
                private Integer infoClicks = null;

                public PanoSession() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final PanoSession clone() {
                    try {
                        PanoSession var1 = (PanoSession)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }


            public final class TutorialSession extends ExtendableMessageNano<TutorialSession> implements Cloneable {
                private Integer tutorial = null;
                private Boolean completed = null;

                public TutorialSession() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final TutorialSession clone() {
                    try {
                        TutorialSession var1 = (TutorialSession)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.tutorial != null) {
                        var1.writeInt32(1, this.tutorial.intValue());
                    }

                    if(this.completed != null) {
                        var1.writeBool(2, this.completed.booleanValue());
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.tutorial != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.tutorial.intValue());
                    }

                    if(this.completed != null) {
                        var1 += CodedOutputByteBufferNano.computeBoolSize(2, this.completed.booleanValue());
                    }

                    return var1;
                }
            }



            private PanoSession panoSession = null;
            private TutorialSession tutorialSession = null;

            public StreetView() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final StreetView clone() {
                StreetView var1;
                try {
                    var1 = (StreetView)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.panoSession != null) {
                    var1.panoSession = this.panoSession.clone();
                }

                if(this.tutorialSession != null) {
                    var1.tutorialSession = this.tutorialSession.clone();
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.panoSession != null) {
                    var1.writeMessage(1, this.panoSession);
                }

                if(this.tutorialSession != null) {
                    var1.writeMessage(2, this.tutorialSession);
                }

                super.writeTo(var1);
            }

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.panoSession != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(1, this.panoSession);
                }

                if(this.tutorialSession != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.tutorialSession);
                }

                return var1;
            }
        }
/////////////////////////

        public final class Photos extends ExtendableMessageNano<Photos> implements Cloneable
        {

            public final class OpenMedia extends ExtendableMessageNano<OpenMedia> implements Cloneable {
                private Integer type = null;
                private Integer source = null;
                private Boolean isSample = null;

                public OpenMedia() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final OpenMedia clone() {
                    try {
                        OpenMedia var1 = (OpenMedia)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }


            public final class WarmWelcome extends ExtendableMessageNano<WarmWelcome> implements Cloneable {
                private Float exitProgress = null;

                public WarmWelcome() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final WarmWelcome clone() {
                    try {
                        WarmWelcome var1 = (WarmWelcome)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.exitProgress != null) {
                        var1 += CodedOutputByteBufferNano.computeFloatSize(1, this.exitProgress.floatValue());
                    }

                    return var1;
                }
            }


            private Integer numPhotos = null;
            private OpenMedia openMedia = null;
            private WarmWelcome warmWelcome = null;

            public Photos() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final Photos clone() {
                Photos var1;
                try {
                    var1 = (Photos)super.clone();
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

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
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
        }
        /////////////

        public final static class GConfigUpdate extends ExtendableMessageNano<GConfigUpdate> implements Cloneable
        {

            public final static class GConfigValue extends ExtendableMessageNano<GConfigValue> implements Cloneable {
                private static volatile GConfigValue[] _emptyArray;
                private String gConfigKey = null;
                private String stringValue = null;

                public static GConfigValue[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new GConfigValue[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public GConfigValue() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final GConfigValue clone() {
                    try {
                        GConfigValue var1 = (GConfigValue)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.gConfigKey != null) {
                        var1.writeString(1, this.gConfigKey);
                    }

                    if(this.stringValue != null) {
                        var1.writeString(2, this.stringValue);
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.gConfigKey != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(1, this.gConfigKey);
                    }

                    if(this.stringValue != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(2, this.stringValue);
                    }

                    return var1;
                }
            }

            private GConfigValue[] gConfigValue = GConfigValue.emptyArray();

            public GConfigUpdate() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final GConfigUpdate clone() {
                GConfigUpdate var1;
                try {
                    var1 = (GConfigUpdate)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.gConfigValue != null && this.gConfigValue.length > 0) {
                    var1.gConfigValue = new GConfigValue[this.gConfigValue.length];

                    for(int var2 = 0; var2 < this.gConfigValue.length; ++var2) {
                        if(this.gConfigValue[var2] != null) {
                            var1.gConfigValue[var2] = this.gConfigValue[var2].clone();
                        }
                    }
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.gConfigValue != null && this.gConfigValue.length > 0) {
                    for(int var2 = 0; var2 < this.gConfigValue.length; ++var2) {
                        GConfigValue var3;
                        if((var3 = this.gConfigValue[var2]) != null) {
                            var1.writeMessage(1, var3);
                        }
                    }
                }

                super.writeTo(var1);
            }

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.gConfigValue != null && this.gConfigValue.length > 0) {
                    for(int var2 = 0; var2 < this.gConfigValue.length; ++var2) {
                        GConfigValue var3;
                        if((var3 = this.gConfigValue[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(1, var3);
                        }
                    }
                }

                return var1;
            }
        }


        //////////////

        public final class VrHome extends ExtendableMessageNano<VrHome> implements Cloneable
        {

            public final class Setup extends ExtendableMessageNano<Setup> implements Cloneable
            {

                public final class StepStateChange extends ExtendableMessageNano<StepStateChange> implements Cloneable {
                    private Integer step = null;
                    private Integer previousStepState = null;
                    private Integer newStepState = null;

                    public StepStateChange() {
                        this.unknownFieldData = null;
                        this.cachedSize = -1;
                    }

                    public final StepStateChange clone() {
                        try {
                            StepStateChange var1 = (StepStateChange)super.clone();
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

                    @Override
                    public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                        return null;
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
                }


                public final class View extends ExtendableMessageNano<View> implements Cloneable {
                    private Integer step = null;
                    private Integer page = null;

                    public View() {
                        this.unknownFieldData = null;
                        this.cachedSize = -1;
                    }

                    public final View clone() {
                        try {
                            View var1 = (View)super.clone();
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

                    @Override
                    public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                        return null;
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
                }

                private View view = null;
                private StepStateChange stepStateChange = null;

                public Setup() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final Setup clone() {
                    Setup var1;
                    try {
                        var1 = (Setup)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }


            public final class GetViewerClick extends ExtendableMessageNano<GetViewerClick> implements Cloneable {
                private String url = null;

                public GetViewerClick() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final GetViewerClick clone() {
                    try {
                        GetViewerClick var1 = (GetViewerClick)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.url != null) {
                        var1.writeString(1, this.url);
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.url != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(1, this.url);
                    }

                    return var1;
                }
            }

            public final class DialogAction extends ExtendableMessageNano<DialogAction> implements Cloneable {
                private Integer type = null;
                private Integer actionType = null;

                public DialogAction() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final DialogAction clone() {
                    try {
                        DialogAction var1 = (DialogAction)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.type != null) {
                        var1.writeInt32(1, this.type.intValue());
                    }

                    if(this.actionType != null) {
                        var1.writeInt32(2, this.actionType.intValue());
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.type != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.type.intValue());
                    }

                    if(this.actionType != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.actionType.intValue());
                    }

                    return var1;
                }
            }



            private Setup setup = null;
            private GConfigUpdate gConfigUpdate = null;
            private GetViewerClick getViewerClick = null;
            private DialogAction dialogAction = null;

            public VrHome() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final VrHome clone() {
                VrHome var1;
                try {
                    var1 = (VrHome)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.setup != null) {
                    var1.setup = this.setup.clone();
                }

                if(this.gConfigUpdate != null) {
                    var1.gConfigUpdate = this.gConfigUpdate.clone();
                }

                if(this.getViewerClick != null) {
                    var1.getViewerClick = this.getViewerClick.clone();
                }

                if(this.dialogAction != null) {
                    var1.dialogAction = this.dialogAction.clone();
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.setup != null) {
                    var1.writeMessage(1, this.setup);
                }

                if(this.gConfigUpdate != null) {
                    var1.writeMessage(2, this.gConfigUpdate);
                }

                if(this.getViewerClick != null) {
                    var1.writeMessage(3, this.getViewerClick);
                }

                if(this.dialogAction != null) {
                    var1.writeMessage(4, this.dialogAction);
                }

                super.writeTo(var1);
            }

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.setup != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(1, this.setup);
                }

                if(this.gConfigUpdate != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.gConfigUpdate);
                }

                if(this.getViewerClick != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(3, this.getViewerClick);
                }

                if(this.dialogAction != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(4, this.dialogAction);
                }

                return var1;
            }
        }
//////////////////////////

        public final class SdkConfigurationParams extends ExtendableMessageNano<SdkConfigurationParams> implements Cloneable
        {

            public final class AsyncReprojectionConfig extends ExtendableMessageNano<AsyncReprojectionConfig> implements Cloneable {
                public Long flags = null;
                private Long displayLatencyMicros = null;

                public AsyncReprojectionConfig() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final AsyncReprojectionConfig clone() {
                    try {
                        AsyncReprojectionConfig var1 = (AsyncReprojectionConfig)super.clone();
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

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
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
            }

            private Boolean daydreamImageAlignmentEnabled = null;
            public Boolean useSystemClockForSensorTimestamps = null;
            public Boolean useMagnetometerInSensorFusion = null;
            public Boolean allowDynamicLibraryLoading = null;
            public Boolean cpuLateLatchingEnabled = null;
            public Integer daydreamImageAlignment = null;
            public AsyncReprojectionConfig asyncReprojectionConfig = null;
            public Boolean useOnlineMagnetometerCalibration = null;
            public Boolean useDeviceIdleDetection = null;
            private Boolean useStationaryBiasCorrection = null;
            public Boolean allowDynamicJavaLibraryLoading = null;

            public SdkConfigurationParams() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final SdkConfigurationParams clone() {
                SdkConfigurationParams var1;
                try {
                    var1 = (SdkConfigurationParams)super.clone();
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

                if(this.useDeviceIdleDetection != null) {
                    var1.writeBool(9, this.useDeviceIdleDetection.booleanValue());
                }

                if(this.useStationaryBiasCorrection != null) {
                    var1.writeBool(10, this.useStationaryBiasCorrection.booleanValue());
                }

                if(this.allowDynamicJavaLibraryLoading != null) {
                    var1.writeBool(11, this.allowDynamicJavaLibraryLoading.booleanValue());
                }

                super.writeTo(var1);
            }

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
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

                if(this.useDeviceIdleDetection != null) {
                    var1 += CodedOutputByteBufferNano.computeBoolSize(9, this.useDeviceIdleDetection.booleanValue());
                }

                if(this.useStationaryBiasCorrection != null) {
                    var1 += CodedOutputByteBufferNano.computeBoolSize(10, this.useStationaryBiasCorrection.booleanValue());
                }

                if(this.allowDynamicJavaLibraryLoading != null) {
                    var1 += CodedOutputByteBufferNano.computeBoolSize(11, this.allowDynamicJavaLibraryLoading.booleanValue());
                }

                return var1;
            }
        }
////////////////////////////

        public final class JumpInspector extends ExtendableMessageNano<JumpInspector> implements Cloneable
        {

            public final class Resolution extends ExtendableMessageNano<Resolution> implements Cloneable {
                private Integer width = null;
                private Integer height = null;

                public Resolution() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final Resolution clone() {
                    try {
                        Resolution var1 = (Resolution)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.width != null) {
                        var1.writeInt32(1, this.width.intValue());
                    }

                    if(this.height != null) {
                        var1.writeInt32(2, this.height.intValue());
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.width != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.width.intValue());
                    }

                    if(this.height != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.height.intValue());
                    }

                    return var1;
                }
            }


            public final class SphericalMetadata extends ExtendableMessageNano<SphericalMetadata> implements Cloneable {
                private Integer metadataVersion = null;
                private Integer projectionType = null;
                private Integer meshCrc = null;

                public SphericalMetadata() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final SphericalMetadata clone() {
                    try {
                        SphericalMetadata var1 = (SphericalMetadata)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.metadataVersion != null) {
                        var1.writeInt32(1, this.metadataVersion.intValue());
                    }

                    if(this.projectionType != null) {
                        var1.writeInt32(2, this.projectionType.intValue());
                    }

                    if(this.meshCrc != null) {
                        var1.writeInt32(3, this.meshCrc.intValue());
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.metadataVersion != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.metadataVersion.intValue());
                    }

                    if(this.projectionType != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.projectionType.intValue());
                    }

                    if(this.meshCrc != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(3, this.meshCrc.intValue());
                    }

                    return var1;
                }
            }



            public final class VideoDetails extends ExtendableMessageNano<VideoDetails> implements Cloneable {
                private Long mediaLengthSeconds = null;
                private Resolution resolution = null;
                private Double framesPerSecond = null;
                private Integer sampleRate = null;
                private Integer videoBitRate = null;
                private Integer audioBitRate = null;
                private Integer videoCodec = null;
                private Integer audioCodec = null;
                private SphericalMetadata sphericalMetadata = null;
                private Integer audioChannelCount = null;
                private Boolean usedMonoFilename = null;
                private Boolean usedWalleFilename = null;
                private Boolean usedWallyFilename = null;

                public VideoDetails() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final VideoDetails clone() {
                    VideoDetails var1;
                    try {
                        var1 = (VideoDetails)super.clone();
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }

                    if(this.resolution != null) {
                        var1.resolution = this.resolution.clone();
                    }

                    if(this.sphericalMetadata != null) {
                        var1.sphericalMetadata = this.sphericalMetadata.clone();
                    }

                    return var1;
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.mediaLengthSeconds != null) {
                        var1.writeInt64(1, this.mediaLengthSeconds.longValue());
                    }

                    if(this.resolution != null) {
                        var1.writeMessage(2, this.resolution);
                    }

                    if(this.framesPerSecond != null) {
                        var1.writeDouble(3, this.framesPerSecond.doubleValue());
                    }

                    if(this.sampleRate != null) {
                        var1.writeInt32(4, this.sampleRate.intValue());
                    }

                    if(this.videoBitRate != null) {
                        var1.writeInt32(5, this.videoBitRate.intValue());
                    }

                    if(this.audioBitRate != null) {
                        var1.writeInt32(6, this.audioBitRate.intValue());
                    }

                    if(this.videoCodec != null) {
                        var1.writeInt32(7, this.videoCodec.intValue());
                    }

                    if(this.audioCodec != null) {
                        var1.writeInt32(8, this.audioCodec.intValue());
                    }

                    if(this.sphericalMetadata != null) {
                        var1.writeMessage(9, this.sphericalMetadata);
                    }

                    if(this.audioChannelCount != null) {
                        var1.writeInt32(10, this.audioChannelCount.intValue());
                    }

                    if(this.usedMonoFilename != null) {
                        var1.writeBool(11, this.usedMonoFilename.booleanValue());
                    }

                    if(this.usedWalleFilename != null) {
                        var1.writeBool(12, this.usedWalleFilename.booleanValue());
                    }

                    if(this.usedWallyFilename != null) {
                        var1.writeBool(13, this.usedWallyFilename.booleanValue());
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.mediaLengthSeconds != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(1, this.mediaLengthSeconds.longValue());
                    }

                    if(this.resolution != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.resolution);
                    }

                    if(this.framesPerSecond != null) {
                        var1 += CodedOutputByteBufferNano.computeDoubleSize(3, this.framesPerSecond.doubleValue());
                    }

                    if(this.sampleRate != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(4, this.sampleRate.intValue());
                    }

                    if(this.videoBitRate != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(5, this.videoBitRate.intValue());
                    }

                    if(this.audioBitRate != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(6, this.audioBitRate.intValue());
                    }

                    if(this.videoCodec != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(7, this.videoCodec.intValue());
                    }

                    if(this.audioCodec != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(8, this.audioCodec.intValue());
                    }

                    if(this.sphericalMetadata != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(9, this.sphericalMetadata);
                    }

                    if(this.audioChannelCount != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(10, this.audioChannelCount.intValue());
                    }

                    if(this.usedMonoFilename != null) {
                        var1 += CodedOutputByteBufferNano.computeBoolSize(11, this.usedMonoFilename.booleanValue());
                    }

                    if(this.usedWalleFilename != null) {
                        var1 += CodedOutputByteBufferNano.computeBoolSize(12, this.usedWalleFilename.booleanValue());
                    }

                    if(this.usedWallyFilename != null) {
                        var1 += CodedOutputByteBufferNano.computeBoolSize(13, this.usedWallyFilename.booleanValue());
                    }

                    return var1;
                }
            }

            public final class ImageDetails extends ExtendableMessageNano<ImageDetails> implements Cloneable {
                private Resolution resolution = null;
                private Boolean usedMonoFilename = null;

                public ImageDetails() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final ImageDetails clone() {
                    ImageDetails var1;
                    try {
                        var1 = (ImageDetails)super.clone();
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }

                    if(this.resolution != null) {
                        var1.resolution = this.resolution.clone();
                    }

                    return var1;
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.resolution != null) {
                        var1.writeMessage(1, this.resolution);
                    }

                    if(this.usedMonoFilename != null) {
                        var1.writeBool(2, this.usedMonoFilename.booleanValue());
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.resolution != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(1, this.resolution);
                    }

                    if(this.usedMonoFilename != null) {
                        var1 += CodedOutputByteBufferNano.computeBoolSize(2, this.usedMonoFilename.booleanValue());
                    }

                    return var1;
                }
            }


            public final class AudioDetails extends ExtendableMessageNano<AudioDetails> implements Cloneable {
                private Long mediaLengthSeconds = null;
                private Integer sampleRate = null;
                private Integer audioBitRate = null;
                private Integer audioCodec = null;
                private Integer audioChannelCount = null;

                public AudioDetails() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final AudioDetails clone() {
                    try {
                        AudioDetails var1 = (AudioDetails)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.mediaLengthSeconds != null) {
                        var1.writeInt64(1, this.mediaLengthSeconds.longValue());
                    }

                    if(this.sampleRate != null) {
                        var1.writeInt32(2, this.sampleRate.intValue());
                    }

                    if(this.audioBitRate != null) {
                        var1.writeInt32(3, this.audioBitRate.intValue());
                    }

                    if(this.audioCodec != null) {
                        var1.writeInt32(4, this.audioCodec.intValue());
                    }

                    if(this.audioChannelCount != null) {
                        var1.writeInt32(5, this.audioChannelCount.intValue());
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.mediaLengthSeconds != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(1, this.mediaLengthSeconds.longValue());
                    }

                    if(this.sampleRate != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.sampleRate.intValue());
                    }

                    if(this.audioBitRate != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(3, this.audioBitRate.intValue());
                    }

                    if(this.audioCodec != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(4, this.audioCodec.intValue());
                    }

                    if(this.audioChannelCount != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(5, this.audioChannelCount.intValue());
                    }

                    return var1;
                }
            }


            public final class MediaDetails extends ExtendableMessageNano<MediaDetails> implements Cloneable {
                private String fileExtension = null;
                private VideoDetails videoDetails = null;
                private ImageDetails imageDetails = null;
                private AudioDetails audioDetails = null;

                public MediaDetails() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final MediaDetails clone() {
                    MediaDetails var1;
                    try {
                        var1 = (MediaDetails)super.clone();
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }

                    if(this.videoDetails != null) {
                        var1.videoDetails = this.videoDetails.clone();
                    }

                    if(this.imageDetails != null) {
                        var1.imageDetails = this.imageDetails.clone();
                    }

                    if(this.audioDetails != null) {
                        var1.audioDetails = this.audioDetails.clone();
                    }

                    return var1;
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.fileExtension != null) {
                        var1.writeString(1, this.fileExtension);
                    }

                    if(this.videoDetails != null) {
                        var1.writeMessage(2, this.videoDetails);
                    }

                    if(this.imageDetails != null) {
                        var1.writeMessage(3, this.imageDetails);
                    }

                    if(this.audioDetails != null) {
                        var1.writeMessage(4, this.audioDetails);
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.fileExtension != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(1, this.fileExtension);
                    }

                    if(this.videoDetails != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.videoDetails);
                    }

                    if(this.imageDetails != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(3, this.imageDetails);
                    }

                    if(this.audioDetails != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(4, this.audioDetails);
                    }

                    return var1;
                }
            }


            public final class VideoPlaybackDetails extends ExtendableMessageNano<VideoPlaybackDetails> implements Cloneable {
                private Integer playbackMode = null;
                private Boolean usedExternalSync = null;
                private Integer droppedFramesCount = null;

                public VideoPlaybackDetails() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final VideoPlaybackDetails clone() {
                    try {
                        VideoPlaybackDetails var1 = (VideoPlaybackDetails)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.playbackMode != null) {
                        var1.writeInt32(1, this.playbackMode.intValue());
                    }

                    if(this.usedExternalSync != null) {
                        var1.writeBool(2, this.usedExternalSync.booleanValue());
                    }

                    if(this.droppedFramesCount != null) {
                        var1.writeInt32(3, this.droppedFramesCount.intValue());
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.playbackMode != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.playbackMode.intValue());
                    }

                    if(this.usedExternalSync != null) {
                        var1 += CodedOutputByteBufferNano.computeBoolSize(2, this.usedExternalSync.booleanValue());
                    }

                    if(this.droppedFramesCount != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(3, this.droppedFramesCount.intValue());
                    }

                    return var1;
                }
            }


            public final class ImagePlaybackDetails extends ExtendableMessageNano<ImagePlaybackDetails> implements Cloneable {
                private Integer playbackMode = null;

                public ImagePlaybackDetails() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final ImagePlaybackDetails clone() {
                    try {
                        ImagePlaybackDetails var1 = (ImagePlaybackDetails)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.playbackMode != null) {
                        var1.writeInt32(1, this.playbackMode.intValue());
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.playbackMode != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.playbackMode.intValue());
                    }

                    return var1;
                }
            }



            public final class PlaybackDetails extends ExtendableMessageNano<PlaybackDetails> implements Cloneable {
                private Integer playbackState = null;
                private Long playbackDurationSeconds = null;
                private Integer playbackEngine = null;
                private VideoPlaybackDetails videoPlayback = null;
                private ImagePlaybackDetails imagePlayback = null;

                public PlaybackDetails() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final PlaybackDetails clone() {
                    PlaybackDetails var1;
                    try {
                        var1 = (PlaybackDetails)super.clone();
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }

                    if(this.videoPlayback != null) {
                        var1.videoPlayback = this.videoPlayback.clone();
                    }

                    if(this.imagePlayback != null) {
                        var1.imagePlayback = this.imagePlayback.clone();
                    }

                    return var1;
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.playbackState != null) {
                        var1.writeInt32(1, this.playbackState.intValue());
                    }

                    if(this.playbackDurationSeconds != null) {
                        var1.writeInt64(2, this.playbackDurationSeconds.longValue());
                    }

                    if(this.playbackEngine != null) {
                        var1.writeInt32(3, this.playbackEngine.intValue());
                    }

                    if(this.videoPlayback != null) {
                        var1.writeMessage(4, this.videoPlayback);
                    }

                    if(this.imagePlayback != null) {
                        var1.writeMessage(5, this.imagePlayback);
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.playbackState != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.playbackState.intValue());
                    }

                    if(this.playbackDurationSeconds != null) {
                        var1 += CodedOutputByteBufferNano.computeInt64Size(2, this.playbackDurationSeconds.longValue());
                    }

                    if(this.playbackEngine != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(3, this.playbackEngine.intValue());
                    }

                    if(this.videoPlayback != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(4, this.videoPlayback);
                    }

                    if(this.imagePlayback != null) {
                        var1 += CodedOutputByteBufferNano.computeMessageSize(5, this.imagePlayback);
                    }

                    return var1;
                }
            }


            public final class PickerDetails extends ExtendableMessageNano<PickerDetails> implements Cloneable {
                private Integer numberOfFiles = null;
                private Integer numberOfFolders = null;

                public PickerDetails() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final PickerDetails clone() {
                    try {
                        PickerDetails var1 = (PickerDetails)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.numberOfFiles != null) {
                        var1.writeInt32(1, this.numberOfFiles.intValue());
                    }

                    if(this.numberOfFolders != null) {
                        var1.writeInt32(2, this.numberOfFolders.intValue());
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.numberOfFiles != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.numberOfFiles.intValue());
                    }

                    if(this.numberOfFolders != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.numberOfFolders.intValue());
                    }

                    return var1;
                }
            }



            private MediaDetails mediaDetails = null;
            private PlaybackDetails playbackDetails = null;
            private PickerDetails pickerEvent = null;

            public JumpInspector() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final JumpInspector clone() {
                JumpInspector var1;
                try {
                    var1 = (JumpInspector)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.mediaDetails != null) {
                    var1.mediaDetails = this.mediaDetails.clone();
                }

                if(this.playbackDetails != null) {
                    var1.playbackDetails = this.playbackDetails.clone();
                }

                if(this.pickerEvent != null) {
                    var1.pickerEvent = this.pickerEvent.clone();
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.mediaDetails != null) {
                    var1.writeMessage(1, this.mediaDetails);
                }

                if(this.playbackDetails != null) {
                    var1.writeMessage(2, this.playbackDetails);
                }

                if(this.pickerEvent != null) {
                    var1.writeMessage(3, this.pickerEvent);
                }

                super.writeTo(var1);
            }

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.mediaDetails != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(1, this.mediaDetails);
                }

                if(this.playbackDetails != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.playbackDetails);
                }

                if(this.pickerEvent != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(3, this.pickerEvent);
                }

                return var1;
            }
        }
///////////////

        public final static class Vector2 extends ExtendableMessageNano<Vector2> implements Cloneable {
            private static volatile Vector2[] _emptyArray;
            public Float x = null;
            public Float y = null;

            public static Vector2[] emptyArray() {
                if(_emptyArray == null) {
                    Object var0 = InternalNano.LAZY_INIT_LOCK;
                    synchronized(InternalNano.LAZY_INIT_LOCK) {
                        if(_emptyArray == null) {
                            _emptyArray = new Vector2[0];
                        }
                    }
                }

                return _emptyArray;
            }

            public Vector2() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final Vector2 clone() {
                try {
                    Vector2 var1 = (Vector2)super.clone();
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

                super.writeTo(var1);
            }

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.x != null) {
                    var1 += CodedOutputByteBufferNano.computeFloatSize(1, this.x.floatValue());
                }

                if(this.y != null) {
                    var1 += CodedOutputByteBufferNano.computeFloatSize(2, this.y.floatValue());
                }

                return var1;
            }
        }
///////////////////


        public final class PhoneAlignment extends ExtendableMessageNano<PhoneAlignment> implements Cloneable {
            public Vector2[] touchLocations = Vector2.emptyArray();
            public Vector2 lensOffset = null;
            public Float angleDegrees = null;

            public PhoneAlignment() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final PhoneAlignment clone() {
                PhoneAlignment var1;
                try {
                    var1 = (PhoneAlignment)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.touchLocations != null && this.touchLocations.length > 0) {
                    var1.touchLocations = new Vector2[this.touchLocations.length];

                    for(int var2 = 0; var2 < this.touchLocations.length; ++var2) {
                        if(this.touchLocations[var2] != null) {
                            var1.touchLocations[var2] = this.touchLocations[var2].clone();
                        }
                    }
                }

                if(this.lensOffset != null) {
                    var1.lensOffset = this.lensOffset.clone();
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.touchLocations != null && this.touchLocations.length > 0) {
                    for(int var2 = 0; var2 < this.touchLocations.length; ++var2) {
                        Vector2 var3;
                        if((var3 = this.touchLocations[var2]) != null) {
                            var1.writeMessage(1, var3);
                        }
                    }
                }

                if(this.lensOffset != null) {
                    var1.writeMessage(2, this.lensOffset);
                }

                if(this.angleDegrees != null) {
                    var1.writeFloat(3, this.angleDegrees.floatValue());
                }

                super.writeTo(var1);
            }

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.touchLocations != null && this.touchLocations.length > 0) {
                    for(int var2 = 0; var2 < this.touchLocations.length; ++var2) {
                        Vector2 var3;
                        if((var3 = this.touchLocations[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(1, var3);
                        }
                    }
                }

                if(this.lensOffset != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(2, this.lensOffset);
                }

                if(this.angleDegrees != null) {
                    var1 += CodedOutputByteBufferNano.computeFloatSize(3, this.angleDegrees.floatValue());
                }

                return var1;
            }
        }
        ////////////////


        public final static class VrStreaming extends ExtendableMessageNano<VrStreaming> implements Cloneable
        {
            public final static class Frame extends ExtendableMessageNano<Frame> implements Cloneable {
                private static volatile Frame[] _emptyArray;
                private Integer poseId = null;
                private Long poseSendTimeUsec = null;
                private Long framePresentTimeUsec = null;
                private Long decodeStartTimeUsec = null;
                private Long decodeEndTimeUsec = null;

                public static Frame[] emptyArray() {
                    if(_emptyArray == null) {
                        Object var0 = InternalNano.LAZY_INIT_LOCK;
                        synchronized(InternalNano.LAZY_INIT_LOCK) {
                            if(_emptyArray == null) {
                                _emptyArray = new Frame[0];
                            }
                        }
                    }

                    return _emptyArray;
                }

                public Frame() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final Frame clone() {
                    try {
                        Frame var1 = (Frame)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.poseId != null) {
                        var1.writeInt32(1, this.poseId.intValue());
                    }

                    if(this.poseSendTimeUsec != null) {
                        var1.writeUInt64(2, this.poseSendTimeUsec.longValue());
                    }

                    if(this.framePresentTimeUsec != null) {
                        var1.writeUInt64(3, this.framePresentTimeUsec.longValue());
                    }

                    if(this.decodeStartTimeUsec != null) {
                        var1.writeUInt64(4, this.decodeStartTimeUsec.longValue());
                    }

                    if(this.decodeEndTimeUsec != null) {
                        var1.writeUInt64(5, this.decodeEndTimeUsec.longValue());
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.poseId != null) {
                        var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.poseId.intValue());
                    }

                    if(this.poseSendTimeUsec != null) {
                        var1 += CodedOutputByteBufferNano.computeUInt64Size(2, this.poseSendTimeUsec.longValue());
                    }

                    if(this.framePresentTimeUsec != null) {
                        var1 += CodedOutputByteBufferNano.computeUInt64Size(3, this.framePresentTimeUsec.longValue());
                    }

                    if(this.decodeStartTimeUsec != null) {
                        var1 += CodedOutputByteBufferNano.computeUInt64Size(4, this.decodeStartTimeUsec.longValue());
                    }

                    if(this.decodeEndTimeUsec != null) {
                        var1 += CodedOutputByteBufferNano.computeUInt64Size(5, this.decodeEndTimeUsec.longValue());
                    }

                    return var1;
                }
            }


            public final class SessionInfo extends ExtendableMessageNano<SessionInfo> implements Cloneable {
                private String sessionId = null;

                public SessionInfo() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public final SessionInfo clone() {
                    try {
                        SessionInfo var1 = (SessionInfo)super.clone();
                        return var1;
                    } catch (CloneNotSupportedException var3) {
                        throw new AssertionError(var3);
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                    if(this.sessionId != null) {
                        var1.writeString(1, this.sessionId);
                    }

                    super.writeTo(var1);
                }

                @Override
                public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                    return null;
                }

                protected final int computeSerializedSize() {
                    int var1 = super.computeSerializedSize();
                    if(this.sessionId != null) {
                        var1 += CodedOutputByteBufferNano.computeStringSize(1, this.sessionId);
                    }

                    return var1;
                }
            }


            private SessionInfo sessionInfo = null;
            private Frame[] frame = Frame.emptyArray();

            public VrStreaming() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public final VrStreaming clone() {
                VrStreaming var1;
                try {
                    var1 = (VrStreaming)super.clone();
                } catch (CloneNotSupportedException var3) {
                    throw new AssertionError(var3);
                }

                if(this.sessionInfo != null) {
                    var1.sessionInfo = this.sessionInfo.clone();
                }

                if(this.frame != null && this.frame.length > 0) {
                    var1.frame = new Frame[this.frame.length];

                    for(int var2 = 0; var2 < this.frame.length; ++var2) {
                        if(this.frame[var2] != null) {
                            var1.frame[var2] = this.frame[var2].clone();
                        }
                    }
                }

                return var1;
            }

            public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
                if(this.sessionInfo != null) {
                    var1.writeMessage(1, this.sessionInfo);
                }

                if(this.frame != null && this.frame.length > 0) {
                    for(int var2 = 0; var2 < this.frame.length; ++var2) {
                        Frame var3;
                        if((var3 = this.frame[var2]) != null) {
                            var1.writeMessage(2, var3);
                        }
                    }
                }

                super.writeTo(var1);
            }

            @Override
            public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
                return null;
            }

            protected final int computeSerializedSize() {
                int var1 = super.computeSerializedSize();
                if(this.sessionInfo != null) {
                    var1 += CodedOutputByteBufferNano.computeMessageSize(1, this.sessionInfo);
                }

                if(this.frame != null && this.frame.length > 0) {
                    for(int var2 = 0; var2 < this.frame.length; ++var2) {
                        Frame var3;
                        if((var3 = this.frame[var2]) != null) {
                            var1 += CodedOutputByteBufferNano.computeMessageSize(2, var3);
                        }
                    }
                }

                return var1;
            }
        }

        ///////////////////////////////////

        private HeadMount headMount = null;
        private Application application = null;
        private Long durationMs = null;
        private Application[] installedVrApplications = Application.emptyArray();
        private Cyclops cyclops = null;
        private QrCodeScan qrCodeScan = null;
        private String cohort = null;
        private Integer lifetimeCountBucket = null;
        private PerformanceStats performanceStats = null;
        private SensorStats sensorStats = null;
        private AudioStats audioStats = null;
        private EmbedVrWidget embedVrWidget = null;
        private VrCore vrCore = null;
        private EarthVr earthVr = null;
        private Launcher launcher = null;
        private Keyboard keyboard = null;
        private Renderer renderer = null;
        private Lullaby lullaby = null;
        private StreetView streetView = null;
        private Photos photos = null;
        private VrHome vrHome = null;
        private SdkConfigurationParams sdkConfiguration = null;
        private GConfigUpdate gConfigUpdate = null;
        private JumpInspector jumpInspector = null;
        public PhoneAlignment phoneAlignment = null;
        private VrStreaming vrStreaming = null;

        public VREvent() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        public VREvent clone() {
            VREvent var1;
            try {
                var1 = (VREvent)super.clone();
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
                var1.installedVrApplications = new Application[this.installedVrApplications.length];

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

            if(this.gConfigUpdate != null) {
                var1.gConfigUpdate = this.gConfigUpdate.clone();
            }

            if(this.jumpInspector != null) {
                var1.jumpInspector = this.jumpInspector.clone();
            }

            if(this.phoneAlignment != null) {
                var1.phoneAlignment = this.phoneAlignment.clone();
            }

            if(this.vrStreaming != null) {
                var1.vrStreaming = this.vrStreaming.clone();
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
                    Application var3;
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

            if(this.gConfigUpdate != null) {
                var1.writeMessage(23, this.gConfigUpdate);
            }

            if(this.jumpInspector != null) {
                var1.writeMessage(24, this.jumpInspector);
            }

            if(this.phoneAlignment != null) {
                var1.writeMessage(25, this.phoneAlignment);
            }

            if(this.vrStreaming != null) {
                var1.writeMessage(26, this.vrStreaming);
            }

            super.writeTo(var1);
        }

        @Override
        public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
            return null;
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
                    Application var3;
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

            if(this.gConfigUpdate != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(23, this.gConfigUpdate);
            }

            if(this.jumpInspector != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(24, this.jumpInspector);
            }

            if(this.phoneAlignment != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(25, this.phoneAlignment);
            }

            if(this.vrStreaming != null) {
                var1 += CodedOutputByteBufferNano.computeMessageSize(26, this.vrStreaming);
            }

            return var1;
        }
    }

    /////////////////////////



    /////////////////////////////////


}
