package com.ateam.mannajob.mypage;

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

import com.ateam.mannajob.AppConstants;
import com.ateam.mannajob.OnFragmentItemSelectedListener;
import com.ateam.mannajob.R;
import com.ateam.mannajob.match.PopOkMatching;
import com.ateam.mannajob.recycleMatch.BMatchDTO;
import com.ateam.mannajob.recycleMyMatch.MyMatchAdapter;
import com.ateam.mannajob.recycleMyMatch.OnMyMatchItemClickListener;
import com.ateam.mannajob.recycleMyRequest.MatchDTO;
import com.ateam.mannajob.recycleMyRequest.OnRequestMatchItemClickListener;
import com.ateam.mannajob.recycleMyRequest.RequestMatchAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MypageMatchManage extends Fragment {
    private static final String TAG = "MypageMatchManage";
    RecyclerView mypage_requset_state_recyc;
    RequestMatchAdapter requestAdapter;
    RecyclerView mypage_edit_state_recyc;
    MyMatchAdapter myMatchAdapter;
    Context context;
    OnFragmentItemSelectedListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        if(context instanceof OnFragmentItemSelectedListener){
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
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_mypage_match_manage, container, false);
        initUI(rootView);
        return rootView;
    }
    private  void  initUI(ViewGroup rootview) {
        mypage_edit_state_recyc = rootview.findViewById(R.id.mypage_edit_state_recyc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mypage_edit_state_recyc.setLayoutManager(layoutManager);
        myMatchAdapter = new MyMatchAdapter();

        SettingEditRecyc();

        mypage_requset_state_recyc = rootview.findViewById(R.id.mypage_request_state_recyc);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());
        mypage_requset_state_recyc.setLayoutManager(layoutManager2);
        requestAdapter = new RequestMatchAdapter();

        SettingRequestRecyc();


    }


//        작성 현황 프래그먼트
    public void SettingEditRecyc(){
        ArrayList<BMatchDTO> list = new ArrayList<>();
        myMatchAdapter.setItems(list);
//       수정필요
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
//        수정필요
        list.add( new BMatchDTO(1,"현직자","idimda","삼성전자","IT/네트워크",10000,"오창읍","2020-10-10","2020-10-10","1","A","", now,"default.jpg","감사합니다"));
        list.add( new BMatchDTO(1,"현직자","idimda","삼성전자","IT/네트워크",10000,"오창읍","2020-10-10","2020-10-10","1","B","", now,"4.jpg","감사합니다."));
        list.add( new BMatchDTO(1,"현직자","idimda","삼성전자","IT/네트워크",10000,"오창읍","2020-10-10","2020-10-10","1","C","", now,"5.jpg","감사합니다"));
        list.add( new BMatchDTO(1,"현직자","idimda","삼성전자","IT/네트워크",10000,"오창읍","2020-10-10","2020-10-10","1","A","", now,"6.jpg","감사합니다."));
        mypage_edit_state_recyc.setAdapter(myMatchAdapter);
//////////adapter 리스너 정의//////
        myMatchAdapter.setOnItemClickListner(new OnMyMatchItemClickListener() {
            @Override
            public void onItemClick(MyMatchAdapter.ViewHolder viewHolder, View view, int position,int btn) {
                if(btn == AppConstants.ADAPTER_BTN_OK){
                    BMatchDTO item = myMatchAdapter.getItem(position);
                    Intent intent = new Intent(context, PopOkMatching.class);
                    intent.putExtra("matchitem",item);
                    startActivity(intent);
                }else if(btn == AppConstants.ADAPTER_BTN_REVIEW){
                    BMatchDTO item = myMatchAdapter.getItem(position);
                    Intent intent = new Intent(context, PopReview.class);
                    intent.putExtra("matchitem",item);
                    startActivity(intent);
                }
            }
        });
    }
    public void SettingRequestRecyc(){
        ArrayList<MatchDTO> list = new ArrayList<MatchDTO>();
        requestAdapter.setItems(list);
//       수정필요
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
//        수정필요
        list.add( new MatchDTO(1,2,"idimda","1","2020-10-01","2020-10-01","2020-11-11","A","00전자 매칭요청"));
        list.add( new MatchDTO(1,2,"idimda","1","2020-10-01","2020-10-01","2020-11-11","B","00전자 매칭요청"));
        list.add( new MatchDTO(1,2,"idimda","1","2020-10-01","2020-10-01","2020-11-11","C","00전자 매칭요청"));
        list.add( new MatchDTO(1,2,"idimda","1","2020-10-01","2020-10-01","2020-11-11","D","00전자 매칭요청"));
        mypage_requset_state_recyc.setAdapter(requestAdapter);
//////////adapter 리스너 정의//////
        requestAdapter.setOnItemClickListner(new OnRequestMatchItemClickListener() {
            @Override
            public void onItemClick(RequestMatchAdapter.ViewHolder viewHolder, View view, int position, int btn) {
                if(btn == AppConstants.ADAPTER_BTN_CANCEL){
                    MatchDTO item = requestAdapter.getItem(position);
                    Intent intent = new Intent(context, PopCancelChk.class);
                    intent.putExtra("matchitem",item);
                    startActivity(intent);
                }else if(btn == AppConstants.ADAPTER_BTN_REVIEW){
                    MatchDTO item = requestAdapter.getItem(position);
                    Intent intent = new Intent(context, PopReview.class);
                    intent.putExtra("matchitem",item);
                    startActivity(intent);
                }
            }
        });
    }
}