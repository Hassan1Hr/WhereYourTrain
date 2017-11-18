package com.example.hassan.know_your_train.custom_views;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.util.AttributeSet;
import android.view.View;

public class InstantAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    public InstantAutoCompleteTextView(Context context) {
        super(context);
    }

    public InstantAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InstantAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean enoughToFilter() {
        return true;
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (getWindowVisibility() == View.GONE) {
            return;
        }

        if (focused && getAdapter() != null) {
            performFiltering(getText(), 0);
            showDropDown();
        }
    }

    @Override
    public boolean performClick() {
        showDropDown();
        return super.performClick();
    }
}
