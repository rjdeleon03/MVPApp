package com.rjdeleon.mvp_app.Models.GeneralInformation;

import com.rjdeleon.mvp_app.Models.GenderTuple;

public class CasualtiesDataRow {
    private PopulationData.AgeGroup ageGroup;
    private GenderTuple dead;
    private GenderTuple missing;
    private GenderTuple injured;

    public CasualtiesDataRow(PopulationData.AgeGroup ageGroup, GenderTuple dead, GenderTuple missing, GenderTuple injured) {
        this.ageGroup = ageGroup;
        this.dead = dead;
        this.missing = missing;
        this.injured = injured;
    }

    public PopulationData.AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public GenderTuple getDead() {
        return dead;
    }

    public GenderTuple getMissing() {
        return missing;
    }

    public GenderTuple getInjured() {
        return injured;
    }
}
