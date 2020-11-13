package com.ateam.mannajob.match;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ateam.mannajob.AppConstants;
import com.ateam.mannajob.OnFragmentItemSelectedListener;
import com.ateam.mannajob.R;
import com.ateam.mannajob.mypage.PopPasswdCheck;
import com.ateam.mannajob.recycleMatch.MatchAdapter;
import com.ateam.mannajob.recycleMatch.MatchDTO;
import com.ateam.mannajob.recycleMatch.OnMatchItemClickListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Matching extends Fragment {
    private static final String TAG = "Matching";
    RecyclerView matchingRecyc;
    MatchAdapter adapter;
    Context context;
    OnFragmentItemSelectedListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        if(context instanceof  OnFragmentItemSelectedListener){
            listener = (OnFragmentItemSelectedListener) context;
        }
    }
    @Override
    public void onDetach(){
        super.onDetach();
        if(context!= null){
            context=null;
            listener = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_matching, container, false);
        initUI(rootView);
        return rootView;
    }
    private  void  initUI(ViewGroup rootview) {
        matchingRecyc = rootview.findViewById(R.id.RecyclerView_b_match);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        matchingRecyc.setLayoutManager(layoutManager);

        ArrayList<MatchDTO> list = new ArrayList<>();
        adapter = new MatchAdapter();
        adapter.setItems(list);
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        list.add( new MatchDTO(1,"현직자","idimda","삼성전자","IT/네트워크",10000,"오창읍","2020-10-10","2020-10-10","1","elon1","", now,"default.jpg","감사합니다"));
        list.add( new MatchDTO(1,"현직자","idimda","삼성전자","IT/네트워크",10000,"오창읍","2020-10-10","2020-10-10","1","elon1","", now,"4.jpg","감사합니다."));
        list.add( new MatchDTO(1,"현직자","idimda","삼성전자","IT/네트워크",10000,"오창읍","2020-10-10","2020-10-10","1","elon1","", now,"5.jpg","감사합니다"));
        list.add( new MatchDTO(1,"현직자","idimda","삼성전자","IT/네트워크",10000,"오창읍","2020-10-10","2020-10-10","1","elon1","", now,"6.jpg","감사합니다."));
        matchingRecyc.setAdapter(adapter);
//////////adapter 리스너 정의//////
        adapter.setOnItemClickListner(new OnMatchItemClickListener() {
            @Override
            public void onItemClick(MatchAdapter.ViewHolder viewHolder, View view, int position) {
                MatchDTO item = adapter.getItem(position);
                listener.onTabSelected(AppConstants.FRAGMENT_BOARD_MATCH,item);
            }
        });
    }
}