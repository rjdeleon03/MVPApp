package com.rjdeleon.mvp_app.Models.GeneralInformation;

import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;

import java.util.ArrayList;
import java.util.List;

public class PopulationData {
    public enum AgeGroup {
        AGE_0_5,
        AGE_6_9,
        AGE_10_12,
        AGE_13_17,
        AGE_18_59,
        AGE_60_PLUS,
        ALL;

        @Override
        public String toString() {
            String str = "Ages ";
            switch(this) {
                case AGE_0_5:
                    return str + "0-5";
                case AGE_6_9:
                    return str + "6-9";
                case AGE_10_12:
                    return str + "10-12";
                case AGE_13_17:
                    return str + "13-17";
                case AGE_18_59:
                    return str + "18-59";
                case AGE_60_PLUS:
                    return str + "60+";
            }
            return null;
        }
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
