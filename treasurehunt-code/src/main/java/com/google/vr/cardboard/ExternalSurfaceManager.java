//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.cardboard;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.google.vr.ndk.base.GvrApi;
import com.google.vr.ndk.base.GvrLayout.ExternalSurfaceListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;

public class ExternalSurfaceManager implements com.google.vr.ndk.base.GvrLayout.ExternalSurfaceManager {
 private static final String TAG = ExternalSurfaceManager.class.getSimpleName();
 private final GvrApi gvrApi;
 private volatile ExternalSurfaceManager.ExternalSurfaceData surfaceData = new ExternalSurfaceManager.ExternalSurfaceData();
 private final Object surfaceDataUpdateLock = new Object();
 private int nextID = 1;

 public ExternalSurfaceManager(GvrApi var1) {
  this.gvrApi = var1;
 }

 public void shutdown() {
  Object var1 = this.surfaceDataUpdateLock;
  synchronized(this.surfaceDataUpdateLock) {
   ExternalSurfaceManager.ExternalSurfaceData var2 = this.surfaceData;
   this.surfaceData = new ExternalSurfaceManager.ExternalSurfaceData();
   Iterator var3 = var2.surfaces.values().iterator();

   while(var3.hasNext()) {
    ((ExternalSurfaceManager.ExternalSurface)var3.next()).shutdown(this.gvrApi);
   }

   var3 = var2.surfacesToRelease.values().iterator();

   while(var3.hasNext()) {
    ((ExternalSurfaceManager.ExternalSurface)var3.next()).shutdown(this.gvrApi);
   }

  }
 }

 public int createExternalSurface(ExternalSurfaceListener var1, Handler var2) {
  if(var1 != null && var2 != null) {
   return this.createExternalSurfaceImpl(var1, var2);
  } else {
   throw new IllegalArgumentException("listener and handler must both be both non-null");
  }
 }

 public int createExternalSurface() {
  return this.createExternalSurfaceImpl((ExternalSurfaceListener)null, (Handler)null);
 }

 private int createExternalSurfaceImpl(ExternalSurfaceListener var1, Handler var2) {
  Object var3 = this.surfaceDataUpdateLock;
  synchronized(this.surfaceDataUpdateLock) {
   ExternalSurfaceManager.ExternalSurfaceData var4 = new ExternalSurfaceManager.ExternalSurfaceData(this.surfaceData);
   int var5 = this.nextID++;
   ExternalSurfaceManager.ExternalSurfaceCallback var6 = null;
   if(var1 != null && var2 != null) {
    var6 = new ExternalSurfaceManager.ExternalSurfaceCallback(var1, var2);
   }

   var4.surfaces.put(Integer.valueOf(var5), new ExternalSurfaceManager.ExternalSurface(var5, var6));
   this.surfaceData = var4;
   return var5;
  }
 }

 public void releaseExternalSurface(int var1) {
  Object var2 = this.surfaceDataUpdateLock;
  synchronized(this.surfaceDataUpdateLock) {
   ExternalSurfaceManager.ExternalSurfaceData var3;
   ExternalSurfaceManager.ExternalSurface var4;
   if((var4 = (ExternalSurfaceManager.ExternalSurface)(var3 = new ExternalSurfaceManager.ExternalSurfaceData(this.surfaceData)).surfaces.remove(Integer.valueOf(var1))) != null) {
    var3.surfacesToRelease.put(Integer.valueOf(var1), var4);
    this.surfaceData = var3;
   } else {
    Log.e(TAG, (new StringBuilder(48)).append("Not releasing nonexistent surface ID ").append(var1).toString());
   }

  }
 }

 public int getSurfaceCount() {
  return this.surfaceData.surfaces.size();
 }

 public Surface getSurface(int var1) {
  ExternalSurfaceManager.ExternalSurfaceData var2 = this.surfaceData;
  if(this.surfaceData.surfaces.containsKey(Integer.valueOf(var1))) {
   return ((ExternalSurfaceManager.ExternalSurface)var2.surfaces.get(Integer.valueOf(var1))).getSurface();
  } else {
   Log.e(TAG, (new StringBuilder(58)).append("Surface with ID ").append(var1).append(" does not exist, returning null").toString());
   return null;
  }
 }

 public void consumerAttachToCurrentGLContext() {
  ExternalSurfaceManager.ExternalSurfaceData var1 = this.surfaceData;
  Iterator var2 = this.surfaceData.surfaces.values().iterator();

  while(var2.hasNext()) {
   ((ExternalSurfaceManager.ExternalSurface)var2.next()).maybeAttachToCurrentGLContext();
  }

 }

 public void consumerDetachFromCurrentGLContext() {
  ExternalSurfaceManager.ExternalSurfaceData var1 = this.surfaceData;
  Iterator var2 = this.surfaceData.surfaces.values().iterator();

  while(var2.hasNext()) {
   ((ExternalSurfaceManager.ExternalSurface)var2.next()).maybeDetachFromCurrentGLContext();
  }

  this.gvrApi.removeAllSurfacesReprojectionThread();
 }

