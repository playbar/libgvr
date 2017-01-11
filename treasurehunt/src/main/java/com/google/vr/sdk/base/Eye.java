/*     */ package com.google.vr.sdk.base;
/*     */ 
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
/*     */ public class Eye
/*     */ {
/*     */   private final int type;
/*     */   private final float[] eyeView;
/*     */   private final Viewport viewport;
/*     */   private final FieldOfView fov;
/*     */   private volatile boolean projectionChanged;
/*     */   private float[] perspective;
/*     */   private float lastZNear;
/*     */   private float lastZFar;
/*     */   
/*     */   @UsedByNative
/*     */   public Eye(int type)
/*     */   {
/*  58 */     this.type = type;
/*  59 */     this.eyeView = new float[16];
/*  60 */     this.viewport = new Viewport();
/*  61 */     this.fov = new FieldOfView();
/*  62 */     this.projectionChanged = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  71 */     return this.type;
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
/*     */   @UsedByNative
/*     */   public float[] getEyeView()
/*     */   {
/*  90 */     return this.eyeView;
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
/*     */   public float[] getPerspective(float zNear, float zFar)
/*     */   {
/* 104 */     if ((!this.projectionChanged) && (this.lastZNear == zNear) && (this.lastZFar == zFar)) {
/* 105 */       return this.perspective;
/*     */     }
/*     */     
/* 108 */     if (this.perspective == null) {
/* 109 */       this.perspective = new float[16];
/*     */     }
/*     */     
/* 112 */     getFov().toPerspectiveMatrix(zNear, zFar, this.perspective, 0);
/*     */     
/* 114 */     this.lastZNear = zNear;
/* 115 */     this.lastZFar = zFar;
/* 116 */     this.projectionChanged = false;
/*     */     
/* 118 */     return this.perspective;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Viewport getViewport()
/*     */   {
/* 127 */     return this.viewport;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public FieldOfView getFov()
/*     */   {
/* 139 */     return this.fov;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setProjectionChanged()
/*     */   {
/* 149 */     this.projectionChanged = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean getProjectionChanged()
/*     */   {
/* 158 */     return this.projectionChanged;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @UsedByNative
/*     */   private void setValues(int viewportX, int viewportY, int viewportWidth, int viewportHeight, float fovLeft, float fovRight, float fovBottom, float fovTop)
/*     */   {
/* 169 */     this.viewport.setViewport(viewportX, viewportY, viewportWidth, viewportHeight);
/* 170 */     this.fov.setAngles(fovLeft, fovRight, fovBottom, fovTop);
/* 171 */     this.projectionChanged = true;
/*     */   }
/*     */   
/*     */   public static abstract class Type
/*     */   {
/*     */     public static final int MONOCULAR = 0;
/*     */     public static final int LEFT = 1;
/*     */     public static final int RIGHT = 2;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\Eye.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */