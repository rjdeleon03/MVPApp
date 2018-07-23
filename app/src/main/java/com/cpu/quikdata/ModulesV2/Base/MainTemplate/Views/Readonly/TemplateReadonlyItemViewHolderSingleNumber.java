package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.TemplateItemViewHolder;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateReadonlySingleNumberBinding;
import com.cpu.quikdata.databinding.TemplateReadonlyStringBinding;

public class TemplateReadonlyItemViewHolderSingleNumber extends TemplateItemViewHolder<TemplateQuestionItemViewModelSingleNumber> {

    /**
     * Constructor
     *
     * @param inflater
     * @param viewModel
     */
    public TemplateReadonlyItemViewHolderSingleNumber(LayoutInflater inflater, TemplateQuestionItemViewModelSingleNumber viewModel) {
        super(inflater, viewModel);
    }

    @Override
    protected View setupView(LayoutInflater inflater) {
        TemplateReadonlySingleNumberBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_readonly_single_number, null, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}
