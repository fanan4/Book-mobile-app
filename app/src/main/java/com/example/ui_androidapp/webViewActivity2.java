package com.example.ui_androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webViewActivity2 extends AppCompatActivity {
     private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view2);
        Intent intent=getIntent();
        webView=findViewById(R.id.webView);
        if(intent!=null){
            String url=intent.getStringExtra("url");
            webView.loadUrl(url);
            webView.setWebViewClient(new WebViewClient());

        }
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}