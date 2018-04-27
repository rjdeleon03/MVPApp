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

    public int getTotalFamilies() {
        return totalFamilies;
    }

    public int getAffectedFamilies() {
        return affectedFamilies;
    }

    public int getDisplacedFamilies() {
        return displacedFamilies;
    }

    public int getTotalHouseholds() {
        return totalHouseholds;
    }

    public int getAffectedHouseholds() {
        return affectedHouseholds;
    }

    public int getDisplacedHouseholds() {
        return displacedHouseholds;
    }
}
