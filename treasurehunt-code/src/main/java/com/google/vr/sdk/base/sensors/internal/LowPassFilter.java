/*    */ package com.google.vr.sdk.base.sensors.internal;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LowPassFilter
/*    */ {
/* 11 */   private static final double NANOS_TO_SECONDS = 1.0D / TimeUnit.NANOSECONDS
/* 12 */     .convert(1L, TimeUnit.SECONDS);
/*    */   
/*    */   private final double timeConstantSecs;
/* 15 */   private final Vector3d filteredData = new Vector3d();
/*    */   
/*    */   private long lastTimestampNs;
/*    */   
/*    */   private int numSamples;
/* 20 */   private final Vector3d temp = new Vector3d();
/*    */   
/*    */   public LowPassFilter(double cutoffFrequency)
/*    */   {
/* 24 */     this.timeConstantSecs = (1.0D / (6.283185307179586D * cutoffFrequency));
/*    */   }
/*    */   
/*    */   public int getNumSamples()
/*    */   {
/* 29 */     return this.numSamples;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addSample(Vector3d sampleData, long timestampNs)
/*    */   {
/* 39 */     addWeightedSample(sampleData, timestampNs, 1.0D);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addWeightedSample(Vector3d sampleData, long timestampNs, double weight)
/*    */   {
/* 52 */     this.numSamples += 1;
/* 53 */     if (this.numSamples == 1)
/*    */     {
/* 55 */       this.filteredData.set(sampleData);
/* 56 */       this.lastTimestampNs = timestampNs;
/* 57 */       return;
/*    */     }
/*    */     
/* 60 */     double weightedDeltaSecs = weight * (timestampNs - this.lastTimestampNs) * NANOS_TO_SECONDS;
/*    */     
/* 62 */     double alpha = weightedDeltaSecs / (this.timeConstantSecs + weightedDeltaSecs);
/* 63 */     this.filteredData.scale(1.0D - alpha);
/* 64 */     this.temp.set(sampleData);
/* 65 */     this.temp.scale(alpha);
/* 66 */     Vector3d.add(this.temp, this.filteredData, this.filteredData);
/* 67 */     this.lastTimestampNs = timestampNs;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Vector3d getFilteredData()
/*    */   {
/* 74 */     return this.filteredData;
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\sensors\internal\LowPassFilter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */