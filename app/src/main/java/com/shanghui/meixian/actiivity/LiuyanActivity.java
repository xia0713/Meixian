package com.shanghui.meixian.actiivity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.base.BaseNetActivity;

import butterknife.InjectView;
import butterknife.OnClick;

public class LiuyanActivity extends BaseNetActivity {
    @InjectView(R.id.back_layout)
    LinearLayout backLayout;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.ed_pinglun)
    EditText edPinglun;
    @InjectView(R.id.tv_send)
    TextView tvSend;

    @Override
    public int initContentView() {
        return R.layout.activity_liuyan;
    }

    @Override
    public void setData() {
        titleText.setText("留言反馈");
    }

    @OnClick({R.id.back_layout, R.id.tv_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_layout:
                finish();
                break;
            case R.id.tv_send:
                break;
        }
    }
}
