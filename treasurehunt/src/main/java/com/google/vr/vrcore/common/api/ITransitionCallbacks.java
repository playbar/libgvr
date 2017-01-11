/*    */ package com.google.vr.vrcore.common.api;
/*    */ 
/*    */ import android.os.Binder;
/*    */ import android.os.IBinder;
/*    */ import android.os.IInterface;
/*    */ import android.os.Parcel;
/*    */ import android.os.RemoteException;
/*    */ 
/*    */ 
/*    */ public abstract interface ITransitionCallbacks
/*    */   extends IInterface
/*    */ {
/*    */   public abstract void onTransitionComplete()
/*    */     throws RemoteException;
/*    */   
/*    */   public static abstract class Stub
/*    */     extends Binder
/*    */     implements ITransitionCallbacks
/*    */   {
/*    */     private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.ITransitionCallbacks";
/*    */     static final int TRANSACTION_onTransitionComplete = 1;
/*    */     
/*    */     public Stub()
/*    */     {
/* 25 */       attachInterface(this, "com.google.vr.vrcore.common.api.ITransitionCallbacks");
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     public static ITransitionCallbacks asInterface(IBinder paramIBinder)
/*    */     {
/* 33 */       if (paramIBinder == null) {
/* 34 */         return null;
/*    */       }
/*    */       IInterface localIInterface;
/* 37 */       if (((localIInterface = paramIBinder.queryLocalInterface("com.google.vr.vrcore.common.api.ITransitionCallbacks")) != null) && ((localIInterface instanceof ITransitionCallbacks))) {
/* 38 */         return (ITransitionCallbacks)localIInterface;
/*    */       }
/* 40 */       return new Proxy(paramIBinder);
/*    */     }
/*    */     
/*    */     public IBinder asBinder() {
/* 44 */       return this;
/*    */     }
/*    */     
/*    */     public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
/* 48 */       switch (paramInt1)
/*    */       {
/*    */ 
/*    */       case 1598968902: 
/* 52 */         paramParcel2.writeString("com.google.vr.vrcore.common.api.ITransitionCallbacks");
/* 53 */         return true;
/*    */       
/*    */ 
/*    */       case 1: 
/* 57 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.ITransitionCallbacks");
/* 58 */         onTransitionComplete();
/* 59 */         return true;
/*    */       }
/*    */       
/* 62 */       return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
/*    */     }
/*    */     
/*    */     private static class Proxy implements ITransitionCallbacks {
/*    */       private IBinder mRemote;
/*    */       
/*    */       Proxy(IBinder paramIBinder) {
/* 69 */         this.mRemote = paramIBinder;
/*    */       }
/*    */       
/*    */       public IBinder asBinder() {
/* 73 */         return this.mRemote;
/*    */       }
/*    */       
/*    */       public String getInterfaceDescriptor() {
/* 77 */         return "com.google.vr.vrcore.common.api.ITransitionCallbacks";
/*    */       }
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */       public void onTransitionComplete()
/*    */         throws RemoteException
/*    */       {
/* 86 */         Parcel localParcel = Parcel.obtain();
/*    */         try {
/* 88 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.common.api.ITransitionCallbacks");
/* 89 */           this.mRemote.transact(1, localParcel, null, 1);
/*    */         }
/*    */         finally {
/* 92 */           localParcel.recycle();
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\common\api\ITransitionCallbacks.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */