package com.farukcankaya.dynamicform.internal.ui.fields;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.farukcankaya.dynamicform.internal.model.fields.Field;
import com.farukcankaya.dynamicform.internal.model.fields.validations.Validation;
import com.farukcankaya.dynamicform.internal.utils.Utility;
import com.farukcankaya.dynamicform.internal.utils.Validator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public abstract class BaseHolder extends RecyclerView.ViewHolder {
    protected View itemView;
    protected int position;
    protected Field field;

    protected BaseHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public static BaseHolder newField(ViewGroup viewGroup, String fieldClassName) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        String layoutName = "field_" + Utility.getType(Field.class.getSimpleName(), fieldClassName);
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(viewGroup.getResources().getIdentifier(layoutName, "layout",
                        viewGroup.getContext().getPackageName()), viewGroup, false);

        String viewHolderName = fieldClassName + "Holder";
        Class inputClass = Class.forName(BaseHolder.class.getPackage().getName() + "." + viewHolderName);
        Constructor constructor = inputClass.getConstructor(View.class);
        return (BaseHolder) constructor.newInstance(view);
    }

    public void bind(int position, Field field) {
        this.position = position;
        this.field = field;
        bind();
    }

    List<String> validate() {
        return Validator.validate(field.getValidations(), getValue());
    }

    abstract void bind();

    abstract String getValue();

    abstract Field getField();
}
