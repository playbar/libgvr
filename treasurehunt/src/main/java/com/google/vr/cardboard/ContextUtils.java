/*    */ package com.google.vr.cardboard;
/*    */ 
/*    */ import android.app.Activity;
/*    */ import android.content.Context;
/*    */ import android.content.ContextWrapper;
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
/*    */ public class ContextUtils
/*    */ {
/*    */   public static Activity getActivity(Context paramContext)
/*    */   {
/*    */     for (;;)
/*    */     {
/* 43 */       if (paramContext == null) {
/* 44 */         return null;
/*    */       }
/* 46 */       if ((paramContext instanceof Activity)) {
/* 47 */         return (Activity)paramContext;
/*    */       }
/* 49 */       if (!(paramContext instanceof ContextWrapper)) break;
/* 50 */       paramContext = ((ContextWrapper)paramContext).getBaseContext();
/*    */     }
/* 52 */     return null;
/*    */   }
/*    */   
/*    */   public static boolean canGetActivity(Context paramContext)
/*    */   {
/* 57 */     return getActivity(paramContext) != null;
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\ContextUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */