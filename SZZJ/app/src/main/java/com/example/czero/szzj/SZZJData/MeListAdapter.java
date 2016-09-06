package com.example.czero.szzj.SZZJData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.czero.szzj.R;

/**
 * Created by zake on 5/21/16.
 */
public class MeListAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mItemNames;
    private String[] mItemContents;
    private int[] mItemImgIds;
    private LayoutInflater mInflater = null;

    public MeListAdapter(Context context, String[] names, String[] contents, int[] imgIds) {
        mContext = context;
        mItemNames = names;
        mItemContents = contents;
        mItemImgIds = imgIds;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mItemNames.length;
    }

    @Override
    public Object getItem(int position) {
        return mItemNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HappyListHolder holder;
        if(convertView == null){
            convertView=mInflater.inflate(R.layout.minelist_item,null);
            holder = new HappyListHolder();
            holder.imgItem = (ImageView) convertView.findViewById(R.id.img_item);
            holder.tvItemName= (TextView) convertView.findViewById(R.id.tv_item_name);
            holder.tvItemContent= (TextView) convertView.findViewById(R.id.tv_item_content);
            convertView.setTag(holder);
        }else{
            holder= (HappyListHolder) convertView.getTag();
        }
        holder.imgItem.setBackgroundResource(mItemImgIds[position]);
        holder.tvItemName.setText(mItemNames[position]);
        holder.tvItemContent.setText(mItemContents[position]);
        return convertView;
    }
    public class HappyListHolder {

        public ImageView imgItem;		//项目Icon
        public TextView tvItemName;		//项目名称
        public TextView tvItemContent;	//项目值

    }

}
