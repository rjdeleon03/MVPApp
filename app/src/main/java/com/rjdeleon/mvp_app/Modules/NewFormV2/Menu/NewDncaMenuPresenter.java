package com.rjdeleon.mvp_app.Modules.NewFormV2.Menu;

public class NewDncaMenuPresenter implements NewDncaMenuContract.Presenter {

    private NewDncaMenuContract.View mView;

    public NewDncaMenuPresenter(NewDncaMenuContract.View view) {
        this.mView = view;
        mView.setPresenter(this);
    }
}
