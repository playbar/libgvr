//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.vrcore.common.api;

import android.content.ComponentName;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.vr.vrcore.common.api.IDaydreamManager;
import com.google.vr.vrcore.logging.api.IVrCoreLoggingService;

public interface IVrCoreSdkService extends IInterface {
    boolean initialize(int var1) throws RemoteException;

    IDaydreamManager getDaydreamManager() throws RemoteException;

    boolean setClientOptions(ComponentName var1, Bundle var2) throws RemoteException;

    IVrCoreLoggingService getLoggingService() throws RemoteException;

    public abstract static class Stub extends Binder implements IVrCoreSdkService {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.IVrCoreSdkService";
        static final int TRANSACTION_initialize = 1;
        static final int TRANSACTION_getDaydreamManager = 2;
        static final int TRANSACTION_setClientOptions = 3;
        static final int TRANSACTION_getLoggingService = 4;

        public Stub() {
            this.attachInterface(this, "com.google.vr.vrcore.common.api.IVrCoreSdkService");
        }

        public static IVrCoreSdkService asInterface(IBinder var0) {
            IInterface var1;
            return (IVrCoreSdkService)(var0 == null?null:((var1 = var0.queryLocalInterface("com.google.vr.vrcore.common.api.IVrCoreSdkService")) != null && var1 instanceof IVrCoreSdkService?(IVrCoreSdkService)var1:new IVrCoreSdkService.Stub.Proxy(var0)));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                    int var10 = var2.readInt();
                    boolean var11 = this.initialize(var10);
                    var3.writeNoException();
                    var3.writeInt(var11?1:0);
                    return true;
                case 2:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                    IDaydreamManager var9 = this.getDaydreamManager();
                    var3.writeNoException();
                    var3.writeStrongBinder(var9 != null?var9.asBinder():null);
                    return true;
                case 3:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                    ComponentName var8;
                    if(0 != var2.readInt()) {
                        var8 = (ComponentName)ComponentName.CREATOR.createFromParcel(var2);
                    } else {
                        var8 = null;
                    }

                    Bundle var6;
                    if(0 != var2.readInt()) {
                        var6 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var6 = null;
                    }

                    boolean var7 = this.setClientOptions(var8, var6);
                    var3.writeNoException();
                    var3.writeInt(var7?1:0);
                    return true;
                case 4:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                    IVrCoreLoggingService var5 = this.getLoggingService();
                    var3.writeNoException();
                    var3.writeStrongBinder(var5 != null?var5.asBinder():null);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }

        private static class Proxy implements IVrCoreSdkService {
            private IBinder mRemote;

            Proxy(IBinder var1) {
                this.mRemote = var1;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.google.vr.vrcore.common.api.IVrCoreSdkService";
            }

            public boolean initialize(int var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                boolean var4;
                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                    var2.writeInt(var1);
                    this.mRemote.transact(1, var2, var3, 0);
                    var3.readException();
                    var4 = 0 != var3.readInt();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

                return var4;
            }

            public IDaydreamManager getDaydreamManager() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                IDaydreamManager var3;
                try {
                    var1.writeInterfaceToken("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                    this.mRemote.transact(2, var1, var2, 0);
                    var2.readException();
                    var3 = com.google.vr.vrcore.common.api.IDaydreamManager.Stub.asInterface(var2.readStrongBinder());
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }

            public boolean setClientOptions(ComponentName var1, Bundle var2) throws RemoteException {
                Parcel var3 = Parcel.obtain();
                Parcel var4 = Parcel.obtain();

                boolean var5;
                try {
                    var3.writeInterfaceToken("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                    if(var1 != null) {
                        var3.writeInt(1);
                        var1.writeToParcel(var3, 0);
                    } else {
                        var3.writeInt(0);
                    }

                    if(var2 != null) {
                        var3.writeInt(1);
                        var2.writeToParcel(var3, 0);
                    } else {
                        var3.writeInt(0);
                    }

                    this.mRemote.transact(3, var3, var4, 0);
                    var4.readException();
                    var5 = 0 != var4.readInt();
                } finally {
                    var4.recycle();
                    var3.recycle();
                }

                return var5;
            }

            public IVrCoreLoggingService getLoggingService() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                IVrCoreLoggingService var3;
                try {
                    var1.writeInterfaceToken("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                    this.mRemote.transact(4, var1, var2, 0);
                    var2.readException();
                    var3 = com.google.vr.vrcore.logging.api.IVrCoreLoggingService.Stub.asInterface(var2.readStrongBinder());
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }
        }
    }
}
