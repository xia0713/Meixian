package com.shanghui.meixian.actiivity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.adapter.SearchContentAdapter;
import com.shanghui.meixian.base.BaseNetActivity;
import com.shanghui.meixian.http.bean.SearchContentBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

public class SearchActivity extends BaseNetActivity {
    @InjectView(R.id.back_layout)
    LinearLayout backLayout;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.ll_danwei)
    LinearLayout llDanwei;
    @InjectView(R.id.ed_search_content)
    EditText edSearchContent;
    @InjectView(R.id.iv_search)
    ImageView ivSearch;
    @InjectView(R.id.lv_content)
    ListView lvContent;
    private List<SearchContentBean> searchContentBeanList;
    private SearchContentAdapter searchContentAdapter;

    @Override
    public int initContentView() {
        return R.layout.activity_search;
    }

    @Override
    public void setData() {
        searchContentBeanList = new ArrayList<>();
        searchContentAdapter = new SearchContentAdapter(mContext, searchContentBeanList);
        lvContent.setAdapter(searchContentAdapter);
    }

    @OnClick({R.id.back_layout, R.id.ll_danwei, R.id.iv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_layout:
                finish();
                break;
            case R.id.ll_danwei:
                break;
            case R.id.iv_search:
                break;
        }
    }
}
