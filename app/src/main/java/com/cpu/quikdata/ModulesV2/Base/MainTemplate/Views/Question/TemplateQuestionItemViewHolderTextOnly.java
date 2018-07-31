package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelTextOnly;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.TemplateItemViewHolder;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateQuestionTextonlyBinding;

public class TemplateQuestionItemViewHolderTextOnly extends TemplateItemViewHolder<TemplateQuestionItemViewModelTextOnly> {

    /**
     * Constructor
     *
     * @param inflater
     * @param viewModel
     */
    public TemplateQuestionItemViewHolderTextOnly(LayoutInflater inflater, TemplateQuestionItemViewModelTextOnly viewModel) {
        super(inflater, viewModel);
    }

    @Override
    protected View setupView(LayoutInflater inflater) {

        if (mViewModel.getUseAltLayout()) {
//            TemplateQuestionBooleanCheckboxBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_question_boolean_checkbox, null, false);
//            binding.setViewModel(mViewModel);
//            return binding.getRoot();
        }

        TemplateQuestionTextonlyBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_question_textonly, null, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}
