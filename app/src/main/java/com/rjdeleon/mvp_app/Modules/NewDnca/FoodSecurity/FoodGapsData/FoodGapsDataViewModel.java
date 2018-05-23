package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodGapsData;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodGapsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodSecurityBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodSecurityRepositoryManager;

public class FoodGapsDataViewModel extends FoodSecurityBaseViewModel implements NonEnumSaveableSection {

    public final ObservableField<String> isAssistanceAppropriate = new ObservableField<>("");
    public final ObservableField<String> isAssistanceEnough = new ObservableField<>("");
    public final ObservableField<String> hasEqualAccess = new ObservableField<>("");
    public final ObservableField<String> wereAllConsidered = new ObservableField<>("");
    
    /**
     * Constructor
     * @param context
     * @param foodSecurityRepositoryManager
     */
    public FoodGapsDataViewModel(Context context, FoodSecurityRepositoryManager foodSecurityRepositoryManager) {
        super(context, foodSecurityRepositoryManager);

        FoodGapsData foodGapsData = mFoodSecurityRepositoryManager.getFoodGapsData();
        isAssistanceAppropriate.set(foodGapsData.getIsAssistanceAppropriate());
        isAssistanceEnough.set(foodGapsData.getIsAssistanceEnough());
        hasEqualAccess.set(foodGapsData.getHasEqualAccess());
        wereAllConsidered.set(foodGapsData.getWereAllConsidered());
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        FoodGapsData foodGapsData = new FoodGapsData(
                isAssistanceAppropriate.get(),
                isAssistanceEnough.get(),
                hasEqualAccess.get(),
                wereAllConsidered.get());
        mFoodSecurityRepositoryManager.saveFoodGapsData(foodGapsData);
    }
}
