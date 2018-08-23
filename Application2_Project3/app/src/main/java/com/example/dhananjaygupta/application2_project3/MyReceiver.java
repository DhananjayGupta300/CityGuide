package com.example.dhananjaygupta.application2_project3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;



//this class implements OnReceive() after receiving intent

public class MyReceiver extends BroadcastReceiver {
    private static final String INTENT_ATTRACTIONS = "com.example.dhananjaygupta.application1_project3.attractions";
    private static final String RESTAURANT_INTENT = "com.example.dhananjaygupta.application1_project3.resturants";

    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Intent i =null;

        //fOR ATTRACTION BUTTON IT OPENS UP THE ACTIVITY
        if ( arg1.getAction() == INTENT_ATTRACTIONS) {
            i = new Intent(arg0.getApplicationContext(),Attractions.class);
        }

        //iF RESTURANTS IS PRESSED THEN IT OPENS THAT
        else {
            i = new Intent(arg0.getApplicationContext(),Resturants.class);
        }
        arg0.startActivity(i);
        Toast.makeText(arg0, "ACTIVITY IS WORKING",
                Toast.LENGTH_LONG).show();
    }
}

