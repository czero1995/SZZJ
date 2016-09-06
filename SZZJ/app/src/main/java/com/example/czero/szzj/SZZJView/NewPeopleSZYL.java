package com.example.czero.szzj.SZZJView;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import com.example.czero.szzj.R;
import com.example.czero.szzj.View.backactivity.BaseActivity;

/**
 * Created by zake on 6/12/16.
 */
public class NewPeopleSZYL extends BaseActivity implements OnTouchListener {
    private ImageView myImageView;
    //模式
    static final int NONE=0;
    static final int DRAG=1;
    static final int ZOOM=2;
    int mode=NONE;
    Matrix matrix = new Matrix();
    Matrix savedMatrix = new Matrix();

    PointF start = new PointF();
    PointF mid = new PointF();
    float oldDist;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpeople_szyl);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        myImageView= (ImageView) findViewById(R.id.myImage);
        myImageView.setOnTouchListener(this);


    }


    public boolean onTouch(View v, MotionEvent event) {
        ImageView myImageView=(ImageView) v;
        switch(event.getAction()&MotionEvent.ACTION_MASK){
            //设置拖拉模式
            case MotionEvent.ACTION_DOWN:
                matrix.set(myImageView.getImageMatrix());
                savedMatrix.set(matrix);
                start.set(event.getX(),event.getY());
                mode=DRAG;
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                mode=NONE;
                break;

            //设置多点触摸模式
            case MotionEvent.ACTION_POINTER_DOWN:
                oldDist=spacing(event);
                if(oldDist>10f){
                    savedMatrix.set(matrix);
                    midPoint(mid, event);
                    mode=ZOOM;
                }
                break;
            //若为DRAG模式，则点击移动图片
            case MotionEvent.ACTION_MOVE:
                if(mode==DRAG){
                    matrix.set(savedMatrix);
                    matrix.postTranslate(event.getX()-start.x,event.getY()-start.y);
                }
                //若为ZOOM模式，则点击触摸缩放
                else if(mode==ZOOM){
                    float newDist=spacing(event);
                    if(newDist>10f){
                        matrix.set(savedMatrix);
                        float scale=newDist/oldDist;
                        //设置硕放比例和图片的中点位置
                        matrix.postScale(scale,scale, mid.x,mid.y);
                    }
                }
                break;
        }
        myImageView.setImageMatrix(matrix);
        return true;
    }
    //计算移动距离
    private float spacing(MotionEvent event){
        float x=event.getX(0)-event.getX(1);
        float y=event.getY(0)-event.getY(1);
        return (x*x+y*y);
    }
    //计算中点位置
    private void midPoint(PointF point,MotionEvent event){
        float x=event.getX(0)+event.getX(1);
        float y=event.getY(0)+event.getY(1);
        point.set(x/2,y/2);
    }
}