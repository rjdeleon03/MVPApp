package com.rjdeleon.mvp_app.Models.GeneralInformation;

public class PopulationDataRow {
    private PopulationData.AgeGroup ageGroup;
    private int totalMale;
    private int totalFemale;
    private int affectedMale;
    private int affectedFemale;
    private int displacedMale;
    private int displacedFemale;

    public PopulationDataRow(PopulationData.AgeGroup ageGroup, int totalMale, int totalFemale, int affectedMale, int affectedFemale, int displacedMale, int displacedFemale) {
        this.ageGroup = ageGroup;
        this.totalMale = totalMale;
        this.totalFemale = totalFemale;
        this.affectedMale = affectedMale;
        this.affectedFemale = affectedFemale;
        this.displacedMale = displacedMale;
        this.displacedFemale = displacedFemale;
    }

    public PopulationData.AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public int getTotalMale() {
        return totalMale;
    }

    public int getTotalFemale() {
        return totalFemale;
    }

    public int getAffectedMale() {
        return affectedMale;
    }

    public int getAffectedFemale() {
        return affectedFemale;
    }

    public int getDisplacedMale() {
        return displacedMale;
    }

    public int getDisplacedFemale() {
        return displacedFemale;
    }
}
