package com.shanghui.meixian.util;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

import com.shanghui.meixian.R;


public class LoadingDialogUitl extends Dialog {
    private Window window = null;
    protected Context mContext;


    private static LoadingDialogUitl instance;

    public static LoadingDialogUitl getInstance() {
        if (instance == null) {
            synchronized (LoadingDialogUitl.class) {
                if (instance == null) {
                }
            }
        }
        return instance;
    }


    public static LoadingDialogUitl bulid(Context context) {
        instance = new LoadingDialogUitl(context);
        return instance;
    }


    public LoadingDialogUitl(Context context) {
        this(context, R.style.MyDialogStyle);
    }

    public LoadingDialogUitl(Context context, int theme) {
        super(context, theme);
        mContext = context;
        setLoadingDialog(R.layout.dialog_loading_layout_reg);
    }

    public void setLoadingDialog(int layoutResID) {
        setContentView(layoutResID);
        window = getWindow(); //
        window.setWindowAnimations(R.style.LoadingDialogStyle); //
        LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);

        lp.alpha = 0.76f; // 透明度
        window.setAttributes(lp);

        this.setCanceledOnTouchOutside(false);

//		this.setCancelable(false);
    }

    public void showDialog() {
        this.show();
    }

    public void closedDialog() {
        this.dismiss();
    }
}
