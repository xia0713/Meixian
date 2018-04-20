package com.shanghui.meixian.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.adapter.ViewPagerAdpater;
import com.shanghui.meixian.base.BaseNetFragment;
import com.shanghui.meixian.views.ViewPagerIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/4/16.
 */

public class HomeFragment extends BaseNetFragment {
    @InjectView(R.id.iv_right)
    ImageView ivRight;
    @InjectView(R.id.indicator)
    ViewPagerIndicator indicator;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    private List<Fragment> fragmentList;
    private List<String> stringList;
    private ViewPagerAdpater adapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initAll() {
        fragmentList = new ArrayList<>();

        DongTaiFragment dongTaiFragment = new DongTaiFragment();
        NewsFragment newsFragment = new NewsFragment();
        fragmentList.add(dongTaiFragment);
        fragmentList.add(newsFragment);

        stringList = new ArrayList<>();
        stringList.add("商会动态");
        stringList.add("会议通知");
        stringList.add("商会新闻");
        stringList.add("我指派的");
        stringList.add("未完成");
        stringList.add("已完成");
        stringList.add("已延期");
        viewpager.setOffscreenPageLimit(fragmentList.size());
        adapter = new ViewPagerAdpater(getChildFragmentManager(), fragmentList, stringList);
        viewpager.setAdapter(adapter);
        indicator.setViewPager(viewpager);
    }

    @OnClick(R.id.iv_right)
    public void onViewClicked() {

    }
}
