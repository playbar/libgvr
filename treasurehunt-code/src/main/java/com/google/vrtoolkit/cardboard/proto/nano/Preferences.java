/*     */ package com.google.vrtoolkit.cardboard.proto.nano;
/*     */ 
/*     */ import com.google.protobuf.nano.CodedInputByteBufferNano;
/*     */ import com.google.protobuf.nano.CodedOutputByteBufferNano;
/*     */ import com.google.protobuf.nano.ExtendableMessageNano;
/*     */ import com.google.protobuf.nano.InternalNano;
/*     */ import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
/*     */ import com.google.protobuf.nano.MessageNano;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public abstract interface Preferences
/*     */ {
/*     */   public static final class UserPrefs extends ExtendableMessageNano<UserPrefs> implements Cloneable
/*     */   {
/*     */     private static volatile UserPrefs[] _emptyArray;
/*     */     private int bitField0_;
/*     */     private int controllerHandedness_;
/*     */     public Preferences.DeveloperPrefs developerPrefs;
/*     */     
/*     */     public static UserPrefs[] emptyArray()
/*     */     {
/*  22 */       if (_emptyArray == null) {
/*  23 */         synchronized (InternalNano.LAZY_INIT_LOCK)
/*     */         {
/*  25 */           if (_emptyArray == null) {
/*  26 */             _emptyArray = new UserPrefs[0];
/*     */           }
/*     */         }
/*     */       }
/*  30 */       return _emptyArray;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  38 */     public final int getControllerHandedness() { return this.controllerHandedness_; }
/*     */     
/*     */     public final UserPrefs setControllerHandedness(int paramInt) {
/*  41 */       this.controllerHandedness_ = paramInt;
/*  42 */       this.bitField0_ |= 0x1;
/*  43 */       return this;
/*     */     }
/*     */     
/*  46 */     public final boolean hasControllerHandedness() { return (this.bitField0_ & 0x1) != 0; }
/*     */     
/*     */     public final UserPrefs clearControllerHandedness() {
/*  49 */       this.controllerHandedness_ = 0;
/*  50 */       this.bitField0_ &= 0xFFFFFFFE;
/*  51 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public UserPrefs()
/*     */     {
/*  60 */       clear();
/*     */     }
/*     */     
/*     */     public final UserPrefs clear() {
/*  64 */       this.bitField0_ = 0;
/*  65 */       this.controllerHandedness_ = 0;
/*  66 */       this.developerPrefs = null;
/*  67 */       this.unknownFieldData = null;
/*  68 */       this.cachedSize = -1;
/*  69 */       return this;
/*     */     }
/*     */     
/*     */     public final UserPrefs clone() {
/*     */       UserPrefs localUserPrefs;
/*     */       try {
/*  75 */         localUserPrefs = (UserPrefs)super.clone();
/*     */       } catch (CloneNotSupportedException localCloneNotSupportedException) {
/*  77 */         throw new AssertionError(localCloneNotSupportedException);
/*     */       }
/*  79 */       if (this.developerPrefs != null) {
/*  80 */         localUserPrefs.developerPrefs = this.developerPrefs.clone();
/*     */       }
/*  82 */       return localUserPrefs;
/*     */     }
/*     */     
/*     */ 
/*     */     public final void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
/*     */       throws IOException
/*     */     {
/*  89 */       if ((this.bitField0_ & 0x1) != 0) {
/*  90 */         paramCodedOutputByteBufferNano.writeInt32(1, this.controllerHandedness_);
/*     */       }
/*  92 */       if (this.developerPrefs != null) {
/*  93 */         paramCodedOutputByteBufferNano.writeMessage(2, this.developerPrefs);
/*     */       }
/*  95 */       super.writeTo(paramCodedOutputByteBufferNano);
/*     */     }
/*     */     
/*     */     protected final int computeSerializedSize()
/*     */     {
/* 100 */       int i = super.computeSerializedSize();
/* 101 */       if ((this.bitField0_ & 0x1) != 0)
/*     */       {
/* 103 */         i = i + CodedOutputByteBufferNano.computeInt32Size(1, this.controllerHandedness_);
/*     */       }
/* 105 */       if (this.developerPrefs != null)
/*     */       {
/* 107 */         i = i + CodedOutputByteBufferNano.computeMessageSize(2, this.developerPrefs);
/*     */       }
/* 109 */       return i;
/*     */     }
/*     */     
/*     */     public final UserPrefs mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
/*     */       throws IOException
/*     */     {
/*     */       for (;;)
/*     */       {
/*     */         int i;
/* 118 */         switch (i = paramCodedInputByteBufferNano.readTag())
/*     */         {
/*     */         case 0: 
/* 120 */           return this;
/*     */         default: 
/* 122 */           if (!super.storeUnknownField(paramCodedInputByteBufferNano, i)) {
/* 123 */             return this;
/*     */           }
/*     */           
/*     */           break;
/*     */         case 8: 
/*     */           int j;
/* 129 */           switch (j = paramCodedInputByteBufferNano.readInt32())
/*     */           {
/*     */           case 0: 
/*     */           case 1: 
/* 132 */             this.controllerHandedness_ = j;
/* 133 */             this.bitField0_ |= 0x1;
/*     */           }
/*     */           
/* 136 */           break;
/*     */         
/*     */         case 18: 
/* 139 */           if (this.developerPrefs == null) {
/* 140 */             this.developerPrefs = new Preferences.DeveloperPrefs();
/*     */           }
/* 142 */           paramCodedInputByteBufferNano.readMessage(this.developerPrefs);
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     
/*     */     public static UserPrefs parseFrom(byte[] paramArrayOfByte)
/*     */       throws InvalidProtocolBufferNanoException
/*     */     {
/* 151 */       return (UserPrefs)MessageNano.mergeFrom(new UserPrefs(), paramArrayOfByte);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 157 */     public static UserPrefs parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
/* 157 */       throws IOException { return new UserPrefs().mergeFrom(paramCodedInputByteBufferNano); }
/*     */     
/*     */     public static abstract interface Handedness { public static final int RIGHT_HANDED = 0;
/*     */       public static final int LEFT_HANDED = 1;
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class DeveloperPrefs extends ExtendableMessageNano<DeveloperPrefs> implements Cloneable { private static volatile DeveloperPrefs[] _emptyArray;
/*     */     private int bitField0_;
/*     */     
/* 167 */     public static DeveloperPrefs[] emptyArray() { if (_emptyArray == null) {
/* 168 */         synchronized (InternalNano.LAZY_INIT_LOCK)
/*     */         {
/* 170 */           if (_emptyArray == null) {
/* 171 */             _emptyArray = new DeveloperPrefs[0];
/*     */           }
/*     */         }
/*     */       }
/* 175 */       return _emptyArray;
/*     */     }
/*     */     
/*     */ 
/*     */     private boolean performanceMonitoringEnabled_;
/*     */     
/*     */     private boolean sensorLoggingEnabled_;
/*     */     private boolean motophoPatchEnabled_;
/* 183 */     public final boolean getPerformanceMonitoringEnabled() { return this.performanceMonitoringEnabled_; }
/*     */     
/*     */     public final DeveloperPrefs setPerformanceMonitoringEnabled(boolean paramBoolean) {
/* 186 */       this.performanceMonitoringEnabled_ = paramBoolean;
/* 187 */       this.bitField0_ |= 0x1;
/* 188 */       return this;
/*     */     }
/*     */     
/* 191 */     public final boolean hasPerformanceMonitoringEnabled() { return (this.bitField0_ & 0x1) != 0; }
/*     */     
/*     */     public final DeveloperPrefs clearPerformanceMonitoringEnabled() {
/* 194 */       this.performanceMonitoringEnabled_ = false;
/* 195 */       this.bitField0_ &= 0xFFFFFFFE;
/* 196 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 202 */     public final boolean getSensorLoggingEnabled() { return this.sensorLoggingEnabled_; }
/*     */     
/*     */     public final DeveloperPrefs setSensorLoggingEnabled(boolean paramBoolean) {
/* 205 */       this.sensorLoggingEnabled_ = paramBoolean;
/* 206 */       this.bitField0_ |= 0x2;
/* 207 */       return this;
/*     */     }
/*     */     
/* 210 */     public final boolean hasSensorLoggingEnabled() { return (this.bitField0_ & 0x2) != 0; }
/*     */     
/*     */     public final DeveloperPrefs clearSensorLoggingEnabled() {
/* 213 */       this.sensorLoggingEnabled_ = false;
/* 214 */       this.bitField0_ &= 0xFFFFFFFD;
/* 215 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 221 */     public final boolean getMotophoPatchEnabled() { return this.motophoPatchEnabled_; }
/*     */     
/*     */     public final DeveloperPrefs setMotophoPatchEnabled(boolean paramBoolean) {
/* 224 */       this.motophoPatchEnabled_ = paramBoolean;
/* 225 */       this.bitField0_ |= 0x4;
/* 226 */       return this;
/*     */     }
/*     */     
/* 229 */     public final boolean hasMotophoPatchEnabled() { return (this.bitField0_ & 0x4) != 0; }
/*     */     
/*     */     public final DeveloperPrefs clearMotophoPatchEnabled() {
/* 232 */       this.motophoPatchEnabled_ = false;
/* 233 */       this.bitField0_ &= 0xFFFFFFFB;
/* 234 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public DeveloperPrefs()
/*     */     {
/* 240 */       clear();
/*     */     }
/*     */     
/*     */     public final DeveloperPrefs clear() {
/* 244 */       this.bitField0_ = 0;
/* 245 */       this.performanceMonitoringEnabled_ = false;
/* 246 */       this.sensorLoggingEnabled_ = false;
/* 247 */       this.motophoPatchEnabled_ = false;
/* 248 */       this.unknownFieldData = null;
/* 249 */       this.cachedSize = -1;
/* 250 */       return this;
/*     */     }
/*     */     
/*     */     public final DeveloperPrefs clone() {
/*     */       DeveloperPrefs localDeveloperPrefs;
/*     */       try {
/* 256 */         localDeveloperPrefs = (DeveloperPrefs)super.clone();
/*     */       } catch (CloneNotSupportedException localCloneNotSupportedException) {
/* 258 */         throw new AssertionError(localCloneNotSupportedException);
/*     */       }
/* 260 */       return localDeveloperPrefs;
/*     */     }
/*     */     
/*     */ 
/*     */     public final void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
/*     */       throws IOException
/*     */     {
/* 267 */       if ((this.bitField0_ & 0x1) != 0) {
/* 268 */         paramCodedOutputByteBufferNano.writeBool(1, this.performanceMonitoringEnabled_);
/*     */       }
/* 270 */       if ((this.bitField0_ & 0x2) != 0) {
/* 271 */         paramCodedOutputByteBufferNano.writeBool(2, this.sensorLoggingEnabled_);
/*     */       }
/* 273 */       if ((this.bitField0_ & 0x4) != 0) {
/* 274 */         paramCodedOutputByteBufferNano.writeBool(3, this.motophoPatchEnabled_);
/*     */       }
/* 276 */       super.writeTo(paramCodedOutputByteBufferNano);
/*     */     }
/*     */     
/*     */     protected final int computeSerializedSize()
/*     */     {
/* 281 */       int i = super.computeSerializedSize();
/* 282 */       if ((this.bitField0_ & 0x1) != 0)
/*     */       {
/* 284 */         i = i + CodedOutputByteBufferNano.computeBoolSize(1, this.performanceMonitoringEnabled_);
/*     */       }
/* 286 */       if ((this.bitField0_ & 0x2) != 0)
/*     */       {
/* 288 */         i = i + CodedOutputByteBufferNano.computeBoolSize(2, this.sensorLoggingEnabled_);
/*     */       }
/* 290 */       if ((this.bitField0_ & 0x4) != 0)
/*     */       {
/* 292 */         i = i + CodedOutputByteBufferNano.computeBoolSize(3, this.motophoPatchEnabled_);
/*     */       }
/* 294 */       return i;
/*     */     }
/*     */     
/*     */     public final DeveloperPrefs mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
/*     */       throws IOException
/*     */     {
/*     */       for (;;)
/*     */       {
/*     */         int i;
/* 303 */         switch (i = paramCodedInputByteBufferNano.readTag())
/*     */         {
/*     */         case 0: 
/* 305 */           return this;
/*     */         default: 
/* 307 */           if (!super.storeUnknownField(paramCodedInputByteBufferNano, i)) {
/* 308 */             return this;
/*     */           }
/*     */           
/*     */           break;
/*     */         case 8: 
/* 313 */           this.performanceMonitoringEnabled_ = paramCodedInputByteBufferNano.readBool();
/* 314 */           this.bitField0_ |= 0x1;
/* 315 */           break;
/*     */         
/*     */         case 16: 
/* 318 */           this.sensorLoggingEnabled_ = paramCodedInputByteBufferNano.readBool();
/* 319 */           this.bitField0_ |= 0x2;
/* 320 */           break;
/*     */         
/*     */         case 24: 
/* 323 */           this.motophoPatchEnabled_ = paramCodedInputByteBufferNano.readBool();
/* 324 */           this.bitField0_ |= 0x4;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     
/*     */     public static DeveloperPrefs parseFrom(byte[] paramArrayOfByte)
/*     */       throws InvalidProtocolBufferNanoException
/*     */     {
/* 333 */       return (DeveloperPrefs)MessageNano.mergeFrom(new DeveloperPrefs(), paramArrayOfByte);
/*     */     }
/*     */     
/*     */     public static DeveloperPrefs parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
/*     */       throws IOException
/*     */     {
/* 339 */       return new DeveloperPrefs().mergeFrom(paramCodedInputByteBufferNano);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vrtoolkit\cardboard\proto\nano\Preferences.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */