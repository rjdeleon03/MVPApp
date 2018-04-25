package com.rjdeleon.mvp_app.Models.GeneralInformation;

import com.rjdeleon.mvp_app.Models.GenderTuple;

import java.util.List;

public class PopulationData {
    public enum AgeGroup {
        AGE_0_5,
        AGE_6_9,
        AGE_10_12,
        AGE_13_17,
        AGE_18_59,
        AGE_60_PLUS,
        ALL
    };

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

        this.populationDataRows.add(new PopulationDataRow(AgeGroup.ALL, total, affected, displaced));
    }

    public List<PopulationDataRow> getPopulationDataRows() {
        return populationDataRows;
    }
}
