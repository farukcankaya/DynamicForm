package com.farukcankaya.dynamicform.internal.model.fields.options;

import com.google.gson.annotations.SerializedName;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public class FieldOption {
    int id;
    @SerializedName("label")
    String label;
    @SerializedName("value")
    Object value;
    @SerializedName("is_checked")
    boolean isChecked = false;

    public FieldOption(String label, String value, boolean isChecked) {
        this.label = label;
        this.value = value;
        this.isChecked = isChecked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
