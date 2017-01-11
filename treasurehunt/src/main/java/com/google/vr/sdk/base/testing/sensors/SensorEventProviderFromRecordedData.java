/*     */ package com.google.vr.sdk.base.testing.sensors;
/*     */ 
/*     */ import android.hardware.SensorEventListener;
/*     */ import com.google.vr.sdk.base.sensors.Clock;
/*     */ import com.google.vr.sdk.base.sensors.SensorEventProvider;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
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
/*     */ public class SensorEventProviderFromRecordedData
/*     */   implements SensorEventProvider
/*     */ {
/*     */   private final List<SensorEventAndTime> events;
/*  24 */   private ListIterator<SensorEventAndTime> eventsIterator = null;
/*     */   
/*     */ 
/*  27 */   private EventClock eventClock = new EventClock(null);
/*     */   
/*     */ 
/*  30 */   private final List<SensorEventListener> registeredListeners = new ArrayList();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SensorEventProviderFromRecordedData(List<SensorEventAndTime> events)
/*     */   {
/*  41 */     this.events = events;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void start()
/*     */   {
/*  49 */     reset();
/*  50 */     next();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void reset()
/*     */   {
/*  57 */     this.eventsIterator = this.events.listIterator();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void stop() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean atEnd()
/*     */   {
/*  72 */     return !this.eventsIterator.hasNext();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean next()
/*     */   {
/*  81 */     if (atEnd()) {
/*  82 */       return false;
/*     */     }
/*  84 */     SensorEventAndTime currentEvent = (SensorEventAndTime)this.eventsIterator.next();
/*  85 */     this.eventClock.setTimeNs(currentEvent.timeNs);
/*     */     
/*     */ 
/*  88 */     synchronized (this.registeredListeners) {
/*  89 */       for (SensorEventListener listener : this.registeredListeners) {
/*  90 */         listener.onSensorChanged(currentEvent.event);
/*     */       }
/*     */     }
/*  93 */     return true;
/*     */   }
/*     */   
/*     */   public void registerListener(SensorEventListener listener)
/*     */   {
/*  98 */     synchronized (this.registeredListeners) {
/*  99 */       this.registeredListeners.add(listener);
/*     */     }
/*     */   }
/*     */   
/*     */   public void unregisterListener(SensorEventListener listener)
/*     */   {
/* 105 */     synchronized (this.registeredListeners) {
/* 106 */       this.registeredListeners.remove(listener);
/*     */     }
/*     */   }
/*     */   
/*     */   public Clock getClock()
/*     */   {
/* 112 */     return this.eventClock;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class EventClock
/*     */     implements Clock
/*     */   {
/*     */     private long currentTimeNs;
/*     */     
/*     */ 
/*     */     public long nanoTime()
/*     */     {
/* 124 */       return this.currentTimeNs;
/*     */     }
/*     */     
/*     */     public void setTimeNs(long nanos) {
/* 128 */       this.currentTimeNs = nanos;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\testing\sensors\SensorEventProviderFromRecordedData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */