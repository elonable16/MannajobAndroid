package com.ateam.mannajob.match;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.ateam.mannajob.R;

public class PopRequestMatch extends Activity {

    Spinner mat_stdate_year;
    Spinner mat_stdate_month;
    Spinner mat_stdate_day;
    Spinner mat_stdate_hour;
    Button mat_request;
    Button mat_cancel;
    String mat_stdate;
    String mat_hour;
    String b_num;
    String year;
    String month;
    String day;
    String hour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setFinishOnTouchOutside(false);
        setContentView(R.layout.activity_pop_request_match);
        UiInit();
        Intent intent = getIntent();
        b_num = intent.getExtras().getString("b_num");
        getSpinnerData();
        mat_request.setOnClickListener(v -> {
            mat_stdate = year+"/"+month+"/"+day;
            mat_hour = hour;
            Log.d("넘아갈 날짜 : ",mat_stdate);
            Log.d("넘아갈 시간 : ",mat_hour);
        });

        mat_cancel.setOnClickListener(v -> {
            finish();
        }
        );
    }
    private void UiInit(){
        mat_stdate_year = findViewById(R.id.mat_stdate_year);
        mat_stdate_month = findViewById(R.id.mat_stdate_month);
        mat_stdate_day = findViewById(R.id.mat_stdate_day);
        mat_stdate_hour = findViewById(R.id.mat_stdate_hour);
        mat_request = findViewById(R.id.mat_request);
        mat_cancel = findViewById(R.id.mat_cancel);

    }
    public void getSpinnerData(){
        mat_stdate_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                year = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        mat_stdate_month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                month = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        mat_stdate_day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                day = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mat_stdate_hour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                hour = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}