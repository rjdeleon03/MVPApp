package com.rjdeleon.mvp_app.Presenters;

import com.rjdeleon.mvp_app.Contracts.DNCAListContract;

public class DNCAListPresenter implements DNCAListContract.Presenter {

    private DNCAListContract.View mView;

    public DNCAListPresenter(DNCAListContract.View view) {
        this.mView = view;
    }
}
