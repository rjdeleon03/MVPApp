package com.rjdeleon.mvp_app.Modules.NewFormV2.Menu;

import android.view.View;

public class NewDncaMenuPresenter implements NewDncaMenuContract.Presenter {

    private NewDncaMenuContract.View mView;

    public NewDncaMenuPresenter(NewDncaMenuContract.View view) {
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void onFormDetailsButtonClick(View view) {

    }
}
