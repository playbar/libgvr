/*    */ package com.google.vr.cardboard;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.os.RemoteException;
/*    */ import android.util.Log;
/*    */ import com.google.vr.ndk.base.Version;
/*    */ import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
/*    */ import com.google.vr.vrcore.base.api.VrCoreUtils;
/*    */ import com.google.vr.vrcore.library.api.IVrCreator;
/*    */ import com.google.vr.vrcore.library.api.IVrNativeLibraryLoader;
/*    */ import com.google.vr.vrcore.library.api.ObjectWrapper;
/*    */ import com.google.vr.vrcore.library.api.VrCoreLoader;
/*    */ 
/*    */ @UsedByNative
/*    */ public class VrCoreLibraryLoader
/*    */ {
/* 17 */   private static final String TAG = VrCoreLibraryLoader.class.getSimpleName();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void checkVrCoreGvrLibraryAvailable(Context paramContext)
/*    */     throws VrCoreNotAvailableException
/*    */   {
/* 29 */     checkVrCoreGvrLibraryAvailable(paramContext, Version.CURRENT);
/*    */   }
/*    */   
/*    */   @UsedByNative
/*    */   public static long loadNativeGvrLibrary(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
/*    */   {
/*    */     try
/*    */     {
/* 37 */       Version localVersion = new Version(paramInt1, paramInt2, paramInt3);
/*    */       
/* 39 */       if (!Version.CURRENT.equals(localVersion)) {
/* 40 */         Log.w(TAG, 
/*    */         
/* 42 */           String.format("Native SDK version does not match Java; expected %s but received %s", new Object[] { Version.CURRENT, localVersion
/*    */           
/* 44 */           .toString() }));
/*    */       }
/* 46 */       checkVrCoreGvrLibraryAvailable(paramContext, localVersion);
/*    */       
/* 48 */       localObject = VrCoreLoader.getRemoteContext(paramContext);
/*    */       
/*    */       IVrCreator localIVrCreator;
/*    */       
/*    */       IVrNativeLibraryLoader localIVrNativeLibraryLoader;
/* 53 */       if ((localIVrNativeLibraryLoader = (localIVrCreator = VrCoreLoader.getRemoteCreator(paramContext)).newNativeLibraryLoader(ObjectWrapper.wrap(localObject), ObjectWrapper.wrap(paramContext))) == null) {
/* 54 */         Log.e(TAG, "Failed to load native GVR library from VrCore: no library loader available.");
/* 55 */         return 0L;
/*    */       }
/* 57 */       return localIVrNativeLibraryLoader.loadNativeGvrLibrary(localVersion.majorVersion, localVersion.minorVersion, localVersion.patchVersion);
/*    */ 
/*    */ 
/*    */ 
/*    */     }
/*    */     catch (VrCoreNotAvailableException|IllegalArgumentException|IllegalStateException|SecurityException|UnsatisfiedLinkError|RemoteException localVrCoreNotAvailableException)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/* 67 */       Object localObject = String.valueOf(localVrCoreNotAvailableException);Log.e(TAG, 49 + String.valueOf(localObject).length() + "Failed to load native GVR library from VrCore:\n  " + (String)localObject); }
/* 68 */     return 0L;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private static void checkVrCoreGvrLibraryAvailable(Context paramContext, Version paramVersion)
/*    */     throws VrCoreNotAvailableException
/*    */   {
/*    */     String str;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     Version localVersion;
/*    */     
/*    */ 
/*    */ 
/* 87 */     if ((localVersion = Version.parse(str = VrCoreUtils.getVrCoreSdkLibraryVersion(paramContext))) == null) {
/* 88 */       Log.i(TAG, "VrCore version does not support library loading.");
/* 89 */       throw new VrCoreNotAvailableException(4);
/*    */     }
/*    */     
/*    */ 
/* 93 */     if (!localVersion.isAtLeast(paramVersion)) {
/* 94 */       Log.w(TAG, 
/*    */       
/* 96 */         String.format("VrCore GVR library version obsolete; VrCore supports %s but target version is %s", new Object[] { str, paramVersion
/*    */         
/* 98 */         .toString() }));
/* 99 */       throw new VrCoreNotAvailableException(4);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\VrCoreLibraryLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */