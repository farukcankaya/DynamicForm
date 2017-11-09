package com.farukcankaya.dynamicform.internal.ui.fields;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public interface FieldAttributes {
    String FIELDS = "fields";
    String FIELD_TYPE = "field_type";
    String FIELD_NAME = "field_name";
    String LABEL = "label";
    String VALUE = "value";
    String HINT = "hint";
    String OPTIONS = "options";
    String CONSTRAINTS = "constraints";
    String validations = "validations";

    interface Constraints {
        String LIMIT = "limit";
        String LIMIT_MIN = "min";
        String LIMIT_MAX = "max";
        String LIMIT_TYPE = "limit_type";

        String INPUT_TYPE = "input_type";
    }
}
