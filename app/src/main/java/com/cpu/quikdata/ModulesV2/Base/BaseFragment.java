package com.cpu.quikdata.ModulesV2.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.cpu.quikdata.BaseActivity;

public abstract class BaseFragment<VM> extends Fragment {

    protected VM mViewModel;
    protected String mTag;
    protected BaseActivity mActivity;

    /**
     * Gets the fragment type
     * @return
     */
    public String getType() {
        return mTag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (BaseActivity) getActivity();
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(VM viewModel) {
        mViewModel = viewModel;
    }
}
