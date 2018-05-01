package com.rjdeleon.mvp_app.Presenters.GeneralInformation;

import com.rjdeleon.mvp_app.Contracts.GeneralInformation.CalamityDetailsContract;

public class CalamityDetailsPresenter implements CalamityDetailsContract.Presenter {

    private CalamityDetailsContract.View mView;

    public CalamityDetailsPresenter(CalamityDetailsContract.View view) {
        this.mView = view;
    }
}
