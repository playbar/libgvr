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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ControllerTouchEvent
/*     */   extends ControllerEvent
/*     */ {
/*     */   public static final int ACTION_NONE = 0;
/*     */   public static final int ACTION_DOWN = 1;
/*     */   public static final int ACTION_MOVE = 2;
/*     */   public static final int ACTION_UP = 3;
/*     */   public static final int ACTION_CANCEL = 4;
/*     */   public int fingerId;
/*     */   public int action;
/*     */   public float x;
/*     */   public float y;
/*     */   
/*     */   public ControllerTouchEvent() {}
/*     */   
/*     */   public ControllerTouchEvent(Parcel paramParcel)
/*     */   {
/*  62 */     readFromParcel(paramParcel);
/*     */   }
/*     */   
/*  65 */   public static final Parcelable.Creator<ControllerTouchEvent> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */     public final ControllerTouchEvent createFromParcel(Parcel paramAnonymousParcel) {
/*  68 */       return new ControllerTouchEvent(paramAnonymousParcel);
/*     */     }
/*     */     
/*     */     public final ControllerTouchEvent[] newArray(int paramAnonymousInt)
/*     */     {
/*  73 */       return new ControllerTouchEvent[paramAnonymousInt];
/*     */     }
/*     */   };
/*     */   
/*     */   public final int describeContents()
/*     */   {
/*  79 */     return 0;
/*     */   }
/*     */   
/*     */   public final void writeToParcel(Parcel paramParcel, int paramInt)
/*     */   {
/*  84 */     super.writeToParcel(paramParcel, paramInt);
/*  85 */     paramParcel.writeInt(this.fingerId);
/*  86 */     paramParcel.writeInt(this.action);
/*  87 */     paramParcel.writeFloat(this.x);
/*  88 */     paramParcel.writeFloat(this.y);
/*     */   }
/*     */   
/*     */   public final void readFromParcel(Parcel paramParcel)
/*     */   {
/*  93 */     super.readFromParcel(paramParcel);
/*  94 */     this.fingerId = paramParcel.readInt();
/*  95 */     this.action = paramParcel.readInt();
/*  96 */     this.x = paramParcel.readFloat();
/*  97 */     this.y = paramParcel.readFloat();
/*     */   }
/*     */   
/*     */   public final int getByteSize()
/*     */   {
/* 102 */     return super.getByteSize() + 8 + 8;
/*     */   }
/*     */   
/*     */   public final void copyFrom(ControllerEvent paramControllerEvent)
/*     */   {
/* 107 */     if (!(paramControllerEvent instanceof ControllerTouchEvent)) {
/* 108 */       throw new IllegalStateException("Cannot copy ControllerTouchEvent from non-ControllerTouchEvent instance.");
/*     */     }
/*     */     
/* 111 */     super.copyFrom(paramControllerEvent);
/* 112 */     ControllerTouchEvent localControllerTouchEvent = (ControllerTouchEvent)paramControllerEvent;
/* 113 */     this.fingerId = localControllerTouchEvent.fingerId;
/* 114 */     this.action = localControllerTouchEvent.action;
/* 115 */     this.x = localControllerTouchEvent.x;
/* 116 */     this.y = localControllerTouchEvent.y;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\controller\api\ControllerTouchEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */