package com.example.czero.szzj.SZZJData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.androidquery.AQuery;
import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJModel.Shop;

import java.util.ArrayList;

/**
 * 适配器--适配某一分类下的店铺列表数据
 * 
 * @date 2014-4-29
 * @author Stone
 */
public class WaimaiListAdapter extends BaseAdapter {

	@SuppressWarnings("unused")
	private Context mContext;
	
	private LayoutInflater mInflater = null;
	private ArrayList<Shop> mShopList = null; // 所选分类下的所有店铺列表
	private String mType;
	private AQuery aq;// 商店的分类

	public WaimaiListAdapter(Context context, ArrayList<Shop> shopList,
							 String type) {
		mContext = context;
		mShopList = shopList;
		mType = type;
		mInflater = LayoutInflater.from(context);
		aq = new AQuery(mContext);
	}

	@Override
	public int getCount() {
		return mShopList.size();
	}

	@Override
	public Object getItem(int position) {
		return mShopList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	// 刷新列表中的数据
	public void refresh(ArrayList<Shop> list) {
		mShopList = list;
		//将数字的类型编号转换为文字
		exchangeType(mType);
		notifyDataSetChanged();
	}

	/**
	 * 根据当前的type类型, 转换成相应的文字
	 * @date 2014-4-29
	 * @param typeString
	 */
	private void exchangeType(String typeString) {


	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		WaimaiHolder waimaiHolder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_waimai, null);
			waimaiHolder = new WaimaiHolder();

			waimaiHolder.tvWaimaiName = (TextView) convertView
					.findViewById(R.id.tv_waimai_name);
			waimaiHolder.tvWaimaiLoc = (TextView) convertView
					.findViewById(R.id.tv_waimai_location);
			waimaiHolder.tvwaimaiphone1= (TextView) convertView.findViewById(R.id.tv_waimai_phone1);
			waimaiHolder.tvwaimaiphone2= (TextView) convertView.findViewById(R.id.tv_waimai_phone2);
			waimaiHolder.tvwaimaitype= (TextView) convertView.findViewById(R.id.tv_waimai_type);
			convertView.setTag(waimaiHolder);
		} else {
			waimaiHolder = (WaimaiHolder) convertView.getTag();
		}










		waimaiHolder.tvWaimaiName.setText(mShopList.get(position).getName());
		// 商店的类型需要单独处理
		waimaiHolder.tvWaimaiLoc.setText(mShopList.get(position).getLocation());
		waimaiHolder.tvwaimaiphone1.setText(mShopList.get(position).getPhone1());
		waimaiHolder.tvwaimaiphone2.setText(mShopList.get(position).getPhone2());
		waimaiHolder.tvwaimaitype.setText(mShopList.get(position).getType());
		return convertView;
	}

}
