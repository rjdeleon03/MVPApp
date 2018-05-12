package com.rjdeleon.mvp_app.Models.GeneralInformation;

public class FamilyData {
    private int totalFamilies;
    private int affectedFamilies;
    private int displacedFamilies;
    private int totalHouseholds;
    private int affectedHouseholds;
    private int displacedHouseholds;

    public FamilyData(int totalFamilies, int affectedFamilies, int displacedFamilies, int totalHouseholds, int affectedHouseholds, int displacedHouseholds) {
        this.totalFamilies = totalFamilies;
        this.affectedFamilies = affectedFamilies;
        this.displacedFamilies = displacedFamilies;
        this.totalHouseholds = totalHouseholds;
        this.affectedHouseholds = affectedHouseholds;
        this.displacedHouseholds = displacedHouseholds;
    }

    public FamilyData() {
        this.totalFamilies = 0;
        this.affectedFamilies = 0;
        this.displacedFamilies = 0;
        this.totalHouseholds = 0;
        this.affectedHouseholds = 0;
        this.displacedHouseholds = 0;
    }

    public int getTotalFamilies() {
        return totalFamilies;
    }

    public void setTotalFamilies(int totalFamilies) {
        this.totalFamilies = totalFamilies;
    }

    public int getAffectedFamilies() {
        return affectedFamilies;
    }

    public void setAffectedFamilies(int affectedFamilies) {
        this.affectedFamilies = affectedFamilies;
    }

    public int getDisplacedFamilies() {
        return displacedFamilies;
    }

    public void setDisplacedFamilies(int displacedFamilies) {
        this.displacedFamilies = displacedFamilies;
    }

    public int getTotalHouseholds() {
        return totalHouseholds;
    }

    public void setTotalHouseholds(int totalHouseholds) {
        this.totalHouseholds = totalHouseholds;
    }

    public int getAffectedHouseholds() {
        return affectedHouseholds;
    }

    public void setAffectedHouseholds(int affectedHouseholds) {
        this.affectedHouseholds = affectedHouseholds;
    }

    public int getDisplacedHouseholds() {
        return displacedHouseholds;
    }

    public void setDisplacedHouseholds(int displacedHouseholds) {
        this.displacedHouseholds = displacedHouseholds;
    }
}
