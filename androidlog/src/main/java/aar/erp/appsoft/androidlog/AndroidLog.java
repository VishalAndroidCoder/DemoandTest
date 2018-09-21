package aar.erp.appsoft.androidlog;

import android.util.Log;

public class AndroidLog {

    public static void debug(String tag, String msg){
        Log.d(tag, msg);
    }

    public static void info(String tag, String msg){
        Log.i(tag, msg);
    }

    public static void warn(String tag, String msg){
        Log.w(tag, msg);
    }

    public static void error(String tag, String msg){
        Log.e(tag, msg);
    }

    public static void verbose(String tag, String msg){
        Log.v(tag, msg);
    }
}
