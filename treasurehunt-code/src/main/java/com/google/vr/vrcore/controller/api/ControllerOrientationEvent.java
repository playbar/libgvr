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
/*    */ public final class ControllerOrientationEvent
/*    */   extends ControllerEvent
/*    */ {
/*    */   public float qx;
/*    */   public float qy;
/*    */   public float qz;
/*    */   public float qw;
/*    */   
/*    */   public ControllerOrientationEvent() {}
/*    */   
/*    */   public ControllerOrientationEvent(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
/*    */   {
/* 26 */     this.qx = paramFloat1;
/* 27 */     this.qy = paramFloat2;
/* 28 */     this.qz = paramFloat3;
/* 29 */     this.qw = paramFloat4;
/*    */   }
/*    */   
/*    */   public ControllerOrientationEvent(Parcel paramParcel) {
/* 33 */     readFromParcel(paramParcel);
/*    */   }
/*    */   
/*    */   public final void set(ControllerOrientationEvent paramControllerOrientationEvent) {
/* 37 */     this.qx = paramControllerOrientationEvent.qx;
/* 38 */     this.qy = paramControllerOrientationEvent.qy;
/* 39 */     this.qz = paramControllerOrientationEvent.qz;
/* 40 */     this.qw = paramControllerOrientationEvent.qw;
/*    */   }
/*    */   
/* 43 */   public static final Parcelable.Creator<ControllerOrientationEvent> CREATOR = new Parcelable.Creator()
/*    */   {
/*    */     public final ControllerOrientationEvent createFromParcel(Parcel paramAnonymousParcel)
/*    */     {
/* 47 */       return new ControllerOrientationEvent(paramAnonymousParcel);
/*    */     }
/*    */     
/*    */     public final ControllerOrientationEvent[] newArray(int paramAnonymousInt)
/*    */     {
/* 52 */       return new ControllerOrientationEvent[paramAnonymousInt];
/*    */     }
/*    */   };
/*    */   
/*    */   public final int describeContents()
/*    */   {
/* 58 */     return 0;
/*    */   }
/*    */   
/*    */   public final void writeToParcel(Parcel paramParcel, int paramInt)
/*    */   {
/* 63 */     super.writeToParcel(paramParcel, paramInt);
/* 64 */     paramParcel.writeFloat(this.qx);
/* 65 */     paramParcel.writeFloat(this.qy);
/* 66 */     paramParcel.writeFloat(this.qz);
/* 67 */     paramParcel.writeFloat(this.qw);
/*    */   }
/*    */   
/*    */   public final void readFromParcel(Parcel paramParcel)
/*    */   {
/* 72 */     super.readFromParcel(paramParcel);
/* 73 */     this.qx = paramParcel.readFloat();
/* 74 */     this.qy = paramParcel.readFloat();
/* 75 */     this.qz = paramParcel.readFloat();
/* 76 */     this.qw = paramParcel.readFloat();
/*    */   }
/*    */   
/*    */   public final int getByteSize()
/*    */   {
/* 81 */     return super.getByteSize() + 16;
/*    */   }
/*    */   
/*    */   public final void copyFrom(ControllerEvent paramControllerEvent)
/*    */   {
/* 86 */     if (!(paramControllerEvent instanceof ControllerOrientationEvent)) {
/* 87 */       throw new IllegalStateException("Cannot copy ControllerOrientationEvent from non-ControllerOrientationEvent instance.");
/*    */     }
/*    */     
/* 90 */     super.copyFrom(paramControllerEvent);
/* 91 */     ControllerOrientationEvent localControllerOrientationEvent = (ControllerOrientationEvent)paramControllerEvent;
/* 92 */     this.qx = localControllerOrientationEvent.qx;
/* 93 */     this.qy = localControllerOrientationEvent.qy;
/* 94 */     this.qz = localControllerOrientationEvent.qz;
/* 95 */     this.qw = localControllerOrientationEvent.qw;
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\controller\api\ControllerOrientationEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */