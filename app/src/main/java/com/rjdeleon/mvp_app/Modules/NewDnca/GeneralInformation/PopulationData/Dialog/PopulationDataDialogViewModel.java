package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Dialog;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataNavigator;

public class PopulationDataDialogViewModel extends NewDncaBaseViewModel {

    private PopulationDataNavigator mPopulationDataNavigator;

    public PopulationDataDialogViewModel(Context context) {
        super(context);
    }

    public void setPopulationDataNavigator(PopulationDataNavigator populationDataNavigator) {
        mPopulationDataNavigator = populationDataNavigator;
    }

    public void navigateOnCancelButtonPressed() {
        if (mPopulationDataNavigator != null)
        mPopulationDataNavigator.onDialogCloseButtonPressed();
    }

    public void navigateOnOkButtonPressed() {

    }
}
