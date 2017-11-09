package com.farukcankaya.dynamicform.internal.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public class Submit {
    @SerializedName("label")
    String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
