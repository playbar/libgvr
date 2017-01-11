/*    */ package com.google.vr.sdk.base.testing;
/*    */ 
/*    */ import com.google.vr.sdk.base.sensors.internal.Matrix3x3d;
/*    */ import com.google.vr.sdk.base.sensors.internal.Vector3d;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class MathUtil
/*    */ {
/*    */   public static double vectorDiffNorm(Vector3d expected, Vector3d actual)
/*    */   {
/* 16 */     Vector3d diff = new Vector3d();
/* 17 */     Vector3d.sub(expected, actual, diff);
/* 18 */     return diff.maxNorm();
/*    */   }
/*    */   
/*    */   public static double matrixDiffNorm(Matrix3x3d expected, Matrix3x3d actual)
/*    */   {
/* 23 */     Matrix3x3d diff = new Matrix3x3d(expected);
/* 24 */     diff.minusEquals(actual);
/* 25 */     return diff.maxNorm();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static Vector3d vectorFromScalar(double x)
/*    */   {
/* 32 */     return new Vector3d(x, -0.5D * x, 0.8D * x);
/*    */   }
/*    */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\testing\MathUtil.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */