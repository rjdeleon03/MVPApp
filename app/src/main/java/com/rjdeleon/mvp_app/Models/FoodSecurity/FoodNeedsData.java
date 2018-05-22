package com.rjdeleon.mvp_app.Models.FoodSecurity;

public class FoodNeedsData {

    private String assistanceNeeded;
    private int numberOfFamilies;

    public FoodNeedsData(String assistanceNeeded, int numberOfFamilies) {
        this.assistanceNeeded = assistanceNeeded;
        this.numberOfFamilies = numberOfFamilies;
    }

    public FoodNeedsData() {
        this("", 0);
    }

    public String getAssistanceNeeded() {
        return assistanceNeeded;
    }

    public void setAssistanceNeeded(String assistanceNeeded) {
        this.assistanceNeeded = assistanceNeeded;
    }

    public int getNumberOfFamilies() {
        return numberOfFamilies;
    }

    public void setNumberOfFamilies(int numberOfFamilies) {
        this.numberOfFamilies = numberOfFamilies;
    }
}
