package com.farukcankaya.dynamicform.internal.utils;

import com.farukcankaya.dynamicform.internal.model.fields.Field;
import com.farukcankaya.dynamicform.internal.model.fields.validations.Validation;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public class GsonFieldTypeAdapter implements JsonSerializer<Field>,
        JsonDeserializer<Field> {
    private static final String TYPE_IDENTIFIER = "field_type";

    @Override
    public Field deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(TYPE_IDENTIFIER);
        String type = prim.getAsString();

        return context.deserialize(jsonObject, getModelClass(type));
    }

    @Override
    public JsonElement serialize(Field src, Type typeOfSrc, JsonSerializationContext context) {
        String className = src.getClass().getSimpleName();
        JsonElement elem = context.serialize(src);
        JsonObject retValue = elem.getAsJsonObject();
        className = className.replace(Field.class.getSimpleName(), "");
        String s = Utility.toSnakeCase(className);
        retValue.addProperty(TYPE_IDENTIFIER, s);
        return retValue;
    }

    private Class<?> getModelClass(String type) {
        Class<?> classType = null;
        try {
            String d = Field.class.getPackage().getName().toString() + "." + Utility.toCamelCase(type) + Field.class.getSimpleName();
            classType = Class.forName(d);
        } catch (ClassNotFoundException e) {
            //throw new JsonParseException(e.getMessage());
        }

        return classType;
    }
}
