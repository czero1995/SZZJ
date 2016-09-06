package com.example.czero.szzj.SZZJData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJModel.Course;
import com.example.czero.szzj.SZZJModel.Love;

import java.util.ArrayList;

/**
 * 适配器--适配二手交易物品列表数据
 * @date 2014-9-15
 * @author Stone
 */
public class CourseItemListAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater = null;
	private ArrayList<Course> mCourse = null; //物品列表

	public CourseItemListAdapter(Context context, ArrayList<Course> courses) {
		mContext = context;
		mCourse = courses;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return mCourse.size();
	}

	@Override
	public Object getItem(int position) {
		return mCourse.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	// 刷新列表中的数据
	public void refresh(ArrayList<Course> list) {
		mCourse = list;
		notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CourseItemHolder courseItemHolder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_course, null);
			courseItemHolder = new CourseItemHolder();

			courseItemHolder.Mondayone=(TextView) convertView.findViewById(R.id.Mondayone);
			courseItemHolder.Mondaythree = (TextView) convertView.findViewById(R.id.Mondaythree);
			courseItemHolder.Mondayfive = (TextView) convertView.findViewById(R.id.Mondayfive);
			courseItemHolder.Tuesdayone = (TextView) convertView.findViewById(R.id.Tuesdayone);
			courseItemHolder.Tuesdaythree = (TextView) convertView.findViewById(R.id.Tuesdaythree);
			courseItemHolder.Tuesdayfive = (TextView) convertView.findViewById(R.id.Tuesdayfive);
			courseItemHolder.Wednesdayone = (TextView) convertView.findViewById(R.id.Wednesdayone);
			courseItemHolder.Wednesdaythree = (TextView) convertView.findViewById(R.id.Wednesdaythree);
			courseItemHolder.Wednesdayfive = (TextView) convertView.findViewById(R.id.Wednesdayfive);
			courseItemHolder.Thursdayone = (TextView) convertView.findViewById(R.id.Thursdayone);
			courseItemHolder.Thursdaythree = (TextView) convertView.findViewById(R.id.Thursdaythree);
			courseItemHolder.Thursdayfive = (TextView) convertView.findViewById(R.id.Thursdayfive);
			courseItemHolder.Firdayone = (TextView) convertView.findViewById(R.id.Firdayone);
			courseItemHolder.Firdaythree = (TextView) convertView.findViewById(R.id.Firdaythree);
			courseItemHolder.Firdayfive = (TextView) convertView.findViewById(R.id.Firdayfive);
			convertView.setTag(courseItemHolder);

		} else {
			courseItemHolder = (CourseItemHolder) convertView.getTag();
		}

                                                                                                                                           		courseItemHolder.Mondayone.setText(mCourse.get(position).getMondayone());
		courseItemHolder.Mondaythree.setText(mCourse.get(position).getMondaythree());
		courseItemHolder.Mondayfive.setText(mCourse.get(position).getMondayfive());
		courseItemHolder.Tuesdayone.setText(mCourse.get(position).getTuesdayone());
		courseItemHolder.Tuesdaythree.setText(mCourse.get(position).getTuesdaythree());
		courseItemHolder.Tuesdayfive.setText(mCourse.get(position).getTuesdayfive());
		courseItemHolder.Wednesdayone.setText(mCourse.get(position).getWednesdayone());
		courseItemHolder.Wednesdaythree.setText(mCourse.get(position).getWednesdaythree());
		courseItemHolder.Wednesdayfive.setText(mCourse.get(position).getWednesdayfive());
		courseItemHolder.Thursdayone.setText(mCourse.get(position).getThursdayone());
		courseItemHolder.Thursdaythree.setText(mCourse.get(position).getThursdaythree());
		courseItemHolder.Thursdayfive.setText(mCourse.get(position).getThursdayfive());
		courseItemHolder.Firdayone.setText(mCourse.get(position).getFirdayone());
		courseItemHolder.Firdaythree.setText(mCourse.get(position).getFirdaythree());
		courseItemHolder.Firdayfive.setText(mCourse.get(position).getFirdayfive());
		return convertView;
	}
	
}
