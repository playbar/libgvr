/*     */ package com.google.vrtoolkit.cardboard;
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
/*     */ class SensorReadingStats
/*     */ {
/*  28 */   private static final String TAG = SensorReadingStats.class.getSimpleName();
/*     */   
/*     */ 
/*     */ 
/*     */   private int sampleBufSize;
/*     */   
/*     */ 
/*     */ 
/*     */   private int numAxes;
/*     */   
/*     */ 
/*     */ 
/*     */   private float[][] sampleBuf;
/*     */   
/*     */ 
/*     */   private int writePos;
/*     */   
/*     */ 
/*     */   private int samplesAdded;
/*     */   
/*     */ 
/*     */ 
/*     */   SensorReadingStats(int paramInt1, int paramInt2)
/*     */   {
/*  52 */     this.sampleBufSize = paramInt1;
/*  53 */     this.numAxes = paramInt2;
/*     */     
/*  55 */     if (paramInt1 <= 0) {
/*  56 */       throw new IllegalArgumentException("sampleBufSize is invalid.");
/*     */     }
/*  58 */     if (paramInt2 <= 0) {
/*  59 */       throw new IllegalArgumentException("numAxes is invalid.");
/*     */     }
/*  61 */     this.sampleBuf = new float[paramInt1][paramInt2];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void addSample(float[] paramArrayOfFloat)
/*     */   {
/*  70 */     if (paramArrayOfFloat.length < this.numAxes) {
/*  71 */       throw new IllegalArgumentException("values.length is less than # of axes.");
/*     */     }
/*  73 */     this.writePos = ((this.writePos + 1) % this.sampleBufSize);
/*  74 */     for (int i = 0; i < this.numAxes; i++) {
/*  75 */       this.sampleBuf[this.writePos][i] = paramArrayOfFloat[i];
/*     */     }
/*  77 */     this.samplesAdded += 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void reset()
/*     */   {
/*  84 */     this.samplesAdded = 0;
/*  85 */     this.writePos = 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean statsAvailable()
/*     */   {
/*  94 */     return this.samplesAdded >= this.sampleBufSize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   float getAverage(int paramInt)
/*     */   {
/* 103 */     if (!statsAvailable())
/*     */     {
/* 105 */       throw new IllegalStateException("Average not available. Not enough samples.");
/*     */     }
/* 107 */     if ((paramInt < 0) || (paramInt >= this.numAxes)) {
/* 108 */       int i = this.numAxes - 1;throw new IllegalStateException(38 + "axis must be between 0 and " + i);
/*     */     }
/* 110 */     float f = 0.0F;
/* 111 */     for (int j = 0; j < this.sampleBufSize; j++) {
/* 112 */       f += this.sampleBuf[j][paramInt];
/*     */     }
/* 114 */     return f / this.sampleBufSize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   float getMaxAbsoluteDeviation(int paramInt)
/*     */   {
/* 121 */     if ((paramInt < 0) || (paramInt >= this.numAxes)) {
/* 122 */       int i = this.numAxes - 1;throw new IllegalStateException(38 + "axis must be between 0 and " + i);
/*     */     }
/* 124 */     float f1 = getAverage(paramInt);
/* 125 */     float f2 = 0.0F;
/* 126 */     for (int j = 0; j < this.sampleBufSize; j++) {
/* 127 */       f2 = Math.max(Math.abs(this.sampleBuf[j][paramInt] - f1), f2);
/*     */     }
/* 129 */     return f2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   float getMaxAbsoluteDeviation()
/*     */   {
/* 136 */     float f = 0.0F;
/* 137 */     for (int i = 0; i < this.numAxes; i++) {
/* 138 */       f = Math.max(f, getMaxAbsoluteDeviation(i));
/*     */     }
/* 140 */     return f;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vrtoolkit\cardboard\SensorReadingStats.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */