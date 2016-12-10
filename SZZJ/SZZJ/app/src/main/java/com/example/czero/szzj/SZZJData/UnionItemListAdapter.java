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
import com.example.czero.szzj.SZZJModel.Union;

import java.util.ArrayList;

/**
 * 适配器--适配二手交易物品列表数据
 * @date 2014-9-15
 * @author Stone
 */
public class UnionItemListAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater = null;
	private ArrayList<Union> munion = null; //物品列表
	private AQuery aq;
	public UnionItemListAdapter(Context context, ArrayList<Union> unions) {
		mContext = context;
		munion = unions;
		mInflater = LayoutInflater.from(context);
		aq = new AQuery(mContext);
	}

	@Override
	public int getCount() {
		return munion.size();
	}

	@Override
	public Object getItem(int position) {
		return munion.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	// 刷新列表中的数据
	public void refresh(ArrayList<Union> list) {
		munion = list;
		notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		UnionItemHolder unionItemHolder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_union, null);
			unionItemHolder = new UnionItemHolder();
			unionItemHolder.imgUnion = (ImageView) convertView
					.findViewById(R.id.img_uninon);
			unionItemHolder.tvUnionName = (TextView) convertView
					.findViewById(R.id.tv_union_name);
			unionItemHolder.tvUnionType = (TextView) convertView.findViewById(R.id.tv_union_type);
			unionItemHolder.tvUnionContact= (TextView) convertView.findViewById(R.id.tv_union_contact);
			unionItemHolder.tvUnionBannar= (TextView) convertView.findViewById(R.id.tv_union_bannar);
			convertView.setTag(unionItemHolder);
		} else {
			unionItemHolder = (UnionItemHolder) convertView.getTag();
		}
		AQuery aqImg = new AQuery(unionItemHolder.imgUnion);
		Union union = munion.get(position);
		if (null != union.getPicUnion() &&  !union.getPicUnion().getFileUrl(mContext).isEmpty()) {
			String url = union.getPicUnion().getFileUrl(mContext);
			if(url != null && !url.isEmpty()) {
				//shouldDelay(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent, String url)
				if(!aqImg.shouldDelay(position, false, convertView, parent, url))
					aqImg.image(url, true, true, 240, 0, null, android.R.anim.fade_in, 0.8f);
			}
			else {
				aqImg.id(R.id.img_uninon).image(R.drawable.ic_app);
			}
		}







		unionItemHolder.tvUnionName.setText(munion.get(position).getName());
		unionItemHolder.tvUnionType.setText(munion.get(position).getType());
		unionItemHolder.tvUnionContact.setText(munion.get(position).getSlogan());
		unionItemHolder.tvUnionBannar.setText(munion.get(position).getBannar());
		return convertView;
	}
	
}
