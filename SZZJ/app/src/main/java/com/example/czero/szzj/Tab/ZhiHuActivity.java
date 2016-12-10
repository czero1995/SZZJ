package com.example.czero.szzj.Tab;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.czero.szzj.R;
import com.example.czero.szzj.ZhiHu.NewsDetailActivity;
import com.example.czero.szzj.ZhiHu.adapter.NewsAdapter;
import com.example.czero.szzj.ZhiHu.task.LoadNewsTask;
import com.example.czero.szzj.ZhiHu.utility.Utility;

/**
 * Created by czero on 10/25/16.
 */

public class ZhiHuActivity extends Fragment implements SwipeRefreshLayout.OnRefreshListener,AdapterView.OnItemClickListener {
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    private SwipeRefreshLayout refreshLayout;
    private ListView lv;
    private NewsAdapter adapter;
    private boolean isConnected;
    public static ZhiHuActivity newInstance(String param1) {
        ZhiHuActivity fragment = new ZhiHuActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }
    public ZhiHuActivity(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myview = inflater.inflate(R.layout.activity_zhihu,container,false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){//沉浸色
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//透明状态栏
        }
        isConnected = Utility.checkNetworkConnection(getActivity());
        refreshLayout = (SwipeRefreshLayout)myview.findViewById(R.id.refresh_layout);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        lv = (ListView) myview.findViewById(R.id.lv);

        adapter = new NewsAdapter(getActivity(), R.layout.zhihu_listview_item);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        if (isConnected) new LoadNewsTask(adapter).execute();
        else Utility.noNetworkAlert(getContext());
        return myview;
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        NewsDetailActivity.startActivity(getContext(), adapter.getItem(position));
    }
}
