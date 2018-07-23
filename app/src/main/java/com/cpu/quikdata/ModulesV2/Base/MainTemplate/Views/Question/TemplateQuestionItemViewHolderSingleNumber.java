package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Question;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.TemplateItemViewHolder;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateQuestionSingleNumberBinding;
import com.cpu.quikdata.databinding.TemplateQuestionStringBinding;

public class TemplateQuestionItemViewHolderSingleNumber extends TemplateItemViewHolder<TemplateQuestionItemViewModelSingleNumber> {

    /**
     * Constructor
     *
     * @param inflater
     * @param viewModel
     */
    public TemplateQuestionItemViewHolderSingleNumber(LayoutInflater inflater, TemplateQuestionItemViewModelSingleNumber viewModel) {
        super(inflater, viewModel);
    }

    @Override
    protected View setupView(LayoutInflater inflater) {
        TemplateQuestionSingleNumberBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_question_single_number, null, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}
