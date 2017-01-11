/*    */ package com.google.vr.audio;
/*    */ 
/*    */ import android.content.BroadcastReceiver;
/*    */ import android.content.Context;
/*    */ import android.content.Intent;
/*    */ import android.content.IntentFilter;
/*    */ import android.media.AudioManager;
/*    */ import com.google.vr.cardboard.annotations.UsedByNative;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @UsedByNative
/*    */ public class DeviceInfo
/*    */ {
/*    */   private static final String TAG = "DeviceInfo";
/*    */   private final long nativeObject;
/*    */   private final Context context;
/*    */   private final BroadcastReceiver headphoneStateReceiver;
/*    */   
/*    */   private DeviceInfo(long paramLong, Context paramContext)
/*    */   {
/* 35 */     this.nativeObject = paramLong;
/* 36 */     this.context = paramContext;
/* 37 */     this.headphoneStateReceiver = new BroadcastReceiver()
/*    */     {
/*    */       public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
/*    */       {
/* 41 */         if (paramAnonymousIntent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
/*    */           int i;
/* 43 */           switch (i = paramAnonymousIntent.getIntExtra("state", -1))
/*    */           {
/*    */           case 0: 
/* 45 */             DeviceInfo.this.nativeUpdateHeadphoneStateChange(DeviceInfo.this.nativeObject, 2);
/* 46 */             return;
/*    */           case 1: 
/* 48 */             DeviceInfo.this.nativeUpdateHeadphoneStateChange(DeviceInfo.this.nativeObject, 1);
/* 49 */             return;
/*    */           }
/* 51 */           DeviceInfo.this.nativeUpdateHeadphoneStateChange(DeviceInfo.this.nativeObject, 0);
/*    */         }
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @UsedByNative
/*    */   private static DeviceInfo createDeviceInfo(long paramLong, Context paramContext)
/*    */   {
/* 65 */     return new DeviceInfo(paramLong, paramContext);
/*    */   }
/*    */   
/*    */   @UsedByNative
/*    */   private void registerHandlers()
/*    */   {
/* 71 */     IntentFilter localIntentFilter = new IntentFilter("android.intent.action.HEADSET_PLUG");
/* 72 */     this.context.registerReceiver(this.headphoneStateReceiver, localIntentFilter);
/*    */   }
/*    */   
/*    */   @UsedByNative
/*    */   private void unregisterHandlers()
/*    */   {
/* 78 */     this.context.unregisterReceiver(this.headphoneStateReceiver);
/*    */   }
/*    */   
/*    */   @UsedByNative
/*    */   private boolean isHeadphonePluggedIn()
/*    */   {
/*    */     AudioManager localAudioManager;
/* 85 */     return (localAudioManager = (AudioManager)this.context.getSystemService("audio")).isWiredHeadsetOn();
/*    */   }
/*    */   
/*    */   private native void nativeUpdateHeadphoneStateChange(long paramLong, int paramInt);
/*    */   
/*    */   private static abstract class HeadphoneState
/*    */   {
/*    */     public static final int UNKNOWN = 0;
/*    */     public static final int PLUGGEDIN = 1;
/*    */     public static final int UNPLUGGED = 2;
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\audio\DeviceInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */