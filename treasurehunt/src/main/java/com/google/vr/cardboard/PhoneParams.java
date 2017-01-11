/*     */ package com.google.vr.cardboard;
/*     */ 
/*     */ import android.os.Build;
/*     */ import android.util.Log;
/*     */ import com.google.protobuf.nano.MessageNano;
/*     */ import com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PhoneParams
/*     */ {
/*     */   private static final boolean DEBUG = false;
/*  18 */   private static final String TAG = PhoneParams.class.getSimpleName();
/*     */   
/*     */ 
/*     */   static class PpiOverride
/*     */   {
/*     */     String manufacturer;
/*     */     
/*     */     String device;
/*     */     
/*     */     String model;
/*     */     String hardware;
/*     */     int xPpi;
/*     */     int yPpi;
/*     */     
/*     */     PpiOverride(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
/*     */     {
/*  34 */       this.manufacturer = paramString1;
/*  35 */       this.device = paramString2;
/*  36 */       this.model = paramString3;
/*  37 */       this.hardware = paramString4;
/*  38 */       this.xPpi = paramInt1;
/*  39 */       this.yPpi = paramInt2;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     boolean isMatching(String paramString1, String paramString2, String paramString3, String paramString4)
/*     */     {
/*  47 */       return ((this.manufacturer == null) || (this.manufacturer.equals(paramString1))) && ((this.device == null) || (this.device.equals(paramString2))) && ((this.model == null) || (this.model.equals(paramString3))) && ((this.hardware == null) || (this.hardware.equals(paramString4)));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*  53 */   private static final List<PpiOverride> PPI_OVERRIDES = Arrays.asList(new PpiOverride[] { new PpiOverride("Micromax", null, "4560MMX", null, 217, 217), new PpiOverride("HTC", "endeavoru", "HTC One X", null, 312, 312), new PpiOverride("samsung", null, "SM-G920P", null, 575, 575), new PpiOverride("samsung", null, "SM-G930", null, 581, 580), new PpiOverride("samsung", null, "SM-G9300", null, 581, 580), new PpiOverride("samsung", null, "SM-G930A", null, 581, 580), new PpiOverride("samsung", null, "SM-G930F", null, 581, 580), new PpiOverride("samsung", null, "SM-G930P", null, 581, 580), new PpiOverride("samsung", null, "SM-G930R4", null, 581, 580), new PpiOverride("samsung", null, "SM-G930T", null, 581, 580), new PpiOverride("samsung", null, "SM-G930V", null, 581, 580), new PpiOverride("samsung", null, "SM-G930W8", null, 581, 580), new PpiOverride("samsung", null, "SM-N915FY", null, 541, 541), new PpiOverride("samsung", null, "SM-N915A", null, 541, 541), new PpiOverride("samsung", null, "SM-N915T", null, 541, 541), new PpiOverride("samsung", null, "SM-N915K", null, 541, 541), new PpiOverride("samsung", null, "SM-N915T", null, 541, 541), new PpiOverride("samsung", null, "SM-N915G", null, 541, 541), new PpiOverride("samsung", null, "SM-N915D", null, 541, 541), new PpiOverride("BLU", "BLU", "Studio 5.0 HD LTE", "qcom", 294, 294), new PpiOverride("OnePlus", "A0001", "A0001", "bacon", 401, 401), new PpiOverride("THL", "THL", "thl 5000", "mt6592", 441, 441) });
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
/*     */   static boolean getPpiOverride(List<PpiOverride> paramList, String paramString1, String paramString2, String paramString3, String paramString4, Phone.PhoneParams paramPhoneParams)
/*     */   {
/*  99 */     for (Iterator localIterator = paramList.iterator(); localIterator.hasNext();) { PpiOverride localPpiOverride;
/* 100 */       if ((localPpiOverride = (PpiOverride)localIterator.next()).isMatching(paramString1, paramString2, paramString3, paramString4)) {
/* 101 */         Log.d(TAG, String.format("Found override: {MANUFACTURER=%s, DEVICE=%s, MODEL=%s, HARDWARE=%s} : x_ppi=%d, y_ppi=%d", new Object[] { localPpiOverride.manufacturer, localPpiOverride.device, localPpiOverride.model, localPpiOverride.hardware, 
/*     */         
/*     */ 
/*     */ 
/* 105 */           Integer.valueOf(localPpiOverride.xPpi), Integer.valueOf(localPpiOverride.yPpi) }));
/* 106 */         paramPhoneParams.setXPpi(localPpiOverride.xPpi);
/* 107 */         paramPhoneParams.setYPpi(localPpiOverride.yPpi);
/* 108 */         return true;
/*     */       }
/*     */     }
/* 111 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   static void registerOverridesInternal(List<PpiOverride> paramList, String paramString1, String paramString2, String paramString3, String paramString4)
/*     */   {
/*     */     Phone.PhoneParams localPhoneParams1;
/*     */     
/* 119 */     Phone.PhoneParams localPhoneParams2 = (localPhoneParams1 = ConfigUtils.readPhoneParamsFromExternalStorage()) == null ? new Phone.PhoneParams() : localPhoneParams1.clone();
/* 120 */     if ((getPpiOverride(paramList, paramString1, paramString2, paramString3, paramString4, localPhoneParams2)) && 
/* 121 */       (!MessageNano.messageNanoEquals(localPhoneParams1, localPhoneParams2))) {
/* 122 */       Log.i(TAG, "Applying phone param override.");
/* 123 */       ConfigUtils.writePhoneParamsToExternalStorage(localPhoneParams2);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerOverrides()
/*     */   {
/* 132 */     registerOverridesInternal(PPI_OVERRIDES, Build.MANUFACTURER, Build.DEVICE, Build.MODEL, Build.HARDWARE);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Phone.PhoneParams getPpiOverride()
/*     */   {
/* 141 */     Phone.PhoneParams localPhoneParams = new Phone.PhoneParams();
/* 142 */     if (getPpiOverride(PPI_OVERRIDES, Build.MANUFACTURER, Build.DEVICE, Build.MODEL, Build.HARDWARE, localPhoneParams))
/*     */     {
/* 144 */       return localPhoneParams;
/*     */     }
/* 146 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\PhoneParams.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */