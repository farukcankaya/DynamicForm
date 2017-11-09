package com.farukcankaya.dynamicform.internal.ui.fields;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.farukcankaya.dynamicform.R;
import com.farukcankaya.dynamicform.internal.model.fields.TextField;
import com.farukcankaya.dynamicform.internal.model.fields.constraints.FieldConstraint;
import com.farukcankaya.dynamicform.internal.model.fields.constraints.Limit;
import com.farukcankaya.dynamicform.internal.utils.Utility;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public class TextFieldHolder extends BaseHolder implements TextWatcher {
    private TextView labelTextView;
    private EditText fieldEditText;

    public TextFieldHolder(View itemView) {
        super(itemView);
        labelTextView = (TextView) itemView.findViewById(R.id.label);
        fieldEditText = (EditText) itemView.findViewById(R.id.field);
        fieldEditText.addTextChangedListener(this);
    }

    @Override
    void bind() {
        if (field.getValue() != null && !TextUtils.isEmpty(field.getValue().toString())) {
            fieldEditText.setText(field.getValue().toString());
        }

        if (!TextUtils.isEmpty(field.getHint())) {
            fieldEditText.setHint(field.getHint());
        }

        if (TextUtils.isEmpty(field.getLabel())) {
            labelTextView.setVisibility(View.GONE);
        } else {
            labelTextView.setVisibility(View.VISIBLE);
            labelTextView.setText(field.getLabel());
        }

        FieldConstraint fieldConstraint = getField().getConstraint();
        if (fieldConstraint != null) {
            if (fieldConstraint.getInputType() != null) {
                fieldEditText.setInputType(Utility.getInputType(fieldConstraint.getInputType()));
            }

            Limit limit = fieldConstraint.getLimit();
            if (limit != null) {
                if (limit.getMax() != null) {
                    InputFilter[] filters = new InputFilter[1];
                    filters[0] = new InputFilter.LengthFilter(Integer.parseInt(limit.getMax()));
                    fieldEditText.setFilters(filters);
                }
            }
        }
    }

    @Override
    String getValue() {
        return fieldEditText.getText().toString();
    }

    @Override
    TextField getField() {
        return (TextField) field;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        field.setValue(s.toString());
    }
}
