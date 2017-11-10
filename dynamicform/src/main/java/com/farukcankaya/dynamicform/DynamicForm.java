package com.farukcankaya.dynamicform;

import android.app.Activity;
import android.content.Intent;

import com.farukcankaya.dynamicform.internal.configuration.DynamicFormConfiguration;
import com.farukcankaya.dynamicform.internal.model.FormTemplate;
import com.farukcankaya.dynamicform.internal.model.fields.Field;
import com.farukcankaya.dynamicform.internal.ui.preview.DynamicFormActivity;
import com.farukcankaya.dynamicform.internal.utils.Utility;
import com.farukcankaya.dynamicform.internal.utils.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public class DynamicForm {

    private DynamicFormConfiguration dynamicFormConfiguration;
    private FormTemplate formTemplate;
    public static String FONT;

    public DynamicForm(DynamicFormConfiguration dynamicFormConfiguration) {
        this.dynamicFormConfiguration = dynamicFormConfiguration;
        if (dynamicFormConfiguration.getForm() != null) {
            formTemplate = Utility.getGson().fromJson(dynamicFormConfiguration.getForm(), FormTemplate.class);
            Utility.setDefaultValues(formTemplate.getFields());
        }
        FONT = dynamicFormConfiguration.getFont();
    }

    public void previewDynamicForm() {
        previewDynamicForm(DynamicFormActivity.class);
    }

    public void previewDynamicForm(Class<?> dynamicFormClass) {
        if (dynamicFormConfiguration == null || (dynamicFormConfiguration.getActivity() == null && dynamicFormConfiguration.getFragment() == null)) {
            return;
        }
        Activity activity = dynamicFormConfiguration.getActivity() != null ?
                dynamicFormConfiguration.getActivity() :
                dynamicFormConfiguration.getFragment().getActivity();
        Intent intent = new Intent(activity, dynamicFormClass);
        intent.putExtra(DynamicFormConfiguration.Arguments.REQUEST_CODE, dynamicFormConfiguration.getRequestCode());
        intent.putExtra(DynamicFormConfiguration.Arguments.FORM, dynamicFormConfiguration.getForm());

        if (dynamicFormConfiguration.getFragment() != null) {
            dynamicFormConfiguration.getFragment().startActivityForResult(intent, dynamicFormConfiguration.getRequestCode());
        } else {
            activity.startActivityForResult(intent, dynamicFormConfiguration.getRequestCode());
        }
    }

    public List<Field> createFieldViews() {
        if (dynamicFormConfiguration == null || (dynamicFormConfiguration.getActivity() == null && dynamicFormConfiguration.getFragment() == null)) {
            return null;
        }
        return null;
    }

    public String exportForm() {
        return "";
    }

    public static String exportValues(FormTemplate formTemplate) {
        if (formTemplate == null) {
            return null;
        }
        List<Field> fields = formTemplate.getFields();
        HashMap<String, Object> fieldResponse = new HashMap<>(fields.size());
        for (Field field : fields) {
            fieldResponse.put(field.getFieldName(), field.getValue());
        }
        return Utility.getGson().toJson(fieldResponse);
    }

    public static List<String> getValidationErrors(FormTemplate formTemplate) {
        if (formTemplate == null) {
            return null;
        }

        List<Field> fields = formTemplate.getFields();
        List<String> errors = new ArrayList<>(fields.size());

        for (Field field : fields) {
            errors.addAll(Validator.validate(field.getValidations(), field.getValue()));
        }

        return errors;
    }
}
