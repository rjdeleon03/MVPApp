package com.cpu.quikdata.Models.GeneralInformation;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Generics.GenderTuple;

public class VulnerablePopulationDataRow extends GenericEnumDataRow {
    private int pregnant;
    private int lactating;
    private int lgbt;
    private int femaleHeadedHouseholds;
    private GenderTuple childHeadedHouseholds;
    private GenderTuple indigenous;
    private GenderTuple disabled;
    private String remarks;

    public VulnerablePopulationDataRow(AgeGroup ageGroup, int pregnant, int lactating, int lgbt, int femaleHeadedHouseholds, GenderTuple childHeadedHouseholds, GenderTuple indigenous, GenderTuple disabled, String remarks) {
        super(ageGroup);
        this.pregnant = pregnant;
        this.lactating = lactating;
        this.lgbt = lgbt;
        this.femaleHeadedHouseholds = femaleHeadedHouseholds;
        this.childHeadedHouseholds = childHeadedHouseholds;
        this.indigenous = indigenous;
        this.disabled = disabled;
        this.remarks = remarks;
    }

    public VulnerablePopulationDataRow(AgeGroup ageGroup) {
        super(ageGroup);
        this.pregnant = 0;
        this.lactating = 0;
        this.lgbt = 0;
        this.femaleHeadedHouseholds = 0;
        this.childHeadedHouseholds = new GenderTuple();
        this.indigenous = new GenderTuple();
        this.disabled = new GenderTuple();
        this.remarks = "";
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

    public GenderTuple getChildHeadedHouseholds() {
        return childHeadedHouseholds;
    }

    public void setChildHeadedHouseholds(GenderTuple childHeadedHouseholds) {
        this.childHeadedHouseholds = childHeadedHouseholds;
    }

    public GenderTuple getIndigenous() {
        return indigenous;
    }

    public void setIndigenous(GenderTuple indigenous) {
        this.indigenous = indigenous;
    }

    public GenderTuple getDisabled() {
        return disabled;
    }

    public void setDisabled(GenderTuple disabled) {
        this.disabled = disabled;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
