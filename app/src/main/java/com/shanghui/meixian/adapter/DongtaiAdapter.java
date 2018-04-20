package com.shanghui.meixian.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.http.bean.DongtaiBean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/17.
 */

public class DongtaiAdapter extends BaseAdapter {
    private Context mContext;
    private List<DongtaiBean> dongtaiList;

    public DongtaiAdapter(Context mContext, List<DongtaiBean> dongtaiList) {
        this.mContext = mContext;
        this.dongtaiList = dongtaiList;
    }

    @Override
    public int getCount() {
        return dongtaiList.size();
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_dongtai, null);
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
        private TextView tvContent;

        public ViewHolder(View view) {
            ivIcon = (ImageView) view.findViewById(R.id.iv_icon);
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
            tvContent = (TextView) view.findViewById(R.id.tv_content);
        }
    }
}
