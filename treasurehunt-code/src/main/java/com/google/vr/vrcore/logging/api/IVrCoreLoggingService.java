/*     */ package com.google.vr.vrcore.logging.api;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable.Creator;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ 
/*     */ public abstract interface IVrCoreLoggingService
/*     */   extends IInterface
/*     */ {
/*     */   public abstract void log(VREventParcelable paramVREventParcelable)
/*     */     throws RemoteException;
/*     */   
/*     */   public abstract void logBatched(VREventParcelable[] paramArrayOfVREventParcelable)
/*     */     throws RemoteException;
/*     */   
/*     */   public static abstract class Stub
/*     */     extends Binder
/*     */     implements IVrCoreLoggingService
/*     */   {
/*     */     private static final String DESCRIPTOR = "com.google.vr.vrcore.logging.api.IVrCoreLoggingService";
/*     */     static final int TRANSACTION_log = 2;
/*     */     static final int TRANSACTION_logBatched = 3;
/*     */     
/*     */     public Stub()
/*     */     {
/*  30 */       attachInterface(this, "com.google.vr.vrcore.logging.api.IVrCoreLoggingService");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public static IVrCoreLoggingService asInterface(IBinder paramIBinder)
/*     */     {
/*  38 */       if (paramIBinder == null) {
/*  39 */         return null;
/*     */       }
/*     */       IInterface localIInterface;
/*  42 */       if (((localIInterface = paramIBinder.queryLocalInterface("com.google.vr.vrcore.logging.api.IVrCoreLoggingService")) != null) && ((localIInterface instanceof IVrCoreLoggingService))) {
/*  43 */         return (IVrCoreLoggingService)localIInterface;
/*     */       }
/*  45 */       return new Proxy(paramIBinder);
/*     */     }
/*     */     
/*     */ 
/*  49 */     public IBinder asBinder() { return this; }
/*     */     
/*     */     public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
/*     */       Object localObject;
/*  53 */       switch (paramInt1)
/*     */       {
/*     */ 
/*     */       case 1598968902: 
/*  57 */         paramParcel2.writeString("com.google.vr.vrcore.logging.api.IVrCoreLoggingService");
/*  58 */         return true;
/*     */       
/*     */ 
/*     */       case 2: 
/*  62 */         paramParcel1.enforceInterface("com.google.vr.vrcore.logging.api.IVrCoreLoggingService");
/*     */         
/*  64 */         if (0 != paramParcel1.readInt()) {
/*  65 */           localObject = (VREventParcelable)VREventParcelable.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/*  68 */           localObject = null;
/*     */         }
/*  70 */         log((VREventParcelable)localObject);
/*  71 */         return true;
/*     */       
/*     */ 
/*     */       case 3: 
/*  75 */         paramParcel1.enforceInterface("com.google.vr.vrcore.logging.api.IVrCoreLoggingService");
/*     */         
/*  77 */         localObject = (VREventParcelable[])paramParcel1.createTypedArray(VREventParcelable.CREATOR);
/*  78 */         logBatched((VREventParcelable[])localObject);
/*  79 */         return true;
/*     */       }
/*     */       
/*  82 */       return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
/*     */     }
/*     */     
/*     */     private static class Proxy implements IVrCoreLoggingService {
/*     */       private IBinder mRemote;
/*     */       
/*     */       Proxy(IBinder paramIBinder) {
/*  89 */         this.mRemote = paramIBinder;
/*     */       }
/*     */       
/*     */       public IBinder asBinder() {
/*  93 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  97 */         return "com.google.vr.vrcore.logging.api.IVrCoreLoggingService";
/*     */       }
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
/*     */       public void log(VREventParcelable paramVREventParcelable)
/*     */         throws RemoteException
/*     */       {
/* 112 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 114 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.logging.api.IVrCoreLoggingService");
/* 115 */           if (paramVREventParcelable != null) {
/* 116 */             localParcel.writeInt(1);
/* 117 */             paramVREventParcelable.writeToParcel(localParcel, 0);
/*     */           }
/*     */           else {
/* 120 */             localParcel.writeInt(0);
/*     */           }
/* 122 */           this.mRemote.transact(2, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 125 */           localParcel.recycle();
/*     */         }
/*     */       }
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
/*     */       public void logBatched(VREventParcelable[] paramArrayOfVREventParcelable)
/*     */         throws RemoteException
/*     */       {
/* 143 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 145 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.logging.api.IVrCoreLoggingService");
/* 146 */           localParcel.writeTypedArray(paramArrayOfVREventParcelable, 0);
/* 147 */           this.mRemote.transact(3, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 150 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\logging\api\IVrCoreLoggingService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */