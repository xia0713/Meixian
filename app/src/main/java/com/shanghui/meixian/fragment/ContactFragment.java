package com.shanghui.meixian.fragment;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.adapter.CityListAdapter;
import com.shanghui.meixian.base.BaseNetFragment;
import com.shanghui.meixian.http.bean.PersonBean;
import com.shanghui.meixian.views.SideLetterBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

//也可使用contactFragment1;
public class ContactFragment extends BaseNetFragment {
    @InjectView(R.id.iv_menu)
    ImageView ivMenu;
    @InjectView(R.id.search)
    LinearLayout search;
    @InjectView(R.id.lv_content)
    ListView lvContent;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.tv_letter_overlay)
    TextView tvLetterOverlay;
    @InjectView(R.id.side_letter_bar)
    SideLetterBar sideLetterBar;
    private CityListAdapter mCityAdapter;
    private List<PersonBean> personBeans;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_contact;
    }

    @Override
    protected void initAll() {
        personBeans = new ArrayList<>();
        mCityAdapter = new CityListAdapter(mContext, personBeans);
        mCityAdapter.setOnCityClickListener(new CityListAdapter.OnCityClickListener() {
            @Override
            public void onCityClick(PersonBean personBean) {

            }
        });
        lvContent.setAdapter(mCityAdapter);
        sideLetterBar.setOverlay(tvLetterOverlay);
        sideLetterBar.setOnLetterChangedListener(new SideLetterBar.OnLetterChangedListener() {
            @Override
            public void onLetterChanged(String letter) {
                int position = mCityAdapter.getLetterPosition(letter);
                lvContent.setSelection(position);
            }
        });

        lvContent.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if (i > 0) {
                    tvTitle.setVisibility(View.VISIBLE);
//                    tvTitle.setText(SourceDateList.get(i).getSortLetters());
                } else {
                    tvTitle.setVisibility(View.GONE);
                }
            }
        });
        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    @OnClick({R.id.iv_menu, R.id.search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_menu:
                break;
            case R.id.search:
                break;
        }
    }
}
