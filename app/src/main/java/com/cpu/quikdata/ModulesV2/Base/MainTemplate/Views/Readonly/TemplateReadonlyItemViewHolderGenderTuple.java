package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.TemplateItemViewHolder;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateReadonlyGenderTupleBinding;

public class TemplateReadonlyItemViewHolderGenderTuple extends TemplateItemViewHolder<TemplateQuestionItemViewModelGenderTuple> {

    /**
     * Constructor
     *
     * @param inflater
     * @param viewModel
     */
    public TemplateReadonlyItemViewHolderGenderTuple(LayoutInflater inflater, TemplateQuestionItemViewModelGenderTuple viewModel) {
        super(inflater, viewModel);
    }

    @Override
    protected View setupView(LayoutInflater inflater) {
        TemplateReadonlyGenderTupleBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_readonly_gender_tuple, null, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}
