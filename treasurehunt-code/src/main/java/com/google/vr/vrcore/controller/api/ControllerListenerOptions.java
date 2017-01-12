/*    */ package com.google.vr.vrcore.controller.api;
/*    */ 
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable;
/*    */ import android.os.Parcelable.Creator;
/*    */ import java.util.Locale;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ControllerListenerOptions
/*    */   implements Parcelable
/*    */ {
/*    */   public boolean enableOrientation;
/*    */   public boolean enableGyro;
/*    */   public boolean enableAccel;
/*    */   public boolean enableTouch;
/*    */   public boolean enableGestures;
/*    */   
/*    */   public ControllerListenerOptions()
/*    */   {
/* 24 */     this.enableOrientation = true;
/* 25 */     this.enableTouch = true;
/*    */   }
/*    */   
/*    */   protected ControllerListenerOptions(Parcel paramParcel) {
/* 29 */     readFromParcel(paramParcel);
/*    */   }
/*    */   
/* 32 */   public static final Parcelable.Creator<ControllerListenerOptions> CREATOR = new Parcelable.Creator()
/*    */   {
/*    */     public final ControllerListenerOptions createFromParcel(Parcel paramAnonymousParcel)
/*    */     {
/* 36 */       return new ControllerListenerOptions(paramAnonymousParcel);
/*    */     }
/*    */     
/*    */     public final ControllerListenerOptions[] newArray(int paramAnonymousInt)
/*    */     {
/* 41 */       return new ControllerListenerOptions[paramAnonymousInt];
/*    */     }
/*    */   };
/*    */   
/*    */   public int describeContents()
/*    */   {
/* 47 */     return 0;
/*    */   }
/*    */   
/*    */   public void writeToParcel(Parcel paramParcel, int paramInt)
/*    */   {
/* 52 */     paramParcel.writeInt(this.enableOrientation ? 1 : 0);
/* 53 */     paramParcel.writeInt(this.enableGyro ? 1 : 0);
/* 54 */     paramParcel.writeInt(this.enableAccel ? 1 : 0);
/* 55 */     paramParcel.writeInt(this.enableTouch ? 1 : 0);
/* 56 */     paramParcel.writeInt(this.enableGestures ? 1 : 0);
/*    */   }
/*    */   
/*    */   public void readFromParcel(Parcel paramParcel) {
/* 60 */     this.enableOrientation = (paramParcel.readInt() != 0);
/* 61 */     this.enableGyro = (paramParcel.readInt() != 0);
/* 62 */     this.enableAccel = (paramParcel.readInt() != 0);
/* 63 */     this.enableTouch = (paramParcel.readInt() != 0);
/* 64 */     this.enableGestures = (paramParcel.readInt() != 0);
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 69 */     return String.format(Locale.US, "ori=%b, gyro=%b, accel=%b, touch=%b, gestures=%b", new Object[] {
/* 70 */       Boolean.valueOf(this.enableOrientation), Boolean.valueOf(this.enableGyro), Boolean.valueOf(this.enableAccel), Boolean.valueOf(this.enableTouch), Boolean.valueOf(this.enableGestures) });
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\controller\api\ControllerListenerOptions.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */