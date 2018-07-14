package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders;

import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.databinding.TemplateQuestionSingleNumberBinding;

public class TemplateItemViewHolderSingleNumber extends TemplateItemViewHolder<TemplateQuestionItemViewModelSingleNumber> {

    private TemplateQuestionSingleNumberBinding mBinding;

    public TemplateItemViewHolderSingleNumber(View itemView) {
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
