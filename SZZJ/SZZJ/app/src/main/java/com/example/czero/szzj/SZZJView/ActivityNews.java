package com.example.czero.szzj.SZZJView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJData.ActivityNewItemListAdapter;

import com.example.czero.szzj.SZZJModel.ActivityNew;
import com.example.czero.szzj.SZZJModel.News;
import com.example.czero.szzj.View.SupperTitle;
import com.example.czero.szzj.View.backactivity.BaseActivity;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by zake on 6/12/16.
 */
public class ActivityNews extends BaseActivity implements AdapterView.OnItemClickListener{
    private ListView lv_activitynew;
    private List<ActivityNew> activityNews= new ArrayList<ActivityNew>();
    private ActivityNewItemListAdapter activityNewItemListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitynews);
        SupperTitle supperTitle;
        supperTitle = (SupperTitle) findViewById(R.id.suppertitle);
        supperTitle.setTitle("校园动态");
        supperTitle.setTitleBackground(getResources().getColor(R.color.white));
        supperTitle.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        lv_activitynew= (ListView) findViewById(R.id.lv_activitynew);
        activityNewItemListAdapter=new ActivityNewItemListAdapter(ActivityNews.this,(ArrayList<ActivityNew>)activityNews);
        lv_activitynew.setAdapter(activityNewItemListAdapter);
        lv_activitynew.setOnItemClickListener(this);
        getActivityNewData();
    }
    private void getActivityNewData() {
        BmobQuery<ActivityNew> query = new BmobQuery<ActivityNew>();
        query.order("-createdAt");
        query.setCachePolicy(BmobQuery.CachePolicy.NETWORK_ELSE_CACHE);
        query.findObjects(this, new FindListener<ActivityNew>() {

            @Override
            public void onSuccess(List<ActivityNew> object) {
                //toast("查询成功. 共计" + object.size());

                    activityNews = object;
                    // 通知Adapter数据更新
                    activityNewItemListAdapter.refresh((ArrayList<ActivityNew>) activityNews);


            }

            @Override
            public void onError(int arg0, String msg) {
                TastyToast.makeText(ActivityNews.this, "亲！请检查网络连接", TastyToast.LENGTH_LONG, TastyToast.WARNING);
            }

        });
    }
    public void toast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent toActivityNew = new Intent(ActivityNews.this, ActivityNewItemActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("activitynew", activityNews.get(position) );
        bundle.putString("activitynewID", activityNews.get(position).getObjectId()); //商铺的ID需要单独传递,否则获取到的是null
        toActivityNew.putExtras(bundle);
        startActivity(toActivityNew);
    }
}
