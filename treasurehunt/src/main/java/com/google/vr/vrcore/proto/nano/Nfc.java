/*     */ package com.google.vr.vrcore.proto.nano;
/*     */ 
/*     */ import com.google.protobuf.nano.CodedInputByteBufferNano;
/*     */ import com.google.protobuf.nano.ExtendableMessageNano;
/*     */ 
/*     */ public abstract interface Nfc
/*     */ {
/*     */   public static final class NfcParams extends ExtendableMessageNano<NfcParams> implements Cloneable
/*     */   {
/*     */     private static volatile NfcParams[] _emptyArray;
/*     */     private int bitField0_;
/*     */     private int viewerId_;
/*     */     
/*     */     public static NfcParams[] emptyArray()
/*     */     {
/*  16 */       if (_emptyArray == null) {
/*  17 */         synchronized (com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK)
/*     */         {
/*  19 */           if (_emptyArray == null) {
/*  20 */             _emptyArray = new NfcParams[0];
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
/*  32 */     public final int getViewerId() { return this.viewerId_; }
/*     */     
/*     */     public final NfcParams setViewerId(int paramInt) {
/*  35 */       this.viewerId_ = paramInt;
/*  36 */       this.bitField0_ |= 0x1;
/*  37 */       return this;
/*     */     }
/*     */     
/*  40 */     public final boolean hasViewerId() { return (this.bitField0_ & 0x1) != 0; }
/*     */     
/*     */     public final NfcParams clearViewerId() {
/*  43 */       this.viewerId_ = 0;
/*  44 */       this.bitField0_ &= 0xFFFFFFFE;
/*  45 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public NfcParams()
/*     */     {
/*  51 */       clear();
/*     */     }
/*     */     
/*     */     public final NfcParams clear() {
/*  55 */       this.bitField0_ = 0;
/*  56 */       this.viewerId_ = 0;
/*  57 */       this.unknownFieldData = null;
/*  58 */       this.cachedSize = -1;
/*  59 */       return this;
/*     */     }
/*     */     
/*     */     public final NfcParams clone() {
/*     */       NfcParams localNfcParams;
/*     */       try {
/*  65 */         localNfcParams = (NfcParams)super.clone();
/*     */       } catch (CloneNotSupportedException localCloneNotSupportedException) {
/*  67 */         throw new AssertionError(localCloneNotSupportedException);
/*     */       }
/*  69 */       return localNfcParams;
/*     */     }
/*     */     
/*     */ 
/*     */     public final void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
/*     */       throws java.io.IOException
/*     */     {
/*  76 */       if ((this.bitField0_ & 0x1) != 0) {
/*  77 */         paramCodedOutputByteBufferNano.writeInt32(1, this.viewerId_);
/*     */       }
/*  79 */       super.writeTo(paramCodedOutputByteBufferNano);
/*     */     }
/*     */     
/*     */     protected final int computeSerializedSize()
/*     */     {
/*  84 */       int i = super.computeSerializedSize();
/*  85 */       if ((this.bitField0_ & 0x1) != 0)
/*     */       {
/*  87 */         i = i + com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(1, this.viewerId_);
/*     */       }
/*  89 */       return i;
/*     */     }
/*     */     
/*     */     public final NfcParams mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
/*     */       throws java.io.IOException
/*     */     {
/*     */       for (;;)
/*     */       {
/*     */         int i;
/*  98 */         switch (i = paramCodedInputByteBufferNano.readTag())
/*     */         {
/*     */         case 0: 
/* 100 */           return this;
/*     */         default: 
/* 102 */           if (!super.storeUnknownField(paramCodedInputByteBufferNano, i)) {
/* 103 */             return this;
/*     */           }
/*     */           
/*     */           break;
/*     */         case 8: 
/* 108 */           this.viewerId_ = paramCodedInputByteBufferNano.readInt32();
/* 109 */           this.bitField0_ |= 0x1;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     
/*     */     public static NfcParams parseFrom(byte[] paramArrayOfByte)
/*     */       throws com.google.protobuf.nano.InvalidProtocolBufferNanoException
/*     */     {
/* 118 */       return (NfcParams)com.google.protobuf.nano.MessageNano.mergeFrom(new NfcParams(), paramArrayOfByte);
/*     */     }
/*     */     
/*     */     public static NfcParams parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
/*     */       throws java.io.IOException
/*     */     {
/* 124 */       return new NfcParams().mergeFrom(paramCodedInputByteBufferNano);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\proto\nano\Nfc.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */