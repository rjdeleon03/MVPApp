package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.Question;

import android.databinding.ViewDataBinding;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.TemplateItemViewHolder;
import com.cpu.quikdata.databinding.TemplateQuestionGenderTupleBinding;

public class TemplateQuestionItemViewHolderGenderTuple extends TemplateItemViewHolder<TemplateQuestionItemViewModelGenderTuple> {

    private TemplateQuestionGenderTupleBinding mBinding;

    public TemplateQuestionItemViewHolderGenderTuple(View itemView) {
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
