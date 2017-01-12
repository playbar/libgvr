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
import com.google.vr.vrcore.controller.api.ControllerAccelEvent;
import com.google.vr.vrcore.controller.api.ControllerButtonEvent;
import com.google.vr.vrcore.controller.api.ControllerEventPacket;
import com.google.vr.vrcore.controller.api.ControllerEventPacket2;
import com.google.vr.vrcore.controller.api.ControllerGyroEvent;
import com.google.vr.vrcore.controller.api.ControllerListenerOptions;
import com.google.vr.vrcore.controller.api.ControllerOrientationEvent;
import com.google.vr.vrcore.controller.api.ControllerTouchEvent;

public interface IControllerListener extends IInterface {
    int getApiVersion() throws RemoteException;

    void onControllerStateChanged(int var1, int var2) throws RemoteException;

    void deprecatedOnControllerTouchEvent(ControllerTouchEvent var1) throws RemoteException;

    void deprecatedOnControllerOrientationEvent(ControllerOrientationEvent var1) throws RemoteException;

    boolean deprecatedOnControllerButtonEventV1(ControllerButtonEvent var1) throws RemoteException;

    void deprecatedOnControllerButtonEvent(ControllerButtonEvent var1) throws RemoteException;

    void deprecatedOnControllerAccelEvent(ControllerAccelEvent var1) throws RemoteException;

    void deprecatedOnControllerGyroEvent(ControllerGyroEvent var1) throws RemoteException;

    ControllerListenerOptions getOptions() throws RemoteException;

    void onControllerEventPacket(ControllerEventPacket var1) throws RemoteException;

    void onControllerRecentered(ControllerOrientationEvent var1) throws RemoteException;

    void onControllerEventPacket2(ControllerEventPacket2 var1) throws RemoteException;

    public abstract static class Stub extends Binder implements IControllerListener {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.controller.api.IControllerListener";
        static final int TRANSACTION_getApiVersion = 1;
        static final int TRANSACTION_onControllerStateChanged = 2;
        static final int TRANSACTION_deprecatedOnControllerTouchEvent = 3;
        static final int TRANSACTION_deprecatedOnControllerOrientationEvent = 4;
        static final int TRANSACTION_deprecatedOnControllerButtonEventV1 = 5;
        static final int TRANSACTION_deprecatedOnControllerButtonEvent = 6;
        static final int TRANSACTION_deprecatedOnControllerAccelEvent = 7;
        static final int TRANSACTION_deprecatedOnControllerGyroEvent = 8;
        static final int TRANSACTION_getOptions = 9;
        static final int TRANSACTION_onControllerEventPacket = 10;
        static final int TRANSACTION_onControllerRecentered = 11;
        static final int TRANSACTION_onControllerEventPacket2 = 12;

        public Stub() {
            this.attachInterface(this, "com.google.vr.vrcore.controller.api.IControllerListener");
        }

        public static IControllerListener asInterface(IBinder var0) {
            IInterface var1;
            return (IControllerListener)(var0 == null?null:((var1 = var0.queryLocalInterface("com.google.vr.vrcore.controller.api.IControllerListener")) != null && var1 instanceof IControllerListener?(IControllerListener)var1:new IControllerListener.Stub.Proxy(var0)));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            ControllerOrientationEvent var7;
            ControllerButtonEvent var13;
            int var15;
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                    var15 = this.getApiVersion();
                    var3.writeNoException();
                    var3.writeInt(var15);
                    return true;
                case 2:
                    var2.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                    var15 = var2.readInt();
                    int var8 = var2.readInt();
                    this.onControllerStateChanged(var15, var8);
                    return true;
                case 3:
                    var2.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                    ControllerTouchEvent var14;
                    if(0 != var2.readInt()) {
                        var14 = (ControllerTouchEvent)ControllerTouchEvent.CREATOR.createFromParcel(var2);
                    } else {
                        var14 = null;
                    }

                    this.deprecatedOnControllerTouchEvent(var14);
                    return true;
                case 4:
                    var2.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                    if(0 != var2.readInt()) {
                        var7 = (ControllerOrientationEvent)ControllerOrientationEvent.CREATOR.createFromParcel(var2);
                    } else {
                        var7 = null;
                    }

                    this.deprecatedOnControllerOrientationEvent(var7);
                    return true;
                case 5:
                    var2.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                    if(0 != var2.readInt()) {
                        var13 = (ControllerButtonEvent)ControllerButtonEvent.CREATOR.createFromParcel(var2);
                    } else {
                        var13 = null;
                    }

                    boolean var6 = this.deprecatedOnControllerButtonEventV1(var13);
                    var3.writeNoException();
                    var3.writeInt(var6?1:0);
                    return true;
                case 6:
                    var2.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                    if(0 != var2.readInt()) {
                        var13 = (ControllerButtonEvent)ControllerButtonEvent.CREATOR.createFromParcel(var2);
                    } else {
                        var13 = null;
                    }

                    this.deprecatedOnControllerButtonEvent(var13);
                    return true;
                case 7:
                    var2.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                    ControllerAccelEvent var12;
                    if(0 != var2.readInt()) {
                        var12 = (ControllerAccelEvent)ControllerAccelEvent.CREATOR.createFromParcel(var2);
                    } else {
                        var12 = null;
                    }

                    this.deprecatedOnControllerAccelEvent(var12);
                    return true;
                case 8:
                    var2.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                    ControllerGyroEvent var11;
                    if(0 != var2.readInt()) {
                        var11 = (ControllerGyroEvent)ControllerGyroEvent.CREATOR.createFromParcel(var2);
                    } else {
                        var11 = null;
                    }

                    this.deprecatedOnControllerGyroEvent(var11);
                    return true;
                case 9:
                    var2.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                    ControllerListenerOptions var10 = this.getOptions();
                    var3.writeNoException();
                    if(var10 != null) {
                        var3.writeInt(1);
                        var10.writeToParcel(var3, 1);
                    } else {
                        var3.writeInt(0);
                    }

                    return true;
                case 10:
                    var2.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                    ControllerEventPacket var9;
                    if(0 != var2.readInt()) {
                        var9 = (ControllerEventPacket)ControllerEventPacket.CREATOR.createFromParcel(var2);
                    } else {
                        var9 = null;
                    }

                    this.onControllerEventPacket(var9);
                    return true;
                case 11:
                    var2.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                    if(0 != var2.readInt()) {
                        var7 = (ControllerOrientationEvent)ControllerOrientationEvent.CREATOR.createFromParcel(var2);
                    } else {
                        var7 = null;
                    }

                    this.onControllerRecentered(var7);
                    return true;
                case 12:
                    var2.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                    ControllerEventPacket2 var5;
                    if(0 != var2.readInt()) {
                        var5 = (ControllerEventPacket2)ControllerEventPacket2.CREATOR.createFromParcel(var2);
                    } else {
                        var5 = null;
                    }

                    this.onControllerEventPacket2(var5);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.vr.vrcore.controller.api.IControllerListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }

