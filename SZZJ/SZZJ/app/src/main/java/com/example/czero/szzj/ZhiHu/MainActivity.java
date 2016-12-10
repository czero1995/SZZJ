package com.example.czero.szzj.ZhiHu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.czero.szzj.R;
import com.example.czero.szzj.ZhiHu.adapter.NewsAdapter;
import com.example.czero.szzj.ZhiHu.task.LoadNewsTask;
import com.example.czero.szzj.ZhiHu.utility.Utility;


public class MainActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {
    private SwipeRefreshLayout refreshLayout;
    private ListView lv;
    private NewsAdapter adapter;
    private boolean isConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isConnected = Utility.checkNetworkConnection(this);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh_layout);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        lv = (ListView) findViewById(R.id.lv);

        adapter = new NewsAdapter(this, R.layout.zhihu_listview_item);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        if (isConnected) new LoadNewsTask(adapter).execute();
        else Utility.noNetworkAlert(this);

    }




    @Override
    public void onRefresh() {
        if (isConnected) {
            new LoadNewsTask(adapter, new LoadNewsTask.onFinishListener() {
                @Override
                public void afterTaskFinish() {
                    refreshLayout.setRefreshing(false);
//                Toast.makeText(MainActivity.this, "Refresh success", Toast.LENGTH_SHORT).show();
                }
            }).execute();
        } else {
            Utility.noNetworkAlert(MainActivity.this);
            refreshLayout.setRefreshing(false);
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        NewsDetailActivity.startActivity(this, adapter.getItem(position));
    }
}
