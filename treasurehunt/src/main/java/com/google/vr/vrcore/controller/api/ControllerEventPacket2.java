/*     */ package com.google.vr.vrcore.controller.api;
/*     */ 
/*     */ import android.os.Parcel;
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
/*     */ public final class ControllerEventPacket2
/*     */   extends ControllerEventPacket
/*     */ {
/*  17 */   private static ArrayDeque<ControllerEventPacket2> pool = new ArrayDeque();
/*     */   
/*     */ 
/*  20 */   private static Object poolLock = new Object();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int positionEventCount;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  34 */   private ControllerPositionEvent[] positionEvents = new ControllerPositionEvent[16];
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ControllerEventPacket2()
/*     */   {
/*  43 */     for (int i = 0; i < 16; i++) {
/*  44 */       this.positionEvents[i] = new ControllerPositionEvent();
/*     */     }
/*  46 */     clear();
/*     */   }
/*     */   
/*     */   public final void clear()
/*     */   {
/*  51 */     super.clear();
/*  52 */     this.positionEventCount = 0;
/*     */   }
/*     */   
/*     */   public final int getPositionEventCount() {
/*  56 */     return this.positionEventCount;
/*     */   }
/*     */   
/*     */   public final ControllerPositionEvent getPositionEvent(int paramInt) {
/*  60 */     if ((paramInt < 0) || (paramInt >= this.positionEventCount)) {
/*  61 */       throw new IndexOutOfBoundsException();
/*     */     }
/*  63 */     return this.positionEvents[paramInt];
/*     */   }
/*     */   
/*     */   public final ControllerPositionEvent addPositionEvent() {
/*  67 */     if (this.positionEventCount >= 16) {
/*  68 */       throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
/*     */     }
/*  70 */     return this.positionEvents[(this.positionEventCount++)];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ControllerEventPacket2 obtain()
/*     */   {
/*  81 */     synchronized (poolLock) {
/*  82 */       return pool.isEmpty() ? new ControllerEventPacket2() : (ControllerEventPacket2)pool.remove();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void recycle()
/*     */   {
/*  93 */     clear();
/*  94 */     synchronized (poolLock) {
/*  95 */       if (!pool.contains(this))
/*  96 */         pool.add(this);
/*     */       return;
/*     */     }
/*     */   }
/*     */   
/* 101 */   public static final Parcelable.Creator<ControllerEventPacket2> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */     public final ControllerEventPacket2 createFromParcel(Parcel paramAnonymousParcel)
/*     */     {
/*     */       ControllerEventPacket2 localControllerEventPacket2;
/*     */       
/* 107 */       (localControllerEventPacket2 = ControllerEventPacket2.obtain()).readFromParcel(paramAnonymousParcel);
/* 108 */       return localControllerEventPacket2;
/*     */     }
/*     */     
/*     */     public final ControllerEventPacket2[] newArray(int paramAnonymousInt)
/*     */     {
/* 113 */       return new ControllerEventPacket2[paramAnonymousInt];
/*     */     }
/*     */   };
/*     */   
/*     */   public final int describeContents()
/*     */   {
/* 119 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   protected final int calculateParcelByteLength()
/*     */   {
/* 125 */     int i = super.calculateParcelByteLength();
/*     */     
/* 127 */     i += 4;
/*     */     
/* 129 */     i += 4;
/*     */     
/* 131 */     for (int j = 0; j < this.positionEventCount; j++) {
/* 132 */       i += this.positionEvents[j].getByteSize();
/*     */     }
/*     */     
/* 135 */     return i;
/*     */   }
/*     */   
/*     */ 
/*     */   public final void writeToParcel(Parcel paramParcel, int paramInt)
/*     */   {
/* 141 */     int i = paramParcel.dataPosition();
/*     */     
/* 143 */     int j = calculateParcelByteLength();
/*     */     
/* 145 */     paramParcel.writeInt(j);
/*     */     
/* 147 */     super.writeToParcel(paramParcel, paramInt);
/*     */     
/* 149 */     paramParcel.writeInt(this.positionEventCount);
/*     */     
/* 151 */     for (int k = 0; k < this.positionEventCount; k++) {
/* 152 */       this.positionEvents[k].writeToParcel(paramParcel, paramInt);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 158 */     if (paramParcel.dataPosition() - i != j) {
/* 159 */       throw new IllegalStateException("Parcelable implemented incorrectly, getByteSize() must return the correct size for each ControllerEvent subclass.");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final void readFromParcel(Parcel paramParcel)
/*     */   {
/* 168 */     int i = paramParcel.dataPosition();
/*     */     
/* 170 */     int j = paramParcel.readInt();
/*     */     
/* 172 */     super.readFromParcel(paramParcel);
/*     */     
/* 174 */     this.positionEventCount = paramParcel.readInt();
/*     */     
/* 176 */     checkIsValidEventCount(this.positionEventCount);
/*     */     
/* 178 */     for (int k = 0; k < this.positionEventCount; k++) {
/* 179 */       this.positionEvents[k].readFromParcel(paramParcel);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 185 */     paramParcel.setDataPosition(i + j);
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\controller\api\ControllerEventPacket2.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */