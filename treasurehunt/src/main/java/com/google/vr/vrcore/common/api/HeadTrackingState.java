/*     */ package com.google.vr.vrcore.common.api;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.os.Parcelable.Creator;
/*     */ import java.util.Arrays;
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
/*     */ public class HeadTrackingState
/*     */   implements Parcelable
/*     */ {
/*  20 */   private byte[] data = new byte[0];
/*     */   
/*     */   public HeadTrackingState() {}
/*     */   
/*  24 */   public HeadTrackingState(byte[] paramArrayOfByte) { this.data = paramArrayOfByte; }
/*     */   
/*     */   private HeadTrackingState(Parcel paramParcel)
/*     */   {
/*  28 */     readFromParcel(paramParcel);
/*     */   }
/*     */   
/*     */   public byte[] getData() {
/*  32 */     return this.data;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  36 */     return this.data.length == 0;
/*     */   }
/*     */   
/*     */   public void setData(byte[] paramArrayOfByte) {
/*  40 */     this.data = paramArrayOfByte;
/*     */   }
/*     */   
/*     */   public void clear() {
/*  44 */     this.data = new byte[0];
/*     */   }
/*     */   
/*  47 */   public static final Parcelable.Creator<HeadTrackingState> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */     public final HeadTrackingState createFromParcel(Parcel paramAnonymousParcel) {
/*  50 */       return new HeadTrackingState(paramAnonymousParcel, null);
/*     */     }
/*     */     
/*     */     public final HeadTrackingState[] newArray(int paramAnonymousInt)
/*     */     {
/*  55 */       return new HeadTrackingState[paramAnonymousInt];
/*     */     }
/*     */   };
/*     */   
/*     */   public int describeContents()
/*     */   {
/*  61 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt)
/*     */   {
/*  66 */     paramParcel.writeInt(this.data.length);
/*  67 */     paramParcel.writeByteArray(this.data);
/*     */   }
/*     */   
/*     */   public void readFromParcel(Parcel paramParcel) {
/*  71 */     int i = paramParcel.readInt();
/*  72 */     this.data = new byte[i];
/*  73 */     paramParcel.readByteArray(this.data);
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/*  78 */     int i = this.data.length;return 36 + "HeadTrackingState[" + i + " bytes]";
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject)
/*     */   {
/*  83 */     if (paramObject == this) {
/*  84 */       return true;
/*     */     }
/*     */     
/*  87 */     if ((paramObject instanceof HeadTrackingState)) {
/*  88 */       return Arrays.equals(((HeadTrackingState)paramObject).data, this.data);
/*     */     }
/*     */     
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/*  96 */     return Arrays.hashCode(this.data);
/*     */   }
/*     */   
/*     */   public void copyFrom(HeadTrackingState paramHeadTrackingState) {
/* 100 */     Parcel localParcel = Parcel.obtain();
/* 101 */     paramHeadTrackingState.writeToParcel(localParcel, 0);
/* 102 */     localParcel.setDataPosition(0);
/* 103 */     readFromParcel(localParcel);
/* 104 */     localParcel.recycle();
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\common\api\HeadTrackingState.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */