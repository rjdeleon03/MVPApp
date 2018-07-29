package com.cpu.quikdata.ModelsV2.Form.EvacuationInformation;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class EvacuationInformation extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<EvacuationItem> itemsList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RealmList<EvacuationItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(RealmList<EvacuationItem> itemsList) {
        this.itemsList = itemsList;
    }
}
