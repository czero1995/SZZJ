package com.example.czero.szzj.SZZJView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

public class ChiziCM extends TextView {


	public ChiziCM(Context context) {
		super(context);
		 init();
	}

	public ChiziCM(Context context, AttributeSet attrs) {
		super(context, attrs);
		 init();
	}

	private void init(){
		setGravity(Gravity.BOTTOM);
	}
	
	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		
		float mmWidth = ((float)getWidth())/10;
		Paint p = new Paint();
		p.setColor(Color.WHITE);
		float top = 2;
		for (int i = 0; i < 15; i++) {
//			canvas.drawRect(i*mmWidth,top,i*mmWidth+8, top+mmWidth,p);
			if (i%2==0) {
				canvas.drawRect(i*mmWidth,top,i*mmWidth+8, top+mmWidth,p);
//				canvas.drawLine(i*mmWidth,top,i*mmWidth+mmWidth, top+mmWidth,p);
//				canvas.drawLine(60, 40, 100, 40, p);// 画线
			}

		}
	}
}
