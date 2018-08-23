package com.example.dhananjaygupta.application2_project3;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class LandFragmentForAttractions extends Fragment {

    private String currentURL;

    public void init(String url) {
        currentURL = url;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //displaying options menu when using fragments
        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // layout gets inlflated and the website is opened in webview
        View v = inflater.inflate(R.layout.webpagelayout, container, false);
        WebView wv = (WebView) v.findViewById(R.id.webPage);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(currentURL);
        return v;
    }
}
