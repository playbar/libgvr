/*     */ package com.google.vr.vrcore.common.api;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ 
/*     */ public abstract interface IDaydreamManager extends android.os.IInterface { public abstract boolean registerListener(android.content.ComponentName paramComponentName, IDaydreamListener paramIDaydreamListener) throws android.os.RemoteException;
/*     */   
/*     */   public abstract boolean unregisterListener(android.content.ComponentName paramComponentName) throws android.os.RemoteException;
/*     */   
/*     */   public abstract int prepareVr(android.content.ComponentName paramComponentName, HeadTrackingState paramHeadTrackingState) throws android.os.RemoteException;
/*     */   
/*     */   public abstract boolean deprecatedLaunchInVr(android.app.PendingIntent paramPendingIntent) throws android.os.RemoteException;
/*     */   
/*     */   public abstract void registerDaydreamIntent(android.app.PendingIntent paramPendingIntent) throws android.os.RemoteException;
/*     */   
/*     */   public abstract void unregisterDaydreamIntent() throws android.os.RemoteException;
/*     */   
/*     */   public abstract boolean launchInVr(android.app.PendingIntent paramPendingIntent, android.content.ComponentName paramComponentName) throws android.os.RemoteException;
/*     */   
/*     */   public abstract boolean launchVrHome() throws android.os.RemoteException;
/*     */   
/*     */   public abstract boolean launchVrTransition(ITransitionCallbacks paramITransitionCallbacks) throws android.os.RemoteException;
/*     */   
/*     */   public abstract boolean exitFromVr(android.app.PendingIntent paramPendingIntent) throws android.os.RemoteException;
/*     */   
/*     */   public abstract void handleInsertionIntoHeadset(byte[] paramArrayOfByte) throws android.os.RemoteException;
/*     */   
/*     */   public abstract void handleRemovalFromHeadset() throws android.os.RemoteException;
/*     */   
/*  29 */   public static abstract class Stub extends android.os.Binder implements IDaydreamManager { public Stub() { attachInterface(this, "com.google.vr.vrcore.common.api.IDaydreamManager"); }
/*     */     
/*     */     private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.IDaydreamManager";
/*     */     static final int TRANSACTION_registerListener = 1;
/*     */     static final int TRANSACTION_unregisterListener = 2;
/*     */     static final int TRANSACTION_prepareVr = 3;
/*     */     
/*     */     public static IDaydreamManager asInterface(android.os.IBinder paramIBinder) {
/*  37 */       if (paramIBinder == null) {
/*  38 */         return null;
/*     */       }
/*     */       android.os.IInterface localIInterface;
/*  41 */       if (((localIInterface = paramIBinder.queryLocalInterface("com.google.vr.vrcore.common.api.IDaydreamManager")) != null) && ((localIInterface instanceof IDaydreamManager))) {
/*  42 */         return (IDaydreamManager)localIInterface;
/*     */       }
/*  44 */       return new Proxy(paramIBinder); }
/*     */     
/*     */     static final int TRANSACTION_deprecatedLaunchInVr = 4;
/*     */     
/*  48 */     public android.os.IBinder asBinder() { return this; }
/*     */     
/*     */     static final int TRANSACTION_registerDaydreamIntent = 5;
/*     */     
/*  52 */     public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws android.os.RemoteException { Object localObject1; Object localObject2; boolean bool4; switch (paramInt1)
/*     */       {
/*     */ 
/*     */       case 1598968902: 
/*  56 */         paramParcel2.writeString("com.google.vr.vrcore.common.api.IDaydreamManager");
/*  57 */         return true;
/*     */       
/*     */ 
/*     */       case 1: 
/*  61 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
/*     */         
/*  63 */         if (0 != paramParcel1.readInt()) {
/*  64 */           localObject1 = (android.content.ComponentName)android.content.ComponentName.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/*  67 */           localObject1 = null;
/*     */         }
/*     */         
/*  70 */         IDaydreamListener localIDaydreamListener = IDaydreamListener.Stub.asInterface(paramParcel1.readStrongBinder());
/*  71 */         boolean bool5 = registerListener((android.content.ComponentName)localObject1, localIDaydreamListener);
/*  72 */         paramParcel2.writeNoException();
/*  73 */         paramParcel2.writeInt(bool5 ? 1 : 0);
/*  74 */         return true;
/*     */       
/*     */ 
/*     */       case 2: 
/*  78 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
/*     */         
/*  80 */         if (0 != paramParcel1.readInt()) {
/*  81 */           localObject1 = (android.content.ComponentName)android.content.ComponentName.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/*  84 */           localObject1 = null;
/*     */         }
/*  86 */         boolean bool2 = unregisterListener((android.content.ComponentName)localObject1);
/*  87 */         paramParcel2.writeNoException();
/*  88 */         paramParcel2.writeInt(bool2 ? 1 : 0);
/*  89 */         return true;
/*     */       
/*     */ 
/*     */       case 3: 
/*  93 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
/*     */         
/*  95 */         if (0 != paramParcel1.readInt()) {
/*  96 */           localObject1 = (android.content.ComponentName)android.content.ComponentName.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/*  99 */           localObject1 = null;
/*     */         }
/*     */         
/* 102 */         HeadTrackingState localHeadTrackingState = new HeadTrackingState();
/* 103 */         int i = prepareVr((android.content.ComponentName)localObject1, localHeadTrackingState);
/* 104 */         paramParcel2.writeNoException();
/* 105 */         paramParcel2.writeInt(i);
/*     */         
/* 107 */         paramParcel2.writeInt(1);
/* 108 */         localHeadTrackingState.writeToParcel(paramParcel2, 1);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 113 */         return true;
/*     */       
/*     */ 
/*     */       case 4: 
/* 117 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
/*     */         
/* 119 */         if (0 != paramParcel1.readInt()) {
/* 120 */           localObject1 = (android.app.PendingIntent)android.app.PendingIntent.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/* 123 */           localObject1 = null;
/*     */         }
/* 125 */         boolean bool3 = deprecatedLaunchInVr((android.app.PendingIntent)localObject1);
/* 126 */         paramParcel2.writeNoException();
/* 127 */         paramParcel2.writeInt(bool3 ? 1 : 0);
/* 128 */         return true;
/*     */       
/*     */ 
/*     */       case 5: 
/* 132 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
/*     */         
/* 134 */         if (0 != paramParcel1.readInt()) {
/* 135 */           localObject1 = (android.app.PendingIntent)android.app.PendingIntent.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/* 138 */           localObject1 = null;
/*     */         }
/* 140 */         registerDaydreamIntent((android.app.PendingIntent)localObject1);
/* 141 */         return true;
/*     */       
/*     */ 
/*     */       case 6: 
/* 145 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
/* 146 */         unregisterDaydreamIntent();
/* 147 */         return true;
/*     */       
/*     */ 
/*     */       case 7: 
/* 151 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
/*     */         
/* 153 */         if (0 != paramParcel1.readInt()) {
/* 154 */           localObject1 = (android.app.PendingIntent)android.app.PendingIntent.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/* 157 */           localObject1 = null;
/*     */         }
/*     */         android.content.ComponentName localComponentName;
/* 160 */         if (0 != paramParcel1.readInt()) {
/* 161 */           localComponentName = (android.content.ComponentName)android.content.ComponentName.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/* 164 */           localComponentName = null;
/*     */         }
/* 166 */         boolean bool6 = launchInVr((android.app.PendingIntent)localObject1, localComponentName);
/* 167 */         paramParcel2.writeNoException();
/* 168 */         paramParcel2.writeInt(bool6 ? 1 : 0);
/* 169 */         return true;
/*     */       
/*     */ 
/*     */       case 8: 
/* 173 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
/* 174 */         boolean bool1 = launchVrHome();
/* 175 */         paramParcel2.writeNoException();
/* 176 */         paramParcel2.writeInt(bool1 ? 1 : 0);
/* 177 */         return true;
/*     */       
/*     */ 
/*     */       case 9: 
/* 181 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
/*     */         
/* 183 */         localObject2 = ITransitionCallbacks.Stub.asInterface(paramParcel1.readStrongBinder());
/* 184 */         bool4 = launchVrTransition((ITransitionCallbacks)localObject2);
/* 185 */         paramParcel2.writeNoException();
/* 186 */         paramParcel2.writeInt(bool4 ? 1 : 0);
/* 187 */         return true;
/*     */       
/*     */ 
/*     */       case 10: 
/* 191 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
/*     */         
/* 193 */         if (0 != paramParcel1.readInt()) {
/* 194 */           localObject2 = (android.app.PendingIntent)android.app.PendingIntent.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/* 197 */           localObject2 = null;
/*     */         }
/* 199 */         bool4 = exitFromVr((android.app.PendingIntent)localObject2);
/* 200 */         paramParcel2.writeNoException();
/* 201 */         paramParcel2.writeInt(bool4 ? 1 : 0);
/* 202 */         return true;
/*     */       
/*     */ 
/*     */       case 11: 
/* 206 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
/*     */         
/* 208 */         localObject2 = paramParcel1.createByteArray();
/* 209 */         handleInsertionIntoHeadset((byte[])localObject2);
/* 210 */         return true;
/*     */       
/*     */ 
/*     */       case 12: 
/* 214 */         paramParcel1.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
/* 215 */         handleRemovalFromHeadset();
/* 216 */         return true;
/*     */       }
/*     */       
/* 219 */       return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
/*     */     }
/*     */     
/*     */     static final int TRANSACTION_unregisterDaydreamIntent = 6;
/*     */     static final int TRANSACTION_launchInVr = 7;
/*     */     static final int TRANSACTION_launchVrHome = 8;
/*     */     
/* 226 */     private static class Proxy implements IDaydreamManager { Proxy(android.os.IBinder paramIBinder) { this.mRemote = paramIBinder; }
/*     */       
/*     */ 
/*     */       public android.os.IBinder asBinder() {
/* 230 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 234 */         return "com.google.vr.vrcore.common.api.IDaydreamManager";
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public boolean registerListener(android.content.ComponentName paramComponentName, IDaydreamListener paramIDaydreamListener)
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
/*     */         //   27: invokevirtual 18	android/content/ComponentName:writeToParcel	(Landroid/os/Parcel;I)V
/*     */         //   30: goto +8 -> 38
/*     */         //   33: aload_3
/*     */         //   34: iconst_0
/*     */         //   35: invokevirtual 24	android/os/Parcel:writeInt	(I)V
/*     */         //   38: aload_3
/*     */         //   39: aload_2
/*     */         //   40: ifnull +12 -> 52
/*     */         //   43: aload_2
/*     */         //   44: invokeinterface 30 1 0
/*     */         //   49: goto +4 -> 53
/*     */         //   52: aconst_null
/*     */         //   53: invokevirtual 26	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
/*     */         //   56: aload_0
/*     */         //   57: getfield 16	com/google/vr/vrcore/common/api/IDaydreamManager$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   60: iconst_1
/*     */         //   61: aload_3
/*     */         //   62: aload 4
/*     */         //   64: iconst_0
/*     */         //   65: invokeinterface 29 5 0
/*     */         //   70: pop
/*     */         //   71: aload 4
/*     */         //   73: invokevirtual 20	android/os/Parcel:readException	()V
/*     */         //   76: iconst_0
/*     */         //   77: aload 4
/*     */         //   79: invokevirtual 21	android/os/Parcel:readInt	()I
/*     */         //   82: if_icmpeq +7 -> 89
/*     */         //   85: iconst_1
/*     */         //   86: goto +4 -> 90
/*     */         //   89: iconst_0
/*     */         //   90: istore 5
/*     */         //   92: aload 4
/*     */         //   94: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   97: aload_3
/*     */         //   98: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   101: goto +17 -> 118
/*     */         //   104: astore 6
/*     */         //   106: aload 4
/*     */         //   108: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   111: aload_3
/*     */         //   112: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   115: aload 6
/*     */         //   117: athrow
/*     */         //   118: iload 5
/*     */         //   120: ireturn
/*     */         // Line number table:
/*     */         //   Java source line #258	-> byte code offset #0
/*     */         //   Java source line #259	-> byte code offset #4
/*     */         //   Java source line #262	-> byte code offset #9
/*     */         //   Java source line #263	-> byte code offset #15
/*     */         //   Java source line #264	-> byte code offset #19
/*     */         //   Java source line #265	-> byte code offset #24
/*     */         //   Java source line #268	-> byte code offset #33
/*     */         //   Java source line #270	-> byte code offset #38
/*     */         //   Java source line #271	-> byte code offset #56
/*     */         //   Java source line #272	-> byte code offset #71
/*     */         //   Java source line #273	-> byte code offset #76
/*     */         //   Java source line #276	-> byte code offset #92
/*     */         //   Java source line #277	-> byte code offset #97
/*     */         //   Java source line #278	-> byte code offset #101
/*     */         //   Java source line #276	-> byte code offset #104
/*     */         //   Java source line #277	-> byte code offset #111
/*     */         //   Java source line #279	-> byte code offset #118
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	121	0	this	Proxy
/*     */         //   0	121	1	paramComponentName	android.content.ComponentName
/*     */         //   0	121	2	paramIDaydreamListener	IDaydreamListener
/*     */         //   3	109	3	localParcel1	Parcel
/*     */         //   7	100	4	localParcel2	Parcel
/*     */         //   90	29	5	bool	boolean
/*     */         //   104	12	6	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   9	92	104	finally
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public boolean unregisterListener(android.content.ComponentName paramComponentName)
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
/*     */         //   14: aload_1
/*     */         //   15: ifnull +17 -> 32
/*     */         //   18: aload_2
/*     */         //   19: iconst_1
/*     */         //   20: invokevirtual 24	android/os/Parcel:writeInt	(I)V
/*     */         //   23: aload_1
/*     */         //   24: aload_2
/*     */         //   25: iconst_0
/*     */         //   26: invokevirtual 18	android/content/ComponentName:writeToParcel	(Landroid/os/Parcel;I)V
/*     */         //   29: goto +8 -> 37
/*     */         //   32: aload_2
/*     */         //   33: iconst_0
/*     */         //   34: invokevirtual 24	android/os/Parcel:writeInt	(I)V
/*     */         //   37: aload_0
/*     */         //   38: getfield 16	com/google/vr/vrcore/common/api/IDaydreamManager$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   41: iconst_2
/*     */         //   42: aload_2
/*     */         //   43: aload_3
/*     */         //   44: iconst_0
/*     */         //   45: invokeinterface 29 5 0
/*     */         //   50: pop
/*     */         //   51: aload_3
/*     */         //   52: invokevirtual 20	android/os/Parcel:readException	()V
/*     */         //   55: iconst_0
/*     */         //   56: aload_3
/*     */         //   57: invokevirtual 21	android/os/Parcel:readInt	()I
/*     */         //   60: if_icmpeq +7 -> 67
/*     */         //   63: iconst_1
/*     */         //   64: goto +4 -> 68
/*     */         //   67: iconst_0
/*     */         //   68: istore 4
/*     */         //   70: aload_3
/*     */         //   71: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   74: aload_2
/*     */         //   75: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   78: goto +16 -> 94
/*     */         //   81: astore 5
/*     */         //   83: aload_3
/*     */         //   84: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   87: aload_2
/*     */         //   88: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   91: aload 5
/*     */         //   93: athrow
/*     */         //   94: iload 4
/*     */         //   96: ireturn
/*     */         // Line number table:
/*     */         //   Java source line #295	-> byte code offset #0
/*     */         //   Java source line #296	-> byte code offset #4
/*     */         //   Java source line #299	-> byte code offset #8
/*     */         //   Java source line #300	-> byte code offset #14
/*     */         //   Java source line #301	-> byte code offset #18
/*     */         //   Java source line #302	-> byte code offset #23
/*     */         //   Java source line #305	-> byte code offset #32
/*     */         //   Java source line #307	-> byte code offset #37
/*     */         //   Java source line #308	-> byte code offset #51
/*     */         //   Java source line #309	-> byte code offset #55
/*     */         //   Java source line #312	-> byte code offset #70
/*     */         //   Java source line #313	-> byte code offset #74
/*     */         //   Java source line #314	-> byte code offset #78
/*     */         //   Java source line #312	-> byte code offset #81
/*     */         //   Java source line #313	-> byte code offset #87
/*     */         //   Java source line #315	-> byte code offset #94
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	97	0	this	Proxy
/*     */         //   0	97	1	paramComponentName	android.content.ComponentName
/*     */         //   3	85	2	localParcel1	Parcel
/*     */         //   7	77	3	localParcel2	Parcel
/*     */         //   68	27	4	bool	boolean
/*     */         //   81	11	5	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   8	70	81	finally
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public int prepareVr(android.content.ComponentName paramComponentName, HeadTrackingState paramHeadTrackingState)
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
/*     */         //   27: invokevirtual 18	android/content/ComponentName:writeToParcel	(Landroid/os/Parcel;I)V
/*     */         //   30: goto +8 -> 38
/*     */         //   33: aload_3
/*     */         //   34: iconst_0
/*     */         //   35: invokevirtual 24	android/os/Parcel:writeInt	(I)V
/*     */         //   38: aload_0
/*     */         //   39: getfield 16	com/google/vr/vrcore/common/api/IDaydreamManager$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   42: iconst_3
/*     */         //   43: aload_3
/*     */         //   44: aload 4
/*     */         //   46: iconst_0
/*     */         //   47: invokeinterface 29 5 0
/*     */         //   52: pop
/*     */         //   53: aload 4
/*     */         //   55: invokevirtual 20	android/os/Parcel:readException	()V
/*     */         //   58: aload 4
/*     */         //   60: invokevirtual 21	android/os/Parcel:readInt	()I
/*     */         //   63: istore 5
/*     */         //   65: iconst_0
/*     */         //   66: aload 4
/*     */         //   68: invokevirtual 21	android/os/Parcel:readInt	()I
/*     */         //   71: if_icmpeq +9 -> 80
/*     */         //   74: aload_2
/*     */         //   75: aload 4
/*     */         //   77: invokevirtual 27	com/google/vr/vrcore/common/api/HeadTrackingState:readFromParcel	(Landroid/os/Parcel;)V
/*     */         //   80: aload 4
/*     */         //   82: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   85: aload_3
/*     */         //   86: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   89: goto +17 -> 106
/*     */         //   92: astore 6
/*     */         //   94: aload 4
/*     */         //   96: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   99: aload_3
/*     */         //   100: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   103: aload 6
/*     */         //   105: athrow
/*     */         //   106: iload 5
/*     */         //   108: ireturn
/*     */         // Line number table:
/*     */         //   Java source line #319	-> byte code offset #0
/*     */         //   Java source line #320	-> byte code offset #4
/*     */         //   Java source line #323	-> byte code offset #9
/*     */         //   Java source line #324	-> byte code offset #15
/*     */         //   Java source line #325	-> byte code offset #19
/*     */         //   Java source line #326	-> byte code offset #24
/*     */         //   Java source line #329	-> byte code offset #33
/*     */         //   Java source line #331	-> byte code offset #38
/*     */         //   Java source line #332	-> byte code offset #53
/*     */         //   Java source line #333	-> byte code offset #58
/*     */         //   Java source line #334	-> byte code offset #65
/*     */         //   Java source line #335	-> byte code offset #74
/*     */         //   Java source line #339	-> byte code offset #80
/*     */         //   Java source line #340	-> byte code offset #85
/*     */         //   Java source line #341	-> byte code offset #89
/*     */         //   Java source line #339	-> byte code offset #92
/*     */         //   Java source line #340	-> byte code offset #99
/*     */         //   Java source line #342	-> byte code offset #106
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	109	0	this	Proxy
/*     */         //   0	109	1	paramComponentName	android.content.ComponentName
/*     */         //   0	109	2	paramHeadTrackingState	HeadTrackingState
/*     */         //   3	97	3	localParcel1	Parcel
/*     */         //   7	88	4	localParcel2	Parcel
/*     */         //   63	44	5	i	int
/*     */         //   92	12	6	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   9	80	92	finally
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public boolean deprecatedLaunchInVr(android.app.PendingIntent paramPendingIntent)
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
/*     */         //   14: aload_1
/*     */         //   15: ifnull +17 -> 32
/*     */         //   18: aload_2
/*     */         //   19: iconst_1
/*     */         //   20: invokevirtual 24	android/os/Parcel:writeInt	(I)V
/*     */         //   23: aload_1
/*     */         //   24: aload_2
/*     */         //   25: iconst_0
/*     */         //   26: invokevirtual 17	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
/*     */         //   29: goto +8 -> 37
/*     */         //   32: aload_2
/*     */         //   33: iconst_0
/*     */         //   34: invokevirtual 24	android/os/Parcel:writeInt	(I)V
/*     */         //   37: aload_0
/*     */         //   38: getfield 16	com/google/vr/vrcore/common/api/IDaydreamManager$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   41: iconst_4
/*     */         //   42: aload_2
/*     */         //   43: aload_3
/*     */         //   44: iconst_0
/*     */         //   45: invokeinterface 29 5 0
/*     */         //   50: pop
/*     */         //   51: aload_3
/*     */         //   52: invokevirtual 20	android/os/Parcel:readException	()V
/*     */         //   55: iconst_0
/*     */         //   56: aload_3
/*     */         //   57: invokevirtual 21	android/os/Parcel:readInt	()I
/*     */         //   60: if_icmpeq +7 -> 67
/*     */         //   63: iconst_1
/*     */         //   64: goto +4 -> 68
/*     */         //   67: iconst_0
/*     */         //   68: istore 4
/*     */         //   70: aload_3
/*     */         //   71: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   74: aload_2
/*     */         //   75: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   78: goto +16 -> 94
/*     */         //   81: astore 5
/*     */         //   83: aload_3
/*     */         //   84: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   87: aload_2
/*     */         //   88: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   91: aload 5
/*     */         //   93: athrow
/*     */         //   94: iload 4
/*     */         //   96: ireturn
/*     */         // Line number table:
/*     */         //   Java source line #363	-> byte code offset #0
/*     */         //   Java source line #364	-> byte code offset #4
/*     */         //   Java source line #367	-> byte code offset #8
/*     */         //   Java source line #368	-> byte code offset #14
/*     */         //   Java source line #369	-> byte code offset #18
/*     */         //   Java source line #370	-> byte code offset #23
/*     */         //   Java source line #373	-> byte code offset #32
/*     */         //   Java source line #375	-> byte code offset #37
/*     */         //   Java source line #376	-> byte code offset #51
/*     */         //   Java source line #377	-> byte code offset #55
/*     */         //   Java source line #380	-> byte code offset #70
/*     */         //   Java source line #381	-> byte code offset #74
/*     */         //   Java source line #382	-> byte code offset #78
/*     */         //   Java source line #380	-> byte code offset #81
/*     */         //   Java source line #381	-> byte code offset #87
/*     */         //   Java source line #383	-> byte code offset #94
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	97	0	this	Proxy
/*     */         //   0	97	1	paramPendingIntent	android.app.PendingIntent
/*     */         //   3	85	2	localParcel1	Parcel
/*     */         //   7	77	3	localParcel2	Parcel
/*     */         //   68	27	4	bool	boolean
/*     */         //   81	11	5	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   8	70	81	finally
/*     */       }
/*     */       
/*     */       public void registerDaydreamIntent(android.app.PendingIntent paramPendingIntent)
/*     */         throws android.os.RemoteException
/*     */       {
/* 399 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 401 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
/* 402 */           if (paramPendingIntent != null) {
/* 403 */             localParcel.writeInt(1);
/* 404 */             paramPendingIntent.writeToParcel(localParcel, 0);
/*     */           }
/*     */           else {
/* 407 */             localParcel.writeInt(0);
/*     */           }
/* 409 */           this.mRemote.transact(5, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 412 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       public void unregisterDaydreamIntent()
/*     */         throws android.os.RemoteException
/*     */       {
/* 423 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 425 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
/* 426 */           this.mRemote.transact(6, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 429 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public boolean launchInVr(android.app.PendingIntent paramPendingIntent, android.content.ComponentName paramComponentName)
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
/*     */         //   27: invokevirtual 17	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
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
/*     */         //   50: invokevirtual 18	android/content/ComponentName:writeToParcel	(Landroid/os/Parcel;I)V
/*     */         //   53: goto +8 -> 61
/*     */         //   56: aload_3
/*     */         //   57: iconst_0
/*     */         //   58: invokevirtual 24	android/os/Parcel:writeInt	(I)V
/*     */         //   61: aload_0
/*     */         //   62: getfield 16	com/google/vr/vrcore/common/api/IDaydreamManager$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   65: bipush 7
/*     */         //   67: aload_3
/*     */         //   68: aload 4
/*     */         //   70: iconst_0
/*     */         //   71: invokeinterface 29 5 0
/*     */         //   76: pop
/*     */         //   77: aload 4
/*     */         //   79: invokevirtual 20	android/os/Parcel:readException	()V
/*     */         //   82: iconst_0
/*     */         //   83: aload 4
/*     */         //   85: invokevirtual 21	android/os/Parcel:readInt	()I
/*     */         //   88: if_icmpeq +7 -> 95
/*     */         //   91: iconst_1
/*     */         //   92: goto +4 -> 96
/*     */         //   95: iconst_0
/*     */         //   96: istore 5
/*     */         //   98: aload 4
/*     */         //   100: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   103: aload_3
/*     */         //   104: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   107: goto +17 -> 124
/*     */         //   110: astore 6
/*     */         //   112: aload 4
/*     */         //   114: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   117: aload_3
/*     */         //   118: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   121: aload 6
/*     */         //   123: athrow
/*     */         //   124: iload 5
/*     */         //   126: ireturn
/*     */         // Line number table:
/*     */         //   Java source line #452	-> byte code offset #0
/*     */         //   Java source line #453	-> byte code offset #4
/*     */         //   Java source line #456	-> byte code offset #9
/*     */         //   Java source line #457	-> byte code offset #15
/*     */         //   Java source line #458	-> byte code offset #19
/*     */         //   Java source line #459	-> byte code offset #24
/*     */         //   Java source line #462	-> byte code offset #33
/*     */         //   Java source line #464	-> byte code offset #38
/*     */         //   Java source line #465	-> byte code offset #42
/*     */         //   Java source line #466	-> byte code offset #47
/*     */         //   Java source line #469	-> byte code offset #56
/*     */         //   Java source line #471	-> byte code offset #61
/*     */         //   Java source line #472	-> byte code offset #77
/*     */         //   Java source line #473	-> byte code offset #82
/*     */         //   Java source line #476	-> byte code offset #98
/*     */         //   Java source line #477	-> byte code offset #103
/*     */         //   Java source line #478	-> byte code offset #107
/*     */         //   Java source line #476	-> byte code offset #110
/*     */         //   Java source line #477	-> byte code offset #117
/*     */         //   Java source line #479	-> byte code offset #124
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	127	0	this	Proxy
/*     */         //   0	127	1	paramPendingIntent	android.app.PendingIntent
/*     */         //   0	127	2	paramComponentName	android.content.ComponentName
/*     */         //   3	115	3	localParcel1	Parcel
/*     */         //   7	106	4	localParcel2	Parcel
/*     */         //   96	29	5	bool	boolean
/*     */         //   110	12	6	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   9	98	110	finally
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public boolean launchVrHome()
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
/*     */         //   15: getfield 16	com/google/vr/vrcore/common/api/IDaydreamManager$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   18: bipush 8
/*     */         //   20: aload_1
/*     */         //   21: aload_2
/*     */         //   22: iconst_0
/*     */         //   23: invokeinterface 29 5 0
/*     */         //   28: pop
/*     */         //   29: aload_2
/*     */         //   30: invokevirtual 20	android/os/Parcel:readException	()V
/*     */         //   33: iconst_0
/*     */         //   34: aload_2
/*     */         //   35: invokevirtual 21	android/os/Parcel:readInt	()I
/*     */         //   38: if_icmpeq +7 -> 45
/*     */         //   41: iconst_1
/*     */         //   42: goto +4 -> 46
/*     */         //   45: iconst_0
/*     */         //   46: istore_3
/*     */         //   47: aload_2
/*     */         //   48: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   51: aload_1
/*     */         //   52: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   55: goto +16 -> 71
/*     */         //   58: astore 4
/*     */         //   60: aload_2
/*     */         //   61: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   64: aload_1
/*     */         //   65: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   68: aload 4
/*     */         //   70: athrow
/*     */         //   71: iload_3
/*     */         //   72: ireturn
/*     */         // Line number table:
/*     */         //   Java source line #491	-> byte code offset #0
/*     */         //   Java source line #492	-> byte code offset #4
/*     */         //   Java source line #495	-> byte code offset #8
/*     */         //   Java source line #496	-> byte code offset #14
/*     */         //   Java source line #497	-> byte code offset #29
/*     */         //   Java source line #498	-> byte code offset #33
/*     */         //   Java source line #501	-> byte code offset #47
/*     */         //   Java source line #502	-> byte code offset #51
/*     */         //   Java source line #503	-> byte code offset #55
/*     */         //   Java source line #501	-> byte code offset #58
/*     */         //   Java source line #502	-> byte code offset #64
/*     */         //   Java source line #504	-> byte code offset #71
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	73	0	this	Proxy
/*     */         //   3	62	1	localParcel1	Parcel
/*     */         //   7	54	2	localParcel2	Parcel
/*     */         //   46	26	3	bool	boolean
/*     */         //   58	11	4	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   8	47	58	finally
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public boolean launchVrTransition(ITransitionCallbacks paramITransitionCallbacks)
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
/*     */         //   15: aload_1
/*     */         //   16: ifnull +12 -> 28
/*     */         //   19: aload_1
/*     */         //   20: invokeinterface 31 1 0
/*     */         //   25: goto +4 -> 29
/*     */         //   28: aconst_null
/*     */         //   29: invokevirtual 26	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
/*     */         //   32: aload_0
/*     */         //   33: getfield 16	com/google/vr/vrcore/common/api/IDaydreamManager$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   36: bipush 9
/*     */         //   38: aload_2
/*     */         //   39: aload_3
/*     */         //   40: iconst_0
/*     */         //   41: invokeinterface 29 5 0
/*     */         //   46: pop
/*     */         //   47: aload_3
/*     */         //   48: invokevirtual 20	android/os/Parcel:readException	()V
/*     */         //   51: iconst_0
/*     */         //   52: aload_3
/*     */         //   53: invokevirtual 21	android/os/Parcel:readInt	()I
/*     */         //   56: if_icmpeq +7 -> 63
/*     */         //   59: iconst_1
/*     */         //   60: goto +4 -> 64
/*     */         //   63: iconst_0
/*     */         //   64: istore 4
/*     */         //   66: aload_3
/*     */         //   67: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   70: aload_2
/*     */         //   71: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   74: goto +16 -> 90
/*     */         //   77: astore 5
/*     */         //   79: aload_3
/*     */         //   80: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   83: aload_2
/*     */         //   84: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   87: aload 5
/*     */         //   89: athrow
/*     */         //   90: iload 4
/*     */         //   92: ireturn
/*     */         // Line number table:
/*     */         //   Java source line #518	-> byte code offset #0
/*     */         //   Java source line #519	-> byte code offset #4
/*     */         //   Java source line #522	-> byte code offset #8
/*     */         //   Java source line #523	-> byte code offset #14
/*     */         //   Java source line #524	-> byte code offset #32
/*     */         //   Java source line #525	-> byte code offset #47
/*     */         //   Java source line #526	-> byte code offset #51
/*     */         //   Java source line #529	-> byte code offset #66
/*     */         //   Java source line #530	-> byte code offset #70
/*     */         //   Java source line #531	-> byte code offset #74
/*     */         //   Java source line #529	-> byte code offset #77
/*     */         //   Java source line #530	-> byte code offset #83
/*     */         //   Java source line #532	-> byte code offset #90
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	93	0	this	Proxy
/*     */         //   0	93	1	paramITransitionCallbacks	ITransitionCallbacks
/*     */         //   3	81	2	localParcel1	Parcel
/*     */         //   7	73	3	localParcel2	Parcel
/*     */         //   64	27	4	bool	boolean
/*     */         //   77	11	5	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   8	66	77	finally
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public boolean exitFromVr(android.app.PendingIntent paramPendingIntent)
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
/*     */         //   14: aload_1
/*     */         //   15: ifnull +17 -> 32
/*     */         //   18: aload_2
/*     */         //   19: iconst_1
/*     */         //   20: invokevirtual 24	android/os/Parcel:writeInt	(I)V
/*     */         //   23: aload_1
/*     */         //   24: aload_2
/*     */         //   25: iconst_0
/*     */         //   26: invokevirtual 17	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
/*     */         //   29: goto +8 -> 37
/*     */         //   32: aload_2
/*     */         //   33: iconst_0
/*     */         //   34: invokevirtual 24	android/os/Parcel:writeInt	(I)V
/*     */         //   37: aload_0
/*     */         //   38: getfield 16	com/google/vr/vrcore/common/api/IDaydreamManager$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   41: bipush 10
/*     */         //   43: aload_2
/*     */         //   44: aload_3
/*     */         //   45: iconst_0
/*     */         //   46: invokeinterface 29 5 0
/*     */         //   51: pop
/*     */         //   52: aload_3
/*     */         //   53: invokevirtual 20	android/os/Parcel:readException	()V
/*     */         //   56: iconst_0
/*     */         //   57: aload_3
/*     */         //   58: invokevirtual 21	android/os/Parcel:readInt	()I
/*     */         //   61: if_icmpeq +7 -> 68
/*     */         //   64: iconst_1
/*     */         //   65: goto +4 -> 69
/*     */         //   68: iconst_0
/*     */         //   69: istore 4
/*     */         //   71: aload_3
/*     */         //   72: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   75: aload_2
/*     */         //   76: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   79: goto +16 -> 95
/*     */         //   82: astore 5
/*     */         //   84: aload_3
/*     */         //   85: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   88: aload_2
/*     */         //   89: invokevirtual 22	android/os/Parcel:recycle	()V
/*     */         //   92: aload 5
/*     */         //   94: athrow
/*     */         //   95: iload 4
/*     */         //   97: ireturn
/*     */         // Line number table:
/*     */         //   Java source line #555	-> byte code offset #0
/*     */         //   Java source line #556	-> byte code offset #4
/*     */         //   Java source line #559	-> byte code offset #8
/*     */         //   Java source line #560	-> byte code offset #14
/*     */         //   Java source line #561	-> byte code offset #18
/*     */         //   Java source line #562	-> byte code offset #23
/*     */         //   Java source line #565	-> byte code offset #32
/*     */         //   Java source line #567	-> byte code offset #37
/*     */         //   Java source line #568	-> byte code offset #52
/*     */         //   Java source line #569	-> byte code offset #56
/*     */         //   Java source line #572	-> byte code offset #71
/*     */         //   Java source line #573	-> byte code offset #75
/*     */         //   Java source line #574	-> byte code offset #79
/*     */         //   Java source line #572	-> byte code offset #82
/*     */         //   Java source line #573	-> byte code offset #88
/*     */         //   Java source line #575	-> byte code offset #95
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	98	0	this	Proxy
/*     */         //   0	98	1	paramPendingIntent	android.app.PendingIntent
/*     */         //   3	86	2	localParcel1	Parcel
/*     */         //   7	78	3	localParcel2	Parcel
/*     */         //   69	27	4	bool	boolean
/*     */         //   82	11	5	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   8	71	82	finally
/*     */       }
/*     */       
/*     */       public void handleInsertionIntoHeadset(byte[] paramArrayOfByte)
/*     */         throws android.os.RemoteException
/*     */       {
/* 595 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 597 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
/* 598 */           localParcel.writeByteArray(paramArrayOfByte);
/* 599 */           this.mRemote.transact(11, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 602 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */       private android.os.IBinder mRemote;
/*     */       
/*     */ 
/*     */       public void handleRemovalFromHeadset()
/*     */         throws android.os.RemoteException
/*     */       {
/* 615 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 617 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
/* 618 */           this.mRemote.transact(12, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 621 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     static final int TRANSACTION_launchVrTransition = 9;
/*     */     static final int TRANSACTION_exitFromVr = 10;
/*     */     static final int TRANSACTION_handleInsertionIntoHeadset = 11;
/*     */     static final int TRANSACTION_handleRemovalFromHeadset = 12;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\common\api\IDaydreamManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */