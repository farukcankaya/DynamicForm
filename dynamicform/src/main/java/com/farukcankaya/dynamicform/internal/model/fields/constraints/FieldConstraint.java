package com.farukcankaya.dynamicform.internal.model.fields.constraints;

import com.google.gson.annotations.SerializedName;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public class FieldConstraint {
    @SerializedName("limit")
    Limit limit;
    @SerializedName("input_type")
    InputType inputType;

    public FieldConstraint(Limit limit, InputType inputType) {
        this.limit = limit;
        this.inputType = inputType;
    }

    public Limit getLimit() {
        return limit;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    public InputType getInputType() {
        return inputType;
    }

    public void setInputType(InputType inputType) {
        this.inputType = inputType;
    }
}
