package com.rjdeleon.mvp_app.Contracts.GeneralInformation;

import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.PopulationDataFragmentViewHolder;

public interface PopulationDataContract {

    interface View {

        void onAddButtonClick(android.view.View view);

        int getAgeGroupSpinnerValue();
    }

    interface Presenter {

        void handleAddButtonClick(android.view.View view);

        void onBindItemViewAtPosition(PopulationDataFragmentViewHolder holder, int position);
    }
}
