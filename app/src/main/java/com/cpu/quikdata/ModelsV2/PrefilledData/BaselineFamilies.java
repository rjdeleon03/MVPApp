package com.cpu.quikdata.ModelsV2.PrefilledData;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class BaselineFamilies extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private int families;

    private int households;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFamilies() {
        return families;
    }

    public void setFamilies(int families) {
        this.families = families;
    }

    public int getHouseholds() {
        return households;
    }

    public void setHouseholds(int households) {
        this.households = households;
    }
}
