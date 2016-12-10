package com.example.czero.szzj.SZZJView;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJData.TourListAdapter;
import com.example.czero.szzj.SZZJModel.Tour;
import com.example.czero.szzj.View.FunGameRefreshView.FunGameRefreshView;
import com.example.czero.szzj.View.PullRefresh.PullToRefreshView;
import com.example.czero.szzj.View.SupperTitle;
import com.example.czero.szzj.View.backactivity.BaseActivity;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;



public class TourActivity extends BaseActivity implements AdapterView.OnItemClickListener {


	private ListView lvtour;
	private TourListAdapter tourListAdapter;
	private PullToRefreshView mPullToRefreshView;
	public static final int REFRESH_DELAY = 3000;

	private List<Tour> tours = new ArrayList<Tour>();
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {

			tourListAdapter.notifyDataSetChanged();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tour);

		SupperTitle supperTitle;
		supperTitle = (SupperTitle) findViewById(R.id.suppertitle);
		supperTitle.setTitle("年轻即出发");
		supperTitle.setTitleBackground(getResources().getColor(R.color.white));
		supperTitle.setOnLeftClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
			}
		});
		lvtour = (ListView) findViewById(R.id.lv_tour);
		tourListAdapter = new TourListAdapter(TourActivity.this, (ArrayList<Tour>) tours);
		lvtour.setAdapter(tourListAdapter);

		mPullToRefreshView = (PullToRefreshView) findViewById(R.id.pull_to_refresh);
		mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
			@Override
			public void onRefresh() {
				mPullToRefreshView.postDelayed(new Runnable() {
					@Override
					public void run() {
						mPullToRefreshView.setRefreshing(false);
					}
				}, REFRESH_DELAY);
			}
		});
		getTourData();
		lvtour.setOnItemClickListener(this);
		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
			//透明状态栏目
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			//透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		}

	}
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent toTourItem = new Intent(TourActivity.this, TourItemActivity.class);
		Bundle bundle = new Bundle();
		bundle.putSerializable("tour", tours.get(position) );
		bundle.putString("tourID", tours.get(position).getObjectId()); //商铺的ID需要单独传递,否则获取到的是null
		toTourItem.putExtras(bundle);
		startActivity(toTourItem);
	}
	private void getTourData(){
		BmobQuery<Tour> query = new BmobQuery<Tour>();
		query.order("-updatedAt");
		query.setCachePolicy(BmobQuery.CachePolicy.NETWORK_ELSE_CACHE);
		query.findObjects(this, new FindListener<Tour>() {
			
		    @Override
		    public void onSuccess(List<Tour> object) {

		        //toast("查询成功. 共计" + object.size());

		    		tours = object;
			        // 通知Adapter数据更新
			    	tourListAdapter.refresh((ArrayList<Tour>) tours);


		    }
		    
			@Override
			public void onError(int arg0, String msg) {
				TastyToast.makeText(getBaseContext(), "亲！请检查网络连接", com.sdsmdg.tastytoast.TastyToast.LENGTH_LONG, com.sdsmdg.tastytoast.TastyToast.WARNING);
			}
			
		});
	}

	private void toast(String toast) {
		Toast.makeText(this, toast,  Toast.LENGTH_SHORT).show();
	}


}
