package com.mj.vr;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.Log;

import com.google.hook.GLESHook;
import com.google.hook.GVRHook;

public class App extends Application {

	static {
        System.loadLibrary("gvr");
        System.loadLibrary("gvr_audio");
        System.loadLibrary("draw");
		System.loadLibrary("glhook");
		System.loadLibrary("gvrhook");
	}

	private String textData = "default";
	private String TAG = "Application";

	public void setTextData(String textData) {
		this.textData = textData;
	}

	public String getTextData() {
		return textData;
	}

	@Override
	public void onCreate() {
		// 程序创建的时候执行
		Log.d(TAG, "onCreate");
		super.onCreate();
		GLESHook.initHook();
		GVRHook.initHook();
	}
	@Override
	public void onTerminate() {
		// 程序终止的时候执行
		Log.d(TAG, "onTerminate");
		super.onTerminate();
	}
	@Override
	public void onLowMemory() {
		// 低内存的时候执行
		Log.d(TAG, "onLowMemory");
		super.onLowMemory();
	}
	@Override
	public void onTrimMemory(int level) {
		// 程序在内存清理的时候执行
		Log.d(TAG, "onTrimMemory");
		super.onTrimMemory(level);
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		Log.d(TAG, "onConfigurationChanged");
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void registerActivityLifecycleCallbacks(
			ActivityLifecycleCallbacks callback) {
		Log.d(TAG, "registerActivityLifecycleCallbacks");
		super.registerActivityLifecycleCallbacks(callback);
	}

	@Override
	public void registerComponentCallbacks(ComponentCallbacks callback) {
		Log.d(TAG, "registerComponentCallbacks");
		super.registerComponentCallbacks(callback);
	}

	@Override
	public void unregisterActivityLifecycleCallbacks(
			ActivityLifecycleCallbacks callback) {
		Log.d(TAG, "unregisterActivityLifecycleCallbacks");
		super.unregisterActivityLifecycleCallbacks(callback);
	}

	@Override
	public void unregisterComponentCallbacks(ComponentCallbacks callback) {
		Log.d(TAG, "unregisterComponentCallbacks");
		super.unregisterComponentCallbacks(callback);
	}

}
