package com.farukcankaya.dynamicform.internal.model.fields.validations;

import com.google.gson.annotations.SerializedName;

/**
 * Created by farukcankaya on 09/11/2017.
 */

public enum LimitType {
    @SerializedName("value")
    VALUE,
    @SerializedName("character_length")
    CHARACTER_LENGTH,
    @SerializedName("word_length")
    WORD_LENGTH,
    @SerializedName("selection")
    SELECTION
}
