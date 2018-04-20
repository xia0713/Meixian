package com.shanghui.meixian.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by Sam on 2018/4/3.
 */

public class BaseApplication extends Application {

    private static volatile BaseApplication application;
    // 上下文
    private static Context mContext;

    public static BaseApplication getInstance() {
        if (application == null) {
            synchronized (BaseApplication.class){
                if (application==null){
                    application = new BaseApplication();
                }
            }
        }
        return application;
    }

    public Context getmContext() {
        return mContext;
    }

    // 最低版本大于21时（5.0系统）可以去掉MultiDex的使用
    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //you must install multiDex whatever tinker is installed!
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

    }
}
