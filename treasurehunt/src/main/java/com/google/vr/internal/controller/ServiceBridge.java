/*     */ package com.google.vr.internal.controller;
/*     */ 
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.ServiceConnection;
/*     */ import android.os.Handler;
/*     */ import android.os.Looper;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Log;
/*     */ import com.google.vr.cardboard.annotations.UsedByNative;
/*     */ import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
/*     */ import com.google.vr.vrcore.base.api.VrCoreUtils;
/*     */ import com.google.vr.vrcore.controller.api.ControllerAccelEvent;
/*     */ import com.google.vr.vrcore.controller.api.ControllerButtonEvent;
/*     */ import com.google.vr.vrcore.controller.api.ControllerEventPacket;
/*     */ import com.google.vr.vrcore.controller.api.ControllerEventPacket2;
/*     */ import com.google.vr.vrcore.controller.api.ControllerGyroEvent;
/*     */ import com.google.vr.vrcore.controller.api.ControllerListenerOptions;
/*     */ import com.google.vr.vrcore.controller.api.ControllerOrientationEvent;
/*     */ import com.google.vr.vrcore.controller.api.ControllerTouchEvent;
/*     */ import com.google.vr.vrcore.controller.api.IControllerListener;
/*     */ import com.google.vr.vrcore.controller.api.IControllerListener.Stub;
/*     */ import com.google.vr.vrcore.controller.api.IControllerService;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @UsedByNative
/*     */ public class ServiceBridge
/*     */   implements ServiceConnection
/*     */ {
/*  43 */   private static final String TAG = ServiceBridge.class.getSimpleName();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final boolean DEBUG = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static final int TARGET_SERVICE_API_VERSION = 10;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static final String LISTENER_KEY = "com.google.vr.internal.controller.LISTENER_KEY";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final int MIN_SERVICE_API_FOR_RECENTERING = 8;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int FLAG_SUPPORTS_RECENTER = 1;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private final Context context;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 132 */   private final ControllerListenerOptions options = new ControllerListenerOptions();
/*     */   
/*     */ 
/*     */   private final Handler mainThreadHandler;
/*     */   
/*     */ 
/*     */   private IControllerService service;
/*     */   
/*     */ 
/*     */   private final Callbacks callbacks;
/*     */   
/*     */ 
/*     */   private boolean isBound;
/*     */   
/* 146 */   private final Runnable bindRunnable = new Runnable()
/*     */   {
/*     */     public void run() {
/* 149 */       ServiceBridge.this.doBind();
/*     */     }
/*     */   };
/*     */   
/* 153 */   private final Runnable unbindRunnable = new Runnable()
/*     */   {
/*     */     public void run() {
/* 156 */       ServiceBridge.this.doUnbind();
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 164 */   private final IControllerListener controllerListener = new IControllerListener.Stub()
/*     */   {
/*     */     public int getApiVersion() throws RemoteException
/*     */     {
/* 168 */       return 10;
/*     */     }
/*     */     
/*     */     public ControllerListenerOptions getOptions() throws RemoteException
/*     */     {
/* 173 */       return ServiceBridge.this.options;
/*     */     }
/*     */     
/*     */     public void onControllerStateChanged(int paramAnonymousInt1, int paramAnonymousInt2)
/*     */       throws RemoteException
/*     */     {
/* 179 */       ServiceBridge.this.callbacks.onControllerStateChanged(paramAnonymousInt1, paramAnonymousInt2);
/*     */     }
/*     */     
/*     */     public void onControllerEventPacket(ControllerEventPacket paramAnonymousControllerEventPacket)
/*     */       throws RemoteException
/*     */     {
/* 185 */       ServiceBridge.this.callbacks.onControllerEventPacket(paramAnonymousControllerEventPacket);
/* 186 */       paramAnonymousControllerEventPacket.recycle();
/*     */     }
/*     */     
/*     */ 
/*     */     public void onControllerEventPacket2(ControllerEventPacket2 paramAnonymousControllerEventPacket2)
/*     */       throws RemoteException
/*     */     {
/* 193 */       ServiceBridge.this.callbacks.onControllerEventPacket(paramAnonymousControllerEventPacket2);
/* 194 */       paramAnonymousControllerEventPacket2.recycle();
/*     */     }
/*     */     
/*     */     public void onControllerRecentered(ControllerOrientationEvent paramAnonymousControllerOrientationEvent)
/*     */     {
/* 199 */       ServiceBridge.this.callbacks.onControllerRecentered(paramAnonymousControllerOrientationEvent);
/*     */     }
/*     */     
/*     */     public boolean deprecatedOnControllerButtonEventV1(ControllerButtonEvent paramAnonymousControllerButtonEvent)
/*     */     {
/* 204 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void deprecatedOnControllerAccelEvent(ControllerAccelEvent paramAnonymousControllerAccelEvent)
/*     */     {
/* 211 */       ControllerEventPacket localControllerEventPacket = ControllerEventPacket.obtain();
/* 212 */       Parcel localParcel = Parcel.obtain();
/* 213 */       paramAnonymousControllerAccelEvent.writeToParcel(localParcel, 0);
/* 214 */       localParcel.setDataPosition(0);
/* 215 */       localControllerEventPacket.addAccelEvent().readFromParcel(localParcel);
/* 216 */       ServiceBridge.this.callbacks.onControllerEventPacket(localControllerEventPacket);
/* 217 */       localControllerEventPacket.recycle();
/* 218 */       localParcel.recycle();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void deprecatedOnControllerButtonEvent(ControllerButtonEvent paramAnonymousControllerButtonEvent)
/*     */     {
/* 225 */       ControllerEventPacket localControllerEventPacket = ControllerEventPacket.obtain();
/* 226 */       Parcel localParcel = Parcel.obtain();
/* 227 */       paramAnonymousControllerButtonEvent.writeToParcel(localParcel, 0);
/* 228 */       localParcel.setDataPosition(0);
/* 229 */       localControllerEventPacket.addButtonEvent().readFromParcel(localParcel);
/* 230 */       ServiceBridge.this.callbacks.onControllerEventPacket(localControllerEventPacket);
/* 231 */       localControllerEventPacket.recycle();
/* 232 */       localParcel.recycle();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void deprecatedOnControllerGyroEvent(ControllerGyroEvent paramAnonymousControllerGyroEvent)
/*     */     {
/* 239 */       ControllerEventPacket localControllerEventPacket = ControllerEventPacket.obtain();
/* 240 */       Parcel localParcel = Parcel.obtain();
/* 241 */       paramAnonymousControllerGyroEvent.writeToParcel(localParcel, 0);
/* 242 */       localParcel.setDataPosition(0);
/* 243 */       localControllerEventPacket.addGyroEvent().readFromParcel(localParcel);
/* 244 */       ServiceBridge.this.callbacks.onControllerEventPacket(localControllerEventPacket);
/* 245 */       localControllerEventPacket.recycle();
/* 246 */       localParcel.recycle();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void deprecatedOnControllerOrientationEvent(ControllerOrientationEvent paramAnonymousControllerOrientationEvent)
/*     */     {
/* 254 */       ControllerEventPacket localControllerEventPacket = ControllerEventPacket.obtain();
/* 255 */       Parcel localParcel = Parcel.obtain();
/* 256 */       paramAnonymousControllerOrientationEvent.writeToParcel(localParcel, 0);
/* 257 */       localParcel.setDataPosition(0);
/* 258 */       localControllerEventPacket.addOrientationEvent().readFromParcel(localParcel);
/* 259 */       ServiceBridge.this.callbacks.onControllerEventPacket(localControllerEventPacket);
/* 260 */       localControllerEventPacket.recycle();
/* 261 */       localParcel.recycle();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void deprecatedOnControllerTouchEvent(ControllerTouchEvent paramAnonymousControllerTouchEvent)
/*     */     {
/* 268 */       ControllerEventPacket localControllerEventPacket = ControllerEventPacket.obtain();
/* 269 */       Parcel localParcel = Parcel.obtain();
/* 270 */       paramAnonymousControllerTouchEvent.writeToParcel(localParcel, 0);
/* 271 */       localParcel.setDataPosition(0);
/* 272 */       localControllerEventPacket.addTouchEvent().readFromParcel(localParcel);
/* 273 */       ServiceBridge.this.callbacks.onControllerEventPacket(localControllerEventPacket);
/* 274 */       localControllerEventPacket.recycle();
/* 275 */       localParcel.recycle();
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @UsedByNative
/*     */   public ServiceBridge(Context paramContext, Callbacks paramCallbacks)
/*     */   {
/* 289 */     this.context = paramContext.getApplicationContext();
/* 290 */     this.callbacks = paramCallbacks;
/* 291 */     this.mainThreadHandler = new Handler(Looper.getMainLooper());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @UsedByNative
/*     */   public void setOrientationEnabled(boolean paramBoolean)
/*     */   {
/* 301 */     this.options.enableOrientation = paramBoolean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @UsedByNative
/*     */   public void setTouchEnabled(boolean paramBoolean)
/*     */   {
/* 311 */     this.options.enableTouch = paramBoolean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @UsedByNative
/*     */   public void setGyroEnabled(boolean paramBoolean)
/*     */   {
/* 321 */     this.options.enableGyro = paramBoolean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @UsedByNative
/*     */   public void setAccelEnabled(boolean paramBoolean)
/*     */   {
/* 331 */     this.options.enableAccel = paramBoolean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @UsedByNative
/*     */   public void setGesturesEnabled(boolean paramBoolean)
/*     */   {
/* 341 */     this.options.enableGestures = paramBoolean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @UsedByNative
/*     */   public void requestBind()
/*     */   {
/* 357 */     this.mainThreadHandler.post(this.bindRunnable);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @UsedByNative
/*     */   public void requestUnbind()
/*     */   {
/* 372 */     this.mainThreadHandler.post(this.unbindRunnable);
/*     */   }
/*     */   
/*     */   private void doBind()
/*     */   {
/* 377 */     ensureOnMainThread();
/*     */     
/* 379 */     if (this.isBound) {
/* 380 */       Log.w(TAG, "Service is already bound."); return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     Intent localIntent;
/*     */     
/*     */ 
/*     */ 
/* 389 */     (localIntent = new Intent("com.google.vr.vrcore.controller.BIND")).setPackage("com.google.vr.vrcore");
/* 390 */     if (!this.context.bindService(localIntent, this, 1))
/*     */     {
/* 392 */       Log.w(TAG, "Bind failed. Service is not available.");
/* 393 */       this.callbacks.onServiceUnavailable();
/* 394 */       return;
/*     */     }
/* 396 */     this.isBound = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void unregisterListener()
/*     */   {
/* 404 */     if (this.service == null)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 409 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 417 */       this.service.unregisterListener("com.google.vr.internal.controller.LISTENER_KEY"); return;
/*     */     } catch (RemoteException localRemoteException2) { RemoteException localRemoteException1;
/* 419 */       (localRemoteException1 = 
/*     */       
/* 421 */         localRemoteException2).printStackTrace();Log.w(TAG, "RemoteException while unregistering listener.");
/*     */     }
/*     */   }
/*     */   
/*     */   private void doUnbind() {
/* 425 */     ensureOnMainThread();
/*     */     
/* 427 */     if (!this.isBound) {
/* 428 */       Log.w(TAG, "Service is already unbound.");
/* 429 */       return;
/*     */     }
/* 431 */     unregisterListener();
/*     */     
/*     */ 
/*     */ 
/* 435 */     this.context.unbindService(this);
/* 436 */     this.isBound = false;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void onServiceConnected(ComponentName arg1, android.os.IBinder arg2)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial 75	com/google/vr/internal/controller/ServiceBridge:ensureOnMainThread	()V
/*     */     //   4: aload_0
/*     */     //   5: aload_2
/*     */     //   6: invokestatic 84	com/google/vr/vrcore/controller/api/IControllerService$Stub:asInterface	(Landroid/os/IBinder;)Lcom/google/vr/vrcore/controller/api/IControllerService;
/*     */     //   9: putfield 53	com/google/vr/internal/controller/ServiceBridge:service	Lcom/google/vr/vrcore/controller/api/IControllerService;
/*     */     //   12: aload_0
/*     */     //   13: getfield 53	com/google/vr/internal/controller/ServiceBridge:service	Lcom/google/vr/vrcore/controller/api/IControllerService;
/*     */     //   16: bipush 10
/*     */     //   18: invokeinterface 101 2 0
/*     */     //   23: istore_3
/*     */     //   24: goto +32 -> 56
/*     */     //   27: dup
/*     */     //   28: astore 4
/*     */     //   30: invokevirtual 69	android/os/RemoteException:printStackTrace	()V
/*     */     //   33: getstatic 45	com/google/vr/internal/controller/ServiceBridge:TAG	Ljava/lang/String;
/*     */     //   36: ldc 6
/*     */     //   38: invokestatic 70	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   41: pop
/*     */     //   42: aload_0
/*     */     //   43: getfield 47	com/google/vr/internal/controller/ServiceBridge:callbacks	Lcom/google/vr/internal/controller/ServiceBridge$Callbacks;
/*     */     //   46: invokeinterface 98 1 0
/*     */     //   51: aload_0
/*     */     //   52: invokespecial 74	com/google/vr/internal/controller/ServiceBridge:doUnbind	()V
/*     */     //   55: return
/*     */     //   56: iload_3
/*     */     //   57: ifeq +56 -> 113
/*     */     //   60: getstatic 45	com/google/vr/internal/controller/ServiceBridge:TAG	Ljava/lang/String;
/*     */     //   63: ldc 19
/*     */     //   65: iload_3
/*     */     //   66: invokestatic 82	com/google/vr/vrcore/controller/api/ControllerInitResults:toString	(I)Ljava/lang/String;
/*     */     //   69: invokestatic 91	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   72: dup
/*     */     //   73: invokevirtual 90	java/lang/String:length	()I
/*     */     //   76: ifeq +9 -> 85
/*     */     //   79: invokevirtual 89	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   82: goto +12 -> 94
/*     */     //   85: pop
/*     */     //   86: new 43	java/lang/String
/*     */     //   89: dup_x1
/*     */     //   90: swap
/*     */     //   91: invokespecial 88	java/lang/String:<init>	(Ljava/lang/String;)V
/*     */     //   94: invokestatic 70	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   97: pop
/*     */     //   98: aload_0
/*     */     //   99: getfield 47	com/google/vr/internal/controller/ServiceBridge:callbacks	Lcom/google/vr/internal/controller/ServiceBridge$Callbacks;
/*     */     //   102: iload_3
/*     */     //   103: invokeinterface 99 2 0
/*     */     //   108: aload_0
/*     */     //   109: invokespecial 74	com/google/vr/internal/controller/ServiceBridge:doUnbind	()V
/*     */     //   112: return
/*     */     //   113: aload_0
/*     */     //   114: invokevirtual 76	com/google/vr/internal/controller/ServiceBridge:getVrCoreClientApiVersion	()I
/*     */     //   117: dup
/*     */     //   118: istore 4
/*     */     //   120: ifge +26 -> 146
/*     */     //   123: getstatic 45	com/google/vr/internal/controller/ServiceBridge:TAG	Ljava/lang/String;
/*     */     //   126: ldc 7
/*     */     //   128: invokestatic 71	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   131: pop
/*     */     //   132: aload_0
/*     */     //   133: getfield 47	com/google/vr/internal/controller/ServiceBridge:callbacks	Lcom/google/vr/internal/controller/ServiceBridge$Callbacks;
/*     */     //   136: invokeinterface 98 1 0
/*     */     //   141: aload_0
/*     */     //   142: invokespecial 74	com/google/vr/internal/controller/ServiceBridge:doUnbind	()V
/*     */     //   145: return
/*     */     //   146: iconst_0
/*     */     //   147: istore 5
/*     */     //   149: iload 4
/*     */     //   151: bipush 8
/*     */     //   153: if_icmplt +9 -> 162
/*     */     //   156: iconst_1
/*     */     //   157: istore 5
/*     */     //   159: goto +33 -> 192
/*     */     //   162: getstatic 45	com/google/vr/internal/controller/ServiceBridge:TAG	Ljava/lang/String;
/*     */     //   165: bipush 62
/*     */     //   167: new 44	java/lang/StringBuilder
/*     */     //   170: dup_x1
/*     */     //   171: swap
/*     */     //   172: invokespecial 92	java/lang/StringBuilder:<init>	(I)V
/*     */     //   175: ldc 9
/*     */     //   177: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   180: iload 4
/*     */     //   182: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
/*     */     //   185: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   188: invokestatic 71	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   191: pop
/*     */     //   192: aload_0
/*     */     //   193: getfield 47	com/google/vr/internal/controller/ServiceBridge:callbacks	Lcom/google/vr/internal/controller/ServiceBridge$Callbacks;
/*     */     //   196: iload 5
/*     */     //   198: invokeinterface 96 2 0
/*     */     //   203: aload_0
/*     */     //   204: getfield 53	com/google/vr/internal/controller/ServiceBridge:service	Lcom/google/vr/vrcore/controller/api/IControllerService;
/*     */     //   207: iconst_0
/*     */     //   208: ldc 16
/*     */     //   210: aload_0
/*     */     //   211: getfield 49	com/google/vr/internal/controller/ServiceBridge:controllerListener	Lcom/google/vr/vrcore/controller/api/IControllerListener;
/*     */     //   214: invokeinterface 102 4 0
/*     */     //   219: ifne +26 -> 245
/*     */     //   222: getstatic 45	com/google/vr/internal/controller/ServiceBridge:TAG	Ljava/lang/String;
/*     */     //   225: ldc 8
/*     */     //   227: invokestatic 71	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   230: pop
/*     */     //   231: aload_0
/*     */     //   232: getfield 47	com/google/vr/internal/controller/ServiceBridge:callbacks	Lcom/google/vr/internal/controller/ServiceBridge$Callbacks;
/*     */     //   235: invokeinterface 98 1 0
/*     */     //   240: aload_0
/*     */     //   241: invokespecial 74	com/google/vr/internal/controller/ServiceBridge:doUnbind	()V
/*     */     //   244: return
/*     */     //   245: return
/*     */     //   246: dup
/*     */     //   247: astore 6
/*     */     //   249: invokevirtual 69	android/os/RemoteException:printStackTrace	()V
/*     */     //   252: getstatic 45	com/google/vr/internal/controller/ServiceBridge:TAG	Ljava/lang/String;
/*     */     //   255: ldc 10
/*     */     //   257: invokestatic 71	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   260: pop
/*     */     //   261: aload_0
/*     */     //   262: getfield 47	com/google/vr/internal/controller/ServiceBridge:callbacks	Lcom/google/vr/internal/controller/ServiceBridge$Callbacks;
/*     */     //   265: invokeinterface 98 1 0
/*     */     //   270: aload_0
/*     */     //   271: invokespecial 74	com/google/vr/internal/controller/ServiceBridge:doUnbind	()V
/*     */     //   274: return
/*     */     // Line number table:
/*     */     //   Java source line #446	-> byte code offset #0
/*     */     //   Java source line #451	-> byte code offset #4
/*     */     //   Java source line #459	-> byte code offset #12
/*     */     //   Java source line #466	-> byte code offset #24
/*     */     //   Java source line #460	-> byte code offset #27
/*     */     //   Java source line #461	-> byte code offset #28
/*     */     //   Java source line #462	-> byte code offset #33
/*     */     //   Java source line #463	-> byte code offset #42
/*     */     //   Java source line #464	-> byte code offset #51
/*     */     //   Java source line #465	-> byte code offset #55
/*     */     //   Java source line #468	-> byte code offset #56
/*     */     //   Java source line #469	-> byte code offset #60
/*     */     //   Java source line #470	-> byte code offset #98
/*     */     //   Java source line #471	-> byte code offset #108
/*     */     //   Java source line #472	-> byte code offset #112
/*     */     //   Java source line #480	-> byte code offset #113
/*     */     //   Java source line #481	-> byte code offset #118
/*     */     //   Java source line #485	-> byte code offset #123
/*     */     //   Java source line #486	-> byte code offset #132
/*     */     //   Java source line #487	-> byte code offset #141
/*     */     //   Java source line #488	-> byte code offset #145
/*     */     //   Java source line #492	-> byte code offset #146
/*     */     //   Java source line #493	-> byte code offset #149
/*     */     //   Java source line #494	-> byte code offset #156
/*     */     //   Java source line #499	-> byte code offset #162
/*     */     //   Java source line #505	-> byte code offset #192
/*     */     //   Java source line #508	-> byte code offset #203
/*     */     //   Java source line #510	-> byte code offset #222
/*     */     //   Java source line #511	-> byte code offset #231
/*     */     //   Java source line #512	-> byte code offset #240
/*     */     //   Java source line #513	-> byte code offset #244
/*     */     //   Java source line #521	-> byte code offset #245
/*     */     //   Java source line #515	-> byte code offset #246
/*     */     //   Java source line #516	-> byte code offset #247
/*     */     //   Java source line #517	-> byte code offset #252
/*     */     //   Java source line #518	-> byte code offset #261
/*     */     //   Java source line #519	-> byte code offset #270
/*     */     //   Java source line #520	-> byte code offset #274
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   12	24	27	android/os/RemoteException
/*     */     //   203	244	246	android/os/RemoteException
/*     */   }
/*     */   
/*     */   public void onServiceDisconnected(ComponentName paramComponentName)
/*     */   {
/* 532 */     ensureOnMainThread();
/*     */     
/*     */ 
/*     */ 
/* 536 */     this.service = null;
/* 537 */     this.callbacks.onServiceDisconnected();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected int getVrCoreClientApiVersion()
/*     */   {
/*     */     try
/*     */     {
/* 549 */       return VrCoreUtils.getVrCoreClientApiVersion(this.context);
/*     */     } catch (VrCoreNotAvailableException localVrCoreNotAvailableException) {
/* 551 */       Log.w(TAG, "VrCore not available.", localVrCoreNotAvailableException); }
/* 552 */     return -1;
/*     */   }
/*     */   
/*     */   private void ensureOnMainThread()
/*     */   {
/* 557 */     if (Looper.myLooper() != Looper.getMainLooper()) {
/* 558 */       throw new IllegalStateException("This should be running on the main thread.");
/*     */     }
/*     */   }
/*     */   
/*     */   @UsedByNative
/*     */   public static abstract interface Callbacks
/*     */   {
/*     */     public abstract void onServiceConnected(int paramInt);
/*     */     
/*     */     public abstract void onServiceDisconnected();
/*     */     
/*     */     public abstract void onServiceUnavailable();
/*     */     
/*     */     public abstract void onServiceFailed();
/*     */     
/*     */     public abstract void onServiceInitFailed(int paramInt);
/*     */     
/*     */     public abstract void onControllerStateChanged(int paramInt1, int paramInt2);
/*     */     
/*     */     public abstract void onControllerEventPacket(ControllerEventPacket paramControllerEventPacket);
/*     */     
/*     */     public abstract void onControllerRecentered(ControllerOrientationEvent paramControllerOrientationEvent);
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\internal\controller\ServiceBridge.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */