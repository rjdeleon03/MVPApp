package com.cpu.quikdata.ModelsV2.PrefilledData;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class BaselinePopulationRow extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private String ageGroup;

    private int male = 0;

    private int female = 0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getFemale() {
        return female;
    }

    public void setFemale(int female) {
        this.female = female;
    }
}
