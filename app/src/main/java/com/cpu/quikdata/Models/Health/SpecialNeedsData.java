package com.cpu.quikdata.Models.Health;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Generics.NormalizableData;
import com.cpu.quikdata.Utils.GenericEnumUtils;

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
