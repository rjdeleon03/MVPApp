package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Row.PopulationDataRowViewHolder;

import java.util.Arrays;
import java.util.List;

public class PopulationDataViewModel extends NewDncaBaseViewModel {

    private PopulationDataNavigator mPopulationDataNavigator;

    private List<PopulationData.AgeGroup> mAgeGroupList;

    public PopulationDataViewModel(Context context) {
        super(context);
    }

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

    public void onBindPopulationDataRowViewAtPosition(PopulationDataRowViewHolder holder, int position) {

    }
}
