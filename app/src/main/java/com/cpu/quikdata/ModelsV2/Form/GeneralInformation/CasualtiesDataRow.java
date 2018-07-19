package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class CasualtiesDataRow extends RealmObject implements IEnumDataRow<GenericEnumDataRow.AgeGroup, CasualtiesDataRow> {

    @Required
    @PrimaryKey
    private String id;

    private String ageGroup;
    private int deadMale;
    private int deadFemale;
    private int missingMale;
    private int missingFemale;
    private int injuredMale;
    private int injuredFemale;

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

    public int getDeadMale() {
        return deadMale;
    }

    public void setDeadMale(int deadMale) {
        this.deadMale = deadMale;
    }

    public int getDeadFemale() {
        return deadFemale;
    }

    public void setDeadFemale(int deadFemale) {
        this.deadFemale = deadFemale;
    }

    public int getMissingMale() {
        return missingMale;
    }

    public void setMissingMale(int missingMale) {
        this.missingMale = missingMale;
    }

    public int getMissingFemale() {
        return missingFemale;
    }

    public void setMissingFemale(int missingFemale) {
        this.missingFemale = missingFemale;
    }

    public int getInjuredMale() {
        return injuredMale;
    }

    public void setInjuredMale(int injuredMale) {
        this.injuredMale = injuredMale;
    }

    public int getInjuredFemale() {
        return injuredFemale;
    }

    public void setInjuredFemale(int injuredFemale) {
        this.injuredFemale = injuredFemale;
    }

    @Override
    public GenericEnumDataRow.AgeGroup getActualType() {
        return GenericEnumDataRow.AgeGroup.valueOf(ageGroup);
    }

    @Override
    public void update(CasualtiesDataRow newRow) {
        deadMale = newRow.getDeadMale();
        deadFemale = newRow.getDeadFemale();
        missingMale = newRow.getMissingMale();
        missingFemale = newRow.getMissingFemale();
        injuredMale = newRow.getInjuredMale();
        injuredFemale = newRow.getInjuredFemale();
    }
}
