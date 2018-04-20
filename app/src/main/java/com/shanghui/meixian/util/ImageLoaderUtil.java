package com.shanghui.meixian.util;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.shanghui.meixian.R;

import java.io.File;


/**
 * Created by 11 on 2016/9/3.
 */
public class ImageLoaderUtil {
    private final static int IMAGE = R.mipmap.error;//设置图片在下载期间显示的图片

    /***
     * 普通加载
     * @param context
     * @param imgUrl
     * @param imageView
     */
    public static void loadImage(Context context, String imgUrl, ImageView imageView) {
        Glide.with(context)
//        Glide.with(BaseApplication.getInstance().getmContext())
                .load(imgUrl)
                .placeholder(IMAGE)//图片加载出来前，显示的图片
                .error(IMAGE)//加载出错时显示的图片
//                .centerCrop()
//                .fitCenter()
//                .dontAnimate()//取消图片加载出来时淡入淡出的特效
//                .skipMemoryCache(true)//跳过缓存到内存中去
//                .diskCacheStrategy( DiskCacheStrategy.NONE )//跳过磁盘缓存
                .into(imageView);
    }

    /***
     * 当加载失败时加载自定义图片
     * @param context
     * @param imgUrl
     * @param imageView
     */
    public static void loadImage(Context context, String imgUrl, ImageView imageView, int imgError) {
        Glide.with(context)
//        Glide.with(ECApplication.getInstance().getmContext())
                .load(imgUrl)
                .placeholder(imgError)//图片加载出来前，显示的图片
                .error(imgError)//加载出错时显示的图片
//                .dontAnimate()//取消图片加载出来时淡入淡出的特效
//                .skipMemoryCache(true)//跳过缓存到内存中去
//                .diskCacheStrategy( DiskCacheStrategy.NONE )//跳过磁盘缓存
                .into(imageView);
    }


    /***
     * 高优先级加载
     * @param context
     * @param imgUrl
     * @param imageView
     */
    public static void loadImageWithHighPriority(Context context, String imgUrl, ImageView imageView) {
        Glide.with(context)
//        Glide.with(ECApplication.getInstance().getmContext())
                .load(imgUrl)
                .placeholder(IMAGE)//图片加载出来前，显示的图片
                .error(IMAGE)//加载出错时显示的图片
//                .dontAnimate()//取消图片加载出来时淡入淡出的特效
//                .skipMemoryCache(true)//跳过缓存到内存中去
//                .diskCacheStrategy( DiskCacheStrategy.NONE )//跳过磁盘缓存
                .priority(Priority.HIGH)
                .into(imageView);
    }

    /***
     * 低优先级加载
     *
     * @param context
     * @param imgUrl
     * @param imageView
     */
    public static void loadImageWithLowPriority(Context context, String imgUrl, ImageView imageView) {
        Glide.with(context)
//        Glide.with(BaseApplication.getInstance().getmContext())
                .load(imgUrl)
                .placeholder(IMAGE)//图片加载出来前，显示的图片
                .error(IMAGE)//加载出错时显示的图片
//                .dontAnimate()//取消图片加载出来时淡入淡出的特效
//                .skipMemoryCache(true)//跳过缓存到内存中去
//                .diskCacheStrategy( DiskCacheStrategy.NONE )//跳过磁盘缓存
                .priority(Priority.LOW)
                .into(imageView);
    }

    /**
     * 加载视频
     *
     * @param context
     * @param filePath  只能是本地的视频路径
     * @param imageView
     */
    public static void loadVideo(Context context, String filePath, ImageView imageView) {
        Glide.with(context)
                .load(Uri.fromFile(new File(filePath)))//需做系统适配
                .placeholder(IMAGE)//图片加载出来前，显示的图片
                .error(IMAGE)//加载出错时显示的图片
                .into(imageView);
    }

}
