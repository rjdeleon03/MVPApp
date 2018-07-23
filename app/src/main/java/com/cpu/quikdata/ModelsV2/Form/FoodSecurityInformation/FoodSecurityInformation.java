package com.cpu.quikdata.ModelsV2.Form.FoodSecurityInformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class FoodSecurityInformation extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private ImpactDetails impactDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImpactDetails getImpactDetails() {
        return impactDetails;
    }

    public void setImpactDetails(ImpactDetails impactDetails) {
        this.impactDetails = impactDetails;
    }
}
