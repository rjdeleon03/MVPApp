package com.cpu.quikdata.ModulesV2.NewForm.CaseStories.ImageItem;

import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.ListData.TemplateListDataViewHolder;
import com.cpu.quikdata.databinding.TemplateImageItemBinding;

public class ImageItemViewHolder extends TemplateListDataViewHolder<ImageItemViewModel> {

    private TemplateImageItemBinding mBinding;

    /**
     * Constructor
     * @param itemView
     */
    public ImageItemViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * Initializes the binding
     * @param itemView
     */
    @Override
    protected void bind(View itemView) {
        mBinding = TemplateImageItemBinding.bind(itemView);
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    @Override
    public void setViewModel(ImageItemViewModel viewModel) {
        mBinding.setViewModel(viewModel);
    }
}
