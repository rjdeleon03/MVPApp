package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Row.PopulationDataRowViewHolder;

import java.util.Arrays;
import java.util.List;

public class PopulationDataViewModel extends NewDncaBaseViewModel {

    private PopulationDataNavigator mPopulationDataNavigator;
    private List<PopulationData.AgeGroup> mAgeGroupList;

    public ObservableInt spinnerValue;

    public PopulationDataViewModel(Context context) {
        super(context);
        spinnerValue = new ObservableInt(0);
    }

    /**
     * Set population data navigator
     * @param populationDataNavigator
     */
    public void setPopulationDataNavigator(PopulationDataNavigator populationDataNavigator) {
        mPopulationDataNavigator = populationDataNavigator;
        mAgeGroupList = PopulationData.AgeGroup.asList();
    }

    /**
     * Retrieves list of age group
     */
    public List<PopulationData.AgeGroup> getAgeGroupList() {
        return mAgeGroupList;
    }

    /**
     * Called when add button is pressed
     */
    public void navigateOnAddButtonPressed() {
        mPopulationDataNavigator.onAddButtonPressed();
    }
}
