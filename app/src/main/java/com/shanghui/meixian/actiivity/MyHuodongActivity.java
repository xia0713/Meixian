package com.shanghui.meixian.actiivity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.base.BaseNetActivity;

import butterknife.InjectView;
import butterknife.OnClick;

public class MyHuodongActivity extends BaseNetActivity {
    @InjectView(R.id.back_layout)
    LinearLayout backLayout;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.lv_content)
    ListView lvContent;
    @InjectView(R.id.tv_show)
    TextView tvShow;
    @InjectView(R.id.ll_no_content)
    LinearLayout llNoContent;

    @Override
    public int initContentView() {
        return R.layout.activity_my_huodong;
    }

    @Override
    public void setData() {
        titleText.setText("我的活动");
    }


    @OnClick({R.id.back_layout, R.id.tv_show})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_layout:
                finish();
                break;
            case R.id.tv_show:
                break;
        }
    }
}
