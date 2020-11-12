package com.ateam.mannajob.serivce;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ateam.mannajob.R;
import com.ateam.mannajob.mypage.PopPasswdCheck;


public class Service extends Fragment {
    Context context;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (context != null) {
            context = null;
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

    }
}