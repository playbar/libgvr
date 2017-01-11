/*     */ package com.google.vr.cardboard;
/*     */ 
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.ServiceConnection;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.RemoteException;
/*     */ import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
/*     */ import com.google.vr.vrcore.performance.api.IPerformanceService;
/*     */ import com.google.vr.vrcore.performance.api.IPerformanceService.Stub;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PerfMonitor
/*     */   implements AutoCloseable
/*     */ {
/*     */   private static final int STATUS_DISCONNECTED = 0;
/*     */   private static final int STATUS_CONNECTING = 1;
/*     */   private static final int STATUS_CONNECTED = 2;
/*  26 */   private final Object lock = new Object();
/*     */   private final Context context;
/*     */   private IPerformanceService perfService;
/*  29 */   private int status = 1;
/*     */   
/*  31 */   private final ServiceConnection connection = new ServiceConnection()
/*     */   {
/*     */     public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
/*     */     {
/*  35 */       synchronized (PerfMonitor.this.lock) {
/*  36 */         PerfMonitor.this.perfService = IPerformanceService.Stub.asInterface(paramAnonymousIBinder);
/*  37 */         PerfMonitor.this.status = 2;
/*  38 */         PerfMonitor.this.lock.notifyAll();
/*  39 */         return;
/*     */       }
/*     */     }
/*     */     
/*     */     public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {
/*  44 */       synchronized (PerfMonitor.this.lock) {
/*  45 */         PerfMonitor.this.perfService = null;
/*  46 */         PerfMonitor.this.status = 0;
/*  47 */         PerfMonitor.this.lock.notifyAll();
/*  48 */         return;
/*     */       }
/*     */     }
/*     */   };
/*     */   
/*     */   protected PerfMonitor(Context paramContext) {
/*  54 */     this.context = paramContext;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static PerfMonitor build(Context paramContext)
/*     */   {
/*     */     Intent localIntent;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  69 */     (localIntent = new Intent("com.google.vr.vrcore.performance.BIND")).setPackage("com.google.vr.vrcore");
/*     */     
/*  71 */     PerfMonitor localPerfMonitor = new PerfMonitor(paramContext);
/*     */     
/*  73 */     if (!paramContext.bindService(localIntent, localPerfMonitor.connection, 1)) {
/*  74 */       return null;
/*     */     }
/*     */     
/*  77 */     return localPerfMonitor;
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
/*     */   public void waitUntilReady(long paramLong)
/*     */     throws IllegalStateException, InterruptedException
/*     */   {
/*  91 */     if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
/*  92 */       throw new IllegalStateException("waitUntilReady cannot be called from the UI thread");
/*     */     }
/*  94 */     synchronized (this.lock) {
/*     */       long l1;
/*  96 */       long l2 = (l1 = System.currentTimeMillis()) + paramLong;
/*  97 */       while ((this.status == 1) && (l1 < l2)) {
/*  98 */         this.lock.wait(l2 - l1);
/*  99 */         l1 = System.currentTimeMillis();
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       return;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isReady()
/*     */   {
/* 112 */     synchronized (this.lock) {
/* 113 */       return this.status == 2;
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
/*     */ 
/*     */ 
/*     */   public float queryRelativeTemperature()
/*     */     throws VrCoreNotAvailableException
/*     */   {
/*     */     IPerformanceService localIPerformanceService;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 138 */     synchronized (this.lock) {
/* 139 */       localIPerformanceService = this.perfService;
/*     */     }
/*     */     
/* 142 */     if (localIPerformanceService == null) {
/* 143 */       throw new VrCoreNotAvailableException(5);
/*     */     }
/*     */     try
/*     */     {
/* 147 */       return localIPerformanceService.getCurrentThrottlingRelativeTemperature();
/*     */     } catch (RemoteException localRemoteException) {
/* 149 */       throw new VrCoreNotAvailableException(8);
/*     */     } catch (SecurityException localSecurityException) {
/* 151 */       throw new VrCoreNotAvailableException(6);
/*     */     } catch (UnsupportedOperationException localUnsupportedOperationException) {
/* 153 */       throw new VrCoreNotAvailableException(7);
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
/*     */ 
/*     */ 
/*     */   public void reportFrameDrops(long paramLong1, long paramLong2, int paramInt)
/*     */     throws VrCoreNotAvailableException
/*     */   {
/*     */     IPerformanceService localIPerformanceService;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 179 */     synchronized (this.lock) {
/* 180 */       localIPerformanceService = this.perfService;
/*     */     }
/*     */     
/* 183 */     if (localIPerformanceService == null) {
/* 184 */       throw new VrCoreNotAvailableException(5);
/*     */     }
/*     */     try
/*     */     {
/* 188 */       localIPerformanceService.reportFrameDrops(paramLong1, paramLong2, paramInt); return;
/*     */     } catch (RemoteException localRemoteException) {
/* 190 */       throw new VrCoreNotAvailableException(8);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void close()
/*     */   {
/* 200 */     this.context.unbindService(this.connection);
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\common.jar!\com\google\vr\cardboard\PerfMonitor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */