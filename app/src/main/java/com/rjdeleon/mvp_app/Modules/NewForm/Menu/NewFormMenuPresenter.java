package com.rjdeleon.mvp_app.Modules.NewForm.Menu;

import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewForm.Menu.NewFormMenuContract;

public class NewFormMenuPresenter implements NewFormMenuContract.Presenter {

    NewFormMenuContract.View mView;

    public NewFormMenuPresenter(NewFormMenuContract.View view) {
        this.mView = view;
    }

    @Override
    public void handleNewFormDetailsButtonClick(View view) {
        this.mView.onShowNewFormDetails(view);
    }

    @Override
    public void handleNewFormGenInfoButtonClick(View view) {
        this.mView.onShowNewFormGenInfo(view);
    }
}
