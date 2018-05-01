package com.rjdeleon.mvp_app.Models.GeneralInformation;

import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;

public class PopulationDataRow {
    private PopulationData.AgeGroup ageGroup;
    private GenderTuple total;
    private GenderTuple affected;
    private GenderTuple displaced;

    public PopulationDataRow(PopulationData.AgeGroup ageGroup, GenderTuple total, GenderTuple affected, GenderTuple displaced) {
        this.ageGroup = ageGroup;
        this.total = total;
        this.affected = affected;
        this.displaced = displaced;
    }

    public PopulationDataRow() {
        this.ageGroup = PopulationData.AgeGroup.AGE_0_5;
        this.total = new GenderTuple();
        this.affected = new GenderTuple();
        this.displaced = new GenderTuple();
    }

    public PopulationData.AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public GenderTuple getTotal() {
        return total;
    }

    public GenderTuple getAffected() {
        return affected;
    }

    public GenderTuple getDisplaced() {
        return displaced;
    }
}
