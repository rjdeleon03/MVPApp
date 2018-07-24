package com.cpu.quikdata.ModelsV2.Form.FoodSecurityInformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class FoodSecurityInformation extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private ImpactDetails impactDetails;
    private FoodSecurityCopingDetails foodSecurityCopingDetails;
    private FoodSecurityNeedsDetails foodSecurityNeedsDetails;
    private FoodSecurityGapsDetails foodSecurityGapsDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImpactDetails getImpactDetails() {
        return impactDetails;
    }

    public void setImpactDetails(ImpactDetails impactDetails) {
        this.impactDetails = impactDetails;
    }

    public FoodSecurityCopingDetails getFoodSecurityCopingDetails() {
        return foodSecurityCopingDetails;
    }

    public void setFoodSecurityCopingDetails(FoodSecurityCopingDetails foodSecurityCopingDetails) {
        this.foodSecurityCopingDetails = foodSecurityCopingDetails;
    }

    public FoodSecurityNeedsDetails getFoodSecurityNeedsDetails() {
        return foodSecurityNeedsDetails;
    }

    public void setFoodSecurityNeedsDetails(FoodSecurityNeedsDetails foodSecurityNeedsDetails) {
        this.foodSecurityNeedsDetails = foodSecurityNeedsDetails;
    }

    public FoodSecurityGapsDetails getFoodSecurityGapsDetails() {
        return foodSecurityGapsDetails;
    }

    public void setFoodSecurityGapsDetails(FoodSecurityGapsDetails foodSecurityGapsDetails) {
        this.foodSecurityGapsDetails = foodSecurityGapsDetails;
    }
}
