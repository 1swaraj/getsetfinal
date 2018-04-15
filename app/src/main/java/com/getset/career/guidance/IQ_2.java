package com.getset.career.guidance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.facebook.AccessToken;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class IQ_2 extends AppCompatActivity {
    long time;
    DatabaseReference mDatabase;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iqtest2);
        webView=(WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollContainer(false);
        final String userId = AccessToken.getCurrentAccessToken().getUserId();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // Get the Android assets folder path
        String folderPath = "file:android_asset/";

        // Get the HTML file name
        String fileName = "15puzzle.html";

        // Get the exact file location
        String file = folderPath + fileName;

                /*
                    loadUrl(String url)
                        Loads the given URL.
                 */

        // Render the HTML file on WebView
        WebViewClient mWebViewClient = new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:window.android.onUrlChange(window.location.href);");
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mDatabase.child(userId).child("Puzzle").setValue(String.valueOf(System.nanoTime()-time));
                Intent intent = new Intent(IQ_2.this, Ptest.class);
                intent.putExtra("question", "0");
                startActivity(intent);
                return true; //don't Allow WebView to load url
            }
        };
        webView.setWebViewClient(mWebViewClient);

        webView.loadUrl(file);
        time=System.nanoTime();
    }
}
