package com.rjdeleon.mvp_app.Models.FoodSecurity;

import com.rjdeleon.mvp_app.Models.Generics.AssistanceData;

public class FoodSecurity {

    private FoodImpactData foodImpactData;
    private FoodCopingData foodCopingData;
    private FoodNeedsData foodNeedsData;
    private AssistanceData assistanceData;
    private FoodGapsData foodGapsData;

    public FoodSecurity(FoodImpactData foodImpactData, FoodCopingData foodCopingData, FoodNeedsData foodNeedsData, AssistanceData assistanceData, FoodGapsData foodGapsData) {
        this.foodImpactData = foodImpactData;
        this.foodCopingData = foodCopingData;
        this.foodNeedsData = foodNeedsData;
        this.assistanceData = assistanceData;
        this.foodGapsData = foodGapsData;
    }

    public FoodSecurity() {
        this(new FoodImpactData(), new FoodCopingData(), new FoodNeedsData(), new AssistanceData(), new FoodGapsData());
    }

    public FoodImpactData getFoodImpactData() {
        return foodImpactData;
    }

    public void setFoodImpactData(FoodImpactData foodImpactData) {
        this.foodImpactData = foodImpactData;
    }

    public FoodCopingData getFoodCopingData() {
        return foodCopingData;
    }

    public void setFoodCopingData(FoodCopingData foodCopingData) {
        this.foodCopingData = foodCopingData;
    }

    public FoodNeedsData getFoodNeedsData() {
        return foodNeedsData;
    }

    public void setFoodNeedsData(FoodNeedsData foodNeedsData) {
        this.foodNeedsData = foodNeedsData;
    }

    public AssistanceData getAssistanceData() {
        return assistanceData;
    }

    public void setAssistanceData(AssistanceData assistanceData) {
        this.assistanceData = assistanceData;
    }

    public FoodGapsData getFoodGapsData() {
        return foodGapsData;
    }

    public void setFoodGapsData(FoodGapsData foodGapsData) {
        this.foodGapsData = foodGapsData;
    }
}
