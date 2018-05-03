package com.rjdeleon.mvp_app.Contracts.GeneralInformation;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.PopulationDataFragmentViewHolder;

public interface PopulationDataContract {

    interface View {

        int getAgeGroupSpinnerValue();

        PopulationDataDialogContract.View onAddButtonClick(android.view.View view);

        void onRowDeleteButtonClick();

        void onAgeGroupAdd();
    }

    interface Presenter {

        void onBindItemViewAtPosition(PopulationDataFragmentViewHolder holder, int position);

        PopulationDataRow getPopulationDataRow(int position);

        int getPopulationDataRowsCount();

        void handleAddButtonClick(android.view.View view);

        void handleRowCardClick(android.view.View view, int position);

        void handleRowDeleteButtonClick(int position);

        void handleAgeGroupAdd(PopulationDataRow row);
    }
}
