package com.rjdeleon.mvp_app.Presenters;

import android.view.View;

import com.rjdeleon.mvp_app.Contracts.FragmentNavigationContract;
import com.rjdeleon.mvp_app.Contracts.NewFormContract;
import com.rjdeleon.mvp_app.Views.Fragments.BaseFragment;

public class NewFormPresenter implements NewFormContract.Presenter, FragmentNavigationContract.Presenter {

    private NewFormContract.View mView;

    public NewFormPresenter(NewFormContract.View view) {
        mView = view;
    }

    @Override
    public void switchToFragment(BaseFragment fragment) {
        mView.onSwitchToFragment(fragment);
    }

    @Override
    public void handleBackButtonClick(View view) {
        mView.onBackButtonClicked(view);
    }
}
