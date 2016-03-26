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
public class BottomSheetCoordinatorLayout2 extends CoordinatorLayout {

    private int touchSlop;
    private boolean shouldIntercept;
    private boolean appBarCanScrollDown;
    private boolean userIsScrollingUp;
    private float lastY;
    private float startY;

    private AppBarLayout appBarLayout;
    private NestedScrollView siblingView;

    public BottomSheetCoordinatorLayout2(Context context) {
        this(context, null);
    }

    public BottomSheetCoordinatorLayout2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomSheetCoordinatorLayout2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(Color.WHITE);

        touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        inflate(context, R.layout.sheet_content, this);
    }


    /**
     * From the appbar we determine if it can scroll down.
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        siblingView = (NestedScrollView) findViewById(R.id.sheet_sibling);
        appBarLayout = (AppBarLayout) findViewById(R.id.sheet_appbar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                appBarCanScrollDown = verticalOffset != 0;
            }
        });
    }

    /**
     * From onInterceptTouchEvent we determine if the finger is scrolling UP.
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (MotionEventCompat.getActionMasked(event)) {
            case MotionEvent.ACTION_DOWN:
                startY = event.getY();
                lastY = startY;
                userIsScrollingUp = false;
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                userIsScrollingUp = false;
                break;
            case MotionEvent.ACTION_MOVE:
                lastY = event.getY();
                float yDeltaTotal = startY - lastY;
                if (yDeltaTotal > touchSlop) { // Moving the finger up.
                    userIsScrollingUp = true;
                }
                break;
        }

        shouldIntercept = appBarCanScrollDown || userIsScrollingUp;
        if (shouldIntercept) {
            requestDisallowInterceptTouchEvent(true);
        }

        return super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }
}
