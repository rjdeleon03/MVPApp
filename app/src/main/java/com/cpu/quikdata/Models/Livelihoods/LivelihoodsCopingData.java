package com.cpu.quikdata.Models.Livelihoods;

public class LivelihoodsCopingData {

    private String copingStrategies;
    private String incomeOpportunities;
    private String livelihoodSkills;

    public LivelihoodsCopingData(String copingStrategies, String incomeOpportunities, String livelihoodSkills) {
        this.copingStrategies = copingStrategies;
        this.incomeOpportunities = incomeOpportunities;
        this.livelihoodSkills = livelihoodSkills;
    }

    public LivelihoodsCopingData() {
        this("", "", "");
    }

    public String getCopingStrategies() {
        return copingStrategies;
    }

    public void setCopingStrategies(String copingStrategies) {
        this.copingStrategies = copingStrategies;
    }

    public String getIncomeOpportunities() {
        return incomeOpportunities;
    }

    public void setIncomeOpportunities(String incomeOpportunities) {
        this.incomeOpportunities = incomeOpportunities;
    }

    public String getLivelihoodSkills() {
        return livelihoodSkills;
    }

    public void setLivelihoodSkills(String livelihoodSkills) {
        this.livelihoodSkills = livelihoodSkills;
    }
}
