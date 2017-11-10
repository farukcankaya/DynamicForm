package com.farukcankaya.dynamicformdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.farukcankaya.dynamicform.DynamicForm;
import com.farukcankaya.dynamicform.internal.configuration.DynamicFormConfiguration;
import com.farukcankaya.dynamicform.internal.utils.Utility;

public class MainActivity extends AppCompatActivity {
    DynamicForm dynamicForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DynamicFormConfiguration configuration = new DynamicFormConfiguration.Builder(this)
                .setRequestCode(22)
                .setForm(Utility.loadJSONFromAsset(this, "data.json"))
                .setFont("Roboto-Bold.ttf")
                .build();
        dynamicForm = new DynamicForm(configuration);
        dynamicForm.previewDynamicForm(CustomDynamicFormActivity.class);
    }
}
