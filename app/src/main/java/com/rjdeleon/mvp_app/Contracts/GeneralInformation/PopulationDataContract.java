package com.rjdeleon.mvp_app.Contracts.GeneralInformation;

public interface PopulationDataContract {

    interface View {

        void onAddButtonClick(android.view.View view);
    }

    interface Presenter {

        void handleAddButtonClick(android.view.View view);
    }
}
