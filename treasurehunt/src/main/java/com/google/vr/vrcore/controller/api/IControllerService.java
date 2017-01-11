/*     */ package com.google.vr.vrcore.controller.api;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.IBinder;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public abstract interface IControllerService extends android.os.IInterface
/*     */ {
/*     */   public abstract int initialize(int paramInt) throws RemoteException;
/*     */   
/*     */   public abstract boolean registerListener(int paramInt, String paramString, IControllerListener paramIControllerListener) throws RemoteException;
/*     */   
/*     */   public abstract boolean unregisterListener(String paramString) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements IControllerService
/*     */   {
/*     */     private static final String DESCRIPTOR = "com.google.vr.vrcore.controller.api.IControllerService";
/*     */     static final int TRANSACTION_initialize = 1;
/*     */     static final int TRANSACTION_registerListener = 5;
/*     */     static final int TRANSACTION_unregisterListener = 6;
/*     */     
/*     */     public Stub()
/*     */     {
/*  25 */       attachInterface(this, "com.google.vr.vrcore.controller.api.IControllerService");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public static IControllerService asInterface(IBinder paramIBinder)
/*     */     {
/*  33 */       if (paramIBinder == null) {
/*  34 */         return null;
/*     */       }
/*     */       android.os.IInterface localIInterface;
/*  37 */       if (((localIInterface = paramIBinder.queryLocalInterface("com.google.vr.vrcore.controller.api.IControllerService")) != null) && ((localIInterface instanceof IControllerService))) {
/*  38 */         return (IControllerService)localIInterface;
/*     */       }
/*  40 */       return new Proxy(paramIBinder);
/*     */     }
/*     */     
/*     */ 
/*  44 */     public IBinder asBinder() { return this; }
/*     */     
/*     */     public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
/*     */       int i;
/*  48 */       switch (paramInt1)
/*     */       {
/*     */ 
/*     */       case 1598968902: 
/*  52 */         paramParcel2.writeString("com.google.vr.vrcore.controller.api.IControllerService");
/*  53 */         return true;
/*     */       
/*     */ 
/*     */       case 1: 
/*  57 */         paramParcel1.enforceInterface("com.google.vr.vrcore.controller.api.IControllerService");
/*     */         
/*  59 */         i = paramParcel1.readInt();
/*  60 */         int j = initialize(i);
/*  61 */         paramParcel2.writeNoException();
/*  62 */         paramParcel2.writeInt(j);
/*  63 */         return true;
/*     */       
/*     */ 
/*     */       case 5: 
/*  67 */         paramParcel1.enforceInterface("com.google.vr.vrcore.controller.api.IControllerService");
/*     */         
/*  69 */         i = paramParcel1.readInt();
/*     */         
/*  71 */         String str2 = paramParcel1.readString();
/*     */         
/*  73 */         IControllerListener localIControllerListener = IControllerListener.Stub.asInterface(paramParcel1.readStrongBinder());
/*  74 */         boolean bool2 = registerListener(i, str2, localIControllerListener);
/*  75 */         paramParcel2.writeNoException();
/*  76 */         paramParcel2.writeInt(bool2 ? 1 : 0);
/*  77 */         return true;
/*     */       
/*     */ 
/*     */       case 6: 
/*  81 */         paramParcel1.enforceInterface("com.google.vr.vrcore.controller.api.IControllerService");
/*     */         
/*  83 */         String str1 = paramParcel1.readString();
/*  84 */         boolean bool1 = unregisterListener(str1);
/*  85 */         paramParcel2.writeNoException();
/*  86 */         paramParcel2.writeInt(bool1 ? 1 : 0);
/*  87 */         return true;
/*     */       }
/*     */       
/*  90 */       return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
/*     */     }
/*     */     
/*     */     private static class Proxy implements IControllerService {
/*     */       private IBinder mRemote;
/*     */       
/*     */       Proxy(IBinder paramIBinder) {
/*  97 */         this.mRemote = paramIBinder;
/*     */       }
/*     */       
/*     */       public IBinder asBinder() {
/* 101 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 105 */         return "com.google.vr.vrcore.controller.api.IControllerService";
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public int initialize(int paramInt)
/*     */         throws RemoteException
/*     */       {
/*     */         // Byte code:
/*     */         //   0: invokestatic 13	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   3: astore_2
/*     */         //   4: invokestatic 13	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   7: astore_3
/*     */         //   8: aload_2
/*     */         //   9: ldc 1
/*     */         //   11: invokevirtual 18	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
/*     */         //   14: aload_2
/*     */         //   15: iload_1
/*     */         //   16: invokevirtual 17	android/os/Parcel:writeInt	(I)V
/*     */         //   19: aload_0
/*     */         //   20: getfield 12	com/google/vr/vrcore/controller/api/IControllerService$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   23: iconst_1
/*     */         //   24: aload_2
/*     */         //   25: aload_3
/*     */         //   26: iconst_0
/*     */         //   27: invokeinterface 22 5 0
/*     */         //   32: pop
/*     */         //   33: aload_3
/*     */         //   34: invokevirtual 14	android/os/Parcel:readException	()V
/*     */         //   37: aload_3
/*     */         //   38: invokevirtual 15	android/os/Parcel:readInt	()I
/*     */         //   41: istore 4
/*     */         //   43: aload_3
/*     */         //   44: invokevirtual 16	android/os/Parcel:recycle	()V
/*     */         //   47: aload_2
/*     */         //   48: invokevirtual 16	android/os/Parcel:recycle	()V
/*     */         //   51: goto +16 -> 67
/*     */         //   54: astore 5
/*     */         //   56: aload_3
/*     */         //   57: invokevirtual 16	android/os/Parcel:recycle	()V
/*     */         //   60: aload_2
/*     */         //   61: invokevirtual 16	android/os/Parcel:recycle	()V
/*     */         //   64: aload 5
/*     */         //   66: athrow
/*     */         //   67: iload 4
/*     */         //   69: ireturn
/*     */         // Line number table:
/*     */         //   Java source line #109	-> byte code offset #0
/*     */         //   Java source line #110	-> byte code offset #4
/*     */         //   Java source line #113	-> byte code offset #8
/*     */         //   Java source line #114	-> byte code offset #14
/*     */         //   Java source line #115	-> byte code offset #19
/*     */         //   Java source line #116	-> byte code offset #33
/*     */         //   Java source line #117	-> byte code offset #37
/*     */         //   Java source line #120	-> byte code offset #43
/*     */         //   Java source line #121	-> byte code offset #47
/*     */         //   Java source line #122	-> byte code offset #51
/*     */         //   Java source line #120	-> byte code offset #54
/*     */         //   Java source line #121	-> byte code offset #60
/*     */         //   Java source line #123	-> byte code offset #67
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	70	0	this	Proxy
/*     */         //   0	70	1	paramInt	int
/*     */         //   3	58	2	localParcel1	Parcel
/*     */         //   7	50	3	localParcel2	Parcel
/*     */         //   41	27	4	i	int
/*     */         //   54	11	5	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   8	43	54	finally
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public boolean registerListener(int paramInt, String paramString, IControllerListener paramIControllerListener)
/*     */         throws RemoteException
/*     */       {
/*     */         // Byte code:
/*     */         //   0: invokestatic 13	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   3: astore 4
/*     */         //   5: invokestatic 13	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   8: astore 5
/*     */         //   10: aload 4
/*     */         //   12: ldc 1
/*     */         //   14: invokevirtual 18	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
/*     */         //   17: aload 4
/*     */         //   19: iload_1
/*     */         //   20: invokevirtual 17	android/os/Parcel:writeInt	(I)V
/*     */         //   23: aload 4
/*     */         //   25: aload_2
/*     */         //   26: invokevirtual 19	android/os/Parcel:writeString	(Ljava/lang/String;)V
/*     */         //   29: aload 4
/*     */         //   31: aload_3
/*     */         //   32: ifnull +12 -> 44
/*     */         //   35: aload_3
/*     */         //   36: invokeinterface 23 1 0
/*     */         //   41: goto +4 -> 45
/*     */         //   44: aconst_null
/*     */         //   45: invokevirtual 20	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
/*     */         //   48: aload_0
/*     */         //   49: getfield 12	com/google/vr/vrcore/controller/api/IControllerService$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   52: iconst_5
/*     */         //   53: aload 4
/*     */         //   55: aload 5
/*     */         //   57: iconst_0
/*     */         //   58: invokeinterface 22 5 0
/*     */         //   63: pop
/*     */         //   64: aload 5
/*     */         //   66: invokevirtual 14	android/os/Parcel:readException	()V
/*     */         //   69: iconst_0
/*     */         //   70: aload 5
/*     */         //   72: invokevirtual 15	android/os/Parcel:readInt	()I
/*     */         //   75: if_icmpeq +7 -> 82
/*     */         //   78: iconst_1
/*     */         //   79: goto +4 -> 83
/*     */         //   82: iconst_0
/*     */         //   83: istore 6
/*     */         //   85: aload 5
/*     */         //   87: invokevirtual 16	android/os/Parcel:recycle	()V
/*     */         //   90: aload 4
/*     */         //   92: invokevirtual 16	android/os/Parcel:recycle	()V
/*     */         //   95: goto +18 -> 113
/*     */         //   98: astore 7
/*     */         //   100: aload 5
/*     */         //   102: invokevirtual 16	android/os/Parcel:recycle	()V
/*     */         //   105: aload 4
/*     */         //   107: invokevirtual 16	android/os/Parcel:recycle	()V
/*     */         //   110: aload 7
/*     */         //   112: athrow
/*     */         //   113: iload 6
/*     */         //   115: ireturn
/*     */         // Line number table:
/*     */         //   Java source line #145	-> byte code offset #0
/*     */         //   Java source line #146	-> byte code offset #5
/*     */         //   Java source line #149	-> byte code offset #10
/*     */         //   Java source line #150	-> byte code offset #17
/*     */         //   Java source line #151	-> byte code offset #23
/*     */         //   Java source line #152	-> byte code offset #29
/*     */         //   Java source line #153	-> byte code offset #48
/*     */         //   Java source line #154	-> byte code offset #64
/*     */         //   Java source line #155	-> byte code offset #69
/*     */         //   Java source line #158	-> byte code offset #85
/*     */         //   Java source line #159	-> byte code offset #90
/*     */         //   Java source line #160	-> byte code offset #95
/*     */         //   Java source line #158	-> byte code offset #98
/*     */         //   Java source line #159	-> byte code offset #105
/*     */         //   Java source line #161	-> byte code offset #113
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	116	0	this	Proxy
/*     */         //   0	116	1	paramInt	int
/*     */         //   0	116	2	paramString	String
/*     */         //   0	116	3	paramIControllerListener	IControllerListener
/*     */         //   3	103	4	localParcel1	Parcel
/*     */         //   8	93	5	localParcel2	Parcel
/*     */         //   83	31	6	bool	boolean
/*     */         //   98	13	7	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   10	85	98	finally
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public boolean unregisterListener(String paramString)
/*     */         throws RemoteException
/*     */       {
/*     */         // Byte code:
/*     */         //   0: invokestatic 13	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   3: astore_2
/*     */         //   4: invokestatic 13	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   7: astore_3
/*     */         //   8: aload_2
/*     */         //   9: ldc 1
/*     */         //   11: invokevirtual 18	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
/*     */         //   14: aload_2
/*     */         //   15: aload_1
/*     */         //   16: invokevirtual 19	android/os/Parcel:writeString	(Ljava/lang/String;)V
/*     */         //   19: aload_0
/*     */         //   20: getfield 12	com/google/vr/vrcore/controller/api/IControllerService$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   23: bipush 6
/*     */         //   25: aload_2
/*     */         //   26: aload_3
/*     */         //   27: iconst_0
/*     */         //   28: invokeinterface 22 5 0
/*     */         //   33: pop
/*     */         //   34: aload_3
/*     */         //   35: invokevirtual 14	android/os/Parcel:readException	()V
/*     */         //   38: iconst_0
/*     */         //   39: aload_3
/*     */         //   40: invokevirtual 15	android/os/Parcel:readInt	()I
/*     */         //   43: if_icmpeq +7 -> 50
/*     */         //   46: iconst_1
/*     */         //   47: goto +4 -> 51
/*     */         //   50: iconst_0
/*     */         //   51: istore 4
/*     */         //   53: aload_3
/*     */         //   54: invokevirtual 16	android/os/Parcel:recycle	()V
/*     */         //   57: aload_2
/*     */         //   58: invokevirtual 16	android/os/Parcel:recycle	()V
/*     */         //   61: goto +16 -> 77
/*     */         //   64: astore 5
/*     */         //   66: aload_3
/*     */         //   67: invokevirtual 16	android/os/Parcel:recycle	()V
/*     */         //   70: aload_2
/*     */         //   71: invokevirtual 16	android/os/Parcel:recycle	()V
/*     */         //   74: aload 5
/*     */         //   76: athrow
/*     */         //   77: iload 4
/*     */         //   79: ireturn
/*     */         // Line number table:
/*     */         //   Java source line #177	-> byte code offset #0
/*     */         //   Java source line #178	-> byte code offset #4
/*     */         //   Java source line #181	-> byte code offset #8
/*     */         //   Java source line #182	-> byte code offset #14
/*     */         //   Java source line #183	-> byte code offset #19
/*     */         //   Java source line #184	-> byte code offset #34
/*     */         //   Java source line #185	-> byte code offset #38
/*     */         //   Java source line #188	-> byte code offset #53
/*     */         //   Java source line #189	-> byte code offset #57
/*     */         //   Java source line #190	-> byte code offset #61
/*     */         //   Java source line #188	-> byte code offset #64
/*     */         //   Java source line #189	-> byte code offset #70
/*     */         //   Java source line #191	-> byte code offset #77
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	80	0	this	Proxy
/*     */         //   0	80	1	paramString	String
/*     */         //   3	68	2	localParcel1	Parcel
/*     */         //   7	60	3	localParcel2	Parcel
/*     */         //   51	27	4	bool	boolean
/*     */         //   64	11	5	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   8	53	64	finally
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\controller\api\IControllerService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */