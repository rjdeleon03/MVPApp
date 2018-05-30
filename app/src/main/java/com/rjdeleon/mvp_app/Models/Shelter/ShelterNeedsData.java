package com.rjdeleon.mvp_app.Models.Shelter;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Generics.NormalizableData;
import com.rjdeleon.mvp_app.Utils.GenericEnumUtils;

import java.util.ArrayList;
import java.util.List;

public class ShelterNeedsData implements NormalizableData {

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

    @Override
    public void normalize() {
        GenericEnumUtils.normalizeGenericEnumData(
                GenericEnumDataRow.NeedsType.class,
                this.getClass(),
                (List<GenericEnumDataRow>)(Object) shelterNeedsDataRows,
                false);
    }
}
