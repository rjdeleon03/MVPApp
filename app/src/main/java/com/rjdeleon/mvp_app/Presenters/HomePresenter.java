package com.rjdeleon.mvp_app.Presenters;

import android.view.View;

import com.rjdeleon.mvp_app.Contracts.HomeContract;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;

    public HomePresenter(HomeContract.View view) {
        this.mView = view;
    }

    @Override
    public void handleNewDncaClick(View view) {
        this.mView.navigateToNewDnca();
    }

    @Override
    public void handleTestApiClick(View view) {
        // Access GET API at localhost:3000/dnca
    }
}
