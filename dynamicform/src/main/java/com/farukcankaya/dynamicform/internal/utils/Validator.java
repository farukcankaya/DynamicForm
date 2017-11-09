package com.farukcankaya.dynamicform.internal.utils;

import android.text.TextUtils;

import com.farukcankaya.dynamicform.internal.model.fields.validations.EqualLimitValidation;
import com.farukcankaya.dynamicform.internal.model.fields.validations.LimitType;
import com.farukcankaya.dynamicform.internal.model.fields.validations.LimitValidation;
import com.farukcankaya.dynamicform.internal.model.fields.validations.MaxLimitValidation;
import com.farukcankaya.dynamicform.internal.model.fields.validations.MinLimitValidation;
import com.farukcankaya.dynamicform.internal.model.fields.validations.PresenceValidation;
import com.farukcankaya.dynamicform.internal.model.fields.validations.RegexValidation;
import com.farukcankaya.dynamicform.internal.model.fields.validations.Validation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public class Validator {
    public static List<String> validate(List<Validation> validations, Object object) {
        String value = object == null ? "" : object.toString();
        List<String> errors = new ArrayList<>(validations.size());

        for (Validation validation : validations) {
            if (validation instanceof PresenceValidation) {
                if (TextUtils.isEmpty(value)) {
                    errors.add(validation.getValidationMessage());
                }
            } else if (validation instanceof LimitValidation) {
                List<String> limitErrors = getLimitValidationErrors((LimitValidation) validation, value);
                if (limitErrors.size() > 0) {
                    errors.addAll(limitErrors);
                }
            } else if (validation instanceof RegexValidation) {
                //  TODO: do regex check
            }
        }

        return errors;
    }

    private static List<String> getLimitValidationErrors(LimitValidation limitValidation, String value) {
        List<String> errors = new ArrayList<>();
        if (limitValidation instanceof MinLimitValidation) {
            if (limitValidation.getLimitType().equals(LimitType.VALUE)) {
                if (Double.parseDouble(value) < Double.parseDouble(limitValidation.getExpression())) {
                    errors.add(limitValidation.getValidationMessage());
                }
            } else if (limitValidation.getLimitType().equals(LimitType.CHARACTER_LENGTH)) {
                if (value.length() < Integer.parseInt(limitValidation.getExpression())) {
                    errors.add(limitValidation.getValidationMessage());
                }
            } else if (limitValidation.getLimitType().equals(LimitType.WORD_LENGTH)) {
                if (value.split("\\s+").length < Integer.parseInt(limitValidation.getExpression())) {
                    errors.add(limitValidation.getValidationMessage());
                }
            }
        } else if (limitValidation instanceof MaxLimitValidation) {
            if (limitValidation.getLimitType().equals(LimitType.VALUE)) {
                if (Double.parseDouble(value) > Double.parseDouble(limitValidation.getExpression())) {
                    errors.add(limitValidation.getValidationMessage());
                }
            } else if (limitValidation.getLimitType().equals(LimitType.CHARACTER_LENGTH)) {
                if (value.length() > Integer.parseInt(limitValidation.getExpression())) {
                    errors.add(limitValidation.getValidationMessage());
                }
            } else if (limitValidation.getLimitType().equals(LimitType.WORD_LENGTH)) {
                if (value.split("\\s+").length > Integer.parseInt(limitValidation.getExpression())) {
                    errors.add(limitValidation.getValidationMessage());
                }
            }
        } else if (limitValidation instanceof EqualLimitValidation) {
            if (limitValidation.getLimitType().equals(LimitType.VALUE)) {
                if (Double.parseDouble(value) == Double.parseDouble(limitValidation.getExpression())) {
                    errors.add(limitValidation.getValidationMessage());
                }
            } else if (limitValidation.getLimitType().equals(LimitType.CHARACTER_LENGTH)) {
                if (value.length() == Integer.parseInt(limitValidation.getExpression())) {
                    errors.add(limitValidation.getValidationMessage());
                }
            } else if (limitValidation.getLimitType().equals(LimitType.WORD_LENGTH)) {
                if (value.split("\\s+").length == Integer.parseInt(limitValidation.getExpression())) {
                    errors.add(limitValidation.getValidationMessage());
                }
            }
        }

        return errors;
    }
}
