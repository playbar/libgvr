package com.google.hook;

/**
 * Created by houguoli on 2017/8/22.
 */

public class GVRHook {
    static {
        System.loadLibrary("gvrhook");
    }
    public static native void initHook();
    public static native void initGraphicHook();
    public static native void unInitHook();
    public static native void hookTest();
    public static native void ReprojFunc();
}
