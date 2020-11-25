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
    public static SimpleDateFormat dateFormat6 = new SimpleDateFormat("yyyy-MM");

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
    public static final int MEMBERCHECK = 102;
    public static final int MEMBERJOIN = 103;
    public static final int APIJOIN = 104;
    public static final int GOMATCHREQUSET = 105;
    public static final int GOCOMPL = 106;
    public static final int COMPLINSERT = 107;
    public static final int MATCHDATA = 110;
    public static final int SEARCHMATCH = 111;
    public static final int NOTICEDATA = 120;
    public static final int QNADATA = 121;
    public static final int MYPROFILE = 131;
    public static final int BMATCHLIST = 132;
    public static final int MATCHLIST = 133;
    public static final int MONTHMATCH = 141;
    public static final int MONTHBMATCH = 142;


}
