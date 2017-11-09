package com.farukcankaya.dynamicform.internal.model.fields.validations;

import com.google.gson.annotations.SerializedName;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public abstract class Validation {
    @SerializedName("validation_type")
    String validationType;
    @SerializedName("expression")
    String expression;
    @SerializedName("validation_message")
    String validationMessage;

    public String getValidationType() {
        return validationType;
    }

    public void setValidationType(String validationType) {
        this.validationType = validationType;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(String validationMessage) {
        this.validationMessage = validationMessage;
    }
}
