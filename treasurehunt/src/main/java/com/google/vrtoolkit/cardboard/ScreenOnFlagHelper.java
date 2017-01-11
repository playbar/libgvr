/*     */ package com.google.vrtoolkit.cardboard;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.hardware.Sensor;
/*     */ import android.hardware.SensorEvent;
/*     */ import android.hardware.SensorEventListener;
/*     */ import android.hardware.SensorManager;
/*     */ import android.view.Window;
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
/*     */ public class ScreenOnFlagHelper
/*     */   implements SensorEventListener
/*     */ {
/*     */   private static final String TAG = "ScreenOnFlagHelper";
/*     */   private static final boolean DEBUG = false;
/*     */   private static final long IDLE_TIMEOUT_MS = 30000L;
/*     */   private static final long SAMPLE_INTERVAL_MS = 250L;
/*     */   private static final int NUM_SAMPLES = 120;
/*     */   private static final float SENSOR_THRESHOLD = 0.2F;
/*  64 */   private boolean screenAlwaysOn = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Activity activity;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  76 */   private SensorReadingStats sensorStats = new SensorReadingStats(120, 3);
/*     */   
/*     */ 
/*     */ 
/*  80 */   private long lastSampleTimestamp = 0L;
/*     */   
/*     */ 
/*  83 */   private boolean isFlagSet = false;
/*     */   private SensorManager sensorManager;
/*     */   private Sensor sensor;
/*     */   
/*     */   public ScreenOnFlagHelper(Activity paramActivity)
/*     */   {
/*  89 */     this.activity = paramActivity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void setSensorManager(SensorManager paramSensorManager)
/*     */   {
/*  98 */     this.sensorManager = paramSensorManager;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScreenAlwaysOn(boolean paramBoolean)
/*     */   {
/* 108 */     this.screenAlwaysOn = paramBoolean;
/* 109 */     updateFlag();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void start()
/*     */   {
/* 119 */     if (this.sensorManager == null) {
/* 120 */       this.sensorManager = ((SensorManager)this.activity.getSystemService("sensor"));
/*     */     }
/*     */     
/* 123 */     if (this.sensor == null) {
/* 124 */       this.sensor = this.sensorManager.getDefaultSensor(1);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 129 */     this.isFlagSet = false;
/*     */     
/*     */ 
/*     */ 
/* 133 */     setKeepScreenOnFlag(true);
/*     */     
/*     */ 
/* 136 */     this.sensorStats.reset();
/*     */     
/*     */ 
/*     */ 
/* 140 */     this.sensorManager.registerListener(this, this.sensor, 250000);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void stop()
/*     */   {
/* 150 */     if (this.sensorManager != null) {
/* 151 */       this.sensorManager.unregisterListener(this);
/*     */     }
/* 153 */     setKeepScreenOnFlag(false);
/*     */   }
/*     */   
/*     */ 
/*     */   public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
/*     */   
/*     */ 
/*     */   public void onSensorChanged(SensorEvent paramSensorEvent)
/*     */   {
/*     */     long l;
/* 163 */     if ((l = (paramSensorEvent.timestamp - this.lastSampleTimestamp) / 1000000L) < 250L)
/*     */     {
/*     */ 
/*     */ 
/* 167 */       return;
/*     */     }
/*     */     
/* 170 */     this.sensorStats.addSample(paramSensorEvent.values);
/* 171 */     this.lastSampleTimestamp = paramSensorEvent.timestamp;
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
/* 182 */     updateFlag();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateFlag()
/*     */   {
/* 192 */     if ((this.screenAlwaysOn) || (!this.sensorStats.statsAvailable())) {
/* 193 */       setKeepScreenOnFlag(true);
/* 194 */       return;
/*     */     }
/*     */     
/*     */ 
/* 198 */     float f = this.sensorStats.getMaxAbsoluteDeviation();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 205 */     setKeepScreenOnFlag(f > 0.2F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void setKeepScreenOnFlag(boolean paramBoolean)
/*     */   {
/* 213 */     if (paramBoolean == this.isFlagSet)
/*     */     {
/*     */ 
/*     */ 
/* 217 */       return;
/*     */     }
/* 219 */     if (paramBoolean) {
/* 220 */       this.activity.getWindow().addFlags(128);
/*     */     } else {
/* 222 */       this.activity.getWindow().clearFlags(128);
/*     */     }
/* 224 */     this.isFlagSet = paramBoolean;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vrtoolkit\cardboard\ScreenOnFlagHelper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */