package com.cpu.quikdata.ModelsV2.Form.WashInformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class WashInformation extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private WashConditionsDetails washConditionsDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WashConditionsDetails getWashConditionsDetails() {
        return washConditionsDetails;
    }

    public void setWashConditionsDetails(WashConditionsDetails washConditionsDetails) {
        this.washConditionsDetails = washConditionsDetails;
    }
}
