package com.example.dhananjaygupta.application2_project3;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

class PortraitFragmentForResturants extends FragmentActivity {

    // Resturants give intent which is used to display the site
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            super.onBackPressed();
        }
        LandFragmentForResturants wwvvff = new LandFragmentForResturants();
        Intent i = this.getIntent();
        String link = i.getExtras().getString("link");
        wwvvff.init(link);
        getFragmentManager().beginTransaction().add(android.R.id.content, wwvvff).commit();
    }
}

