package com.farukcankaya.dynamicform.internal.ui.view;

import android.content.Context;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

import com.farukcankaya.dynamicform.R;

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
    }
}
