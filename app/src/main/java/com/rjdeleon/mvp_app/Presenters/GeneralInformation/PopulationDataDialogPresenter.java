package com.rjdeleon.mvp_app.Presenters.GeneralInformation;

import android.view.View;

import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataContract;
import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataDialogContract;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;

public class PopulationDataDialogPresenter implements PopulationDataDialogContract.Presenter {

    private PopulationDataContract.Presenter mParentPresenter;
    private PopulationDataDialogContract.View mView;
    private PopulationDataRow mPopulationDataRow;

    public PopulationDataDialogPresenter(PopulationDataDialogContract.View view, PopulationDataContract.Presenter parentPresenter, PopulationDataRow row) {
        this.mView = view;
        this.mParentPresenter = parentPresenter;
        this.mPopulationDataRow = row;

        ageGroup.set(mPopulationDataRow.getAgeGroup().toString());
        totalMale.set(mPopulationDataRow.getTotal().male);
        totalFemale.set(mPopulationDataRow.getTotal().female);
        affectedMale.set(mPopulationDataRow.getAffected().male);
        affectedFemale.set(mPopulationDataRow.getAffected().female);
        displacedMale.set(mPopulationDataRow.getDisplaced().male);
        displacedFemale.set(mPopulationDataRow.getDisplaced().female);
    }

    @Override
    public void handleDialogOkButtonClick(View view) {
        mPopulationDataRow.getTotal().male = totalMale.get();
        mPopulationDataRow.getTotal().female = totalFemale.get();
        mPopulationDataRow.getAffected().male = affectedMale.get();
        mPopulationDataRow.getAffected().female = affectedFemale.get();
        mPopulationDataRow.getDisplaced().male = displacedMale.get();
        mPopulationDataRow.getDisplaced().female = displacedFemale.get();;
        mParentPresenter.handleAgeGroupAdd(mPopulationDataRow);
        mView.onDialogCancelButtonClick(view);
    }

    @Override
    public void handleDialogCancelButtonClick(View view) {
        mView.onDialogCancelButtonClick(view);
    }
}
