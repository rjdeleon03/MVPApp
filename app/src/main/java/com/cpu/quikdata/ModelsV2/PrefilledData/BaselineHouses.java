package com.cpu.quikdata.ModelsV2.PrefilledData;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class BaselineHouses extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<BaselineHousesRow> houses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RealmList<BaselineHousesRow> getHouses() {
        return houses;
    }

    public void setRows(RealmList<BaselineHousesRow> houses) {
        this.houses = houses;
    }
}
