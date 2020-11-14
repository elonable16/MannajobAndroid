package com.ateam.mannajob.mypage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.applandeo.materialcalendarview.CalendarUtils;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnCalendarPageChangeListener;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.applandeo.materialcalendarview.utils.DateUtils;
import com.ateam.mannajob.OnFragmentItemSelectedListener;
import com.ateam.mannajob.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Schedule extends Fragment {
    private static final String TAG = "Schedule";
    Context context;
    OnFragmentItemSelectedListener listener;
    com.applandeo.materialcalendarview.CalendarView calendarView;
    int MonthCnt = 0;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof OnFragmentItemSelectedListener) {
            listener = (OnFragmentItemSelectedListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (context != null) {
            context = null;
            listener = null;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_schedule, container, false);
        initUI(rootView);

        return rootView;
    }

    private void initUI(ViewGroup rootview) {
        calendarView = rootview.findViewById(R.id.calendarView);

        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(@NotNull EventDay eventDay) {
                Calendar clickedDayCalendar = eventDay.getCalendar();
                Log.d("데이",Integer.toString(clickedDayCalendar.get(Calendar.YEAR)));
                Log.d("데이",Integer.toString(clickedDayCalendar.get(Calendar.MONTH)+1));
                Log.d("데이",Integer.toString(clickedDayCalendar.get(Calendar.DAY_OF_MONTH)));

                Intent intent = new Intent(getContext(), Popcalendar.class);
                intent.putExtra("mat_stdate" , clickedDayCalendar);
                startActivity(intent);
            }
        });
        calendarView.setOnForwardPageChangeListener(new OnCalendarPageChangeListener() {
            @Override
            public void onChange() {
                Calendar calendar = Calendar.getInstance();
                MonthCnt++;
                calendar.add(Calendar.MONTH,MonthCnt);
                Toast.makeText(context, Integer.toString(calendar.get(Calendar.YEAR))+Integer.toString(calendar.get(Calendar.MONTH)+1), Toast.LENGTH_SHORT).show();
            }
        });
        calendarView.setOnPreviousPageChangeListener(new OnCalendarPageChangeListener() {
             @Override
             public void onChange() {
                 Calendar calendar = Calendar.getInstance();
                 MonthCnt--;
                 calendar.add(Calendar.MONTH,MonthCnt);
                 Toast.makeText(context, Integer.toString(calendar.get(Calendar.YEAR))+Integer.toString(calendar.get(Calendar.MONTH)+1), Toast.LENGTH_SHORT).show();
             }
         });

// 아이템 이미지(이벤트) 추가
        List<EventDay> events = new ArrayList<>();
        for(Calendar a:getSelectedDays()) {
            events.add(new EventDay(a, R.drawable.calendardot));
        }

        calendarView.setEvents(events);
    }
    private List<Calendar> getSelectedDays() {
        List<Calendar> calendars = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Calendar calendar = DateUtils.getCalendar();
            calendar.add(Calendar.DAY_OF_MONTH, i);
            calendars.add(calendar);
        }
        return calendars;
    }
}