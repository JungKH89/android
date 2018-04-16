package com.example.smart_10.project1_12;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by SMART-10 on 2018-04-16.
 */

public class WebAppInterface {
    Context mContext;
    WebAppInterface(Context c){
        mContext = c;
    }

    //메소드 정의 ==> 자바스크립트에서 안드로이드 메서드 호출
    @JavascriptInterface
    public void showToast (String toast){
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

}
