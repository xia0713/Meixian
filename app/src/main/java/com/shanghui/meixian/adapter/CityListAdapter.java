package com.shanghui.meixian.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.http.bean.PersonBean;
import com.shanghui.meixian.util.PinyinUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sam_chan on 2017/7/20.
 */
public class CityListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater inflater;
    private List<PersonBean> mCities;
    private HashMap<String, Integer> letterIndexes;
    private String[] sections;
    private OnCityClickListener onCityClickListener;

    public CityListAdapter(Context mContext, List<PersonBean> mCities) {
        this.mContext = mContext;
        this.mCities = mCities;
        this.inflater = LayoutInflater.from(mContext);
        if (mCities == null) {
            mCities = new ArrayList<>();
        }
//        mCities.add(0, new City("定位", "0"));
//        mCities.add(1, new City("热门", "1"));
        int size = mCities.size();
        letterIndexes = new HashMap<>();
        sections = new String[size];
        for (int index = 0; index < size; index++) {
            //当前城市拼音首字母
            String currentLetter = PinyinUtils.getFirstLetter(mCities.get(index).getPinyin());
            //上个首字母，如果不存在设为"#"
            String previousLetter = index >= 1 ? PinyinUtils.getFirstLetter(mCities.get(index - 1).getPinyin()) : "#";
            if (!TextUtils.equals(currentLetter, previousLetter)) {
                letterIndexes.put(currentLetter, index);
                sections[index] = currentLetter;
            }
        }
    }


    /**
     * 获取字母索引的位置
     *
     * @param letter
     * @return
     */
    public int getLetterPosition(String letter) {
        Integer integer = letterIndexes.get(letter);
        return integer == null ? -1 : integer;
    }


    @Override
    public int getCount() {
        return mCities == null ? 0 : mCities.size();
    }

    @Override
    public PersonBean getItem(int position) {
        return mCities == null ? null : mCities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        CityViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.cp_item_city_listview, parent, false);
            holder = new CityViewHolder();
            holder.letter = (TextView) view.findViewById(R.id.tv_item_city_listview_letter);
            holder.name = (TextView) view.findViewById(R.id.tv_item_city_listview_name);
            view.setTag(holder);
        } else {
            holder = (CityViewHolder) view.getTag();
        }
        if (position >= 1) {
            final String city = mCities.get(position).getName();
            holder.name.setText(city);
            String currentLetter = PinyinUtils.getFirstLetter(mCities.get(position).getPinyin());
            String previousLetter = position >= 1 ? PinyinUtils.getFirstLetter(mCities.get(position - 1).getPinyin()) : "";
            if (!TextUtils.equals(currentLetter, previousLetter)) {
                holder.letter.setVisibility(View.VISIBLE);
                holder.letter.setText(currentLetter);
            } else {
                holder.letter.setVisibility(View.GONE);
            }
            holder.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onCityClickListener != null) {
                        onCityClickListener.onCityClick(mCities.get(position));
                    }
                }
            });
        }
        return view;
    }

    public static class CityViewHolder {
        TextView letter;
        TextView name;
    }

    public void setOnCityClickListener(OnCityClickListener listener) {
        this.onCityClickListener = listener;
    }

    public interface OnCityClickListener {
        void onCityClick(PersonBean personBean);
    }
}
