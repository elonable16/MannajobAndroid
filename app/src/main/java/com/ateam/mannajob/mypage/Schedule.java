package com.ateam.mannajob.mypage;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.ateam.mannajob.AppConstants;
import com.ateam.mannajob.OnFragmentItemSelectedListener;
import com.ateam.mannajob.R;
import com.ateam.mannajob.recycleCalendar.CalendarAdapter;
import com.ateam.mannajob.recycleCalendar.CalendarDTO;
import com.ateam.mannajob.recycleCalendar.OnCalendarItemClickListener;
import com.ateam.mannajob.recycleMatch.MatchAdapter;
import com.ateam.mannajob.recycleMatch.MatchDTO;
import com.ateam.mannajob.recycleMatch.OnMatchItemClickListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import lib.kingja.switchbutton.SwitchMultiButton;


public class Schedule extends Fragment {
    private static final String TAG = "Schedule";
    RecyclerView scheduleRecyc;
    CalendarAdapter adapter;
    Context context;
    OnFragmentItemSelectedListener listener;
    CalendarView calendarView;

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

        Log.d("test", "onCreateView s");

        return rootView;
    }

    private void initUI(ViewGroup rootview) {

        scheduleRecyc = rootview.findViewById(R.id.calendar_recyc);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        scheduleRecyc.setLayoutManager(layoutManager);

        ArrayList<CalendarDTO> list = new ArrayList<>();
        adapter = new CalendarAdapter();
        adapter.setItems(list);
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        list.add(new CalendarDTO(1, "admin", "010-0000-0000", now, "03:00", "청주시 오창읍"));
        scheduleRecyc.setAdapter(adapter);
//////////adapter 리스너 정의//////
        adapter.setOnItemClickListner(new OnCalendarItemClickListener(){
            @Override
            public void onItemClick(CalendarAdapter.ViewHolder viewHolder, View view, int position) {
                CalendarDTO item = adapter.getItem(position);
            }
        });

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("test", "onCreate s");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("test", "onActivityCreated s");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("test", "onStart s");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("test", "onResume s");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("test", "onPause s");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("test", "onStop s");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("test", "onDestroyView s");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("test", "onDestroy s");
    }
}