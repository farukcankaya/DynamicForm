package com.farukcankaya.dynamicformdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.farukcankaya.dynamicform.DynamicForm;
import com.farukcankaya.dynamicform.internal.ui.BaseDynamicFormActivity;

import java.util.List;

/**
 * Created by farukcankaya on 09/11/2017.
 */

public class CustomDynamicFormActivity extends BaseDynamicFormActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dynamic_form);

        recyclerView = (RecyclerView) findViewById(R.id.rv_dynamic_form);
        setRecyclerViewLayoutManager(recyclerView);
        setupAdapter(recyclerView);

        button = (Button) findViewById(R.id.btn_verify);
        button.setText(getFormTemplate().getSubmit().getLabel());

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        List<String> errors = DynamicForm.getValidationErrors(getFormTemplate());
        if (errors.size() > 0) {
            Toast.makeText(this, errors.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        String form = DynamicForm.exportValues(getFormTemplate());
        Toast.makeText(this, form, Toast.LENGTH_SHORT).show();
    }
}
