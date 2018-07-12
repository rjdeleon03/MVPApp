package com.cpu.quikdata.ModulesV2.PrefilledData;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cpu.quikdata.ModulesV2.PrefilledData.ViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.databinding.TemplateQuestionGenderTupleBinding;

public class TemplateItemViewHolder extends RecyclerView.ViewHolder {

    private TemplateQuestionGenderTupleBinding mBinding;

    public TemplateItemViewHolder(View itemView) {
        super(itemView);
        if (mBinding == null) {
            mBinding = TemplateQuestionGenderTupleBinding.bind(itemView);
        }
    }

    public void unbind() {
        if (mBinding != null) {
            mBinding.unbind();
        }
    }

    public void setViewModel(TemplateQuestionItemViewModelGenderTuple itemViewModel) {
        if (mBinding != null) {
            mBinding.setViewModel(itemViewModel);
        }
    }


}
