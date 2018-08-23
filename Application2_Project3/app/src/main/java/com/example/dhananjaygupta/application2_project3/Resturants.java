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

//this class is for communication between two fragments(List displaying name of restauarants and their official site)
public class Resturants extends AppCompatActivity implements ListFragmentForResturants.ListSelectionListener {

    public static String[] myRestaurant;
    Fragment myRestaurantFragment;
    public static String[] myRestaurantPages;
    FrameLayout myRestaurantPageFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturants);

        //Assisgning data to the variables
        myRestaurant = getResources().getStringArray(R.array.Restaurant);
        myRestaurantPages = getResources().getStringArray(R.array.RestaurantWebPage);

    }

    //method to create options menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.options,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        menu.add(0,0,0,"Attraction");
        return super.onPrepareOptionsMenu(menu);
    }


    // this method opens Attraction Activity when menu item is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(this, Attractions.class);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }

    //interface method implementation that was defined in Attraction List
    @Override
    public void onListSelection(int index) {

        //when device is in landscape mode, it gets fragment and resize the layout of the two fragments
        if (findViewById(R.id.RestaurantWebPage) != null) {
            myRestaurantPageFragment = (FrameLayout) findViewById(R.id.RestaurantWebPage);
            myRestaurantFragment = getFragmentManager().findFragmentById(R.id.ListFragmentForResturants);
            myRestaurantFragment.getView().setLayoutParams(new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT, 1f));
            myRestaurantPageFragment.setLayoutParams(new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT, 2f));
            LandFragmentForResturants alf = (LandFragmentForResturants)
                    getFragmentManager().findFragmentById(R.id.RestaurantWebPage);


            alf = new LandFragmentForResturants();
            alf.init(myRestaurantPages[index]);

            //Fragment manager needed in landscape mode
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.RestaurantWebPage, alf);
            ft.commit();
        }

        // if in potrait mode display fragment as  new activity
        else {
            Intent i = new Intent(this,PortraitFragmentForResturants.class);
            i.putExtra("link",myRestaurantPages[index]);
            startActivity(i);
        }
    }

    //to retain state while rotation
    @Override
    public void onSaveInstanceState(Bundle outState) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(findViewById(R.id.RestaurantWebPage) != null) {
            if(fm.findFragmentById(R.id.RestaurantWebPage) != null) {
                ft.remove(fm.findFragmentById(R.id.RestaurantWebPage));
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
        myRestaurantFragment.getView().setLayoutParams(new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 0));
    }
}



