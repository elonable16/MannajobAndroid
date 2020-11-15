package com.ateam.mannajob.serivce;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ateam.mannajob.AppConstants;
import com.ateam.mannajob.MainActivity;
import com.ateam.mannajob.OnFragmentItemSelectedListener;
import com.ateam.mannajob.R;
import com.ateam.mannajob.match.Matching;
import com.ateam.mannajob.recycleNotice.NoticeAdapter;
import com.ateam.mannajob.recycleNotice.NoticeDTO;
import com.ateam.mannajob.recycleNotice.OnNoticeItemClickListener;
import com.ateam.mannajob.recycleQna.OnQnAItemClickListener;
import com.ateam.mannajob.recycleQna.QnAAdapter;
import com.ateam.mannajob.recycleQna.QnADTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import lib.kingja.switchbutton.SwitchMultiButton;


public class Service extends Fragment implements MainActivity.onKeyBackPressedListener {
    Context context;
    RecyclerView serviceRecyc;
    NoticeAdapter noticeAdapter;
        QnAAdapter qnAAdapter;
    OnFragmentItemSelectedListener listener;
    SwitchMultiButton switchMultiButton;
    int switchpostion;
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
        if (switchpostion == 0) {
            showNoticeList();
        } else if (switchpostion == 1) {
            showQnAList();
        }
        return rootView;
    }

    private void initUI(ViewGroup rootview) {
        switchMultiButton = rootview.findViewById(R.id.service_switchButton);
        switchMultiButton.setOnSwitchListener(new SwitchMultiButton.OnSwitchListener() {
            @Override
            public void onSwitch(int position, String tabText) {
                if (position == 0) {
                    showNoticeList();
                    serviceRecyc.setAdapter(noticeAdapter);
                } else if (position == 1) {
                    showQnAList();
                    serviceRecyc.setAdapter(qnAAdapter);
                }
                switchpostion = position;
            }
        });
        serviceRecyc = rootview.findViewById(R.id.service_recyc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        serviceRecyc.setLayoutManager(layoutManager);
    }

    public void showNoticeList(){
        ArrayList<NoticeDTO> list = new ArrayList<>();
        noticeAdapter = new NoticeAdapter();
        noticeAdapter.setItems(list);
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        list.add(new NoticeDTO(1, "이용해주셔서 감사합니다.", "admin", "공지합니다.", 1234, now));
        list.add(new NoticeDTO(1, "이용해주셔서 감사합니다.", "admin", "공지합니다.", 1234, now));
        list.add(new NoticeDTO(1, "이용해주셔서 감사합니다.", "admin", "공지합니다.", 1234, now));
        list.add(new NoticeDTO(1, "이용해주셔서 감사합니다.", "admin", "공지합니다.", 1234, now));
        list.add(new NoticeDTO(1, "이용해주셔서 감사합니다.", "admin", "공지합니다.", 1234, now));
        list.add(new NoticeDTO(1, "이용해주셔서 감사합니다.", "admin", "공지합니다.", 1234, now));
        serviceRecyc.setAdapter(noticeAdapter);
        noticeAdapter.setOnItemClickListner(new OnNoticeItemClickListener() {
            @Override
            public void onItemClick(NoticeAdapter.ViewHolder viewHolder, View view, int position) {
                NoticeDTO item = noticeAdapter.getItem(position);
                listener.onTabSelected(AppConstants.FRAGMENT_BOARD_NOTICE,item);
            }
        });
    }

    public void showQnAList() {
        ArrayList<QnADTO> list = new ArrayList<>();
        qnAAdapter = new QnAAdapter();
        qnAAdapter.setItems(list);
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        list.add(new QnADTO(1, "기타", "lion", "질문내용은 이것입니다.", now, "질문있습니다.","답변내용입니다.",now));
        list.add(new QnADTO(1, "기타", "lion", "질문내용은 이것입니다.", now, "질문있습니다.","답변내용입니다.",now));
        list.add(new QnADTO(1, "기타", "lion", "질문내용은 이것입니다.", now, "질문있습니다.","답변내용입니다.",now));
        list.add(new QnADTO(1, "기타", "lion", "질문내용은 이것입니다.", now, "질문있습니다.","답변내용입니다.",now));
        list.add(new QnADTO(1, "기타", "lion", "질문내용은 이것입니다.", now, "질문있습니다.","답변내용입니다.",now));
        list.add(new QnADTO(1, "기타", "lion", "질문내용은 이것입니다.", now, "질문있습니다.","답변내용입니다.",now));
        serviceRecyc.setAdapter(qnAAdapter);

        qnAAdapter.setOnItemClickListner(new OnQnAItemClickListener() {
            @Override
            public void onItemClick(QnAAdapter.ViewHolder viewHolder, View view, int position) {
                QnADTO item = qnAAdapter.getItem(position);
                listener.onTabSelected(AppConstants.FRAGMENT_BOARD_QNA,item);
            }
        });
    }
    @Override
    public void onBackKey() {
        goToMain();
    }

    //프래그먼트 종료
    private void goToMain(){
        FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(Service.this).commit();
        fragmentManager.popBackStack();
    }

}
