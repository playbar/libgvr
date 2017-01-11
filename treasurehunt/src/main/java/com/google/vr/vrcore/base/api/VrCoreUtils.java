/*     */ package com.google.vr.vrcore.base.api;
/*     */ 
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.pm.ApplicationInfo;
/*     */ import android.content.pm.PackageInfo;
/*     */ import android.content.pm.PackageInstaller;
/*     */ import android.content.pm.PackageInstaller.SessionInfo;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.content.pm.PackageManager.NameNotFoundException;
/*     */ import android.content.pm.Signature;
/*     */ import android.os.Build.VERSION;
/*     */ import android.os.Bundle;
/*     */ import android.util.Log;
/*     */ import com.google.vr.cardboard.annotations.UsedByNative;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ @UsedByNative
/*     */ public final class VrCoreUtils
/*     */ {
/*  21 */   private static final String TAG = VrCoreUtils.class.getSimpleName();
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
/*     */   public static int checkVrCoreAvailability(Context paramContext)
/*     */   {
/*     */     int i;
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
/*  96 */     return i = checkVrCoreAvailabilityImpl(paramContext);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isVrCoreAvailable(Context paramContext)
/*     */   {
/* 106 */     return checkVrCoreAvailability(paramContext) == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @UsedByNative
/*     */   public static int getVrCoreClientApiVersion(Context paramContext)
/*     */     throws VrCoreNotAvailableException
/*     */   {
/*     */     try
/*     */     {
/*     */       ApplicationInfo localApplicationInfo;
/*     */       
/*     */ 
/*     */ 
/* 123 */       if ((localApplicationInfo = paramContext.getPackageManager().getApplicationInfo("com.google.vr.vrcore", 128)).enabled) {
/* 124 */         if (localApplicationInfo.metaData != null) {
/* 125 */           return localApplicationInfo.metaData.getInt("com.google.vr.vrcore.ClientApiVersion", 0);
/*     */         }
/* 124 */         return 
/*     */         
/* 126 */           0;
/*     */       }
/* 128 */       throw new VrCoreNotAvailableException(2);
/*     */     }
/*     */     catch (PackageManager.NameNotFoundException localNameNotFoundException) {
/* 131 */       throw new VrCoreNotAvailableException(checkVrCoreAvailability(paramContext));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getVrCoreVersionCode(Context paramContext)
/*     */     throws VrCoreNotAvailableException
/*     */   {
/*     */     try
/*     */     {
/* 144 */       return 
/* 145 */         paramContext.getPackageManager().getPackageInfo("com.google.vr.vrcore", 0).versionCode;
/*     */     }
/*     */     catch (PackageManager.NameNotFoundException localNameNotFoundException) {
/* 148 */       Log.e(TAG, "Could not find VrCore package", localNameNotFoundException);
/* 149 */       throw new VrCoreNotAvailableException(checkVrCoreAvailability(paramContext));
/*     */     }
/*     */   }
/*     */   
/*     */   public static String getVrCoreVersionName(Context paramContext) throws VrCoreNotAvailableException {
/*     */     try {
/* 155 */       return 
/*     */       
/* 157 */         paramContext.getPackageManager().getPackageInfo("com.google.vr.vrcore", 0).versionName;
/*     */     }
/*     */     catch (PackageManager.NameNotFoundException localNameNotFoundException) {
/* 160 */       Log.e(TAG, "Could not find VrCore package", localNameNotFoundException);
/* 161 */       throw new VrCoreNotAvailableException(checkVrCoreAvailability(paramContext));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getVrCoreSdkLibraryVersion(Context paramContext)
/*     */     throws VrCoreNotAvailableException
/*     */   {
/*     */     ApplicationInfo localApplicationInfo;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 180 */       localApplicationInfo = paramContext.getPackageManager().getApplicationInfo("com.google.vr.vrcore", 128);
/*     */     } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
/* 182 */       throw new VrCoreNotAvailableException(checkVrCoreAvailability(paramContext));
/*     */     }
/*     */     
/*     */ 
/* 186 */     if (localApplicationInfo == null) {
/* 187 */       throw new VrCoreNotAvailableException(8);
/*     */     }
/*     */     
/* 190 */     if (!localApplicationInfo.enabled) {
/* 191 */       throw new VrCoreNotAvailableException(2);
/*     */     }
/*     */     
/*     */ 
/* 195 */     if (localApplicationInfo.metaData == null) {
/* 196 */       throw new VrCoreNotAvailableException(4);
/*     */     }
/*     */     
/*     */     String str;
/*     */     
/* 201 */     if ((str = localApplicationInfo.metaData.getString("com.google.vr.vrcore.SdkLibraryVersion", "")).isEmpty()) {
/* 202 */       throw new VrCoreNotAvailableException(4);
/*     */     }
/*     */     
/*     */ 
/* 206 */     return str.substring(1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getConnectionResultString(int paramInt)
/*     */   {
/* 216 */     switch (paramInt) {
/*     */     case 0: 
/* 218 */       return "VR Service present";
/*     */     case 1: 
/* 220 */       return "VR Service missing";
/*     */     case 2: 
/* 222 */       return "VR Service disabled";
/*     */     case 3: 
/* 224 */       return "VR Service updating";
/*     */     case 4: 
/* 226 */       return "VR Service obsolete";
/*     */     case 5: 
/* 228 */       return "VR Service not connected";
/*     */     case 6: 
/* 230 */       return "No permission to do operation";
/*     */     case 7: 
/* 232 */       return "This operation is not supported on this device";
/*     */     case 8: 
/* 234 */       return "An unknown failure occurred";
/*     */     }
/* 236 */     return 38 + "Invalid connection result: " + paramInt;
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean isVrCoreComponent(ComponentName paramComponentName)
/*     */   {
/* 242 */     return (paramComponentName != null) && ("com.google.vr.vrcore".equals(paramComponentName.getPackageName()));
/*     */   }
/*     */   
/*     */   private static int checkVrCoreAvailabilityImpl(Context paramContext) {
/* 246 */     if ("com.google.vr.vrcore".equals(paramContext.getPackageName()))
/*     */     {
/* 248 */       return 0;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 256 */       if (!(localObject1 = paramContext.getPackageManager().getApplicationInfo("com.google.vr.vrcore", 0)).enabled) {
/* 257 */         return 2;
/*     */       }
/* 259 */       if (!verifyRemotePackageSignature(paramContext)) {
/* 260 */         return 9;
/*     */       }
/* 262 */       return 0;
/*     */     }
/*     */     catch (PackageManager.NameNotFoundException localNameNotFoundException1)
/*     */     {
/*     */       Object localObject2;
/*     */       
/*     */ 
/*     */ 
/* 270 */       if (Build.VERSION.SDK_INT >= 21)
/*     */       {
/*     */ 
/* 273 */         for (localObject2 = (localObject1 = paramContext.getPackageManager().getPackageInstaller().getAllSessions()).iterator(); ((Iterator)localObject2).hasNext();) { PackageInstaller.SessionInfo localSessionInfo = (PackageInstaller.SessionInfo)((Iterator)localObject2).next();
/* 274 */           if ("com.google.vr.vrcore".equals(localSessionInfo.getAppPackageName())) {
/* 275 */             return 3;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 281 */       Object localObject1 = paramContext.getPackageManager();
/*     */       
/*     */ 
/*     */       try
/*     */       {
/* 286 */         if ((localObject2 = ((PackageManager)localObject1).getApplicationInfo("com.google.vr.vrcore", 8192)).enabled) {
/* 287 */           return 3;
/*     */         }
/*     */       }
/*     */       catch (PackageManager.NameNotFoundException localNameNotFoundException2) {}
/*     */     }
/*     */     
/*     */ 
/* 294 */     return 1;
/*     */   }
/*     */   
/*     */ 
/*     */   private static boolean verifyRemotePackageSignature(Context paramContext)
/*     */     throws PackageManager.NameNotFoundException
/*     */   {
/*     */     PackageInfo localPackageInfo;
/* 302 */     if (SignatureUtils.verifySignature(localPackageInfo = paramContext.getPackageManager().getPackageInfo("com.google.vr.vrcore", 64), new Signature[] { SignatureUtils.VRCORE_RELEASE_SIGNATURE })) {
/* 303 */       return true;
/*     */     }
/*     */     
/* 306 */     if (BuildUtils.isDebugBuild(paramContext)) {
/* 307 */       return SignatureUtils.verifySignature(localPackageInfo, new Signature[] { SignatureUtils.VRCORE_DEBUG_SIGNATURE });
/*     */     }
/* 309 */     return false;
/*     */   }
/*     */   
/*     */   public static class ConnectionResult
/*     */   {
/*     */     public static final int SUCCESS = 0;
/*     */     public static final int SERVICE_MISSING = 1;
/*     */     public static final int SERVICE_DISABLED = 2;
/*     */     public static final int SERVICE_UPDATING = 3;
/*     */     public static final int SERVICE_OBSOLETE = 4;
/*     */     public static final int SERVICE_NOT_CONNECTED = 5;
/*     */     public static final int NO_PERMISSION = 6;
/*     */     public static final int NOT_SUPPORTED = 7;
/*     */     public static final int UNKNOWN = 8;
/*     */     public static final int SERVICE_INVALID = 9;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\base\api\VrCoreUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */