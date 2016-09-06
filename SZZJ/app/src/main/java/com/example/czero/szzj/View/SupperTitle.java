package com.example.czero.szzj.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.czero.szzj.R;


public class SupperTitle extends RelativeLayout {
    private RelativeLayout supper_title;

    private ImageView titleback;
    private TextView mTitle;
    private LinearLayout mLeftAll, bar;


    public SupperTitle(Context mContext) {
        super(mContext);
        initView(mContext, null);
    }

    public SupperTitle(Context mContext, AttributeSet mAttrs) {
        super(mContext, mAttrs);
        initView(mContext, mAttrs);
    }

    public SupperTitle(Context mContext, AttributeSet mAttrs, int mDefStyle) {
        super(mContext, mAttrs, mDefStyle);
        initView(mContext, mAttrs);
    }

    private void initView(Context mContext, AttributeSet mAttrs) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        RelativeLayout layout = (RelativeLayout) mInflater.inflate(
                R.layout.common_supper_title, this, true);

        //整个supper_title
        supper_title = (RelativeLayout) layout.findViewById(R.id.supper_title);
        titleback= (ImageView) findViewById(R.id.titleback);
        bar = (LinearLayout) layout.findViewById(R.id.bar);

        //中间布局
        mTitle = (TextView) layout.findViewById(R.id.title);

        //提示布局

        initAttr(mContext, mAttrs);
    }


    private void initAttr(Context mContext, AttributeSet mAttrs) {
        if (mAttrs == null) return;
        TypedArray a = mContext.obtainStyledAttributes(mAttrs, R.styleable.SupperTitle);
        //title

        //整个title高度
        if (a.getDimension(R.styleable.SupperTitle_barHeight, -1) != -1) {
            setHeight((int) a.getDimension(R.styleable.SupperTitle_barHeight, 0));
        }

        Log.d("setBar", "setBackground: " + a.getColor(R.styleable.SupperTitle_barBackground, -1));
        //整个title颜色
        if (a.getColor(R.styleable.SupperTitle_barBackground, -1) != -1) {
            setBackground(a.getColor(R.styleable.SupperTitle_barBackground, -1));
        }
        //leftTitle


        a.recycle();
    }


    /******************************************
     * 整个title  及属性设置
     **/
    public void setBackground(int color) {
        if (bar == null || color == -1) return;
        bar.setBackgroundColor(color);

    }

    public void setTitleBackground(int color) {
        bar.setBackgroundColor(color);

    }

    public void setHeight(int height) {
        if (supper_title == null) return;
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) supper_title.getLayoutParams();//取控件textView当前的布局参数
        params.height = height;// 控件的高度
        supper_title.setLayoutParams(params);
    }

    public void setPadding(int left, int top, int right, int bottom) {

        try {
            if (supper_title == null) return;
//            supper_title.setPadding((int) ScreenUtils.dpToPx(BaseApplication.getContext(), left), (int) ScreenUtils.dpToPx(BaseApplication.getContext(), top), (int) ScreenUtils.dpToPx(BaseApplication.getContext(), right), (int) ScreenUtils.dpToPx(BaseApplication.getContext(), bottom));

        } catch (StackOverflowError e) {

            ;
        }

    }


    public void setTitle(String text) {
        if (mTitle == null) return;
        mTitle.setVisibility(VISIBLE);
        mTitle.setText(text);
    }


    /****************************
     * 左边布局
     **/

    public void setOnLeftClickListener(OnClickListener listener) {
        if (titleback == null) return;
        titleback.setVisibility(VISIBLE);
        titleback.setOnClickListener(listener);
    }


    /**
     * 通过padding方法的沉浸色
     *
     * @param mWindow
     */
    public void setPaddingImmersionColor(Window mWindow) {
        if (mWindow == null) return;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            mWindow.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            //mWindow.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            int l = bar.getPaddingLeft();
            int r = bar.getPaddingRight();
            int t = bar.getPaddingTop();
            int b = bar.getPaddingBottom();
            int h = getStatusBarHeight();
            bar.setClipToPadding(false);
            bar.setFitsSystemWindows(false);
            bar.setPadding(l, t + h, r, b);


        }

    }

    /**
     * 获得状态栏的高度
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
