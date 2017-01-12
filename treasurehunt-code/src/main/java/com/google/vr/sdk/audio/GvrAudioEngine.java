/*     */ package com.google.vr.sdk.audio;
/*     */ 
/*     */ import android.content.Context;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GvrAudioEngine
/*     */ {
/*     */   public static final int INVALID_ID = -1;
/*     */   private final long vrAudioSystemRef;
/*     */   
/*     */   static
/*     */   {
/* 137 */     System.loadLibrary("gvr_audio");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public GvrAudioEngine(Context context, int renderingMode)
/*     */   {
/* 148 */     this.vrAudioSystemRef = nativeInitialize(
/* 149 */       getClass().getClassLoader(), context.getApplicationContext(), renderingMode);
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
/*     */   public void update()
/*     */   {
/* 174 */     nativeUpdate(this.vrAudioSystemRef);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void pause()
/*     */   {
/* 183 */     nativePause(this.vrAudioSystemRef);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void resume()
/*     */   {
/* 192 */     nativeResume(this.vrAudioSystemRef);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean preloadSoundFile(String filename)
/*     */   {
/* 204 */     return nativePreloadSoundFile(this.vrAudioSystemRef, filename);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void unloadSoundFile(String filename)
/*     */   {
/* 216 */     nativeUnloadSoundFile(this.vrAudioSystemRef, filename);
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
/*     */   public int createSoundObject(String filename)
/*     */   {
/* 231 */     return nativeCreateSoundObject(this.vrAudioSystemRef, filename);
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
/*     */   public int createSoundfield(String filename)
/*     */   {
/* 246 */     return nativeCreateSoundfield(this.vrAudioSystemRef, filename);
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
/*     */   public int createStereoSound(String filename)
/*     */   {
/* 260 */     return nativeCreateStereoSound(this.vrAudioSystemRef, filename);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void playSound(int sourceId, boolean loopingEnabled)
/*     */   {
/* 272 */     nativePlaySound(this.vrAudioSystemRef, sourceId, loopingEnabled);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void pauseSound(int sourceId)
/*     */   {
/* 283 */     nativePauseSound(this.vrAudioSystemRef, sourceId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void resumeSound(int sourceId)
/*     */   {
/* 294 */     nativeResumeSound(this.vrAudioSystemRef, sourceId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void stopSound(int sourceId)
/*     */   {
/* 306 */     nativeStopSound(this.vrAudioSystemRef, sourceId);
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
/*     */   public void setSoundObjectPosition(int soundObjectId, float x, float y, float z)
/*     */   {
/* 320 */     nativeSetSoundObjectPosition(this.vrAudioSystemRef, soundObjectId, x, y, z);
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
/*     */   public void setSoundObjectDistanceRolloffModel(int soundObjectId, int rolloffModel, float minDistance, float maxDistance)
/*     */   {
/* 339 */     nativeSetSoundObjectDistanceRolloffModel(this.vrAudioSystemRef, soundObjectId, rolloffModel, minDistance, maxDistance);
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
/*     */   public void setSoundfieldRotation(int soundfieldId, float x, float y, float z, float w)
/*     */   {
/* 360 */     nativeSetSoundfieldRotation(this.vrAudioSystemRef, soundfieldId, x, y, z, w);
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
/*     */   public void setSoundVolume(int sourceId, float volume)
/*     */   {
/* 373 */     nativeSetSoundVolume(this.vrAudioSystemRef, sourceId, volume);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSoundPlaying(int sourceId)
/*     */   {
/* 385 */     return nativeIsSoundPlaying(this.vrAudioSystemRef, sourceId);
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
/*     */   public void setHeadPosition(float x, float y, float z)
/*     */   {
/* 398 */     nativeSetHeadPosition(this.vrAudioSystemRef, x, y, z);
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
/*     */   public void setHeadRotation(float x, float y, float z, float w)
/*     */   {
/* 412 */     nativeSetHeadRotation(this.vrAudioSystemRef, x, y, z, w);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void enableRoom(boolean enable)
/*     */   {
/* 424 */     nativeEnableRoom(this.vrAudioSystemRef, enable);
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
/*     */   public void setRoomProperties(float sizeX, float sizeY, float sizeZ, int wallMaterial, int ceilingMaterial, int floorMaterial)
/*     */   {
/* 446 */     nativeSetRoomProperties(this.vrAudioSystemRef, sizeX, sizeY, sizeZ, wallMaterial, ceilingMaterial, floorMaterial);
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
/*     */   public void setRoomReverbAdjustments(float gain, float timeAdjust, float brightnessAdjust)
/*     */   {
/* 470 */     nativeSetRoomReverbAdjustments(this.vrAudioSystemRef, gain, timeAdjust, brightnessAdjust);
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
/*     */   public void enableSpeakerStereoMode(boolean enable)
/*     */   {
/* 489 */     nativeEnableStereoSpeakerMode(this.vrAudioSystemRef, enable);
/*     */   }
/*     */   
/*     */   private native long nativeInitialize(ClassLoader paramClassLoader, Context paramContext, int paramInt);
/*     */   
/*     */   /* Error */
/*     */   protected void finalize()
/*     */     throws java.lang.Throwable
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_0
/*     */     //   2: getfield 46	com/google/vr/sdk/audio/GvrAudioEngine:vrAudioSystemRef	J
/*     */     //   5: invokespecial 58	com/google/vr/sdk/audio/GvrAudioEngine:nativeRelease	(J)V
/*     */     //   8: aload_0
/*     */     //   9: invokespecial 60	java/lang/Object:finalize	()V
/*     */     //   12: goto +10 -> 22
/*     */     //   15: astore_1
/*     */     //   16: aload_0
/*     */     //   17: invokespecial 60	java/lang/Object:finalize	()V
/*     */     //   20: aload_1
/*     */     //   21: athrow
/*     */     //   22: return
/*     */     // Line number table:
/*     */     //   Java source line #161	-> byte code offset #0
/*     */     //   Java source line #163	-> byte code offset #8
/*     */     //   Java source line #164	-> byte code offset #12
/*     */     //   Java source line #163	-> byte code offset #15
/*     */     //   Java source line #165	-> byte code offset #22
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	23	0	this	GvrAudioEngine
/*     */     //   15	6	1	localObject	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   0	8	15	finally
/*     */   }
/*     */   
/*     */   private native void nativeRelease(long paramLong);
/*     */   
/*     */   private native void nativeUpdate(long paramLong);
/*     */   
/*     */   private native void nativePause(long paramLong);
/*     */   
/*     */   private native void nativeResume(long paramLong);
/*     */   
/*     */   private native boolean nativePreloadSoundFile(long paramLong, String paramString);
/*     */   
/*     */   private native void nativeUnloadSoundFile(long paramLong, String paramString);
/*     */   
/*     */   private native int nativeCreateSoundObject(long paramLong, String paramString);
/*     */   
/*     */   private native int nativeCreateSoundfield(long paramLong, String paramString);
/*     */   
/*     */   private native int nativeCreateStereoSound(long paramLong, String paramString);
/*     */   
/*     */   private native void nativePlaySound(long paramLong, int paramInt, boolean paramBoolean);
/*     */   
/*     */   private native void nativePauseSound(long paramLong, int paramInt);
/*     */   
/*     */   private native void nativeResumeSound(long paramLong, int paramInt);
/*     */   
/*     */   private native void nativeStopSound(long paramLong, int paramInt);
/*     */   
/*     */   private native void nativeSetSoundObjectPosition(long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
/*     */   
/*     */   private native void nativeSetSoundObjectDistanceRolloffModel(long paramLong, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2);
/*     */   
/*     */   private native void nativeSetSoundfieldRotation(long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
/*     */   
/*     */   private native void nativeSetSoundVolume(long paramLong, int paramInt, float paramFloat);
/*     */   
/*     */   private native boolean nativeIsSoundPlaying(long paramLong, int paramInt);
/*     */   
/*     */   private native void nativeSetHeadPosition(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
/*     */   
/*     */   private native void nativeSetHeadRotation(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
/*     */   
/*     */   private native void nativeEnableRoom(long paramLong, boolean paramBoolean);
/*     */   
/*     */   private native void nativeSetRoomProperties(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, int paramInt3);
/*     */   
/*     */   private native void nativeSetRoomReverbAdjustments(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
/*     */   
/*     */   private native void nativeEnableStereoSpeakerMode(long paramLong, boolean paramBoolean);
/*     */   
/*     */   public static abstract class DistanceRolloffModel
/*     */   {
/*     */     public static final int LOGARITHMIC = 0;
/*     */     public static final int LINEAR = 1;
/*     */     public static final int NONE = 2;
/*     */   }
/*     */   
/*     */   public static abstract class MaterialName
/*     */   {
/*     */     public static final int TRANSPARENT = 0;
/*     */     public static final int ACOUSTIC_CEILING_TILES = 1;
/*     */     public static final int BRICK_BARE = 2;
/*     */     public static final int BRICK_PAINTED = 3;
/*     */     public static final int CONCRETE_BLOCK_COARSE = 4;
/*     */     public static final int CONCRETE_BLOCK_PAINTED = 5;
/*     */     public static final int CURTAIN_HEAVY = 6;
/*     */     public static final int FIBER_GLASS_INSULATION = 7;
/*     */     public static final int GLASS_THIN = 8;
/*     */     public static final int GLASS_THICK = 9;
/*     */     public static final int GRASS = 10;
/*     */     public static final int LINOLEUM_ON_CONCRETE = 11;
/*     */     public static final int MARBLE = 12;
/*     */     public static final int METAL = 13;
/*     */     public static final int PARQUET_ON_CONCRETE = 14;
/*     */     public static final int PLASTER_ROUGH = 15;
/*     */     public static final int PLASTER_SMOOTH = 16;
/*     */     public static final int PLYWOOD_PANEL = 17;
/*     */     public static final int POLISHED_CONCRETE_OR_TILE = 18;
/*     */     public static final int SHEET_ROCK = 19;
/*     */     public static final int WATER_OR_ICE_SURFACE = 20;
/*     */     public static final int WOOD_CEILING = 21;
/*     */     public static final int WOOD_PANEL = 22;
/*     */   }
/*     */   
/*     */   public static abstract class RenderingMode
/*     */   {
/*     */     public static final int STEREO_PANNING = 0;
/*     */     public static final int BINAURAL_LOW_QUALITY = 1;
/*     */     public static final int BINAURAL_HIGH_QUALITY = 2;
/*     */   }
/*     */ }


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\audio.jar!\com\google\vr\sdk\audio\GvrAudioEngine.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */