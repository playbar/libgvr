//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.ndk.base;

import android.content.Context;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams;
import com.google.protobuf.nano.MessageNano;
import com.google.vr.cardboard.DisplaySynchronizer;
import com.google.vr.cardboard.DisplayUtils;
import com.google.vr.cardboard.EglReadyListener;
import com.google.vr.cardboard.UsedByNative;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.cardboard.VrParamsProviderFactory;
import com.google.vr.cardboard.annotations.UsedByReflection;
import com.google.vr.ndk.base.BufferSpec;
import com.google.vr.ndk.base.BufferViewport;
import com.google.vr.ndk.base.BufferViewportList;
import com.google.vr.ndk.base.ExternalSurface;
import com.google.vr.ndk.base.GvrAnalytics;
import com.google.vr.ndk.base.SdkConfigurationReader;
import com.google.vr.ndk.base.SwapChain;
import com.google.vr.ndk.base.UserPrefs;
import com.google.vr.ndk.base.GvrLayout.ExternalSurfaceListener;
import com.google.vr.sdk.proto.nano.CardboardDevice.DeviceParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@UsedByReflection("Unity")
public class GvrApi {
    private static final String TAG = GvrApi.class.getSimpleName();
    private static final boolean IS_ROBOLECTRIC_BUILD;
    private static GvrApi.PoseTracker sPoseTrackerForTesting;
    private long nativeGvrContext;
    private final boolean ownsNativeGvrContext;
    private final Context context;
    private final VrParamsProvider vrParamsProvider;
    private final DisplaySynchronizer displaySynchronizer;
    private ArrayList<WeakReference<SwapChain>> swapChainRefs;
    private UserPrefs userPrefs;
    private GvrAnalytics analytics;

    public static void setPoseTrackerForTesting(GvrApi.PoseTracker var0) {
        sPoseTrackerForTesting = var0;
    }

    public static void setDynamicLibraryLoadingEnabled(boolean var0) {
        nativeSetDynamicLibraryLoadingEnabled(var0);
    }

    public static boolean usingDynamicLibrary(Context var0) {
        setApplicationState(var0);
        return nativeUsingDynamicLibrary();
    }

    public GvrApi(Context var1, DisplaySynchronizer var2) {
        this.context = var1;
        this.displaySynchronizer = var2;
        long var3 = var2 == null?0L:var2.getNativeDisplaySynchronizer();
        this.vrParamsProvider = VrParamsProviderFactory.create(var1);
        this.swapChainRefs = new ArrayList();
        DisplayMetrics var5 = this.computeCurrentDisplayMetrics();
        this.ownsNativeGvrContext = true;
        if(!IS_ROBOLECTRIC_BUILD) {
            this.nativeGvrContext = this.nativeCreate(this.getClass().getClassLoader(), var1.getApplicationContext(), var3, var5.widthPixels, var5.heightPixels, var5.xdpi, var5.ydpi, sPoseTrackerForTesting);
            if(this.nativeGvrContext == 0L) {
                throw new IllegalStateException("Native GVR context creation failed, implementation unavailable.");
            }
        }

    }

    GvrApi(Context var1, long var2) {
        if(var2 == 0L) {
            throw new IllegalArgumentException("Invalid wrapped native GVR context.");
        } else {
            this.context = var1;
            this.ownsNativeGvrContext = false;
            this.nativeGvrContext = var2;
            this.vrParamsProvider = VrParamsProviderFactory.create(var1);
            this.displaySynchronizer = null;
            this.swapChainRefs = new ArrayList();
            setApplicationState(var1);
        }
    }

    void requestContextSharing(EglReadyListener var1) {
        this.nativeRequestContextSharing(this.nativeGvrContext, var1);
    }

    static DisplaySynchronizer createDefaultDisplaySynchronizer(Context var0) {
        return new DisplaySynchronizer(var0, DisplayUtils.getDefaultDisplay(var0));
    }

    protected void finalize() throws Throwable {
        try {
            if(this.nativeGvrContext != 0L) {
                Log.w(TAG, "GvrApi.shutdown() should be called to ensure resource cleanup");
                this.shutdown();
            }
        } finally {
            super.finalize();
        }

    }

    SdkConfigurationParams getSdkConfigurationParams() {
        return SdkConfigurationReader.getParams(this.context);
    }

    void pause() {
        this.nativePause(this.nativeGvrContext);
    }

    void resume() {
        this.nativeResume(this.nativeGvrContext);
    }

    public void shutdown() {
        ArrayList var4;
        int var5 = (var4 = (ArrayList)this.swapChainRefs).size();
        int var6 = 0;
        Object var1 = null;

        while(var6 < var5) {
            Object var10000 = var4.get(var6);
            ++var6;
            SwapChain var3;
            if((var3 = (SwapChain)((WeakReference)var10000).get()) != null) {
                var3.shutdown();
            }
        }

        if(this.nativeGvrContext != 0L) {
            this.vrParamsProvider.close();
            if(this.ownsNativeGvrContext) {
                this.nativeReleaseGvrContext(this.nativeGvrContext);
            }

            this.nativeGvrContext = 0L;
        }

    }

    @UsedByReflection("Unity")
    public long getNativeGvrContext() {
        return this.nativeGvrContext;
    }

    public int getError() {
        return this.nativeGetError(this.nativeGvrContext);
    }

    public int clearError() {
        return this.nativeClearError(this.nativeGvrContext);
    }

    public static String getErrorString(int var0) {
        return nativeGetErrorString(var0);
    }

    public UserPrefs getUserPrefs() {
        if(this.userPrefs == null) {
            this.userPrefs = new UserPrefs(this.nativeGetUserPrefs(this.nativeGvrContext));
        }

        return this.userPrefs;
    }

    public GvrAnalytics experimentalGetAnalytics() {
        return this.analytics;
    }

    void dumpDebugData() {
        this.nativeDumpDebugData(this.nativeGvrContext);
    }

    public void initializeGl() {
        this.nativeInitializeGl(this.nativeGvrContext);
    }

    public void onSurfaceCreatedReprojectionThread() {
        this.nativeOnSurfaceCreatedReprojectionThread(this.nativeGvrContext);
    }

    public void onSurfaceChangedReprojectionThread() {
        this.nativeOnSurfaceChangedReprojectionThread(this.nativeGvrContext);
    }

    public BufferSpec createBufferSpec() {
        return new BufferSpec(nativeBufferSpecCreate(this.nativeGvrContext));
    }

    public ExternalSurface createExternalSurface(ExternalSurfaceListener var1, Handler var2) {
        return new ExternalSurface(this, var1, var2);
    }

    public SwapChain createSwapChain(BufferSpec[] var1) {
        long[] var2 = new long[var1.length];

        for(int var3 = 0; var3 < var1.length; ++var3) {
            var2[var3] = var1[var3].nativeBufferSpec;
        }

        SwapChain var4 = new SwapChain(nativeSwapChainCreate(this.nativeGvrContext, var2));
        this.swapChainRefs.add(new WeakReference(var4));
        return var4;
    }

    public BufferViewportList createBufferViewportList() {
        return new BufferViewportList(this.nativeBufferViewportListCreate(this.nativeGvrContext));
    }

    public BufferViewport createBufferViewport() {
        return new BufferViewport(nativeBufferViewportCreate(this.nativeGvrContext));
    }

    public void getRecommendedBufferViewports(BufferViewportList var1) {
        this.nativeGetRecommendedBufferViewports(this.nativeGvrContext, var1.nativeBufferViewportList);
    }

    public void getScreenBufferViewports(BufferViewportList var1) {
        this.nativeGetScreenBufferViewports(this.nativeGvrContext, var1.nativeBufferViewportList);
    }

    public void getMaximumEffectiveRenderTargetSize(Point var1) {
        this.nativeGetMaximumEffectiveRenderTargetSize(this.nativeGvrContext, var1);
    }

    public void getScreenTargetSize(Point var1) {
        this.nativeGetScreenTargetSize(this.nativeGvrContext, var1);
    }

    /** @deprecated */
    @Deprecated
    public void distortToScreen(int var1, BufferViewportList var2, float[] var3, long var4) {
        if(var3 == null) {
            throw new IllegalArgumentException("Head transform must not be null.");
        } else {
            this.nativeDistortToScreen(this.nativeGvrContext, var1, var2.nativeBufferViewportList, var3, var4);
        }
    }

    public Point renderReprojectionThread() {
        return this.nativeRenderReprojectionThread(this.nativeGvrContext);
    }

    public void onPauseReprojectionThread() {
        this.nativeOnPauseReprojectionThread(this.nativeGvrContext);
    }

    public void setDefaultFramebufferActive() {
        this.nativeSetDefaultFramebufferActive(this.nativeGvrContext);
    }

    public void getHeadSpaceFromStartSpaceRotation(float[] var1, long var2) {
        if(var1 != null && var1.length == 16) {
            this.nativeGetHeadSpaceFromStartSpaceRotation(this.nativeGvrContext, var1, var2);
        } else {
            throw new IllegalArgumentException("Invalid head rotation argument, must be a float[16].");
        }
    }

    void setIgnoreManualTrackerPauseResume(boolean var1) {
        this.nativeSetIgnoreManualPauseResumeTracker(this.nativeGvrContext, var1);
    }

    public void pauseTracking() {
        this.nativePauseTracking(this.nativeGvrContext);
    }

    public void resumeTracking() {
        this.nativeResumeTracking(this.nativeGvrContext);
    }

    public byte[] pauseTrackingGetState() {
        return this.nativePauseTrackingGetState(this.nativeGvrContext);
    }

    public void resumeTrackingSetState(byte[] var1) {
        this.nativeResumeTrackingSetState(this.nativeGvrContext, var1);
    }

    public void resetTracking() {
        this.nativeResetTracking(this.nativeGvrContext);
    }

    public void recenterTracking() {
        this.nativeRecenterTracking(this.nativeGvrContext);
    }

    public void reconnectSensors() {
        this.nativeReconnectSensors(this.nativeGvrContext);
    }

    void setIdleListener(GvrApi.IdleListener var1) {
        this.nativeSetIdleListener(this.nativeGvrContext, var1);
    }

    public void refreshDisplayMetrics() {
        this.setDisplayMetrics(this.computeCurrentDisplayMetrics());
    }

    public boolean setDefaultViewerProfile(String var1) {
        return this.nativeSetDefaultViewerProfile(this.nativeGvrContext, var1);
    }

    public void refreshViewerProfile() {
        DeviceParams var1;
        if((var1 = this.vrParamsProvider.readDeviceParams()) != null) {
            this.setViewerParams(MessageNano.toByteArray(var1));
        }

    }

    public String getViewerVendor() {
        return this.nativeGetViewerVendor(this.nativeGvrContext);
    }

    public String getViewerModel() {
        return this.nativeGetViewerModel(this.nativeGvrContext);
    }

    public int getViewerType() {
        return this.nativeGetViewerType(this.nativeGvrContext);
    }

    /** @deprecated */
    @Deprecated
    public float[] getEyeFromHeadMatrix(int var1) {
        float[] var2 = new float[16];
        this.getEyeFromHeadMatrix(var1, var2);
        return var2;
    }

    public void getEyeFromHeadMatrix(int var1, float[] var2) {
        this.nativeGetEyeFromHeadMatrix(this.nativeGvrContext, var1, var2);
    }

    public int[] getWindowBounds() {
        int[] var1;
        if((var1 = this.nativeGetWindowBounds(this.nativeGvrContext)).length != 4) {
            throw new AssertionError("Implementation error: invalid window bounds.");
        } else {
            return var1;
        }
    }

    public float[] computeDistortedPoint(int var1, float[] var2) {
        float[] var3;
        if((var3 = this.nativeComputeDistortedPoint(this.nativeGvrContext, var1, var2)).length != 6) {
            throw new AssertionError("Implementation error: invalid UV coordinates output.");
        } else {
            return var3;
        }
    }

    boolean setAsyncReprojectionEnabled(boolean var1) {
        return this.nativeSetAsyncReprojectionEnabled(this.nativeGvrContext, var1);
    }

    public boolean getAsyncReprojectionEnabled() {
        return this.nativeGetAsyncReprojectionEnabled(this.nativeGvrContext);
    }

    public void setSurfaceSize(int var1, int var2) {
        if(var1 == 0 != (var2 == 0)) {
            throw new IllegalArgumentException("Custom surface dimensions should both either be zero or non-zero");
        } else {
            this.nativeSetSurfaceSize(this.nativeGvrContext, var1, var2);
        }
    }

    public boolean isFeatureSupported(int var1) {
        return this.nativeIsFeatureSupported(this.nativeGvrContext, var1);
    }

    public void setLensOffset(float var1, float var2) {
        this.nativeSetLensOffset(this.nativeGvrContext, var1, var2);
    }

    DisplayMetrics computeCurrentDisplayMetrics() {
        Display var1;
        if(this.displaySynchronizer == null) {
            var1 = DisplayUtils.getDefaultDisplay(this.context);
        } else {
            var1 = this.displaySynchronizer.getDisplay();
        }

        return DisplayUtils.getDisplayMetricsLandscapeWithOverride(var1, this.vrParamsProvider.readPhoneParams());
    }

    void setDisplayMetrics(DisplayMetrics var1) {
        this.nativeSetDisplayMetrics(this.nativeGvrContext, var1.widthPixels, var1.heightPixels, var1.xdpi, var1.ydpi);
    }

    public float getBorderSizeMeters() {
        return this.nativeGetBorderSizeMeters(this.nativeGvrContext);
    }

    private boolean setViewerParams(byte[] var1) {
        return this.nativeSetViewerParams(this.nativeGvrContext, var1);
    }

    public boolean usingVrDisplayService() {
        return this.nativeUsingVrDisplayService(this.nativeGvrContext);
    }

    private static void setApplicationState(Context var0) {
        if(!IS_ROBOLECTRIC_BUILD) {
            nativeSetApplicationState(GvrApi.class.getClassLoader(), var0.getApplicationContext());
        }

    }

    private native long nativeBufferViewportListCreate(long var1);

    static native void nativeBufferViewportListDestroy(long var0);

    static native int nativeBufferViewportListGetSize(long var0);

    static native void nativeBufferViewportListGetItem(long var0, int var2, long var3);

    static native void nativeBufferViewportListSetItem(long var0, int var2, long var3);

    static native long nativeBufferViewportCreate(long var0);

    static native void nativeBufferViewportDestroy(long var0);

    static native void nativeBufferViewportGetSourceUv(long var0, RectF var2);

    static native void nativeBufferViewportSetSourceUv(long var0, float var2, float var3, float var4, float var5);

    static native void nativeBufferViewportGetSourceFov(long var0, RectF var2);

    static native void nativeBufferViewportSetSourceFov(long var0, float var2, float var3, float var4, float var5);

    static native void nativeBufferViewportGetTransform(long var0, float[] var2);

    static native void nativeBufferViewportSetTransform(long var0, float[] var2);

    static native boolean nativeBufferViewportEqual(long var0, long var2);

    static native int nativeBufferViewportGetTargetEye(long var0);

    static native void nativeBufferViewportSetTargetEye(long var0, int var2);

    static native int nativeBufferViewportGetSourceBufferIndex(long var0);

    static native void nativeBufferViewportSetSourceBufferIndex(long var0, int var2);

    static native int nativeBufferViewportGetExternalSurfaceId(long var0);

    static native void nativeBufferViewportSetExternalSurfaceId(long var0, int var2);

    static native void nativeBufferViewportSetExternalSurface(long var0, long var2);

    static native int nativeBufferViewportGetReprojection(long var0);

    static native void nativeBufferViewportSetReprojection(long var0, int var2);

    static native void nativeBufferViewportSetSourceLayer(long var0, int var2);

    static native long nativeBufferSpecCreate(long var0);

    static native void nativeBufferSpecDestroy(long var0);

    static native void nativeBufferSpecGetSize(long var0, Point var2);

    static native void nativeBufferSpecSetSize(long var0, int var2, int var3);

    static native void nativeBufferSpecSetColorFormat(long var0, int var2);

    static native void nativeBufferSpecSetDepthStencilFormat(long var0, int var2);

    static native void nativeBufferSpecSetMultiviewLayers(long var0, int var2);

    static native int nativeBufferSpecGetSamples(long var0);

    static native void nativeBufferSpecSetSamples(long var0, int var2);

    static native long nativeExternalSurfaceCreate(long var0);

    static native long nativeExternalSurfaceCreateWithListeners(long var0, Runnable var2, Runnable var3, Handler var4);

    static native void nativeExternalSurfaceDestroy(long var0);

    static native int nativeExternalSurfaceGetId(long var0);

    static native Surface nativeExternalSurfaceGetSurface(long var0);

    static native long nativeSwapChainCreate(long var0, long[] var2);

    static native void nativeSwapChainDestroy(long var0);

    static native int nativeSwapChainGetBufferCount(long var0);

    static native void nativeSwapChainGetBufferSize(long var0, int var2, Point var3);

    static native void nativeSwapChainResizeBuffer(long var0, int var2, int var3, int var4);

    static native long nativeSwapChainAcquireFrame(long var0);

    static native void nativeFrameBindBuffer(long var0, int var2);

    static native void nativeFrameUnbind(long var0);

    static native int nativeFrameGetFramebufferObject(long var0, int var2);

    static native void nativeFrameGetBufferSize(long var0, int var2, Point var3);

    static native void nativeFrameSubmit(long var0, long var2, float[] var4);

    private static native boolean nativeUsingDynamicLibrary();

    private static native void nativeSetApplicationState(ClassLoader var0, Context var1);

    private static native void nativeSetDynamicLibraryLoadingEnabled(boolean var0);

    private native long nativeCreate(ClassLoader var1, Context var2, long var3, int var5, int var6, float var7, float var8, GvrApi.PoseTracker var9);

