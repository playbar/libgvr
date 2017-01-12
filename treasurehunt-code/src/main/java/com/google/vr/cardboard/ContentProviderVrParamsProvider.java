//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.cardboard;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Base64;
import android.util.Log;
import com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.cardboard.VrSettingsProviderContract;
import com.google.vr.ndk.base.SdkConfigurationReader;
import com.google.vr.vrcore.nano.SdkConfiguration.SdkConfigurationRequest;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams;
import com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams;
import com.google.vrtoolkit.cardboard.proto.nano.Preferences.UserPrefs;

public class ContentProviderVrParamsProvider implements VrParamsProvider {
  private static final String TAG = ContentProviderVrParamsProvider.class.getSimpleName();
  private final ContentProviderClient client;
  private final Uri deviceParamsSettingUri;
  private final Uri userPrefsUri;
  private final Uri phoneParamsSettingUri;
  private final Uri sdkConfigurationParamsSettingUri;

  public ContentProviderVrParamsProvider(ContentProviderClient var1, String var2) {
    if(var1 == null) {
      throw new IllegalArgumentException("ContentProviderClient must not be null");
    } else if(var2 != null && !var2.isEmpty()) {
      this.client = var1;
      this.deviceParamsSettingUri = VrSettingsProviderContract.createUri(var2, "device_params");
      this.userPrefsUri = VrSettingsProviderContract.createUri(var2, "user_prefs");
      this.phoneParamsSettingUri = VrSettingsProviderContract.createUri(var2, "phone_params");
      this.sdkConfigurationParamsSettingUri = VrSettingsProviderContract.createUri(var2, "sdk_configuration_params");
    } else {
      throw new IllegalArgumentException("Authority key must be non-null and non-empty");
    }
  }

  public DeviceParams readDeviceParams() {
    return (DeviceParams)this.readParams(new DeviceParams(), this.deviceParamsSettingUri, (String)null);
  }

  public boolean writeDeviceParams(DeviceParams var1) {
    return this.writeParams(var1, this.deviceParamsSettingUri);
  }

  public PhoneParams readPhoneParams() {
    return (PhoneParams)this.readParams(new PhoneParams(), this.phoneParamsSettingUri, (String)null);
  }

  public SdkConfigurationParams readSdkConfigurationParams(SdkConfigurationRequest var1) {
    String var2 = Base64.encodeToString(MessageNano.toByteArray(var1), 0);
    return (SdkConfigurationParams)this.readParams(SdkConfigurationReader.DEFAULT_PARAMS, this.sdkConfigurationParamsSettingUri, var2);
  }

  public UserPrefs readUserPrefs() {
    return (UserPrefs)this.readParams(new UserPrefs(), this.userPrefsUri, (String)null);
  }

  public boolean updateUserPrefs(UserPrefs var1) {
    return this.writeParams(var1, this.userPrefsUri);
  }

  public void close() {
    this.client.release();
  }

  private <T extends MessageNano> T readParams(T var1, Uri var2, String var3)
  {
    Cursor var4 = null;

    MessageNano var6;
    try {
      if((var4 = this.client.query(var2, (String[])null, var3, (String[])null, (String)null)) == null || !var4.moveToFirst()) {
        String var10000 = TAG;
        String var12 = String.valueOf(var2);
        Log.e(var10000, (new StringBuilder(50 + String.valueOf(var12).length())).append("Invalid params result from ContentProvider query: ").append(var12).toString());
        return null;
      }

      byte[] var5;
      if((var5 = var4.getBlob(0)) == null) {
        return null;
      }

      var6 = MessageNano.mergeFrom(var1, var5);
    } catch (CursorIndexOutOfBoundsException | IllegalArgumentException | RemoteException | InvalidProtocolBufferNanoException var10) {
      Log.e(TAG, "Error reading params from ContentProvider", var10);
      return null;
    } finally {
      if(var4 != null) {
        var4.close();
      }

    }
    return (T)var6;
  }

  private boolean writeParams(MessageNano var1, Uri var2) {
    try {
      int var3;
      if(var1 == null) {
        var3 = this.client.delete(var2, (String)null, (String[])null);
      } else {
        ContentValues var4 = new ContentValues();
        byte[] var5 = MessageNano.toByteArray(var1);
        var4.put("value", var5);
        var3 = this.client.update(var2, var4, (String)null, (String[])null);
      }

      return var3 > 0;
    } catch (RemoteException var6) {
      Log.e(TAG, "Failed to write params to ContentProvider", var6);
      return false;
    } catch (SecurityException var7) {
      Log.e(TAG, "Insufficient permissions to write params to ContentProvider", var7);
      return false;
    }
  }
}
