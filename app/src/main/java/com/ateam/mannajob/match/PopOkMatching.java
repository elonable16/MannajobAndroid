package com.ateam.mannajob.match;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ateam.mannajob.R;

public class PopOkMatching extends Activity {
    RadioGroup mat_radio_group;
    Button mat_ok_btn;
    Button mat_cancel_btn;
    int radioItemCnt=5;
    String chkradio="선택된 매칭이 없습니다.";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setFinishOnTouchOutside(false);
        setContentView(R.layout.activity_pop_ok_matching);

        initUI();
    }

    private void initUI(){
        mat_radio_group = findViewById(R.id.mat_radio_group);
        mat_ok_btn = findViewById(R.id.mat_ok_btn);
        mat_cancel_btn = findViewById(R.id.mat_cancel_btn);
        AddRadioGrouplist();
        mat_radio_group.setOnCheckedChangeListener(groupClickListener);

        mat_ok_btn.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),chkradio,Toast.LENGTH_SHORT).show();
        });
        mat_cancel_btn.setOnClickListener(v -> {
            finish();
        });
    }
    public void  AddRadioGrouplist(){
        for(int i=0; i<radioItemCnt;i++){
            RadioButton radioButton = new RadioButton(this);
            if(i==0){
                radioButton.setText("게시글을 취소합니다.");
            }else {
                radioButton.setText("list" + i);
            }
            radioButton.setId(i);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT,RadioGroup.LayoutParams.WRAP_CONTENT);
            mat_radio_group.addView(radioButton,layoutParams);
        }
    }
    RadioGroup.OnCheckedChangeListener groupClickListener = new RadioGroup.OnCheckedChangeListener() {
        @Override public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            for(int j=0; j<radioItemCnt; j++){
                if(i == j){
                    RadioButton radioItem = (RadioButton) mat_radio_group.getChildAt(j);
                    chkradio = radioItem.getText().toString();
                }
            }
        }
    };
}