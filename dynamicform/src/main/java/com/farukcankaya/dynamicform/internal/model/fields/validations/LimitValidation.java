package com.farukcankaya.dynamicform.internal.model.fields.validations;

import com.google.gson.annotations.SerializedName;

/**
 * Created by farukcankaya on 09/11/2017.
 */

public abstract class LimitValidation extends Validation {
    @SerializedName("limit_type")
    LimitType limitType = LimitType.CHARACTER_LENGTH;

    public LimitType getLimitType() {
        return limitType;
    }

    public void setLimitType(LimitType limitType) {
        this.limitType = limitType;
    }
}
