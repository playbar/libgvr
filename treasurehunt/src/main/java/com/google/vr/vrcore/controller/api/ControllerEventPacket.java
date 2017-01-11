/*     */ package com.google.vr.vrcore.controller.api;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.os.Parcelable.Creator;
/*     */ import java.util.ArrayDeque;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class ControllerEventPacket
/*     */   implements Parcelable
/*     */ {
/*     */   private static final int SERIALIZED_FORMAT_VERSION = 1;
/*     */   protected static final int MAX_EVENTS = 16;
/*  29 */   private static ArrayDeque<ControllerEventPacket> pool = new ArrayDeque();
/*     */   
/*     */ 
/*  32 */   private static Object poolLock = new Object();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int accelEventCount;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  46 */   private ControllerAccelEvent[] accelEvents = new ControllerAccelEvent[16];
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int buttonEventCount;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  60 */   private ControllerButtonEvent[] buttonEvents = new ControllerButtonEvent[16];
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int gyroEventCount;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  74 */   private ControllerGyroEvent[] gyroEvents = new ControllerGyroEvent[16];
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int orientationEventCount;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  88 */   private ControllerOrientationEvent[] orientationEvents = new ControllerOrientationEvent[16];
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int touchEventCount;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 103 */   private ControllerTouchEvent[] touchEvents = new ControllerTouchEvent[16];
/*     */   
/*     */   public ControllerEventPacket()
/*     */   {
/* 107 */     for (int i = 0; i < 16; i++)
/*     */     {
/*     */ 
/* 110 */       this.accelEvents[i] = new ControllerAccelEvent();
/* 111 */       this.buttonEvents[i] = new ControllerButtonEvent();
/* 112 */       this.gyroEvents[i] = new ControllerGyroEvent();
/* 113 */       this.orientationEvents[i] = new ControllerOrientationEvent();
/* 114 */       this.touchEvents[i] = new ControllerTouchEvent();
/*     */     }
/* 116 */     clear();
/*     */   }
/*     */   
/*     */   public void copyFrom(ControllerEventPacket paramControllerEventPacket)
/*     */   {
/* 121 */     this.accelEventCount = paramControllerEventPacket.accelEventCount;
/* 122 */     this.buttonEventCount = paramControllerEventPacket.buttonEventCount;
/* 123 */     this.gyroEventCount = paramControllerEventPacket.gyroEventCount;
/* 124 */     this.orientationEventCount = paramControllerEventPacket.orientationEventCount;
/* 125 */     this.touchEventCount = paramControllerEventPacket.touchEventCount;
/* 126 */     for (int i = 0; i < 16; i++) {
/* 127 */       this.accelEvents[i].copyFrom(paramControllerEventPacket.accelEvents[i]);
/* 128 */       this.buttonEvents[i].copyFrom(paramControllerEventPacket.buttonEvents[i]);
/* 129 */       this.gyroEvents[i].copyFrom(paramControllerEventPacket.gyroEvents[i]);
/* 130 */       this.orientationEvents[i].copyFrom(paramControllerEventPacket.orientationEvents[i]);
/* 131 */       this.touchEvents[i].copyFrom(paramControllerEventPacket.touchEvents[i]);
/*     */     }
/*     */   }
/*     */   
/*     */   protected ControllerEventPacket(Parcel paramParcel) {
/* 136 */     this();
/* 137 */     readFromParcel(paramParcel);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 141 */     this.accelEventCount = 0;
/* 142 */     this.buttonEventCount = 0;
/* 143 */     this.gyroEventCount = 0;
/* 144 */     this.orientationEventCount = 0;
/* 145 */     this.touchEventCount = 0;
/*     */   }
/*     */   
/*     */   public int getAccelEventCount() {
/* 149 */     return this.accelEventCount;
/*     */   }
/*     */   
/*     */   public int getButtonEventCount() {
/* 153 */     return this.buttonEventCount;
/*     */   }
/*     */   
/*     */   public int getGyroEventCount() {
/* 157 */     return this.gyroEventCount;
/*     */   }
/*     */   
/*     */   public int getOrientationEventCount() {
/* 161 */     return this.orientationEventCount;
/*     */   }
/*     */   
/*     */   public int getTouchEventCount() {
/* 165 */     return this.touchEventCount;
/*     */   }
/*     */   
/*     */   public ControllerAccelEvent getAccelEvent(int paramInt) {
/* 169 */     if ((paramInt < 0) || (paramInt >= this.accelEventCount)) {
/* 170 */       throw new IndexOutOfBoundsException();
/*     */     }
/* 172 */     return this.accelEvents[paramInt];
/*     */   }
/*     */   
/*     */   public ControllerButtonEvent getButtonEvent(int paramInt) {
/* 176 */     if ((paramInt < 0) || (paramInt >= this.buttonEventCount)) {
/* 177 */       throw new IndexOutOfBoundsException();
/*     */     }
/* 179 */     return this.buttonEvents[paramInt];
/*     */   }
/*     */   
/*     */   public ControllerGyroEvent getGyroEvent(int paramInt) {
/* 183 */     if ((paramInt < 0) || (paramInt >= this.gyroEventCount)) {
/* 184 */       throw new IndexOutOfBoundsException();
/*     */     }
/* 186 */     return this.gyroEvents[paramInt];
/*     */   }
/*     */   
/*     */   public ControllerOrientationEvent getOrientationEvent(int paramInt) {
/* 190 */     if ((paramInt < 0) || (paramInt >= this.orientationEventCount)) {
/* 191 */       throw new IndexOutOfBoundsException();
/*     */     }
/* 193 */     return this.orientationEvents[paramInt];
/*     */   }
/*     */   
/*     */   public ControllerTouchEvent getTouchEvent(int paramInt) {
/* 197 */     if ((paramInt < 0) || (paramInt >= this.touchEventCount)) {
/* 198 */       throw new IndexOutOfBoundsException();
/*     */     }
/* 200 */     return this.touchEvents[paramInt];
/*     */   }
/*     */   
/*     */   public ControllerAccelEvent addAccelEvent() {
/* 204 */     if (this.accelEventCount >= 16) {
/* 205 */       throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
/*     */     }
/* 207 */     return this.accelEvents[(this.accelEventCount++)];
/*     */   }
/*     */   
/*     */   public ControllerButtonEvent addButtonEvent() {
/* 211 */     if (this.buttonEventCount >= 16) {
/* 212 */       throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
/*     */     }
/* 214 */     return this.buttonEvents[(this.buttonEventCount++)];
/*     */   }
/*     */   
/*     */   public ControllerGyroEvent addGyroEvent() {
/* 218 */     if (this.gyroEventCount >= 16) {
/* 219 */       throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
/*     */     }
/* 221 */     return this.gyroEvents[(this.gyroEventCount++)];
/*     */   }
/*     */   
/*     */   public ControllerOrientationEvent addOrientationEvent() {
/* 225 */     if (this.orientationEventCount >= 16) {
/* 226 */       throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
/*     */     }
/* 228 */     return this.orientationEvents[(this.orientationEventCount++)];
/*     */   }
/*     */   
/*     */   public ControllerTouchEvent addTouchEvent() {
/* 232 */     if (this.touchEventCount >= 16) {
/* 233 */       throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
/*     */     }
/* 235 */     return this.touchEvents[(this.touchEventCount++)];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ControllerEventPacket obtain()
/*     */   {
/* 246 */     synchronized (poolLock) {
/* 247 */       return pool.isEmpty() ? new ControllerEventPacket() : (ControllerEventPacket)pool.remove();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void recycle()
/*     */   {
/* 257 */     clear();
/* 258 */     synchronized (poolLock) {
/* 259 */       if (!pool.contains(this))
/* 260 */         pool.add(this);
/*     */       return;
/*     */     }
/*     */   }
/*     */   
/* 265 */   public static final Parcelable.Creator<ControllerEventPacket> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */     public final ControllerEventPacket createFromParcel(Parcel paramAnonymousParcel)
/*     */     {
/*     */       ControllerEventPacket localControllerEventPacket;
/*     */       
/* 271 */       (localControllerEventPacket = ControllerEventPacket.obtain()).readFromParcel(paramAnonymousParcel);
/* 272 */       return localControllerEventPacket;
/*     */     }
/*     */     
/*     */     public final ControllerEventPacket[] newArray(int paramAnonymousInt)
/*     */     {
/* 277 */       return new ControllerEventPacket[paramAnonymousInt];
/*     */     }
/*     */   };
/*     */   
/*     */   public int describeContents()
/*     */   {
/* 283 */     return 0;
/*     */   }
/*     */   
/*     */   protected int calculateParcelByteLength()
/*     */   {
/* 288 */     int i = 4;
/*     */     
/*     */ 
/* 291 */     i += 20;
/*     */     
/* 293 */     for (int j = 0; j < this.accelEventCount; j++) {
/* 294 */       i += this.accelEvents[j].getByteSize();
/*     */     }
/*     */     
/* 297 */     for (j = 0; j < this.buttonEventCount; j++) {
/* 298 */       i += this.buttonEvents[j].getByteSize();
/*     */     }
/*     */     
/* 301 */     for (j = 0; j < this.gyroEventCount; j++) {
/* 302 */       i += this.gyroEvents[j].getByteSize();
/*     */     }
/*     */     
/* 305 */     for (j = 0; j < this.orientationEventCount; j++) {
/* 306 */       i += this.orientationEvents[j].getByteSize();
/*     */     }
/*     */     
/* 309 */     for (j = 0; j < this.touchEventCount; j++) {
/* 310 */       i += this.touchEvents[j].getByteSize();
/*     */     }
/* 312 */     return i;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt)
/*     */   {
/* 322 */     paramParcel.writeInt(1);
/*     */     
/* 324 */     paramParcel.writeInt(this.accelEventCount);
/* 325 */     for (int i = 0; i < this.accelEventCount; i++) {
/* 326 */       this.accelEvents[i].writeToParcel(paramParcel, paramInt);
/*     */     }
/*     */     
/* 329 */     paramParcel.writeInt(this.buttonEventCount);
/* 330 */     for (i = 0; i < this.buttonEventCount; i++) {
/* 331 */       this.buttonEvents[i].writeToParcel(paramParcel, paramInt);
/*     */     }
/*     */     
/* 334 */     paramParcel.writeInt(this.gyroEventCount);
/* 335 */     for (i = 0; i < this.gyroEventCount; i++) {
/* 336 */       this.gyroEvents[i].writeToParcel(paramParcel, paramInt);
/*     */     }
/*     */     
/* 339 */     paramParcel.writeInt(this.orientationEventCount);
/* 340 */     for (i = 0; i < this.orientationEventCount; i++) {
/* 341 */       this.orientationEvents[i].writeToParcel(paramParcel, paramInt);
/*     */     }
/*     */     
/* 344 */     paramParcel.writeInt(this.touchEventCount);
/* 345 */     for (i = 0; i < this.touchEventCount; i++) {
/* 346 */       this.touchEvents[i].writeToParcel(paramParcel, paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   public void readFromParcel(Parcel paramParcel)
/*     */   {
/* 352 */     paramParcel.readInt();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 358 */     this.accelEventCount = paramParcel.readInt();
/* 359 */     checkIsValidEventCount(this.accelEventCount);
/* 360 */     for (int i = 0; i < this.accelEventCount; i++) {
/* 361 */       this.accelEvents[i].readFromParcel(paramParcel);
/*     */     }
/*     */     
/* 364 */     this.buttonEventCount = paramParcel.readInt();
/* 365 */     checkIsValidEventCount(this.buttonEventCount);
/* 366 */     for (i = 0; i < this.buttonEventCount; i++) {
/* 367 */       this.buttonEvents[i].readFromParcel(paramParcel);
/*     */     }
/*     */     
/* 370 */     this.gyroEventCount = paramParcel.readInt();
/* 371 */     checkIsValidEventCount(this.gyroEventCount);
/* 372 */     for (i = 0; i < this.gyroEventCount; i++) {
/* 373 */       this.gyroEvents[i].readFromParcel(paramParcel);
/*     */     }
/*     */     
/* 376 */     this.orientationEventCount = paramParcel.readInt();
/* 377 */     checkIsValidEventCount(this.orientationEventCount);
/* 378 */     for (i = 0; i < this.orientationEventCount; i++) {
/* 379 */       this.orientationEvents[i].readFromParcel(paramParcel);
/*     */     }
/*     */     
/* 382 */     this.touchEventCount = paramParcel.readInt();
/* 383 */     checkIsValidEventCount(this.touchEventCount);
/* 384 */     for (i = 0; i < this.touchEventCount; i++) {
/* 385 */       this.touchEvents[i].readFromParcel(paramParcel);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void checkIsValidEventCount(int paramInt) {
/* 390 */     if ((paramInt < 0) || (paramInt >= 16)) {
/* 391 */       throw new IllegalArgumentException(32 + "Invalid event count: " + paramInt);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\controller\api\ControllerEventPacket.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */