package com.example.root.villupuramglug.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.root.villupuramglug.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GlugsFragment extends Fragment {

    public WebView mWebView;

    public GlugsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tutorials, container, false);

        mWebView = (WebView) rootView.findViewById(R.id.webview);
        mWebView.loadUrl("https://manimaran96.wordpress.com/2014/07/22/glugucev/");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());


        return rootView;
    }


}

