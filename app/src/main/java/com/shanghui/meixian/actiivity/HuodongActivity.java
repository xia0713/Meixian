package com.shanghui.meixian.actiivity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.adapter.ViewPagerAdpater;
import com.shanghui.meixian.base.BaseActivity;
import com.shanghui.meixian.fragment.HuodongFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

public class HuodongActivity extends BaseActivity {
    @InjectView(R.id.back_layout)
    LinearLayout backLayout;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.ll_recent)
    LinearLayout llRecent;
    @InjectView(R.id.ll_ago)
    LinearLayout llAgo;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;

    private List<Fragment> fragmentList;
    private ViewPagerAdpater adapter;

    @Override
    public int initContentView() {
        return R.layout.activity_huodong;
    }

    @Override
    public void setData() {
        titleText.setText("活动平台");
        fragmentList = new ArrayList<>();

        HuodongFragment recentFragment = new HuodongFragment();
        HuodongFragment agoFragment = new HuodongFragment();
        fragmentList.add(recentFragment);
        fragmentList.add(agoFragment);

        adapter = new ViewPagerAdpater(getSupportFragmentManager(), fragmentList, null);
        viewpager.setAdapter(adapter);
    }

    @Override
    public void initListener() {
        super.initListener();
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    llRecent.setSelected(true);
                    llAgo.setSelected(false);
                } else {
                    llRecent.setSelected(false);
                    llAgo.setSelected(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.back_layout, R.id.ll_recent, R.id.ll_ago})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_layout:
                finish();
                break;
            case R.id.ll_recent:
                viewpager.setCurrentItem(0);
                llRecent.setSelected(true);
                llAgo.setSelected(false);
                break;
            case R.id.ll_ago:
                viewpager.setCurrentItem(1);
                llRecent.setSelected(false);
                llAgo.setSelected(true);
                break;
        }
    }
}
