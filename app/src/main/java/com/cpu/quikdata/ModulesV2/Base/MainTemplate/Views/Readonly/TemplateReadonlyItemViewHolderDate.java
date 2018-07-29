package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.Readonly;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views.TemplateItemViewHolder;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateReadonlyDateBinding;

public class TemplateReadonlyItemViewHolderDate extends TemplateItemViewHolder<TemplateQuestionItemViewModelDate> {

    /**
     * Constructor
     *
     * @param inflater
     * @param viewModel
     */
    public TemplateReadonlyItemViewHolderDate(LayoutInflater inflater, TemplateQuestionItemViewModelDate viewModel) {
        super(inflater, viewModel);
    }

    @Override
    protected View setupView(LayoutInflater inflater) {
        TemplateReadonlyDateBinding binding = DataBindingUtil.inflate(inflater, R.layout.template_readonly_date, null, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}
