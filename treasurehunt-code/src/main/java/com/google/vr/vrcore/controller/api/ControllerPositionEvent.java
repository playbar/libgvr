/*    */ package com.google.vr.vrcore.controller.api;
/*    */ 
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable;
/*    */ 
/*    */ 
/*    */ public final class ControllerPositionEvent
/*    */   extends ControllerEvent
/*    */ {
/*    */   public float x;
/*    */   public float y;
/*    */   public float z;
/*    */   
/*    */   public ControllerPositionEvent() {}
/*    */   
/*    */   public ControllerPositionEvent(Parcel paramParcel)
/*    */   {
/* 18 */     readFromParcel(paramParcel);
/*    */   }
/*    */   
/* 21 */   public static final Parcelable.Creator<ControllerPositionEvent> CREATOR = new Parcelable.Creator()
/*    */   {
/*    */     public final ControllerPositionEvent createFromParcel(Parcel paramAnonymousParcel)
/*    */     {
/* 25 */       return new ControllerPositionEvent(paramAnonymousParcel);
/*    */     }
/*    */     
/*    */     public final ControllerPositionEvent[] newArray(int paramAnonymousInt)
/*    */     {
/* 30 */       return new ControllerPositionEvent[paramAnonymousInt];
/*    */     }
/*    */   };
/*    */   
/*    */   public final int describeContents()
/*    */   {
/* 36 */     return 0;
/*    */   }
/*    */   
/*    */   public final void writeToParcel(Parcel paramParcel, int paramInt)
/*    */   {
/* 41 */     super.writeToParcel(paramParcel, paramInt);
/* 42 */     paramParcel.writeFloat(this.x);
/* 43 */     paramParcel.writeFloat(this.y);
/* 44 */     paramParcel.writeFloat(this.z);
/*    */   }
/*    */   
/*    */   public final void readFromParcel(Parcel paramParcel)
/*    */   {
/* 49 */     super.readFromParcel(paramParcel);
/* 50 */     this.x = paramParcel.readFloat();
/* 51 */     this.y = paramParcel.readFloat();
/* 52 */     this.z = paramParcel.readFloat();
/*    */   }
/*    */   
/*    */   public final int getByteSize()
/*    */   {
/* 57 */     return super.getByteSize() + 12;
/*    */   }
/*    */   
/*    */   public final void copyFrom(ControllerEvent paramControllerEvent)
/*    */   {
/* 62 */     if (!(paramControllerEvent instanceof ControllerPositionEvent)) {
/* 63 */       throw new IllegalStateException("Cannot copy ControllerPositionEvent from non-ControllerPositionEvent instance.");
/*    */     }
/*    */     
/* 66 */     super.copyFrom(paramControllerEvent);
/* 67 */     ControllerPositionEvent localControllerPositionEvent = (ControllerPositionEvent)paramControllerEvent;
/* 68 */     this.x = localControllerPositionEvent.x;
/* 69 */     this.y = localControllerPositionEvent.y;
/* 70 */     this.z = localControllerPositionEvent.z;
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\controller\api\ControllerPositionEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */