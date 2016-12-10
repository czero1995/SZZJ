package com.example.czero.szzj.Tab;


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJView.ActivityNews;
import com.example.czero.szzj.SZZJView.Chizi;
import com.example.czero.szzj.SZZJView.CourseActivity;
import com.example.czero.szzj.SZZJView.LostFoundActivity;
import com.example.czero.szzj.SZZJView.LoveWallActivity;
import com.example.czero.szzj.SZZJView.LoveWallURL;
import com.example.czero.szzj.SZZJView.NewPeopleSZYL;
import com.example.czero.szzj.SZZJView.SearchphoneActivity;
import com.example.czero.szzj.SZZJView.SecondTradeActivity;

import com.example.czero.szzj.SZZJView.TourActivity;
import com.example.czero.szzj.SZZJView.UnionActivity;
import com.example.czero.szzj.SZZJView.VideoActivity;
import com.example.czero.szzj.SZZJView.WaimaiActivity;
import com.example.czero.szzj.SmartC.SmarcActivity;
import com.example.czero.szzj.View.CircularAnimUtil;

import com.example.czero.szzj.View.bannar.BannerLayout;
import com.example.czero.szzj.View.marqeeview.MarqueeView;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;


public class ServerActivity extends Fragment implements View.OnClickListener {
    private Button union, tour,
            waimai, secondtrade, lostfound,
            course, lovewall, smartc, xiaoyuandongtai;
    private MarqueeView marqueeView;
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public static ServerActivity newInstance(String param1) {
        ServerActivity fragment = new ServerActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


    public ServerActivity() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//沉浸色
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//透明状态栏
        }
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View myview = inflater.inflate(R.layout.activity_tabserver, container, false);

        final FloatingActionMenu fabMenu = (FloatingActionMenu) myview.findViewById(R.id.fabmenu);
        fabMenu.setClosedOnTouchOutside(true);

        final FloatingActionButton fabBtnChizi = (FloatingActionButton) myview.findViewById(R.id.fab_chizi);
        fabBtnChizi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabMenu.close(true);
                Intent intent = new Intent(getContext(), Chizi.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fabhaomachaxun = (FloatingActionButton) myview.findViewById(R.id.fab_haomachaxun);
        fabhaomachaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabMenu.close(true);
                Intent intent = new Intent(getContext(), SearchphoneActivity.class);
                startActivity(intent);
            }
        });
        FloatingActionButton guangyingshanzhi = (FloatingActionButton) myview.findViewById(R.id.fab_guangyingshanzhi);
        guangyingshanzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabMenu.close(true);
                Intent intent = new Intent(getContext(), VideoActivity.class);
                startActivity(intent);
            }
        });
        FloatingActionButton shanzhiyilan = (FloatingActionButton) myview.findViewById(R.id.fab_shanzhiyilan);
        shanzhiyilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabMenu.close(true);
                Intent intent = new Intent(getContext(), NewPeopleSZYL.class);
                startActivity(intent);
            }
        });

        lostfound = (Button) myview.findViewById(R.id.lostfound);
        waimai = (Button) myview.findViewById(R.id.waimai);
        tour = (Button) myview.findViewById(R.id.tour);
        course = (Button) myview.findViewById(R.id.course);
        secondtrade = (Button) myview.findViewById(R.id.secondtrade);
        union = (Button) myview.findViewById(R.id.union);
        xiaoyuandongtai = (Button) myview.findViewById(R.id.xiaoyuandongtai);
        lovewall = (Button) myview.findViewById(R.id.lovewall);

        smartc = (Button) myview.findViewById(R.id.smartc);

        lovewall.setOnClickListener(this);
        smartc.setOnClickListener(this);
        lostfound.setOnClickListener(this);
        waimai.setOnClickListener(this);
        tour.setOnClickListener(this);
        course.setOnClickListener(this);
        secondtrade.setOnClickListener(this);
        union.setOnClickListener(this);
        xiaoyuandongtai.setOnClickListener(this);
        BannerLayout bannerLayout = (BannerLayout) myview.findViewById(R.id.banner);
        final List<String> urls = new ArrayList<>();
        urls.add("http://119.29.121.145/adone.jpg");
        urls.add("http://119.29.121.145/adtwo.jpg");
        urls.add("http://119.29.121.145/adthree.jpg");
        urls.add("http://119.29.121.145/adfour.jpg");
        urls.add("http://119.29.121.145/adfive.jpg");
        bannerLayout.setViewUrls(urls);

        marqueeView = (MarqueeView) myview.findViewById(R.id.marqueeView);
        List<String> info = new ArrayList<>();
        info.add("     生活万种风情,因为过它的人有趣有味");
        info.add("     因为你有双下巴,所以碰到任何困难,不要低头");
        info.add("     知行合一,德技双馨!");
        info.add("     够真橙,活青春!");
        info.add("     人最怕的就是圈子太low,大家不成长还乐在其中");
        info.add("     在这里,要么庸俗,要么孤独");
        marqueeView.startWithList(info);
        marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                TastyToast.makeText(getContext(), textView.getText() + "", TastyToast.LENGTH_LONG, TastyToast.INFO);
            }
        });

        //添加监听事件
        bannerLayout.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {

                switch (position) {
                    case 0:
                        Intent one = new Intent(getContext(), NewPeopleSZYL.class);
                        startActivity(one);
                        break;
                    case 1:
                        Intent two = new Intent(getContext(), VideoActivity.class);
                        startActivity(two);
                        break;
                }
            }
        });
        return myview;
    }

    public List<String> getData() {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("item" + i);
        }
        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.union:
                CircularAnimUtil.startActivity((Activity) getContext(), UnionActivity.class, v, R.color.bantouming);
                break;
            case R.id.tour:
                CircularAnimUtil.startActivity((Activity) getContext(), TourActivity.class, v, R.color.gray_bg);

                break;
            case R.id.waimai:
                CircularAnimUtil.startActivity((Activity) getContext(), WaimaiActivity.class, v, R.color.gray_bg);
                break;
            case R.id.secondtrade:
                Intent intent_love = new Intent(getContext(), LoveWallURL.class);
                intent_love.putExtra("flag", "2");
                Bundle bundle = new Bundle();
                bundle.putString("secondurl", "http://weidian.com/?userid=894912406&wfr=wx_profile&from=singlemessage&isappinstalled=0");
                bundle.putString("secondtitle", "姜是老的辣，货是旧的香");
                intent_love.putExtras(bundle);
                startActivity(intent_love);
                break;
            case R.id.lostfound:
                CircularAnimUtil.startActivity((Activity) getContext(), LostFoundActivity.class, v, R.color.gray_bg);
                break;
            case R.id.course:
                CircularAnimUtil.startActivity((Activity) getContext(), CourseActivity.class, v, R.color.gray_bg);
                break;
            case R.id.lovewall:
                CircularAnimUtil.startActivity((Activity) getContext(), LoveWallActivity.class, v, R.color.gray_bg);
                break;
            case R.id.smartc:
                CircularAnimUtil.startActivity((Activity) getContext(), SmarcActivity.class, v, R.color.gray_bg);
                break;
            case R.id.xiaoyuandongtai:
                CircularAnimUtil.startActivity((Activity) getContext(), ActivityNews.class, v, R.color.gray_bg);
                break;
        }
    }
}