 public void consumerUpdateManagedSurfaces() {
  ExternalSurfaceManager.ExternalSurfaceData var1 = this.surfaceData;
  Iterator var2 = this.surfaceData.surfaces.values().iterator();

  while(var2.hasNext()) {
   ExternalSurfaceManager.ExternalSurface var3;
   (var3 = (ExternalSurfaceManager.ExternalSurface)var2.next()).maybeAttachToCurrentGLContext();
   var3.updateSurfaceTexture(this.gvrApi);
  }

  var2 = var1.surfacesToRelease.values().iterator();

  while(var2.hasNext()) {
   ((ExternalSurfaceManager.ExternalSurface)var2.next()).shutdown(this.gvrApi);
  }

 }

 private static class ExternalSurface {
  private final int id;
  private final ExternalSurfaceManager.ExternalSurfaceCallback callback;
  private final float[] transformMatrix = new float[16];
  private final AtomicBoolean hasNewFrame = new AtomicBoolean(false);
  private final AtomicBoolean released = new AtomicBoolean(false);
  private final int[] glTextureId = new int[1];
  private volatile SurfaceTexture surfaceTexture;
  private volatile Surface surface;
  private boolean isAttached = false;

  ExternalSurface(int var1, ExternalSurfaceManager.ExternalSurfaceCallback var2) {
   this.id = var1;
   this.callback = var2;
   Matrix.setIdentityM(this.transformMatrix, 0);
  }

  void maybeAttachToCurrentGLContext() {
   if(!this.isAttached) {
    GLES20.glGenTextures(1, this.glTextureId, 0);
    if(this.surfaceTexture == null) {
     this.surfaceTexture = new SurfaceTexture(this.glTextureId[0]);
     this.surfaceTexture.setOnFrameAvailableListener(new OnFrameAvailableListener() {
      public void onFrameAvailable(SurfaceTexture var1) {
       ExternalSurface.this.hasNewFrame.set(true);
       if(ExternalSurface.this.callback != null) {
        ExternalSurface.this.callback.postOnFrameAvailable();
       }

      }
     });
     this.surface = new Surface(this.surfaceTexture);
    } else {
     this.surfaceTexture.attachToGLContext(this.glTextureId[0]);
    }

    this.isAttached = true;
    if(this.callback != null) {
     this.callback.postOnAvailable(this.surface);
    }

   }
  }

  void maybeDetachFromCurrentGLContext() {
   if(this.isAttached) {
    this.surfaceTexture.detachFromGLContext();
    this.isAttached = false;
   }
  }

  void updateSurfaceTexture(GvrApi var1) {
   if(this.hasNewFrame.getAndSet(false)) {
    this.surfaceTexture.updateTexImage();
    this.surfaceTexture.getTransformMatrix(this.transformMatrix);
    long var3 = this.surfaceTexture.getTimestamp();
    var1.updateSurfaceReprojectionThread(this.id, this.glTextureId[0], var3, this.transformMatrix);
   }

  }

  Surface getSurface() {
   return this.surface;
  }

  void shutdown(GvrApi var1) {
   if(!this.released.getAndSet(true)) {
    if(this.surfaceTexture != null) {
     this.surfaceTexture.release();
     this.surfaceTexture = null;
     this.surface = null;
    }

    var1.updateSurfaceReprojectionThread(this.id, 0, 0L, this.transformMatrix);
   }
  }
 }

 private static class ExternalSurfaceCallback {
  private final ExternalSurfaceListener listener;
  private final Handler handler;
  private final Runnable frameAvailableRunnable;

  public ExternalSurfaceCallback(ExternalSurfaceListener var1, Handler var2) {
   this.listener = var1;
   this.handler = var2;
   this.frameAvailableRunnable = new Runnable() {
    public void run() {
     ExternalSurfaceCallback.this.listener.onFrameAvailable();
    }
   };
  }

  public void postOnAvailable(final Surface var1) {
   this.handler.post(new Runnable() {
    public void run() {
     ExternalSurfaceCallback.this.listener.onSurfaceAvailable(var1);
    }
   });
  }

  public void postOnFrameAvailable() {
   this.handler.post(this.frameAvailableRunnable);
  }
 }

 private static class ExternalSurfaceData {
  final HashMap<Integer, ExternalSurfaceManager.ExternalSurface> surfaces;
  final HashMap<Integer, ExternalSurfaceManager.ExternalSurface> surfacesToRelease;

  ExternalSurfaceData() {
   this.surfaces = new HashMap();
   this.surfacesToRelease = new HashMap();
  }

  ExternalSurfaceData(ExternalSurfaceManager.ExternalSurfaceData var1) {
   this.surfaces = new HashMap(var1.surfaces);
   this.surfacesToRelease = new HashMap(var1.surfacesToRelease);
   Iterator var2 = this.surfacesToRelease.entrySet().iterator();

   while(var2.hasNext()) {
    if(((ExternalSurfaceManager.ExternalSurface)((Entry)var2.next()).getValue()).released.get()) {
     var2.remove();
    }
   }

  }
 }
}
