/*    */ package com.google.vr.vrcore.library.api;
/*    */ 
/*    */ import android.os.Binder;
/*    */ import android.os.IBinder;
/*    */ import android.os.IInterface;
/*    */ import android.os.Parcel;
/*    */ import android.os.RemoteException;
/*    */ 
/*    */ 
/*    */ public abstract interface IVrCreator
/*    */   extends IInterface
/*    */ {
/*    */   public abstract IVrNativeLibraryLoader DEPRECATED_newNativeLibraryLoader(IObjectWrapper paramIObjectWrapper)
/*    */     throws RemoteException;
/*    */   
/*    */   public abstract IVrNativeLibraryLoader newNativeLibraryLoader(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2)
/*    */     throws RemoteException;
/*    */   
/*    */   public static abstract class Stub
/*    */     extends Binder
/*    */     implements IVrCreator
/*    */   {
/*    */     private static final String DESCRIPTOR = "com.google.vr.vrcore.library.api.IVrCreator";
/*    */     static final int TRANSACTION_DEPRECATED_newNativeLibraryLoader = 3;
/*    */     static final int TRANSACTION_newNativeLibraryLoader = 4;
/*    */     
/*    */     public Stub()
/*    */     {
/* 29 */       attachInterface(this, "com.google.vr.vrcore.library.api.IVrCreator");
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     public static IVrCreator asInterface(IBinder paramIBinder)
/*    */     {
/* 37 */       if (paramIBinder == null) {
/* 38 */         return null;
/*    */       }
/*    */       IInterface localIInterface;
/* 41 */       if (((localIInterface = paramIBinder.queryLocalInterface("com.google.vr.vrcore.library.api.IVrCreator")) != null) && ((localIInterface instanceof IVrCreator))) {
/* 42 */         return (IVrCreator)localIInterface;
/*    */       }
/* 44 */       return new Proxy(paramIBinder);
/*    */     }
/*    */     
/*    */ 
/* 48 */     public IBinder asBinder() { return this; }
/*    */     
/*    */     public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException { IObjectWrapper localIObjectWrapper;
/*    */       Object localObject;
/* 52 */       switch (paramInt1)
/*    */       {
/*    */ 
/*    */       case 1598968902: 
/* 56 */         paramParcel2.writeString("com.google.vr.vrcore.library.api.IVrCreator");
/* 57 */         return true;
/*    */       
/*    */ 
/*    */       case 3: 
/* 61 */         paramParcel1.enforceInterface("com.google.vr.vrcore.library.api.IVrCreator");
/*    */         
/* 63 */         localIObjectWrapper = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
/* 64 */         localObject = DEPRECATED_newNativeLibraryLoader(localIObjectWrapper);
/* 65 */         paramParcel2.writeNoException();
/* 66 */         paramParcel2.writeStrongBinder(localObject != null ? ((IVrNativeLibraryLoader)localObject).asBinder() : null);
/* 67 */         return true;
/*    */       
/*    */ 
/*    */       case 4: 
/* 71 */         paramParcel1.enforceInterface("com.google.vr.vrcore.library.api.IVrCreator");
/*    */         
/* 73 */         localIObjectWrapper = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
/*    */         
/* 75 */         localObject = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
/* 76 */         IVrNativeLibraryLoader localIVrNativeLibraryLoader = newNativeLibraryLoader(localIObjectWrapper, (IObjectWrapper)localObject);
/* 77 */         paramParcel2.writeNoException();
/* 78 */         paramParcel2.writeStrongBinder(localIVrNativeLibraryLoader != null ? localIVrNativeLibraryLoader.asBinder() : null);
/* 79 */         return true;
/*    */       }
/*    */       
/* 82 */       return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
/*    */     }
/*    */     
/*    */     private static class Proxy implements IVrCreator {
/*    */       private IBinder mRemote;
/*    */       
/*    */       Proxy(IBinder paramIBinder) {
/* 89 */         this.mRemote = paramIBinder;
/*    */       }
/*    */       
/*    */       public IBinder asBinder() {
/* 93 */         return this.mRemote;
/*    */       }
/*    */       
/*    */       public String getInterfaceDescriptor() {
/* 97 */         return "com.google.vr.vrcore.library.api.IVrCreator";
/*    */       }
/*    */       
/*    */       /* Error */
/*    */       public IVrNativeLibraryLoader DEPRECATED_newNativeLibraryLoader(IObjectWrapper paramIObjectWrapper)
/*    */         throws RemoteException
/*    */       {
/*    */         // Byte code:
/*    */         //   0: invokestatic 14	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*    */         //   3: astore_2
/*    */         //   4: invokestatic 14	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*    */         //   7: astore_3
/*    */         //   8: aload_2
/*    */         //   9: ldc 1
/*    */         //   11: invokevirtual 18	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
/*    */         //   14: aload_2
/*    */         //   15: aload_1
/*    */         //   16: ifnull +12 -> 28
/*    */         //   19: aload_1
/*    */         //   20: invokeinterface 23 1 0
/*    */         //   25: goto +4 -> 29
/*    */         //   28: aconst_null
/*    */         //   29: invokevirtual 19	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
/*    */         //   32: aload_0
/*    */         //   33: getfield 13	com/google/vr/vrcore/library/api/IVrCreator$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*    */         //   36: iconst_3
/*    */         //   37: aload_2
/*    */         //   38: aload_3
/*    */         //   39: iconst_0
/*    */         //   40: invokeinterface 22 5 0
/*    */         //   45: pop
/*    */         //   46: aload_3
/*    */         //   47: invokevirtual 15	android/os/Parcel:readException	()V
/*    */         //   50: aload_3
/*    */         //   51: invokevirtual 16	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
/*    */         //   54: invokestatic 20	com/google/vr/vrcore/library/api/IVrNativeLibraryLoader$Stub:asInterface	(Landroid/os/IBinder;)Lcom/google/vr/vrcore/library/api/IVrNativeLibraryLoader;
/*    */         //   57: astore 4
/*    */         //   59: aload_3
/*    */         //   60: invokevirtual 17	android/os/Parcel:recycle	()V
/*    */         //   63: aload_2
/*    */         //   64: invokevirtual 17	android/os/Parcel:recycle	()V
/*    */         //   67: goto +16 -> 83
/*    */         //   70: astore 5
/*    */         //   72: aload_3
/*    */         //   73: invokevirtual 17	android/os/Parcel:recycle	()V
/*    */         //   76: aload_2
/*    */         //   77: invokevirtual 17	android/os/Parcel:recycle	()V
/*    */         //   80: aload 5
/*    */         //   82: athrow
/*    */         //   83: aload 4
/*    */         //   85: areturn
/*    */         // Line number table:
/*    */         //   Java source line #109	-> byte code offset #0
/*    */         //   Java source line #110	-> byte code offset #4
/*    */         //   Java source line #113	-> byte code offset #8
/*    */         //   Java source line #114	-> byte code offset #14
/*    */         //   Java source line #115	-> byte code offset #32
/*    */         //   Java source line #116	-> byte code offset #46
/*    */         //   Java source line #117	-> byte code offset #50
/*    */         //   Java source line #120	-> byte code offset #59
/*    */         //   Java source line #121	-> byte code offset #63
/*    */         //   Java source line #122	-> byte code offset #67
/*    */         //   Java source line #120	-> byte code offset #70
/*    */         //   Java source line #121	-> byte code offset #76
/*    */         //   Java source line #123	-> byte code offset #83
/*    */         // Local variable table:
/*    */         //   start	length	slot	name	signature
/*    */         //   0	86	0	this	Proxy
/*    */         //   0	86	1	paramIObjectWrapper	IObjectWrapper
/*    */         //   3	74	2	localParcel1	Parcel
/*    */         //   7	66	3	localParcel2	Parcel
/*    */         //   57	27	4	localIVrNativeLibraryLoader	IVrNativeLibraryLoader
/*    */         //   70	11	5	localObject	Object
/*    */         // Exception table:
/*    */         //   from	to	target	type
/*    */         //   8	59	70	finally
/*    */       }
/*    */       
/*    */       /* Error */
/*    */       public IVrNativeLibraryLoader newNativeLibraryLoader(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2)
/*    */         throws RemoteException
/*    */       {
/*    */         // Byte code:
/*    */         //   0: invokestatic 14	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*    */         //   3: astore_3
/*    */         //   4: invokestatic 14	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*    */         //   7: astore 4
/*    */         //   9: aload_3
/*    */         //   10: ldc 1
/*    */         //   12: invokevirtual 18	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
/*    */         //   15: aload_3
/*    */         //   16: aload_1
/*    */         //   17: ifnull +12 -> 29
/*    */         //   20: aload_1
/*    */         //   21: invokeinterface 23 1 0
/*    */         //   26: goto +4 -> 30
/*    */         //   29: aconst_null
/*    */         //   30: invokevirtual 19	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
/*    */         //   33: aload_3
/*    */         //   34: aload_2
/*    */         //   35: ifnull +12 -> 47
/*    */         //   38: aload_2
/*    */         //   39: invokeinterface 23 1 0
/*    */         //   44: goto +4 -> 48
/*    */         //   47: aconst_null
/*    */         //   48: invokevirtual 19	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
/*    */         //   51: aload_0
/*    */         //   52: getfield 13	com/google/vr/vrcore/library/api/IVrCreator$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*    */         //   55: iconst_4
/*    */         //   56: aload_3
/*    */         //   57: aload 4
/*    */         //   59: iconst_0
/*    */         //   60: invokeinterface 22 5 0
/*    */         //   65: pop
/*    */         //   66: aload 4
/*    */         //   68: invokevirtual 15	android/os/Parcel:readException	()V
/*    */         //   71: aload 4
/*    */         //   73: invokevirtual 16	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
/*    */         //   76: invokestatic 20	com/google/vr/vrcore/library/api/IVrNativeLibraryLoader$Stub:asInterface	(Landroid/os/IBinder;)Lcom/google/vr/vrcore/library/api/IVrNativeLibraryLoader;
/*    */         //   79: astore 5
/*    */         //   81: aload 4
/*    */         //   83: invokevirtual 17	android/os/Parcel:recycle	()V
/*    */         //   86: aload_3
/*    */         //   87: invokevirtual 17	android/os/Parcel:recycle	()V
/*    */         //   90: goto +17 -> 107
/*    */         //   93: astore 6
/*    */         //   95: aload 4
/*    */         //   97: invokevirtual 17	android/os/Parcel:recycle	()V
/*    */         //   100: aload_3
/*    */         //   101: invokevirtual 17	android/os/Parcel:recycle	()V
/*    */         //   104: aload 6
/*    */         //   106: athrow
/*    */         //   107: aload 5
/*    */         //   109: areturn
/*    */         // Line number table:
/*    */         //   Java source line #135	-> byte code offset #0
/*    */         //   Java source line #136	-> byte code offset #4
/*    */         //   Java source line #139	-> byte code offset #9
/*    */         //   Java source line #140	-> byte code offset #15
/*    */         //   Java source line #141	-> byte code offset #33
/*    */         //   Java source line #142	-> byte code offset #51
/*    */         //   Java source line #143	-> byte code offset #66
/*    */         //   Java source line #144	-> byte code offset #71
/*    */         //   Java source line #147	-> byte code offset #81
/*    */         //   Java source line #148	-> byte code offset #86
/*    */         //   Java source line #149	-> byte code offset #90
/*    */         //   Java source line #147	-> byte code offset #93
/*    */         //   Java source line #148	-> byte code offset #100
/*    */         //   Java source line #150	-> byte code offset #107
/*    */         // Local variable table:
/*    */         //   start	length	slot	name	signature
/*    */         //   0	110	0	this	Proxy
/*    */         //   0	110	1	paramIObjectWrapper1	IObjectWrapper
/*    */         //   0	110	2	paramIObjectWrapper2	IObjectWrapper
/*    */         //   3	98	3	localParcel1	Parcel
/*    */         //   7	89	4	localParcel2	Parcel
/*    */         //   79	29	5	localIVrNativeLibraryLoader	IVrNativeLibraryLoader
/*    */         //   93	12	6	localObject	Object
/*    */         // Exception table:
/*    */         //   from	to	target	type
/*    */         //   9	81	93	finally
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\library\api\IVrCreator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */