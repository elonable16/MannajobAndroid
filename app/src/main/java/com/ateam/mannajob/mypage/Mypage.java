package com.ateam.mannajob.mypage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ateam.mannajob.AppConstants;
import com.ateam.mannajob.MainActivity;
import com.ateam.mannajob.OnFragmentItemSelectedListener;
import com.ateam.mannajob.R;
import com.ateam.mannajob.match.Matching;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;
import lib.kingja.switchbutton.SwitchMultiButton;


public class Mypage extends Fragment implements MainActivity.onKeyBackPressedListener {
    CircleImageView profileImage;
    TextView mypageID;
    TextView mypageName;
    TextView mypagePhone;
    TextView mypageEmail;


    Context context;
    Button update_profile_btn;
    OnFragmentItemSelectedListener listener;
    SwitchMultiButton switchMultiButton;
    FrameLayout container;
    int switchpostion;

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


        return rootView;
    }

    private  void  initUI(ViewGroup rootview) {
        mypageID =rootview.findViewById(R.id.mypage_ID);
        mypageName= rootview.findViewById(R.id.mypageName);
        mypagePhone= rootview.findViewById(R.id.mypage_phone);
        mypageEmail= rootview.findViewById(R.id.mypage_email);
        profileImage = rootview.findViewById(R.id.profile_image);
        update_profile_btn = rootview.findViewById(R.id.update_profile_btn);
        SettingDisplay();
        update_profile_btn.setOnClickListener(v -> {
            Intent intent = new Intent(context,PopPasswdCheck.class);
            startActivityForResult(intent,101);
        });
        container = rootview.findViewById(R.id.container_mypage);
        switchMultiButton = rootview.findViewById(R.id.mypage_switchButton);
        switchMultiButton.setOnSwitchListener(new SwitchMultiButton.OnSwitchListener() {
              @Override
              public void onSwitch(int position, String tabText) {
                  if (position == 0) {
                      listener.onTabSelected(AppConstants.FRAGMENT_CALENDAR,null);
                  } else if (position == 1) {
                      listener.onTabSelected(AppConstants.FRAGMENT_MATCHINGMANGER,null);
                  }
                  switchpostion = position;
              }
        });

    }
    public void SettingDisplay(){
        mypageID.setText("");
        mypageName.setText("");
        mypagePhone.setText("");
        mypageEmail.setText("");
        MainActivity activity = new MainActivity();
//        activity.getImageToServer(profileImage, .getProfileImage());
    }

    @Override
    public void onResume() {
        super.onResume();
        if (switchpostion == 0) {
            listener.onTabSelected(AppConstants.FRAGMENT_CALENDAR,null);
        } else if (switchpostion == 1) {
            listener.onTabSelected(AppConstants.FRAGMENT_MATCHINGMANGER,null);
        }
    }

    @Override
    public void onBackKey() {
        goToMain();
    }

    //프래그먼트 종료
    private void goToMain(){
        FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(Mypage.this).commit();
        fragmentManager.popBackStack();
    }
}