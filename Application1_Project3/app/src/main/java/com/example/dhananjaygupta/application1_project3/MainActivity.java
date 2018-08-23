//PACKAGE DECLARATION
package com.example.dhananjaygupta.application1_project3;

//IMPORTING THE REQUIRED CLASSES
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.content.Intent;
import android.content.pm.PackageManager;

//CODE FOR THE ONLY ACTIVITY OF THIS APP
public class MainActivity extends AppCompatActivity {
    //STRING FOR INTENT TO ATTRACTION ACTIVITY OF 2ND APP
    private static final String INTENT_ATTRACTIONS = "com.example.dhananjaygupta.application1_project3.attractions";
    //BUTTON 1 FOR ATTRACTIONS
    private Button Button1;
    //STRING FOR INTENT TO RESTAURENTS ACTIVITY OF 2ND APP
    private static final String INTENT_RESTAURENTS = "com.example.dhananjaygupta.application1_project3.resturants";
    //BUTTON 2 FOR RESTAURENTS
    private Button Button2;
    //STRING FOR INDICATING THE FOLDER
    private static final String PROJECT3 = "edu.uic.cs478.sp18.project3" ;

    //THIS IS CALLED UPON AT THE CREATION OF THE FIRST ACTIVITY//
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        //CALLING THE PARENT CLASS CONSTRUCTOR
        super.onCreate(savedInstanceState);
        //SETTING THE LAYOUT FILE FOR THIS CLASS USING THE "R' CLASS
        setContentView(R.layout.activity_main);
        //ASSIGNING BUTTON REFERENCES
        Button1 = (Button) findViewById(R.id.button1) ;
        //SET THE LISTENER TO THE BUTTON1 FOR CLICKS BY THE USER AND THEN DO THE APPROPRIATE ACTION
        Button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                permissionCheckToBroadcast1();
            }
        }) ;
        Button2 = (Button) findViewById(R.id.button2);
        //SET THE LISTENER TO THE BUTTON2 FOR CLICKS BY THE USER AND THEN DO THE APPROPRIATE ACTION
        Button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                permissionCheckToBroadcast2();
            }
        }) ;
    }

    private void permissionCheckToBroadcast2() {
        if (ContextCompat.checkSelfPermission(this, PROJECT3)== PackageManager.PERMISSION_GRANTED)
        {
            Intent aIntent = new Intent(INTENT_RESTAURENTS) ;
            sendBroadcast(aIntent, PROJECT3) ;
        }
        else {
            ActivityCompat.requestPermissions(this, new String[]{PROJECT3}, 0) ;
        }

    }
    private void permissionCheckToBroadcast1() {
        if (ContextCompat.checkSelfPermission(this, PROJECT3)== PackageManager.PERMISSION_GRANTED)
        {
            Intent aIntent = new Intent(INTENT_ATTRACTIONS) ;
            sendBroadcast(aIntent, PROJECT3) ;
        }
        else {
            ActivityCompat.requestPermissions(this, new String[]{PROJECT3}, 0) ;
        }

    }

    public void onRequestPermissionsResult(int code, String[] permissions, int[] results) {
        if (results.length > 0) {
            if (results[0] == PackageManager.PERMISSION_GRANTED) {
                permissionCheckToBroadcast1();
            }
            else {
                Toast.makeText(this, "Bummer: No permission", Toast.LENGTH_SHORT).show();

            }
        }
    }
}

