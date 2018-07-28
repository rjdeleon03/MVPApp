package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.TemplateItemViewHolder;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateQuestionBooleanBinding;

public class TemplateQuestionItemViewHolderBooleanGroup extends TemplateItemViewHolder<TemplateQuestionItemViewModelBoolean> {

    /**
     * Constructor
     *
     * @param inflater
     * @param viewModel
     */
    public TemplateQuestionItemViewHolderBooleanGroup(LayoutInflater inflater, TemplateQuestionItemViewModelBoolean viewModel) {
        super(inflater, viewModel);
    }

    @Override
    protected View setupView(LayoutInflater inflater) {
        TemplateQuestionBooleanBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_question_boolean, null, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}
