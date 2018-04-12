package com.example.smart_10.project1_6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnchange;
    ImageView view1;
    ImageView view2;
    int imageIndex= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("이미지 바꾸기");

        //id찾기
        btnchange=(Button)findViewById(R.id.BtnChange);
        view1=(ImageView)findViewById(R.id.imageView1);
        view2=(ImageView)findViewById(R.id.imageView2);

        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //메소드 호출
                changeImage();
            }
        });

    }

    public void changeImage() {
        if(imageIndex==0){
            view1.setVisibility(View.VISIBLE);
            view2.setVisibility(View.INVISIBLE);
            imageIndex=1;
        }else if(imageIndex==1){
            view1.setVisibility(View.INVISIBLE);
            view2.setVisibility(View.VISIBLE);
            imageIndex=0;
        }
    }
}
