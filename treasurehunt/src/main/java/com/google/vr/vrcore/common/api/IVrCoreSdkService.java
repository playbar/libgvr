/*     */ package com.google.vr.vrcore.common.api;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ 
/*     */ public abstract interface IVrCoreSdkService extends android.os.IInterface
/*     */ {
/*     */   public abstract boolean initialize(int paramInt) throws android.os.RemoteException;
/*     */   
/*     */   public abstract IDaydreamManager getDaydreamManager() throws android.os.RemoteException;
/*     */   
/*     */   public abstract boolean setClientOptions(android.content.ComponentName paramComponentName, android.os.Bundle paramBundle) throws android.os.RemoteException;
/*     */   
/*     */   public abstract com.google.vr.vrcore.logging.api.IVrCoreLoggingService getLoggingService() throws android.os.RemoteException;
/*     */   
/*     */   public static abstract class Stub extends android.os.Binder implements IVrCoreSdkService
/*     */   {
/*     */     private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.IVrCoreSdkService";
/*     */     static final int TRANSACTION_initialize = 1;
/*     */     static final int TRANSACTION_getDaydreamManager = 2;
/*     */     static final int TRANSACTION_setClientOptions = 3;
/*     */     static final int TRANSACTION_getLoggingService = 4;
/*     */     
/*     */     public Stub()
/*     */     {
/*  25 */       attachInterface(this, "com.google.vr.vrcore.common.api.IVrCoreSdkService");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public static IVrCoreSdkService asInterface(android.os.IBinder paramIBinder)
/*     */     {
/*  33 */       if (paramIBinder == null) {
/*  34 */         return null;
/*     */       }
/*     */       android.os.IInterface localIInterface;
/*  37 */       if (((localIInterface = paramIBinder.queryLocalInterface("com.google.vr.vrcore.common.api.IVrCoreSdkService")) != null) && ((localIInterface instanceof IVrCoreSdkService))) {
/*  38 */         return (IVrCoreSdkService)localIInterface;
/*     */       }
/*  40 */       return new Proxy(paramIBinder);
/*     */     }
/*     */     
/*     */ 
/*  44 */     public android.os.IBinder asBinder() { return this; }
/*     */     
/*     */     public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws android.os.RemoteException {
/*     */       Object localObject;
/*  48 */       switch (paramInt1)
/*     */       {
/*     */ 
/*     */       case 1598968902: 
/*  52 */         paramParcel2.writeString("com.google.vr.vrcore.common.api.IVrCoreSdkService");
/*  53 */         return true;
/*     */       
/*     */ 
/*     */       case 1: 
/*  57 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IVrCoreSdkService");
/*     */         
/*  59 */         int i = paramParcel1.readInt();
/*  60 */         boolean bool1 = initialize(i);
/*  61 */         paramParcel2.writeNoException();
/*  62 */         paramParcel2.writeInt(bool1 ? 1 : 0);
/*  63 */         return true;
/*     */       
/*     */ 
/*     */       case 2: 
/*  67 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IVrCoreSdkService");
/*  68 */         localObject = getDaydreamManager();
/*  69 */         paramParcel2.writeNoException();
/*  70 */         paramParcel2.writeStrongBinder(localObject != null ? ((IDaydreamManager)localObject).asBinder() : null);
/*  71 */         return true;
/*     */       
/*     */ 
/*     */       case 3: 
/*  75 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IVrCoreSdkService");
/*     */         
/*  77 */         if (0 != paramParcel1.readInt()) {
/*  78 */           localObject = (android.content.ComponentName)android.content.ComponentName.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/*  81 */           localObject = null;
/*     */         }
/*     */         android.os.Bundle localBundle;
/*  84 */         if (0 != paramParcel1.readInt()) {
/*  85 */           localBundle = (android.os.Bundle)android.os.Bundle.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/*  88 */           localBundle = null;
/*     */         }
/*  90 */         boolean bool2 = setClientOptions((android.content.ComponentName)localObject, localBundle);
/*  91 */         paramParcel2.writeNoException();
/*  92 */         paramParcel2.writeInt(bool2 ? 1 : 0);
/*  93 */         return true;
/*     */       
/*     */ 
/*     */       case 4: 
/*  97 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IVrCoreSdkService");
/*  98 */         localObject = getLoggingService();
/*  99 */         paramParcel2.writeNoException();
/* 100 */         paramParcel2.writeStrongBinder(localObject != null ? ((com.google.vr.vrcore.logging.api.IVrCoreLoggingService)localObject).asBinder() : null);
/* 101 */         return true;
/*     */       }
/*     */       
/* 104 */       return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
/*     */     }
/*     */     
/*     */     private static class Proxy implements IVrCoreSdkService {
/*     */       private android.os.IBinder mRemote;
/*     */       
/*     */       Proxy(android.os.IBinder paramIBinder) {
/* 111 */         this.mRemote = paramIBinder;
/*     */       }
/*     */       
/*     */       public android.os.IBinder asBinder() {
/* 115 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 119 */         return "com.google.vr.vrcore.common.api.IVrCoreSdkService";
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public boolean initialize(int paramInt)
/*     */         throws android.os.RemoteException
/*     */       {
/*     */         // Byte code:
/*     */         //   0: invokestatic 19	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   3: astore_2
/*     */         //   4: invokestatic 19	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   7: astore_3
/*     */         //   8: aload_2
/*     */         //   9: ldc 1
/*     */         //   11: invokevirtual 25	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
/*     */         //   14: aload_2
/*     */         //   15: iload_1
/*     */         //   16: invokevirtual 24	android/os/Parcel:writeInt	(I)V
/*     */         //   19: aload_0
/*     */         //   20: getfield 16	com/google/vr/vrcore/common/api/IVrCoreSdkService$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   23: iconst_1
/*     */         //   24: aload_2
/*     */         //   25: aload_3
/*     */         //   26: iconst_0
/*     */         //   27: invokeinterface 29 5 0
/*     */         //   32: pop
/*     */         //   33: aload_3
/*     */         //   34: invokevirtual 20	android/os/Parcel:readException	()V
/*     */         //   37: iconst_0
/*     */         //   38: aload_3
/*     */         //   39: invokevirtual 21	android/os/Parcel:readInt	()I
/*     */         //   42: if_icmpeq +7 -> 49
/*     */         //   45: iconst_1
/*     */         //   46: goto +4 -> 50
/*     */         //   49: iconst_0
/*     */         //   50: istore 4
/*     */         //   52: aload_3
/*     */         //   53: invokevirtual 23	android/os/Parcel:recycle	()V
/*     */         //   56: aload_2
/*     */         //   57: invokevirtual 23	android/os/Parcel:recycle	()V
/*     */         //   60: goto +16 -> 76
/*     */         //   63: astore 5
/*     */         //   65: aload_3
/*     */         //   66: invokevirtual 23	android/os/Parcel:recycle	()V
/*     */         //   69: aload_2
/*     */         //   70: invokevirtual 23	android/os/Parcel:recycle	()V
/*     */         //   73: aload 5
/*     */         //   75: athrow
/*     */         //   76: iload 4
/*     */         //   78: ireturn
/*     */         // Line number table:
/*     */         //   Java source line #134	-> byte code offset #0
/*     */         //   Java source line #135	-> byte code offset #4
/*     */         //   Java source line #138	-> byte code offset #8
/*     */         //   Java source line #139	-> byte code offset #14
/*     */         //   Java source line #140	-> byte code offset #19
/*     */         //   Java source line #141	-> byte code offset #33
/*     */         //   Java source line #142	-> byte code offset #37
/*     */         //   Java source line #145	-> byte code offset #52
/*     */         //   Java source line #146	-> byte code offset #56
/*     */         //   Java source line #147	-> byte code offset #60
/*     */         //   Java source line #145	-> byte code offset #63
/*     */         //   Java source line #146	-> byte code offset #69
/*     */         //   Java source line #148	-> byte code offset #76
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	79	0	this	Proxy
/*     */         //   0	79	1	paramInt	int
/*     */         //   3	67	2	localParcel1	Parcel
/*     */         //   7	59	3	localParcel2	Parcel
/*     */         //   50	27	4	bool	boolean
/*     */         //   63	11	5	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   8	52	63	finally
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public IDaydreamManager getDaydreamManager()
/*     */         throws android.os.RemoteException
/*     */       {
/*     */         // Byte code:
/*     */         //   0: invokestatic 19	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   3: astore_1
/*     */         //   4: invokestatic 19	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   7: astore_2
/*     */         //   8: aload_1
/*     */         //   9: ldc 1
/*     */         //   11: invokevirtual 25	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
/*     */         //   14: aload_0
/*     */         //   15: getfield 16	com/google/vr/vrcore/common/api/IVrCoreSdkService$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   18: iconst_2
/*     */         //   19: aload_1
/*     */         //   20: aload_2
/*     */         //   21: iconst_0
/*     */         //   22: invokeinterface 29 5 0
/*     */         //   27: pop
/*     */         //   28: aload_2
/*     */         //   29: invokevirtual 20	android/os/Parcel:readException	()V
/*     */         //   32: aload_2
/*     */         //   33: invokevirtual 22	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
/*     */         //   36: invokestatic 26	com/google/vr/vrcore/common/api/IDaydreamManager$Stub:asInterface	(Landroid/os/IBinder;)Lcom/google/vr/vrcore/common/api/IDaydreamManager;
/*     */         //   39: astore_3
/*     */         //   40: aload_2
/*     */         //   41: invokevirtual 23	android/os/Parcel:recycle	()V
/*     */         //   44: aload_1
/*     */         //   45: invokevirtual 23	android/os/Parcel:recycle	()V
/*     */         //   48: goto +16 -> 64
/*     */         //   51: astore 4
/*     */         //   53: aload_2
/*     */         //   54: invokevirtual 23	android/os/Parcel:recycle	()V
/*     */         //   57: aload_1
/*     */         //   58: invokevirtual 23	android/os/Parcel:recycle	()V
/*     */         //   61: aload 4
/*     */         //   63: athrow
/*     */         //   64: aload_3
/*     */         //   65: areturn
/*     */         // Line number table:
/*     */         //   Java source line #157	-> byte code offset #0
/*     */         //   Java source line #158	-> byte code offset #4
/*     */         //   Java source line #161	-> byte code offset #8
/*     */         //   Java source line #162	-> byte code offset #14
/*     */         //   Java source line #163	-> byte code offset #28
/*     */         //   Java source line #164	-> byte code offset #32
/*     */         //   Java source line #167	-> byte code offset #40
/*     */         //   Java source line #168	-> byte code offset #44
/*     */         //   Java source line #169	-> byte code offset #48
/*     */         //   Java source line #167	-> byte code offset #51
/*     */         //   Java source line #168	-> byte code offset #57
/*     */         //   Java source line #170	-> byte code offset #64
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	66	0	this	Proxy
/*     */         //   3	55	1	localParcel1	Parcel
/*     */         //   7	47	2	localParcel2	Parcel
/*     */         //   39	26	3	localIDaydreamManager	IDaydreamManager
/*     */         //   51	11	4	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   8	40	51	finally
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public boolean setClientOptions(android.content.ComponentName paramComponentName, android.os.Bundle paramBundle)
/*     */         throws android.os.RemoteException
/*     */       {
/*     */         // Byte code:
/*     */         //   0: invokestatic 19	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   3: astore_3
/*     */         //   4: invokestatic 19	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   7: astore 4
/*     */         //   9: aload_3
/*     */         //   10: ldc 1
/*     */         //   12: invokevirtual 25	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
/*     */         //   15: aload_1
/*     */         //   16: ifnull +17 -> 33
/*     */         //   19: aload_3
/*     */         //   20: iconst_1
/*     */         //   21: invokevirtual 24	android/os/Parcel:writeInt	(I)V
/*     */         //   24: aload_1
/*     */         //   25: aload_3
/*     */         //   26: iconst_0
/*     */         //   27: invokevirtual 17	android/content/ComponentName:writeToParcel	(Landroid/os/Parcel;I)V
/*     */         //   30: goto +8 -> 38
/*     */         //   33: aload_3
/*     */         //   34: iconst_0
/*     */         //   35: invokevirtual 24	android/os/Parcel:writeInt	(I)V
/*     */         //   38: aload_2
/*     */         //   39: ifnull +17 -> 56
/*     */         //   42: aload_3
/*     */         //   43: iconst_1
/*     */         //   44: invokevirtual 24	android/os/Parcel:writeInt	(I)V
/*     */         //   47: aload_2
/*     */         //   48: aload_3
/*     */         //   49: iconst_0
/*     */         //   50: invokevirtual 18	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
/*     */         //   53: goto +8 -> 61
/*     */         //   56: aload_3
/*     */         //   57: iconst_0
/*     */         //   58: invokevirtual 24	android/os/Parcel:writeInt	(I)V
/*     */         //   61: aload_0
/*     */         //   62: getfield 16	com/google/vr/vrcore/common/api/IVrCoreSdkService$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   65: iconst_3
/*     */         //   66: aload_3
/*     */         //   67: aload 4
/*     */         //   69: iconst_0
/*     */         //   70: invokeinterface 29 5 0
/*     */         //   75: pop
/*     */         //   76: aload 4
/*     */         //   78: invokevirtual 20	android/os/Parcel:readException	()V
/*     */         //   81: iconst_0
/*     */         //   82: aload 4
/*     */         //   84: invokevirtual 21	android/os/Parcel:readInt	()I
/*     */         //   87: if_icmpeq +7 -> 94
/*     */         //   90: iconst_1
/*     */         //   91: goto +4 -> 95
/*     */         //   94: iconst_0
/*     */         //   95: istore 5
/*     */         //   97: aload 4
/*     */         //   99: invokevirtual 23	android/os/Parcel:recycle	()V
/*     */         //   102: aload_3
/*     */         //   103: invokevirtual 23	android/os/Parcel:recycle	()V
/*     */         //   106: goto +17 -> 123
/*     */         //   109: astore 6
/*     */         //   111: aload 4
/*     */         //   113: invokevirtual 23	android/os/Parcel:recycle	()V
/*     */         //   116: aload_3
/*     */         //   117: invokevirtual 23	android/os/Parcel:recycle	()V
/*     */         //   120: aload 6
/*     */         //   122: athrow
/*     */         //   123: iload 5
/*     */         //   125: ireturn
/*     */         // Line number table:
/*     */         //   Java source line #198	-> byte code offset #0
/*     */         //   Java source line #199	-> byte code offset #4
/*     */         //   Java source line #202	-> byte code offset #9
/*     */         //   Java source line #203	-> byte code offset #15
/*     */         //   Java source line #204	-> byte code offset #19
/*     */         //   Java source line #205	-> byte code offset #24
/*     */         //   Java source line #208	-> byte code offset #33
/*     */         //   Java source line #210	-> byte code offset #38
/*     */         //   Java source line #211	-> byte code offset #42
/*     */         //   Java source line #212	-> byte code offset #47
/*     */         //   Java source line #215	-> byte code offset #56
/*     */         //   Java source line #217	-> byte code offset #61
/*     */         //   Java source line #218	-> byte code offset #76
/*     */         //   Java source line #219	-> byte code offset #81
/*     */         //   Java source line #222	-> byte code offset #97
/*     */         //   Java source line #223	-> byte code offset #102
/*     */         //   Java source line #224	-> byte code offset #106
/*     */         //   Java source line #222	-> byte code offset #109
/*     */         //   Java source line #223	-> byte code offset #116
/*     */         //   Java source line #225	-> byte code offset #123
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	126	0	this	Proxy
/*     */         //   0	126	1	paramComponentName	android.content.ComponentName
/*     */         //   0	126	2	paramBundle	android.os.Bundle
/*     */         //   3	114	3	localParcel1	Parcel
/*     */         //   7	105	4	localParcel2	Parcel
/*     */         //   95	29	5	bool	boolean
/*     */         //   109	12	6	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   9	97	109	finally
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public com.google.vr.vrcore.logging.api.IVrCoreLoggingService getLoggingService()
/*     */         throws android.os.RemoteException
/*     */       {
/*     */         // Byte code:
/*     */         //   0: invokestatic 19	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   3: astore_1
/*     */         //   4: invokestatic 19	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   7: astore_2
/*     */         //   8: aload_1
/*     */         //   9: ldc 1
/*     */         //   11: invokevirtual 25	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
/*     */         //   14: aload_0
/*     */         //   15: getfield 16	com/google/vr/vrcore/common/api/IVrCoreSdkService$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   18: iconst_4
/*     */         //   19: aload_1
/*     */         //   20: aload_2
/*     */         //   21: iconst_0
/*     */         //   22: invokeinterface 29 5 0
/*     */         //   27: pop
/*     */         //   28: aload_2
/*     */         //   29: invokevirtual 20	android/os/Parcel:readException	()V
/*     */         //   32: aload_2
/*     */         //   33: invokevirtual 22	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
/*     */         //   36: invokestatic 27	com/google/vr/vrcore/logging/api/IVrCoreLoggingService$Stub:asInterface	(Landroid/os/IBinder;)Lcom/google/vr/vrcore/logging/api/IVrCoreLoggingService;
/*     */         //   39: astore_3
/*     */         //   40: aload_2
/*     */         //   41: invokevirtual 23	android/os/Parcel:recycle	()V
/*     */         //   44: aload_1
/*     */         //   45: invokevirtual 23	android/os/Parcel:recycle	()V
/*     */         //   48: goto +16 -> 64
/*     */         //   51: astore 4
/*     */         //   53: aload_2
/*     */         //   54: invokevirtual 23	android/os/Parcel:recycle	()V
/*     */         //   57: aload_1
/*     */         //   58: invokevirtual 23	android/os/Parcel:recycle	()V
/*     */         //   61: aload 4
/*     */         //   63: athrow
/*     */         //   64: aload_3
/*     */         //   65: areturn
/*     */         // Line number table:
/*     */         //   Java source line #237	-> byte code offset #0
/*     */         //   Java source line #238	-> byte code offset #4
/*     */         //   Java source line #241	-> byte code offset #8
/*     */         //   Java source line #242	-> byte code offset #14
/*     */         //   Java source line #243	-> byte code offset #28
/*     */         //   Java source line #244	-> byte code offset #32
/*     */         //   Java source line #247	-> byte code offset #40
/*     */         //   Java source line #248	-> byte code offset #44
/*     */         //   Java source line #249	-> byte code offset #48
/*     */         //   Java source line #247	-> byte code offset #51
/*     */         //   Java source line #248	-> byte code offset #57
/*     */         //   Java source line #250	-> byte code offset #64
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	66	0	this	Proxy
/*     */         //   3	55	1	localParcel1	Parcel
/*     */         //   7	47	2	localParcel2	Parcel
/*     */         //   39	26	3	localIVrCoreLoggingService	com.google.vr.vrcore.logging.api.IVrCoreLoggingService
/*     */         //   51	11	4	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   8	40	51	finally
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\common\api\IVrCoreSdkService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */