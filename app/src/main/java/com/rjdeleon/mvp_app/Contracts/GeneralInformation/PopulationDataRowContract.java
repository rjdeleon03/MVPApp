package com.rjdeleon.mvp_app.Contracts.GeneralInformation;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;

public interface PopulationDataRowContract {

    interface View {
        void bind(PopulationDataRowContract.Presenter presenter);
    }

    interface Presenter {

        void onItemClick(android.view.View view);

        void onDeleteButtonClick(android.view.View view);
    }
}
