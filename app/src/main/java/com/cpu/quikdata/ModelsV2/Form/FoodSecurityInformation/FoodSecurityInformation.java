package com.cpu.quikdata.ModelsV2.Form.FoodSecurityInformation;

import com.cpu.quikdata.ModelsV2.Form.Common.AssistanceData;
import com.cpu.quikdata.ModelsV2.Form.Common.IAssistanceDataContainer;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class FoodSecurityInformation extends RealmObject implements IAssistanceDataContainer {

    @Required
    @PrimaryKey
    private String id;

    private ImpactDetails impactDetails;
    private FoodSecurityCopingDetails foodSecurityCopingDetails;
    private FoodSecurityNeedsDetails foodSecurityNeedsDetails;
    private FoodSecurityGapsDetails foodSecurityGapsDetails;
    private AssistanceData foodAssistanceData;

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

    @Override
    public AssistanceData getAssistanceData() {
        return foodAssistanceData;
    }

    @Override
    public void setAssistanceData(AssistanceData assistanceData) {
        this.foodAssistanceData = assistanceData;
    }
}
