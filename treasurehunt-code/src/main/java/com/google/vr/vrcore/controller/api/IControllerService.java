//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.vrcore.controller.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.vr.vrcore.controller.api.IControllerListener;

public interface IControllerService extends IInterface {
    int initialize(int var1) throws RemoteException;

    boolean registerListener(int var1, String var2, IControllerListener var3) throws RemoteException;

    boolean unregisterListener(String var1) throws RemoteException;

    public abstract static class Stub extends Binder implements IControllerService {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.controller.api.IControllerService";
        static final int TRANSACTION_initialize = 1;
        static final int TRANSACTION_registerListener = 5;
        static final int TRANSACTION_unregisterListener = 6;

        public Stub() {
            this.attachInterface(this, "com.google.vr.vrcore.controller.api.IControllerService");
        }

        public static IControllerService asInterface(IBinder var0) {
            IInterface var1;
            return (IControllerService)(var0 == null?null:((var1 = var0.queryLocalInterface("com.google.vr.vrcore.controller.api.IControllerService")) != null && var1 instanceof IControllerService?(IControllerService)var1:new IControllerService.Stub.Proxy(var0)));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            int var9;
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.vr.vrcore.controller.api.IControllerService");
                    var9 = var2.readInt();
                    int var11 = this.initialize(var9);
                    var3.writeNoException();
                    var3.writeInt(var11);
                    return true;
                case 5:
                    var2.enforceInterface("com.google.vr.vrcore.controller.api.IControllerService");
                    var9 = var2.readInt();
                    String var10 = var2.readString();
                    IControllerListener var7 = com.google.vr.vrcore.controller.api.IControllerListener.Stub.asInterface(var2.readStrongBinder());
                    boolean var8 = this.registerListener(var9, var10, var7);
                    var3.writeNoException();
                    var3.writeInt(var8?1:0);
                    return true;
                case 6:
                    var2.enforceInterface("com.google.vr.vrcore.controller.api.IControllerService");
                    String var5 = var2.readString();
                    boolean var6 = this.unregisterListener(var5);
                    var3.writeNoException();
                    var3.writeInt(var6?1:0);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.vr.vrcore.controller.api.IControllerService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }

        private static class Proxy implements IControllerService {
            private IBinder mRemote;

            Proxy(IBinder var1) {
                this.mRemote = var1;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.google.vr.vrcore.controller.api.IControllerService";
            }

            public int initialize(int var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                int var4;
                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerService");
                    var2.writeInt(var1);
                    this.mRemote.transact(1, var2, var3, 0);
                    var3.readException();
                    var4 = var3.readInt();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

                return var4;
            }

            public boolean registerListener(int var1, String var2, IControllerListener var3) throws RemoteException {
                Parcel var4 = Parcel.obtain();
                Parcel var5 = Parcel.obtain();

                boolean var6;
                try {
                    var4.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerService");
                    var4.writeInt(var1);
                    var4.writeString(var2);
                    var4.writeStrongBinder(var3 != null?var3.asBinder():null);
                    this.mRemote.transact(5, var4, var5, 0);
                    var5.readException();
                    var6 = 0 != var5.readInt();
                } finally {
                    var5.recycle();
                    var4.recycle();
                }

                return var6;
            }

            public boolean unregisterListener(String var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                boolean var4;
                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerService");
                    var2.writeString(var1);
                    this.mRemote.transact(6, var2, var3, 0);
                    var3.readException();
                    var4 = 0 != var3.readInt();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

                return var4;
            }
        }
    }
}
