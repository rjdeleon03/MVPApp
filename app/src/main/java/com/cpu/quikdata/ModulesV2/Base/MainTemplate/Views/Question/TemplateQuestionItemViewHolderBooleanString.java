package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.TemplateItemViewHolder;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateQuestionBooleanStringBinding;

public class TemplateQuestionItemViewHolderBooleanString extends TemplateItemViewHolder<TemplateQuestionItemViewModelBooleanString> {

    /**
     * Constructor
     *
     * @param inflater
     * @param viewModel
     */
    public TemplateQuestionItemViewHolderBooleanString(LayoutInflater inflater, TemplateQuestionItemViewModelBooleanString viewModel) {
        super(inflater, viewModel);
    }

    @Override
    protected View setupView(LayoutInflater inflater) {
        TemplateQuestionBooleanStringBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_question_boolean_string, null, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}
