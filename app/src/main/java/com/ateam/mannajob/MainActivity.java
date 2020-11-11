package com.ateam.mannajob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nhn.android.naverlogin.OAuthLogin;
import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

public class MainActivity extends AppCompatActivity implements AutoPermissionsListener {
    private static final String TAG= "MainActivity";
    OAuthLogin LoginState = OAuthLogin.getInstance();
    Matching matching_f;
    Service service_f;
    Mypage mypage_f;

    Toolbar toolbar;


    BottomNavigationView bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        matching_f = new Matching();
        service_f = new Service();
        mypage_f = new Mypage();


        setContentView(R.layout.activity_main);
        //툴바(액션바) 설정
        toolbar = findViewById(R.id.toolbar);
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
    public void onTabSelected(int position) { // fragment에서 이벤트 연결시 이동을 위한 메소드 작성 버튼, 취소 버튼을 누를 시 selected item이 변경됨으로  onnavigationItemSelected에 의해 해당 페이지로 이동
        if (position == 0) {
            bottomNavigation.setSelectedItemId(R.id.tab1);
        } else if (position == 1) {
            bottomNavigation.setSelectedItemId(R.id.tab2);
        } else if (position == 2) {
            bottomNavigation.setSelectedItemId(R.id.tab3);
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