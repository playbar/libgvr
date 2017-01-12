/*     */ package com.google.vr.sdk.base.sensors.internal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OrientationEKF
/*     */ {
/*     */   private static final float NS2S = 1.0E-9F;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final double MIN_ACCEL_NOISE_SIGMA = 0.75D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final double MAX_ACCEL_NOISE_SIGMA = 7.0D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  24 */   private double[] rotationMatrix = new double[16];
/*     */   
/*  26 */   private Matrix3x3d so3SensorFromWorld = new Matrix3x3d();
/*  27 */   private Matrix3x3d so3LastMotion = new Matrix3x3d();
/*  28 */   private Matrix3x3d mP = new Matrix3x3d();
/*  29 */   private Matrix3x3d mQ = new Matrix3x3d();
/*  30 */   private Matrix3x3d mR = new Matrix3x3d();
/*  31 */   private Matrix3x3d mRaccel = new Matrix3x3d();
/*  32 */   private Matrix3x3d mS = new Matrix3x3d();
/*  33 */   private Matrix3x3d mH = new Matrix3x3d();
/*  34 */   private Matrix3x3d mK = new Matrix3x3d();
/*  35 */   private Vector3d mNu = new Vector3d();
/*  36 */   private Vector3d mz = new Vector3d();
/*  37 */   private Vector3d mh = new Vector3d();
/*  38 */   private Vector3d mu = new Vector3d();
/*  39 */   private Vector3d mx = new Vector3d();
/*  40 */   private Vector3d down = new Vector3d();
/*  41 */   private Vector3d north = new Vector3d();
/*     */   
/*     */ 
/*     */   private long sensorTimeStampGyro;
/*     */   
/*  46 */   private final Vector3d lastGyro = new Vector3d();
/*     */   
/*     */ 
/*  49 */   private double previousAccelNorm = 0.0D;
/*     */   
/*     */ 
/*  52 */   private double movingAverageAccelNormChange = 0.0D;
/*     */   
/*     */   private float filteredGyroTimestep;
/*     */   
/*  56 */   private boolean timestepFilterInit = false;
/*     */   private int numGyroTimestepSamples;
/*  58 */   private boolean gyroFilterValid = true;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  63 */   private Matrix3x3d getPredictedGLMatrixTempM1 = new Matrix3x3d();
/*  64 */   private Matrix3x3d getPredictedGLMatrixTempM2 = new Matrix3x3d();
/*  65 */   private Vector3d getPredictedGLMatrixTempV1 = new Vector3d();
/*     */   
/*     */ 
/*  68 */   private Matrix3x3d setHeadingDegreesTempM1 = new Matrix3x3d();
/*     */   
/*     */ 
/*  71 */   private Matrix3x3d processGyroTempM1 = new Matrix3x3d();
/*  72 */   private Matrix3x3d processGyroTempM2 = new Matrix3x3d();
/*     */   
/*     */ 
/*  75 */   private Matrix3x3d processAccTempM1 = new Matrix3x3d();
/*  76 */   private Matrix3x3d processAccTempM2 = new Matrix3x3d();
/*  77 */   private Matrix3x3d processAccTempM3 = new Matrix3x3d();
/*  78 */   private Matrix3x3d processAccTempM4 = new Matrix3x3d();
/*  79 */   private Matrix3x3d processAccTempM5 = new Matrix3x3d();
/*  80 */   private Vector3d processAccTempV1 = new Vector3d();
/*  81 */   private Vector3d processAccTempV2 = new Vector3d();
/*  82 */   private Vector3d processAccVDelta = new Vector3d();
/*     */   
/*     */ 
/*  85 */   private Vector3d processMagTempV1 = new Vector3d();
/*  86 */   private Vector3d processMagTempV2 = new Vector3d();
/*  87 */   private Vector3d processMagTempV3 = new Vector3d();
/*  88 */   private Vector3d processMagTempV4 = new Vector3d();
/*  89 */   private Vector3d processMagTempV5 = new Vector3d();
/*  90 */   private Matrix3x3d processMagTempM1 = new Matrix3x3d();
/*  91 */   private Matrix3x3d processMagTempM2 = new Matrix3x3d();
/*  92 */   private Matrix3x3d processMagTempM4 = new Matrix3x3d();
/*  93 */   private Matrix3x3d processMagTempM5 = new Matrix3x3d();
/*  94 */   private Matrix3x3d processMagTempM6 = new Matrix3x3d();
/*     */   
/*     */ 
/*  97 */   private Matrix3x3d updateCovariancesAfterMotionTempM1 = new Matrix3x3d();
/*  98 */   private Matrix3x3d updateCovariancesAfterMotionTempM2 = new Matrix3x3d();
/*     */   
/*     */ 
/* 101 */   private Matrix3x3d accObservationFunctionForNumericalJacobianTempM = new Matrix3x3d();
/*     */   
/*     */ 
/*     */ 
/* 105 */   private Matrix3x3d magObservationFunctionForNumericalJacobianTempM = new Matrix3x3d();
/*     */   
/*     */ 
/*     */   private boolean alignedToGravity;
/*     */   
/*     */ 
/*     */   private boolean alignedToNorth;
/*     */   
/*     */ 
/*     */   public OrientationEKF()
/*     */   {
/* 116 */     reset();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public synchronized void reset()
/*     */   {
/* 123 */     this.sensorTimeStampGyro = 0L;
/*     */     
/* 125 */     this.so3SensorFromWorld.setIdentity();
/* 126 */     this.so3LastMotion.setIdentity();
/*     */     
/*     */ 
/* 129 */     double initialSigmaP = 5.0D;
/*     */     
/* 131 */     this.mP.setZero();
/* 132 */     this.mP.setSameDiagonal(25.0D);
/*     */     
/*     */ 
/* 135 */     double initialSigmaQ = 1.0D;
/* 136 */     this.mQ.setZero();
/* 137 */     this.mQ.setSameDiagonal(1.0D);
/*     */     
/*     */ 
/* 140 */     double initialSigmaR = 0.25D;
/* 141 */     this.mR.setZero();
/* 142 */     this.mR.setSameDiagonal(0.0625D);
/*     */     
/*     */ 
/* 145 */     this.mRaccel.setZero();
/* 146 */     this.mRaccel.setSameDiagonal(0.5625D);
/*     */     
/* 148 */     this.mS.setZero();
/* 149 */     this.mH.setZero();
/* 150 */     this.mK.setZero();
/* 151 */     this.mNu.setZero();
/* 152 */     this.mz.setZero();
/* 153 */     this.mh.setZero();
/* 154 */     this.mu.setZero();
/* 155 */     this.mx.setZero();
/*     */     
/* 157 */     this.down.set(0.0D, 0.0D, 9.81D);
/* 158 */     this.north.set(0.0D, 1.0D, 0.0D);
/*     */     
/* 160 */     this.alignedToGravity = false;
/* 161 */     this.alignedToNorth = false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized boolean isReady()
/*     */   {
/* 169 */     return this.alignedToGravity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized double getHeadingDegrees()
/*     */   {
/* 181 */     double x = this.so3SensorFromWorld.get(2, 0);
/* 182 */     double y = this.so3SensorFromWorld.get(2, 1);
/* 183 */     double mag = Math.sqrt(x * x + y * y);
/*     */     
/* 185 */     if (mag < 0.1D) {
/* 186 */       return 0.0D;
/*     */     }
/*     */     
/* 189 */     double heading = -90.0D - Math.atan2(y, x) / 3.141592653589793D * 180.0D;
/* 190 */     if (heading < 0.0D) {
/* 191 */       heading += 360.0D;
/*     */     }
/* 193 */     if (heading >= 360.0D) {
/* 194 */       heading -= 360.0D;
/*     */     }
/* 196 */     return heading;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized void setHeadingDegrees(double heading)
/*     */   {
/* 205 */     double currentHeading = getHeadingDegrees();
/* 206 */     double deltaHeading = heading - currentHeading;
/* 207 */     double s = Math.sin(deltaHeading / 180.0D * 3.141592653589793D);
/* 208 */     double c = Math.cos(deltaHeading / 180.0D * 3.141592653589793D);
/*     */     
/* 210 */     double[][] deltaHeadingRotationVals = { { c, -s, 0.0D }, { s, c, 0.0D }, { 0.0D, 0.0D, 1.0D } };
/*     */     
/* 212 */     arrayAssign(deltaHeadingRotationVals, this.setHeadingDegreesTempM1);
/* 213 */     Matrix3x3d.mult(this.so3SensorFromWorld, this.setHeadingDegreesTempM1, this.so3SensorFromWorld);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized double[] getGLMatrix()
/*     */   {
/* 223 */     return glMatrixFromSo3(this.so3SensorFromWorld);
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
/*     */   public synchronized double[] getPredictedGLMatrix(double secondsAfterLastGyroEvent)
/*     */   {
/* 237 */     double dT = secondsAfterLastGyroEvent;
/* 238 */     Vector3d pmu = this.getPredictedGLMatrixTempV1;
/* 239 */     pmu.set(this.lastGyro);
/* 240 */     pmu.scale(-dT);
/* 241 */     Matrix3x3d so3PredictedMotion = this.getPredictedGLMatrixTempM1;
/* 242 */     So3Util.sO3FromMu(pmu, so3PredictedMotion);
/*     */     
/* 244 */     Matrix3x3d so3PredictedState = this.getPredictedGLMatrixTempM2;
/* 245 */     Matrix3x3d.mult(so3PredictedMotion, this.so3SensorFromWorld, so3PredictedState);
/*     */     
/* 247 */     return glMatrixFromSo3(so3PredictedState);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized Matrix3x3d getRotationMatrix()
/*     */   {
/* 255 */     return this.so3SensorFromWorld;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void arrayAssign(double[][] data, Matrix3x3d m)
/*     */   {
/* 265 */     assert (3 == data.length);
/* 266 */     assert (3 == data[0].length);
/* 267 */     assert (3 == data[1].length);
/* 268 */     assert (3 == data[2].length);
/* 269 */     m.set(data[0][0], data[0][1], data[0][2], data[1][0], data[1][1], data[1][2], data[2][0], data[2][1], data[2][2]);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized boolean isAlignedToGravity()
/*     */   {
/* 279 */     return this.alignedToGravity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized boolean isAlignedToNorth()
/*     */   {
/* 287 */     return this.alignedToNorth;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized void processGyro(Vector3d gyro, long sensorTimeStamp)
/*     */   {
/* 297 */     float kTimeThreshold = 0.04F;
/* 298 */     float kdTdefault = 0.01F;
/* 299 */     if (this.sensorTimeStampGyro != 0L) {
/* 300 */       float dT = (float)(sensorTimeStamp - this.sensorTimeStampGyro) * 1.0E-9F;
/* 301 */       if (dT > 0.04F) {
/* 302 */         dT = this.gyroFilterValid ? this.filteredGyroTimestep : 0.01F;
/*     */       } else {
/* 304 */         filterGyroTimestep(dT);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 309 */       this.mu.set(gyro);
/* 310 */       this.mu.scale(-dT);
/* 311 */       So3Util.sO3FromMu(this.mu, this.so3LastMotion);
/*     */       
/* 313 */       this.processGyroTempM1.set(this.so3SensorFromWorld);
/* 314 */       Matrix3x3d.mult(this.so3LastMotion, this.so3SensorFromWorld, this.processGyroTempM1);
/* 315 */       this.so3SensorFromWorld.set(this.processGyroTempM1);
/*     */       
/* 317 */       updateCovariancesAfterMotion();
/*     */       
/* 319 */       this.processGyroTempM2.set(this.mQ);
/* 320 */       this.processGyroTempM2.scale(dT * dT);
/* 321 */       this.mP.plusEquals(this.processGyroTempM2);
/*     */     }
/* 323 */     this.sensorTimeStampGyro = sensorTimeStamp;
/* 324 */     this.lastGyro.set(gyro);
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
/*     */ 
/*     */ 
/*     */   private void updateAccelCovariance(double currentAccelNorm)
/*     */   {
/* 341 */     double currentAccelNormChange = Math.abs(currentAccelNorm - this.previousAccelNorm);
/* 342 */     this.previousAccelNorm = currentAccelNorm;
/*     */     
/*     */ 
/* 345 */     double kSmoothingFactor = 0.5D;
/* 346 */     this.movingAverageAccelNormChange = (0.5D * currentAccelNormChange + 0.5D * this.movingAverageAccelNormChange);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 352 */     double kMaxAccelNormChange = 0.15D;
/*     */     
/* 354 */     double normChangeRatio = this.movingAverageAccelNormChange / 0.15D;
/* 355 */     double accelNoiseSigma = Math.min(7.0D, 0.75D + normChangeRatio * 6.25D);
/*     */     
/*     */ 
/*     */ 
/* 359 */     this.mRaccel.setSameDiagonal(accelNoiseSigma * accelNoiseSigma);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized void processAcc(Vector3d acc, long sensorTimeStamp)
/*     */   {
/* 371 */     this.mz.set(acc);
/* 372 */     updateAccelCovariance(this.mz.length());
/*     */     
/* 374 */     if (this.alignedToGravity) {
/* 375 */       accObservationFunctionForNumericalJacobian(this.so3SensorFromWorld, this.mNu);
/*     */       
/*     */ 
/* 378 */       double eps = 1.0E-7D;
/* 379 */       for (int dof = 0; dof < 3; dof++) {
/* 380 */         Vector3d delta = this.processAccVDelta;
/* 381 */         delta.setZero();
/* 382 */         delta.setComponent(dof, eps);
/*     */         
/* 384 */         So3Util.sO3FromMu(delta, this.processAccTempM1);
/* 385 */         Matrix3x3d.mult(this.processAccTempM1, this.so3SensorFromWorld, this.processAccTempM2);
/*     */         
/* 387 */         accObservationFunctionForNumericalJacobian(this.processAccTempM2, this.processAccTempV1);
/*     */         
/* 389 */         Vector3d withDelta = this.processAccTempV1;
/*     */         
/* 391 */         Vector3d.sub(this.mNu, withDelta, this.processAccTempV2);
/* 392 */         this.processAccTempV2.scale(1.0D / eps);
/* 393 */         this.mH.setColumn(dof, this.processAccTempV2);
/*     */       }
/*     */       
/*     */ 
/* 397 */       this.mH.transpose(this.processAccTempM3);
/* 398 */       Matrix3x3d.mult(this.mP, this.processAccTempM3, this.processAccTempM4);
/* 399 */       Matrix3x3d.mult(this.mH, this.processAccTempM4, this.processAccTempM5);
/* 400 */       Matrix3x3d.add(this.processAccTempM5, this.mRaccel, this.mS);
/*     */       
/*     */ 
/* 403 */       this.mS.invert(this.processAccTempM3);
/* 404 */       this.mH.transpose(this.processAccTempM4);
/* 405 */       Matrix3x3d.mult(this.processAccTempM4, this.processAccTempM3, this.processAccTempM5);
/* 406 */       Matrix3x3d.mult(this.mP, this.processAccTempM5, this.mK);
/*     */       
/*     */ 
/* 409 */       Matrix3x3d.mult(this.mK, this.mNu, this.mx);
/*     */       
/*     */ 
/* 412 */       Matrix3x3d.mult(this.mK, this.mH, this.processAccTempM3);
/* 413 */       this.processAccTempM4.setIdentity();
/* 414 */       this.processAccTempM4.minusEquals(this.processAccTempM3);
/* 415 */       Matrix3x3d.mult(this.processAccTempM4, this.mP, this.processAccTempM3);
/* 416 */       this.mP.set(this.processAccTempM3);
/*     */       
/* 418 */       So3Util.sO3FromMu(this.mx, this.so3LastMotion);
/*     */       
/* 420 */       Matrix3x3d.mult(this.so3LastMotion, this.so3SensorFromWorld, this.so3SensorFromWorld);
/*     */       
/* 422 */       updateCovariancesAfterMotion();
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 427 */       So3Util.sO3FromTwoVec(this.down, this.mz, this.so3SensorFromWorld);
/* 428 */       this.alignedToGravity = true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized void processMag(float[] mag, long sensorTimeStamp)
/*     */   {
/* 440 */     if (!this.alignedToGravity) {
/* 441 */       return;
/*     */     }
/* 443 */     this.mz.set(mag[0], mag[1], mag[2]);
/* 444 */     this.mz.normalize();
/*     */     
/* 446 */     Vector3d downInSensorFrame = new Vector3d();
/* 447 */     this.so3SensorFromWorld.getColumn(2, downInSensorFrame);
/*     */     
/* 449 */     Vector3d.cross(this.mz, downInSensorFrame, this.processMagTempV1);
/* 450 */     Vector3d perpToDownAndMag = this.processMagTempV1;
/* 451 */     perpToDownAndMag.normalize();
/*     */     
/* 453 */     Vector3d.cross(downInSensorFrame, perpToDownAndMag, this.processMagTempV2);
/* 454 */     Vector3d magHorizontal = this.processMagTempV2;
/*     */     
/*     */ 
/* 457 */     magHorizontal.normalize();
/* 458 */     this.mz.set(magHorizontal);
/*     */     
/* 460 */     if (this.alignedToNorth) {
/* 461 */       magObservationFunctionForNumericalJacobian(this.so3SensorFromWorld, this.mNu);
/*     */       
/*     */ 
/* 464 */       double eps = 1.0E-7D;
/* 465 */       for (int dof = 0; dof < 3; dof++) {
/* 466 */         Vector3d delta = this.processMagTempV3;
/* 467 */         delta.setZero();
/* 468 */         delta.setComponent(dof, eps);
/*     */         
/* 470 */         So3Util.sO3FromMu(delta, this.processMagTempM1);
/* 471 */         Matrix3x3d.mult(this.processMagTempM1, this.so3SensorFromWorld, this.processMagTempM2);
/*     */         
/* 473 */         magObservationFunctionForNumericalJacobian(this.processMagTempM2, this.processMagTempV4);
/*     */         
/* 475 */         Vector3d withDelta = this.processMagTempV4;
/*     */         
/* 477 */         Vector3d.sub(this.mNu, withDelta, this.processMagTempV5);
/* 478 */         this.processMagTempV5.scale(1.0D / eps);
/*     */         
/* 480 */         this.mH.setColumn(dof, this.processMagTempV5);
/*     */       }
/*     */       
/*     */ 
/* 484 */       this.mH.transpose(this.processMagTempM4);
/* 485 */       Matrix3x3d.mult(this.mP, this.processMagTempM4, this.processMagTempM5);
/* 486 */       Matrix3x3d.mult(this.mH, this.processMagTempM5, this.processMagTempM6);
/* 487 */       Matrix3x3d.add(this.processMagTempM6, this.mR, this.mS);
/*     */       
/*     */ 
/* 490 */       this.mS.invert(this.processMagTempM4);
/* 491 */       this.mH.transpose(this.processMagTempM5);
/* 492 */       Matrix3x3d.mult(this.processMagTempM5, this.processMagTempM4, this.processMagTempM6);
/* 493 */       Matrix3x3d.mult(this.mP, this.processMagTempM6, this.mK);
/*     */       
/*     */ 
/* 496 */       Matrix3x3d.mult(this.mK, this.mNu, this.mx);
/*     */       
/*     */ 
/* 499 */       Matrix3x3d.mult(this.mK, this.mH, this.processMagTempM4);
/* 500 */       this.processMagTempM5.setIdentity();
/* 501 */       this.processMagTempM5.minusEquals(this.processMagTempM4);
/* 502 */       Matrix3x3d.mult(this.processMagTempM5, this.mP, this.processMagTempM4);
/* 503 */       this.mP.set(this.processMagTempM4);
/*     */       
/* 505 */       So3Util.sO3FromMu(this.mx, this.so3LastMotion);
/*     */       
/* 507 */       Matrix3x3d.mult(this.so3LastMotion, this.so3SensorFromWorld, this.processMagTempM4);
/* 508 */       this.so3SensorFromWorld.set(this.processMagTempM4);
/*     */       
/* 510 */       updateCovariancesAfterMotion();
/*     */     }
/*     */     else
/*     */     {
/* 514 */       magObservationFunctionForNumericalJacobian(this.so3SensorFromWorld, this.mNu);
/* 515 */       So3Util.sO3FromMu(this.mNu, this.so3LastMotion);
/*     */       
/* 517 */       Matrix3x3d.mult(this.so3LastMotion, this.so3SensorFromWorld, this.processMagTempM4);
/* 518 */       this.so3SensorFromWorld.set(this.processMagTempM4);
/*     */       
/* 520 */       updateCovariancesAfterMotion();
/* 521 */       this.alignedToNorth = true;
/*     */     }
/*     */   }
/*     */   
/*     */   private double[] glMatrixFromSo3(Matrix3x3d so3)
/*     */   {
/* 527 */     for (int r = 0; r < 3; r++) {
/* 528 */       for (int c = 0; c < 3; c++)
/*     */       {
/* 530 */         this.rotationMatrix[(4 * c + r)] = so3.get(r, c);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 535 */     this.rotationMatrix[3] = (this.rotationMatrix[7] = this.rotationMatrix[11] = 0.0D);
/* 536 */     this.rotationMatrix[12] = (this.rotationMatrix[13] = this.rotationMatrix[14] = 0.0D);
/*     */     
/*     */ 
/* 539 */     this.rotationMatrix[15] = 1.0D;
/*     */     
/* 541 */     return this.rotationMatrix;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void filterGyroTimestep(float timeStep)
/*     */   {
/* 551 */     float kFilterCoeff = 0.95F;
/* 552 */     float kMinSamples = 10.0F;
/* 553 */     if (!this.timestepFilterInit) {
/* 554 */       this.filteredGyroTimestep = timeStep;
/* 555 */       this.numGyroTimestepSamples = 1;
/* 556 */       this.timestepFilterInit = true;
/*     */     }
/*     */     else {
/* 559 */       this.filteredGyroTimestep = (0.95F * this.filteredGyroTimestep + 0.050000012F * timeStep);
/*     */       
/* 561 */       if (++this.numGyroTimestepSamples > 10.0F) {
/* 562 */         this.gyroFilterValid = true;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void updateCovariancesAfterMotion() {
/* 568 */     this.so3LastMotion.transpose(this.updateCovariancesAfterMotionTempM1);
/* 569 */     Matrix3x3d.mult(this.mP, this.updateCovariancesAfterMotionTempM1, this.updateCovariancesAfterMotionTempM2);
/*     */     
/* 571 */     Matrix3x3d.mult(this.so3LastMotion, this.updateCovariancesAfterMotionTempM2, this.mP);
/* 572 */     this.so3LastMotion.setIdentity();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void accObservationFunctionForNumericalJacobian(Matrix3x3d so3SensorFromWorldPred, Vector3d result)
/*     */   {
/* 581 */     Matrix3x3d.mult(so3SensorFromWorldPred, this.down, this.mh);
/* 582 */     So3Util.sO3FromTwoVec(this.mh, this.mz, this.accObservationFunctionForNumericalJacobianTempM);
/*     */     
/*     */ 
/* 585 */     So3Util.muFromSO3(this.accObservationFunctionForNumericalJacobianTempM, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void magObservationFunctionForNumericalJacobian(Matrix3x3d so3SensorFromWorldPred, Vector3d result)
/*     */   {
/* 597 */     Matrix3x3d.mult(so3SensorFromWorldPred, this.north, this.mh);
/* 598 */     So3Util.sO3FromTwoVec(this.mh, this.mz, this.magObservationFunctionForNumericalJacobianTempM);
/*     */     
/* 600 */     So3Util.muFromSO3(this.magObservationFunctionForNumericalJacobianTempM, result);
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\sensors\internal\OrientationEKF.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */