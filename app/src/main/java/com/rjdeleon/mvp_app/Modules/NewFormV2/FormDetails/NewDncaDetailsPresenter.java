package com.rjdeleon.mvp_app.Modules.NewFormV2.FormDetails;

public class NewDncaDetailsPresenter implements NewDncaDetailsContract.Presenter {

    private NewDncaDetailsContract.View mView;

    public NewDncaDetailsPresenter(NewDncaDetailsContract.View view) {
        this.mView = view;
        mView.setPresenter(this);
    }
}
