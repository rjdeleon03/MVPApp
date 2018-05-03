package com.rjdeleon.mvp_app.Presenters.GeneralInformation;

import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataContract;
import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataDialogContract;

public class PopulationDataDialogPresenter implements PopulationDataDialogContract.Presenter {

    private PopulationDataContract.Presenter mParentPresenter;

    public PopulationDataDialogPresenter(PopulationDataContract.Presenter parentPresenter) {
        this.mParentPresenter = parentPresenter;

        // TODO: Add data for every field here
        // totalMale.set(...)
    }
}
