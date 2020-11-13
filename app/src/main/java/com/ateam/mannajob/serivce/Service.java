package com.ateam.mannajob.serivce;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ateam.mannajob.OnFragmentItemSelectedListener;
import com.ateam.mannajob.R;
import com.ateam.mannajob.mypage.PopPasswdCheck;
import com.ateam.mannajob.recycleMatch.MatchAdapter;
import com.ateam.mannajob.recycleMatch.MatchDTO;
import com.ateam.mannajob.recycleNotice.NoticeAdapter;
import com.ateam.mannajob.recycleQna.QnAAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import lib.kingja.switchbutton.SwitchMultiButton;


public class Service extends Fragment {
    Context context;
    RecyclerView serviceRecyc;
    NoticeAdapter noticeAdapter;
        QnAAdapter qnAAdapter;
    OnFragmentItemSelectedListener listener;
    SwitchMultiButton switchMultiButton;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        if(context instanceof  OnFragmentItemSelectedListener){
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
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_service, container, false);
        initUI(rootView);
        return rootView;
    }

    private void initUI(ViewGroup rootview) {
        serviceRecyc = rootview.findViewById(R.id.service_recyc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        serviceRecyc.setLayoutManager(layoutManager);

        ArrayList<MatchDTO> list = new ArrayList<>();
        adapter = new MatchAdapter();
        adapter.setItems(list);
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();

    }
}