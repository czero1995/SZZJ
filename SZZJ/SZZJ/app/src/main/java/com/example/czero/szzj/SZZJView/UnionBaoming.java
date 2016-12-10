package com.example.czero.szzj.SZZJView;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.czero.szzj.R;
import com.example.czero.szzj.View.backactivity.BaseActivity;

/**
 * Created by zake on 6/29/16.
 */
public class UnionBaoming extends BaseActivity {
    private String baomingurl = "http://www.sojump.hk/jq/8926071.aspx";
    private WebView unionbaomingwebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unionbaoming);
        unionbaomingwebView = (WebView) findViewById(R.id.unionbaomingwebview);
        WebSettings settings = unionbaomingwebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
//        settings.setBuiltInZoomControls(true);//设置缩放功能
//        settings.setDisplayZoomControls(false);//设置放大缩小按键隐藏
        unionbaomingwebView.loadUrl(baomingurl);
        unionbaomingwebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制网页在webview中去打开，false调用系统或这第三方浏览器中去打开
                view.loadUrl(url);
                return true;
            }
        });
    }

    //改写物理按键返回的逻辑

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (unionbaomingwebView.canGoBack()) {
                unionbaomingwebView.goBack();
                return true;

            } else {
//                    finish();
                unionbaomingwebView.setVisibility(View.GONE);
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}
