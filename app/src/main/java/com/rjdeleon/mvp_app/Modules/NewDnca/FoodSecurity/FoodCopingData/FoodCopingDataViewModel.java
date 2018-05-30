package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodCopingData;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.Generics.GenericCopingData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodSecurityBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodSecurityRepositoryManager;

public class FoodCopingDataViewModel extends FoodSecurityBaseViewModel implements NonEnumSaveableSection {

    public final ObservableField<String> copingStrategies = new ObservableField<>();

    /**
     * Constructor
     * @param context
     * @param foodSecurityRepositoryManager
     */
    public FoodCopingDataViewModel(Context context, FoodSecurityRepositoryManager foodSecurityRepositoryManager) {
        super(context, foodSecurityRepositoryManager);

        GenericCopingData foodCopingData = mFoodSecurityRepositoryManager.getFoodCopingData();
        copingStrategies.set(foodCopingData.getCopingStrategies());
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        GenericCopingData foodCopingData = new GenericCopingData(copingStrategies.get());
        mFoodSecurityRepositoryManager.saveFoodCopingData(foodCopingData);
    }
}
