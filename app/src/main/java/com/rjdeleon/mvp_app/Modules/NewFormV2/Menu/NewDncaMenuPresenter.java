package com.rjdeleon.mvp_app.Modules.NewFormV2.Menu;

import android.view.View;

public class NewDncaMenuPresenter implements NewDncaMenuContract.Presenter {

    private NewDncaMenuContract.View mView;

    public NewDncaMenuPresenter(NewDncaMenuContract.View view) {
        this.mView = view;
        mView.setPresenter(this);
    }

    /**
     * Handle when user clicks on form details button
     * */
    @Override
    public void onFormDetailsButtonClick(View view) {

    }

    /**
     * Handle when user clicks on general information button
     * */
    @Override
    public void onGenInfoButtonClick(View view) {

    }

    /**
     * Unbind view so it does not get retained
     * */
    @Override
    public void unbind() {
        this.mView = null;
    }
}
