package com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.PopulationData.Row;

public interface PopulationDataRowContract {

    interface View {
        void bind(PopulationDataRowContract.Presenter presenter);
    }

    interface Presenter {

        void onItemClick(android.view.View view);

        void onDeleteButtonClick(android.view.View view);
    }
}
