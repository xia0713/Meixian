package com.shanghui.meixian.fragment;

import android.widget.RelativeLayout;

import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.shanghui.meixian.R;
import com.shanghui.meixian.base.BaseNetFragment;
import com.shanghui.meixian.views.BannerIndicatorView;
import com.shanghui.meixian.views.BannerView;
import com.shanghui.meixian.views.ListViewForScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by Administrator on 2018/4/17.
 */

public class DongTaiFragment extends BaseNetFragment {

    @InjectView(R.id.banner_view)
    BannerView bannerView;
    @InjectView(R.id.banner_indicator_view)
    BannerIndicatorView bannerIndicatorView;
    @InjectView(R.id.rl_banner)
    RelativeLayout rlBanner;
    @InjectView(R.id.lv_content)
    ListViewForScrollView lvContent;
    @InjectView(R.id.scroll_view)
    PullToRefreshScrollView scrollView;

    private List<String> imgUrl;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_dongtai;
    }

    @Override
    protected void initAll() {
        imgUrl = new ArrayList<>();
        bannerView.init(imgUrl, new BannerView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
        bannerView.setIndicator(bannerIndicatorView);
    }

}
