package com.farukcankaya.dynamicform.internal.ui.preview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.farukcankaya.dynamicform.R;
import com.farukcankaya.dynamicform.internal.ui.BaseDynamicFormActivity;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public class DynamicFormActivity extends BaseDynamicFormActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_form);

        recyclerView = (RecyclerView) findViewById(R.id.dynamic_form);
        setRecyclerViewLayoutManager(recyclerView);
        setupAdapter(recyclerView);
    }
}
