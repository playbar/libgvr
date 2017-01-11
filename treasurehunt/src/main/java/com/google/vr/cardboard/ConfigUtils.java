/*     */ package com.google.vr.cardboard;
/*     */ 
/*     */ import android.net.Uri;
/*     */ import android.os.Environment;
/*     */ import android.util.Base64;
/*     */ import android.util.Log;
/*     */ import com.google.protobuf.nano.MessageNano;
/*     */ import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams;
/*     */ import com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
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
/*     */ public class ConfigUtils
/*     */ {
/*     */   private static final boolean DEBUG = false;
/*  46 */   private static final String TAG = ConfigUtils.class.getSimpleName();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final int CARDBOARD_PHONE_PARAMS_STREAM_SENTINEL = 779508118;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final String URI_KEY_PARAMS = "p";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final String CARDBOARD_CONFIG_FOLDER = "Cardboard";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final String CARDBOARD_DEVICE_PARAMS_FILE = "current_device_params";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final String CARDBOARD_PHONE_PARAMS_FILE = "phone_params";
/*     */   
/*     */ 
/*     */ 
/*     */   private static final int CARDBOARD_DEVICE_PARAMS_STREAM_SENTINEL = 894990891;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static CardboardDevice.DeviceParams readDeviceParamsFromExternalStorage()
/*     */   {
/*     */     CardboardDevice.DeviceParams localDeviceParams;
/*     */     
/*     */ 
/*     */ 
/*  86 */     return localDeviceParams = (CardboardDevice.DeviceParams)readFromExternalStorage(CardboardDevice.DeviceParams.class, "current_device_params", 894990891, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static CardboardDevice.DeviceParams readDeviceParamsFromUri(Uri paramUri)
/*     */   {
/*     */     String str;
/*     */     
/*     */ 
/*     */ 
/*  98 */     if ((str = paramUri.getQueryParameter("p")) == null) {
/*  99 */       Log.w(TAG, "No Cardboard parameters in URI.");
/* 100 */       return null;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 105 */       byte[] arrayOfByte = Base64.decode(str, 11);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 111 */       return localObject = (CardboardDevice.DeviceParams)MessageNano.mergeFrom(new CardboardDevice.DeviceParams(), arrayOfByte);
/*     */     } catch (Exception localException) {
/* 113 */       Object localObject = String.valueOf(localException);Log.w(TAG, 46 + String.valueOf(localObject).length() + "Parsing cardboard parameters from URI failed: " + (String)localObject); }
/* 114 */     return null;
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
/*     */   public static Phone.PhoneParams readPhoneParamsFromExternalStorage()
/*     */   {
/*     */     Phone.PhoneParams localPhoneParams;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 137 */     return localPhoneParams = (Phone.PhoneParams)readFromExternalStorage(Phone.PhoneParams.class, "phone_params", 779508118, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean writeDeviceParamsToExternalStorage(CardboardDevice.DeviceParams paramDeviceParams)
/*     */   {
/*     */     boolean bool;
/*     */     
/*     */ 
/*     */ 
/* 149 */     if (!(bool = writeToExternalStorage(paramDeviceParams, "current_device_params", 894990891))) {
/* 150 */       Log.e(TAG, "Could not write Cardboard parameters to external storage.");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 156 */     return bool;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean writePhoneParamsToExternalStorage(Phone.PhoneParams paramPhoneParams)
/*     */   {
/* 167 */     if ((paramPhoneParams.dEPRECATEDGyroBias != null) && (paramPhoneParams.dEPRECATEDGyroBias.length == 0))
/*     */     {
/* 169 */       (paramPhoneParams = paramPhoneParams.clone()).dEPRECATEDGyroBias = new float[] { 0.0F, 0.0F, 0.0F };
/*     */     }
/*     */     
/*     */     boolean bool;
/*     */     
/* 174 */     if (!(bool = writeToExternalStorage(paramPhoneParams, "phone_params", 779508118))) {
/* 175 */       Log.e(TAG, "Could not write Phone parameters to external storage.");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 181 */     return bool;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean removeDeviceParamsFromExternalStorage()
/*     */   {
/* 190 */     boolean bool = false;
/*     */     try {
/*     */       File localFile;
/* 193 */       bool = (localFile = getConfigFile("current_device_params")).exists() ? localFile.delete() : true;
/*     */     } catch (IllegalStateException localIllegalStateException) {
/* 195 */       String str = String.valueOf(localIllegalStateException);Log.w(TAG, 34 + String.valueOf(str).length() + "Error clearing device parameters: " + str);
/*     */     }
/* 197 */     if (!bool) {
/* 198 */       Log.e(TAG, "Could not clear Cardboard parameters from external storage.");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 204 */     return bool;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static File getConfigFile(String paramString)
/*     */     throws IllegalStateException
/*     */   {
/*     */     File localFile;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 221 */     if (!(localFile = new File(Environment.getExternalStorageDirectory(), "Cardboard")).exists()) {
/* 222 */       localFile.mkdirs();
/* 223 */     } else if (!localFile.isDirectory()) {
/* 224 */       String str = String.valueOf(localFile);throw new IllegalStateException(61 + String.valueOf(str).length() + str + " already exists as a file, but is expected to be a directory.");
/*     */     }
/*     */     
/*     */ 
/* 228 */     return new File(localFile, paramString);
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
/*     */   private static <T extends MessageNano> T readFromExternalStorage(Class<T> paramClass, String paramString, int paramInt, boolean paramBoolean)
/*     */   {
/*     */     try
/*     */     {
/* 245 */       BufferedInputStream localBufferedInputStream = null;
/*     */       Object localObject1;
/* 247 */       try { localBufferedInputStream = new BufferedInputStream(new FileInputStream(getConfigFile(paramString)));
/* 248 */         localObject1 = readFromInputStream(paramClass, localBufferedInputStream, paramInt);
/*     */         
/*     */         try
/*     */         {
/* 252 */           localBufferedInputStream.close();
/*     */         }
/*     */         catch (IOException localIOException1) {}
/* 248 */         return (T)localObject1;
/*     */       } finally {
/* 250 */         if (localBufferedInputStream != null) {
/*     */           try {
/* 252 */             localBufferedInputStream.close();
/*     */           }
/*     */           catch (IOException localIOException2) {}
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 265 */       return null;
/*     */     }
/*     */     catch (FileNotFoundException localFileNotFoundException)
/*     */     {
/* 259 */       if (paramBoolean) {
/* 260 */         localObject1 = String.valueOf(localFileNotFoundException);Log.d(TAG, 39 + String.valueOf(localObject1).length() + "Parameters file not found for reading: " + (String)localObject1);
/*     */       }
/*     */     } catch (IllegalStateException localIllegalStateException) {
/* 263 */       localObject1 = String.valueOf(localIllegalStateException);Log.w(TAG, 26 + String.valueOf(localObject1).length() + "Error reading parameters: " + (String)localObject1);
/*     */     }
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   private static <T extends MessageNano> T readFromInputStream(Class<T> arg0, InputStream arg1, int arg2)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnonnull +5 -> 6
/*     */     //   4: aconst_null
/*     */     //   5: areturn
/*     */     //   6: bipush 8
/*     */     //   8: invokestatic 100	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
/*     */     //   11: astore_3
/*     */     //   12: aload_1
/*     */     //   13: aload_3
/*     */     //   14: invokevirtual 101	java/nio/ByteBuffer:array	()[B
/*     */     //   17: iconst_0
/*     */     //   18: aload_3
/*     */     //   19: invokevirtual 101	java/nio/ByteBuffer:array	()[B
/*     */     //   22: arraylength
/*     */     //   23: invokevirtual 84	java/io/InputStream:read	([BII)I
/*     */     //   26: iconst_m1
/*     */     //   27: if_icmpne +14 -> 41
/*     */     //   30: getstatic 55	com/google/vr/cardboard/ConfigUtils:TAG	Ljava/lang/String;
/*     */     //   33: ldc 12
/*     */     //   35: invokestatic 61	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   38: pop
/*     */     //   39: aconst_null
/*     */     //   40: areturn
/*     */     //   41: aload_3
/*     */     //   42: invokevirtual 102	java/nio/ByteBuffer:getInt	()I
/*     */     //   45: istore 4
/*     */     //   47: aload_3
/*     */     //   48: invokevirtual 102	java/nio/ByteBuffer:getInt	()I
/*     */     //   51: istore 5
/*     */     //   53: iload 4
/*     */     //   55: iload_2
/*     */     //   56: if_icmpeq +14 -> 70
/*     */     //   59: getstatic 55	com/google/vr/cardboard/ConfigUtils:TAG	Ljava/lang/String;
/*     */     //   62: ldc 13
/*     */     //   64: invokestatic 61	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   67: pop
/*     */     //   68: aconst_null
/*     */     //   69: areturn
/*     */     //   70: iload 5
/*     */     //   72: newarray <illegal type>
/*     */     //   74: astore 6
/*     */     //   76: aload_1
/*     */     //   77: aload 6
/*     */     //   79: iconst_0
/*     */     //   80: iload 5
/*     */     //   82: invokevirtual 84	java/io/InputStream:read	([BII)I
/*     */     //   85: iconst_m1
/*     */     //   86: if_icmpne +14 -> 100
/*     */     //   89: getstatic 55	com/google/vr/cardboard/ConfigUtils:TAG	Ljava/lang/String;
/*     */     //   92: ldc 12
/*     */     //   94: invokestatic 61	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   97: pop
/*     */     //   98: aconst_null
/*     */     //   99: areturn
/*     */     //   100: aload_0
/*     */     //   101: invokevirtual 88	java/lang/Class:newInstance	()Ljava/lang/Object;
/*     */     //   104: checkcast 30	com/google/protobuf/nano/MessageNano
/*     */     //   107: aload 6
/*     */     //   109: invokestatic 64	com/google/protobuf/nano/MessageNano:mergeFrom	(Lcom/google/protobuf/nano/MessageNano;[B)Lcom/google/protobuf/nano/MessageNano;
/*     */     //   112: areturn
/*     */     //   113: astore_3
/*     */     //   114: getstatic 55	com/google/vr/cardboard/ConfigUtils:TAG	Ljava/lang/String;
/*     */     //   117: ldc 14
/*     */     //   119: aload_3
/*     */     //   120: invokevirtual 63	com/google/protobuf/nano/InvalidProtocolBufferNanoException:toString	()Ljava/lang/String;
/*     */     //   123: invokestatic 96	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   126: dup
/*     */     //   127: invokevirtual 95	java/lang/String:length	()I
/*     */     //   130: ifeq +9 -> 139
/*     */     //   133: invokevirtual 94	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   136: goto +12 -> 148
/*     */     //   139: pop
/*     */     //   140: new 51	java/lang/String
/*     */     //   143: dup_x1
/*     */     //   144: swap
/*     */     //   145: invokespecial 93	java/lang/String:<init>	(Ljava/lang/String;)V
/*     */     //   148: invokestatic 62	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   151: pop
/*     */     //   152: goto +126 -> 278
/*     */     //   155: astore_3
/*     */     //   156: getstatic 55	com/google/vr/cardboard/ConfigUtils:TAG	Ljava/lang/String;
/*     */     //   159: ldc 15
/*     */     //   161: aload_3
/*     */     //   162: invokevirtual 82	java/io/IOException:toString	()Ljava/lang/String;
/*     */     //   165: invokestatic 96	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   168: dup
/*     */     //   169: invokevirtual 95	java/lang/String:length	()I
/*     */     //   172: ifeq +9 -> 181
/*     */     //   175: invokevirtual 94	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   178: goto +12 -> 190
/*     */     //   181: pop
/*     */     //   182: new 51	java/lang/String
/*     */     //   185: dup_x1
/*     */     //   186: swap
/*     */     //   187: invokespecial 93	java/lang/String:<init>	(Ljava/lang/String;)V
/*     */     //   190: invokestatic 62	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   193: pop
/*     */     //   194: goto +84 -> 278
/*     */     //   197: astore_3
/*     */     //   198: getstatic 55	com/google/vr/cardboard/ConfigUtils:TAG	Ljava/lang/String;
/*     */     //   201: ldc 11
/*     */     //   203: aload_3
/*     */     //   204: invokevirtual 91	java/lang/InstantiationException:toString	()Ljava/lang/String;
/*     */     //   207: invokestatic 96	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   210: dup
/*     */     //   211: invokevirtual 95	java/lang/String:length	()I
/*     */     //   214: ifeq +9 -> 223
/*     */     //   217: invokevirtual 94	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   220: goto +12 -> 232
/*     */     //   223: pop
/*     */     //   224: new 51	java/lang/String
/*     */     //   227: dup_x1
/*     */     //   228: swap
/*     */     //   229: invokespecial 93	java/lang/String:<init>	(Ljava/lang/String;)V
/*     */     //   232: invokestatic 62	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   235: pop
/*     */     //   236: goto +42 -> 278
/*     */     //   239: astore_3
/*     */     //   240: getstatic 55	com/google/vr/cardboard/ConfigUtils:TAG	Ljava/lang/String;
/*     */     //   243: ldc 9
/*     */     //   245: aload_3
/*     */     //   246: invokevirtual 89	java/lang/IllegalAccessException:toString	()Ljava/lang/String;
/*     */     //   249: invokestatic 96	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   252: dup
/*     */     //   253: invokevirtual 95	java/lang/String:length	()I
/*     */     //   256: ifeq +9 -> 265
/*     */     //   259: invokevirtual 94	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   262: goto +12 -> 274
/*     */     //   265: pop
/*     */     //   266: new 51	java/lang/String
/*     */     //   269: dup_x1
/*     */     //   270: swap
/*     */     //   271: invokespecial 93	java/lang/String:<init>	(Ljava/lang/String;)V
/*     */     //   274: invokestatic 62	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   277: pop
/*     */     //   278: aconst_null
/*     */     //   279: areturn
/*     */     // Line number table:
/*     */     //   Java source line #280	-> byte code offset #0
/*     */     //   Java source line #281	-> byte code offset #4
/*     */     //   Java source line #287	-> byte code offset #6
/*     */     //   Java source line #288	-> byte code offset #12
/*     */     //   Java source line #289	-> byte code offset #30
/*     */     //   Java source line #290	-> byte code offset #39
/*     */     //   Java source line #292	-> byte code offset #41
/*     */     //   Java source line #293	-> byte code offset #47
/*     */     //   Java source line #294	-> byte code offset #53
/*     */     //   Java source line #295	-> byte code offset #59
/*     */     //   Java source line #296	-> byte code offset #68
/*     */     //   Java source line #298	-> byte code offset #70
/*     */     //   Java source line #299	-> byte code offset #76
/*     */     //   Java source line #300	-> byte code offset #89
/*     */     //   Java source line #301	-> byte code offset #98
/*     */     //   Java source line #303	-> byte code offset #100
/*     */     //   Java source line #304	-> byte code offset #113
/*     */     //   Java source line #305	-> byte code offset #114
/*     */     //   Java source line #312	-> byte code offset #152
/*     */     //   Java source line #306	-> byte code offset #155
/*     */     //   Java source line #307	-> byte code offset #156
/*     */     //   Java source line #312	-> byte code offset #194
/*     */     //   Java source line #308	-> byte code offset #197
/*     */     //   Java source line #309	-> byte code offset #198
/*     */     //   Java source line #312	-> byte code offset #236
/*     */     //   Java source line #310	-> byte code offset #239
/*     */     //   Java source line #311	-> byte code offset #240
/*     */     //   Java source line #313	-> byte code offset #278
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   6	40	113	com/google/protobuf/nano/InvalidProtocolBufferNanoException
/*     */     //   41	69	113	com/google/protobuf/nano/InvalidProtocolBufferNanoException
/*     */     //   70	99	113	com/google/protobuf/nano/InvalidProtocolBufferNanoException
/*     */     //   100	112	113	com/google/protobuf/nano/InvalidProtocolBufferNanoException
/*     */     //   6	40	155	java/io/IOException
/*     */     //   41	69	155	java/io/IOException
/*     */     //   70	99	155	java/io/IOException
/*     */     //   100	112	155	java/io/IOException
/*     */     //   6	40	197	java/lang/InstantiationException
/*     */     //   41	69	197	java/lang/InstantiationException
/*     */     //   70	99	197	java/lang/InstantiationException
/*     */     //   100	112	197	java/lang/InstantiationException
/*     */     //   6	40	239	java/lang/IllegalAccessException
/*     */     //   41	69	239	java/lang/IllegalAccessException
/*     */     //   70	99	239	java/lang/IllegalAccessException
/*     */     //   100	112	239	java/lang/IllegalAccessException
/*     */   }
/*     */   
/*     */   private static boolean writeToExternalStorage(MessageNano paramMessageNano, String paramString, int paramInt)
/*     */   {
/* 325 */     bool = false;
/* 326 */     BufferedOutputStream localBufferedOutputStream = null;
/*     */     try {
/* 328 */       localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(getConfigFile(paramString)));
/* 329 */       bool = writeToOutputStream(paramMessageNano, localBufferedOutputStream, paramInt);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       try
/*     */       {
/* 337 */         localBufferedOutputStream.close();
/*     */       }
/*     */       catch (IOException localIOException1) {}
/*     */       
/*     */       String str;
/*     */       
/* 343 */       return bool;
/*     */     }
/*     */     catch (FileNotFoundException localFileNotFoundException)
/*     */     {
/* 331 */       str = String.valueOf(localFileNotFoundException);Log.e(TAG, 39 + String.valueOf(str).length() + "Parameters file not found for writing: " + str);
/*     */     } catch (IllegalStateException localIllegalStateException) {
/* 333 */       str = String.valueOf(localIllegalStateException);Log.w(TAG, 26 + String.valueOf(str).length() + "Error writing parameters: " + str);
/*     */     } finally {
/* 335 */       if (localBufferedOutputStream != null) {
/*     */         try {
/* 337 */           localBufferedOutputStream.close();
/*     */         }
/*     */         catch (IOException localIOException4) {}
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   private static boolean writeToOutputStream(MessageNano arg0, OutputStream arg1, int arg2)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokestatic 65	com/google/protobuf/nano/MessageNano:toByteArray	(Lcom/google/protobuf/nano/MessageNano;)[B
/*     */     //   4: astore_3
/*     */     //   5: bipush 8
/*     */     //   7: invokestatic 100	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
/*     */     //   10: dup
/*     */     //   11: astore 4
/*     */     //   13: iload_2
/*     */     //   14: invokevirtual 103	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
/*     */     //   17: pop
/*     */     //   18: aload 4
/*     */     //   20: aload_3
/*     */     //   21: arraylength
/*     */     //   22: invokevirtual 103	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
/*     */     //   25: pop
/*     */     //   26: aload_1
/*     */     //   27: aload 4
/*     */     //   29: invokevirtual 101	java/nio/ByteBuffer:array	()[B
/*     */     //   32: invokevirtual 86	java/io/OutputStream:write	([B)V
/*     */     //   35: aload_1
/*     */     //   36: aload_3
/*     */     //   37: invokevirtual 86	java/io/OutputStream:write	([B)V
/*     */     //   40: iconst_1
/*     */     //   41: ireturn
/*     */     //   42: astore_3
/*     */     //   43: getstatic 55	com/google/vr/cardboard/ConfigUtils:TAG	Ljava/lang/String;
/*     */     //   46: ldc 16
/*     */     //   48: aload_3
/*     */     //   49: invokevirtual 82	java/io/IOException:toString	()Ljava/lang/String;
/*     */     //   52: invokestatic 96	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   55: dup
/*     */     //   56: invokevirtual 95	java/lang/String:length	()I
/*     */     //   59: ifeq +9 -> 68
/*     */     //   62: invokevirtual 94	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   65: goto +12 -> 77
/*     */     //   68: pop
/*     */     //   69: new 51	java/lang/String
/*     */     //   72: dup_x1
/*     */     //   73: swap
/*     */     //   74: invokespecial 93	java/lang/String:<init>	(Ljava/lang/String;)V
/*     */     //   77: invokestatic 62	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   80: pop
/*     */     //   81: iconst_0
/*     */     //   82: ireturn
/*     */     // Line number table:
/*     */     //   Java source line #361	-> byte code offset #0
/*     */     //   Java source line #362	-> byte code offset #5
/*     */     //   Java source line #363	-> byte code offset #11
/*     */     //   Java source line #364	-> byte code offset #18
/*     */     //   Java source line #365	-> byte code offset #26
/*     */     //   Java source line #366	-> byte code offset #35
/*     */     //   Java source line #367	-> byte code offset #40
/*     */     //   Java source line #368	-> byte code offset #42
/*     */     //   Java source line #369	-> byte code offset #43
/*     */     //   Java source line #370	-> byte code offset #81
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   0	41	42	java/io/IOException
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\ConfigUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */