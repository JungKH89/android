package com.example.smart_10.project1_9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //사용할 변수선언
    Button btnGo, btnBack;
    EditText edtUrl;
    WebView web1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id 찾기
        btnGo = (Button) findViewById(R.id.btnGo);
        btnBack = (Button) findViewById(R.id.btnBack);
        edtUrl = (EditText) findViewById(R.id.edtUrl);
        web1 = (WebView) findViewById(R.id.webView1);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web1.loadUrl(edtUrl.getText().toString());    // =web.LoadUrl("http://www.daum.net");
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web1.goBack();
            }
        });
    }
}
