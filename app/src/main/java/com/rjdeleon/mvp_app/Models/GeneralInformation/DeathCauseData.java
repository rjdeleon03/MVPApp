package com.rjdeleon.mvp_app.Models.GeneralInformation;

import java.util.ArrayList;
import java.util.List;

public class DeathCauseData {
    private List<DeathCauseDataRow> deathCauseDataRows;

    public DeathCauseData(List<DeathCauseDataRow> deathCauseDataRows) {
        this.deathCauseDataRows = deathCauseDataRows;
    }

    public DeathCauseData() {
        this.deathCauseDataRows = new ArrayList<>();
    }

    public List<DeathCauseDataRow> getDeathCauseDataRows() {
        return deathCauseDataRows;
    }
}
