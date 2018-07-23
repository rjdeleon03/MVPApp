package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.TemplateItemViewHolder;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateQuestionGenderTupleBinding;

public class TemplateQuestionItemViewHolderGenderTuple extends TemplateItemViewHolder<TemplateQuestionItemViewModelGenderTuple> {

    /**
     * Constructor
     *
     * @param inflater
     * @param viewModel
     */
    public TemplateQuestionItemViewHolderGenderTuple(LayoutInflater inflater, TemplateQuestionItemViewModelGenderTuple viewModel) {
        super(inflater, viewModel);
    }

    @Override
    protected View setupView(LayoutInflater inflater) {
        TemplateQuestionGenderTupleBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_question_gender_tuple, null, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}
