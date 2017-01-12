//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.sdk.base;

import android.opengl.Matrix;
import com.google.vr.cardboard.UsedByNative;

@UsedByNative
public class HeadTransform {
    private static final float GIMBAL_LOCK_EPSILON = 0.01F;
    private final float[] headView = new float[16];

    public HeadTransform() {
        Matrix.setIdentityM(this.headView, 0);
    }

    @UsedByNative
    public float[] getHeadView() {
        return this.headView;
    }

    public void getHeadView(float[] headView, int offset) {
        if(offset + 16 > headView.length) {
            throw new IllegalArgumentException("Not enough space to write the result");
        } else {
            System.arraycopy(this.headView, 0, headView, offset, 16);
        }
    }

    public void getForwardVector(float[] forward, int offset) {
        if(offset + 3 > forward.length) {
            throw new IllegalArgumentException("Not enough space to write the result");
        } else {
            for(int i = 0; i < 3; ++i) {
                forward[i + offset] = -this.headView[2 + i * 4];
            }

        }
    }

    public void getUpVector(float[] up, int offset) {
        if(offset + 3 > up.length) {
            throw new IllegalArgumentException("Not enough space to write the result");
        } else {
            for(int i = 0; i < 3; ++i) {
                up[i + offset] = this.headView[1 + i * 4];
            }

        }
    }

    public void getRightVector(float[] right, int offset) {
        if(offset + 3 > right.length) {
            throw new IllegalArgumentException("Not enough space to write the result");
        } else {
            for(int i = 0; i < 3; ++i) {
                right[i + offset] = this.headView[i * 4];
            }

        }
    }

    public void getQuaternion(float[] quaternion, int offset) {
        if(offset + 4 > quaternion.length) {
            throw new IllegalArgumentException("Not enough space to write the result");
        } else {
            float[] m = this.headView;
            float t = m[0] + m[5] + m[10];
            float x;
            float y;
            float z;
            float w;
            float s;
            if(t >= 0.0F) {
                s = (float)Math.sqrt((double)(t + 1.0F));
                w = 0.5F * s;
                s = 0.5F / s;
                x = (m[9] - m[6]) * s;
                y = (m[2] - m[8]) * s;
                z = (m[4] - m[1]) * s;
            } else if(m[0] > m[5] && m[0] > m[10]) {
                s = (float)Math.sqrt((double)(1.0F + m[0] - m[5] - m[10]));
                x = s * 0.5F;
                s = 0.5F / s;
                y = (m[4] + m[1]) * s;
                z = (m[2] + m[8]) * s;
                w = (m[9] - m[6]) * s;
            } else if(m[5] > m[10]) {
                s = (float)Math.sqrt((double)(1.0F + m[5] - m[0] - m[10]));
                y = s * 0.5F;
                s = 0.5F / s;
                x = (m[4] + m[1]) * s;
                z = (m[9] + m[6]) * s;
                w = (m[2] - m[8]) * s;
            } else {
                s = (float)Math.sqrt((double)(1.0F + m[10] - m[0] - m[5]));
                z = s * 0.5F;
                s = 0.5F / s;
                x = (m[2] + m[8]) * s;
                y = (m[9] + m[6]) * s;
                w = (m[4] - m[1]) * s;
            }

            quaternion[offset + 0] = x;
            quaternion[offset + 1] = y;
            quaternion[offset + 2] = z;
            quaternion[offset + 3] = w;
        }
    }

    public void getEulerAngles(float[] eulerAngles, int offset) {
        if(offset + 3 > eulerAngles.length) {
            throw new IllegalArgumentException("Not enough space to write the result");
        } else {
            float pitch = (float)Math.asin((double)this.headView[6]);
            float yaw;
            float roll;
            if(Math.sqrt((double)(1.0F - this.headView[6] * this.headView[6])) >= 0.009999999776482582D) {
                yaw = (float)Math.atan2((double)(-this.headView[2]), (double)this.headView[10]);
                roll = (float)Math.atan2((double)(-this.headView[4]), (double)this.headView[5]);
            } else {
                yaw = 0.0F;
                roll = (float)Math.atan2((double)this.headView[1], (double)this.headView[0]);
            }

            eulerAngles[offset + 0] = -pitch;
            eulerAngles[offset + 1] = -yaw;
            eulerAngles[offset + 2] = -roll;
        }
    }

    public void getTranslation(float[] translation, int offset) {
        if(offset + 3 > translation.length) {
            throw new IllegalArgumentException("Not enough space to write the result");
        } else {
            for(int i = 0; i < 3; ++i) {
                translation[i + offset] = this.headView[12 + i];
            }

        }
    }
}
