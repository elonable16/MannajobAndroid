package com.ateam.mannajob.mypage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.ateam.mannajob.AppConstants;
import com.ateam.mannajob.OnFragmentItemSelectedListener;
import com.ateam.mannajob.R;


public class Mypage extends Fragment {

    Context context;
    Button update_profile_btn;
    OnFragmentItemSelectedListener listener;

    FrameLayout container;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof OnFragmentItemSelectedListener) {
            listener = (OnFragmentItemSelectedListener)context;
        }

    }
    @Override
    public void onDetach(){
        super.onDetach();
        if(context!= null){
            context=null;
            listener=null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_mypage, container, false);
        initUI(rootView);

        listener.onTabSelected(AppConstants.FRAGMENT_CALENDAR,null);
        return rootView;
    }

    private  void  initUI(ViewGroup rootview) {
        update_profile_btn = rootview.findViewById(R.id.update_profile_btn);
        update_profile_btn.setOnClickListener(v -> {
            Intent intent = new Intent(context,PopPasswdCheck.class);
            startActivityForResult(intent,101);
        });
        container = rootview.findViewById(R.id.container_mypage);
    }
}