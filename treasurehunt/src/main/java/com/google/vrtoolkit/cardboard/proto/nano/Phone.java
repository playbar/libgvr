/*     */ package com.google.vrtoolkit.cardboard.proto.nano;
/*     */ 
/*     */ import com.google.protobuf.nano.CodedInputByteBufferNano;
/*     */ 
/*     */ public abstract interface Phone
/*     */ {
/*     */   public static final class PhoneParams extends com.google.protobuf.nano.ExtendableMessageNano<PhoneParams> implements Cloneable {
/*     */     private static volatile PhoneParams[] _emptyArray;
/*     */     private int bitField0_;
/*     */     private float xPpi_;
/*     */     private float yPpi_;
/*     */     private float bottomBezelHeight_;
/*     */     public float[] dEPRECATEDGyroBias;
/*     */     
/*     */     public static PhoneParams[] emptyArray() {
/*  16 */       if (_emptyArray == null) {
/*  17 */         synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK)
/*     */         {
/*  19 */           if (_emptyArray == null) {
/*  20 */             _emptyArray = new PhoneParams[0];
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
/*  32 */     public final float getXPpi() { return this.xPpi_; }
/*     */     
/*     */     public final PhoneParams setXPpi(float paramFloat) {
/*  35 */       this.xPpi_ = paramFloat;
/*  36 */       this.bitField0_ |= 0x1;
/*  37 */       return this;
/*     */     }
/*     */     
/*  40 */     public final boolean hasXPpi() { return (this.bitField0_ & 0x1) != 0; }
/*     */     
/*     */     public final PhoneParams clearXPpi() {
/*  43 */       this.xPpi_ = 0.0F;
/*  44 */       this.bitField0_ &= 0xFFFFFFFE;
/*  45 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  51 */     public final float getYPpi() { return this.yPpi_; }
/*     */     
/*     */     public final PhoneParams setYPpi(float paramFloat) {
/*  54 */       this.yPpi_ = paramFloat;
/*  55 */       this.bitField0_ |= 0x2;
/*  56 */       return this;
/*     */     }
/*     */     
/*  59 */     public final boolean hasYPpi() { return (this.bitField0_ & 0x2) != 0; }
/*     */     
/*     */     public final PhoneParams clearYPpi() {
/*  62 */       this.yPpi_ = 0.0F;
/*  63 */       this.bitField0_ &= 0xFFFFFFFD;
/*  64 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  70 */     public final float getBottomBezelHeight() { return this.bottomBezelHeight_; }
/*     */     
/*     */     public final PhoneParams setBottomBezelHeight(float paramFloat) {
/*  73 */       this.bottomBezelHeight_ = paramFloat;
/*  74 */       this.bitField0_ |= 0x4;
/*  75 */       return this;
/*     */     }
/*     */     
/*  78 */     public final boolean hasBottomBezelHeight() { return (this.bitField0_ & 0x4) != 0; }
/*     */     
/*     */     public final PhoneParams clearBottomBezelHeight() {
/*  81 */       this.bottomBezelHeight_ = 0.0F;
/*  82 */       this.bitField0_ &= 0xFFFFFFFB;
/*  83 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public PhoneParams()
/*     */     {
/*  92 */       clear();
/*     */     }
/*     */     
/*     */     public final PhoneParams clear() {
/*  96 */       this.bitField0_ = 0;
/*  97 */       this.xPpi_ = 0.0F;
/*  98 */       this.yPpi_ = 0.0F;
/*  99 */       this.bottomBezelHeight_ = 0.0F;
/* 100 */       this.dEPRECATEDGyroBias = com.google.protobuf.nano.WireFormatNano.EMPTY_FLOAT_ARRAY;
/* 101 */       this.unknownFieldData = null;
/* 102 */       this.cachedSize = -1;
/* 103 */       return this;
/*     */     }
/*     */     
/*     */     public final PhoneParams clone() {
/*     */       PhoneParams localPhoneParams;
/*     */       try {
/* 109 */         localPhoneParams = (PhoneParams)super.clone();
/*     */       } catch (CloneNotSupportedException localCloneNotSupportedException) {
/* 111 */         throw new AssertionError(localCloneNotSupportedException);
/*     */       }
/* 113 */       if ((this.dEPRECATEDGyroBias != null) && (this.dEPRECATEDGyroBias.length > 0)) {
/* 114 */         localPhoneParams.dEPRECATEDGyroBias = ((float[])this.dEPRECATEDGyroBias.clone());
/*     */       }
/* 116 */       return localPhoneParams;
/*     */     }
/*     */     
/*     */ 
/*     */     public final void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
/*     */       throws java.io.IOException
/*     */     {
/* 123 */       if ((this.bitField0_ & 0x1) != 0) {
/* 124 */         paramCodedOutputByteBufferNano.writeFloat(1, this.xPpi_);
/*     */       }
/* 126 */       if ((this.bitField0_ & 0x2) != 0) {
/* 127 */         paramCodedOutputByteBufferNano.writeFloat(2, this.yPpi_);
/*     */       }
/* 129 */       if ((this.bitField0_ & 0x4) != 0) {
/* 130 */         paramCodedOutputByteBufferNano.writeFloat(3, this.bottomBezelHeight_);
/*     */       }
/* 132 */       if ((this.dEPRECATEDGyroBias != null) && (this.dEPRECATEDGyroBias.length > 0)) {
/* 133 */         int i = 4 * this.dEPRECATEDGyroBias.length;
/* 134 */         paramCodedOutputByteBufferNano.writeRawVarint32(34);
/* 135 */         paramCodedOutputByteBufferNano.writeRawVarint32(i);
/* 136 */         for (int j = 0; j < this.dEPRECATEDGyroBias.length; j++) {
/* 137 */           paramCodedOutputByteBufferNano.writeFloatNoTag(this.dEPRECATEDGyroBias[j]);
/*     */         }
/*     */       }
/* 140 */       super.writeTo(paramCodedOutputByteBufferNano);
/*     */     }
/*     */     
/*     */     protected final int computeSerializedSize()
/*     */     {
/* 145 */       int i = super.computeSerializedSize();
/* 146 */       if ((this.bitField0_ & 0x1) != 0)
/*     */       {
/* 148 */         i = i + com.google.protobuf.nano.CodedOutputByteBufferNano.computeFloatSize(1, this.xPpi_);
/*     */       }
/* 150 */       if ((this.bitField0_ & 0x2) != 0)
/*     */       {
/* 152 */         i = i + com.google.protobuf.nano.CodedOutputByteBufferNano.computeFloatSize(2, this.yPpi_);
/*     */       }
/* 154 */       if ((this.bitField0_ & 0x4) != 0)
/*     */       {
/* 156 */         i = i + com.google.protobuf.nano.CodedOutputByteBufferNano.computeFloatSize(3, this.bottomBezelHeight_);
/*     */       }
/* 158 */       if ((this.dEPRECATEDGyroBias != null) && (this.dEPRECATEDGyroBias.length > 0)) {
/* 159 */         int j = 4 * this.dEPRECATEDGyroBias.length;
/* 160 */         i += j;
/* 161 */         i++;
/*     */         
/* 163 */         i = i + com.google.protobuf.nano.CodedOutputByteBufferNano.computeRawVarint32Size(j);
/*     */       }
/* 165 */       return i;
/*     */     }
/*     */     
/*     */     public final PhoneParams mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano) throws java.io.IOException
/*     */     {
/*     */       for (;;) {
/*     */         int i;
/*     */         int j;
/*     */         int k;
/* 174 */         switch (i = paramCodedInputByteBufferNano.readTag())
/*     */         {
/*     */         case 0: 
/* 176 */           return this;
/*     */         default: 
/* 178 */           if (!super.storeUnknownField(paramCodedInputByteBufferNano, i)) {
/* 179 */             return this;
/*     */           }
/*     */           
/*     */           break;
/*     */         case 13: 
/* 184 */           this.xPpi_ = paramCodedInputByteBufferNano.readFloat();
/* 185 */           this.bitField0_ |= 0x1;
/* 186 */           break;
/*     */         
/*     */         case 21: 
/* 189 */           this.yPpi_ = paramCodedInputByteBufferNano.readFloat();
/* 190 */           this.bitField0_ |= 0x2;
/* 191 */           break;
/*     */         
/*     */         case 29: 
/* 194 */           this.bottomBezelHeight_ = paramCodedInputByteBufferNano.readFloat();
/* 195 */           this.bitField0_ |= 0x4;
/* 196 */           break;
/*     */         
/*     */ 
/*     */         case 37: 
/* 200 */           j = com.google.protobuf.nano.WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 37);
/*     */           
/* 202 */           float[] arrayOfFloat1 = new float[(k = this.dEPRECATEDGyroBias == null ? 0 : this.dEPRECATEDGyroBias.length) + j];
/* 203 */           if (k != 0) {
/* 204 */             System.arraycopy(this.dEPRECATEDGyroBias, 0, arrayOfFloat1, 0, k);
/*     */           }
/* 206 */           for (; k < arrayOfFloat1.length - 1; k++) {
/* 207 */             arrayOfFloat1[k] = paramCodedInputByteBufferNano.readFloat();
/* 208 */             paramCodedInputByteBufferNano.readTag();
/*     */           }
/*     */           
/* 211 */           arrayOfFloat1[k] = paramCodedInputByteBufferNano.readFloat();
/* 212 */           this.dEPRECATEDGyroBias = arrayOfFloat1;
/* 213 */           break;
/*     */         
/*     */         case 34: 
/* 216 */           j = paramCodedInputByteBufferNano.readRawVarint32();
/* 217 */           k = paramCodedInputByteBufferNano.pushLimit(j);
/* 218 */           int m = j / 4;
/*     */           int n;
/* 220 */           float[] arrayOfFloat2 = new float[(n = this.dEPRECATEDGyroBias == null ? 0 : this.dEPRECATEDGyroBias.length) + m];
/* 221 */           if (n != 0) {
/* 222 */             System.arraycopy(this.dEPRECATEDGyroBias, 0, arrayOfFloat2, 0, n);
/*     */           }
/* 224 */           for (; n < arrayOfFloat2.length; n++) {
/* 225 */             arrayOfFloat2[n] = paramCodedInputByteBufferNano.readFloat();
/*     */           }
/* 227 */           this.dEPRECATEDGyroBias = arrayOfFloat2;
/* 228 */           paramCodedInputByteBufferNano.popLimit(k);
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     
/*     */     public static PhoneParams parseFrom(byte[] paramArrayOfByte)
/*     */       throws com.google.protobuf.nano.InvalidProtocolBufferNanoException
/*     */     {
/* 237 */       return (PhoneParams)com.google.protobuf.nano.MessageNano.mergeFrom(new PhoneParams(), paramArrayOfByte);
/*     */     }
/*     */     
/*     */     public static PhoneParams parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
/*     */       throws java.io.IOException
/*     */     {
/* 243 */       return new PhoneParams().mergeFrom(paramCodedInputByteBufferNano);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vrtoolkit\cardboard\proto\nano\Phone.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */