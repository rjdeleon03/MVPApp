package com.rjdeleon.mvp_app.Base;

import android.support.v4.app.Fragment;

import com.rjdeleon.mvp_app.Base.FragmentNavigationContract;

public abstract class BaseFragment extends Fragment implements FragmentNavigationContract.View {

    protected FragmentNavigationContract.Presenter navigationPresenter;

    protected String fragmentTitle = "";
    protected String fragmentSubtitle = "";

    @Override
    public void attachPresenter(FragmentNavigationContract.Presenter presenter) {
        navigationPresenter = presenter;
    }

    public String getFragmentTitle() {
        return fragmentTitle;
    }

    public String getFragmentSubtitle() {
        return fragmentSubtitle;
    }
}
