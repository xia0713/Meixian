package com.shanghui.meixian.actiivity;

import android.support.v4.app.Fragment;
import android.widget.FrameLayout;

import com.shanghui.meixian.R;
import com.shanghui.meixian.base.BaseActivity;
import com.shanghui.meixian.fragment.ContactFragment;
import com.shanghui.meixian.fragment.HomeFragment;
import com.shanghui.meixian.fragment.HuiyuanFragment;
import com.shanghui.meixian.fragment.MineFragment;
import com.shanghui.meixian.fragment.MoreFragment;
import com.shanghui.meixian.views.TabIndicator;

import java.util.ArrayList;

import butterknife.InjectView;

/**
 * Created by Administrator on 2018/4/16.
 */

public class HomeActivity extends BaseActivity {

    @InjectView(R.id.tab_indicator)
    TabIndicator tabIndicator;
    @InjectView(R.id.details_layout)
    FrameLayout detailsLayout;

    private Fragment fragmentNow;
//    private Fragment oneFragment;
//    private Fragment twoFragment;
//    private Fragment threeFragment;
//    private Fragment fourFragment;
    private ArrayList<Fragment> fragmentList;

    @Override
    public int initContentView() {
        return R.layout.activity_home;
    }

    @Override
    public void setData() {

//        oneFragment = new HomeFragment();
//        fragmentNow = oneFragment;

        fragmentList = new ArrayList<>(4);
//        fragmentList.add(oneFragment);
//        fragmentList.add(twoFragment);
//        fragmentList.add(threeFragment);
//        fragmentList.add(fourFragment);
        fragmentList.set(0, new HomeFragment());
        fragmentList.set(1, new ContactFragment());
        fragmentList.set(2, new HuiyuanFragment());
        fragmentList.set(3, new MineFragment());
        fragmentList.set(4, new MoreFragment());
        fragmentNow=fragmentList.get(0);
        getSupportFragmentManager().beginTransaction().add(R.id.details_layout, fragmentList.get(0));


        tabIndicator.setOnSelectListener(new TabIndicator.OnSelectListener() {
            @Override
            public void onSelect(int i) {
                switch (i) {
                    case 0:
                        if (fragmentList.get(i) == null)
                            fragmentList.set(i, new HomeFragment());
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
//
//                if (oneFragment == null) {
//                    oneFragment = new HomeFragment();
//                }
                if (fragmentList.get(i).isAdded()) {
                    getSupportFragmentManager().beginTransaction().hide(fragmentNow).show(fragmentList.get(i));
                } else {
                    //如果fragmentOne不存在，则隐藏当前的fragment，
                    //然后添加fragmentOne（此时是初始化）
                    getSupportFragmentManager().beginTransaction().hide(fragmentNow).add(R.id.details_layout, fragmentList.get(i));
                }
//                fragmentTransaction.addToBackStack(null);
                fragmentNow = fragmentList.get(i);
                getSupportFragmentManager().beginTransaction().commit();
            }
        });

    }

}
