package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class PopulationDataRow extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

    private String ageGroup;
    private int affectedMale;
    private int affectedFemale;
    private int displacedMale;
    private int displacedFemale;

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAffectedMale() {
        return affectedMale;
    }

    public void setAffectedMale(int affectedMale) {
        this.affectedMale = affectedMale;
    }

    public int getAffectedFemale() {
        return affectedFemale;
    }

    public void setAffectedFemale(int affectedFemale) {
        this.affectedFemale = affectedFemale;
    }

    public int getDisplacedMale() {
        return displacedMale;
    }

    public void setDisplacedMale(int displacedMale) {
        this.displacedMale = displacedMale;
    }

    public int getDisplacedFemale() {
        return displacedFemale;
    }

    public void setDisplacedFemale(int displacedFemale) {
        this.displacedFemale = displacedFemale;
    }
}
