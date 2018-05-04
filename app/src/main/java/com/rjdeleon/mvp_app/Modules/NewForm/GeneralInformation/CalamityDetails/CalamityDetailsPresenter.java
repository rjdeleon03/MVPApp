package com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.CalamityDetails;

public class CalamityDetailsPresenter implements CalamityDetailsContract.Presenter {

    private CalamityDetailsContract.View mView;

    public CalamityDetailsPresenter(CalamityDetailsContract.View view) {
        this.mView = view;
    }
}
