package com.farukcankaya.dynamicform.internal.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.farukcankaya.dynamicform.internal.configuration.DynamicFormConfiguration;
import com.farukcankaya.dynamicform.internal.model.FormTemplate;
import com.farukcankaya.dynamicform.internal.ui.preview.FieldAdapter;
import com.farukcankaya.dynamicform.internal.utils.Utility;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public abstract class BaseDynamicFormActivity extends AppCompatActivity {
    private static final String KEY_FORM_TEMPLATE = "dynamicform.form.template";
    protected FormTemplate formTemplate;
    protected LinearLayoutManager recyclerViewLayoutManager;
    protected FieldAdapter fieldAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        formTemplate = extractFormTemplate(savedInstanceState);
    }

    protected FormTemplate extractFormTemplate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            String form = savedInstanceState.getString(KEY_FORM_TEMPLATE);
            if (form != null) {
                FormTemplate formTemplate = Utility.getGson().fromJson(form, FormTemplate.class);
                return formTemplate;
            }
        }
        if (getIntent().hasExtra(DynamicFormConfiguration.Arguments.FORM)) {
            String form = getIntent().getStringExtra(DynamicFormConfiguration.Arguments.FORM);
            FormTemplate formTemplate = Utility.getGson().fromJson(form, FormTemplate.class);
            return formTemplate;
        }
        return null;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_FORM_TEMPLATE, Utility.getGson().toJson(formTemplate));
        super.onSaveInstanceState(outState);
    }

    protected void setupAdapter(RecyclerView recyclerView) {
        fieldAdapter = new FieldAdapter(formTemplate);
        recyclerView.setAdapter(fieldAdapter);
    }

    protected void setRecyclerViewLayoutManager(RecyclerView recyclerView) {
        int scrollPosition = 0;
        if (recyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        recyclerViewLayoutManager = recyclerViewLayoutManager == null ? new LinearLayoutManager(this) : recyclerViewLayoutManager;

        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.scrollToPosition(scrollPosition);
    }

    public LinearLayoutManager getRecyclerViewLayoutManager() {
        return recyclerViewLayoutManager;
    }

    public void setRecyclerViewLayoutManager(LinearLayoutManager recyclerViewLayoutManager) {
        this.recyclerViewLayoutManager = recyclerViewLayoutManager;
    }

    public FormTemplate getFormTemplate() {
        return formTemplate;
    }
}
