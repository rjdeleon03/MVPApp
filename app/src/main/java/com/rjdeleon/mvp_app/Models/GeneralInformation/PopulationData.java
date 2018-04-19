package com.rjdeleon.mvp_app.Models.GeneralInformation;

import java.util.List;

public class PopulationData {
    public enum AgeGroup {
        AGE_0_5,
        AGE_6_9,
        AGE_10_12,
        AGE_13_17,
        AGE_18_59,
        AGE_60_PLUS
    };

    private List<PopulationDataRow> populationDataRows;

    public PopulationData(List<PopulationDataRow> populationDataRows) {
        this.populationDataRows = populationDataRows;
    }

    public List<PopulationDataRow> getPopulationDataRows() {
        return populationDataRows;
    }
}
