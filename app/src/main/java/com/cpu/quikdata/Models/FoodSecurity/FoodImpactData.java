package com.cpu.quikdata.Models.FoodSecurity;

import com.cpu.quikdata.Models.Generics.BoolRemarksTuple;

public class FoodImpactData {

    private BoolRemarksTuple foodAvailability;
    private BoolRemarksTuple lackOfFoodAccess;
    private BoolRemarksTuple foodConstraints;
    private BoolRemarksTuple foodSources;

    private String timesEatingBefore;
    private String timesEatingAfter;
    private String meetFoodNeedsBefore;
    private String meetFoodNeedsAfter;
    private String foodProdChanged;
    private String nextFoodRation;

    public FoodImpactData(BoolRemarksTuple foodAvailability, BoolRemarksTuple lackOfFoodAccess, BoolRemarksTuple foodConstraints, BoolRemarksTuple foodSources, String timesEatingBefore, String timesEatingAfter, String meetFoodNeedsBefore, String meetFoodNeedsAfter, String foodProdChanged, String nextFoodRation) {
        this.foodAvailability = foodAvailability;
        this.lackOfFoodAccess = lackOfFoodAccess;
        this.foodConstraints = foodConstraints;
        this.foodSources = foodSources;
        this.timesEatingBefore = timesEatingBefore;
        this.timesEatingAfter = timesEatingAfter;
        this.meetFoodNeedsBefore = meetFoodNeedsBefore;
        this.meetFoodNeedsAfter = meetFoodNeedsAfter;
        this.foodProdChanged = foodProdChanged;
        this.nextFoodRation = nextFoodRation;
    }

    public FoodImpactData() {
        this(new BoolRemarksTuple(),
                new BoolRemarksTuple(),
                new BoolRemarksTuple(),
                new BoolRemarksTuple(),
                "" ,
                "" ,
                "" ,
                "" ,
                "" ,
                "" );
    }

    public BoolRemarksTuple getFoodAvailability() {
        return foodAvailability;
    }

    public void setFoodAvailability(BoolRemarksTuple foodAvailability) {
        this.foodAvailability = foodAvailability;
    }

    public BoolRemarksTuple getLackOfFoodAccess() {
        return lackOfFoodAccess;
    }

    public void setLackOfFoodAccess(BoolRemarksTuple lackOfFoodAccess) {
        this.lackOfFoodAccess = lackOfFoodAccess;
    }

    public BoolRemarksTuple getFoodConstraints() {
        return foodConstraints;
    }

    public void setFoodConstraints(BoolRemarksTuple foodConstraints) {
        this.foodConstraints = foodConstraints;
    }

    public BoolRemarksTuple getFoodSources() {
        return foodSources;
    }

    public void setFoodSources(BoolRemarksTuple foodSources) {
        this.foodSources = foodSources;
    }

    public String getTimesEatingBefore() {
        return timesEatingBefore;
    }

    public void setTimesEatingBefore(String timesEatingBefore) {
        this.timesEatingBefore = timesEatingBefore;
    }

    public String getTimesEatingAfter() {
        return timesEatingAfter;
    }

    public void setTimesEatingAfter(String timesEatingAfter) {
        this.timesEatingAfter = timesEatingAfter;
    }

    public String getMeetFoodNeedsBefore() {
        return meetFoodNeedsBefore;
    }

    public void setMeetFoodNeedsBefore(String meetFoodNeedsBefore) {
        this.meetFoodNeedsBefore = meetFoodNeedsBefore;
    }

    public String getMeetFoodNeedsAfter() {
        return meetFoodNeedsAfter;
    }

    public void setMeetFoodNeedsAfter(String meetFoodNeedsAfter) {
        this.meetFoodNeedsAfter = meetFoodNeedsAfter;
    }

    public String getFoodProdChanged() {
        return foodProdChanged;
    }

    public void setFoodProdChanged(String foodProdChanged) {
        this.foodProdChanged = foodProdChanged;
    }

    public String getNextFoodRation() {
        return nextFoodRation;
    }

    public void setNextFoodRation(String nextFoodRation) {
        this.nextFoodRation = nextFoodRation;
    }
}
