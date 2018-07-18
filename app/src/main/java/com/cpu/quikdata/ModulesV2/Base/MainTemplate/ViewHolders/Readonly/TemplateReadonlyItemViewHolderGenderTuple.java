package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.Readonly;

import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewHolders.TemplateItemViewHolder;
import com.cpu.quikdata.databinding.TemplateQuestionGenderTupleBinding;
import com.cpu.quikdata.databinding.TemplateReadonlyGenderTupleBinding;

public class TemplateReadonlyItemViewHolderGenderTuple extends TemplateItemViewHolder<TemplateQuestionItemViewModelGenderTuple> {

    private TemplateReadonlyGenderTupleBinding mBinding;

    public TemplateReadonlyItemViewHolderGenderTuple(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(View itemView) {
        if (mBinding == null) {
            mBinding = TemplateReadonlyGenderTupleBinding.bind(itemView);
        }
    }

    @Override
    public void setViewModel(TemplateQuestionItemViewModelGenderTuple itemViewModel) {
        if (mBinding != null) {
            mBinding.setViewModel(itemViewModel);
        }
    }
}
