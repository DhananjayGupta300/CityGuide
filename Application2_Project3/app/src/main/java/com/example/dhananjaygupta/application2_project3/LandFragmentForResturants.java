package com.example.dhananjaygupta.application2_project3;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;



public class LandFragmentForResturants extends Fragment {

    private String currentURL;

    public void init(String url) {
        currentURL = url;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //displaying options menu in fragments
        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //the layout is inflated and the website is displayed in webview

        View v = inflater.inflate(R.layout.resturantslayout_webpage, container, false);
        WebView wv = (WebView) v.findViewById(R.id.Resturant_Page);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(currentURL);
        return v;
    }
}

