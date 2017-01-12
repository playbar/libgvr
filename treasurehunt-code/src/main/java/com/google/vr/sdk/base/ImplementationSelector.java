/*    */ package com.google.vr.sdk.base;
/*    */ 
/*    */ import android.content.Context;
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
/*    */ public class ImplementationSelector
/*    */ {
/*    */   public static CardboardViewApi createCardboardViewApi(Context context)
/*    */   {
/* 34 */     return new CardboardViewNativeImpl(context);
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\ImplementationSelector.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */