package com.rjdeleon.mvp_app.Models.GeneralInformation;

import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;

import java.util.ArrayList;
import java.util.List;

public class PopulationData {

    private List<PopulationDataRow> populationDataRows;

    public PopulationData(List<PopulationDataRow> populationDataRows) {
        this.populationDataRows = populationDataRows;

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

        this.populationDataRows.add(new PopulationDataRow(AgeGroupDataRow.AgeGroup.ALL, total, affected, displaced));
    }

    public PopulationData() {
        this.populationDataRows = new ArrayList<>();
    }

    public List<PopulationDataRow> getPopulationDataRows() {
        return populationDataRows;
    }

    public void setPopulationDataRows(List<PopulationDataRow> populationDataRows) {
        this.populationDataRows = populationDataRows;
    }
}
