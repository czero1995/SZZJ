package com.example.czero.szzj.ZhiHu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.czero.szzj.R;
import com.example.czero.szzj.ZhiHu.entity.News;
import com.example.czero.szzj.ZhiHu.task.LoadNewsDetailTask;
import com.example.czero.szzj.ZhiHu.utility.Utility;


/**
 * Created by mac on 15-2-17.
 */
public class NewsDetailActivity extends Activity {
    private WebView mWebView;
    private boolean isFavourite = false;
    private News news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhihu_news_detail);

        mWebView = (WebView) findViewById(R.id.webview);
        setWebView(mWebView);

        news = (News) getIntent().getSerializableExtra("news");
        new LoadNewsDetailTask(mWebView).execute(news.getId());
//        isFavourite = DailyNewsDB.getInstance(this).isFavourite(news);
    }

    private void setWebView(WebView mWebView) {
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setHorizontalScrollBarEnabled(false);
    }

    public static void startActivity(Context context, News news) {
        if (Utility.checkNetworkConnection(context)) {
            Intent i = new Intent(context, NewsDetailActivity.class);
            i.putExtra("news", news);
            context.startActivity(i);
        } else {
            Utility.noNetworkAlert(context);
        }
    }



}
