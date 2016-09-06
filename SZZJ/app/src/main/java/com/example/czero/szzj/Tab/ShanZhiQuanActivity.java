package com.example.czero.szzj.Tab;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJData.ShanZhiQuanListAdapter;
import com.example.czero.szzj.SZZJModel.ShanZhiQuan;
import com.example.czero.szzj.SZZJModel.User;
import com.example.czero.szzj.SZZJView.DongTaiActivity;
import com.example.czero.szzj.SZZJView.LoginActivity;
import com.example.czero.szzj.View.SupperTitle;
import com.sdsmdg.tastytoast.TastyToast;
import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;


public class ShanZhiQuanActivity extends Fragment{

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    private ListView lvamusetalk;
    private LinearLayout common_loading;
    private LinearLayout common_nodata;
    private ShanZhiQuanListAdapter shanZhiQuanListAdapter;
    private List<ShanZhiQuan> shanZhiQuan = new ArrayList<ShanZhiQuan>();
    private User curUser;
    PullToRefreshView mPtrNewsList;

    public static ShanZhiQuanActivity newInstance(String param1) {
        ShanZhiQuanActivity fragment = new ShanZhiQuanActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public ShanZhiQuanActivity() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myview = inflater.inflate(R.layout.activity_shanzhiquan, container, false);
        FloatingActionButton fab = (FloatingActionButton)myview.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "够真橙，活青春！", Snackbar.LENGTH_LONG)
                        .setAction("发动态", new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                curUser = BmobUser.getCurrentUser(getContext(), User.class);
                                if(curUser ==null){
                                    Toast.makeText(getContext(),"请先登陆",Toast.LENGTH_SHORT).show();
                                    Intent login = new Intent(getContext(), LoginActivity.class);
                                    startActivity(login);
                                }else {
                                    Intent i = new Intent(getContext(), DongTaiActivity.class);
                                    startActivity(i);
                                }
                            }
                        }).show();
            }
        });
        SupperTitle supperTitle;
        supperTitle = (SupperTitle) myview.findViewById(R.id.suppertitle);
        supperTitle.setTitle("汕职圈");
        supperTitle.setTitleBackground(getResources().getColor(R.color.white));
        lvamusetalk = (ListView) myview.findViewById(R.id.lv_amusetalk);
        common_loading= (LinearLayout) myview.findViewById(R.id.common_loading);
        common_nodata= (LinearLayout) myview.findViewById(R.id.common_nodata);
        mPtrNewsList= (PullToRefreshView)myview.findViewById(R.id.pull_to_refresh);
        mPtrNewsList.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAmuseTalkData();
                TastyToast.makeText(getContext(), "正在刷新", TastyToast.LENGTH_LONG, TastyToast.INFO);
                mPtrNewsList.setRefreshing(false);
            }
        });


        shanZhiQuanListAdapter = new ShanZhiQuanListAdapter(getContext(), (ArrayList<ShanZhiQuan>) shanZhiQuan);
        lvamusetalk.setAdapter(shanZhiQuanListAdapter);

        getAmuseTalkData();

        return myview;
    }
    public  void getAmuseTalkData() {
        BmobQuery<ShanZhiQuan> query = new BmobQuery<ShanZhiQuan>();
        query.order("-createdAt");
        query.setCachePolicy(BmobQuery.CachePolicy.NETWORK_ELSE_CACHE);
        query.findObjects(getContext(), new FindListener<ShanZhiQuan>() {

            @Override
            public void onSuccess(List<ShanZhiQuan> object) {


                    shanZhiQuan = object;
                    // 通知Adapter数据更新
                    shanZhiQuanListAdapter.refresh((ArrayList<ShanZhiQuan>) shanZhiQuan);
                    common_loading.setVisibility(View.GONE);
                common_nodata.setVisibility(View.GONE);

            }

            @Override
            public void onError(int arg0, String msg) {
//                Toast.makeText(getActivity(), "网络异常，下拉刷新试试", Toast.LENGTH_SHORT).show();
                common_nodata.setVisibility(View.VISIBLE);
                common_loading.setVisibility(View.GONE);


            }

        });
    }





}
