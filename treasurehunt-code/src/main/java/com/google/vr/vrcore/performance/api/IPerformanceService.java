//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.vrcore.performance.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IPerformanceService extends IInterface {
    float getCurrentThrottlingRelativeTemperature() throws RemoteException;

    void reportFrameDrops(long var1, long var3, int var5) throws RemoteException;

    public abstract static class Stub extends Binder implements IPerformanceService {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.performance.api.IPerformanceService";
        static final int TRANSACTION_getCurrentThrottlingRelativeTemperature = 1;
        static final int TRANSACTION_reportFrameDrops = 2;

        public Stub() {
            this.attachInterface(this, "com.google.vr.vrcore.performance.api.IPerformanceService");
        }

        public static IPerformanceService asInterface(IBinder var0) {
            IInterface var1;
            return (IPerformanceService)(var0 == null?null:((var1 = var0.queryLocalInterface("com.google.vr.vrcore.performance.api.IPerformanceService")) != null && var1 instanceof IPerformanceService?(IPerformanceService)var1:new IPerformanceService.Stub.Proxy(var0)));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.vr.vrcore.performance.api.IPerformanceService");
                    float var10 = this.getCurrentThrottlingRelativeTemperature();
                    var3.writeNoException();
                    var3.writeFloat(var10);
                    return true;
                case 2:
                    var2.enforceInterface("com.google.vr.vrcore.performance.api.IPerformanceService");
                    long var5 = var2.readLong();
                    long var7 = var2.readLong();
                    int var9 = var2.readInt();
                    this.reportFrameDrops(var5, var7, var9);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.vr.vrcore.performance.api.IPerformanceService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }

        private static class Proxy implements IPerformanceService {
            private IBinder mRemote;

            Proxy(IBinder var1) {
                this.mRemote = var1;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.google.vr.vrcore.performance.api.IPerformanceService";
            }

            public float getCurrentThrottlingRelativeTemperature() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                float var3;
                try {
                    var1.writeInterfaceToken("com.google.vr.vrcore.performance.api.IPerformanceService");
                    this.mRemote.transact(1, var1, var2, 0);
                    var2.readException();
                    var3 = var2.readFloat();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }

            public void reportFrameDrops(long var1, long var3, int var5) throws RemoteException {
                Parcel var6 = Parcel.obtain();

                try {
                    var6.writeInterfaceToken("com.google.vr.vrcore.performance.api.IPerformanceService");
                    var6.writeLong(var1);
                    var6.writeLong(var3);
                    var6.writeInt(var5);
                    this.mRemote.transact(2, var6, (Parcel)null, 1);
                } finally {
                    var6.recycle();
                }

            }
        }
    }
}
