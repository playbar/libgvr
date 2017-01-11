/*      */ package com.google.vrtoolkit.cardboard.proto.nano;
/*      */ 
/*      */ import com.google.protobuf.nano.CodedInputByteBufferNano;
/*      */ import com.google.protobuf.nano.CodedOutputByteBufferNano;
/*      */ import com.google.protobuf.nano.ExtendableMessageNano;
/*      */ import com.google.protobuf.nano.MessageNano;
/*      */ import com.google.protobuf.nano.WireFormatNano;
/*      */ import java.io.IOException;
/*      */ 
/*      */ public abstract interface CardboardDevice
/*      */ {
/*      */   public static final class DeviceParams extends ExtendableMessageNano<DeviceParams> implements Cloneable
/*      */   {
/*      */     private static volatile DeviceParams[] _emptyArray;
/*      */     private int bitField0_;
/*      */     private String vendor_;
/*      */     private String model_;
/*      */     private float screenToLensDistance_;
/*      */     private float interLensDistance_;
/*      */     public float[] leftEyeFieldOfViewAngles;
/*      */     private int verticalAlignment_;
/*      */     private float trayToLensDistance_;
/*      */     public float[] distortionCoefficients;
/*      */     private boolean hasMagnet_;
/*      */     private int primaryButton_;
/*      */     public CardboardDevice.CardboardInternalParams internal;
/*      */     public CardboardDevice.DaydreamInternalParams daydreamInternal;
/*      */     
/*      */     public static DeviceParams[] emptyArray()
/*      */     {
/*   31 */       if (_emptyArray == null) {
/*   32 */         synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK)
/*      */         {
/*   34 */           if (_emptyArray == null) {
/*   35 */             _emptyArray = new DeviceParams[0];
/*      */           }
/*      */         }
/*      */       }
/*   39 */       return _emptyArray;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*   47 */     public final String getVendor() { return this.vendor_; }
/*      */     
/*      */     public final DeviceParams setVendor(String paramString) {
/*   50 */       if (paramString == null) {
/*   51 */         throw new NullPointerException();
/*      */       }
/*   53 */       this.vendor_ = paramString;
/*   54 */       this.bitField0_ |= 0x1;
/*   55 */       return this;
/*      */     }
/*      */     
/*   58 */     public final boolean hasVendor() { return (this.bitField0_ & 0x1) != 0; }
/*      */     
/*      */     public final DeviceParams clearVendor() {
/*   61 */       this.vendor_ = "";
/*   62 */       this.bitField0_ &= 0xFFFFFFFE;
/*   63 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*   69 */     public final String getModel() { return this.model_; }
/*      */     
/*      */     public final DeviceParams setModel(String paramString) {
/*   72 */       if (paramString == null) {
/*   73 */         throw new NullPointerException();
/*      */       }
/*   75 */       this.model_ = paramString;
/*   76 */       this.bitField0_ |= 0x2;
/*   77 */       return this;
/*      */     }
/*      */     
/*   80 */     public final boolean hasModel() { return (this.bitField0_ & 0x2) != 0; }
/*      */     
/*      */     public final DeviceParams clearModel() {
/*   83 */       this.model_ = "";
/*   84 */       this.bitField0_ &= 0xFFFFFFFD;
/*   85 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*   91 */     public final float getScreenToLensDistance() { return this.screenToLensDistance_; }
/*      */     
/*      */     public final DeviceParams setScreenToLensDistance(float paramFloat) {
/*   94 */       this.screenToLensDistance_ = paramFloat;
/*   95 */       this.bitField0_ |= 0x4;
/*   96 */       return this;
/*      */     }
/*      */     
/*   99 */     public final boolean hasScreenToLensDistance() { return (this.bitField0_ & 0x4) != 0; }
/*      */     
/*      */     public final DeviceParams clearScreenToLensDistance() {
/*  102 */       this.screenToLensDistance_ = 0.0F;
/*  103 */       this.bitField0_ &= 0xFFFFFFFB;
/*  104 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  110 */     public final float getInterLensDistance() { return this.interLensDistance_; }
/*      */     
/*      */     public final DeviceParams setInterLensDistance(float paramFloat) {
/*  113 */       this.interLensDistance_ = paramFloat;
/*  114 */       this.bitField0_ |= 0x8;
/*  115 */       return this;
/*      */     }
/*      */     
/*  118 */     public final boolean hasInterLensDistance() { return (this.bitField0_ & 0x8) != 0; }
/*      */     
/*      */     public final DeviceParams clearInterLensDistance() {
/*  121 */       this.interLensDistance_ = 0.0F;
/*  122 */       this.bitField0_ &= 0xFFFFFFF7;
/*  123 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  132 */     public final int getVerticalAlignment() { return this.verticalAlignment_; }
/*      */     
/*      */     public final DeviceParams setVerticalAlignment(int paramInt) {
/*  135 */       this.verticalAlignment_ = paramInt;
/*  136 */       this.bitField0_ |= 0x10;
/*  137 */       return this;
/*      */     }
/*      */     
/*  140 */     public final boolean hasVerticalAlignment() { return (this.bitField0_ & 0x10) != 0; }
/*      */     
/*      */     public final DeviceParams clearVerticalAlignment() {
/*  143 */       this.verticalAlignment_ = 0;
/*  144 */       this.bitField0_ &= 0xFFFFFFEF;
/*  145 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  151 */     public final float getTrayToLensDistance() { return this.trayToLensDistance_; }
/*      */     
/*      */     public final DeviceParams setTrayToLensDistance(float paramFloat) {
/*  154 */       this.trayToLensDistance_ = paramFloat;
/*  155 */       this.bitField0_ |= 0x20;
/*  156 */       return this;
/*      */     }
/*      */     
/*  159 */     public final boolean hasTrayToLensDistance() { return (this.bitField0_ & 0x20) != 0; }
/*      */     
/*      */     public final DeviceParams clearTrayToLensDistance() {
/*  162 */       this.trayToLensDistance_ = 0.0F;
/*  163 */       this.bitField0_ &= 0xFFFFFFDF;
/*  164 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  173 */     public final boolean getHasMagnet() { return this.hasMagnet_; }
/*      */     
/*      */     public final DeviceParams setHasMagnet(boolean paramBoolean) {
/*  176 */       this.hasMagnet_ = paramBoolean;
/*  177 */       this.bitField0_ |= 0x40;
/*  178 */       return this;
/*      */     }
/*      */     
/*  181 */     public final boolean hasHasMagnet() { return (this.bitField0_ & 0x40) != 0; }
/*      */     
/*      */     public final DeviceParams clearHasMagnet() {
/*  184 */       this.hasMagnet_ = false;
/*  185 */       this.bitField0_ &= 0xFFFFFFBF;
/*  186 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  192 */     public final int getPrimaryButton() { return this.primaryButton_; }
/*      */     
/*      */     public final DeviceParams setPrimaryButton(int paramInt) {
/*  195 */       this.primaryButton_ = paramInt;
/*  196 */       this.bitField0_ |= 0x80;
/*  197 */       return this;
/*      */     }
/*      */     
/*  200 */     public final boolean hasPrimaryButton() { return (this.bitField0_ & 0x80) != 0; }
/*      */     
/*      */     public final DeviceParams clearPrimaryButton() {
/*  203 */       this.primaryButton_ = 1;
/*  204 */       this.bitField0_ &= 0xFF7F;
/*  205 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public DeviceParams()
/*      */     {
/*  217 */       clear();
/*      */     }
/*      */     
/*      */     public final DeviceParams clear() {
/*  221 */       this.bitField0_ = 0;
/*  222 */       this.vendor_ = "";
/*  223 */       this.model_ = "";
/*  224 */       this.screenToLensDistance_ = 0.0F;
/*  225 */       this.interLensDistance_ = 0.0F;
/*  226 */       this.leftEyeFieldOfViewAngles = WireFormatNano.EMPTY_FLOAT_ARRAY;
/*  227 */       this.verticalAlignment_ = 0;
/*  228 */       this.trayToLensDistance_ = 0.0F;
/*  229 */       this.distortionCoefficients = WireFormatNano.EMPTY_FLOAT_ARRAY;
/*  230 */       this.hasMagnet_ = false;
/*  231 */       this.primaryButton_ = 1;
/*  232 */       this.internal = null;
/*  233 */       this.daydreamInternal = null;
/*  234 */       this.unknownFieldData = null;
/*  235 */       this.cachedSize = -1;
/*  236 */       return this;
/*      */     }
/*      */     
/*      */     public final DeviceParams clone() {
/*      */       DeviceParams localDeviceParams;
/*      */       try {
/*  242 */         localDeviceParams = (DeviceParams)super.clone();
/*      */       } catch (CloneNotSupportedException localCloneNotSupportedException) {
/*  244 */         throw new AssertionError(localCloneNotSupportedException);
/*      */       }
/*  246 */       if ((this.leftEyeFieldOfViewAngles != null) && (this.leftEyeFieldOfViewAngles.length > 0)) {
/*  247 */         localDeviceParams.leftEyeFieldOfViewAngles = ((float[])this.leftEyeFieldOfViewAngles.clone());
/*      */       }
/*  249 */       if ((this.distortionCoefficients != null) && (this.distortionCoefficients.length > 0)) {
/*  250 */         localDeviceParams.distortionCoefficients = ((float[])this.distortionCoefficients.clone());
/*      */       }
/*  252 */       if (this.internal != null) {
/*  253 */         localDeviceParams.internal = this.internal.clone();
/*      */       }
/*  255 */       if (this.daydreamInternal != null) {
/*  256 */         localDeviceParams.daydreamInternal = this.daydreamInternal.clone();
/*      */       }
/*  258 */       return localDeviceParams;
/*      */     }
/*      */     
/*      */ 
/*      */     public final void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
/*      */       throws IOException
/*      */     {
/*  265 */       if ((this.bitField0_ & 0x1) != 0) {
/*  266 */         paramCodedOutputByteBufferNano.writeString(1, this.vendor_);
/*      */       }
/*  268 */       if ((this.bitField0_ & 0x2) != 0) {
/*  269 */         paramCodedOutputByteBufferNano.writeString(2, this.model_);
/*      */       }
/*  271 */       if ((this.bitField0_ & 0x4) != 0) {
/*  272 */         paramCodedOutputByteBufferNano.writeFloat(3, this.screenToLensDistance_);
/*      */       }
/*  274 */       if ((this.bitField0_ & 0x8) != 0)
/*  275 */         paramCodedOutputByteBufferNano.writeFloat(4, this.interLensDistance_);
/*      */       int i;
/*  277 */       int j; if ((this.leftEyeFieldOfViewAngles != null) && (this.leftEyeFieldOfViewAngles.length > 0)) {
/*  278 */         i = 4 * this.leftEyeFieldOfViewAngles.length;
/*  279 */         paramCodedOutputByteBufferNano.writeRawVarint32(42);
/*  280 */         paramCodedOutputByteBufferNano.writeRawVarint32(i);
/*  281 */         for (j = 0; j < this.leftEyeFieldOfViewAngles.length; j++) {
/*  282 */           paramCodedOutputByteBufferNano.writeFloatNoTag(this.leftEyeFieldOfViewAngles[j]);
/*      */         }
/*      */       }
/*  285 */       if ((this.bitField0_ & 0x20) != 0) {
/*  286 */         paramCodedOutputByteBufferNano.writeFloat(6, this.trayToLensDistance_);
/*      */       }
/*  288 */       if ((this.distortionCoefficients != null) && (this.distortionCoefficients.length > 0)) {
/*  289 */         i = 4 * this.distortionCoefficients.length;
/*  290 */         paramCodedOutputByteBufferNano.writeRawVarint32(58);
/*  291 */         paramCodedOutputByteBufferNano.writeRawVarint32(i);
/*  292 */         for (j = 0; j < this.distortionCoefficients.length; j++) {
/*  293 */           paramCodedOutputByteBufferNano.writeFloatNoTag(this.distortionCoefficients[j]);
/*      */         }
/*      */       }
/*  296 */       if ((this.bitField0_ & 0x40) != 0) {
/*  297 */         paramCodedOutputByteBufferNano.writeBool(10, this.hasMagnet_);
/*      */       }
/*  299 */       if ((this.bitField0_ & 0x10) != 0) {
/*  300 */         paramCodedOutputByteBufferNano.writeInt32(11, this.verticalAlignment_);
/*      */       }
/*  302 */       if ((this.bitField0_ & 0x80) != 0) {
/*  303 */         paramCodedOutputByteBufferNano.writeInt32(12, this.primaryButton_);
/*      */       }
/*  305 */       if (this.internal != null) {
/*  306 */         paramCodedOutputByteBufferNano.writeMessage(1729, this.internal);
/*      */       }
/*  308 */       if (this.daydreamInternal != null) {
/*  309 */         paramCodedOutputByteBufferNano.writeMessage(196883, this.daydreamInternal);
/*      */       }
/*  311 */       super.writeTo(paramCodedOutputByteBufferNano);
/*      */     }
/*      */     
/*      */     protected final int computeSerializedSize()
/*      */     {
/*  316 */       int i = super.computeSerializedSize();
/*  317 */       if ((this.bitField0_ & 0x1) != 0)
/*      */       {
/*  319 */         i = i + CodedOutputByteBufferNano.computeStringSize(1, this.vendor_);
/*      */       }
/*  321 */       if ((this.bitField0_ & 0x2) != 0)
/*      */       {
/*  323 */         i = i + CodedOutputByteBufferNano.computeStringSize(2, this.model_);
/*      */       }
/*  325 */       if ((this.bitField0_ & 0x4) != 0)
/*      */       {
/*  327 */         i = i + CodedOutputByteBufferNano.computeFloatSize(3, this.screenToLensDistance_);
/*      */       }
/*  329 */       if ((this.bitField0_ & 0x8) != 0)
/*      */       {
/*  331 */         i = i + CodedOutputByteBufferNano.computeFloatSize(4, this.interLensDistance_); }
/*      */       int j;
/*  333 */       if ((this.leftEyeFieldOfViewAngles != null) && (this.leftEyeFieldOfViewAngles.length > 0)) {
/*  334 */         j = 4 * this.leftEyeFieldOfViewAngles.length;
/*  335 */         i += j;
/*  336 */         i++;
/*      */         
/*  338 */         i = i + CodedOutputByteBufferNano.computeRawVarint32Size(j);
/*      */       }
/*  340 */       if ((this.bitField0_ & 0x20) != 0)
/*      */       {
/*  342 */         i = i + CodedOutputByteBufferNano.computeFloatSize(6, this.trayToLensDistance_);
/*      */       }
/*  344 */       if ((this.distortionCoefficients != null) && (this.distortionCoefficients.length > 0)) {
/*  345 */         j = 4 * this.distortionCoefficients.length;
/*  346 */         i += j;
/*  347 */         i++;
/*      */         
/*  349 */         i = i + CodedOutputByteBufferNano.computeRawVarint32Size(j);
/*      */       }
/*  351 */       if ((this.bitField0_ & 0x40) != 0)
/*      */       {
/*  353 */         i = i + CodedOutputByteBufferNano.computeBoolSize(10, this.hasMagnet_);
/*      */       }
/*  355 */       if ((this.bitField0_ & 0x10) != 0)
/*      */       {
/*  357 */         i = i + CodedOutputByteBufferNano.computeInt32Size(11, this.verticalAlignment_);
/*      */       }
/*  359 */       if ((this.bitField0_ & 0x80) != 0)
/*      */       {
/*  361 */         i = i + CodedOutputByteBufferNano.computeInt32Size(12, this.primaryButton_);
/*      */       }
/*  363 */       if (this.internal != null)
/*      */       {
/*  365 */         i = i + CodedOutputByteBufferNano.computeMessageSize(1729, this.internal);
/*      */       }
/*  367 */       if (this.daydreamInternal != null)
/*      */       {
/*  369 */         i = i + CodedOutputByteBufferNano.computeMessageSize(196883, this.daydreamInternal);
/*      */       }
/*  371 */       return i;
/*      */     }
/*      */     
/*      */     public final DeviceParams mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano) throws IOException {
/*      */       for (;;) { int i;
/*      */         int j;
/*      */         int k;
/*      */         int i1;
/*      */         float[] arrayOfFloat3;
/*  380 */         switch (i = paramCodedInputByteBufferNano.readTag())
/*      */         {
/*      */         case 0: 
/*  382 */           return this;
/*      */         default: 
/*  384 */           if (!super.storeUnknownField(paramCodedInputByteBufferNano, i)) {
/*  385 */             return this;
/*      */           }
/*      */           
/*      */           break;
/*      */         case 10: 
/*  390 */           this.vendor_ = paramCodedInputByteBufferNano.readString();
/*  391 */           this.bitField0_ |= 0x1;
/*  392 */           break;
/*      */         
/*      */         case 18: 
/*  395 */           this.model_ = paramCodedInputByteBufferNano.readString();
/*  396 */           this.bitField0_ |= 0x2;
/*  397 */           break;
/*      */         
/*      */         case 29: 
/*  400 */           this.screenToLensDistance_ = paramCodedInputByteBufferNano.readFloat();
/*  401 */           this.bitField0_ |= 0x4;
/*  402 */           break;
/*      */         
/*      */         case 37: 
/*  405 */           this.interLensDistance_ = paramCodedInputByteBufferNano.readFloat();
/*  406 */           this.bitField0_ |= 0x8;
/*  407 */           break;
/*      */         
/*      */ 
/*      */         case 45: 
/*  411 */           j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 45);
/*      */           
/*  413 */           float[] arrayOfFloat1 = new float[(k = this.leftEyeFieldOfViewAngles == null ? 0 : this.leftEyeFieldOfViewAngles.length) + j];
/*  414 */           if (k != 0) {
/*  415 */             System.arraycopy(this.leftEyeFieldOfViewAngles, 0, arrayOfFloat1, 0, k);
/*      */           }
/*  417 */           for (; k < arrayOfFloat1.length - 1; k++) {
/*  418 */             arrayOfFloat1[k] = paramCodedInputByteBufferNano.readFloat();
/*  419 */             paramCodedInputByteBufferNano.readTag();
/*      */           }
/*      */           
/*  422 */           arrayOfFloat1[k] = paramCodedInputByteBufferNano.readFloat();
/*  423 */           this.leftEyeFieldOfViewAngles = arrayOfFloat1;
/*  424 */           break;
/*      */         
/*      */         case 42: 
/*  427 */           j = paramCodedInputByteBufferNano.readRawVarint32();
/*  428 */           k = paramCodedInputByteBufferNano.pushLimit(j);
/*  429 */           int m = j / 4;
/*      */           
/*  431 */           arrayOfFloat3 = new float[(i1 = this.leftEyeFieldOfViewAngles == null ? 0 : this.leftEyeFieldOfViewAngles.length) + m];
/*  432 */           if (i1 != 0) {
/*  433 */             System.arraycopy(this.leftEyeFieldOfViewAngles, 0, arrayOfFloat3, 0, i1);
/*      */           }
/*  435 */           for (; i1 < arrayOfFloat3.length; i1++) {
/*  436 */             arrayOfFloat3[i1] = paramCodedInputByteBufferNano.readFloat();
/*      */           }
/*  438 */           this.leftEyeFieldOfViewAngles = arrayOfFloat3;
/*  439 */           paramCodedInputByteBufferNano.popLimit(k);
/*  440 */           break;
/*      */         
/*      */         case 53: 
/*  443 */           this.trayToLensDistance_ = paramCodedInputByteBufferNano.readFloat();
/*  444 */           this.bitField0_ |= 0x20;
/*  445 */           break;
/*      */         
/*      */ 
/*      */         case 61: 
/*  449 */           j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 61);
/*      */           
/*  451 */           float[] arrayOfFloat2 = new float[(k = this.distortionCoefficients == null ? 0 : this.distortionCoefficients.length) + j];
/*  452 */           if (k != 0) {
/*  453 */             System.arraycopy(this.distortionCoefficients, 0, arrayOfFloat2, 0, k);
/*      */           }
/*  455 */           for (; k < arrayOfFloat2.length - 1; k++) {
/*  456 */             arrayOfFloat2[k] = paramCodedInputByteBufferNano.readFloat();
/*  457 */             paramCodedInputByteBufferNano.readTag();
/*      */           }
/*      */           
/*  460 */           arrayOfFloat2[k] = paramCodedInputByteBufferNano.readFloat();
/*  461 */           this.distortionCoefficients = arrayOfFloat2;
/*  462 */           break;
/*      */         
/*      */         case 58: 
/*  465 */           j = paramCodedInputByteBufferNano.readRawVarint32();
/*  466 */           k = paramCodedInputByteBufferNano.pushLimit(j);
/*  467 */           int n = j / 4;
/*      */           
/*  469 */           arrayOfFloat3 = new float[(i1 = this.distortionCoefficients == null ? 0 : this.distortionCoefficients.length) + n];
/*  470 */           if (i1 != 0) {
/*  471 */             System.arraycopy(this.distortionCoefficients, 0, arrayOfFloat3, 0, i1);
/*      */           }
/*  473 */           for (; i1 < arrayOfFloat3.length; i1++) {
/*  474 */             arrayOfFloat3[i1] = paramCodedInputByteBufferNano.readFloat();
/*      */           }
/*  476 */           this.distortionCoefficients = arrayOfFloat3;
/*  477 */           paramCodedInputByteBufferNano.popLimit(k);
/*  478 */           break;
/*      */         
/*      */         case 80: 
/*  481 */           this.hasMagnet_ = paramCodedInputByteBufferNano.readBool();
/*  482 */           this.bitField0_ |= 0x40;
/*  483 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  487 */           switch (j = paramCodedInputByteBufferNano.readInt32())
/*      */           {
/*      */           case 0: 
/*      */           case 1: 
/*      */           case 2: 
/*  491 */             this.verticalAlignment_ = j;
/*  492 */             this.bitField0_ |= 0x10;
/*      */           }
/*      */           
/*  495 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  499 */           switch (j = paramCodedInputByteBufferNano.readInt32())
/*      */           {
/*      */           case 0: 
/*      */           case 1: 
/*      */           case 2: 
/*      */           case 3: 
/*  504 */             this.primaryButton_ = j;
/*  505 */             this.bitField0_ |= 0x80;
/*      */           }
/*      */           
/*  508 */           break;
/*      */         
/*      */         case 13834: 
/*  511 */           if (this.internal == null) {
/*  512 */             this.internal = new CardboardDevice.CardboardInternalParams();
/*      */           }
/*  514 */           paramCodedInputByteBufferNano.readMessage(this.internal);
/*  515 */           break;
/*      */         
/*      */         case 1575066: 
/*  518 */           if (this.daydreamInternal == null) {
/*  519 */             this.daydreamInternal = new CardboardDevice.DaydreamInternalParams();
/*      */           }
/*  521 */           paramCodedInputByteBufferNano.readMessage(this.daydreamInternal);
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     
/*      */     public static DeviceParams parseFrom(byte[] paramArrayOfByte)
/*      */       throws com.google.protobuf.nano.InvalidProtocolBufferNanoException
/*      */     {
/*  530 */       return (DeviceParams)MessageNano.mergeFrom(new DeviceParams(), paramArrayOfByte);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  536 */     public static DeviceParams parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
/*  536 */       throws IOException { return new DeviceParams().mergeFrom(paramCodedInputByteBufferNano); }
/*      */     
/*      */     public static abstract interface ButtonType { public static final int NONE = 0;
/*      */       public static final int MAGNET = 1;
/*      */       public static final int TOUCH = 2;
/*      */       public static final int INDIRECT_TOUCH = 3;
/*      */     }
/*      */     
/*      */     public static abstract interface VerticalAlignmentType { public static final int BOTTOM = 0;
/*      */       public static final int CENTER = 1;
/*      */       public static final int TOP = 2;
/*      */     } }
/*      */   
/*      */   public static final class CardboardInternalParams extends ExtendableMessageNano<CardboardInternalParams> implements Cloneable { private static volatile CardboardInternalParams[] _emptyArray;
/*      */     private int bitField0_;
/*      */     public int[] eyeOrientations;
/*      */     private float screenCenterToLensDistance_;
/*      */     private float xPpiOverride_;
/*      */     private float yPpiOverride_;
/*      */     private String accelerometer_;
/*      */     private String gyroscope_;
/*      */     
/*  558 */     public static CardboardInternalParams[] emptyArray() { if (_emptyArray == null) {
/*  559 */         synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK)
/*      */         {
/*  561 */           if (_emptyArray == null) {
/*  562 */             _emptyArray = new CardboardInternalParams[0];
/*      */           }
/*      */         }
/*      */       }
/*  566 */       return _emptyArray; }
/*      */     
/*      */     public static abstract interface OrientationType { public static final int CCW_0_DEGREES = 0;
/*      */       public static final int CCW_90_DEGREES = 1;
/*      */       public static final int CCW_180_DEGREES = 2;
/*      */       public static final int CCW_270_DEGREES = 3;
/*      */       public static final int CCW_0_DEGREES_MIRRORED = 4;
/*      */       public static final int CCW_90_DEGREES_MIRRORED = 5;
/*      */       public static final int CCW_180_DEGREES_MIRRORED = 6;
/*      */       public static final int CCW_270_DEGREES_MIRRORED = 7; }
/*      */     
/*  577 */     public final float getScreenCenterToLensDistance() { return this.screenCenterToLensDistance_; }
/*      */     
/*      */     public final CardboardInternalParams setScreenCenterToLensDistance(float paramFloat) {
/*  580 */       this.screenCenterToLensDistance_ = paramFloat;
/*  581 */       this.bitField0_ |= 0x1;
/*  582 */       return this;
/*      */     }
/*      */     
/*  585 */     public final boolean hasScreenCenterToLensDistance() { return (this.bitField0_ & 0x1) != 0; }
/*      */     
/*      */     public final CardboardInternalParams clearScreenCenterToLensDistance() {
/*  588 */       this.screenCenterToLensDistance_ = 0.0F;
/*  589 */       this.bitField0_ &= 0xFFFFFFFE;
/*  590 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  596 */     public final float getXPpiOverride() { return this.xPpiOverride_; }
/*      */     
/*      */     public final CardboardInternalParams setXPpiOverride(float paramFloat) {
/*  599 */       this.xPpiOverride_ = paramFloat;
/*  600 */       this.bitField0_ |= 0x2;
/*  601 */       return this;
/*      */     }
/*      */     
/*  604 */     public final boolean hasXPpiOverride() { return (this.bitField0_ & 0x2) != 0; }
/*      */     
/*      */     public final CardboardInternalParams clearXPpiOverride() {
/*  607 */       this.xPpiOverride_ = 0.0F;
/*  608 */       this.bitField0_ &= 0xFFFFFFFD;
/*  609 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  615 */     public final float getYPpiOverride() { return this.yPpiOverride_; }
/*      */     
/*      */     public final CardboardInternalParams setYPpiOverride(float paramFloat) {
/*  618 */       this.yPpiOverride_ = paramFloat;
/*  619 */       this.bitField0_ |= 0x4;
/*  620 */       return this;
/*      */     }
/*      */     
/*  623 */     public final boolean hasYPpiOverride() { return (this.bitField0_ & 0x4) != 0; }
/*      */     
/*      */     public final CardboardInternalParams clearYPpiOverride() {
/*  626 */       this.yPpiOverride_ = 0.0F;
/*  627 */       this.bitField0_ &= 0xFFFFFFFB;
/*  628 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  634 */     public final String getAccelerometer() { return this.accelerometer_; }
/*      */     
/*      */     public final CardboardInternalParams setAccelerometer(String paramString) {
/*  637 */       if (paramString == null) {
/*  638 */         throw new NullPointerException();
/*      */       }
/*  640 */       this.accelerometer_ = paramString;
/*  641 */       this.bitField0_ |= 0x8;
/*  642 */       return this;
/*      */     }
/*      */     
/*  645 */     public final boolean hasAccelerometer() { return (this.bitField0_ & 0x8) != 0; }
/*      */     
/*      */     public final CardboardInternalParams clearAccelerometer() {
/*  648 */       this.accelerometer_ = "";
/*  649 */       this.bitField0_ &= 0xFFFFFFF7;
/*  650 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  656 */     public final String getGyroscope() { return this.gyroscope_; }
/*      */     
/*      */     public final CardboardInternalParams setGyroscope(String paramString) {
/*  659 */       if (paramString == null) {
/*  660 */         throw new NullPointerException();
/*      */       }
/*  662 */       this.gyroscope_ = paramString;
/*  663 */       this.bitField0_ |= 0x10;
/*  664 */       return this;
/*      */     }
/*      */     
/*  667 */     public final boolean hasGyroscope() { return (this.bitField0_ & 0x10) != 0; }
/*      */     
/*      */     public final CardboardInternalParams clearGyroscope() {
/*  670 */       this.gyroscope_ = "";
/*  671 */       this.bitField0_ &= 0xFFFFFFEF;
/*  672 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public CardboardInternalParams()
/*      */     {
/*  678 */       clear();
/*      */     }
/*      */     
/*      */     public final CardboardInternalParams clear() {
/*  682 */       this.bitField0_ = 0;
/*  683 */       this.eyeOrientations = WireFormatNano.EMPTY_INT_ARRAY;
/*  684 */       this.screenCenterToLensDistance_ = 0.0F;
/*  685 */       this.xPpiOverride_ = 0.0F;
/*  686 */       this.yPpiOverride_ = 0.0F;
/*  687 */       this.accelerometer_ = "";
/*  688 */       this.gyroscope_ = "";
/*  689 */       this.unknownFieldData = null;
/*  690 */       this.cachedSize = -1;
/*  691 */       return this;
/*      */     }
/*      */     
/*      */     public final CardboardInternalParams clone() {
/*      */       CardboardInternalParams localCardboardInternalParams;
/*      */       try {
/*  697 */         localCardboardInternalParams = (CardboardInternalParams)super.clone();
/*      */       } catch (CloneNotSupportedException localCloneNotSupportedException) {
/*  699 */         throw new AssertionError(localCloneNotSupportedException);
/*      */       }
/*  701 */       if ((this.eyeOrientations != null) && (this.eyeOrientations.length > 0)) {
/*  702 */         localCardboardInternalParams.eyeOrientations = ((int[])this.eyeOrientations.clone());
/*      */       }
/*  704 */       return localCardboardInternalParams;
/*      */     }
/*      */     
/*      */ 
/*      */     public final void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
/*      */       throws IOException
/*      */     {
/*  711 */       if ((this.eyeOrientations != null) && (this.eyeOrientations.length > 0)) {
/*  712 */         int i = 0;
/*  713 */         for (int j = 0; j < this.eyeOrientations.length; j++) {
/*  714 */           int k = this.eyeOrientations[j];
/*      */           
/*  716 */           i = i + CodedOutputByteBufferNano.computeInt32SizeNoTag(k);
/*      */         }
/*  718 */         paramCodedOutputByteBufferNano.writeRawVarint32(10);
/*  719 */         paramCodedOutputByteBufferNano.writeRawVarint32(i);
/*  720 */         for (j = 0; j < this.eyeOrientations.length; j++) {
/*  721 */           paramCodedOutputByteBufferNano.writeRawVarint32(this.eyeOrientations[j]);
/*      */         }
/*      */       }
/*  724 */       if ((this.bitField0_ & 0x1) != 0) {
/*  725 */         paramCodedOutputByteBufferNano.writeFloat(2, this.screenCenterToLensDistance_);
/*      */       }
/*  727 */       if ((this.bitField0_ & 0x2) != 0) {
/*  728 */         paramCodedOutputByteBufferNano.writeFloat(3, this.xPpiOverride_);
/*      */       }
/*  730 */       if ((this.bitField0_ & 0x4) != 0) {
/*  731 */         paramCodedOutputByteBufferNano.writeFloat(4, this.yPpiOverride_);
/*      */       }
/*  733 */       if ((this.bitField0_ & 0x8) != 0) {
/*  734 */         paramCodedOutputByteBufferNano.writeString(5, this.accelerometer_);
/*      */       }
/*  736 */       if ((this.bitField0_ & 0x10) != 0) {
/*  737 */         paramCodedOutputByteBufferNano.writeString(6, this.gyroscope_);
/*      */       }
/*  739 */       super.writeTo(paramCodedOutputByteBufferNano);
/*      */     }
/*      */     
/*      */     protected final int computeSerializedSize()
/*      */     {
/*  744 */       int i = super.computeSerializedSize();
/*  745 */       if ((this.eyeOrientations != null) && (this.eyeOrientations.length > 0)) {
/*  746 */         int j = 0;
/*  747 */         for (int k = 0; k < this.eyeOrientations.length; k++) {
/*  748 */           int m = this.eyeOrientations[k];
/*      */           
/*  750 */           j = j + CodedOutputByteBufferNano.computeInt32SizeNoTag(m);
/*      */         }
/*  752 */         i += j;
/*  753 */         i++;
/*      */         
/*  755 */         i = i + CodedOutputByteBufferNano.computeRawVarint32Size(j);
/*      */       }
/*  757 */       if ((this.bitField0_ & 0x1) != 0)
/*      */       {
/*  759 */         i = i + CodedOutputByteBufferNano.computeFloatSize(2, this.screenCenterToLensDistance_);
/*      */       }
/*  761 */       if ((this.bitField0_ & 0x2) != 0)
/*      */       {
/*  763 */         i = i + CodedOutputByteBufferNano.computeFloatSize(3, this.xPpiOverride_);
/*      */       }
/*  765 */       if ((this.bitField0_ & 0x4) != 0)
/*      */       {
/*  767 */         i = i + CodedOutputByteBufferNano.computeFloatSize(4, this.yPpiOverride_);
/*      */       }
/*  769 */       if ((this.bitField0_ & 0x8) != 0)
/*      */       {
/*  771 */         i = i + CodedOutputByteBufferNano.computeStringSize(5, this.accelerometer_);
/*      */       }
/*  773 */       if ((this.bitField0_ & 0x10) != 0)
/*      */       {
/*  775 */         i = i + CodedOutputByteBufferNano.computeStringSize(6, this.gyroscope_);
/*      */       }
/*  777 */       return i;
/*      */     }
/*      */     
/*      */     public final CardboardInternalParams mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano) throws IOException {
/*      */       for (;;) {
/*      */         int i;
/*      */         int j;
/*      */         int m;
/*      */         int n;
/*  786 */         switch (i = paramCodedInputByteBufferNano.readTag())
/*      */         {
/*      */         case 0: 
/*  788 */           return this;
/*      */         default: 
/*  790 */           if (!super.storeUnknownField(paramCodedInputByteBufferNano, i)) {
/*  791 */             return this;
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*      */           break;
/*      */         case 8: 
/*  798 */           int[] arrayOfInt1 = new int[j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 8)];
/*  799 */           m = 0;
/*  800 */           for (n = 0; n < j; n++) {
/*  801 */             if (n != 0) {
/*  802 */               paramCodedInputByteBufferNano.readTag();
/*      */             }
/*      */             int i1;
/*  805 */             switch (i1 = paramCodedInputByteBufferNano.readInt32())
/*      */             {
/*      */             case 0: 
/*      */             case 1: 
/*      */             case 2: 
/*      */             case 3: 
/*      */             case 4: 
/*      */             case 5: 
/*      */             case 6: 
/*      */             case 7: 
/*  814 */               arrayOfInt1[(m++)] = i1;
/*      */             }
/*      */             
/*      */           }
/*  818 */           if (m != 0)
/*      */           {
/*  820 */             if (((n = this.eyeOrientations == null ? 0 : this.eyeOrientations.length) == 0) && (m == j)) {
/*  821 */               this.eyeOrientations = arrayOfInt1;
/*      */             } else {
/*  823 */               int[] arrayOfInt2 = new int[n + m];
/*  824 */               if (n != 0) {
/*  825 */                 System.arraycopy(this.eyeOrientations, 0, arrayOfInt2, 0, n);
/*      */               }
/*  827 */               System.arraycopy(arrayOfInt1, 0, arrayOfInt2, n, m);
/*  828 */               this.eyeOrientations = arrayOfInt2;
/*      */             } }
/*  830 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  834 */           j = paramCodedInputByteBufferNano.readRawVarint32();
/*  835 */           int k = paramCodedInputByteBufferNano.pushLimit(j);
/*      */           
/*  837 */           m = 0;
/*  838 */           n = paramCodedInputByteBufferNano.getPosition();
/*  839 */           while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0) {
/*  840 */             switch (paramCodedInputByteBufferNano.readInt32()) {
/*      */             case 0: 
/*      */             case 1: 
/*      */             case 2: 
/*      */             case 3: 
/*      */             case 4: 
/*      */             case 5: 
/*      */             case 6: 
/*      */             case 7: 
/*  849 */               m++;
/*      */             }
/*      */             
/*      */           }
/*  853 */           if (m != 0) {
/*  854 */             paramCodedInputByteBufferNano.rewindToPosition(n);
/*      */             int i2;
/*  856 */             int[] arrayOfInt3 = new int[(i2 = this.eyeOrientations == null ? 0 : this.eyeOrientations.length) + m];
/*  857 */             if (i2 != 0) {
/*  858 */               System.arraycopy(this.eyeOrientations, 0, arrayOfInt3, 0, i2);
/*      */             }
/*  860 */             while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0) {
/*      */               int i3;
/*  862 */               switch (i3 = paramCodedInputByteBufferNano.readInt32())
/*      */               {
/*      */               case 0: 
/*      */               case 1: 
/*      */               case 2: 
/*      */               case 3: 
/*      */               case 4: 
/*      */               case 5: 
/*      */               case 6: 
/*      */               case 7: 
/*  871 */                 arrayOfInt3[(i2++)] = i3;
/*      */               }
/*      */               
/*      */             }
/*  875 */             this.eyeOrientations = arrayOfInt3;
/*      */           }
/*  877 */           paramCodedInputByteBufferNano.popLimit(k);
/*  878 */           break;
/*      */         
/*      */         case 21: 
/*  881 */           this.screenCenterToLensDistance_ = paramCodedInputByteBufferNano.readFloat();
/*  882 */           this.bitField0_ |= 0x1;
/*  883 */           break;
/*      */         
/*      */         case 29: 
/*  886 */           this.xPpiOverride_ = paramCodedInputByteBufferNano.readFloat();
/*  887 */           this.bitField0_ |= 0x2;
/*  888 */           break;
/*      */         
/*      */         case 37: 
/*  891 */           this.yPpiOverride_ = paramCodedInputByteBufferNano.readFloat();
/*  892 */           this.bitField0_ |= 0x4;
/*  893 */           break;
/*      */         
/*      */         case 42: 
/*  896 */           this.accelerometer_ = paramCodedInputByteBufferNano.readString();
/*  897 */           this.bitField0_ |= 0x8;
/*  898 */           break;
/*      */         
/*      */         case 50: 
/*  901 */           this.gyroscope_ = paramCodedInputByteBufferNano.readString();
/*  902 */           this.bitField0_ |= 0x10;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     
/*      */     public static CardboardInternalParams parseFrom(byte[] paramArrayOfByte)
/*      */       throws com.google.protobuf.nano.InvalidProtocolBufferNanoException
/*      */     {
/*  911 */       return (CardboardInternalParams)MessageNano.mergeFrom(new CardboardInternalParams(), paramArrayOfByte);
/*      */     }
/*      */     
/*      */     public static CardboardInternalParams parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
/*      */       throws IOException
/*      */     {
/*  917 */       return new CardboardInternalParams().mergeFrom(paramCodedInputByteBufferNano);
/*      */     }
/*      */     
/*      */     
/*      */   }
/*      */   
/*      */   public static final class DaydreamInternalParams extends ExtendableMessageNano<DaydreamInternalParams> implements Cloneable
/*      */   {
/*      */     public static DaydreamInternalParams[] emptyArray()
/*      */     {
/*  927 */       if (_emptyArray == null) {
/*  928 */         synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK)
/*      */         {
/*  930 */           if (_emptyArray == null) {
/*  931 */             _emptyArray = new DaydreamInternalParams[0];
/*      */           }
/*      */         }
/*      */       }
/*  935 */       return _emptyArray;
/*      */     }
/*      */     
/*      */ 
/*      */     private static volatile DaydreamInternalParams[] _emptyArray;
/*      */     private int bitField0_;
/*      */     private int version_;
/*      */     public CardboardDevice.ScreenAlignmentMarker[] alignmentMarkers;
/*  943 */     public final int getVersion() { return this.version_; }
/*      */     
/*      */     public final DaydreamInternalParams setVersion(int paramInt) {
/*  946 */       this.version_ = paramInt;
/*  947 */       this.bitField0_ |= 0x1;
/*  948 */       return this;
/*      */     }
/*      */     
/*  951 */     public final boolean hasVersion() { return (this.bitField0_ & 0x1) != 0; }
/*      */     
/*      */     public final DaydreamInternalParams clearVersion() {
/*  954 */       this.version_ = 0;
/*  955 */       this.bitField0_ &= 0xFFFFFFFE;
/*  956 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public DaydreamInternalParams()
/*      */     {
/*  965 */       clear();
/*      */     }
/*      */     
/*      */     public final DaydreamInternalParams clear() {
/*  969 */       this.bitField0_ = 0;
/*  970 */       this.version_ = 0;
/*  971 */       this.alignmentMarkers = CardboardDevice.ScreenAlignmentMarker.emptyArray();
/*  972 */       this.unknownFieldData = null;
/*  973 */       this.cachedSize = -1;
/*  974 */       return this;
/*      */     }
/*      */     
/*      */     public final DaydreamInternalParams clone() {
/*      */       DaydreamInternalParams localDaydreamInternalParams;
/*      */       try {
/*  980 */         localDaydreamInternalParams = (DaydreamInternalParams)super.clone();
/*      */       } catch (CloneNotSupportedException localCloneNotSupportedException) {
/*  982 */         throw new AssertionError(localCloneNotSupportedException);
/*      */       }
/*  984 */       if ((this.alignmentMarkers != null) && (this.alignmentMarkers.length > 0)) {
/*  985 */         localDaydreamInternalParams.alignmentMarkers = new CardboardDevice.ScreenAlignmentMarker[this.alignmentMarkers.length];
/*  986 */         for (int i = 0; i < this.alignmentMarkers.length; i++) {
/*  987 */           if (this.alignmentMarkers[i] != null) {
/*  988 */             localDaydreamInternalParams.alignmentMarkers[i] = this.alignmentMarkers[i].clone();
/*      */           }
/*      */         }
/*      */       }
/*  992 */       return localDaydreamInternalParams;
/*      */     }
/*      */     
/*      */ 
/*      */     public final void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
/*      */       throws IOException
/*      */     {
/*  999 */       if ((this.bitField0_ & 0x1) != 0) {
/* 1000 */         paramCodedOutputByteBufferNano.writeInt32(1, this.version_);
/*      */       }
/* 1002 */       if ((this.alignmentMarkers != null) && (this.alignmentMarkers.length > 0)) {
/* 1003 */         for (int i = 0; i < this.alignmentMarkers.length; i++) {
/*      */           CardboardDevice.ScreenAlignmentMarker localScreenAlignmentMarker;
/* 1005 */           if ((localScreenAlignmentMarker = this.alignmentMarkers[i]) != null) {
/* 1006 */             paramCodedOutputByteBufferNano.writeMessage(2, localScreenAlignmentMarker);
/*      */           }
/*      */         }
/*      */       }
/* 1010 */       super.writeTo(paramCodedOutputByteBufferNano);
/*      */     }
/*      */     
/*      */     protected final int computeSerializedSize()
/*      */     {
/* 1015 */       int i = super.computeSerializedSize();
/* 1016 */       if ((this.bitField0_ & 0x1) != 0)
/*      */       {
/* 1018 */         i = i + CodedOutputByteBufferNano.computeInt32Size(1, this.version_);
/*      */       }
/* 1020 */       if ((this.alignmentMarkers != null) && (this.alignmentMarkers.length > 0)) {
/* 1021 */         for (int j = 0; j < this.alignmentMarkers.length; j++) {
/*      */           CardboardDevice.ScreenAlignmentMarker localScreenAlignmentMarker;
/* 1023 */           if ((localScreenAlignmentMarker = this.alignmentMarkers[j]) != null)
/*      */           {
/* 1025 */             i = i + CodedOutputByteBufferNano.computeMessageSize(2, localScreenAlignmentMarker);
/*      */           }
/*      */         }
/*      */       }
/* 1029 */       return i;
/*      */     }
/*      */     
/*      */     public final DaydreamInternalParams mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
/*      */       throws IOException
/*      */     {
/*      */       for (;;)
/*      */       {
/*      */         int i;
/* 1038 */         switch (i = paramCodedInputByteBufferNano.readTag())
/*      */         {
/*      */         case 0: 
/* 1040 */           return this;
/*      */         default: 
/* 1042 */           if (!super.storeUnknownField(paramCodedInputByteBufferNano, i)) {
/* 1043 */             return this;
/*      */           }
/*      */           
/*      */           break;
/*      */         case 8: 
/* 1048 */           this.version_ = paramCodedInputByteBufferNano.readInt32();
/* 1049 */           this.bitField0_ |= 0x1;
/* 1050 */           break;
/*      */         
/*      */ 
/*      */         case 18: 
/* 1054 */           int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
/*      */           int k;
/* 1056 */           CardboardDevice.ScreenAlignmentMarker[] arrayOfScreenAlignmentMarker = new CardboardDevice.ScreenAlignmentMarker[(k = this.alignmentMarkers == null ? 0 : this.alignmentMarkers.length) + j];
/*      */           
/* 1058 */           if (k != 0) {
/* 1059 */             System.arraycopy(this.alignmentMarkers, 0, arrayOfScreenAlignmentMarker, 0, k);
/*      */           }
/* 1061 */           for (; k < arrayOfScreenAlignmentMarker.length - 1; k++) {
/* 1062 */             arrayOfScreenAlignmentMarker[k] = new CardboardDevice.ScreenAlignmentMarker();
/* 1063 */             paramCodedInputByteBufferNano.readMessage(arrayOfScreenAlignmentMarker[k]);
/* 1064 */             paramCodedInputByteBufferNano.readTag();
/*      */           }
/*      */           
/* 1067 */           arrayOfScreenAlignmentMarker[k] = new CardboardDevice.ScreenAlignmentMarker();
/* 1068 */           paramCodedInputByteBufferNano.readMessage(arrayOfScreenAlignmentMarker[k]);
/* 1069 */           this.alignmentMarkers = arrayOfScreenAlignmentMarker;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     
/*      */     public static DaydreamInternalParams parseFrom(byte[] paramArrayOfByte)
/*      */       throws com.google.protobuf.nano.InvalidProtocolBufferNanoException
/*      */     {
/* 1078 */       return (DaydreamInternalParams)MessageNano.mergeFrom(new DaydreamInternalParams(), paramArrayOfByte);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1084 */     public static DaydreamInternalParams parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
/* 1084 */       throws IOException { return new DaydreamInternalParams().mergeFrom(paramCodedInputByteBufferNano); }
/*      */   }
/*      */   
/*      */   public static final class ScreenAlignmentMarker extends ExtendableMessageNano<ScreenAlignmentMarker> implements Cloneable {
/*      */     private static volatile ScreenAlignmentMarker[] _emptyArray;
/*      */     private int bitField0_;
/*      */     private float horizontal_;
/*      */     private float vertical_;
/*      */     
/*      */     public static ScreenAlignmentMarker[] emptyArray() {
/* 1094 */       if (_emptyArray == null) {
/* 1095 */         synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK)
/*      */         {
/* 1097 */           if (_emptyArray == null) {
/* 1098 */             _emptyArray = new ScreenAlignmentMarker[0];
/*      */           }
/*      */         }
/*      */       }
/* 1102 */       return _emptyArray;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1110 */     public final float getHorizontal() { return this.horizontal_; }
/*      */     
/*      */     public final ScreenAlignmentMarker setHorizontal(float paramFloat) {
/* 1113 */       this.horizontal_ = paramFloat;
/* 1114 */       this.bitField0_ |= 0x1;
/* 1115 */       return this;
/*      */     }
/*      */     
/* 1118 */     public final boolean hasHorizontal() { return (this.bitField0_ & 0x1) != 0; }
/*      */     
/*      */     public final ScreenAlignmentMarker clearHorizontal() {
/* 1121 */       this.horizontal_ = 0.0F;
/* 1122 */       this.bitField0_ &= 0xFFFFFFFE;
/* 1123 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1129 */     public final float getVertical() { return this.vertical_; }
/*      */     
/*      */     public final ScreenAlignmentMarker setVertical(float paramFloat) {
/* 1132 */       this.vertical_ = paramFloat;
/* 1133 */       this.bitField0_ |= 0x2;
/* 1134 */       return this;
/*      */     }
/*      */     
/* 1137 */     public final boolean hasVertical() { return (this.bitField0_ & 0x2) != 0; }
/*      */     
/*      */     public final ScreenAlignmentMarker clearVertical() {
/* 1140 */       this.vertical_ = 0.0F;
/* 1141 */       this.bitField0_ &= 0xFFFFFFFD;
/* 1142 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public ScreenAlignmentMarker()
/*      */     {
/* 1148 */       clear();
/*      */     }
/*      */     
/*      */     public final ScreenAlignmentMarker clear() {
/* 1152 */       this.bitField0_ = 0;
/* 1153 */       this.horizontal_ = 0.0F;
/* 1154 */       this.vertical_ = 0.0F;
/* 1155 */       this.unknownFieldData = null;
/* 1156 */       this.cachedSize = -1;
/* 1157 */       return this;
/*      */     }
/*      */     
/*      */     public final ScreenAlignmentMarker clone() {
/*      */       ScreenAlignmentMarker localScreenAlignmentMarker;
/*      */       try {
/* 1163 */         localScreenAlignmentMarker = (ScreenAlignmentMarker)super.clone();
/*      */       } catch (CloneNotSupportedException localCloneNotSupportedException) {
/* 1165 */         throw new AssertionError(localCloneNotSupportedException);
/*      */       }
/* 1167 */       return localScreenAlignmentMarker;
/*      */     }
/*      */     
/*      */ 
/*      */     public final void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
/*      */       throws IOException
/*      */     {
/* 1174 */       if ((this.bitField0_ & 0x1) != 0) {
/* 1175 */         paramCodedOutputByteBufferNano.writeFloat(1, this.horizontal_);
/*      */       }
/* 1177 */       if ((this.bitField0_ & 0x2) != 0) {
/* 1178 */         paramCodedOutputByteBufferNano.writeFloat(2, this.vertical_);
/*      */       }
/* 1180 */       super.writeTo(paramCodedOutputByteBufferNano);
/*      */     }
/*      */     
/*      */     protected final int computeSerializedSize()
/*      */     {
/* 1185 */       int i = super.computeSerializedSize();
/* 1186 */       if ((this.bitField0_ & 0x1) != 0)
/*      */       {
/* 1188 */         i = i + CodedOutputByteBufferNano.computeFloatSize(1, this.horizontal_);
/*      */       }
/* 1190 */       if ((this.bitField0_ & 0x2) != 0)
/*      */       {
/* 1192 */         i = i + CodedOutputByteBufferNano.computeFloatSize(2, this.vertical_);
/*      */       }
/* 1194 */       return i;
/*      */     }
/*      */     
/*      */     public final ScreenAlignmentMarker mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
/*      */       throws IOException
/*      */     {
/*      */       for (;;)
/*      */       {
/*      */         int i;
/* 1203 */         switch (i = paramCodedInputByteBufferNano.readTag())
/*      */         {
/*      */         case 0: 
/* 1205 */           return this;
/*      */         default: 
/* 1207 */           if (!super.storeUnknownField(paramCodedInputByteBufferNano, i)) {
/* 1208 */             return this;
/*      */           }
/*      */           
/*      */           break;
/*      */         case 13: 
/* 1213 */           this.horizontal_ = paramCodedInputByteBufferNano.readFloat();
/* 1214 */           this.bitField0_ |= 0x1;
/* 1215 */           break;
/*      */         
/*      */         case 21: 
/* 1218 */           this.vertical_ = paramCodedInputByteBufferNano.readFloat();
/* 1219 */           this.bitField0_ |= 0x2;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     
/*      */     public static ScreenAlignmentMarker parseFrom(byte[] paramArrayOfByte)
/*      */       throws com.google.protobuf.nano.InvalidProtocolBufferNanoException
/*      */     {
/* 1228 */       return (ScreenAlignmentMarker)MessageNano.mergeFrom(new ScreenAlignmentMarker(), paramArrayOfByte);
/*      */     }
/*      */     
/*      */     public static ScreenAlignmentMarker parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
/*      */       throws IOException
/*      */     {
/* 1234 */       return new ScreenAlignmentMarker().mergeFrom(paramCodedInputByteBufferNano);
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vrtoolkit\cardboard\proto\nano\CardboardDevice.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */