/*     */ package com.google.vrtoolkit.cardboard.proto.nano;
/*     */ 
/*     */ import com.google.protobuf.nano.CodedInputByteBufferNano;
/*     */ 
/*     */ public abstract interface Session {
/*     */   public static final class TrackerState extends com.google.protobuf.nano.ExtendableMessageNano<TrackerState> implements Cloneable {
/*     */     private static volatile TrackerState[] _emptyArray;
/*     */     private int bitField0_;
/*     */     public double[] q;
/*     */     private long timeSinceEpochSeconds_;
/*     */     public double[] gyroscopeBias;
/*     */     public float[] lensOffset;
/*     */     public double[] lastGyroscopeSample;
/*     */     private double lastGyroscopeTimestamp_;
/*     */     
/*  16 */     public static TrackerState[] emptyArray() { if (_emptyArray == null) {
/*  17 */         synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK)
/*     */         {
/*  19 */           if (_emptyArray == null) {
/*  20 */             _emptyArray = new TrackerState[0];
/*     */           }
/*     */         }
/*     */       }
/*  24 */       return _emptyArray;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  35 */     public final long getTimeSinceEpochSeconds() { return this.timeSinceEpochSeconds_; }
/*     */     
/*     */     public final TrackerState setTimeSinceEpochSeconds(long paramLong) {
/*  38 */       this.timeSinceEpochSeconds_ = paramLong;
/*  39 */       this.bitField0_ |= 0x1;
/*  40 */       return this;
/*     */     }
/*     */     
/*  43 */     public final boolean hasTimeSinceEpochSeconds() { return (this.bitField0_ & 0x1) != 0; }
/*     */     
/*     */     public final TrackerState clearTimeSinceEpochSeconds() {
/*  46 */       this.timeSinceEpochSeconds_ = 0L;
/*  47 */       this.bitField0_ &= 0xFFFFFFFE;
/*  48 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  63 */     public final double getLastGyroscopeTimestamp() { return this.lastGyroscopeTimestamp_; }
/*     */     
/*     */     public final TrackerState setLastGyroscopeTimestamp(double paramDouble) {
/*  66 */       this.lastGyroscopeTimestamp_ = paramDouble;
/*  67 */       this.bitField0_ |= 0x2;
/*  68 */       return this;
/*     */     }
/*     */     
/*  71 */     public final boolean hasLastGyroscopeTimestamp() { return (this.bitField0_ & 0x2) != 0; }
/*     */     
/*     */     public final TrackerState clearLastGyroscopeTimestamp() {
/*  74 */       this.lastGyroscopeTimestamp_ = 0.0D;
/*  75 */       this.bitField0_ &= 0xFFFFFFFD;
/*  76 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public TrackerState()
/*     */     {
/*  82 */       clear();
/*     */     }
/*     */     
/*     */     public final TrackerState clear() {
/*  86 */       this.bitField0_ = 0;
/*  87 */       this.q = com.google.protobuf.nano.WireFormatNano.EMPTY_DOUBLE_ARRAY;
/*  88 */       this.timeSinceEpochSeconds_ = 0L;
/*  89 */       this.gyroscopeBias = com.google.protobuf.nano.WireFormatNano.EMPTY_DOUBLE_ARRAY;
/*  90 */       this.lensOffset = com.google.protobuf.nano.WireFormatNano.EMPTY_FLOAT_ARRAY;
/*  91 */       this.lastGyroscopeSample = com.google.protobuf.nano.WireFormatNano.EMPTY_DOUBLE_ARRAY;
/*  92 */       this.lastGyroscopeTimestamp_ = 0.0D;
/*  93 */       this.unknownFieldData = null;
/*  94 */       this.cachedSize = -1;
/*  95 */       return this;
/*     */     }
/*     */     
/*     */     public final TrackerState clone() {
/*     */       TrackerState localTrackerState;
/*     */       try {
/* 101 */         localTrackerState = (TrackerState)super.clone();
/*     */       } catch (CloneNotSupportedException localCloneNotSupportedException) {
/* 103 */         throw new AssertionError(localCloneNotSupportedException);
/*     */       }
/* 105 */       if ((this.q != null) && (this.q.length > 0)) {
/* 106 */         localTrackerState.q = ((double[])this.q.clone());
/*     */       }
/* 108 */       if ((this.gyroscopeBias != null) && (this.gyroscopeBias.length > 0)) {
/* 109 */         localTrackerState.gyroscopeBias = ((double[])this.gyroscopeBias.clone());
/*     */       }
/* 111 */       if ((this.lensOffset != null) && (this.lensOffset.length > 0)) {
/* 112 */         localTrackerState.lensOffset = ((float[])this.lensOffset.clone());
/*     */       }
/* 114 */       if ((this.lastGyroscopeSample != null) && (this.lastGyroscopeSample.length > 0)) {
/* 115 */         localTrackerState.lastGyroscopeSample = ((double[])this.lastGyroscopeSample.clone());
/*     */       }
/* 117 */       return localTrackerState;
/*     */     }
/*     */     
/*     */     public final void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano paramCodedOutputByteBufferNano) throws java.io.IOException
/*     */     {
/*     */       int i;
/*     */       int j;
/* 124 */       if ((this.q != null) && (this.q.length > 0)) {
/* 125 */         i = 8 * this.q.length;
/* 126 */         paramCodedOutputByteBufferNano.writeRawVarint32(10);
/* 127 */         paramCodedOutputByteBufferNano.writeRawVarint32(i);
/* 128 */         for (j = 0; j < this.q.length; j++) {
/* 129 */           paramCodedOutputByteBufferNano.writeDoubleNoTag(this.q[j]);
/*     */         }
/*     */       }
/* 132 */       if ((this.bitField0_ & 0x1) != 0) {
/* 133 */         paramCodedOutputByteBufferNano.writeInt64(2, this.timeSinceEpochSeconds_);
/*     */       }
/* 135 */       if ((this.gyroscopeBias != null) && (this.gyroscopeBias.length > 0)) {
/* 136 */         i = 8 * this.gyroscopeBias.length;
/* 137 */         paramCodedOutputByteBufferNano.writeRawVarint32(26);
/* 138 */         paramCodedOutputByteBufferNano.writeRawVarint32(i);
/* 139 */         for (j = 0; j < this.gyroscopeBias.length; j++) {
/* 140 */           paramCodedOutputByteBufferNano.writeDoubleNoTag(this.gyroscopeBias[j]);
/*     */         }
/*     */       }
/* 143 */       if ((this.lensOffset != null) && (this.lensOffset.length > 0)) {
/* 144 */         i = 4 * this.lensOffset.length;
/* 145 */         paramCodedOutputByteBufferNano.writeRawVarint32(34);
/* 146 */         paramCodedOutputByteBufferNano.writeRawVarint32(i);
/* 147 */         for (j = 0; j < this.lensOffset.length; j++) {
/* 148 */           paramCodedOutputByteBufferNano.writeFloatNoTag(this.lensOffset[j]);
/*     */         }
/*     */       }
/* 151 */       if ((this.lastGyroscopeSample != null) && (this.lastGyroscopeSample.length > 0)) {
/* 152 */         i = 8 * this.lastGyroscopeSample.length;
/* 153 */         paramCodedOutputByteBufferNano.writeRawVarint32(42);
/* 154 */         paramCodedOutputByteBufferNano.writeRawVarint32(i);
/* 155 */         for (j = 0; j < this.lastGyroscopeSample.length; j++) {
/* 156 */           paramCodedOutputByteBufferNano.writeDoubleNoTag(this.lastGyroscopeSample[j]);
/*     */         }
/*     */       }
/* 159 */       if ((this.bitField0_ & 0x2) != 0) {
/* 160 */         paramCodedOutputByteBufferNano.writeDouble(6, this.lastGyroscopeTimestamp_);
/*     */       }
/* 162 */       super.writeTo(paramCodedOutputByteBufferNano);
/*     */     }
/*     */     
/*     */     protected final int computeSerializedSize()
/*     */     {
/* 167 */       int i = super.computeSerializedSize();
/* 168 */       int j; if ((this.q != null) && (this.q.length > 0)) {
/* 169 */         j = 8 * this.q.length;
/* 170 */         i += j;
/* 171 */         i++;
/*     */         
/* 173 */         i = i + com.google.protobuf.nano.CodedOutputByteBufferNano.computeRawVarint32Size(j);
/*     */       }
/* 175 */       if ((this.bitField0_ & 0x1) != 0)
/*     */       {
/* 177 */         i = i + com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt64Size(2, this.timeSinceEpochSeconds_);
/*     */       }
/* 179 */       if ((this.gyroscopeBias != null) && (this.gyroscopeBias.length > 0)) {
/* 180 */         j = 8 * this.gyroscopeBias.length;
/* 181 */         i += j;
/* 182 */         i++;
/*     */         
/* 184 */         i = i + com.google.protobuf.nano.CodedOutputByteBufferNano.computeRawVarint32Size(j);
/*     */       }
/* 186 */       if ((this.lensOffset != null) && (this.lensOffset.length > 0)) {
/* 187 */         j = 4 * this.lensOffset.length;
/* 188 */         i += j;
/* 189 */         i++;
/*     */         
/* 191 */         i = i + com.google.protobuf.nano.CodedOutputByteBufferNano.computeRawVarint32Size(j);
/*     */       }
/* 193 */       if ((this.lastGyroscopeSample != null) && (this.lastGyroscopeSample.length > 0)) {
/* 194 */         j = 8 * this.lastGyroscopeSample.length;
/* 195 */         i += j;
/* 196 */         i++;
/*     */         
/* 198 */         i = i + com.google.protobuf.nano.CodedOutputByteBufferNano.computeRawVarint32Size(j);
/*     */       }
/* 200 */       if ((this.bitField0_ & 0x2) != 0)
/*     */       {
/* 202 */         i = i + com.google.protobuf.nano.CodedOutputByteBufferNano.computeDoubleSize(6, this.lastGyroscopeTimestamp_);
/*     */       }
/* 204 */       return i;
/*     */     }
/*     */     
/*     */     public final TrackerState mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano) throws java.io.IOException {
/*     */       for (;;) { int i;
/*     */         int j;
/*     */         int k;
/*     */         int i3;
/*     */         Object localObject;
/* 213 */         switch (i = paramCodedInputByteBufferNano.readTag())
/*     */         {
/*     */         case 0: 
/* 215 */           return this;
/*     */         default: 
/* 217 */           if (!super.storeUnknownField(paramCodedInputByteBufferNano, i)) {
/* 218 */             return this;
/*     */           }
/*     */           
/*     */ 
/*     */           break;
/*     */         case 9: 
/* 224 */           j = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 9);
/*     */           
/* 226 */           double[] arrayOfDouble1 = new double[(k = this.q == null ? 0 : this.q.length) + j];
/* 227 */           if (k != 0) {
/* 228 */             System.arraycopy(this.q, 0, arrayOfDouble1, 0, k);
/*     */           }
/* 230 */           for (; k < arrayOfDouble1.length - 1; k++) {
/* 231 */             arrayOfDouble1[k] = paramCodedInputByteBufferNano.readDouble();
/* 232 */             paramCodedInputByteBufferNano.readTag();
/*     */           }
/*     */           
/* 235 */           arrayOfDouble1[k] = paramCodedInputByteBufferNano.readDouble();
/* 236 */           this.q = arrayOfDouble1;
/* 237 */           break;
/*     */         
/*     */         case 10: 
/* 240 */           j = paramCodedInputByteBufferNano.readRawVarint32();
/* 241 */           k = paramCodedInputByteBufferNano.pushLimit(j);
/* 242 */           int m = j / 8;
/*     */           
/* 244 */           localObject = new double[(i3 = this.q == null ? 0 : this.q.length) + m];
/* 245 */           if (i3 != 0) {
/* 246 */             System.arraycopy(this.q, 0, localObject, 0, i3);
/*     */           }
/* 248 */           for (; i3 < localObject.length; i3++) {
/* 249 */             localObject[i3] = paramCodedInputByteBufferNano.readDouble();
/*     */           }
/* 251 */           this.q = ((double[])localObject);
/* 252 */           paramCodedInputByteBufferNano.popLimit(k);
/* 253 */           break;
/*     */         
/*     */         case 16: 
/* 256 */           this.timeSinceEpochSeconds_ = paramCodedInputByteBufferNano.readInt64();
/* 257 */           this.bitField0_ |= 0x1;
/* 258 */           break;
/*     */         
/*     */ 
/*     */         case 25: 
/* 262 */           j = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 25);
/*     */           
/* 264 */           double[] arrayOfDouble2 = new double[(k = this.gyroscopeBias == null ? 0 : this.gyroscopeBias.length) + j];
/* 265 */           if (k != 0) {
/* 266 */             System.arraycopy(this.gyroscopeBias, 0, arrayOfDouble2, 0, k);
/*     */           }
/* 268 */           for (; k < arrayOfDouble2.length - 1; k++) {
/* 269 */             arrayOfDouble2[k] = paramCodedInputByteBufferNano.readDouble();
/* 270 */             paramCodedInputByteBufferNano.readTag();
/*     */           }
/*     */           
/* 273 */           arrayOfDouble2[k] = paramCodedInputByteBufferNano.readDouble();
/* 274 */           this.gyroscopeBias = arrayOfDouble2;
/* 275 */           break;
/*     */         
/*     */         case 26: 
/* 278 */           j = paramCodedInputByteBufferNano.readRawVarint32();
/* 279 */           k = paramCodedInputByteBufferNano.pushLimit(j);
/* 280 */           int n = j / 8;
/*     */           
/* 282 */           localObject = new double[(i3 = this.gyroscopeBias == null ? 0 : this.gyroscopeBias.length) + n];
/* 283 */           if (i3 != 0) {
/* 284 */             System.arraycopy(this.gyroscopeBias, 0, localObject, 0, i3);
/*     */           }
/* 286 */           for (; i3 < localObject.length; i3++) {
/* 287 */             localObject[i3] = paramCodedInputByteBufferNano.readDouble();
/*     */           }
/* 289 */           this.gyroscopeBias = ((double[])localObject);
/* 290 */           paramCodedInputByteBufferNano.popLimit(k);
/* 291 */           break;
/*     */         
/*     */ 
/*     */         case 37: 
/* 295 */           j = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 37);
/*     */           
/* 297 */           float[] arrayOfFloat = new float[(k = this.lensOffset == null ? 0 : this.lensOffset.length) + j];
/* 298 */           if (k != 0) {
/* 299 */             System.arraycopy(this.lensOffset, 0, arrayOfFloat, 0, k);
/*     */           }
/* 301 */           for (; k < arrayOfFloat.length - 1; k++) {
/* 302 */             arrayOfFloat[k] = paramCodedInputByteBufferNano.readFloat();
/* 303 */             paramCodedInputByteBufferNano.readTag();
/*     */           }
/*     */           
/* 306 */           arrayOfFloat[k] = paramCodedInputByteBufferNano.readFloat();
/* 307 */           this.lensOffset = arrayOfFloat;
/* 308 */           break;
/*     */         
/*     */         case 34: 
/* 311 */           j = paramCodedInputByteBufferNano.readRawVarint32();
/* 312 */           k = paramCodedInputByteBufferNano.pushLimit(j);
/* 313 */           int i1 = j / 4;
/*     */           
/* 315 */           localObject = new float[(i3 = this.lensOffset == null ? 0 : this.lensOffset.length) + i1];
/* 316 */           if (i3 != 0) {
/* 317 */             System.arraycopy(this.lensOffset, 0, localObject, 0, i3);
/*     */           }
/* 319 */           for (; i3 < localObject.length; i3++) {
/* 320 */             localObject[i3] = paramCodedInputByteBufferNano.readFloat();
/*     */           }
/* 322 */           this.lensOffset = ((float[])localObject);
/* 323 */           paramCodedInputByteBufferNano.popLimit(k);
/* 324 */           break;
/*     */         
/*     */ 
/*     */         case 41: 
/* 328 */           j = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 41);
/*     */           
/* 330 */           double[] arrayOfDouble3 = new double[(k = this.lastGyroscopeSample == null ? 0 : this.lastGyroscopeSample.length) + j];
/* 331 */           if (k != 0) {
/* 332 */             System.arraycopy(this.lastGyroscopeSample, 0, arrayOfDouble3, 0, k);
/*     */           }
/* 334 */           for (; k < arrayOfDouble3.length - 1; k++) {
/* 335 */             arrayOfDouble3[k] = paramCodedInputByteBufferNano.readDouble();
/* 336 */             paramCodedInputByteBufferNano.readTag();
/*     */           }
/*     */           
/* 339 */           arrayOfDouble3[k] = paramCodedInputByteBufferNano.readDouble();
/* 340 */           this.lastGyroscopeSample = arrayOfDouble3;
/* 341 */           break;
/*     */         
/*     */         case 42: 
/* 344 */           j = paramCodedInputByteBufferNano.readRawVarint32();
/* 345 */           k = paramCodedInputByteBufferNano.pushLimit(j);
/* 346 */           int i2 = j / 8;
/*     */           
/* 348 */           localObject = new double[(i3 = this.lastGyroscopeSample == null ? 0 : this.lastGyroscopeSample.length) + i2];
/* 349 */           if (i3 != 0) {
/* 350 */             System.arraycopy(this.lastGyroscopeSample, 0, localObject, 0, i3);
/*     */           }
/* 352 */           for (; i3 < localObject.length; i3++) {
/* 353 */             localObject[i3] = paramCodedInputByteBufferNano.readDouble();
/*     */           }
/* 355 */           this.lastGyroscopeSample = ((double[])localObject);
/* 356 */           paramCodedInputByteBufferNano.popLimit(k);
/* 357 */           break;
/*     */         
/*     */         case 49: 
/* 360 */           this.lastGyroscopeTimestamp_ = paramCodedInputByteBufferNano.readDouble();
/* 361 */           this.bitField0_ |= 0x2;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     
/*     */     public static TrackerState parseFrom(byte[] paramArrayOfByte)
/*     */       throws com.google.protobuf.nano.InvalidProtocolBufferNanoException
/*     */     {
/* 370 */       return (TrackerState)com.google.protobuf.nano.MessageNano.mergeFrom(new TrackerState(), paramArrayOfByte);
/*     */     }
/*     */     
/*     */     public static TrackerState parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
/*     */       throws java.io.IOException
/*     */     {
/* 376 */       return new TrackerState().mergeFrom(paramCodedInputByteBufferNano);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vrtoolkit\cardboard\proto\nano\Session.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */