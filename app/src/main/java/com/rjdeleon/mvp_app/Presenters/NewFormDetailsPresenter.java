package com.rjdeleon.mvp_app.Presenters;

import android.view.View;

import com.rjdeleon.mvp_app.Contracts.NewFormDetailsContract;

public class NewFormDetailsPresenter implements NewFormDetailsContract.Presenter {

    private NewFormDetailsContract.View mView;

    public NewFormDetailsPresenter(NewFormDetailsContract.View view) {
        this.mView = view;
    }

    @Override
    public void handleSaveButtonClick(View view) {
        mView.onSaveButtonClick(view);
    }
}
