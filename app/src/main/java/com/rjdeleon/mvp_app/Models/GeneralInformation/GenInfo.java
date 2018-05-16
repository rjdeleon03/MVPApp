package com.rjdeleon.mvp_app.Models.GeneralInformation;

public class GenInfo {
    private CalamityDesc calamityDesc;
    private PopulationData populationData;
    private FamilyData familyData;
    private VulnerablePopulationData vulnerablePopulationData;
    private CasualtiesData casualtiesData;
    private DeathCauseData deathCauseData;
    private InfrastructureDamageData infrastructureDamageData;

    public GenInfo(CalamityDesc calamityDesc, PopulationData populationData, FamilyData familyData, VulnerablePopulationData vulnerablePopulationData, CasualtiesData casualtiesData, DeathCauseData deathCauseData, InfrastructureDamageData infrastructureDamageData) {
        this.calamityDesc = calamityDesc;
        this.populationData = populationData;
        this.familyData = familyData;
        this.vulnerablePopulationData = vulnerablePopulationData;
        this.casualtiesData = casualtiesData;
        this.deathCauseData = deathCauseData;
        this.infrastructureDamageData = infrastructureDamageData;
    }

    public GenInfo() {
        this.calamityDesc = new CalamityDesc();
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

    public void setCalamityDesc(CalamityDesc calamityDesc) {
        this.calamityDesc = calamityDesc;
    }

    public PopulationData getPopulationData() {
        return populationData;
    }

    public void setPopulationData(PopulationData populationData) {
        this.populationData = populationData;
    }

    public FamilyData getFamilyData() {
        return familyData;
    }

    public void setFamilyData(FamilyData familyData) {
        this.familyData = familyData;
    }

    public VulnerablePopulationData getVulnerablePopulationData() {
        return vulnerablePopulationData;
    }

    public void setVulnerablePopulationData(VulnerablePopulationData vulnerablePopulationData) {
        this.vulnerablePopulationData = vulnerablePopulationData;
    }

    public CasualtiesData getCasualtiesData() {
        return casualtiesData;
    }

    public void setCasualtiesData(CasualtiesData casualtiesData) {
        this.casualtiesData = casualtiesData;
    }

    public DeathCauseData getDeathCauseData() {
        return deathCauseData;
    }

    public void setDeathCauseData(DeathCauseData deathCauseData) {
        this.deathCauseData = deathCauseData;
    }

    public InfrastructureDamageData getInfrastructureDamageData() {
        return infrastructureDamageData;
    }

    public void setInfrastructureDamageData(InfrastructureDamageData infrastructureDamageData) {
        this.infrastructureDamageData = infrastructureDamageData;
    }

    public void normalize() {

    }
}
