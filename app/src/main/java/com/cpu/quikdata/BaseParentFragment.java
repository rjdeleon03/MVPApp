package com.cpu.quikdata;

import com.cpu.quikdata.ModulesV2.Base.BaseFragment;

public class BaseParentFragment<VM> extends BaseFragment<VM> {

    @Override
    public void onResume() {
        super.onResume();
        if (mActivity != null) {
            mActivity.refreshToolbarTitleFromTopmostFragment();
        }
    }
}
