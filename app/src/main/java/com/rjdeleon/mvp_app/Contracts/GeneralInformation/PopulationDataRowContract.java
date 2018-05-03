package com.rjdeleon.mvp_app.Contracts.GeneralInformation;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;

public interface PopulationDataRowContract {

    interface View {
        void bind(PopulationDataRowContract.Presenter presenter);
    }

    interface Presenter {

        ObservableField<String> ageGroup = new ObservableField<>(PopulationData.AgeGroup.AGE_0_5.toString());
        ObservableInt totalMale = new ObservableInt(0);
        ObservableInt totalFemale = new ObservableInt(0);
        ObservableInt affectedMale = new ObservableInt(0);
        ObservableInt affectedFemale = new ObservableInt(0);
        ObservableInt displacedMale = new ObservableInt(0);
        ObservableInt displacedFemale = new ObservableInt(0);

        void onItemClick(android.view.View view);

        void onDeleteButtonClick(android.view.View view);
    }
}
