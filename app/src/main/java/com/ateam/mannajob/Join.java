package com.ateam.mannajob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Join extends AppCompatActivity {

    TextView id;
    TextView passwd;
    TextView passwd_re;
    TextView name;
    TextView phone;
    TextView email;
    Button reg_ok_btn;
    Button reg_cancel_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        UIinit();
        reg_ok_btn.setOnClickListener(v -> {

        });
        reg_cancel_btn.setOnClickListener(v -> {
            finish();
        });
    }
    private void UIinit(){
        id = findViewById(R.id.reg_id);
        passwd = findViewById(R.id.reg_passwd);
        passwd_re = findViewById(R.id.reg_passwd_re);
        name = findViewById(R.id.reg_name);
        phone = findViewById(R.id.reg_phone);
        email = findViewById(R.id.reg_email);
        reg_ok_btn = findViewById(R.id.reg_ok_btn);
        reg_cancel_btn = findViewById(R.id.reg_exit_btn);
    }
}