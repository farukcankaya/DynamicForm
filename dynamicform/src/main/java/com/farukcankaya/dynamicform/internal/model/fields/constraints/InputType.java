package com.farukcankaya.dynamicform.internal.model.fields.constraints;

import com.google.gson.annotations.SerializedName;

/**
 * Created by farukcankaya on 08/11/2017.
 */

public enum InputType {
    @SerializedName("text")
    TEXT,
    @SerializedName("textCapCharacters")
    TEXT_CAP_CHARACTERS,
    @SerializedName("textCapWords")
    TEXT_CAP_WORDS,
    @SerializedName("number")
    NUMBER,
    @SerializedName("textEmailAddress")
    TEXT_EMAIL_ADDRESS,
    @SerializedName("phone")
    PHONE
}
