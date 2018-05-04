package com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation;

import com.rjdeleon.mvp_app.Modules.NewForm.NewFormContract;

public class NewFormGenInfoPresenter implements NewFormGenInfoContract.Presenter {

    private NewFormGenInfoContract.View mView;
    private NewFormContract.Presenter mParentPresenter;

    public NewFormGenInfoPresenter(NewFormGenInfoContract.View view, NewFormContract.Presenter parentPresenter) {
        mView = view;
        mParentPresenter = parentPresenter;
    }
}
