//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.vrcore.common.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.vr.vrcore.common.api.HeadTrackingState;

public interface IDaydreamListener extends IInterface {
    int getTargetApiVersion() throws RemoteException;

    HeadTrackingState requestStopTracking() throws RemoteException;

    void applyFade(int var1, long var2) throws RemoteException;

    void recenterHeadTracking() throws RemoteException;

    void dumpDebugData() throws RemoteException;

    void resumeHeadTracking(HeadTrackingState var1) throws RemoteException;

    public abstract static class Stub extends Binder implements IDaydreamListener {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.IDaydreamListener";
        static final int TRANSACTION_getTargetApiVersion = 1;
        static final int TRANSACTION_requestStopTracking = 2;
        static final int TRANSACTION_applyFade = 3;
        static final int TRANSACTION_recenterHeadTracking = 4;
        static final int TRANSACTION_dumpDebugData = 5;
        static final int TRANSACTION_resumeHeadTracking = 6;

        public Stub() {
            this.attachInterface(this, "com.google.vr.vrcore.common.api.IDaydreamListener");
        }

        public static IDaydreamListener asInterface(IBinder var0) {
            IInterface var1;
            return (IDaydreamListener)(var0 == null?null:((var1 = var0.queryLocalInterface("com.google.vr.vrcore.common.api.IDaydreamListener")) != null && var1 instanceof IDaydreamListener?(IDaydreamListener)var1:new IDaydreamListener.Stub.Proxy(var0)));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            HeadTrackingState var5;
            int var8;
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
                    var8 = this.getTargetApiVersion();
                    var3.writeNoException();
                    var3.writeInt(var8);
                    return true;
                case 2:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
                    var5 = this.requestStopTracking();
                    var3.writeNoException();
                    if(var5 != null) {
                        var3.writeInt(1);
                        var5.writeToParcel(var3, 1);
                    } else {
                        var3.writeInt(0);
                    }

                    return true;
                case 3:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
                    var8 = var2.readInt();
                    long var6 = var2.readLong();
                    this.applyFade(var8, var6);
                    return true;
                case 4:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
                    this.recenterHeadTracking();
                    return true;
                case 5:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
                    this.dumpDebugData();
                    return true;
                case 6:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
                    if(0 != var2.readInt()) {
                        var5 = (HeadTrackingState)HeadTrackingState.CREATOR.createFromParcel(var2);
                    } else {
                        var5 = null;
                    }

                    this.resumeHeadTracking(var5);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.vr.vrcore.common.api.IDaydreamListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }

        private static class Proxy implements IDaydreamListener {
            private IBinder mRemote;

            Proxy(IBinder var1) {
                this.mRemote = var1;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.google.vr.vrcore.common.api.IDaydreamListener";
            }

            public int getTargetApiVersion() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                int var3;
                try {
                    var1.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamListener");
                    this.mRemote.transact(1, var1, var2, 0);
                    var2.readException();
                    var3 = var2.readInt();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }

            public HeadTrackingState requestStopTracking() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                HeadTrackingState var3;
                try {
                    var1.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamListener");
                    this.mRemote.transact(2, var1, var2, 0);
                    var2.readException();
                    if(0 != var2.readInt()) {
                        var3 = (HeadTrackingState)HeadTrackingState.CREATOR.createFromParcel(var2);
                    } else {
                        var3 = null;
                    }
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }

            public void applyFade(int var1, long var2) throws RemoteException {
                Parcel var4 = Parcel.obtain();

                try {
                    var4.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamListener");
                    var4.writeInt(var1);
                    var4.writeLong(var2);
                    this.mRemote.transact(3, var4, (Parcel)null, 1);
                } finally {
                    var4.recycle();
                }

            }

            public void recenterHeadTracking() throws RemoteException {
                Parcel var1 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamListener");
                    this.mRemote.transact(4, var1, (Parcel)null, 1);
                } finally {
                    var1.recycle();
                }

            }

            public void dumpDebugData() throws RemoteException {
                Parcel var1 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamListener");
                    this.mRemote.transact(5, var1, (Parcel)null, 1);
                } finally {
                    var1.recycle();
                }

            }

            public void resumeHeadTracking(HeadTrackingState var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamListener");
                    if(var1 != null) {
                        var2.writeInt(1);
                        var1.writeToParcel(var2, 0);
                    } else {
                        var2.writeInt(0);
                    }

                    this.mRemote.transact(6, var2, (Parcel)null, 1);
                } finally {
                    var2.recycle();
                }

            }
        }
    }
}
