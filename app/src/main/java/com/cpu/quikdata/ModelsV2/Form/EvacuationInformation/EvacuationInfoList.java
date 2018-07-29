package com.cpu.quikdata.ModelsV2.Form.EvacuationInformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class EvacuationInfoList extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
