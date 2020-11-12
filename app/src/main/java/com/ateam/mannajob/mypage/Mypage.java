package com.ateam.mannajob.mypage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ateam.mannajob.R;


public class Mypage extends Fragment {

    Context context;
    Button update_profile_btn;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
    @Override
    public void onDetach(){
        super.onDetach();
        if(context!= null){
            context=null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_mypage, container, false);
        initUI(rootView);
        return rootView;
    }
    private  void  initUI(ViewGroup rootview) {
        update_profile_btn = rootview.findViewById(R.id.update_profile_btn);
        update_profile_btn.setOnClickListener(v -> {
            Intent intent = new Intent(context,PopPasswdCheck.class);
            startActivityForResult(intent,101);
        });
    }
}