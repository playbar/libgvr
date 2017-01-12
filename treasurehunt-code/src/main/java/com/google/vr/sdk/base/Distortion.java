/*     */ package com.google.vr.sdk.base;
/*     */ 
/*     */ import java.util.Arrays;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Distortion
/*     */ {
/*  27 */   private static final float[] CARDBOARD_V2_2_COEFFICIENTS = { 0.34F, 0.55F };
/*     */   
/*  29 */   private static final float[] CARDBOARD_V1_COEFFICIENTS = { 0.441F, 0.156F };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private float[] coefficients;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Distortion cardboardV1Distortion()
/*     */   {
/*  47 */     Distortion params = new Distortion();
/*  48 */     params.coefficients = ((float[])CARDBOARD_V1_COEFFICIENTS.clone());
/*     */     
/*  50 */     return params;
/*     */   }
/*     */   
/*     */   public Distortion() {
/*  54 */     this.coefficients = ((float[])CARDBOARD_V2_2_COEFFICIENTS.clone());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Distortion(Distortion other)
/*     */   {
/*  63 */     setCoefficients(other.coefficients);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Distortion parseFromProtobuf(float[] coefficients)
/*     */   {
/*  74 */     Distortion distortion = new Distortion();
/*  75 */     distortion.setCoefficients(coefficients);
/*  76 */     return distortion;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float[] toProtobuf()
/*     */   {
/*  86 */     return (float[])this.coefficients.clone();
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
/*     */   public void setCoefficients(float[] coefficients)
/*     */   {
/* 101 */     this.coefficients = (coefficients != null ? (float[])coefficients.clone() : new float[0]);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float[] getCoefficients()
/*     */   {
/* 110 */     return this.coefficients;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float distortionFactor(float radius)
/*     */   {
/* 120 */     float result = 1.0F;
/* 121 */     float rFactor = 1.0F;
/* 122 */     float rSquared = radius * radius;
/*     */     
/* 124 */     for (float ki : this.coefficients) {
/* 125 */       rFactor *= rSquared;
/* 126 */       result += ki * rFactor;
/*     */     }
/*     */     
/* 129 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float distort(float radius)
/*     */   {
/* 139 */     return radius * distortionFactor(radius);
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
/*     */   public float distortInverse(float radius)
/*     */   {
/* 155 */     float r0 = radius / 0.9F;
/* 156 */     float r1 = radius * 0.9F;
/* 157 */     float dr0 = radius - distort(r0);
/* 158 */     while (Math.abs(r1 - r0) > 1.0E-4D) {
/* 159 */       float dr1 = radius - distort(r1);
/* 160 */       float r2 = r1 - dr1 * ((r1 - r0) / (dr1 - dr0));
/* 161 */       r0 = r1;
/* 162 */       r1 = r2;
/* 163 */       dr0 = dr1;
/*     */     }
/* 165 */     return r1;
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
/*     */   private static double[] solveLinear(double[][] a, double[] y)
/*     */   {
/* 182 */     int n = a[0].length;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 190 */     for (int j = 0; j < n - 1; j++) {
/* 191 */       for (int k = j + 1; k < n; k++) {
/* 192 */         double p = a[k][j] / a[j][j];
/* 193 */         for (int i = j + 1; i < n; i++) {
/* 194 */           a[k][i] -= p * a[j][i];
/*     */         }
/* 196 */         y[k] -= p * y[j];
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 202 */     double[] x = new double[n];
/*     */     
/*     */ 
/* 205 */     for (int j = n - 1; j >= 0; j--) {
/* 206 */       double v = y[j];
/* 207 */       for (int i = j + 1; i < n; i++) {
/* 208 */         v -= a[j][i] * x[i];
/*     */       }
/* 210 */       x[j] = (v / a[j][j]);
/*     */     }
/*     */     
/* 213 */     return x;
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
/*     */   private static double[] solveLeastSquares(double[][] matA, double[] vecY)
/*     */   {
/* 231 */     int numSamples = matA.length;
/* 232 */     int numCoefficients = matA[0].length;
/*     */     
/*     */ 
/* 235 */     double[][] matATA = new double[numCoefficients][numCoefficients];
/* 236 */     for (int k = 0; k < numCoefficients; k++) {
/* 237 */       for (int j = 0; j < numCoefficients; j++) {
/* 238 */         double sum = 0.0D;
/* 239 */         for (int i = 0; i < numSamples; i++) {
/* 240 */           sum += matA[i][j] * matA[i][k];
/*     */         }
/* 242 */         matATA[j][k] = sum;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 247 */     double[] vecATY = new double[numCoefficients];
/* 248 */     for (int j = 0; j < numCoefficients; j++) {
/* 249 */       double sum = 0.0D;
/* 250 */       for (int i = 0; i < numSamples; i++) {
/* 251 */         sum += matA[i][j] * vecY[i];
/*     */       }
/* 253 */       vecATY[j] = sum;
/*     */     }
/*     */     
/*     */ 
/* 257 */     return solveLinear(matATA, vecATY);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Distortion getApproximateInverseDistortion(float maxRadius, int numCoefficients)
/*     */   {
/* 296 */     int numSamples = 100;
/*     */     
/* 298 */     double[][] matA = new double[100][numCoefficients];
/* 299 */     double[] vecY = new double[100];
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
/* 311 */     for (int i = 0; i < 100; i++) {
/* 312 */       float r = maxRadius * (i + 1) / 100.0F;
/* 313 */       double rp = distort(r);
/* 314 */       double v = rp;
/* 315 */       for (int j = 0; j < numCoefficients; j++) {
/* 316 */         v *= rp * rp;
/* 317 */         matA[i][j] = v;
/*     */       }
/* 319 */       vecY[i] = (r - rp);
/*     */     }
/*     */     
/* 322 */     double[] vecK = solveLeastSquares(matA, vecY);
/*     */     
/*     */ 
/* 325 */     float[] coefficients = new float[vecK.length];
/* 326 */     for (int i = 0; i < vecK.length; i++) {
/* 327 */       coefficients[i] = ((float)vecK[i]);
/*     */     }
/* 329 */     Distortion inverse = new Distortion();
/* 330 */     inverse.setCoefficients(coefficients);
/* 331 */     return inverse;
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
/*     */   @Deprecated
/*     */   public Distortion getApproximateInverseDistortion(float maxRadius)
/*     */   {
/* 350 */     return getApproximateInverseDistortion(maxRadius, 2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean equals(Object other)
/*     */   {
/* 361 */     if (other == null) {
/* 362 */       return false;
/*     */     }
/*     */     
/* 365 */     if (other == this) {
/* 366 */       return true;
/*     */     }
/*     */     
/* 369 */     if (!(other instanceof Distortion)) {
/* 370 */       return false;
/*     */     }
/*     */     
/* 373 */     Distortion o = (Distortion)other;
/* 374 */     return Arrays.equals(this.coefficients, o.coefficients);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 386 */     StringBuilder builder = new StringBuilder().append("{\n").append("  coefficients: [");
/*     */     
/* 388 */     for (int i = 0; i < this.coefficients.length; i++) {
/* 389 */       builder.append(Float.toString(this.coefficients[i]));
/* 390 */       if (i < this.coefficients.length - 1) {
/* 391 */         builder.append(", ");
/*     */       }
/*     */     }
/*     */     
/* 395 */     builder.append("],\n}");
/* 396 */     return builder.toString();
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\Distortion.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */