package com.shanghui.meixian.base;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.shanghui.meixian.interfaces.PermissionInterFace;
import com.shanghui.meixian.util.LoadingDialogUitl;
import com.shanghui.meixian.util.SharedPreferenceUtil;

import butterknife.ButterKnife;

/**
 * Created by Sam on 2018/4/3.
 */

public abstract class BaseFragment extends Fragment implements PermissionInterFace {
    protected Context mContext;
    protected View mRootView;
    private LoadingDialogUitl mDialogUitl;
    private String TAG;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getContentViewId(), container, false);
        ButterKnife.inject(this, mRootView);//绑定framgent
        this.mContext = getActivity();
        this.TAG = this.getClass().getSimpleName();
        mDialogUitl = new LoadingDialogUitl(mContext);
        initAll();
        initListener();
        return mRootView;
    }
    /**
     * 返回布局的R.layout
     * @return
     */
    public abstract int getContentViewId();
    protected abstract void initAll();
    public void initListener() {
    }
    public void showToast(String str) {
        Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
    }

    public void showDialog() {
        mDialogUitl.showDialog();
    }

    public void closeDialog() {
        mDialogUitl.closedDialog();
    }

    public void logI(String content) {
        Log.i(TAG, content);
    }

    public void logD(String content) {
        Log.d(TAG, content);
    }

    public SharedPreferenceUtil getSharedToolInstance() {
        return SharedPreferenceUtil.getInstance(mContext);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    String checkPermission = "";

    public void requestPermissions(String checkPermission, String[] requestPermission) {
        this.checkPermission = checkPermission;
        boolean isSucess = true;
        for(int i = 0;i<requestPermission.length;i++){
            if (ContextCompat.checkSelfPermission(getContext(), requestPermission[i]) != PackageManager.PERMISSION_GRANTED) {
                isSucess = false;
            }
        }
        if (!isSucess) {
            requestPermissions(requestPermission,
                    MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        } else {
            RequestPermissionsSuccess(checkPermission);
        }
    }


    public final static int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1000;


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
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
