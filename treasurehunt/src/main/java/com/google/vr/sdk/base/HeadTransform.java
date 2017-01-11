/*     */ package com.google.vr.sdk.base;
/*     */ 
/*     */ import android.opengl.Matrix;
/*     */ import com.google.vr.cardboard.UsedByNative;
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
/*     */ @UsedByNative
/*     */ public class HeadTransform
/*     */ {
/*     */   private static final float GIMBAL_LOCK_EPSILON = 0.01F;
/*     */   private final float[] headView;
/*     */   
/*     */   public HeadTransform()
/*     */   {
/*  34 */     this.headView = new float[16];
/*  35 */     Matrix.setIdentityM(this.headView, 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @UsedByNative
/*     */   public float[] getHeadView()
/*     */   {
/*  48 */     return this.headView;
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
/*     */   public void getHeadView(float[] headView, int offset)
/*     */   {
/*  62 */     if (offset + 16 > headView.length) {
/*  63 */       throw new IllegalArgumentException("Not enough space to write the result");
/*     */     }
/*     */     
/*  66 */     System.arraycopy(this.headView, 0, headView, offset, 16);
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
/*     */   public void getForwardVector(float[] forward, int offset)
/*     */   {
/*  81 */     if (offset + 3 > forward.length) {
/*  82 */       throw new IllegalArgumentException("Not enough space to write the result");
/*     */     }
/*     */     
/*     */ 
/*  86 */     for (int i = 0; i < 3; i++) {
/*  87 */       forward[(i + offset)] = (-this.headView[(2 + i * 4)]);
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
/*     */   public void getUpVector(float[] up, int offset)
/*     */   {
/* 100 */     if (offset + 3 > up.length) {
/* 101 */       throw new IllegalArgumentException("Not enough space to write the result");
/*     */     }
/*     */     
/*     */ 
/* 105 */     for (int i = 0; i < 3; i++) {
/* 106 */       up[(i + offset)] = this.headView[(1 + i * 4)];
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
/*     */   public void getRightVector(float[] right, int offset)
/*     */   {
/* 119 */     if (offset + 3 > right.length) {
/* 120 */       throw new IllegalArgumentException("Not enough space to write the result");
/*     */     }
/*     */     
/*     */ 
/* 124 */     for (int i = 0; i < 3; i++) {
/* 125 */       right[(i + offset)] = this.headView[(i * 4)];
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
/*     */   public void getQuaternion(float[] quaternion, int offset)
/*     */   {
/* 138 */     if (offset + 4 > quaternion.length) {
/* 139 */       throw new IllegalArgumentException("Not enough space to write the result");
/*     */     }
/*     */     
/*     */ 
/* 143 */     float[] m = this.headView;
/* 144 */     float t = m[0] + m[5] + m[10];
/*     */     float z;
/*     */     float z;
/* 147 */     float x; float y; float w; if (t >= 0.0F) {
/* 148 */       float s = (float)Math.sqrt(t + 1.0F);
/* 149 */       float w = 0.5F * s;
/* 150 */       s = 0.5F / s;
/* 151 */       float x = (m[9] - m[6]) * s;
/* 152 */       float y = (m[2] - m[8]) * s;
/* 153 */       z = (m[4] - m[1]) * s;
/*     */     } else { float w;
/* 155 */       if ((m[0] > m[5]) && (m[0] > m[10])) {
/* 156 */         float s = (float)Math.sqrt(1.0F + m[0] - m[5] - m[10]);
/* 157 */         float x = s * 0.5F;
/* 158 */         s = 0.5F / s;
/* 159 */         float y = (m[4] + m[1]) * s;
/* 160 */         float z = (m[2] + m[8]) * s;
/* 161 */         w = (m[9] - m[6]) * s;
/*     */       } else { float w;
/* 163 */         if (m[5] > m[10]) {
/* 164 */           float s = (float)Math.sqrt(1.0F + m[5] - m[0] - m[10]);
/* 165 */           float y = s * 0.5F;
/* 166 */           s = 0.5F / s;
/* 167 */           float x = (m[4] + m[1]) * s;
/* 168 */           float z = (m[9] + m[6]) * s;
/* 169 */           w = (m[2] - m[8]) * s;
/*     */         }
/*     */         else {
/* 172 */           float s = (float)Math.sqrt(1.0F + m[10] - m[0] - m[5]);
/* 173 */           z = s * 0.5F;
/* 174 */           s = 0.5F / s;
/* 175 */           x = (m[2] + m[8]) * s;
/* 176 */           y = (m[9] + m[6]) * s;
/* 177 */           w = (m[4] - m[1]) * s;
/*     */         }
/*     */       } }
/* 180 */     quaternion[(offset + 0)] = x;
/* 181 */     quaternion[(offset + 1)] = y;
/* 182 */     quaternion[(offset + 2)] = z;
/* 183 */     quaternion[(offset + 3)] = w;
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
/*     */   public void getEulerAngles(float[] eulerAngles, int offset)
/*     */   {
/* 212 */     if (offset + 3 > eulerAngles.length) {
/* 213 */       throw new IllegalArgumentException("Not enough space to write the result");
/*     */     }
/*     */     
/*     */ 
/* 217 */     float pitch = (float)Math.asin(this.headView[6]);
/*     */     float roll;
/*     */     float yaw;
/*     */     float roll;
/* 221 */     if (Math.sqrt(1.0F - this.headView[6] * this.headView[6]) >= 0.009999999776482582D)
/*     */     {
/*     */ 
/* 224 */       float yaw = (float)Math.atan2(-this.headView[2], this.headView[10]);
/* 225 */       roll = (float)Math.atan2(-this.headView[4], this.headView[5]);
/*     */     }
/*     */     else
/*     */     {
/* 229 */       yaw = 0.0F;
/* 230 */       roll = (float)Math.atan2(this.headView[1], this.headView[0]);
/*     */     }
/*     */     
/* 233 */     eulerAngles[(offset + 0)] = (-pitch);
/* 234 */     eulerAngles[(offset + 1)] = (-yaw);
/* 235 */     eulerAngles[(offset + 2)] = (-roll);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void getTranslation(float[] translation, int offset)
/*     */   {
/* 247 */     if (offset + 3 > translation.length) {
/* 248 */       throw new IllegalArgumentException("Not enough space to write the result");
/*     */     }
/*     */     
/*     */ 
/* 252 */     for (int i = 0; i < 3; i++) {
/* 253 */       translation[(i + offset)] = this.headView[(12 + i)];
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\HeadTransform.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */