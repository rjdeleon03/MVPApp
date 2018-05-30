package com.rjdeleon.mvp_app.Models.Shelter;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;

public class ShelterNeedsDataRow extends GenericEnumDataRow {

    private String items;
    private int familyCount;

    public ShelterNeedsDataRow(NeedsType type, String items, int familyCount) {
        super(type);
        this.items = items;
        this.familyCount = familyCount;
    }

    public ShelterNeedsDataRow(NeedsType type) {
        this(type, "", 0);
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
