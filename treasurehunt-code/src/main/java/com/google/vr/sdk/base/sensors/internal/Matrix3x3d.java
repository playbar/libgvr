/*     */ package com.google.vr.sdk.base.sensors.internal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Matrix3x3d
/*     */ {
/*  12 */   public double[] m = new double[9];
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Matrix3x3d() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Matrix3x3d(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22)
/*     */   {
/*  30 */     this.m[0] = m00;
/*  31 */     this.m[1] = m01;
/*  32 */     this.m[2] = m02;
/*  33 */     this.m[3] = m10;
/*  34 */     this.m[4] = m11;
/*  35 */     this.m[5] = m12;
/*  36 */     this.m[6] = m20;
/*  37 */     this.m[7] = m21;
/*  38 */     this.m[8] = m22;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Matrix3x3d(Matrix3x3d o)
/*     */   {
/*  47 */     this.m[0] = o.m[0];
/*  48 */     this.m[1] = o.m[1];
/*  49 */     this.m[2] = o.m[2];
/*  50 */     this.m[3] = o.m[3];
/*  51 */     this.m[4] = o.m[4];
/*  52 */     this.m[5] = o.m[5];
/*  53 */     this.m[6] = o.m[6];
/*  54 */     this.m[7] = o.m[7];
/*  55 */     this.m[8] = o.m[8];
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
/*     */   public void set(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22)
/*     */   {
/*  68 */     this.m[0] = m00;
/*  69 */     this.m[1] = m01;
/*  70 */     this.m[2] = m02;
/*  71 */     this.m[3] = m10;
/*  72 */     this.m[4] = m11;
/*  73 */     this.m[5] = m12;
/*  74 */     this.m[6] = m20;
/*  75 */     this.m[7] = m21;
/*  76 */     this.m[8] = m22;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void set(Matrix3x3d o)
/*     */   {
/*  85 */     this.m[0] = o.m[0];
/*  86 */     this.m[1] = o.m[1];
/*  87 */     this.m[2] = o.m[2];
/*  88 */     this.m[3] = o.m[3];
/*  89 */     this.m[4] = o.m[4];
/*  90 */     this.m[5] = o.m[5];
/*  91 */     this.m[6] = o.m[6];
/*  92 */     this.m[7] = o.m[7];
/*  93 */     this.m[8] = o.m[8];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setZero()
/*     */   {
/* 100 */     this.m[0] = (this.m[1] = this.m[2] = this.m[3] = this.m[4] = this.m[5] = this.m[6] = this.m[7] = this.m[8] = 0.0D);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIdentity()
/*     */   {
/* 107 */     this.m[1] = (this.m[2] = this.m[3] = this.m[5] = this.m[6] = this.m[7] = 0.0D);
/* 108 */     this.m[0] = (this.m[4] = this.m[8] = 1.0D);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSameDiagonal(double d)
/*     */   {
/* 117 */     this.m[0] = (this.m[4] = this.m[8] = d);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double get(int row, int col)
/*     */   {
/* 128 */     return this.m[(3 * row + col)];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void set(int row, int col, double value)
/*     */   {
/* 139 */     this.m[(3 * row + col)] = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void getColumn(int col, Vector3d v)
/*     */   {
/* 149 */     v.x = this.m[col];
/* 150 */     v.y = this.m[(col + 3)];
/* 151 */     v.z = this.m[(col + 6)];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setColumn(int col, Vector3d v)
/*     */   {
/* 161 */     this.m[col] = v.x;
/* 162 */     this.m[(col + 3)] = v.y;
/* 163 */     this.m[(col + 6)] = v.z;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void scale(double s)
/*     */   {
/* 172 */     this.m[0] *= s;
/* 173 */     this.m[1] *= s;
/* 174 */     this.m[2] *= s;
/* 175 */     this.m[3] *= s;
/* 176 */     this.m[4] *= s;
/* 177 */     this.m[5] *= s;
/* 178 */     this.m[6] *= s;
/* 179 */     this.m[7] *= s;
/* 180 */     this.m[8] *= s;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void plusEquals(Matrix3x3d b)
/*     */   {
/* 189 */     this.m[0] += b.m[0];
/* 190 */     this.m[1] += b.m[1];
/* 191 */     this.m[2] += b.m[2];
/* 192 */     this.m[3] += b.m[3];
/* 193 */     this.m[4] += b.m[4];
/* 194 */     this.m[5] += b.m[5];
/* 195 */     this.m[6] += b.m[6];
/* 196 */     this.m[7] += b.m[7];
/* 197 */     this.m[8] += b.m[8];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void minusEquals(Matrix3x3d b)
/*     */   {
/* 206 */     this.m[0] -= b.m[0];
/* 207 */     this.m[1] -= b.m[1];
/* 208 */     this.m[2] -= b.m[2];
/* 209 */     this.m[3] -= b.m[3];
/* 210 */     this.m[4] -= b.m[4];
/* 211 */     this.m[5] -= b.m[5];
/* 212 */     this.m[6] -= b.m[6];
/* 213 */     this.m[7] -= b.m[7];
/* 214 */     this.m[8] -= b.m[8];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void transpose()
/*     */   {
/* 221 */     double tmp = this.m[1];
/* 222 */     this.m[1] = this.m[3];
/* 223 */     this.m[3] = tmp;
/*     */     
/* 225 */     tmp = this.m[2];
/* 226 */     this.m[2] = this.m[6];
/* 227 */     this.m[6] = tmp;
/*     */     
/* 229 */     tmp = this.m[5];
/* 230 */     this.m[5] = this.m[7];
/* 231 */     this.m[7] = tmp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void transpose(Matrix3x3d result)
/*     */   {
/* 240 */     double m1 = this.m[1];
/* 241 */     double m2 = this.m[2];
/* 242 */     double m5 = this.m[5];
/* 243 */     result.m[0] = this.m[0];
/* 244 */     result.m[1] = this.m[3];
/* 245 */     result.m[2] = this.m[6];
/* 246 */     result.m[3] = m1;
/* 247 */     result.m[4] = this.m[4];
/* 248 */     result.m[5] = this.m[7];
/* 249 */     result.m[6] = m2;
/* 250 */     result.m[7] = m5;
/* 251 */     result.m[8] = this.m[8];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void add(Matrix3x3d a, Matrix3x3d b, Matrix3x3d result)
/*     */   {
/* 262 */     a.m[0] += b.m[0];
/* 263 */     a.m[1] += b.m[1];
/* 264 */     a.m[2] += b.m[2];
/* 265 */     a.m[3] += b.m[3];
/* 266 */     a.m[4] += b.m[4];
/* 267 */     a.m[5] += b.m[5];
/* 268 */     a.m[6] += b.m[6];
/* 269 */     a.m[7] += b.m[7];
/* 270 */     a.m[8] += b.m[8];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void mult(Matrix3x3d a, Matrix3x3d b, Matrix3x3d result)
/*     */   {
/* 281 */     result.set(a.m[0] * b.m[0] + a.m[1] * b.m[3] + a.m[2] * b.m[6], a.m[0] * b.m[1] + a.m[1] * b.m[4] + a.m[2] * b.m[7], a.m[0] * b.m[2] + a.m[1] * b.m[5] + a.m[2] * b.m[8], a.m[3] * b.m[0] + a.m[4] * b.m[3] + a.m[5] * b.m[6], a.m[3] * b.m[1] + a.m[4] * b.m[4] + a.m[5] * b.m[7], a.m[3] * b.m[2] + a.m[4] * b.m[5] + a.m[5] * b.m[8], a.m[6] * b.m[0] + a.m[7] * b.m[3] + a.m[8] * b.m[6], a.m[6] * b.m[1] + a.m[7] * b.m[4] + a.m[8] * b.m[7], a.m[6] * b.m[2] + a.m[7] * b.m[5] + a.m[8] * b.m[8]);
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
/*     */ 
/*     */ 
/*     */   public static void mult(Matrix3x3d a, Vector3d v, Vector3d result)
/*     */   {
/* 300 */     double x = a.m[0] * v.x + a.m[1] * v.y + a.m[2] * v.z;
/* 301 */     double y = a.m[3] * v.x + a.m[4] * v.y + a.m[5] * v.z;
/* 302 */     double z = a.m[6] * v.x + a.m[7] * v.y + a.m[8] * v.z;
/* 303 */     result.x = x;
/* 304 */     result.y = y;
/* 305 */     result.z = z;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double determinant()
/*     */   {
/* 314 */     return 
/*     */     
/* 316 */       get(0, 0) * (get(1, 1) * get(2, 2) - get(2, 1) * get(1, 2)) - get(0, 1) * (get(1, 0) * get(2, 2) - get(1, 2) * get(2, 0)) + get(0, 2) * (get(1, 0) * get(2, 1) - get(1, 1) * get(2, 0));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean invert(Matrix3x3d result)
/*     */   {
/* 325 */     double d = determinant();
/* 326 */     if (d == 0.0D) {
/* 327 */       return false;
/*     */     }
/*     */     
/* 330 */     double invdet = 1.0D / d;
/*     */     
/* 332 */     result.set((this.m[4] * this.m[8] - this.m[7] * this.m[5]) * invdet, -(this.m[1] * this.m[8] - this.m[2] * this.m[7]) * invdet, (this.m[1] * this.m[5] - this.m[2] * this.m[4]) * invdet, -(this.m[3] * this.m[8] - this.m[5] * this.m[6]) * invdet, (this.m[0] * this.m[8] - this.m[2] * this.m[6]) * invdet, -(this.m[0] * this.m[5] - this.m[3] * this.m[2]) * invdet, (this.m[3] * this.m[7] - this.m[6] * this.m[4]) * invdet, -(this.m[0] * this.m[7] - this.m[6] * this.m[1]) * invdet, (this.m[0] * this.m[4] - this.m[3] * this.m[1]) * invdet);
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
/* 345 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public double maxNorm()
/*     */   {
/* 352 */     double maxVal = Math.abs(this.m[0]);
/* 353 */     for (int i = 1; i < this.m.length; i++) {
/* 354 */       maxVal = Math.max(maxVal, Math.abs(this.m[i]));
/*     */     }
/* 356 */     return maxVal;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\sensors\internal\Matrix3x3d.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */