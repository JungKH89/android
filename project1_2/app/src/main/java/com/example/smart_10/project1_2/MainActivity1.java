package com.example.smart_10.project1_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity {

    //위젯에 사용할 변수 선언.. 데이터타입 변수명; ==>데이터타입 (기본형(8), 참조형:클래스)
    EditText edit1, edit2;
    Button btnAdd, btnSub,btnMul, btnDiv, btnRemain, btnClear, btnC;
    TextView textResult;
    String num1, num2;
    Integer result;

    //추가한 10개의 버튼을 사용하기 위한 배열 선언
    //배열선언 : 타입[] 배열명= new 타입 [크기]
    Button[] numButtons=new Button[10];
    Integer[] numBtnIDs={R.id.BtnNum0,R.id.BtnNum1,R.id.BtnNum2,R.id.BtnNum3,R.id.BtnNum4,
                         R.id.BtnNum5,R.id.BtnNum6,R.id.BtnNum7,R.id.BtnNum8,R.id.BtnNum9};
    //인덱스 번호 체크할 변수
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        setTitle("테이블레이아웃 계산기");

        //xml에 있는 id값 찾기
        edit1=(EditText) findViewById(R.id.Edit1);
        edit2=(EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub= (Button) findViewById(R.id.BtnSub);
        btnMul=(Button) findViewById(R.id.BtnMul);
        btnDiv=(Button) findViewById(R.id.BtnDiv);
        btnRemain=(Button) findViewById(R.id.BtnRemain);
        btnClear=(Button) findViewById(R.id.BtnClear);
        btnC=(Button) findViewById(R.id.BtnC);

        textResult=(TextView) findViewById(R.id.TestResult);

        //배열에 있는 id값 찾기
        for (i=0;i<numBtnIDs.length;i++){
            numButtons[i]=(Button)findViewById(numBtnIDs[i]);
        }

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

        //모든 글자 지우는 버튼
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText("");
                edit2.setText("");

                textResult.setText("계산 결과 : ");
                edit1.requestFocus();
                edit1.setCursorVisible(true);
            }
        });

        //한글자씩 지우는 버튼
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit1.isFocused()==true){
                    String strTemp = edit1 .getText().toString();
                    edit1.setText(strTemp.substring(0, strTemp.length()-1));
                    edit1.setSelection(edit1.length());
                }else if(edit2.isFocused()==true){
                    String strTemp = edit2 .getText().toString();
                    edit2.setText(strTemp.substring(0, strTemp.length()-1));
                    edit2.setSelection(edit2.length());
                }else{
                    Toast.makeText(getApplicationContext(),"먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        for(i=0;i<numBtnIDs.length;i++){
            final int index;
            index=i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(edit1.isFocused()==true){
                        // 클릭한 버튼을 계속 추가해서 보여주기
                        num1=edit1.getText().toString()+numButtons[index].getText().toString();
                        //setText : 새롭게 값 설정
                        edit1.setText(num1);
                    }else if(edit2.isFocused()==true){
                        num2=edit2.getText().toString()+numButtons[index].getText().toString();
                        edit2.setText(num2);
                    }else{
                        Toast.makeText(getApplicationContext(),"먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}
