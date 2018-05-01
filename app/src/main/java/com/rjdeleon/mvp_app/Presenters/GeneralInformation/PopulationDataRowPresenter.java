package com.rjdeleon.mvp_app.Presenters.GeneralInformation;

import android.databinding.ObservableField;
import android.view.View;

import com.rjdeleon.mvp_app.AppUtil;
import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataRowContract;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;

public class PopulationDataRowPresenter implements PopulationDataRowContract.Presenter {

    private PopulationDataRow mPopulationDataRow;
    public ObservableField<String> ageGroup;

    public PopulationDataRowPresenter(PopulationDataRow populationDataRow) {
        this.mPopulationDataRow = populationDataRow;

        this.ageGroup = new ObservableField<>(AppUtil.ageGroupToString(mPopulationDataRow.getAgeGroup()));
    }

    @Override
    public void onItemClick(View view) {

    }

    @Override
    public void onDeleteButtonClick(View view) {

    }
}
