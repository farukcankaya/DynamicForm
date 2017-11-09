package com.farukcankaya.dynamicform.internal.model.fields.constraints;

import com.google.gson.annotations.SerializedName;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public class Limit {
    @SerializedName("min")
    Double min;
    @SerializedName("max")
    Double max;
    @SerializedName("limit_type")
    LimitType limitType;

    public Limit(Double min, Double max, LimitType limitType) {
        this.min = min;
        this.max = max;
        this.limitType = limitType;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public LimitType getLimitType() {
        return limitType;
    }

    public void setLimitType(LimitType limitType) {
        this.limitType = limitType;
    }
}
