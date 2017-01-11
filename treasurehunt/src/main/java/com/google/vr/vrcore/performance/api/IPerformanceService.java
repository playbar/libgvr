/*     */ package com.google.vr.vrcore.performance.api;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ 
/*     */ public abstract interface IPerformanceService extends android.os.IInterface {
/*     */   public abstract float getCurrentThrottlingRelativeTemperature() throws android.os.RemoteException;
/*     */   
/*     */   public abstract void reportFrameDrops(long paramLong1, long paramLong2, int paramInt) throws android.os.RemoteException;
/*     */   
/*     */   public static abstract class Stub extends android.os.Binder implements IPerformanceService {
/*     */     private static final String DESCRIPTOR = "com.google.vr.vrcore.performance.api.IPerformanceService";
/*     */     static final int TRANSACTION_getCurrentThrottlingRelativeTemperature = 1;
/*     */     static final int TRANSACTION_reportFrameDrops = 2;
/*     */     
/*  15 */     public Stub() { attachInterface(this, "com.google.vr.vrcore.performance.api.IPerformanceService"); }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public static IPerformanceService asInterface(android.os.IBinder paramIBinder)
/*     */     {
/*  23 */       if (paramIBinder == null) {
/*  24 */         return null;
/*     */       }
/*     */       android.os.IInterface localIInterface;
/*  27 */       if (((localIInterface = paramIBinder.queryLocalInterface("com.google.vr.vrcore.performance.api.IPerformanceService")) != null) && ((localIInterface instanceof IPerformanceService))) {
/*  28 */         return (IPerformanceService)localIInterface;
/*     */       }
/*  30 */       return new Proxy(paramIBinder);
/*     */     }
/*     */     
/*     */     public android.os.IBinder asBinder() {
/*  34 */       return this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws android.os.RemoteException {
/*  38 */       switch (paramInt1)
/*     */       {
/*     */ 
/*     */       case 1598968902: 
/*  42 */         paramParcel2.writeString("com.google.vr.vrcore.performance.api.IPerformanceService");
/*  43 */         return true;
/*     */       
/*     */ 
/*     */       case 1: 
/*  47 */         paramParcel1.enforceInterface("com.google.vr.vrcore.performance.api.IPerformanceService");
/*  48 */         float f = getCurrentThrottlingRelativeTemperature();
/*  49 */         paramParcel2.writeNoException();
/*  50 */         paramParcel2.writeFloat(f);
/*  51 */         return true;
/*     */       
/*     */ 
/*     */       case 2: 
/*  55 */         paramParcel1.enforceInterface("com.google.vr.vrcore.performance.api.IPerformanceService");
/*     */         
/*  57 */         long l1 = paramParcel1.readLong();
/*     */         
/*  59 */         long l2 = paramParcel1.readLong();
/*     */         
/*  61 */         int i = paramParcel1.readInt();
/*  62 */         reportFrameDrops(l1, l2, i);
/*  63 */         return true;
/*     */       }
/*     */       
/*  66 */       return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
/*     */     }
/*     */     
/*     */     private static class Proxy implements IPerformanceService {
/*     */       private android.os.IBinder mRemote;
/*     */       
/*     */       Proxy(android.os.IBinder paramIBinder) {
/*  73 */         this.mRemote = paramIBinder;
/*     */       }
/*     */       
/*     */       public android.os.IBinder asBinder() {
/*  77 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  81 */         return "com.google.vr.vrcore.performance.api.IPerformanceService";
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public float getCurrentThrottlingRelativeTemperature()
/*     */         throws android.os.RemoteException
/*     */       {
/*     */         // Byte code:
/*     */         //   0: invokestatic 11	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   3: astore_1
/*     */         //   4: invokestatic 11	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   7: astore_2
/*     */         //   8: aload_1
/*     */         //   9: ldc 1
/*     */         //   11: invokevirtual 16	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
/*     */         //   14: aload_0
/*     */         //   15: getfield 10	com/google/vr/vrcore/performance/api/IPerformanceService$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   18: iconst_1
/*     */         //   19: aload_1
/*     */         //   20: aload_2
/*     */         //   21: iconst_0
/*     */         //   22: invokeinterface 19 5 0
/*     */         //   27: pop
/*     */         //   28: aload_2
/*     */         //   29: invokevirtual 12	android/os/Parcel:readException	()V
/*     */         //   32: aload_2
/*     */         //   33: invokevirtual 13	android/os/Parcel:readFloat	()F
/*     */         //   36: fstore_3
/*     */         //   37: aload_2
/*     */         //   38: invokevirtual 14	android/os/Parcel:recycle	()V
/*     */         //   41: aload_1
/*     */         //   42: invokevirtual 14	android/os/Parcel:recycle	()V
/*     */         //   45: goto +16 -> 61
/*     */         //   48: astore 4
/*     */         //   50: aload_2
/*     */         //   51: invokevirtual 14	android/os/Parcel:recycle	()V
/*     */         //   54: aload_1
/*     */         //   55: invokevirtual 14	android/os/Parcel:recycle	()V
/*     */         //   58: aload 4
/*     */         //   60: athrow
/*     */         //   61: fload_3
/*     */         //   62: freturn
/*     */         // Line number table:
/*     */         //   Java source line #85	-> byte code offset #0
/*     */         //   Java source line #86	-> byte code offset #4
/*     */         //   Java source line #89	-> byte code offset #8
/*     */         //   Java source line #90	-> byte code offset #14
/*     */         //   Java source line #91	-> byte code offset #28
/*     */         //   Java source line #92	-> byte code offset #32
/*     */         //   Java source line #95	-> byte code offset #37
/*     */         //   Java source line #96	-> byte code offset #41
/*     */         //   Java source line #97	-> byte code offset #45
/*     */         //   Java source line #95	-> byte code offset #48
/*     */         //   Java source line #96	-> byte code offset #54
/*     */         //   Java source line #98	-> byte code offset #61
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	63	0	this	Proxy
/*     */         //   3	52	1	localParcel1	Parcel
/*     */         //   7	44	2	localParcel2	Parcel
/*     */         //   36	26	3	f	float
/*     */         //   48	11	4	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   8	37	48	finally
/*     */       }
/*     */       
/*     */       public void reportFrameDrops(long paramLong1, long paramLong2, int paramInt)
/*     */         throws android.os.RemoteException
/*     */       {
/* 102 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 104 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.performance.api.IPerformanceService");
/* 105 */           localParcel.writeLong(paramLong1);
/* 106 */           localParcel.writeLong(paramLong2);
/* 107 */           localParcel.writeInt(paramInt);
/* 108 */           this.mRemote.transact(2, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 111 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\performance\api\IPerformanceService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */