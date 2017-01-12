/*     */ package com.google.vr.sdk.base.sensors;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.app.PendingIntent;
/*     */ import android.content.BroadcastReceiver;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.IntentFilter;
/*     */ import android.net.Uri;
/*     */ import android.nfc.FormatException;
/*     */ import android.nfc.NdefMessage;
/*     */ import android.nfc.NdefRecord;
/*     */ import android.nfc.NfcAdapter;
/*     */ import android.nfc.Tag;
/*     */ import android.nfc.TagLostException;
/*     */ import android.nfc.tech.Ndef;
/*     */ import android.os.Handler;
/*     */ import android.util.Log;
/*     */ import com.google.vr.sdk.base.GvrViewerParams;
/*     */ import com.google.vr.sdk.base.PermissionUtils;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
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
/*     */ public class NfcSensor
/*     */ {
/*     */   private static final String TAG = "NfcSensor";
/*     */   private static final int MAX_CONNECTION_FAILURES = 1;
/*     */   private static final long NFC_POLLING_INTERVAL_MS = 250L;
/*     */   private static NfcSensor sInstance;
/*     */   private final Context context;
/*     */   private final NfcAdapter nfcAdapter;
/*     */   private final Object tagLock;
/*     */   private final List<ListenerHelper> listeners;
/*     */   private BroadcastReceiver nfcBroadcastReceiver;
/*     */   private IntentFilter[] nfcIntentFilters;
/*     */   private Ndef currentNdef;
/*     */   private Tag currentTag;
/*     */   private boolean currentTagIsCardboard;
/*     */   private Timer nfcDisconnectTimer;
/*     */   private int tagConnectionFailures;
/*     */   
/*     */   public static NfcSensor getInstance(Context context)
/*     */   {
/* 100 */     if (sInstance == null) {
/* 101 */       sInstance = new NfcSensor(context);
/*     */     }
/*     */     
/* 104 */     return sInstance;
/*     */   }
/*     */   
/*     */   private NfcSensor(Context context) {
/* 108 */     this.context = context.getApplicationContext();
/* 109 */     this.listeners = new ArrayList();
/* 110 */     this.tagLock = new Object();
/*     */     
/* 112 */     if (PermissionUtils.hasPermission(context, "android.permission.NFC")) {
/* 113 */       this.nfcAdapter = NfcAdapter.getDefaultAdapter(context);
/*     */     } else {
/* 115 */       this.nfcAdapter = null;
/*     */     }
/*     */     
/* 118 */     if (this.nfcAdapter == null) {
/* 119 */       Log.w("NfcSensor", "NFC is not supported on this phone or application doesn't have NFC permission.");
/* 120 */       return;
/*     */     }
/*     */     
/*     */ 
/* 124 */     this.nfcBroadcastReceiver = new BroadcastReceiver()
/*     */     {
/*     */       public void onReceive(Context context, Intent intent) {
/* 127 */         NfcSensor.this.onNfcIntent(intent);
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addOnCardboardNfcListener(OnCardboardNfcListener listener)
/*     */   {
/* 140 */     if (listener == null) {
/* 141 */       return;
/*     */     }
/*     */     
/* 144 */     synchronized (this.listeners) { IntentFilter ndefIntentFilter;
/* 145 */       if (this.listeners.isEmpty())
/*     */       {
/* 147 */         ndefIntentFilter = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
/* 148 */         ndefIntentFilter.addAction("android.nfc.action.TECH_DISCOVERED");
/* 149 */         ndefIntentFilter.addAction("android.nfc.action.TAG_DISCOVERED");
/* 150 */         this.nfcIntentFilters = new IntentFilter[] { ndefIntentFilter };
/*     */         
/*     */ 
/* 153 */         this.context.registerReceiver(this.nfcBroadcastReceiver, ndefIntentFilter);
/*     */       }
/*     */       
/* 156 */       for (ListenerHelper helper : this.listeners) {
/* 157 */         if (helper.getListener() == listener) {
/* 158 */           return;
/*     */         }
/*     */       }
/*     */       
/* 162 */       this.listeners.add(new ListenerHelper(listener, new Handler()));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removeOnCardboardNfcListener(OnCardboardNfcListener listener)
/*     */   {
/* 172 */     if (listener == null) {
/* 173 */       return;
/*     */     }
/*     */     
/* 176 */     synchronized (this.listeners) {
/* 177 */       for (ListenerHelper helper : this.listeners) {
/* 178 */         if (helper.getListener() == listener) {
/* 179 */           this.listeners.remove(helper);
/* 180 */           break;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 186 */       if ((this.nfcBroadcastReceiver != null) && (this.listeners.isEmpty())) {
/* 187 */         this.context.unregisterReceiver(this.nfcBroadcastReceiver);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isNfcSupported()
/*     */   {
/* 198 */     return this.nfcAdapter != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isNfcEnabled()
/*     */   {
/* 207 */     return (isNfcSupported()) && (this.nfcAdapter.isEnabled());
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public boolean isDeviceInCardboard()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 81	com/google/vr/sdk/base/sensors/NfcSensor:tagLock	Ljava/lang/Object;
/*     */     //   4: dup
/*     */     //   5: astore_1
/*     */     //   6: monitorenter
/*     */     //   7: aload_0
/*     */     //   8: getfield 192	com/google/vr/sdk/base/sensors/NfcSensor:currentTagIsCardboard	Z
/*     */     //   11: aload_1
/*     */     //   12: monitorexit
/*     */     //   13: ireturn
/*     */     //   14: astore_2
/*     */     //   15: aload_1
/*     */     //   16: monitorexit
/*     */     //   17: aload_2
/*     */     //   18: athrow
/*     */     // Line number table:
/*     */     //   Java source line #217	-> byte code offset #0
/*     */     //   Java source line #218	-> byte code offset #7
/*     */     //   Java source line #219	-> byte code offset #14
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	19	0	this	NfcSensor
/*     */     //   5	11	1	Ljava/lang/Object;	Object
/*     */     //   14	4	2	localObject1	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	13	14	finally
/*     */     //   14	17	14	finally
/*     */   }
/*     */   
/*     */   public NdefMessage getTagContents()
/*     */   {
/* 228 */     synchronized (this.tagLock) {
/* 229 */       return this.currentNdef != null ? this.currentNdef.getCachedNdefMessage() : null;
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
/*     */   public NdefMessage getCurrentTagContents()
/*     */     throws TagLostException, IOException, FormatException
/*     */   {
/* 243 */     synchronized (this.tagLock) {
/* 244 */       return this.currentNdef != null ? this.currentNdef.getNdefMessage() : null;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getTagCapacity()
/*     */   {
/* 255 */     synchronized (this.tagLock) {
/* 256 */       if (this.currentNdef == null) {
/* 257 */         throw new IllegalStateException("No NFC tag");
/*     */       }
/*     */       
/* 260 */       return this.currentNdef.getMaxSize();
/*     */     }
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void writeUri(Uri uri)
/*     */     throws TagLostException, IOException, java.lang.IllegalArgumentException
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 81	com/google/vr/sdk/base/sensors/NfcSensor:tagLock	Ljava/lang/Object;
/*     */     //   4: dup
/*     */     //   5: astore_2
/*     */     //   6: monitorenter
/*     */     //   7: aload_0
/*     */     //   8: getfield 231	com/google/vr/sdk/base/sensors/NfcSensor:currentTag	Landroid/nfc/Tag;
/*     */     //   11: ifnonnull +13 -> 24
/*     */     //   14: new 217	java/lang/IllegalStateException
/*     */     //   17: dup
/*     */     //   18: ldc -23
/*     */     //   20: invokespecial 220	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
/*     */     //   23: athrow
/*     */     //   24: aconst_null
/*     */     //   25: astore_3
/*     */     //   26: aconst_null
/*     */     //   27: astore 4
/*     */     //   29: aload_1
/*     */     //   30: invokestatic 239	android/nfc/NdefRecord:createUri	(Landroid/net/Uri;)Landroid/nfc/NdefRecord;
/*     */     //   33: astore 5
/*     */     //   35: aload_0
/*     */     //   36: invokevirtual 241	com/google/vr/sdk/base/sensors/NfcSensor:getCurrentTagContents	()Landroid/nfc/NdefMessage;
/*     */     //   39: astore_3
/*     */     //   40: goto +10 -> 50
/*     */     //   43: astore 6
/*     */     //   45: aload_0
/*     */     //   46: invokevirtual 245	com/google/vr/sdk/base/sensors/NfcSensor:getTagContents	()Landroid/nfc/NdefMessage;
/*     */     //   49: astore_3
/*     */     //   50: aload_3
/*     */     //   51: ifnull +110 -> 161
/*     */     //   54: new 76	java/util/ArrayList
/*     */     //   57: dup
/*     */     //   58: invokespecial 77	java/util/ArrayList:<init>	()V
/*     */     //   61: astore 6
/*     */     //   63: iconst_0
/*     */     //   64: istore 7
/*     */     //   66: aload_3
/*     */     //   67: invokevirtual 249	android/nfc/NdefMessage:getRecords	()[Landroid/nfc/NdefRecord;
/*     */     //   70: astore 8
/*     */     //   72: aload 8
/*     */     //   74: arraylength
/*     */     //   75: istore 9
/*     */     //   77: iconst_0
/*     */     //   78: istore 10
/*     */     //   80: iload 10
/*     */     //   82: iload 9
/*     */     //   84: if_icmpge +52 -> 136
/*     */     //   87: aload 8
/*     */     //   89: iload 10
/*     */     //   91: aaload
/*     */     //   92: astore 11
/*     */     //   94: aload_0
/*     */     //   95: aload 11
/*     */     //   97: invokespecial 255	com/google/vr/sdk/base/sensors/NfcSensor:isCardboardNdefRecord	(Landroid/nfc/NdefRecord;)Z
/*     */     //   100: ifeq +22 -> 122
/*     */     //   103: iload 7
/*     */     //   105: ifne +25 -> 130
/*     */     //   108: aload 6
/*     */     //   110: aload 5
/*     */     //   112: invokevirtual 256	java/util/ArrayList:add	(Ljava/lang/Object;)Z
/*     */     //   115: pop
/*     */     //   116: iconst_1
/*     */     //   117: istore 7
/*     */     //   119: goto +11 -> 130
/*     */     //   122: aload 6
/*     */     //   124: aload 11
/*     */     //   126: invokevirtual 256	java/util/ArrayList:add	(Ljava/lang/Object;)Z
/*     */     //   129: pop
/*     */     //   130: iinc 10 1
/*     */     //   133: goto -53 -> 80
/*     */     //   136: new 203	android/nfc/NdefMessage
/*     */     //   139: dup
/*     */     //   140: aload 6
/*     */     //   142: aload 6
/*     */     //   144: invokevirtual 259	java/util/ArrayList:size	()I
/*     */     //   147: anewarray 235	android/nfc/NdefRecord
/*     */     //   150: invokevirtual 263	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   153: checkcast 251	[Landroid/nfc/NdefRecord;
/*     */     //   156: invokespecial 266	android/nfc/NdefMessage:<init>	([Landroid/nfc/NdefRecord;)V
/*     */     //   159: astore 4
/*     */     //   161: aload 4
/*     */     //   163: ifnonnull +21 -> 184
/*     */     //   166: new 203	android/nfc/NdefMessage
/*     */     //   169: dup
/*     */     //   170: iconst_1
/*     */     //   171: anewarray 235	android/nfc/NdefRecord
/*     */     //   174: dup
/*     */     //   175: iconst_0
/*     */     //   176: aload 5
/*     */     //   178: aastore
/*     */     //   179: invokespecial 266	android/nfc/NdefMessage:<init>	([Landroid/nfc/NdefRecord;)V
/*     */     //   182: astore 4
/*     */     //   184: aload_0
/*     */     //   185: getfield 196	com/google/vr/sdk/base/sensors/NfcSensor:currentNdef	Landroid/nfc/tech/Ndef;
/*     */     //   188: ifnull +155 -> 343
/*     */     //   191: aload_0
/*     */     //   192: getfield 196	com/google/vr/sdk/base/sensors/NfcSensor:currentNdef	Landroid/nfc/tech/Ndef;
/*     */     //   195: invokevirtual 269	android/nfc/tech/Ndef:isConnected	()Z
/*     */     //   198: ifne +10 -> 208
/*     */     //   201: aload_0
/*     */     //   202: getfield 196	com/google/vr/sdk/base/sensors/NfcSensor:currentNdef	Landroid/nfc/tech/Ndef;
/*     */     //   205: invokevirtual 272	android/nfc/tech/Ndef:connect	()V
/*     */     //   208: aload_0
/*     */     //   209: getfield 196	com/google/vr/sdk/base/sensors/NfcSensor:currentNdef	Landroid/nfc/tech/Ndef;
/*     */     //   212: invokevirtual 223	android/nfc/tech/Ndef:getMaxSize	()I
/*     */     //   215: aload 4
/*     */     //   217: invokevirtual 275	android/nfc/NdefMessage:getByteArrayLength	()I
/*     */     //   220: if_icmpge +68 -> 288
/*     */     //   223: new 227	java/lang/IllegalArgumentException
/*     */     //   226: dup
/*     */     //   227: aload_0
/*     */     //   228: getfield 196	com/google/vr/sdk/base/sensors/NfcSensor:currentNdef	Landroid/nfc/tech/Ndef;
/*     */     //   231: invokevirtual 223	android/nfc/tech/Ndef:getMaxSize	()I
/*     */     //   234: istore 6
/*     */     //   236: aload 4
/*     */     //   238: invokevirtual 275	android/nfc/NdefMessage:getByteArrayLength	()I
/*     */     //   241: istore 7
/*     */     //   243: bipush 82
/*     */     //   245: new 277	java/lang/StringBuilder
/*     */     //   248: dup_x1
/*     */     //   249: swap
/*     */     //   250: invokespecial 280	java/lang/StringBuilder:<init>	(I)V
/*     */     //   253: ldc_w 282
/*     */     //   256: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   259: iload 6
/*     */     //   261: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
/*     */     //   264: ldc_w 291
/*     */     //   267: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   270: iload 7
/*     */     //   272: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
/*     */     //   275: ldc_w 293
/*     */     //   278: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   281: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   284: invokespecial 298	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
/*     */     //   287: athrow
/*     */     //   288: aload_0
/*     */     //   289: getfield 196	com/google/vr/sdk/base/sensors/NfcSensor:currentNdef	Landroid/nfc/tech/Ndef;
/*     */     //   292: aload 4
/*     */     //   294: invokevirtual 302	android/nfc/tech/Ndef:writeNdefMessage	(Landroid/nfc/NdefMessage;)V
/*     */     //   297: goto +143 -> 440
/*     */     //   300: astore 6
/*     */     //   302: new 304	java/lang/RuntimeException
/*     */     //   305: dup
/*     */     //   306: ldc_w 306
/*     */     //   309: aload 6
/*     */     //   311: invokevirtual 307	android/nfc/FormatException:toString	()Ljava/lang/String;
/*     */     //   314: invokestatic 313	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   317: dup
/*     */     //   318: invokevirtual 316	java/lang/String:length	()I
/*     */     //   321: ifeq +9 -> 330
/*     */     //   324: invokevirtual 320	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   327: goto +12 -> 339
/*     */     //   330: pop
/*     */     //   331: new 309	java/lang/String
/*     */     //   334: dup_x1
/*     */     //   335: swap
/*     */     //   336: invokespecial 321	java/lang/String:<init>	(Ljava/lang/String;)V
/*     */     //   339: invokespecial 322	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
/*     */     //   342: athrow
/*     */     //   343: aload_0
/*     */     //   344: getfield 231	com/google/vr/sdk/base/sensors/NfcSensor:currentTag	Landroid/nfc/Tag;
/*     */     //   347: invokestatic 328	android/nfc/tech/NdefFormatable:get	(Landroid/nfc/Tag;)Landroid/nfc/tech/NdefFormatable;
/*     */     //   350: astore 6
/*     */     //   352: aload 6
/*     */     //   354: ifnonnull +14 -> 368
/*     */     //   357: new 208	java/io/IOException
/*     */     //   360: dup
/*     */     //   361: ldc_w 330
/*     */     //   364: invokespecial 331	java/io/IOException:<init>	(Ljava/lang/String;)V
/*     */     //   367: athrow
/*     */     //   368: ldc 24
/*     */     //   370: ldc_w 333
/*     */     //   373: invokestatic 105	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   376: pop
/*     */     //   377: aload 6
/*     */     //   379: invokevirtual 334	android/nfc/tech/NdefFormatable:connect	()V
/*     */     //   382: aload 6
/*     */     //   384: aload 4
/*     */     //   386: invokevirtual 337	android/nfc/tech/NdefFormatable:format	(Landroid/nfc/NdefMessage;)V
/*     */     //   389: aload 6
/*     */     //   391: invokevirtual 340	android/nfc/tech/NdefFormatable:close	()V
/*     */     //   394: goto +46 -> 440
/*     */     //   397: astore 7
/*     */     //   399: new 304	java/lang/RuntimeException
/*     */     //   402: dup
/*     */     //   403: ldc_w 306
/*     */     //   406: aload 7
/*     */     //   408: invokevirtual 307	android/nfc/FormatException:toString	()Ljava/lang/String;
/*     */     //   411: invokestatic 313	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   414: dup
/*     */     //   415: invokevirtual 316	java/lang/String:length	()I
/*     */     //   418: ifeq +9 -> 427
/*     */     //   421: invokevirtual 320	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   424: goto +12 -> 436
/*     */     //   427: pop
/*     */     //   428: new 309	java/lang/String
/*     */     //   431: dup_x1
/*     */     //   432: swap
/*     */     //   433: invokespecial 321	java/lang/String:<init>	(Ljava/lang/String;)V
/*     */     //   436: invokespecial 322	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
/*     */     //   439: athrow
/*     */     //   440: aload_0
/*     */     //   441: aload_0
/*     */     //   442: getfield 231	com/google/vr/sdk/base/sensors/NfcSensor:currentTag	Landroid/nfc/Tag;
/*     */     //   445: invokespecial 344	com/google/vr/sdk/base/sensors/NfcSensor:onNewNfcTag	(Landroid/nfc/Tag;)V
/*     */     //   448: aload_2
/*     */     //   449: monitorexit
/*     */     //   450: goto +10 -> 460
/*     */     //   453: astore 12
/*     */     //   455: aload_2
/*     */     //   456: monitorexit
/*     */     //   457: aload 12
/*     */     //   459: athrow
/*     */     //   460: return
/*     */     // Line number table:
/*     */     //   Java source line #277	-> byte code offset #0
/*     */     //   Java source line #278	-> byte code offset #7
/*     */     //   Java source line #279	-> byte code offset #14
/*     */     //   Java source line #282	-> byte code offset #24
/*     */     //   Java source line #283	-> byte code offset #26
/*     */     //   Java source line #284	-> byte code offset #29
/*     */     //   Java source line #288	-> byte code offset #35
/*     */     //   Java source line #292	-> byte code offset #40
/*     */     //   Java source line #289	-> byte code offset #43
/*     */     //   Java source line #291	-> byte code offset #45
/*     */     //   Java source line #295	-> byte code offset #50
/*     */     //   Java source line #296	-> byte code offset #54
/*     */     //   Java source line #297	-> byte code offset #63
/*     */     //   Java source line #299	-> byte code offset #66
/*     */     //   Java source line #300	-> byte code offset #94
/*     */     //   Java source line #302	-> byte code offset #103
/*     */     //   Java source line #303	-> byte code offset #108
/*     */     //   Java source line #304	-> byte code offset #116
/*     */     //   Java source line #307	-> byte code offset #122
/*     */     //   Java source line #299	-> byte code offset #130
/*     */     //   Java source line #311	-> byte code offset #136
/*     */     //   Java source line #315	-> byte code offset #161
/*     */     //   Java source line #316	-> byte code offset #166
/*     */     //   Java source line #319	-> byte code offset #184
/*     */     //   Java source line #321	-> byte code offset #191
/*     */     //   Java source line #322	-> byte code offset #201
/*     */     //   Java source line #325	-> byte code offset #208
/*     */     //   Java source line #326	-> byte code offset #223
/*     */     //   Java source line #328	-> byte code offset #231
/*     */     //   Java source line #329	-> byte code offset #238
/*     */     //   Java source line #333	-> byte code offset #288
/*     */     //   Java source line #337	-> byte code offset #297
/*     */     //   Java source line #334	-> byte code offset #300
/*     */     //   Java source line #335	-> byte code offset #302
/*     */     //   Java source line #336	-> byte code offset #311
/*     */     //   Java source line #341	-> byte code offset #343
/*     */     //   Java source line #342	-> byte code offset #352
/*     */     //   Java source line #343	-> byte code offset #357
/*     */     //   Java source line #346	-> byte code offset #368
/*     */     //   Java source line #350	-> byte code offset #377
/*     */     //   Java source line #351	-> byte code offset #382
/*     */     //   Java source line #352	-> byte code offset #389
/*     */     //   Java source line #356	-> byte code offset #394
/*     */     //   Java source line #353	-> byte code offset #397
/*     */     //   Java source line #354	-> byte code offset #399
/*     */     //   Java source line #355	-> byte code offset #408
/*     */     //   Java source line #360	-> byte code offset #440
/*     */     //   Java source line #361	-> byte code offset #448
/*     */     //   Java source line #362	-> byte code offset #460
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	461	0	this	NfcSensor
/*     */     //   0	461	1	uri	Uri
/*     */     //   26	422	3	currentMessage	NdefMessage
/*     */     //   29	419	4	newMessage	NdefMessage
/*     */     //   35	413	5	newRecord	NdefRecord
/*     */     //   45	5	6	e	Exception
/*     */     //   63	98	6	newRecords	ArrayList<NdefRecord>
/*     */     //   302	41	6	e	FormatException
/*     */     //   352	88	6	ndef	android.nfc.tech.NdefFormatable
/*     */     //   66	95	7	recordFound	boolean
/*     */     //   399	41	7	e	FormatException
/*     */     //   94	36	11	record	NdefRecord
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   35	40	43	java/lang/Exception
/*     */     //   288	297	300	android/nfc/FormatException
/*     */     //   377	394	397	android/nfc/FormatException
/*     */     //   7	450	453	finally
/*     */     //   453	457	453	finally
/*     */   }
/*     */   
/*     */   public void onResume(Activity activity)
/*     */   {
/* 370 */     if (!isNfcEnabled()) {
/* 371 */       return;
/*     */     }
/*     */     
/* 374 */     Intent intent = new Intent("android.nfc.action.NDEF_DISCOVERED");
/* 375 */     intent.setPackage(activity.getPackageName());
/*     */     
/* 377 */     PendingIntent pendingIntent = PendingIntent.getBroadcast(this.context, 0, intent, 0);
/* 378 */     this.nfcAdapter.enableForegroundDispatch(activity, pendingIntent, this.nfcIntentFilters, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onPause(Activity activity)
/*     */   {
/* 387 */     if (!isNfcEnabled()) {
/* 388 */       return;
/*     */     }
/*     */     
/* 391 */     this.nfcAdapter.disableForegroundDispatch(activity);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onNfcIntent(Intent intent)
/*     */   {
/* 400 */     if ((!isNfcEnabled()) || (intent == null) || (!this.nfcIntentFilters[0].matchAction(intent.getAction()))) {
/* 401 */       return;
/*     */     }
/*     */     
/* 404 */     onNewNfcTag((Tag)intent.getParcelableExtra("android.nfc.extra.TAG"));
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   private void onNewNfcTag(Tag nfcTag)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnonnull +4 -> 5
/*     */     //   4: return
/*     */     //   5: aload_0
/*     */     //   6: getfield 81	com/google/vr/sdk/base/sensors/NfcSensor:tagLock	Ljava/lang/Object;
/*     */     //   9: dup
/*     */     //   10: astore_2
/*     */     //   11: monitorenter
/*     */     //   12: aload_0
/*     */     //   13: getfield 231	com/google/vr/sdk/base/sensors/NfcSensor:currentTag	Landroid/nfc/Tag;
/*     */     //   16: astore_3
/*     */     //   17: aload_0
/*     */     //   18: getfield 196	com/google/vr/sdk/base/sensors/NfcSensor:currentNdef	Landroid/nfc/tech/Ndef;
/*     */     //   21: astore 4
/*     */     //   23: aload_0
/*     */     //   24: getfield 192	com/google/vr/sdk/base/sensors/NfcSensor:currentTagIsCardboard	Z
/*     */     //   27: istore 5
/*     */     //   29: aload_0
/*     */     //   30: invokespecial 417	com/google/vr/sdk/base/sensors/NfcSensor:closeCurrentNfcTag	()V
/*     */     //   33: aload_0
/*     */     //   34: aload_1
/*     */     //   35: putfield 231	com/google/vr/sdk/base/sensors/NfcSensor:currentTag	Landroid/nfc/Tag;
/*     */     //   38: aload_0
/*     */     //   39: aload_1
/*     */     //   40: invokestatic 420	android/nfc/tech/Ndef:get	(Landroid/nfc/Tag;)Landroid/nfc/tech/Ndef;
/*     */     //   43: putfield 196	com/google/vr/sdk/base/sensors/NfcSensor:currentNdef	Landroid/nfc/tech/Ndef;
/*     */     //   46: aload_0
/*     */     //   47: getfield 196	com/google/vr/sdk/base/sensors/NfcSensor:currentNdef	Landroid/nfc/tech/Ndef;
/*     */     //   50: ifnonnull +15 -> 65
/*     */     //   53: iload 5
/*     */     //   55: ifeq +7 -> 62
/*     */     //   58: aload_0
/*     */     //   59: invokespecial 423	com/google/vr/sdk/base/sensors/NfcSensor:sendDisconnectionEvent	()V
/*     */     //   62: aload_2
/*     */     //   63: monitorexit
/*     */     //   64: return
/*     */     //   65: iconst_0
/*     */     //   66: istore 6
/*     */     //   68: aload 4
/*     */     //   70: ifnull +59 -> 129
/*     */     //   73: aload_0
/*     */     //   74: getfield 231	com/google/vr/sdk/base/sensors/NfcSensor:currentTag	Landroid/nfc/Tag;
/*     */     //   77: invokevirtual 427	android/nfc/Tag:getId	()[B
/*     */     //   80: astore 7
/*     */     //   82: aload_3
/*     */     //   83: invokevirtual 427	android/nfc/Tag:getId	()[B
/*     */     //   86: astore 8
/*     */     //   88: aload 7
/*     */     //   90: ifnull +22 -> 112
/*     */     //   93: aload 8
/*     */     //   95: ifnull +17 -> 112
/*     */     //   98: aload 7
/*     */     //   100: aload 8
/*     */     //   102: invokestatic 433	java/util/Arrays:equals	([B[B)Z
/*     */     //   105: ifeq +7 -> 112
/*     */     //   108: iconst_1
/*     */     //   109: goto +4 -> 113
/*     */     //   112: iconst_0
/*     */     //   113: istore 6
/*     */     //   115: iload 6
/*     */     //   117: ifne +12 -> 129
/*     */     //   120: iload 5
/*     */     //   122: ifeq +7 -> 129
/*     */     //   125: aload_0
/*     */     //   126: invokespecial 423	com/google/vr/sdk/base/sensors/NfcSensor:sendDisconnectionEvent	()V
/*     */     //   129: aload_0
/*     */     //   130: getfield 196	com/google/vr/sdk/base/sensors/NfcSensor:currentNdef	Landroid/nfc/tech/Ndef;
/*     */     //   133: invokevirtual 272	android/nfc/tech/Ndef:connect	()V
/*     */     //   136: aload_0
/*     */     //   137: getfield 196	com/google/vr/sdk/base/sensors/NfcSensor:currentNdef	Landroid/nfc/tech/Ndef;
/*     */     //   140: invokevirtual 201	android/nfc/tech/Ndef:getCachedNdefMessage	()Landroid/nfc/NdefMessage;
/*     */     //   143: astore 7
/*     */     //   145: goto +61 -> 206
/*     */     //   148: astore 8
/*     */     //   150: ldc 24
/*     */     //   152: ldc_w 437
/*     */     //   155: aload 8
/*     */     //   157: invokevirtual 438	java/lang/Exception:toString	()Ljava/lang/String;
/*     */     //   160: invokestatic 313	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   163: dup
/*     */     //   164: invokevirtual 316	java/lang/String:length	()I
/*     */     //   167: ifeq +9 -> 176
/*     */     //   170: invokevirtual 320	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   173: goto +12 -> 185
/*     */     //   176: pop
/*     */     //   177: new 309	java/lang/String
/*     */     //   180: dup_x1
/*     */     //   181: swap
/*     */     //   182: invokespecial 321	java/lang/String:<init>	(Ljava/lang/String;)V
/*     */     //   185: invokestatic 440	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   188: pop
/*     */     //   189: iload 6
/*     */     //   191: ifeq +12 -> 203
/*     */     //   194: iload 5
/*     */     //   196: ifeq +7 -> 203
/*     */     //   199: aload_0
/*     */     //   200: invokespecial 423	com/google/vr/sdk/base/sensors/NfcSensor:sendDisconnectionEvent	()V
/*     */     //   203: aload_2
/*     */     //   204: monitorexit
/*     */     //   205: return
/*     */     //   206: aload_0
/*     */     //   207: aload_0
/*     */     //   208: aload 7
/*     */     //   210: invokespecial 444	com/google/vr/sdk/base/sensors/NfcSensor:isCardboardNdefMessage	(Landroid/nfc/NdefMessage;)Z
/*     */     //   213: putfield 192	com/google/vr/sdk/base/sensors/NfcSensor:currentTagIsCardboard	Z
/*     */     //   216: iload 6
/*     */     //   218: ifne +78 -> 296
/*     */     //   221: aload_0
/*     */     //   222: getfield 192	com/google/vr/sdk/base/sensors/NfcSensor:currentTagIsCardboard	Z
/*     */     //   225: ifeq +71 -> 296
/*     */     //   228: aload_0
/*     */     //   229: getfield 79	com/google/vr/sdk/base/sensors/NfcSensor:listeners	Ljava/util/List;
/*     */     //   232: dup
/*     */     //   233: astore 8
/*     */     //   235: monitorenter
/*     */     //   236: aload_0
/*     */     //   237: getfield 79	com/google/vr/sdk/base/sensors/NfcSensor:listeners	Ljava/util/List;
/*     */     //   240: invokeinterface 143 1 0
/*     */     //   245: astore 9
/*     */     //   247: aload 9
/*     */     //   249: invokeinterface 148 1 0
/*     */     //   254: ifeq +28 -> 282
/*     */     //   257: aload 9
/*     */     //   259: invokeinterface 152 1 0
/*     */     //   264: checkcast 7	com/google/vr/sdk/base/sensors/NfcSensor$ListenerHelper
/*     */     //   267: astore 10
/*     */     //   269: aload 10
/*     */     //   271: aload 7
/*     */     //   273: invokestatic 450	com/google/vr/sdk/base/GvrViewerParams:createFromNfcContents	(Landroid/nfc/NdefMessage;)Lcom/google/vr/sdk/base/GvrViewerParams;
/*     */     //   276: invokevirtual 454	com/google/vr/sdk/base/sensors/NfcSensor$ListenerHelper:onInsertedIntoGvrViewer	(Lcom/google/vr/sdk/base/GvrViewerParams;)V
/*     */     //   279: goto -32 -> 247
/*     */     //   282: aload 8
/*     */     //   284: monitorexit
/*     */     //   285: goto +11 -> 296
/*     */     //   288: astore 11
/*     */     //   290: aload 8
/*     */     //   292: monitorexit
/*     */     //   293: aload 11
/*     */     //   295: athrow
/*     */     //   296: aload_0
/*     */     //   297: getfield 192	com/google/vr/sdk/base/sensors/NfcSensor:currentTagIsCardboard	Z
/*     */     //   300: ifeq +43 -> 343
/*     */     //   303: aload_0
/*     */     //   304: iconst_0
/*     */     //   305: putfield 456	com/google/vr/sdk/base/sensors/NfcSensor:tagConnectionFailures	I
/*     */     //   308: aload_0
/*     */     //   309: new 458	java/util/Timer
/*     */     //   312: dup
/*     */     //   313: ldc_w 460
/*     */     //   316: invokespecial 461	java/util/Timer:<init>	(Ljava/lang/String;)V
/*     */     //   319: putfield 463	com/google/vr/sdk/base/sensors/NfcSensor:nfcDisconnectTimer	Ljava/util/Timer;
/*     */     //   322: aload_0
/*     */     //   323: getfield 463	com/google/vr/sdk/base/sensors/NfcSensor:nfcDisconnectTimer	Ljava/util/Timer;
/*     */     //   326: new 13	com/google/vr/sdk/base/sensors/NfcSensor$2
/*     */     //   329: dup
/*     */     //   330: aload_0
/*     */     //   331: invokespecial 464	com/google/vr/sdk/base/sensors/NfcSensor$2:<init>	(Lcom/google/vr/sdk/base/sensors/NfcSensor;)V
/*     */     //   334: ldc2_w 30
/*     */     //   337: ldc2_w 30
/*     */     //   340: invokevirtual 468	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
/*     */     //   343: aload_2
/*     */     //   344: monitorexit
/*     */     //   345: goto +10 -> 355
/*     */     //   348: astore 12
/*     */     //   350: aload_2
/*     */     //   351: monitorexit
/*     */     //   352: aload 12
/*     */     //   354: athrow
/*     */     //   355: return
/*     */     // Line number table:
/*     */     //   Java source line #408	-> byte code offset #0
/*     */     //   Java source line #409	-> byte code offset #4
/*     */     //   Java source line #412	-> byte code offset #5
/*     */     //   Java source line #413	-> byte code offset #12
/*     */     //   Java source line #414	-> byte code offset #17
/*     */     //   Java source line #415	-> byte code offset #23
/*     */     //   Java source line #418	-> byte code offset #29
/*     */     //   Java source line #422	-> byte code offset #33
/*     */     //   Java source line #423	-> byte code offset #38
/*     */     //   Java source line #425	-> byte code offset #46
/*     */     //   Java source line #428	-> byte code offset #53
/*     */     //   Java source line #429	-> byte code offset #58
/*     */     //   Java source line #431	-> byte code offset #62
/*     */     //   Java source line #434	-> byte code offset #65
/*     */     //   Java source line #436	-> byte code offset #68
/*     */     //   Java source line #438	-> byte code offset #73
/*     */     //   Java source line #439	-> byte code offset #82
/*     */     //   Java source line #440	-> byte code offset #88
/*     */     //   Java source line #443	-> byte code offset #115
/*     */     //   Java source line #444	-> byte code offset #125
/*     */     //   Java source line #451	-> byte code offset #129
/*     */     //   Java source line #452	-> byte code offset #136
/*     */     //   Java source line #462	-> byte code offset #145
/*     */     //   Java source line #453	-> byte code offset #148
/*     */     //   Java source line #454	-> byte code offset #150
/*     */     //   Java source line #457	-> byte code offset #189
/*     */     //   Java source line #458	-> byte code offset #199
/*     */     //   Java source line #461	-> byte code offset #203
/*     */     //   Java source line #465	-> byte code offset #206
/*     */     //   Java source line #468	-> byte code offset #216
/*     */     //   Java source line #469	-> byte code offset #228
/*     */     //   Java source line #470	-> byte code offset #236
/*     */     //   Java source line #471	-> byte code offset #269
/*     */     //   Java source line #472	-> byte code offset #273
/*     */     //   Java source line #471	-> byte code offset #276
/*     */     //   Java source line #473	-> byte code offset #279
/*     */     //   Java source line #474	-> byte code offset #282
/*     */     //   Java source line #478	-> byte code offset #296
/*     */     //   Java source line #479	-> byte code offset #303
/*     */     //   Java source line #480	-> byte code offset #308
/*     */     //   Java source line #481	-> byte code offset #322
/*     */     //   Java source line #497	-> byte code offset #343
/*     */     //   Java source line #498	-> byte code offset #355
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	356	0	this	NfcSensor
/*     */     //   0	356	1	nfcTag	Tag
/*     */     //   17	326	3	previousTag	Tag
/*     */     //   23	320	4	previousNdef	Ndef
/*     */     //   29	314	5	previousTagWasCardboard	boolean
/*     */     //   68	275	6	isSameTag	boolean
/*     */     //   82	47	7	tagId1	byte[]
/*     */     //   145	3	7	nfcTagContents	NdefMessage
/*     */     //   206	137	7	nfcTagContents	NdefMessage
/*     */     //   88	41	8	tagId2	byte[]
/*     */     //   150	56	8	e	Exception
/*     */     //   269	10	10	listener	ListenerHelper
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   129	145	148	java/lang/Exception
/*     */     //   236	285	288	finally
/*     */     //   288	293	288	finally
/*     */     //   12	64	348	finally
/*     */     //   65	205	348	finally
/*     */     //   206	345	348	finally
/*     */     //   348	352	348	finally
/*     */   }
/*     */   
/*     */   private void closeCurrentNfcTag()
/*     */   {
/* 502 */     if (this.nfcDisconnectTimer != null) {
/* 503 */       this.nfcDisconnectTimer.cancel();
/*     */     }
/*     */     
/* 506 */     if (this.currentNdef == null) {
/* 507 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 512 */       this.currentNdef.close();
/*     */     } catch (IOException e) {
/* 514 */       Log.w("NfcSensor", e.toString());
/*     */     }
/*     */     
/* 517 */     this.currentTag = null;
/* 518 */     this.currentNdef = null;
/* 519 */     this.currentTagIsCardboard = false;
/*     */   }
/*     */   
/*     */   private void sendDisconnectionEvent() {
/* 523 */     synchronized (this.listeners) {
/* 524 */       for (ListenerHelper listener : this.listeners) {
/* 525 */         listener.onRemovedFromGvrViewer();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isCardboardNdefMessage(NdefMessage message) {
/* 531 */     if (message == null) {
/* 532 */       return false;
/*     */     }
/*     */     
/* 535 */     for (NdefRecord record : message.getRecords()) {
/* 536 */       if (isCardboardNdefRecord(record)) {
/* 537 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 541 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isCardboardNdefRecord(NdefRecord record) {
/* 545 */     if (record == null) {
/* 546 */       return false;
/*     */     }
/*     */     
/* 549 */     Uri uri = record.toUri();
/* 550 */     return (uri != null) && (GvrViewerParams.isGvrUri(uri));
/*     */   }
/*     */   
/*     */ 
/*     */   private static class ListenerHelper
/*     */     implements NfcSensor.OnCardboardNfcListener
/*     */   {
/*     */     private NfcSensor.OnCardboardNfcListener listener;
/*     */     private Handler handler;
/*     */     
/*     */     public ListenerHelper(NfcSensor.OnCardboardNfcListener listener, Handler handler)
/*     */     {
/* 562 */       this.listener = listener;
/* 563 */       this.handler = handler;
/*     */     }
/*     */     
/*     */     public NfcSensor.OnCardboardNfcListener getListener() {
/* 567 */       return this.listener;
/*     */     }
/*     */     
/*     */     public void onInsertedIntoGvrViewer(final GvrViewerParams viewerParams)
/*     */     {
/* 572 */       this.handler.post(new Runnable()
/*     */       {
/*     */         public void run() {
/* 575 */           NfcSensor.ListenerHelper.this.listener.onInsertedIntoGvrViewer(viewerParams);
/*     */         }
/*     */       });
/*     */     }
/*     */     
/*     */     public void onRemovedFromGvrViewer()
/*     */     {
/* 582 */       this.handler.post(new Runnable()
/*     */       {
/*     */         public void run() {
/* 585 */           NfcSensor.ListenerHelper.this.listener.onRemovedFromGvrViewer();
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract interface OnCardboardNfcListener
/*     */   {
/*     */     public abstract void onInsertedIntoGvrViewer(GvrViewerParams paramGvrViewerParams);
/*     */     
/*     */     public abstract void onRemovedFromGvrViewer();
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\sensors\NfcSensor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */