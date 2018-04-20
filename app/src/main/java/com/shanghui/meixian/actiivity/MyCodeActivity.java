package com.shanghui.meixian.actiivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.base.BaseNetActivity;

import butterknife.InjectView;
import butterknife.OnClick;

public class MyCodeActivity extends BaseNetActivity {
    @InjectView(R.id.back_layout)
    LinearLayout backLayout;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.right_image)
    ImageView rightImage;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_zhiwei)
    TextView tvZhiwei;
    @InjectView(R.id.tv_company)
    TextView tvCompany;
    @InjectView(R.id.iv_code)
    ImageView ivCode;
    @InjectView(R.id.rl_code)
    RelativeLayout rlCode;

    @Override
    public int initContentView() {
        return R.layout.activity_code;
    }

    @Override
    public void setData() {
        titleText.setText("我的二维码");
        //适配，达到宽高一致
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) rlCode.getLayoutParams();
        params.height = params.width;
        rlCode.setLayoutParams(params);
    }

    @OnClick({R.id.back_layout, R.id.right_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_layout:
                finish();
                break;
            case R.id.right_image:
                break;
        }
    }
}
