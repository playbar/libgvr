/*    */ package com.google.vr.ndk.base;
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
/*    */ public class UserPrefs
/*    */ {
/* 24 */   private static final String TAG = UserPrefs.class.getSimpleName();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private final long nativeUserPrefs;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   UserPrefs(long paramLong)
/*    */   {
/* 44 */     this.nativeUserPrefs = paramLong;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getControllerHandedness()
/*    */   {
/* 52 */     return GvrApi.nativeUserPrefsGetControllerHandedness(this.nativeUserPrefs);
/*    */   }
/*    */   
/*    */   public static abstract class ControllerHandedness
/*    */   {
/*    */     public static final int RIGHT_HANDED = 0;
/*    */     public static final int LEFT_HANDED = 1;
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\ndk\base\UserPrefs.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */