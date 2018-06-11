package com.cpu.quikdata.Models.Livelihoods;

import com.cpu.quikdata.Models.Generics.AssistanceData;

public class Livelihoods {

    private LivelihoodsIncomeData incomeBeforeEmergency;
    private LivelihoodsIncomeData incomeAfterEmergency;
    private LivelihoodsDamageData estimatedDamage;
    private LivelihoodsCopingData copingData;
    private LivelihoodsNeedsData needsData;
    private AssistanceData assistanceData;
    private LivelihoodsGapsData gapsData;

    public Livelihoods(LivelihoodsIncomeData incomeBeforeEmergency,
                       LivelihoodsIncomeData incomeAfterEmergency,
                       LivelihoodsDamageData estimatedDamage,
                       LivelihoodsCopingData copingData,
                       LivelihoodsNeedsData needsData,
                       AssistanceData assistanceData,
                       LivelihoodsGapsData gapsData) {

        this.incomeBeforeEmergency = incomeBeforeEmergency;
        this.incomeAfterEmergency = incomeAfterEmergency;
        this.estimatedDamage = estimatedDamage;
        this.copingData = copingData;
        this.needsData = needsData;
        this.assistanceData = assistanceData;
        this.gapsData = gapsData;
    }

    public Livelihoods() {
        this(new LivelihoodsIncomeData(),
                new LivelihoodsIncomeData(),
                new LivelihoodsDamageData(),
                new LivelihoodsCopingData(),
                new LivelihoodsNeedsData(),
                new AssistanceData(),
                new LivelihoodsGapsData());
    }

    public LivelihoodsIncomeData getIncomeBeforeEmergency() {
        return incomeBeforeEmergency;
    }

    public void setIncomeBeforeEmergency(LivelihoodsIncomeData incomeBeforeEmergency) {
        this.incomeBeforeEmergency = incomeBeforeEmergency;
    }

    public LivelihoodsIncomeData getIncomeAfterEmergency() {
        return incomeAfterEmergency;
    }

    public void setIncomeAfterEmergency(LivelihoodsIncomeData incomeAfterEmergency) {
        this.incomeAfterEmergency = incomeAfterEmergency;
    }

    public LivelihoodsDamageData getEstimatedDamage() {
        return estimatedDamage;
    }

    public void setEstimatedDamage(LivelihoodsDamageData estimatedDamage) {
        this.estimatedDamage = estimatedDamage;
    }

    public LivelihoodsCopingData getCopingData() {
        return copingData;
    }

    public void setCopingData(LivelihoodsCopingData copingData) {
        this.copingData = copingData;
    }

    public LivelihoodsNeedsData getNeedsData() {
        return needsData;
    }

    public void setNeedsData(LivelihoodsNeedsData needsData) {
        this.needsData = needsData;
    }

    public AssistanceData getAssistanceData() {
        return assistanceData;
    }

    public void setAssistanceData(AssistanceData assistanceData) {
        this.assistanceData = assistanceData;
    }

    public LivelihoodsGapsData getGapsData() {
        return gapsData;
    }

    public void setGapsData(LivelihoodsGapsData gapsData) {
        this.gapsData = gapsData;
    }
}
