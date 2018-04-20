package com.shanghui.meixian.sort;

import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.base.BaseNetFragment;
import com.shanghui.meixian.http.bean.SortModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.InjectView;

public class ContactFragment1 extends BaseNetFragment {
    @InjectView(R.id.country_lvcountry)
    ListView sortListView;
    @InjectView(R.id.dialog)
    TextView dialog;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.sidrbar)
    SideBar sidrbar;
    /**
     * 汉字转换成拼音的类
     */
    private CharacterParser characterParser;
    private List<SortModel> SourceDateList;

    /**
     * 根据拼音来排列ListView里面的数据类
     */
    private PinyinComparator pinyinComparator;
    private SortAreaAdapter adapter;
    private List<AreaBean> list_Hotprovince=new ArrayList<>();
    private String[] date={};
    private String[] id={};

    @Override
    public int getContentViewId() {
        return R.layout.fragment_contact1;
    }

    @Override
    protected void initAll() {
//实例化汉字转拼音类
        characterParser = CharacterParser.getInstance();
        pinyinComparator = new PinyinComparator();
        sidrbar.setTextView(dialog);
        //设置右侧触摸监听
        sidrbar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    sortListView.setSelection(position);
                }
            }
        });
        sortListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //这里要利用adapter.getItem(position)来获取当前position所对应的对象
            }
        });
        sortListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if (i > 0) {
                    tvTitle.setVisibility(View.VISIBLE);
                    tvTitle.setText(SourceDateList.get(i).getSortLetters());
                } else {
                    tvTitle.setVisibility(View.GONE);
                }
            }
        });
        SourceDateList = filledData(date);
        // 根据a-z进行排序源数据
        Collections.sort(SourceDateList, pinyinComparator);
        SortModel model = new SortModel();

        model.setBeen(list_Hotprovince);
        model.setName("1");
        model.setSortLetters("0");

        SourceDateList.add(0, model);
        adapter = new SortAreaAdapter(mContext, SourceDateList);
        sortListView.setAdapter(adapter);
    }
    /**
     * 为ListView填充数据
     *
     * @param date
     * @return
     */
    private List<SortModel> filledData(String[] date) {
        List<SortModel> mSortList = new ArrayList<SortModel>();

        for (int i = 0; i < date.length; i++) {
            SortModel sortModel = new SortModel();
            sortModel.setName(date[i]);
            sortModel.setId(id[i]);
            //汉字转换成拼音
            String pinyin = characterParser.getSelling(date[i]);
            String sortString = pinyin.substring(0, 1).toUpperCase();

            if (!TextUtils.isEmpty(sortString)) {
                // 正则表达式，判断首字母是否是英文字母
                if (sortString.matches("[A-Z]")) {
                    sortModel.setSortLetters(sortString.toUpperCase());
                } else {
                    sortModel.setSortLetters("#");
                }
                mSortList.add(sortModel);
            }
        }
        return mSortList;

    }

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<SortModel> filterDateList = new ArrayList<SortModel>();

        if (TextUtils.isEmpty(filterStr)) {
            filterDateList = SourceDateList;
        } else {
            filterDateList.clear();
            for (SortModel sortModel : SourceDateList) {
                String name = sortModel.getName();
                if (name.indexOf(filterStr.toString()) != -1 || characterParser.getSelling(name).startsWith(filterStr.toString())) {
                    filterDateList.add(sortModel);
                }
            }
        }
        // 根据a-z进行排序
        Collections.sort(filterDateList, pinyinComparator);
        adapter.updateListView(filterDateList, filterStr);
    }
}
