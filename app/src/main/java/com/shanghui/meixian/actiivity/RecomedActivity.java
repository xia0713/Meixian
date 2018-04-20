package com.shanghui.meixian.actiivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.adapter.RecomedAdapter;
import com.shanghui.meixian.base.BaseActivity;
import com.shanghui.meixian.http.bean.RecomedBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

public class RecomedActivity extends BaseActivity {
    @InjectView(R.id.back_layout)
    LinearLayout backLayout;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.lv_content)
    ListView lvContent;
    private List<RecomedBean> recomedBeans;
    private RecomedAdapter recomedAdapter;

    @Override
    public int initContentView() {
        return R.layout.activity_recomed;
    }

    @Override
    public void setData() {
        titleText.setText("应用推荐");
        recomedBeans = new ArrayList<>();
        recomedAdapter = new RecomedAdapter(mContext, recomedBeans);
        lvContent.setAdapter(recomedAdapter);
    }

    @Override
    public void initListener() {
        super.initListener();
        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    @OnClick(R.id.back_layout)
    public void onViewClicked() {
        finish();
    }
}
