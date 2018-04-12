package com.example.smart_10.project1_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bmiCal;
    TextView textResult;
    EditText edit1, edit2;
    String num1, num2;
    Float result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1=(EditText) findViewById(R.id.edit1);
        edit2=(EditText) findViewById(R.id.edit2);
        bmiCal=(Button) findViewById(R.id.bmiCal);
        textResult=(TextView) findViewById(R.id.textResult);


        bmiCal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1=edit1.getText().toString();
                num2=edit2.getText().toString();
                Float tall1=Float.parseFloat(num1)/100;
                result=(Float.parseFloat(num2))/(tall1*tall1);
                if(result<18.5){
                    textResult.setText(result.toString()+ " : 저체중");
                }
                else if(result>18.5 && result< 22.9){
                    textResult.setText(result.toString()+ " : 정상");
                }
                else{
                    textResult.setText(result.toString()+ " : 비만");
                }
                return false;
            }
        });
    }



}
