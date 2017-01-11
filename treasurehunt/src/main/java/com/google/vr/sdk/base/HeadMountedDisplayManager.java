/*     */ package com.google.vr.sdk.base;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import android.view.Display;
/*     */ import android.view.WindowManager;
/*     */ import com.google.vr.cardboard.VrParamsProvider;
/*     */ import com.google.vr.cardboard.VrParamsProviderFactory;
/*     */ import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams;
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
/*     */ public class HeadMountedDisplayManager
/*     */ {
/*     */   private static final String TAG = "HeadMountedDisplayManager";
/*     */   private final HeadMountedDisplay hmd;
/*     */   private final Context context;
/*     */   private final VrParamsProvider paramsProvider;
/*     */   
/*     */   public HeadMountedDisplayManager(Context context)
/*     */   {
/*  49 */     this.context = context;
/*     */     
/*     */ 
/*  52 */     this.paramsProvider = VrParamsProviderFactory.create(context);
/*  53 */     this.hmd = new HeadMountedDisplay(createScreenParams(), createGvrViewerParams());
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
/*     */   public HeadMountedDisplay getHeadMountedDisplay()
/*     */   {
/*  68 */     return this.hmd;
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
/*     */   public void onResume()
/*     */   {
/*  85 */     CardboardDevice.DeviceParams deviceProto = this.paramsProvider.readDeviceParams();
/*     */     
/*  87 */     GvrViewerParams deviceParams = deviceProto != null ? new GvrViewerParams(deviceProto) : null;
/*  88 */     if ((deviceParams != null) && (!deviceParams.equals(this.hmd.getGvrViewerParams()))) {
/*  89 */       this.hmd.setGvrViewerParams(deviceParams);
/*  90 */       Log.i("HeadMountedDisplayManager", "Successfully read updated device params from external storage");
/*     */     }
/*     */     
/*  93 */     Phone.PhoneParams phoneProto = this.paramsProvider.readPhoneParams();
/*     */     
/*  95 */     ScreenParams screenParams = phoneProto != null ? ScreenParams.fromProto(getDisplay(), phoneProto) : null;
/*  96 */     if ((screenParams != null) && (!screenParams.equals(this.hmd.getScreenParams()))) {
/*  97 */       this.hmd.setScreenParams(screenParams);
/*  98 */       Log.i("HeadMountedDisplayManager", "Successfully read updated screen params from external storage");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onPause() {}
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
/*     */   public boolean updateGvrViewerParams(GvrViewerParams gvrViewerParams)
/*     */   {
/* 128 */     if ((gvrViewerParams == null) || (gvrViewerParams.equals(this.hmd.getGvrViewerParams()))) {
/* 129 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 133 */     this.hmd.setGvrViewerParams(gvrViewerParams);
/* 134 */     this.paramsProvider.writeDeviceParams(gvrViewerParams.toProtobuf());
/* 135 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean updateScreenParams(ScreenParams screenParams)
/*     */   {
/* 145 */     if ((screenParams == null) || (screenParams.equals(this.hmd.getScreenParams()))) {
/* 146 */       return false;
/*     */     }
/* 148 */     this.hmd.setScreenParams(screenParams);
/* 149 */     return true;
/*     */   }
/*     */   
/*     */   private Display getDisplay() {
/* 153 */     WindowManager windowManager = (WindowManager)this.context.getSystemService("window");
/* 154 */     return windowManager.getDefaultDisplay();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private ScreenParams createScreenParams()
/*     */   {
/* 162 */     Display display = getDisplay();
/* 163 */     ScreenParams params = ScreenParams.fromProto(display, this.paramsProvider.readPhoneParams());
/* 164 */     return params != null ? params : new ScreenParams(display);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private GvrViewerParams createGvrViewerParams()
/*     */   {
/* 172 */     return new GvrViewerParams(this.paramsProvider.readDeviceParams());
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\HeadMountedDisplayManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */