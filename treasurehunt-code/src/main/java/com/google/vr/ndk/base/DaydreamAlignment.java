//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.ndk.base;

import android.content.Context;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.google.vr.cardboard.DisplayUtils;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.cardboard.VrParamsProviderFactory;
import com.google.vr.ndk.base.GvrApi;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.ScreenAlignmentMarker;
import com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams;

class DaydreamAlignment {
    private static final String TAG = "DaydreamAlignment";
    private static final double MAX_TOUCH_DISTANCE_SQUARED_METERS = 2.25E-4D;
    private final VrParamsProvider vrParamsProvider;
    private DisplayMetrics displayMetrics;
    private float xMetersPerPixel;
    private float yMetersPerPixel;
    private float borderSizeMeters;
    private float[][] markersInPixels;
    private int mostTouchesSeen;
    private int[] touchBestMarker;
    private int[] markerBestTouch;
    private double[] currentMarkerBestDists;
    private float[] pixelTranslation = new float[2];
    private boolean lastMotionEventInHeadset;
    private boolean enabled = true;
    private final boolean isDaydreamImageAlignmentEnabled;

    public DaydreamAlignment(Context var1, GvrApi var2) {
        this.isDaydreamImageAlignmentEnabled = var2.getSdkConfigurationParams().daydreamImageAlignment.intValue() != 1;
        this.vrParamsProvider = VrParamsProviderFactory.create(var1);
        DaydreamAlignment.FinishInitilizationTask var3;
        (var3 = new DaydreamAlignment.FinishInitilizationTask()).display = DisplayUtils.getDefaultDisplay(var1);
        var3.execute(new Void[0]);
    }

    DaydreamAlignment(VrParamsProvider var1, DisplayMetrics var2, PhoneParams var3, boolean var4) {
        this.isDaydreamImageAlignmentEnabled = var4;
        this.vrParamsProvider = var1;
        this.init(var2, var3);
    }

    private void init(DisplayMetrics var1, PhoneParams var2) {
        this.displayMetrics = var1;
        this.borderSizeMeters = DisplayUtils.getBorderSizeMeters(var2);
        this.xMetersPerPixel = DisplayUtils.getMetersPerPixelFromDotsPerInch(this.displayMetrics.xdpi);
        this.yMetersPerPixel = DisplayUtils.getMetersPerPixelFromDotsPerInch(this.displayMetrics.ydpi);
        this.resetTrackingState();
        this.refreshViewerProfile();
    }

    public void setEnabled(boolean var1) {
        this.enabled = var1;
        if(!var1) {
            this.resetTrackingState();
        }

    }

    public boolean processMotionEvent(MotionEvent var1) {
        if(!this.viewerNeedsTouchProcessing()) {
            this.lastMotionEventInHeadset = false;
            return false;
        } else if(!this.isDaydreamImageAlignmentEnabled()) {
            return true;
        } else {
            int var2;
            if((var2 = var1.getPointerCount()) > this.mostTouchesSeen) {
                this.touchBestMarker = new int[var2];
                this.mostTouchesSeen = var2;
            }

            int var3;
            for(var3 = 0; var3 < this.markersInPixels.length; ++var3) {
                this.markerBestTouch[var3] = -1;
                this.currentMarkerBestDists[var3] = 2.25E-4D;
            }

            int var6;
            for(var3 = 0; var3 < var2; ++var3) {
                double var4 = 2.25E-4D;
                this.touchBestMarker[var3] = -1;

                for(var6 = 0; var6 < this.markersInPixels.length; ++var6) {
                    float var7 = (this.markersInPixels[var6][0] - var1.getX(var3)) * this.xMetersPerPixel;
                    float var8 = (this.markersInPixels[var6][1] - var1.getY(var3)) * this.yMetersPerPixel;
                    double var9;
                    if((var9 = (double)(var7 * var7 + var8 * var8)) < var4) {
                        var4 = var9;
                        this.touchBestMarker[var3] = var6;
                    }

                    if(var9 < this.currentMarkerBestDists[var6]) {
                        this.currentMarkerBestDists[var6] = var9;
                        this.markerBestTouch[var6] = var3;
                    }
                }
            }

            float var11 = 0.0F;
            float var12 = 0.0F;
            int var5 = 0;

            for(var6 = 0; var6 < this.markerBestTouch.length; ++var6) {
                if(this.markerBestTouch[var6] != -1) {
                    if(this.touchBestMarker[this.markerBestTouch[var6]] != var6) {
                        this.markerBestTouch[var6] = -1;
                    } else {
                        ++var5;
                        var11 += var1.getX(this.markerBestTouch[var6]) - this.markersInPixels[var6][0];
                        var12 += var1.getY(this.markerBestTouch[var6]) - this.markersInPixels[var6][1];
                    }
                }
            }

            if(var5 > 0) {
                this.lastMotionEventInHeadset = true;
                this.pixelTranslation[0] = var11 / (float)var5;
                this.pixelTranslation[1] = var12 / (float)var5;
            } else {
                this.lastMotionEventInHeadset = false;
            }

            return true;
        }
    }

    void getTranslationInPixels(float[] var1) {
        if(var1.length < 2) {
            throw new IllegalArgumentException("Translation array too small");
        } else {
            var1[0] = this.pixelTranslation[0];
            var1[1] = this.pixelTranslation[1];
        }
    }

    public void getTranslationInScreenSpace(float[] var1) {
        if(var1.length < 2) {
            throw new IllegalArgumentException("Translation array too small");
        } else {
            var1[0] = this.pixelTranslation[0] / (float)this.displayMetrics.widthPixels;
            var1[1] = this.pixelTranslation[1] / (float)this.displayMetrics.heightPixels;
            var1[0] *= 4.0F;
            var1[1] *= -2.0F;
        }
    }

    boolean viewerNeedsTouchProcessing() {
        return this.enabled && this.markersInPixels != null && this.markersInPixels.length > 0;
    }

    boolean isDaydreamImageAlignmentEnabled() {
        return this.isDaydreamImageAlignmentEnabled;
    }

    public boolean wasLastMotionEventInViewer() {
        return this.lastMotionEventInHeadset;
    }

    public void refreshViewerProfile() {
        (new DaydreamAlignment.RefreshViewerProfileTask()).execute(new Void[0]);
    }

    public void shutdown() {
        this.vrParamsProvider.close();
    }

    private void resetTrackingState() {
        this.lastMotionEventInHeadset = false;
        this.pixelTranslation[0] = 0.0F;
        this.pixelTranslation[1] = 0.0F;
        this.mostTouchesSeen = 0;
    }

    private class FinishInitilizationTask extends AsyncTask<Void, Void, PhoneParams> {
        public Display display;

        private FinishInitilizationTask() {
        }

        protected PhoneParams doInBackground(Void... var1) {
            return DaydreamAlignment.this.vrParamsProvider.readPhoneParams();
        }

        protected void onProgressUpdate(Void... var1) {
        }

        protected void onPostExecute(PhoneParams var1) {
            DisplayMetrics var2 = DisplayUtils.getDisplayMetricsLandscapeWithOverride(this.display, var1);
            DaydreamAlignment.this.init(var2, var1);
        }
    }

    private class RefreshViewerProfileTask extends AsyncTask<Void, Void, DeviceParams> {
        private RefreshViewerProfileTask() {
        }

        protected DeviceParams doInBackground(Void... var1) {
            return DaydreamAlignment.this.vrParamsProvider.readDeviceParams();
        }

        protected void onProgressUpdate(Void... var1) {
        }

        protected void onPostExecute(DeviceParams var1) {
            if(var1 != null && var1.daydreamInternal != null && var1.daydreamInternal.alignmentMarkers != null) {
                ScreenAlignmentMarker[] var2 = var1.daydreamInternal.alignmentMarkers;
                DaydreamAlignment.this.markersInPixels = new float[var2.length][];
                DaydreamAlignment.this.currentMarkerBestDists = new double[var2.length];
                DaydreamAlignment.this.markerBestTouch = new int[var2.length];

                for(int var3 = 0; var3 < var2.length; ++var3) {
                    ScreenAlignmentMarker var4 = var2[var3];
                    DaydreamAlignment.this.markersInPixels[var3] = new float[2];
                    DaydreamAlignment.this.markersInPixels[var3][0] = (float)(DaydreamAlignment.this.displayMetrics.widthPixels / 2) + var4.getHorizontal() / DaydreamAlignment.this.xMetersPerPixel;
                    DaydreamAlignment.this.markersInPixels[var3][1] = (float)DaydreamAlignment.this.displayMetrics.heightPixels - (var4.getVertical() + var1.getTrayToLensDistance() - DaydreamAlignment.this.borderSizeMeters) / DaydreamAlignment.this.yMetersPerPixel;
                }

            } else {
                DaydreamAlignment.this.markersInPixels = null;
            }
        }
    }

    public static class DefaultTouchListener implements OnTouchListener {
        private float[] lastTranslation = new float[2];
        private float[] translation = new float[2];
        private final DaydreamAlignment daydreamAlignment;
        private final GvrApi gvrApi;

        public DefaultTouchListener(DaydreamAlignment var1, GvrApi var2) {
            this.daydreamAlignment = var1;
            this.gvrApi = var2;
        }

        public boolean onTouch(View var1, MotionEvent var2) {
            if(!this.daydreamAlignment.processMotionEvent(var2)) {
                return false;
            } else {
                if(!this.daydreamAlignment.wasLastMotionEventInViewer()) {
                    this.translation[0] = 0.0F;
                    this.translation[1] = 0.0F;
                } else {
                    this.daydreamAlignment.getTranslationInScreenSpace(this.translation);
                }

                if(this.translation[0] != this.lastTranslation[0] || this.translation[1] != this.lastTranslation[1]) {
                    this.lastTranslation[0] = this.translation[0];
                    this.lastTranslation[1] = this.translation[1];
                    this.gvrApi.setLensOffset(this.translation[0], this.translation[1]);
                }

                return true;
            }
        }
    }
}
