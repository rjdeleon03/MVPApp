package com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoRepositoryManager;

import java.util.List;

public abstract class BaseAgeGroupViewModel extends NewDncaGenInfoBaseViewModel {

    protected BaseAgeGroupNavigator mBaseAgeGroupNavigator;
    protected List<PopulationData.AgeGroup> mAgeGroupList = PopulationData.AgeGroup.asList();

    public ObservableInt spinnerValue = new ObservableInt(0);

    /**
     * Constructor
     * @param context
     * @param newDncaGenInfoRepositoryManager
     */
    protected BaseAgeGroupViewModel(Context context, NewDncaGenInfoRepositoryManager newDncaGenInfoRepositoryManager) {
        super(context, newDncaGenInfoRepositoryManager);
    }

    /**
     * Set population data navigator
     * @param baseAgeGroupNavigator
     */
    public void setBaseAgeGroupNavigator(BaseAgeGroupNavigator baseAgeGroupNavigator) {
        mBaseAgeGroupNavigator = baseAgeGroupNavigator;
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
        mBaseAgeGroupNavigator.onAddButtonPressed();
    }

    /**
     * Handles navigation when save button is pressed
     */
    public void navigateOnSaveButtonPressed() {

    }
}
