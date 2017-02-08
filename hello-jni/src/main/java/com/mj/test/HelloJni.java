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
package com.mj.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelloJni extends Activity {

    private Button button;
    private TextView textView;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button1);
        textView = (TextView)findViewById(R.id.textview);
        textView.setText(stringFromJNI());
    }

    public native String  stringFromJNI();

    public void Btn1_Click(View view)
    {
        String str = "---->" + count;
        str = stringFromJNI();
        str += count;
        textView.setText(str);
        count++;
    }

    public native String  unimplementedStringFromJNI();
    static {
        System.loadLibrary("mjtest");
    }
}
