package com.farukcankaya.dynamicform.internal.model.fields;

import com.farukcankaya.dynamicform.internal.model.fields.constraints.FieldConstraint;
import com.farukcankaya.dynamicform.internal.model.fields.options.FieldOption;
import com.farukcankaya.dynamicform.internal.model.fields.validations.Validation;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public abstract class Field {
    @SerializedName("field_name")
    String fieldName;
    @SerializedName("value")
    Object value;
    @SerializedName("label")
    String label;
    @SerializedName("hint")
    String hint;
    @SerializedName("options")
    List<FieldOption> options;
    @SerializedName("constraints")
    FieldConstraint constraint;
    @SerializedName("validations")
    List<Validation> validations;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public List<FieldOption> getOptions() {
        return options;
    }

    public void setOptions(List<FieldOption> options) {
        this.options = options;
    }

    public FieldConstraint getConstraint() {
        return constraint;
    }

    public void setConstraint(FieldConstraint constraint) {
        this.constraint = constraint;
    }

    public List<Validation> getValidations() {
        return validations;
    }

    public void setValidations(List<Validation> validations) {
        this.validations = validations;
    }
}
