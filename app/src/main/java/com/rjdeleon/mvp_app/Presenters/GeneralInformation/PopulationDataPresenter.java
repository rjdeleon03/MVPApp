package com.rjdeleon.mvp_app.Presenters.GeneralInformation;

import android.view.View;

import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataContract;

public class PopulationDataPresenter implements PopulationDataContract.Presenter {

    private PopulationDataContract.View mView;

    public PopulationDataPresenter(PopulationDataContract.View view) {
        this.mView = view;
    }

    @Override
    public void handleAddButtonClick(View view) {
        mView.onAddButtonClick(view);
    }
}
