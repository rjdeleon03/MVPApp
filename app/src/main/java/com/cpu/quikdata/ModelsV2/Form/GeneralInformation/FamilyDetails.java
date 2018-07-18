package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class FamilyDetails extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private int affectedFamilies;
    private int affectedHouseholds;
    private int displacedFamilies;
    private int displacedHouseholds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAffectedFamilies() {
        return affectedFamilies;
    }

    public void setAffectedFamilies(int affectedFamilies) {
        this.affectedFamilies = affectedFamilies;
    }

    public int getAffectedHouseholds() {
        return affectedHouseholds;
    }

    public void setAffectedHouseholds(int affectedHouseholds) {
        this.affectedHouseholds = affectedHouseholds;
    }

    public int getDisplacedFamilies() {
        return displacedFamilies;
    }

    public void setDisplacedFamilies(int displacedFamilies) {
        this.displacedFamilies = displacedFamilies;
    }

    public int getDisplacedHouseholds() {
        return displacedHouseholds;
    }

    public void setDisplacedHouseholds(int displacedHouseholds) {
        this.displacedHouseholds = displacedHouseholds;
    }
}
