/*     */ package com.google.vr.cardboard;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.app.ActivityManager;
/*     */ import android.app.AlertDialog;
/*     */ import android.app.AlertDialog.Builder;
/*     */ import android.content.ActivityNotFoundException;
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.DialogInterface;
/*     */ import android.content.DialogInterface.OnClickListener;
/*     */ import android.content.Intent;
/*     */ import android.content.pm.ApplicationInfo;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.content.pm.PackageManager.NameNotFoundException;
/*     */ import android.net.Uri;
/*     */ import android.os.Build.VERSION;
/*     */ import android.os.PowerManager;
/*     */ import android.provider.Settings.Secure;
/*     */ import android.util.Log;
/*     */ import android.view.Window;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AndroidNCompat
/*     */ {
/*  34 */   private static final String TAG = AndroidNCompat.class.getSimpleName();
/*     */   
/*     */ 
/*     */   private static final boolean DEBUG = false;
/*     */   
/*     */   public static final int N_SDK_LEVEL = 24;
/*     */   
/*     */   public static final int NMR1_SDK_LEVEL = 25;
/*     */   
/*     */   private static final String DEFAULT_VR_MODE_PACKAGE = "com.google.vr.vrcore";
/*     */   
/*     */   private static final String DEFAULT_VR_MODE_CLASS = "com.google.vr.vrcore.common.VrCoreListenerService";
/*     */   
/*     */   private static final String ACTION_VR_LISTENER_SETTINGS = "android.settings.VR_LISTENER_SETTINGS";
/*     */   
/*     */   private static final String ENABLED_VR_LISTENERS = "enabled_vr_listeners";
/*     */   
/*  51 */   private static int sSdkLevelOverride = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final int SUCCESS = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final int PACKAGE_NOT_PRESENT = -1;
/*     */   
/*     */ 
/*     */ 
/*     */   private static final int PACKAGE_NOT_ENABLED = -2;
/*     */   
/*     */ 
/*     */ 
/*     */   public static final int FLAG_VR_MODE_ENABLE_FALLBACK = 1;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean setVrModeEnabled(Activity paramActivity, boolean paramBoolean)
/*     */   {
/*  76 */     return setVrModeEnabled(paramActivity, paramBoolean, 1);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean setVrModeEnabled(Activity paramActivity, boolean paramBoolean, int paramInt)
/*     */   {
/*  95 */     if (!isVrModeSupported(paramActivity)) {
/*  96 */       if (isAtLeastN()) {
/*  97 */         Log.d(TAG, "VR mode is not supported on this N device.");
/*     */       }
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     ComponentName localComponentName = new ComponentName("com.google.vr.vrcore", "com.google.vr.vrcore.common.VrCoreListenerService");
/*     */     try
/*     */     {
/* 105 */       paramActivity.setVrModeEnabled(paramBoolean, localComponentName);
/*     */       
/*     */ 
/*     */ 
/* 109 */       return true;
/*     */     } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
/* 111 */       str = String.valueOf(localNameNotFoundException);Log.w(TAG, 25 + String.valueOf(str).length() + "No VR service component: " + str);
/* 112 */       if (((paramInt & 0x1) != 0) && 
/* 113 */         (handleVrCoreAbsence(paramActivity, checkForVrCorePresence(paramActivity)))) {
/* 114 */         Log.w(TAG, "Failed to handle missing VrCore package.");
/*     */       }
/*     */     } catch (UnsupportedOperationException localUnsupportedOperationException) {
/* 117 */       String str = String.valueOf(localUnsupportedOperationException);Log.w(TAG, 23 + String.valueOf(str).length() + "Failed to set VR mode: " + str);
/*     */     }
/*     */     
/* 120 */     return false;
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
/*     */   public static boolean isVrModeSupported(Context paramContext)
/*     */   {
/* 135 */     return (isAtLeastN()) && (paramContext.getPackageManager().hasSystemFeature("android.software.vr.mode"));
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
/*     */   public static boolean setSustainedPerformanceMode(Activity paramActivity, boolean paramBoolean)
/*     */   {
/* 149 */     if (!isAtLeastN()) {
/* 150 */       return false;
/*     */     }
/*     */     
/*     */     PowerManager localPowerManager;
/* 154 */     if (!(localPowerManager = (PowerManager)paramActivity.getSystemService("power")).isSustainedPerformanceModeSupported()) {
/* 155 */       Log.d(TAG, "Sustained performance mode is not supported on this device.");
/* 156 */       return false;
/*     */     }
/*     */     
/*     */     Window localWindow;
/* 160 */     if ((localWindow = paramActivity.getWindow()) == null) {
/* 161 */       Log.e(TAG, "Activity does not have a window");
/* 162 */       return false;
/*     */     }
/*     */     
/* 165 */     localWindow.setSustainedPerformanceMode(paramBoolean);
/*     */     
/*     */ 
/*     */ 
/* 169 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setVrThread(int paramInt)
/*     */   {
/* 181 */     if (!isAtLeastN()) {
/*     */       return;
/*     */     }
/*     */     Method localMethod;
/*     */     String str;
/*     */     try
/*     */     {
/* 188 */       localMethod = ActivityManager.class.getMethod("setVrThread", new Class[] { Integer.TYPE });
/*     */     }
/*     */     catch (NoSuchMethodException|RuntimeException localNoSuchMethodException) {
/* 191 */       if (isAtLeastNMR1()) {
/* 192 */         str = String.valueOf(localNoSuchMethodException);Log.e(TAG, 38 + String.valueOf(str).length() + "Failed to acquire setVrThread method: " + str);return;
/*     */       }
/* 194 */       str = String.valueOf(localNoSuchMethodException);Log.w(TAG, 38 + String.valueOf(str).length() + "Failed to acquire setVrThread method: " + str);
/*     */       
/* 196 */       return;
/*     */     }
/*     */     try
/*     */     {
/* 200 */       localMethod.invoke(null, new Object[] { Integer.valueOf(paramInt) }); return;
/*     */     } catch (InvocationTargetException|IllegalAccessException|RuntimeException localInvocationTargetException) {
/* 202 */       str = String.valueOf(localInvocationTargetException);Log.e(TAG, 30 + String.valueOf(str).length() + "Failed to invoke setVrThread: " + str);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setSdkLevelForTesting(int paramInt)
/*     */   {
/* 213 */     sSdkLevelOverride = paramInt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static boolean isAtLeastN()
/*     */   {
/* 220 */     return (sSdkLevelOverride >= 24) || (Build.VERSION.SDK_INT >= 24);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean isAtLeastNMR1()
/*     */   {
/* 229 */     return (sSdkLevelOverride >= 25) || ("NMR1".equals(Build.VERSION.CODENAME)) || (Build.VERSION.SDK_INT >= 25);
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
/*     */   private static int checkForVrCorePresence(Context paramContext)
/*     */   {
/* 244 */     List localList = paramContext.getPackageManager().getInstalledApplications(0);
/* 245 */     int i = 0;
/* 246 */     for (Object localObject1 = localList.iterator(); ((Iterator)localObject1).hasNext();) {
/* 247 */       if ((localObject2 = (ApplicationInfo)((Iterator)localObject1).next()).packageName.equals("com.google.vr.vrcore")) {
/* 248 */         i = 1;
/* 249 */         break;
/*     */       }
/*     */     }
/*     */     
/* 253 */     if (i == 0)
/*     */     {
/* 255 */       return -1;
/*     */     }
/*     */     
/* 258 */     localObject1 = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_vr_listeners");
/* 259 */     Object localObject2 = new ComponentName("com.google.vr.vrcore", "com.google.vr.vrcore.common.VrCoreListenerService");
/* 260 */     if ((localObject1 == null) || (!((String)localObject1).contains(((ComponentName)localObject2).flattenToString())))
/*     */     {
/* 262 */       return -2;
/*     */     }
/*     */     
/* 265 */     return 0;
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
/*     */   private static boolean handleVrCoreAbsence(Context paramContext, int paramInt)
/*     */   {
/* 280 */     if (paramInt == -1) {
/* 281 */       showWarningDialog(paramContext, R.string.dialog_vr_core_not_installed, R.string.go_to_playstore_button, new DialogInterface.OnClickListener()
/*     */       {
/*     */         public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */         {
/*     */           Intent localIntent;
/*     */           
/* 287 */           (localIntent = new Intent("android.intent.action.VIEW")).setData(Uri.parse("market://details?id=com.google.vr.vrcore"));
/* 288 */           localIntent.setPackage("com.android.vending");
/*     */           try {
/* 290 */             AndroidNCompat.this.startActivity(localIntent); return;
/*     */           } catch (ActivityNotFoundException localActivityNotFoundException) {
/* 292 */             Log.e(AndroidNCompat.TAG, "Google Play Services is not installed, unable to download VrCore.");
/*     */           }
/*     */         }
/* 295 */       });
/* 296 */       return false; }
/* 297 */     if (paramInt == -2) {
/* 298 */       showWarningDialog(paramContext, R.string.dialog_vr_core_not_enabled, R.string.go_to_vr_listeners_settings_button, new DialogInterface.OnClickListener()
/*     */       {
/*     */ 
/*     */         public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */         {
/* 303 */           AndroidNCompat.this.startActivity(new Intent("android.settings.VR_LISTENER_SETTINGS"));
/*     */         }
/* 305 */       });
/* 306 */       return false;
/*     */     }
/* 308 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static void showWarningDialog(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
/*     */   {
/*     */     AlertDialog.Builder localBuilder;
/*     */     
/* 317 */     (localBuilder = new AlertDialog.Builder(paramContext, R.style.GvrDialogTheme)).setMessage(paramInt1).setTitle(R.string.dialog_title_warning).setPositiveButton(paramInt2, paramOnClickListener).setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener()
/*     */     {
/*     */ 
/*     */       public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
/*     */ 
/*     */ 
/* 323 */     });
/* 324 */     localBuilder.create().show();
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\AndroidNCompat.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */