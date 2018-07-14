package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class TemplateItemViewHolder<VM> extends RecyclerView.ViewHolder {

    public TemplateItemViewHolder(View itemView) {
        super(itemView);
        bind(itemView);
    }

    public abstract void bind(View itemView);

    public abstract void setViewModel(VM itemViewModel);
}
