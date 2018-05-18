package com.rjdeleon.mvp_app.Models.ShelterNonFoodItems;

import com.rjdeleon.mvp_app.Models.Generics.AssistanceData;

public class ShelterInfo {

    private ShelterHouseDamageData houseDamageData;
    private ShelterCopingData copingData;
    private ShelterNeedsData needsData;
    private AssistanceData assistanceData;
    private ShelterGapsData gapsData;

    public ShelterInfo(ShelterHouseDamageData houseDamageData, ShelterCopingData copingData, ShelterNeedsData needsData, AssistanceData assistanceData, ShelterGapsData gapsData) {
        this.houseDamageData = houseDamageData;
        this.copingData = copingData;
        this.needsData = needsData;
        this.assistanceData = assistanceData;
        this.gapsData = gapsData;
    }

    public ShelterInfo() {
        this.houseDamageData = new ShelterHouseDamageData();
        this.copingData = new ShelterCopingData();
        this.needsData = new ShelterNeedsData();
        this.assistanceData = new AssistanceData();
        this.gapsData = new ShelterGapsData();
    }

    public ShelterHouseDamageData getHouseDamageData() {
        return houseDamageData;
    }

    public void setHouseDamageData(ShelterHouseDamageData houseDamageData) {
        this.houseDamageData = houseDamageData;
    }

    public ShelterCopingData getCopingData() {
        return copingData;
    }

    public void setCopingData(ShelterCopingData copingData) {
        this.copingData = copingData;
    }

    public ShelterNeedsData getNeedsData() {
        return needsData;
    }

    public void setNeedsData(ShelterNeedsData needsData) {
        this.needsData = needsData;
    }

    public AssistanceData getAssistanceData() {
        return assistanceData;
    }

    public void setAssistanceData(AssistanceData assistanceData) {
        this.assistanceData = assistanceData;
    }

    public ShelterGapsData getGapsData() {
        return gapsData;
    }

    public void setGapsData(ShelterGapsData gapsData) {
        this.gapsData = gapsData;
    }
}
