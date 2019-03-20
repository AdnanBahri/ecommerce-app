package com.goat.gucci.best_asics_sport_shoes.WebViews;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.goat.gucci.best_asics_sport_shoes.R;

public class CollectionWebView extends AppCompatActivity {

    private WebView webView;
    private SwipeRefreshLayout swipe;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_web_view);

        webView = (WebView) findViewById(R.id.web_view_collection);
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe_collection);

        url = getIntent().getStringExtra("url");

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Load();
            }
        });

        Load();

    }

    private void Load(){
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        swipe.setRefreshing(true);
        webView.setWebViewClient(new WebViewClient()   {

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
//                webView.loadUrl("file:///android_asset/error.html");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                swipe.setRefreshing(false);
            }
        });

        webView.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(webView.canGoBack()){
            webView.goBack();
        }
        else
            finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
