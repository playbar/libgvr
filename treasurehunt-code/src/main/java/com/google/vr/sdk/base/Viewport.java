/*     */ package com.google.vr.sdk.base;
/*     */ 
/*     */ import android.opengl.GLES20;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @UsedByNative
/*     */ public class Viewport
/*     */ {
/*     */   public int x;
/*     */   public int y;
/*     */   public int width;
/*     */   public int height;
/*     */   
/*     */   @UsedByNative
/*     */   public void setViewport(int x, int y, int width, int height)
/*     */   {
/*  42 */     this.x = x;
/*  43 */     this.y = y;
/*  44 */     this.width = width;
/*  45 */     this.height = height;
/*     */   }
/*     */   
/*     */   public void setGLViewport()
/*     */   {
/*  50 */     GLES20.glViewport(this.x, this.y, this.width, this.height);
/*     */   }
/*     */   
/*     */   public void setGLScissor()
/*     */   {
/*  55 */     GLES20.glScissor(this.x, this.y, this.width, this.height);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void getAsArray(int[] array, int offset)
/*     */   {
/*  67 */     if (offset + 4 > array.length) {
/*  68 */       throw new IllegalArgumentException("Not enough space to write the result");
/*     */     }
/*     */     
/*  71 */     array[offset] = this.x;
/*  72 */     array[(offset + 1)] = this.y;
/*  73 */     array[(offset + 2)] = this.width;
/*  74 */     array[(offset + 3)] = this.height;
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
/*  85 */     int i = this.x;
/*  86 */     i = this.y;
/*  87 */     i = this.width;
/*  88 */     i = this.height;return "{\n" + new StringBuilder(18).append("  x: ").append(i).append(",\n").toString() + new StringBuilder(18).append("  y: ").append(i).append(",\n").toString() + new StringBuilder(22).append("  width: ").append(i).append(",\n").toString() + new StringBuilder(23).append("  height: ").append(i).append(",\n").toString() + 
/*  89 */       "}";
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/*  96 */     if (obj == this) {
/*  97 */       return true;
/*     */     }
/*  99 */     if (!(obj instanceof Viewport)) {
/* 100 */       return false;
/*     */     }
/* 102 */     Viewport other = (Viewport)obj;
/* 103 */     return (this.x == other.x) && (this.y == other.y) && (this.width == other.width) && (this.height == other.height);
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 108 */     return 
/* 109 */       Integer.valueOf(this.x).hashCode() ^ Integer.valueOf(this.y).hashCode() ^ Integer.valueOf(this.width).hashCode() ^ Integer.valueOf(this.height).hashCode();
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\Viewport.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */