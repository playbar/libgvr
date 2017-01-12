//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.vrcore.common.api;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.vr.vrcore.common.api.HeadTrackingState;
import com.google.vr.vrcore.common.api.IDaydreamListener;
import com.google.vr.vrcore.common.api.ITransitionCallbacks;

public interface IDaydreamManager extends IInterface {
    boolean registerListener(ComponentName var1, IDaydreamListener var2) throws RemoteException;

    boolean unregisterListener(ComponentName var1) throws RemoteException;

    int prepareVr(ComponentName var1, HeadTrackingState var2) throws RemoteException;

    boolean deprecatedLaunchInVr(PendingIntent var1) throws RemoteException;

    void registerDaydreamIntent(PendingIntent var1) throws RemoteException;

    void unregisterDaydreamIntent() throws RemoteException;

    boolean launchInVr(PendingIntent var1, ComponentName var2) throws RemoteException;

    boolean launchVrHome() throws RemoteException;

    boolean launchVrTransition(ITransitionCallbacks var1) throws RemoteException;

    boolean exitFromVr(PendingIntent var1) throws RemoteException;

    void handleInsertionIntoHeadset(byte[] var1) throws RemoteException;

    void handleRemovalFromHeadset() throws RemoteException;

    public abstract static class Stub extends Binder implements IDaydreamManager {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.IDaydreamManager";
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_unregisterListener = 2;
        static final int TRANSACTION_prepareVr = 3;
        static final int TRANSACTION_deprecatedLaunchInVr = 4;
        static final int TRANSACTION_registerDaydreamIntent = 5;
        static final int TRANSACTION_unregisterDaydreamIntent = 6;
        static final int TRANSACTION_launchInVr = 7;
        static final int TRANSACTION_launchVrHome = 8;
        static final int TRANSACTION_launchVrTransition = 9;
        static final int TRANSACTION_exitFromVr = 10;
        static final int TRANSACTION_handleInsertionIntoHeadset = 11;
        static final int TRANSACTION_handleRemovalFromHeadset = 12;

        public Stub() {
            this.attachInterface(this, "com.google.vr.vrcore.common.api.IDaydreamManager");
        }

