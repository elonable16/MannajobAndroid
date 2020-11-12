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

}
