package com.rjdeleon.mvp_app.Models.Health;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Generics.NormalizableData;
import com.rjdeleon.mvp_app.Utils.GenericEnumUtils;

import java.util.ArrayList;
import java.util.List;

public class SpecialNeedsData implements NormalizableData {

    private List<SpecialNeedsDataRow> specialNeedsDataRows;

    public SpecialNeedsData(List<SpecialNeedsDataRow> specialNeedsDataRows) {
        this.specialNeedsDataRows = specialNeedsDataRows;
    }

    public SpecialNeedsData() {
        this(new ArrayList<SpecialNeedsDataRow>());
    }

    public List<SpecialNeedsDataRow> getSpecialNeedsDataRows() {
        return specialNeedsDataRows;
    }

    public void setSpecialNeedsDataRows(List<SpecialNeedsDataRow> specialNeedsDataRows) {
        this.specialNeedsDataRows = specialNeedsDataRows;
    }

    @Override
    public void normalize() {
        GenericEnumUtils.normalizeGenericEnumData(
                GenericEnumDataRow.SpecialNeedsType.class,
                this.getClass(),
                (List<GenericEnumDataRow>)(Object) specialNeedsDataRows);
    }
}
