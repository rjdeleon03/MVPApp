package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class GeneralInformation extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private CalamityDetails calamityDetails;
    private PopulationData populationData;
    private FamilyDetails familyDetails;
    private VulnerableData vulnerableData;
    private CasualtiesData casualtiesData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CalamityDetails getCalamityDetails() {
        return calamityDetails;
    }

    public void setCalamityDetails(CalamityDetails calamityDetails) {
        this.calamityDetails = calamityDetails;
    }

    public PopulationData getPopulationData() {
        return populationData;
    }

    public void setPopulationData(PopulationData populationData) {
        this.populationData = populationData;
    }

    public FamilyDetails getFamilyDetails() {
        return familyDetails;
    }

    public void setFamilyDetails(FamilyDetails familyDetails) {
        this.familyDetails = familyDetails;
    }

    public VulnerableData getVulnerableData() {
        return vulnerableData;
    }

    public void setVulnerableData(VulnerableData vulnerableData) {
        this.vulnerableData = vulnerableData;
    }

    public CasualtiesData getCasualtiesData() {
        return casualtiesData;
    }

    public void setCasualtiesData(CasualtiesData casualtiesData) {
        this.casualtiesData = casualtiesData;
    }
}
