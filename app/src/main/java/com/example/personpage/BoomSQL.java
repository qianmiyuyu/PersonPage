package com.example.personpage;

import android.app.Application;
import android.content.Context;

import cn.bmob.v3.Bmob;

public class BoomSQL extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        Bmob.initialize(this, "03de14ff4bda451ee3108a1070c21129");
    }
    public static Context getContext(){
        return context;
    }
}
