package com.example.czero.szzj.SZZJData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJModel.Tour;

import java.util.ArrayList;

/**
 * 适配器--适配二手交易物品列表数据
 * @date 2014-9-15
 * @author Stone
 */
public class TourListAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater = null;
	private ArrayList<Tour> mtour = null; //物品列表

	public TourListAdapter(Context context, ArrayList<Tour> tour) {
		mContext = context;
		mtour=tour;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return mtour.size();
	}

	@Override
	public Object getItem(int position) {
		return mtour.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	// 刷新列表中的数据
	public void refresh(ArrayList<Tour> list) {
		mtour = list;
		notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TourItemHolder tourItemHolder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_tour, null);
			tourItemHolder = new TourItemHolder();

			tourItemHolder.tvTourName = (TextView) convertView
					.findViewById(R.id.tv_tourname);

			tourItemHolder.tvTourContent = (TextView) convertView
					.findViewById(R.id.tv_tourcontent);

			tourItemHolder.tvTourTime= (TextView) convertView.findViewById(R.id.tv_tourtime);
			convertView.setTag(tourItemHolder);
			tourItemHolder.tvTime= (TextView) convertView.findViewById(R.id.tv_time);
		} else {
			tourItemHolder = (TourItemHolder) convertView.getTag();
		}


		tourItemHolder.tvTourName.setText(mtour.get(position).getName());

		tourItemHolder.tvTourContent.setText(mtour.get(position).getContent());
		tourItemHolder.tvTourTime.setText(mtour.get(position).getTime());


//		mTradeItemList.get(position).getPicTradeItem().loadImageThumbnail(mContext, tradeItemHodler.imgTradeItem, 300, 300, 100);
		return convertView;
	}
	
}
