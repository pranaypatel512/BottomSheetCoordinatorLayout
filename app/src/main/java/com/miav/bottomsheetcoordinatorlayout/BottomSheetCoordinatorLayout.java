package com.miav.bottomsheetcoordinatorlayout;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;


@CoordinatorLayout.DefaultBehavior(BottomSheetBehavior.class)
public class BottomSheetCoordinatorLayout extends CoordinatorLayout {


    public BottomSheetCoordinatorLayout(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
        inflate(context, R.layout.sheet_content, this);
    }

    public BottomSheetCoordinatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.WHITE);
        inflate(context, R.layout.sheet_content, this);
    }

    public BottomSheetCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(Color.WHITE);
        inflate(context, R.layout.sheet_content, this);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return super.onInterceptTouchEvent(event);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }
}
