package com.example.dhananjaygupta.application2_project3;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.content.res.Configuration;


public class PortraitFragmentForAttractions extends FragmentActivity {

    //GETTING THE INTENT FORM THE ATTRACTIONS ACTIVITY AND OPENING THE SITE

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            super.onBackPressed();
        }
        LandFragmentForAttractions wwvvff = new LandFragmentForAttractions();
        Intent intent = this.getIntent();
        String link = intent.getExtras().getString("link");
        wwvvff.init(link);
        getFragmentManager().beginTransaction().add(android.R.id.content, wwvvff).commit();
    }
}
