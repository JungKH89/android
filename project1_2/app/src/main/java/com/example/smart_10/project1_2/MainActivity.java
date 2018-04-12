package com.example.smart_10.project1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //위젯에 사용할 변수 선언.. 데이터타입 변수명; ==>데이터타입 (기본형(8), 참조형:클래스)
    EditText edit1, edit2;
    Button btnAdd, btnSub,btnMul, btnDiv, btnRemain;
    TextView textResult;
    String num1, num2;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        //xml에 있는 id값 찾기
        edit1=(EditText) findViewById(R.id.Edit1);
        edit2=(EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub= (Button) findViewById(R.id.BtnSub);
        btnMul=(Button) findViewById(R.id.BtnMul);
        btnDiv=(Button) findViewById(R.id.BtnDiv);
        btnRemain=(Button) findViewById(R.id.BtnRemain);

        textResult=(TextView) findViewById(R.id.TestResult);

        //기능부여 ==> 이벤트==> onTouchListener
        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1=edit1.getText().toString();
                //getText() : 입력된 값 얻기
                //toString() : 문자열화 하기
                num2=edit2.getText().toString();
                result=Integer.parseInt(num1)+Integer.parseInt(num2);
                textResult.setText("계산 결과 : "+result.toString());
                return false;
            }
        });

        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1=edit1.getText().toString();
                num2=edit2.getText().toString();
                result=Integer.parseInt(num1)-Integer.parseInt(num2);
                textResult.setText("계산 결과 : "+result.toString());
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1=edit1.getText().toString();
                num2=edit2.getText().toString();
                result=Integer.parseInt(num1)*Integer.parseInt(num2);
                textResult.setText("계산 결과 : "+result.toString());
                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1=edit1.getText().toString();
                num2=edit2.getText().toString();
                Float result_1;
                result_1=Float.parseFloat(num1)/Float.parseFloat(num2);
                textResult.setText("계산 결과 : "+result_1.toString());
                return false;
            }
        });

        btnRemain.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1=edit1.getText().toString();
                num2=edit2.getText().toString();
                result=Integer.parseInt(num1)%Integer.parseInt(num2);
                textResult.setText("계산 결과 : "+result.toString());
                return false;
            }
        });

    }
}
