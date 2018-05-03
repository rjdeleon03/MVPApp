package com.rjdeleon.mvp_app.Presenters.GeneralInformation;

import android.databinding.ObservableInt;
import android.view.View;

import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataContract;
import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataDialogContract;

public class PopulationDataDialogPresenter implements PopulationDataDialogContract.Presenter {

    private PopulationDataContract.Presenter mParentPresenter;
    private PopulationDataDialogContract.View mView;

    public PopulationDataDialogPresenter(PopulationDataDialogContract.View view, PopulationDataContract.Presenter parentPresenter) {

        this.mView = view;
        this.mParentPresenter = parentPresenter;
    }

    @Override
    public void handleDialogOkButtonClick(View view) {

    }

    @Override
    public void handleDialogCancelButtonClick(View view) {
        mView.onDialogCancelButtonClick(view);
    }
}
