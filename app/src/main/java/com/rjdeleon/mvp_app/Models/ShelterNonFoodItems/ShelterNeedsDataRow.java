package com.rjdeleon.mvp_app.Models.ShelterNonFoodItems;

public class ShelterNeedsDataRow {

    private String items;
    private int familyCount;

    public ShelterNeedsDataRow(String items, int familyCount) {
        this.items = items;
        this.familyCount = familyCount;
    }

    public ShelterNeedsDataRow() {
        this.items = "";
        this.familyCount = 0;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public int getFamilyCount() {
        return familyCount;
    }

    public void setFamilyCount(int familyCount) {
        this.familyCount = familyCount;
    }
}
