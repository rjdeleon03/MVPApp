package com.cpu.quikdata.ModulesV2.FormList.Item;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cpu.quikdata.databinding.FormListItemBinding;

public class FormListItemViewHolder extends RecyclerView.ViewHolder {

    private FormListItemBinding mFormListItemBinding;

    /**
     * Constructor
     * @param itemView
     */
    public FormListItemViewHolder(View itemView) {
        super(itemView);
        bind(itemView);
    }

    /**
     * Initializes binding
     */
    public void bind(View itemView) {
        mFormListItemBinding = FormListItemBinding.bind(itemView);
    }

    /**
     * Binds viewModel to view
     * @param viewModel
     */
    public void setViewModel(FormListItemViewModel viewModel) {
        mFormListItemBinding.setViewModel(viewModel);
    }
}
