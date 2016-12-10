package com.example.czero.szzj.ZhiHu.task;

import android.os.AsyncTask;

import com.example.czero.szzj.ZhiHu.adapter.NewsAdapter;
import com.example.czero.szzj.ZhiHu.entity.News;
import com.example.czero.szzj.ZhiHu.http.Http;
import com.example.czero.szzj.ZhiHu.http.JsonHelper;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Created by mac on 15-2-3.
 */
public class LoadNewsTask extends AsyncTask<Void, Void, List<News>> {
    private NewsAdapter adapter;
    private onFinishListener listener;

    public LoadNewsTask(NewsAdapter adapter) {
        super();
        this.adapter = adapter;
    }

    public LoadNewsTask(NewsAdapter adapter, onFinishListener listener) {
        super();
        this.adapter = adapter;
        this.listener = listener;
    }



    @Override
    protected List<News> doInBackground(Void... params) {
        List<News> newsList = null;
        try {
            newsList = JsonHelper.parseJsonToList(Http.getLastNewsList());
        } catch (IOException | JSONException e) {

        } finally {
            return newsList;
        }
    }

    @Override
    protected void onPostExecute(List<News> newsList) {
        adapter.refreshNewsList(newsList);
        if (listener != null) {
            listener.afterTaskFinish();
        }

    }

    public interface onFinishListener {
        public void afterTaskFinish();
    }
}
