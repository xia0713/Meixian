package com.shanghui.meixian.http.inter;

import retrofit2.Response;

public interface HttpResponseListener<T> {

    /**
     * 网络请求之前
     */
    void onStart();

    /**
     * 请求成功并且返回有数据
     */
    void onSuccess(T response);

    /**
     * 请求成功 （暂无数据、系统异常等）
     */
    void onFailure(String failMessage);

    void onFinish();

    void onNoNetWork();
}
