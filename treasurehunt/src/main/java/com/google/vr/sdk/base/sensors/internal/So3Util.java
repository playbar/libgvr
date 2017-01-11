/*     */ package com.google.vr.sdk.base.sensors.internal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class So3Util
/*     */ {
/*     */   private static final double M_SQRT1_2 = 0.7071067811865476D;
/*     */   
/*     */ 
/*     */   private static final double ONE_6TH = 0.1666666716337204D;
/*     */   
/*     */ 
/*     */   private static final double ONE_20TH = 0.1666666716337204D;
/*     */   
/*     */ 
/*  17 */   private static Vector3d temp31 = new Vector3d();
/*  18 */   private static Vector3d sO3FromTwoVecN = new Vector3d();
/*  19 */   private static Vector3d sO3FromTwoVecA = new Vector3d();
/*  20 */   private static Vector3d sO3FromTwoVecB = new Vector3d();
/*  21 */   private static Vector3d sO3FromTwoVecRotationAxis = new Vector3d();
/*  22 */   private static Matrix3x3d sO3FromTwoVec33R1 = new Matrix3x3d();
/*  23 */   private static Matrix3x3d sO3FromTwoVec33R2 = new Matrix3x3d();
/*  24 */   private static Vector3d muFromSO3R2 = new Vector3d();
/*  25 */   private static Vector3d rotationPiAboutAxisTemp = new Vector3d();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void sO3FromTwoVec(Vector3d a, Vector3d b, Matrix3x3d result)
/*     */   {
/*  38 */     Vector3d.cross(a, b, sO3FromTwoVecN);
/*  39 */     if (sO3FromTwoVecN.length() == 0.0D)
/*     */     {
/*  41 */       double dot = Vector3d.dot(a, b);
/*  42 */       if (dot >= 0.0D) {
/*  43 */         result.setIdentity();
/*     */       } else {
/*  45 */         Vector3d.ortho(a, sO3FromTwoVecRotationAxis);
/*  46 */         rotationPiAboutAxis(sO3FromTwoVecRotationAxis, result);
/*     */       }
/*  48 */       return;
/*     */     }
/*     */     
/*     */ 
/*  52 */     sO3FromTwoVecA.set(a);
/*  53 */     sO3FromTwoVecB.set(b);
/*     */     
/*     */ 
/*  56 */     sO3FromTwoVecN.normalize();
/*  57 */     sO3FromTwoVecA.normalize();
/*  58 */     sO3FromTwoVecB.normalize();
/*     */     
/*  60 */     Matrix3x3d r1 = sO3FromTwoVec33R1;
/*  61 */     r1.setColumn(0, sO3FromTwoVecA);
/*  62 */     r1.setColumn(1, sO3FromTwoVecN);
/*  63 */     Vector3d.cross(sO3FromTwoVecN, sO3FromTwoVecA, temp31);
/*  64 */     r1.setColumn(2, temp31);
/*     */     
/*  66 */     Matrix3x3d r2 = sO3FromTwoVec33R2;
/*  67 */     r2.setColumn(0, sO3FromTwoVecB);
/*  68 */     r2.setColumn(1, sO3FromTwoVecN);
/*  69 */     Vector3d.cross(sO3FromTwoVecN, sO3FromTwoVecB, temp31);
/*  70 */     r2.setColumn(2, temp31);
/*     */     
/*  72 */     r1.transpose();
/*  73 */     Matrix3x3d.mult(r2, r1, result);
/*     */   }
/*     */   
/*     */   private static void rotationPiAboutAxis(Vector3d v, Matrix3x3d result)
/*     */   {
/*  78 */     rotationPiAboutAxisTemp.set(v);
/*  79 */     rotationPiAboutAxisTemp.scale(3.141592653589793D / rotationPiAboutAxisTemp.length());
/*  80 */     double invTheta = 0.3183098861837907D;
/*     */     
/*  82 */     double kA = 0.0D;
/*     */     
/*  84 */     double kB = 0.20264236728467558D;
/*  85 */     rodriguesSo3Exp(rotationPiAboutAxisTemp, kA, kB, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void sO3FromMu(Vector3d w, Matrix3x3d result)
/*     */   {
/*  95 */     double thetaSq = Vector3d.dot(w, w);
/*  96 */     double theta = Math.sqrt(thetaSq);
/*     */     double kB;
/*     */     double kA;
/*  99 */     double kB; if (thetaSq < 1.0E-8D) {
/* 100 */       double kA = 1.0D - 0.1666666716337204D * thetaSq;
/* 101 */       kB = 0.5D;
/*     */     } else { double kA;
/* 103 */       if (thetaSq < 1.0E-6D) {
/* 104 */         double kB = 0.5D - 0.0416666679084301D * thetaSq;
/* 105 */         kA = 1.0D - thetaSq * 0.1666666716337204D * (1.0D - 0.1666666716337204D * thetaSq);
/*     */       } else {
/* 107 */         double invTheta = 1.0D / theta;
/* 108 */         kA = Math.sin(theta) * invTheta;
/* 109 */         kB = (1.0D - Math.cos(theta)) * (invTheta * invTheta);
/*     */       }
/*     */     }
/* 112 */     rodriguesSo3Exp(w, kA, kB, result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void muFromSO3(Matrix3x3d so3, Vector3d result)
/*     */   {
/* 123 */     double cosAngle = (so3.get(0, 0) + so3.get(1, 1) + so3.get(2, 2) - 1.0D) * 0.5D;
/* 124 */     result.set((so3.get(2, 1) - so3.get(1, 2)) / 2.0D, 
/* 125 */       (so3.get(0, 2) - so3.get(2, 0)) / 2.0D, 
/* 126 */       (so3.get(1, 0) - so3.get(0, 1)) / 2.0D);
/*     */     
/* 128 */     double sinAngleAbs = result.length();
/* 129 */     if (cosAngle > 0.7071067811865476D)
/*     */     {
/* 131 */       if (sinAngleAbs > 0.0D) {
/* 132 */         result.scale(Math.asin(sinAngleAbs) / sinAngleAbs);
/*     */       }
/* 134 */     } else if (cosAngle > -0.7071067811865476D)
/*     */     {
/* 136 */       double angle = Math.acos(cosAngle);
/* 137 */       result.scale(angle / sinAngleAbs);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 142 */       double angle = 3.141592653589793D - Math.asin(sinAngleAbs);
/* 143 */       double d0 = so3.get(0, 0) - cosAngle;
/* 144 */       double d1 = so3.get(1, 1) - cosAngle;
/* 145 */       double d2 = so3.get(2, 2) - cosAngle;
/*     */       
/* 147 */       Vector3d r2 = muFromSO3R2;
/* 148 */       if ((d0 * d0 > d1 * d1) && (d0 * d0 > d2 * d2))
/*     */       {
/* 150 */         r2.set(d0, (so3.get(1, 0) + so3.get(0, 1)) / 2.0D, 
/* 151 */           (so3.get(0, 2) + so3.get(2, 0)) / 2.0D);
/* 152 */       } else if (d1 * d1 > d2 * d2)
/*     */       {
/* 154 */         r2.set((so3.get(1, 0) + so3.get(0, 1)) / 2.0D, d1, 
/* 155 */           (so3.get(2, 1) + so3.get(1, 2)) / 2.0D);
/*     */       }
/*     */       else {
/* 158 */         r2.set((so3.get(0, 2) + so3.get(2, 0)) / 2.0D, 
/* 159 */           (so3.get(2, 1) + so3.get(1, 2)) / 2.0D, d2);
/*     */       }
/*     */       
/* 162 */       if (Vector3d.dot(r2, result) < 0.0D) {
/* 163 */         r2.scale(-1.0D);
/*     */       }
/* 165 */       r2.normalize();
/* 166 */       r2.scale(angle);
/* 167 */       result.set(r2);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void rodriguesSo3Exp(Vector3d w, double kA, double kB, Matrix3x3d result)
/*     */   {
/* 185 */     double wx2 = w.x * w.x;
/* 186 */     double wy2 = w.y * w.y;
/* 187 */     double wz2 = w.z * w.z;
/*     */     
/* 189 */     result.set(0, 0, 1.0D - kB * (wy2 + wz2));
/* 190 */     result.set(1, 1, 1.0D - kB * (wx2 + wz2));
/* 191 */     result.set(2, 2, 1.0D - kB * (wx2 + wy2));
/*     */     
/*     */ 
/* 194 */     double a = kA * w.z;
/* 195 */     double b = kB * (w.x * w.y);
/* 196 */     result.set(0, 1, b - a);
/* 197 */     result.set(1, 0, b + a);
/*     */     
/*     */ 
/* 200 */     double a = kA * w.y;
/* 201 */     double b = kB * (w.x * w.z);
/* 202 */     result.set(0, 2, b + a);
/* 203 */     result.set(2, 0, b - a);
/*     */     
/*     */ 
/* 206 */     double a = kA * w.x;
/* 207 */     double b = kB * (w.y * w.z);
/* 208 */     result.set(1, 2, b - a);
/* 209 */     result.set(2, 1, b + a);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void generatorField(int i, Matrix3x3d pos, Matrix3x3d result)
/*     */   {
/* 221 */     result.set(i, 0, 0.0D);
/* 222 */     result.set((i + 1) % 3, 0, -pos.get((i + 2) % 3, 0));
/* 223 */     result.set((i + 2) % 3, 0, pos.get((i + 1) % 3, 0));
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\sensors\internal\So3Util.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */