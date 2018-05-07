package com.rjdeleon.mvp_app.Models.GeneralInformation;

public class GenInfo {
    private CalamityDesc calamityDesc;
    private String affectedAreaDesc;
    private PopulationData populationData;
    private FamilyData familyData;
    private VulnerablePopulationData vulnerablePopulationData;
    private CasualtiesData casualtiesData;
    private DeathCauseData deathCauseData;
    private InfrastructureDamageData infrastructureDamageData;

    public GenInfo(CalamityDesc calamityDesc, String affectedAreaDesc, PopulationData populationData, FamilyData familyData, VulnerablePopulationData vulnerablePopulationData, CasualtiesData casualtiesData, DeathCauseData deathCauseData, InfrastructureDamageData infrastructureDamageData) {
        this.calamityDesc = calamityDesc;
        this.affectedAreaDesc = affectedAreaDesc;
        this.populationData = populationData;
        this.familyData = familyData;
        this.vulnerablePopulationData = vulnerablePopulationData;
        this.casualtiesData = casualtiesData;
        this.deathCauseData = deathCauseData;
        this.infrastructureDamageData = infrastructureDamageData;
    }

    public GenInfo() {
        this.calamityDesc = new CalamityDesc();
        this.affectedAreaDesc = "";
        this.populationData = new PopulationData();
        this.familyData = new FamilyData();
        this.vulnerablePopulationData = new VulnerablePopulationData();
        this.casualtiesData = new CasualtiesData();
        this.deathCauseData = new DeathCauseData();
        this.infrastructureDamageData = new InfrastructureDamageData();
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

    public FamilyData getFamilyData() {
        return familyData;
    }

    public VulnerablePopulationData getVulnerablePopulationData() {
        return vulnerablePopulationData;
    }

    public CasualtiesData getCasualtiesData() {
        return casualtiesData;
    }

    public DeathCauseData getDeathCauseData() {
        return deathCauseData;
    }

    public InfrastructureDamageData getInfrastructureDamageData() {
        return infrastructureDamageData;
    }
}
