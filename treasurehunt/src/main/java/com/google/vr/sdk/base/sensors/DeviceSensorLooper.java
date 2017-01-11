/*     */ package com.google.vr.sdk.base.sensors;
/*     */ 
/*     */ import android.hardware.Sensor;
/*     */ import android.hardware.SensorEvent;
/*     */ import android.hardware.SensorEventListener;
/*     */ import android.hardware.SensorManager;
/*     */ import android.os.Build;
/*     */ import android.os.Handler;
/*     */ import android.os.HandlerThread;
/*     */ import android.os.Looper;
/*     */ import android.util.Log;
/*     */ import java.util.ArrayList;
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
/*     */ public class DeviceSensorLooper
/*     */   implements SensorEventProvider
/*     */ {
/*  39 */   private static final String LOG_TAG = DeviceSensorLooper.class.getSimpleName();
/*     */   
/*     */ 
/*     */   private boolean isRunning;
/*     */   
/*     */ 
/*     */   private SensorManager sensorManager;
/*     */   
/*     */ 
/*     */   private Looper sensorLooper;
/*     */   
/*     */ 
/*     */   private SensorEventListener sensorEventListener;
/*     */   
/*     */ 
/*  54 */   private final ArrayList<SensorEventListener> registeredListeners = new ArrayList();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DeviceSensorLooper(SensorManager sensorManager)
/*     */   {
/*  63 */     this.sensorManager = sensorManager;
/*     */   }
/*     */   
/*     */ 
/*     */   private Sensor getUncalibratedGyro()
/*     */   {
/*  69 */     if (Build.MANUFACTURER.equals("HTC")) {
/*  70 */       return null;
/*     */     }
/*  72 */     return this.sensorManager.getDefaultSensor(16);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void start()
/*     */   {
/*  80 */     if (this.isRunning)
/*     */     {
/*  82 */       return;
/*     */     }
/*     */     
/*  85 */     this.sensorEventListener = new SensorEventListener()
/*     */     {
/*     */       public void onSensorChanged(SensorEvent event)
/*     */       {
/*  89 */         synchronized (DeviceSensorLooper.this.registeredListeners) {
/*  90 */           for (SensorEventListener listener : DeviceSensorLooper.this.registeredListeners) {
/*  91 */             listener.onSensorChanged(event);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */       public void onAccuracyChanged(Sensor sensor, int accuracy)
/*     */       {
/*  98 */         synchronized (DeviceSensorLooper.this.registeredListeners) {
/*  99 */           for (SensorEventListener listener : DeviceSensorLooper.this.registeredListeners) {
/* 100 */             listener.onAccuracyChanged(sensor, accuracy);
/*     */           }
/*     */           
/*     */         }
/*     */       }
/* 105 */     };
/* 106 */     HandlerThread sensorThread = new HandlerThread("sensor")
/*     */     {
/*     */       protected void onLooperPrepared() {
/* 109 */         Handler handler = new Handler(Looper.myLooper());
/*     */         
/*     */ 
/* 112 */         Sensor accelerometer = DeviceSensorLooper.this.sensorManager.getDefaultSensor(1);
/* 113 */         DeviceSensorLooper.this.sensorManager.registerListener(DeviceSensorLooper.this.sensorEventListener, accelerometer, 0, handler);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 122 */         Sensor gyroscope = DeviceSensorLooper.this.getUncalibratedGyro();
/* 123 */         if (gyroscope == null) {
/* 124 */           Log.i(DeviceSensorLooper.LOG_TAG, "Uncalibrated gyroscope unavailable, default to regular gyroscope.");
/* 125 */           gyroscope = DeviceSensorLooper.this.sensorManager.getDefaultSensor(4);
/*     */         }
/*     */         
/* 128 */         DeviceSensorLooper.this.sensorManager.registerListener(DeviceSensorLooper.this.sensorEventListener, gyroscope, 0, handler);
/*     */       }
/*     */       
/*     */ 
/* 132 */     };
/* 133 */     sensorThread.start();
/* 134 */     this.sensorLooper = sensorThread.getLooper();
/* 135 */     this.isRunning = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void stop()
/*     */   {
/* 143 */     if (!this.isRunning)
/*     */     {
/* 145 */       return;
/*     */     }
/*     */     
/* 148 */     this.sensorManager.unregisterListener(this.sensorEventListener);
/* 149 */     this.sensorEventListener = null;
/*     */     
/* 151 */     this.sensorLooper.quit();
/* 152 */     this.sensorLooper = null;
/* 153 */     this.isRunning = false;
/*     */   }
/*     */   
/*     */   public void registerListener(SensorEventListener listener)
/*     */   {
/* 158 */     synchronized (this.registeredListeners) {
/* 159 */       this.registeredListeners.add(listener);
/*     */     }
/*     */   }
/*     */   
/*     */   public void unregisterListener(SensorEventListener listener)
/*     */   {
/* 165 */     synchronized (this.registeredListeners) {
/* 166 */       this.registeredListeners.remove(listener);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\sensors\DeviceSensorLooper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */