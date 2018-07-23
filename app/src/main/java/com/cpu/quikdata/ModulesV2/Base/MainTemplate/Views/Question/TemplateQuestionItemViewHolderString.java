package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.TemplateItemViewHolder;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateQuestionBooleanBinding;
import com.cpu.quikdata.databinding.TemplateQuestionStringBinding;

public class TemplateQuestionItemViewHolderString extends TemplateItemViewHolder<TemplateQuestionItemViewModelString> {

    /**
     * Constructor
     *
     * @param inflater
     * @param viewModel
     */
    public TemplateQuestionItemViewHolderString(LayoutInflater inflater, TemplateQuestionItemViewModelString viewModel) {
        super(inflater, viewModel);
    }

    @Override
    protected View setupView(LayoutInflater inflater) {
        TemplateQuestionStringBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_question_string, null, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}
