/*    */ package com.google.vr.vrcore.logging.api;
/*    */ 
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable;
/*    */ import android.os.Parcelable.Creator;
/*    */ import android.util.Log;
/*    */ import com.google.common.logging.nano.Vr.VREvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VREventParcelable
/*    */   implements Parcelable
/*    */ {
/* 16 */   private static final String TAG = VREventParcelable.class.getSimpleName();
/*    */   private int eventCode;
/*    */   private Vr.VREvent event;
/*    */   
/*    */   public VREventParcelable(int paramInt, Vr.VREvent paramVREvent)
/*    */   {
/* 22 */     this.eventCode = paramInt;
/* 23 */     this.event = paramVREvent;
/*    */   }
/*    */   
/*    */   private VREventParcelable(Parcel paramParcel) {
/* 27 */     this.eventCode = paramParcel.readInt();
/*    */     try {
/*    */       byte[] arrayOfByte;
/* 30 */       if ((arrayOfByte = paramParcel.createByteArray()).length > 0)
/* 31 */         this.event = Vr.VREvent.parseFrom(arrayOfByte);
/*    */       return;
/*    */     } catch (Exception localException) {
/* 34 */       String str = String.valueOf(localException);Log.i(TAG, 35 + String.valueOf(str).length() + "Logging with empty VREvent. Error: " + str);
/*    */     }
/*    */   }
/*    */   
/*    */   public int describeContents()
/*    */   {
/* 40 */     return 0;
/*    */   }
/*    */   
/*    */   public void writeToParcel(Parcel paramParcel, int paramInt)
/*    */   {
/* 45 */     paramParcel.writeInt(this.eventCode);
/* 46 */     if (this.event != null) {
/* 47 */       paramParcel.writeByteArray(Vr.VREvent.toByteArray(this.event));
/*    */     }
/*    */   }
/*    */   
/*    */   public Vr.VREvent getEvent() {
/* 52 */     return this.event;
/*    */   }
/*    */   
/*    */   public int getEventCode() {
/* 56 */     return this.eventCode;
/*    */   }
/*    */   
/* 59 */   public static final Parcelable.Creator<VREventParcelable> CREATOR = new Parcelable.Creator()
/*    */   {
/*    */     public final VREventParcelable createFromParcel(Parcel paramAnonymousParcel) {
/* 62 */       return new VREventParcelable(paramAnonymousParcel, null);
/*    */     }
/*    */     
/*    */     public final VREventParcelable[] newArray(int paramAnonymousInt)
/*    */     {
/* 67 */       return new VREventParcelable[paramAnonymousInt];
/*    */     }
/*    */   };
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\logging\api\VREventParcelable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */