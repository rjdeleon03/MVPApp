package com.rjdeleon.mvp_app.Views.Fragments;

import android.support.v4.app.Fragment;

import com.rjdeleon.mvp_app.Contracts.FragmentNavigationContract;

public abstract class BaseFragment extends Fragment implements FragmentNavigationContract.View {

    protected FragmentNavigationContract.Presenter navigationPresenter;

    @Override
    public void attachPresenter(FragmentNavigationContract.Presenter presenter) {
        navigationPresenter = presenter;
    }
}
