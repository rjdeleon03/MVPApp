package com.cpu.quikdata.ModulesV2.PrefilledData.ViewHolders;

import android.view.View;

import com.cpu.quikdata.ModulesV2.PrefilledData.ViewModels.TemplateQuestionItemViewModelGenderTuple;

import com.cpu.quikdata.databinding.TemplateQuestionGenderTupleBinding;

public class TemplateItemViewHolderGenderTuple extends TemplateItemViewHolder<TemplateQuestionItemViewModelGenderTuple> {

    private TemplateQuestionGenderTupleBinding mBinding;

    public TemplateItemViewHolderGenderTuple(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(View itemView) {
        if (mBinding == null) {
            mBinding = TemplateQuestionGenderTupleBinding.bind(itemView);
        }
    }

    @Override
    public void setViewModel(TemplateQuestionItemViewModelGenderTuple itemViewModel) {
        if (mBinding != null) {
            mBinding.setViewModel(itemViewModel);
        }
    }
}
