/*    */ package com.google.vr.vrcore.library.api;
/*    */ 
/*    */ import android.os.Binder;
/*    */ import android.os.IBinder;
/*    */ import android.os.IInterface;
/*    */ import android.os.Parcel;
/*    */ import android.os.RemoteException;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract interface IObjectWrapper
/*    */   extends IInterface
/*    */ {
/*    */   public static abstract class Stub
/*    */     extends Binder
/*    */     implements IObjectWrapper
/*    */   {
/*    */     private static final String DESCRIPTOR = "com.google.vr.vrcore.library.api.IObjectWrapper";
/*    */     
/*    */     public Stub()
/*    */     {
/* 22 */       attachInterface(this, "com.google.vr.vrcore.library.api.IObjectWrapper");
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     public static IObjectWrapper asInterface(IBinder paramIBinder)
/*    */     {
/* 30 */       if (paramIBinder == null) {
/* 31 */         return null;
/*    */       }
/*    */       IInterface localIInterface;
/* 34 */       if (((localIInterface = paramIBinder.queryLocalInterface("com.google.vr.vrcore.library.api.IObjectWrapper")) != null) && ((localIInterface instanceof IObjectWrapper))) {
/* 35 */         return (IObjectWrapper)localIInterface;
/*    */       }
/* 37 */       return new Proxy(paramIBinder);
/*    */     }
/*    */     
/*    */     public IBinder asBinder() {
/* 41 */       return this;
/*    */     }
/*    */     
/*    */     public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
/* 45 */       switch (paramInt1)
/*    */       {
/*    */ 
/*    */       case 1598968902: 
/* 49 */         paramParcel2.writeString("com.google.vr.vrcore.library.api.IObjectWrapper");
/* 50 */         return true;
/*    */       }
/*    */       
/* 53 */       return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
/*    */     }
/*    */     
/*    */     private static class Proxy implements IObjectWrapper {
/*    */       private IBinder mRemote;
/*    */       
/*    */       Proxy(IBinder paramIBinder) {
/* 60 */         this.mRemote = paramIBinder;
/*    */       }
/*    */       
/*    */       public IBinder asBinder() {
/* 64 */         return this.mRemote;
/*    */       }
/*    */       
/*    */       public String getInterfaceDescriptor() {
/* 68 */         return "com.google.vr.vrcore.library.api.IObjectWrapper";
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\library\api\IObjectWrapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */