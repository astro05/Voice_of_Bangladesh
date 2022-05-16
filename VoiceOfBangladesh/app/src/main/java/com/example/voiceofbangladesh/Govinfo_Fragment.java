package com.example.voiceofbangladesh;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class Govinfo_Fragment extends Fragment implements View.OnClickListener {

    private static FragmentManager fragmentManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_govinfo, container,false);
        WebView webView =(WebView)v.findViewById(R.id.gov_site);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://bangladesh.gov.bd");


        return  v;
    }


    @Override
    public void onClick(View v) {
         }
}