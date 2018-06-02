package com.rjdeleon.mvp_app.Models.Wash;

import com.rjdeleon.mvp_app.Models.Generics.AssistanceData;
import com.rjdeleon.mvp_app.Models.Generics.GenericCopingData;

public class WashInfo {

    private WashConditionsData conditionsData;
    private GenericCopingData copingData;
    private AssistanceData assistanceData;
    private WashGapsData gapsData;

    public WashInfo(WashConditionsData conditionsData, GenericCopingData copingData, AssistanceData assistanceData, WashGapsData gapsData) {
        this.conditionsData = conditionsData;
        this.copingData = copingData;
        this.assistanceData = assistanceData;
        this.gapsData = gapsData;
    }

    public WashInfo() {
        this(new WashConditionsData(), new GenericCopingData(), new AssistanceData(), new WashGapsData());
    }

    public WashConditionsData getConditionsData() {
        return conditionsData;
    }

    public void setConditionsData(WashConditionsData conditionsData) {
        this.conditionsData = conditionsData;
    }

    public GenericCopingData getCopingData() {
        return copingData;
    }

    public void setCopingData(GenericCopingData copingData) {
        this.copingData = copingData;
    }

    public AssistanceData getAssistanceData() {
        return assistanceData;
    }

    public void setAssistanceData(AssistanceData assistanceData) {
        this.assistanceData = assistanceData;
    }

    public WashGapsData getGapsData() {
        return gapsData;
    }

    public void setGapsData(WashGapsData gapsData) {
        this.gapsData = gapsData;
    }
}
