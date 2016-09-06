package com.example.czero.szzj.Tab;


import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import android.view.WindowManager;
import android.widget.Toast;

import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJData.MyViewPagerAdapter;
import com.example.czero.szzj.Tab.ServerActivity;
import com.example.czero.szzj.Tab.ShanZhiQuanActivity;
import com.example.czero.szzj.Tab.MeActivity;


public class MainActivity extends AppCompatActivity{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyViewPagerAdapter adapter;

    private boolean isExit = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//沉浸色
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//透明状态栏
        }
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.pager);

        if (viewPager != null) {
            setupViewPager(viewPager);
        }

    }
    private void setupViewPager(ViewPager viewPager) {
        adapter = new MyViewPagerAdapter(getSupportFragmentManager(), this);
        adapter.addFragment(new ServerActivity().newInstance("Page1"), "校园服务");
        adapter.addFragment(new ShanZhiQuanActivity().newInstance("Page2"), "汕职圈");
        adapter.addFragment(new MeActivity().newInstance("Page3"), "我");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!isExit) {
                isExit = true;
                Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        isExit = false;
                    }
                }, 2000);
                return false;
            }
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
