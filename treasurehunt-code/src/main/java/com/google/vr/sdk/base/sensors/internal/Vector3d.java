/*     */ package com.google.vr.sdk.base.sensors.internal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Vector3d
/*     */ {
/*     */   public double x;
/*     */   
/*     */ 
/*     */ 
/*     */   public double y;
/*     */   
/*     */ 
/*     */ 
/*     */   public double z;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Vector3d() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Vector3d(double xx, double yy, double zz)
/*     */   {
/*  29 */     set(xx, yy, zz);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void set(double xx, double yy, double zz)
/*     */   {
/*  40 */     this.x = xx;
/*  41 */     this.y = yy;
/*  42 */     this.z = zz;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setComponent(int i, double val)
/*     */   {
/*  53 */     if (i == 0) {
/*  54 */       this.x = val;
/*  55 */     } else if (i == 1) {
/*  56 */       this.y = val;
/*     */     } else {
/*  58 */       this.z = val;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setZero()
/*     */   {
/*  66 */     this.x = (this.y = this.z = 0.0D);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void set(Vector3d other)
/*     */   {
/*  75 */     this.x = other.x;
/*  76 */     this.y = other.y;
/*  77 */     this.z = other.z;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void scale(double s)
/*     */   {
/*  86 */     this.x *= s;
/*  87 */     this.y *= s;
/*  88 */     this.z *= s;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void normalize()
/*     */   {
/*  95 */     double d = length();
/*  96 */     if (d != 0.0D) {
/*  97 */       scale(1.0D / d);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static double dot(Vector3d a, Vector3d b)
/*     */   {
/* 109 */     return a.x * b.x + a.y * b.y + a.z * b.z;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double length()
/*     */   {
/* 118 */     return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean sameValues(Vector3d other)
/*     */   {
/* 127 */     return (this.x == other.x) && (this.y == other.y) && (this.z == other.z);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void add(Vector3d a, Vector3d b, Vector3d result)
/*     */   {
/* 138 */     result.set(a.x + b.x, a.y + b.y, a.z + b.z);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void sub(Vector3d a, Vector3d b, Vector3d result)
/*     */   {
/* 149 */     result.set(a.x - b.x, a.y - b.y, a.z - b.z);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void cross(Vector3d a, Vector3d b, Vector3d result)
/*     */   {
/* 160 */     result.set(a.y * b.z - a.z * b.y, a.z * b.x - a.x * b.z, a.x * b.y - a.y * b.x);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void ortho(Vector3d v, Vector3d result)
/*     */   {
/* 170 */     int k = largestAbsComponent(v) - 1;
/* 171 */     if (k < 0) {
/* 172 */       k = 2;
/*     */     }
/* 174 */     result.setZero();
/* 175 */     result.setComponent(k, 1.0D);
/*     */     
/* 177 */     cross(v, result, result);
/* 178 */     result.normalize();
/*     */   }
/*     */   
/*     */   public String toString() {
/* 182 */     return String.format("%+05f %+05f %+05f", new Object[] { Double.valueOf(this.x), Double.valueOf(this.y), Double.valueOf(this.z) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int largestAbsComponent(Vector3d v)
/*     */   {
/* 191 */     double xAbs = Math.abs(v.x);
/* 192 */     double yAbs = Math.abs(v.y);
/* 193 */     double zAbs = Math.abs(v.z);
/*     */     
/* 195 */     if (xAbs > yAbs) {
/* 196 */       if (xAbs > zAbs) {
/* 197 */         return 0;
/*     */       }
/* 199 */       return 2;
/*     */     }
/*     */     
/* 202 */     if (yAbs > zAbs) {
/* 203 */       return 1;
/*     */     }
/* 205 */     return 2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double maxNorm()
/*     */   {
/* 214 */     return Math.max(Math.abs(this.x), Math.max(Math.abs(this.y), Math.abs(this.z)));
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\sensors\internal\Vector3d.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */