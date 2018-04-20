package com.shanghui.meixian.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.shanghui.meixian.R;
import com.shanghui.meixian.actiivity.HuodongDetailActivity;
import com.shanghui.meixian.adapter.HuodongAdapter;
import com.shanghui.meixian.base.BaseNetFragment;
import com.shanghui.meixian.http.bean.HuodongBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

public class HuodongFragment extends BaseNetFragment {
    @InjectView(R.id.lv_content)
    PullToRefreshListView lvContent;
    @InjectView(R.id.iv_nodata)
    ImageView ivNodata;
    private int NUMPAGE = 1;
    private int COUNT = 10;
    private List<HuodongBean> huodongBeans;
    private HuodongAdapter huodongAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initAll() {
        huodongBeans = new ArrayList<>();
        huodongAdapter = new HuodongAdapter(mContext, huodongBeans);
        lvContent.setAdapter(huodongAdapter);
        getNoticeData();
    }

    public void getNoticeData() {

    }


    @Override
    public void initListener() {
        initListview();
    }

    public void initListview() {
        //设置可上拉刷新和下拉刷新
        lvContent.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        //设置刷新时显示的文本
        final ILoadingLayout startLayout = lvContent.getLoadingLayoutProxy(true, false);
        startLayout.setPullLabel("下拉刷新...");
        startLayout.setRefreshingLabel("正在加载中...");
        startLayout.setReleaseLabel("放开刷新");

        ILoadingLayout endLayout = lvContent.getLoadingLayoutProxy(false, true);
        endLayout.setPullLabel("上拉加载更多...");
        endLayout.setRefreshingLabel("正在加载中...");
        endLayout.setReleaseLabel("放开加载");

        lvContent.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {


            }
        });
        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//position-1;
                Intent intent = new Intent(mContext, HuodongDetailActivity.class);
                startActivity(intent);
            }
        });

    }
}
