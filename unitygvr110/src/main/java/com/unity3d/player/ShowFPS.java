package com.unity3d.player;

import android.util.Log;

import java.text.DecimalFormat;

/**
 * Created by houguoli on 2017/4/11.
 */

public class ShowFPS {
    static long prevTime = System.nanoTime();
    static long lastTime = System.nanoTime();
    static int frameCounter = 0;
    static float maxIntervalTime = 0;
    static float minIntervalTime = 0;

    public static void showFPS()
    {
        long currentTime = System.nanoTime();
        float everyIntervalTime = (currentTime - lastTime)/1000000;
        if( everyIntervalTime > maxIntervalTime)
        {
            maxIntervalTime = everyIntervalTime;
        }
        if( everyIntervalTime < minIntervalTime)
        {
            minIntervalTime = everyIntervalTime;
        }
        lastTime = currentTime;
        ++frameCounter;
        float totalTime = (currentTime - prevTime) / 1000000;
        if( totalTime > 10000 ){
            float elapsedSec = (float)totalTime / 1000.0f;
            float currentFPS = (float)frameCounter / elapsedSec;
            //------ MJDD ---MojingTest--- AvgFPS = %3.2f , Frame = [%3.2f , %3.2f] (ms)
            DecimalFormat decimalFormat=new DecimalFormat("000.00");
            String strCurFPS = decimalFormat.format(currentFPS);
            String strMin = decimalFormat.format(minIntervalTime);
            String strMax = decimalFormat.format(maxIntervalTime);
            Log.i("MJDD", "---MojingTest--- AvgFPS = " + strCurFPS + ", Frame = [" + strMin + ",  "+ strMax + "] (ms)");
            minIntervalTime = currentFPS;
            maxIntervalTime = currentFPS;
            frameCounter = 0;
            prevTime = currentTime;
        }
    }
}
