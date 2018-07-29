package com.cpu.quikdata.ModulesV2.FormList.Item;

import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.ListData.TemplateListDataViewHolder;
import com.cpu.quikdata.databinding.FormListItemBinding;

public class FormListItemViewHolder extends TemplateListDataViewHolder<FormListItemViewModel> {

    private FormListItemBinding mFormListItemBinding;

    /**
     * Constructor
     * @param itemView
     */
    public FormListItemViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * Initializes binding
     * @param itemView
     */
    @Override
    protected void bind(View itemView) {
        mFormListItemBinding = FormListItemBinding.bind(itemView);
    }

    @Override
    public void setViewModel(FormListItemViewModel viewModel) {
        mFormListItemBinding.setViewModel(viewModel);
    }
}
