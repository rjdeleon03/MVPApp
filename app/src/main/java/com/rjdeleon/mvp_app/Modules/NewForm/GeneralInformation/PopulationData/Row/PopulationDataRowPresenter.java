package com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.PopulationData.Row;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.PopulationData.PopulationDataContract;
import com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.PopulationData.Row.PopulationDataRowContract;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;

public class PopulationDataRowPresenter implements PopulationDataRowContract.Presenter {

    private PopulationDataContract.Presenter mParentPresenter;
    private PopulationDataRow mPopulationDataRow;
    private int mPosition;

    public ObservableField<String> ageGroup = new ObservableField<>(PopulationData.AgeGroup.AGE_0_5.toString());
    public ObservableInt totalMale = new ObservableInt(0);
    public ObservableInt totalFemale = new ObservableInt(0);
    public ObservableInt affectedMale = new ObservableInt(0);
    public ObservableInt affectedFemale = new ObservableInt(0);
    public ObservableInt displacedMale = new ObservableInt(0);
    public ObservableInt displacedFemale = new ObservableInt(0);

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
        mParentPresenter.handleRowCardClick(view, mPosition);
    }

    @Override
    public void onDeleteButtonClick(View view) {
        mParentPresenter.handleRowDeleteButtonClick(mPosition);
    }
}
