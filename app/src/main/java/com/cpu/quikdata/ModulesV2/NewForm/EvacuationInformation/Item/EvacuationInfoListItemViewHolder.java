package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.Item;

import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.ListData.TemplateListDataViewHolder;
import com.cpu.quikdata.databinding.EvacuationInfoListItemBinding;
import com.cpu.quikdata.databinding.FormListItemBinding;

public class EvacuationInfoListItemViewHolder extends TemplateListDataViewHolder<EvacuationInfoListItemViewModel> {

    private EvacuationInfoListItemBinding mEvacuationInfoListItemBinding;

    /**
     * Constructor
     * @param itemView
     */
    public EvacuationInfoListItemViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * Initializes binding
     * @param itemView
     */
    @Override
    protected void bind(View itemView) {
        mEvacuationInfoListItemBinding = EvacuationInfoListItemBinding.bind(itemView);
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    @Override
    public void setViewModel(EvacuationInfoListItemViewModel viewModel) {
        mEvacuationInfoListItemBinding.setViewModel(viewModel);
    }
}
