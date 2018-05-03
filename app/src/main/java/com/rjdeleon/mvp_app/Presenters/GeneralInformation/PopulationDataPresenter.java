package com.rjdeleon.mvp_app.Presenters.GeneralInformation;

import android.databinding.ObservableBoolean;
import android.view.View;

import com.rjdeleon.mvp_app.AppUtil;
import com.rjdeleon.mvp_app.Contracts.FragmentNavigationContract;
import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataContract;
import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataDialogContract;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.PopulationDataFragmentViewHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PopulationDataPresenter implements PopulationDataContract.Presenter {

    private PopulationDataContract.View mView;
    private FragmentNavigationContract.Presenter mParentPresenter;
    private List<PopulationDataRow> mPopulationDataRows;
    private List<PopulationData.AgeGroup> mAgeGroupsList;
    public ObservableBoolean isAddButtonEnabled;

    public PopulationDataPresenter(PopulationDataContract.View view, FragmentNavigationContract.Presenter parentPresenter) {
        this.mView = view;
        this.mParentPresenter = parentPresenter;
        this.mPopulationDataRows = new ArrayList<>();
        this.isAddButtonEnabled = new ObservableBoolean(true);

        // Fill age groups list
        this.mAgeGroupsList = new ArrayList<>();
        for (PopulationData.AgeGroup ag : PopulationData.AgeGroup.values()) {
            if (ag != PopulationData.AgeGroup.ALL) {
                mAgeGroupsList.add(ag);
            }
        }
    }

    @Override
    public void onBindItemViewAtPosition(PopulationDataFragmentViewHolder holder, int position) {
        PopulationDataRowPresenter populationDataRowPresenter = new PopulationDataRowPresenter(this, position);
        holder.bind(populationDataRowPresenter);
    }

    @Override
    public PopulationDataRow getPopulationDataRow(int position) {
        return mPopulationDataRows.get(position);
    }

    @Override
    public void handleAddButtonClick(View view) {
        PopulationDataDialogContract.View dialog = mView.onAddButtonClick(view);
        int spinnerValue = mView.getAgeGroupSpinnerValue();
        PopulationDataDialogPresenter populationDataDialogPresenter = new PopulationDataDialogPresenter(
                dialog,this, new PopulationDataRow(mAgeGroupsList.get(spinnerValue)));
        dialog.bind(populationDataDialogPresenter);
    }

    @Override
    public void handleRowCardClick(android.view.View view, int position) {
        PopulationDataDialogContract.View dialog = mView.onAddButtonClick(view);
        PopulationDataDialogPresenter populationDataDialogPresenter = new PopulationDataDialogPresenter(
                dialog,this, mPopulationDataRows.get(position));
        dialog.bind(populationDataDialogPresenter);

        PopulationDataRow testRow = mPopulationDataRows.get(position);
        GenderTuple testGt = testRow.getTotal();
        testGt.male += 3;
        testGt.female += 5;
        testRow.setTotal(testGt);
        mView.onAgeGroupAdd();
    }

    @Override
    public void handleRowDeleteButtonClick(int position) {

        // Insert AgeGroup into correct position in list
        PopulationData.AgeGroup ageGroupToAdd = mPopulationDataRows.get(position).getAgeGroup();
        int listCount = mAgeGroupsList.size();
        for (int i = 0; i <= listCount; i++) {
            if (listCount >= i+1) {
                if (mAgeGroupsList.get(i).ordinal() > ageGroupToAdd.ordinal()) {
                    mAgeGroupsList.add(i, ageGroupToAdd);
                    break;
                }
            } else {
                mAgeGroupsList.add(i, ageGroupToAdd);
                break;
            }
        }
        mPopulationDataRows.remove(position);
        isAddButtonEnabled.set((mAgeGroupsList.size() > 0));
        mView.onRowDeleteButtonClick();
    }

    @Override
    public void handleAgeGroupAdd(PopulationDataRow row) {

        // Insert AgeGroup into correct position in rows list
        PopulationData.AgeGroup rowAgeGroupToAdd = row.getAgeGroup();
        int rowsCount = getPopulationDataRowsCount();
        for (int i = 0; i <= rowsCount; i++) {
            if (rowsCount >= i+1) {
                if (mPopulationDataRows.get(i).getAgeGroup().ordinal() > rowAgeGroupToAdd.ordinal()) {
                    mPopulationDataRows.add(i, row);
                    break;
                }
            } else {
                mPopulationDataRows.add(i, row);
                break;
            }
        }
        mAgeGroupsList.remove(mView.getAgeGroupSpinnerValue());
        isAddButtonEnabled.set((mAgeGroupsList.size() > 0));
        mView.onAgeGroupAdd();
    }

    @Override
    public int getPopulationDataRowsCount() {
        return mPopulationDataRows.size();
    }

    public List<PopulationData.AgeGroup> getAgeGroupsList() {
        return mAgeGroupsList;
    }
}
