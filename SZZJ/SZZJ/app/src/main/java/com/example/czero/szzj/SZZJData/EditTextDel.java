package com.example.czero.szzj.SZZJData;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EditText;

import com.example.czero.szzj.R;

/**
 * Created by zake on 6/10/16.
 */
public class EditTextDel extends EditText {
    private final static String TAG = "EditTextDel";
    private Drawable imgInable;
    private Drawable imgAble;
    private Context mContext;

    public EditTextDel(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public EditTextDel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        init();
    }

    public EditTextDel(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
//        imgInable = mContext.getResources().getDrawable(R.mipmap.delete_gray);
        imgAble = mContext.getResources().getDrawable(R.mipmap.delete);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {
                setDrawable();
            }
        });
        setDrawable();
    }


    private void setDrawable() {
        if(length() < 1)
            setCompoundDrawablesWithIntrinsicBounds(null, null, imgInable, null);
        else
            setCompoundDrawablesWithIntrinsicBounds(null, null, imgAble, null);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (imgAble != null && event.getAction() == MotionEvent.ACTION_UP) {
            int eventX = (int) event.getRawX();
            int eventY = (int) event.getRawY();
            Log.e(TAG, "eventX = " + eventX + "; eventY = " + eventY);
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            rect.left = rect.right - 50;
            if(rect.contains(eventX, eventY))
                setText("");
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

}