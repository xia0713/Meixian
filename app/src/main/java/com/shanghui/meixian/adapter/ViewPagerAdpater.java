package com.shanghui.meixian.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WeiChao.Xia on 2017/3/9.
 */
public class ViewPagerAdpater extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<String> titleList;

    public ViewPagerAdpater(FragmentManager supportFragmentManager, List<Fragment> fragments, List<String> titleList) {
        super(supportFragmentManager);
        if (fragments == null) {
            this.fragments = new ArrayList<>();
        } else {
            this.fragments = fragments;
        }
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {

        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(titleList==null||titleList.size()<position+1){
            return null;
        }
        return titleList.get(position);
    }
}
