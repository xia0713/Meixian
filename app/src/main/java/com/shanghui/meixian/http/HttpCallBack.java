package com.shanghui.meixian.http;

import android.content.Context;
import android.widget.Toast;
import com.shanghui.meixian.http.inter.HttpResponseListener;
import com.shanghui.meixian.util.LoadingDialogUitl;


/**
 * Created by Administrator on 2018/4/13.
 */

public abstract class HttpCallBack<T> implements HttpResponseListener<T> {

    private LoadingDialogUitl mDialogUitl;
    private Context mContext;

    public HttpCallBack(Context mContext) {
        this.mContext = mContext;
        mDialogUitl = new LoadingDialogUitl(this.mContext);
    }

    public void showDialog() {
        if (mDialogUitl == null) {
            mDialogUitl = new LoadingDialogUitl(this.mContext);
        }

        if (!mDialogUitl.isShowing())
            mDialogUitl.showDialog();
    }

    public void closeDialog() {
        if (mDialogUitl != null && mDialogUitl.isShowing())
            mDialogUitl.closedDialog();
    }

    public void showToast(String str) {
        Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        showDialog();
    }

    @Override
    public void onFinish() {
        closeDialog();
    }

    @Override
    public void onNoNetWork() {
        showToast("没有网络，请连接WiFi或开启数据");
    }
}
