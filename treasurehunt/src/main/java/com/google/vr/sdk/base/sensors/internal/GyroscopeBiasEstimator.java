/*     */ package com.google.vr.sdk.base.sensors.internal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GyroscopeBiasEstimator
/*     */ {
/*     */   private static final float ACCEL_LOWPASS_FREQ = 1.0F;
/*     */   
/*     */ 
/*     */ 
/*     */   private static final float GYRO_LOWPASS_FREQ = 10.0F;
/*     */   
/*     */ 
/*     */ 
/*     */   private static final float GYRO_BIAS_LOWPASS_FREQ = 0.15F;
/*     */   
/*     */ 
/*     */   private static final int NUM_GYRO_BIAS_SAMPLES_THRESHOLD = 30;
/*     */   
/*     */ 
/*     */   private static final int NUM_GYRO_BIAS_SAMPLES_INITIAL_SMOOTHING = 100;
/*     */   
/*     */ 
/*     */   private LowPassFilter accelLowPass;
/*     */   
/*     */ 
/*     */   private LowPassFilter gyroLowPass;
/*     */   
/*     */ 
/*     */   private LowPassFilter gyroBiasLowPass;
/*     */   
/*     */ 
/*     */   private static final float ACCEL_DIFF_STATIC_THRESHOLD = 0.5F;
/*     */   
/*     */ 
/*     */   private static final float GYRO_DIFF_STATIC_THRESHOLD = 0.008F;
/*     */   
/*     */ 
/*     */   private Vector3d smoothedGyroDiff;
/*     */   
/*     */ 
/*     */   private Vector3d smoothedAccelDiff;
/*     */   
/*     */ 
/*     */   private static final float GYRO_FOR_BIAS_THRESHOLD = 0.35F;
/*     */   
/*     */ 
/*     */   private static final int IS_STATIC_NUM_FRAMES_THRESHOLD = 10;
/*     */   
/*     */ 
/*     */   private IsStaticCounter isAccelStatic;
/*     */   
/*     */ 
/*     */   private IsStaticCounter isGyroStatic;
/*     */   
/*     */ 
/*     */ 
/*     */   public GyroscopeBiasEstimator()
/*     */   {
/*  61 */     reset();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void reset()
/*     */   {
/*  68 */     this.smoothedGyroDiff = new Vector3d();
/*  69 */     this.smoothedAccelDiff = new Vector3d();
/*  70 */     this.accelLowPass = new LowPassFilter(1.0D);
/*  71 */     this.gyroLowPass = new LowPassFilter(10.0D);
/*  72 */     this.gyroBiasLowPass = new LowPassFilter(0.15000000596046448D);
/*  73 */     this.isAccelStatic = new IsStaticCounter(10);
/*  74 */     this.isGyroStatic = new IsStaticCounter(10);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void processGyroscope(Vector3d gyro, long sensorTimestampNs)
/*     */   {
/*  86 */     this.gyroLowPass.addSample(gyro, sensorTimestampNs);
/*  87 */     Vector3d.sub(gyro, this.gyroLowPass.getFilteredData(), this.smoothedGyroDiff);
/*     */     
/*  89 */     this.isGyroStatic.appendFrame(this.smoothedGyroDiff.length() < 0.00800000037997961D);
/*     */     
/*     */ 
/*     */ 
/*  93 */     if ((this.isGyroStatic.isRecentlyStatic()) && (this.isAccelStatic.isRecentlyStatic())) {
/*  94 */       updateGyroBias(gyro, sensorTimestampNs);
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
/*     */   public void processAccelerometer(Vector3d accel, long sensorTimestampNs)
/*     */   {
/* 107 */     this.accelLowPass.addSample(accel, sensorTimestampNs);
/* 108 */     Vector3d.sub(accel, this.accelLowPass.getFilteredData(), this.smoothedAccelDiff);
/* 109 */     this.isAccelStatic.appendFrame(this.smoothedAccelDiff.length() < 0.5D);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void getGyroBias(Vector3d result)
/*     */   {
/* 117 */     if (this.gyroBiasLowPass.getNumSamples() < 30) {
/* 118 */       result.setZero();
/*     */     } else {
/* 120 */       result.set(this.gyroBiasLowPass.getFilteredData());
/*     */       
/*     */ 
/*     */ 
/* 124 */       double rampUpRatio = Math.min(1.0D, 
/* 125 */         (this.gyroBiasLowPass.getNumSamples() - 30) / 100.0D);
/*     */       
/* 127 */       result.scale(rampUpRatio);
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
/*     */ 
/*     */   private void updateGyroBias(Vector3d gyro, long sensorTimestampNs)
/*     */   {
/* 141 */     if (gyro.length() >= 0.3499999940395355D)
/*     */     {
/*     */ 
/* 144 */       return;
/*     */     }
/*     */     
/* 147 */     double updateWeight = Math.max(0.0D, 1.0D - gyro.length() / 0.3499999940395355D);
/* 148 */     updateWeight *= updateWeight;
/* 149 */     this.gyroBiasLowPass.addWeightedSample(this.gyroLowPass.getFilteredData(), sensorTimestampNs, updateWeight);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static class IsStaticCounter
/*     */   {
/*     */     private final int minStaticFrames;
/*     */     
/*     */ 
/*     */     private int consecutiveIsStatic;
/*     */     
/*     */ 
/*     */ 
/*     */     IsStaticCounter(int minStaticFrames)
/*     */     {
/* 166 */       this.minStaticFrames = minStaticFrames;
/*     */     }
/*     */     
/*     */     void appendFrame(boolean isStatic)
/*     */     {
/* 171 */       if (!isStatic) {
/* 172 */         this.consecutiveIsStatic = 0;
/*     */       } else {
/* 174 */         this.consecutiveIsStatic += 1;
/*     */       }
/*     */     }
/*     */     
/*     */     boolean isRecentlyStatic() {
/* 179 */       return this.consecutiveIsStatic >= this.minStaticFrames;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\sensors\internal\GyroscopeBiasEstimator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */