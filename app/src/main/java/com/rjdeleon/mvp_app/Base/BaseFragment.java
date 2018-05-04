package com.rjdeleon.mvp_app.Base;

import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment implements FragmentNavigationContract.View {

    protected FragmentNavigationContract.Presenter mNavigationPresenter;

    protected String fragmentTitle = "";
    protected String fragmentSubtitle = "";

    @Override
    public void attachPresenter(FragmentNavigationContract.Presenter presenter) {
        mNavigationPresenter = presenter;
    }

    public String getFragmentTitle() {
        return fragmentTitle;
    }

    public String getFragmentSubtitle() {
        return fragmentSubtitle;
    }
}
