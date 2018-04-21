package com.rjdeleon.mvp_app.Models.GeneralInformation;

import java.util.List;

public class CasualtiesData {
    private List<CasualtiesDataRow> casualtiesDataRows;

    public CasualtiesData(List<CasualtiesDataRow> casualtiesDataRows) {
        this.casualtiesDataRows = casualtiesDataRows;
    }

    public List<CasualtiesDataRow> getCasualtiesDataRows() {
        return casualtiesDataRows;
    }
}
