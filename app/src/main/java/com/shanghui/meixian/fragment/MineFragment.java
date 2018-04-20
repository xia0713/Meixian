package com.shanghui.meixian.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.actiivity.ChangePassWordActivity;
import com.shanghui.meixian.actiivity.MyCodeActivity;
import com.shanghui.meixian.actiivity.MyHuodongActivity;
import com.shanghui.meixian.actiivity.ProductActivity;
import com.shanghui.meixian.base.BaseNetFragment;

import butterknife.InjectView;
import butterknife.OnClick;

public class MineFragment extends BaseNetFragment {
    @InjectView(R.id.iv_head)
    ImageView ivHead;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_zhiwei)
    TextView tvZhiwei;
    @InjectView(R.id.tv_company)
    TextView tvCompany;
    @InjectView(R.id.ll_huodong)
    LinearLayout llHuodong;
    @InjectView(R.id.ll_xiaoxi)
    LinearLayout llXiaoxi;
    @InjectView(R.id.ll_code)
    LinearLayout llCode;
    @InjectView(R.id.ll_card)
    LinearLayout llCard;
    @InjectView(R.id.ll_danwei)
    LinearLayout llDanwei;
    @InjectView(R.id.ll_zixun)
    LinearLayout llZixun;
    @InjectView(R.id.ll_product)
    LinearLayout llProduct;
    @InjectView(R.id.ll_password)
    LinearLayout llPassword;
    @InjectView(R.id.tv_sign_out)
    TextView tvSignOut;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initAll() {

    }

    @OnClick({R.id.ll_huodong, R.id.ll_xiaoxi, R.id.ll_code, R.id.ll_card, R.id.ll_danwei, R.id.ll_zixun, R.id.ll_product, R.id.ll_password, R.id.tv_sign_out})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.ll_huodong:
                intent = new Intent(mContext, MyHuodongActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_xiaoxi:
                break;
            case R.id.ll_code:
                intent = new Intent(mContext, MyCodeActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_card:
                break;
            case R.id.ll_danwei:
                break;
            case R.id.ll_zixun:
                break;
            case R.id.ll_product:
                intent = new Intent(mContext, ProductActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_password:
                intent=new Intent(mContext,ChangePassWordActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_sign_out:
                break;
        }
    }
}
