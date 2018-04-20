package com.shanghui.meixian.fragment;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.shanghui.meixian.R;
import com.shanghui.meixian.actiivity.HuiyuanDetailActivity;
import com.shanghui.meixian.actiivity.SearchActivity;
import com.shanghui.meixian.adapter.HuiyuanSonAdapter;
import com.shanghui.meixian.base.BaseNetFragment;
import com.shanghui.meixian.http.bean.HuiyuanSonBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

public class HuiyuanSonFragment extends BaseNetFragment {
    @InjectView(R.id.search)
    LinearLayout search;
    @InjectView(R.id.lv_content)
    PullToRefreshListView lvContent;
    @InjectView(R.id.iv_nodata)
    ImageView ivNodata;
    private int NUMPAGE = 1;
    private int COUNT = 10;
    private List<HuiyuanSonBean> huiyuanSonBeans;
    private HuiyuanSonAdapter huiyuanSonAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_huiyuan_son;
    }

    @Override
    protected void initAll() {
        huiyuanSonBeans = new ArrayList<>();
        huiyuanSonAdapter = new HuiyuanSonAdapter(mContext, huiyuanSonBeans);
        lvContent.setAdapter(huiyuanSonAdapter);
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
                Intent intent=new Intent(mContext, HuiyuanDetailActivity.class);
                startActivity(intent);
            }
        });

    }

    @OnClick(R.id.search)
    public void onViewClicked() {
        Intent intent=new Intent(mContext,SearchActivity.class);
        startActivity(intent);
    }
}
