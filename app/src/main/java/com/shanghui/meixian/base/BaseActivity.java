package com.shanghui.meixian.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.shanghui.meixian.R;
import com.shanghui.meixian.db.SQLHelper;
import com.shanghui.meixian.interfaces.PermissionInterFace;
import com.shanghui.meixian.util.ActivityCollectorUtil;
import com.shanghui.meixian.util.SharedPreferenceUtil;

import butterknife.ButterKnife;

/**
 * Created by Sam on 2018/4/3.
 */

public abstract class BaseActivity extends FragmentActivity implements PermissionInterFace {

    protected Context mContext;
    public String TAG;
    protected SQLHelper dbHelper;
    protected SQLiteDatabase dbHelperW;
    protected SQLiteDatabase dbHelperR;
    protected SystemBarTintManager tintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(initContentView());
        initSystemBar();
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); //透明状态栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION); //透明导航栏
        ActivityCollectorUtil.getInstance().addActivity(this);

        this.TAG = this.getClass().getSimpleName();
        mContext = this;

        dbHelper = new SQLHelper(mContext);
        dbHelperR = dbHelper.getReadableDatabase();
        dbHelperW = dbHelper.getWritableDatabase();

        // 初始化View注入
        ButterKnife.inject(this);

        setData();
        initListener();
    }

    /**
     * 初始化状态栏
     */
    protected void initSystemBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);
        if (getStatusBarTintColor() != getResources().getColor(R.color.transparent)) {
            tintManager.setStatusBarTintColor(getStatusBarTintColor());
            tintManager.setNavigationBarTintColor(getStatusBarTintColor());
        }
    }

    /**
     * @return 状态栏的颜色，子类重写这个方法即可
     */
    public int getStatusBarTintColor() {
        return getResources().getColor(R.color.themeColor);
    }


    /**
     * 设置状态栏为透明
     *
     * @param on
     */
    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        //
        if (on) {
            winParams.flags |= bits;
            // winParams.flags |=WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


    /**
     * 初始化布局
     */
    public abstract int initContentView();

    public void initListener() {
    }

    public abstract void setData();


    public SharedPreferenceUtil getSharedToolInstance() {
        return SharedPreferenceUtil.getInstance(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollectorUtil.getInstance().removeActivity(this);
    }


    public void showToast(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }


    /**
     * 关闭软键盘
     */
    protected void showSoftKeyboard() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String checkPermission = "";

    public void requestPermissions(String checkPermission, String[] requestPermission) {
        this.checkPermission = checkPermission;
        boolean isSucess = true;
        for (int i = 0; i < requestPermission.length; i++) {
            if (ContextCompat.checkSelfPermission(this, requestPermission[i]) != PackageManager.PERMISSION_GRANTED) {
                isSucess = false;
            }
        }
        if (!isSucess) {
            ActivityCompat.requestPermissions(this, requestPermission,
                    MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        } else {
            RequestPermissionsSuccess(checkPermission);
        }
    }


    public final static int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1000;

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    RequestPermissionsSuccess(checkPermission);
                } else {
                    RequestPermissionsFailed(checkPermission);
                }
                return;
            }
        }
    }

    @Override
    public void RequestPermissionsFailed(String checkPermission) {

        showToast("权限申请失败");
    }

    @Override
    public void RequestPermissionsSuccess(String checkPermission) {

    }
}

