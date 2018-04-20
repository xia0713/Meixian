package com.shanghui.meixian.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.Scroller;

import com.shanghui.meixian.util.ImageLoaderUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 广告栏视图
 */
public class BannerView extends ViewPager {
    List<String> mBanners;
    Context mContext;

    /**
     * 用来启动自动滑动的handler
     */
    private BannerHandler mHandler;
    /**
     * 广告栏下方的小圆点标记
     */
    private BannerIndicatorView mIndicator;
    /**
     * 广告图片数量
     */
    private int count;
    /**
     * 广告图片的ImageView列表
     */
    private List<ImageView> imageViewList;
    /**
     * 当前的位置
     */
    private int currPosition;
    /**
     * 滑动需要的时间
     */
    private int scrollDuration = 2000;
    /**
     * 间隔时间
     */
    private int pauseDuration = 2000;

    public BannerView(Context context) {
        super(context);
        mContext = context;
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    private OnItemClickListener onItemClickListener;

    public void init(List<String> mBanners, OnItemClickListener onItemClickListener1) {
        this.onItemClickListener = onItemClickListener1;
        // 将图片放入ImageView中
//        this.images = images;
        if (mBanners == null) {
            mBanners = new ArrayList<>();
            return;
        }
        count = mBanners.size();
        imageViewList = new ArrayList<>();
        this.mBanners = mBanners;
        for (int i = 0; i < count; i++) {
            final ImageView imageView = new ImageView(getContext());
            final String url = mBanners.get(i);
            ImageLoaderUtil.loadImage(mContext, url, imageView);

            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (onItemClickListener != null) {
                final int finalI = i;
                imageView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(finalI);
                    }
                });
            }
            imageViewList.add(imageView);
        }

        setAdapter(new BannerAdapter());
//        this.setOffscreenPageLimit(count);
        setOnPageChangeListener(new onBannerChangeListener());

        new FixedSpeedScroller(getContext(), new DecelerateInterpolator(2))
                .setDuration(this, scrollDuration);

        currPosition = Short.MAX_VALUE / 2 - (Short.MAX_VALUE / 2) % count;
        setCurrentItem(currPosition);

        mHandler = new BannerHandler();
        startScroll();
    }


   public interface OnItemClickListener {
        void onItemClick(int position);
    }


    public void startScroll() {
        mHandler.sendEmptyMessageDelayed(BannerHandler.START_SCROLL,
                pauseDuration);
    }

    public void stopScroll() {
        mHandler.sendEmptyMessage(BannerHandler.STOP_SCROLL);
    }

    public void setScrollDuration(int scrollDuration) {
        this.scrollDuration = scrollDuration;
    }

    public void setPauseDuration(int pauseDuration) {
        this.pauseDuration = pauseDuration;
    }

    public void setIndicator(BannerIndicatorView indicator) {
        if (mBanners != null && mBanners.size() > 0) {
            mIndicator = indicator;
            mIndicator.init(mBanners.size());
            mIndicator.setFocus(currPosition % mBanners.size());
        }
    }

    private class BannerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            if (count > 1) {
                return Short.MAX_VALUE;
            } else {
                return count;
            }
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
//            container.addView(imageViewList.get(position % count));
//            return imageViewList.get(position % count);
            if (imageViewList.get(position % imageViewList.size()).getParent() != null) {
//                ((ViewPager) imageViewList.get(position % imageViewList.size()) .getParent()).removeView(imageViewList.get(position % imageViewList.size()));
                container.removeView(imageViewList.get(position % imageViewList.size()));
            }
            try {
                ((ViewPager) container).addView(imageViewList.get(position % imageViewList.size()), 0);
            } catch (Exception e) {
                e.printStackTrace();
//                ((ViewPager) imageViewList.get(position % imageViewList.size()).getParent()).removeView(imageViewList.get(position % imageViewList.size()));
//                ((ViewPager) container).addView(imageViewList.get(position % imageViewList.size()), 0);
            }
            return imageViewList.get(position % imageViewList.size());
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            container.removeView(imageViewList.get(position % imageViewList.size()));
//            container.removeViewAt(position % imageViewList.size());
        }
    }

    public class onBannerChangeListener implements OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            switch (state) {
                case ViewPager.SCROLL_STATE_DRAGGING:
                    stopScroll();
                    break;
                case ViewPager.SCROLL_STATE_IDLE:
                    startScroll();
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onPageSelected(int position) {
            currPosition = position;
            if (mIndicator != null) {
                mIndicator.setFocus(position % mBanners.size());
            }
        }
    }

    @SuppressLint("HandlerLeak")
    private class BannerHandler extends Handler {

        /**
         * 请求更新显示的View。
         */
        protected static final int START_SCROLL = 1;
        /**
         * 请求暂停轮播。
         */
        protected static final int STOP_SCROLL = 2;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            // 检查消息队列并移除未发送的消息，这主要是避免在复杂环境下消息出现重复等问题。
            if (BannerView.this.mHandler.hasMessages(START_SCROLL)) {
                BannerView.this.mHandler.removeMessages(START_SCROLL);
            }
            switch (msg.what) {
                case START_SCROLL:
                    BannerView.this.currPosition++;
                    BannerView.this.setCurrentItem(BannerView.this.currPosition);
                    startScroll();
                    break;
                case STOP_SCROLL:
                    break;
                default:
                    break;
            }
        }
    }

    private class FixedSpeedScroller extends Scroller {
        private int mDuration;

        public FixedSpeedScroller(Context context) {
            super(context);
        }

        public FixedSpeedScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        /**
         * 设置滑动时间 ,如果用默认时间可不用这个类 ,反射技术实现
         *
         * @param vp   ViewPager 对象
         * @param time 时间
         */

        public void setDuration(ViewPager vp, int time) {
            try {
                Field field = ViewPager.class.getDeclaredField("mScroller");
                field.setAccessible(true);
                setmDuration(time);
                field.set(vp, this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy,
                                int duration) {
            super.startScroll(startX, startY, dx, dy, mDuration);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy) {
            super.startScroll(startX, startY, dx, dy, mDuration);
        }

        @SuppressWarnings("unused")
        public int getmDuration() {
            return mDuration;
        }

        public void setmDuration(int time) {
            mDuration = time;
        }
    }
}
