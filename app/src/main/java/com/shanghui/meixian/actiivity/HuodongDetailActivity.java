package com.shanghui.meixian.actiivity;

import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.base.BaseNetActivity;
import com.shanghui.meixian.views.BannerIndicatorView;
import com.shanghui.meixian.views.BannerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

public class HuodongDetailActivity extends BaseNetActivity {
    @InjectView(R.id.back_layout)
    LinearLayout backLayout;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.right_image)
    ImageView rightImage;
    @InjectView(R.id.banner_view)
    BannerView bannerView;
    @InjectView(R.id.banner_indicator_view)
    BannerIndicatorView bannerIndicatorView;
    @InjectView(R.id.rl_banner)
    RelativeLayout rlBanner;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.tv_place_name)
    TextView tvPlaceName;
    @InjectView(R.id.tv_date)
    TextView tvDate;
    @InjectView(R.id.tv_phone)
    TextView tvPhone;
    @InjectView(R.id.tv_local)
    TextView tvLocal;
    @InjectView(R.id.tv_photos_num)
    TextView tvPhotosNum;
    @InjectView(R.id.gv_photos)
    GridView gvPhotos;
    @InjectView(R.id.iv_take_photo)
    ImageView ivTakePhoto;
    @InjectView(R.id.ll_no_photo)
    LinearLayout llNoPhoto;
    @InjectView(R.id.tv_content)
    TextView tvContent;
    private List<String> imgUrl;

    @Override
    public int initContentView() {
        return R.layout.activity_huodong_detail;
    }

    @Override
    public void setData() {
        imgUrl = new ArrayList<>();
        bannerView.init(imgUrl, new BannerView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
        bannerView.setIndicator(bannerIndicatorView);
    }

    @OnClick({R.id.back_layout, R.id.right_image,R.id.iv_take_photo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_layout:
                break;
            case R.id.right_image:
                break;
        }
    }

}
