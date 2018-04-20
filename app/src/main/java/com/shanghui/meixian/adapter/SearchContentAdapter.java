package com.shanghui.meixian.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.http.bean.SearchContentBean;

import java.util.List;

public class SearchContentAdapter extends BaseAdapter {
    private Context mContext;
    private List<SearchContentBean> searchContentBeanList;

    public SearchContentAdapter(Context mContext, List<SearchContentBean> searchContentBeanList) {
        this.mContext = mContext;
        this.searchContentBeanList = searchContentBeanList;
    }

    @Override
    public int getCount() {
        return searchContentBeanList.size();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_search_content, null);
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
        private ImageView ivDelete;

        public ViewHolder(View view) {
            tvName = (TextView) view.findViewById(R.id.tv_name);
            ivDelete = (ImageView) view.findViewById(R.id.iv_delete);
        }
    }
}
