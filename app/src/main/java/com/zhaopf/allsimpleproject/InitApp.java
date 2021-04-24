package com.zhaopf.allsimpleproject;

import android.app.Application;
import android.content.Context;

/**
 * @创建者 赵鹏飞
 * @文件介绍 TODO
 * @创建日期 2021/4/14 21:47
 * @Github https://github.com/zhao-pf
 */
public class InitApp extends Application {
    private static InitApp instance;

    public synchronized static InitApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getContext() {
        return instance.getApplicationContext();
    }
}
