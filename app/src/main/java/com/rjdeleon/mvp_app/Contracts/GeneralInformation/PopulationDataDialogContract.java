package com.rjdeleon.mvp_app.Contracts.GeneralInformation;

public interface PopulationDataDialogContract {

    interface View {

        void bind(PopulationDataDialogContract.Presenter presenter);

        void onDialogCancelButtonClick(android.view.View view);
    }

    interface Presenter {

        void handleDialogOkButtonClick(android.view.View view);

        void handleDialogCancelButtonClick(android.view.View view);
    }
}
