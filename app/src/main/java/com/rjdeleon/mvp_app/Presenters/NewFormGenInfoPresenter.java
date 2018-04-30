package com.rjdeleon.mvp_app.Presenters;

import com.rjdeleon.mvp_app.Contracts.NewFormContract;
import com.rjdeleon.mvp_app.Contracts.NewFormGenInfoContract;

public class NewFormGenInfoPresenter implements NewFormGenInfoContract.Presenter {

    private NewFormGenInfoContract.View mView;
    private NewFormContract.Presenter mParentPresenter;

    public NewFormGenInfoPresenter(NewFormGenInfoContract.View view, NewFormContract.Presenter parentPresenter) {
        mView = view;
        mParentPresenter = parentPresenter;
    }
}
