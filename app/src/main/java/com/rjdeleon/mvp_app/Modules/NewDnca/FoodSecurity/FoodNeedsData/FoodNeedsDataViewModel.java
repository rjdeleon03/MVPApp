package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodNeedsData;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodNeedsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodSecurityBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodSecurityRepositoryManager;

public class FoodNeedsDataViewModel extends FoodSecurityBaseViewModel implements NonEnumSaveableSection {

    public final ObservableField<String> assistanceNeeded = new ObservableField<>();
    public final ObservableInt numberOfFamilies = new ObservableInt(0);

    /**
     * Constructor
     * @param context
     * @param foodSecurityRepositoryManager
     */
    public FoodNeedsDataViewModel(Context context, FoodSecurityRepositoryManager foodSecurityRepositoryManager) {
        super(context, foodSecurityRepositoryManager);

        FoodNeedsData foodNeedsData = mFoodSecurityRepositoryManager.getFoodNeedsData();
        assistanceNeeded.set(foodNeedsData.getAssistanceNeeded());
        numberOfFamilies.set(foodNeedsData.getNumberOfFamilies());
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        FoodNeedsData foodNeedsData = new FoodNeedsData(assistanceNeeded.get(), numberOfFamilies.get());
        mFoodSecurityRepositoryManager.saveFoodNeedsData(foodNeedsData);
    }
}
