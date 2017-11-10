package com.farukcankaya.dynamicform.internal.ui.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.farukcankaya.dynamicform.DynamicForm;
import com.farukcankaya.dynamicform.R;
import com.farukcankaya.dynamicform.internal.utils.FontCache;

/**
 * Created by farukcankaya on 10/11/2017.
 */

public class DynamicFormEditText extends AppCompatEditText {

    public DynamicFormEditText(Context context) {
        this(context, null);
    }

    public DynamicFormEditText(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.dynamicFormEditTextStyle);
    }

    public DynamicFormEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context, attrs);
    }

    private void initializeViews(Context context, AttributeSet attrs) {
        setFont(DynamicForm.FONT);
    }

    public void setFont(String font) {
        if (font == null) {
            return;
        }
        Typeface tf = FontCache.get(getContext(), font);
        if (tf != null) {
            setTypeface(tf);
        }
    }
}
