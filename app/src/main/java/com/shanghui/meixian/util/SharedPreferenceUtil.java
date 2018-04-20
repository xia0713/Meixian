package com.shanghui.meixian.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sam on 2018/4/3.
 */

public class SharedPreferenceUtil {
    public final String SHAREDPREFERENCES = "PROJECT";
    public static final String User_ID = "useID";


    private static volatile SharedPreferenceUtil instance;
    private SharedPreferences preferences;


    private SharedPreferenceUtil(Context context) {
        preferences = context.getSharedPreferences(SHAREDPREFERENCES, Context.MODE_PRIVATE);
    }

    public static SharedPreferenceUtil getInstance(Context context) {
        if (instance == null) {
            synchronized (SharedPreferenceUtil.class) {
                if (instance == null) {
                    instance = new SharedPreferenceUtil(context);
                }
            }
        }
        return instance;
    }

    /**
     * 获取REFRENCE文件中的值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T getPreferences(String key, T defaultValue) {
        if (defaultValue instanceof Integer) {
            return (T) new Integer(preferences.getInt(key, (Integer) defaultValue));
        } else if (defaultValue instanceof String) {
            return (T) preferences.getString(key, (String) defaultValue);
        } else if (defaultValue instanceof Boolean) {
            return (T) new Boolean(preferences.getBoolean(key, (Boolean) defaultValue));
        } else if (defaultValue instanceof Long) {
            return (T) new Long(preferences.getLong(key, (Long) defaultValue));
        } else if (defaultValue instanceof Float) {
            return (T) new Float(preferences.getFloat(key, (Float) defaultValue));
        } else if (defaultValue instanceof Set) {
            return (T) new HashSet<String>(preferences.getStringSet(key, (Set<String>) defaultValue));
        } else {
            return null;
        }
    }

    /**
     * 保存值到REFRENCE文件
     *
     * @param key
     * @param value
     */
    public void setPreferences(String key, Object value) {
        final SharedPreferences.Editor editor = preferences.edit();
        if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Set) {
            editor.putStringSet(key, (Set<String>) value);
        }
        editor.commit();
    }
}
