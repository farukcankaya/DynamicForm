package com.farukcankaya.dynamicform.internal.ui.preview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.farukcankaya.dynamicform.internal.model.FormTemplate;
import com.farukcankaya.dynamicform.internal.ui.fields.BaseHolder;

/**
 * Created by farukcankaya on 01/10/2017.
 */

public class FieldAdapter extends RecyclerView.Adapter<BaseHolder> {
    FormTemplate formTemplate;

    public FieldAdapter(FormTemplate formTemplate) {
        this.formTemplate = formTemplate;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        try {
            BaseHolder baseHolder = BaseHolder.newField(parent, formTemplate.getFields().get(viewType).getClass().getSimpleName());
            return baseHolder;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        holder.bind(position, formTemplate.getFields().get(position));
    }

    @Override
    public int getItemCount() {
        return formTemplate.getFields().size();
    }
}
