package com.lin.login.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.lin.login.R;

/**
 * Created by linweilin on 2017/3/8.
 */

public class CircleView extends View {

    Paint p = new Paint();
    public float currentX = 50;
    public float currentY = 50;
    public int textColor;
    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        textColor = array.getColor(R.styleable.CircleView_TextColor, Color.BLUE);
        array.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.BLUE);
        canvas.drawCircle(currentX,currentY,300,p);
//        p.setColor(textColor);
//        canvas.drawText("YY",currentX - 30,currentY + 50,p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX = event.getX();
        currentY = event.getY();
        invalidate();
        return true;
    }
}
