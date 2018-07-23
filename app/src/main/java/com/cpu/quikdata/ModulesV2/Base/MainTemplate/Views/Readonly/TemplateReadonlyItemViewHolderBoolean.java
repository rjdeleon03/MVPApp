package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.TemplateItemViewHolder;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateReadonlyBooleanBinding;

public class TemplateReadonlyItemViewHolderBoolean extends TemplateItemViewHolder<TemplateQuestionItemViewModelBoolean> {

    /**
     * Constructor
     *
     * @param inflater
     * @param viewModel
     */
    public TemplateReadonlyItemViewHolderBoolean(LayoutInflater inflater, TemplateQuestionItemViewModelBoolean viewModel) {
        super(inflater, viewModel);
    }

    @Override
    protected View setupView(LayoutInflater inflater) {
        TemplateReadonlyBooleanBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_readonly_boolean, null, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}
