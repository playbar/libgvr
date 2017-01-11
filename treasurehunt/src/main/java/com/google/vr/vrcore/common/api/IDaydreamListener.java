/*     */ package com.google.vr.vrcore.common.api;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ 
/*     */ public abstract interface IDaydreamListener extends android.os.IInterface {
/*     */   public abstract int getTargetApiVersion() throws android.os.RemoteException;
/*     */   
/*     */   public abstract HeadTrackingState requestStopTracking() throws android.os.RemoteException;
/*     */   
/*     */   public abstract void applyFade(int paramInt, long paramLong) throws android.os.RemoteException;
/*     */   
/*     */   public abstract void recenterHeadTracking() throws android.os.RemoteException;
/*     */   
/*     */   public abstract void dumpDebugData() throws android.os.RemoteException;
/*     */   
/*     */   public abstract void resumeHeadTracking(HeadTrackingState paramHeadTrackingState) throws android.os.RemoteException;
/*     */   
/*     */   public static abstract class Stub extends android.os.Binder implements IDaydreamListener {
/*     */     private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.IDaydreamListener";
/*     */     static final int TRANSACTION_getTargetApiVersion = 1;
/*     */     static final int TRANSACTION_requestStopTracking = 2;
/*     */     static final int TRANSACTION_applyFade = 3;
/*     */     static final int TRANSACTION_recenterHeadTracking = 4;
/*     */     static final int TRANSACTION_dumpDebugData = 5;
/*     */     static final int TRANSACTION_resumeHeadTracking = 6;
/*     */     
/*     */     public Stub() {
/*  28 */       attachInterface(this, "com.google.vr.vrcore.common.api.IDaydreamListener");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public static IDaydreamListener asInterface(android.os.IBinder paramIBinder)
/*     */     {
/*  36 */       if (paramIBinder == null) {
/*  37 */         return null;
/*     */       }
/*     */       android.os.IInterface localIInterface;
/*  40 */       if (((localIInterface = paramIBinder.queryLocalInterface("com.google.vr.vrcore.common.api.IDaydreamListener")) != null) && ((localIInterface instanceof IDaydreamListener))) {
/*  41 */         return (IDaydreamListener)localIInterface;
/*     */       }
/*  43 */       return new Proxy(paramIBinder);
/*     */     }
/*     */     
/*     */     public android.os.IBinder asBinder() {
/*  47 */       return this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws android.os.RemoteException {
/*  51 */       switch (paramInt1)
/*     */       {
/*     */ 
/*     */       case 1598968902: 
/*  55 */         paramParcel2.writeString("com.google.vr.vrcore.common.api.IDaydreamListener");
/*  56 */         return true;
/*     */       
/*     */ 
/*     */       case 1: 
/*  60 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
/*  61 */         int i = getTargetApiVersion();
/*  62 */         paramParcel2.writeNoException();
/*  63 */         paramParcel2.writeInt(i);
/*  64 */         return true;
/*     */       
/*     */ 
/*     */       case 2: 
/*  68 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
/*  69 */         HeadTrackingState localHeadTrackingState1 = requestStopTracking();
/*  70 */         paramParcel2.writeNoException();
/*  71 */         if (localHeadTrackingState1 != null) {
/*  72 */           paramParcel2.writeInt(1);
/*  73 */           localHeadTrackingState1.writeToParcel(paramParcel2, 1);
/*     */         }
/*     */         else {
/*  76 */           paramParcel2.writeInt(0);
/*     */         }
/*  78 */         return true;
/*     */       
/*     */ 
/*     */       case 3: 
/*  82 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
/*     */         
/*  84 */         int j = paramParcel1.readInt();
/*     */         
/*  86 */         long l = paramParcel1.readLong();
/*  87 */         applyFade(j, l);
/*  88 */         return true;
/*     */       
/*     */ 
/*     */       case 4: 
/*  92 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
/*  93 */         recenterHeadTracking();
/*  94 */         return true;
/*     */       
/*     */ 
/*     */       case 5: 
/*  98 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
/*  99 */         dumpDebugData();
/* 100 */         return true;
/*     */       
/*     */ 
/*     */       case 6: 
/* 104 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
/*     */         HeadTrackingState localHeadTrackingState2;
/* 106 */         if (0 != paramParcel1.readInt()) {
/* 107 */           localHeadTrackingState2 = (HeadTrackingState)HeadTrackingState.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/* 110 */           localHeadTrackingState2 = null;
/*     */         }
/* 112 */         resumeHeadTracking(localHeadTrackingState2);
/* 113 */         return true;
/*     */       }
/*     */       
/* 116 */       return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
/*     */     }
/*     */     
/*     */     private static class Proxy implements IDaydreamListener {
/*     */       private android.os.IBinder mRemote;
/*     */       
/*     */       Proxy(android.os.IBinder paramIBinder) {
/* 123 */         this.mRemote = paramIBinder;
/*     */       }
/*     */       
/*     */       public android.os.IBinder asBinder() {
/* 127 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 131 */         return "com.google.vr.vrcore.common.api.IDaydreamListener";
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public int getTargetApiVersion()
/*     */         throws android.os.RemoteException
/*     */       {
/*     */         // Byte code:
/*     */         //   0: invokestatic 15	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   3: astore_1
/*     */         //   4: invokestatic 15	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   7: astore_2
/*     */         //   8: aload_1
/*     */         //   9: ldc 1
/*     */         //   11: invokevirtual 20	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
/*     */         //   14: aload_0
/*     */         //   15: getfield 14	com/google/vr/vrcore/common/api/IDaydreamListener$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   18: iconst_1
/*     */         //   19: aload_1
/*     */         //   20: aload_2
/*     */         //   21: iconst_0
/*     */         //   22: invokeinterface 24 5 0
/*     */         //   27: pop
/*     */         //   28: aload_2
/*     */         //   29: invokevirtual 16	android/os/Parcel:readException	()V
/*     */         //   32: aload_2
/*     */         //   33: invokevirtual 17	android/os/Parcel:readInt	()I
/*     */         //   36: istore_3
/*     */         //   37: aload_2
/*     */         //   38: invokevirtual 18	android/os/Parcel:recycle	()V
/*     */         //   41: aload_1
/*     */         //   42: invokevirtual 18	android/os/Parcel:recycle	()V
/*     */         //   45: goto +16 -> 61
/*     */         //   48: astore 4
/*     */         //   50: aload_2
/*     */         //   51: invokevirtual 18	android/os/Parcel:recycle	()V
/*     */         //   54: aload_1
/*     */         //   55: invokevirtual 18	android/os/Parcel:recycle	()V
/*     */         //   58: aload 4
/*     */         //   60: athrow
/*     */         //   61: iload_3
/*     */         //   62: ireturn
/*     */         // Line number table:
/*     */         //   Java source line #135	-> byte code offset #0
/*     */         //   Java source line #136	-> byte code offset #4
/*     */         //   Java source line #139	-> byte code offset #8
/*     */         //   Java source line #140	-> byte code offset #14
/*     */         //   Java source line #141	-> byte code offset #28
/*     */         //   Java source line #142	-> byte code offset #32
/*     */         //   Java source line #145	-> byte code offset #37
/*     */         //   Java source line #146	-> byte code offset #41
/*     */         //   Java source line #147	-> byte code offset #45
/*     */         //   Java source line #145	-> byte code offset #48
/*     */         //   Java source line #146	-> byte code offset #54
/*     */         //   Java source line #148	-> byte code offset #61
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	63	0	this	Proxy
/*     */         //   3	52	1	localParcel1	Parcel
/*     */         //   7	44	2	localParcel2	Parcel
/*     */         //   36	26	3	i	int
/*     */         //   48	11	4	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   8	37	48	finally
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public HeadTrackingState requestStopTracking()
/*     */         throws android.os.RemoteException
/*     */       {
/*     */         // Byte code:
/*     */         //   0: invokestatic 15	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   3: astore_1
/*     */         //   4: invokestatic 15	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   7: astore_2
/*     */         //   8: aload_1
/*     */         //   9: ldc 1
/*     */         //   11: invokevirtual 20	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
/*     */         //   14: aload_0
/*     */         //   15: getfield 14	com/google/vr/vrcore/common/api/IDaydreamListener$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   18: iconst_2
/*     */         //   19: aload_1
/*     */         //   20: aload_2
/*     */         //   21: iconst_0
/*     */         //   22: invokeinterface 24 5 0
/*     */         //   27: pop
/*     */         //   28: aload_2
/*     */         //   29: invokevirtual 16	android/os/Parcel:readException	()V
/*     */         //   32: iconst_0
/*     */         //   33: aload_2
/*     */         //   34: invokevirtual 17	android/os/Parcel:readInt	()I
/*     */         //   37: if_icmpeq +19 -> 56
/*     */         //   40: getstatic 13	com/google/vr/vrcore/common/api/HeadTrackingState:CREATOR	Landroid/os/Parcelable$Creator;
/*     */         //   43: aload_2
/*     */         //   44: invokeinterface 25 2 0
/*     */         //   49: checkcast 7	com/google/vr/vrcore/common/api/HeadTrackingState
/*     */         //   52: astore_3
/*     */         //   53: goto +5 -> 58
/*     */         //   56: aconst_null
/*     */         //   57: astore_3
/*     */         //   58: aload_2
/*     */         //   59: invokevirtual 18	android/os/Parcel:recycle	()V
/*     */         //   62: aload_1
/*     */         //   63: invokevirtual 18	android/os/Parcel:recycle	()V
/*     */         //   66: goto +16 -> 82
/*     */         //   69: astore 4
/*     */         //   71: aload_2
/*     */         //   72: invokevirtual 18	android/os/Parcel:recycle	()V
/*     */         //   75: aload_1
/*     */         //   76: invokevirtual 18	android/os/Parcel:recycle	()V
/*     */         //   79: aload 4
/*     */         //   81: athrow
/*     */         //   82: aload_3
/*     */         //   83: areturn
/*     */         // Line number table:
/*     */         //   Java source line #163	-> byte code offset #0
/*     */         //   Java source line #164	-> byte code offset #4
/*     */         //   Java source line #167	-> byte code offset #8
/*     */         //   Java source line #168	-> byte code offset #14
/*     */         //   Java source line #169	-> byte code offset #28
/*     */         //   Java source line #170	-> byte code offset #32
/*     */         //   Java source line #171	-> byte code offset #40
/*     */         //   Java source line #174	-> byte code offset #56
/*     */         //   Java source line #178	-> byte code offset #58
/*     */         //   Java source line #179	-> byte code offset #62
/*     */         //   Java source line #180	-> byte code offset #66
/*     */         //   Java source line #178	-> byte code offset #69
/*     */         //   Java source line #179	-> byte code offset #75
/*     */         //   Java source line #181	-> byte code offset #82
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	84	0	this	Proxy
/*     */         //   3	73	1	localParcel1	Parcel
/*     */         //   7	65	2	localParcel2	Parcel
/*     */         //   52	31	3	localHeadTrackingState	HeadTrackingState
/*     */         //   69	11	4	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   8	58	69	finally
/*     */       }
/*     */       
/*     */       public void applyFade(int paramInt, long paramLong)
/*     */         throws android.os.RemoteException
/*     */       {
/* 204 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 206 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamListener");
/* 207 */           localParcel.writeInt(paramInt);
/* 208 */           localParcel.writeLong(paramLong);
/* 209 */           this.mRemote.transact(3, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 212 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       public void recenterHeadTracking()
/*     */         throws android.os.RemoteException
/*     */       {
/* 225 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 227 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamListener");
/* 228 */           this.mRemote.transact(4, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 231 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       public void dumpDebugData()
/*     */         throws android.os.RemoteException
/*     */       {
/* 244 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 246 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamListener");
/* 247 */           this.mRemote.transact(5, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 250 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       public void resumeHeadTracking(HeadTrackingState paramHeadTrackingState)
/*     */         throws android.os.RemoteException
/*     */       {
/* 262 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 264 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamListener");
/* 265 */           if (paramHeadTrackingState != null) {
/* 266 */             localParcel.writeInt(1);
/* 267 */             paramHeadTrackingState.writeToParcel(localParcel, 0);
/*     */           }
/*     */           else {
/* 270 */             localParcel.writeInt(0);
/*     */           }
/* 272 */           this.mRemote.transact(6, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 275 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\common\api\IDaydreamListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */