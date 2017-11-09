package com.farukcankaya.dynamicform.internal.model;

import com.farukcankaya.dynamicform.internal.model.fields.Field;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public class FormTemplate {
    @SerializedName("fields")
    List<Field> fields;
    @SerializedName("submit")
    Submit submit;

    public FormTemplate() {
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public Submit getSubmit() {
        return submit;
    }

    public void setSubmit(Submit submit) {
        this.submit = submit;
    }
}
