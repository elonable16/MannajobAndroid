package com.ateam.mannajob.mypage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.ateam.mannajob.R;
import com.ateam.mannajob.recycleMyRequest.MatchDTO;

public class PopCancelChk extends Activity {
    Button cancelchk_cancel_btn;
    Button cancelchk_ok_btn;
    MatchDTO matchDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setFinishOnTouchOutside(false);
        setContentView(R.layout.activity_pop_cancel_chk);

        Intent intent = getIntent();
        matchDTO =(MatchDTO)intent.getExtras().getSerializable("matchitem");
        initUI();
    }

    private void initUI(){
        cancelchk_cancel_btn = findViewById(R.id.cancelchk_cancel_btn);
        cancelchk_ok_btn = findViewById(R.id.cancelchk_ok_btn);
        cancelchk_ok_btn.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),Integer.toString(matchDTO.getB_num()),Toast.LENGTH_SHORT).show();
        });
        cancelchk_cancel_btn.setOnClickListener(v -> {
            finish();
        });
    }
}