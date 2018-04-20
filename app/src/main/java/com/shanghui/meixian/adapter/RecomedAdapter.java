package com.shanghui.meixian.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.http.bean.RecomedBean;

import java.util.List;

public class RecomedAdapter extends BaseAdapter {
    private Context mContext;
    private List<RecomedBean> recomedBeans;

    public RecomedAdapter(Context mContext, List<RecomedBean> recomedBeans) {
        this.mContext = mContext;
        this.recomedBeans = recomedBeans;
    }

    @Override
    public int getCount() {
        return 0;
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_recomed, null);
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
        private TextView tvName;
        private TextView tvCompany;
        private ImageView ivDownload;

        public ViewHolder(View view) {
            ivIcon = (ImageView) view.findViewById(R.id.iv_icon);
            tvName = (TextView) view.findViewById(R.id.tv_name);
            tvCompany = (TextView) view.findViewById(R.id.tv_company);
            ivDownload = (ImageView) view.findViewById(R.id.iv_download);
        }
    }
}
