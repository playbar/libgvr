/*    */ package com.google.vr.vrcore.library.api;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.content.pm.PackageManager.NameNotFoundException;
/*    */ import android.os.IBinder;
/*    */ import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
/*    */ import com.google.vr.vrcore.base.api.VrCoreUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VrCoreLoader
/*    */ {
/* 16 */   private static final String TAG = VrCoreLoader.class.getSimpleName();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private static final boolean DEBUG = false;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private static final String LIBRARY_APK_PACKAGE = "com.google.vr.vrcore";
/*    */   
/*    */ 
/*    */ 
/*    */   private static final String CREATOR_NAME = "com.google.vr.vrcore.library.VrCreator";
/*    */   
/*    */ 
/*    */ 
/*    */   static final int MIN_TARGET_API_VERSION = 9;
/*    */   
/*    */ 
/*    */ 
/*    */   private static Context sRemoteContext;
/*    */   
/*    */ 
/*    */ 
/*    */   private static IVrCreator sCreator;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static IVrCreator getRemoteCreator(Context paramContext)
/*    */     throws VrCoreNotAvailableException
/*    */   {
/* 50 */     if (sCreator == null)
/*    */     {
/*    */       ClassLoader localClassLoader;
/*    */       
/*    */       IBinder localIBinder;
/*    */       
/* 56 */       sCreator = IVrCreator.Stub.asInterface(localIBinder = newBinderInstance(localClassLoader = getRemoteContext(paramContext).getClassLoader(), "com.google.vr.vrcore.library.VrCreator"));
/*    */     }
/* 58 */     return sCreator;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static Context getRemoteContext(Context paramContext)
/*    */     throws VrCoreNotAvailableException
/*    */   {
/* 73 */     if (sRemoteContext == null) {
/*    */       int i;
/* 75 */       if ((i = VrCoreUtils.getVrCoreClientApiVersion(paramContext)) < 9)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 83 */         throw new VrCoreNotAvailableException(4);
/*    */       }
/*    */       
/*    */ 
/*    */ 
/*    */       try
/*    */       {
/* 90 */         sRemoteContext = paramContext.createPackageContext("com.google.vr.vrcore", 3);
/*    */       }
/*    */       catch (PackageManager.NameNotFoundException localNameNotFoundException)
/*    */       {
/* 94 */         throw new VrCoreNotAvailableException(1);
/*    */       }
/*    */     }
/* 97 */     return sRemoteContext;
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   private static IBinder newBinderInstance(ClassLoader arg0, String arg1)
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: invokevirtual 38	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
/*    */     //   5: dup
/*    */     //   6: astore_2
/*    */     //   7: invokevirtual 37	java/lang/Class:newInstance	()Ljava/lang/Object;
/*    */     //   10: checkcast 11	android/os/IBinder
/*    */     //   13: areturn
/*    */     //   14: pop
/*    */     //   15: new 22	java/lang/IllegalStateException
/*    */     //   18: dup
/*    */     //   19: ldc 4
/*    */     //   21: aload_1
/*    */     //   22: invokestatic 44	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/*    */     //   25: dup
/*    */     //   26: invokevirtual 43	java/lang/String:length	()I
/*    */     //   29: ifeq +9 -> 38
/*    */     //   32: invokevirtual 42	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
/*    */     //   35: goto +12 -> 47
/*    */     //   38: pop
/*    */     //   39: new 25	java/lang/String
/*    */     //   42: dup_x1
/*    */     //   43: swap
/*    */     //   44: invokespecial 41	java/lang/String:<init>	(Ljava/lang/String;)V
/*    */     //   47: invokespecial 39	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
/*    */     //   50: athrow
/*    */     //   51: pop
/*    */     //   52: new 22	java/lang/IllegalStateException
/*    */     //   55: dup
/*    */     //   56: ldc 5
/*    */     //   58: aload_1
/*    */     //   59: invokestatic 44	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/*    */     //   62: dup
/*    */     //   63: invokevirtual 43	java/lang/String:length	()I
/*    */     //   66: ifeq +9 -> 75
/*    */     //   69: invokevirtual 42	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
/*    */     //   72: goto +12 -> 84
/*    */     //   75: pop
/*    */     //   76: new 25	java/lang/String
/*    */     //   79: dup_x1
/*    */     //   80: swap
/*    */     //   81: invokespecial 41	java/lang/String:<init>	(Ljava/lang/String;)V
/*    */     //   84: invokespecial 39	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
/*    */     //   87: athrow
/*    */     //   88: pop
/*    */     //   89: new 22	java/lang/IllegalStateException
/*    */     //   92: dup
/*    */     //   93: ldc 3
/*    */     //   95: aload_1
/*    */     //   96: invokestatic 44	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/*    */     //   99: dup
/*    */     //   100: invokevirtual 43	java/lang/String:length	()I
/*    */     //   103: ifeq +9 -> 112
/*    */     //   106: invokevirtual 42	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
/*    */     //   109: goto +12 -> 121
/*    */     //   112: pop
/*    */     //   113: new 25	java/lang/String
/*    */     //   116: dup_x1
/*    */     //   117: swap
/*    */     //   118: invokespecial 41	java/lang/String:<init>	(Ljava/lang/String;)V
/*    */     //   121: invokespecial 39	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
/*    */     //   124: athrow
/*    */     // Line number table:
/*    */     //   Java source line #110	-> byte code offset #0
/*    */     //   Java source line #111	-> byte code offset #6
/*    */     //   Java source line #112	-> byte code offset #14
/*    */     //   Java source line #113	-> byte code offset #15
/*    */     //   Java source line #114	-> byte code offset #51
/*    */     //   Java source line #115	-> byte code offset #52
/*    */     //   Java source line #116	-> byte code offset #88
/*    */     //   Java source line #117	-> byte code offset #89
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   0	13	14	java/lang/ClassNotFoundException
/*    */     //   0	13	51	java/lang/InstantiationException
/*    */     //   0	13	88	java/lang/IllegalAccessException
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\library\api\VrCoreLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */