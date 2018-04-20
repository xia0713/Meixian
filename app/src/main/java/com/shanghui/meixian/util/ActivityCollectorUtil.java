package com.shanghui.meixian.util;

import android.app.Activity;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollectorUtil {
    public static List<Activity> activities = new ArrayList<Activity>();
    private static volatile ActivityCollectorUtil instance;
    /**
     * 单例模式
     * @return
     */
    public static ActivityCollectorUtil getInstance() {
        if (instance == null) {
            synchronized (ActivityCollectorUtil.class){
                if (instance==null){
                    instance = new ActivityCollectorUtil();
                }
            }
        }
        return instance;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
                activities.remove(activity);
            }
        }
    }
}
