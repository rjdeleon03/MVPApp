package com.rjdeleon.mvp_app.Presenters.GeneralInformation;

import android.databinding.ObservableField;
import android.view.View;

import com.rjdeleon.mvp_app.AppUtil;
import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataContract;
import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataRowContract;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;

public class PopulationDataRowPresenter implements PopulationDataRowContract.Presenter {

    private PopulationDataContract.Presenter mParentPresenter;
    private PopulationDataRow mPopulationDataRow;
    private int mPosition;

    public ObservableField<String> ageGroup;

    public PopulationDataRowPresenter(PopulationDataContract.Presenter parentPresenter, int position) {
        this.mParentPresenter = parentPresenter;
        this.mPopulationDataRow = mParentPresenter.getPopulationDataRow(position);
        this.mPosition = position;

        this.ageGroup = new ObservableField<>(AppUtil.ageGroupToString(mPopulationDataRow.getAgeGroup()));
    }

    @Override
    public void onItemClick(View view) {

    }

    @Override
    public void onDeleteButtonClick(View view) {
        mParentPresenter.handleRowDeleteButtonClick(mPosition);
    }
}
