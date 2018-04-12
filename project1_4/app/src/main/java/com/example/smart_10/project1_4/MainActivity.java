package com.example.smart_10.project1_4;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnOK,reset1;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("애완동물 사진 보기");

        text1 = (TextView)findViewById(R.id.Text1);
        text2 = (TextView) findViewById(R.id.Text2);

        chkAgree=(CheckBox) findViewById(R.id.ChkAgree);
        rGroup1=(RadioGroup) findViewById(R.id.Rgroup1);
        rdoDog=(RadioButton) findViewById(R.id.RdoDog);
        rdoCat=(RadioButton) findViewById(R.id.RdoCat);
        rdoRabbit=(RadioButton) findViewById(R.id.RdoRabbit);
        btnOK=(Button) findViewById(R.id.BtnOk);
        reset1=(Button) findViewById(R.id.Reset);
        imgPet=(ImageView) findViewById(R.id.ImgPet);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkAgree.isChecked() == true){
                    //isChecked : checked속성값을 알아볼 때 사용
                    //화면에 보여주기 ==> visible이라는 속성값을 설정
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                } else     //다시 화면에서 숨기기
                {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });

        //선택완료 버튼에 클릭 이벤트 부여
        btnOK.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                switch (rGroup1.getCheckedRadioButtonId()){
                    case R.id.RdoDog:
                        imgPet.setImageResource(R.drawable.dog);
                        //setImageResource ==> android:src 동일기능 ==>이미지 불러오기
                        break;
                    case R.id.RdoCat:
                        imgPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.RdoRabbit:
                        imgPet.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"동물 먼저 선택하세요",Toast.LENGTH_SHORT).show();
                }
            }
        });

        reset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2.setVisibility(View.INVISIBLE);
                rGroup1.setVisibility(View.INVISIBLE);
                btnOK.setVisibility(View.INVISIBLE);
                imgPet.setVisibility(View.INVISIBLE);
            }
        });

        //radio버튼 누르면 바로 보임
//        rdoDog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imgPet.setImageResource(R.drawable.dog);
//            }
//        });
//
//        rdoCat.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                imgPet.setImageResource(R.drawable.cat);
//            }
//        });
//
//        rdoRabbit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imgPet.setImageResource(R.drawable.rabbit);
//            }
//        });
    }
}


