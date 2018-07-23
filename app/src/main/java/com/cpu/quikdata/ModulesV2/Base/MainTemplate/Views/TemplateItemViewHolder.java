package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Views;

import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;

public abstract class TemplateItemViewHolder<VM extends TemplateQuestionItemViewModel> {

    protected VM mViewModel;
    protected View mView;

    /**
     * Constructor
     * @param inflater
     * @param viewModel
     */
    public TemplateItemViewHolder(LayoutInflater inflater, VM viewModel) {
        mViewModel = viewModel;
        mView = setupView(inflater);
    }

    /**
     * Sets up the view
     * @param inflater
     */
    protected abstract View setupView(LayoutInflater inflater);

    /**
     * Gets the view
     * @return
     */
    public View getView() {
        return mView;
    }

}
