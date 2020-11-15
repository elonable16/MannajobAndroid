package com.ateam.mannajob.mypage;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ateam.mannajob.R;

public class PopReview extends Activity {
    RadioGroup review_radio_group;
    RadioButton review_like;
    RadioButton review_dislike;
    EditText review_contents;
    Button review_ok_btn;
    Button review_cancel_btn;
    String likechk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setFinishOnTouchOutside(false);
        setContentView(R.layout.activity_pop_review);

        initUI();
    }

    private void initUI(){
        review_radio_group = findViewById(R.id.review_radio_group);
        review_like = findViewById(R.id.review_like);
        likechk = "G";
        review_dislike = findViewById(R.id.review_dislike);
        review_contents = findViewById(R.id.review_contents);
        review_ok_btn = findViewById(R.id.review_ok_btn);
        review_ok_btn.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),likechk+"리뷰를 작성했습니다.",Toast.LENGTH_SHORT).show();
        });
        review_cancel_btn = findViewById(R.id.review_cancel_btn);
        review_cancel_btn.setOnClickListener(v -> {
            finish();
        });

        review_radio_group.setOnCheckedChangeListener(groupClickListener);
    }
    RadioGroup.OnCheckedChangeListener groupClickListener = new RadioGroup.OnCheckedChangeListener() {
        @Override public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            if(i == R.id.review_like){
                likechk = "G";
            } else if(i == R.id.review_dislike){
                likechk = "B";
            }
        }
    };
}