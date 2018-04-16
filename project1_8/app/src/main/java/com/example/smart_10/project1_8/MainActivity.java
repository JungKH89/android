package com.example.smart_10.project1_8;

import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation") //예전 버전일 때 나오는 경고문 없애줌
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1> TabHost 사용하기 위한 준비 ==> 정보를 가져옴
        TabHost tabHost = getTabHost();

        //탭 위젯에 들어갈 내용
        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별");
        tabSpecSong.setContent(R.id.tabSong);   //텝에 들어갈 내용과 ID값 연결
        tabHost.addTab(tabSpecSong);            //탭에 들어갈 내용을 탭호스트에 연결

        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("Artist").setIndicator("가수별");
        tabSpecArtist.setContent(R.id.tabArtist);
        tabHost.addTab(tabSpecArtist);

        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("Album").setIndicator("앨범별");
        tabSpecAlbum.setContent(R.id.tabAlbum);
        tabHost.addTab(tabSpecAlbum);

        //기본 탭 설정
        tabHost.setCurrentTab(0);
    }
}
