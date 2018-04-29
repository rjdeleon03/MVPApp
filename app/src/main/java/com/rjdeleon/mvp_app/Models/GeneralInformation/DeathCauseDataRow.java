package com.rjdeleon.mvp_app.Models.GeneralInformation;

import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;

public class DeathCauseDataRow {
    private PopulationData.AgeGroup ageGroup;
    private GenderTuple measles;
    private GenderTuple diarrhea;
    private GenderTuple pneumonia;
    private GenderTuple dengue;
    private GenderTuple drowning;
    private GenderTuple heartAttack;
    private GenderTuple electrocution;
    private GenderTuple collapsedBuilding;
    private GenderTuple others;

    public DeathCauseDataRow(PopulationData.AgeGroup ageGroup, GenderTuple measles, GenderTuple diarrhea, GenderTuple pneumonia, GenderTuple dengue, GenderTuple drowning, GenderTuple heartAttack, GenderTuple electrocution, GenderTuple collapsedBuilding, GenderTuple others) {
        this.ageGroup = ageGroup;
        this.measles = measles;
        this.diarrhea = diarrhea;
        this.pneumonia = pneumonia;
        this.dengue = dengue;
        this.drowning = drowning;
        this.heartAttack = heartAttack;
        this.electrocution = electrocution;
        this.collapsedBuilding = collapsedBuilding;
        this.others = others;
    }

    public PopulationData.AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public GenderTuple getMeasles() {
        return measles;
    }

    public GenderTuple getDiarrhea() {
        return diarrhea;
    }

    public GenderTuple getPneumonia() {
        return pneumonia;
    }

    public GenderTuple getDengue() {
        return dengue;
    }

    public GenderTuple getDrowning() {
        return drowning;
    }

    public GenderTuple getHeartAttack() {
        return heartAttack;
    }

    public GenderTuple getElectrocution() {
        return electrocution;
    }

    public GenderTuple getCollapsedBuilding() {
        return collapsedBuilding;
    }

    public GenderTuple getOthers() {
        return others;
    }
}
