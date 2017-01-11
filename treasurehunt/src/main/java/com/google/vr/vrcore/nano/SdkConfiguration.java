/*     */ package com.google.vr.vrcore.nano;
/*     */ 
/*     */ import com.google.protobuf.nano.CodedInputByteBufferNano;
/*     */ import com.google.protobuf.nano.CodedOutputByteBufferNano;
/*     */ 
/*     */ public abstract interface SdkConfiguration
/*     */ {
/*     */   public static final class SdkConfigurationRequest extends com.google.protobuf.nano.ExtendableMessageNano<SdkConfigurationRequest>
/*     */   {
/*     */     private static volatile SdkConfigurationRequest[] _emptyArray;
/*     */     public String sdkVersion;
/*     */     public com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams requestedParams;
/*     */     
/*     */     public static SdkConfigurationRequest[] emptyArray()
/*     */     {
/*  16 */       if (_emptyArray == null) {
/*  17 */         synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK)
/*     */         {
/*  19 */           if (_emptyArray == null) {
/*  20 */             _emptyArray = new SdkConfigurationRequest[0];
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
/*     */     public SdkConfigurationRequest()
/*     */     {
/*  36 */       clear();
/*     */     }
/*     */     
/*     */     public final SdkConfigurationRequest clear() {
/*  40 */       this.sdkVersion = null;
/*  41 */       this.requestedParams = null;
/*  42 */       this.unknownFieldData = null;
/*  43 */       this.cachedSize = -1;
/*  44 */       return this;
/*     */     }
/*     */     
/*     */     public final void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
/*     */       throws java.io.IOException
/*     */     {
/*  50 */       if (this.sdkVersion != null) {
/*  51 */         paramCodedOutputByteBufferNano.writeString(1, this.sdkVersion);
/*     */       }
/*  53 */       if (this.requestedParams != null) {
/*  54 */         paramCodedOutputByteBufferNano.writeMessage(2, this.requestedParams);
/*     */       }
/*  56 */       super.writeTo(paramCodedOutputByteBufferNano);
/*     */     }
/*     */     
/*     */     protected final int computeSerializedSize()
/*     */     {
/*  61 */       int i = super.computeSerializedSize();
/*  62 */       if (this.sdkVersion != null)
/*     */       {
/*  64 */         i = i + CodedOutputByteBufferNano.computeStringSize(1, this.sdkVersion);
/*     */       }
/*  66 */       if (this.requestedParams != null)
/*     */       {
/*  68 */         i = i + CodedOutputByteBufferNano.computeMessageSize(2, this.requestedParams);
/*     */       }
/*  70 */       return i;
/*     */     }
/*     */     
/*     */     public final SdkConfigurationRequest mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
/*     */       throws java.io.IOException
/*     */     {
/*     */       for (;;)
/*     */       {
/*     */         int i;
/*  79 */         switch (i = paramCodedInputByteBufferNano.readTag())
/*     */         {
/*     */         case 0: 
/*  81 */           return this;
/*     */         default: 
/*  83 */           if (!super.storeUnknownField(paramCodedInputByteBufferNano, i)) {
/*  84 */             return this;
/*     */           }
/*     */           
/*     */           break;
/*     */         case 10: 
/*  89 */           this.sdkVersion = paramCodedInputByteBufferNano.readString();
/*  90 */           break;
/*     */         
/*     */         case 18: 
/*  93 */           if (this.requestedParams == null) {
/*  94 */             this.requestedParams = new com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams();
/*     */           }
/*  96 */           paramCodedInputByteBufferNano.readMessage(this.requestedParams);
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     
/*     */     public static SdkConfigurationRequest parseFrom(byte[] paramArrayOfByte)
/*     */       throws com.google.protobuf.nano.InvalidProtocolBufferNanoException
/*     */     {
/* 105 */       return (SdkConfigurationRequest)com.google.protobuf.nano.MessageNano.mergeFrom(new SdkConfigurationRequest(), paramArrayOfByte);
/*     */     }
/*     */     
/*     */     public static SdkConfigurationRequest parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
/*     */       throws java.io.IOException
/*     */     {
/* 111 */       return new SdkConfigurationRequest().mergeFrom(paramCodedInputByteBufferNano);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\nano\SdkConfiguration.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */