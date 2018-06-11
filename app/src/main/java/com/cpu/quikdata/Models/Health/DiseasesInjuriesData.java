package com.cpu.quikdata.Models.Health;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Generics.NormalizableData;
import com.cpu.quikdata.Utils.GenericEnumUtils;

import java.util.ArrayList;
import java.util.List;

public class DiseasesInjuriesData implements NormalizableData {

    private List<DiseasesInjuriesDataRow> diseasesInjuriesDataRows;

    public DiseasesInjuriesData(List<DiseasesInjuriesDataRow> diseasesInjuriesDataRows) {
        this.diseasesInjuriesDataRows = diseasesInjuriesDataRows;
    }

    public DiseasesInjuriesData() {
        this(new ArrayList<DiseasesInjuriesDataRow>());
    }

    public List<DiseasesInjuriesDataRow> getDiseasesInjuriesDataRows() {
        return diseasesInjuriesDataRows;
    }

    public void setDiseasesInjuriesDataRows(List<DiseasesInjuriesDataRow> diseasesInjuriesDataRows) {
        this.diseasesInjuriesDataRows = diseasesInjuriesDataRows;
    }

    @Override
    public void normalize() {
        GenericEnumUtils.normalizeGenericEnumData(
                GenericEnumDataRow.AgeGroup.class,
                this.getClass(),
                (List<GenericEnumDataRow>)(Object) diseasesInjuriesDataRows);
    }
}
