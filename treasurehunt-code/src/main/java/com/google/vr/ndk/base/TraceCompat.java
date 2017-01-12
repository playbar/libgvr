/*    */ package com.google.vr.ndk.base;
/*    */ 
/*    */ import android.os.Build.VERSION;
/*    */ import android.os.Trace;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class TraceCompat
/*    */ {
/*    */   static void beginSection(String paramString)
/*    */   {
/* 13 */     if (VERSION.SDK_INT >= 18) {
/* 14 */       Trace.beginSection(paramString);
/*    */     }
/*    */   }
/*    */   
/*    */   static void endSection() {
/* 19 */     if (VERSION.SDK_INT >= 18) {
/* 20 */       Trace.endSection();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\ndk\base\TraceCompat.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */