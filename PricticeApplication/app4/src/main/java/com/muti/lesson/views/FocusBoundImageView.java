package com.muti.lesson.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;



public class FocusBoundImageView extends android.support.v7.widget.AppCompatImageView {
    Paint mPaint = new Paint();

    RectF mRect = new RectF();

    public FocusBoundImageView(Context context) {
        this(context, null);
    }

    public FocusBoundImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FocusBoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawFocusBound(canvas);
    }

    /**
     * 绘制焦点框
     *
     * @param canvas
     */
    private void drawFocusBound(Canvas canvas) {
        // 获取显示的高度
        int h = getMeasuredHeight();
        // 获取显示的宽度
        int w = getMeasuredWidth();
        float whiteStrokeWidth = 1.6f;
        float blackStrokeWidth = 1.6f;
        float whiteRadius = 6.0f;
        float blackRadius = 4.5f;


        mPaint.setColor(Color.BLACK);

        mPaint.setStrokeWidth(blackStrokeWidth);
        mPaint.setAntiAlias(true);
        mRect.bottom = h - whiteStrokeWidth - blackStrokeWidth;
        mRect.top = whiteStrokeWidth + blackStrokeWidth;
        mRect.left = whiteStrokeWidth + blackStrokeWidth;
        mRect.right = w - whiteStrokeWidth - blackStrokeWidth;
        canvas.drawRoundRect(mRect, blackRadius, blackRadius, mPaint);


        mPaint.setColor(Color.WHITE);

        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(whiteStrokeWidth);
        mRect.bottom = h - whiteStrokeWidth;
        mRect.top = whiteStrokeWidth;
        mRect.left = whiteStrokeWidth;
        mRect.right = w - whiteStrokeWidth;
        canvas.drawRoundRect(mRect, whiteRadius, whiteRadius, mPaint);
    }
}
