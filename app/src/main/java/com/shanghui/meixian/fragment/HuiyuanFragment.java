package com.shanghui.meixian.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.shanghui.meixian.R;
import com.shanghui.meixian.adapter.ViewPagerAdpater;
import com.shanghui.meixian.base.BaseFragment;
import com.shanghui.meixian.views.ViewPagerIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

public class HuiyuanFragment extends BaseFragment {
    @InjectView(R.id.indicator)
    ViewPagerIndicator indicator;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    private List<Fragment> fragmentList;
    private List<String> stringList;
    private ViewPagerAdpater adapter;
    @Override
    public int getContentViewId() {
        return R.layout.fragment_huiyuan;
    }

    @Override
    protected void initAll() {
        fragmentList = new ArrayList<>();

        HuiyuanSonFragment huiyuanSonFragment1 = new HuiyuanSonFragment();
        fragmentList.add(huiyuanSonFragment1);

        stringList = new ArrayList<>();
        stringList.add("全部");
        stringList.add("房地产开发");
        stringList.add("汽车");
        stringList.add("我指派的");
        stringList.add("未完成");
        stringList.add("已完成");
        stringList.add("已延期");
        viewpager.setOffscreenPageLimit(fragmentList.size());
        adapter = new ViewPagerAdpater(getChildFragmentManager(), fragmentList, stringList);
        viewpager.setAdapter(adapter);
        indicator.setViewPager(viewpager);
    }

}
