package com.rjdeleon.mvp_app.Presenters;

import android.view.View;

import com.rjdeleon.mvp_app.Contracts.NewFormContract;

public class NewFormPresenter implements NewFormContract.Presenter {

    NewFormContract.View mView;

    public NewFormPresenter(NewFormContract.View view) {
        this.mView = view;
    }

    @Override
    public void handleNewFormDetailsButtonClick(View view) {
        this.mView.onShowNewFormDetails(view);
    }
}
