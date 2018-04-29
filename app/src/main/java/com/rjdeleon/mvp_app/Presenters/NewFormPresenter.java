package com.rjdeleon.mvp_app.Presenters;

import android.view.View;

import com.rjdeleon.mvp_app.Contracts.FragmentNavigationContract;
import com.rjdeleon.mvp_app.Contracts.NewFormContract;
import com.rjdeleon.mvp_app.Models.FormInfo;
import com.rjdeleon.mvp_app.Views.Fragments.BaseFragment;

public class NewFormPresenter implements NewFormContract.Presenter, FragmentNavigationContract.Presenter {

    private NewFormContract.View mView;
    private FormInfo mFormInfo;

    public NewFormPresenter(NewFormContract.View view) {
        mView = view;
        mFormInfo = new FormInfo();
    }

    @Override
    public void switchToFragment(BaseFragment fragment) {
        mView.onSwitchToFragment(fragment);
    }

    @Override
    public void closeFragment(BaseFragment fragment) {
        mView.onCloseFragment(fragment);
    }

    @Override
    public void handleBackButtonClick(View view) {
        mView.onBackButtonClicked(view);
    }

    @Override
    public FormInfo getFormInfo() {
        return mFormInfo;
    }

    @Override
    public void setFormInfo(FormInfo formInfo) {
        this.mFormInfo = formInfo;
    }
}
