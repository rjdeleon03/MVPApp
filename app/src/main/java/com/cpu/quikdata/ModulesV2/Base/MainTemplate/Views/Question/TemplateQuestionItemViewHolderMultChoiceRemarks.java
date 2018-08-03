package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelMultChoiceRemarks;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.TemplateItemViewHolder;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateQuestionMultChoiceRemarksBinding;

public class TemplateQuestionItemViewHolderMultChoiceRemarks extends TemplateItemViewHolder<TemplateQuestionItemViewModelMultChoiceRemarks> {

    /**
     * Constructor
     *
     * @param inflater
     * @param viewModel
     */
    public TemplateQuestionItemViewHolderMultChoiceRemarks(LayoutInflater inflater, TemplateQuestionItemViewModelMultChoiceRemarks viewModel) {
        super(inflater, viewModel);
    }

    @Override
    protected View setupView(LayoutInflater inflater) {
        TemplateQuestionMultChoiceRemarksBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_question_mult_choice_remarks, null, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}