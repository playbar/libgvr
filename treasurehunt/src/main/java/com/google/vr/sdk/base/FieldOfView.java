/*     */ package com.google.vr.sdk.base;
/*     */ 
/*     */ import android.opengl.Matrix;
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
/*     */ public class FieldOfView
/*     */ {
/*     */   private static final float CARDBOARD_V2_2_MAX_FOV_LEFT_RIGHT = 60.0F;
/*     */   private static final float CARDBOARD_V2_2_MAX_FOV_BOTTOM = 60.0F;
/*     */   private static final float CARDBOARD_V2_2_MAX_FOV_TOP = 60.0F;
/*     */   private static final float CARDBOARD_V1_MAX_FOV_LEFT_RIGHT = 40.0F;
/*     */   private static final float CARDBOARD_V1_MAX_FOV_BOTTOM = 40.0F;
/*     */   private static final float CARDBOARD_V1_MAX_FOV_TOP = 40.0F;
/*     */   private float left;
/*     */   private float right;
/*     */   private float bottom;
/*     */   private float top;
/*     */   
/*     */   public FieldOfView()
/*     */   {
/*  45 */     this.left = 60.0F;
/*  46 */     this.right = 60.0F;
/*  47 */     this.bottom = 60.0F;
/*  48 */     this.top = 60.0F;
/*     */   }
/*     */   
/*     */   public static FieldOfView cardboardV1FieldOfView()
/*     */   {
/*  53 */     FieldOfView params = new FieldOfView();
/*  54 */     params.setAngles(40.0F, 40.0F, 40.0F, 40.0F);
/*     */     
/*     */ 
/*  57 */     return params;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public FieldOfView(float left, float right, float bottom, float top)
/*     */   {
/*  69 */     setAngles(left, right, bottom, top);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public FieldOfView(FieldOfView other)
/*     */   {
/*  78 */     copy(other);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static FieldOfView parseFromProtobuf(float[] angles)
/*     */   {
/*  89 */     if (angles.length != 4) {
/*  90 */       return null;
/*     */     }
/*     */     
/*  93 */     return new FieldOfView(angles[0], angles[1], angles[2], angles[3]);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float[] toProtobuf()
/*     */   {
/* 103 */     return new float[] { this.left, this.right, this.bottom, this.top };
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void copy(FieldOfView other)
/*     */   {
/* 112 */     this.left = other.left;
/* 113 */     this.right = other.right;
/* 114 */     this.bottom = other.bottom;
/* 115 */     this.top = other.top;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAngles(float left, float right, float bottom, float top)
/*     */   {
/* 127 */     this.left = left;
/* 128 */     this.right = right;
/* 129 */     this.bottom = bottom;
/* 130 */     this.top = top;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLeft(float left)
/*     */   {
/* 139 */     this.left = left;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getLeft()
/*     */   {
/* 148 */     return this.left;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRight(float right)
/*     */   {
/* 157 */     this.right = right;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getRight()
/*     */   {
/* 166 */     return this.right;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBottom(float bottom)
/*     */   {
/* 175 */     this.bottom = bottom;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getBottom()
/*     */   {
/* 184 */     return this.bottom;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTop(float top)
/*     */   {
/* 193 */     this.top = top;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getTop()
/*     */   {
/* 202 */     return this.top;
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
/*     */   public void toPerspectiveMatrix(float near, float far, float[] perspective, int offset)
/*     */   {
/* 216 */     if (offset + 16 > perspective.length) {
/* 217 */       throw new IllegalArgumentException("Not enough space to write the result");
/*     */     }
/*     */     
/* 220 */     float l = (float)-Math.tan(Math.toRadians(this.left)) * near;
/* 221 */     float r = (float)Math.tan(Math.toRadians(this.right)) * near;
/* 222 */     float b = (float)-Math.tan(Math.toRadians(this.bottom)) * near;
/* 223 */     float t = (float)Math.tan(Math.toRadians(this.top)) * near;
/* 224 */     Matrix.frustumM(perspective, offset, l, r, b, t, near, far);
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
/* 235 */     if (other == null) {
/* 236 */       return false;
/*     */     }
/*     */     
/* 239 */     if (other == this) {
/* 240 */       return true;
/*     */     }
/*     */     
/* 243 */     if (!(other instanceof FieldOfView)) {
/* 244 */       return false;
/*     */     }
/*     */     
/* 247 */     FieldOfView o = (FieldOfView)other;
/* 248 */     return (this.left == o.left) && (this.right == o.right) && (this.bottom == o.bottom) && (this.top == o.top);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 259 */     float f = this.left;
/* 260 */     f = this.right;
/* 261 */     f = this.bottom;
/* 262 */     f = this.top;return "{\n" + new StringBuilder(25).append("  left: ").append(f).append(",\n").toString() + new StringBuilder(26).append("  right: ").append(f).append(",\n").toString() + new StringBuilder(27).append("  bottom: ").append(f).append(",\n").toString() + new StringBuilder(24).append("  top: ").append(f).append(",\n").toString() + 
/* 263 */       "}";
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\FieldOfView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */