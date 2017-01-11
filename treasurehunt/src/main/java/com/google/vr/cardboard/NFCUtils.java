/*    */ package com.google.vr.cardboard;
/*    */ 
/*    */ import android.app.Activity;
/*    */ import android.app.PendingIntent;
/*    */ import android.content.BroadcastReceiver;
/*    */ import android.content.Context;
/*    */ import android.content.Intent;
/*    */ import android.content.IntentFilter;
/*    */ import android.nfc.NfcAdapter;
/*    */ import android.nfc.Tag;
/*    */ import android.util.Log;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NFCUtils
/*    */ {
/* 19 */   private static final String TAG = NFCUtils.class.getSimpleName();
/*    */   Context context;
/*    */   NfcAdapter nfcAdapter;
/*    */   BroadcastReceiver nfcBroadcastReceiver;
/*    */   IntentFilter[] nfcIntentFilters;
/*    */   
/*    */   public void onCreate(Activity paramActivity)
/*    */   {
/* 27 */     this.context = paramActivity.getApplicationContext();
/*    */     
/* 29 */     this.nfcAdapter = NfcAdapter.getDefaultAdapter(this.context);
/*    */     
/* 31 */     this.nfcBroadcastReceiver = new BroadcastReceiver()
/*    */     {
/*    */       public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent) {
/* 34 */         Log.i(NFCUtils.TAG, "Got an NFC tag!");
/* 35 */         NFCUtils.this.onNFCTagDetected((Tag)paramAnonymousIntent.getParcelableExtra("android.nfc.extra.TAG"));
/*    */       }
/*    */     };
/*    */     
/*    */     IntentFilter localIntentFilter1;
/* 40 */     (localIntentFilter1 = createNfcIntentFilter()).addDataScheme("cardboard");
/*    */     
/*    */     IntentFilter localIntentFilter2;
/* 43 */     (localIntentFilter2 = createNfcIntentFilter()).addDataScheme("http");
/* 44 */     localIntentFilter2.addDataAuthority("goo.gl", null);
/*    */     
/*    */     IntentFilter localIntentFilter3;
/* 47 */     (localIntentFilter3 = createNfcIntentFilter()).addDataScheme("http");
/* 48 */     localIntentFilter3.addDataAuthority("google.com", null);
/* 49 */     localIntentFilter3.addDataPath("/cardboard/cfg.*", 2);
/*    */     
/* 51 */     this.nfcIntentFilters = new IntentFilter[] { localIntentFilter1, localIntentFilter2, localIntentFilter3 };
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onResume(Activity paramActivity)
/*    */   {
/* 59 */     paramActivity.registerReceiver(this.nfcBroadcastReceiver, createNfcIntentFilter());
/*    */     Intent localIntent;
/* 61 */     (localIntent = new Intent("android.nfc.action.NDEF_DISCOVERED")).setPackage(paramActivity.getPackageName());
/* 62 */     PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.context, 0, localIntent, 0);
/* 63 */     if (isNFCEnabled()) {
/* 64 */       this.nfcAdapter.enableForegroundDispatch(paramActivity, localPendingIntent, this.nfcIntentFilters, null);
/*    */     }
/*    */   }
/*    */   
/*    */   public void onPause(Activity paramActivity) {
/* 69 */     if (isNFCEnabled()) {
/* 70 */       this.nfcAdapter.disableForegroundDispatch(paramActivity);
/*    */     }
/* 72 */     paramActivity.unregisterReceiver(this.nfcBroadcastReceiver);
/*    */   }
/*    */   
/*    */   protected boolean isNFCEnabled() {
/* 76 */     return (this.nfcAdapter != null) && (this.nfcAdapter.isEnabled());
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onNFCTagDetected(Tag paramTag) {}
/*    */   
/*    */   private IntentFilter createNfcIntentFilter()
/*    */   {
/*    */     IntentFilter localIntentFilter;
/* 85 */     (localIntentFilter = new IntentFilter()).addAction("android.nfc.action.NDEF_DISCOVERED");
/* 86 */     localIntentFilter.addAction("android.nfc.action.TECH_DISCOVERED");
/* 87 */     localIntentFilter.addAction("android.nfc.action.TAG_DISCOVERED");
/* 88 */     return localIntentFilter;
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\NFCUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */