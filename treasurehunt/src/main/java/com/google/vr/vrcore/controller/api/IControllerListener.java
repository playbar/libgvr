/*     */ package com.google.vr.vrcore.controller.api;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ 
/*     */ public abstract interface IControllerListener extends android.os.IInterface
/*     */ {
/*     */   public abstract int getApiVersion() throws android.os.RemoteException;
/*     */   
/*     */   public abstract void onControllerStateChanged(int paramInt1, int paramInt2) throws android.os.RemoteException;
/*     */   
/*     */   public abstract void deprecatedOnControllerTouchEvent(ControllerTouchEvent paramControllerTouchEvent) throws android.os.RemoteException;
/*     */   
/*     */   public abstract void deprecatedOnControllerOrientationEvent(ControllerOrientationEvent paramControllerOrientationEvent) throws android.os.RemoteException;
/*     */   
/*     */   public abstract boolean deprecatedOnControllerButtonEventV1(ControllerButtonEvent paramControllerButtonEvent) throws android.os.RemoteException;
/*     */   
/*     */   public abstract void deprecatedOnControllerButtonEvent(ControllerButtonEvent paramControllerButtonEvent) throws android.os.RemoteException;
/*     */   
/*     */   public abstract void deprecatedOnControllerAccelEvent(ControllerAccelEvent paramControllerAccelEvent) throws android.os.RemoteException;
/*     */   
/*     */   public abstract void deprecatedOnControllerGyroEvent(ControllerGyroEvent paramControllerGyroEvent) throws android.os.RemoteException;
/*     */   
/*     */   public abstract ControllerListenerOptions getOptions() throws android.os.RemoteException;
/*     */   
/*     */   public abstract void onControllerEventPacket(ControllerEventPacket paramControllerEventPacket) throws android.os.RemoteException;
/*     */   
/*     */   public abstract void onControllerRecentered(ControllerOrientationEvent paramControllerOrientationEvent) throws android.os.RemoteException;
/*     */   
/*     */   public abstract void onControllerEventPacket2(ControllerEventPacket2 paramControllerEventPacket2) throws android.os.RemoteException;
/*     */   
/*     */   public static abstract class Stub extends android.os.Binder implements IControllerListener
/*     */   {
/*     */     private static final String DESCRIPTOR = "com.google.vr.vrcore.controller.api.IControllerListener";
/*     */     static final int TRANSACTION_getApiVersion = 1;
/*     */     static final int TRANSACTION_onControllerStateChanged = 2;
/*     */     static final int TRANSACTION_deprecatedOnControllerTouchEvent = 3;
/*     */     static final int TRANSACTION_deprecatedOnControllerOrientationEvent = 4;
/*     */     static final int TRANSACTION_deprecatedOnControllerButtonEventV1 = 5;
/*     */     
/*     */     public Stub() {
/*  41 */       attachInterface(this, "com.google.vr.vrcore.controller.api.IControllerListener");
/*     */     }
/*     */     
/*     */     static final int TRANSACTION_deprecatedOnControllerButtonEvent = 6;
/*     */     static final int TRANSACTION_deprecatedOnControllerAccelEvent = 7;
/*     */     static final int TRANSACTION_deprecatedOnControllerGyroEvent = 8;
/*     */     
/*     */     public static IControllerListener asInterface(android.os.IBinder paramIBinder) {
/*  49 */       if (paramIBinder == null) {
/*  50 */         return null;
/*     */       }
/*     */       android.os.IInterface localIInterface;
/*  53 */       if (((localIInterface = paramIBinder.queryLocalInterface("com.google.vr.vrcore.controller.api.IControllerListener")) != null) && ((localIInterface instanceof IControllerListener))) {
/*  54 */         return (IControllerListener)localIInterface;
/*     */       }
/*  56 */       return new Proxy(paramIBinder); }
/*     */     
/*     */     static final int TRANSACTION_getOptions = 9;
/*     */     
/*  60 */     public android.os.IBinder asBinder() { return this; }
/*     */     
/*     */     static final int TRANSACTION_onControllerEventPacket = 10;
/*     */     
/*  64 */     public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws android.os.RemoteException { int i; Object localObject; switch (paramInt1)
/*     */       {
/*     */ 
/*     */       case 1598968902: 
/*  68 */         paramParcel2.writeString("com.google.vr.vrcore.controller.api.IControllerListener");
/*  69 */         return true;
/*     */       
/*     */ 
/*     */       case 1: 
/*  73 */         paramParcel1.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
/*  74 */         i = getApiVersion();
/*  75 */         paramParcel2.writeNoException();
/*  76 */         paramParcel2.writeInt(i);
/*  77 */         return true;
/*     */       
/*     */ 
/*     */       case 2: 
/*  81 */         paramParcel1.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
/*     */         
/*  83 */         i = paramParcel1.readInt();
/*     */         
/*  85 */         int j = paramParcel1.readInt();
/*  86 */         onControllerStateChanged(i, j);
/*  87 */         return true;
/*     */       
/*     */ 
/*     */       case 3: 
/*  91 */         paramParcel1.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
/*     */         
/*  93 */         if (0 != paramParcel1.readInt()) {
/*  94 */           localObject = (ControllerTouchEvent)ControllerTouchEvent.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/*  97 */           localObject = null;
/*     */         }
/*  99 */         deprecatedOnControllerTouchEvent((ControllerTouchEvent)localObject);
/* 100 */         return true;
/*     */       
/*     */ 
/*     */       case 4: 
/* 104 */         paramParcel1.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
/*     */         
/* 106 */         if (0 != paramParcel1.readInt()) {
/* 107 */           localObject = (ControllerOrientationEvent)ControllerOrientationEvent.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/* 110 */           localObject = null;
/*     */         }
/* 112 */         deprecatedOnControllerOrientationEvent((ControllerOrientationEvent)localObject);
/* 113 */         return true;
/*     */       
/*     */ 
/*     */       case 5: 
/* 117 */         paramParcel1.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
/*     */         
/* 119 */         if (0 != paramParcel1.readInt()) {
/* 120 */           localObject = (ControllerButtonEvent)ControllerButtonEvent.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/* 123 */           localObject = null;
/*     */         }
/* 125 */         boolean bool = deprecatedOnControllerButtonEventV1((ControllerButtonEvent)localObject);
/* 126 */         paramParcel2.writeNoException();
/* 127 */         paramParcel2.writeInt(bool ? 1 : 0);
/* 128 */         return true;
/*     */       
/*     */ 
/*     */       case 6: 
/* 132 */         paramParcel1.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
/*     */         
/* 134 */         if (0 != paramParcel1.readInt()) {
/* 135 */           localObject = (ControllerButtonEvent)ControllerButtonEvent.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/* 138 */           localObject = null;
/*     */         }
/* 140 */         deprecatedOnControllerButtonEvent((ControllerButtonEvent)localObject);
/* 141 */         return true;
/*     */       
/*     */ 
/*     */       case 7: 
/* 145 */         paramParcel1.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
/*     */         
/* 147 */         if (0 != paramParcel1.readInt()) {
/* 148 */           localObject = (ControllerAccelEvent)ControllerAccelEvent.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/* 151 */           localObject = null;
/*     */         }
/* 153 */         deprecatedOnControllerAccelEvent((ControllerAccelEvent)localObject);
/* 154 */         return true;
/*     */       
/*     */ 
/*     */       case 8: 
/* 158 */         paramParcel1.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
/*     */         
/* 160 */         if (0 != paramParcel1.readInt()) {
/* 161 */           localObject = (ControllerGyroEvent)ControllerGyroEvent.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/* 164 */           localObject = null;
/*     */         }
/* 166 */         deprecatedOnControllerGyroEvent((ControllerGyroEvent)localObject);
/* 167 */         return true;
/*     */       
/*     */ 
/*     */       case 9: 
/* 171 */         paramParcel1.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
/* 172 */         localObject = getOptions();
/* 173 */         paramParcel2.writeNoException();
/* 174 */         if (localObject != null) {
/* 175 */           paramParcel2.writeInt(1);
/* 176 */           ((ControllerListenerOptions)localObject).writeToParcel(paramParcel2, 1);
/*     */         }
/*     */         else {
/* 179 */           paramParcel2.writeInt(0);
/*     */         }
/* 181 */         return true;
/*     */       
/*     */ 
/*     */       case 10: 
/* 185 */         paramParcel1.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
/*     */         
/* 187 */         if (0 != paramParcel1.readInt()) {
/* 188 */           localObject = (ControllerEventPacket)ControllerEventPacket.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/* 191 */           localObject = null;
/*     */         }
/* 193 */         onControllerEventPacket((ControllerEventPacket)localObject);
/* 194 */         return true;
/*     */       
/*     */ 
/*     */       case 11: 
/* 198 */         paramParcel1.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
/*     */         
/* 200 */         if (0 != paramParcel1.readInt()) {
/* 201 */           localObject = (ControllerOrientationEvent)ControllerOrientationEvent.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/* 204 */           localObject = null;
/*     */         }
/* 206 */         onControllerRecentered((ControllerOrientationEvent)localObject);
/* 207 */         return true;
/*     */       
/*     */ 
/*     */       case 12: 
/* 211 */         paramParcel1.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
/*     */         
/* 213 */         if (0 != paramParcel1.readInt()) {
/* 214 */           localObject = (ControllerEventPacket2)ControllerEventPacket2.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/* 217 */           localObject = null;
/*     */         }
/* 219 */         onControllerEventPacket2((ControllerEventPacket2)localObject);
/* 220 */         return true;
/*     */       }
/*     */       
/* 223 */       return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
/*     */     }
/*     */     
/*     */     static final int TRANSACTION_onControllerRecentered = 11;
/*     */     static final int TRANSACTION_onControllerEventPacket2 = 12;
/*     */     private static class Proxy implements IControllerListener { private android.os.IBinder mRemote;
/*     */       
/* 230 */       Proxy(android.os.IBinder paramIBinder) { this.mRemote = paramIBinder; }
/*     */       
/*     */ 
/*     */       public android.os.IBinder asBinder() {
/* 234 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 238 */         return "com.google.vr.vrcore.controller.api.IControllerListener";
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public int getApiVersion()
/*     */         throws android.os.RemoteException
/*     */       {
/*     */         // Byte code:
/*     */         //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   3: astore_1
/*     */         //   4: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   7: astore_2
/*     */         //   8: aload_1
/*     */         //   9: ldc 1
/*     */         //   11: invokevirtual 27	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
/*     */         //   14: aload_0
/*     */         //   15: getfield 21	com/google/vr/vrcore/controller/api/IControllerListener$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   18: iconst_1
/*     */         //   19: aload_1
/*     */         //   20: aload_2
/*     */         //   21: iconst_0
/*     */         //   22: invokeinterface 36 5 0
/*     */         //   27: pop
/*     */         //   28: aload_2
/*     */         //   29: invokevirtual 23	android/os/Parcel:readException	()V
/*     */         //   32: aload_2
/*     */         //   33: invokevirtual 24	android/os/Parcel:readInt	()I
/*     */         //   36: istore_3
/*     */         //   37: aload_2
/*     */         //   38: invokevirtual 25	android/os/Parcel:recycle	()V
/*     */         //   41: aload_1
/*     */         //   42: invokevirtual 25	android/os/Parcel:recycle	()V
/*     */         //   45: goto +16 -> 61
/*     */         //   48: astore 4
/*     */         //   50: aload_2
/*     */         //   51: invokevirtual 25	android/os/Parcel:recycle	()V
/*     */         //   54: aload_1
/*     */         //   55: invokevirtual 25	android/os/Parcel:recycle	()V
/*     */         //   58: aload 4
/*     */         //   60: athrow
/*     */         //   61: iload_3
/*     */         //   62: ireturn
/*     */         // Line number table:
/*     */         //   Java source line #242	-> byte code offset #0
/*     */         //   Java source line #243	-> byte code offset #4
/*     */         //   Java source line #246	-> byte code offset #8
/*     */         //   Java source line #247	-> byte code offset #14
/*     */         //   Java source line #248	-> byte code offset #28
/*     */         //   Java source line #249	-> byte code offset #32
/*     */         //   Java source line #252	-> byte code offset #37
/*     */         //   Java source line #253	-> byte code offset #41
/*     */         //   Java source line #254	-> byte code offset #45
/*     */         //   Java source line #252	-> byte code offset #48
/*     */         //   Java source line #253	-> byte code offset #54
/*     */         //   Java source line #255	-> byte code offset #61
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
/*     */       public void onControllerStateChanged(int paramInt1, int paramInt2)
/*     */         throws android.os.RemoteException
/*     */       {
/* 266 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 268 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
/* 269 */           localParcel.writeInt(paramInt1);
/* 270 */           localParcel.writeInt(paramInt2);
/* 271 */           this.mRemote.transact(2, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 274 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       public void deprecatedOnControllerTouchEvent(ControllerTouchEvent paramControllerTouchEvent)
/*     */         throws android.os.RemoteException
/*     */       {
/* 285 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 287 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
/* 288 */           if (paramControllerTouchEvent != null) {
/* 289 */             localParcel.writeInt(1);
/* 290 */             paramControllerTouchEvent.writeToParcel(localParcel, 0);
/*     */           }
/*     */           else {
/* 293 */             localParcel.writeInt(0);
/*     */           }
/* 295 */           this.mRemote.transact(3, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 298 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       public void deprecatedOnControllerOrientationEvent(ControllerOrientationEvent paramControllerOrientationEvent)
/*     */         throws android.os.RemoteException
/*     */       {
/* 309 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 311 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
/* 312 */           if (paramControllerOrientationEvent != null) {
/* 313 */             localParcel.writeInt(1);
/* 314 */             paramControllerOrientationEvent.writeToParcel(localParcel, 0);
/*     */           }
/*     */           else {
/* 317 */             localParcel.writeInt(0);
/*     */           }
/* 319 */           this.mRemote.transact(4, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 322 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public boolean deprecatedOnControllerButtonEventV1(ControllerButtonEvent paramControllerButtonEvent)
/*     */         throws android.os.RemoteException
/*     */       {
/*     */         // Byte code:
/*     */         //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   3: astore_2
/*     */         //   4: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   7: astore_3
/*     */         //   8: aload_2
/*     */         //   9: ldc 1
/*     */         //   11: invokevirtual 27	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
/*     */         //   14: aload_1
/*     */         //   15: ifnull +17 -> 32
/*     */         //   18: aload_2
/*     */         //   19: iconst_1
/*     */         //   20: invokevirtual 26	android/os/Parcel:writeInt	(I)V
/*     */         //   23: aload_1
/*     */         //   24: aload_2
/*     */         //   25: iconst_0
/*     */         //   26: invokevirtual 29	com/google/vr/vrcore/controller/api/ControllerButtonEvent:writeToParcel	(Landroid/os/Parcel;I)V
/*     */         //   29: goto +8 -> 37
/*     */         //   32: aload_2
/*     */         //   33: iconst_0
/*     */         //   34: invokevirtual 26	android/os/Parcel:writeInt	(I)V
/*     */         //   37: aload_0
/*     */         //   38: getfield 21	com/google/vr/vrcore/controller/api/IControllerListener$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   41: iconst_5
/*     */         //   42: aload_2
/*     */         //   43: aload_3
/*     */         //   44: iconst_0
/*     */         //   45: invokeinterface 36 5 0
/*     */         //   50: pop
/*     */         //   51: aload_3
/*     */         //   52: invokevirtual 23	android/os/Parcel:readException	()V
/*     */         //   55: iconst_0
/*     */         //   56: aload_3
/*     */         //   57: invokevirtual 24	android/os/Parcel:readInt	()I
/*     */         //   60: if_icmpeq +7 -> 67
/*     */         //   63: iconst_1
/*     */         //   64: goto +4 -> 68
/*     */         //   67: iconst_0
/*     */         //   68: istore 4
/*     */         //   70: aload_3
/*     */         //   71: invokevirtual 25	android/os/Parcel:recycle	()V
/*     */         //   74: aload_2
/*     */         //   75: invokevirtual 25	android/os/Parcel:recycle	()V
/*     */         //   78: goto +16 -> 94
/*     */         //   81: astore 5
/*     */         //   83: aload_3
/*     */         //   84: invokevirtual 25	android/os/Parcel:recycle	()V
/*     */         //   87: aload_2
/*     */         //   88: invokevirtual 25	android/os/Parcel:recycle	()V
/*     */         //   91: aload 5
/*     */         //   93: athrow
/*     */         //   94: iload 4
/*     */         //   96: ireturn
/*     */         // Line number table:
/*     */         //   Java source line #344	-> byte code offset #0
/*     */         //   Java source line #345	-> byte code offset #4
/*     */         //   Java source line #348	-> byte code offset #8
/*     */         //   Java source line #349	-> byte code offset #14
/*     */         //   Java source line #350	-> byte code offset #18
/*     */         //   Java source line #351	-> byte code offset #23
/*     */         //   Java source line #354	-> byte code offset #32
/*     */         //   Java source line #356	-> byte code offset #37
/*     */         //   Java source line #357	-> byte code offset #51
/*     */         //   Java source line #358	-> byte code offset #55
/*     */         //   Java source line #361	-> byte code offset #70
/*     */         //   Java source line #362	-> byte code offset #74
/*     */         //   Java source line #363	-> byte code offset #78
/*     */         //   Java source line #361	-> byte code offset #81
/*     */         //   Java source line #362	-> byte code offset #87
/*     */         //   Java source line #364	-> byte code offset #94
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	97	0	this	Proxy
/*     */         //   0	97	1	paramControllerButtonEvent	ControllerButtonEvent
/*     */         //   3	85	2	localParcel1	Parcel
/*     */         //   7	77	3	localParcel2	Parcel
/*     */         //   68	27	4	bool	boolean
/*     */         //   81	11	5	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   8	70	81	finally
/*     */       }
/*     */       
/*     */       public void deprecatedOnControllerButtonEvent(ControllerButtonEvent paramControllerButtonEvent)
/*     */         throws android.os.RemoteException
/*     */       {
/* 379 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 381 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
/* 382 */           if (paramControllerButtonEvent != null) {
/* 383 */             localParcel.writeInt(1);
/* 384 */             paramControllerButtonEvent.writeToParcel(localParcel, 0);
/*     */           }
/*     */           else {
/* 387 */             localParcel.writeInt(0);
/*     */           }
/* 389 */           this.mRemote.transact(6, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 392 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       public void deprecatedOnControllerAccelEvent(ControllerAccelEvent paramControllerAccelEvent)
/*     */         throws android.os.RemoteException
/*     */       {
/* 403 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 405 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
/* 406 */           if (paramControllerAccelEvent != null) {
/* 407 */             localParcel.writeInt(1);
/* 408 */             paramControllerAccelEvent.writeToParcel(localParcel, 0);
/*     */           }
/*     */           else {
/* 411 */             localParcel.writeInt(0);
/*     */           }
/* 413 */           this.mRemote.transact(7, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 416 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       public void deprecatedOnControllerGyroEvent(ControllerGyroEvent paramControllerGyroEvent)
/*     */         throws android.os.RemoteException
/*     */       {
/* 427 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 429 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
/* 430 */           if (paramControllerGyroEvent != null) {
/* 431 */             localParcel.writeInt(1);
/* 432 */             paramControllerGyroEvent.writeToParcel(localParcel, 0);
/*     */           }
/*     */           else {
/* 435 */             localParcel.writeInt(0);
/*     */           }
/* 437 */           this.mRemote.transact(8, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 440 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       public ControllerListenerOptions getOptions()
/*     */         throws android.os.RemoteException
/*     */       {
/*     */         // Byte code:
/*     */         //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   3: astore_1
/*     */         //   4: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
/*     */         //   7: astore_2
/*     */         //   8: aload_1
/*     */         //   9: ldc 1
/*     */         //   11: invokevirtual 27	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
/*     */         //   14: aload_0
/*     */         //   15: getfield 21	com/google/vr/vrcore/controller/api/IControllerListener$Stub$Proxy:mRemote	Landroid/os/IBinder;
/*     */         //   18: bipush 9
/*     */         //   20: aload_1
/*     */         //   21: aload_2
/*     */         //   22: iconst_0
/*     */         //   23: invokeinterface 36 5 0
/*     */         //   28: pop
/*     */         //   29: aload_2
/*     */         //   30: invokevirtual 23	android/os/Parcel:readException	()V
/*     */         //   33: iconst_0
/*     */         //   34: aload_2
/*     */         //   35: invokevirtual 24	android/os/Parcel:readInt	()I
/*     */         //   38: if_icmpeq +19 -> 57
/*     */         //   41: getstatic 20	com/google/vr/vrcore/controller/api/ControllerListenerOptions:CREATOR	Landroid/os/Parcelable$Creator;
/*     */         //   44: aload_2
/*     */         //   45: invokeinterface 37 2 0
/*     */         //   50: checkcast 12	com/google/vr/vrcore/controller/api/ControllerListenerOptions
/*     */         //   53: astore_3
/*     */         //   54: goto +5 -> 59
/*     */         //   57: aconst_null
/*     */         //   58: astore_3
/*     */         //   59: aload_2
/*     */         //   60: invokevirtual 25	android/os/Parcel:recycle	()V
/*     */         //   63: aload_1
/*     */         //   64: invokevirtual 25	android/os/Parcel:recycle	()V
/*     */         //   67: goto +16 -> 83
/*     */         //   70: astore 4
/*     */         //   72: aload_2
/*     */         //   73: invokevirtual 25	android/os/Parcel:recycle	()V
/*     */         //   76: aload_1
/*     */         //   77: invokevirtual 25	android/os/Parcel:recycle	()V
/*     */         //   80: aload 4
/*     */         //   82: athrow
/*     */         //   83: aload_3
/*     */         //   84: areturn
/*     */         // Line number table:
/*     */         //   Java source line #450	-> byte code offset #0
/*     */         //   Java source line #451	-> byte code offset #4
/*     */         //   Java source line #454	-> byte code offset #8
/*     */         //   Java source line #455	-> byte code offset #14
/*     */         //   Java source line #456	-> byte code offset #29
/*     */         //   Java source line #457	-> byte code offset #33
/*     */         //   Java source line #458	-> byte code offset #41
/*     */         //   Java source line #461	-> byte code offset #57
/*     */         //   Java source line #465	-> byte code offset #59
/*     */         //   Java source line #466	-> byte code offset #63
/*     */         //   Java source line #467	-> byte code offset #67
/*     */         //   Java source line #465	-> byte code offset #70
/*     */         //   Java source line #466	-> byte code offset #76
/*     */         //   Java source line #468	-> byte code offset #83
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	85	0	this	Proxy
/*     */         //   3	74	1	localParcel1	Parcel
/*     */         //   7	66	2	localParcel2	Parcel
/*     */         //   53	31	3	localControllerListenerOptions	ControllerListenerOptions
/*     */         //   70	11	4	localObject	Object
/*     */         // Exception table:
/*     */         //   from	to	target	type
/*     */         //   8	59	70	finally
/*     */       }
/*     */       
/*     */       public void onControllerEventPacket(ControllerEventPacket paramControllerEventPacket)
/*     */         throws android.os.RemoteException
/*     */       {
/* 482 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 484 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
/* 485 */           if (paramControllerEventPacket != null) {
/* 486 */             localParcel.writeInt(1);
/* 487 */             paramControllerEventPacket.writeToParcel(localParcel, 0);
/*     */           }
/*     */           else {
/* 490 */             localParcel.writeInt(0);
/*     */           }
/* 492 */           this.mRemote.transact(10, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 495 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */       public void onControllerRecentered(ControllerOrientationEvent paramControllerOrientationEvent)
/*     */         throws android.os.RemoteException
/*     */       {
/* 505 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 507 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
/* 508 */           if (paramControllerOrientationEvent != null) {
/* 509 */             localParcel.writeInt(1);
/* 510 */             paramControllerOrientationEvent.writeToParcel(localParcel, 0);
/*     */           }
/*     */           else {
/* 513 */             localParcel.writeInt(0);
/*     */           }
/* 515 */           this.mRemote.transact(11, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 518 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       public void onControllerEventPacket2(ControllerEventPacket2 paramControllerEventPacket2)
/*     */         throws android.os.RemoteException
/*     */       {
/* 529 */         Parcel localParcel = Parcel.obtain();
/*     */         try {
/* 531 */           localParcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
/* 532 */           if (paramControllerEventPacket2 != null) {
/* 533 */             localParcel.writeInt(1);
/* 534 */             paramControllerEventPacket2.writeToParcel(localParcel, 0);
/*     */           }
/*     */           else {
/* 537 */             localParcel.writeInt(0);
/*     */           }
/* 539 */           this.mRemote.transact(12, localParcel, null, 1);
/*     */         }
/*     */         finally {
/* 542 */           localParcel.recycle();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\controller\api\IControllerListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */