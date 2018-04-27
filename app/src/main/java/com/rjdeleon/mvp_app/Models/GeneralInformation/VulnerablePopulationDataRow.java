package com.rjdeleon.mvp_app.Models.GeneralInformation;

import com.rjdeleon.mvp_app.Models.GenderTuple;

public class VulnerablePopulationDataRow {
    private PopulationData.AgeGroup ageGroup;
    private int pregnant;
    private int lactating;
    private int lgbt;
    private int femaleHeadedHouseholds;
    private GenderTuple childHeadedHouseholds;
    private GenderTuple indigenous;
    private GenderTuple disabled;
    private String remarks;

    public VulnerablePopulationDataRow(PopulationData.AgeGroup ageGroup, int pregnant, int lactating, int lgbt, int femaleHeadedHouseholds, GenderTuple childHeadedHouseholds, GenderTuple indigenous, GenderTuple disabled, String remarks) {
        this.ageGroup = ageGroup;
        this.pregnant = pregnant;
        this.lactating = lactating;
        this.lgbt = lgbt;
        this.femaleHeadedHouseholds = femaleHeadedHouseholds;
        this.childHeadedHouseholds = childHeadedHouseholds;
        this.indigenous = indigenous;
        this.disabled = disabled;
        this.remarks = remarks;
    }

    public PopulationData.AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public int getPregnant() {
        return pregnant;
    }

    public int getLactating() {
        return lactating;
    }

    public int getLgbt() {
        return lgbt;
    }

    public int getFemaleHeadedHouseholds() {
        return femaleHeadedHouseholds;
    }

    public GenderTuple getChildHeadedHouseholds() {
        return childHeadedHouseholds;
    }

    public GenderTuple getIndigenous() {
        return indigenous;
    }

    public GenderTuple getDisabled() {
        return disabled;
    }

    public String getRemarks() {
        return remarks;
    }
}
