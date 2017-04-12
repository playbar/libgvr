package com.unity3d.player;

import android.util.Log;

/**
 * Created by houguoli on 2017/4/11.
 */

public class ShowFPS {
    static long prevTime = System.nanoTime() / 1000000;
    static long lastTime = 0;
    static int frameCounter = 0;
    static float maxFPS = 0;
    static float minFPS = 0;

    public static void showFPS()
    {
        long currentTime = System.nanoTime() / 1000000;
        float everyFPS = 1000.0f /(currentTime - lastTime);
        if( everyFPS > maxFPS )
        {
            maxFPS = everyFPS;
        }
        if( everyFPS < minFPS )
        {
            minFPS = everyFPS;
        }
        lastTime = currentTime;
        ++frameCounter;
        if( currentTime - prevTime > 10000 ){
            float elapsedSec = (float)(currentTime - prevTime) / 1000.0f;
            float currentFPS = (float)frameCounter / elapsedSec;
            Log.i("mjgvr", "render, FPS: " + currentFPS + ", maxFPS: " + maxFPS + ", minFPS: "+minFPS);
            minFPS = currentFPS;
            maxFPS = currentFPS;
            frameCounter = 0;
            prevTime = currentTime;
        }
    }
}
