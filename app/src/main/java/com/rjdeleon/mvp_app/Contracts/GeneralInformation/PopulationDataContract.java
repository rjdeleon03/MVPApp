package com.rjdeleon.mvp_app.Contracts.GeneralInformation;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.PopulationDataFragmentViewHolder;

public interface PopulationDataContract {

    interface View {

        void onAddButtonClick(android.view.View view);

        int getAgeGroupSpinnerValue();

        void onRowDeleteButtonClick();

        void onAgeGroupAdd();
    }

    interface Presenter {

        void onBindItemViewAtPosition(PopulationDataFragmentViewHolder holder, int position);

        void onBindDialog(PopulationDataDialogContract.View view);

        PopulationDataRow getPopulationDataRow(int position);

        void handleAddButtonClick(android.view.View view);

        void handleRowDeleteButtonClick(int position);

        void handleAgeGroupAdd(PopulationDataRow row);
    }
}
