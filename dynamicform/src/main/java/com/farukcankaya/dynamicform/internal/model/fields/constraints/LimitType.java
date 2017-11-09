package com.farukcankaya.dynamicform.internal.model.fields.constraints;

import com.google.gson.annotations.SerializedName;

/**
 * Created by farukcankaya on 08/11/2017.
 */

public enum LimitType {
    @SerializedName("character")
    CHARACTER,
    @SerializedName("word")
    WORD,
    @SerializedName("date")
    DATE
}
