package com.example.dhananjaygupta.application2_project3;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

public class ControllingActivity extends Activity
{
    // private Button mButton ;
    private static final String INTENT_ATTRACTIONS = "com.example.dhananjaygupta.application1_project3.attractions";
    private static final String INTENT_RESTAURANTS = "com.example.dhananjaygupta.application1_project3.resturants";

    BroadcastReceiver myReceiver = new MyReceiver() ;
    IntentFilter myFilter = new IntentFilter(INTENT_ATTRACTIONS) ;
    IntentFilter myFilter1 = new IntentFilter(INTENT_RESTAURANTS) ;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myFilter.setPriority(100);
        registerReceiver(myReceiver, myFilter);
        registerReceiver(myReceiver,myFilter1);
    }

    public void onResume() {
        super.onResume()  ;
        if (ContextCompat.checkSelfPermission(this, "edu.uic.cs478.sp18.project3") !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{"edu.uic.cs478.sp18.project3"}, 0);
        }
    }

    public void onRequestPermissionsResult(int code, String[] permissions, int[] grantResults) {

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // this means the Permission is granted and so we move ahead
            onResume();
        }
        else {
            Toast.makeText(this, "BUMMER: You Do not have permission No Permission", Toast.LENGTH_LONG).show() ;
        }
    }
}
