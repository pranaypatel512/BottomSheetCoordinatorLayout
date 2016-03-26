package com.miav.bottomsheetcoordinatorlayout;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout root;
    private BottomSheetCoordinatorLayout bottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomSheet = new BottomSheetCoordinatorLayout(this);
        root = (CoordinatorLayout) findViewById(R.id.root);

        CoordinatorLayout.LayoutParams params =
                new CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        params.setBehavior(new BottomSheetBehavior());
        root.addView(bottomSheet, params);

        bottomSheet.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                bottomSheet.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
    }


}
