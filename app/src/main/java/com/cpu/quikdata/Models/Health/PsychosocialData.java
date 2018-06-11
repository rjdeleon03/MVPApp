package com.cpu.quikdata.Models.Health;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Generics.NormalizableData;
import com.cpu.quikdata.Utils.GenericEnumUtils;

import java.util.ArrayList;
import java.util.List;

public class PsychosocialData implements NormalizableData {

    private List<PsychosocialDataRow> psychosocialDataRows;

    public PsychosocialData(List<PsychosocialDataRow> psychosocialDataRows) {
        this.psychosocialDataRows = psychosocialDataRows;
    }

    public PsychosocialData() {
        this(new ArrayList<PsychosocialDataRow>());
    }

    public List<PsychosocialDataRow> getPsychosocialDataRows() {
        return psychosocialDataRows;
    }

    public void setPsychosocialDataRows(List<PsychosocialDataRow> psychosocialDataRows) {
        this.psychosocialDataRows = psychosocialDataRows;
    }

    @Override
    public void normalize() {
        GenericEnumUtils.normalizeGenericEnumData(
                GenericEnumDataRow.AgeGroup.class,
                this.getClass(),
                (List<GenericEnumDataRow>)(Object) psychosocialDataRows);
    }
}
