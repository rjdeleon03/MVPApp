package com.cpu.quikdata.Models.GeneralInformation;

import com.cpu.quikdata.Models.Generics.GenericEnumDataTotalizable;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Generics.GenderTuple;
import com.cpu.quikdata.Utils.GenericEnumUtils;

import java.util.ArrayList;
import java.util.List;

public class PopulationData extends GenericEnumDataTotalizable {

    private List<PopulationDataRow> populationDataRows;

    public PopulationData(List<PopulationDataRow> populationDataRows) {
        super(new PopulationDataRow(GenericEnumDataRow.AgeGroup.ALL));
        this.populationDataRows = populationDataRows;
        addTotalRow();
    }

    public PopulationData() {
        this(new ArrayList<PopulationDataRow>());
    }

    public List<PopulationDataRow> getPopulationDataRows() {
        return populationDataRows;
    }

    public void setPopulationDataRows(List<PopulationDataRow> populationDataRows) {
        this.populationDataRows = populationDataRows;
    }

    @Override
    public void normalize() {
        GenericEnumUtils.normalizeGenericEnumData(
                GenericEnumDataRow.AgeGroup.class,
                this.getClass(),
                (List<GenericEnumDataRow>)(Object) populationDataRows);

        addTotalRow();
    }

    @Override
    public void addTotalRow() {

        GenderTuple total = new GenderTuple();
        GenderTuple affected = new GenderTuple();
        GenderTuple displaced = new GenderTuple();
        for(PopulationDataRow row : populationDataRows) {
            total.male += row.getTotal().male;
            total.female += row.getTotal().female;
            affected.male += row.getAffected().male;
            affected.female += row.getAffected().female;
            displaced.male += row.getDisplaced().male;
            displaced.female += row.getDisplaced().female;
        }

        PopulationDataRow row = (PopulationDataRow) totalRow;
        row.setTotal(total);
        row.setAffected(affected);
        row.setDisplaced(displaced);
    }
}
