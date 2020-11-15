package com.ateam.mannajob;

import android.os.Handler;
import android.util.Log;

import java.text.SimpleDateFormat;

public class AppConstants {

//    public static final int REQ_LOCATION_BY_ADDRESS = 101;


    public static SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmm");
    public static SimpleDateFormat dateFormat2 = new SimpleDateFormat("YYYY-MM-dd HH시");
    public static SimpleDateFormat dateFormat3 = new SimpleDateFormat("MM월 dd일");
    public static SimpleDateFormat dateFormat4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat dateFormat5 = new SimpleDateFormat("yyyy-MM-dd");

    public static final int FRAGMENT_MATCH = 1;
    public static final int FRAGMENT_SERVICE = 2;
    public static final int FRAGMENT_MYPAGE = 3;
    public static final int FRAGMENT_BOARD_MATCH = 4;
    public static final int FRAGMENT_BOARD_QNA = 5;
    public static final int FRAGMENT_BOARD_NOTICE = 6;
    public static final int FRAGMENT_CALENDAR = 7;
    public static final int FRAGMENT_MATCHINGMANGER = 8;
    public static final int ADAPTER_BTN_OK = 1001;
    public static final int ADAPTER_BTN_REVIEW = 1002;
    public static final int ADAPTER_BTN_CANCEL = 1003;
    public static final String CANCEL = "취소";
    public static final String PROCEEDING = "대기";
    public static final String FINISH = "완료";
    public static final String REQUEST = "요청";
    public static final String REJECT = "거절";
    public static final String URL = "http://192.168.0.225:8080/";


    public static final int LOGINCHECK = 101;

}
