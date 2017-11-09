package com.farukcankaya.dynamicform.internal.model.fields.constraints;

import com.google.gson.annotations.SerializedName;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public class Limit {
    @SerializedName("min")
    String min;
    @SerializedName("max")
    String max;
    @SerializedName("limit_type")
    LimitType limitType;

    public Limit(String min, String max, LimitType limitType) {
        this.min = min;
        this.max = max;
        this.limitType = limitType;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public LimitType getLimitType() {
        return limitType;
    }

    public void setLimitType(LimitType limitType) {
        this.limitType = limitType;
    }
}
