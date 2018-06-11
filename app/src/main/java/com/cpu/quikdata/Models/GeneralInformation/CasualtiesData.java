package com.cpu.quikdata.Models.GeneralInformation;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Generics.GenderTuple;
import com.cpu.quikdata.Models.Generics.GenericEnumDataTotalizable;
import com.cpu.quikdata.Models.Generics.NormalizableData;
import com.cpu.quikdata.Models.Generics.TotalizableData;
import com.cpu.quikdata.Utils.GenericEnumUtils;

import java.util.ArrayList;
import java.util.List;

public class CasualtiesData extends GenericEnumDataTotalizable {

    private List<CasualtiesDataRow> casualtiesDataRows;

    public CasualtiesData(List<CasualtiesDataRow> casualtiesDataRows) {
        super(new CasualtiesDataRow(GenericEnumDataRow.AgeGroup.ALL));
        this.casualtiesDataRows = casualtiesDataRows;
        addTotalRow();
    }

    public CasualtiesData() {
        this(new ArrayList<CasualtiesDataRow>());
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

        CasualtiesDataRow row = (CasualtiesDataRow) totalRow;
        row.setDead(dead);
        row.setMissing(missing);
        row.setInjured(injured);
    }
}
