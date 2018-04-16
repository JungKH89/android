package com.example.smart_10.project1_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView web1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id 찾기
        web1 = (WebView) findViewById(R.id.webView1);

        web1.loadUrl("file:///android_asset/test.html");
    }
}
