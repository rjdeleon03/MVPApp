package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.TemplateItemViewHolder;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateReadonlyBooleanBinding;
import com.cpu.quikdata.databinding.TemplateReadonlyStringBinding;

public class TemplateReadonlyItemViewHolderString extends TemplateItemViewHolder<TemplateQuestionItemViewModelString> {

    /**
     * Constructor
     *
     * @param inflater
     * @param viewModel
     */
    public TemplateReadonlyItemViewHolderString(LayoutInflater inflater, TemplateQuestionItemViewModelString viewModel) {
        super(inflater, viewModel);
    }

    @Override
    protected View setupView(LayoutInflater inflater) {
        TemplateReadonlyStringBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_readonly_string, null, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}
