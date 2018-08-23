package com.example.dhananjaygupta.application2_project3;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


//Class for communication between fragments: The list of attractions and their site
public class Attractions extends AppCompatActivity implements ListFragmentForAttractions.ListSelectionListener {

    public static String[] myWebPages;
    public static String[] myAttractions;

    Fragment myAttractionFragment;
    FrameLayout myWebPageFragment;

// called on creation of the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controlling);

        //Assisgning data to the variables
        myAttractions = getResources().getStringArray(R.array.Attractions);
        myWebPages = getResources().getStringArray(R.array.WebPage);
    }

    // This method creates a options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.options,menu);
        return super.onCreateOptionsMenu(menu);
    }
    // setting the menu
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        menu.add(0,0,0,"Restaurant");
        return super.onPrepareOptionsMenu(menu);
    }

    // method to open the resturant activity on item selection from the menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(this, Resturants.class);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }

    //implementing the interface defned in attractions list
    @Override
    public void onListSelection(int index) {

        //when in landscape mode: fetches fragment and resize the layout of the two fragments
        if (findViewById(R.id.LandscapeWebPage) != null) {

            myWebPageFragment = (FrameLayout) findViewById(R.id.LandscapeWebPage);
            myAttractionFragment = getFragmentManager().findFragmentById(R.id.Fragment_List);
            myAttractionFragment.getView().setLayoutParams(new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT, 1f));
            myWebPageFragment.setLayoutParams(new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT, 2f));

            LandFragmentForAttractions atldfg = (LandFragmentForAttractions)
                    getFragmentManager().findFragmentById(R.id.LandscapeWebPage);


            atldfg = new LandFragmentForAttractions();
            atldfg.init(myWebPages[index]);

            //Fragment manager which will be required by the landscape mode
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.LandscapeWebPage, atldfg);
            ft.commit();

        }

        // fragment displayed as new activity in portrait mode
        else {
            Intent i = new Intent(this,PortraitFragmentForAttractions.class);
            i.putExtra("link",myWebPages[index]);
            startActivity(i);

        }
    }

    //state retention during rotation
    @Override
    public void onSaveInstanceState(Bundle outState) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(findViewById(R.id.LandscapeWebPage) != null) {
            if(fm.findFragmentById(R.id.LandscapeWebPage) != null) {
                ft.remove(fm.findFragmentById(R.id.LandscapeWebPage));
            }
            ft.commit();
        }
        if(outState !=null) {
            super.onSaveInstanceState(outState);
        }

    }
    // getting original orientation on pressing back soft key
    @Override
    public void onBackPressed()
    {
        myAttractionFragment.getView().setLayoutParams(new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 0));
    }
}

