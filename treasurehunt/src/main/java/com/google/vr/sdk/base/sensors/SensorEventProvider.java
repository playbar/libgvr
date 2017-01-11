package com.google.vr.sdk.base.sensors;

import android.hardware.SensorEventListener;

public abstract interface SensorEventProvider
{
  public abstract void start();
  
  public abstract void stop();
  
  public abstract void registerListener(SensorEventListener paramSensorEventListener);
  
  public abstract void unregisterListener(SensorEventListener paramSensorEventListener);
}


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\sensors\SensorEventProvider.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */