package com.shanghui.meixian.views;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shanghui.meixian.R;


public class TabIndicator extends LinearLayout {

    private View mIndicator;
    private OnSelectListener mOnSelectListener;
    private int lastTab = 0;
    private int textColor, textColorSelected;
    private int[] tabImageId = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private int[] tabImageSelectedId = {R.mipmap.error, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private String[] tabTexts = {"首页", "一", "er", "san"};
    private Context mContext;
    private int ITEMCOUNT;
    private GridView gv_tab;
    private TabGridAdapter tabGridAdapter;

    public TabIndicator(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public TabIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext =  context;
        init();
    }

    @SuppressLint("NewApi")
    public TabIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    public void setOnSelectListener(OnSelectListener listener) {
        mOnSelectListener = listener;
    }

    public void setNum(int num) {
//        if (num > 0) {
//            tv_num.setVisibility(VISIBLE);
//            tv_num.setText(num + "");
//        } else {
//            tv_num.setVisibility(GONE);
//        }
    }

    private void init() {
        ITEMCOUNT = tabImageId.length;
        mIndicator = LayoutInflater.from(getContext()).inflate(R.layout.widget_tab_indicator, this,
                true);
        lastTab = -1;
        textColor = getResources().getColor(R.color.content_text);
        textColorSelected = getResources().getColor(R.color.themeTextColor);
        gv_tab = (GridView) mIndicator.findViewById(R.id.gv_tab);
        gv_tab.setNumColumns(ITEMCOUNT);
        tabGridAdapter = new TabGridAdapter();
        gv_tab.setAdapter(tabGridAdapter);
        gv_tab.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                setTab(i);
            }
        });
    }

    public void setTab(int i) {
        if (lastTab == i) {
            return;
        } else {
            lastTab = i;
            tabGridAdapter.notifyDataSetChanged();
            mOnSelectListener.onSelect(i);
        }
    }


    public interface OnSelectListener {
        void onSelect(int i);
    }


    class TabGridAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return ITEMCOUNT;
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
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_tab, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initializeViews(i, (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews(int position, ViewHolder holder) {
            //TODO implement
            if (lastTab == position) {
                holder.tab0Text.setText(tabTexts[position]);
                holder.tab0Text.setTextColor(textColorSelected);
                holder.tab0Image.setImageResource(tabImageSelectedId[position]);
            } else {
                holder.tab0Text.setText(tabTexts[position]);
                holder.tab0Text.setTextColor(textColor);
                holder.tab0Image.setImageResource(tabImageId[position]);
            }

        }

        protected class ViewHolder {
            private ImageView tab0Image;
            private TextView tvNum;
            private TextView tab0Text;

            public ViewHolder(View view) {
                tab0Image = (ImageView) view.findViewById(R.id.tab_0_image);
                tvNum = (TextView) view.findViewById(R.id.tv_num);
                tab0Text = (TextView) view.findViewById(R.id.tab_0_text);
            }
        }
    }
}
