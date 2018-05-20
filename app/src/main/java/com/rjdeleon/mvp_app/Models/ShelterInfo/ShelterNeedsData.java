package com.rjdeleon.mvp_app.Models.ShelterInfo;

import java.util.ArrayList;
import java.util.List;

public class ShelterNeedsData {

    private List<ShelterNeedsDataRow> shelterNeedsDataRows;

    public ShelterNeedsData(List<ShelterNeedsDataRow> shelterNeedsDataRows) {
        this.shelterNeedsDataRows = shelterNeedsDataRows;
    }

    public ShelterNeedsData() {
        this.shelterNeedsDataRows = new ArrayList<>();
    }

    public List<ShelterNeedsDataRow> getShelterNeedsDataRows() {
        return shelterNeedsDataRows;
    }

    public void setShelterNeedsDataRows(List<ShelterNeedsDataRow> shelterNeedsDataRows) {
        this.shelterNeedsDataRows = shelterNeedsDataRows;
    }
}
