package com.shanghui.meixian.actiivity;

import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.base.BaseNetActivity;

import butterknife.InjectView;
import butterknife.OnClick;

public class ProductActivity extends BaseNetActivity {
    @InjectView(R.id.back_layout)
    LinearLayout backLayout;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.lv_content)
    ListView lvContent;
    @InjectView(R.id.tv_no_data)
    TextView tvNoData;

    @Override
    public int initContentView() {
        return R.layout.activity_product;
    }

    @Override
    public void setData() {
        titleText.setText("产品收藏");
    }

    @OnClick(R.id.back_layout)
    public void onViewClicked() {
    }
}
