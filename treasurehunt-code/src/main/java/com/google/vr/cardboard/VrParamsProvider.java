package com.google.vr.cardboard;

import com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams;
import com.google.vr.vrcore.nano.SdkConfiguration.SdkConfigurationRequest;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams;
import com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams;
import com.google.vrtoolkit.cardboard.proto.nano.Preferences.UserPrefs;

public abstract interface VrParamsProvider
{
  public abstract DeviceParams readDeviceParams();
  
  public abstract boolean writeDeviceParams(DeviceParams paramDeviceParams);
  
  public abstract PhoneParams readPhoneParams();
  
  public abstract SdkConfigurationParams readSdkConfigurationParams(SdkConfigurationRequest paramSdkConfigurationRequest);
  
  public abstract UserPrefs readUserPrefs();
  
  public abstract boolean updateUserPrefs(UserPrefs paramUserPrefs);
  
  public abstract void close();
}


