package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelDoubleString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.TemplateItemViewHolder;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateQuestionDoubleStringBinding;
import com.cpu.quikdata.databinding.TemplateQuestionStringBinding;

public class TemplateQuestionItemViewHolderDoubleString extends TemplateItemViewHolder<TemplateQuestionItemViewModelDoubleString> {

    /**
     * Constructor
     *
     * @param inflater
     * @param viewModel
     */
    public TemplateQuestionItemViewHolderDoubleString(LayoutInflater inflater, TemplateQuestionItemViewModelDoubleString viewModel) {
        super(inflater, viewModel);
    }

    @Override
    protected View setupView(LayoutInflater inflater) {
        TemplateQuestionDoubleStringBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_question_double_string, null, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}
