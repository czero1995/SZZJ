package com.example.czero.szzj.SZZJView;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJData.TradeItemListAdapter;
import com.example.czero.szzj.SZZJModel.SecondTrade;
import com.example.czero.szzj.View.FunGameRefreshView.FunGameRefreshView;
import com.example.czero.szzj.View.SupperTitle;
import com.example.czero.szzj.View.backactivity.BaseActivity;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.FindListener;


/**
 * 某一分类下的所有店铺页面
 * @author Stone
 * @date  2014-4-26 
 */
public class SecondTradeActivity extends BaseActivity implements OnItemClickListener {


	private TextView tvTitle;
	private ListView lvTradeItemAllList;
	private TradeItemListAdapter tradeItemListAdapter;
	private String title;
	private List<SecondTrade> tradeItemList = new ArrayList<SecondTrade>();
	private FunGameRefreshView refreshView;

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {

			tradeItemListAdapter.notifyDataSetChanged();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_secondtrade);

		SupperTitle supperTitle;
		supperTitle = (SupperTitle) findViewById(R.id.suppertitle);
		supperTitle.setTitle("姜是老的辣，货是旧的香");
		supperTitle.setTitleBackground(getResources().getColor(R.color.white));
		supperTitle.setOnLeftClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
			}
		});
		getTradeItemData();
		initView();
		refreshView = (FunGameRefreshView) findViewById(R.id.refresh_fun_game);
		refreshView.setOnRefreshListener(new FunGameRefreshView.FunGameRefreshListener() {
			@Override
			public void onRefreshing() {
				mHandler.sendEmptyMessage(0);
			}
		});
		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
			//透明状态栏目
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			//透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		}
		
	}
	
	public void initView() {

		tvTitle = (TextView) findViewById(R.id.tv_title);
		lvTradeItemAllList = (ListView) findViewById(R.id.lv_second_trade_all);
		tradeItemListAdapter = new TradeItemListAdapter(this, (ArrayList<SecondTrade>) tradeItemList);
		lvTradeItemAllList.setAdapter(tradeItemListAdapter);
		lvTradeItemAllList.setOnItemClickListener(this);
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
							long id) {
		//toast("点击了： " + position);
		//将当前点击的Shop对象传递给下一个Activity
//		Intent toShopItem = new Intent(SecondTradeActivity.this, ShopItemActivity.class);
//		Bundle bundle = new Bundle();  
//        bundle.putSerializable("shop", shopList.get(position) );  
//        bundle.putString("shopID", shopList.get(position).getObjectId()); //商铺的ID需要单独传递,否则获取到的是null
//        Log.i(TAG, ">>发出>>" + "shopID: "+shopList.get(position).getObjectId()+" shopName: "+shopList.get(position).getName());
//        toShopItem.putExtras(bundle);
//		startActivity(toShopItem);
	}
	
	/**
	 * 加载二手交易中所有商品到ListView中
	 */
	private void getTradeItemData() {
		BmobQuery<SecondTrade> query = new BmobQuery<SecondTrade>();
		query.order("-updatedAt");
		query.setCachePolicy(BmobQuery.CachePolicy.NETWORK_ELSE_CACHE);
		query.findObjects(this, new FindListener<SecondTrade>() {
			
		    @Override
		    public void onSuccess(List<SecondTrade> object) {


		    		tradeItemList = object;
			        // 通知Adapter数据更新
			    	tradeItemListAdapter.refresh((ArrayList<SecondTrade>) tradeItemList);
			    	//tradeItemListAdapter.notifyDataSetChanged();

		    }
		    
			@Override
			public void onError(int arg0, String msg) {
				TastyToast.makeText(getBaseContext(), "亲！请检查网络连接", TastyToast.LENGTH_LONG, TastyToast.WARNING);
			}
			
		});
	}

	
}
