package com.cpu.quikdata.ModulesV2.Base;

import android.support.v4.app.Fragment;

import com.cpu.quikdata.BaseActivity;

public abstract class BaseFragment<VM> extends Fragment {

    protected VM mViewModel;
    protected String mTag;

    /**
     * Gets the fragment type
     * @return
     */
    public String getType() {
        return mTag;
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(VM viewModel) {
        mViewModel = viewModel;
    }
}
