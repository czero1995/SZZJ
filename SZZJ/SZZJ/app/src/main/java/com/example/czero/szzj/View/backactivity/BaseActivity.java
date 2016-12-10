package com.example.czero.szzj.View.backactivity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

import android.view.Window;
import android.view.WindowManager;

public class BaseActivity extends Activity {

    protected SwipeBackLayout mSwipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mSwipeBackLayout = new SwipeBackLayout(this);
        mSwipeBackLayout.attachToActivity(this);
        mSwipeBackLayout.setBgTransparent();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//沉浸色
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//透明状态栏
        }
    }


    /**
     * 是否禁用滑动返回
     */
    public void setSwipeBackEnabled(boolean isSwipeBackEnabled) {
        mSwipeBackLayout.setSwipeBackEnabled(isSwipeBackEnabled);
    }


}
