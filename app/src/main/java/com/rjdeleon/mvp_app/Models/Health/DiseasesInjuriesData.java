package com.rjdeleon.mvp_app.Models.Health;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Generics.NormalizableData;
import com.rjdeleon.mvp_app.Utils.GenericEnumUtils;

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
