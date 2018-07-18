package com.cpu.quikdata.ModelsV2.Form.GeneralInformation;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class VulnerableDataRow extends RealmObject implements IEnumDataRow<GenericEnumDataRow.AgeGroup> {

    @Required
    @PrimaryKey
    private String id;

    private String ageGroup;

    private int pregnant;
    private int lactating;
    private int lgbt;
    private int femaleHeadedHouseholds;
    private int childHeadedHouseholdsMale;
    private int childHeadedHouseholdsFemale;
    private int indigenousMale;
    private int indigenousFemale;
    private int disabledMale;
    private int disabledFemale;
    private String remarks;

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

    @Override
    public GenericEnumDataRow.AgeGroup getActualType() {
        return GenericEnumDataRow.AgeGroup.valueOf(ageGroup);
    }

    public int getPregnant() {
        return pregnant;
    }

    public void setPregnant(int pregnant) {
        this.pregnant = pregnant;
    }

    public int getLactating() {
        return lactating;
    }

    public void setLactating(int lactating) {
        this.lactating = lactating;
    }

    public int getLgbt() {
        return lgbt;
    }

    public void setLgbt(int lgbt) {
        this.lgbt = lgbt;
    }

    public int getFemaleHeadedHouseholds() {
        return femaleHeadedHouseholds;
    }

    public void setFemaleHeadedHouseholds(int femaleHeadedHouseholds) {
        this.femaleHeadedHouseholds = femaleHeadedHouseholds;
    }

    public int getChildHeadedHouseholdsMale() {
        return childHeadedHouseholdsMale;
    }

    public void setChildHeadedHouseholdsMale(int childHeadedHouseholdsMale) {
        this.childHeadedHouseholdsMale = childHeadedHouseholdsMale;
    }

    public int getChildHeadedHouseholdsFemale() {
        return childHeadedHouseholdsFemale;
    }

    public void setChildHeadedHouseholdsFemale(int childHeadedHouseholdsFemale) {
        this.childHeadedHouseholdsFemale = childHeadedHouseholdsFemale;
    }

    public int getIndigenousMale() {
        return indigenousMale;
    }

    public void setIndigenousMale(int indigenousMale) {
        this.indigenousMale = indigenousMale;
    }

    public int getIndigenousFemale() {
        return indigenousFemale;
    }

    public void setIndigenousFemale(int indigenousFemale) {
        this.indigenousFemale = indigenousFemale;
    }

    public int getDisabledMale() {
        return disabledMale;
    }

    public void setDisabledMale(int disabledMale) {
        this.disabledMale = disabledMale;
    }

    public int getDisabledFemale() {
        return disabledFemale;
    }

    public void setDisabledFemale(int disabledFemale) {
        this.disabledFemale = disabledFemale;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
