package com.cpu.quikdata.Models.Health;

import com.cpu.quikdata.Models.Generics.AssistanceData;
import com.cpu.quikdata.Models.Generics.GenericCopingData;
import com.cpu.quikdata.Models.Generics.NormalizableData;

public class HealthInfo implements NormalizableData {

    private DiseasesInjuriesData diseasesInjuriesData;
    private SpecialNeedsData specialNeedsData;
    private PsychosocialData psychosocialData;
    private GenericCopingData copingData;
    private AssistanceData assistanceData;
    private HealthGapsData gapsData;

    public HealthInfo(DiseasesInjuriesData diseasesInjuriesData, SpecialNeedsData specialNeedsData, PsychosocialData psychosocialData, GenericCopingData copingData, AssistanceData assistanceData, HealthGapsData gapsData) {
        this.diseasesInjuriesData = diseasesInjuriesData;
        this.specialNeedsData = specialNeedsData;
        this.psychosocialData = psychosocialData;
        this.copingData = copingData;
        this.assistanceData = assistanceData;
        this.gapsData = gapsData;
    }

    public HealthInfo() {
        this(new DiseasesInjuriesData(),
                new SpecialNeedsData(),
                new PsychosocialData(),
                new GenericCopingData(),
                new AssistanceData(),
                new HealthGapsData());
    }

    public DiseasesInjuriesData getDiseasesInjuriesData() {
        return diseasesInjuriesData;
    }

    public void setDiseasesInjuriesData(DiseasesInjuriesData diseasesInjuriesData) {
        this.diseasesInjuriesData = diseasesInjuriesData;
    }

    public SpecialNeedsData getSpecialNeedsData() {
        return specialNeedsData;
    }

    public void setSpecialNeedsData(SpecialNeedsData specialNeedsData) {
        this.specialNeedsData = specialNeedsData;
    }

    public PsychosocialData getPsychosocialData() {
        return psychosocialData;
    }

    public void setPsychosocialData(PsychosocialData psychosocialData) {
        this.psychosocialData = psychosocialData;
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

    public HealthGapsData getGapsData() {
        return gapsData;
    }

    public void setGapsData(HealthGapsData gapsData) {
        this.gapsData = gapsData;
    }

    @Override
    public void normalize() {
        if (diseasesInjuriesData != null) diseasesInjuriesData.normalize();

        if (specialNeedsData != null) specialNeedsData.normalize();

        if (psychosocialData != null) psychosocialData.normalize();
    }
}
