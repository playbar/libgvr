/*    */ package com.google.vr.sdk.base.sensors;
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
/*    */ public class SystemClock
/*    */   implements Clock
/*    */ {
/*    */   public long nanoTime()
/*    */   {
/* 27 */     return System.nanoTime();
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\sensors\SystemClock.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */