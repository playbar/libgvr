/*     */ package com.google.vr.ndk.base;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.AsyncTask;
/*     */ import android.util.DisplayMetrics;
/*     */ import android.view.Display;
/*     */ import android.view.MotionEvent;
/*     */ import android.view.View;
/*     */ import android.view.View.OnTouchListener;
/*     */ import com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams;
/*     */ import com.google.vr.cardboard.DisplayUtils;
/*     */ import com.google.vr.cardboard.VrParamsProvider;
/*     */ import com.google.vr.cardboard.VrParamsProviderFactory;
/*     */ import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DaydreamInternalParams;
/*     */ import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams;
/*     */ import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.ScreenAlignmentMarker;
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
/*     */ class DaydreamAlignment
/*     */ {
/*     */   private static final String TAG = "DaydreamAlignment";
/*     */   private static final double MAX_TOUCH_DISTANCE_SQUARED_METERS = 2.25E-4D;
/*     */   private final VrParamsProvider vrParamsProvider;
/*     */   private DisplayMetrics displayMetrics;
/*     */   private float xMetersPerPixel;
/*     */   private float yMetersPerPixel;
/*     */   private float borderSizeMeters;
/*     */   private float[][] markersInPixels;
/*     */   private int mostTouchesSeen;
/*     */   private int[] touchBestMarker;
/*     */   private int[] markerBestTouch;
/*     */   private double[] currentMarkerBestDists;
/*  47 */   private float[] pixelTranslation = new float[2];
/*     */   
/*     */ 
/*     */   private boolean lastMotionEventInHeadset;
/*     */   
/*     */ 
/*  53 */   private boolean enabled = true;
/*     */   
/*     */ 
/*     */   private final boolean isDaydreamImageAlignmentEnabled;
/*     */   
/*     */ 
/*     */   public DaydreamAlignment(Context paramContext, GvrApi paramGvrApi)
/*     */   {
/*  61 */     this.isDaydreamImageAlignmentEnabled = (paramGvrApi.getSdkConfigurationParams().daydreamImageAlignment.intValue() != 1);
/*     */     
/*     */ 
/*  64 */     this.vrParamsProvider = VrParamsProviderFactory.create(paramContext);
/*     */     
/*     */     FinishInitilizationTask localFinishInitilizationTask;
/*  67 */     (localFinishInitilizationTask = new FinishInitilizationTask(null)).display = DisplayUtils.getDefaultDisplay(paramContext);
/*  68 */     localFinishInitilizationTask.execute(new Void[0]);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   DaydreamAlignment(VrParamsProvider paramVrParamsProvider, DisplayMetrics paramDisplayMetrics, Phone.PhoneParams paramPhoneParams, boolean paramBoolean)
/*     */   {
/*  77 */     this.isDaydreamImageAlignmentEnabled = paramBoolean;
/*  78 */     this.vrParamsProvider = paramVrParamsProvider;
/*     */     
/*  80 */     init(paramDisplayMetrics, paramPhoneParams);
/*     */   }
/*     */   
/*     */   public static class DefaultTouchListener implements View.OnTouchListener
/*     */   {
/*  85 */     private float[] lastTranslation = new float[2];
/*  86 */     private float[] translation = new float[2];
/*     */     private final DaydreamAlignment daydreamAlignment;
/*     */     private final GvrApi gvrApi;
/*     */     
/*     */     public DefaultTouchListener(DaydreamAlignment paramDaydreamAlignment, GvrApi paramGvrApi) {
/*  91 */       this.daydreamAlignment = paramDaydreamAlignment;
/*  92 */       this.gvrApi = paramGvrApi;
/*     */     }
/*     */     
/*     */     public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
/*     */     {
/*  97 */       if (!this.daydreamAlignment.processMotionEvent(paramMotionEvent)) {
/*  98 */         return false;
/*     */       }
/*     */       
/* 101 */       if (!this.daydreamAlignment.wasLastMotionEventInViewer())
/*     */       {
/* 103 */         this.translation[0] = 0.0F;
/* 104 */         this.translation[1] = 0.0F;
/*     */       } else {
/* 106 */         this.daydreamAlignment.getTranslationInScreenSpace(this.translation);
/*     */       }
/*     */       
/*     */ 
/* 110 */       if ((this.translation[0] != this.lastTranslation[0]) || (this.translation[1] != this.lastTranslation[1])) {
/* 111 */         this.lastTranslation[0] = this.translation[0];
/* 112 */         this.lastTranslation[1] = this.translation[1];
/* 113 */         this.gvrApi.setLensOffset(this.translation[0], this.translation[1]);
/*     */       }
/* 115 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private void init(DisplayMetrics paramDisplayMetrics, Phone.PhoneParams paramPhoneParams) {
/* 120 */     this.displayMetrics = paramDisplayMetrics;
/* 121 */     this.borderSizeMeters = DisplayUtils.getBorderSizeMeters(paramPhoneParams);
/*     */     
/* 123 */     this.xMetersPerPixel = DisplayUtils.getMetersPerPixelFromDotsPerInch(this.displayMetrics.xdpi);
/* 124 */     this.yMetersPerPixel = DisplayUtils.getMetersPerPixelFromDotsPerInch(this.displayMetrics.ydpi);
/*     */     
/*     */ 
/* 127 */     resetTrackingState();
/*     */     
/*     */ 
/* 130 */     refreshViewerProfile();
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean paramBoolean)
/*     */   {
/* 135 */     this.enabled = paramBoolean;
/* 136 */     if (!paramBoolean) {
/* 137 */       resetTrackingState();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean processMotionEvent(MotionEvent paramMotionEvent)
/*     */   {
/* 150 */     if (!viewerNeedsTouchProcessing()) {
/* 151 */       this.lastMotionEventInHeadset = false;
/* 152 */       return false;
/*     */     }
/*     */     
/* 155 */     if (!isDaydreamImageAlignmentEnabled())
/*     */     {
/* 157 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     int i;
/*     */     
/*     */ 
/* 165 */     if ((i = paramMotionEvent.getPointerCount()) > this.mostTouchesSeen) {
/* 166 */       this.touchBestMarker = new int[i];
/* 167 */       this.mostTouchesSeen = i;
/*     */     }
/*     */     
/* 170 */     for (int j = 0; j < this.markersInPixels.length; j++) {
/* 171 */       this.markerBestTouch[j] = -1;
/* 172 */       this.currentMarkerBestDists[j] = 2.25E-4D;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 177 */     for (j = 0; j < i; j++) {
/* 178 */       double d1 = 2.25E-4D;
/* 179 */       this.touchBestMarker[j] = -1;
/* 180 */       for (m = 0; m < this.markersInPixels.length; m++) {
/* 181 */         float f3 = (this.markersInPixels[m][0] - paramMotionEvent.getX(j)) * this.xMetersPerPixel;
/* 182 */         float f4 = (this.markersInPixels[m][1] - paramMotionEvent.getY(j)) * this.yMetersPerPixel;
/*     */         double d2;
/* 184 */         if ((d2 = f3 * f3 + f4 * f4) < d1) {
/* 185 */           d1 = d2;
/* 186 */           this.touchBestMarker[j] = m;
/*     */         }
/* 188 */         if (d2 < this.currentMarkerBestDists[m]) {
/* 189 */           this.currentMarkerBestDists[m] = d2;
/* 190 */           this.markerBestTouch[m] = j;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 195 */     float f1 = 0.0F;
/* 196 */     float f2 = 0.0F;
/* 197 */     int k = 0;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 203 */     for (int m = 0; m < this.markerBestTouch.length; m++) {
/* 204 */       if (this.markerBestTouch[m] != -1)
/*     */       {
/*     */ 
/* 207 */         if (this.touchBestMarker[this.markerBestTouch[m]] != m) {
/* 208 */           this.markerBestTouch[m] = -1;
/*     */         } else {
/* 210 */           k++;
/* 211 */           f1 += paramMotionEvent.getX(this.markerBestTouch[m]) - this.markersInPixels[m][0];
/* 212 */           f2 += paramMotionEvent.getY(this.markerBestTouch[m]) - this.markersInPixels[m][1];
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 218 */     if (k > 0) {
/* 219 */       this.lastMotionEventInHeadset = true;
/* 220 */       this.pixelTranslation[0] = (f1 / k);
/* 221 */       this.pixelTranslation[1] = (f2 / k);
/*     */     } else {
/* 223 */       this.lastMotionEventInHeadset = false;
/*     */     }
/*     */     
/* 226 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void getTranslationInPixels(float[] paramArrayOfFloat)
/*     */   {
/* 233 */     if (paramArrayOfFloat.length < 2) {
/* 234 */       throw new IllegalArgumentException("Translation array too small");
/*     */     }
/* 236 */     paramArrayOfFloat[0] = this.pixelTranslation[0];
/* 237 */     paramArrayOfFloat[1] = this.pixelTranslation[1];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void getTranslationInScreenSpace(float[] paramArrayOfFloat)
/*     */   {
/* 246 */     if (paramArrayOfFloat.length < 2) {
/* 247 */       throw new IllegalArgumentException("Translation array too small");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 252 */     paramArrayOfFloat[0] = (this.pixelTranslation[0] / this.displayMetrics.widthPixels);
/* 253 */     paramArrayOfFloat[1] = (this.pixelTranslation[1] / this.displayMetrics.heightPixels);
/*     */     
/*     */ 
/* 256 */     paramArrayOfFloat[0] *= 4.0F;
/* 257 */     paramArrayOfFloat[1] *= -2.0F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean viewerNeedsTouchProcessing()
/*     */   {
/* 267 */     return (this.enabled) && (this.markersInPixels != null) && (this.markersInPixels.length > 0);
/*     */   }
/*     */   
/*     */   boolean isDaydreamImageAlignmentEnabled()
/*     */   {
/* 272 */     return this.isDaydreamImageAlignmentEnabled;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean wasLastMotionEventInViewer()
/*     */   {
/* 283 */     return this.lastMotionEventInHeadset;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void refreshViewerProfile()
/*     */   {
/* 295 */     new RefreshViewerProfileTask(null).execute(new Void[0]);
/*     */   }
/*     */   
/*     */ 
/*     */   private class RefreshViewerProfileTask
/*     */     extends AsyncTask<Void, Void, CardboardDevice.DeviceParams>
/*     */   {
/*     */     private RefreshViewerProfileTask() {}
/*     */     
/*     */     protected CardboardDevice.DeviceParams doInBackground(Void... paramVarArgs)
/*     */     {
/* 306 */       return DaydreamAlignment.this.vrParamsProvider.readDeviceParams();
/*     */     }
/*     */     
/*     */ 
/*     */     protected void onProgressUpdate(Void... paramVarArgs) {}
/*     */     
/*     */     protected void onPostExecute(CardboardDevice.DeviceParams paramDeviceParams)
/*     */     {
/* 314 */       if ((paramDeviceParams == null) || (paramDeviceParams.daydreamInternal == null) || (paramDeviceParams.daydreamInternal.alignmentMarkers == null))
/*     */       {
/*     */ 
/* 317 */         DaydreamAlignment.this.markersInPixels = null;
/* 318 */         return;
/*     */       }
/*     */       
/* 321 */       CardboardDevice.ScreenAlignmentMarker[] arrayOfScreenAlignmentMarker = paramDeviceParams.daydreamInternal.alignmentMarkers;
/*     */       
/* 323 */       DaydreamAlignment.this.markersInPixels = new float[arrayOfScreenAlignmentMarker.length][];
/* 324 */       DaydreamAlignment.this.currentMarkerBestDists = new double[arrayOfScreenAlignmentMarker.length];
/* 325 */       DaydreamAlignment.this.markerBestTouch = new int[arrayOfScreenAlignmentMarker.length];
/*     */       
/* 327 */       for (int i = 0; i < arrayOfScreenAlignmentMarker.length; i++) {
/* 328 */         CardboardDevice.ScreenAlignmentMarker localScreenAlignmentMarker = arrayOfScreenAlignmentMarker[i];
/* 329 */         DaydreamAlignment.this.markersInPixels[i] = new float[2];
/* 330 */         DaydreamAlignment.this.markersInPixels[i][0] = 
/* 331 */           (DaydreamAlignment.this.displayMetrics.widthPixels / 2 + localScreenAlignmentMarker.getHorizontal() / DaydreamAlignment.this.xMetersPerPixel);
/* 332 */         DaydreamAlignment.this.markersInPixels[i][1] = 
/*     */         
/*     */ 
/* 335 */           (DaydreamAlignment.this.displayMetrics.heightPixels - (localScreenAlignmentMarker.getVertical() + paramDeviceParams.getTrayToLensDistance() - DaydreamAlignment.this.borderSizeMeters) / DaydreamAlignment.this.yMetersPerPixel);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private class FinishInitilizationTask extends AsyncTask<Void, Void, Phone.PhoneParams>
/*     */   {
/*     */     public Display display;
/*     */     
/*     */     private FinishInitilizationTask() {}
/*     */     
/*     */     protected Phone.PhoneParams doInBackground(Void... paramVarArgs)
/*     */     {
/* 348 */       return DaydreamAlignment.this.vrParamsProvider.readPhoneParams();
/*     */     }
/*     */     
/*     */ 
/*     */     protected void onProgressUpdate(Void... paramVarArgs) {}
/*     */     
/*     */ 
/*     */     protected void onPostExecute(Phone.PhoneParams paramPhoneParams)
/*     */     {
/* 357 */       DisplayMetrics localDisplayMetrics = DisplayUtils.getDisplayMetricsLandscapeWithOverride(this.display, paramPhoneParams);
/* 358 */       DaydreamAlignment.this.init(localDisplayMetrics, paramPhoneParams);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void shutdown()
/*     */   {
/* 366 */     this.vrParamsProvider.close();
/*     */   }
/*     */   
/*     */   private void resetTrackingState() {
/* 370 */     this.lastMotionEventInHeadset = false;
/* 371 */     this.pixelTranslation[0] = 0.0F;
/* 372 */     this.pixelTranslation[1] = 0.0F;
/* 373 */     this.mostTouchesSeen = 0;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\ndk\base\DaydreamAlignment.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */