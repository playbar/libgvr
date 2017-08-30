package com.mj.vr;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.*;

import com.google.vr.sdk.base.CardboardViewNativeImpl;
import com.google.vr.cardboard.MutableEglConfigChooser;
import com.google.vr.cardboard.VrParamsProviderJni;
import com.mj.vr.my.R;

import java.util.ArrayList;
import java.util.List;

public class MainLanch extends Activity {

    Button button;
    TextView textView;
    int count = 0;

    private boolean addPermission(List<String> permissionsList, String permission)
    {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED)
        {
            permissionsList.add(permission);

            // Check for Rationale Option
            if (!shouldShowRequestPermissionRationale(permission))
                return false;
        }

        return true;
    }

    public void checkRuntimePermissionsRunnable()
    {
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            // Android 6.0+ needs runtime permission checks
            List<String> permissionsNeeded = new ArrayList<String>();
            final List<String> permissionsList = new ArrayList<String>();

            if (!addPermission(permissionsList, Manifest.permission.READ_EXTERNAL_STORAGE))
                permissionsNeeded.add("Read External Storage");
            if (!addPermission(permissionsList, Manifest.permission.WRITE_EXTERNAL_STORAGE))
                permissionsNeeded.add("Write External Storage");

            if (permissionsList.size() > 0)
            {
                requestPermissions(permissionsList.toArray(new String[permissionsList.size()]), 124);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkRuntimePermissionsRunnable();
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button1);
//        int i = TreasureActivityJNI.cout;
        textView = (TextView)findViewById(R.id.textView1);
    }

//    static {
//        System.loadLibrary("gvr");
//        System.loadLibrary("gvr_audio");
//        System.loadLibrary("gvr_t");
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    public void Btn1_Click(View view)
    {
        String str = "---->" + count;
//        str = stringFromJNI();
        textView.setText(str);
        startActivity(new Intent(MainLanch.this, MainActivity.class));
        count++;
    }

}
