package com.google.vr.cardboard;

import com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams;
import com.google.vr.vrcore.nano.SdkConfiguration.SdkConfigurationRequest;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams;
import com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams;
import com.google.vrtoolkit.cardboard.proto.nano.Preferences.UserPrefs;

public abstract interface VrParamsProvider
{
  public abstract CardboardDevice.DeviceParams readDeviceParams();
  
  public abstract boolean writeDeviceParams(CardboardDevice.DeviceParams paramDeviceParams);
  
  public abstract Phone.PhoneParams readPhoneParams();
  
  public abstract Vr.VREvent.SdkConfigurationParams readSdkConfigurationParams(SdkConfiguration.SdkConfigurationRequest paramSdkConfigurationRequest);
  
  public abstract Preferences.UserPrefs readUserPrefs();
  
  public abstract boolean updateUserPrefs(Preferences.UserPrefs paramUserPrefs);
  
  public abstract void close();
}


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\VrParamsProvider.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */