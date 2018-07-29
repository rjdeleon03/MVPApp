package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.TemplateItemViewHolder;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateQuestionBooleanCheckboxBinding;
import com.cpu.quikdata.databinding.TemplateQuestionBooleanBinding;

public class TemplateQuestionItemViewHolderBoolean extends TemplateItemViewHolder<TemplateQuestionItemViewModelBoolean> {

    /**
     * Constructor
     *
     * @param inflater
     * @param viewModel
     */
    public TemplateQuestionItemViewHolderBoolean(LayoutInflater inflater, TemplateQuestionItemViewModelBoolean viewModel) {
        super(inflater, viewModel);
    }

    @Override
    protected View setupView(LayoutInflater inflater) {

        if (mViewModel.getUseAltLayout()) {
            TemplateQuestionBooleanCheckboxBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_question_boolean_checkbox, null, false);
            binding.setViewModel(mViewModel);
            return binding.getRoot();
        }

        TemplateQuestionBooleanBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_question_boolean, null, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}