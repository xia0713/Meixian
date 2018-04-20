package com.shanghui.meixian.actiivity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.base.BaseNetActivity;

import butterknife.InjectView;
import butterknife.OnClick;

public class HuiyuanDetailActivity extends BaseNetActivity {
    @InjectView(R.id.back_layout)
    LinearLayout backLayout;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.right_image)
    ImageView rightImage;
    @InjectView(R.id.iv_share)
    ImageView ivShare;
    @InjectView(R.id.iv_icon)
    ImageView ivIcon;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_phone)
    TextView tvPhone;
    @InjectView(R.id.iv_call)
    ImageView ivCall;
    @InjectView(R.id.tv_address)
    TextView tvAddress;
    @InjectView(R.id.iv_address)
    ImageView ivAddress;
    @InjectView(R.id.tv_tag)
    TextView tvTag;
    @InjectView(R.id.iv_tag)
    ImageView ivTag;
    @InjectView(R.id.line_jianjie)
    View lineJianjie;
    @InjectView(R.id.ll_jianjie)
    LinearLayout llJianjie;
    @InjectView(R.id.line_chanpin)
    View lineChanpin;
    @InjectView(R.id.ll_chanpin)
    LinearLayout llChanpin;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    public int initContentView() {
        return R.layout.activity_huiyuan_detail;
    }

    @Override
    public void setData() {
    }

    @OnClick({R.id.back_layout, R.id.right_image, R.id.iv_share, R.id.iv_call, R.id.iv_address, R.id.iv_tag, R.id.ll_jianjie, R.id.ll_chanpin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_layout:
                break;
            case R.id.right_image:
                break;
            case R.id.iv_share:
                break;
            case R.id.iv_call:
                break;
            case R.id.iv_address:
                break;
            case R.id.iv_tag:
                break;
            case R.id.ll_jianjie:
                break;
            case R.id.ll_chanpin:
                break;
        }
    }
}
