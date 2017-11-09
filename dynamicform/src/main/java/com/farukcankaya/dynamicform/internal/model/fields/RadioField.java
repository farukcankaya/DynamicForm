package com.farukcankaya.dynamicform.internal.model.fields;

import com.farukcankaya.dynamicform.internal.model.fields.options.FieldOption;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public class RadioField extends Field {

    /**
     * TODO: there should be better way to do this!
     *
     * @return
     */
    @Override
    public Object getValue() {
        if (super.getValue() == null) {
            for (FieldOption fieldOption : getOptions()) {
                if (fieldOption.isChecked()) {
                    setValue(fieldOption.getValue());
                    break;
                }
            }
        }
        return super.getValue();
    }
}
