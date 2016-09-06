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
import com.example.czero.szzj.SZZJModel.SecondTrade;
import com.example.czero.szzj.SZZJModel.Shop;

import java.util.ArrayList;

import cn.bmob.v3.datatype.BmobFile;

/**
 * 适配器--适配二手交易物品列表数据
 * @date 2014-9-15
 * @author Stone
 */
public class TradeItemListAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater = null;
	private ArrayList<SecondTrade> mTradeItemList = null; //物品列表
	private AQuery aq;



	public TradeItemListAdapter(Context context, ArrayList<SecondTrade> tradeItemList) {
		mContext = context;
		mTradeItemList = tradeItemList;
		mInflater = LayoutInflater.from(context);
		aq = new AQuery(mContext);
	}

	@Override
	public int getCount() {
		return mTradeItemList.size();
	}

	@Override
	public Object getItem(int position) {
		return mTradeItemList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	// 刷新列表中的数据
	public void refresh(ArrayList<SecondTrade> list) {
		mTradeItemList = list;
		notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TradeItemHolder tradeItemHodler;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_secondtrade, null);
			tradeItemHodler = new TradeItemHolder();
			tradeItemHodler.imgTradeItem = (ImageView) convertView
					.findViewById(R.id.img_trade_item);
			tradeItemHodler.tvTradeItemName = (TextView) convertView
					.findViewById(R.id.tv_trade_item_name);
			tradeItemHodler.tvTradeItemType = (TextView) convertView
					.findViewById(R.id.tv_trade_item_type);
			tradeItemHodler.tvTradeItemPrice = (TextView) convertView
					.findViewById(R.id.tv_trade_item_price);
			tradeItemHodler.tvTradeItemOwner = (TextView) convertView
					.findViewById(R.id.tv_trade_item_owner);
			tradeItemHodler.tvTradeItemTime = (TextView) convertView
					.findViewById(R.id.tv_trade_item_time);
			tradeItemHodler.tvTradeItemPhone= (TextView) convertView.findViewById(R.id.tv_trade_item_phone);
			convertView.setTag(tradeItemHodler);
		} else {
			tradeItemHodler = (TradeItemHolder) convertView.getTag();
		}

		AQuery aqImg = new AQuery(tradeItemHodler.imgTradeItem);
		SecondTrade secondTrade = mTradeItemList.get(position);
		if (null != secondTrade.getPicTradeItem() &&  !secondTrade.getPicTradeItem().getFileUrl(mContext).isEmpty()) {
			String url = secondTrade.getPicTradeItem().getFileUrl(mContext);
			if(url != null && !url.isEmpty()) {
				//shouldDelay(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent, String url)
				if(!aqImg.shouldDelay(position, false, convertView, parent, url))
					aqImg.image(url, true, true, 240, 0, null, android.R.anim.fade_in, 0.8f);
			}
		else {
			aqImg.id(R.id.img_trade_item).image(R.drawable.ic_app);
		}
		}





		tradeItemHodler.tvTradeItemPhone.setText(mTradeItemList.get(position).getPhone()
		);
		tradeItemHodler.tvTradeItemName.setText(mTradeItemList.get(position).getItem());
		tradeItemHodler.tvTradeItemType.setText(mTradeItemList.get(position).getType());
		tradeItemHodler.tvTradeItemPrice.setText("￥ " + mTradeItemList.get(position).getPrice());
		tradeItemHodler.tvTradeItemOwner.setText(mTradeItemList.get(position).getOwner());
		tradeItemHodler.tvTradeItemTime.setText(mTradeItemList.get(position).getCreatedAt());

//		mTradeItemList.get(position).getPicTradeItem().loadImageThumbnail(mContext, tradeItemHodler.imgTradeItem, 300, 300, 100);
		return convertView;
	}
	
}
