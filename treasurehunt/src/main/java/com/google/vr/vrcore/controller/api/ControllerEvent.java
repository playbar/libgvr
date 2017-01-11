/*    */ package com.google.vr.vrcore.controller.api;
/*    */ 
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ControllerEvent
/*    */   implements Parcelable
/*    */ {
/*    */   public static final int CONTROLLER_ID_DEFAULT = 0;
/*    */   public long timestampNanos;
/* 25 */   public int controllerId = 0;
/*    */   
/*    */   public void writeToParcel(Parcel paramParcel, int paramInt)
/*    */   {
/* 29 */     paramParcel.writeLong(this.timestampNanos);
/* 30 */     paramParcel.writeInt(this.controllerId);
/*    */   }
/*    */   
/*    */   public void readFromParcel(Parcel paramParcel) {
/* 34 */     this.timestampNanos = paramParcel.readLong();
/* 35 */     this.controllerId = paramParcel.readInt();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getByteSize()
/*    */   {
/* 44 */     return 12;
/*    */   }
/*    */   
/*    */   public void copyFrom(ControllerEvent paramControllerEvent)
/*    */   {
/* 49 */     this.timestampNanos = paramControllerEvent.timestampNanos;
/* 50 */     this.controllerId = paramControllerEvent.controllerId;
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\controller\api\ControllerEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */