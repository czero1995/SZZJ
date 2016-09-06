package com.example.czero.szzj.SZZJData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJModel.ActivityNew;
import com.example.czero.szzj.SZZJModel.News;

import java.util.ArrayList;

/**
 * 适配器--适配二手交易物品列表数据
 * @date 2014-9-15
 * @author Stone
 */
public class ActivityNewItemListAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater = null;
	private ArrayList<ActivityNew> mActivityNew = null; //物品列表

	public ActivityNewItemListAdapter(Context context, ArrayList<ActivityNew> activitynew) {
		mContext = context;
		mActivityNew = activitynew;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return mActivityNew.size();
	}

	@Override
	public Object getItem(int position) {
		return mActivityNew.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	// 刷新列表中的数据
	public void refresh(ArrayList<ActivityNew> list) {
		mActivityNew = list;
		notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ActivityNewHolder activityNewHolder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_activitynew, null);
			activityNewHolder = new ActivityNewHolder();

			activityNewHolder.tvActivityNewname = (TextView) convertView
					.findViewById(R.id.tv_activitynew_name);
			activityNewHolder.tvActivityNewtitle = (TextView) convertView
					.findViewById(R.id.tv_activitynew_title);
			convertView.setTag(activityNewHolder);
			activityNewHolder.tvActivityNewDate= (TextView) convertView.findViewById(R.id.tv_activitynew_date);
		} else {
			activityNewHolder = (ActivityNewHolder) convertView.getTag();
		}
		activityNewHolder.tvActivityNewname.setText(mActivityNew.get(position).getName());
		activityNewHolder.tvActivityNewtitle.setText(mActivityNew.get(position).getTitle());
		activityNewHolder.tvActivityNewDate.setText(mActivityNew.get(position).getCreatedAt());
		return convertView;
	}
	
}
