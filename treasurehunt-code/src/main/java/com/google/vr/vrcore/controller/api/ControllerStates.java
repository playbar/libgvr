/*    */ package com.google.vr.vrcore.controller.api;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ControllerStates
/*    */ {
/*    */   public static final int DISCONNECTED = 0;
/*    */   
/*    */   public static final int SCANNING = 1;
/*    */   
/*    */   public static final int CONNECTING = 2;
/*    */   
/*    */   public static final int CONNECTED = 3;
/*    */   
/*    */ 
/*    */   public static final String toString(int paramInt)
/*    */   {
/* 18 */     switch (paramInt) {
/*    */     case 0: 
/* 20 */       return "DISCONNECTED";
/*    */     case 1: 
/* 22 */       return "SCANNING";
/*    */     case 2: 
/* 24 */       return "CONNECTING";
/*    */     case 3: 
/* 26 */       return "CONNECTED";
/*    */     }
/* 28 */     return 39 + "[UNKNOWN CONTROLLER STATE: " + paramInt + "]";
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\vrcore\controller\api\ControllerStates.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */