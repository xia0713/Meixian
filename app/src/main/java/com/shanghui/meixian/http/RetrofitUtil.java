package com.shanghui.meixian.http;

import com.shanghui.meixian.config.Contance;
import com.shanghui.meixian.http.inter.HttpResponseListener;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private static volatile RetrofitUtil instance;
    private Retrofit retrofit;

    public RetrofitUtil() {
//        OkHttpClient client = new OkHttpClient.Builder().
//                connectTimeout(10, TimeUnit.SECONDS).
//                readTimeout(10, TimeUnit.SECONDS).
//                writeTimeout(10, TimeUnit.SECONDS).build();

        //1.创建Retrofit对象
        retrofit = new Retrofit.Builder().baseUrl(Contance.baseUrl) // 定义访问的主机地址
//                .client(client)
                .addConverterFactory(GsonConverterFactory.create())  //解析方法
                .build();
    }

    public static RetrofitUtil getInstance() {
        if (instance == null) {
            synchronized (RetrofitUtil.class) {
                if (instance == null) {
                    instance = new RetrofitUtil();
                }
            }
        }
        return instance;
    }


    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }


    public <T> Call<T> enqueue(Call<T> call, final HttpResponseListener<T> httpResponseListener) {

        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.raw().code() == 200) {//200是服务器有合理响应
                    httpResponseListener.onSuccess(response.body());
                } else {//失败响应
                    onFailure(call, new RuntimeException("response error,detail = " + response.raw().toString()));
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                if (t instanceof SocketTimeoutException) {
                    //
                } else if (t instanceof ConnectException) {
                    //
                } else if (t instanceof RuntimeException) {
                    //
                }
                httpResponseListener.onFailure(t.getMessage());
            }
        });

        return call;
    }


}