        private static class Proxy implements IControllerListener {
            private IBinder mRemote;

            Proxy(IBinder var1) {
                this.mRemote = var1;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.google.vr.vrcore.controller.api.IControllerListener";
            }

            public int getApiVersion() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                int var3;
                try {
                    var1.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                    this.mRemote.transact(1, var1, var2, 0);
                    var2.readException();
                    var3 = var2.readInt();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }

            public void onControllerStateChanged(int var1, int var2) throws RemoteException {
                Parcel var3 = Parcel.obtain();

                try {
                    var3.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                    var3.writeInt(var1);
                    var3.writeInt(var2);
                    this.mRemote.transact(2, var3, (Parcel)null, 1);
                } finally {
                    var3.recycle();
                }

            }

            public void deprecatedOnControllerTouchEvent(ControllerTouchEvent var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                    if(var1 != null) {
                        var2.writeInt(1);
                        var1.writeToParcel(var2, 0);
                    } else {
                        var2.writeInt(0);
                    }

                    this.mRemote.transact(3, var2, (Parcel)null, 1);
                } finally {
                    var2.recycle();
                }

            }

            public void deprecatedOnControllerOrientationEvent(ControllerOrientationEvent var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                    if(var1 != null) {
                        var2.writeInt(1);
                        var1.writeToParcel(var2, 0);
                    } else {
                        var2.writeInt(0);
                    }

                    this.mRemote.transact(4, var2, (Parcel)null, 1);
                } finally {
                    var2.recycle();
                }

            }

            public boolean deprecatedOnControllerButtonEventV1(ControllerButtonEvent var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                boolean var4;
                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                    if(var1 != null) {
                        var2.writeInt(1);
                        var1.writeToParcel(var2, 0);
                    } else {
                        var2.writeInt(0);
                    }

                    this.mRemote.transact(5, var2, var3, 0);
                    var3.readException();
                    var4 = 0 != var3.readInt();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

                return var4;
            }

            public void deprecatedOnControllerButtonEvent(ControllerButtonEvent var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
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

            public void deprecatedOnControllerAccelEvent(ControllerAccelEvent var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                    if(var1 != null) {
                        var2.writeInt(1);
                        var1.writeToParcel(var2, 0);
                    } else {
                        var2.writeInt(0);
                    }

                    this.mRemote.transact(7, var2, (Parcel)null, 1);
                } finally {
                    var2.recycle();
                }

            }

            public void deprecatedOnControllerGyroEvent(ControllerGyroEvent var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                    if(var1 != null) {
                        var2.writeInt(1);
                        var1.writeToParcel(var2, 0);
                    } else {
                        var2.writeInt(0);
                    }

                    this.mRemote.transact(8, var2, (Parcel)null, 1);
                } finally {
                    var2.recycle();
                }

            }

            public ControllerListenerOptions getOptions() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                ControllerListenerOptions var3;
                try {
                    var1.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                    this.mRemote.transact(9, var1, var2, 0);
                    var2.readException();
                    if(0 != var2.readInt()) {
                        var3 = (ControllerListenerOptions)ControllerListenerOptions.CREATOR.createFromParcel(var2);
                    } else {
                        var3 = null;
                    }
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }

            public void onControllerEventPacket(ControllerEventPacket var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                    if(var1 != null) {
                        var2.writeInt(1);
                        var1.writeToParcel(var2, 0);
                    } else {
                        var2.writeInt(0);
                    }

                    this.mRemote.transact(10, var2, (Parcel)null, 1);
                } finally {
                    var2.recycle();
                }

            }

            public void onControllerRecentered(ControllerOrientationEvent var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                    if(var1 != null) {
                        var2.writeInt(1);
                        var1.writeToParcel(var2, 0);
                    } else {
                        var2.writeInt(0);
                    }

                    this.mRemote.transact(11, var2, (Parcel)null, 1);
                } finally {
                    var2.recycle();
                }

            }

            public void onControllerEventPacket2(ControllerEventPacket2 var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                    if(var1 != null) {
                        var2.writeInt(1);
                        var1.writeToParcel(var2, 0);
                    } else {
                        var2.writeInt(0);
                    }

                    this.mRemote.transact(12, var2, (Parcel)null, 1);
                } finally {
                    var2.recycle();
                }

            }
        }
    }
}
