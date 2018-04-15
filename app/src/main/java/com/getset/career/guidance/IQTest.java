package com.getset.career.guidance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class IQTest extends AppCompatActivity {
    WebView towerOfHanoi;
    long time;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iqtest);
        towerOfHanoi=(WebView)findViewById(R.id.game1);
        towerOfHanoi.setWebViewClient(new WebViewClient());
        towerOfHanoi.getSettings().setJavaScriptEnabled(true);
        towerOfHanoi.setScrollContainer(false);

        // Get the Android assets folder path
        String folderPath = "file:android_asset/";

        // Get the HTML file name
        String fileName = "index.html";

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
                    // Here put your code
                    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                    final String userId = AccessToken.getCurrentAccessToken().getUserId();

                    mDatabase.child(userId).child("TOH").setValue(String.valueOf(System.nanoTime()-time));
                    Intent intent = new Intent(IQTest.this,IQ_2.class);
                    intent.putExtra("time", String.valueOf(System.nanoTime()-time));
                    Toast.makeText(getBaseContext(),String.valueOf(System.nanoTime()-time),Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    return true; //don't Allow WebView to load url
                }
            };
        towerOfHanoi.setWebViewClient(mWebViewClient);
        time=System.nanoTime();
        towerOfHanoi.loadUrl(file);
    }
}
