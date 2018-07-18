package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.Question;

import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.TemplateItemViewHolder;
import com.cpu.quikdata.databinding.TemplateQuestionSingleNumberBinding;

public class TemplateQuestionItemViewHolderSingleNumber extends TemplateItemViewHolder<TemplateQuestionItemViewModelSingleNumber> {

    private TemplateQuestionSingleNumberBinding mBinding;

    public TemplateQuestionItemViewHolderSingleNumber(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(View itemView) {
        if (mBinding == null) {
            mBinding = TemplateQuestionSingleNumberBinding.bind(itemView);
        }
    }

    @Override
    public void setViewModel(TemplateQuestionItemViewModelSingleNumber itemViewModel) {
        mBinding.setViewModel(itemViewModel);
    }
}
