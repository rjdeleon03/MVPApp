package com.cpu.quikdata.ModelsV2.PrefilledData;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;

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