    private native void nativeRequestContextSharing(long var1, EglReadyListener var3);

    private native int nativeGetError(long var1);

    private native int nativeClearError(long var1);

    private static native String nativeGetErrorString(int var0);

    private native long nativeGetUserPrefs(long var1);

    static native int nativeUserPrefsGetControllerHandedness(long var0);

    static native boolean nativeUserPrefsGetPerformanceMonitoringEnabled(long var0);

    static native boolean nativeUserPrefsGetPerformanceHudEnabled(long var0);

    private native long nativeGetAnalytics(long var1);

    static native byte[] nativeAnalyticsCreateSample(long var0, byte[] var2);

    private native void nativePause(long var1);

    private native void nativeResume(long var1);

    private native void nativeReleaseGvrContext(long var1);

    private native void nativeInitializeGl(long var1);

    private native void nativeOnSurfaceCreatedReprojectionThread(long var1);

    private native void nativeOnSurfaceChangedReprojectionThread(long var1);

    private native void nativeGetRecommendedBufferViewports(long var1, long var3);

    private native void nativeGetScreenBufferViewports(long var1, long var3);

    private native void nativeGetMaximumEffectiveRenderTargetSize(long var1, Point var3);

    private native void nativeGetScreenTargetSize(long var1, Point var3);

    private native void nativeDistortToScreen(long var1, int var3, long var4, float[] var6, long var7);

    private native void nativeSetDefaultFramebufferActive(long var1);

    private native Point nativeRenderReprojectionThread(long var1);

    private native void nativeOnPauseReprojectionThread(long var1);

    private native void nativeGetHeadSpaceFromStartSpaceRotation(long var1, float[] var3, long var4);

    private native void nativeSetIgnoreManualPauseResumeTracker(long var1, boolean var3);

    private native void nativePauseTracking(long var1);

    private native byte[] nativePauseTrackingGetState(long var1);

    private native void nativeResumeTracking(long var1);

    private native void nativeResumeTrackingSetState(long var1, byte[] var3);

    private native void nativeResetTracking(long var1);

    private native void nativeRecenterTracking(long var1);

    private native void nativeGetEyeFromHeadMatrix(long var1, int var3, float[] var4);

    private native int[] nativeGetWindowBounds(long var1);

    private native float[] nativeComputeDistortedPoint(long var1, int var3, float[] var4);

    private native boolean nativeSetDefaultViewerProfile(long var1, String var3);

    private native String nativeGetViewerVendor(long var1);

    private native String nativeGetViewerModel(long var1);

    private native int nativeGetViewerType(long var1);

    private native boolean nativeSetAsyncReprojectionEnabled(long var1, boolean var3);

    private native boolean nativeGetAsyncReprojectionEnabled(long var1);

    private native boolean nativeIsFeatureSupported(long var1, int var3);

    private native void nativeReconnectSensors(long var1);

    private native void nativeSetIdleListener(long var1, GvrApi.IdleListener var3);

    private native boolean nativeSetViewerParams(long var1, byte[] var3);

    private native void nativeSetDisplayMetrics(long var1, int var3, int var4, float var5, float var6);

    private native float nativeGetBorderSizeMeters(long var1);

    private native void nativeSetSurfaceSize(long var1, int var3, int var4);

    private native void nativeSetLensOffset(long var1, float var3, float var4);

    private native void nativeDumpDebugData(long var1);

    private native boolean nativeUsingVrDisplayService(long var1);

    static {
        IS_ROBOLECTRIC_BUILD = "robolectric".equals(Build.FINGERPRINT);

        try {
            System.loadLibrary("gvr");
        } catch (UnsatisfiedLinkError var0) {
            ;
        }
    }

    public abstract static class ViewerType {
        public static final int CARDBOARD = 0;
        public static final int DAYDREAM = 1;
        static final int DEFAULT = 0;

        public ViewerType() {
        }
    }

    @UsedByNative
    interface IdleListener {
        @UsedByNative
        void onIdleChanged(boolean var1);
    }

    public abstract static class Error {
        public static final int NONE = 0;
        public static final int CONTROLLER_CREATE_FAILED = 2;
        public static final int NO_FRAME_AVAILABLE = 3;

        public Error() {
        }
    }

    @UsedByNative
    public interface PoseTracker {
        @UsedByNative
        void getHeadPoseInStartSpace(float[] var1, long var2);
    }

    public abstract static class Feature {
        public static final int ASYNC_REPROJECTION = 0;
        public static final int MULTIVIEW = 1;
        public static final int EXTERNAL_SURFACE = 2;

        public Feature() {
        }
    }
}
