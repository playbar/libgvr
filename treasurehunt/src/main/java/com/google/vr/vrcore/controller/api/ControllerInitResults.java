/*    */ package com.google.vr.vrcore.controller.api;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ControllerInitResults
/*    */ {
/*    */   public static final int SUCCESS = 0;
/*    */   
/*    */ 
/*    */ 
/*    */   public static final int FAILED_UNSUPPORTED = 1;
/*    */   
/*    */ 
/*    */   public static final int FAILED_NOT_AUTHORIZED = 2;
/*    */   
/*    */ 
/*    */   public static final int FAILED_CLIENT_OBSOLETE = 3;
/*    */   
/*    */ 
/*    */ 
/*    */   public static final String toString(int paramInt)
/*    */   {
/* 24 */     switch (paramInt) {
/*    */     case 0: 
/* 26 */       return "SUCCESS";
/*    */     case 1: 
/* 28 */       return "FAILED_UNSUPPORTED";
/*    */     case 2: 
/* 30 */       return "FAILED_NOT_AUTHORIZED";
/*    */     case 3: 
/* 32 */       return "FAILED_CLIENT_OBSOLETE";
/*    */     }
/* 34 */     return 45 + "[UNKNOWN CONTROLLER INIT RESULT: " + paramInt + "]";
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\controller\api\ControllerInitResults.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */