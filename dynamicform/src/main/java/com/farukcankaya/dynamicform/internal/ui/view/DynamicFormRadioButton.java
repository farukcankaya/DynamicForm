package com.farukcankaya.dynamicform.internal.ui.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

import com.farukcankaya.dynamicform.DynamicForm;
import com.farukcankaya.dynamicform.R;
import com.farukcankaya.dynamicform.internal.utils.FontCache;

/**
 * Created by farukcankaya on 09/11/2017.
 */

public class DynamicFormRadioButton extends AppCompatRadioButton {
    public DynamicFormRadioButton(Context context) {
        this(context, null);
    }

    public DynamicFormRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.dynamicFormRadioButtonStyle);
    }

    public DynamicFormRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
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