        public static IDaydreamManager asInterface(IBinder var0) {
            IInterface var1;
            return (IDaydreamManager)(var0 == null?null:((var1 = var0.queryLocalInterface("com.google.vr.vrcore.common.api.IDaydreamManager")) != null && var1 instanceof IDaydreamManager?(IDaydreamManager)var1:new IDaydreamManager.Stub.Proxy(var0)));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            boolean var6;
            boolean var7;
            PendingIntent var8;
            ComponentName var15;
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
                    if(0 != var2.readInt()) {
                        var15 = (ComponentName)ComponentName.CREATOR.createFromParcel(var2);
                    } else {
                        var15 = null;
                    }

                    IDaydreamListener var14 = com.google.vr.vrcore.common.api.IDaydreamListener.Stub.asInterface(var2.readStrongBinder());
                    var7 = this.registerListener(var15, var14);
                    var3.writeNoException();
                    var3.writeInt(var7?1:0);
                    return true;
                case 2:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
                    if(0 != var2.readInt()) {
                        var15 = (ComponentName)ComponentName.CREATOR.createFromParcel(var2);
                    } else {
                        var15 = null;
                    }

                    var6 = this.unregisterListener(var15);
                    var3.writeNoException();
                    var3.writeInt(var6?1:0);
                    return true;
                case 3:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
                    if(0 != var2.readInt()) {
                        var15 = (ComponentName)ComponentName.CREATOR.createFromParcel(var2);
                    } else {
                        var15 = null;
                    }

                    HeadTrackingState var13 = new HeadTrackingState();
                    int var12 = this.prepareVr(var15, var13);
                    var3.writeNoException();
                    var3.writeInt(var12);
                    var3.writeInt(1);
                    var13.writeToParcel(var3, 1);
                    return true;
                case 4:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
                    if(0 != var2.readInt()) {
                        var8 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                    } else {
                        var8 = null;
                    }

                    var6 = this.deprecatedLaunchInVr(var8);
                    var3.writeNoException();
                    var3.writeInt(var6?1:0);
                    return true;
                case 5:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
                    if(0 != var2.readInt()) {
                        var8 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                    } else {
                        var8 = null;
                    }

                    this.registerDaydreamIntent(var8);
                    return true;
                case 6:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
                    this.unregisterDaydreamIntent();
                    return true;
                case 7:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
                    if(0 != var2.readInt()) {
                        var8 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                    } else {
                        var8 = null;
                    }

                    ComponentName var11;
                    if(0 != var2.readInt()) {
                        var11 = (ComponentName)ComponentName.CREATOR.createFromParcel(var2);
                    } else {
                        var11 = null;
                    }

                    var7 = this.launchInVr(var8, var11);
                    var3.writeNoException();
                    var3.writeInt(var7?1:0);
                    return true;
                case 8:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
                    boolean var10 = this.launchVrHome();
                    var3.writeNoException();
                    var3.writeInt(var10?1:0);
                    return true;
                case 9:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
                    ITransitionCallbacks var9 = com.google.vr.vrcore.common.api.ITransitionCallbacks.Stub.asInterface(var2.readStrongBinder());
                    var6 = this.launchVrTransition(var9);
                    var3.writeNoException();
                    var3.writeInt(var6?1:0);
                    return true;
                case 10:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
                    if(0 != var2.readInt()) {
                        var8 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                    } else {
                        var8 = null;
                    }

                    var6 = this.exitFromVr(var8);
                    var3.writeNoException();
                    var3.writeInt(var6?1:0);
                    return true;
                case 11:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
                    byte[] var5 = var2.createByteArray();
                    this.handleInsertionIntoHeadset(var5);
                    return true;
                case 12:
                    var2.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
                    this.handleRemovalFromHeadset();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.vr.vrcore.common.api.IDaydreamManager");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }

        private static class Proxy implements IDaydreamManager {
            private IBinder mRemote;

            Proxy(IBinder var1) {
                this.mRemote = var1;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.google.vr.vrcore.common.api.IDaydreamManager";
            }

            public boolean registerListener(ComponentName var1, IDaydreamListener var2) throws RemoteException {
                Parcel var3 = Parcel.obtain();
                Parcel var4 = Parcel.obtain();

                boolean var5;
                try {
                    var3.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
                    if(var1 != null) {
                        var3.writeInt(1);
                        var1.writeToParcel(var3, 0);
                    } else {
                        var3.writeInt(0);
                    }

                    var3.writeStrongBinder(var2 != null?var2.asBinder():null);
                    this.mRemote.transact(1, var3, var4, 0);
                    var4.readException();
                    var5 = 0 != var4.readInt();
                } finally {
                    var4.recycle();
                    var3.recycle();
                }

                return var5;
            }

            public boolean unregisterListener(ComponentName var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                boolean var4;
                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
                    if(var1 != null) {
                        var2.writeInt(1);
                        var1.writeToParcel(var2, 0);
                    } else {
                        var2.writeInt(0);
                    }

                    this.mRemote.transact(2, var2, var3, 0);
                    var3.readException();
                    var4 = 0 != var3.readInt();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

                return var4;
            }

            public int prepareVr(ComponentName var1, HeadTrackingState var2) throws RemoteException {
                Parcel var3 = Parcel.obtain();
                Parcel var4 = Parcel.obtain();

                int var5;
                try {
                    var3.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
                    if(var1 != null) {
                        var3.writeInt(1);
                        var1.writeToParcel(var3, 0);
                    } else {
                        var3.writeInt(0);
                    }

                    this.mRemote.transact(3, var3, var4, 0);
                    var4.readException();
                    var5 = var4.readInt();
                    if(0 != var4.readInt()) {
                        var2.readFromParcel(var4);
                    }
                } finally {
                    var4.recycle();
                    var3.recycle();
                }

                return var5;
            }

            public boolean deprecatedLaunchInVr(PendingIntent var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                boolean var4;
                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
                    if(var1 != null) {
                        var2.writeInt(1);
                        var1.writeToParcel(var2, 0);
                    } else {
                        var2.writeInt(0);
                    }

                    this.mRemote.transact(4, var2, var3, 0);
                    var3.readException();
                    var4 = 0 != var3.readInt();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

                return var4;
            }

            public void registerDaydreamIntent(PendingIntent var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
                    if(var1 != null) {
                        var2.writeInt(1);
                        var1.writeToParcel(var2, 0);
                    } else {
                        var2.writeInt(0);
                    }

                    this.mRemote.transact(5, var2, (Parcel)null, 1);
                } finally {
                    var2.recycle();
                }

            }

            public void unregisterDaydreamIntent() throws RemoteException {
                Parcel var1 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
                    this.mRemote.transact(6, var1, (Parcel)null, 1);
                } finally {
                    var1.recycle();
                }

            }

            public boolean launchInVr(PendingIntent var1, ComponentName var2) throws RemoteException {
                Parcel var3 = Parcel.obtain();
                Parcel var4 = Parcel.obtain();

                boolean var5;
                try {
                    var3.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
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

                    this.mRemote.transact(7, var3, var4, 0);
                    var4.readException();
                    var5 = 0 != var4.readInt();
                } finally {
                    var4.recycle();
                    var3.recycle();
                }

                return var5;
            }

            public boolean launchVrHome() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                boolean var3;
                try {
                    var1.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
                    this.mRemote.transact(8, var1, var2, 0);
                    var2.readException();
                    var3 = 0 != var2.readInt();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }

            public boolean launchVrTransition(ITransitionCallbacks var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                boolean var4;
                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
                    var2.writeStrongBinder(var1 != null?var1.asBinder():null);
                    this.mRemote.transact(9, var2, var3, 0);
                    var3.readException();
                    var4 = 0 != var3.readInt();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

                return var4;
            }

            public boolean exitFromVr(PendingIntent var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                boolean var4;
                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
                    if(var1 != null) {
                        var2.writeInt(1);
                        var1.writeToParcel(var2, 0);
                    } else {
                        var2.writeInt(0);
                    }

                    this.mRemote.transact(10, var2, var3, 0);
                    var3.readException();
                    var4 = 0 != var3.readInt();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

                return var4;
            }

            public void handleInsertionIntoHeadset(byte[] var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
                    var2.writeByteArray(var1);
                    this.mRemote.transact(11, var2, (Parcel)null, 1);
                } finally {
                    var2.recycle();
                }

            }

            public void handleRemovalFromHeadset() throws RemoteException {
                Parcel var1 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
                    this.mRemote.transact(12, var1, (Parcel)null, 1);
                } finally {
                    var1.recycle();
                }

            }
        }
    }
}
