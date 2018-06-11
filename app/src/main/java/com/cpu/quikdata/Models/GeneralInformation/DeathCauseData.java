package com.cpu.quikdata.Models.GeneralInformation;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Generics.NormalizableData;
import com.cpu.quikdata.Utils.GenericEnumUtils;

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
                (List<GenericEnumDataRow>)(Object) deathCauseDataRows);
    }
}
