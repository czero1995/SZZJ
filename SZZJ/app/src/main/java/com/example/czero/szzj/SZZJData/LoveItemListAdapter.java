package com.example.czero.szzj.SZZJData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJModel.Love;

import java.util.ArrayList;

/**
 * 适配器--适配二手交易物品列表数据
 * @date 2014-9-15
 * @author Stone
 */
public class LoveItemListAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater = null;
	private ArrayList<Love> mLove = null; //物品列表

	public LoveItemListAdapter(Context context, ArrayList<Love> love) {
		mContext = context;
		mLove = love;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return mLove.size();
	}

	@Override
	public Object getItem(int position) {
		return mLove.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	// 刷新列表中的数据
	public void refresh(ArrayList<Love> list) {
		mLove = list;
		notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LoveItemHolder loveItemHolder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_love, null);
			loveItemHolder = new LoveItemHolder();

			loveItemHolder.tv_love_content = (TextView) convertView
					.findViewById(R.id.tv_love_content);
			loveItemHolder.tvTradeItemTime = (TextView) convertView
					.findViewById(R.id.tv_trade_item_time);
			convertView.setTag(loveItemHolder);
		} else {
			loveItemHolder = (LoveItemHolder) convertView.getTag();
		}

		loveItemHolder.tv_love_content.setText(mLove.get(position).getDescription());

		loveItemHolder.tvTradeItemTime.setText(mLove.get(position).getCreatedAt());
		return convertView;
	}
	
}
