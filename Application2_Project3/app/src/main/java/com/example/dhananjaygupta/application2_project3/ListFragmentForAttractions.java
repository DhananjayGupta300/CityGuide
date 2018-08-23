package com.example.dhananjaygupta.application2_project3;

import android.app.ListFragment;
import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;





public class ListFragmentForAttractions extends ListFragment {

    private ListSelectionListener myListener = null;
    private int myIndex = -1;

    public interface ListSelectionListener {
        public void onListSelection(int index);
    }
    //called upon user selecting item form the list
    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {

        // Indicates the selected item has been checked
        if(myIndex != pos){
            myIndex =pos;
            myListener.onListSelection(pos);
        }
        getListView().setItemChecked(pos, true);

    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {

            // Set the ListSelectionListener for communicating with the Attraction Activity
            myListener = (ListSelectionListener) activity;

        } catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+ " Does not implement OnListItemClick");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //For retention
        setRetainInstance(true);

        //For displaying options menu with fragments
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        //selects only one item at a time
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        setListAdapter(new ArrayAdapter<String>(getActivity(),R.layout.attractionslayout,
                Attractions.myAttractions));

        //while rotation from potrait to landscape retains the state
        if(myIndex != -1)
        {
            getListView().setItemChecked(myIndex,true);
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                myListener.onListSelection(myIndex);
        }
    }

    //Various other fragment lifecycle methods
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
