package com.cpu.quikdata.ModulesV2.Base.ListData;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class ListDataViewHolder<VM> extends RecyclerView.ViewHolder {

    /**
     * Constructor
     *
     * @param itemView
     */
    public ListDataViewHolder(View itemView) {
        super(itemView);
        bind(itemView);
    }

    /**
     * Initializes binding
     * @param itemView
     */
    protected abstract void bind(View itemView);

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public abstract void setViewModel(VM viewModel);
}
