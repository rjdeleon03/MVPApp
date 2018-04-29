package com.rjdeleon.mvp_app.Models.GeneralInformation;

import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;

import java.util.List;

public class CasualtiesData {
    private List<CasualtiesDataRow> casualtiesDataRows;

    public CasualtiesData(List<CasualtiesDataRow> casualtiesDataRows) {
        this.casualtiesDataRows = casualtiesDataRows;

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
        this.casualtiesDataRows.add(new CasualtiesDataRow(PopulationData.AgeGroup.ALL, dead, missing, injured));
    }

    public List<CasualtiesDataRow> getCasualtiesDataRows() {
        return casualtiesDataRows;
    }
}
