package com.gali.fragmentos;

import android.os.Bundle;
import android.renderscript.ScriptIntrinsic;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by kuku on 11/02/14.
 */
public class CountryInfoFragment extends Fragment {
    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_info2, container,false);
        webView = (WebView)view.findViewById(R.id.webView);
        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String country = ((CountryDetailActivity)getActivity()).getCountry();

        webView.loadUrl("http://es.m.wikipedia.org/wiki/"+country);
        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideURlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        });



    }
}
