package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.Question;

import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.TemplateItemViewHolder;
import com.cpu.quikdata.databinding.TemplateQuestionStringBinding;

public class TemplateQuestionItemViewHolderString extends TemplateItemViewHolder<TemplateQuestionItemViewModelString> {

    private TemplateQuestionStringBinding mBinding;

    public TemplateQuestionItemViewHolderString(View itemView) {
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
