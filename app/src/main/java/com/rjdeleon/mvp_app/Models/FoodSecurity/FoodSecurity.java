package com.rjdeleon.mvp_app.Models.FoodSecurity;

import com.rjdeleon.mvp_app.Models.Generics.AssistanceData;
import com.rjdeleon.mvp_app.Models.Generics.GenericCopingData;

public class FoodSecurity {

    private FoodImpactData impactData;
    private GenericCopingData copingData;
    private FoodNeedsData needsData;
    private AssistanceData assistanceData;
    private FoodGapsData gapsData;

    public FoodSecurity(FoodImpactData impactData, GenericCopingData copingData, FoodNeedsData needsData, AssistanceData assistanceData, FoodGapsData gapsData) {
        this.impactData = impactData;
        this.copingData = copingData;
        this.needsData = needsData;
        this.assistanceData = assistanceData;
        this.gapsData = gapsData;
    }

    public FoodSecurity() {
        this(new FoodImpactData(), new GenericCopingData(), new FoodNeedsData(), new AssistanceData(), new FoodGapsData());
    }

    public FoodImpactData getImpactData() {
        return impactData;
    }

    public void setImpactData(FoodImpactData impactData) {
        this.impactData = impactData;
    }

    public GenericCopingData getCopingData() {
        return copingData;
    }

    public void setCopingData(GenericCopingData copingData) {
        this.copingData = copingData;
    }

    public FoodNeedsData getNeedsData() {
        return needsData;
    }

    public void setNeedsData(FoodNeedsData needsData) {
        this.needsData = needsData;
    }

    public AssistanceData getAssistanceData() {
        return assistanceData;
    }

    public void setAssistanceData(AssistanceData assistanceData) {
        this.assistanceData = assistanceData;
    }

    public FoodGapsData getGapsData() {
        return gapsData;
    }

    public void setGapsData(FoodGapsData gapsData) {
        this.gapsData = gapsData;
    }
}
