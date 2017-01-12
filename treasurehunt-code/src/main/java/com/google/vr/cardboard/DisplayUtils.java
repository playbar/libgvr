/*     */ package com.google.vr.cardboard;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.res.Resources;
/*     */ import android.content.res.Resources.NotFoundException;
/*     */ import android.hardware.display.DisplayManager;
/*     */ import android.os.Build.VERSION;
/*     */ import android.util.DisplayMetrics;
/*     */ import android.view.Display;
/*     */ import android.view.WindowManager;
/*     */ import com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DisplayUtils
/*     */ {
/*     */   public static final String EXTERNAL_DISPLAY_RESOURCE_NAME = "display_manager_hdmi_display_name";
/*     */   private static final float METERS_PER_INCH = 0.0254F;
/*     */   private static final float DEFAULT_BORDER_SIZE_METERS = 0.003F;
/*     */   
/*     */   public static Display getDefaultDisplay(Context paramContext)
/*     */   {
/*     */     WindowManager localWindowManager;
/*  51 */     return (localWindowManager = (WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static DisplayMetrics getDisplayMetricsLandscape(Display paramDisplay)
/*     */   {
/*  63 */     DisplayMetrics localDisplayMetrics = new DisplayMetrics();
/*     */     
/*     */ 
/*  66 */     if (VERSION.SDK_INT >= 17) {
/*  67 */       paramDisplay.getRealMetrics(localDisplayMetrics);
/*     */     } else {
/*  69 */       paramDisplay.getMetrics(localDisplayMetrics);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  74 */     if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels) {
/*  75 */       int i = localDisplayMetrics.widthPixels;
/*  76 */       localDisplayMetrics.widthPixels = localDisplayMetrics.heightPixels;
/*  77 */       localDisplayMetrics.heightPixels = i;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  86 */     float f = localDisplayMetrics.xdpi;
/*  87 */     localDisplayMetrics.xdpi = localDisplayMetrics.ydpi;
/*  88 */     localDisplayMetrics.ydpi = f;
/*     */     
/*  90 */     return localDisplayMetrics;
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
/*     */   public static DisplayMetrics getDisplayMetricsLandscapeWithOverride(Display paramDisplay, PhoneParams paramPhoneParams)
/*     */   {
/* 107 */     DisplayMetrics localDisplayMetrics = getDisplayMetricsLandscape(paramDisplay);
/*     */     
/* 109 */     if (paramPhoneParams != null)
/*     */     {
/*     */ 
/* 112 */       if (paramPhoneParams.hasXPpi()) {
/* 113 */         localDisplayMetrics.xdpi = paramPhoneParams.getXPpi();
/*     */       }
/* 115 */       if (paramPhoneParams.hasYPpi()) {
/* 116 */         localDisplayMetrics.ydpi = paramPhoneParams.getYPpi();
/*     */       }
/*     */     }
/*     */     
/* 120 */     return localDisplayMetrics;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static float getBorderSizeMeters(PhoneParams paramPhoneParams)
/*     */   {
/* 131 */     if ((paramPhoneParams != null) && (paramPhoneParams.hasBottomBezelHeight())) {
/* 132 */       return paramPhoneParams.getBottomBezelHeight();
/*     */     }
/* 134 */     return 0.003F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static float getMetersPerPixelFromDotsPerInch(float paramFloat)
/*     */   {
/* 146 */     return 0.0254F / paramFloat;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getExternalDisplayName(Context paramContext)
/*     */   {
/*     */     Resources localResources;
/*     */     
/*     */ 
/*     */ 
/* 159 */     int i = (localResources = paramContext.getResources()).getIdentifier("display_manager_hdmi_display_name", "string", "android");
/*     */     try {
/* 161 */       return localResources.getString(i);
/*     */     } catch (Resources.NotFoundException localNotFoundException) {}
/* 163 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean hasExternalDisplay(Context paramContext)
/*     */   {
/* 175 */     if (VERSION.SDK_INT <= 16) {
/* 176 */       return false;
/*     */     }
/*     */     
/*     */     String str;
/* 180 */     if ((str = getExternalDisplayName(paramContext)) == null) {
/* 181 */       return false;
/*     */     }
/*     */     
/*     */     DisplayManager localDisplayManager;
/*     */     Display[] arrayOfDisplay;
/* 186 */     int i = (arrayOfDisplay = (localDisplayManager = (DisplayManager)paramContext.getSystemService("display")).getDisplays()).length; for (int j = 0; j < i; j++) { Display localDisplay;
/* 187 */       if ((localDisplay = arrayOfDisplay[j]).getName().equals(str)) {
/* 188 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 192 */     return false;
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
/*     */   public static boolean isSameDisplay(Display paramDisplay1, Display paramDisplay2)
/*     */   {
/* 207 */     if (paramDisplay1 == paramDisplay2) {
/* 208 */       return true;
/*     */     }
/*     */     
/* 211 */     if ((paramDisplay1 == null) || (paramDisplay2 == null)) {
/* 212 */       return false;
/*     */     }
/*     */     
/* 215 */     if ((paramDisplay1.getDisplayId() != paramDisplay2.getDisplayId()) || 
/* 216 */       (paramDisplay1.getFlags() != paramDisplay2.getFlags()) || 
/* 217 */       (paramDisplay1.isValid() != paramDisplay2.isValid()) || 
/* 218 */       (!paramDisplay1.getName().equals(paramDisplay2.getName()))) {
/* 219 */       return false;
/*     */     }
/*     */     
/* 222 */     DisplayMetrics localDisplayMetrics1 = new DisplayMetrics();
/* 223 */     DisplayMetrics localDisplayMetrics2 = new DisplayMetrics();
/* 224 */     paramDisplay1.getMetrics(localDisplayMetrics1);
/* 225 */     paramDisplay2.getMetrics(localDisplayMetrics2);
/* 226 */     return localDisplayMetrics1.equals(localDisplayMetrics2);
/*     */   }
/*     */ }

