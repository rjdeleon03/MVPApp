package com.cpu.quikdata.ModulesV2.FormList.Item;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cpu.quikdata.databinding.FormListItemBinding;

public class FormListItemViewHolder extends RecyclerView.ViewHolder {

    private View mItemView;

    /**
     * Constructor
     * @param itemView
     */
    public FormListItemViewHolder(View itemView) {
        super(itemView);
        mItemView = itemView;
    }

    /**
     * Binds viewModel to view
     * @param viewModel
     */
    public void bind(FormListItemViewModel viewModel) {
        FormListItemBinding formListItemBinding = FormListItemBinding.bind(mItemView);
        formListItemBinding.setViewModel(viewModel);
    }
}
