package com.shanghui.meixian.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.http.bean.HuiyuanBean;

import java.util.List;

public class HuiyuanAdapter extends BaseAdapter {
    private Context mContext;
    private List<HuiyuanBean> huiyuanBeans;
    public HuiyuanAdapter(Context mContext, List<HuiyuanBean> huiyuanBeans) {
        this.mContext=mContext;
        this.huiyuanBeans=huiyuanBeans;
    }

    @Override
    public int getCount() {
        return huiyuanBeans.size();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_huiyuan, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(position, (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(int position, ViewHolder holder) {
        //TODO implement
    }

    protected class ViewHolder {
        private TextView tvName;
        private TextView tvZhiwei;
        private TextView tvCompany;
        private TextView tvAddress;

        public ViewHolder(View view) {
            tvName = (TextView) view.findViewById(R.id.tv_name);
            tvZhiwei = (TextView) view.findViewById(R.id.tv_zhiwei);
            tvCompany = (TextView) view.findViewById(R.id.tv_company);
            tvAddress = (TextView) view.findViewById(R.id.tv_address);
        }
    }
}
