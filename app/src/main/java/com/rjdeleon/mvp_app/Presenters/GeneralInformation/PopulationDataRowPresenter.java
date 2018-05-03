package com.rjdeleon.mvp_app.Presenters.GeneralInformation;

import android.databinding.ObservableField;
import android.view.View;

import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataContract;
import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataRowContract;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;

public class PopulationDataRowPresenter implements PopulationDataRowContract.Presenter {

    private PopulationDataContract.Presenter mParentPresenter;
    private PopulationDataRow mPopulationDataRow;
    private int mPosition;

    public PopulationDataRowPresenter(PopulationDataContract.Presenter parentPresenter, int position) {
        this.mParentPresenter = parentPresenter;
        this.mPopulationDataRow = mParentPresenter.getPopulationDataRow(position);
        this.mPosition = position;

        ageGroup.set(mPopulationDataRow.getAgeGroup().toString());
        totalMale.set(mPopulationDataRow.getTotal().male);
        totalFemale.set(mPopulationDataRow.getTotal().female);
        affectedMale.set(mPopulationDataRow.getAffected().male);
        affectedFemale.set(mPopulationDataRow.getAffected().female);
        displacedMale.set(mPopulationDataRow.getDisplaced().male);
        displacedFemale.set(mPopulationDataRow.getDisplaced().female);
    }

    @Override
    public void onItemClick(View view) {

    }

    @Override
    public void onDeleteButtonClick(View view) {
        mParentPresenter.handleRowDeleteButtonClick(mPosition);
    }
}
