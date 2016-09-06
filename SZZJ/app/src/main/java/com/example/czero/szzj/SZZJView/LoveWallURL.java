package com.example.czero.szzj.SZZJView;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.czero.szzj.R;
import com.example.czero.szzj.View.SupperTitle;
import com.example.czero.szzj.View.backactivity.BaseActivity;

/**
 * Created by zake on 6/5/16.
 */
public class LoveWallURL extends BaseActivity {
//    private String loveurl = "https://jinshuju.net/f/Xpwy5B";
    private WebView lovewebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lovewallurl);
        lovewebView = (WebView) findViewById(R.id.lovewebview);
        SupperTitle supperTitle;
        supperTitle = (SupperTitle) findViewById(R.id.suppertitle);
        supperTitle.setTitleBackground(getResources().getColor(R.color.white));
        supperTitle.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        WebSettings settings = lovewebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);//设置缩放功能
        settings.setDisplayZoomControls(false);//设置放大缩小按键隐藏
        String value = getIntent().getStringExtra("flag");
        if (value.equals("1")){
            Bundle bundle = this.getIntent().getExtras();
            String loveurl = bundle.getString("loveurl");
            String lovetitle = bundle.getString("lovetitle");
            supperTitle.setTitle(lovetitle);
            lovewebView.loadUrl(loveurl);
            lovewebView.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    //返回值是true的时候控制网页在webview中去打开，false调用系统或这第三方浏览器中去打开
                    view.loadUrl(url);
                    return true;
                }
            });
        }else if(value.equals("2")){
            Bundle bundle2 = this.getIntent().getExtras();
            String secondtrade = bundle2.getString("secondurl");
            String secondtitle = bundle2.getString("secondtitle");
            supperTitle.setTitle(secondtitle);
            lovewebView.loadUrl(secondtrade);
            lovewebView.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    //返回值是true的时候控制网页在webview中去打开，false调用系统或这第三方浏览器中去打开
                    view.loadUrl(url);
                    return true;
                }
            });
        }

//        lovewebView.loadUrl(loveurl);
//        lovewebView.setWebViewClient(new WebViewClient() {
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                //返回值是true的时候控制网页在webview中去打开，false调用系统或这第三方浏览器中去打开
//                view.loadUrl(url);
//                return true;
//            }
//        });
    }

    //改写物理按键返回的逻辑

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (lovewebView.canGoBack()) {
                lovewebView.goBack();
                return true;

            } else {
//                    finish();
                lovewebView.setVisibility(View.GONE);
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}