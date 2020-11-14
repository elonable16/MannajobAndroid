package com.ateam.mannajob.mypage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.ateam.mannajob.R;
import com.ateam.mannajob.recycleCalendar.CalendarAdapter;
import com.ateam.mannajob.recycleCalendar.CalendarDTO;
import com.ateam.mannajob.recycleMatch.MatchAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Popcalendar extends Activity {
    RecyclerView scheduleRecyc;
    CalendarAdapter adapter;
    CalendarDTO calendarDTO;
    Calendar calendar_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_popcalendar);
        Intent intent = getIntent();
//        calendar_date = intent.getStringExtra("mat_stdate");
//        Toast.makeText(this,date,Toast.LENGTH_SHORT).show();
        UiInit();
    }

    public void UiInit(){
        scheduleRecyc = findViewById(R.id.calendar_recyc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        scheduleRecyc.setLayoutManager(layoutManager);

        ArrayList<CalendarDTO> list = new ArrayList<>();
        adapter = new CalendarAdapter();


        adapter.setItems(list);
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        list.add(new CalendarDTO(1, "admin","010-0000-0000", now, "03:00", "청주시 오창읍"));

        scheduleRecyc.setAdapter(adapter);
    }
}