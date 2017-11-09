package com.farukcankaya.dynamicform.internal.utils;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;

import com.farukcankaya.dynamicform.internal.model.fields.Field;
import com.farukcankaya.dynamicform.internal.model.fields.constraints.InputType;
import com.farukcankaya.dynamicform.internal.model.fields.options.FieldOption;
import com.farukcankaya.dynamicform.internal.model.fields.validations.Validation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public class Utility {
    private static final String TAG = "Utility";
    private static Gson gson;
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static Gson getGson() {
        if (gson != null) {
            return gson;
        }
        gson = new GsonBuilder()
                .registerTypeAdapter(Field.class, new GsonFieldTypeAdapter())
                .registerTypeAdapter(Validation.class, new GsonFieldValidationTypeAdapter())
                .create();
        return gson;
    }

    public static void setDefaultValues(List<Field> fields) {
        for (Field field : fields) {
            if (field.getOptions() != null && field.getOptions().size() > 0) {
                for (FieldOption fieldOption : field.getOptions()) {
                    if (fieldOption.isChecked()) {
                        field.setValue(fieldOption.getValue());
                    }
                }
            }
        }
    }

    public static String getType(String baseClassName, String className) {
        return className.replace(baseClassName, "").toLowerCase();
    }

    public static String loadJSONFromAsset(Context context, String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            Log.d(TAG, "Exception Occurred : " + ex.getMessage());
            return null;
        }
        return json;
    }

    public static int getInputType(InputType inputType) {
        switch (inputType) {
            case TEXT:
                return android.text.InputType.TYPE_CLASS_TEXT;
            case TEXT_CAP_CHARACTERS:
                return android.text.InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS;
            case TEXT_CAP_WORDS:
                return android.text.InputType.TYPE_TEXT_FLAG_CAP_WORDS;
            case NUMBER:
                return android.text.InputType.TYPE_CLASS_NUMBER;
            case TEXT_EMAIL_ADDRESS:
                return android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
            case PHONE:
                return android.text.InputType.TYPE_CLASS_PHONE;
            default:
                return android.text.InputType.TYPE_CLASS_TEXT;
        }
    }

    public static String toSnakeCase(String text) {
        Matcher matcher = Pattern.compile("(?<=[a-z])[A-Z]").matcher(text);

        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "_" + matcher.group().toLowerCase());
        }
        matcher.appendTail(stringBuffer);

        return stringBuffer.toString();
    }

    public static String toCamelCase(String text) {
        Matcher matcher = Pattern.compile("(_)[a-z]").matcher(text);

        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String s = matcher.group();
            matcher.appendReplacement(stringBuffer, s.substring(1).toUpperCase());
        }
        matcher.appendTail(stringBuffer);

        String s = stringBuffer.toString();
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static String fromDate(Date date) {
        DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(date);
    }

    public static Date toDate(String stringDate) {
        if (stringDate != null) {
            try {
                return new SimpleDateFormat(DATE_FORMAT).parse(stringDate);
            } catch (ParseException e) {
                Log.e(TAG, e.getLocalizedMessage());
            }
        }
        return null;
    }

    public static int generateUniqueViewId() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return generateViewId();
        } else {
            return View.generateViewId();
        }
    }

    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    /**
     * Generate a value suitable for use in {@link android.view.View#setId(int)}.
     * This value will not collide with ID values generated at build time by aapt for R.id.
     *
     * @return a generated ID value
     */
    private static int generateViewId() {
        for (; ; ) {
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }
}
