/*    */ package com.google.vr.vrcore.controller.api;
/*    */ 
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable.Creator;
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
/*    */ public final class ControllerGyroEvent
/*    */   extends ControllerEvent
/*    */ {
/*    */   public float x;
/*    */   public float y;
/*    */   public float z;
/*    */   
/*    */   public ControllerGyroEvent() {}
/*    */   
/*    */   public ControllerGyroEvent(Parcel paramParcel)
/*    */   {
/* 44 */     readFromParcel(paramParcel);
/*    */   }
/*    */   
/* 47 */   public static final Parcelable.Creator<ControllerGyroEvent> CREATOR = new Parcelable.Creator()
/*    */   {
/*    */     public final ControllerGyroEvent createFromParcel(Parcel paramAnonymousParcel)
/*    */     {
/* 51 */       return new ControllerGyroEvent(paramAnonymousParcel);
/*    */     }
/*    */     
/*    */     public final ControllerGyroEvent[] newArray(int paramAnonymousInt)
/*    */     {
/* 56 */       return new ControllerGyroEvent[paramAnonymousInt];
/*    */     }
/*    */   };
/*    */   
/*    */   public final int describeContents()
/*    */   {
/* 62 */     return 0;
/*    */   }
/*    */   
/*    */   public final void writeToParcel(Parcel paramParcel, int paramInt)
/*    */   {
/* 67 */     super.writeToParcel(paramParcel, paramInt);
/* 68 */     paramParcel.writeFloat(this.x);
/* 69 */     paramParcel.writeFloat(this.y);
/* 70 */     paramParcel.writeFloat(this.z);
/*    */   }
/*    */   
/*    */   public final void readFromParcel(Parcel paramParcel)
/*    */   {
/* 75 */     super.readFromParcel(paramParcel);
/* 76 */     this.x = paramParcel.readFloat();
/* 77 */     this.y = paramParcel.readFloat();
/* 78 */     this.z = paramParcel.readFloat();
/*    */   }
/*    */   
/*    */   public final int getByteSize()
/*    */   {
/* 83 */     return super.getByteSize() + 12;
/*    */   }
/*    */   
/*    */   public final void copyFrom(ControllerEvent paramControllerEvent)
/*    */   {
/* 88 */     if (!(paramControllerEvent instanceof ControllerGyroEvent)) {
/* 89 */       throw new IllegalStateException("Cannot copy ControllerGyroEvent from non-ControllerGyroEvent instance.");
/*    */     }
/*    */     
/* 92 */     super.copyFrom(paramControllerEvent);
/* 93 */     ControllerGyroEvent localControllerGyroEvent = (ControllerGyroEvent)paramControllerEvent;
/* 94 */     this.x = localControllerGyroEvent.x;
/* 95 */     this.y = localControllerGyroEvent.y;
/* 96 */     this.z = localControllerGyroEvent.z;
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\controller\api\ControllerGyroEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */