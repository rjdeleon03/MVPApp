package com.cpu.quikdata.Models.Livelihoods;

import java.util.ArrayList;
import java.util.List;

public class LivelihoodsDamageData {

    private List<LivelihoodsDamageDataRow> livelihoodsDamageDataRows;

    public LivelihoodsDamageData(List<LivelihoodsDamageDataRow> livelihoodsDamageDataRows) {
        this.livelihoodsDamageDataRows = livelihoodsDamageDataRows;
    }

    public LivelihoodsDamageData() {
        this(new ArrayList<LivelihoodsDamageDataRow>());
    }

    public List<LivelihoodsDamageDataRow> getLivelihoodsDamageDataRows() {
        return livelihoodsDamageDataRows;
    }

    public void setLivelihoodsDamageDataRows(List<LivelihoodsDamageDataRow> livelihoodsDamageDataRows) {
        this.livelihoodsDamageDataRows = livelihoodsDamageDataRows;
    }
}
