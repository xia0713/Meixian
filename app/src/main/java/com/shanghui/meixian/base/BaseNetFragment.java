package com.shanghui.meixian.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shanghui.meixian.http.HttpCallBack;
import com.shanghui.meixian.http.RetrofitUtil;
import com.shanghui.meixian.http.inter.ApiService;
import com.shanghui.meixian.util.NetUtil;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/4/11.
 */

public abstract class BaseNetFragment extends BaseFragment {
    private ApiService apiService;
    public ApiService getApiService() {
        if (apiService == null) {
            apiService = RetrofitUtil.getInstance().create(ApiService.class);
        }
        return apiService;
    }

    //异步请求
    public <T> Call<T> RequestWithEnqueue(Call<T> call, final HttpCallBack<T> httpCallBack) {

        if (!NetUtil.isNetworkAvailable(mContext)) {
            httpCallBack.onNoNetWork();
            return call;
        }
        httpCallBack.onStart();

        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.isSuccessful()) {//
                    httpCallBack.onSuccess(response.body());
                    httpCallBack.onFinish();
                } else {//失败响应
                    onFailure(call, new RuntimeException("response error,detail = " + response.raw().toString()));
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                if (t instanceof SocketTimeoutException) {
                    //
                    showToast("网络连接超时");
                } else if (t instanceof ConnectException) {
                    //
                    showToast("连接异常");
                } else if (t instanceof RuntimeException) {
                    //
                    showToast("请求失败");
                }
                httpCallBack.onFailure(t.getMessage());
                httpCallBack.onFinish();
            }
        });

        return call;

    }
}
