package com.rjdeleon.mvp_app.Models.GeneralInformation;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;
import com.rjdeleon.mvp_app.Models.Generics.NormalizableData;
import com.rjdeleon.mvp_app.Models.Generics.TotalizableData;
import com.rjdeleon.mvp_app.Utils.GenericEnumUtils;

import java.util.ArrayList;
import java.util.List;

public class CasualtiesData implements NormalizableData, TotalizableData {

    private List<CasualtiesDataRow> casualtiesDataRows;

    public CasualtiesData(List<CasualtiesDataRow> casualtiesDataRows) {
        this.casualtiesDataRows = casualtiesDataRows;
        addTotalRow();
    }

    public CasualtiesData() {
        casualtiesDataRows = new ArrayList<>();
    }

    public List<CasualtiesDataRow> getCasualtiesDataRows() {
        return casualtiesDataRows;
    }

    public void setCasualtiesDataRows(List<CasualtiesDataRow> casualtiesDataRows) {
        this.casualtiesDataRows = casualtiesDataRows;
    }

    @Override
    public void normalize() {
        GenericEnumUtils.normalizeGenericEnumData(
                GenericEnumDataRow.AgeGroup.class,
                this.getClass(),
                (List<GenericEnumDataRow>)(Object) casualtiesDataRows);

        addTotalRow();
    }

    @Override
    public void addTotalRow() {

        GenderTuple dead = new GenderTuple();
        GenderTuple missing = new GenderTuple();
        GenderTuple injured = new GenderTuple();

        for(CasualtiesDataRow row : casualtiesDataRows) {
            dead.male += row.getDead().male;
            dead.female += row.getDead().female;
            missing.male += row.getMissing().male;
            missing.female += row.getMissing().female;
            injured.male += row.getInjured().male;
            injured.female += row.getInjured().female;
        }
        this.casualtiesDataRows.add(new CasualtiesDataRow(GenericEnumDataRow.AgeGroup.ALL, dead, missing, injured));
    }
}
