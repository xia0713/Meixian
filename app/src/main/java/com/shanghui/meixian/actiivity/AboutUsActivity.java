package com.shanghui.meixian.actiivity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.base.BaseNetActivity;

import butterknife.InjectView;
import butterknife.OnClick;

public class AboutUsActivity extends BaseNetActivity {
    @InjectView(R.id.back_layout)
    LinearLayout backLayout;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.iv_logo)
    ImageView ivLogo;
    @InjectView(R.id.tv_content)
    TextView tvContent;
    @InjectView(R.id.tv_phone)
    TextView tvPhone;
    @InjectView(R.id.iv_call)
    ImageView ivCall;
    @InjectView(R.id.iv_weibo)
    ImageView ivWeibo;
    @InjectView(R.id.iv_web)
    ImageView ivWeb;
    @InjectView(R.id.tv_address)
    TextView tvAddress;
    @InjectView(R.id.iv_address)
    ImageView ivAddress;

    @Override
    public int initContentView() {
        return R.layout.activity_about_us;
    }

    @Override
    public void setData() {
        titleText.setText("关于我们");
    }

    @OnClick({R.id.back_layout, R.id.iv_call, R.id.iv_weibo, R.id.iv_web, R.id.iv_address})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.back_layout:
                finish();
                break;
            case R.id.iv_call:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "123"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            case R.id.iv_weibo:
                break;
            case R.id.iv_web:
                break;
            case R.id.iv_address:
                intent = new Intent(mContext, AddressActivity.class);
                startActivity(intent);
                break;
        }
    }
}
