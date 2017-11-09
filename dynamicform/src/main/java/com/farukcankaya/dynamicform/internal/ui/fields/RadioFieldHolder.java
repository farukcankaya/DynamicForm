package com.farukcankaya.dynamicform.internal.ui.fields;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.farukcankaya.dynamicform.R;
import com.farukcankaya.dynamicform.internal.model.fields.RadioField;
import com.farukcankaya.dynamicform.internal.model.fields.options.FieldOption;
import com.farukcankaya.dynamicform.internal.utils.Utility;

import java.util.List;

/**
 * Created by farukcankaya on 09/11/2017.
 */

public class RadioFieldHolder extends BaseHolder implements RadioGroup.OnCheckedChangeListener {
    private TextView labelTextView;
    private RadioGroup fieldRadioGroup;

    public RadioFieldHolder(View itemView) {
        super(itemView);
        labelTextView = (TextView) itemView.findViewById(R.id.label);
        fieldRadioGroup = (RadioGroup) itemView.findViewById(R.id.field);
    }

    @Override
    void bind() {
        if (TextUtils.isEmpty(field.getLabel())) {
            labelTextView.setVisibility(View.GONE);
        } else {
            labelTextView.setVisibility(View.VISIBLE);
            labelTextView.setText(field.getLabel());
        }

        fieldRadioGroup.removeAllViews();
        List<FieldOption> fieldOptions = getField().getOptions();
        for (int i = 0; i < fieldOptions.size(); i++) {
            final FieldOption fieldOption = fieldOptions.get(i);
            if (fieldOption.getId() == 0) {
                fieldOption.setId(Utility.generateUniqueViewId());
            }
            RadioButton radioButton = new RadioButton(itemView.getContext());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            radioButton.setId(fieldOption.getId());
            radioButton.setLayoutParams(params);
            radioButton.setText(fieldOption.getLabel());
            radioButton.setChecked(fieldOption.isChecked());
            fieldRadioGroup.addView(radioButton);
        }
        fieldRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    String getValue() {
        return getField().getValue().toString();
    }

    @Override
    RadioField getField() {
        return (RadioField) field;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (FieldOption fieldOption : getField().getOptions()) {
            fieldOption.setChecked(fieldOption.getId() == checkedId);
            getField().setValue(fieldOption.getValue());
        }
    }
}
