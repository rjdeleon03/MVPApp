package com.rjdeleon.mvp_app.Models;

public class PopulationDataRow {
    private int totalMale;
    private int totalFemale;
    private int affectedMale;
    private int affectedFemale;
    private int displacedMale;
    private int displacedFemale;

    public PopulationDataRow(int totalMale, int totalFemale, int affectedMale, int affectedFemale, int displacedMale, int displacedFemale) {
        this.totalMale = totalMale;
        this.totalFemale = totalFemale;
        this.affectedMale = affectedMale;
        this.affectedFemale = affectedFemale;
        this.displacedMale = displacedMale;
        this.displacedFemale = displacedFemale;
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
