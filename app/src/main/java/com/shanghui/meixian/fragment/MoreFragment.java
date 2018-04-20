package com.shanghui.meixian.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.shanghui.meixian.R;
import com.shanghui.meixian.actiivity.LiuyanActivity;
import com.shanghui.meixian.actiivity.RecomedActivity;
import com.shanghui.meixian.actiivity.WeiboActivity;
import com.shanghui.meixian.base.BaseFragment;

import butterknife.InjectView;
import butterknife.OnClick;

public class MoreFragment extends BaseFragment {
    @InjectView(R.id.ll_about_us)
    LinearLayout llAboutUs;
    @InjectView(R.id.ll_weibo)
    LinearLayout llWeibo;
    @InjectView(R.id.ll_liuyan)
    LinearLayout llLiuyan;
    @InjectView(R.id.ll_recomed)
    LinearLayout llRecomed;
    @InjectView(R.id.ll_share)
    LinearLayout llShare;
    @InjectView(R.id.ll_update)
    LinearLayout llUpdate;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_more;
    }

    @Override
    protected void initAll() {

    }

    @OnClick({R.id.ll_about_us, R.id.ll_weibo, R.id.ll_liuyan, R.id.ll_recomed, R.id.ll_share, R.id.ll_update})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.ll_about_us:
                break;
            case R.id.ll_weibo:
                intent = new Intent(mContext, WeiboActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_liuyan:
                intent = new Intent(mContext, LiuyanActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_recomed:
                intent = new Intent(mContext, RecomedActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_share:
                break;
            case R.id.ll_update:
                break;
        }
    }
}
