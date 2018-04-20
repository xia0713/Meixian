package com.shanghui.meixian.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.http.bean.HuodongBean;

import java.util.List;

public class HuodongAdapter extends BaseAdapter {
    private Context mContext;
    private List<HuodongBean> huodongBeanList;

    public HuodongAdapter(Context mContext, List<HuodongBean> huodongBeanList) {
        this.mContext = mContext;
        this.huodongBeanList = huodongBeanList;
    }

    @Override
    public int getCount() {
        return huodongBeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_huodong, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(position, (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(int position, ViewHolder holder) {
        //TODO implement
    }

    protected class ViewHolder {
        private TextView tvTitle;
        private ImageView ivIcon;
        private TextView tvPlaceName;
        private TextView tvDate;
        private TextView tvLocal;
        private TextView tvNum;
        private TextView tvState;

        public ViewHolder(View view) {
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
            ivIcon = (ImageView) view.findViewById(R.id.iv_icon);
            tvPlaceName = (TextView) view.findViewById(R.id.tv_place_name);
            tvDate = (TextView) view.findViewById(R.id.tv_date);
            tvLocal = (TextView) view.findViewById(R.id.tv_local);
            tvNum = (TextView) view.findViewById(R.id.tv_num);
            tvState = (TextView) view.findViewById(R.id.tv_state);
        }
    }
}
