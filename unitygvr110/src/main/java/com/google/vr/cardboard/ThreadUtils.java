//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.vr.cardboard;

import android.os.Handler;
import android.os.Looper;

public class ThreadUtils {
    private static final Handler uiHandler = new Handler(Looper.getMainLooper());

    public ThreadUtils() {
    }

    public static void runOnUiThread(Runnable var0) {
        if(runningOnUiThread()) {
            var0.run();
        } else {
            uiHandler.post(var0);
        }
    }

    public static void postOnUiThread(Runnable var0) {
        uiHandler.post(var0);
    }

    public static boolean runningOnUiThread() {
        return uiHandler.getLooper() == Looper.myLooper();
    }

    public static void assertOnUiThread() {
    }

    public static void throwIfNotOnUiThread() {
        if(!runningOnUiThread()) {
            throw new IllegalStateException("Call was not made on the UI thread.");
        }
    }

    public static Handler getUiThreadHandler() {
        return uiHandler;
    }
}
