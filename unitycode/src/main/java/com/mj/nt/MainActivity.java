/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mj.nt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.unity3d.player.UnityPlayer;

import java.io.File;
import com.google.vr.cardboard.ConfigUtils;

public class MainActivity extends Activity {

    int count = 0;
    int hour = 0;
    int minute = 0;
    int second = 0;
    TextView tickView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String strPath = getSDPath();
        Log.e("MainActivity", strPath);

        tickView = (TextView) findViewById(R.id.tickView);
    }

    public void Btn1_Click(View view)
    {
        String str = "---->" + count;
//        str = stringFromJNI();
        tickView.setText(str);
        startActivity(new Intent(MainActivity.this, UnityPlayerActivity.class));
        count++;
    }

    public String getSDPath(){
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED);//判断sd卡是否存在
        if(sdCardExist)
        {
            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        }
        return sdDir.toString();
    }

    @Override
    public void onResume() {
        super.onResume();
        hour = minute = second = 0;
//        ((TextView)findViewById(R.id.hellojniMsg)).setText(stringFromJNI());
    }

    @Override
    public void onPause () {
        super.onPause();
    }

//    static
//    {
////        System.loadLibrary("gvrimpl");
//        System.loadLibrary("gvr");
//    }

    static {
//        (new CExceptionHandler()).isSameExceptionHandler();
        System.loadLibrary("gvr");
        System.loadLibrary("mono");
        System.loadLibrary("unity");
        UnityPlayer.m = false;
        UnityPlayer.m = UnityPlayer.loadLibraryStatic("main");
    }

//    public native  String stringFromJNI();
}
