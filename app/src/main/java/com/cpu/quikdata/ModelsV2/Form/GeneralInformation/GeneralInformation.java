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
}
