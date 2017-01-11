/*    */ package com.google.vr.vrcore.base.api;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class VrCoreNotAvailableException
/*    */   extends Exception
/*    */ {
/*    */   public final int errorCode;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public VrCoreNotAvailableException(int paramInt)
/*    */   {
/* 22 */     super(VrCoreUtils.getConnectionResultString(paramInt));
/* 23 */     this.errorCode = paramInt;
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\base\api\VrCoreNotAvailableException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */