package logs.proto.wireless.performance.mobile.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;

import java.io.IOException;

/**
 * Created by houguoli on 2017/8/10.
 */

public class MemoryMetric {

    public final class AndroidMemoryStats extends ExtendableMessageNano<AndroidMemoryStats> implements Cloneable {
        private Integer dalvikPssKb = null;
        private Integer nativePssKb = null;
        private Integer otherPssKb = null;
        private Integer dalvikPrivateDirtyKb = null;
        private Integer nativePrivateDirtyKb = null;
        private Integer otherPrivateDirtyKb = null;
        private Integer totalPrivateCleanKb = null;
        private Integer totalSharedDirtyKb = null;
        private Integer totalSwappablePssKb = null;
        private Integer otherGraphicsPssKb = null;
        private Integer summaryJavaHeapKb = null;
        private Integer summaryCodeKb = null;
        private Integer summaryStackKb = null;
        private Integer summaryGraphicsKb = null;
        private Integer summaryPrivateOtherKb = null;
        private Integer summarySystemKb = null;
        private Integer availableMemoryKb = null;
        private Integer totalMemoryMb = null;

        public AndroidMemoryStats() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        public final AndroidMemoryStats clone() {
            try {
                AndroidMemoryStats var1 = (AndroidMemoryStats)super.clone();
                return var1;
            } catch (CloneNotSupportedException var3) {
                throw new AssertionError(var3);
            }
        }

        public final void writeTo(CodedOutputByteBufferNano var1) throws IOException {
            if(this.dalvikPssKb != null) {
                var1.writeInt32(1, this.dalvikPssKb.intValue());
            }

            if(this.nativePssKb != null) {
                var1.writeInt32(2, this.nativePssKb.intValue());
            }

            if(this.otherPssKb != null) {
                var1.writeInt32(3, this.otherPssKb.intValue());
            }

            if(this.dalvikPrivateDirtyKb != null) {
                var1.writeInt32(4, this.dalvikPrivateDirtyKb.intValue());
            }

            if(this.nativePrivateDirtyKb != null) {
                var1.writeInt32(5, this.nativePrivateDirtyKb.intValue());
            }

            if(this.otherPrivateDirtyKb != null) {
                var1.writeInt32(6, this.otherPrivateDirtyKb.intValue());
            }

            if(this.totalPrivateCleanKb != null) {
                var1.writeInt32(7, this.totalPrivateCleanKb.intValue());
            }

            if(this.totalSharedDirtyKb != null) {
                var1.writeInt32(8, this.totalSharedDirtyKb.intValue());
            }

            if(this.totalSwappablePssKb != null) {
                var1.writeInt32(9, this.totalSwappablePssKb.intValue());
            }

            if(this.otherGraphicsPssKb != null) {
                var1.writeInt32(10, this.otherGraphicsPssKb.intValue());
            }

            if(this.summaryJavaHeapKb != null) {
                var1.writeInt32(11, this.summaryJavaHeapKb.intValue());
            }

            if(this.summaryCodeKb != null) {
                var1.writeInt32(12, this.summaryCodeKb.intValue());
            }

            if(this.summaryStackKb != null) {
                var1.writeInt32(13, this.summaryStackKb.intValue());
            }

            if(this.summaryGraphicsKb != null) {
                var1.writeInt32(14, this.summaryGraphicsKb.intValue());
            }

            if(this.summaryPrivateOtherKb != null) {
                var1.writeInt32(15, this.summaryPrivateOtherKb.intValue());
            }

            if(this.summarySystemKb != null) {
                var1.writeInt32(16, this.summarySystemKb.intValue());
            }

            if(this.availableMemoryKb != null) {
                var1.writeInt32(17, this.availableMemoryKb.intValue());
            }

            if(this.totalMemoryMb != null) {
                var1.writeInt32(18, this.totalMemoryMb.intValue());
            }

            super.writeTo(var1);
        }

        protected final int computeSerializedSize() {
            int var1 = super.computeSerializedSize();
            if(this.dalvikPssKb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(1, this.dalvikPssKb.intValue());
            }

            if(this.nativePssKb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(2, this.nativePssKb.intValue());
            }

            if(this.otherPssKb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(3, this.otherPssKb.intValue());
            }

            if(this.dalvikPrivateDirtyKb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(4, this.dalvikPrivateDirtyKb.intValue());
            }

            if(this.nativePrivateDirtyKb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(5, this.nativePrivateDirtyKb.intValue());
            }

            if(this.otherPrivateDirtyKb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(6, this.otherPrivateDirtyKb.intValue());
            }

            if(this.totalPrivateCleanKb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(7, this.totalPrivateCleanKb.intValue());
            }

            if(this.totalSharedDirtyKb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(8, this.totalSharedDirtyKb.intValue());
            }

            if(this.totalSwappablePssKb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(9, this.totalSwappablePssKb.intValue());
            }

            if(this.otherGraphicsPssKb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(10, this.otherGraphicsPssKb.intValue());
            }

            if(this.summaryJavaHeapKb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(11, this.summaryJavaHeapKb.intValue());
            }

            if(this.summaryCodeKb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(12, this.summaryCodeKb.intValue());
            }

            if(this.summaryStackKb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(13, this.summaryStackKb.intValue());
            }

            if(this.summaryGraphicsKb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(14, this.summaryGraphicsKb.intValue());
            }

            if(this.summaryPrivateOtherKb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(15, this.summaryPrivateOtherKb.intValue());
            }

            if(this.summarySystemKb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(16, this.summarySystemKb.intValue());
            }

            if(this.availableMemoryKb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(17, this.availableMemoryKb.intValue());
            }

            if(this.totalMemoryMb != null) {
                var1 += CodedOutputByteBufferNano.computeInt32Size(18, this.totalMemoryMb.intValue());
            }

            return var1;
        }

        @Override
        public MessageNano mergeFrom(CodedInputByteBufferNano input) throws IOException {
            return null;
        }
    }

}
