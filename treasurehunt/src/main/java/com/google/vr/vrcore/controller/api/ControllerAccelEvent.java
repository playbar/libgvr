/*     */ package com.google.vr.vrcore.controller.api;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable.Creator;
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
/*     */ public final class ControllerAccelEvent
/*     */   extends ControllerEvent
/*     */ {
/*     */   public float x;
/*     */   public float y;
/*     */   public float z;
/*     */   
/*     */   public ControllerAccelEvent() {}
/*     */   
/*     */   public ControllerAccelEvent(Parcel paramParcel)
/*     */   {
/*  48 */     readFromParcel(paramParcel);
/*     */   }
/*     */   
/*  51 */   public static final Parcelable.Creator<ControllerAccelEvent> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */     public final ControllerAccelEvent createFromParcel(Parcel paramAnonymousParcel)
/*     */     {
/*  55 */       return new ControllerAccelEvent(paramAnonymousParcel);
/*     */     }
/*     */     
/*     */     public final ControllerAccelEvent[] newArray(int paramAnonymousInt)
/*     */     {
/*  60 */       return new ControllerAccelEvent[paramAnonymousInt];
/*     */     }
/*     */   };
/*     */   
/*     */   public final int describeContents()
/*     */   {
/*  66 */     return 0;
/*     */   }
/*     */   
/*     */   public final void writeToParcel(Parcel paramParcel, int paramInt)
/*     */   {
/*  71 */     super.writeToParcel(paramParcel, paramInt);
/*  72 */     paramParcel.writeFloat(this.x);
/*  73 */     paramParcel.writeFloat(this.y);
/*  74 */     paramParcel.writeFloat(this.z);
/*     */   }
/*     */   
/*     */   public final void readFromParcel(Parcel paramParcel)
/*     */   {
/*  79 */     super.readFromParcel(paramParcel);
/*  80 */     this.x = paramParcel.readFloat();
/*  81 */     this.y = paramParcel.readFloat();
/*  82 */     this.z = paramParcel.readFloat();
/*     */   }
/*     */   
/*     */   public final int getByteSize()
/*     */   {
/*  87 */     return super.getByteSize() + 12;
/*     */   }
/*     */   
/*     */   public final void copyFrom(ControllerEvent paramControllerEvent)
/*     */   {
/*  92 */     if (!(paramControllerEvent instanceof ControllerAccelEvent)) {
/*  93 */       throw new IllegalStateException("Cannot copy ControllerAccelEvent from non-ControllerAccelEvent instance.");
/*     */     }
/*     */     
/*  96 */     super.copyFrom(paramControllerEvent);
/*  97 */     ControllerAccelEvent localControllerAccelEvent = (ControllerAccelEvent)paramControllerEvent;
/*  98 */     this.x = localControllerAccelEvent.x;
/*  99 */     this.y = localControllerAccelEvent.y;
/* 100 */     this.z = localControllerAccelEvent.z;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\controller\api\ControllerAccelEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */