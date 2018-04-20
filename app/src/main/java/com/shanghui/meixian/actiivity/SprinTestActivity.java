package com.shanghui.meixian.actiivity;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


import com.shanghui.meixian.R;
import com.shanghui.meixian.base.BaseNetActivity;
import com.shanghui.meixian.http.HttpCallBack;
import com.shanghui.meixian.http.bean.WeatherInfoBean;

import java.util.ArrayList;

import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/4/12.
 */

public class SprinTestActivity extends BaseNetActivity {

    @InjectView(R.id.text)
    TextView text;
    @InjectView(R.id.botton)
    Button botton;
    private Response<WeatherInfoBean> execute;
    private Call<WeatherInfoBean> weather;

    @Override
    public int initContentView() {
        return R.layout.test;
    }

    @Override
    public void setData() {
        final ArrayList<String> list = new ArrayList<String>();
        list.add("苹果");
        list.add("香蕉");
        list.add("橘子");
        list.add("香蕉");
        list.add("苹果");
        list.add("香蕉");
        list.add("橘子");
        list.add("香蕉");
        list.add("苹果");
        list.add("香蕉");
        list.add("橘子");
        list.add("香蕉");
        list.add("苹果");
        list.add("香蕉");
        list.add("橘子");
        list.add("香蕉");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


//        tvResult.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sprinnerPopupWindow = new SprinnerPopupWindow(mContext, DensityUtils.dp2px(mContext, 100), DensityUtils.dp2px(mContext, 200), new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        showToast(list.get(i));
//                    }
//                }, list, 0);
//                sprinnerPopupWindow.show(tvResult);
//            }
//        });


    }

    @OnClick(R.id.botton)
    public void onViewClicked() {
        weather = getApiService().getWeather("北京", "json", "bd09ll", "6tYzTvGZSOpYB5Oc2YGGOKt8");

        RequestWithEnqueue(weather, new HttpCallBack<WeatherInfoBean>(mContext) {
            @Override
            public void onSuccess(WeatherInfoBean response) {
                Log.d("respones", "");
            }

            @Override
            public void onFailure(String failMessage) {
                Log.d("failMessage", failMessage);
            }
        });

    }
}
