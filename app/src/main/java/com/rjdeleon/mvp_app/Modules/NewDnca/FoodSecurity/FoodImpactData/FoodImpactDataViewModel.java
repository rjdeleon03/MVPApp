package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodImpactData;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodImpactData;
import com.rjdeleon.mvp_app.Models.Generics.BoolRemarksTuple;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodSecurityBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodSecurityRepositoryManager;

public class FoodImpactDataViewModel extends FoodSecurityBaseViewModel implements NonEnumSaveableSection {

    public final ObservableBoolean foodAvailabilityBool = new ObservableBoolean(false);
    public final ObservableField<String> foodAvailabilityRemarks = new ObservableField<>("");
    public final ObservableBoolean lackOfFoodAccessBool = new ObservableBoolean(false);
    public final ObservableField<String> lackOfFoodAccessRemarks = new ObservableField<>("");
    public final ObservableBoolean foodConstraintsBool = new ObservableBoolean(false);
    public final ObservableField<String> foodConstraintsRemarks = new ObservableField<>("");
    public final ObservableBoolean foodSourcesBool = new ObservableBoolean(false);
    public final ObservableField<String> foodSourcesRemarks = new ObservableField<>("");
    
    public final ObservableField<String> timesEatingBefore = new ObservableField<>("");
    public final ObservableField<String> timesEatingAfter = new ObservableField<>("");
    public final ObservableField<String> meetFoodNeedsBefore = new ObservableField<>("");
    public final ObservableField<String> meetFoodNeedsAfter = new ObservableField<>("");
    public final ObservableField<String> foodProdChanged = new ObservableField<>("");
    public final ObservableField<String> nextFoodRation = new ObservableField<>("");

    /**
     * Constructor
     * @param context
     * @param foodSecurityRepositoryManager
     */
    public FoodImpactDataViewModel(Context context, FoodSecurityRepositoryManager foodSecurityRepositoryManager) {
        super(context, foodSecurityRepositoryManager);

        FoodImpactData foodImpactData = mFoodSecurityRepositoryManager.getFoodImpactData();
        foodAvailabilityBool.set(foodImpactData.getFoodAvailability().isYes);
        foodAvailabilityRemarks.set(foodImpactData.getFoodAvailability().remarks);
        lackOfFoodAccessBool.set(foodImpactData.getLackOfFoodAccess().isYes);
        lackOfFoodAccessRemarks.set(foodImpactData.getLackOfFoodAccess().remarks);
        foodConstraintsBool.set(foodImpactData.getFoodConstraints().isYes);
        foodConstraintsRemarks.set(foodImpactData.getFoodConstraints().remarks);
        foodSourcesBool.set(foodImpactData.getFoodSources().isYes);
        foodSourcesRemarks.set(foodImpactData.getFoodSources().remarks);
        timesEatingBefore.set(foodImpactData.getTimesEatingBefore());
        timesEatingAfter.set(foodImpactData.getTimesEatingAfter());
        meetFoodNeedsBefore.set(foodImpactData.getMeetFoodNeedsBefore());
        meetFoodNeedsAfter.set(foodImpactData.getMeetFoodNeedsAfter());
        foodProdChanged.set(foodImpactData.getFoodProdChanged());
        nextFoodRation.set(foodImpactData.getNextFoodRation());
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        FoodImpactData foodImpactData = new FoodImpactData(new BoolRemarksTuple(foodAvailabilityBool.get(), foodAvailabilityRemarks.get()),
                new BoolRemarksTuple(lackOfFoodAccessBool.get(), lackOfFoodAccessRemarks.get()),
                new BoolRemarksTuple(foodConstraintsBool.get(), foodConstraintsRemarks.get()),
                new BoolRemarksTuple(foodSourcesBool.get(), foodSourcesRemarks.get()),
                timesEatingBefore.get(),
                timesEatingAfter.get(),
                meetFoodNeedsBefore.get(),
                meetFoodNeedsAfter.get(),
                foodProdChanged.get(),
                nextFoodRation.get());
        mFoodSecurityRepositoryManager.saveFoodImpactData(foodImpactData);
    }
}
