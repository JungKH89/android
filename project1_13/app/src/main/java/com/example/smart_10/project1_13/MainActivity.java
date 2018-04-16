package com.example.smart_10.project1_13;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar mProgStatus;
    Button btnDecrease1, btnIncrease1;

    //Rating 추가
    Button btnDecrease2, btnIncrease2, btnResult;
    RatingBar mRatingVote;

    //Seekbar추가
    SeekBar mSeekRed;
    View mViewColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id찾기
        mProgStatus = (ProgressBar) findViewById(R.id.progStatus);
        btnDecrease1 = (Button) findViewById(R.id.btnDecrease1);
        btnIncrease1 = (Button) findViewById(R.id.btnIncrease1);

        //Rating에 대한 id찾기
        mRatingVote = (RatingBar) findViewById(R.id.ratingVote);
        btnDecrease2 = (Button) findViewById(R.id.btnDecrease2);
        btnIncrease2 = (Button) findViewById(R.id.btnIncrease2);
        btnResult = (Button) findViewById(R.id.btnResult);

        //Seekbar에 대한 id찾기
        mSeekRed = (SeekBar) findViewById(R.id.seekRed);
        mViewColor = (View) findViewById(R.id.viewColor);

        //기본 배경 색상
        mSeekRed.setBackgroundColor(Color.argb(255, mSeekRed.getProgress(),0,0));


        btnDecrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgStatus.setProgress(mProgStatus.getProgress() - 5);
            }
        });

        btnIncrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgStatus.setProgress(mProgStatus.getProgress() + 5);
            }
        });

        btnDecrease2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRatingVote.incrementProgressBy(-1);
            }
        });

        btnIncrease2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRatingVote.incrementProgressBy(1);
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "현재값 = "+mRatingVote.getRating(),Toast.LENGTH_SHORT).show();
            }
        });

        //seekbar이벤트
        mSeekRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mViewColor.setBackgroundColor(Color.argb(255,progress,0,0));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


}
