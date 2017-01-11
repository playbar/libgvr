/*     */ package com.google.vr.cardboard;
/*     */ 
/*     */ import android.content.ContentProviderClient;
/*     */ import android.content.ContentValues;
/*     */ import android.database.Cursor;
/*     */ import android.database.CursorIndexOutOfBoundsException;
/*     */ import android.net.Uri;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Base64;
/*     */ import android.util.Log;
/*     */ import com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams;
/*     */ import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
/*     */ import com.google.protobuf.nano.MessageNano;
/*     */ import com.google.vr.ndk.base.SdkConfigurationReader;
/*     */ import com.google.vr.vrcore.nano.SdkConfiguration.SdkConfigurationRequest;
/*     */ import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams;
/*     */ import com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams;
/*     */ import com.google.vrtoolkit.cardboard.proto.nano.Preferences.UserPrefs;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContentProviderVrParamsProvider
/*     */   implements VrParamsProvider
/*     */ {
/*  29 */   private static final String TAG = ContentProviderVrParamsProvider.class.getSimpleName();
/*     */   
/*     */ 
/*     */   private final ContentProviderClient client;
/*     */   
/*     */ 
/*     */   private final Uri deviceParamsSettingUri;
/*     */   
/*     */ 
/*     */   private final Uri userPrefsUri;
/*     */   
/*     */   private final Uri phoneParamsSettingUri;
/*     */   
/*     */   private final Uri sdkConfigurationParamsSettingUri;
/*     */   
/*     */ 
/*     */   public ContentProviderVrParamsProvider(ContentProviderClient paramContentProviderClient, String paramString)
/*     */   {
/*  47 */     if (paramContentProviderClient == null) {
/*  48 */       throw new IllegalArgumentException("ContentProviderClient must not be null");
/*     */     }
/*  50 */     if ((paramString == null) || (paramString.isEmpty())) {
/*  51 */       throw new IllegalArgumentException("Authority key must be non-null and non-empty");
/*     */     }
/*  53 */     this.client = paramContentProviderClient;
/*     */     
/*  55 */     this.deviceParamsSettingUri = VrSettingsProviderContract.createUri(paramString, "device_params");
/*     */     
/*     */ 
/*  58 */     this.userPrefsUri = VrSettingsProviderContract.createUri(paramString, "user_prefs");
/*     */     
/*     */ 
/*  61 */     this.phoneParamsSettingUri = VrSettingsProviderContract.createUri(paramString, "phone_params");
/*     */     
/*     */ 
/*  64 */     this.sdkConfigurationParamsSettingUri = VrSettingsProviderContract.createUri(paramString, "sdk_configuration_params");
/*     */   }
/*     */   
/*     */ 
/*     */   public CardboardDevice.DeviceParams readDeviceParams()
/*     */   {
/*  70 */     return (CardboardDevice.DeviceParams)readParams(new CardboardDevice.DeviceParams(), this.deviceParamsSettingUri, null);
/*     */   }
/*     */   
/*     */   public boolean writeDeviceParams(CardboardDevice.DeviceParams paramDeviceParams)
/*     */   {
/*  75 */     return writeParams(paramDeviceParams, this.deviceParamsSettingUri);
/*     */   }
/*     */   
/*     */   public Phone.PhoneParams readPhoneParams()
/*     */   {
/*  80 */     return (Phone.PhoneParams)readParams(new Phone.PhoneParams(), this.phoneParamsSettingUri, null);
/*     */   }
/*     */   
/*     */   public Vr.VREvent.SdkConfigurationParams readSdkConfigurationParams(SdkConfiguration.SdkConfigurationRequest paramSdkConfigurationRequest)
/*     */   {
/*  85 */     String str = Base64.encodeToString(MessageNano.toByteArray(paramSdkConfigurationRequest), 0);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  91 */     return (Vr.VREvent.SdkConfigurationParams)readParams(SdkConfigurationReader.DEFAULT_PARAMS, this.sdkConfigurationParamsSettingUri, str);
/*     */   }
/*     */   
/*     */ 
/*     */   public Preferences.UserPrefs readUserPrefs()
/*     */   {
/*  97 */     return (Preferences.UserPrefs)readParams(new Preferences.UserPrefs(), this.userPrefsUri, null);
/*     */   }
/*     */   
/*     */   public boolean updateUserPrefs(Preferences.UserPrefs paramUserPrefs)
/*     */   {
/* 102 */     return writeParams(paramUserPrefs, this.userPrefsUri);
/*     */   }
/*     */   
/*     */   public void close()
/*     */   {
/* 107 */     this.client.release();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private <T extends MessageNano> T readParams(T paramT, Uri paramUri, String paramString)
/*     */   {
/* 119 */     Cursor localCursor = null;
/*     */     try
/*     */     {
/* 122 */       if (((localCursor = this.client.query(paramUri, null, paramString, null, null)) != null) && (localCursor.moveToFirst()))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 127 */         if ((localObject1 = localCursor.getBlob(0)) == null) {
/* 128 */           return null;
/*     */         }
/* 130 */         return MessageNano.mergeFrom(paramT, (byte[])localObject1);
/*     */       }
/* 132 */       Object localObject1 = String.valueOf(paramUri);Log.e(TAG, 50 + String.valueOf(localObject1).length() + "Invalid params result from ContentProvider query: " + (String)localObject1);
/* 133 */       return null;
/*     */ 
/*     */     }
/*     */     catch (InvalidProtocolBufferNanoException|CursorIndexOutOfBoundsException|IllegalArgumentException|RemoteException localInvalidProtocolBufferNanoException)
/*     */     {
/* 138 */       Log.e(TAG, "Error reading params from ContentProvider", localInvalidProtocolBufferNanoException);
/* 139 */       return null;
/*     */     } finally {
/* 141 */       if (localCursor != null) {
/* 142 */         localCursor.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean writeParams(MessageNano paramMessageNano, Uri paramUri)
/*     */   {
/*     */     try
/*     */     {
/*     */       int i;
/*     */       
/*     */ 
/* 157 */       if (paramMessageNano == null) {
/* 158 */         i = this.client.delete(paramUri, null, null);
/*     */       } else {
/* 160 */         ContentValues localContentValues = new ContentValues();
/* 161 */         byte[] arrayOfByte = MessageNano.toByteArray(paramMessageNano);
/* 162 */         localContentValues.put("value", arrayOfByte);
/* 163 */         i = this.client.update(paramUri, localContentValues, null, null);
/*     */       }
/* 165 */       return i > 0;
/*     */     } catch (RemoteException localRemoteException) {
/* 167 */       Log.e(TAG, "Failed to write params to ContentProvider", localRemoteException);
/* 168 */       return false;
/*     */     }
/*     */     catch (SecurityException localSecurityException) {
/* 171 */       Log.e(TAG, "Insufficient permissions to write params to ContentProvider", localSecurityException); }
/* 172 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\ContentProviderVrParamsProvider.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */