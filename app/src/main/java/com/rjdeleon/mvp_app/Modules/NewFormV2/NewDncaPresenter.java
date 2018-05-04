package com.rjdeleon.mvp_app.Modules.NewFormV2;

import android.view.View;

public class NewDncaPresenter implements NewDncaContract.Presenter {

    private NewDncaContract.View mView;

    public NewDncaPresenter(NewDncaContract.View view) {
        this.mView = view;
    }

    @Override
    public void onBackButtonClick(View view) {
        mView.navigateBack(view);
    }
}
