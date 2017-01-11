/*     */ package com.google.vr.cardboard;
/*     */ 
/*     */ import android.graphics.SurfaceTexture;
/*     */ import android.graphics.SurfaceTexture.OnFrameAvailableListener;
/*     */ import android.opengl.GLES20;
/*     */ import android.opengl.Matrix;
/*     */ import android.os.Handler;
/*     */ import android.util.Log;
/*     */ import android.view.Surface;
/*     */ import com.google.vr.ndk.base.GvrApi;
/*     */ import com.google.vr.ndk.base.GvrLayout.ExternalSurfaceListener;
/*     */ import com.google.vr.ndk.base.GvrLayout.ExternalSurfaceManager;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExternalSurfaceManager
/*     */   implements GvrLayout.ExternalSurfaceManager
/*     */ {
/*  26 */   private static final String TAG = ExternalSurfaceManager.class.getSimpleName();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private final GvrApi gvrApi;
/*     */   
/*     */ 
/*     */ 
/*  35 */   private volatile ExternalSurfaceData surfaceData = new ExternalSurfaceData();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  41 */   private final Object surfaceDataUpdateLock = new Object();
/*     */   
/*     */ 
/*  44 */   private int nextID = 1;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ExternalSurfaceManager(GvrApi paramGvrApi)
/*     */   {
/*  52 */     this.gvrApi = paramGvrApi;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void shutdown()
/*     */   {
/*  60 */     synchronized (this.surfaceDataUpdateLock) {
/*  61 */       ExternalSurfaceData localExternalSurfaceData = this.surfaceData;
/*  62 */       this.surfaceData = new ExternalSurfaceData();
/*  63 */       for (Iterator localIterator = localExternalSurfaceData.surfaces.values().iterator(); localIterator.hasNext();)
/*  64 */         (localExternalSurface = (ExternalSurface)localIterator.next()).shutdown(this.gvrApi);
/*     */       ExternalSurface localExternalSurface;
/*  66 */       for (localIterator = localExternalSurfaceData.surfacesToRelease.values().iterator(); localIterator.hasNext();) {
/*  67 */         (localExternalSurface = (ExternalSurface)localIterator.next()).shutdown(this.gvrApi);
/*     */       }
/*  69 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int createExternalSurface(GvrLayout.ExternalSurfaceListener paramExternalSurfaceListener, Handler paramHandler)
/*     */   {
/*  81 */     if ((paramExternalSurfaceListener == null) || (paramHandler == null)) {
/*  82 */       throw new IllegalArgumentException("listener and handler must both be both non-null");
/*     */     }
/*  84 */     return createExternalSurfaceImpl(paramExternalSurfaceListener, paramHandler);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int createExternalSurface()
/*     */   {
/*  94 */     return createExternalSurfaceImpl(null, null);
/*     */   }
/*     */   
/*     */   private int createExternalSurfaceImpl(GvrLayout.ExternalSurfaceListener paramExternalSurfaceListener, Handler paramHandler) {
/*  98 */     synchronized (this.surfaceDataUpdateLock) {
/*  99 */       ExternalSurfaceData localExternalSurfaceData = new ExternalSurfaceData(this.surfaceData);
/* 100 */       int i = this.nextID++;
/* 101 */       ExternalSurfaceCallback localExternalSurfaceCallback = null;
/* 102 */       if ((paramExternalSurfaceListener != null) && (paramHandler != null)) {
/* 103 */         localExternalSurfaceCallback = new ExternalSurfaceCallback(paramExternalSurfaceListener, paramHandler);
/*     */       }
/* 105 */       localExternalSurfaceData.surfaces.put(Integer.valueOf(i), new ExternalSurface(i, localExternalSurfaceCallback));
/* 106 */       this.surfaceData = localExternalSurfaceData;
/* 107 */       return i;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void releaseExternalSurface(int paramInt)
/*     */   {
/* 117 */     synchronized (this.surfaceDataUpdateLock) {
/*     */       ExternalSurfaceData localExternalSurfaceData;
/*     */       ExternalSurface localExternalSurface;
/* 120 */       if ((localExternalSurface = (ExternalSurface)(localExternalSurfaceData = new ExternalSurfaceData(this.surfaceData)).surfaces.remove(Integer.valueOf(paramInt))) != null) {
/* 121 */         localExternalSurfaceData.surfacesToRelease.put(Integer.valueOf(paramInt), localExternalSurface);
/* 122 */         this.surfaceData = localExternalSurfaceData;
/*     */       } else {
/* 124 */         Log.e(TAG, 48 + "Not releasing nonexistent surface ID " + paramInt);
/*     */       }
/* 126 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getSurfaceCount()
/*     */   {
/* 136 */     return this.surfaceData.surfaces.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Surface getSurface(int paramInt)
/*     */   {
/*     */     ExternalSurfaceData localExternalSurfaceData;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 151 */     if ((localExternalSurfaceData = this.surfaceData).surfaces.containsKey(Integer.valueOf(paramInt))) {
/* 152 */       return ((ExternalSurface)localExternalSurfaceData.surfaces.get(Integer.valueOf(paramInt))).getSurface();
/*     */     }
/* 154 */     Log.e(TAG, 58 + "Surface with ID " + paramInt + " does not exist, returning null");
/* 155 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void consumerAttachToCurrentGLContext()
/*     */   {
/*     */     ExternalSurfaceData localExternalSurfaceData;
/*     */     
/*     */ 
/* 166 */     for (Iterator localIterator = (localExternalSurfaceData = this.surfaceData).surfaces.values().iterator(); localIterator.hasNext();) { ExternalSurface localExternalSurface;
/* 167 */       (localExternalSurface = (ExternalSurface)localIterator.next()).maybeAttachToCurrentGLContext();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void consumerDetachFromCurrentGLContext()
/*     */   {
/*     */     ExternalSurfaceData localExternalSurfaceData;
/*     */     
/*     */ 
/* 178 */     for (Iterator localIterator = (localExternalSurfaceData = this.surfaceData).surfaces.values().iterator(); localIterator.hasNext();) { ExternalSurface localExternalSurface;
/* 179 */       (localExternalSurface = (ExternalSurface)localIterator.next()).maybeDetachFromCurrentGLContext();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 184 */     this.gvrApi.removeAllSurfacesReprojectionThread();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void consumerUpdateManagedSurfaces()
/*     */   {
/*     */     ExternalSurfaceData localExternalSurfaceData;
/*     */     
/*     */ 
/* 195 */     for (Iterator localIterator = (localExternalSurfaceData = this.surfaceData).surfaces.values().iterator(); localIterator.hasNext();) {
/* 196 */       (localExternalSurface = (ExternalSurface)localIterator.next()).maybeAttachToCurrentGLContext();
/* 197 */       localExternalSurface.updateSurfaceTexture(this.gvrApi);
/*     */     }
/*     */     ExternalSurface localExternalSurface;
/* 200 */     for (localIterator = localExternalSurfaceData.surfacesToRelease.values().iterator(); localIterator.hasNext();) {
/* 201 */       (localExternalSurface = (ExternalSurface)localIterator.next()).shutdown(this.gvrApi);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ExternalSurfaceData
/*     */   {
/*     */     final HashMap<Integer, ExternalSurfaceManager.ExternalSurface> surfaces;
/*     */     final HashMap<Integer, ExternalSurfaceManager.ExternalSurface> surfacesToRelease;
/*     */     
/*     */     ExternalSurfaceData() {
/* 211 */       this.surfaces = new HashMap();
/* 212 */       this.surfacesToRelease = new HashMap();
/*     */     }
/*     */     
/* 215 */     ExternalSurfaceData(ExternalSurfaceData paramExternalSurfaceData) { this.surfaces = new HashMap(paramExternalSurfaceData.surfaces);
/* 216 */       this.surfacesToRelease = new HashMap(paramExternalSurfaceData.surfacesToRelease);
/*     */       
/*     */ 
/* 219 */       for (Iterator localIterator = this.surfacesToRelease.entrySet().iterator(); localIterator.hasNext();) {
/*     */         Map.Entry localEntry;
/* 221 */         if (((ExternalSurfaceManager.ExternalSurface)(localEntry = (Map.Entry)localIterator.next()).getValue()).released.get()) {
/* 222 */           localIterator.remove();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ExternalSurfaceCallback
/*     */   {
/*     */     private final GvrLayout.ExternalSurfaceListener listener;
/*     */     private final Handler handler;
/*     */     private final Runnable frameAvailableRunnable;
/*     */     
/*     */     public ExternalSurfaceCallback(GvrLayout.ExternalSurfaceListener paramExternalSurfaceListener, Handler paramHandler) {
/* 235 */       this.listener = paramExternalSurfaceListener;
/* 236 */       this.handler = paramHandler;
/* 237 */       this.frameAvailableRunnable = new Runnable()
/*     */       {
/*     */         public void run() {
/* 240 */           ExternalSurfaceManager.ExternalSurfaceCallback.this.listener.onFrameAvailable();
/*     */         }
/*     */       };
/*     */     }
/*     */     
/*     */     public void postOnAvailable(final Surface paramSurface)
/*     */     {
/* 247 */       this.handler.post(new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 251 */           ExternalSurfaceManager.ExternalSurfaceCallback.this.listener.onSurfaceAvailable(paramSurface);
/*     */         }
/*     */       });
/*     */     }
/*     */     
/*     */     public void postOnFrameAvailable()
/*     */     {
/* 258 */       this.handler.post(this.frameAvailableRunnable);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class ExternalSurface
/*     */   {
/*     */     private final int id;
/*     */     
/*     */     private final ExternalSurfaceManager.ExternalSurfaceCallback callback;
/*     */     
/* 269 */     private final float[] transformMatrix = new float[16];
/* 270 */     private final AtomicBoolean hasNewFrame = new AtomicBoolean(false);
/* 271 */     private final AtomicBoolean released = new AtomicBoolean(false);
/* 272 */     private final int[] glTextureId = new int[1];
/*     */     
/*     */     private volatile SurfaceTexture surfaceTexture;
/*     */     private volatile Surface surface;
/* 276 */     private boolean isAttached = false;
/*     */     
/*     */     ExternalSurface(int paramInt, ExternalSurfaceManager.ExternalSurfaceCallback paramExternalSurfaceCallback) {
/* 279 */       this.id = paramInt;
/* 280 */       this.callback = paramExternalSurfaceCallback;
/* 281 */       Matrix.setIdentityM(this.transformMatrix, 0);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     void maybeAttachToCurrentGLContext()
/*     */     {
/* 289 */       if (this.isAttached) {
/* 290 */         return;
/*     */       }
/*     */       
/* 293 */       GLES20.glGenTextures(1, this.glTextureId, 0);
/* 294 */       if (this.surfaceTexture == null) {
/* 295 */         this.surfaceTexture = new SurfaceTexture(this.glTextureId[0]);
/*     */         
/*     */ 
/* 298 */         this.surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener()
/*     */         {
/*     */           public void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
/*     */           {
/* 302 */             ExternalSurfaceManager.ExternalSurface.this.hasNewFrame.set(true);
/*     */             
/*     */ 
/* 305 */             if (ExternalSurfaceManager.ExternalSurface.this.callback != null) {
/* 306 */               ExternalSurfaceManager.ExternalSurface.this.callback.postOnFrameAvailable();
/*     */             }
/*     */           }
/* 309 */         });
/* 310 */         this.surface = new Surface(this.surfaceTexture);
/*     */       } else {
/* 312 */         this.surfaceTexture.attachToGLContext(this.glTextureId[0]);
/*     */       }
/* 314 */       this.isAttached = true;
/* 315 */       if (this.callback != null) {
/* 316 */         this.callback.postOnAvailable(this.surface);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     void maybeDetachFromCurrentGLContext()
/*     */     {
/* 324 */       if (!this.isAttached) {
/* 325 */         return;
/*     */       }
/*     */       
/* 328 */       this.surfaceTexture.detachFromGLContext();
/* 329 */       this.isAttached = false;
/*     */     }
/*     */     
/*     */ 
/*     */     void updateSurfaceTexture(GvrApi paramGvrApi)
/*     */     {
/*     */       boolean bool;
/*     */       
/* 337 */       if ((bool = this.hasNewFrame.getAndSet(false)))
/*     */       {
/* 339 */         this.surfaceTexture.updateTexImage();
/* 340 */         this.surfaceTexture.getTransformMatrix(this.transformMatrix);
/* 341 */         long l = this.surfaceTexture.getTimestamp();
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 346 */         paramGvrApi.updateSurfaceReprojectionThread(this.id, this.glTextureId[0], l, this.transformMatrix);
/*     */       }
/*     */     }
/*     */     
/*     */     Surface getSurface() {
/* 351 */       return this.surface;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     void shutdown(GvrApi paramGvrApi)
/*     */     {
/* 359 */       if (this.released.getAndSet(true)) {
/* 360 */         return;
/*     */       }
/* 362 */       if (this.surfaceTexture != null) {
/* 363 */         this.surfaceTexture.release();
/* 364 */         this.surfaceTexture = null;
/* 365 */         this.surface = null;
/*     */       }
/*     */       
/*     */ 
/* 369 */       paramGvrApi.updateSurfaceReprojectionThread(this.id, 0, 0L, this.transformMatrix);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\ExternalSurfaceManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */