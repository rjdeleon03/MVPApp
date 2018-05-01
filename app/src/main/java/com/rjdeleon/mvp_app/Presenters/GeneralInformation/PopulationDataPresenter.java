package com.rjdeleon.mvp_app.Presenters.GeneralInformation;

import android.databinding.ObservableBoolean;
import android.view.View;

import com.rjdeleon.mvp_app.AppUtil;
import com.rjdeleon.mvp_app.Contracts.FragmentNavigationContract;
import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataContract;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.PopulationDataFragmentViewHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PopulationDataPresenter implements PopulationDataContract.Presenter {

    private PopulationDataContract.View mView;
    private FragmentNavigationContract.Presenter mParentPresenter;
    private List<PopulationDataRow> mPopulationDataRows;
    private List<PopulationDataRowPresenter> mPopulationDataRowPresenters;
    private List<String> mAgeGroupsList;
    public ObservableBoolean isAddButtonEnabled;

    public PopulationDataPresenter(PopulationDataContract.View view, FragmentNavigationContract.Presenter parentPresenter) {
        this.mView = view;
        this.mParentPresenter = parentPresenter;
        this.mPopulationDataRows = new ArrayList<>();
        this.mPopulationDataRowPresenters = new ArrayList<>();
        this.isAddButtonEnabled = new ObservableBoolean(true);

        // Fill age groups list
        this.mAgeGroupsList = new ArrayList<>();
        for (PopulationData.AgeGroup ag : PopulationData.AgeGroup.values()) {
            if (ag != PopulationData.AgeGroup.ALL) {
                mAgeGroupsList.add(AppUtil.ageGroupToString(ag));
            }
        }
    }

    @Override
    public void handleAddButtonClick(View view) {
        int spinnerValue = mView.getAgeGroupSpinnerValue();
        mPopulationDataRows.add(new PopulationDataRow(AppUtil.stringToAgeGroup(mAgeGroupsList.get(spinnerValue))));
        mAgeGroupsList.remove(spinnerValue);
        mView.onAddButtonClick(view);
        isAddButtonEnabled.set((mAgeGroupsList.size() > 0));
    }

    @Override
    public void onBindItemViewAtPosition(PopulationDataFragmentViewHolder holder, int position) {
        PopulationDataRowPresenter populationDataRowPresenter = new PopulationDataRowPresenter(this, position);
        holder.bind(populationDataRowPresenter);
        mPopulationDataRowPresenters.add(populationDataRowPresenter);
    }

    @Override
    public PopulationDataRow getPopulationDataRow(int position) {
        return mPopulationDataRows.get(position);
    }

    @Override
    public void handleRowDeleteButtonClick(int position) {
        mAgeGroupsList.add(AppUtil.ageGroupToString(mPopulationDataRows.get(position).getAgeGroup()));
        mPopulationDataRows.remove(position);
        mView.onRowDeleteButtonClick();
    }

    public int getPopulationDataRowsCount() {
        return mPopulationDataRows.size();
    }

    public List<String> getAgeGroupsList() {
        return mAgeGroupsList;
    }
}
