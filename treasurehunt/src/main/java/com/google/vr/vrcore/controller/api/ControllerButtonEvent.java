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
/*     */ public final class ControllerButtonEvent
/*     */   extends ControllerEvent
/*     */ {
/*     */   public static final int BUTTON_NONE = 0;
/*     */   public static final int BUTTON_CLICK = 1;
/*     */   public static final int BUTTON_HOME = 2;
/*     */   public static final int BUTTON_APP = 3;
/*     */   public static final int BUTTON_VOLUME_UP = 5;
/*     */   public static final int BUTTON_VOLUME_DOWN = 6;
/*     */   public static final int BUTTON_COUNT = 7;
/*     */   public int button;
/*     */   public boolean down;
/*     */   
/*     */   public ControllerButtonEvent() {}
/*     */   
/*     */   public ControllerButtonEvent(Parcel paramParcel)
/*     */   {
/*  41 */     readFromParcel(paramParcel);
/*     */   }
/*     */   
/*  44 */   public static final Parcelable.Creator<ControllerButtonEvent> CREATOR = new Parcelable.Creator()
/*     */   {
/*     */     public final ControllerButtonEvent createFromParcel(Parcel paramAnonymousParcel)
/*     */     {
/*  48 */       return new ControllerButtonEvent(paramAnonymousParcel);
/*     */     }
/*     */     
/*     */     public final ControllerButtonEvent[] newArray(int paramAnonymousInt)
/*     */     {
/*  53 */       return new ControllerButtonEvent[paramAnonymousInt];
/*     */     }
/*     */   };
/*     */   
/*     */   public final int describeContents()
/*     */   {
/*  59 */     return 0;
/*     */   }
/*     */   
/*     */   public final void writeToParcel(Parcel paramParcel, int paramInt)
/*     */   {
/*  64 */     super.writeToParcel(paramParcel, paramInt);
/*  65 */     paramParcel.writeInt(this.button);
/*  66 */     paramParcel.writeInt(this.down ? 1 : 0);
/*     */   }
/*     */   
/*     */   public final void readFromParcel(Parcel paramParcel)
/*     */   {
/*  71 */     super.readFromParcel(paramParcel);
/*  72 */     this.button = paramParcel.readInt();
/*  73 */     this.down = (0 != paramParcel.readInt());
/*     */   }
/*     */   
/*     */   public static String buttonToString(int paramInt)
/*     */   {
/*  78 */     switch (paramInt) {
/*     */     case 0: 
/*  80 */       return "BUTTON_NONE";
/*     */     case 1: 
/*  82 */       return "BUTTON_CLICK";
/*     */     case 2: 
/*  84 */       return "BUTTON_HOME";
/*     */     case 3: 
/*  86 */       return "BUTTON_APP";
/*     */     case 5: 
/*  88 */       return "BUTTON_VOLUME_UP";
/*     */     case 6: 
/*  90 */       return "BUTTON_VOLUME_DOWN";
/*     */     }
/*  92 */     return 29 + "[Unknown button: " + paramInt + "]";
/*     */   }
/*     */   
/*     */ 
/*     */   public final int getByteSize()
/*     */   {
/*  98 */     return super.getByteSize() + 8;
/*     */   }
/*     */   
/*     */   public final void copyFrom(ControllerEvent paramControllerEvent)
/*     */   {
/* 103 */     if (!(paramControllerEvent instanceof ControllerButtonEvent)) {
/* 104 */       throw new IllegalStateException("Cannot copy ControllerButtonEvent from non-ControllerButtonEvent instance.");
/*     */     }
/*     */     
/* 107 */     super.copyFrom(paramControllerEvent);
/* 108 */     ControllerButtonEvent localControllerButtonEvent = (ControllerButtonEvent)paramControllerEvent;
/* 109 */     this.button = localControllerButtonEvent.button;
/* 110 */     this.down = localControllerButtonEvent.down;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\controller\api\ControllerButtonEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */