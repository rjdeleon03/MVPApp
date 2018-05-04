package com.rjdeleon.mvp_app.Base;

import android.support.v4.app.Fragment;

import com.rjdeleon.mvp_app.Modules.NewForm.NewFormNavigationContract;

public abstract class BaseFragment extends Fragment implements NewFormNavigationContract.View {

    protected NewFormNavigationContract.Presenter mNavigationPresenter;

    protected String fragmentTitle = "";
    protected String fragmentSubtitle = "";

    @Override
    public void attachPresenter(NewFormNavigationContract.Presenter presenter) {
        mNavigationPresenter = presenter;
    }

    public String getFragmentTitle() {
        return fragmentTitle;
    }

    public String getFragmentSubtitle() {
        return fragmentSubtitle;
    }
}
