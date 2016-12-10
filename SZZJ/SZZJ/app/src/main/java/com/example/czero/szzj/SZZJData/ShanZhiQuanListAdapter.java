package com.example.czero.szzj.SZZJData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.bumptech.glide.Glide;
import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJModel.ShanZhiQuan;
import com.example.czero.szzj.SZZJModel.User;
import com.example.czero.szzj.SZZJUtil.GlideCircleTransform;
import com.example.czero.szzj.SZZJView.LoginActivity;
import com.example.czero.szzj.Tab.ShanZhiQuanActivity;
import com.wx.goodview.GoodView;

import java.util.ArrayList;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.UpdateListener;

/**
 * 适配器--适配二手交易物品列表数据
 * @date 2014-9-15
 * @author Stone
 */
public class ShanZhiQuanListAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater = null;
	private AQuery aq;
	private ArrayList<ShanZhiQuan> mShanZhiQuan = null;
	private User user;

	public ShanZhiQuanListAdapter(Context context, ArrayList<ShanZhiQuan> shanzhiquan) {
		mContext = context;
		mShanZhiQuan = shanzhiquan;
		mInflater = LayoutInflater.from(context);
		aq = new AQuery(mContext);

	}

	@Override
	public int getCount() {
		return mShanZhiQuan.size();

	}

	@Override
	public Object getItem(int position) {
		return mShanZhiQuan.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	// 刷新列表中的数据
	public void refresh(ArrayList<ShanZhiQuan> list) {
		mShanZhiQuan = list;
		notifyDataSetChanged();
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final ShanZhiQuanItemHolder shanZhiQuanItemHolders;

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_amusetalk, null);
			shanZhiQuanItemHolders =new ShanZhiQuanItemHolder();
			shanZhiQuanItemHolders.tv_name= (TextView) convertView.findViewById(R.id.username);
			shanZhiQuanItemHolders.tv_content = (TextView) convertView
					.findViewById(R.id.tv_amusetalk_content);
			shanZhiQuanItemHolders.tvTradeItemTime = (TextView) convertView
					.findViewById(R.id.tv_trade_item_time);
			shanZhiQuanItemHolders.tv_device = (TextView) convertView.findViewById(R.id.device);
			shanZhiQuanItemHolders.lovenumber= (TextView) convertView.findViewById(R.id.lovenumber);
			shanZhiQuanItemHolders.lovebtn= (ImageView) convertView.findViewById(R.id.btnlove);
			user = BmobUser.getCurrentUser(mContext, User.class);
			final ShanZhiQuan shanZhiQuan = new ShanZhiQuan();
			if (mShanZhiQuan.get(position).getIslove() ==null){
				shanZhiQuanItemHolders.lovebtn.setImageResource(R.drawable.ic_love);
			}else {
				shanZhiQuanItemHolders.lovebtn.setImageResource(R.drawable.ic_lovecheck);
			}
			shanZhiQuanItemHolders.lovebtn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(final View view) {
					final ShanZhiQuanActivity shanZhiQuanActivity = new ShanZhiQuanActivity();
					shanZhiQuanItemHolders.lovebtn.setEnabled(false);
					mShanZhiQuan.get(position).setIslove(true);
					if(user==null){
						Toast.makeText(mContext, "请先登陆", Toast.LENGTH_SHORT).show();
						Intent i = new Intent(mContext, LoginActivity.class);
						mContext.startActivity(i);
					}else {

						shanZhiQuan.increment("lovenumber");
						String id = mShanZhiQuan.get(position).getObjectId();
						final GoodView goodView = new GoodView(mContext);
						shanZhiQuan.update(mContext, id, new UpdateListener() {
							@Override
							public void onSuccess() {
								goodView.setText("+1");
								goodView.show(view);
								shanZhiQuanItemHolders.lovebtn.setImageResource(R.drawable.ic_lovecheck);

							}

							@Override
							public void onFailure(int i, String s) {
								Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
							}
						});
					}
				}
			});

			convertView.setTag(shanZhiQuanItemHolders);
		} else {
			shanZhiQuanItemHolders = (ShanZhiQuanItemHolder) convertView.getTag();
		}


//		try {
//		shanZhiQuanItemHolders.lovenumber.setText(Integer.parseInt(mShanZhiQuan.get(position).getLovenumber().toString()));
//		} catch(NumberFormatException nfe) {
//			System.out.println("Could not parse " + nfe);
//		}
		shanZhiQuanItemHolders.lovenumber.setText(mShanZhiQuan.get(position).getLovenumber()+" ");
		shanZhiQuanItemHolders.tv_content.setText(mShanZhiQuan.get(position).getContent());
		shanZhiQuanItemHolders.tv_name.setText(mShanZhiQuan.get(position).getUsername());
		shanZhiQuanItemHolders.tv_device.setText(mShanZhiQuan.get(position).getDevice());
		shanZhiQuanItemHolders.tvTradeItemTime.setText(mShanZhiQuan.get(position).getCreatedAt());

		return convertView;
	}
	
}