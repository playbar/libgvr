package com.google.vr.sdk.base;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.opengl.GLSurfaceView;
import android.os.Trace;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.google.vr.cardboard.CardboardGLSurfaceView;
import com.google.vr.cardboard.CardboardGLSurfaceView.DetachListener;
import com.google.vr.cardboard.DisplaySynchronizer;
import com.google.vr.cardboard.ThreadUtils;
import com.google.vr.cardboard.TransitionView.TransitionListener;
import com.google.vr.cardboard.UiLayer;
import com.google.vr.cardboard.UsedByNative;
import com.google.vr.ndk.base.BufferSpec;
import com.google.vr.ndk.base.GvrApi;
import com.google.vr.ndk.base.GvrLayout;
import com.google.vr.ndk.base.GvrLayout.PresentationListener;
import com.google.vr.ndk.base.GvrSurfaceView;
import com.google.vr.ndk.base.GvrUiLayout;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;






















@UsedByNative
public class CardboardViewNativeImpl
  implements CardboardGLSurfaceView.DetachListener, CardboardViewApi
{
/*  56 */   private static final String TAG = CardboardViewNativeImpl.class.getSimpleName();
  private final RendererHelper rendererHelper  = new RendererHelper();
  private final HeadMountedDisplayManager hmdManager;
  private CountDownLatch shutdownLatch;
  private int cardboardTriggerCount;
  private volatile Runnable cardboardTriggerListener;
  private volatile Runnable cardboardBackListener;
  private Runnable transitionDoneListener;
  private final CardboardGLSurfaceView glSurfaceView;
  private final GvrLayout gvrLayout;
  private final GvrUiLayout uiLayout;
  private final GvrApi gvrApi;
  private final Context context;
  private boolean stereoMode;
  private volatile boolean distortionCorrectionEnabled;
  private long nativeCardboardView;
  
  /* Error */
  public CardboardViewNativeImpl(Context context)
  {
      this.context = context;
    hmdManager = new HeadMountedDisplayManager(context);
      glSurfaceView = new CardboardGLSurfaceView(context, this);
      gvrLayout = new GvrLayout(context);
      uiLayout = new GvrUiLayout(context);
      gvrApi = new GvrApi(context, new DisplaySynchronizer(context, new Display(null)));
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 96	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield 98	com/google/vr/sdk/base/CardboardViewNativeImpl:cardboardTriggerCount	I
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 100	com/google/vr/sdk/base/CardboardViewNativeImpl:stereoMode	Z
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 102	com/google/vr/sdk/base/CardboardViewNativeImpl:distortionCorrectionEnabled	Z
    //   19: aload_0
    //   20: aload_1
    //   21: putfield 104	com/google/vr/sdk/base/CardboardViewNativeImpl:context	Landroid/content/Context;
    //   24: aload_0
    //   25: new 106	com/google/vr/sdk/base/HeadMountedDisplayManager
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 108	com/google/vr/sdk/base/HeadMountedDisplayManager:<init>	(Landroid/content/Context;)V
    //   33: putfield 110	com/google/vr/sdk/base/CardboardViewNativeImpl:hmdManager	Lcom/google/vr/sdk/base/HeadMountedDisplayManager;
    //   36: aload_0
    //   37: invokevirtual 114	java/lang/Object:getClass	()Ljava/lang/Class;
    //   40: invokevirtual 120	java/lang/Class:getPackage	()Ljava/lang/Package;
    //   43: invokevirtual 126	java/lang/Package:getName	()Ljava/lang/String;
    //   46: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   49: ldc -122
    //   51: invokevirtual 138	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore_3
    //   55: aload_3
    //   56: invokestatic 142	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   59: astore 4
    //   61: aload 4
    //   63: ldc -112
    //   65: invokevirtual 148	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   68: astore 5
    //   70: aload 5
    //   72: aconst_null
    //   73: invokevirtual 154	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   76: checkcast 128	java/lang/String
    //   79: astore_2
    //   80: goto +16 -> 96
    //   83: astore_3
    //   84: getstatic 158	com/google/vr/sdk/base/CardboardViewNativeImpl:TAG	Ljava/lang/String;
    //   87: ldc -96
    //   89: invokestatic 166	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   92: pop
    //   93: ldc -88
    //   95: astore_2
    //   96: getstatic 158	com/google/vr/sdk/base/CardboardViewNativeImpl:TAG	Ljava/lang/String;
    //   99: ldc -86
    //   101: aload_2
    //   102: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   105: dup
    //   106: invokevirtual 174	java/lang/String:length	()I
    //   109: ifeq +9 -> 118
    //   112: invokevirtual 138	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   115: goto +12 -> 127
    //   118: pop
    //   119: new 128	java/lang/String
    //   122: dup_x1
    //   123: swap
    //   124: invokespecial 177	java/lang/String:<init>	(Ljava/lang/String;)V
    //   127: invokestatic 166	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   130: pop
    //   131: aload_2
    //   132: invokestatic 182	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   135: getstatic 158	com/google/vr/sdk/base/CardboardViewNativeImpl:TAG	Ljava/lang/String;
    //   138: ldc -72
    //   140: invokestatic 166	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   143: pop
    //   144: aload_0
    //   145: invokevirtual 114	java/lang/Object:getClass	()Ljava/lang/Class;
    //   148: invokevirtual 188	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   151: aload_1
    //   152: invokevirtual 192	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   155: invokestatic 196	com/google/vr/sdk/base/CardboardViewNativeImpl:nativeSetApplicationState	(Ljava/lang/ClassLoader;Landroid/content/Context;)J
    //   158: pop2
    //   159: aload_0
    //   160: new 46	com/google/vr/cardboard/CardboardGLSurfaceView
    //   163: dup
    //   164: aload_1
    //   165: aload_0
    //   166: invokespecial 199	com/google/vr/cardboard/CardboardGLSurfaceView:<init>	(Landroid/content/Context;Lcom/google/vr/cardboard/CardboardGLSurfaceView$DetachListener;)V
    //   169: putfield 201	com/google/vr/sdk/base/CardboardViewNativeImpl:glSurfaceView	Lcom/google/vr/cardboard/CardboardGLSurfaceView;
    //   172: aload_0
    //   173: new 51	com/google/vr/ndk/base/GvrLayout
    //   176: dup
    //   177: aload_1
    //   178: invokespecial 202	com/google/vr/ndk/base/GvrLayout:<init>	(Landroid/content/Context;)V
    //   181: putfield 204	com/google/vr/sdk/base/CardboardViewNativeImpl:gvrLayout	Lcom/google/vr/ndk/base/GvrLayout;
    //   184: aload_0
    //   185: getfield 204	com/google/vr/sdk/base/CardboardViewNativeImpl:gvrLayout	Lcom/google/vr/ndk/base/GvrLayout;
    //   188: aload_0
    //   189: getfield 201	com/google/vr/sdk/base/CardboardViewNativeImpl:glSurfaceView	Lcom/google/vr/cardboard/CardboardGLSurfaceView;
    //   192: invokevirtual 208	com/google/vr/ndk/base/GvrLayout:setPresentationView	(Landroid/view/View;)V
    //   195: aload_0
    //   196: getfield 204	com/google/vr/sdk/base/CardboardViewNativeImpl:gvrLayout	Lcom/google/vr/ndk/base/GvrLayout;
    //   199: new 15	com/google/vr/sdk/base/CardboardViewNativeImpl$PresentationListener
    //   202: dup
    //   203: aload_0
    //   204: aconst_null
    //   205: invokespecial 211	com/google/vr/sdk/base/CardboardViewNativeImpl$PresentationListener:<init>	(Lcom/google/vr/sdk/base/CardboardViewNativeImpl;Lcom/google/vr/sdk/base/CardboardViewNativeImpl$1;)V
    //   208: invokevirtual 215	com/google/vr/ndk/base/GvrLayout:addPresentationListener	(Lcom/google/vr/ndk/base/GvrLayout$PresentationListener;)V
    //   211: aload_0
    //   212: new 12	com/google/vr/sdk/base/CardboardViewNativeImpl$RendererHelper
    //   215: dup
    //   216: aload_0
    //   217: invokespecial 218	com/google/vr/sdk/base/CardboardViewNativeImpl$RendererHelper:<init>	(Lcom/google/vr/sdk/base/CardboardViewNativeImpl;)V
    //   220: putfield 220	com/google/vr/sdk/base/CardboardViewNativeImpl:rendererHelper	Lcom/google/vr/sdk/base/CardboardViewNativeImpl$RendererHelper;
    //   223: aload_0
    //   224: aload_0
    //   225: getfield 204	com/google/vr/sdk/base/CardboardViewNativeImpl:gvrLayout	Lcom/google/vr/ndk/base/GvrLayout;
    //   228: invokevirtual 224	com/google/vr/ndk/base/GvrLayout:getUiLayout	()Lcom/google/vr/ndk/base/GvrUiLayout;
    //   231: putfield 226	com/google/vr/sdk/base/CardboardViewNativeImpl:uiLayout	Lcom/google/vr/ndk/base/GvrUiLayout;
    //   234: aload_0
    //   235: aload_0
    //   236: getfield 204	com/google/vr/sdk/base/CardboardViewNativeImpl:gvrLayout	Lcom/google/vr/ndk/base/GvrLayout;
    //   239: invokevirtual 230	com/google/vr/ndk/base/GvrLayout:getGvrApi	()Lcom/google/vr/ndk/base/GvrApi;
    //   242: putfield 232	com/google/vr/sdk/base/CardboardViewNativeImpl:gvrApi	Lcom/google/vr/ndk/base/GvrApi;
    //   245: aload_0
    //   246: aload_0
    //   247: aload_0
    //   248: getfield 232	com/google/vr/sdk/base/CardboardViewNativeImpl:gvrApi	Lcom/google/vr/ndk/base/GvrApi;
    //   251: invokevirtual 238	com/google/vr/ndk/base/GvrApi:getNativeGvrContext	()J
    //   254: invokespecial 242	com/google/vr/sdk/base/CardboardViewNativeImpl:nativeInit	(J)J
    //   257: putfield 244	com/google/vr/sdk/base/CardboardViewNativeImpl:nativeCardboardView	J
    //   260: return
    // Line number table:
    //   Java source line #81	-> byte code offset #0
    //   Java source line #62	-> byte code offset #4
    //   Java source line #76	-> byte code offset #9
    //   Java source line #77	-> byte code offset #14
    //   Java source line #82	-> byte code offset #19
    //   Java source line #83	-> byte code offset #24
    //   Java source line #89	-> byte code offset #36
    //   Java source line #90	-> byte code offset #55
    //   Java source line #91	-> byte code offset #61
    //   Java source line #92	-> byte code offset #70
    //   Java source line #97	-> byte code offset #80
    //   Java source line #94	-> byte code offset #83
    //   Java source line #95	-> byte code offset #84
    //   Java source line #96	-> byte code offset #93
    //   Java source line #99	-> byte code offset #96
    //   Java source line #100	-> byte code offset #131
    //   Java source line #101	-> byte code offset #135
    //   Java source line #104	-> byte code offset #144
    //   Java source line #106	-> byte code offset #159
    //   Java source line #107	-> byte code offset #172
    //   Java source line #108	-> byte code offset #184
    //   Java source line #109	-> byte code offset #195
    //   Java source line #111	-> byte code offset #211
    //   Java source line #112	-> byte code offset #223
    //   Java source line #113	-> byte code offset #234
    //   Java source line #114	-> byte code offset #245
    //   Java source line #115	-> byte code offset #260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	CardboardViewNativeImpl
    //   0	261	1	context	Context
    //   80	3	2	nativeLibrary	String
    //   96	165	2	nativeLibrary	String
    //   55	25	3	proxyClassName	String
    //   84	12	3	e	Exception
    //   61	19	4	proxyClass	Class
    //   70	10	5	proxyLibField	java.lang.reflect.Field
    // Exception table:
    //   from	to	target	type
    //   36	80	83	java/lang/Exception
  }
  
  /* Error */
  protected void finalize()
    throws java.lang.Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 244	com/google/vr/sdk/base/CardboardViewNativeImpl:nativeCardboardView	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifeq +21 -> 27
    //   9: getstatic 158	com/google/vr/sdk/base/CardboardViewNativeImpl:TAG	Ljava/lang/String;
    //   12: ldc_w 259
    //   15: invokestatic 262	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   18: pop
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 244	com/google/vr/sdk/base/CardboardViewNativeImpl:nativeCardboardView	J
    //   24: invokespecial 266	com/google/vr/sdk/base/CardboardViewNativeImpl:nativeDestroy	(J)V
    //   27: aload_0
    //   28: invokespecial 268	java/lang/Object:finalize	()V
    //   31: goto +10 -> 41
    //   34: astore_1
    //   35: aload_0
    //   36: invokespecial 268	java/lang/Object:finalize	()V
    //   39: aload_1
    //   40: athrow
    //   41: return
    // Line number table:
    //   Java source line #120	-> byte code offset #0
    //   Java source line #122	-> byte code offset #9
    //   Java source line #123	-> byte code offset #19
    //   Java source line #126	-> byte code offset #27
    //   Java source line #127	-> byte code offset #31
    //   Java source line #126	-> byte code offset #34
    //   Java source line #128	-> byte code offset #41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	CardboardViewNativeImpl
    //   34	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	27	34	finally
  }
  
  /* Error */
  public void onSurfaceViewDetachedFromWindow()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 273	com/google/vr/sdk/base/CardboardViewNativeImpl:shutdownLatch	Ljava/util/concurrent/CountDownLatch;
    //   4: ifnonnull +77 -> 81
    //   7: aload_0
    //   8: new 275	java/util/concurrent/CountDownLatch
    //   11: dup
    //   12: iconst_1
    //   13: invokespecial 278	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   16: putfield 273	com/google/vr/sdk/base/CardboardViewNativeImpl:shutdownLatch	Ljava/util/concurrent/CountDownLatch;
    //   19: aload_0
    //   20: getfield 220	com/google/vr/sdk/base/CardboardViewNativeImpl:rendererHelper	Lcom/google/vr/sdk/base/CardboardViewNativeImpl$RendererHelper;
    //   23: invokevirtual 281	com/google/vr/sdk/base/CardboardViewNativeImpl$RendererHelper:shutdown	()V
    //   26: aload_0
    //   27: getfield 273	com/google/vr/sdk/base/CardboardViewNativeImpl:shutdownLatch	Ljava/util/concurrent/CountDownLatch;
    //   30: invokevirtual 284	java/util/concurrent/CountDownLatch:await	()V
    //   33: goto +43 -> 76
    //   36: astore_1
    //   37: getstatic 158	com/google/vr/sdk/base/CardboardViewNativeImpl:TAG	Ljava/lang/String;
    //   40: ldc_w 286
    //   43: aload_1
    //   44: invokevirtual 289	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   47: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   50: dup
    //   51: invokevirtual 174	java/lang/String:length	()I
    //   54: ifeq +9 -> 63
    //   57: invokevirtual 138	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   60: goto +12 -> 72
    //   63: pop
    //   64: new 128	java/lang/String
    //   67: dup_x1
    //   68: swap
    //   69: invokespecial 177	java/lang/String:<init>	(Ljava/lang/String;)V
    //   72: invokestatic 291	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   75: pop
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 273	com/google/vr/sdk/base/CardboardViewNativeImpl:shutdownLatch	Ljava/util/concurrent/CountDownLatch;
    //   81: return
    // Line number table:
    //   Java source line #134	-> byte code offset #0
    //   Java source line #135	-> byte code offset #7
    //   Java source line #136	-> byte code offset #19
    //   Java source line #138	-> byte code offset #26
    //   Java source line #141	-> byte code offset #33
    //   Java source line #139	-> byte code offset #36
    //   Java source line #140	-> byte code offset #37
    //   Java source line #143	-> byte code offset #76
    //   Java source line #145	-> byte code offset #81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	CardboardViewNativeImpl
    //   37	39	1	e	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   26	33	36	java/lang/InterruptedException
  }
  
  public void setRenderer(GvrView.Renderer renderer)
  {
/* 151 */     this.rendererHelper.setRenderer(renderer);
/* 152 */     this.glSurfaceView.setRenderer(this.rendererHelper);
  }
  
  public void setRenderer(GvrView.StereoRenderer renderer)
  {
/* 157 */     this.rendererHelper.setRenderer(renderer);
/* 158 */     this.glSurfaceView.setRenderer(this.rendererHelper);
  }
  



  public void getCurrentEyeParams(HeadTransform head, Eye leftEye, Eye rightEye, Eye monocular, Eye leftEyeNoDistortionCorrection, Eye rightEyeNoDistortionCorrection)
  {
/* 166 */     this.rendererHelper.getCurrentEyeParams(head, leftEye, rightEye, monocular, leftEyeNoDistortionCorrection, rightEyeNoDistortionCorrection);
  }
  


  public void setStereoModeEnabled(boolean enabled)
  {
/* 173 */     this.stereoMode = enabled;
/* 174 */     this.rendererHelper.setStereoModeEnabled(enabled);
  }
  
  public boolean getStereoModeEnabled()
  {
/* 179 */     return this.stereoMode;
  }
  
  public boolean setAsyncReprojectionEnabled(boolean enable)
  {
/* 184 */     return this.gvrLayout.setAsyncReprojectionEnabled(enable);
  }
  
  public boolean getAsyncReprojectionEnabled()
  {
/* 189 */     return this.gvrLayout.getGvrApi().getAsyncReprojectionEnabled();
  }
  
  public void setOnCloseButtonListener(Runnable listener)
  {
/* 194 */     this.uiLayout.setCloseButtonListener(listener);
  }
  
  public void setTransitionViewEnabled(boolean enabled)
  {
/* 199 */     this.uiLayout.setTransitionViewEnabled(enabled);
/* 200 */     updateTransitionListener();
  }
  
  public void setOnTransitionViewDoneListener(Runnable listener)
  {
/* 205 */     this.transitionDoneListener = listener;
/* 206 */     updateTransitionListener();
  }
  
  private void updateTransitionListener() {
/* 210 */     if (this.uiLayout.getUiLayer().getTransitionViewEnabled()) {
/* 211 */       this.uiLayout.getUiLayer().setTransitionViewListener(new TransitionListener()
      {



        public void onTransitionDone()
        {


/* 220 */           if (CardboardViewNativeImpl.this.nativeCardboardView != 0L) {
/* 221 */             CardboardViewNativeImpl.this.nativeLogEvent(CardboardViewNativeImpl.this.nativeCardboardView, 2002);
          }
          
/* 224 */           if (CardboardViewNativeImpl.this.transitionDoneListener != null) {
/* 225 */             ThreadUtils.runOnUiThread(CardboardViewNativeImpl.this.transitionDoneListener);
          }
        }
        




        public void onSwitchViewer()
        {
/* 235 */           if (CardboardViewNativeImpl.this.nativeCardboardView != 0L) {
/* 236 */             CardboardViewNativeImpl.this.nativeLogEvent(CardboardViewNativeImpl.this.nativeCardboardView, 2003);
          }
        }
      });
    } else {
/* 241 */       this.uiLayout.getUiLayer().setTransitionViewListener(null);
    }
  }
  
  public HeadMountedDisplay getHeadMountedDisplay()
  {
/* 247 */     return this.hmdManager.getHeadMountedDisplay();
  }
  
  public void setNeckModelEnabled(boolean enabled)
  {
/* 252 */     nativeSetNeckModelEnabled(this.nativeCardboardView, enabled);
  }
  
  public float getNeckModelFactor()
  {
/* 257 */     return nativeGetNeckModelFactor(this.nativeCardboardView);
  }
  
  public void setNeckModelFactor(float factor)
  {
/* 262 */     nativeSetNeckModelFactor(this.nativeCardboardView, factor);
  }
  
  public void resetHeadTracker()
  {
/* 267 */     this.gvrApi.resetTracking();
  }
  
  public void recenterHeadTracker()
  {
/* 272 */     this.gvrApi.recenterTracking();
  }
  
  public void updateGvrViewerParams(GvrViewerParams gvrDeviceParams)
  {
/* 277 */     if (this.hmdManager.updateGvrViewerParams(gvrDeviceParams)) {
/* 278 */       setGvrViewerParams(getGvrViewerParams());
    }
  }
  
  public GvrViewerParams getGvrViewerParams()
  {
/* 284 */     return this.hmdManager.getHeadMountedDisplay().getGvrViewerParams();
  }
  
  public void updateScreenParams(ScreenParams screenParams)
  {
/* 289 */     if (this.hmdManager.updateScreenParams(screenParams)) {
/* 290 */       setScreenParams(getScreenParams());
    }
  }
  
  public ScreenParams getScreenParams()
  {
/* 296 */     return this.hmdManager.getHeadMountedDisplay().getScreenParams();
  }
  
  public float getInterpupillaryDistance()
  {
/* 301 */     return getGvrViewerParams().getInterLensDistance();
  }
  
  public void setDistortionCorrectionEnabled(final boolean enabled)
  {
/* 306 */     checkNativeCardboardView();
/* 307 */     this.distortionCorrectionEnabled = enabled;
/* 308 */     queueEvent(new Runnable()
    {
      public void run() {
/* 311 */         CardboardViewNativeImpl.this.nativeSetDistortionCorrectionEnabled(CardboardViewNativeImpl.this.nativeCardboardView, enabled);
      }
    });
  }
  
  public boolean getDistortionCorrectionEnabled()
  {
/* 318 */     return this.distortionCorrectionEnabled;
  }
  
  public void undistortTexture(final int inputTexture)
  {
/* 323 */     checkNativeCardboardView();
/* 324 */     queueEvent(new Runnable()
    {
      public void run() {
/* 327 */         CardboardViewNativeImpl.this.nativeUndistortTexture(CardboardViewNativeImpl.this.nativeCardboardView, inputTexture);
      }
    });
  }
  
  public void setDistortionCorrectionScale(final float scale)
  {
/* 334 */     checkNativeCardboardView();
/* 335 */     queueEvent(new Runnable()
    {
      public void run() {
/* 338 */         CardboardViewNativeImpl.this.nativeSetDistortionCorrectionScale(CardboardViewNativeImpl.this.nativeCardboardView, scale);
      }
    });
  }
  
  public void setMultisampling(final int numSamples)
  {
/* 345 */     checkNativeCardboardView();
/* 346 */     queueEvent(new Runnable()
    {
      public void run()
      {
/* 350 */         CardboardViewNativeImpl.this.nativeSetMultisampling(CardboardViewNativeImpl.this.nativeCardboardView, numSamples);
      }
    });
  }
  
  public void setDepthStencilFormat(final int format)
  {
/* 357 */     checkNativeCardboardView();
/* 358 */     if (!BufferSpec.isValidDepthStencilFormat(format)) {
/* 359 */       throw new IllegalArgumentException("Invalid depth-stencil format.");
    }
/* 361 */     queueEvent(new Runnable()
    {
      public void run()
      {
/* 365 */         CardboardViewNativeImpl.this.nativeSetDepthStencilFormat(CardboardViewNativeImpl.this.nativeCardboardView, format);
      }
    });
  }
  
  public void onResume()
  {
/* 372 */     checkNativeCardboardView();
/* 373 */     this.gvrLayout.onResume();
/* 374 */     this.glSurfaceView.onResume();
    
/* 376 */     this.hmdManager.onResume();
/* 377 */     setScreenParams(getScreenParams());
/* 378 */     setGvrViewerParams(getGvrViewerParams());
/* 379 */     this.gvrApi.resumeTracking();
  }
  
  public void onPause()
  {
/* 384 */     checkNativeCardboardView();
/* 385 */     this.gvrApi.pauseTracking();
/* 386 */     this.hmdManager.onPause();
/* 387 */     this.glSurfaceView.onPause();
/* 388 */     this.gvrLayout.onPause();
  }
  
  public void shutdown()
  {
/* 393 */     if (this.nativeCardboardView != 0L) {
/* 394 */       this.gvrLayout.shutdown();
/* 395 */       nativeDestroy(this.nativeCardboardView);
/* 396 */       this.nativeCardboardView = 0L;
    }
  }
  
  public boolean onTouchEvent(MotionEvent e)
  {
/* 402 */     if ((e.getActionMasked() == 0) && (this.cardboardTriggerListener != null)) {
/* 403 */       onCardboardTrigger();
/* 404 */       return true;
    }
/* 406 */     return false;
  }
  
  public void setOnCardboardTriggerListener(Runnable listener)
  {
/* 411 */     this.cardboardTriggerListener = listener;
  }
  
  public void enableCardboardTriggerEmulation()
  {
/* 416 */     this.gvrLayout.enableCardboardTriggerEmulation(new Runnable()
    {
      public void run()
      {
/* 420 */         CardboardViewNativeImpl.this.onCardboardTrigger();
      }
    });
  }
  
  public void setOnCardboardBackListener(Runnable listener)
  {
/* 427 */     this.cardboardBackListener = listener;
  }
  
  public View getRootView()
  {
/* 432 */     return this.gvrLayout;
  }
  
  public GvrSurfaceView getGvrSurfaceView()
  {
/* 437 */     return this.glSurfaceView;
  }
  
  private void runOnCardboardBackListener() {
/* 441 */     Runnable listener = this.cardboardBackListener;
/* 442 */     if (listener != null) {
/* 443 */       ThreadUtils.runOnUiThread(listener);
    }
  }
  
  @UsedByNative
  private void onCardboardTrigger() {
/* 449 */     Runnable listener = this.cardboardTriggerListener;
/* 450 */     if (listener != null) {
/* 451 */       ThreadUtils.runOnUiThread(listener);
    }
  }
  
  @UsedByNative
  private void onCardboardBack() {
/* 457 */     runOnCardboardBackListener();
  }
  
  private void queueEvent(Runnable r)
  {
/* 462 */     this.glSurfaceView.queueEvent(r);
  }
  
  private void setGvrViewerParams(final GvrViewerParams newParams) {
/* 466 */     GvrViewerParams deviceParams = new GvrViewerParams(newParams);
/* 467 */     this.uiLayout.setViewerName(deviceParams.getModel());
/* 468 */     queueEvent(new Runnable()
    {
      public void run()
      {
/* 472 */         CardboardViewNativeImpl.this.nativeSetGvrViewerParams(CardboardViewNativeImpl.this.nativeCardboardView, newParams.toByteArray());
      }
    });
  }
  
  private void setScreenParams(ScreenParams newParams) {
/* 478 */     final ScreenParams screenParams = new ScreenParams(newParams);
/* 479 */     queueEvent(new Runnable()
    {
      public void run() {
/* 482 */         CardboardViewNativeImpl.this.rendererHelper.setScreenParams(screenParams);
/* 483 */         CardboardViewNativeImpl.this.nativeSetScreenParams(CardboardViewNativeImpl.this.nativeCardboardView, screenParams.getWidth(), screenParams
/* 484 */           .getHeight(), screenParams.getWidthMeters() / screenParams.getWidth(), screenParams
/* 485 */           .getHeightMeters() / screenParams.getHeight(), screenParams
/* 486 */           .getBorderSizeMeters());
      }
    });
  }
  
  private void reconnectSensors() {
/* 492 */     queueEvent(new Runnable()
    {
      public void run()
      {
/* 496 */         CardboardViewNativeImpl.this.gvrApi.reconnectSensors();
      }
    });
  }
  
  private void checkNativeCardboardView() {
/* 502 */     if (this.nativeCardboardView == 0L) {
/* 503 */       throw new IllegalStateException("GvrView has already been shut down.");
    }
  }
  
  private class PresentationListener implements GvrLayout.PresentationListener
  {
    ScreenParams originalParams;
    
    private PresentationListener() {}
    
    public void onPresentationStarted(Display display)
    {
/* 515 */       this.originalParams = CardboardViewNativeImpl.this.getScreenParams();
/* 516 */       ScreenParams newParams = new ScreenParams(display);
      

/* 519 */       CardboardViewNativeImpl.this.updateScreenParams(newParams);
      



/* 524 */       CardboardViewNativeImpl.this.reconnectSensors();
    }
    
    public void onPresentationStopped()
    {
/* 529 */       if (this.originalParams != null) {
/* 530 */         CardboardViewNativeImpl.this.updateScreenParams(this.originalParams);
      }
    }
  }
  


  private class RendererHelper
    implements GLSurfaceView.Renderer
  {
    private GvrView.Renderer renderer;
    

    private GvrView.StereoRenderer stereoRenderer;
    

    private ScreenParams screenParams;
    
    private boolean stereoMode;
    
    private boolean surfaceCreated;
    
    private boolean invalidSurfaceSizeWarningShown;
    
    private EGLDisplay eglDisplay;
    

    public RendererHelper()
    {
/* 559 */       this.screenParams = new ScreenParams(CardboardViewNativeImpl.this.getScreenParams());
/* 560 */       this.stereoMode = CardboardViewNativeImpl.this.stereoMode;
    }
    
    public void setRenderer(GvrView.Renderer renderer) {
/* 564 */       this.renderer = renderer;
/* 565 */       CardboardViewNativeImpl.this.nativeSetRenderer(CardboardViewNativeImpl.this.nativeCardboardView, renderer);
    }
    
    public void setRenderer(GvrView.StereoRenderer stereoRenderer) {
/* 569 */       this.stereoRenderer = stereoRenderer;
/* 570 */       CardboardViewNativeImpl.this.nativeSetStereoRenderer(CardboardViewNativeImpl.this.nativeCardboardView, stereoRenderer);
    }
    
    public void setScreenParams(ScreenParams screenParams)
    {
/* 575 */       this.screenParams = screenParams;
    }
    
    public void shutdown() {
/* 579 */       CardboardViewNativeImpl.this.queueEvent(new Runnable()
      {
        public void run() {
/* 582 */           if (((CardboardViewNativeImpl.RendererHelper.this.renderer != null) || (CardboardViewNativeImpl.RendererHelper.this.stereoRenderer != null)) && (CardboardViewNativeImpl.RendererHelper.this.surfaceCreated)) {
/* 583 */             CardboardViewNativeImpl.RendererHelper.this.surfaceCreated = false;
/* 584 */             CardboardViewNativeImpl.RendererHelper.this.callOnRendererShutdown();
          }
          
/* 587 */           CardboardViewNativeImpl.this.shutdownLatch.countDown();
        }
      });
    }
    
    public void setStereoModeEnabled(final boolean enabled) {
/* 593 */       CardboardViewNativeImpl.this.checkNativeCardboardView();
      
/* 595 */       CardboardViewNativeImpl.this.gvrLayout.setStereoModeEnabled(enabled);
      
/* 597 */       CardboardViewNativeImpl.this.queueEvent(new Runnable()
      {
        public void run() {
/* 600 */           if (CardboardViewNativeImpl.RendererHelper.this.stereoMode == enabled) {
/* 601 */             return;
          }
          
/* 604 */           CardboardViewNativeImpl.RendererHelper.this.stereoMode = enabled;
          
/* 606 */           CardboardViewNativeImpl.this.nativeSetStereoModeEnabled(CardboardViewNativeImpl.this.nativeCardboardView, enabled);
          




/* 612 */           if (!EGL10.EGL_NO_SURFACE.equals(
/* 613 */             ((EGL10)EGLContext.getEGL()).eglGetCurrentSurface(12377)))
          {

/* 616 */             CardboardViewNativeImpl.RendererHelper.this.onSurfaceChanged((GL10)null, CardboardViewNativeImpl.RendererHelper.this.screenParams.getWidth(), CardboardViewNativeImpl.RendererHelper.this.screenParams.getHeight());
          }
        }
      });
    }
    
    /* Error */
    public void getCurrentEyeParams(HeadTransform head, Eye leftEye, Eye rightEye, Eye monocular, Eye leftEyeNoDistortionCorrection, Eye rightEyeNoDistortionCorrection)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 44	com/google/vr/sdk/base/CardboardViewNativeImpl$RendererHelper:this$0	Lcom/google/vr/sdk/base/CardboardViewNativeImpl;
      //   4: invokestatic 99	com/google/vr/sdk/base/CardboardViewNativeImpl:access$2400	(Lcom/google/vr/sdk/base/CardboardViewNativeImpl;)V
      //   7: new 117	java/util/concurrent/CountDownLatch
      //   10: dup
      //   11: iconst_1
      //   12: invokespecial 120	java/util/concurrent/CountDownLatch:<init>	(I)V
      //   15: astore 7
      //   17: aload_0
      //   18: getfield 44	com/google/vr/sdk/base/CardboardViewNativeImpl$RendererHelper:this$0	Lcom/google/vr/sdk/base/CardboardViewNativeImpl;
      //   21: new 12	com/google/vr/sdk/base/CardboardViewNativeImpl$RendererHelper$3
      //   24: dup
      //   25: aload_0
      //   26: aload_1
      //   27: aload_2
      //   28: aload_3
      //   29: aload 4
      //   31: aload 5
      //   33: aload 6
      //   35: aload 7
      //   37: invokespecial 123	com/google/vr/sdk/base/CardboardViewNativeImpl$RendererHelper$3:<init>	(Lcom/google/vr/sdk/base/CardboardViewNativeImpl$RendererHelper;Lcom/google/vr/sdk/base/HeadTransform;Lcom/google/vr/sdk/base/Eye;Lcom/google/vr/sdk/base/Eye;Lcom/google/vr/sdk/base/Eye;Lcom/google/vr/sdk/base/Eye;Lcom/google/vr/sdk/base/Eye;Ljava/util/concurrent/CountDownLatch;)V
      //   40: invokestatic 94	com/google/vr/sdk/base/CardboardViewNativeImpl:access$2300	(Lcom/google/vr/sdk/base/CardboardViewNativeImpl;Ljava/lang/Runnable;)V
      //   43: aload 7
      //   45: invokevirtual 126	java/util/concurrent/CountDownLatch:await	()V
      //   48: goto +44 -> 92
      //   51: astore 8
      //   53: invokestatic 134	com/google/vr/sdk/base/CardboardViewNativeImpl:access$3000	()Ljava/lang/String;
      //   56: ldc -120
      //   58: aload 8
      //   60: invokevirtual 139	java/lang/InterruptedException:toString	()Ljava/lang/String;
      //   63: invokestatic 145	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   66: dup
      //   67: invokevirtual 149	java/lang/String:length	()I
      //   70: ifeq +9 -> 79
      //   73: invokevirtual 153	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   76: goto +12 -> 88
      //   79: pop
      //   80: new 141	java/lang/String
      //   83: dup_x1
      //   84: swap
      //   85: invokespecial 156	java/lang/String:<init>	(Ljava/lang/String;)V
      //   88: invokestatic 162	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   91: pop
      //   92: return
      // Line number table:
      //   Java source line #626	-> byte code offset #0
      //   Java source line #629	-> byte code offset #7
      //   Java source line #630	-> byte code offset #17
      //   Java source line #640	-> byte code offset #43
      //   Java source line #643	-> byte code offset #48
      //   Java source line #641	-> byte code offset #51
      //   Java source line #642	-> byte code offset #53
      //   Java source line #644	-> byte code offset #92
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	93	0	this	RendererHelper
      //   0	93	1	head	HeadTransform
      //   0	93	2	leftEye	Eye
      //   0	93	3	rightEye	Eye
      //   0	93	4	monocular	Eye
      //   0	93	5	leftEyeNoDistortionCorrection	Eye
      //   0	93	6	rightEyeNoDistortionCorrection	Eye
      //   17	76	7	finished	CountDownLatch
      //   53	39	8	e	InterruptedException
      // Exception table:
      //   from	to	target	type
      //   43	48	51	java/lang/InterruptedException
    }
    
    public void onDrawFrame(GL10 gl)
    {
/* 648 */       if (((this.renderer == null) && (this.stereoRenderer == null)) || (!this.surfaceCreated)) {
/* 649 */         return;
      }
      
/* 652 */       Trace.beginSection("Render");
/* 653 */       CardboardViewNativeImpl.this.nativeOnDrawFrame(CardboardViewNativeImpl.this.nativeCardboardView);
/* 654 */       Trace.endSection();
      
/* 656 */       EGL14.eglSwapInterval(this.eglDisplay, 1);
    }
    
    public void onSurfaceChanged(GL10 gl, int width, int height)
    {
/* 661 */       if (((this.renderer == null) && (this.stereoRenderer == null)) || (!this.surfaceCreated)) {
/* 662 */         return;
      }
      




/* 669 */       if ((this.stereoMode) && ((width != this.screenParams.getWidth()) || (height != this.screenParams.getHeight()))) {
/* 670 */         if (!this.invalidSurfaceSizeWarningShown)
        {

/* 673 */           int i = this.screenParams.getWidth();int j = this.screenParams.getHeight();Log.e(CardboardViewNativeImpl.TAG, 134 + "Surface size " + width + "x" + height + " does not match the expected screen size " + i + "x" + j + ". Stereo rendering might feel off.");
        }
        
/* 676 */         this.invalidSurfaceSizeWarningShown = true;
      } else {
/* 678 */         this.invalidSurfaceSizeWarningShown = false;
      }
      
/* 681 */       CardboardViewNativeImpl.this.nativeOnSurfaceChanged(CardboardViewNativeImpl.this.nativeCardboardView, width, height);
      


/* 685 */       callOnSurfaceChanged(width, height);
    }
    
    private void callOnSurfaceCreated(EGLConfig config) {
/* 689 */       CardboardViewNativeImpl.this.nativeOnSurfaceCreated(CardboardViewNativeImpl.this.nativeCardboardView);
      
/* 691 */       if (this.renderer != null) {
/* 692 */         this.renderer.onSurfaceCreated(config);
/* 693 */       } else if (this.stereoRenderer != null) {
/* 694 */         this.stereoRenderer.onSurfaceCreated(config);
      }
    }
    
    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
