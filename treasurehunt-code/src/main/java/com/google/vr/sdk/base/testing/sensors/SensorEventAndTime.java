/*    */ package com.google.vr.sdk.base.testing.sensors;
/*    */ 
/*    */ import android.hardware.SensorEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SensorEventAndTime
/*    */ {
/*    */   public SensorEvent event;
/*    */   public long timeNs;
/*    */   
/*    */   public SensorEventAndTime(SensorEvent event, long timeNs)
/*    */   {
/* 21 */     this.event = event;
/* 22 */     this.timeNs = timeNs;
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\testing\sensors\SensorEventAndTime.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */