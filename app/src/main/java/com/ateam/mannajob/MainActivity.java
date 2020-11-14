package com.ateam.mannajob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.ateam.mannajob.match.BoardMatching;
import com.ateam.mannajob.match.Matching;
import com.ateam.mannajob.mypage.Mypage;
import com.ateam.mannajob.mypage.MypageMatchManage;
import com.ateam.mannajob.mypage.Schedule;
import com.ateam.mannajob.recycleMatch.MatchDTO;
import com.ateam.mannajob.recycleNotice.NoticeDTO;
import com.ateam.mannajob.recycleQna.QnADTO;
import com.ateam.mannajob.serivce.BoardNotice;
import com.ateam.mannajob.serivce.BoardQnA;
import com.ateam.mannajob.serivce.Service;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nhn.android.naverlogin.OAuthLogin;
import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.Inflater;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements AutoPermissionsListener,OnFragmentItemSelectedListener, ImageFormToServer, Runnable {
    private static final String TAG= "MainActivity";
    private final MyHandler handler = new MyHandler(this);
    OAuthLogin LoginState = OAuthLogin.getInstance();
    Matching matching_f;
    Service service_f;
    Mypage mypage_f;
    BoardMatching boardMatching_f;
    MypageMatchManage mypageMatchManage_f;
    BoardNotice boardNotice_f;
    BoardQnA boardQnA_f;
    Schedule schedule_f;
    Bundle bundle;


    Toolbar toolbar;
    //프로필 확인
    Bitmap bitmap;
    CircleImageView profile;
    String profile_file_name;
    public class MyHandler extends Handler {
        private final WeakReference<MainActivity> weakReference;

        public MyHandler(MainActivity activity){
            this.weakReference = new WeakReference<>(activity);
        }
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            profile.setImageBitmap(bitmap);
        }
    }

    @Override
    public void getImageToServer(CircleImageView imageView, String imageName) {
        this.profile = imageView;
        this.profile_file_name = imageName;
        Thread thread = new Thread(MainActivity.this);
        thread.start();
    }

    BottomNavigationView bottomNavigation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UIinit();

        toolbar = findViewById(R.id.toolbar);
        //툴바(액션바) 설정
        toolbarSetting(toolbar);
        //초기화면 지정
        getSupportFragmentManager().beginTransaction().replace(R.id.container_main, matching_f).commit();
        //권한 설정
        AutoPermissions.Companion.loadAllPermissions(this, 101);



        //프래그먼터 클릭된 아이디 값을 통해 화면 전환
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_main, matching_f).commit();
                        return true;
                    case R.id.tab2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_main, service_f).commit();
                        return true;
                    case R.id.tab3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_main, mypage_f).commit();

                        return true;
//                    case R.id.tab3:
//                        if (LoginState.getState(getApplicationContext()).toString().equals("OK")) {
//                            Toast.makeText(getApplicationContext(), "다섯번째 탭 선택됨", Toast.LENGTH_LONG).show();
//                            getSupportFragmentManager().beginTransaction().replace(R.id.container_main, fragment5).commit();
//                        } else {
//                            Toast.makeText(getApplicationContext(), "로그인이 필요합니다.", Toast.LENGTH_LONG).show();
//                        }
//                        return true;
                }
                return false;
            }
        });
    }

    public void UIinit(){
        matching_f = new Matching();
        service_f = new Service();
        mypage_f = new Mypage();
        boardMatching_f = new BoardMatching();
        mypageMatchManage_f = new MypageMatchManage();
        boardNotice_f = new BoardNotice();
        boardQnA_f = new BoardQnA();
        schedule_f = new Schedule();

    }

    public void onTabSelected(int position, Object item) { // fragment에서 이벤트 연결시 이동을 위한 메소드 작성 버튼, 취소 버튼을 누를 시 selected item이 변경됨으로  onnavigationItemSelected에 의해 해당 페이지로 이동
        bundle = new Bundle();
        if (position == AppConstants.FRAGMENT_MATCH) {
            bottomNavigation.setSelectedItemId(R.id.tab1);
        } else if (position == AppConstants.FRAGMENT_SERVICE) {
            bottomNavigation.setSelectedItemId(R.id.tab2);
        } else if (position == AppConstants.FRAGMENT_MYPAGE) {
            bottomNavigation.setSelectedItemId(R.id.tab3);
        } else if (position == AppConstants.FRAGMENT_BOARD_MATCH){
            MatchDTO matchDTO = (MatchDTO)item;
            bundle.putSerializable("item", matchDTO);
            boardMatching_f.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.container_main, boardMatching_f).commit();
        }
        else if (position == AppConstants.FRAGMENT_BOARD_NOTICE){
            NoticeDTO noticeDTO = (NoticeDTO)item;
            bundle.putSerializable("item", noticeDTO);
            boardNotice_f.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.container_main, boardNotice_f).commit();
        }
        else if (position == AppConstants.FRAGMENT_BOARD_QNA){
            QnADTO qnaDTO = (QnADTO) item;
            bundle.putSerializable("item", qnaDTO);
            boardQnA_f.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.container_main, boardQnA_f).commit();
        }
        else if (position == AppConstants.FRAGMENT_CALENDAR){
            Log.d("가나다라","마바사");
            mypage_f.getChildFragmentManager().beginTransaction().replace(R.id.container_mypage, schedule_f).commit();
        }
        else if (position == AppConstants.FRAGMENT_MATCHINGMANGER){
            mypage_f.getChildFragmentManager().beginTransaction().replace(R.id.container_mypage, mypageMatchManage_f).commit();
        }
    }
////////////////////////////////////////////////////////////////////////////프로필 다운로드 스레드
    @Override
    public void run() {
        URL url = null;
        try {
            url = new URL("http://192.168.0.225:8080/resources/img/productimg/"+profile_file_name);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.connect();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 4;
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is,null,options);
            handler.sendEmptyMessage(0);
            is.close();
            conn.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////// 툴바 사용
    public void toolbarSetting(Toolbar toolbar) {
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.login_tab:
                Toast.makeText(this, "로그인 창 클릭", Toast.LENGTH_SHORT).show();
                // 새 액티비티 열기(로그인)

//                if (LoginState.getState(this).toString().equals("OK")) {
//                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment5).commit();
//                } else {
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
//                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    ///////////////////////////////////////Danger permission request///////////////////////////////////////
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AutoPermissions.Companion.parsePermissions(this, requestCode, permissions, this);
    }

    @Override
    public void onDenied(int i, String[] permissions) {
        Toast.makeText(this, "permissions denied : " + permissions.length, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGranted(int i, String[] permissions) {
        Toast.makeText(this, "permissions granted : " + permissions.length, Toast.LENGTH_SHORT).show();
    }
}