/* 700 */       if ((this.renderer == null) && (this.stereoRenderer == null)) {
/* 701 */         return;
      }
      
/* 704 */       this.surfaceCreated = true;
      
/* 706 */       this.eglDisplay = EGL14.eglGetCurrentDisplay();
      
/* 708 */       callOnSurfaceCreated(config);
    }
    
    private void callOnSurfaceChanged(int width, int height) {
/* 712 */       if (this.renderer != null) {
/* 713 */         this.renderer.onSurfaceChanged(width, height);
      }
/* 715 */       else if (this.stereoRenderer != null) {
/* 716 */         if (this.stereoMode)
        {

/* 719 */           this.stereoRenderer.onSurfaceChanged(width / 2, height);
        } else {
/* 721 */           this.stereoRenderer.onSurfaceChanged(width, height);
        }
      }
    }
    
    private void callOnRendererShutdown() {
/* 727 */       if (this.renderer != null) {
/* 728 */         this.renderer.onRendererShutdown();
/* 729 */       } else if (this.stereoRenderer != null) {
/* 730 */         this.stereoRenderer.onRendererShutdown();
      }
    }
  }
  
  private static Display getDefaultDisplay(Context context) {
/* 736 */     WindowManager windowManager = (WindowManager)context.getSystemService("window");
/* 737 */     return windowManager.getDefaultDisplay();
  }
  
  private static native long nativeSetApplicationState(ClassLoader paramClassLoader, Context paramContext);
  
  private native long nativeInit(long paramLong);
  
  private native void nativeDestroy(long paramLong);
  
  private native void nativeSetRenderer(long paramLong, GvrView.Renderer paramRenderer);
  
  private native void nativeSetStereoRenderer(long paramLong, GvrView.StereoRenderer paramStereoRenderer);
  
  private native void nativeOnSurfaceCreated(long paramLong);
  
  private native void nativeOnSurfaceChanged(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeOnDrawFrame(long paramLong);
  
  private native void nativeGetCurrentEyeParams(long paramLong, HeadTransform paramHeadTransform, Eye paramEye1, Eye paramEye2, Eye paramEye3, Eye paramEye4, Eye paramEye5);
  
  private native void nativeSetNeckModelEnabled(long paramLong, boolean paramBoolean);
  
  private native float nativeGetNeckModelFactor(long paramLong);
  
  private native void nativeSetNeckModelFactor(long paramLong, float paramFloat);
  
  private native void nativeSetGvrViewerParams(long paramLong, byte[] paramArrayOfByte);
  
  private native void nativeSetScreenParams(long paramLong, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private native void nativeSetStereoModeEnabled(long paramLong, boolean paramBoolean);
  
  private native void nativeSetDistortionCorrectionEnabled(long paramLong, boolean paramBoolean);
  
  private native void nativeSetDistortionCorrectionScale(long paramLong, float paramFloat);
  
  private native void nativeSetMultisampling(long paramLong, int paramInt);
  
  private native void nativeSetDepthStencilFormat(long paramLong, int paramInt);
  
  private native void nativeUndistortTexture(long paramLong, int paramInt);
  
  private native void nativeLogEvent(long paramLong, int paramInt);
}


/* Location:              D:\MyWorks\Baofeng\gvr\libgvr\treasurehunt\libs\base.jar!\com\google\vr\sdk\base\CardboardViewNativeImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */