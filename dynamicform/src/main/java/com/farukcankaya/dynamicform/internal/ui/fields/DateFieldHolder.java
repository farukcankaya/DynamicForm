package com.farukcankaya.dynamicform.internal.ui.fields;

import android.app.DatePickerDialog;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.farukcankaya.dynamicform.R;
import com.farukcankaya.dynamicform.internal.model.fields.DateField;
import com.farukcankaya.dynamicform.internal.model.fields.constraints.FieldConstraint;
import com.farukcankaya.dynamicform.internal.model.fields.constraints.Limit;
import com.farukcankaya.dynamicform.internal.utils.Utility;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by farukcankaya on 09/11/2017.
 */

public class DateFieldHolder extends BaseHolder implements View.OnTouchListener, DatePickerDialog.OnDateSetListener {
    private TextView labelTextView;
    private EditText fieldEditText;
    private DatePickerDialog dialog;
    private boolean isShown;

    public DateFieldHolder(View itemView) {
        super(itemView);
        labelTextView = (TextView) itemView.findViewById(R.id.label);
        fieldEditText = (EditText) itemView.findViewById(R.id.field);
        fieldEditText.setOnTouchListener(this);
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
    }

    @Override
    String getValue() {
        return fieldEditText.getText().toString();
    }

    @Override
    DateField getField() {
        return (DateField) field;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        isShown = false;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);
        getField().setValue(Utility.fromDate(calendar.getTime()));
        fieldEditText.setText(getField().getValue().toString());

        dialog.dismiss();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (isShown == false) {
            isShown = true;
            Calendar c = Calendar.getInstance(Locale.getDefault());
            int year = c.get(Calendar.YEAR) - 18;
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            if (!TextUtils.isEmpty(getValue())) {
                c = Calendar.getInstance(Locale.getDefault());
                c.setTime(Utility.toDate(getValue()));

                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
            }

            dialog = new DatePickerDialog(itemView.getContext(), this, year, month, day);

            FieldConstraint fieldConstraint = getField().getConstraint();
            if (fieldConstraint != null) {
                Limit limit = fieldConstraint.getLimit();
                if (limit != null) {
                    if (limit.getMin() != null) {
                        dialog.getDatePicker().setMinDate(Utility.toDate(limit.getMin()).getTime());
                    }

                    if (limit.getMax() != null) {
                        dialog.getDatePicker().setMaxDate(Utility.toDate(limit.getMax()).getTime());
                    }
                }
            }

            dialog.show();
        }
        return true;
    }
}
