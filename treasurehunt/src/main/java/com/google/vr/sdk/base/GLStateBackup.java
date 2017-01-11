/*     */ package com.google.vr.sdk.base;
/*     */ 
/*     */ import android.opengl.GLES20;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GLStateBackup
/*     */ {
/*     */   private boolean cullFaceEnabled;
/*     */   private boolean scissorTestEnabled;
/*     */   private boolean depthTestEnabled;
/*  19 */   private IntBuffer viewport = IntBuffer.allocate(4);
/*  20 */   private IntBuffer texture2dId = IntBuffer.allocate(1);
/*  21 */   private IntBuffer textureUnit = IntBuffer.allocate(1);
/*  22 */   private IntBuffer scissorBox = IntBuffer.allocate(4);
/*  23 */   private IntBuffer shaderProgram = IntBuffer.allocate(1);
/*  24 */   private IntBuffer arrayBufferBinding = IntBuffer.allocate(1);
/*  25 */   private IntBuffer elementArrayBufferBinding = IntBuffer.allocate(1);
/*  26 */   private FloatBuffer clearColor = FloatBuffer.allocate(4);
/*     */   
/*  28 */   private ArrayList<VertexAttributeState> vertexAttributes = new ArrayList();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private class VertexAttributeState
/*     */   {
/*     */     private int attributeId;
/*     */     
/*     */ 
/*  38 */     private IntBuffer enabled = IntBuffer.allocate(1);
/*     */     
/*     */     VertexAttributeState(int attributeId) {
/*  41 */       this.attributeId = attributeId;
/*     */     }
/*     */     
/*     */     void readFromGL() {
/*  45 */       GLES20.glGetVertexAttribiv(this.attributeId, 34338, this.enabled);
/*     */     }
/*     */     
/*     */ 
/*     */     void writeToGL()
/*     */     {
/*  51 */       if (this.enabled.array()[0] == 0) {
/*  52 */         GLES20.glDisableVertexAttribArray(this.attributeId);
/*     */       } else {
/*  54 */         GLES20.glEnableVertexAttribArray(this.attributeId);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   void addTrackedVertexAttribute(int attributeId) {
/*  60 */     this.vertexAttributes.add(new VertexAttributeState(attributeId));
/*     */   }
/*     */   
/*     */   void clearTrackedVertexAttributes() {
/*  64 */     this.vertexAttributes.clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void readFromGL()
/*     */   {
/*  72 */     GLES20.glGetIntegerv(2978, this.viewport);
/*     */     
/*     */ 
/*  75 */     this.cullFaceEnabled = GLES20.glIsEnabled(2884);
/*  76 */     this.scissorTestEnabled = GLES20.glIsEnabled(3089);
/*  77 */     this.depthTestEnabled = GLES20.glIsEnabled(2929);
/*     */     
/*     */ 
/*  80 */     GLES20.glGetFloatv(3106, this.clearColor);
/*     */     
/*     */ 
/*  83 */     GLES20.glGetIntegerv(35725, this.shaderProgram);
/*     */     
/*     */ 
/*  86 */     GLES20.glGetIntegerv(3088, this.scissorBox);
/*     */     
/*     */ 
/*  89 */     GLES20.glGetIntegerv(34016, this.textureUnit);
/*  90 */     GLES20.glGetIntegerv(32873, this.texture2dId);
/*     */     
/*     */ 
/*  93 */     GLES20.glGetIntegerv(34964, this.arrayBufferBinding);
/*  94 */     GLES20.glGetIntegerv(34965, this.elementArrayBufferBinding);
/*     */     
/*     */ 
/*     */ 
/*  98 */     for (VertexAttributeState vas : this.vertexAttributes) {
/*  99 */       vas.readFromGL();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void writeToGL()
/*     */   {
/* 108 */     for (VertexAttributeState vas : this.vertexAttributes) {
/* 109 */       vas.writeToGL();
/*     */     }
/*     */     
/*     */ 
/* 113 */     GLES20.glBindBuffer(34962, this.arrayBufferBinding.array()[0]);
/* 114 */     GLES20.glBindBuffer(34963, this.elementArrayBufferBinding
/* 115 */       .array()[0]);
/*     */     
/*     */ 
/* 118 */     GLES20.glBindTexture(3553, this.texture2dId.array()[0]);
/* 119 */     GLES20.glActiveTexture(this.textureUnit.array()[0]);
/*     */     
/*     */ 
/* 122 */     GLES20.glScissor(this.scissorBox.array()[0], this.scissorBox.array()[1], this.scissorBox
/* 123 */       .array()[2], this.scissorBox.array()[3]);
/*     */     
/*     */ 
/* 126 */     GLES20.glUseProgram(this.shaderProgram.array()[0]);
/*     */     
/*     */ 
/* 129 */     GLES20.glClearColor(this.clearColor.array()[0], this.clearColor.array()[1], this.clearColor
/* 130 */       .array()[2], this.clearColor.array()[3]);
/*     */     
/*     */ 
/* 133 */     if (this.cullFaceEnabled) {
/* 134 */       GLES20.glEnable(2884);
/*     */     } else {
/* 136 */       GLES20.glDisable(2884);
/*     */     }
/* 138 */     if (this.scissorTestEnabled) {
/* 139 */       GLES20.glEnable(3089);
/*     */     } else {
/* 141 */       GLES20.glDisable(3089);
/*     */     }
/* 143 */     if (this.depthTestEnabled) {
/* 144 */       GLES20.glEnable(2929);
/*     */     } else {
/* 146 */       GLES20.glDisable(2929);
/*     */     }
/*     */     
/*     */ 
/* 150 */     GLES20.glViewport(this.viewport.array()[0], this.viewport.array()[1], this.viewport
/* 151 */       .array()[2], this.viewport.array()[3]);
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\GLStateBackup.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */