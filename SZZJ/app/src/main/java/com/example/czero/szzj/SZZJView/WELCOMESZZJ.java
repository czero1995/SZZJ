package com.example.czero.szzj.SZZJView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;
import com.bumptech.glide.Glide;
import com.example.czero.szzj.R;
import com.example.czero.szzj.Tab.MainActivity;

import cn.bmob.push.BmobPush;
import cn.bmob.sms.BmobSMS;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobInstallation;


/**
 * Created by zake on 5/20/16.
 */
public class WELCOMESZZJ extends Activity {
    private static final String APPID = "f511c1b5bea912ef964937dcd486da8f";
    private static final int ANIMATION_DURATION = 3000;
    private static final float SCALE_END = 1.13F;
    private ImageView mSplashImage;
    private TextView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bmob.initialize(this, APPID);
        BmobSMS.initialize(this, APPID);
        // 初始化BmobSDK
        // 使用推送服务时的初始化操作
        BmobInstallation.getCurrentInstallation(this).save();
        // 启动推送服务
        BmobPush.startWork(this);

        setContentView(R.layout.activity_welcomeszzj);
        mSplashImage = (ImageView) findViewById(R.id.iv_entry);
        titleView = (TextView) findViewById(R.id.tv_title);
        animateImage();
        Glide.with(this).load("http://119.29.121.145/welcome.png").placeholder(R.drawable.ic_welcome).into(mSplashImage);

    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    private void animateImage() {
        android.animation.ObjectAnimator animatorX = android.animation.ObjectAnimator.ofFloat(mSplashImage, "scaleX", 1f, SCALE_END);
        android.animation.ObjectAnimator animatorY = android.animation.ObjectAnimator.ofFloat(mSplashImage, "scaleY", 1f, SCALE_END);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(ANIMATION_DURATION).play(animatorX).with(animatorY);
        set.start();
//
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent = new Intent(WELCOMESZZJ.this, MainActivity.class);
                startActivity(intent);
                WELCOMESZZJ.this.finish();
            }
        });
    }




    /*
    动画效果
     */
//    private void animal() {
//        ObjectAnimator.ofFloat(welcomepic, "rotationY", 0F, 360F).setDuration(2000).start();
//        ObjectAnimator.ofFloat(welcomepic, "alpha", 0F, 1F).setDuration(2000).start();
//        ObjectAnimator.ofFloat(welcometext, "alpha", 0F, 1F).setDuration(2000).start();
//    }


}