package com.shanghui.meixian.sort;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.http.bean.SortModel;

import java.util.List;

public class SortAreaAdapter extends BaseAdapter implements SectionIndexer {
    private List<SortModel> list = null;
    private Context mContext;
    private static final int BANNER = 0;
    private static final int ONE = 1;
    private List<AreaBean> been;
    private boolean flag = false;//是否为搜索状态

    public SortAreaAdapter(Context mContext, List<SortModel> list) {
        this.mContext = mContext;
        this.list = list;
        been = list.get(0).getBeen();
    }

    public void updateListView(List<SortModel> list, String str) {
        this.list = list;
        if (TextUtils.isEmpty(str)) {
            this.flag = false;
        } else {
            this.flag = true;
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.list.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup arg2) {

        return getone(position, view);//
    }

    private View getone(int position, View view) {
        view = LayoutInflater.from(mContext).inflate(R.layout.cp_item_city_listview, null);
        final SortModel mContent = list.get(position);
        TextView tvTitle = (TextView) view.findViewById(R.id.tv_item_city_listview_name);
        TextView tvLetter = (TextView) view.findViewById(R.id.tv_item_city_listview_letter);
        int section = getSectionForPosition(position);

        if (position == getPositionForSection(section)) {
            tvLetter.setVisibility(View.VISIBLE);
            tvLetter.setText(mContent.getSortLetters());
        } else {
            tvLetter.setVisibility(View.GONE);
        }
        tvTitle.setText(this.list.get(position).getName());

        return view;
    }

    final static class ViewHolder {
        TextView tvLetter;
        TextView tvTitle;
    }

    /**
     * ����ListView�ĵ�ǰλ�û�ȡ���������ĸ��Char asciiֵ
     */
    public int getSectionForPosition(int position) {
        return list.get(position).getSortLetters().charAt(0);
    }

    /**
     * ���ݷ��������ĸ��Char asciiֵ��ȡ���һ�γ��ָ�����ĸ��λ��
     */
    public int getPositionForSection(int section) {
        for (int i = 0; i < getCount(); i++) {
            String sortStr = list.get(i).getSortLetters();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }

        return -1;
    }

    /**
     * ��ȡӢ�ĵ�����ĸ����Ӣ����ĸ��#���档
     *
     * @param str
     * @return
     */
    private String getAlpha(String str) {
        String sortStr = str.trim().substring(0, 1).toUpperCase();
        // ������ʽ���ж�����ĸ�Ƿ���Ӣ����ĸ
        if (sortStr.matches("[A-Z]")) {
            return sortStr;
        } else {
            return "#";
        }
    }

    @Override
    public Object[] getSections() {
        return null;
    }
}