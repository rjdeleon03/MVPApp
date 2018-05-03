package com.rjdeleon.mvp_app.Presenters.GeneralInformation;

import android.databinding.ObservableInt;
import android.view.View;

import com.rjdeleon.mvp_app.AppUtil;
import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataContract;
import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataDialogContract;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;

public class PopulationDataDialogPresenter implements PopulationDataDialogContract.Presenter {

    private PopulationDataContract.Presenter mParentPresenter;
    private PopulationDataDialogContract.View mView;
    private PopulationDataRow mPopulationDataRow;

    public PopulationDataDialogPresenter(PopulationDataDialogContract.View view, PopulationDataContract.Presenter parentPresenter) {

        this.mView = view;
        this.mParentPresenter = parentPresenter;
    }

    @Override
    public void handleDialogOkButtonClick(View view) {
        GenderTuple total = new GenderTuple(totalMale.get(), totalFemale.get());
        GenderTuple affected = new GenderTuple(affectedMale.get(), affectedFemale.get());
        GenderTuple displaced = new GenderTuple(displacedMale.get(), displacedFemale.get());
        PopulationData.AgeGroup ag = AppUtil.stringToAgeGroup(ageGroup.get());
        PopulationDataRow newRow = new PopulationDataRow(ag, total, affected, displaced);
        mParentPresenter.handleAgeGroupAdd(newRow);
        mView.onDialogCancelButtonClick(view);
    }

    @Override
    public void handleDialogCancelButtonClick(View view) {
        mView.onDialogCancelButtonClick(view);
    }
}
