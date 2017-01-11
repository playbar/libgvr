/*     */ package com.google.vr.cardboard;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.app.AlertDialog;
/*     */ import android.app.AlertDialog.Builder;
/*     */ import android.content.ActivityNotFoundException;
/*     */ import android.content.Context;
/*     */ import android.content.DialogInterface;
/*     */ import android.content.DialogInterface.OnCancelListener;
/*     */ import android.content.DialogInterface.OnClickListener;
/*     */ import android.content.Intent;
/*     */ import android.content.pm.ActivityInfo;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.content.pm.ResolveInfo;
/*     */ import android.net.Uri;
/*     */ import android.view.View;
/*     */ import android.view.Window;
/*     */ import android.widget.Toast;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UiUtils
/*     */ {
/*     */   private static final String CARDBOARD_WEBSITE = "https://google.com/cardboard/cfg";
/*     */   private static final String CARDBOARD_CONFIGURE_ACTION = "com.google.vrtoolkit.cardboard.CONFIGURE";
/*     */   private static final String DAYDREAM_HELP_CENTER_LINK = "https://support.google.com/daydream?p=daydream_help_menu";
/*  30 */   public static StoragePermissionUtils permissionUtils = new StoragePermissionUtils();
/*     */   
/*     */ 
/*     */ 
/*     */   public static AlertDialog.Builder dialogBuilderForTesting;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void launchOrInstallCardboard(Context paramContext)
/*     */   {
/*  41 */     PackageManager localPackageManager = paramContext.getPackageManager();
/*     */     Intent localIntent1;
/*  43 */     (localIntent1 = new Intent()).setAction("com.google.vrtoolkit.cardboard.CONFIGURE");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  48 */     List localList = localPackageManager.queryIntentActivities(localIntent1, 0);
/*  49 */     ArrayList localArrayList = new ArrayList();
/*  50 */     Integer localInteger = null;
/*  51 */     for (Object localObject = localList.iterator(); ((Iterator)localObject).hasNext();) { ResolveInfo localResolveInfo;
/*     */       String str;
/*  53 */       if (PackageUtils.isGooglePackage(str = (localResolveInfo = (ResolveInfo)((Iterator)localObject).next()).activityInfo.packageName))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  61 */         int i = localResolveInfo.priority;
/*  62 */         if (PackageUtils.isSystemPackage(paramContext, str)) {
/*  63 */           i++;
/*     */         }
/*     */         
/*  66 */         if (localInteger == null) {
/*  67 */           localInteger = Integer.valueOf(i);
/*  68 */         } else if (i > localInteger.intValue())
/*     */         {
/*  70 */           localInteger = Integer.valueOf(i);
/*  71 */           localArrayList.clear();
/*  72 */         } else { if (i < localInteger.intValue()) {
/*     */             continue;
/*     */           }
/*     */         }
/*     */         
/*     */         Intent localIntent2;
/*  78 */         (localIntent2 = new Intent(localIntent1)).setClassName(str, localResolveInfo.activityInfo.name);
/*  79 */         localArrayList.add(localIntent2);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  86 */     if (!VrParamsProviderFactory.isContentProviderAvailable(paramContext)) {
/*  87 */       permissionUtils.requestStoragePermission(paramContext);
/*     */     }
/*     */     
/*  90 */     if (localArrayList.isEmpty())
/*     */     {
/*     */ 
/*  93 */       showInstallDialog(paramContext);return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 103 */     localObject = localArrayList.size() == 1 ? (Intent)localArrayList.get(0) : localIntent1;
/*     */     
/* 105 */     paramContext.startActivity((Intent)localObject);
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
/*     */   public static AlertDialog showDaydreamHelpCenterDialog(Context paramContext, int paramInt1, int paramInt2, Runnable paramRunnable)
/*     */   {
/* 123 */     DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
/*     */     {
/*     */       public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */       {
/* 127 */         Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://support.google.com/daydream?p=daydream_help_menu"));
/*     */         try {
/* 129 */           UiUtils.this.startActivity(localIntent); return;
/*     */         } catch (ActivityNotFoundException localActivityNotFoundException) {
/* 131 */           Toast.makeText(UiUtils.this, R.string.no_browser_text, 1).show();
/* 132 */           paramAnonymousDialogInterface.cancel();
/*     */         }
/*     */       }
/*     */     };
/*     */     
/*     */ 
/*     */ 
/*     */     AlertDialog.Builder localBuilder;
/*     */     
/*     */ 
/*     */ 
/* 143 */     (localBuilder = createAlertDialogBuilder(paramContext)).setTitle(paramInt1).setMessage(paramInt2).setCancelable(false).setPositiveButton(R.string.dialog_button_open_help_center, local1).setNegativeButton(R.string.dialog_button_got_it, new DialogInterface.OnClickListener()
/*     */     {
/*     */ 
/*     */       public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */       {
/* 148 */         paramAnonymousDialogInterface.cancel();
/*     */       }
/*     */     });
/* 151 */     if (paramRunnable != null) {
/* 152 */       localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
/*     */       {
/*     */         public final void onCancel(DialogInterface paramAnonymousDialogInterface)
/*     */         {
/* 156 */           UiUtils.this.run();
/*     */         }
/*     */       });
/*     */     }
/*     */     AlertDialog localAlertDialog;
/* 161 */     (localAlertDialog = localBuilder.create()).setCanceledOnTouchOutside(false);
/* 162 */     return showImmersiveDialog(paramContext, localAlertDialog);
/*     */   }
/*     */   
/*     */   private static void showInstallDialog(Context paramContext) {
/* 166 */     DialogInterface.OnClickListener local4 = new DialogInterface.OnClickListener()
/*     */     {
/*     */       public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */       {
/*     */         try {
/* 171 */           UiUtils.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://google.com/cardboard/cfg"))); return;
/*     */         } catch (ActivityNotFoundException localActivityNotFoundException) {
/* 173 */           Toast.makeText(UiUtils.this, R.string.no_browser_text, 1).show();
/*     */         }
/*     */       }
/*     */     };
/*     */     
/*     */ 
/*     */     AlertDialog.Builder localBuilder;
/*     */     
/*     */ 
/* 182 */     (localBuilder = createAlertDialogBuilder(paramContext)).setTitle(R.string.dialog_title).setMessage(R.string.dialog_message_no_cardboard).setPositiveButton(R.string.go_to_playstore_button, local4).setNegativeButton(R.string.cancel_button, null);
/* 183 */     showImmersiveDialog(paramContext, localBuilder.create());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static AlertDialog showImmersiveDialog(Context paramContext, AlertDialog paramAlertDialog)
/*     */   {
/* 194 */     paramAlertDialog.getWindow().setFlags(8, 8);
/*     */     
/*     */ 
/*     */ 
/* 198 */     paramAlertDialog.show();
/*     */     
/*     */     Activity localActivity;
/*     */     
/* 202 */     if ((localActivity = ContextUtils.getActivity(paramContext)) != null)
/*     */     {
/*     */ 
/*     */ 
/* 206 */       paramAlertDialog.getWindow().getDecorView().setSystemUiVisibility(localActivity
/* 207 */         .getWindow().getDecorView().getSystemUiVisibility());
/*     */     }
/*     */     
/*     */ 
/* 211 */     paramAlertDialog.getWindow().clearFlags(8);
/* 212 */     return paramAlertDialog;
/*     */   }
/*     */   
/*     */   private static AlertDialog.Builder createAlertDialogBuilder(Context paramContext)
/*     */   {
/* 217 */     if (dialogBuilderForTesting != null) {
/* 218 */       return dialogBuilderForTesting;
/*     */     }
/* 220 */     return new AlertDialog.Builder(paramContext, R.style.GvrDialogTheme);
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\UiUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */