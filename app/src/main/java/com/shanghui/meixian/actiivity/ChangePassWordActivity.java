package com.shanghui.meixian.actiivity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.base.BaseNetActivity;

import butterknife.InjectView;
import butterknife.OnClick;

public class ChangePassWordActivity extends BaseNetActivity {
    @InjectView(R.id.back_layout)
    LinearLayout backLayout;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.tetle_tv_ok)
    TextView tetleTvOk;
    @InjectView(R.id.ed_old_password)
    EditText edOldPassword;
    @InjectView(R.id.ed_new_password)
    EditText edNewPassword;

    @Override
    public int initContentView() {
        return R.layout.activity_change_password;
    }

    @Override
    public void setData() {
        tetleTvOk.setText("完成");
        titleText.setText("修改密码");
    }

    @OnClick({R.id.back_layout, R.id.tetle_tv_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_layout:
                finish();
                break;
            case R.id.tetle_tv_ok:
                break;
        }
    }
}
