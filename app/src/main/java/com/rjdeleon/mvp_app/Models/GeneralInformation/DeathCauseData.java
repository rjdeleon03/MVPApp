package com.rjdeleon.mvp_app.Models.GeneralInformation;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Generics.NormalizableData;
import com.rjdeleon.mvp_app.Utils.GenericEnumUtils;

import java.util.ArrayList;
import java.util.List;

public class DeathCauseData implements NormalizableData {
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

    public void setDeathCauseDataRows(List<DeathCauseDataRow> deathCauseDataRows) {
        this.deathCauseDataRows = deathCauseDataRows;
    }

    @Override
    public void normalize() {
        GenericEnumUtils.normalizeGenericEnumData(
                GenericEnumDataRow.AgeGroup.class,
                this.getClass(),
                (List<GenericEnumDataRow>)(Object) deathCauseDataRows,
                false);
    }
}
