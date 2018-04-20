package com.shanghui.meixian.actiivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.shanghui.meixian.R;
import com.shanghui.meixian.adapter.HuiyuanAdapter;
import com.shanghui.meixian.base.BaseNetActivity;
import com.shanghui.meixian.http.bean.HuiyuanBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

public class NewHuiyuanActivity extends BaseNetActivity {
    @InjectView(R.id.back_layout)
    LinearLayout backLayout;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.lv_content)
    PullToRefreshListView lvContent;
    @InjectView(R.id.iv_nodata)
    ImageView ivNodata;
    private int NUMPAGE = 1;
    private int COUNT = 10;
    private List<HuiyuanBean> huiyuanBeans;
    private HuiyuanAdapter huiyuanAdapter;


    @Override
    public int initContentView() {
        return R.layout.activity_new_huiyuan;
    }

    @Override
    public void setData() {
        huiyuanBeans = new ArrayList<>();
        huiyuanAdapter = new HuiyuanAdapter(mContext, huiyuanBeans);
        lvContent.setAdapter(huiyuanAdapter);
        getNoticeData();
    }

    public void getNoticeData() {

    }

    @OnClick(R.id.back_layout)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void initListener() {
        initListview();
    }

    public void initListview() {
        //设置可上拉刷新和下拉刷新
        lvContent.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        //设置刷新时显示的文本
        final ILoadingLayout startLayout = lvContent.getLoadingLayoutProxy(true, false);
        startLayout.setPullLabel("下拉刷新...");
        startLayout.setRefreshingLabel("正在加载中...");
        startLayout.setReleaseLabel("放开刷新");

        ILoadingLayout endLayout = lvContent.getLoadingLayoutProxy(false, true);
        endLayout.setPullLabel("上拉加载更多...");
        endLayout.setRefreshingLabel("正在加载中...");
        endLayout.setReleaseLabel("放开加载");

        lvContent.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {


            }
        });
        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//position-1;
                showDetail(huiyuanBeans.get(position - 1));
            }
        });

    }

    private void showDetail(HuiyuanBean huiyuanBean) {
        final Dialog dialog = new Dialog(mContext, R.style.CustomDialog);
        dialog.setContentView(R.layout.dialog_detail);

        ImageView ivHead = (ImageView) dialog.findViewById(R.id.iv_head);
        ImageView ivShoucang = (ImageView) dialog.findViewById(R.id.iv_shoucang);
        TextView tvName = (TextView) dialog.findViewById(R.id.tv_name);
        TextView tvZhiwei = (TextView) dialog.findViewById(R.id.tv_zhiwei);
        TextView tvCompany = (TextView) dialog.findViewById(R.id.tv_company);
        TextView tvPhone = (TextView) dialog.findViewById(R.id.tv_phone);
        ImageView ivCall = (ImageView) dialog.findViewById(R.id.iv_call);
        TextView tvEmail = (TextView) dialog.findViewById(R.id.tv_email);
        TextView tvWeibo = (TextView) dialog.findViewById(R.id.tv_weibo);
        TextView tvAddress = (TextView) dialog.findViewById(R.id.tv_address);
        TextView tvSend = (TextView) dialog.findViewById(R.id.tv_send);
        ImageView ivClose = (ImageView) dialog.findViewById(R.id.iv_close);
        ImageView ivEmail = (ImageView) dialog.findViewById(R.id.iv_email);

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "12344"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        ivEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("mailto:"+"xxx@abc.com");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
//                Intent intent = new Intent(Intent.ACTION_SEND, uri);
                //intent.putExtra(Intent.EXTRA_CC, email); // 抄送人
                // intent.putExtra(Intent.EXTRA_SUBJECT, "这是邮件的主题部分"); // 主题
                // intent.putExtra(Intent.EXTRA_TEXT, "这是邮件的正文部分"); // 正文
                startActivity(Intent.createChooser(intent, "使用以下方式打开"));
            }
        });
        ivShoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        tvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dialog.show();
    }
}
