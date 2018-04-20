package com.shanghui.meixian.actiivity;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.shanghui.meixian.R;
import com.shanghui.meixian.base.BaseNetActivity;
import com.shanghui.meixian.util.SoftKeyBoardListenerUtil;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/4/17.
 */

public class NewsDetailActivity extends BaseNetActivity {
    @InjectView(R.id.back)
    ImageView back;
    @InjectView(R.id.back_layout)
    LinearLayout backLayout;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.tetle_tv_ok)
    TextView tetleTvOk;
    @InjectView(R.id.right_image)
    ImageView rightImage;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.tv_date_source)
    TextView tvDateSource;
    @InjectView(R.id.iv_picture)
    ImageView ivPicture;
    @InjectView(R.id.tv_content)
    TextView tvContent;
    @InjectView(R.id.scrollView)
    ScrollView scrollView;
    @InjectView(R.id.ed_pinglun)
    EditText edPinglun;
    @InjectView(R.id.iv_shoucang)
    ImageView ivShoucang;
    @InjectView(R.id.iv_share)
    ImageView ivShare;
    @InjectView(R.id.tv_send)
    TextView tvSend;
    @InjectView(R.id.ll_pinglun)
    LinearLayout llPinglun;

    @Override
    public int initContentView() {
        return R.layout.activity_news_detail;
    }

    @Override
    public void setData() {
//监听键盘弹起和收起状态
        SoftKeyBoardListenerUtil.setListener(NewsDetailActivity.this, new SoftKeyBoardListenerUtil.OnSoftKeyBoardChangeListener() {
            @Override
            public void keyBoardShow(int height) {
                setCommentButtonVISIBLE();
            }

            @Override
            public void keyBoardHide(int height) {

                setShareVISIBLE();

            }
        });
        edPinglun.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    setCommentButtonVISIBLE();
                }
            }
        });
    }

    void setShareVISIBLE() {

        tvSend.setVisibility(View.GONE);
        ivShare.setVisibility(View.VISIBLE);
        ivShoucang.setVisibility(View.VISIBLE);
    }

    void setCommentButtonVISIBLE() {
        tvSend.setVisibility(View.VISIBLE);
        ivShare.setVisibility(View.GONE);
        ivShoucang.setVisibility(View.GONE);
    }

    @OnClick({R.id.back_layout, R.id.tetle_tv_ok, R.id.iv_picture, R.id.iv_shoucang, R.id.iv_share, R.id.tv_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_layout:
                finish();
                break;
            case R.id.tetle_tv_ok:
                break;
            case R.id.iv_picture:
                break;
            case R.id.iv_shoucang:
                break;
            case R.id.iv_share:
                break;
            case R.id.tv_send:
                if (TextUtils.isEmpty(edPinglun.getText().toString().trim())) {
                    showToast("请输入评论内容");
                } else {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edPinglun.getWindowToken(), 0);
                    submit();
                }
                break;
        }
    }

    private void submit() {

    }
}
