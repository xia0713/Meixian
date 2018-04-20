package com.shanghui.meixian.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.http.bean.HuiyuanSonBean;

import java.util.List;

public class HuiyuanSonAdapter extends BaseAdapter {
    private Context mContext;
    private List<HuiyuanSonBean> huiyuanSonBeans;

    public HuiyuanSonAdapter(Context mContext, List<HuiyuanSonBean> huiyuanSonBeans) {
        this.mContext = mContext;
        this.huiyuanSonBeans = huiyuanSonBeans;
    }

    @Override
    public int getCount() {
        return huiyuanSonBeans.size();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_huiyuan_son, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(position, (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(int position, ViewHolder holder) {
        //TODO implement
    }

    protected class ViewHolder {
        private ImageView ivIcon;
        private TextView tvTitle;
        private TextView tvPhone;
        private TextView tvAddress;

        public ViewHolder(View view) {
            ivIcon = (ImageView) view.findViewById(R.id.iv_icon);
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
            tvPhone = (TextView) view.findViewById(R.id.tv_phone);
            tvAddress = (TextView) view.findViewById(R.id.tv_address);
        }
    }
}
