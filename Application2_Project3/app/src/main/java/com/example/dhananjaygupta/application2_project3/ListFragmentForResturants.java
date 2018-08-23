package com.example.dhananjaygupta.application2_project3;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.app.ListFragment;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;



public class ListFragmentForResturants extends ListFragment {

    private ListSelectionListener myListener = null;
    private int myIndex = -1;

    public interface ListSelectionListener {
        public void onListSelection(int index);
    }

    // Called upon item selaction form the list
    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {

        // indicating selcted items checked
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

            // Set the ListSelectionListener for communicating with the Restaurant Activity
            myListener = (ListSelectionListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()+ " Does not implements OnArticleSelectedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        //Displaying options menu with fragments
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //selects only one item at a time
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        setListAdapter(new ArrayAdapter<String>(getActivity(),R.layout.resturantslayout,
                Resturants.myRestaurant));

        //while rotation from potrait to landscape retains the state
        if(myIndex != -1){
            getListView().setItemChecked(myIndex,true);
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                myListener.onListSelection(myIndex);
        }
    }

    //other life cycle methods of fragments
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
