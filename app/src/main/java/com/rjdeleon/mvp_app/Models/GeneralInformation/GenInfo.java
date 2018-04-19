package com.rjdeleon.mvp_app.Models.GeneralInformation;

public class GenInfo {
    private CalamityDesc calamityDesc;
    private String affectedAreaDesc;
    private PopulationData populationData;

    public GenInfo(CalamityDesc calamityDesc, String affectedAreaDesc, PopulationData populationData) {
        this.calamityDesc = calamityDesc;
        this.affectedAreaDesc = affectedAreaDesc;
        this.populationData = populationData;
    }

    public CalamityDesc getCalamityDesc() {
        return calamityDesc;
    }

    public String getAffectedAreaDesc() {
        return affectedAreaDesc;
    }

    public PopulationData getPopulationData() {
        return populationData;
    }
}
