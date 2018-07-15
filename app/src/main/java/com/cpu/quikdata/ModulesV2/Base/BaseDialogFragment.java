package com.cpu.quikdata.ModulesV2.Base;

import android.support.v4.app.DialogFragment;

public abstract class BaseDialogFragment<VM> extends DialogFragment {

    protected VM mViewModel;

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(VM viewModel) {
        mViewModel = viewModel;
    }
}
