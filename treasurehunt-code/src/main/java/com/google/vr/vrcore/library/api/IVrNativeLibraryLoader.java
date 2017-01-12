/*     */ package com.google.vr.vrcore.library.api;
/*     */ 
/*     */ import android.os.IBinder;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public abstract interface IVrNativeLibraryLoader extends android.os.IInterface
/*     */ {
/*     */   public abstract long loadNativeGvrLibrary(int paramInt1, int paramInt2, int paramInt3) throws RemoteException;
/*     */   
/*     */   public abstract void closeNativeGvrLibrary(long paramLong) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends android.os.Binder implements IVrNativeLibraryLoader
/*     */   {
/*     */     private static final String DESCRIPTOR = "com.google.vr.vrcore.library.api.IVrNativeLibraryLoader";
/*     */     static final int TRANSACTION_loadNativeGvrLibrary = 2;
/*     */     static final int TRANSACTION_closeNativeGvrLibrary = 3;
/*     */     
/*     */     public Stub()
/*     */     {
/*  21 */       attachInterface(this, "com.google.vr.vrcore.library.api.IVrNativeLibraryLoader");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public static IVrNativeLibraryLoader asInterface(IBinder paramIBinder)
/*     */     {
/*  29 */       if (paramIBinder == null) {
/*  30 */         return null;
/*     */       }
/*     */       android.os.IInterface localIInterface;
/*  33 */       if (((localIInterface = paramIBinder.queryLocalInterface("com.google.vr.vrcore.library.api.IVrNativeLibraryLoader")) != null) && ((localIInterface instanceof IVrNativeLibraryLoader))) {
/*  34 */         return (IVrNativeLibraryLoader)localIInterface;
/*     */       }
/*  36 */       return new Proxy(paramIBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  40 */       return this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
/*  44 */       switch (paramInt1)
/*     */       {
/*     */ 
/*     */       case 1598968902: 
/*  48 */         paramParcel2.writeString("com.google.vr.vrcore.library.api.IVrNativeLibraryLoader");
/*  49 */         return true;
/*     */       
/*     */ 
/*     */       case 2: 
/*  53 */         paramParcel1.enforceInterface("com.google.vr.vrcore.library.api.IVrNativeLibraryLoader");
/*     */         
/*  55 */         int i = paramParcel1.readInt();
/*     */         
/*  57 */         int j = paramParcel1.readInt();
/*     */         
/*  59 */         int k = paramParcel1.readInt();
/*  60 */         long l2 = loadNativeGvrLibrary(i, j, k);
/*  61 */         paramParcel2.writeNoException();
/*  62 */         paramParcel2.writeLong(l2);
/*  63 */         return true;
/*     */       
/*     */ 
/*     */       case 3: 
/*  67 */         paramParcel1.enforceInterface("com.google.vr.vrcore.library.api.IVrNativeLibraryLoader");
/*     */         
/*  69 */         long l1 = paramParcel1.readLong();
/*  70 */         closeNativeGvrLibrary(l1);
/*  71 */         paramParcel2.writeNoException();
/*  72 */         return true;
/*     */       }
/*     */       
/*  75 */       return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
/*     */     }
/*     */     
/*     */     private static class Proxy implements IVrNativeLibraryLoader {
/*     */       private IBinder mRemote;
/*     */       
/*     */       Proxy(IBinder paramIBinder) {
/*  82 */         this.mRemote = paramIBinder;
/*     */       }
/*     */       
/*     */       public IBinder asBinder() {
/*  86 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  90 */         return "com.google.vr.vrcore.library.api.IVrNativeLibraryLoader";
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public long loadNativeGvrLibrary(int paramInt1, int paramInt2, int paramInt3)
/*     */         throws RemoteException
/*     */       {
/*     */         // Byte code:
/*     */         //   0: invokestatic 11	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   3: astore 4
/*     */         //   5: invokestatic 11	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   8: astore 5
/*     */         //   10: aload 4
/*     */         //   12: ldc 1
/*     */         //   14: invokevirtual 16	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
/*     */         //   17: aload 4
/*     */         //   19: iload_1
/*     */         //   20: invokevirtual 15	android/os/Parcel:writeInt	(I)V
/*     */         //   23: aload 4
/*     */         //   25: iload_2
/*     */         //   26: invokevirtual 15	android/os/Parcel:writeInt	(I)V
/*     */         //   29: aload 4
/*     */         //   31: iload_3
/*     */         //   32: invokevirtual 15	android/os/Parcel:writeInt	(I)V
/*     */         //   35: aload_0
/*     */         //   36: getfield 10	com/google/vr/vrcore/library/api/IVrNativeLibraryLoader$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   39: iconst_2
/*     */         //   40: aload 4
/*     */         //   42: aload 5
/*     */         //   44: iconst_0
/*     */         //   45: invokeinterface 19 5 0
/*     */         //   50: pop
/*     */         //   51: aload 5
/*     */         //   53: invokevirtual 12	android/os/Parcel:readException	()V
/*     */         //   56: aload 5
/*     */         //   58: invokevirtual 13	android/os/Parcel:readLong	()J
/*     */         //   61: lstore 6
/*     */         //   63: aload 5
/*     */         //   65: invokevirtual 14	android/os/Parcel:recycle	()V
/*     */         //   68: aload 4
/*     */         //   70: invokevirtual 14	android/os/Parcel:recycle	()V
/*     */         //   73: goto +18 -> 91
/*     */         //   76: astore 8
/*     */         //   78: aload 5
/*     */         //   80: invokevirtual 14	android/os/Parcel:recycle	()V
/*     */         //   83: aload 4
/*     */         //   85: invokevirtual 14	android/os/Parcel:recycle	()V
/*     */         //   88: aload 8
/*     */         //   90: athrow
/*     */         //   91: lload 6
/*     */         //   93: lreturn
/*     */         // Line number table:
/*     */         //   Java source line #112	-> byte code offset #0
/*     */         //   Java source line #113	-> byte code offset #5
/*     */         //   Java source line #116	-> byte code offset #10
/*     */         //   Java source line #117	-> byte code offset #17
/*     */         //   Java source line #118	-> byte code offset #23
/*     */         //   Java source line #119	-> byte code offset #29
/*     */         //   Java source line #120	-> byte code offset #35
/*     */         //   Java source line #121	-> byte code offset #51
/*     */         //   Java source line #122	-> byte code offset #56
/*     */         //   Java source line #125	-> byte code offset #63
/*     */         //   Java source line #126	-> byte code offset #68
/*     */         //   Java source line #127	-> byte code offset #73
/*     */         //   Java source line #125	-> byte code offset #76
/*     */         //   Java source line #126	-> byte code offset #83
/*     */         //   Java source line #128	-> byte code offset #91
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	94	0	this	Proxy
/*     */         //   0	94	1	paramInt1	int
/*     */         //   0	94	2	paramInt2	int
/*     */         //   0	94	3	paramInt3	int
/*     */         //   3	81	4	localParcel1	Parcel
/*     */         //   8	71	5	localParcel2	Parcel
/*     */         //   61	31	6	l	long
/*     */         //   76	13	8	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   10	63	76	finally
/*     */       }
/*     */       
/*     */       public void closeNativeGvrLibrary(long paramLong)
/*     */         throws RemoteException
/*     */       {
/* 139 */         Parcel localParcel1 = Parcel.obtain();
/* 140 */         Parcel localParcel2 = Parcel.obtain();
/*     */         try {
/* 142 */           localParcel1.writeInterfaceToken("com.google.vr.vrcore.library.api.IVrNativeLibraryLoader");
/* 143 */           localParcel1.writeLong(paramLong);
/* 144 */           this.mRemote.transact(3, localParcel1, localParcel2, 0);
/* 145 */           localParcel2.readException();
/*     */         }
/*     */         finally {
/* 148 */           localParcel2.recycle();
/* 149 */           localParcel1.recycle();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\library\api\IVrNativeLibraryLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */