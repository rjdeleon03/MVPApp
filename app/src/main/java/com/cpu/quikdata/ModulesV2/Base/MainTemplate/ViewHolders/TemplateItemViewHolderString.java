package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders;

import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;

import com.cpu.quikdata.databinding.TemplateQuestionStringBinding;

public class TemplateItemViewHolderString extends TemplateItemViewHolder<TemplateQuestionItemViewModelString> {

    private TemplateQuestionStringBinding mBinding;

    public TemplateItemViewHolderString(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(View itemView) {
        if (mBinding == null) {
            mBinding = TemplateQuestionStringBinding.bind(itemView);
        }
    }

    @Override
    public void setViewModel(TemplateQuestionItemViewModelString itemViewModel) {
        mBinding.setViewModel(itemViewModel);
    }
}
