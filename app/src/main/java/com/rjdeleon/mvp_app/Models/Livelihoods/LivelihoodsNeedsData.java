package com.rjdeleon.mvp_app.Models.Livelihoods;

public class LivelihoodsNeedsData {

    private String assistanceToFillGap;
    private String resourcesNeeded;
    private String familiesNeedingAssistance;

    public LivelihoodsNeedsData(String assistanceToFillGap, String resourcesNeeded, String familiesNeedingAssistance) {
        this.assistanceToFillGap = assistanceToFillGap;
        this.resourcesNeeded = resourcesNeeded;
        this.familiesNeedingAssistance = familiesNeedingAssistance;
    }

    public LivelihoodsNeedsData() {
        this("", "", "");
    }

    public String getAssistanceToFillGap() {
        return assistanceToFillGap;
    }

    public void setAssistanceToFillGap(String assistanceToFillGap) {
        this.assistanceToFillGap = assistanceToFillGap;
    }

    public String getResourcesNeeded() {
        return resourcesNeeded;
    }

    public void setResourcesNeeded(String resourcesNeeded) {
        this.resourcesNeeded = resourcesNeeded;
    }

    public String getFamiliesNeedingAssistance() {
        return familiesNeedingAssistance;
    }

    public void setFamiliesNeedingAssistance(String familiesNeedingAssistance) {
        this.familiesNeedingAssistance = familiesNeedingAssistance;
    }
}
